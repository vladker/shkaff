package org.opencv.video;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DISOpticalFlow extends DenseOpticalFlow {
    public static final int PRESET_FAST = 1;
    public static final int PRESET_MEDIUM = 2;
    public static final int PRESET_ULTRAFAST = 0;

    public DISOpticalFlow(long j6) {
        super(j6);
    }

    public static DISOpticalFlow __fromPtr__(long j6) {
        return new DISOpticalFlow(j6);
    }

    public static DISOpticalFlow create(int i5) {
        return __fromPtr__(create_0(i5));
    }

    private static native long create_0(int i5);

    private static native long create_1();

    private static native void delete(long j6);

    private static native int getFinestScale_0(long j6);

    private static native int getGradientDescentIterations_0(long j6);

    private static native int getPatchSize_0(long j6);

    private static native int getPatchStride_0(long j6);

    private static native boolean getUseMeanNormalization_0(long j6);

    private static native boolean getUseSpatialPropagation_0(long j6);

    private static native float getVariationalRefinementAlpha_0(long j6);

    private static native float getVariationalRefinementDelta_0(long j6);

    private static native float getVariationalRefinementGamma_0(long j6);

    private static native int getVariationalRefinementIterations_0(long j6);

    private static native void setFinestScale_0(long j6, int i5);

    private static native void setGradientDescentIterations_0(long j6, int i5);

    private static native void setPatchSize_0(long j6, int i5);

    private static native void setPatchStride_0(long j6, int i5);

    private static native void setUseMeanNormalization_0(long j6, boolean z6);

    private static native void setUseSpatialPropagation_0(long j6, boolean z6);

    private static native void setVariationalRefinementAlpha_0(long j6, float f6);

    private static native void setVariationalRefinementDelta_0(long j6, float f6);

    private static native void setVariationalRefinementGamma_0(long j6, float f6);

    private static native void setVariationalRefinementIterations_0(long j6, int i5);

    @Override // org.opencv.video.DenseOpticalFlow, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getFinestScale() {
        return getFinestScale_0(this.nativeObj);
    }

    public int getGradientDescentIterations() {
        return getGradientDescentIterations_0(this.nativeObj);
    }

    public int getPatchSize() {
        return getPatchSize_0(this.nativeObj);
    }

    public int getPatchStride() {
        return getPatchStride_0(this.nativeObj);
    }

    public boolean getUseMeanNormalization() {
        return getUseMeanNormalization_0(this.nativeObj);
    }

    public boolean getUseSpatialPropagation() {
        return getUseSpatialPropagation_0(this.nativeObj);
    }

    public float getVariationalRefinementAlpha() {
        return getVariationalRefinementAlpha_0(this.nativeObj);
    }

    public float getVariationalRefinementDelta() {
        return getVariationalRefinementDelta_0(this.nativeObj);
    }

    public float getVariationalRefinementGamma() {
        return getVariationalRefinementGamma_0(this.nativeObj);
    }

    public int getVariationalRefinementIterations() {
        return getVariationalRefinementIterations_0(this.nativeObj);
    }

    public void setFinestScale(int i5) {
        setFinestScale_0(this.nativeObj, i5);
    }

    public void setGradientDescentIterations(int i5) {
        setGradientDescentIterations_0(this.nativeObj, i5);
    }

    public void setPatchSize(int i5) {
        setPatchSize_0(this.nativeObj, i5);
    }

    public void setPatchStride(int i5) {
        setPatchStride_0(this.nativeObj, i5);
    }

    public void setUseMeanNormalization(boolean z6) {
        setUseMeanNormalization_0(this.nativeObj, z6);
    }

    public void setUseSpatialPropagation(boolean z6) {
        setUseSpatialPropagation_0(this.nativeObj, z6);
    }

    public void setVariationalRefinementAlpha(float f6) {
        setVariationalRefinementAlpha_0(this.nativeObj, f6);
    }

    public void setVariationalRefinementDelta(float f6) {
        setVariationalRefinementDelta_0(this.nativeObj, f6);
    }

    public void setVariationalRefinementGamma(float f6) {
        setVariationalRefinementGamma_0(this.nativeObj, f6);
    }

    public void setVariationalRefinementIterations(int i5) {
        setVariationalRefinementIterations_0(this.nativeObj, i5);
    }

    public static DISOpticalFlow create() {
        return __fromPtr__(create_1());
    }
}
