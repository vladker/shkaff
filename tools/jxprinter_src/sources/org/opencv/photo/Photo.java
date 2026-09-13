package org.opencv.photo;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Point;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Photo {
    public static final int INPAINT_NS = 0;
    public static final int INPAINT_TELEA = 1;
    public static final int LDR_SIZE = 256;
    public static final int MIXED_CLONE = 2;
    public static final int MONOCHROME_TRANSFER = 3;
    public static final int NORMAL_CLONE = 1;
    public static final int NORMCONV_FILTER = 2;
    public static final int RECURS_FILTER = 1;

    public static void colorChange(Mat mat, Mat mat2, Mat mat3, float f6, float f7, float f8) {
        colorChange_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6, f7, f8);
    }

    private static native void colorChange_0(long j6, long j7, long j8, float f6, float f7, float f8);

    private static native void colorChange_1(long j6, long j7, long j8, float f6, float f7);

    private static native void colorChange_2(long j6, long j7, long j8, float f6);

    private static native void colorChange_3(long j6, long j7, long j8);

    public static AlignMTB createAlignMTB(int i5, int i6, boolean z6) {
        return AlignMTB.__fromPtr__(createAlignMTB_0(i5, i6, z6));
    }

    private static native long createAlignMTB_0(int i5, int i6, boolean z6);

    private static native long createAlignMTB_1(int i5, int i6);

    private static native long createAlignMTB_2(int i5);

    private static native long createAlignMTB_3();

    public static CalibrateDebevec createCalibrateDebevec(int i5, float f6, boolean z6) {
        return CalibrateDebevec.__fromPtr__(createCalibrateDebevec_0(i5, f6, z6));
    }

    private static native long createCalibrateDebevec_0(int i5, float f6, boolean z6);

    private static native long createCalibrateDebevec_1(int i5, float f6);

    private static native long createCalibrateDebevec_2(int i5);

    private static native long createCalibrateDebevec_3();

    public static CalibrateRobertson createCalibrateRobertson(int i5, float f6) {
        return CalibrateRobertson.__fromPtr__(createCalibrateRobertson_0(i5, f6));
    }

    private static native long createCalibrateRobertson_0(int i5, float f6);

    private static native long createCalibrateRobertson_1(int i5);

    private static native long createCalibrateRobertson_2();

    public static MergeDebevec createMergeDebevec() {
        return MergeDebevec.__fromPtr__(createMergeDebevec_0());
    }

    private static native long createMergeDebevec_0();

    public static MergeMertens createMergeMertens(float f6, float f7, float f8) {
        return MergeMertens.__fromPtr__(createMergeMertens_0(f6, f7, f8));
    }

    private static native long createMergeMertens_0(float f6, float f7, float f8);

    private static native long createMergeMertens_1(float f6, float f7);

    private static native long createMergeMertens_2(float f6);

    private static native long createMergeMertens_3();

    public static MergeRobertson createMergeRobertson() {
        return MergeRobertson.__fromPtr__(createMergeRobertson_0());
    }

    private static native long createMergeRobertson_0();

    public static Tonemap createTonemap(float f6) {
        return Tonemap.__fromPtr__(createTonemap_0(f6));
    }

    public static TonemapDrago createTonemapDrago(float f6, float f7, float f8) {
        return TonemapDrago.__fromPtr__(createTonemapDrago_0(f6, f7, f8));
    }

    private static native long createTonemapDrago_0(float f6, float f7, float f8);

    private static native long createTonemapDrago_1(float f6, float f7);

    private static native long createTonemapDrago_2(float f6);

    private static native long createTonemapDrago_3();

    public static TonemapMantiuk createTonemapMantiuk(float f6, float f7, float f8) {
        return TonemapMantiuk.__fromPtr__(createTonemapMantiuk_0(f6, f7, f8));
    }

    private static native long createTonemapMantiuk_0(float f6, float f7, float f8);

    private static native long createTonemapMantiuk_1(float f6, float f7);

    private static native long createTonemapMantiuk_2(float f6);

    private static native long createTonemapMantiuk_3();

    public static TonemapReinhard createTonemapReinhard(float f6, float f7, float f8, float f9) {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_0(f6, f7, f8, f9));
    }

    private static native long createTonemapReinhard_0(float f6, float f7, float f8, float f9);

    private static native long createTonemapReinhard_1(float f6, float f7, float f8);

    private static native long createTonemapReinhard_2(float f6, float f7);

    private static native long createTonemapReinhard_3(float f6);

    private static native long createTonemapReinhard_4();

    private static native long createTonemap_0(float f6);

    private static native long createTonemap_1();

    public static void decolor(Mat mat, Mat mat2, Mat mat3) {
        decolor_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void decolor_0(long j6, long j7, long j8);

    public static void denoise_TVL1(List<Mat> list, Mat mat, double d, int i5) {
        denoise_TVL1_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, d, i5);
    }

    private static native void denoise_TVL1_0(long j6, long j7, double d, int i5);

    private static native void denoise_TVL1_1(long j6, long j7, double d);

    private static native void denoise_TVL1_2(long j6, long j7);

    public static void detailEnhance(Mat mat, Mat mat2, float f6, float f7) {
        detailEnhance_0(mat.nativeObj, mat2.nativeObj, f6, f7);
    }

    private static native void detailEnhance_0(long j6, long j7, float f6, float f7);

    private static native void detailEnhance_1(long j6, long j7, float f6);

    private static native void detailEnhance_2(long j6, long j7);

    public static void edgePreservingFilter(Mat mat, Mat mat2, int i5, float f6, float f7) {
        edgePreservingFilter_0(mat.nativeObj, mat2.nativeObj, i5, f6, f7);
    }

    private static native void edgePreservingFilter_0(long j6, long j7, int i5, float f6, float f7);

    private static native void edgePreservingFilter_1(long j6, long j7, int i5, float f6);

    private static native void edgePreservingFilter_2(long j6, long j7, int i5);

    private static native void edgePreservingFilter_3(long j6, long j7);

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, float f6, int i5, int i6) {
        fastNlMeansDenoising_0(mat.nativeObj, mat2.nativeObj, f6, i5, i6);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2, float f6, float f7, int i5, int i6) {
        fastNlMeansDenoisingColored_0(mat.nativeObj, mat2.nativeObj, f6, f7, i5, i6);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i5, int i6, float f6, float f7, int i7, int i8) {
        fastNlMeansDenoisingColoredMulti_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, f6, f7, i7, i8);
    }

    private static native void fastNlMeansDenoisingColoredMulti_0(long j6, long j7, int i5, int i6, float f6, float f7, int i7, int i8);

    private static native void fastNlMeansDenoisingColoredMulti_1(long j6, long j7, int i5, int i6, float f6, float f7, int i7);

    private static native void fastNlMeansDenoisingColoredMulti_2(long j6, long j7, int i5, int i6, float f6, float f7);

    private static native void fastNlMeansDenoisingColoredMulti_3(long j6, long j7, int i5, int i6, float f6);

    private static native void fastNlMeansDenoisingColoredMulti_4(long j6, long j7, int i5, int i6);

    private static native void fastNlMeansDenoisingColored_0(long j6, long j7, float f6, float f7, int i5, int i6);

    private static native void fastNlMeansDenoisingColored_1(long j6, long j7, float f6, float f7, int i5);

    private static native void fastNlMeansDenoisingColored_2(long j6, long j7, float f6, float f7);

    private static native void fastNlMeansDenoisingColored_3(long j6, long j7, float f6);

    private static native void fastNlMeansDenoisingColored_4(long j6, long j7);

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i5, int i6, float f6, int i7, int i8) {
        fastNlMeansDenoisingMulti_0(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, f6, i7, i8);
    }

    private static native void fastNlMeansDenoisingMulti_0(long j6, long j7, int i5, int i6, float f6, int i7, int i8);

    private static native void fastNlMeansDenoisingMulti_1(long j6, long j7, int i5, int i6, float f6, int i7);

    private static native void fastNlMeansDenoisingMulti_2(long j6, long j7, int i5, int i6, float f6);

    private static native void fastNlMeansDenoisingMulti_3(long j6, long j7, int i5, int i6);

    private static native void fastNlMeansDenoisingMulti_4(long j6, long j7, int i5, int i6, long j8, int i7, int i8, int i9);

    private static native void fastNlMeansDenoisingMulti_5(long j6, long j7, int i5, int i6, long j8, int i7, int i8);

    private static native void fastNlMeansDenoisingMulti_6(long j6, long j7, int i5, int i6, long j8, int i7);

    private static native void fastNlMeansDenoisingMulti_7(long j6, long j7, int i5, int i6, long j8);

    private static native void fastNlMeansDenoising_0(long j6, long j7, float f6, int i5, int i6);

    private static native void fastNlMeansDenoising_1(long j6, long j7, float f6, int i5);

    private static native void fastNlMeansDenoising_2(long j6, long j7, float f6);

    private static native void fastNlMeansDenoising_3(long j6, long j7);

    private static native void fastNlMeansDenoising_4(long j6, long j7, long j8, int i5, int i6, int i7);

    private static native void fastNlMeansDenoising_5(long j6, long j7, long j8, int i5, int i6);

    private static native void fastNlMeansDenoising_6(long j6, long j7, long j8, int i5);

    private static native void fastNlMeansDenoising_7(long j6, long j7, long j8);

    public static void illuminationChange(Mat mat, Mat mat2, Mat mat3, float f6, float f7) {
        illuminationChange_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6, f7);
    }

    private static native void illuminationChange_0(long j6, long j7, long j8, float f6, float f7);

    private static native void illuminationChange_1(long j6, long j7, long j8, float f6);

    private static native void illuminationChange_2(long j6, long j7, long j8);

    public static void inpaint(Mat mat, Mat mat2, Mat mat3, double d, int i5) {
        inpaint_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d, i5);
    }

    private static native void inpaint_0(long j6, long j7, long j8, double d, int i5);

    public static void pencilSketch(Mat mat, Mat mat2, Mat mat3, float f6, float f7, float f8) {
        pencilSketch_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6, f7, f8);
    }

    private static native void pencilSketch_0(long j6, long j7, long j8, float f6, float f7, float f8);

    private static native void pencilSketch_1(long j6, long j7, long j8, float f6, float f7);

    private static native void pencilSketch_2(long j6, long j7, long j8, float f6);

    private static native void pencilSketch_3(long j6, long j7, long j8);

    public static void seamlessClone(Mat mat, Mat mat2, Mat mat3, Point point, Mat mat4, int i5) {
        seamlessClone_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f7681x, point.f7682y, mat4.nativeObj, i5);
    }

    private static native void seamlessClone_0(long j6, long j7, long j8, double d, double d6, long j9, int i5);

    public static void stylization(Mat mat, Mat mat2, float f6, float f7) {
        stylization_0(mat.nativeObj, mat2.nativeObj, f6, f7);
    }

    private static native void stylization_0(long j6, long j7, float f6, float f7);

    private static native void stylization_1(long j6, long j7, float f6);

    private static native void stylization_2(long j6, long j7);

    public static void textureFlattening(Mat mat, Mat mat2, Mat mat3, float f6, float f7, int i5) {
        textureFlattening_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6, f7, i5);
    }

    private static native void textureFlattening_0(long j6, long j7, long j8, float f6, float f7, int i5);

    private static native void textureFlattening_1(long j6, long j7, long j8, float f6, float f7);

    private static native void textureFlattening_2(long j6, long j7, long j8, float f6);

    private static native void textureFlattening_3(long j6, long j7, long j8);

    public static void colorChange(Mat mat, Mat mat2, Mat mat3, float f6, float f7) {
        colorChange_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6, f7);
    }

    public static AlignMTB createAlignMTB(int i5, int i6) {
        return AlignMTB.__fromPtr__(createAlignMTB_1(i5, i6));
    }

    public static CalibrateDebevec createCalibrateDebevec(int i5, float f6) {
        return CalibrateDebevec.__fromPtr__(createCalibrateDebevec_1(i5, f6));
    }

    public static CalibrateRobertson createCalibrateRobertson(int i5) {
        return CalibrateRobertson.__fromPtr__(createCalibrateRobertson_1(i5));
    }

    public static MergeMertens createMergeMertens(float f6, float f7) {
        return MergeMertens.__fromPtr__(createMergeMertens_1(f6, f7));
    }

    public static Tonemap createTonemap() {
        return Tonemap.__fromPtr__(createTonemap_1());
    }

    public static TonemapDrago createTonemapDrago(float f6, float f7) {
        return TonemapDrago.__fromPtr__(createTonemapDrago_1(f6, f7));
    }

    public static TonemapMantiuk createTonemapMantiuk(float f6, float f7) {
        return TonemapMantiuk.__fromPtr__(createTonemapMantiuk_1(f6, f7));
    }

    public static TonemapReinhard createTonemapReinhard(float f6, float f7, float f8) {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_1(f6, f7, f8));
    }

    public static void detailEnhance(Mat mat, Mat mat2, float f6) {
        detailEnhance_1(mat.nativeObj, mat2.nativeObj, f6);
    }

    public static void edgePreservingFilter(Mat mat, Mat mat2, int i5, float f6) {
        edgePreservingFilter_1(mat.nativeObj, mat2.nativeObj, i5, f6);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, float f6, int i5) {
        fastNlMeansDenoising_1(mat.nativeObj, mat2.nativeObj, f6, i5);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2, float f6, float f7, int i5) {
        fastNlMeansDenoisingColored_1(mat.nativeObj, mat2.nativeObj, f6, f7, i5);
    }

    public static void illuminationChange(Mat mat, Mat mat2, Mat mat3, float f6) {
        illuminationChange_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6);
    }

    public static void pencilSketch(Mat mat, Mat mat2, Mat mat3, float f6, float f7) {
        pencilSketch_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6, f7);
    }

    public static void stylization(Mat mat, Mat mat2, float f6) {
        stylization_1(mat.nativeObj, mat2.nativeObj, f6);
    }

    public static void textureFlattening(Mat mat, Mat mat2, Mat mat3, float f6, float f7) {
        textureFlattening_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6, f7);
    }

    public static void colorChange(Mat mat, Mat mat2, Mat mat3, float f6) {
        colorChange_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6);
    }

    public static AlignMTB createAlignMTB(int i5) {
        return AlignMTB.__fromPtr__(createAlignMTB_2(i5));
    }

    public static CalibrateDebevec createCalibrateDebevec(int i5) {
        return CalibrateDebevec.__fromPtr__(createCalibrateDebevec_2(i5));
    }

    public static CalibrateRobertson createCalibrateRobertson() {
        return CalibrateRobertson.__fromPtr__(createCalibrateRobertson_2());
    }

    public static MergeMertens createMergeMertens(float f6) {
        return MergeMertens.__fromPtr__(createMergeMertens_2(f6));
    }

    public static TonemapDrago createTonemapDrago(float f6) {
        return TonemapDrago.__fromPtr__(createTonemapDrago_2(f6));
    }

    public static TonemapMantiuk createTonemapMantiuk(float f6) {
        return TonemapMantiuk.__fromPtr__(createTonemapMantiuk_2(f6));
    }

    public static TonemapReinhard createTonemapReinhard(float f6, float f7) {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_2(f6, f7));
    }

    public static void denoise_TVL1(List<Mat> list, Mat mat, double d) {
        denoise_TVL1_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, d);
    }

    public static void detailEnhance(Mat mat, Mat mat2) {
        detailEnhance_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void edgePreservingFilter(Mat mat, Mat mat2, int i5) {
        edgePreservingFilter_2(mat.nativeObj, mat2.nativeObj, i5);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, float f6) {
        fastNlMeansDenoising_2(mat.nativeObj, mat2.nativeObj, f6);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2, float f6, float f7) {
        fastNlMeansDenoisingColored_2(mat.nativeObj, mat2.nativeObj, f6, f7);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i5, int i6, float f6, float f7, int i7) {
        fastNlMeansDenoisingColoredMulti_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, f6, f7, i7);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i5, int i6, float f6, int i7) {
        fastNlMeansDenoisingMulti_1(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, f6, i7);
    }

    public static void illuminationChange(Mat mat, Mat mat2, Mat mat3) {
        illuminationChange_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void pencilSketch(Mat mat, Mat mat2, Mat mat3, float f6) {
        pencilSketch_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6);
    }

    public static void stylization(Mat mat, Mat mat2) {
        stylization_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void textureFlattening(Mat mat, Mat mat2, Mat mat3, float f6) {
        textureFlattening_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, f6);
    }

    public static void colorChange(Mat mat, Mat mat2, Mat mat3) {
        colorChange_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static AlignMTB createAlignMTB() {
        return AlignMTB.__fromPtr__(createAlignMTB_3());
    }

    public static CalibrateDebevec createCalibrateDebevec() {
        return CalibrateDebevec.__fromPtr__(createCalibrateDebevec_3());
    }

    public static MergeMertens createMergeMertens() {
        return MergeMertens.__fromPtr__(createMergeMertens_3());
    }

    public static TonemapDrago createTonemapDrago() {
        return TonemapDrago.__fromPtr__(createTonemapDrago_3());
    }

    public static TonemapMantiuk createTonemapMantiuk() {
        return TonemapMantiuk.__fromPtr__(createTonemapMantiuk_3());
    }

    public static TonemapReinhard createTonemapReinhard(float f6) {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_3(f6));
    }

    public static void edgePreservingFilter(Mat mat, Mat mat2) {
        edgePreservingFilter_3(mat.nativeObj, mat2.nativeObj);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2) {
        fastNlMeansDenoising_3(mat.nativeObj, mat2.nativeObj);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2, float f6) {
        fastNlMeansDenoisingColored_3(mat.nativeObj, mat2.nativeObj, f6);
    }

    public static void pencilSketch(Mat mat, Mat mat2, Mat mat3) {
        pencilSketch_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void textureFlattening(Mat mat, Mat mat2, Mat mat3) {
        textureFlattening_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static TonemapReinhard createTonemapReinhard() {
        return TonemapReinhard.__fromPtr__(createTonemapReinhard_4());
    }

    public static void denoise_TVL1(List<Mat> list, Mat mat) {
        denoise_TVL1_2(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, MatOfFloat matOfFloat, int i5, int i6, int i7) {
        fastNlMeansDenoising_4(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, i5, i6, i7);
    }

    public static void fastNlMeansDenoisingColored(Mat mat, Mat mat2) {
        fastNlMeansDenoisingColored_4(mat.nativeObj, mat2.nativeObj);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i5, int i6, float f6, float f7) {
        fastNlMeansDenoisingColoredMulti_2(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, f6, f7);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i5, int i6, float f6) {
        fastNlMeansDenoisingMulti_2(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, f6);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, MatOfFloat matOfFloat, int i5, int i6) {
        fastNlMeansDenoising_5(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, i5, i6);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, MatOfFloat matOfFloat, int i5) {
        fastNlMeansDenoising_6(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj, i5);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i5, int i6, float f6) {
        fastNlMeansDenoisingColoredMulti_3(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, f6);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i5, int i6) {
        fastNlMeansDenoisingMulti_3(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6);
    }

    public static void fastNlMeansDenoising(Mat mat, Mat mat2, MatOfFloat matOfFloat) {
        fastNlMeansDenoising_7(mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj);
    }

    public static void fastNlMeansDenoisingColoredMulti(List<Mat> list, Mat mat, int i5, int i6) {
        fastNlMeansDenoisingColoredMulti_4(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i5, int i6, MatOfFloat matOfFloat, int i7, int i8, int i9) {
        fastNlMeansDenoisingMulti_4(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, matOfFloat.nativeObj, i7, i8, i9);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i5, int i6, MatOfFloat matOfFloat, int i7, int i8) {
        fastNlMeansDenoisingMulti_5(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, matOfFloat.nativeObj, i7, i8);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i5, int i6, MatOfFloat matOfFloat, int i7) {
        fastNlMeansDenoisingMulti_6(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, matOfFloat.nativeObj, i7);
    }

    public static void fastNlMeansDenoisingMulti(List<Mat> list, Mat mat, int i5, int i6, MatOfFloat matOfFloat) {
        fastNlMeansDenoisingMulti_7(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, i5, i6, matOfFloat.nativeObj);
    }
}
