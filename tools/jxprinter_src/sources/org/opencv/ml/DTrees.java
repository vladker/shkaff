package org.opencv.ml;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DTrees extends StatModel {
    public static final int PREDICT_AUTO = 0;
    public static final int PREDICT_MASK = 768;
    public static final int PREDICT_MAX_VOTE = 512;
    public static final int PREDICT_SUM = 256;

    public DTrees(long j6) {
        super(j6);
    }

    public static DTrees __fromPtr__(long j6) {
        return new DTrees(j6);
    }

    public static DTrees create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    private static native int getCVFolds_0(long j6);

    private static native int getMaxCategories_0(long j6);

    private static native int getMaxDepth_0(long j6);

    private static native int getMinSampleCount_0(long j6);

    private static native long getPriors_0(long j6);

    private static native float getRegressionAccuracy_0(long j6);

    private static native boolean getTruncatePrunedTree_0(long j6);

    private static native boolean getUse1SERule_0(long j6);

    private static native boolean getUseSurrogates_0(long j6);

    public static DTrees load(String str, String str2) {
        return __fromPtr__(load_0(str, str2));
    }

    private static native long load_0(String str, String str2);

    private static native long load_1(String str);

    private static native void setCVFolds_0(long j6, int i5);

    private static native void setMaxCategories_0(long j6, int i5);

    private static native void setMaxDepth_0(long j6, int i5);

    private static native void setMinSampleCount_0(long j6, int i5);

    private static native void setPriors_0(long j6, long j7);

    private static native void setRegressionAccuracy_0(long j6, float f6);

    private static native void setTruncatePrunedTree_0(long j6, boolean z6);

    private static native void setUse1SERule_0(long j6, boolean z6);

    private static native void setUseSurrogates_0(long j6, boolean z6);

    @Override // org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getCVFolds() {
        return getCVFolds_0(this.nativeObj);
    }

    public int getMaxCategories() {
        return getMaxCategories_0(this.nativeObj);
    }

    public int getMaxDepth() {
        return getMaxDepth_0(this.nativeObj);
    }

    public int getMinSampleCount() {
        return getMinSampleCount_0(this.nativeObj);
    }

    public Mat getPriors() {
        return new Mat(getPriors_0(this.nativeObj));
    }

    public float getRegressionAccuracy() {
        return getRegressionAccuracy_0(this.nativeObj);
    }

    public boolean getTruncatePrunedTree() {
        return getTruncatePrunedTree_0(this.nativeObj);
    }

    public boolean getUse1SERule() {
        return getUse1SERule_0(this.nativeObj);
    }

    public boolean getUseSurrogates() {
        return getUseSurrogates_0(this.nativeObj);
    }

    public void setCVFolds(int i5) {
        setCVFolds_0(this.nativeObj, i5);
    }

    public void setMaxCategories(int i5) {
        setMaxCategories_0(this.nativeObj, i5);
    }

    public void setMaxDepth(int i5) {
        setMaxDepth_0(this.nativeObj, i5);
    }

    public void setMinSampleCount(int i5) {
        setMinSampleCount_0(this.nativeObj, i5);
    }

    public void setPriors(Mat mat) {
        setPriors_0(this.nativeObj, mat.nativeObj);
    }

    public void setRegressionAccuracy(float f6) {
        setRegressionAccuracy_0(this.nativeObj, f6);
    }

    public void setTruncatePrunedTree(boolean z6) {
        setTruncatePrunedTree_0(this.nativeObj, z6);
    }

    public void setUse1SERule(boolean z6) {
        setUse1SERule_0(this.nativeObj, z6);
    }

    public void setUseSurrogates(boolean z6) {
        setUseSurrogates_0(this.nativeObj, z6);
    }

    public static DTrees load(String str) {
        return __fromPtr__(load_1(str));
    }
}
