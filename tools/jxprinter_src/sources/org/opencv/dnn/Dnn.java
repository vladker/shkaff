package org.opencv.dnn;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.MatOfRect2d;
import org.opencv.core.MatOfRotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Dnn {
    public static final int DNN_BACKEND_CANN = 8;
    public static final int DNN_BACKEND_CUDA = 5;
    public static final int DNN_BACKEND_DEFAULT = 0;
    public static final int DNN_BACKEND_HALIDE = 1;
    public static final int DNN_BACKEND_INFERENCE_ENGINE = 2;
    public static final int DNN_BACKEND_OPENCV = 3;
    public static final int DNN_BACKEND_TIMVX = 7;
    public static final int DNN_BACKEND_VKCOM = 4;
    public static final int DNN_BACKEND_WEBNN = 6;
    public static final int DNN_LAYOUT_NCDHW = 3;
    public static final int DNN_LAYOUT_NCHW = 2;
    public static final int DNN_LAYOUT_ND = 1;
    public static final int DNN_LAYOUT_NDHWC = 5;
    public static final int DNN_LAYOUT_NHWC = 4;
    public static final int DNN_LAYOUT_PLANAR = 6;
    public static final int DNN_LAYOUT_UNKNOWN = 0;
    public static final int DNN_PMODE_CROP_CENTER = 1;
    public static final int DNN_PMODE_LETTERBOX = 2;
    public static final int DNN_PMODE_NULL = 0;
    public static final int DNN_TARGET_CPU = 0;
    public static final int DNN_TARGET_CPU_FP16 = 10;
    public static final int DNN_TARGET_CUDA = 6;
    public static final int DNN_TARGET_CUDA_FP16 = 7;
    public static final int DNN_TARGET_FPGA = 5;
    public static final int DNN_TARGET_HDDL = 8;
    public static final int DNN_TARGET_MYRIAD = 3;
    public static final int DNN_TARGET_NPU = 9;
    public static final int DNN_TARGET_OPENCL = 1;
    public static final int DNN_TARGET_OPENCL_FP16 = 2;
    public static final int DNN_TARGET_VULKAN = 4;
    public static final int SoftNMSMethod_SOFTNMS_GAUSSIAN = 2;
    public static final int SoftNMSMethod_SOFTNMS_LINEAR = 1;

    public static void NMSBoxes(MatOfRect2d matOfRect2d, MatOfFloat matOfFloat, float f6, float f7, MatOfInt matOfInt, float f8, int i5) {
        NMSBoxes_0(matOfRect2d.nativeObj, matOfFloat.nativeObj, f6, f7, matOfInt.nativeObj, f8, i5);
    }

    public static void NMSBoxesBatched(MatOfRect2d matOfRect2d, MatOfFloat matOfFloat, MatOfInt matOfInt, float f6, float f7, MatOfInt matOfInt2, float f8, int i5) {
        NMSBoxesBatched_0(matOfRect2d.nativeObj, matOfFloat.nativeObj, matOfInt.nativeObj, f6, f7, matOfInt2.nativeObj, f8, i5);
    }

    private static native void NMSBoxesBatched_0(long j6, long j7, long j8, float f6, float f7, long j9, float f8, int i5);

    private static native void NMSBoxesBatched_1(long j6, long j7, long j8, float f6, float f7, long j9, float f8);

    private static native void NMSBoxesBatched_2(long j6, long j7, long j8, float f6, float f7, long j9);

    public static void NMSBoxesRotated(MatOfRotatedRect matOfRotatedRect, MatOfFloat matOfFloat, float f6, float f7, MatOfInt matOfInt, float f8, int i5) {
        NMSBoxesRotated_0(matOfRotatedRect.nativeObj, matOfFloat.nativeObj, f6, f7, matOfInt.nativeObj, f8, i5);
    }

    private static native void NMSBoxesRotated_0(long j6, long j7, float f6, float f7, long j8, float f8, int i5);

    private static native void NMSBoxesRotated_1(long j6, long j7, float f6, float f7, long j8, float f8);

    private static native void NMSBoxesRotated_2(long j6, long j7, float f6, float f7, long j8);

    private static native void NMSBoxes_0(long j6, long j7, float f6, float f7, long j8, float f8, int i5);

    private static native void NMSBoxes_1(long j6, long j7, float f6, float f7, long j8, float f8);

    private static native void NMSBoxes_2(long j6, long j7, float f6, float f7, long j8);

    public static Mat blobFromImage(Mat mat, double d, Size size, Scalar scalar, boolean z6, boolean z7, int i5) {
        long j6 = mat.nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        return new Mat(blobFromImage_0(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3], z6, z7, i5));
    }

    public static Mat blobFromImageWithParams(Mat mat, Image2BlobParams image2BlobParams) {
        return new Mat(blobFromImageWithParams_0(mat.nativeObj, image2BlobParams.nativeObj));
    }

    private static native long blobFromImageWithParams_0(long j6, long j7);

    private static native long blobFromImageWithParams_1(long j6);

    private static native void blobFromImageWithParams_2(long j6, long j7, long j8);

    private static native void blobFromImageWithParams_3(long j6, long j7);

    private static native long blobFromImage_0(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6, boolean z7, int i5);

    private static native long blobFromImage_1(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6, boolean z7);

    private static native long blobFromImage_2(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6);

    private static native long blobFromImage_3(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11);

    private static native long blobFromImage_4(long j6, double d, double d6, double d7);

    private static native long blobFromImage_5(long j6, double d);

    private static native long blobFromImage_6(long j6);

    public static Mat blobFromImages(List<Mat> list, double d, Size size, Scalar scalar, boolean z6, boolean z7, int i5) {
        long j6 = Converters.vector_Mat_to_Mat(list).nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        return new Mat(blobFromImages_0(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3], z6, z7, i5));
    }

    public static Mat blobFromImagesWithParams(List<Mat> list, Image2BlobParams image2BlobParams) {
        return new Mat(blobFromImagesWithParams_0(Converters.vector_Mat_to_Mat(list).nativeObj, image2BlobParams.nativeObj));
    }

    private static native long blobFromImagesWithParams_0(long j6, long j7);

    private static native long blobFromImagesWithParams_1(long j6);

    private static native void blobFromImagesWithParams_2(long j6, long j7, long j8);

    private static native void blobFromImagesWithParams_3(long j6, long j7);

    private static native long blobFromImages_0(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6, boolean z7, int i5);

    private static native long blobFromImages_1(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6, boolean z7);

    private static native long blobFromImages_2(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6);

    private static native long blobFromImages_3(long j6, double d, double d6, double d7, double d8, double d9, double d10, double d11);

    private static native long blobFromImages_4(long j6, double d, double d6, double d7);

    private static native long blobFromImages_5(long j6, double d);

    private static native long blobFromImages_6(long j6);

    public static List<Integer> getAvailableTargets(int i5) {
        return getAvailableTargets_0(i5);
    }

    private static native List<Integer> getAvailableTargets_0(int i5);

    @Deprecated
    public static String getInferenceEngineBackendType() {
        return getInferenceEngineBackendType_0();
    }

    private static native String getInferenceEngineBackendType_0();

    public static String getInferenceEngineCPUType() {
        return getInferenceEngineCPUType_0();
    }

    private static native String getInferenceEngineCPUType_0();

    public static String getInferenceEngineVPUType() {
        return getInferenceEngineVPUType_0();
    }

    private static native String getInferenceEngineVPUType_0();

    public static void imagesFromBlob(Mat mat, List<Mat> list) {
        Mat mat2 = new Mat();
        imagesFromBlob_0(mat.nativeObj, mat2.nativeObj);
        Converters.Mat_to_vector_Mat(mat2, list);
        mat2.release();
    }

    private static native void imagesFromBlob_0(long j6, long j7);

    public static Net readNet(String str, String str2, String str3) {
        return new Net(readNet_0(str, str2, str3));
    }

    public static Net readNetFromCaffe(String str, String str2) {
        return new Net(readNetFromCaffe_0(str, str2));
    }

    private static native long readNetFromCaffe_0(String str, String str2);

    private static native long readNetFromCaffe_1(String str);

    private static native long readNetFromCaffe_2(long j6, long j7);

    private static native long readNetFromCaffe_3(long j6);

    public static Net readNetFromDarknet(String str, String str2) {
        return new Net(readNetFromDarknet_0(str, str2));
    }

    private static native long readNetFromDarknet_0(String str, String str2);

    private static native long readNetFromDarknet_1(String str);

    private static native long readNetFromDarknet_2(long j6, long j7);

    private static native long readNetFromDarknet_3(long j6);

    public static Net readNetFromModelOptimizer(String str, String str2) {
        return new Net(readNetFromModelOptimizer_0(str, str2));
    }

    private static native long readNetFromModelOptimizer_0(String str, String str2);

    private static native long readNetFromModelOptimizer_1(long j6, long j7);

    public static Net readNetFromONNX(String str) {
        return new Net(readNetFromONNX_0(str));
    }

    private static native long readNetFromONNX_0(String str);

    private static native long readNetFromONNX_1(long j6);

    public static Net readNetFromTFLite(String str) {
        return new Net(readNetFromTFLite_0(str));
    }

    private static native long readNetFromTFLite_0(String str);

    private static native long readNetFromTFLite_1(long j6);

    public static Net readNetFromTensorflow(String str, String str2) {
        return new Net(readNetFromTensorflow_0(str, str2));
    }

    private static native long readNetFromTensorflow_0(String str, String str2);

    private static native long readNetFromTensorflow_1(String str);

    private static native long readNetFromTensorflow_2(long j6, long j7);

    private static native long readNetFromTensorflow_3(long j6);

    public static Net readNetFromTorch(String str, boolean z6, boolean z7) {
        return new Net(readNetFromTorch_0(str, z6, z7));
    }

    private static native long readNetFromTorch_0(String str, boolean z6, boolean z7);

    private static native long readNetFromTorch_1(String str, boolean z6);

    private static native long readNetFromTorch_2(String str);

    private static native long readNet_0(String str, String str2, String str3);

    private static native long readNet_1(String str, String str2);

    private static native long readNet_2(String str);

    private static native long readNet_3(String str, long j6, long j7);

    private static native long readNet_4(String str, long j6);

    public static Mat readTensorFromONNX(String str) {
        return new Mat(readTensorFromONNX_0(str));
    }

    private static native long readTensorFromONNX_0(String str);

    public static Mat readTorchBlob(String str, boolean z6) {
        return new Mat(readTorchBlob_0(str, z6));
    }

    private static native long readTorchBlob_0(String str, boolean z6);

    private static native long readTorchBlob_1(String str);

    public static void releaseHDDLPlugin() {
        releaseHDDLPlugin_0();
    }

    private static native void releaseHDDLPlugin_0();

    public static void resetMyriadDevice() {
        resetMyriadDevice_0();
    }

    private static native void resetMyriadDevice_0();

    @Deprecated
    public static String setInferenceEngineBackendType(String str) {
        return setInferenceEngineBackendType_0(str);
    }

    private static native String setInferenceEngineBackendType_0(String str);

    public static void shrinkCaffeModel(String str, String str2, List<String> list) {
        shrinkCaffeModel_0(str, str2, list);
    }

    private static native void shrinkCaffeModel_0(String str, String str2, List<String> list);

    private static native void shrinkCaffeModel_1(String str, String str2);

    public static void softNMSBoxes(MatOfRect matOfRect, MatOfFloat matOfFloat, MatOfFloat matOfFloat2, float f6, float f7, MatOfInt matOfInt, long j6, float f8) {
        softNMSBoxes_0(matOfRect.nativeObj, matOfFloat.nativeObj, matOfFloat2.nativeObj, f6, f7, matOfInt.nativeObj, j6, f8);
    }

    private static native void softNMSBoxes_0(long j6, long j7, long j8, float f6, float f7, long j9, long j10, float f8);

    private static native void softNMSBoxes_2(long j6, long j7, long j8, float f6, float f7, long j9, long j10);

    private static native void softNMSBoxes_3(long j6, long j7, long j8, float f6, float f7, long j9);

    public static void writeTextGraph(String str, String str2) {
        writeTextGraph_0(str, str2);
    }

    private static native void writeTextGraph_0(String str, String str2);

    public static void NMSBoxes(MatOfRect2d matOfRect2d, MatOfFloat matOfFloat, float f6, float f7, MatOfInt matOfInt, float f8) {
        NMSBoxes_1(matOfRect2d.nativeObj, matOfFloat.nativeObj, f6, f7, matOfInt.nativeObj, f8);
    }

    public static void NMSBoxesBatched(MatOfRect2d matOfRect2d, MatOfFloat matOfFloat, MatOfInt matOfInt, float f6, float f7, MatOfInt matOfInt2, float f8) {
        NMSBoxesBatched_1(matOfRect2d.nativeObj, matOfFloat.nativeObj, matOfInt.nativeObj, f6, f7, matOfInt2.nativeObj, f8);
    }

    public static void NMSBoxesRotated(MatOfRotatedRect matOfRotatedRect, MatOfFloat matOfFloat, float f6, float f7, MatOfInt matOfInt, float f8) {
        NMSBoxesRotated_1(matOfRotatedRect.nativeObj, matOfFloat.nativeObj, f6, f7, matOfInt.nativeObj, f8);
    }

    public static Mat blobFromImage(Mat mat, double d, Size size, Scalar scalar, boolean z6, boolean z7) {
        long j6 = mat.nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        return new Mat(blobFromImage_1(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3], z6, z7));
    }

    public static Mat blobFromImageWithParams(Mat mat) {
        return new Mat(blobFromImageWithParams_1(mat.nativeObj));
    }

    public static Net readNet(String str, String str2) {
        return new Net(readNet_1(str, str2));
    }

    public static Net readNetFromCaffe(String str) {
        return new Net(readNetFromCaffe_1(str));
    }

    public static Net readNetFromDarknet(String str) {
        return new Net(readNetFromDarknet_1(str));
    }

    public static Net readNetFromModelOptimizer(MatOfByte matOfByte, MatOfByte matOfByte2) {
        return new Net(readNetFromModelOptimizer_1(matOfByte.nativeObj, matOfByte2.nativeObj));
    }

    public static Net readNetFromONNX(MatOfByte matOfByte) {
        return new Net(readNetFromONNX_1(matOfByte.nativeObj));
    }

    public static Net readNetFromTFLite(MatOfByte matOfByte) {
        return new Net(readNetFromTFLite_1(matOfByte.nativeObj));
    }

    public static Net readNetFromTensorflow(String str) {
        return new Net(readNetFromTensorflow_1(str));
    }

    public static Net readNetFromTorch(String str, boolean z6) {
        return new Net(readNetFromTorch_1(str, z6));
    }

    public static Mat readTorchBlob(String str) {
        return new Mat(readTorchBlob_1(str));
    }

    public static void shrinkCaffeModel(String str, String str2) {
        shrinkCaffeModel_1(str, str2);
    }

    public static void softNMSBoxes(MatOfRect matOfRect, MatOfFloat matOfFloat, MatOfFloat matOfFloat2, float f6, float f7, MatOfInt matOfInt, long j6) {
        softNMSBoxes_2(matOfRect.nativeObj, matOfFloat.nativeObj, matOfFloat2.nativeObj, f6, f7, matOfInt.nativeObj, j6);
    }

    public static void NMSBoxes(MatOfRect2d matOfRect2d, MatOfFloat matOfFloat, float f6, float f7, MatOfInt matOfInt) {
        NMSBoxes_2(matOfRect2d.nativeObj, matOfFloat.nativeObj, f6, f7, matOfInt.nativeObj);
    }

    public static void NMSBoxesBatched(MatOfRect2d matOfRect2d, MatOfFloat matOfFloat, MatOfInt matOfInt, float f6, float f7, MatOfInt matOfInt2) {
        NMSBoxesBatched_2(matOfRect2d.nativeObj, matOfFloat.nativeObj, matOfInt.nativeObj, f6, f7, matOfInt2.nativeObj);
    }

    public static void NMSBoxesRotated(MatOfRotatedRect matOfRotatedRect, MatOfFloat matOfFloat, float f6, float f7, MatOfInt matOfInt) {
        NMSBoxesRotated_2(matOfRotatedRect.nativeObj, matOfFloat.nativeObj, f6, f7, matOfInt.nativeObj);
    }

    public static Mat blobFromImage(Mat mat, double d, Size size, Scalar scalar, boolean z6) {
        long j6 = mat.nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        return new Mat(blobFromImage_2(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3], z6));
    }

    public static void blobFromImageWithParams(Mat mat, Mat mat2, Image2BlobParams image2BlobParams) {
        blobFromImageWithParams_2(mat.nativeObj, mat2.nativeObj, image2BlobParams.nativeObj);
    }

    public static Mat blobFromImages(List<Mat> list, double d, Size size, Scalar scalar, boolean z6, boolean z7) {
        long j6 = Converters.vector_Mat_to_Mat(list).nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        return new Mat(blobFromImages_1(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3], z6, z7));
    }

    public static Mat blobFromImagesWithParams(List<Mat> list) {
        return new Mat(blobFromImagesWithParams_1(Converters.vector_Mat_to_Mat(list).nativeObj));
    }

    public static Net readNet(String str) {
        return new Net(readNet_2(str));
    }

    public static Net readNetFromCaffe(MatOfByte matOfByte, MatOfByte matOfByte2) {
        return new Net(readNetFromCaffe_2(matOfByte.nativeObj, matOfByte2.nativeObj));
    }

    public static Net readNetFromDarknet(MatOfByte matOfByte, MatOfByte matOfByte2) {
        return new Net(readNetFromDarknet_2(matOfByte.nativeObj, matOfByte2.nativeObj));
    }

    public static Net readNetFromTensorflow(MatOfByte matOfByte, MatOfByte matOfByte2) {
        return new Net(readNetFromTensorflow_2(matOfByte.nativeObj, matOfByte2.nativeObj));
    }

    public static Net readNetFromTorch(String str) {
        return new Net(readNetFromTorch_2(str));
    }

    public static void softNMSBoxes(MatOfRect matOfRect, MatOfFloat matOfFloat, MatOfFloat matOfFloat2, float f6, float f7, MatOfInt matOfInt) {
        softNMSBoxes_3(matOfRect.nativeObj, matOfFloat.nativeObj, matOfFloat2.nativeObj, f6, f7, matOfInt.nativeObj);
    }

    public static Mat blobFromImage(Mat mat, double d, Size size, Scalar scalar) {
        long j6 = mat.nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        return new Mat(blobFromImage_3(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3]));
    }

    public static void blobFromImageWithParams(Mat mat, Mat mat2) {
        blobFromImageWithParams_3(mat.nativeObj, mat2.nativeObj);
    }

    public static Net readNet(String str, MatOfByte matOfByte, MatOfByte matOfByte2) {
        return new Net(readNet_3(str, matOfByte.nativeObj, matOfByte2.nativeObj));
    }

    public static Net readNetFromCaffe(MatOfByte matOfByte) {
        return new Net(readNetFromCaffe_3(matOfByte.nativeObj));
    }

    public static Net readNetFromDarknet(MatOfByte matOfByte) {
        return new Net(readNetFromDarknet_3(matOfByte.nativeObj));
    }

    public static Net readNetFromTensorflow(MatOfByte matOfByte) {
        return new Net(readNetFromTensorflow_3(matOfByte.nativeObj));
    }

    public static Mat blobFromImage(Mat mat, double d, Size size) {
        return new Mat(blobFromImage_4(mat.nativeObj, d, size.width, size.height));
    }

    public static Mat blobFromImages(List<Mat> list, double d, Size size, Scalar scalar, boolean z6) {
        long j6 = Converters.vector_Mat_to_Mat(list).nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        return new Mat(blobFromImages_2(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3], z6));
    }

    public static void blobFromImagesWithParams(List<Mat> list, Mat mat, Image2BlobParams image2BlobParams) {
        blobFromImagesWithParams_2(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, image2BlobParams.nativeObj);
    }

    public static Net readNet(String str, MatOfByte matOfByte) {
        return new Net(readNet_4(str, matOfByte.nativeObj));
    }

    public static Mat blobFromImage(Mat mat, double d) {
        return new Mat(blobFromImage_5(mat.nativeObj, d));
    }

    public static Mat blobFromImage(Mat mat) {
        return new Mat(blobFromImage_6(mat.nativeObj));
    }

    public static Mat blobFromImages(List<Mat> list, double d, Size size, Scalar scalar) {
        long j6 = Converters.vector_Mat_to_Mat(list).nativeObj;
        double d6 = size.width;
        double d7 = size.height;
        double[] dArr = scalar.val;
        return new Mat(blobFromImages_3(j6, d, d6, d7, dArr[0], dArr[1], dArr[2], dArr[3]));
    }

    public static void blobFromImagesWithParams(List<Mat> list, Mat mat) {
        blobFromImagesWithParams_3(Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }

    public static Mat blobFromImages(List<Mat> list, double d, Size size) {
        return new Mat(blobFromImages_4(Converters.vector_Mat_to_Mat(list).nativeObj, d, size.width, size.height));
    }

    public static Mat blobFromImages(List<Mat> list, double d) {
        return new Mat(blobFromImages_5(Converters.vector_Mat_to_Mat(list).nativeObj, d));
    }

    public static Mat blobFromImages(List<Mat> list) {
        return new Mat(blobFromImages_6(Converters.vector_Mat_to_Mat(list).nativeObj));
    }
}
