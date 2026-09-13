package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class GFTTDetector extends Feature2D {
    public GFTTDetector(long j6) {
        super(j6);
    }

    public static GFTTDetector __fromPtr__(long j6) {
        return new GFTTDetector(j6);
    }

    public static GFTTDetector create(int i5, double d, double d6, int i6, boolean z6, double d7) {
        return __fromPtr__(create_0(i5, d, d6, i6, z6, d7));
    }

    private static native long create_0(int i5, double d, double d6, int i6, boolean z6, double d7);

    private static native long create_1(int i5, double d, double d6, int i6, boolean z6);

    private static native long create_2(int i5, double d, double d6, int i6);

    private static native long create_3(int i5, double d, double d6);

    private static native long create_4(int i5, double d);

    private static native long create_5(int i5);

    private static native long create_6();

    private static native long create_7(int i5, double d, double d6, int i6, int i7, boolean z6, double d7);

    private static native long create_8(int i5, double d, double d6, int i6, int i7, boolean z6);

    private static native long create_9(int i5, double d, double d6, int i6, int i7);

    private static native void delete(long j6);

    private static native int getBlockSize_0(long j6);

    private static native String getDefaultName_0(long j6);

    private static native int getGradientSize_0(long j6);

    private static native boolean getHarrisDetector_0(long j6);

    private static native double getK_0(long j6);

    private static native int getMaxFeatures_0(long j6);

    private static native double getMinDistance_0(long j6);

    private static native double getQualityLevel_0(long j6);

    private static native void setBlockSize_0(long j6, int i5);

    private static native void setGradientSize_0(long j6, int i5);

    private static native void setHarrisDetector_0(long j6, boolean z6);

    private static native void setK_0(long j6, double d);

    private static native void setMaxFeatures_0(long j6, int i5);

    private static native void setMinDistance_0(long j6, double d);

    private static native void setQualityLevel_0(long j6, double d);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getBlockSize() {
        return getBlockSize_0(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public int getGradientSize() {
        return getGradientSize_0(this.nativeObj);
    }

    public boolean getHarrisDetector() {
        return getHarrisDetector_0(this.nativeObj);
    }

    public double getK() {
        return getK_0(this.nativeObj);
    }

    public int getMaxFeatures() {
        return getMaxFeatures_0(this.nativeObj);
    }

    public double getMinDistance() {
        return getMinDistance_0(this.nativeObj);
    }

    public double getQualityLevel() {
        return getQualityLevel_0(this.nativeObj);
    }

    public void setBlockSize(int i5) {
        setBlockSize_0(this.nativeObj, i5);
    }

    public void setGradientSize(int i5) {
        setGradientSize_0(this.nativeObj, i5);
    }

    public void setHarrisDetector(boolean z6) {
        setHarrisDetector_0(this.nativeObj, z6);
    }

    public void setK(double d) {
        setK_0(this.nativeObj, d);
    }

    public void setMaxFeatures(int i5) {
        setMaxFeatures_0(this.nativeObj, i5);
    }

    public void setMinDistance(double d) {
        setMinDistance_0(this.nativeObj, d);
    }

    public void setQualityLevel(double d) {
        setQualityLevel_0(this.nativeObj, d);
    }

    public static GFTTDetector create(int i5, double d, double d6, int i6, boolean z6) {
        return __fromPtr__(create_1(i5, d, d6, i6, z6));
    }

    public static GFTTDetector create(int i5, double d, double d6, int i6) {
        return __fromPtr__(create_2(i5, d, d6, i6));
    }

    public static GFTTDetector create(int i5, double d, double d6) {
        return __fromPtr__(create_3(i5, d, d6));
    }

    public static GFTTDetector create(int i5, double d) {
        return __fromPtr__(create_4(i5, d));
    }

    public static GFTTDetector create(int i5) {
        return __fromPtr__(create_5(i5));
    }

    public static GFTTDetector create() {
        return __fromPtr__(create_6());
    }

    public static GFTTDetector create(int i5, double d, double d6, int i6, int i7, boolean z6, double d7) {
        return __fromPtr__(create_7(i5, d, d6, i6, i7, z6, d7));
    }

    public static GFTTDetector create(int i5, double d, double d6, int i6, int i7, boolean z6) {
        return __fromPtr__(create_8(i5, d, d6, i6, i7, z6));
    }

    public static GFTTDetector create(int i5, double d, double d6, int i6, int i7) {
        return __fromPtr__(create_9(i5, d, d6, i6, i7));
    }
}
