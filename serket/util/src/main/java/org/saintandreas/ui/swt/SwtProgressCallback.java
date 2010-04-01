package org.saintandreas.ui.swt;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.saintandreas.ui.ProgressCallback;

public class SwtProgressCallback implements ProgressCallback {
    private ProgressBar bar = null;
    private Label label = null;
    private int lastProgressValue = 0;

    public void setProgressPercent(float percent) {
        int newValue = (int) (percent * 100f);
        if (newValue != lastProgressValue) {
            lastProgressValue = newValue;
            if (bar != null) {
                bar.setSelection(lastProgressValue);
            }
        }
    }

    public void setStatusText(String text) {
        if (label != null) {
            label.setText(text);
        }
    }

    public void setBar(ProgressBar bar) {
        this.bar = bar;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public float getProgressPercent() {
        return (float)bar.getSelection() /(float)bar.getMaximum();
    }

    public void setProgressPercent(String text, float percent) {
        setStatusText(text);
        setProgressPercent(percent);
        
    }
}
