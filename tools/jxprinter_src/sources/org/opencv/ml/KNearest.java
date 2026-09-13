package org.opencv.ml;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class KNearest extends StatModel {
    public static final int BRUTE_FORCE = 1;
    public static final int KDTREE = 2;

    public KNearest(long j6) {
        super(j6);
    }

    public static KNearest __fromPtr__(long j6) {
        return new KNearest(j6);
    }

    public static KNearest create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    private static native float findNearest_0(long j6, long j7, int i5, long j8, long j9, long j10);

    private static native float findNearest_1(long j6, long j7, int i5, long j8, long j9);

    private static native float findNearest_2(long j6, long j7, int i5, long j8);

    private static native int getAlgorithmType_0(long j6);

    private static native int getDefaultK_0(long j6);

    private static native int getEmax_0(long j6);

    private static native boolean getIsClassifier_0(long j6);

    public static KNearest load(String str) {
        return __fromPtr__(load_0(str));
    }

    private static native long load_0(String str);

    private static native void setAlgorithmType_0(long j6, int i5);

    private static native void setDefaultK_0(long j6, int i5);

    private static native void setEmax_0(long j6, int i5);

    private static native void setIsClassifier_0(long j6, boolean z6);

    @Override // org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float findNearest(Mat mat, int i5, Mat mat2, Mat mat3, Mat mat4) {
        return findNearest_0(this.nativeObj, mat.nativeObj, i5, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public int getAlgorithmType() {
        return getAlgorithmType_0(this.nativeObj);
    }

    public int getDefaultK() {
        return getDefaultK_0(this.nativeObj);
    }

    public int getEmax() {
        return getEmax_0(this.nativeObj);
    }

    public boolean getIsClassifier() {
        return getIsClassifier_0(this.nativeObj);
    }

    public void setAlgorithmType(int i5) {
        setAlgorithmType_0(this.nativeObj, i5);
    }

    public void setDefaultK(int i5) {
        setDefaultK_0(this.nativeObj, i5);
    }

    public void setEmax(int i5) {
        setEmax_0(this.nativeObj, i5);
    }

    public void setIsClassifier(boolean z6) {
        setIsClassifier_0(this.nativeObj, z6);
    }

    public float findNearest(Mat mat, int i5, Mat mat2, Mat mat3) {
        return findNearest_1(this.nativeObj, mat.nativeObj, i5, mat2.nativeObj, mat3.nativeObj);
    }

    public float findNearest(Mat mat, int i5, Mat mat2) {
        return findNearest_2(this.nativeObj, mat.nativeObj, i5, mat2.nativeObj);
    }
}
