package org.opencv.objdetect;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.Scalar;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Objdetect {
    public static final int CASCADE_DO_CANNY_PRUNING = 1;
    public static final int CASCADE_DO_ROUGH_SEARCH = 8;
    public static final int CASCADE_FIND_BIGGEST_OBJECT = 4;
    public static final int CASCADE_SCALE_IMAGE = 2;
    public static final int CORNER_REFINE_APRILTAG = 3;
    public static final int CORNER_REFINE_CONTOUR = 2;
    public static final int CORNER_REFINE_NONE = 0;
    public static final int CORNER_REFINE_SUBPIX = 1;
    public static final int DICT_4X4_100 = 1;
    public static final int DICT_4X4_1000 = 3;
    public static final int DICT_4X4_250 = 2;
    public static final int DICT_4X4_50 = 0;
    public static final int DICT_5X5_100 = 5;
    public static final int DICT_5X5_1000 = 7;
    public static final int DICT_5X5_250 = 6;
    public static final int DICT_5X5_50 = 4;
    public static final int DICT_6X6_100 = 9;
    public static final int DICT_6X6_1000 = 11;
    public static final int DICT_6X6_250 = 10;
    public static final int DICT_6X6_50 = 8;
    public static final int DICT_7X7_100 = 13;
    public static final int DICT_7X7_1000 = 15;
    public static final int DICT_7X7_250 = 14;
    public static final int DICT_7X7_50 = 12;
    public static final int DICT_APRILTAG_16h5 = 17;
    public static final int DICT_APRILTAG_25h9 = 18;
    public static final int DICT_APRILTAG_36h10 = 19;
    public static final int DICT_APRILTAG_36h11 = 20;
    public static final int DICT_ARUCO_MIP_36h12 = 21;
    public static final int DICT_ARUCO_ORIGINAL = 16;
    public static final int DetectionBasedTracker_DETECTED = 1;
    public static final int DetectionBasedTracker_DETECTED_NOT_SHOWN_YET = 0;
    public static final int DetectionBasedTracker_DETECTED_TEMPORARY_LOST = 2;
    public static final int DetectionBasedTracker_WRONG_OBJECT = 3;

    public static void drawDetectedCornersCharuco(Mat mat, Mat mat2, Mat mat3, Scalar scalar) {
        long j6 = mat.nativeObj;
        long j7 = mat2.nativeObj;
        long j8 = mat3.nativeObj;
        double[] dArr = scalar.val;
        drawDetectedCornersCharuco_0(j6, j7, j8, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void drawDetectedCornersCharuco_0(long j6, long j7, long j8, double d, double d6, double d7, double d8);

    private static native void drawDetectedCornersCharuco_1(long j6, long j7, long j8);

    private static native void drawDetectedCornersCharuco_2(long j6, long j7);

    public static void drawDetectedDiamonds(Mat mat, List<Mat> list, Mat mat2, Scalar scalar) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        long j6 = mat.nativeObj;
        long j7 = matVector_Mat_to_Mat.nativeObj;
        long j8 = mat2.nativeObj;
        double[] dArr = scalar.val;
        drawDetectedDiamonds_0(j6, j7, j8, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void drawDetectedDiamonds_0(long j6, long j7, long j8, double d, double d6, double d7, double d8);

    private static native void drawDetectedDiamonds_1(long j6, long j7, long j8);

    private static native void drawDetectedDiamonds_2(long j6, long j7);

    public static void drawDetectedMarkers(Mat mat, List<Mat> list, Mat mat2, Scalar scalar) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        long j6 = mat.nativeObj;
        long j7 = matVector_Mat_to_Mat.nativeObj;
        long j8 = mat2.nativeObj;
        double[] dArr = scalar.val;
        drawDetectedMarkers_0(j6, j7, j8, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void drawDetectedMarkers_0(long j6, long j7, long j8, double d, double d6, double d7, double d8);

    private static native void drawDetectedMarkers_1(long j6, long j7, long j8);

    private static native void drawDetectedMarkers_2(long j6, long j7);

    public static Dictionary extendDictionary(int i5, int i6, Dictionary dictionary, int i7) {
        return new Dictionary(extendDictionary_0(i5, i6, dictionary.nativeObj, i7));
    }

    private static native long extendDictionary_0(int i5, int i6, long j6, int i7);

    private static native long extendDictionary_1(int i5, int i6, long j6);

    private static native long extendDictionary_2(int i5, int i6);

    public static void generateImageMarker(Dictionary dictionary, int i5, int i6, Mat mat, int i7) {
        generateImageMarker_0(dictionary.nativeObj, i5, i6, mat.nativeObj, i7);
    }

    private static native void generateImageMarker_0(long j6, int i5, int i6, long j7, int i7);

    private static native void generateImageMarker_1(long j6, int i5, int i6, long j7);

    public static Dictionary getPredefinedDictionary(int i5) {
        return new Dictionary(getPredefinedDictionary_0(i5));
    }

    private static native long getPredefinedDictionary_0(int i5);

    public static void groupRectangles(MatOfRect matOfRect, MatOfInt matOfInt, int i5, double d) {
        groupRectangles_0(matOfRect.nativeObj, matOfInt.nativeObj, i5, d);
    }

    private static native void groupRectangles_0(long j6, long j7, int i5, double d);

    private static native void groupRectangles_1(long j6, long j7, int i5);

    public static void drawDetectedCornersCharuco(Mat mat, Mat mat2, Mat mat3) {
        drawDetectedCornersCharuco_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static Dictionary extendDictionary(int i5, int i6, Dictionary dictionary) {
        return new Dictionary(extendDictionary_1(i5, i6, dictionary.nativeObj));
    }

    public static void generateImageMarker(Dictionary dictionary, int i5, int i6, Mat mat) {
        generateImageMarker_1(dictionary.nativeObj, i5, i6, mat.nativeObj);
    }

    public static void groupRectangles(MatOfRect matOfRect, MatOfInt matOfInt, int i5) {
        groupRectangles_1(matOfRect.nativeObj, matOfInt.nativeObj, i5);
    }

    public static void drawDetectedCornersCharuco(Mat mat, Mat mat2) {
        drawDetectedCornersCharuco_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void drawDetectedDiamonds(Mat mat, List<Mat> list, Mat mat2) {
        drawDetectedDiamonds_1(mat.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat2.nativeObj);
    }

    public static void drawDetectedMarkers(Mat mat, List<Mat> list, Mat mat2) {
        drawDetectedMarkers_1(mat.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat2.nativeObj);
    }

    public static Dictionary extendDictionary(int i5, int i6) {
        return new Dictionary(extendDictionary_2(i5, i6));
    }

    public static void drawDetectedDiamonds(Mat mat, List<Mat> list) {
        drawDetectedDiamonds_2(mat.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj);
    }

    public static void drawDetectedMarkers(Mat mat, List<Mat> list) {
        drawDetectedMarkers_2(mat.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj);
    }
}
