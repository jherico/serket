package org.saintandreas.serket.test;

import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.saintandreas.serket.reference.MediaServer;
import org.saintandreas.serket.reference.SerketContentDirectory;
import org.saintandreas.serket.reference.servlet.DescriptionServlet;
import org.saintandreas.serket.service.Service;
import org.saintandreas.serket.ssdp.Message;
import org.saintandreas.serket.ssdp.SSDP;
import org.saintandreas.serket.ssdp.SSDPServer;
import org.saintandreas.util.NetUtil;

public class IntegrationTest {
    private static final ResourceBundle resources = ResourceBundle.getBundle("serket");
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final String uuid;
    private final MediaServer mediaServer;
    private final Server jettyServer;
    private final SSDPServer ssdpServer;

    public IntegrationTest() {
        uuid = "uuid:" + UUID.randomUUID().toString();
        mediaServer = new MediaServer(uuid, "/ui");
        mediaServer.getServiceList().add(new SerketContentDirectory("service/cd/control", "service/cd/event"));
        jettyServer = new Server(8080);
        ssdpServer = new SSDPServer(uuid, executor);
        initJetty();
    }

    public void start() throws Exception {
        ssdpServer.listen();
        jettyServer.start();
        executor.submit(new Sender());
        SSDP.sendDiscover();
    }

    public void stop() throws Exception {
        jettyServer.stop();
        jettyServer.join();
        executor.shutdownNow();
    }

    public void initJetty() {
        List<Handler> handlerList = new ArrayList<Handler>();

        // the description handler
        {
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/description");
            context.addServlet(new ServletHolder(new DescriptionServlet(mediaServer)), "/*");
            handlerList.add(context);
        }

        // the service descriptor handler
        {
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/scpd");
            context.setBaseResource(Resource.newClassPathResource("/scpd/"));
            context.addServlet(new ServletHolder(new DefaultServlet()), "/*");
            handlerList.add(context);
        }

        // the service descriptor handler
        {
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            context.addServlet(new ServletHolder(new LoggingServlet()), "/*");
            handlerList.add(context);
        }

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(handlerList.toArray(new Handler[] {}));
        jettyServer.setHandler(contexts);
    }

    protected class Sender implements Runnable {
        @Override
        public void run() {
            try {
                MulticastSocket socket = new MulticastSocket();
                while (!executor.isShutdown()) {
                    try {
                        List<String> nts = new ArrayList<String>();
                        nts.add("upnp:rootdevice");
                        nts.add(mediaServer.getDeviceType());
                        for (Service s : mediaServer.getServiceList()) {
                            nts.add(s.getServiceType());
                        }
                        LogFactory.getLog(Sender.class).debug("Sending alive messages");
                        for (String s : nts) {
                            String message = Message.buildNotifyAliveMessage(s, uuid + "::" + s, "http://" + NetUtil.getInet4Address().getHostAddress() + ":8080/description/",
                                    60 * 60, "serketLib/0.1");
                            socket.send(SSDP.getPacket(message));
                        }
                        Thread.sleep(5000);
                    } catch (SocketTimeoutException e) {
                        continue;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private static Shell openShell(Display display) {
        final Shell shell = new Shell(display);
        shell.setVisible(false);
        // shell.setText(resources.getString("Window_title"));
        // shell.setSize(500, 300);
        // shell.open();
        final ToolTip tip = new ToolTip(shell, SWT.BALLOON | SWT.ICON_INFORMATION);
        tip.setMessage("Balloon Message Goes Here!");
        Image image = new Image(display, IntegrationTest.class.getResourceAsStream("/images/Play1Hot_256.png"));
        Tray tray = display.getSystemTray();
        if (tray != null) {
            TrayItem item = new TrayItem(tray, SWT.NONE);
            final Menu menu = new Menu(shell, SWT.POP_UP);
            item.setImage(image);
            item.setToolTip(tip);
            item.addListener(SWT.MenuDetect, new org.eclipse.swt.widgets.Listener() {
                public void handleEvent(Event event) {
                    menu.setVisible(true);
                }
            });

            {
                MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
                menuItem.setText(resources.getString("Config_menuitem"));
            }
            new MenuItem(menu, SWT.SEPARATOR);
            {
                MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
                menuItem.setText(resources.getString("Exit_menuitem"));
                menuItem.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent event) {
                        shell.close();
                    }
                });
            }
        }

        return shell;
    }

    public static void main(String[] args) throws Exception {
        IntegrationTest app = new IntegrationTest();
        app.start();

        Display display = new Display();
        Shell shell = openShell(display);
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();

        app.stop();
    }
}

// XmlConfiguration configuration = new XmlConfiguration(new
// File("myJetty.xml").toURL());
// configuration.configure(server);
// server.start();
