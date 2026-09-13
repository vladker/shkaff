package org.opencv.core;

import java.util.List;
import org.opencv.android.OpenCVLoader;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Core {
    public static final int BORDER_CONSTANT = 0;
    public static final int BORDER_DEFAULT = 4;
    public static final int BORDER_ISOLATED = 16;
    public static final int BORDER_REFLECT = 2;
    public static final int BORDER_REFLECT101 = 4;
    public static final int BORDER_REFLECT_101 = 4;
    public static final int BORDER_REPLICATE = 1;
    public static final int BORDER_TRANSPARENT = 5;
    public static final int BORDER_WRAP = 3;
    public static final int BadAlign = -21;
    public static final int BadAlphaChannel = -18;
    public static final int BadCOI = -24;
    public static final int BadCallBack = -22;
    public static final int BadDataPtr = -12;
    public static final int BadDepth = -17;
    public static final int BadImageSize = -10;
    public static final int BadModelOrChSeq = -14;
    public static final int BadNumChannel1U = -16;
    public static final int BadNumChannels = -15;
    public static final int BadOffset = -11;
    public static final int BadOrder = -19;
    public static final int BadOrigin = -20;
    public static final int BadROISize = -25;
    public static final int BadStep = -13;
    public static final int BadTileSize = -23;
    public static final int CMP_EQ = 0;
    public static final int CMP_GE = 2;
    public static final int CMP_GT = 1;
    public static final int CMP_LE = 4;
    public static final int CMP_LT = 3;
    public static final int CMP_NE = 5;
    public static final int COVAR_COLS = 16;
    public static final int COVAR_NORMAL = 1;
    public static final int COVAR_ROWS = 8;
    public static final int COVAR_SCALE = 4;
    public static final int COVAR_SCRAMBLED = 0;
    public static final int COVAR_USE_AVG = 2;
    private static final int CV_16S = 3;
    private static final int CV_16U = 2;
    private static final int CV_32F = 5;
    private static final int CV_32S = 4;
    private static final int CV_64F = 6;
    private static final int CV_8S = 1;
    private static final int CV_8U = 0;
    private static final int CV_USRTYPE1 = 7;
    public static final int DCT_INVERSE = 1;
    public static final int DCT_ROWS = 4;
    public static final int DECOMP_CHOLESKY = 3;
    public static final int DECOMP_EIG = 2;
    public static final int DECOMP_LU = 0;
    public static final int DECOMP_NORMAL = 16;
    public static final int DECOMP_QR = 4;
    public static final int DECOMP_SVD = 1;
    public static final int DFT_COMPLEX_INPUT = 64;
    public static final int DFT_COMPLEX_OUTPUT = 16;
    public static final int DFT_INVERSE = 1;
    public static final int DFT_REAL_OUTPUT = 32;
    public static final int DFT_ROWS = 4;
    public static final int DFT_SCALE = 2;
    public static final int FILLED = -1;
    public static final int Formatter_FMT_C = 5;
    public static final int Formatter_FMT_CSV = 2;
    public static final int Formatter_FMT_DEFAULT = 0;
    public static final int Formatter_FMT_MATLAB = 1;
    public static final int Formatter_FMT_NUMPY = 4;
    public static final int Formatter_FMT_PYTHON = 3;
    public static final int GEMM_1_T = 1;
    public static final int GEMM_2_T = 2;
    public static final int GEMM_3_T = 4;
    public static final int GpuApiCallError = -217;
    public static final int GpuNotSupported = -216;
    public static final int HeaderIsNull = -9;
    public static final int KMEANS_PP_CENTERS = 2;
    public static final int KMEANS_RANDOM_CENTERS = 0;
    public static final int KMEANS_USE_INITIAL_LABELS = 1;
    public static final int MaskIsTiled = -26;
    public static final int NORM_HAMMING = 6;
    public static final int NORM_HAMMING2 = 7;
    public static final int NORM_INF = 1;
    public static final int NORM_L1 = 2;
    public static final int NORM_L2 = 4;
    public static final int NORM_L2SQR = 5;
    public static final int NORM_MINMAX = 32;
    public static final int NORM_RELATIVE = 8;
    public static final int NORM_TYPE_MASK = 7;
    public static final int OpenCLApiCallError = -220;
    public static final int OpenCLDoubleNotSupported = -221;
    public static final int OpenCLInitError = -222;
    public static final int OpenCLNoAMDBlasFft = -223;
    public static final int OpenGlApiCallError = -219;
    public static final int OpenGlNotSupported = -218;
    public static final int PCA_DATA_AS_COL = 1;
    public static final int PCA_DATA_AS_ROW = 0;
    public static final int PCA_USE_AVG = 2;
    public static final int Param_ALGORITHM = 6;
    public static final int Param_BOOLEAN = 1;
    public static final int Param_FLOAT = 7;
    public static final int Param_INT = 0;
    public static final int Param_MAT = 4;
    public static final int Param_MAT_VECTOR = 5;
    public static final int Param_REAL = 2;
    public static final int Param_SCALAR = 12;
    public static final int Param_STRING = 3;
    public static final int Param_UCHAR = 11;
    public static final int Param_UINT64 = 9;
    public static final int Param_UNSIGNED_INT = 8;
    public static final int REDUCE_AVG = 1;
    public static final int REDUCE_MAX = 2;
    public static final int REDUCE_MIN = 3;
    public static final int REDUCE_SUM = 0;
    public static final int REDUCE_SUM2 = 4;
    public static final int RNG_NORMAL = 1;
    public static final int RNG_UNIFORM = 0;
    public static final int ROTATE_180 = 1;
    public static final int ROTATE_90_CLOCKWISE = 0;
    public static final int ROTATE_90_COUNTERCLOCKWISE = 2;
    public static final int SORT_ASCENDING = 0;
    public static final int SORT_DESCENDING = 16;
    public static final int SORT_EVERY_COLUMN = 1;
    public static final int SORT_EVERY_ROW = 0;
    public static final int SVD_FULL_UV = 4;
    public static final int SVD_MODIFY_A = 1;
    public static final int SVD_NO_UV = 2;
    public static final int StsAssert = -215;
    public static final int StsAutoTrace = -8;
    public static final int StsBackTrace = -1;
    public static final int StsBadArg = -5;
    public static final int StsBadFlag = -206;
    public static final int StsBadFunc = -6;
    public static final int StsBadMask = -208;
    public static final int StsBadMemBlock = -214;
    public static final int StsBadPoint = -207;
    public static final int StsBadSize = -201;
    public static final int StsDivByZero = -202;
    public static final int StsError = -2;
    public static final int StsFilterOffsetErr = -31;
    public static final int StsFilterStructContentErr = -29;
    public static final int StsInplaceNotSupported = -203;
    public static final int StsInternal = -3;
    public static final int StsKernelStructContentErr = -30;
    public static final int StsNoConv = -7;
    public static final int StsNoMem = -4;
    public static final int StsNotImplemented = -213;
    public static final int StsNullPtr = -27;
    public static final int StsObjectNotFound = -204;
    public static final int StsOk = 0;
    public static final int StsOutOfRange = -211;
    public static final int StsParseError = -212;
    public static final int StsUnmatchedFormats = -205;
    public static final int StsUnmatchedSizes = -209;
    public static final int StsUnsupportedFormat = -210;
    public static final int StsVecLengthErr = -28;
    public static final String VERSION = getVersion();
    public static final String NATIVE_LIBRARY_NAME = getNativeLibraryName();
    public static final int VERSION_MAJOR = getVersionMajorJ();
    public static final int VERSION_MINOR = getVersionMinorJ();
    public static final int VERSION_REVISION = getVersionRevisionJ();
    public static final String VERSION_STATUS = getVersionStatusJ();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MinMaxLocResult {
        public double minVal = 0.0d;
        public double maxVal = 0.0d;
        public Point minLoc = new Point();
        public Point maxLoc = new Point();
    }

    public static void LUT(Mat mat, Mat mat2, Mat mat3) {
        LUT_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void LUT_0(long j6, long j7, long j8);

    public static double Mahalanobis(Mat mat, Mat mat2, Mat mat3) {
        return Mahalanobis_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native double Mahalanobis_0(long j6, long j7, long j8);

    public static void PCABackProject(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCABackProject_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void PCABackProject_0(long j6, long j7, long j8, long j9);

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3, int i5) {
        PCACompute_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i5) {
        PCACompute2_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5);
    }

    private static native void PCACompute2_0(long j6, long j7, long j8, long j9, int i5);

    private static native void PCACompute2_1(long j6, long j7, long j8, long j9);

    private static native void PCACompute2_2(long j6, long j7, long j8, long j9, double d);

    private static native void PCACompute_0(long j6, long j7, long j8, int i5);

    private static native void PCACompute_1(long j6, long j7, long j8);

    private static native void PCACompute_2(long j6, long j7, long j8, double d);

    public static void PCAProject(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCAProject_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void PCAProject_0(long j6, long j7, long j8, long j9);

    public static double PSNR(Mat mat, Mat mat2, double d) {
        return PSNR_0(mat.nativeObj, mat2.nativeObj, d);
    }

    private static native double PSNR_0(long j6, long j7, double d);

    private static native double PSNR_1(long j6, long j7);

    public static void SVBackSubst(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        SVBackSubst_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    private static native void SVBackSubst_0(long j6, long j7, long j8, long j9, long j10);

    public static void SVDecomp(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i5) {
        SVDecomp_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5);
    }

    private static native void SVDecomp_0(long j6, long j7, long j8, long j9, int i5);

    private static native void SVDecomp_1(long j6, long j7, long j8, long j9);

    public static void absdiff(Mat mat, Mat mat2, Mat mat3) {
        absdiff_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void absdiff_0(long j6, long j7, long j8);

    private static native void absdiff_1(long j6, double d, double d6, double d7, double d8, long j7);

    public static void add(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i5) {
        add_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5);
    }

    public static void addSamplesDataSearchPath(String str) {
        addSamplesDataSearchPath_0(str);
    }

    private static native void addSamplesDataSearchPath_0(String str);

    public static void addSamplesDataSearchSubDirectory(String str) {
        addSamplesDataSearchSubDirectory_0(str);
    }

    private static native void addSamplesDataSearchSubDirectory_0(String str);

    public static void addWeighted(Mat mat, double d, Mat mat2, double d6, double d7, Mat mat3, int i5) {
        addWeighted_0(mat.nativeObj, d, mat2.nativeObj, d6, d7, mat3.nativeObj, i5);
    }

    private static native void addWeighted_0(long j6, double d, long j7, double d6, double d7, long j8, int i5);

    private static native void addWeighted_1(long j6, double d, long j7, double d6, double d7, long j8);

    private static native void add_0(long j6, long j7, long j8, long j9, int i5);

    private static native void add_1(long j6, long j7, long j8, long j9);

    private static native void add_2(long j6, long j7, long j8);

    private static native void add_3(long j6, double d, double d6, double d7, double d8, long j7, long j8, int i5);

    private static native void add_4(long j6, double d, double d6, double d7, double d8, long j7, long j8);

    private static native void add_5(long j6, double d, double d6, double d7, double d8, long j7);

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i5, Mat mat4, int i6, int i7, Mat mat5, int i8, boolean z6) {
        batchDistance_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, mat4.nativeObj, i6, i7, mat5.nativeObj, i8, z6);
    }

    private static native void batchDistance_0(long j6, long j7, long j8, int i5, long j9, int i6, int i7, long j10, int i8, boolean z6);

    private static native void batchDistance_1(long j6, long j7, long j8, int i5, long j9, int i6, int i7, long j10, int i8);

    private static native void batchDistance_2(long j6, long j7, long j8, int i5, long j9, int i6, int i7, long j10);

    private static native void batchDistance_3(long j6, long j7, long j8, int i5, long j9, int i6, int i7);

    private static native void batchDistance_4(long j6, long j7, long j8, int i5, long j9, int i6);

    private static native void batchDistance_5(long j6, long j7, long j8, int i5, long j9);

    public static void bitwise_and(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_and_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void bitwise_and_0(long j6, long j7, long j8, long j9);

    private static native void bitwise_and_1(long j6, long j7, long j8);

    public static void bitwise_not(Mat mat, Mat mat2, Mat mat3) {
        bitwise_not_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void bitwise_not_0(long j6, long j7, long j8);

    private static native void bitwise_not_1(long j6, long j7);

    public static void bitwise_or(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_or_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void bitwise_or_0(long j6, long j7, long j8, long j9);

    private static native void bitwise_or_1(long j6, long j7, long j8);

    public static void bitwise_xor(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_xor_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void bitwise_xor_0(long j6, long j7, long j8, long j9);

    private static native void bitwise_xor_1(long j6, long j7, long j8);

    public static int borderInterpolate(int i5, int i6, int i7) {
        return borderInterpolate_0(i5, i6, i7);
    }

    private static native int borderInterpolate_0(int i5, int i6, int i7);

    public static void calcCovarMatrix(Mat mat, Mat mat2, Mat mat3, int i5, int i6) {
        calcCovarMatrix_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, i6);
    }

    private static native void calcCovarMatrix_0(long j6, long j7, long j8, int i5, int i6);

    private static native void calcCovarMatrix_1(long j6, long j7, long j8, int i5);

    public static void cartToPolar(Mat mat, Mat mat2, Mat mat3, Mat mat4, boolean z6) {
        cartToPolar_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, z6);
    }

    private static native void cartToPolar_0(long j6, long j7, long j8, long j9, boolean z6);

    private static native void cartToPolar_1(long j6, long j7, long j8, long j9);

    public static boolean checkHardwareSupport(int i5) {
        return checkHardwareSupport_0(i5);
    }

    private static native boolean checkHardwareSupport_0(int i5);

    public static boolean checkRange(Mat mat, boolean z6, double d, double d6) {
        return checkRange_0(mat.nativeObj, z6, d, d6);
    }

    private static native boolean checkRange_0(long j6, boolean z6, double d, double d6);

    private static native boolean checkRange_1(long j6, boolean z6, double d);

    private static native boolean checkRange_2(long j6, boolean z6);

    private static native boolean checkRange_4(long j6);

    public static void compare(Mat mat, Mat mat2, Mat mat3, int i5) {
        compare_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5);
    }

    private static native void compare_0(long j6, long j7, long j8, int i5);

    private static native void compare_1(long j6, double d, double d6, double d7, double d8, long j7, int i5);

    public static void completeSymm(Mat mat, boolean z6) {
        completeSymm_0(mat.nativeObj, z6);
    }

    private static native void completeSymm_0(long j6, boolean z6);

    private static native void completeSymm_1(long j6);

    public static void convertFp16(Mat mat, Mat mat2) {
        convertFp16_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void convertFp16_0(long j6, long j7);

    public static void convertScaleAbs(Mat mat, Mat mat2, double d, double d6) {
        convertScaleAbs_0(mat.nativeObj, mat2.nativeObj, d, d6);
    }

    private static native void convertScaleAbs_0(long j6, long j7, double d, double d6);

    private static native void convertScaleAbs_1(long j6, long j7, double d);

    private static native void convertScaleAbs_2(long j6, long j7);

    public static void copyMakeBorder(Mat mat, Mat mat2, int i5, int i6, int i7, int i8, int i9, Scalar scalar) {
        long j6 = mat.nativeObj;
        long j7 = mat2.nativeObj;
        double[] dArr = scalar.val;
        copyMakeBorder_0(j6, j7, i5, i6, i7, i8, i9, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void copyMakeBorder_0(long j6, long j7, int i5, int i6, int i7, int i8, int i9, double d, double d6, double d7, double d8);

    private static native void copyMakeBorder_1(long j6, long j7, int i5, int i6, int i7, int i8, int i9);

    public static void copyTo(Mat mat, Mat mat2, Mat mat3) {
        copyTo_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void copyTo_0(long j6, long j7, long j8);

    public static int countNonZero(Mat mat) {
        return countNonZero_0(mat.nativeObj);
    }

    private static native int countNonZero_0(long j6);

    public static float cubeRoot(float f6) {
        return cubeRoot_0(f6);
    }

    private static native float cubeRoot_0(float f6);

    public static void dct(Mat mat, Mat mat2, int i5) {
        dct_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native void dct_0(long j6, long j7, int i5);

    private static native void dct_1(long j6, long j7);

    public static double determinant(Mat mat) {
        return determinant_0(mat.nativeObj);
    }

    private static native double determinant_0(long j6);

    public static void dft(Mat mat, Mat mat2, int i5, int i6) {
        dft_0(mat.nativeObj, mat2.nativeObj, i5, i6);
    }

    private static native void dft_0(long j6, long j7, int i5, int i6);

    private static native void dft_1(long j6, long j7, int i5);

    private static native void dft_2(long j6, long j7);

    public static void divide(Mat mat, Mat mat2, Mat mat3, double d, int i5) {
        divide_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d, i5);
    }

    private static native void divide_0(long j6, long j7, long j8, double d, int i5);

    private static native void divide_1(long j6, long j7, long j8, double d);

    private static native void divide_2(long j6, long j7, long j8);

    private static native void divide_3(double d, long j6, long j7, int i5);

    private static native void divide_4(double d, long j6, long j7);

    private static native void divide_5(long j6, double d, double d6, double d7, double d8, long j7, double d9, int i5);

    private static native void divide_6(long j6, double d, double d6, double d7, double d8, long j7, double d9);

    private static native void divide_7(long j6, double d, double d6, double d7, double d8, long j7);

    public static boolean eigen(Mat mat, Mat mat2, Mat mat3) {
        return eigen_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void eigenNonSymmetric(Mat mat, Mat mat2, Mat mat3) {
        eigenNonSymmetric_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void eigenNonSymmetric_0(long j6, long j7, long j8);

    private static native boolean eigen_0(long j6, long j7, long j8);

    private static native boolean eigen_1(long j6, long j7);

    public static void exp(Mat mat, Mat mat2) {
        exp_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void exp_0(long j6, long j7);

    public static void extractChannel(Mat mat, Mat mat2, int i5) {
        extractChannel_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native void extractChannel_0(long j6, long j7, int i5);

    public static float fastAtan2(float f6, float f7) {
        return fastAtan2_0(f6, f7);
    }

    private static native float fastAtan2_0(float f6, float f7);

    public static String findFile(String str, boolean z6, boolean z7) {
        return findFile_0(str, z6, z7);
    }

    public static String findFileOrKeep(String str, boolean z6) {
        return findFileOrKeep_0(str, z6);
    }

    private static native String findFileOrKeep_0(String str, boolean z6);

    private static native String findFileOrKeep_1(String str);

    private static native String findFile_0(String str, boolean z6, boolean z7);

    private static native String findFile_1(String str, boolean z6);

    private static native String findFile_2(String str);

    public static void findNonZero(Mat mat, Mat mat2) {
        findNonZero_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void findNonZero_0(long j6, long j7);

    public static void flip(Mat mat, Mat mat2, int i5) {
        flip_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    public static void flipND(Mat mat, Mat mat2, int i5) {
        flipND_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native void flipND_0(long j6, long j7, int i5);

    private static native void flip_0(long j6, long j7, int i5);

    public static void gemm(Mat mat, Mat mat2, double d, Mat mat3, double d6, Mat mat4, int i5) {
        gemm_0(mat.nativeObj, mat2.nativeObj, d, mat3.nativeObj, d6, mat4.nativeObj, i5);
    }

    private static native void gemm_0(long j6, long j7, double d, long j8, double d6, long j9, int i5);

    private static native void gemm_1(long j6, long j7, double d, long j8, double d6, long j9);

    public static String getBuildInformation() {
        return getBuildInformation_0();
    }

    private static native String getBuildInformation_0();

    public static String getCPUFeaturesLine() {
        return getCPUFeaturesLine_0();
    }

    private static native String getCPUFeaturesLine_0();

    public static long getCPUTickCount() {
        return getCPUTickCount_0();
    }

    private static native long getCPUTickCount_0();

    public static String getHardwareFeatureName(int i5) {
        return getHardwareFeatureName_0(i5);
    }

    private static native String getHardwareFeatureName_0(int i5);

    public static String getIppVersion() {
        return getIppVersion_0();
    }

    private static native String getIppVersion_0();

    private static String getNativeLibraryName() {
        return "opencv_java480";
    }

    public static int getNumThreads() {
        return getNumThreads_0();
    }

    private static native int getNumThreads_0();

    public static int getNumberOfCPUs() {
        return getNumberOfCPUs_0();
    }

    private static native int getNumberOfCPUs_0();

    public static int getOptimalDFTSize(int i5) {
        return getOptimalDFTSize_0(i5);
    }

    private static native int getOptimalDFTSize_0(int i5);

    @Deprecated
    public static int getThreadNum() {
        return getThreadNum_0();
    }

    private static native int getThreadNum_0();

    public static long getTickCount() {
        return getTickCount_0();
    }

    private static native long getTickCount_0();

    public static double getTickFrequency() {
        return getTickFrequency_0();
    }

    private static native double getTickFrequency_0();

    private static String getVersion() {
        return OpenCVLoader.OPENCV_VERSION;
    }

    public static int getVersionMajor() {
        return getVersionMajor_0();
    }

    private static int getVersionMajorJ() {
        return 4;
    }

    private static native int getVersionMajor_0();

    public static int getVersionMinor() {
        return getVersionMinor_0();
    }

    private static int getVersionMinorJ() {
        return 8;
    }

    private static native int getVersionMinor_0();

    public static int getVersionRevision() {
        return getVersionRevision_0();
    }

    private static int getVersionRevisionJ() {
        return 0;
    }

    private static native int getVersionRevision_0();

    private static String getVersionStatusJ() {
        return "";
    }

    public static String getVersionString() {
        return getVersionString_0();
    }

    private static native String getVersionString_0();

    public static boolean hasNonZero(Mat mat) {
        return hasNonZero_0(mat.nativeObj);
    }

    private static native boolean hasNonZero_0(long j6);

    public static void hconcat(List<Mat> list, Mat mat) {
        hconcat_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }

    private static native void hconcat_0(long j6, long j7);

    public static void idct(Mat mat, Mat mat2, int i5) {
        idct_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native void idct_0(long j6, long j7, int i5);

    private static native void idct_1(long j6, long j7);

    public static void idft(Mat mat, Mat mat2, int i5, int i6) {
        idft_0(mat.nativeObj, mat2.nativeObj, i5, i6);
    }

    private static native void idft_0(long j6, long j7, int i5, int i6);

    private static native void idft_1(long j6, long j7, int i5);

    private static native void idft_2(long j6, long j7);

    public static void inRange(Mat mat, Scalar scalar, Scalar scalar2, Mat mat2) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = dArr[3];
        double[] dArr2 = scalar2.val;
        inRange_0(j6, d, d6, d7, d8, dArr2[0], dArr2[1], dArr2[2], dArr2[3], mat2.nativeObj);
    }

    private static native void inRange_0(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, long j7);

    public static void insertChannel(Mat mat, Mat mat2, int i5) {
        insertChannel_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native void insertChannel_0(long j6, long j7, int i5);

    public static double invert(Mat mat, Mat mat2, int i5) {
        return invert_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native double invert_0(long j6, long j7, int i5);

    private static native double invert_1(long j6, long j7);

    public static double kmeans(Mat mat, int i5, Mat mat2, TermCriteria termCriteria, int i6, int i7, Mat mat3) {
        return kmeans_0(mat.nativeObj, i5, mat2.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i6, i7, mat3.nativeObj);
    }

    private static native double kmeans_0(long j6, int i5, long j7, int i6, int i7, double d, int i8, int i9, long j8);

    private static native double kmeans_1(long j6, int i5, long j7, int i6, int i7, double d, int i8, int i9);

    public static void log(Mat mat, Mat mat2) {
        log_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void log_0(long j6, long j7);

    public static void magnitude(Mat mat, Mat mat2, Mat mat3) {
        magnitude_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void magnitude_0(long j6, long j7, long j8);

    public static void max(Mat mat, Mat mat2, Mat mat3) {
        max_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void max_0(long j6, long j7, long j8);

    private static native void max_1(long j6, double d, double d6, double d7, double d8, long j7);

    public static Scalar mean(Mat mat, Mat mat2) {
        return new Scalar(mean_0(mat.nativeObj, mat2.nativeObj));
    }

    public static void meanStdDev(Mat mat, MatOfDouble matOfDouble, MatOfDouble matOfDouble2, Mat mat2) {
        meanStdDev_0(mat.nativeObj, matOfDouble.nativeObj, matOfDouble2.nativeObj, mat2.nativeObj);
    }

    private static native void meanStdDev_0(long j6, long j7, long j8, long j9);

    private static native void meanStdDev_1(long j6, long j7, long j8);

    private static native double[] mean_0(long j6, long j7);

    private static native double[] mean_1(long j6);

    public static void merge(List<Mat> list, Mat mat) {
        merge_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }

    private static native void merge_0(long j6, long j7);

    public static void min(Mat mat, Mat mat2, Mat mat3) {
        min_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static MinMaxLocResult minMaxLoc(Mat mat, Mat mat2) {
        MinMaxLocResult minMaxLocResult = new MinMaxLocResult();
        double[] dArrN_minMaxLocManual = n_minMaxLocManual(mat.nativeObj, mat2 != null ? mat2.nativeObj : 0L);
        minMaxLocResult.minVal = dArrN_minMaxLocManual[0];
        minMaxLocResult.maxVal = dArrN_minMaxLocManual[1];
        Point point = minMaxLocResult.minLoc;
        point.f7681x = dArrN_minMaxLocManual[2];
        point.f7682y = dArrN_minMaxLocManual[3];
        Point point2 = minMaxLocResult.maxLoc;
        point2.f7681x = dArrN_minMaxLocManual[4];
        point2.f7682y = dArrN_minMaxLocManual[5];
        return minMaxLocResult;
    }

    private static native void min_0(long j6, long j7, long j8);

    private static native void min_1(long j6, double d, double d6, double d7, double d8, long j7);

    public static void mixChannels(List<Mat> list, List<Mat> list2, MatOfInt matOfInt) {
        mixChannels_0(Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, matOfInt.nativeObj);
    }

    private static native void mixChannels_0(long j6, long j7, long j8);

    public static void mulSpectrums(Mat mat, Mat mat2, Mat mat3, int i5, boolean z6) {
        mulSpectrums_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, z6);
    }

    private static native void mulSpectrums_0(long j6, long j7, long j8, int i5, boolean z6);

    private static native void mulSpectrums_1(long j6, long j7, long j8, int i5);

    public static void mulTransposed(Mat mat, Mat mat2, boolean z6, Mat mat3, double d, int i5) {
        mulTransposed_0(mat.nativeObj, mat2.nativeObj, z6, mat3.nativeObj, d, i5);
    }

    private static native void mulTransposed_0(long j6, long j7, boolean z6, long j8, double d, int i5);

    private static native void mulTransposed_1(long j6, long j7, boolean z6, long j8, double d);

    private static native void mulTransposed_2(long j6, long j7, boolean z6, long j8);

    private static native void mulTransposed_3(long j6, long j7, boolean z6);

    public static void multiply(Mat mat, Mat mat2, Mat mat3, double d, int i5) {
        multiply_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d, i5);
    }

    private static native void multiply_0(long j6, long j7, long j8, double d, int i5);

    private static native void multiply_1(long j6, long j7, long j8, double d);

    private static native void multiply_2(long j6, long j7, long j8);

    private static native void multiply_3(long j6, double d, double d6, double d7, double d8, long j7, double d9, int i5);

    private static native void multiply_4(long j6, double d, double d6, double d7, double d8, long j7, double d9);

    private static native void multiply_5(long j6, double d, double d6, double d7, double d8, long j7);

    private static native double[] n_minMaxLocManual(long j6, long j7);

    public static double norm(Mat mat, int i5, Mat mat2) {
        return norm_0(mat.nativeObj, i5, mat2.nativeObj);
    }

    private static native double norm_0(long j6, int i5, long j7);

    private static native double norm_1(long j6, int i5);

    private static native double norm_2(long j6);

    private static native double norm_3(long j6, long j7, int i5, long j8);

    private static native double norm_4(long j6, long j7, int i5);

    private static native double norm_5(long j6, long j7);

    public static void normalize(Mat mat, Mat mat2, double d, double d6, int i5, int i6, Mat mat3) {
        normalize_0(mat.nativeObj, mat2.nativeObj, d, d6, i5, i6, mat3.nativeObj);
    }

    private static native void normalize_0(long j6, long j7, double d, double d6, int i5, int i6, long j8);

    private static native void normalize_1(long j6, long j7, double d, double d6, int i5, int i6);

    private static native void normalize_2(long j6, long j7, double d, double d6, int i5);

    private static native void normalize_3(long j6, long j7, double d, double d6);

    private static native void normalize_4(long j6, long j7, double d);

    private static native void normalize_5(long j6, long j7);

    public static void patchNaNs(Mat mat, double d) {
        patchNaNs_0(mat.nativeObj, d);
    }

    private static native void patchNaNs_0(long j6, double d);

    private static native void patchNaNs_1(long j6);

    public static void perspectiveTransform(Mat mat, Mat mat2, Mat mat3) {
        perspectiveTransform_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void perspectiveTransform_0(long j6, long j7, long j8);

    public static void phase(Mat mat, Mat mat2, Mat mat3, boolean z6) {
        phase_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, z6);
    }

    private static native void phase_0(long j6, long j7, long j8, boolean z6);

    private static native void phase_1(long j6, long j7, long j8);

    public static void polarToCart(Mat mat, Mat mat2, Mat mat3, Mat mat4, boolean z6) {
        polarToCart_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, z6);
    }

    private static native void polarToCart_0(long j6, long j7, long j8, long j9, boolean z6);

    private static native void polarToCart_1(long j6, long j7, long j8, long j9);

    public static void pow(Mat mat, double d, Mat mat2) {
        pow_0(mat.nativeObj, d, mat2.nativeObj);
    }

    private static native void pow_0(long j6, double d, long j7);

    public static void randShuffle(Mat mat, double d) {
        randShuffle_0(mat.nativeObj, d);
    }

    private static native void randShuffle_0(long j6, double d);

    private static native void randShuffle_2(long j6);

    public static void randn(Mat mat, double d, double d6) {
        randn_0(mat.nativeObj, d, d6);
    }

    private static native void randn_0(long j6, double d, double d6);

    public static void randu(Mat mat, double d, double d6) {
        randu_0(mat.nativeObj, d, d6);
    }

    private static native void randu_0(long j6, double d, double d6);

    public static void reduce(Mat mat, Mat mat2, int i5, int i6, int i7) {
        reduce_0(mat.nativeObj, mat2.nativeObj, i5, i6, i7);
    }

    public static void reduceArgMax(Mat mat, Mat mat2, int i5, boolean z6) {
        reduceArgMax_0(mat.nativeObj, mat2.nativeObj, i5, z6);
    }

    private static native void reduceArgMax_0(long j6, long j7, int i5, boolean z6);

    private static native void reduceArgMax_1(long j6, long j7, int i5);

    public static void reduceArgMin(Mat mat, Mat mat2, int i5, boolean z6) {
        reduceArgMin_0(mat.nativeObj, mat2.nativeObj, i5, z6);
    }

    private static native void reduceArgMin_0(long j6, long j7, int i5, boolean z6);

    private static native void reduceArgMin_1(long j6, long j7, int i5);

    private static native void reduce_0(long j6, long j7, int i5, int i6, int i7);

    private static native void reduce_1(long j6, long j7, int i5, int i6);

    public static void repeat(Mat mat, int i5, int i6, Mat mat2) {
        repeat_0(mat.nativeObj, i5, i6, mat2.nativeObj);
    }

    private static native void repeat_0(long j6, int i5, int i6, long j7);

    public static void rotate(Mat mat, Mat mat2, int i5) {
        rotate_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native void rotate_0(long j6, long j7, int i5);

    public static void scaleAdd(Mat mat, double d, Mat mat2, Mat mat3) {
        scaleAdd_0(mat.nativeObj, d, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void scaleAdd_0(long j6, double d, long j7, long j8);

    public static void setErrorVerbosity(boolean z6) {
        setErrorVerbosity_0(z6);
    }

    private static native void setErrorVerbosity_0(boolean z6);

    public static void setIdentity(Mat mat, Scalar scalar) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        setIdentity_0(j6, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void setIdentity_0(long j6, double d, double d6, double d7, double d8);

    private static native void setIdentity_1(long j6);

    public static void setNumThreads(int i5) {
        setNumThreads_0(i5);
    }

    private static native void setNumThreads_0(int i5);

    public static void setRNGSeed(int i5) {
        setRNGSeed_0(i5);
    }

    private static native void setRNGSeed_0(int i5);

    public static void setUseIPP(boolean z6) {
        setUseIPP_0(z6);
    }

    private static native void setUseIPP_0(boolean z6);

    public static void setUseIPP_NotExact(boolean z6) {
        setUseIPP_NotExact_0(z6);
    }

    private static native void setUseIPP_NotExact_0(boolean z6);

    public static void setUseOptimized(boolean z6) {
        setUseOptimized_0(z6);
    }

    private static native void setUseOptimized_0(boolean z6);

    public static boolean solve(Mat mat, Mat mat2, Mat mat3, int i5) {
        return solve_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5);
    }

    public static int solveCubic(Mat mat, Mat mat2) {
        return solveCubic_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native int solveCubic_0(long j6, long j7);

    public static double solvePoly(Mat mat, Mat mat2, int i5) {
        return solvePoly_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native double solvePoly_0(long j6, long j7, int i5);

    private static native double solvePoly_1(long j6, long j7);

    private static native boolean solve_0(long j6, long j7, long j8, int i5);

    private static native boolean solve_1(long j6, long j7, long j8);

    public static void sort(Mat mat, Mat mat2, int i5) {
        sort_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    public static void sortIdx(Mat mat, Mat mat2, int i5) {
        sortIdx_0(mat.nativeObj, mat2.nativeObj, i5);
    }

    private static native void sortIdx_0(long j6, long j7, int i5);

    private static native void sort_0(long j6, long j7, int i5);

    public static void split(Mat mat, List<Mat> list) {
        Mat mat2 = new Mat();
        split_0(mat.nativeObj, mat2.nativeObj);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
    }

    private static native void split_0(long j6, long j7);

    public static void sqrt(Mat mat, Mat mat2) {
        sqrt_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void sqrt_0(long j6, long j7);

    public static void subtract(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i5) {
        subtract_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i5);
    }

    private static native void subtract_0(long j6, long j7, long j8, long j9, int i5);

    private static native void subtract_1(long j6, long j7, long j8, long j9);

    private static native void subtract_2(long j6, long j7, long j8);

    private static native void subtract_3(long j6, double d, double d6, double d7, double d8, long j7, long j8, int i5);

    private static native void subtract_4(long j6, double d, double d6, double d7, double d8, long j7, long j8);

    private static native void subtract_5(long j6, double d, double d6, double d7, double d8, long j7);

    public static Scalar sumElems(Mat mat) {
        return new Scalar(sumElems_0(mat.nativeObj));
    }

    private static native double[] sumElems_0(long j6);

    public static Scalar trace(Mat mat) {
        return new Scalar(trace_0(mat.nativeObj));
    }

    private static native double[] trace_0(long j6);

    public static void transform(Mat mat, Mat mat2, Mat mat3) {
        transform_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void transform_0(long j6, long j7, long j8);

    public static void transpose(Mat mat, Mat mat2) {
        transpose_0(mat.nativeObj, mat2.nativeObj);
    }

    public static void transposeND(Mat mat, MatOfInt matOfInt, Mat mat2) {
        transposeND_0(mat.nativeObj, matOfInt.nativeObj, mat2.nativeObj);
    }

    private static native void transposeND_0(long j6, long j7, long j8);

    private static native void transpose_0(long j6, long j7);

    public static boolean useIPP() {
        return useIPP_0();
    }

    private static native boolean useIPP_0();

    public static boolean useIPP_NotExact() {
        return useIPP_NotExact_0();
    }

    private static native boolean useIPP_NotExact_0();

    public static boolean useOptimized() {
        return useOptimized_0();
    }

    private static native boolean useOptimized_0();

    public static void vconcat(List<Mat> list, Mat mat) {
        vconcat_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }

    private static native void vconcat_0(long j6, long j7);

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3) {
        PCACompute_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCACompute2_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static double PSNR(Mat mat, Mat mat2) {
        return PSNR_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void SVDecomp(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        SVDecomp_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void absdiff(Mat mat, Scalar scalar, Mat mat2) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        absdiff_1(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void add(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        add_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void addWeighted(Mat mat, double d, Mat mat2, double d6, double d7, Mat mat3) {
        addWeighted_1(mat.nativeObj, d, mat2.nativeObj, d6, d7, mat3.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i5, Mat mat4, int i6, int i7, Mat mat5, int i8) {
        batchDistance_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, mat4.nativeObj, i6, i7, mat5.nativeObj, i8);
    }

    public static void bitwise_and(Mat mat, Mat mat2, Mat mat3) {
        bitwise_and_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void bitwise_not(Mat mat, Mat mat2) {
        bitwise_not_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void bitwise_or(Mat mat, Mat mat2, Mat mat3) {
        bitwise_or_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void bitwise_xor(Mat mat, Mat mat2, Mat mat3) {
        bitwise_xor_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void calcCovarMatrix(Mat mat, Mat mat2, Mat mat3, int i5) {
        calcCovarMatrix_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5);
    }

    public static void cartToPolar(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        cartToPolar_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static boolean checkRange(Mat mat, boolean z6, double d) {
        return checkRange_1(mat.nativeObj, z6, d);
    }

    public static void compare(Mat mat, Scalar scalar, Mat mat2, int i5) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        compare_1(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, i5);
    }

    public static void completeSymm(Mat mat) {
        completeSymm_1(mat.nativeObj);
    }

    public static void convertScaleAbs(Mat mat, Mat mat2, double d) {
        convertScaleAbs_1(mat.nativeObj, mat2.nativeObj, d);
    }

    public static void copyMakeBorder(Mat mat, Mat mat2, int i5, int i6, int i7, int i8, int i9) {
        copyMakeBorder_1(mat.nativeObj, mat2.nativeObj, i5, i6, i7, i8, i9);
    }

    public static void dct(Mat mat, Mat mat2) {
        dct_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void dft(Mat mat, Mat mat2, int i5) {
        dft_1(mat.nativeObj, mat2.nativeObj, i5);
    }

    public static void divide(Mat mat, Mat mat2, Mat mat3, double d) {
        divide_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d);
    }

    public static boolean eigen(Mat mat, Mat mat2) {
        return eigen_1(mat.nativeObj, mat2.nativeObj);
    }

    public static String findFile(String str, boolean z6) {
        return findFile_1(str, z6);
    }

    public static String findFileOrKeep(String str) {
        return findFileOrKeep_1(str);
    }

    public static void gemm(Mat mat, Mat mat2, double d, Mat mat3, double d6, Mat mat4) {
        gemm_1(mat.nativeObj, mat2.nativeObj, d, mat3.nativeObj, d6, mat4.nativeObj);
    }

    public static void idct(Mat mat, Mat mat2) {
        idct_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void idft(Mat mat, Mat mat2, int i5) {
        idft_1(mat.nativeObj, mat2.nativeObj, i5);
    }

    public static double invert(Mat mat, Mat mat2) {
        return invert_1(mat.nativeObj, mat2.nativeObj);
    }

    public static double kmeans(Mat mat, int i5, Mat mat2, TermCriteria termCriteria, int i6, int i7) {
        return kmeans_1(mat.nativeObj, i5, mat2.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i6, i7);
    }

    public static void max(Mat mat, Scalar scalar, Mat mat2) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        max_1(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static Scalar mean(Mat mat) {
        return new Scalar(mean_1(mat.nativeObj));
    }

    public static void meanStdDev(Mat mat, MatOfDouble matOfDouble, MatOfDouble matOfDouble2) {
        meanStdDev_1(mat.nativeObj, matOfDouble.nativeObj, matOfDouble2.nativeObj);
    }

    public static void min(Mat mat, Scalar scalar, Mat mat2) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        min_1(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void mulSpectrums(Mat mat, Mat mat2, Mat mat3, int i5) {
        mulSpectrums_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z6, Mat mat3, double d) {
        mulTransposed_1(mat.nativeObj, mat2.nativeObj, z6, mat3.nativeObj, d);
    }

    public static void multiply(Mat mat, Mat mat2, Mat mat3, double d) {
        multiply_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d);
    }

    public static double norm(Mat mat, int i5) {
        return norm_1(mat.nativeObj, i5);
    }

    public static void normalize(Mat mat, Mat mat2, double d, double d6, int i5, int i6) {
        normalize_1(mat.nativeObj, mat2.nativeObj, d, d6, i5, i6);
    }

    public static void patchNaNs(Mat mat) {
        patchNaNs_1(mat.nativeObj);
    }

    public static void phase(Mat mat, Mat mat2, Mat mat3) {
        phase_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void polarToCart(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        polarToCart_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void randShuffle(Mat mat) {
        randShuffle_2(mat.nativeObj);
    }

    public static void reduce(Mat mat, Mat mat2, int i5, int i6) {
        reduce_1(mat.nativeObj, mat2.nativeObj, i5, i6);
    }

    public static void reduceArgMax(Mat mat, Mat mat2, int i5) {
        reduceArgMax_1(mat.nativeObj, mat2.nativeObj, i5);
    }

    public static void reduceArgMin(Mat mat, Mat mat2, int i5) {
        reduceArgMin_1(mat.nativeObj, mat2.nativeObj, i5);
    }

    public static void setIdentity(Mat mat) {
        setIdentity_1(mat.nativeObj);
    }

    public static boolean solve(Mat mat, Mat mat2, Mat mat3) {
        return solve_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static double solvePoly(Mat mat, Mat mat2) {
        return solvePoly_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void subtract(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        subtract_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3, double d) {
        PCACompute_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d) {
        PCACompute2_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, d);
    }

    public static void add(Mat mat, Mat mat2, Mat mat3) {
        add_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i5, Mat mat4, int i6, int i7, Mat mat5) {
        batchDistance_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, mat4.nativeObj, i6, i7, mat5.nativeObj);
    }

    public static boolean checkRange(Mat mat, boolean z6) {
        return checkRange_2(mat.nativeObj, z6);
    }

    public static void convertScaleAbs(Mat mat, Mat mat2) {
        convertScaleAbs_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void dft(Mat mat, Mat mat2) {
        dft_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void divide(Mat mat, Mat mat2, Mat mat3) {
        divide_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static String findFile(String str) {
        return findFile_2(str);
    }

    public static void idft(Mat mat, Mat mat2) {
        idft_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z6, Mat mat3) {
        mulTransposed_2(mat.nativeObj, mat2.nativeObj, z6, mat3.nativeObj);
    }

    public static void multiply(Mat mat, Mat mat2, Mat mat3) {
        multiply_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static double norm(Mat mat) {
        return norm_2(mat.nativeObj);
    }

    public static void normalize(Mat mat, Mat mat2, double d, double d6, int i5) {
        normalize_2(mat.nativeObj, mat2.nativeObj, d, d6, i5);
    }

    public static void subtract(Mat mat, Mat mat2, Mat mat3) {
        subtract_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2, Mat mat3, int i5) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        add_3(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, mat3.nativeObj, i5);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i5, Mat mat4, int i6, int i7) {
        batchDistance_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, mat4.nativeObj, i6, i7);
    }

    public static boolean checkRange(Mat mat) {
        return checkRange_4(mat.nativeObj);
    }

    public static void divide(double d, Mat mat, Mat mat2, int i5) {
        divide_3(d, mat.nativeObj, mat2.nativeObj, i5);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z6) {
        mulTransposed_3(mat.nativeObj, mat2.nativeObj, z6);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2, double d, int i5) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        multiply_3(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, d, i5);
    }

    public static double norm(Mat mat, Mat mat2, int i5, Mat mat3) {
        return norm_3(mat.nativeObj, mat2.nativeObj, i5, mat3.nativeObj);
    }

    public static void normalize(Mat mat, Mat mat2, double d, double d6) {
        normalize_3(mat.nativeObj, mat2.nativeObj, d, d6);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2, Mat mat3, int i5) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        subtract_3(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, mat3.nativeObj, i5);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2, Mat mat3) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        add_4(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, mat3.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i5, Mat mat4, int i6) {
        batchDistance_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, mat4.nativeObj, i6);
    }

    public static void divide(double d, Mat mat, Mat mat2) {
        divide_4(d, mat.nativeObj, mat2.nativeObj);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2, double d) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        multiply_4(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, d);
    }

    public static double norm(Mat mat, Mat mat2, int i5) {
        return norm_4(mat.nativeObj, mat2.nativeObj, i5);
    }

    public static void normalize(Mat mat, Mat mat2, double d) {
        normalize_4(mat.nativeObj, mat2.nativeObj, d);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2, Mat mat3) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        subtract_4(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, mat3.nativeObj);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        add_5(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i5, Mat mat4) {
        batchDistance_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i5, mat4.nativeObj);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2, double d, int i5) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        divide_5(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, d, i5);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        multiply_5(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static double norm(Mat mat, Mat mat2) {
        return norm_5(mat.nativeObj, mat2.nativeObj);
    }

    public static void normalize(Mat mat, Mat mat2) {
        normalize_5(mat.nativeObj, mat2.nativeObj);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        subtract_5(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2, double d) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        divide_6(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, d);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2) {
        long j6 = mat.nativeObj;
        double[] dArr = scalar.val;
        divide_7(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static MinMaxLocResult minMaxLoc(Mat mat) {
        return minMaxLoc(mat, null);
    }
}
