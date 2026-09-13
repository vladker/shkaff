package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SIFT extends Feature2D {
    public SIFT(long j6) {
        super(j6);
    }

    public static SIFT __fromPtr__(long j6) {
        return new SIFT(j6);
    }

    public static SIFT create(int i5, int i6, double d, double d6, double d7, boolean z6) {
        return __fromPtr__(create_0(i5, i6, d, d6, d7, z6));
    }

    private static native long create_0(int i5, int i6, double d, double d6, double d7, boolean z6);

    private static native long create_1(int i5, int i6, double d, double d6, double d7);

    private static native long create_2(int i5, int i6, double d, double d6);

    private static native long create_3(int i5, int i6, double d);

    private static native long create_4(int i5, int i6);

    private static native long create_5(int i5);

    private static native long create_6();

    private static native long create_7(int i5, int i6, double d, double d6, double d7, int i7, boolean z6);

    private static native long create_8(int i5, int i6, double d, double d6, double d7, int i7);

    private static native void delete(long j6);

    private static native double getContrastThreshold_0(long j6);

    private static native String getDefaultName_0(long j6);

    private static native double getEdgeThreshold_0(long j6);

    private static native int getNFeatures_0(long j6);

    private static native int getNOctaveLayers_0(long j6);

    private static native double getSigma_0(long j6);

    private static native void setContrastThreshold_0(long j6, double d);

    private static native void setEdgeThreshold_0(long j6, double d);

    private static native void setNFeatures_0(long j6, int i5);

    private static native void setNOctaveLayers_0(long j6, int i5);

    private static native void setSigma_0(long j6, double d);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public double getContrastThreshold() {
        return getContrastThreshold_0(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public double getEdgeThreshold() {
        return getEdgeThreshold_0(this.nativeObj);
    }

    public int getNFeatures() {
        return getNFeatures_0(this.nativeObj);
    }

    public int getNOctaveLayers() {
        return getNOctaveLayers_0(this.nativeObj);
    }

    public double getSigma() {
        return getSigma_0(this.nativeObj);
    }

    public void setContrastThreshold(double d) {
        setContrastThreshold_0(this.nativeObj, d);
    }

    public void setEdgeThreshold(double d) {
        setEdgeThreshold_0(this.nativeObj, d);
    }

    public void setNFeatures(int i5) {
        setNFeatures_0(this.nativeObj, i5);
    }

    public void setNOctaveLayers(int i5) {
        setNOctaveLayers_0(this.nativeObj, i5);
    }

    public void setSigma(double d) {
        setSigma_0(this.nativeObj, d);
    }

    public static SIFT create(int i5, int i6, double d, double d6, double d7) {
        return __fromPtr__(create_1(i5, i6, d, d6, d7));
    }

    public static SIFT create(int i5, int i6, double d, double d6) {
        return __fromPtr__(create_2(i5, i6, d, d6));
    }

    public static SIFT create(int i5, int i6, double d) {
        return __fromPtr__(create_3(i5, i6, d));
    }

    public static SIFT create(int i5, int i6) {
        return __fromPtr__(create_4(i5, i6));
    }

    public static SIFT create(int i5) {
        return __fromPtr__(create_5(i5));
    }

    public static SIFT create() {
        return __fromPtr__(create_6());
    }

    public static SIFT create(int i5, int i6, double d, double d6, double d7, int i7, boolean z6) {
        return __fromPtr__(create_7(i5, i6, d, d6, d7, i7, z6));
    }

    public static SIFT create(int i5, int i6, double d, double d6, double d7, int i7) {
        return __fromPtr__(create_8(i5, i6, d, d6, d7, i7));
    }
}
