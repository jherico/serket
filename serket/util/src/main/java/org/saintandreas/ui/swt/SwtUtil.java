package org.saintandreas.ui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class SwtUtil {
    public abstract static class SplashCallback extends SwtProgressCallback implements Runnable {
        protected Shell splash;
        public abstract void initApp();

        public void run() {
            initApp();
            splash.close();
        }
        public void setSplash(Shell splash) {
            this.splash = splash;
        }
    }

    public static void openSplash(Display display, String image, SplashCallback callback) {
        openSplash(display, new Image(display, SwtUtil.class.getResourceAsStream(image)), callback);
    }

    public static void openSplash(Display display, final Image image, SplashCallback callback) {
        final Shell splash = new Shell(SWT.ON_TOP);
        callback.setSplash(splash);
        FormLayout layout = new FormLayout();
        splash.setLayout(layout);

        final ProgressBar bar = new ProgressBar(splash, SWT.NONE);
        bar.setMaximum(100);
        {
            FormData progressData = new FormData();
            progressData.left = new FormAttachment(0, 5);
            progressData.right = new FormAttachment(100, -5);
            progressData.bottom = new FormAttachment(100, -5);
            bar.setLayoutData(progressData);
        }

        final Label status = new Label(splash, SWT.SHADOW_IN);
        {
            FormData data = new FormData ();
            data.left = new FormAttachment (0, 5);
            data.right = new FormAttachment (100, -5);
            data.bottom = new FormAttachment (bar, -5, SWT.DEFAULT);
            status.setLayoutData(data);
            status.setText("init");
        }
        
        Label label = new Label(splash, SWT.NONE);
        label.setImage(image);
        {
            FormData data = new FormData();
            data = new FormData ();
            data.left = new FormAttachment (0, 0);
            data.right = new FormAttachment (100, 0);
            data.bottom = new FormAttachment (status, -5, SWT.DEFAULT);
            label.setLayoutData(data);
        }
        splash.pack();
        Rectangle splashRect = splash.getBounds();
        Rectangle displayRect = display.getBounds();
        int x = (displayRect.width - splashRect.width) / 2;
        int y = (displayRect.height - splashRect.height) / 2;
        splash.setLocation(x, y);
        splash.open();
        callback.setBar(bar);
        callback.setLabel(status);
        display.asyncExec(callback);
    }

}
