package org.opencv.ml;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class NormalBayesClassifier extends StatModel {
    public NormalBayesClassifier(long j6) {
        super(j6);
    }

    public static NormalBayesClassifier __fromPtr__(long j6) {
        return new NormalBayesClassifier(j6);
    }

    public static NormalBayesClassifier create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    public static NormalBayesClassifier load(String str, String str2) {
        return __fromPtr__(load_0(str, str2));
    }

    private static native long load_0(String str, String str2);

    private static native long load_1(String str);

    private static native float predictProb_0(long j6, long j7, long j8, long j9, int i5);

    private static native float predictProb_1(long j6, long j7, long j8, long j9);

    @Override // org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float predictProb(Mat mat, Mat mat2, Mat mat3, int i5) {
        return predictProb_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5);
    }

    public static NormalBayesClassifier load(String str) {
        return __fromPtr__(load_1(str));
    }

    public float predictProb(Mat mat, Mat mat2, Mat mat3) {
        return predictProb_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
}
