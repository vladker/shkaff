package org.opencv.dnn;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Model {
    protected final long nativeObj;

    public Model(long j6) {
        this.nativeObj = j6;
    }

    private static native long Model_0(String str, String str2);

    private static native long Model_1(String str);

    private static native long Model_2(long j6);

    public static Model __fromPtr__(long j6) {
        return new Model(j6);
    }

    private static native void delete(long j6);

    private static native void predict_0(long j6, long j7, long j8);

    private static native long setInputCrop_0(long j6, boolean z6);

    private static native long setInputMean_0(long j6, double d, double d6, double d7, double d8);

    private static native void setInputParams_0(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6, boolean z7);

    private static native void setInputParams_1(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6);

    private static native void setInputParams_2(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11);

    private static native void setInputParams_3(long j6, double d, double d6, double d7);

    private static native void setInputParams_4(long j6, double d);

    private static native void setInputParams_5(long j6);

    private static native long setInputScale_0(long j6, double d, double d6, double d7, double d8);

    private static native long setInputSize_0(long j6, double d, double d6);

    private static native long setInputSize_1(long j6, int i5, int i6);

    private static native long setInputSwapRB_0(long j6, boolean z6);

    private static native long setPreferableBackend_0(long j6, int i5);

    private static native long setPreferableTarget_0(long j6, int i5);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public void predict(Mat mat, List<Mat> list) {
        Mat mat2 = new Mat();
        predict_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
    }

    public Model setInputCrop(boolean z6) {
        return new Model(setInputCrop_0(this.nativeObj, z6));
    }

    public Model setInputMean(Scalar scalar) {
        long j6 = this.nativeObj;
        double[] dArr = scalar.val;
        return new Model(setInputMean_0(j6, dArr[0], dArr[1], dArr[2], dArr[3]));
    }

    public void setInputParams(double d, Size size, Scalar scalar, boolean z6, boolean z7) {
        long j6 = this.nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        setInputParams_0(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3], z6, z7);
    }

    public Model setInputScale(Scalar scalar) {
        long j6 = this.nativeObj;
        double[] dArr = scalar.val;
        return new Model(setInputScale_0(j6, dArr[0], dArr[1], dArr[2], dArr[3]));
    }

    public Model setInputSize(Size size) {
        return new Model(setInputSize_0(this.nativeObj, size.width, size.height));
    }

    public Model setInputSwapRB(boolean z6) {
        return new Model(setInputSwapRB_0(this.nativeObj, z6));
    }

    public Model setPreferableBackend(int i5) {
        return new Model(setPreferableBackend_0(this.nativeObj, i5));
    }

    public Model setPreferableTarget(int i5) {
        return new Model(setPreferableTarget_0(this.nativeObj, i5));
    }

    public Model(String str, String str2) {
        this.nativeObj = Model_0(str, str2);
    }

    public void setInputParams(double d, Size size, Scalar scalar, boolean z6) {
        long j6 = this.nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        setInputParams_1(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3], z6);
    }

    public Model setInputSize(int i5, int i6) {
        return new Model(setInputSize_1(this.nativeObj, i5, i6));
    }

    public void setInputParams(double d, Size size, Scalar scalar) {
        long j6 = this.nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        setInputParams_2(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public Model(String str) {
        this.nativeObj = Model_1(str);
    }

    public void setInputParams(double d, Size size) {
        setInputParams_3(this.nativeObj, d, size.width, size.height);
    }

    public void setInputParams(double d) {
        setInputParams_4(this.nativeObj, d);
    }

    public Model(Net net) {
        this.nativeObj = Model_2(net.nativeObj);
    }

    public void setInputParams() {
        setInputParams_5(this.nativeObj);
    }
}
