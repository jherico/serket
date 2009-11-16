/*
 * Copyright (C) 2009 Bradley Austin Davis.
 * 
 * This file is part of serket.
 * 
 * serket is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * serket is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * serket. If not, see <http://www.gnu.org/licenses/>.
*/
package org.saintandreas.serket.jetty;

import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
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
    static private ResourceBundle resources = null; //ResourceBundle.getBundle("JettyRunner");
    static private ExecutorService executor = Executors.newCachedThreadPool();

    
    public static void runJetty() throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context0 = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context0.setContextPath("/scpd");
        context0.setBaseResource(Resource.newClassPathResource("/scpd/"));
        context0.addServlet(new ServletHolder(new DefaultServlet()),"/*");
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { context0 });
        server.setHandler(contexts);
        server.start();
        server.join();
    }

    public static void main(String[] args) throws Exception {
        runJetty();
//        Server server = new Server();
//        XmlConfiguration configuration = new XmlConfiguration(new JettyRunner.class.getResourceAsStream("/testJetty.xml"));
//        configuration.configure(server);
//        server.start();
//
//        XmlConfiguration configuration = new XmlConfiguration(new File("myJetty.xml").toURL()); 
//
//        configuration.configure(server);
//        server.start();
//        
////      org.eclipse.jetty.util.log.Log.getLog().setDebugEnabled(true);
//        Server server = new Server(5001);
//        server.setHandler(new WebAppContext("src/main/webapp", "/"));
//        server.start();
//        
////        UPNPHelper.start(executor);
//
//        final Display display = new Display();
//        final Shell shell = openShell(display);
//        while (!shell.isDisposed()) {
//            if (!display.readAndDispatch()) {
//                display.sleep();
//            }
//        }
//
//        executor.shutdownNow();
//        display.dispose();
//        server.stop();
//        server.join();
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



