package org.opencv.imgproc;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.Point;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class GeneralizedHough extends Algorithm {
    public GeneralizedHough(long j6) {
        super(j6);
    }

    public static GeneralizedHough __fromPtr__(long j6) {
        return new GeneralizedHough(j6);
    }

    private static native void delete(long j6);

    private static native void detect_0(long j6, long j7, long j8, long j9);

    private static native void detect_1(long j6, long j7, long j8);

    private static native void detect_2(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void detect_3(long j6, long j7, long j8, long j9, long j10);

    private static native int getCannyHighThresh_0(long j6);

    private static native int getCannyLowThresh_0(long j6);

    private static native double getDp_0(long j6);

    private static native int getMaxBufferSize_0(long j6);

    private static native double getMinDist_0(long j6);

    private static native void setCannyHighThresh_0(long j6, int i5);

    private static native void setCannyLowThresh_0(long j6, int i5);

    private static native void setDp_0(long j6, double d);

    private static native void setMaxBufferSize_0(long j6, int i5);

    private static native void setMinDist_0(long j6, double d);

    private static native void setTemplate_0(long j6, long j7, double d, double d6);

    private static native void setTemplate_1(long j6, long j7);

    private static native void setTemplate_2(long j6, long j7, long j8, long j9, double d, double d6);

    private static native void setTemplate_3(long j6, long j7, long j8, long j9);

    public void detect(Mat mat, Mat mat2, Mat mat3) {
        detect_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getCannyHighThresh() {
        return getCannyHighThresh_0(this.nativeObj);
    }

    public int getCannyLowThresh() {
        return getCannyLowThresh_0(this.nativeObj);
    }

    public double getDp() {
        return getDp_0(this.nativeObj);
    }

    public int getMaxBufferSize() {
        return getMaxBufferSize_0(this.nativeObj);
    }

    public double getMinDist() {
        return getMinDist_0(this.nativeObj);
    }

    public void setCannyHighThresh(int i5) {
        setCannyHighThresh_0(this.nativeObj, i5);
    }

    public void setCannyLowThresh(int i5) {
        setCannyLowThresh_0(this.nativeObj, i5);
    }

    public void setDp(double d) {
        setDp_0(this.nativeObj, d);
    }

    public void setMaxBufferSize(int i5) {
        setMaxBufferSize_0(this.nativeObj, i5);
    }

    public void setMinDist(double d) {
        setMinDist_0(this.nativeObj, d);
    }

    public void setTemplate(Mat mat, Point point) {
        setTemplate_0(this.nativeObj, mat.nativeObj, point.f7681x, point.f7682y);
    }

    public void detect(Mat mat, Mat mat2) {
        detect_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void setTemplate(Mat mat) {
        setTemplate_1(this.nativeObj, mat.nativeObj);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        detect_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public void setTemplate(Mat mat, Mat mat2, Mat mat3, Point point) {
        setTemplate_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f7681x, point.f7682y);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        detect_3(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public void setTemplate(Mat mat, Mat mat2, Mat mat3) {
        setTemplate_3(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }
}
