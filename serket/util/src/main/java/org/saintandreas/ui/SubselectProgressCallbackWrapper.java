package org.saintandreas.ui;


public class SubselectProgressCallbackWrapper implements ProgressCallback {
    private final ProgressCallback wrapped;
    float start;
    float length;

    public SubselectProgressCallbackWrapper(ProgressCallback wrapped, float start, float length) {
        this.start = start;
        this.length = length;
        this.wrapped = wrapped;
    }

    public SubselectProgressCallbackWrapper(ProgressCallback wrapped, float length) {
        start = wrapped.getProgressPercent();
        this.wrapped = wrapped;
    }

    public void setProgressPercent(float percent) {
        wrapped.setProgressPercent(start + (percent * length));
    }

    public void setStatusText(String text) {
        wrapped.setStatusText(text);
    }

    public float getProgressPercent() {
        return (wrapped.getProgressPercent() - start) / length;
    }

    public void setProgressPercent(String text, float percent) {
        setStatusText(text);
        setProgressPercent(percent);
        
    }

}
