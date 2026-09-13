package org.opencv.video;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FarnebackOpticalFlow extends DenseOpticalFlow {
    public FarnebackOpticalFlow(long j6) {
        super(j6);
    }

    public static FarnebackOpticalFlow __fromPtr__(long j6) {
        return new FarnebackOpticalFlow(j6);
    }

    public static FarnebackOpticalFlow create(int i5, double d, boolean z6, int i6, int i7, int i8, double d6, int i9) {
        return __fromPtr__(create_0(i5, d, z6, i6, i7, i8, d6, i9));
    }

    private static native long create_0(int i5, double d, boolean z6, int i6, int i7, int i8, double d6, int i9);

    private static native long create_1(int i5, double d, boolean z6, int i6, int i7, int i8, double d6);

    private static native long create_2(int i5, double d, boolean z6, int i6, int i7, int i8);

    private static native long create_3(int i5, double d, boolean z6, int i6, int i7);

    private static native long create_4(int i5, double d, boolean z6, int i6);

    private static native long create_5(int i5, double d, boolean z6);

    private static native long create_6(int i5, double d);

    private static native long create_7(int i5);

    private static native long create_8();

    private static native void delete(long j6);

    private static native boolean getFastPyramids_0(long j6);

    private static native int getFlags_0(long j6);

    private static native int getNumIters_0(long j6);

    private static native int getNumLevels_0(long j6);

    private static native int getPolyN_0(long j6);

    private static native double getPolySigma_0(long j6);

    private static native double getPyrScale_0(long j6);

    private static native int getWinSize_0(long j6);

    private static native void setFastPyramids_0(long j6, boolean z6);

    private static native void setFlags_0(long j6, int i5);

    private static native void setNumIters_0(long j6, int i5);

    private static native void setNumLevels_0(long j6, int i5);

    private static native void setPolyN_0(long j6, int i5);

    private static native void setPolySigma_0(long j6, double d);

    private static native void setPyrScale_0(long j6, double d);

    private static native void setWinSize_0(long j6, int i5);

    @Override // org.opencv.video.DenseOpticalFlow, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public boolean getFastPyramids() {
        return getFastPyramids_0(this.nativeObj);
    }

    public int getFlags() {
        return getFlags_0(this.nativeObj);
    }

    public int getNumIters() {
        return getNumIters_0(this.nativeObj);
    }

    public int getNumLevels() {
        return getNumLevels_0(this.nativeObj);
    }

    public int getPolyN() {
        return getPolyN_0(this.nativeObj);
    }

    public double getPolySigma() {
        return getPolySigma_0(this.nativeObj);
    }

    public double getPyrScale() {
        return getPyrScale_0(this.nativeObj);
    }

    public int getWinSize() {
        return getWinSize_0(this.nativeObj);
    }

    public void setFastPyramids(boolean z6) {
        setFastPyramids_0(this.nativeObj, z6);
    }

    public void setFlags(int i5) {
        setFlags_0(this.nativeObj, i5);
    }

    public void setNumIters(int i5) {
        setNumIters_0(this.nativeObj, i5);
    }

    public void setNumLevels(int i5) {
        setNumLevels_0(this.nativeObj, i5);
    }

    public void setPolyN(int i5) {
        setPolyN_0(this.nativeObj, i5);
    }

    public void setPolySigma(double d) {
        setPolySigma_0(this.nativeObj, d);
    }

    public void setPyrScale(double d) {
        setPyrScale_0(this.nativeObj, d);
    }

    public void setWinSize(int i5) {
        setWinSize_0(this.nativeObj, i5);
    }

    public static FarnebackOpticalFlow create(int i5, double d, boolean z6, int i6, int i7, int i8, double d6) {
        return __fromPtr__(create_1(i5, d, z6, i6, i7, i8, d6));
    }

    public static FarnebackOpticalFlow create(int i5, double d, boolean z6, int i6, int i7, int i8) {
        return __fromPtr__(create_2(i5, d, z6, i6, i7, i8));
    }

    public static FarnebackOpticalFlow create(int i5, double d, boolean z6, int i6, int i7) {
        return __fromPtr__(create_3(i5, d, z6, i6, i7));
    }

    public static FarnebackOpticalFlow create(int i5, double d, boolean z6, int i6) {
        return __fromPtr__(create_4(i5, d, z6, i6));
    }

    public static FarnebackOpticalFlow create(int i5, double d, boolean z6) {
        return __fromPtr__(create_5(i5, d, z6));
    }

    public static FarnebackOpticalFlow create(int i5, double d) {
        return __fromPtr__(create_6(i5, d));
    }

    public static FarnebackOpticalFlow create(int i5) {
        return __fromPtr__(create_7(i5));
    }

    public static FarnebackOpticalFlow create() {
        return __fromPtr__(create_8());
    }
}
