package org.opencv.features2d;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Feature2D extends Algorithm {
    public Feature2D(long j6) {
        super(j6);
    }

    public static Feature2D __fromPtr__(long j6) {
        return new Feature2D(j6);
    }

    private static native void compute_0(long j6, long j7, long j8, long j9);

    private static native void compute_1(long j6, long j7, long j8, long j9);

    private static native int defaultNorm_0(long j6);

    private static native void delete(long j6);

    private static native int descriptorSize_0(long j6);

    private static native int descriptorType_0(long j6);

    private static native void detectAndCompute_0(long j6, long j7, long j8, long j9, long j10, boolean z6);

    private static native void detectAndCompute_1(long j6, long j7, long j8, long j9, long j10);

    private static native void detect_0(long j6, long j7, long j8, long j9);

    private static native void detect_1(long j6, long j7, long j8);

    private static native void detect_2(long j6, long j7, long j8, long j9);

    private static native void detect_3(long j6, long j7, long j8);

    private static native boolean empty_0(long j6);

    private static native String getDefaultName_0(long j6);

    private static native void read_0(long j6, String str);

    private static native void write_0(long j6, String str);

    public void compute(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2) {
        compute_0(this.nativeObj, mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj);
    }

    public int defaultNorm() {
        return defaultNorm_0(this.nativeObj);
    }

    public int descriptorSize() {
        return descriptorSize_0(this.nativeObj);
    }

    public int descriptorType() {
        return descriptorType_0(this.nativeObj);
    }

    public void detect(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2) {
        detect_0(this.nativeObj, mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj);
    }

    public void detectAndCompute(Mat mat, Mat mat2, MatOfKeyPoint matOfKeyPoint, Mat mat3, boolean z6) {
        detectAndCompute_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, matOfKeyPoint.nativeObj, mat3.nativeObj, z6);
    }

    @Override // org.opencv.core.Algorithm
    public boolean empty() {
        return empty_0(this.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public void read(String str) {
        read_0(this.nativeObj, str);
    }

    public void write(String str) {
        write_0(this.nativeObj, str);
    }

    public void compute(List<Mat> list, List<MatOfKeyPoint> list2, List<Mat> list3) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_vector_KeyPoint_to_Mat = Converters.vector_vector_KeyPoint_to_Mat(list2, new ArrayList(list2 != null ? list2.size() : 0));
        Mat mat = new Mat();
        compute_1(this.nativeObj, matVector_Mat_to_Mat.nativeObj, matVector_vector_KeyPoint_to_Mat.nativeObj, mat.nativeObj);
        Converters.Mat_to_vector_vector_KeyPoint(matVector_vector_KeyPoint_to_Mat, list2);
        matVector_vector_KeyPoint_to_Mat.release();
        Converters.Mat_to_vector_Mat(mat, list3);
        mat.release();
    }

    public void detect(Mat mat, MatOfKeyPoint matOfKeyPoint) {
        detect_1(this.nativeObj, mat.nativeObj, matOfKeyPoint.nativeObj);
    }

    public void detectAndCompute(Mat mat, Mat mat2, MatOfKeyPoint matOfKeyPoint, Mat mat3) {
        detectAndCompute_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, matOfKeyPoint.nativeObj, mat3.nativeObj);
    }

    public void detect(List<Mat> list, List<MatOfKeyPoint> list2, List<Mat> list3) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat mat = new Mat();
        detect_2(this.nativeObj, matVector_Mat_to_Mat.nativeObj, mat.nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj);
        Converters.Mat_to_vector_vector_KeyPoint(mat, list2);
        mat.release();
    }

    public void detect(List<Mat> list, List<MatOfKeyPoint> list2) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat mat = new Mat();
        detect_3(this.nativeObj, matVector_Mat_to_Mat.nativeObj, mat.nativeObj);
        Converters.Mat_to_vector_vector_KeyPoint(mat, list2);
        mat.release();
    }
}
