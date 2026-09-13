package org.opencv.calib3d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StereoSGBM extends StereoMatcher {
    public static final int MODE_HH = 1;
    public static final int MODE_HH4 = 3;
    public static final int MODE_SGBM = 0;
    public static final int MODE_SGBM_3WAY = 2;

    public StereoSGBM(long j6) {
        super(j6);
    }

    public static StereoSGBM __fromPtr__(long j6) {
        return new StereoSGBM(j6);
    }

    public static StereoSGBM create(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        return __fromPtr__(create_0(i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15));
    }

    private static native long create_0(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15);

    private static native long create_1(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14);

    private static native long create_10(int i5);

    private static native long create_11();

    private static native long create_2(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13);

    private static native long create_3(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    private static native long create_4(int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    private static native long create_5(int i5, int i6, int i7, int i8, int i9, int i10);

    private static native long create_6(int i5, int i6, int i7, int i8, int i9);

    private static native long create_7(int i5, int i6, int i7, int i8);

    private static native long create_8(int i5, int i6, int i7);

    private static native long create_9(int i5, int i6);

    private static native void delete(long j6);

    private static native int getMode_0(long j6);

    private static native int getP1_0(long j6);

    private static native int getP2_0(long j6);

    private static native int getPreFilterCap_0(long j6);

    private static native int getUniquenessRatio_0(long j6);

    private static native void setMode_0(long j6, int i5);

    private static native void setP1_0(long j6, int i5);

    private static native void setP2_0(long j6, int i5);

    private static native void setPreFilterCap_0(long j6, int i5);

    private static native void setUniquenessRatio_0(long j6, int i5);

    @Override // org.opencv.calib3d.StereoMatcher, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getMode() {
        return getMode_0(this.nativeObj);
    }

    public int getP1() {
        return getP1_0(this.nativeObj);
    }

    public int getP2() {
        return getP2_0(this.nativeObj);
    }

    public int getPreFilterCap() {
        return getPreFilterCap_0(this.nativeObj);
    }

    public int getUniquenessRatio() {
        return getUniquenessRatio_0(this.nativeObj);
    }

    public void setMode(int i5) {
        setMode_0(this.nativeObj, i5);
    }

    public void setP1(int i5) {
        setP1_0(this.nativeObj, i5);
    }

    public void setP2(int i5) {
        setP2_0(this.nativeObj, i5);
    }

    public void setPreFilterCap(int i5) {
        setPreFilterCap_0(this.nativeObj, i5);
    }

    public void setUniquenessRatio(int i5) {
        setUniquenessRatio_0(this.nativeObj, i5);
    }

    public static StereoSGBM create(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        return __fromPtr__(create_1(i5, i6, i7, i8, i9, i10, i11, i12, i13, i14));
    }

    public static StereoSGBM create(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        return __fromPtr__(create_2(i5, i6, i7, i8, i9, i10, i11, i12, i13));
    }

    public static StereoSGBM create(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        return __fromPtr__(create_3(i5, i6, i7, i8, i9, i10, i11, i12));
    }

    public static StereoSGBM create(int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        return __fromPtr__(create_4(i5, i6, i7, i8, i9, i10, i11));
    }

    public static StereoSGBM create(int i5, int i6, int i7, int i8, int i9, int i10) {
        return __fromPtr__(create_5(i5, i6, i7, i8, i9, i10));
    }

    public static StereoSGBM create(int i5, int i6, int i7, int i8, int i9) {
        return __fromPtr__(create_6(i5, i6, i7, i8, i9));
    }

    public static StereoSGBM create(int i5, int i6, int i7, int i8) {
        return __fromPtr__(create_7(i5, i6, i7, i8));
    }

    public static StereoSGBM create(int i5, int i6, int i7) {
        return __fromPtr__(create_8(i5, i6, i7));
    }

    public static StereoSGBM create(int i5, int i6) {
        return __fromPtr__(create_9(i5, i6));
    }

    public static StereoSGBM create(int i5) {
        return __fromPtr__(create_10(i5));
    }

    public static StereoSGBM create() {
        return __fromPtr__(create_11());
    }
}
