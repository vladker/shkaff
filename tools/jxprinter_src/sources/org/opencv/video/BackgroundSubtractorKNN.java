package org.opencv.video;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BackgroundSubtractorKNN extends BackgroundSubtractor {
    public BackgroundSubtractorKNN(long j6) {
        super(j6);
    }

    public static BackgroundSubtractorKNN __fromPtr__(long j6) {
        return new BackgroundSubtractorKNN(j6);
    }

    private static native void delete(long j6);

    private static native boolean getDetectShadows_0(long j6);

    private static native double getDist2Threshold_0(long j6);

    private static native int getHistory_0(long j6);

    private static native int getNSamples_0(long j6);

    private static native double getShadowThreshold_0(long j6);

    private static native int getShadowValue_0(long j6);

    private static native int getkNNSamples_0(long j6);

    private static native void setDetectShadows_0(long j6, boolean z6);

    private static native void setDist2Threshold_0(long j6, double d);

    private static native void setHistory_0(long j6, int i5);

    private static native void setNSamples_0(long j6, int i5);

    private static native void setShadowThreshold_0(long j6, double d);

    private static native void setShadowValue_0(long j6, int i5);

    private static native void setkNNSamples_0(long j6, int i5);

    @Override // org.opencv.video.BackgroundSubtractor, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public boolean getDetectShadows() {
        return getDetectShadows_0(this.nativeObj);
    }

    public double getDist2Threshold() {
        return getDist2Threshold_0(this.nativeObj);
    }

    public int getHistory() {
        return getHistory_0(this.nativeObj);
    }

    public int getNSamples() {
        return getNSamples_0(this.nativeObj);
    }

    public double getShadowThreshold() {
        return getShadowThreshold_0(this.nativeObj);
    }

    public int getShadowValue() {
        return getShadowValue_0(this.nativeObj);
    }

    public int getkNNSamples() {
        return getkNNSamples_0(this.nativeObj);
    }

    public void setDetectShadows(boolean z6) {
        setDetectShadows_0(this.nativeObj, z6);
    }

    public void setDist2Threshold(double d) {
        setDist2Threshold_0(this.nativeObj, d);
    }

    public void setHistory(int i5) {
        setHistory_0(this.nativeObj, i5);
    }

    public void setNSamples(int i5) {
        setNSamples_0(this.nativeObj, i5);
    }

    public void setShadowThreshold(double d) {
        setShadowThreshold_0(this.nativeObj, d);
    }

    public void setShadowValue(int i5) {
        setShadowValue_0(this.nativeObj, i5);
    }

    public void setkNNSamples(int i5) {
        setkNNSamples_0(this.nativeObj, i5);
    }
}
