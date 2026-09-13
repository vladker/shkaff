package org.opencv.imgproc;

import org.opencv.core.Mat;
import org.opencv.core.Point;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class IntelligentScissorsMB {
    protected final long nativeObj;

    public IntelligentScissorsMB(long j6) {
        this.nativeObj = j6;
    }

    private static native long IntelligentScissorsMB_0();

    public static IntelligentScissorsMB __fromPtr__(long j6) {
        return new IntelligentScissorsMB(j6);
    }

    private static native long applyImageFeatures_0(long j6, long j7, long j8, long j9, long j10);

    private static native long applyImageFeatures_1(long j6, long j7, long j8, long j9);

    private static native long applyImage_0(long j6, long j7);

    private static native void buildMap_0(long j6, double d, double d6);

    private static native void delete(long j6);

    private static native void getContour_0(long j6, double d, double d6, long j7, boolean z6);

    private static native void getContour_1(long j6, double d, double d6, long j7);

    private static native long setEdgeFeatureCannyParameters_0(long j6, double d, double d6, int i5, boolean z6);

    private static native long setEdgeFeatureCannyParameters_1(long j6, double d, double d6, int i5);

    private static native long setEdgeFeatureCannyParameters_2(long j6, double d, double d6);

    private static native long setEdgeFeatureZeroCrossingParameters_0(long j6, float f6);

    private static native long setEdgeFeatureZeroCrossingParameters_1(long j6);

    private static native long setGradientMagnitudeMaxLimit_0(long j6, float f6);

    private static native long setGradientMagnitudeMaxLimit_1(long j6);

    private static native long setWeights_0(long j6, float f6, float f7, float f8);

    public IntelligentScissorsMB applyImage(Mat mat) {
        return new IntelligentScissorsMB(applyImage_0(this.nativeObj, mat.nativeObj));
    }

    public IntelligentScissorsMB applyImageFeatures(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        return new IntelligentScissorsMB(applyImageFeatures_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj));
    }

    public void buildMap(Point point) {
        buildMap_0(this.nativeObj, point.f7681x, point.f7682y);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public void getContour(Point point, Mat mat, boolean z6) {
        getContour_0(this.nativeObj, point.f7681x, point.f7682y, mat.nativeObj, z6);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public IntelligentScissorsMB setEdgeFeatureCannyParameters(double d, double d6, int i5, boolean z6) {
        return new IntelligentScissorsMB(setEdgeFeatureCannyParameters_0(this.nativeObj, d, d6, i5, z6));
    }

    public IntelligentScissorsMB setEdgeFeatureZeroCrossingParameters(float f6) {
        return new IntelligentScissorsMB(setEdgeFeatureZeroCrossingParameters_0(this.nativeObj, f6));
    }

    public IntelligentScissorsMB setGradientMagnitudeMaxLimit(float f6) {
        return new IntelligentScissorsMB(setGradientMagnitudeMaxLimit_0(this.nativeObj, f6));
    }

    public IntelligentScissorsMB setWeights(float f6, float f7, float f8) {
        return new IntelligentScissorsMB(setWeights_0(this.nativeObj, f6, f7, f8));
    }

    public IntelligentScissorsMB() {
        this.nativeObj = IntelligentScissorsMB_0();
    }

    public IntelligentScissorsMB applyImageFeatures(Mat mat, Mat mat2, Mat mat3) {
        return new IntelligentScissorsMB(applyImageFeatures_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj));
    }

    public void getContour(Point point, Mat mat) {
        getContour_1(this.nativeObj, point.f7681x, point.f7682y, mat.nativeObj);
    }

    public IntelligentScissorsMB setEdgeFeatureCannyParameters(double d, double d6, int i5) {
        return new IntelligentScissorsMB(setEdgeFeatureCannyParameters_1(this.nativeObj, d, d6, i5));
    }

    public IntelligentScissorsMB setEdgeFeatureZeroCrossingParameters() {
        return new IntelligentScissorsMB(setEdgeFeatureZeroCrossingParameters_1(this.nativeObj));
    }

    public IntelligentScissorsMB setGradientMagnitudeMaxLimit() {
        return new IntelligentScissorsMB(setGradientMagnitudeMaxLimit_1(this.nativeObj));
    }

    public IntelligentScissorsMB setEdgeFeatureCannyParameters(double d, double d6) {
        return new IntelligentScissorsMB(setEdgeFeatureCannyParameters_2(this.nativeObj, d, d6));
    }
}
