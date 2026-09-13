package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ORB extends Feature2D {
    public static final int FAST_SCORE = 1;
    public static final int HARRIS_SCORE = 0;

    public ORB(long j6) {
        super(j6);
    }

    public static ORB __fromPtr__(long j6) {
        return new ORB(j6);
    }

    public static ORB create(int i5, float f6, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        return __fromPtr__(create_0(i5, f6, i6, i7, i8, i9, i10, i11, i12));
    }

    private static native long create_0(int i5, float f6, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    private static native long create_1(int i5, float f6, int i6, int i7, int i8, int i9, int i10, int i11);

    private static native long create_2(int i5, float f6, int i6, int i7, int i8, int i9, int i10);

    private static native long create_3(int i5, float f6, int i6, int i7, int i8, int i9);

    private static native long create_4(int i5, float f6, int i6, int i7, int i8);

    private static native long create_5(int i5, float f6, int i6, int i7);

    private static native long create_6(int i5, float f6, int i6);

    private static native long create_7(int i5, float f6);

    private static native long create_8(int i5);

    private static native long create_9();

    private static native void delete(long j6);

    private static native String getDefaultName_0(long j6);

    private static native int getEdgeThreshold_0(long j6);

    private static native int getFastThreshold_0(long j6);

    private static native int getFirstLevel_0(long j6);

    private static native int getMaxFeatures_0(long j6);

    private static native int getNLevels_0(long j6);

    private static native int getPatchSize_0(long j6);

    private static native double getScaleFactor_0(long j6);

    private static native int getScoreType_0(long j6);

    private static native int getWTA_K_0(long j6);

    private static native void setEdgeThreshold_0(long j6, int i5);

    private static native void setFastThreshold_0(long j6, int i5);

    private static native void setFirstLevel_0(long j6, int i5);

    private static native void setMaxFeatures_0(long j6, int i5);

    private static native void setNLevels_0(long j6, int i5);

    private static native void setPatchSize_0(long j6, int i5);

    private static native void setScaleFactor_0(long j6, double d);

    private static native void setScoreType_0(long j6, int i5);

    private static native void setWTA_K_0(long j6, int i5);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public int getEdgeThreshold() {
        return getEdgeThreshold_0(this.nativeObj);
    }

    public int getFastThreshold() {
        return getFastThreshold_0(this.nativeObj);
    }

    public int getFirstLevel() {
        return getFirstLevel_0(this.nativeObj);
    }

    public int getMaxFeatures() {
        return getMaxFeatures_0(this.nativeObj);
    }

    public int getNLevels() {
        return getNLevels_0(this.nativeObj);
    }

    public int getPatchSize() {
        return getPatchSize_0(this.nativeObj);
    }

    public double getScaleFactor() {
        return getScaleFactor_0(this.nativeObj);
    }

    public int getScoreType() {
        return getScoreType_0(this.nativeObj);
    }

    public int getWTA_K() {
        return getWTA_K_0(this.nativeObj);
    }

    public void setEdgeThreshold(int i5) {
        setEdgeThreshold_0(this.nativeObj, i5);
    }

    public void setFastThreshold(int i5) {
        setFastThreshold_0(this.nativeObj, i5);
    }

    public void setFirstLevel(int i5) {
        setFirstLevel_0(this.nativeObj, i5);
    }

    public void setMaxFeatures(int i5) {
        setMaxFeatures_0(this.nativeObj, i5);
    }

    public void setNLevels(int i5) {
        setNLevels_0(this.nativeObj, i5);
    }

    public void setPatchSize(int i5) {
        setPatchSize_0(this.nativeObj, i5);
    }

    public void setScaleFactor(double d) {
        setScaleFactor_0(this.nativeObj, d);
    }

    public void setScoreType(int i5) {
        setScoreType_0(this.nativeObj, i5);
    }

    public void setWTA_K(int i5) {
        setWTA_K_0(this.nativeObj, i5);
    }

    public static ORB create(int i5, float f6, int i6, int i7, int i8, int i9, int i10, int i11) {
        return __fromPtr__(create_1(i5, f6, i6, i7, i8, i9, i10, i11));
    }

    public static ORB create(int i5, float f6, int i6, int i7, int i8, int i9, int i10) {
        return __fromPtr__(create_2(i5, f6, i6, i7, i8, i9, i10));
    }

    public static ORB create(int i5, float f6, int i6, int i7, int i8, int i9) {
        return __fromPtr__(create_3(i5, f6, i6, i7, i8, i9));
    }

    public static ORB create(int i5, float f6, int i6, int i7, int i8) {
        return __fromPtr__(create_4(i5, f6, i6, i7, i8));
    }

    public static ORB create(int i5, float f6, int i6, int i7) {
        return __fromPtr__(create_5(i5, f6, i6, i7));
    }

    public static ORB create(int i5, float f6, int i6) {
        return __fromPtr__(create_6(i5, f6, i6));
    }

    public static ORB create(int i5, float f6) {
        return __fromPtr__(create_7(i5, f6));
    }

    public static ORB create(int i5) {
        return __fromPtr__(create_8(i5));
    }

    public static ORB create() {
        return __fromPtr__(create_9());
    }
}
