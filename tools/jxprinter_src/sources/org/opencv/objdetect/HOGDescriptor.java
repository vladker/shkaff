package org.opencv.objdetect;

import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class HOGDescriptor {
    public static final int DEFAULT_NLEVELS = 64;
    public static final int DESCR_FORMAT_COL_BY_COL = 0;
    public static final int DESCR_FORMAT_ROW_BY_ROW = 1;
    public static final int L2Hys = 0;
    protected final long nativeObj;

    public HOGDescriptor(long j6) {
        this.nativeObj = j6;
    }

    private static native long HOGDescriptor_0();

    private static native long HOGDescriptor_1(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i5, int i6, double d13, int i7, double d14, boolean z6, int i8, boolean z7);

    private static native long HOGDescriptor_2(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i5, int i6, double d13, int i7, double d14, boolean z6, int i8);

    private static native long HOGDescriptor_3(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i5, int i6, double d13, int i7, double d14, boolean z6);

    private static native long HOGDescriptor_4(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i5, int i6, double d13, int i7, double d14);

    private static native long HOGDescriptor_5(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i5, int i6, double d13, int i7);

    private static native long HOGDescriptor_6(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i5, int i6, double d13);

    private static native long HOGDescriptor_7(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i5, int i6);

    private static native long HOGDescriptor_8(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i5);

    private static native long HOGDescriptor_9(String str);

    public static HOGDescriptor __fromPtr__(long j6) {
        return new HOGDescriptor(j6);
    }

    private static native boolean checkDetectorSize_0(long j6);

    private static native void computeGradient_0(long j6, long j7, long j8, long j9, double d, double d6, double d7, double d8);

    private static native void computeGradient_1(long j6, long j7, long j8, long j9, double d, double d6);

    private static native void computeGradient_2(long j6, long j7, long j8, long j9);

    private static native void compute_0(long j6, long j7, long j8, double d, double d6, double d7, double d8, long j9);

    private static native void compute_1(long j6, long j7, long j8, double d, double d6, double d7, double d8);

    private static native void compute_2(long j6, long j7, long j8, double d, double d6);

    private static native void compute_3(long j6, long j7, long j8);

    private static native void delete(long j6);

    private static native void detectMultiScale_0(long j6, long j7, long j8, long j9, double d, double d6, double d7, double d8, double d9, double d10, double d11, boolean z6);

    private static native void detectMultiScale_1(long j6, long j7, long j8, long j9, double d, double d6, double d7, double d8, double d9, double d10, double d11);

    private static native void detectMultiScale_2(long j6, long j7, long j8, long j9, double d, double d6, double d7, double d8, double d9, double d10);

    private static native void detectMultiScale_3(long j6, long j7, long j8, long j9, double d, double d6, double d7, double d8, double d9);

    private static native void detectMultiScale_4(long j6, long j7, long j8, long j9, double d, double d6, double d7);

    private static native void detectMultiScale_5(long j6, long j7, long j8, long j9, double d);

    private static native void detectMultiScale_6(long j6, long j7, long j8, long j9);

    private static native void detect_0(long j6, long j7, long j8, long j9, double d, double d6, double d7, double d8, double d9, long j10);

    private static native void detect_1(long j6, long j7, long j8, long j9, double d, double d6, double d7, double d8, double d9);

    private static native void detect_2(long j6, long j7, long j8, long j9, double d, double d6, double d7);

    private static native void detect_3(long j6, long j7, long j8, long j9, double d);

    private static native void detect_4(long j6, long j7, long j8, long j9);

    public static MatOfFloat getDaimlerPeopleDetector() {
        return MatOfFloat.fromNativeAddr(getDaimlerPeopleDetector_0());
    }

    private static native long getDaimlerPeopleDetector_0();

    public static MatOfFloat getDefaultPeopleDetector() {
        return MatOfFloat.fromNativeAddr(getDefaultPeopleDetector_0());
    }

    private static native long getDefaultPeopleDetector_0();

    private static native long getDescriptorSize_0(long j6);

    private static native double getWinSigma_0(long j6);

    private static native double get_L2HysThreshold_0(long j6);

    private static native double[] get_blockSize_0(long j6);

    private static native double[] get_blockStride_0(long j6);

    private static native double[] get_cellSize_0(long j6);

    private static native int get_derivAperture_0(long j6);

    private static native boolean get_gammaCorrection_0(long j6);

    private static native int get_histogramNormType_0(long j6);

    private static native int get_nbins_0(long j6);

    private static native int get_nlevels_0(long j6);

    private static native boolean get_signedGradient_0(long j6);

    private static native long get_svmDetector_0(long j6);

    private static native double get_winSigma_0(long j6);

    private static native double[] get_winSize_0(long j6);

    private static native boolean load_0(long j6, String str, String str2);

    private static native boolean load_1(long j6, String str);

    private static native void save_0(long j6, String str, String str2);

    private static native void save_1(long j6, String str);

    private static native void setSVMDetector_0(long j6, long j7);

    public boolean checkDetectorSize() {
        return checkDetectorSize_0(this.nativeObj);
    }

    public void compute(Mat mat, MatOfFloat matOfFloat, Size size, Size size2, MatOfPoint matOfPoint) {
        compute_0(this.nativeObj, mat.nativeObj, matOfFloat.nativeObj, size.width, size.height, size2.width, size2.height, matOfPoint.nativeObj);
    }

    public void computeGradient(Mat mat, Mat mat2, Mat mat3, Size size, Size size2) {
        computeGradient_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height, size2.width, size2.height);
    }

    public void detect(Mat mat, MatOfPoint matOfPoint, MatOfDouble matOfDouble, double d, Size size, Size size2, MatOfPoint matOfPoint2) {
        detect_0(this.nativeObj, mat.nativeObj, matOfPoint.nativeObj, matOfDouble.nativeObj, d, size.width, size.height, size2.width, size2.height, matOfPoint2.nativeObj);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, MatOfDouble matOfDouble, double d, Size size, Size size2, double d6, double d7, boolean z6) {
        detectMultiScale_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj, d, size.width, size.height, size2.width, size2.height, d6, d7, z6);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getDescriptorSize() {
        return getDescriptorSize_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public double getWinSigma() {
        return getWinSigma_0(this.nativeObj);
    }

    public double get_L2HysThreshold() {
        return get_L2HysThreshold_0(this.nativeObj);
    }

    public Size get_blockSize() {
        return new Size(get_blockSize_0(this.nativeObj));
    }

    public Size get_blockStride() {
        return new Size(get_blockStride_0(this.nativeObj));
    }

    public Size get_cellSize() {
        return new Size(get_cellSize_0(this.nativeObj));
    }

    public int get_derivAperture() {
        return get_derivAperture_0(this.nativeObj);
    }

    public boolean get_gammaCorrection() {
        return get_gammaCorrection_0(this.nativeObj);
    }

    public int get_histogramNormType() {
        return get_histogramNormType_0(this.nativeObj);
    }

    public int get_nbins() {
        return get_nbins_0(this.nativeObj);
    }

    public int get_nlevels() {
        return get_nlevels_0(this.nativeObj);
    }

    public boolean get_signedGradient() {
        return get_signedGradient_0(this.nativeObj);
    }

    public MatOfFloat get_svmDetector() {
        return MatOfFloat.fromNativeAddr(get_svmDetector_0(this.nativeObj));
    }

    public double get_winSigma() {
        return get_winSigma_0(this.nativeObj);
    }

    public Size get_winSize() {
        return new Size(get_winSize_0(this.nativeObj));
    }

    public boolean load(String str, String str2) {
        return load_0(this.nativeObj, str, str2);
    }

    public void save(String str, String str2) {
        save_0(this.nativeObj, str, str2);
    }

    public void setSVMDetector(Mat mat) {
        setSVMDetector_0(this.nativeObj, mat.nativeObj);
    }

    public HOGDescriptor() {
        this.nativeObj = HOGDescriptor_0();
    }

    public void compute(Mat mat, MatOfFloat matOfFloat, Size size, Size size2) {
        compute_1(this.nativeObj, mat.nativeObj, matOfFloat.nativeObj, size.width, size.height, size2.width, size2.height);
    }

    public void computeGradient(Mat mat, Mat mat2, Mat mat3, Size size) {
        computeGradient_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, size.width, size.height);
    }

    public void detect(Mat mat, MatOfPoint matOfPoint, MatOfDouble matOfDouble, double d, Size size, Size size2) {
        detect_1(this.nativeObj, mat.nativeObj, matOfPoint.nativeObj, matOfDouble.nativeObj, d, size.width, size.height, size2.width, size2.height);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, MatOfDouble matOfDouble, double d, Size size, Size size2, double d6, double d7) {
        detectMultiScale_1(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj, d, size.width, size.height, size2.width, size2.height, d6, d7);
    }

    public boolean load(String str) {
        return load_1(this.nativeObj, str);
    }

    public void save(String str) {
        save_1(this.nativeObj, str);
    }

    public void compute(Mat mat, MatOfFloat matOfFloat, Size size) {
        compute_2(this.nativeObj, mat.nativeObj, matOfFloat.nativeObj, size.width, size.height);
    }

    public void computeGradient(Mat mat, Mat mat2, Mat mat3) {
        computeGradient_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void detect(Mat mat, MatOfPoint matOfPoint, MatOfDouble matOfDouble, double d, Size size) {
        detect_2(this.nativeObj, mat.nativeObj, matOfPoint.nativeObj, matOfDouble.nativeObj, d, size.width, size.height);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, MatOfDouble matOfDouble, double d, Size size, Size size2, double d6) {
        detectMultiScale_2(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj, d, size.width, size.height, size2.width, size2.height, d6);
    }

    public HOGDescriptor(Size size, Size size2, Size size3, Size size4, int i5, int i6, double d, int i7, double d6, boolean z6, int i8, boolean z7) {
        this.nativeObj = HOGDescriptor_1(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, i5, i6, d, i7, d6, z6, i8, z7);
    }

    public void compute(Mat mat, MatOfFloat matOfFloat) {
        compute_3(this.nativeObj, mat.nativeObj, matOfFloat.nativeObj);
    }

    public void detect(Mat mat, MatOfPoint matOfPoint, MatOfDouble matOfDouble, double d) {
        detect_3(this.nativeObj, mat.nativeObj, matOfPoint.nativeObj, matOfDouble.nativeObj, d);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, MatOfDouble matOfDouble, double d, Size size, Size size2) {
        detectMultiScale_3(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj, d, size.width, size.height, size2.width, size2.height);
    }

    public void detect(Mat mat, MatOfPoint matOfPoint, MatOfDouble matOfDouble) {
        detect_4(this.nativeObj, mat.nativeObj, matOfPoint.nativeObj, matOfDouble.nativeObj);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, MatOfDouble matOfDouble, double d, Size size) {
        detectMultiScale_4(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj, d, size.width, size.height);
    }

    public HOGDescriptor(Size size, Size size2, Size size3, Size size4, int i5, int i6, double d, int i7, double d6, boolean z6, int i8) {
        this.nativeObj = HOGDescriptor_2(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, i5, i6, d, i7, d6, z6, i8);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, MatOfDouble matOfDouble, double d) {
        detectMultiScale_5(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj, d);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, MatOfDouble matOfDouble) {
        detectMultiScale_6(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfDouble.nativeObj);
    }

    public HOGDescriptor(Size size, Size size2, Size size3, Size size4, int i5, int i6, double d, int i7, double d6, boolean z6) {
        this.nativeObj = HOGDescriptor_3(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, i5, i6, d, i7, d6, z6);
    }

    public HOGDescriptor(Size size, Size size2, Size size3, Size size4, int i5, int i6, double d, int i7, double d6) {
        this.nativeObj = HOGDescriptor_4(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, i5, i6, d, i7, d6);
    }

    public HOGDescriptor(Size size, Size size2, Size size3, Size size4, int i5, int i6, double d, int i7) {
        this.nativeObj = HOGDescriptor_5(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, i5, i6, d, i7);
    }

    public HOGDescriptor(Size size, Size size2, Size size3, Size size4, int i5, int i6, double d) {
        this.nativeObj = HOGDescriptor_6(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, i5, i6, d);
    }

    public HOGDescriptor(Size size, Size size2, Size size3, Size size4, int i5, int i6) {
        this.nativeObj = HOGDescriptor_7(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, i5, i6);
    }

    public HOGDescriptor(Size size, Size size2, Size size3, Size size4, int i5) {
        this.nativeObj = HOGDescriptor_8(size.width, size.height, size2.width, size2.height, size3.width, size3.height, size4.width, size4.height, i5);
    }

    public HOGDescriptor(String str) {
        this.nativeObj = HOGDescriptor_9(str);
    }
}
