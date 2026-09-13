package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class KAZE extends Feature2D {
    public static final int DIFF_CHARBONNIER = 3;
    public static final int DIFF_PM_G1 = 0;
    public static final int DIFF_PM_G2 = 1;
    public static final int DIFF_WEICKERT = 2;

    public KAZE(long j6) {
        super(j6);
    }

    public static KAZE __fromPtr__(long j6) {
        return new KAZE(j6);
    }

    public static KAZE create(boolean z6, boolean z7, float f6, int i5, int i6, int i7) {
        return __fromPtr__(create_0(z6, z7, f6, i5, i6, i7));
    }

    private static native long create_0(boolean z6, boolean z7, float f6, int i5, int i6, int i7);

    private static native long create_1(boolean z6, boolean z7, float f6, int i5, int i6);

    private static native long create_2(boolean z6, boolean z7, float f6, int i5);

    private static native long create_3(boolean z6, boolean z7, float f6);

    private static native long create_4(boolean z6, boolean z7);

    private static native long create_5(boolean z6);

    private static native long create_6();

    private static native void delete(long j6);

    private static native String getDefaultName_0(long j6);

    private static native int getDiffusivity_0(long j6);

    private static native boolean getExtended_0(long j6);

    private static native int getNOctaveLayers_0(long j6);

    private static native int getNOctaves_0(long j6);

    private static native double getThreshold_0(long j6);

    private static native boolean getUpright_0(long j6);

    private static native void setDiffusivity_0(long j6, int i5);

    private static native void setExtended_0(long j6, boolean z6);

    private static native void setNOctaveLayers_0(long j6, int i5);

    private static native void setNOctaves_0(long j6, int i5);

    private static native void setThreshold_0(long j6, double d);

    private static native void setUpright_0(long j6, boolean z6);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public int getDiffusivity() {
        return getDiffusivity_0(this.nativeObj);
    }

    public boolean getExtended() {
        return getExtended_0(this.nativeObj);
    }

    public int getNOctaveLayers() {
        return getNOctaveLayers_0(this.nativeObj);
    }

    public int getNOctaves() {
        return getNOctaves_0(this.nativeObj);
    }

    public double getThreshold() {
        return getThreshold_0(this.nativeObj);
    }

    public boolean getUpright() {
        return getUpright_0(this.nativeObj);
    }

    public void setDiffusivity(int i5) {
        setDiffusivity_0(this.nativeObj, i5);
    }

    public void setExtended(boolean z6) {
        setExtended_0(this.nativeObj, z6);
    }

    public void setNOctaveLayers(int i5) {
        setNOctaveLayers_0(this.nativeObj, i5);
    }

    public void setNOctaves(int i5) {
        setNOctaves_0(this.nativeObj, i5);
    }

    public void setThreshold(double d) {
        setThreshold_0(this.nativeObj, d);
    }

    public void setUpright(boolean z6) {
        setUpright_0(this.nativeObj, z6);
    }

    public static KAZE create(boolean z6, boolean z7, float f6, int i5, int i6) {
        return __fromPtr__(create_1(z6, z7, f6, i5, i6));
    }

    public static KAZE create(boolean z6, boolean z7, float f6, int i5) {
        return __fromPtr__(create_2(z6, z7, f6, i5));
    }

    public static KAZE create(boolean z6, boolean z7, float f6) {
        return __fromPtr__(create_3(z6, z7, f6));
    }

    public static KAZE create(boolean z6, boolean z7) {
        return __fromPtr__(create_4(z6, z7));
    }

    public static KAZE create(boolean z6) {
        return __fromPtr__(create_5(z6));
    }

    public static KAZE create() {
        return __fromPtr__(create_6());
    }
}
