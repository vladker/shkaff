package org.opencv.ml;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StatModel extends Algorithm {
    public static final int COMPRESSED_INPUT = 2;
    public static final int PREPROCESSED_INPUT = 4;
    public static final int RAW_OUTPUT = 1;
    public static final int UPDATE_MODEL = 1;

    public StatModel(long j6) {
        super(j6);
    }

    public static StatModel __fromPtr__(long j6) {
        return new StatModel(j6);
    }

    private static native float calcError_0(long j6, long j7, boolean z6, long j8);

    private static native void delete(long j6);

    private static native boolean empty_0(long j6);

    private static native int getVarCount_0(long j6);

    private static native boolean isClassifier_0(long j6);

    private static native boolean isTrained_0(long j6);

    private static native float predict_0(long j6, long j7, long j8, int i5);

    private static native float predict_1(long j6, long j7, long j8);

    private static native float predict_2(long j6, long j7);

    private static native boolean train_0(long j6, long j7, int i5);

    private static native boolean train_1(long j6, long j7);

    private static native boolean train_2(long j6, long j7, int i5, long j8);

    public float calcError(TrainData trainData, boolean z6, Mat mat) {
        return calcError_0(this.nativeObj, trainData.getNativeObjAddr(), z6, mat.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public boolean empty() {
        return empty_0(this.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getVarCount() {
        return getVarCount_0(this.nativeObj);
    }

    public boolean isClassifier() {
        return isClassifier_0(this.nativeObj);
    }

    public boolean isTrained() {
        return isTrained_0(this.nativeObj);
    }

    public float predict(Mat mat, Mat mat2, int i5) {
        return predict_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, i5);
    }

    public boolean train(TrainData trainData, int i5) {
        return train_0(this.nativeObj, trainData.getNativeObjAddr(), i5);
    }

    public float predict(Mat mat, Mat mat2) {
        return predict_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public boolean train(TrainData trainData) {
        return train_1(this.nativeObj, trainData.getNativeObjAddr());
    }

    public float predict(Mat mat) {
        return predict_2(this.nativeObj, mat.nativeObj);
    }

    public boolean train(Mat mat, int i5, Mat mat2) {
        return train_2(this.nativeObj, mat.nativeObj, i5, mat2.nativeObj);
    }
}
