package org.opencv.features2d;

import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BRISK extends Feature2D {
    public BRISK(long j6) {
        super(j6);
    }

    public static BRISK __fromPtr__(long j6) {
        return new BRISK(j6);
    }

    public static BRISK create(int i5, int i6, float f6) {
        return __fromPtr__(create_0(i5, i6, f6));
    }

    private static native long create_0(int i5, int i6, float f6);

    private static native long create_1(int i5, int i6);

    private static native long create_10(int i5, int i6, long j6, long j7, float f6);

    private static native long create_11(int i5, int i6, long j6, long j7);

    private static native long create_2(int i5);

    private static native long create_3();

    private static native long create_4(long j6, long j7, float f6, float f7, long j8);

    private static native long create_5(long j6, long j7, float f6, float f7);

    private static native long create_6(long j6, long j7, float f6);

    private static native long create_7(long j6, long j7);

    private static native long create_8(int i5, int i6, long j6, long j7, float f6, float f7, long j8);

    private static native long create_9(int i5, int i6, long j6, long j7, float f6, float f7);

    private static native void delete(long j6);

    private static native String getDefaultName_0(long j6);

    private static native int getOctaves_0(long j6);

    private static native float getPatternScale_0(long j6);

    private static native int getThreshold_0(long j6);

    private static native void setOctaves_0(long j6, int i5);

    private static native void setPatternScale_0(long j6, float f6);

    private static native void setThreshold_0(long j6, int i5);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public int getOctaves() {
        return getOctaves_0(this.nativeObj);
    }

    public float getPatternScale() {
        return getPatternScale_0(this.nativeObj);
    }

    public int getThreshold() {
        return getThreshold_0(this.nativeObj);
    }

    public void setOctaves(int i5) {
        setOctaves_0(this.nativeObj, i5);
    }

    public void setPatternScale(float f6) {
        setPatternScale_0(this.nativeObj, f6);
    }

    public void setThreshold(int i5) {
        setThreshold_0(this.nativeObj, i5);
    }

    public static BRISK create(int i5, int i6) {
        return __fromPtr__(create_1(i5, i6));
    }

    public static BRISK create(int i5) {
        return __fromPtr__(create_2(i5));
    }

    public static BRISK create() {
        return __fromPtr__(create_3());
    }

    public static BRISK create(MatOfFloat matOfFloat, MatOfInt matOfInt, float f6, float f7, MatOfInt matOfInt2) {
        return __fromPtr__(create_4(matOfFloat.nativeObj, matOfInt.nativeObj, f6, f7, matOfInt2.nativeObj));
    }

    public static BRISK create(MatOfFloat matOfFloat, MatOfInt matOfInt, float f6, float f7) {
        return __fromPtr__(create_5(matOfFloat.nativeObj, matOfInt.nativeObj, f6, f7));
    }

    public static BRISK create(MatOfFloat matOfFloat, MatOfInt matOfInt, float f6) {
        return __fromPtr__(create_6(matOfFloat.nativeObj, matOfInt.nativeObj, f6));
    }

    public static BRISK create(MatOfFloat matOfFloat, MatOfInt matOfInt) {
        return __fromPtr__(create_7(matOfFloat.nativeObj, matOfInt.nativeObj));
    }

    public static BRISK create(int i5, int i6, MatOfFloat matOfFloat, MatOfInt matOfInt, float f6, float f7, MatOfInt matOfInt2) {
        return __fromPtr__(create_8(i5, i6, matOfFloat.nativeObj, matOfInt.nativeObj, f6, f7, matOfInt2.nativeObj));
    }

    public static BRISK create(int i5, int i6, MatOfFloat matOfFloat, MatOfInt matOfInt, float f6, float f7) {
        return __fromPtr__(create_9(i5, i6, matOfFloat.nativeObj, matOfInt.nativeObj, f6, f7));
    }

    public static BRISK create(int i5, int i6, MatOfFloat matOfFloat, MatOfInt matOfInt, float f6) {
        return __fromPtr__(create_10(i5, i6, matOfFloat.nativeObj, matOfInt.nativeObj, f6));
    }

    public static BRISK create(int i5, int i6, MatOfFloat matOfFloat, MatOfInt matOfInt) {
        return __fromPtr__(create_11(i5, i6, matOfFloat.nativeObj, matOfInt.nativeObj));
    }
}
