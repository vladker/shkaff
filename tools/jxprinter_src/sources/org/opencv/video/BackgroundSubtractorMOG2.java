package org.opencv.video;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BackgroundSubtractorMOG2 extends BackgroundSubtractor {
    public BackgroundSubtractorMOG2(long j6) {
        super(j6);
    }

    public static BackgroundSubtractorMOG2 __fromPtr__(long j6) {
        return new BackgroundSubtractorMOG2(j6);
    }

    private static native void apply_0(long j6, long j7, long j8, double d);

    private static native void apply_1(long j6, long j7, long j8);

    private static native void delete(long j6);

    private static native double getBackgroundRatio_0(long j6);

    private static native double getComplexityReductionThreshold_0(long j6);

    private static native boolean getDetectShadows_0(long j6);

    private static native int getHistory_0(long j6);

    private static native int getNMixtures_0(long j6);

    private static native double getShadowThreshold_0(long j6);

    private static native int getShadowValue_0(long j6);

    private static native double getVarInit_0(long j6);

    private static native double getVarMax_0(long j6);

    private static native double getVarMin_0(long j6);

    private static native double getVarThresholdGen_0(long j6);

    private static native double getVarThreshold_0(long j6);

    private static native void setBackgroundRatio_0(long j6, double d);

    private static native void setComplexityReductionThreshold_0(long j6, double d);

    private static native void setDetectShadows_0(long j6, boolean z6);

    private static native void setHistory_0(long j6, int i5);

    private static native void setNMixtures_0(long j6, int i5);

    private static native void setShadowThreshold_0(long j6, double d);

    private static native void setShadowValue_0(long j6, int i5);

    private static native void setVarInit_0(long j6, double d);

    private static native void setVarMax_0(long j6, double d);

    private static native void setVarMin_0(long j6, double d);

    private static native void setVarThresholdGen_0(long j6, double d);

    private static native void setVarThreshold_0(long j6, double d);

    @Override // org.opencv.video.BackgroundSubtractor
    public void apply(Mat mat, Mat mat2, double d) {
        apply_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, d);
    }

    @Override // org.opencv.video.BackgroundSubtractor, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public double getBackgroundRatio() {
        return getBackgroundRatio_0(this.nativeObj);
    }

    public double getComplexityReductionThreshold() {
        return getComplexityReductionThreshold_0(this.nativeObj);
    }

    public boolean getDetectShadows() {
        return getDetectShadows_0(this.nativeObj);
    }

    public int getHistory() {
        return getHistory_0(this.nativeObj);
    }

    public int getNMixtures() {
        return getNMixtures_0(this.nativeObj);
    }

    public double getShadowThreshold() {
        return getShadowThreshold_0(this.nativeObj);
    }

    public int getShadowValue() {
        return getShadowValue_0(this.nativeObj);
    }

    public double getVarInit() {
        return getVarInit_0(this.nativeObj);
    }

    public double getVarMax() {
        return getVarMax_0(this.nativeObj);
    }

    public double getVarMin() {
        return getVarMin_0(this.nativeObj);
    }

    public double getVarThreshold() {
        return getVarThreshold_0(this.nativeObj);
    }

    public double getVarThresholdGen() {
        return getVarThresholdGen_0(this.nativeObj);
    }

    public void setBackgroundRatio(double d) {
        setBackgroundRatio_0(this.nativeObj, d);
    }

    public void setComplexityReductionThreshold(double d) {
        setComplexityReductionThreshold_0(this.nativeObj, d);
    }

    public void setDetectShadows(boolean z6) {
        setDetectShadows_0(this.nativeObj, z6);
    }

    public void setHistory(int i5) {
        setHistory_0(this.nativeObj, i5);
    }

    public void setNMixtures(int i5) {
        setNMixtures_0(this.nativeObj, i5);
    }

    public void setShadowThreshold(double d) {
        setShadowThreshold_0(this.nativeObj, d);
    }

    public void setShadowValue(int i5) {
        setShadowValue_0(this.nativeObj, i5);
    }

    public void setVarInit(double d) {
        setVarInit_0(this.nativeObj, d);
    }

    public void setVarMax(double d) {
        setVarMax_0(this.nativeObj, d);
    }

    public void setVarMin(double d) {
        setVarMin_0(this.nativeObj, d);
    }

    public void setVarThreshold(double d) {
        setVarThreshold_0(this.nativeObj, d);
    }

    public void setVarThresholdGen(double d) {
        setVarThresholdGen_0(this.nativeObj, d);
    }

    @Override // org.opencv.video.BackgroundSubtractor
    public void apply(Mat mat, Mat mat2) {
        apply_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
