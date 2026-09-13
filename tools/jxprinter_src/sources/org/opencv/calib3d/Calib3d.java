package org.opencv.calib3d;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint3f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Calib3d {
    public static final int CALIB_CB_ACCURACY = 32;
    public static final int CALIB_CB_ADAPTIVE_THRESH = 1;
    public static final int CALIB_CB_ASYMMETRIC_GRID = 2;
    public static final int CALIB_CB_CLUSTERING = 4;
    public static final int CALIB_CB_EXHAUSTIVE = 16;
    public static final int CALIB_CB_FAST_CHECK = 8;
    public static final int CALIB_CB_FILTER_QUADS = 4;
    public static final int CALIB_CB_LARGER = 64;
    public static final int CALIB_CB_MARKER = 128;
    public static final int CALIB_CB_NORMALIZE_IMAGE = 2;
    public static final int CALIB_CB_SYMMETRIC_GRID = 1;
    public static final int CALIB_FIX_ASPECT_RATIO = 2;
    public static final int CALIB_FIX_FOCAL_LENGTH = 16;
    public static final int CALIB_FIX_INTRINSIC = 256;
    public static final int CALIB_FIX_K1 = 32;
    public static final int CALIB_FIX_K2 = 64;
    public static final int CALIB_FIX_K3 = 128;
    public static final int CALIB_FIX_K4 = 2048;
    public static final int CALIB_FIX_K5 = 4096;
    public static final int CALIB_FIX_K6 = 8192;
    public static final int CALIB_FIX_PRINCIPAL_POINT = 4;
    public static final int CALIB_FIX_S1_S2_S3_S4 = 65536;
    public static final int CALIB_FIX_TANGENT_DIST = 2097152;
    public static final int CALIB_FIX_TAUX_TAUY = 524288;
    public static final int CALIB_HAND_EYE_ANDREFF = 3;
    public static final int CALIB_HAND_EYE_DANIILIDIS = 4;
    public static final int CALIB_HAND_EYE_HORAUD = 2;
    public static final int CALIB_HAND_EYE_PARK = 1;
    public static final int CALIB_HAND_EYE_TSAI = 0;
    public static final int CALIB_NINTRINSIC = 18;
    public static final int CALIB_RATIONAL_MODEL = 16384;
    public static final int CALIB_ROBOT_WORLD_HAND_EYE_LI = 1;
    public static final int CALIB_ROBOT_WORLD_HAND_EYE_SHAH = 0;
    public static final int CALIB_SAME_FOCAL_LENGTH = 512;
    public static final int CALIB_THIN_PRISM_MODEL = 32768;
    public static final int CALIB_TILTED_MODEL = 262144;
    public static final int CALIB_USE_EXTRINSIC_GUESS = 4194304;
    public static final int CALIB_USE_INTRINSIC_GUESS = 1;
    public static final int CALIB_USE_LU = 131072;
    public static final int CALIB_USE_QR = 1048576;
    public static final int CALIB_ZERO_DISPARITY = 1024;
    public static final int CALIB_ZERO_TANGENT_DIST = 8;
    public static final int COV_POLISHER = 3;
    public static final int CV_DLS = 3;
    public static final int CV_EPNP = 1;
    public static final int CV_ITERATIVE = 0;
    public static final int CV_P3P = 2;
    public static final int CirclesGridFinderParameters_ASYMMETRIC_GRID = 1;
    public static final int CirclesGridFinderParameters_SYMMETRIC_GRID = 0;
    public static final int CvLevMarq_CALC_J = 2;
    public static final int CvLevMarq_CHECK_ERR = 3;
    public static final int CvLevMarq_DONE = 0;
    public static final int CvLevMarq_STARTED = 1;
    public static final int FM_7POINT = 1;
    public static final int FM_8POINT = 2;
    public static final int FM_LMEDS = 4;
    public static final int FM_RANSAC = 8;
    public static final int LMEDS = 4;
    public static final int LOCAL_OPTIM_GC = 3;
    public static final int LOCAL_OPTIM_INNER_AND_ITER_LO = 2;
    public static final int LOCAL_OPTIM_INNER_LO = 1;
    public static final int LOCAL_OPTIM_NULL = 0;
    public static final int LOCAL_OPTIM_SIGMA = 4;
    public static final int LSQ_POLISHER = 1;
    public static final int MAGSAC = 2;
    public static final int NEIGH_FLANN_KNN = 0;
    public static final int NEIGH_FLANN_RADIUS = 2;
    public static final int NEIGH_GRID = 1;
    public static final int NONE_POLISHER = 0;
    public static final int PROJ_SPHERICAL_EQRECT = 1;
    public static final int PROJ_SPHERICAL_ORTHO = 0;
    public static final int RANSAC = 8;
    public static final int RHO = 16;
    public static final int SAMPLING_NAPSAC = 2;
    public static final int SAMPLING_PROGRESSIVE_NAPSAC = 1;
    public static final int SAMPLING_PROSAC = 3;
    public static final int SAMPLING_UNIFORM = 0;
    public static final int SCORE_METHOD_LMEDS = 3;
    public static final int SCORE_METHOD_MAGSAC = 2;
    public static final int SCORE_METHOD_MSAC = 1;
    public static final int SCORE_METHOD_RANSAC = 0;
    public static final int SOLVEPNP_AP3P = 5;
    public static final int SOLVEPNP_DLS = 3;
    public static final int SOLVEPNP_EPNP = 1;
    public static final int SOLVEPNP_IPPE = 6;
    public static final int SOLVEPNP_IPPE_SQUARE = 7;
    public static final int SOLVEPNP_ITERATIVE = 0;
    public static final int SOLVEPNP_MAX_COUNT = 9;
    public static final int SOLVEPNP_P3P = 2;
    public static final int SOLVEPNP_SQPNP = 8;
    public static final int SOLVEPNP_UPNP = 4;
    public static final int USAC_ACCURATE = 36;
    public static final int USAC_DEFAULT = 32;
    public static final int USAC_FAST = 35;
    public static final int USAC_FM_8PTS = 34;
    public static final int USAC_MAGSAC = 38;
    public static final int USAC_PARALLEL = 33;
    public static final int USAC_PROSAC = 37;
    public static final int fisheye_CALIB_CHECK_COND = 4;
    public static final int fisheye_CALIB_FIX_FOCAL_LENGTH = 2048;
    public static final int fisheye_CALIB_FIX_INTRINSIC = 256;
    public static final int fisheye_CALIB_FIX_K1 = 16;
    public static final int fisheye_CALIB_FIX_K2 = 32;
    public static final int fisheye_CALIB_FIX_K3 = 64;
    public static final int fisheye_CALIB_FIX_K4 = 128;
    public static final int fisheye_CALIB_FIX_PRINCIPAL_POINT = 512;
    public static final int fisheye_CALIB_FIX_SKEW = 8;
    public static final int fisheye_CALIB_RECOMPUTE_EXTRINSIC = 2;
    public static final int fisheye_CALIB_USE_INTRINSIC_GUESS = 1;
    public static final int fisheye_CALIB_ZERO_DISPARITY = 1024;

    public static double[] RQDecomp3x3(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        return RQDecomp3x3_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    private static native double[] RQDecomp3x3_0(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native double[] RQDecomp3x3_1(long j6, long j7, long j8, long j9, long j10);

    private static native double[] RQDecomp3x3_2(long j6, long j7, long j8, long j9);

    private static native double[] RQDecomp3x3_3(long j6, long j7, long j8);

    public static void Rodrigues(Mat mat, Mat mat2, Mat mat3) {
        Rodrigues_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void Rodrigues_0(long j6, long j7, long j8);

    private static native void Rodrigues_1(long j6, long j7);

    public static double calibrateCamera(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, int i5, TermCriteria termCriteria) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        double dCalibrateCamera_0 = calibrateCamera_0(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        AbstractC1125a.p(mat3, list3, mat4, list4);
        return dCalibrateCamera_0;
    }

    public static double calibrateCameraExtended(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3, Mat mat4, Mat mat5, int i5, TermCriteria termCriteria) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat6 = new Mat();
        Mat mat7 = new Mat();
        double dCalibrateCameraExtended_0 = calibrateCameraExtended_0(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat6.nativeObj, mat7.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        AbstractC1125a.p(mat6, list3, mat7, list4);
        return dCalibrateCameraExtended_0;
    }

    private static native double calibrateCameraExtended_0(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i5, int i6, int i7, double d7);

    private static native double calibrateCameraExtended_1(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i5);

    private static native double calibrateCameraExtended_2(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11, long j12, long j13, long j14);

    public static double calibrateCameraRO(List<Mat> list, List<Mat> list2, Size size, int i5, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3, int i6, TermCriteria termCriteria) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        double dCalibrateCameraRO_0 = calibrateCameraRO_0(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, i5, mat.nativeObj, mat2.nativeObj, mat4.nativeObj, mat5.nativeObj, mat3.nativeObj, i6, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        AbstractC1125a.p(mat4, list3, mat5, list4);
        return dCalibrateCameraRO_0;
    }

    public static double calibrateCameraROExtended(List<Mat> list, List<Mat> list2, Size size, int i5, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, int i6, TermCriteria termCriteria) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat8 = new Mat();
        Mat mat9 = new Mat();
        double dCalibrateCameraROExtended_0 = calibrateCameraROExtended_0(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, i5, mat.nativeObj, mat2.nativeObj, mat8.nativeObj, mat9.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, i6, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        AbstractC1125a.p(mat8, list3, mat9, list4);
        return dCalibrateCameraROExtended_0;
    }

    private static native double calibrateCameraROExtended_0(long j6, long j7, double d, double d6, int i5, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i6, int i7, int i8, double d7);

    private static native double calibrateCameraROExtended_1(long j6, long j7, double d, double d6, int i5, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i6);

    private static native double calibrateCameraROExtended_2(long j6, long j7, double d, double d6, int i5, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16);

    private static native double calibrateCameraRO_0(long j6, long j7, double d, double d6, int i5, long j8, long j9, long j10, long j11, long j12, int i6, int i7, int i8, double d7);

    private static native double calibrateCameraRO_1(long j6, long j7, double d, double d6, int i5, long j8, long j9, long j10, long j11, long j12, int i6);

    private static native double calibrateCameraRO_2(long j6, long j7, double d, double d6, int i5, long j8, long j9, long j10, long j11, long j12);

    private static native double calibrateCamera_0(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11, int i5, int i6, int i7, double d7);

    private static native double calibrateCamera_1(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11, int i5);

    private static native double calibrateCamera_2(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11);

    public static void calibrateHandEye(List<Mat> list, List<Mat> list2, List<Mat> list3, List<Mat> list4, Mat mat, Mat mat2, int i5) {
        calibrateHandEye_0(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, Converters.vector_Mat_to_Mat(list4).nativeObj, mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native void calibrateHandEye_0(long j6, long j7, long j8, long j9, long j10, long j11, int i5);

    private static native void calibrateHandEye_1(long j6, long j7, long j8, long j9, long j10, long j11);

    public static void calibrateRobotWorldHandEye(List<Mat> list, List<Mat> list2, List<Mat> list3, List<Mat> list4, Mat mat, Mat mat2, Mat mat3, Mat mat4, int i5) {
        calibrateRobotWorldHandEye_0(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, Converters.vector_Mat_to_Mat(list4).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5);
    }

    private static native void calibrateRobotWorldHandEye_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i5);

    private static native void calibrateRobotWorldHandEye_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13);

    public static void calibrationMatrixValues(Mat mat, Size size, double d, double d6, double[] dArr, double[] dArr2, double[] dArr3, Point point, double[] dArr4) {
        double[] dArr5 = new double[1];
        double[] dArr6 = new double[1];
        double[] dArr7 = new double[1];
        double[] dArr8 = new double[2];
        double[] dArr9 = new double[1];
        calibrationMatrixValues_0(mat.nativeObj, size.width, size.height, d, d6, dArr5, dArr6, dArr7, dArr8, dArr9);
        if (dArr != null) {
            dArr[0] = dArr5[0];
        }
        if (dArr2 != null) {
            dArr2[0] = dArr6[0];
        }
        if (dArr3 != null) {
            dArr3[0] = dArr7[0];
        }
        if (point != null) {
            point.f7681x = dArr8[0];
            point.f7682y = dArr8[1];
        }
        if (dArr4 != null) {
            dArr4[0] = dArr9[0];
        }
    }

    private static native void calibrationMatrixValues_0(long j6, double d, double d6, double d7, double d8, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5);

    public static boolean checkChessboard(Mat mat, Size size) {
        return checkChessboard_0(mat.nativeObj, size.width, size.height);
    }

    private static native boolean checkChessboard_0(long j6, double d, double d6);

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, Mat mat12, Mat mat13, Mat mat14) {
        composeRT_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, mat12.nativeObj, mat13.nativeObj, mat14.nativeObj);
    }

    private static native void composeRT_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19);

    private static native void composeRT_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18);

    private static native void composeRT_2(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17);

    private static native void composeRT_3(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16);

    private static native void composeRT_4(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15);

    private static native void composeRT_5(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14);

    private static native void composeRT_6(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13);

    private static native void composeRT_7(long j6, long j7, long j8, long j9, long j10, long j11, long j12);

    private static native void composeRT_8(long j6, long j7, long j8, long j9, long j10, long j11);

    public static void computeCorrespondEpilines(Mat mat, int i5, Mat mat2, Mat mat3) {
        computeCorrespondEpilines_0(mat.nativeObj, i5, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void computeCorrespondEpilines_0(long j6, int i5, long j7, long j8);

    public static void convertPointsFromHomogeneous(Mat mat, Mat mat2) {
        convertPointsFromHomogeneous_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void convertPointsFromHomogeneous_0(long j6, long j7);

    public static void convertPointsToHomogeneous(Mat mat, Mat mat2) {
        convertPointsToHomogeneous_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void convertPointsToHomogeneous_0(long j6, long j7);

    public static void correctMatches(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        correctMatches_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    private static native void correctMatches_0(long j6, long j7, long j8, long j9, long j10);

    public static void decomposeEssentialMat(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        decomposeEssentialMat_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void decomposeEssentialMat_0(long j6, long j7, long j8, long j9);

    public static int decomposeHomographyMat(Mat mat, Mat mat2, List<Mat> list, List<Mat> list2, List<Mat> list3) {
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        int iDecomposeHomographyMat_0 = decomposeHomographyMat_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
        AbstractC1125a.p(mat3, list, mat4, list2);
        Converters.Mat_to_vector_Mat(mat5, list3);
        mat5.release();
        return iDecomposeHomographyMat_0;
    }

    private static native int decomposeHomographyMat_0(long j6, long j7, long j8, long j9, long j10);

    public static void decomposeProjectionMatrix(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8) {
        decomposeProjectionMatrix_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj);
    }

    private static native void decomposeProjectionMatrix_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13);

    private static native void decomposeProjectionMatrix_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12);

    private static native void decomposeProjectionMatrix_2(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void decomposeProjectionMatrix_3(long j6, long j7, long j8, long j9, long j10);

    private static native void decomposeProjectionMatrix_4(long j6, long j7, long j8, long j9);

    public static void drawChessboardCorners(Mat mat, Size size, MatOfPoint2f matOfPoint2f, boolean z6) {
        drawChessboardCorners_0(mat.nativeObj, size.width, size.height, matOfPoint2f.nativeObj, z6);
    }

    private static native void drawChessboardCorners_0(long j6, double d, double d6, long j7, boolean z6);

    public static void drawFrameAxes(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, float f6, int i5) {
        drawFrameAxes_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, f6, i5);
    }

    private static native void drawFrameAxes_0(long j6, long j7, long j8, long j9, long j10, float f6, int i5);

    private static native void drawFrameAxes_1(long j6, long j7, long j8, long j9, long j10, float f6);

    public static Mat estimateAffine2D(Mat mat, Mat mat2, Mat mat3, int i5, double d, long j6, double d6, long j7) {
        return new Mat(estimateAffine2D_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, j6, d6, j7));
    }

    private static native long estimateAffine2D_0(long j6, long j7, long j8, int i5, double d, long j9, double d6, long j10);

    private static native long estimateAffine2D_1(long j6, long j7, long j8, int i5, double d, long j9, double d6);

    private static native long estimateAffine2D_2(long j6, long j7, long j8, int i5, double d, long j9);

    private static native long estimateAffine2D_3(long j6, long j7, long j8, int i5, double d);

    private static native long estimateAffine2D_4(long j6, long j7, long j8, int i5);

    private static native long estimateAffine2D_5(long j6, long j7, long j8);

    private static native long estimateAffine2D_6(long j6, long j7);

    private static native long estimateAffine2D_7(long j6, long j7, long j8, long j9);

    public static int estimateAffine3D(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d, double d6) {
        return estimateAffine3D_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, d, d6);
    }

    private static native int estimateAffine3D_0(long j6, long j7, long j8, long j9, double d, double d6);

    private static native int estimateAffine3D_1(long j6, long j7, long j8, long j9, double d);

    private static native int estimateAffine3D_2(long j6, long j7, long j8, long j9);

    private static native long estimateAffine3D_3(long j6, long j7, double[] dArr, boolean z6);

    private static native long estimateAffine3D_4(long j6, long j7, double[] dArr);

    private static native long estimateAffine3D_5(long j6, long j7);

    public static Mat estimateAffinePartial2D(Mat mat, Mat mat2, Mat mat3, int i5, double d, long j6, double d6, long j7) {
        return new Mat(estimateAffinePartial2D_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, j6, d6, j7));
    }

    private static native long estimateAffinePartial2D_0(long j6, long j7, long j8, int i5, double d, long j9, double d6, long j10);

    private static native long estimateAffinePartial2D_1(long j6, long j7, long j8, int i5, double d, long j9, double d6);

    private static native long estimateAffinePartial2D_2(long j6, long j7, long j8, int i5, double d, long j9);

    private static native long estimateAffinePartial2D_3(long j6, long j7, long j8, int i5, double d);

    private static native long estimateAffinePartial2D_4(long j6, long j7, long j8, int i5);

    private static native long estimateAffinePartial2D_5(long j6, long j7, long j8);

    private static native long estimateAffinePartial2D_6(long j6, long j7);

    public static Scalar estimateChessboardSharpness(Mat mat, Size size, Mat mat2, float f6, boolean z6, Mat mat3) {
        return new Scalar(estimateChessboardSharpness_0(mat.nativeObj, size.width, size.height, mat2.nativeObj, f6, z6, mat3.nativeObj));
    }

    private static native double[] estimateChessboardSharpness_0(long j6, double d, double d6, long j7, float f6, boolean z6, long j8);

    private static native double[] estimateChessboardSharpness_1(long j6, double d, double d6, long j7, float f6, boolean z6);

    private static native double[] estimateChessboardSharpness_2(long j6, double d, double d6, long j7, float f6);

    private static native double[] estimateChessboardSharpness_3(long j6, double d, double d6, long j7);

    public static int estimateTranslation3D(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d, double d6) {
        return estimateTranslation3D_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, d, d6);
    }

    private static native int estimateTranslation3D_0(long j6, long j7, long j8, long j9, double d, double d6);

    private static native int estimateTranslation3D_1(long j6, long j7, long j8, long j9, double d);

    private static native int estimateTranslation3D_2(long j6, long j7, long j8, long j9);

    public static void filterHomographyDecompByVisibleRefpoints(List<Mat> list, List<Mat> list2, Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        filterHomographyDecompByVisibleRefpoints_0(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void filterHomographyDecompByVisibleRefpoints_0(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void filterHomographyDecompByVisibleRefpoints_1(long j6, long j7, long j8, long j9, long j10);

    public static void filterSpeckles(Mat mat, double d, int i5, double d6, Mat mat2) {
        filterSpeckles_0(mat.nativeObj, d, i5, d6, mat2.nativeObj);
    }

    private static native void filterSpeckles_0(long j6, double d, int i5, double d6, long j7);

    private static native void filterSpeckles_1(long j6, double d, int i5, double d6);

    public static boolean find4QuadCornerSubpix(Mat mat, Mat mat2, Size size) {
        return find4QuadCornerSubpix_0(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    private static native boolean find4QuadCornerSubpix_0(long j6, long j7, double d, double d6);

    public static boolean findChessboardCorners(Mat mat, Size size, MatOfPoint2f matOfPoint2f, int i5) {
        return findChessboardCorners_0(mat.nativeObj, size.width, size.height, matOfPoint2f.nativeObj, i5);
    }

    public static boolean findChessboardCornersSB(Mat mat, Size size, Mat mat2, int i5) {
        return findChessboardCornersSB_0(mat.nativeObj, size.width, size.height, mat2.nativeObj, i5);
    }

    public static boolean findChessboardCornersSBWithMeta(Mat mat, Size size, Mat mat2, int i5, Mat mat3) {
        return findChessboardCornersSBWithMeta_0(mat.nativeObj, size.width, size.height, mat2.nativeObj, i5, mat3.nativeObj);
    }

    private static native boolean findChessboardCornersSBWithMeta_0(long j6, double d, double d6, long j7, int i5, long j8);

    private static native boolean findChessboardCornersSB_0(long j6, double d, double d6, long j7, int i5);

    private static native boolean findChessboardCornersSB_1(long j6, double d, double d6, long j7);

    private static native boolean findChessboardCorners_0(long j6, double d, double d6, long j7, int i5);

    private static native boolean findChessboardCorners_1(long j6, double d, double d6, long j7);

    public static boolean findCirclesGrid(Mat mat, Size size, Mat mat2, int i5) {
        return findCirclesGrid_0(mat.nativeObj, size.width, size.height, mat2.nativeObj, i5);
    }

    private static native boolean findCirclesGrid_0(long j6, double d, double d6, long j7, int i5);

    private static native boolean findCirclesGrid_2(long j6, double d, double d6, long j7);

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, int i5, double d, double d6, int i6, Mat mat4) {
        return new Mat(findEssentialMat_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, d6, i6, mat4.nativeObj));
    }

    private static native long findEssentialMat_0(long j6, long j7, long j8, int i5, double d, double d6, int i6, long j9);

    private static native long findEssentialMat_1(long j6, long j7, long j8, int i5, double d, double d6, int i6);

    private static native long findEssentialMat_10(long j6, long j7, double d, double d6, double d7, int i5);

    private static native long findEssentialMat_11(long j6, long j7, double d, double d6, double d7);

    private static native long findEssentialMat_12(long j6, long j7, double d);

    private static native long findEssentialMat_13(long j6, long j7);

    private static native long findEssentialMat_14(long j6, long j7, long j8, long j9, long j10, long j11, int i5, double d, double d6, long j12);

    private static native long findEssentialMat_15(long j6, long j7, long j8, long j9, long j10, long j11, int i5, double d, double d6);

    private static native long findEssentialMat_16(long j6, long j7, long j8, long j9, long j10, long j11, int i5, double d);

    private static native long findEssentialMat_17(long j6, long j7, long j8, long j9, long j10, long j11, int i5);

    private static native long findEssentialMat_18(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native long findEssentialMat_19(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13);

    private static native long findEssentialMat_2(long j6, long j7, long j8, int i5, double d, double d6);

    private static native long findEssentialMat_3(long j6, long j7, long j8, int i5, double d);

    private static native long findEssentialMat_4(long j6, long j7, long j8, int i5);

    private static native long findEssentialMat_5(long j6, long j7, long j8);

    private static native long findEssentialMat_6(long j6, long j7, double d, double d6, double d7, int i5, double d8, double d9, int i6, long j8);

    private static native long findEssentialMat_7(long j6, long j7, double d, double d6, double d7, int i5, double d8, double d9, int i6);

    private static native long findEssentialMat_8(long j6, long j7, double d, double d6, double d7, int i5, double d8, double d9);

    private static native long findEssentialMat_9(long j6, long j7, double d, double d6, double d7, int i5, double d8);

    public static Mat findFundamentalMat(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d, double d6, int i6, Mat mat) {
        return new Mat(findFundamentalMat_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d, d6, i6, mat.nativeObj));
    }

    private static native long findFundamentalMat_0(long j6, long j7, int i5, double d, double d6, int i6, long j8);

    private static native long findFundamentalMat_1(long j6, long j7, int i5, double d, double d6, int i6);

    private static native long findFundamentalMat_2(long j6, long j7, int i5, double d, double d6, long j8);

    private static native long findFundamentalMat_3(long j6, long j7, int i5, double d, double d6);

    private static native long findFundamentalMat_4(long j6, long j7, int i5, double d);

    private static native long findFundamentalMat_5(long j6, long j7, int i5);

    private static native long findFundamentalMat_6(long j6, long j7);

    private static native long findFundamentalMat_7(long j6, long j7, long j8, long j9);

    public static Mat findHomography(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d, Mat mat, int i6, double d6) {
        return new Mat(findHomography_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d, mat.nativeObj, i6, d6));
    }

    private static native long findHomography_0(long j6, long j7, int i5, double d, long j8, int i6, double d6);

    private static native long findHomography_1(long j6, long j7, int i5, double d, long j8, int i6);

    private static native long findHomography_2(long j6, long j7, int i5, double d, long j8);

    private static native long findHomography_3(long j6, long j7, int i5, double d);

    private static native long findHomography_4(long j6, long j7, int i5);

    private static native long findHomography_5(long j6, long j7);

    private static native long findHomography_6(long j6, long j7, long j8, long j9);

    public static double fisheye_calibrate(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, int i5, TermCriteria termCriteria) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        double dFisheye_calibrate_0 = fisheye_calibrate_0(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        AbstractC1125a.p(mat3, list3, mat4, list4);
        return dFisheye_calibrate_0;
    }

    private static native double fisheye_calibrate_0(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11, int i5, int i6, int i7, double d7);

    private static native double fisheye_calibrate_1(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11, int i5);

    private static native double fisheye_calibrate_2(long j6, long j7, double d, double d6, long j8, long j9, long j10, long j11);

    public static void fisheye_distortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d) {
        fisheye_distortPoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, d);
    }

    private static native void fisheye_distortPoints_0(long j6, long j7, long j8, long j9, double d);

    private static native void fisheye_distortPoints_1(long j6, long j7, long j8, long j9);

    public static void fisheye_estimateNewCameraMatrixForUndistortRectify(Mat mat, Mat mat2, Size size, Mat mat3, Mat mat4, double d, Size size2, double d6) {
        fisheye_estimateNewCameraMatrixForUndistortRectify_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, mat3.nativeObj, mat4.nativeObj, d, size2.width, size2.height, d6);
    }

    private static native void fisheye_estimateNewCameraMatrixForUndistortRectify_0(long j6, long j7, double d, double d6, long j8, long j9, double d7, double d8, double d9, double d10);

    private static native void fisheye_estimateNewCameraMatrixForUndistortRectify_1(long j6, long j7, double d, double d6, long j8, long j9, double d7, double d8, double d9);

    private static native void fisheye_estimateNewCameraMatrixForUndistortRectify_2(long j6, long j7, double d, double d6, long j8, long j9, double d7);

    private static native void fisheye_estimateNewCameraMatrixForUndistortRectify_3(long j6, long j7, double d, double d6, long j8, long j9);

    public static void fisheye_initUndistortRectifyMap(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, int i5, Mat mat5, Mat mat6) {
        fisheye_initUndistortRectifyMap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, i5, mat5.nativeObj, mat6.nativeObj);
    }

    private static native void fisheye_initUndistortRectifyMap_0(long j6, long j7, long j8, long j9, double d, double d6, int i5, long j10, long j11);

    public static void fisheye_projectPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d, Mat mat7) {
        fisheye_projectPoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, d, mat7.nativeObj);
    }

    private static native void fisheye_projectPoints_0(long j6, long j7, long j8, long j9, long j10, long j11, double d, long j12);

    private static native void fisheye_projectPoints_1(long j6, long j7, long j8, long j9, long j10, long j11, double d);

    private static native void fisheye_projectPoints_2(long j6, long j7, long j8, long j9, long j10, long j11);

    public static double fisheye_stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, List<Mat> list4, List<Mat> list5, int i5, TermCriteria termCriteria) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat matVector_Mat_to_Mat3 = Converters.vector_Mat_to_Mat(list3);
        Mat mat7 = new Mat();
        Mat mat8 = new Mat();
        double dFisheye_stereoCalibrate_0 = fisheye_stereoCalibrate_0(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, matVector_Mat_to_Mat3.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        AbstractC1125a.p(mat7, list4, mat8, list5);
        return dFisheye_stereoCalibrate_0;
    }

    private static native double fisheye_stereoCalibrate_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, int i5, int i6, int i7, double d7);

    private static native double fisheye_stereoCalibrate_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, int i5);

    private static native double fisheye_stereoCalibrate_2(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16);

    private static native double fisheye_stereoCalibrate_3(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, int i5, int i6, int i7, double d7);

    private static native double fisheye_stereoCalibrate_4(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, int i5);

    private static native double fisheye_stereoCalibrate_5(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14);

    public static void fisheye_stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5, Size size2, double d, double d6) {
        fisheye_stereoRectify_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5, size2.width, size2.height, d, d6);
    }

    private static native void fisheye_stereoRectify_0(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5, double d7, double d8, double d9, double d10);

    private static native void fisheye_stereoRectify_1(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5, double d7, double d8, double d9);

    private static native void fisheye_stereoRectify_2(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5, double d7, double d8);

    private static native void fisheye_stereoRectify_3(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5);

    public static void fisheye_undistortImage(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Size size) {
        fisheye_undistortImage_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, size.width, size.height);
    }

    private static native void fisheye_undistortImage_0(long j6, long j7, long j8, long j9, long j10, double d, double d6);

    private static native void fisheye_undistortImage_1(long j6, long j7, long j8, long j9, long j10);

    private static native void fisheye_undistortImage_2(long j6, long j7, long j8, long j9);

    public static void fisheye_undistortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, TermCriteria termCriteria) {
        fisheye_undistortPoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    private static native void fisheye_undistortPoints_0(long j6, long j7, long j8, long j9, long j10, long j11, int i5, int i6, double d);

    private static native void fisheye_undistortPoints_1(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void fisheye_undistortPoints_2(long j6, long j7, long j8, long j9, long j10);

    private static native void fisheye_undistortPoints_3(long j6, long j7, long j8, long j9);

    public static Mat getDefaultNewCameraMatrix(Mat mat, Size size, boolean z6) {
        return new Mat(getDefaultNewCameraMatrix_0(mat.nativeObj, size.width, size.height, z6));
    }

    private static native long getDefaultNewCameraMatrix_0(long j6, double d, double d6, boolean z6);

    private static native long getDefaultNewCameraMatrix_1(long j6, double d, double d6);

    private static native long getDefaultNewCameraMatrix_2(long j6);

    public static Mat getOptimalNewCameraMatrix(Mat mat, Mat mat2, Size size, double d, Size size2, Rect rect, boolean z6) {
        double[] dArr = new double[4];
        Mat mat3 = new Mat(getOptimalNewCameraMatrix_0(mat.nativeObj, mat2.nativeObj, size.width, size.height, d, size2.width, size2.height, dArr, z6));
        if (rect != null) {
            rect.f7686x = (int) dArr[0];
            rect.f7687y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        return mat3;
    }

    private static native long getOptimalNewCameraMatrix_0(long j6, long j7, double d, double d6, double d7, double d8, double d9, double[] dArr, boolean z6);

    private static native long getOptimalNewCameraMatrix_1(long j6, long j7, double d, double d6, double d7, double d8, double d9, double[] dArr);

    private static native long getOptimalNewCameraMatrix_2(long j6, long j7, double d, double d6, double d7, double d8, double d9);

    private static native long getOptimalNewCameraMatrix_3(long j6, long j7, double d, double d6, double d7);

    public static Rect getValidDisparityROI(Rect rect, Rect rect2, int i5, int i6, int i7) {
        return new Rect(getValidDisparityROI_0(rect.f7686x, rect.f7687y, rect.width, rect.height, rect2.f7686x, rect2.f7687y, rect2.width, rect2.height, i5, i6, i7));
    }

    private static native double[] getValidDisparityROI_0(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15);

    public static Mat initCameraMatrix2D(List<MatOfPoint3f> list, List<MatOfPoint2f> list2, Size size, double d) {
        return new Mat(initCameraMatrix2D_0(Converters.vector_vector_Point3f_to_Mat(list, new ArrayList(list != null ? list.size() : 0)).nativeObj, Converters.vector_vector_Point2f_to_Mat(list2, new ArrayList(list2 != null ? list2.size() : 0)).nativeObj, size.width, size.height, d));
    }

    private static native long initCameraMatrix2D_0(long j6, long j7, double d, double d6, double d7);

    private static native long initCameraMatrix2D_1(long j6, long j7, double d, double d6);

    public static void initInverseRectificationMap(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, int i5, Mat mat5, Mat mat6) {
        initInverseRectificationMap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, i5, mat5.nativeObj, mat6.nativeObj);
    }

    private static native void initInverseRectificationMap_0(long j6, long j7, long j8, long j9, double d, double d6, int i5, long j10, long j11);

    public static void initUndistortRectifyMap(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, int i5, Mat mat5, Mat mat6) {
        initUndistortRectifyMap_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, i5, mat5.nativeObj, mat6.nativeObj);
    }

    private static native void initUndistortRectifyMap_0(long j6, long j7, long j8, long j9, double d, double d6, int i5, long j10, long j11);

    public static void matMulDeriv(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        matMulDeriv_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void matMulDeriv_0(long j6, long j7, long j8, long j9);

    public static void projectPoints(MatOfPoint3f matOfPoint3f, Mat mat, Mat mat2, Mat mat3, MatOfDouble matOfDouble, MatOfPoint2f matOfPoint2f, Mat mat4, double d) {
        projectPoints_0(matOfPoint3f.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, matOfDouble.nativeObj, matOfPoint2f.nativeObj, mat4.nativeObj, d);
    }

    private static native void projectPoints_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d);

    private static native void projectPoints_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12);

    private static native void projectPoints_2(long j6, long j7, long j8, long j9, long j10, long j11);

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, int i5, double d, double d6, Mat mat10) {
        return recoverPose_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, i5, d, d6, mat10.nativeObj);
    }

    private static native int recoverPose_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i5, double d, double d6, long j15);

    private static native int recoverPose_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i5, double d, double d6);

    private static native int recoverPose_10(long j6, long j7, long j8, long j9, long j10);

    private static native int recoverPose_11(long j6, long j7, long j8, long j9, long j10, long j11, double d, long j12, long j13);

    private static native int recoverPose_12(long j6, long j7, long j8, long j9, long j10, long j11, double d, long j12);

    private static native int recoverPose_13(long j6, long j7, long j8, long j9, long j10, long j11, double d);

    private static native int recoverPose_2(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i5, double d);

    private static native int recoverPose_3(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i5);

    private static native int recoverPose_4(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14);

    private static native int recoverPose_5(long j6, long j7, long j8, long j9, long j10, long j11, long j12);

    private static native int recoverPose_6(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native int recoverPose_7(long j6, long j7, long j8, long j9, long j10, double d, double d6, double d7, long j11);

    private static native int recoverPose_8(long j6, long j7, long j8, long j9, long j10, double d, double d6, double d7);

    private static native int recoverPose_9(long j6, long j7, long j8, long j9, long j10, double d);

    public static float rectify3Collinear(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, List<Mat> list, List<Mat> list2, Size size, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, Mat mat12, Mat mat13, Mat mat14, Mat mat15, Mat mat16, Mat mat17, double d, Size size2, Rect rect, Rect rect2, int i5) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        float fRectify3Collinear_0 = rectify3Collinear_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, size.width, size.height, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, mat12.nativeObj, mat13.nativeObj, mat14.nativeObj, mat15.nativeObj, mat16.nativeObj, mat17.nativeObj, d, size2.width, size2.height, dArr, dArr2, i5);
        if (rect != null) {
            rect.f7686x = (int) dArr[0];
            rect.f7687y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        if (rect2 != null) {
            rect2.f7686x = (int) dArr2[0];
            rect2.f7687y = (int) dArr2[1];
            rect2.width = (int) dArr2[2];
            rect2.height = (int) dArr2[3];
        }
        return fRectify3Collinear_0;
    }

    private static native float rectify3Collinear_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, double d, double d6, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, double d7, double d8, double d9, double[] dArr, double[] dArr2, int i5);

    public static void reprojectImageTo3D(Mat mat, Mat mat2, Mat mat3, boolean z6, int i5) {
        reprojectImageTo3D_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, z6, i5);
    }

    private static native void reprojectImageTo3D_0(long j6, long j7, long j8, boolean z6, int i5);

    private static native void reprojectImageTo3D_1(long j6, long j7, long j8, boolean z6);

    private static native void reprojectImageTo3D_2(long j6, long j7, long j8);

    public static double sampsonDistance(Mat mat, Mat mat2, Mat mat3) {
        return sampsonDistance_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native double sampsonDistance_0(long j6, long j7, long j8);

    public static int solveP3P(Mat mat, Mat mat2, Mat mat3, Mat mat4, List<Mat> list, List<Mat> list2, int i5) {
        Mat mat5 = new Mat();
        Mat mat6 = new Mat();
        int iSolveP3P_0 = solveP3P_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, i5);
        AbstractC1125a.p(mat5, list, mat6, list2);
        return iSolveP3P_0;
    }

    private static native int solveP3P_0(long j6, long j7, long j8, long j9, long j10, long j11, int i5);

    public static boolean solvePnP(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, boolean z6, int i5) {
        return solvePnP_0(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, z6, i5);
    }

    public static int solvePnPGeneric(Mat mat, Mat mat2, Mat mat3, Mat mat4, List<Mat> list, List<Mat> list2, boolean z6, int i5, Mat mat5, Mat mat6, Mat mat7) {
        Mat mat8 = new Mat();
        Mat mat9 = new Mat();
        int iSolvePnPGeneric_0 = solvePnPGeneric_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat8.nativeObj, mat9.nativeObj, z6, i5, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj);
        AbstractC1125a.p(mat8, list, mat9, list2);
        return iSolvePnPGeneric_0;
    }

    private static native int solvePnPGeneric_0(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5, long j12, long j13, long j14);

    private static native int solvePnPGeneric_1(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5, long j12, long j13);

    private static native int solvePnPGeneric_2(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5, long j12);

    private static native int solvePnPGeneric_3(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5);

    private static native int solvePnPGeneric_4(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6);

    private static native int solvePnPGeneric_5(long j6, long j7, long j8, long j9, long j10, long j11);

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, boolean z6, int i5, float f6, double d, Mat mat4, int i6) {
        return solvePnPRansac_0(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, z6, i5, f6, d, mat4.nativeObj, i6);
    }

    private static native boolean solvePnPRansac_0(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5, float f6, double d, long j12, int i6);

    private static native boolean solvePnPRansac_1(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5, float f6, double d, long j12);

    private static native boolean solvePnPRansac_2(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5, float f6, double d);

    private static native boolean solvePnPRansac_3(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5, float f6);

    private static native boolean solvePnPRansac_4(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5);

    private static native boolean solvePnPRansac_5(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6);

    private static native boolean solvePnPRansac_6(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native boolean solvePnPRansac_7(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13);

    private static native boolean solvePnPRansac_8(long j6, long j7, long j8, long j9, long j10, long j11, long j12);

    public static void solvePnPRefineLM(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, TermCriteria termCriteria) {
        solvePnPRefineLM_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    private static native void solvePnPRefineLM_0(long j6, long j7, long j8, long j9, long j10, long j11, int i5, int i6, double d);

    private static native void solvePnPRefineLM_1(long j6, long j7, long j8, long j9, long j10, long j11);

    public static void solvePnPRefineVVS(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, TermCriteria termCriteria, double d) {
        solvePnPRefineVVS_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, d);
    }

    private static native void solvePnPRefineVVS_0(long j6, long j7, long j8, long j9, long j10, long j11, int i5, int i6, double d, double d6);

    private static native void solvePnPRefineVVS_1(long j6, long j7, long j8, long j9, long j10, long j11, int i5, int i6, double d);

    private static native void solvePnPRefineVVS_2(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native boolean solvePnP_0(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6, int i5);

    private static native boolean solvePnP_1(long j6, long j7, long j8, long j9, long j10, long j11, boolean z6);

    private static native boolean solvePnP_2(long j6, long j7, long j8, long j9, long j10, long j11);

    public static double stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, int i5, TermCriteria termCriteria) {
        return stereoCalibrate_0(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public static double stereoCalibrateExtended(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, List<Mat> list4, List<Mat> list5, Mat mat9, int i5, TermCriteria termCriteria) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat matVector_Mat_to_Mat3 = Converters.vector_Mat_to_Mat(list3);
        Mat mat10 = new Mat();
        Mat mat11 = new Mat();
        double dStereoCalibrateExtended_0 = stereoCalibrateExtended_0(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, matVector_Mat_to_Mat3.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat10.nativeObj, mat11.nativeObj, mat9.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
        AbstractC1125a.p(mat10, list4, mat11, list5);
        return dStereoCalibrateExtended_0;
    }

    private static native double stereoCalibrateExtended_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, long j17, long j18, long j19, int i5, int i6, int i7, double d7);

    private static native double stereoCalibrateExtended_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, long j17, long j18, long j19, int i5);

    private static native double stereoCalibrateExtended_2(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, long j17, long j18, long j19);

    private static native double stereoCalibrate_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, int i5, int i6, int i7, double d7);

    private static native double stereoCalibrate_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, int i5);

    private static native double stereoCalibrate_2(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16);

    private static native double stereoCalibrate_3(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, long j17, int i5, int i6, int i7, double d7);

    private static native double stereoCalibrate_4(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, long j17, int i5);

    private static native double stereoCalibrate_5(long j6, long j7, long j8, long j9, long j10, long j11, long j12, double d, double d6, long j13, long j14, long j15, long j16, long j17);

    public static void stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5, double d, Size size2, Rect rect, Rect rect2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        stereoRectify_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5, d, size2.width, size2.height, dArr, dArr2);
        if (rect != null) {
            rect.f7686x = (int) dArr[0];
            rect.f7687y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        if (rect2 != null) {
            rect2.f7686x = (int) dArr2[0];
            rect2.f7687y = (int) dArr2[1];
            rect2.width = (int) dArr2[2];
            rect2.height = (int) dArr2[3];
        }
    }

    public static boolean stereoRectifyUncalibrated(Mat mat, Mat mat2, Mat mat3, Size size, Mat mat4, Mat mat5, double d) {
        return stereoRectifyUncalibrated_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, mat4.nativeObj, mat5.nativeObj, d);
    }

    private static native boolean stereoRectifyUncalibrated_0(long j6, long j7, long j8, double d, double d6, long j9, long j10, double d7);

    private static native boolean stereoRectifyUncalibrated_1(long j6, long j7, long j8, double d, double d6, long j9, long j10);

    private static native void stereoRectify_0(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5, double d7, double d8, double d9, double[] dArr, double[] dArr2);

    private static native void stereoRectify_1(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5, double d7, double d8, double d9, double[] dArr);

    private static native void stereoRectify_2(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5, double d7, double d8, double d9);

    private static native void stereoRectify_3(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5, double d7);

    private static native void stereoRectify_4(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i5);

    private static native void stereoRectify_5(long j6, long j7, long j8, long j9, double d, double d6, long j10, long j11, long j12, long j13, long j14, long j15, long j16);

    public static void triangulatePoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        triangulatePoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    private static native void triangulatePoints_0(long j6, long j7, long j8, long j9, long j10);

    public static void undistort(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        undistort_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static void undistortImagePoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, TermCriteria termCriteria) {
        undistortImagePoints_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    private static native void undistortImagePoints_0(long j6, long j7, long j8, long j9, int i5, int i6, double d);

    private static native void undistortImagePoints_1(long j6, long j7, long j8, long j9);

    public static void undistortPoints(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        undistortPoints_0(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void undistortPointsIter(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, TermCriteria termCriteria) {
        undistortPointsIter_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    private static native void undistortPointsIter_0(long j6, long j7, long j8, long j9, long j10, long j11, int i5, int i6, double d);

    private static native void undistortPoints_0(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void undistortPoints_1(long j6, long j7, long j8, long j9, long j10);

    private static native void undistortPoints_2(long j6, long j7, long j8, long j9);

    private static native void undistort_0(long j6, long j7, long j8, long j9, long j10);

    private static native void undistort_1(long j6, long j7, long j8, long j9);

    public static void validateDisparity(Mat mat, Mat mat2, int i5, int i6, int i7) {
        validateDisparity_0(mat.nativeObj, mat2.nativeObj, i5, i6, i7);
    }

    private static native void validateDisparity_0(long j6, long j7, int i5, int i6, int i7);

    private static native void validateDisparity_1(long j6, long j7, int i5, int i6);

    public static double[] RQDecomp3x3(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        return RQDecomp3x3_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static void Rodrigues(Mat mat, Mat mat2) {
        Rodrigues_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, Mat mat12, Mat mat13) {
        composeRT_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, mat12.nativeObj, mat13.nativeObj);
    }

    public static void decomposeProjectionMatrix(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        decomposeProjectionMatrix_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj);
    }

    public static void drawFrameAxes(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, float f6) {
        drawFrameAxes_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, f6);
    }

    public static Mat estimateAffine2D(Mat mat, Mat mat2, Mat mat3, int i5, double d, long j6, double d6) {
        return new Mat(estimateAffine2D_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, j6, d6));
    }

    public static int estimateAffine3D(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d) {
        return estimateAffine3D_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, d);
    }

    public static Mat estimateAffinePartial2D(Mat mat, Mat mat2, Mat mat3, int i5, double d, long j6, double d6) {
        return new Mat(estimateAffinePartial2D_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, j6, d6));
    }

    public static Scalar estimateChessboardSharpness(Mat mat, Size size, Mat mat2, float f6, boolean z6) {
        return new Scalar(estimateChessboardSharpness_1(mat.nativeObj, size.width, size.height, mat2.nativeObj, f6, z6));
    }

    public static int estimateTranslation3D(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d) {
        return estimateTranslation3D_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, d);
    }

    public static void filterSpeckles(Mat mat, double d, int i5, double d6) {
        filterSpeckles_1(mat.nativeObj, d, i5, d6);
    }

    public static boolean findChessboardCorners(Mat mat, Size size, MatOfPoint2f matOfPoint2f) {
        return findChessboardCorners_1(mat.nativeObj, size.width, size.height, matOfPoint2f.nativeObj);
    }

    public static boolean findChessboardCornersSB(Mat mat, Size size, Mat mat2) {
        return findChessboardCornersSB_1(mat.nativeObj, size.width, size.height, mat2.nativeObj);
    }

    public static boolean findCirclesGrid(Mat mat, Size size, Mat mat2) {
        return findCirclesGrid_2(mat.nativeObj, size.width, size.height, mat2.nativeObj);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, int i5, double d, double d6, int i6) {
        return new Mat(findEssentialMat_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, d6, i6));
    }

    public static Mat findFundamentalMat(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d, double d6, int i6) {
        return new Mat(findFundamentalMat_1(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d, d6, i6));
    }

    public static Mat findHomography(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d, Mat mat, int i6) {
        return new Mat(findHomography_1(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d, mat.nativeObj, i6));
    }

    public static void fisheye_distortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        fisheye_distortPoints_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void fisheye_estimateNewCameraMatrixForUndistortRectify(Mat mat, Mat mat2, Size size, Mat mat3, Mat mat4, double d, Size size2) {
        fisheye_estimateNewCameraMatrixForUndistortRectify_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, mat3.nativeObj, mat4.nativeObj, d, size2.width, size2.height);
    }

    public static void fisheye_projectPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d) {
        fisheye_projectPoints_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, d);
    }

    public static void fisheye_stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5, Size size2, double d) {
        fisheye_stereoRectify_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5, size2.width, size2.height, d);
    }

    public static void fisheye_undistortImage(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        fisheye_undistortImage_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static void fisheye_undistortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        fisheye_undistortPoints_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    public static Mat getDefaultNewCameraMatrix(Mat mat, Size size) {
        return new Mat(getDefaultNewCameraMatrix_1(mat.nativeObj, size.width, size.height));
    }

    public static void projectPoints(MatOfPoint3f matOfPoint3f, Mat mat, Mat mat2, Mat mat3, MatOfDouble matOfDouble, MatOfPoint2f matOfPoint2f, Mat mat4) {
        projectPoints_1(matOfPoint3f.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, matOfDouble.nativeObj, matOfPoint2f.nativeObj, mat4.nativeObj);
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, int i5, double d, double d6) {
        return recoverPose_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, i5, d, d6);
    }

    public static void reprojectImageTo3D(Mat mat, Mat mat2, Mat mat3, boolean z6) {
        reprojectImageTo3D_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, z6);
    }

    public static boolean solvePnP(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, boolean z6) {
        return solvePnP_1(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, z6);
    }

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, boolean z6, int i5, float f6, double d, Mat mat4) {
        return solvePnPRansac_1(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, z6, i5, f6, d, mat4.nativeObj);
    }

    public static void solvePnPRefineLM(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        solvePnPRefineLM_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    public static void solvePnPRefineVVS(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, TermCriteria termCriteria) {
        solvePnPRefineVVS_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public static boolean stereoRectifyUncalibrated(Mat mat, Mat mat2, Mat mat3, Size size, Mat mat4, Mat mat5) {
        return stereoRectifyUncalibrated_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, mat4.nativeObj, mat5.nativeObj);
    }

    public static void undistort(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        undistort_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void undistortImagePoints(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        undistortImagePoints_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void undistortPoints(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, Mat mat, Mat mat2, Mat mat3) {
        undistortPoints_1(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void validateDisparity(Mat mat, Mat mat2, int i5, int i6) {
        validateDisparity_1(mat.nativeObj, mat2.nativeObj, i5, i6);
    }

    public static double[] RQDecomp3x3(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        return RQDecomp3x3_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, Mat mat12) {
        composeRT_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, mat12.nativeObj);
    }

    public static void decomposeProjectionMatrix(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        decomposeProjectionMatrix_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    public static Mat estimateAffine2D(Mat mat, Mat mat2, Mat mat3, int i5, double d, long j6) {
        return new Mat(estimateAffine2D_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, j6));
    }

    public static int estimateAffine3D(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        return estimateAffine3D_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static Mat estimateAffinePartial2D(Mat mat, Mat mat2, Mat mat3, int i5, double d, long j6) {
        return new Mat(estimateAffinePartial2D_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, j6));
    }

    public static Scalar estimateChessboardSharpness(Mat mat, Size size, Mat mat2, float f6) {
        return new Scalar(estimateChessboardSharpness_2(mat.nativeObj, size.width, size.height, mat2.nativeObj, f6));
    }

    public static int estimateTranslation3D(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        return estimateTranslation3D_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, int i5, double d, double d6) {
        return new Mat(findEssentialMat_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d, d6));
    }

    public static Mat findFundamentalMat(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d, double d6, Mat mat) {
        return new Mat(findFundamentalMat_2(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d, d6, mat.nativeObj));
    }

    public static Mat findHomography(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d, Mat mat) {
        return new Mat(findHomography_2(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d, mat.nativeObj));
    }

    public static void fisheye_estimateNewCameraMatrixForUndistortRectify(Mat mat, Mat mat2, Size size, Mat mat3, Mat mat4, double d) {
        fisheye_estimateNewCameraMatrixForUndistortRectify_2(mat.nativeObj, mat2.nativeObj, size.width, size.height, mat3.nativeObj, mat4.nativeObj, d);
    }

    public static void fisheye_projectPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        fisheye_projectPoints_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    public static void fisheye_stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5, Size size2) {
        fisheye_stereoRectify_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5, size2.width, size2.height);
    }

    public static void fisheye_undistortImage(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        fisheye_undistortImage_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void fisheye_undistortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        fisheye_undistortPoints_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static Mat getDefaultNewCameraMatrix(Mat mat) {
        return new Mat(getDefaultNewCameraMatrix_2(mat.nativeObj));
    }

    public static void projectPoints(MatOfPoint3f matOfPoint3f, Mat mat, Mat mat2, Mat mat3, MatOfDouble matOfDouble, MatOfPoint2f matOfPoint2f) {
        projectPoints_2(matOfPoint3f.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, matOfDouble.nativeObj, matOfPoint2f.nativeObj);
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, int i5, double d) {
        return recoverPose_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, i5, d);
    }

    public static void reprojectImageTo3D(Mat mat, Mat mat2, Mat mat3) {
        reprojectImageTo3D_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static boolean solvePnP(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3) {
        return solvePnP_2(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, boolean z6, int i5, float f6, double d) {
        return solvePnPRansac_2(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, z6, i5, f6, d);
    }

    public static void solvePnPRefineVVS(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        solvePnPRefineVVS_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    public static void undistortPoints(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, Mat mat, Mat mat2) {
        undistortPoints_2(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public static double[] RQDecomp3x3(Mat mat, Mat mat2, Mat mat3) {
        return RQDecomp3x3_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11) {
        composeRT_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj);
    }

    public static void decomposeProjectionMatrix(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        decomposeProjectionMatrix_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static Mat estimateAffine2D(Mat mat, Mat mat2, Mat mat3, int i5, double d) {
        return new Mat(estimateAffine2D_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d));
    }

    public static Mat estimateAffine3D(Mat mat, Mat mat2, double[] dArr, boolean z6) {
        double[] dArr2 = new double[1];
        Mat mat3 = new Mat(estimateAffine3D_3(mat.nativeObj, mat2.nativeObj, dArr2, z6));
        if (dArr != null) {
            dArr[0] = dArr2[0];
        }
        return mat3;
    }

    public static Mat estimateAffinePartial2D(Mat mat, Mat mat2, Mat mat3, int i5, double d) {
        return new Mat(estimateAffinePartial2D_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d));
    }

    public static Scalar estimateChessboardSharpness(Mat mat, Size size, Mat mat2) {
        return new Scalar(estimateChessboardSharpness_3(mat.nativeObj, size.width, size.height, mat2.nativeObj));
    }

    public static void filterHomographyDecompByVisibleRefpoints(List<Mat> list, List<Mat> list2, Mat mat, Mat mat2, Mat mat3) {
        filterHomographyDecompByVisibleRefpoints_1(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, int i5, double d) {
        return new Mat(findEssentialMat_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, d));
    }

    public static Mat findFundamentalMat(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d, double d6) {
        return new Mat(findFundamentalMat_3(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d, d6));
    }

    public static Mat findHomography(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d) {
        return new Mat(findHomography_3(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d));
    }

    public static void fisheye_estimateNewCameraMatrixForUndistortRectify(Mat mat, Mat mat2, Size size, Mat mat3, Mat mat4) {
        fisheye_estimateNewCameraMatrixForUndistortRectify_3(mat.nativeObj, mat2.nativeObj, size.width, size.height, mat3.nativeObj, mat4.nativeObj);
    }

    public static void fisheye_stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5) {
        fisheye_stereoRectify_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5);
    }

    public static void fisheye_undistortPoints(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        fisheye_undistortPoints_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static Mat getOptimalNewCameraMatrix(Mat mat, Mat mat2, Size size, double d, Size size2, Rect rect) {
        double[] dArr = new double[4];
        Mat mat3 = new Mat(getOptimalNewCameraMatrix_1(mat.nativeObj, mat2.nativeObj, size.width, size.height, d, size2.width, size2.height, dArr));
        if (rect != null) {
            rect.f7686x = (int) dArr[0];
            rect.f7687y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        return mat3;
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, int i5) {
        return recoverPose_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, i5);
    }

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, boolean z6, int i5, float f6) {
        return solvePnPRansac_3(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, z6, i5, f6);
    }

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10) {
        composeRT_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj);
    }

    public static void decomposeProjectionMatrix(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        decomposeProjectionMatrix_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static Mat estimateAffine2D(Mat mat, Mat mat2, Mat mat3, int i5) {
        return new Mat(estimateAffine2D_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5));
    }

    public static Mat estimateAffinePartial2D(Mat mat, Mat mat2, Mat mat3, int i5) {
        return new Mat(estimateAffinePartial2D_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, int i5) {
        return new Mat(findEssentialMat_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5));
    }

    public static Mat findFundamentalMat(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5, double d) {
        return new Mat(findFundamentalMat_4(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5, d));
    }

    public static Mat findHomography(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5) {
        return new Mat(findHomography_4(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5));
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9) {
        return recoverPose_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj);
    }

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, boolean z6, int i5) {
        return solvePnPRansac_4(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, z6, i5);
    }

    public static double stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, int i5) {
        return stereoCalibrate_1(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, i5);
    }

    public static void calibrateHandEye(List<Mat> list, List<Mat> list2, List<Mat> list3, List<Mat> list4, Mat mat, Mat mat2) {
        calibrateHandEye_1(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, Converters.vector_Mat_to_Mat(list4).nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public static void calibrateRobotWorldHandEye(List<Mat> list, List<Mat> list2, List<Mat> list3, List<Mat> list4, Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        calibrateRobotWorldHandEye_1(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, Converters.vector_Mat_to_Mat(list4).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9) {
        composeRT_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj);
    }

    public static Mat estimateAffine2D(Mat mat, Mat mat2, Mat mat3) {
        return new Mat(estimateAffine2D_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj));
    }

    public static Mat estimateAffinePartial2D(Mat mat, Mat mat2, Mat mat3) {
        return new Mat(estimateAffinePartial2D_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3) {
        return new Mat(findEssentialMat_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj));
    }

    public static Mat findFundamentalMat(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, int i5) {
        return new Mat(findFundamentalMat_5(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, i5));
    }

    public static Mat findHomography(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2) {
        return new Mat(findHomography_5(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj));
    }

    public static Mat initCameraMatrix2D(List<MatOfPoint3f> list, List<MatOfPoint2f> list2, Size size) {
        return new Mat(initCameraMatrix2D_1(Converters.vector_vector_Point3f_to_Mat(list, new ArrayList(list != null ? list.size() : 0)).nativeObj, Converters.vector_vector_Point2f_to_Mat(list2, new ArrayList(list2 != null ? list2.size() : 0)).nativeObj, size.width, size.height));
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        return recoverPose_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj);
    }

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, boolean z6) {
        return solvePnPRansac_5(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, z6);
    }

    public static void stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5, double d, Size size2, Rect rect) {
        double[] dArr = new double[4];
        stereoRectify_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5, d, size2.width, size2.height, dArr);
        if (rect != null) {
            rect.f7686x = (int) dArr[0];
            rect.f7687y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
    }

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, Mat mat8) {
        composeRT_6(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj);
    }

    public static Mat estimateAffine2D(Mat mat, Mat mat2) {
        return new Mat(estimateAffine2D_6(mat.nativeObj, mat2.nativeObj));
    }

    public static Mat estimateAffine3D(Mat mat, Mat mat2, double[] dArr) {
        double[] dArr2 = new double[1];
        Mat mat3 = new Mat(estimateAffine3D_4(mat.nativeObj, mat2.nativeObj, dArr2));
        if (dArr != null) {
            dArr[0] = dArr2[0];
        }
        return mat3;
    }

    public static Mat estimateAffinePartial2D(Mat mat, Mat mat2) {
        return new Mat(estimateAffinePartial2D_6(mat.nativeObj, mat2.nativeObj));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, double d, Point point, int i5, double d6, double d7, int i6, Mat mat3) {
        return new Mat(findEssentialMat_6(mat.nativeObj, mat2.nativeObj, d, point.f7681x, point.f7682y, i5, d6, d7, i6, mat3.nativeObj));
    }

    public static Mat findFundamentalMat(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2) {
        return new Mat(findFundamentalMat_6(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj));
    }

    public static Mat findHomography(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, Mat mat, UsacParams usacParams) {
        return new Mat(findHomography_6(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, mat.nativeObj, usacParams.nativeObj));
    }

    public static Mat getOptimalNewCameraMatrix(Mat mat, Mat mat2, Size size, double d, Size size2) {
        return new Mat(getOptimalNewCameraMatrix_2(mat.nativeObj, mat2.nativeObj, size.width, size.height, d, size2.width, size2.height));
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        return recoverPose_6(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3) {
        return solvePnPRansac_6(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        composeRT_7(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj);
    }

    public static Mat estimateAffine2D(Mat mat, Mat mat2, Mat mat3, UsacParams usacParams) {
        return new Mat(estimateAffine2D_7(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, usacParams.nativeObj));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, double d, Point point, int i5, double d6, double d7, int i6) {
        return new Mat(findEssentialMat_7(mat.nativeObj, mat2.nativeObj, d, point.f7681x, point.f7682y, i5, d6, d7, i6));
    }

    public static Mat findFundamentalMat(MatOfPoint2f matOfPoint2f, MatOfPoint2f matOfPoint2f2, Mat mat, UsacParams usacParams) {
        return new Mat(findFundamentalMat_7(matOfPoint2f.nativeObj, matOfPoint2f2.nativeObj, mat.nativeObj, usacParams.nativeObj));
    }

    public static Mat getOptimalNewCameraMatrix(Mat mat, Mat mat2, Size size, double d) {
        return new Mat(getOptimalNewCameraMatrix_3(mat.nativeObj, mat2.nativeObj, size.width, size.height, d));
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, double d, Point point, Mat mat6) {
        return recoverPose_7(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, d, point.f7681x, point.f7682y, mat6.nativeObj);
    }

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, Mat mat4, UsacParams usacParams) {
        return solvePnPRansac_7(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, usacParams.nativeObj);
    }

    public static void composeRT(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        composeRT_8(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, double d, Point point, int i5, double d6, double d7) {
        return new Mat(findEssentialMat_8(mat.nativeObj, mat2.nativeObj, d, point.f7681x, point.f7682y, i5, d6, d7));
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, double d, Point point) {
        return recoverPose_8(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, d, point.f7681x, point.f7682y);
    }

    public static int solvePnPGeneric(Mat mat, Mat mat2, Mat mat3, Mat mat4, List<Mat> list, List<Mat> list2, boolean z6, int i5, Mat mat5, Mat mat6) {
        Mat mat7 = new Mat();
        Mat mat8 = new Mat();
        int iSolvePnPGeneric_1 = solvePnPGeneric_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat7.nativeObj, mat8.nativeObj, z6, i5, mat5.nativeObj, mat6.nativeObj);
        AbstractC1125a.p(mat7, list, mat8, list2);
        return iSolvePnPGeneric_1;
    }

    public static boolean solvePnPRansac(MatOfPoint3f matOfPoint3f, MatOfPoint2f matOfPoint2f, Mat mat, MatOfDouble matOfDouble, Mat mat2, Mat mat3, Mat mat4) {
        return solvePnPRansac_8(matOfPoint3f.nativeObj, matOfPoint2f.nativeObj, mat.nativeObj, matOfDouble.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static double stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8) {
        return stereoCalibrate_2(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj);
    }

    public static void stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5, double d, Size size2) {
        stereoRectify_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5, d, size2.width, size2.height);
    }

    public static Mat estimateAffine3D(Mat mat, Mat mat2) {
        return new Mat(estimateAffine3D_5(mat.nativeObj, mat2.nativeObj));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, double d, Point point, int i5, double d6) {
        return new Mat(findEssentialMat_9(mat.nativeObj, mat2.nativeObj, d, point.f7681x, point.f7682y, i5, d6));
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, double d) {
        return recoverPose_9(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, d);
    }

    public static void stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5, double d) {
        stereoRectify_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5, d);
    }

    public static double calibrateCamera(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, int i5) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        double dCalibrateCamera_1 = calibrateCamera_1(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5);
        AbstractC1125a.p(mat3, list3, mat4, list4);
        return dCalibrateCamera_1;
    }

    public static double calibrateCameraExtended(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3, Mat mat4, Mat mat5, int i5) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat6 = new Mat();
        Mat mat7 = new Mat();
        double dCalibrateCameraExtended_1 = calibrateCameraExtended_1(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat6.nativeObj, mat7.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, i5);
        AbstractC1125a.p(mat6, list3, mat7, list4);
        return dCalibrateCameraExtended_1;
    }

    public static double calibrateCameraRO(List<Mat> list, List<Mat> list2, Size size, int i5, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3, int i6) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        double dCalibrateCameraRO_1 = calibrateCameraRO_1(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, i5, mat.nativeObj, mat2.nativeObj, mat4.nativeObj, mat5.nativeObj, mat3.nativeObj, i6);
        AbstractC1125a.p(mat4, list3, mat5, list4);
        return dCalibrateCameraRO_1;
    }

    public static double calibrateCameraROExtended(List<Mat> list, List<Mat> list2, Size size, int i5, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, int i6) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat8 = new Mat();
        Mat mat9 = new Mat();
        double dCalibrateCameraROExtended_1 = calibrateCameraROExtended_1(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, i5, mat.nativeObj, mat2.nativeObj, mat8.nativeObj, mat9.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, i6);
        AbstractC1125a.p(mat8, list3, mat9, list4);
        return dCalibrateCameraROExtended_1;
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, double d, Point point, int i5) {
        return new Mat(findEssentialMat_10(mat.nativeObj, mat2.nativeObj, d, point.f7681x, point.f7682y, i5));
    }

    public static double fisheye_calibrate(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, int i5) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        double dFisheye_calibrate_1 = fisheye_calibrate_1(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5);
        AbstractC1125a.p(mat3, list3, mat4, list4);
        return dFisheye_calibrate_1;
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        return recoverPose_10(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public static void stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11, int i5) {
        stereoRectify_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj, i5);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, double d, Point point) {
        return new Mat(findEssentialMat_11(mat.nativeObj, mat2.nativeObj, d, point.f7681x, point.f7682y));
    }

    public static double fisheye_stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, List<Mat> list4, List<Mat> list5, int i5) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat matVector_Mat_to_Mat3 = Converters.vector_Mat_to_Mat(list3);
        Mat mat7 = new Mat();
        Mat mat8 = new Mat();
        double dFisheye_stereoCalibrate_1 = fisheye_stereoCalibrate_1(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, matVector_Mat_to_Mat3.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, i5);
        AbstractC1125a.p(mat7, list4, mat8, list5);
        return dFisheye_stereoCalibrate_1;
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d, Mat mat7, Mat mat8) {
        return recoverPose_11(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, d, mat7.nativeObj, mat8.nativeObj);
    }

    public static double stereoCalibrateExtended(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, List<Mat> list4, List<Mat> list5, Mat mat9, int i5) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat matVector_Mat_to_Mat3 = Converters.vector_Mat_to_Mat(list3);
        Mat mat10 = new Mat();
        Mat mat11 = new Mat();
        double dStereoCalibrateExtended_1 = stereoCalibrateExtended_1(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, matVector_Mat_to_Mat3.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat10.nativeObj, mat11.nativeObj, mat9.nativeObj, i5);
        AbstractC1125a.p(mat10, list4, mat11, list5);
        return dStereoCalibrateExtended_1;
    }

    public static void stereoRectify(Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, Mat mat10, Mat mat11) {
        stereoRectify_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, mat10.nativeObj, mat11.nativeObj);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, double d) {
        return new Mat(findEssentialMat_12(mat.nativeObj, mat2.nativeObj, d));
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d, Mat mat7) {
        return recoverPose_12(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, d, mat7.nativeObj);
    }

    public static double stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, int i5, TermCriteria termCriteria) {
        return stereoCalibrate_3(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2) {
        return new Mat(findEssentialMat_13(mat.nativeObj, mat2.nativeObj));
    }

    public static int recoverPose(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, double d) {
        return recoverPose_13(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, d);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, int i5, double d, double d6, Mat mat7) {
        return new Mat(findEssentialMat_14(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, i5, d, d6, mat7.nativeObj));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, int i5, double d, double d6) {
        return new Mat(findEssentialMat_15(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, i5, d, d6));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, int i5, double d) {
        return new Mat(findEssentialMat_16(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, i5, d));
    }

    public static int solvePnPGeneric(Mat mat, Mat mat2, Mat mat3, Mat mat4, List<Mat> list, List<Mat> list2, boolean z6, int i5, Mat mat5) {
        Mat mat6 = new Mat();
        Mat mat7 = new Mat();
        int iSolvePnPGeneric_2 = solvePnPGeneric_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat6.nativeObj, mat7.nativeObj, z6, i5, mat5.nativeObj);
        AbstractC1125a.p(mat6, list, mat7, list2);
        return iSolvePnPGeneric_2;
    }

    public static double stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9, int i5) {
        return stereoCalibrate_4(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj, i5);
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, int i5) {
        return new Mat(findEssentialMat_17(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, i5));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        return new Mat(findEssentialMat_18(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj));
    }

    public static Mat findEssentialMat(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7, UsacParams usacParams) {
        return new Mat(findEssentialMat_19(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, usacParams.nativeObj));
    }

    public static double calibrateCamera(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        double dCalibrateCamera_2 = calibrateCamera_2(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
        AbstractC1125a.p(mat3, list3, mat4, list4);
        return dCalibrateCamera_2;
    }

    public static double calibrateCameraExtended(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3, Mat mat4, Mat mat5) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat6 = new Mat();
        Mat mat7 = new Mat();
        double dCalibrateCameraExtended_2 = calibrateCameraExtended_2(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat6.nativeObj, mat7.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
        AbstractC1125a.p(mat6, list3, mat7, list4);
        return dCalibrateCameraExtended_2;
    }

    public static double calibrateCameraRO(List<Mat> list, List<Mat> list2, Size size, int i5, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        double dCalibrateCameraRO_2 = calibrateCameraRO_2(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, i5, mat.nativeObj, mat2.nativeObj, mat4.nativeObj, mat5.nativeObj, mat3.nativeObj);
        AbstractC1125a.p(mat4, list3, mat5, list4);
        return dCalibrateCameraRO_2;
    }

    public static double calibrateCameraROExtended(List<Mat> list, List<Mat> list2, Size size, int i5, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4, Mat mat3, Mat mat4, Mat mat5, Mat mat6, Mat mat7) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat8 = new Mat();
        Mat mat9 = new Mat();
        double dCalibrateCameraROExtended_2 = calibrateCameraROExtended_2(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, i5, mat.nativeObj, mat2.nativeObj, mat8.nativeObj, mat9.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj);
        AbstractC1125a.p(mat8, list3, mat9, list4);
        return dCalibrateCameraROExtended_2;
    }

    public static double fisheye_calibrate(List<Mat> list, List<Mat> list2, Size size, Mat mat, Mat mat2, List<Mat> list3, List<Mat> list4) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        double dFisheye_calibrate_2 = fisheye_calibrate_2(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
        AbstractC1125a.p(mat3, list3, mat4, list4);
        return dFisheye_calibrate_2;
    }

    public static double stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, Mat mat9) {
        return stereoCalibrate_5(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat9.nativeObj);
    }

    public static double fisheye_stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, List<Mat> list4, List<Mat> list5) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat matVector_Mat_to_Mat3 = Converters.vector_Mat_to_Mat(list3);
        Mat mat7 = new Mat();
        Mat mat8 = new Mat();
        double dFisheye_stereoCalibrate_2 = fisheye_stereoCalibrate_2(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, matVector_Mat_to_Mat3.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj);
        AbstractC1125a.p(mat7, list4, mat8, list5);
        return dFisheye_stereoCalibrate_2;
    }

    public static double stereoCalibrateExtended(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, Mat mat7, Mat mat8, List<Mat> list4, List<Mat> list5, Mat mat9) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        Mat matVector_Mat_to_Mat3 = Converters.vector_Mat_to_Mat(list3);
        Mat mat10 = new Mat();
        Mat mat11 = new Mat();
        double dStereoCalibrateExtended_2 = stereoCalibrateExtended_2(matVector_Mat_to_Mat.nativeObj, matVector_Mat_to_Mat2.nativeObj, matVector_Mat_to_Mat3.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, mat7.nativeObj, mat8.nativeObj, mat10.nativeObj, mat11.nativeObj, mat9.nativeObj);
        AbstractC1125a.p(mat10, list4, mat11, list5);
        return dStereoCalibrateExtended_2;
    }

    public static int solvePnPGeneric(Mat mat, Mat mat2, Mat mat3, Mat mat4, List<Mat> list, List<Mat> list2, boolean z6, int i5) {
        Mat mat5 = new Mat();
        Mat mat6 = new Mat();
        int iSolvePnPGeneric_3 = solvePnPGeneric_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, z6, i5);
        AbstractC1125a.p(mat5, list, mat6, list2);
        return iSolvePnPGeneric_3;
    }

    public static int solvePnPGeneric(Mat mat, Mat mat2, Mat mat3, Mat mat4, List<Mat> list, List<Mat> list2, boolean z6) {
        Mat mat5 = new Mat();
        Mat mat6 = new Mat();
        int iSolvePnPGeneric_4 = solvePnPGeneric_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj, z6);
        AbstractC1125a.p(mat5, list, mat6, list2);
        return iSolvePnPGeneric_4;
    }

    public static double fisheye_stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, int i5, TermCriteria termCriteria) {
        return fisheye_stereoCalibrate_3(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public static double fisheye_stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6, int i5) {
        return fisheye_stereoCalibrate_4(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj, i5);
    }

    public static int solvePnPGeneric(Mat mat, Mat mat2, Mat mat3, Mat mat4, List<Mat> list, List<Mat> list2) {
        Mat mat5 = new Mat();
        Mat mat6 = new Mat();
        int iSolvePnPGeneric_5 = solvePnPGeneric_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
        AbstractC1125a.p(mat5, list, mat6, list2);
        return iSolvePnPGeneric_5;
    }

    public static double fisheye_stereoCalibrate(List<Mat> list, List<Mat> list2, List<Mat> list3, Mat mat, Mat mat2, Mat mat3, Mat mat4, Size size, Mat mat5, Mat mat6) {
        return fisheye_stereoCalibrate_5(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, Converters.vector_Mat_to_Mat(list3).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, size.width, size.height, mat5.nativeObj, mat6.nativeObj);
    }
}
