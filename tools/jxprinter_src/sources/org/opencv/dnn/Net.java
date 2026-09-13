package org.opencv.dnn;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Net {
    protected final long nativeObj;

    public Net(long j6) {
        this.nativeObj = j6;
    }

    private static native long Net_0();

    public static Net __fromPtr__(long j6) {
        return new Net(j6);
    }

    private static native void connect_0(long j6, String str, String str2);

    private static native void delete(long j6);

    private static native void dumpToFile_0(long j6, String str);

    private static native String dump_0(long j6);

    private static native boolean empty_0(long j6);

    private static native void enableFusion_0(long j6, boolean z6);

    private static native void enableWinograd_0(long j6, boolean z6);

    private static native long forward_0(long j6, String str);

    private static native long forward_1(long j6);

    private static native void forward_2(long j6, long j7, String str);

    private static native void forward_3(long j6, long j7);

    private static native void forward_4(long j6, long j7, List<String> list);

    private static native long getFLOPS_0(long j6, List<MatOfInt> list);

    private static native long getFLOPS_1(long j6, long j7);

    private static native long getFLOPS_2(long j6, int i5, List<MatOfInt> list);

    private static native long getFLOPS_3(long j6, int i5, long j7);

    private static native void getInputDetails_0(long j6, long j7, long j8);

    private static native int getLayerId_0(long j6, String str);

    private static native List<String> getLayerNames_0(long j6);

    private static native void getLayerTypes_0(long j6, List<String> list);

    private static native long getLayer_0(long j6, int i5);

    private static native long getLayer_1(long j6, String str);

    private static native long getLayer_2(long j6, long j7);

    private static native int getLayersCount_0(long j6, String str);

    private static native void getMemoryConsumption_0(long j6, long j7, double[] dArr, double[] dArr2);

    private static native void getMemoryConsumption_1(long j6, int i5, List<MatOfInt> list, double[] dArr, double[] dArr2);

    private static native void getMemoryConsumption_2(long j6, int i5, long j7, double[] dArr, double[] dArr2);

    private static native void getOutputDetails_0(long j6, long j7, long j8);

    private static native long getParam_0(long j6, int i5, int i6);

    private static native long getParam_1(long j6, int i5);

    private static native long getParam_2(long j6, String str, int i5);

    private static native long getParam_3(long j6, String str);

    private static native long getPerfProfile_0(long j6, long j7);

    private static native List<String> getUnconnectedOutLayersNames_0(long j6);

    private static native long getUnconnectedOutLayers_0(long j6);

    private static native long quantize_0(long j6, long j7, int i5, int i6, boolean z6);

    private static native long quantize_1(long j6, long j7, int i5, int i6);

    public static Net readFromModelOptimizer(String str, String str2) {
        return new Net(readFromModelOptimizer_0(str, str2));
    }

    private static native long readFromModelOptimizer_0(String str, String str2);

    private static native long readFromModelOptimizer_1(long j6, long j7);

    private static native void setHalideScheduler_0(long j6, String str);

    private static native void setInputShape_0(long j6, String str, long j7);

    private static native void setInput_0(long j6, long j7, String str, double d, double d6, double d7, double d8, double d9);

    private static native void setInput_1(long j6, long j7, String str, double d);

    private static native void setInput_2(long j6, long j7, String str);

    private static native void setInput_3(long j6, long j7);

    private static native void setInputsNames_0(long j6, List<String> list);

    private static native void setParam_0(long j6, int i5, int i6, long j7);

    private static native void setParam_1(long j6, String str, int i5, long j7);

    private static native void setPreferableBackend_0(long j6, int i5);

    private static native void setPreferableTarget_0(long j6, int i5);

    public void connect(String str, String str2) {
        connect_0(this.nativeObj, str, str2);
    }

    public String dump() {
        return dump_0(this.nativeObj);
    }

    public void dumpToFile(String str) {
        dumpToFile_0(this.nativeObj, str);
    }

    public boolean empty() {
        return empty_0(this.nativeObj);
    }

    public void enableFusion(boolean z6) {
        enableFusion_0(this.nativeObj, z6);
    }

    public void enableWinograd(boolean z6) {
        enableWinograd_0(this.nativeObj, z6);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public Mat forward(String str) {
        return new Mat(forward_0(this.nativeObj, str));
    }

    public long getFLOPS(List<MatOfInt> list) {
        return getFLOPS_0(this.nativeObj, list);
    }

    public void getInputDetails(MatOfFloat matOfFloat, MatOfInt matOfInt) {
        getInputDetails_0(this.nativeObj, matOfFloat.nativeObj, matOfInt.nativeObj);
    }

    public Layer getLayer(int i5) {
        return Layer.__fromPtr__(getLayer_0(this.nativeObj, i5));
    }

    public int getLayerId(String str) {
        return getLayerId_0(this.nativeObj, str);
    }

    public List<String> getLayerNames() {
        return getLayerNames_0(this.nativeObj);
    }

    public void getLayerTypes(List<String> list) {
        getLayerTypes_0(this.nativeObj, list);
    }

    public int getLayersCount(String str) {
        return getLayersCount_0(this.nativeObj, str);
    }

    public void getMemoryConsumption(MatOfInt matOfInt, long[] jArr, long[] jArr2) {
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        getMemoryConsumption_0(this.nativeObj, matOfInt.nativeObj, dArr, dArr2);
        if (jArr != null) {
            jArr[0] = (long) dArr[0];
        }
        if (jArr2 != null) {
            jArr2[0] = (long) dArr2[0];
        }
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public void getOutputDetails(MatOfFloat matOfFloat, MatOfInt matOfInt) {
        getOutputDetails_0(this.nativeObj, matOfFloat.nativeObj, matOfInt.nativeObj);
    }

    public Mat getParam(int i5, int i6) {
        return new Mat(getParam_0(this.nativeObj, i5, i6));
    }

    public long getPerfProfile(MatOfDouble matOfDouble) {
        return getPerfProfile_0(this.nativeObj, matOfDouble.nativeObj);
    }

    public MatOfInt getUnconnectedOutLayers() {
        return MatOfInt.fromNativeAddr(getUnconnectedOutLayers_0(this.nativeObj));
    }

    public List<String> getUnconnectedOutLayersNames() {
        return getUnconnectedOutLayersNames_0(this.nativeObj);
    }

    public Net quantize(List<Mat> list, int i5, int i6, boolean z6) {
        return new Net(quantize_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, i5, i6, z6));
    }

    public void setHalideScheduler(String str) {
        setHalideScheduler_0(this.nativeObj, str);
    }

    public void setInput(Mat mat, String str, double d, Scalar scalar) {
        long j6 = this.nativeObj;
        long j7 = mat.nativeObj;
        double[] dArr = scalar.val;
        setInput_0(j6, j7, str, d, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public void setInputShape(String str, MatOfInt matOfInt) {
        setInputShape_0(this.nativeObj, str, matOfInt.nativeObj);
    }

    public void setInputsNames(List<String> list) {
        setInputsNames_0(this.nativeObj, list);
    }

    public void setParam(int i5, int i6, Mat mat) {
        setParam_0(this.nativeObj, i5, i6, mat.nativeObj);
    }

    public void setPreferableBackend(int i5) {
        setPreferableBackend_0(this.nativeObj, i5);
    }

    public void setPreferableTarget(int i5) {
        setPreferableTarget_0(this.nativeObj, i5);
    }

    public Net() {
        this.nativeObj = Net_0();
    }

    public static Net readFromModelOptimizer(MatOfByte matOfByte, MatOfByte matOfByte2) {
        return new Net(readFromModelOptimizer_1(matOfByte.nativeObj, matOfByte2.nativeObj));
    }

    public Mat forward() {
        return new Mat(forward_1(this.nativeObj));
    }

    public long getFLOPS(MatOfInt matOfInt) {
        return getFLOPS_1(this.nativeObj, matOfInt.nativeObj);
    }

    @Deprecated
    public Layer getLayer(String str) {
        return Layer.__fromPtr__(getLayer_1(this.nativeObj, str));
    }

    public Mat getParam(int i5) {
        return new Mat(getParam_1(this.nativeObj, i5));
    }

    public void setInput(Mat mat, String str, double d) {
        setInput_1(this.nativeObj, mat.nativeObj, str, d);
    }

    public void setParam(String str, int i5, Mat mat) {
        setParam_1(this.nativeObj, str, i5, mat.nativeObj);
    }

    public void forward(List<Mat> list, String str) {
        Mat mat = new Mat();
        forward_2(this.nativeObj, mat.nativeObj, str);
        Converters.Mat_to_vector_Mat(mat, list);
        mat.release();
    }

    public long getFLOPS(int i5, List<MatOfInt> list) {
        return getFLOPS_2(this.nativeObj, i5, list);
    }

    @Deprecated
    public Layer getLayer(DictValue dictValue) {
        return Layer.__fromPtr__(getLayer_2(this.nativeObj, dictValue.getNativeObjAddr()));
    }

    public Mat getParam(String str, int i5) {
        return new Mat(getParam_2(this.nativeObj, str, i5));
    }

    public Net quantize(List<Mat> list, int i5, int i6) {
        return new Net(quantize_1(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, i5, i6));
    }

    public void setInput(Mat mat, String str) {
        setInput_2(this.nativeObj, mat.nativeObj, str);
    }

    public long getFLOPS(int i5, MatOfInt matOfInt) {
        return getFLOPS_3(this.nativeObj, i5, matOfInt.nativeObj);
    }

    public Mat getParam(String str) {
        return new Mat(getParam_3(this.nativeObj, str));
    }

    public void setInput(Mat mat) {
        setInput_3(this.nativeObj, mat.nativeObj);
    }

    public void getMemoryConsumption(int i5, List<MatOfInt> list, long[] jArr, long[] jArr2) {
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        getMemoryConsumption_1(this.nativeObj, i5, list, dArr, dArr2);
        if (jArr != null) {
            jArr[0] = (long) dArr[0];
        }
        if (jArr2 != null) {
            jArr2[0] = (long) dArr2[0];
        }
    }

    public void forward(List<Mat> list) {
        Mat mat = new Mat();
        forward_3(this.nativeObj, mat.nativeObj);
        Converters.Mat_to_vector_Mat(mat, list);
        mat.release();
    }

    public void forward(List<Mat> list, List<String> list2) {
        Mat mat = new Mat();
        forward_4(this.nativeObj, mat.nativeObj, list2);
        Converters.Mat_to_vector_Mat(mat, list);
        mat.release();
    }

    public void getMemoryConsumption(int i5, MatOfInt matOfInt, long[] jArr, long[] jArr2) {
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        getMemoryConsumption_2(this.nativeObj, i5, matOfInt.nativeObj, dArr, dArr2);
        if (jArr != null) {
            jArr[0] = (long) dArr[0];
        }
        if (jArr2 != null) {
            jArr2[0] = (long) dArr2[0];
        }
    }
}
