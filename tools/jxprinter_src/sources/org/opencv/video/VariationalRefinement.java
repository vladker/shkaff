package org.opencv.video;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class VariationalRefinement extends DenseOpticalFlow {
    public VariationalRefinement(long j6) {
        super(j6);
    }

    public static VariationalRefinement __fromPtr__(long j6) {
        return new VariationalRefinement(j6);
    }

    private static native void calcUV_0(long j6, long j7, long j8, long j9, long j10);

    public static VariationalRefinement create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    private static native float getAlpha_0(long j6);

    private static native float getDelta_0(long j6);

    private static native int getFixedPointIterations_0(long j6);

    private static native float getGamma_0(long j6);

    private static native float getOmega_0(long j6);

    private static native int getSorIterations_0(long j6);

    private static native void setAlpha_0(long j6, float f6);

    private static native void setDelta_0(long j6, float f6);

    private static native void setFixedPointIterations_0(long j6, int i5);

    private static native void setGamma_0(long j6, float f6);

    private static native void setOmega_0(long j6, float f6);

    private static native void setSorIterations_0(long j6, int i5);

    public void calcUV(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        calcUV_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    @Override // org.opencv.video.DenseOpticalFlow, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getAlpha() {
        return getAlpha_0(this.nativeObj);
    }

    public float getDelta() {
        return getDelta_0(this.nativeObj);
    }

    public int getFixedPointIterations() {
        return getFixedPointIterations_0(this.nativeObj);
    }

    public float getGamma() {
        return getGamma_0(this.nativeObj);
    }

    public float getOmega() {
        return getOmega_0(this.nativeObj);
    }

    public int getSorIterations() {
        return getSorIterations_0(this.nativeObj);
    }

    public void setAlpha(float f6) {
        setAlpha_0(this.nativeObj, f6);
    }

    public void setDelta(float f6) {
        setDelta_0(this.nativeObj, f6);
    }

    public void setFixedPointIterations(int i5) {
        setFixedPointIterations_0(this.nativeObj, i5);
    }

    public void setGamma(float f6) {
        setGamma_0(this.nativeObj, f6);
    }

    public void setOmega(float f6) {
        setOmega_0(this.nativeObj, f6);
    }

    public void setSorIterations(int i5) {
        setSorIterations_0(this.nativeObj, i5);
    }
}
