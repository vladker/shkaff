package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class LogisticRegression extends StatModel {
    public static final int BATCH = 0;
    public static final int MINI_BATCH = 1;
    public static final int REG_DISABLE = -1;
    public static final int REG_L1 = 0;
    public static final int REG_L2 = 1;

    public LogisticRegression(long j6) {
        super(j6);
    }

    public static LogisticRegression __fromPtr__(long j6) {
        return new LogisticRegression(j6);
    }

    public static LogisticRegression create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    private static native int getIterations_0(long j6);

    private static native double getLearningRate_0(long j6);

    private static native int getMiniBatchSize_0(long j6);

    private static native int getRegularization_0(long j6);

    private static native double[] getTermCriteria_0(long j6);

    private static native int getTrainMethod_0(long j6);

    private static native long get_learnt_thetas_0(long j6);

    public static LogisticRegression load(String str, String str2) {
        return __fromPtr__(load_0(str, str2));
    }

    private static native long load_0(String str, String str2);

    private static native long load_1(String str);

    private static native float predict_0(long j6, long j7, long j8, int i5);

    private static native float predict_1(long j6, long j7, long j8);

    private static native float predict_2(long j6, long j7);

    private static native void setIterations_0(long j6, int i5);

    private static native void setLearningRate_0(long j6, double d);

    private static native void setMiniBatchSize_0(long j6, int i5);

    private static native void setRegularization_0(long j6, int i5);

    private static native void setTermCriteria_0(long j6, int i5, int i6, double d);

    private static native void setTrainMethod_0(long j6, int i5);

    @Override // org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getIterations() {
        return getIterations_0(this.nativeObj);
    }

    public double getLearningRate() {
        return getLearningRate_0(this.nativeObj);
    }

    public int getMiniBatchSize() {
        return getMiniBatchSize_0(this.nativeObj);
    }

    public int getRegularization() {
        return getRegularization_0(this.nativeObj);
    }

    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }

    public int getTrainMethod() {
        return getTrainMethod_0(this.nativeObj);
    }

    public Mat get_learnt_thetas() {
        return new Mat(get_learnt_thetas_0(this.nativeObj));
    }

    @Override // org.opencv.ml.StatModel
    public float predict(Mat mat, Mat mat2, int i5) {
        return predict_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, i5);
    }

    public void setIterations(int i5) {
        setIterations_0(this.nativeObj, i5);
    }

    public void setLearningRate(double d) {
        setLearningRate_0(this.nativeObj, d);
    }

    public void setMiniBatchSize(int i5) {
        setMiniBatchSize_0(this.nativeObj, i5);
    }

    public void setRegularization(int i5) {
        setRegularization_0(this.nativeObj, i5);
    }

    public void setTermCriteria(TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public void setTrainMethod(int i5) {
        setTrainMethod_0(this.nativeObj, i5);
    }

    public static LogisticRegression load(String str) {
        return __fromPtr__(load_1(str));
    }

    @Override // org.opencv.ml.StatModel
    public float predict(Mat mat, Mat mat2) {
        return predict_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    @Override // org.opencv.ml.StatModel
    public float predict(Mat mat) {
        return predict_2(this.nativeObj, mat.nativeObj);
    }
}
