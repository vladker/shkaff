package org.opencv.video;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Video {
    private static final int CV_LKFLOW_GET_MIN_EIGENVALS = 8;
    private static final int CV_LKFLOW_INITIAL_GUESSES = 4;
    public static final int MOTION_AFFINE = 2;
    public static final int MOTION_EUCLIDEAN = 1;
    public static final int MOTION_HOMOGRAPHY = 3;
    public static final int MOTION_TRANSLATION = 0;
    public static final int OPTFLOW_FARNEBACK_GAUSSIAN = 256;
    public static final int OPTFLOW_LK_GET_MIN_EIGENVALS = 8;
    public static final int OPTFLOW_USE_INITIAL_FLOW = 4;
    public static final int TrackerSamplerCSC_MODE_DETECT = 5;
    public static final int TrackerSamplerCSC_MODE_INIT_NEG = 2;
    public static final int TrackerSamplerCSC_MODE_INIT_POS = 1;
    public static final int TrackerSamplerCSC_MODE_TRACK_NEG = 4;
    public static final int TrackerSamplerCSC_MODE_TRACK_POS = 3;

    public static RotatedRect CamShift(Mat mat, Rect rect, TermCriteria termCriteria) {
        double[] dArr = new double[4];
        RotatedRect rotatedRect = new RotatedRect(CamShift_0(mat.nativeObj, rect.f7686x, rect.f7687y, rect.width, rect.height, dArr, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon));
        rect.f7686x = (int) dArr[0];
        rect.f7687y = (int) dArr[1];
        rect.width = (int) dArr[2];
        rect.height = (int) dArr[3];
        return rotatedRect;
    }

    private static native double[] CamShift_0(long j6, int i5, int i6, int i7, int i8, double[] dArr, int i9, int i10, double d);

    public static int buildOpticalFlowPyramid(Mat mat, List<Mat> list, Size size, int i5, boolean z6, int i6, int i7, boolean z7) {
        Mat mat2 = new Mat();
        int iBuildOpticalFlowPyramid_0 = buildOpticalFlowPyramid_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, i5, z6, i6, i7, z7);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
        return iBuildOpticalFlowPyramid_0;
    }

    private static native int buildOpticalFlowPyramid_0(long j6, long j7, double d, double d6, int i5, boolean z6, int i6, int i7, boolean z7);

    private static native int buildOpticalFlowPyramid_1(long j6, long j7, double d, double d6, int i5, boolean z6, int i6, int i7);

    private static native int buildOpticalFlowPyramid_2(long j6, long j7, double d, double d6, int i5, boolean z6, int i6);

    private static native int buildOpticalFlowPyramid_3(long j6, long j7, double d, double d6, int i5, boolean z6);

    private static native int buildOpticalFlowPyramid_4(long j6, long j7, double d, double d6, int i5);

    public static void calcOpticalFlowFarneback(Mat mat, Mat mat2, Mat mat3, double d, int i5, int i6, int i7, int i8, double d6, int i9) {
        calcOpticalFlowFarneback_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d, i5, i6, i7, i8, d6, i9);
    }

    private static native void calcOpticalFlowFarneback_0(long j6, long j7, long j8, double d, int i5, int i6, int i7, int i8, double d6, int i9);

    public static void calcOpticalFlowPyrLK(Mat mat, Mat mat2, MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, MatOfByte matOfByte, MatOfFloat matOfFloat, Size size, int i5, TermCriteria termCriteria, int i6, double d) {
        calcOpticalFlowPyrLK_0(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj, size.width, size.height, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i6, d);
    }

    private static native void calcOpticalFlowPyrLK_0(long j6, long j7, long j8, long j9, long j10, long j11, double d, double d6, int i5, int i6, int i7, double d7, int i8, double d8);

    private static native void calcOpticalFlowPyrLK_1(long j6, long j7, long j8, long j9, long j10, long j11, double d, double d6, int i5, int i6, int i7, double d7, int i8);

    private static native void calcOpticalFlowPyrLK_2(long j6, long j7, long j8, long j9, long j10, long j11, double d, double d6, int i5, int i6, int i7, double d7);

    private static native void calcOpticalFlowPyrLK_3(long j6, long j7, long j8, long j9, long j10, long j11, double d, double d6, int i5);

    private static native void calcOpticalFlowPyrLK_4(long j6, long j7, long j8, long j9, long j10, long j11, double d, double d6);

    private static native void calcOpticalFlowPyrLK_5(long j6, long j7, long j8, long j9, long j10, long j11);

    public static double computeECC(Mat mat, Mat mat2, Mat mat3) {
        return computeECC_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native double computeECC_0(long j6, long j7, long j8);

    private static native double computeECC_1(long j6, long j7);

    public static BackgroundSubtractorKNN createBackgroundSubtractorKNN(int i5, double d, boolean z6) {
        return BackgroundSubtractorKNN.__fromPtr__(createBackgroundSubtractorKNN_0(i5, d, z6));
    }

    private static native long createBackgroundSubtractorKNN_0(int i5, double d, boolean z6);

    private static native long createBackgroundSubtractorKNN_1(int i5, double d);

    private static native long createBackgroundSubtractorKNN_2(int i5);

    private static native long createBackgroundSubtractorKNN_3();

    public static BackgroundSubtractorMOG2 createBackgroundSubtractorMOG2(int i5, double d, boolean z6) {
        return BackgroundSubtractorMOG2.__fromPtr__(createBackgroundSubtractorMOG2_0(i5, d, z6));
    }

    private static native long createBackgroundSubtractorMOG2_0(int i5, double d, boolean z6);

    private static native long createBackgroundSubtractorMOG2_1(int i5, double d);

    private static native long createBackgroundSubtractorMOG2_2(int i5);

    private static native long createBackgroundSubtractorMOG2_3();

    public static double findTransformECC(Mat mat, Mat mat2, Mat mat3, int i5, TermCriteria termCriteria, Mat mat4, int i6) {
        return findTransformECC_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, mat4.nativeObj, i6);
    }

    private static native double findTransformECC_0(long j6, long j7, long j8, int i5, int i6, int i7, double d, long j9, int i8);

    private static native double findTransformECC_1(long j6, long j7, long j8, int i5, int i6, int i7, double d, long j9);

    private static native double findTransformECC_2(long j6, long j7, long j8, int i5, int i6, int i7, double d);

    private static native double findTransformECC_3(long j6, long j7, long j8, int i5);

    private static native double findTransformECC_4(long j6, long j7, long j8);

    public static int meanShift(Mat mat, Rect rect, TermCriteria termCriteria) {
        double[] dArr = new double[4];
        int iMeanShift_0 = meanShift_0(mat.nativeObj, rect.f7686x, rect.f7687y, rect.width, rect.height, dArr, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        rect.f7686x = (int) dArr[0];
        rect.f7687y = (int) dArr[1];
        rect.width = (int) dArr[2];
        rect.height = (int) dArr[3];
        return iMeanShift_0;
    }

    private static native int meanShift_0(long j6, int i5, int i6, int i7, int i8, double[] dArr, int i9, int i10, double d);

    public static Mat readOpticalFlow(String str) {
        return new Mat(readOpticalFlow_0(str));
    }

    private static native long readOpticalFlow_0(String str);

    public static boolean writeOpticalFlow(String str, Mat mat) {
        return writeOpticalFlow_0(str, mat.nativeObj);
    }

    private static native boolean writeOpticalFlow_0(String str, long j6);

    public static void calcOpticalFlowPyrLK(Mat mat, Mat mat2, MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, MatOfByte matOfByte, MatOfFloat matOfFloat, Size size, int i5, TermCriteria termCriteria, int i6) {
        calcOpticalFlowPyrLK_1(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj, size.width, size.height, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i6);
    }

    public static double computeECC(Mat mat, Mat mat2) {
        return computeECC_1(mat.nativeObj, mat2.nativeObj);
    }

    public static BackgroundSubtractorKNN createBackgroundSubtractorKNN(int i5, double d) {
        return BackgroundSubtractorKNN.__fromPtr__(createBackgroundSubtractorKNN_1(i5, d));
    }

    public static BackgroundSubtractorMOG2 createBackgroundSubtractorMOG2(int i5, double d) {
        return BackgroundSubtractorMOG2.__fromPtr__(createBackgroundSubtractorMOG2_1(i5, d));
    }

    public static double findTransformECC(Mat mat, Mat mat2, Mat mat3, int i5, TermCriteria termCriteria, Mat mat4) {
        return findTransformECC_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, mat4.nativeObj);
    }

    public static void calcOpticalFlowPyrLK(Mat mat, Mat mat2, MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, MatOfByte matOfByte, MatOfFloat matOfFloat, Size size, int i5, TermCriteria termCriteria) {
        calcOpticalFlowPyrLK_2(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj, size.width, size.height, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public static BackgroundSubtractorKNN createBackgroundSubtractorKNN(int i5) {
        return BackgroundSubtractorKNN.__fromPtr__(createBackgroundSubtractorKNN_2(i5));
    }

    public static BackgroundSubtractorMOG2 createBackgroundSubtractorMOG2(int i5) {
        return BackgroundSubtractorMOG2.__fromPtr__(createBackgroundSubtractorMOG2_2(i5));
    }

    public static double findTransformECC(Mat mat, Mat mat2, Mat mat3, int i5, TermCriteria termCriteria) {
        return findTransformECC_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public static void calcOpticalFlowPyrLK(Mat mat, Mat mat2, MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, MatOfByte matOfByte, MatOfFloat matOfFloat, Size size, int i5) {
        calcOpticalFlowPyrLK_3(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj, size.width, size.height, i5);
    }

    public static BackgroundSubtractorKNN createBackgroundSubtractorKNN() {
        return BackgroundSubtractorKNN.__fromPtr__(createBackgroundSubtractorKNN_3());
    }

    public static BackgroundSubtractorMOG2 createBackgroundSubtractorMOG2() {
        return BackgroundSubtractorMOG2.__fromPtr__(createBackgroundSubtractorMOG2_3());
    }

    public static double findTransformECC(Mat mat, Mat mat2, Mat mat3, int i5) {
        return findTransformECC_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5);
    }

    public static int buildOpticalFlowPyramid(Mat mat, List<Mat> list, Size size, int i5, boolean z6, int i6, int i7) {
        Mat mat2 = new Mat();
        int iBuildOpticalFlowPyramid_1 = buildOpticalFlowPyramid_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, i5, z6, i6, i7);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
        return iBuildOpticalFlowPyramid_1;
    }

    public static void calcOpticalFlowPyrLK(Mat mat, Mat mat2, MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, MatOfByte matOfByte, MatOfFloat matOfFloat, Size size) {
        calcOpticalFlowPyrLK_4(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj, size.width, size.height);
    }

    public static double findTransformECC(Mat mat, Mat mat2, Mat mat3) {
        return findTransformECC_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void calcOpticalFlowPyrLK(Mat mat, Mat mat2, MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, MatOfByte matOfByte, MatOfFloat matOfFloat) {
        calcOpticalFlowPyrLK_5(mat.nativeObj, mat2.nativeObj, matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, matOfByte.nativeObj, matOfFloat.nativeObj);
    }

    public static int buildOpticalFlowPyramid(Mat mat, List<Mat> list, Size size, int i5, boolean z6, int i6) {
        Mat mat2 = new Mat();
        int iBuildOpticalFlowPyramid_2 = buildOpticalFlowPyramid_2(mat.nativeObj, mat2.nativeObj, size.width, size.height, i5, z6, i6);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
        return iBuildOpticalFlowPyramid_2;
    }

    public static int buildOpticalFlowPyramid(Mat mat, List<Mat> list, Size size, int i5, boolean z6) {
        Mat mat2 = new Mat();
        int iBuildOpticalFlowPyramid_3 = buildOpticalFlowPyramid_3(mat.nativeObj, mat2.nativeObj, size.width, size.height, i5, z6);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
        return iBuildOpticalFlowPyramid_3;
    }

    public static int buildOpticalFlowPyramid(Mat mat, List<Mat> list, Size size, int i5) {
        Mat mat2 = new Mat();
        int iBuildOpticalFlowPyramid_4 = buildOpticalFlowPyramid_4(mat.nativeObj, mat2.nativeObj, size.width, size.height, i5);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
        return iBuildOpticalFlowPyramid_4;
    }
}
