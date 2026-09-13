package org.opencv.objdetect;

import org.opencv.core.Mat;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FaceDetectorYN {
    protected final long nativeObj;

    public FaceDetectorYN(long j6) {
        this.nativeObj = j6;
    }

    public static FaceDetectorYN __fromPtr__(long j6) {
        return new FaceDetectorYN(j6);
    }

    public static FaceDetectorYN create(String str, String str2, Size size, float f6, float f7, int i5, int i6, int i7) {
        return __fromPtr__(create_0(str, str2, size.width, size.height, f6, f7, i5, i6, i7));
    }

    private static native long create_0(String str, String str2, double d, double d6, float f6, float f7, int i5, int i6, int i7);

    private static native long create_1(String str, String str2, double d, double d6, float f6, float f7, int i5, int i6);

    private static native long create_2(String str, String str2, double d, double d6, float f6, float f7, int i5);

    private static native long create_3(String str, String str2, double d, double d6, float f6, float f7);

    private static native long create_4(String str, String str2, double d, double d6, float f6);

    private static native long create_5(String str, String str2, double d, double d6);

    private static native void delete(long j6);

    private static native int detect_0(long j6, long j7, long j8);

    private static native double[] getInputSize_0(long j6);

    private static native float getNMSThreshold_0(long j6);

    private static native float getScoreThreshold_0(long j6);

    private static native int getTopK_0(long j6);

    private static native void setInputSize_0(long j6, double d, double d6);

    private static native void setNMSThreshold_0(long j6, float f6);

    private static native void setScoreThreshold_0(long j6, float f6);

    private static native void setTopK_0(long j6, int i5);

    public int detect(Mat mat, Mat mat2) {
        return detect_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public Size getInputSize() {
        return new Size(getInputSize_0(this.nativeObj));
    }

    public float getNMSThreshold() {
        return getNMSThreshold_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public float getScoreThreshold() {
        return getScoreThreshold_0(this.nativeObj);
    }

    public int getTopK() {
        return getTopK_0(this.nativeObj);
    }

    public void setInputSize(Size size) {
        setInputSize_0(this.nativeObj, size.width, size.height);
    }

    public void setNMSThreshold(float f6) {
        setNMSThreshold_0(this.nativeObj, f6);
    }

    public void setScoreThreshold(float f6) {
        setScoreThreshold_0(this.nativeObj, f6);
    }

    public void setTopK(int i5) {
        setTopK_0(this.nativeObj, i5);
    }

    public static FaceDetectorYN create(String str, String str2, Size size, float f6, float f7, int i5, int i6) {
        return __fromPtr__(create_1(str, str2, size.width, size.height, f6, f7, i5, i6));
    }

    public static FaceDetectorYN create(String str, String str2, Size size, float f6, float f7, int i5) {
        return __fromPtr__(create_2(str, str2, size.width, size.height, f6, f7, i5));
    }

    public static FaceDetectorYN create(String str, String str2, Size size, float f6, float f7) {
        return __fromPtr__(create_3(str, str2, size.width, size.height, f6, f7));
    }

    public static FaceDetectorYN create(String str, String str2, Size size, float f6) {
        return __fromPtr__(create_4(str, str2, size.width, size.height, f6));
    }

    public static FaceDetectorYN create(String str, String str2, Size size) {
        return __fromPtr__(create_5(str, str2, size.width, size.height));
    }
}
