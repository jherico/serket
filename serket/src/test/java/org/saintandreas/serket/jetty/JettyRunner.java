package org.saintandreas.serket.jetty;

import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

public class JettyRunner {
    static private ResourceBundle resources = ResourceBundle.getBundle("JettyRunner");
    static private ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
//      org.eclipse.jetty.util.log.Log.getLog().setDebugEnabled(true);
        Server server = new Server(5001);
        server.setHandler(new WebAppContext("src/main/webapp", "/"));
        server.start();
        
//        UPNPHelper.start(executor);

        final Display display = new Display();
        final Shell shell = openShell(display);
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        executor.shutdownNow();
        display.dispose();
        server.stop();
        server.join();
    }

    private static Shell openShell(Display display) {
        final Shell shell = new Shell(display);
        shell.setVisible(false);
//        shell.setText(resources.getString("Window_title"));
//        shell.setSize(500, 300);
//        shell.open();
        final ToolTip tip = new ToolTip(shell, SWT.BALLOON | SWT.ICON_INFORMATION);
        tip.setMessage("Balloon Message Goes Here!");
        Image image = new Image(display, JettyRunner.class.getResourceAsStream("/images/Play1Hot_256.png"));
        Tray tray = display.getSystemTray();
        if (tray != null) {
            TrayItem item = new TrayItem(tray, SWT.NONE);
            final Menu menu = new Menu(shell, SWT.POP_UP);
            item.setImage(image);
            item.setToolTip(tip); 
            item.addListener (SWT.MenuDetect, new Listener () {
                public void handleEvent (Event event) {
                    menu.setVisible (true);
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
}
