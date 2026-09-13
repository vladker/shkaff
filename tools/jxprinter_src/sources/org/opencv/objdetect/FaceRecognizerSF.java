package org.opencv.objdetect;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FaceRecognizerSF {
    public static final int FR_COSINE = 0;
    public static final int FR_NORM_L2 = 1;
    protected final long nativeObj;

    public FaceRecognizerSF(long j6) {
        this.nativeObj = j6;
    }

    public static FaceRecognizerSF __fromPtr__(long j6) {
        return new FaceRecognizerSF(j6);
    }

    private static native void alignCrop_0(long j6, long j7, long j8, long j9);

    public static FaceRecognizerSF create(String str, String str2, int i5, int i6) {
        return __fromPtr__(create_0(str, str2, i5, i6));
    }

    private static native long create_0(String str, String str2, int i5, int i6);

    private static native long create_1(String str, String str2, int i5);

    private static native long create_2(String str, String str2);

    private static native void delete(long j6);

    private static native void feature_0(long j6, long j7, long j8);

    private static native double match_0(long j6, long j7, long j8, int i5);

    private static native double match_1(long j6, long j7, long j8);

    public void alignCrop(Mat mat, Mat mat2, Mat mat3) {
        alignCrop_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void feature(Mat mat, Mat mat2) {
        feature_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public double match(Mat mat, Mat mat2, int i5) {
        return match_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, i5);
    }

    public static FaceRecognizerSF create(String str, String str2, int i5) {
        return __fromPtr__(create_1(str, str2, i5));
    }

    public double match(Mat mat, Mat mat2) {
        return match_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public static FaceRecognizerSF create(String str, String str2) {
        return __fromPtr__(create_2(str, str2));
    }
}
