package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class AKAZE extends Feature2D {
    public static final int DESCRIPTOR_KAZE = 3;
    public static final int DESCRIPTOR_KAZE_UPRIGHT = 2;
    public static final int DESCRIPTOR_MLDB = 5;
    public static final int DESCRIPTOR_MLDB_UPRIGHT = 4;

    public AKAZE(long j6) {
        super(j6);
    }

    public static AKAZE __fromPtr__(long j6) {
        return new AKAZE(j6);
    }

    public static AKAZE create(int i5, int i6, int i7, float f6, int i8, int i9, int i10) {
        return __fromPtr__(create_0(i5, i6, i7, f6, i8, i9, i10));
    }

    private static native long create_0(int i5, int i6, int i7, float f6, int i8, int i9, int i10);

    private static native long create_1(int i5, int i6, int i7, float f6, int i8, int i9);

    private static native long create_2(int i5, int i6, int i7, float f6, int i8);

    private static native long create_3(int i5, int i6, int i7, float f6);

    private static native long create_4(int i5, int i6, int i7);

    private static native long create_5(int i5, int i6);

    private static native long create_6(int i5);

    private static native long create_7();

    private static native void delete(long j6);

    private static native String getDefaultName_0(long j6);

    private static native int getDescriptorChannels_0(long j6);

    private static native int getDescriptorSize_0(long j6);

    private static native int getDescriptorType_0(long j6);

    private static native int getDiffusivity_0(long j6);

    private static native int getNOctaveLayers_0(long j6);

    private static native int getNOctaves_0(long j6);

    private static native double getThreshold_0(long j6);

    private static native void setDescriptorChannels_0(long j6, int i5);

    private static native void setDescriptorSize_0(long j6, int i5);

    private static native void setDescriptorType_0(long j6, int i5);

    private static native void setDiffusivity_0(long j6, int i5);

    private static native void setNOctaveLayers_0(long j6, int i5);

    private static native void setNOctaves_0(long j6, int i5);

    private static native void setThreshold_0(long j6, double d);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public int getDescriptorChannels() {
        return getDescriptorChannels_0(this.nativeObj);
    }

    public int getDescriptorSize() {
        return getDescriptorSize_0(this.nativeObj);
    }

    public int getDescriptorType() {
        return getDescriptorType_0(this.nativeObj);
    }

    public int getDiffusivity() {
        return getDiffusivity_0(this.nativeObj);
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

    public void setDescriptorChannels(int i5) {
        setDescriptorChannels_0(this.nativeObj, i5);
    }

    public void setDescriptorSize(int i5) {
        setDescriptorSize_0(this.nativeObj, i5);
    }

    public void setDescriptorType(int i5) {
        setDescriptorType_0(this.nativeObj, i5);
    }

    public void setDiffusivity(int i5) {
        setDiffusivity_0(this.nativeObj, i5);
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

    public static AKAZE create(int i5, int i6, int i7, float f6, int i8, int i9) {
        return __fromPtr__(create_1(i5, i6, i7, f6, i8, i9));
    }

    public static AKAZE create(int i5, int i6, int i7, float f6, int i8) {
        return __fromPtr__(create_2(i5, i6, i7, f6, i8));
    }

    public static AKAZE create(int i5, int i6, int i7, float f6) {
        return __fromPtr__(create_3(i5, i6, i7, f6));
    }

    public static AKAZE create(int i5, int i6, int i7) {
        return __fromPtr__(create_4(i5, i6, i7));
    }

    public static AKAZE create(int i5, int i6) {
        return __fromPtr__(create_5(i5, i6));
    }

    public static AKAZE create(int i5) {
        return __fromPtr__(create_6(i5));
    }

    public static AKAZE create() {
        return __fromPtr__(create_7());
    }
}
