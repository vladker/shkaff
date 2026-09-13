package org.opencv.features2d;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfRect;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MSER extends Feature2D {
    public MSER(long j6) {
        super(j6);
    }

    public static MSER __fromPtr__(long j6) {
        return new MSER(j6);
    }

    public static MSER create(int i5, int i6, int i7, double d, double d6, int i8, double d7, double d8, int i9) {
        return __fromPtr__(create_0(i5, i6, i7, d, d6, i8, d7, d8, i9));
    }

    private static native long create_0(int i5, int i6, int i7, double d, double d6, int i8, double d7, double d8, int i9);

    private static native long create_1(int i5, int i6, int i7, double d, double d6, int i8, double d7, double d8);

    private static native long create_2(int i5, int i6, int i7, double d, double d6, int i8, double d7);

    private static native long create_3(int i5, int i6, int i7, double d, double d6, int i8);

    private static native long create_4(int i5, int i6, int i7, double d, double d6);

    private static native long create_5(int i5, int i6, int i7, double d);

    private static native long create_6(int i5, int i6, int i7);

    private static native long create_7(int i5, int i6);

    private static native long create_8(int i5);

    private static native long create_9();

    private static native void delete(long j6);

    private static native void detectRegions_0(long j6, long j7, long j8, long j9);

    private static native double getAreaThreshold_0(long j6);

    private static native String getDefaultName_0(long j6);

    private static native int getDelta_0(long j6);

    private static native int getEdgeBlurSize_0(long j6);

    private static native int getMaxArea_0(long j6);

    private static native int getMaxEvolution_0(long j6);

    private static native double getMaxVariation_0(long j6);

    private static native int getMinArea_0(long j6);

    private static native double getMinDiversity_0(long j6);

    private static native double getMinMargin_0(long j6);

    private static native boolean getPass2Only_0(long j6);

    private static native void setAreaThreshold_0(long j6, double d);

    private static native void setDelta_0(long j6, int i5);

    private static native void setEdgeBlurSize_0(long j6, int i5);

    private static native void setMaxArea_0(long j6, int i5);

    private static native void setMaxEvolution_0(long j6, int i5);

    private static native void setMaxVariation_0(long j6, double d);

    private static native void setMinArea_0(long j6, int i5);

    private static native void setMinDiversity_0(long j6, double d);

    private static native void setMinMargin_0(long j6, double d);

    private static native void setPass2Only_0(long j6, boolean z6);

    public void detectRegions(Mat mat, List<MatOfPoint> list, MatOfRect matOfRect) {
        Mat mat2 = new Mat();
        detectRegions_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, matOfRect.nativeObj);
        Converters.Mat_to_vector_vector_Point(mat2, list);
        mat2.release();
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public double getAreaThreshold() {
        return getAreaThreshold_0(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public int getDelta() {
        return getDelta_0(this.nativeObj);
    }

    public int getEdgeBlurSize() {
        return getEdgeBlurSize_0(this.nativeObj);
    }

    public int getMaxArea() {
        return getMaxArea_0(this.nativeObj);
    }

    public int getMaxEvolution() {
        return getMaxEvolution_0(this.nativeObj);
    }

    public double getMaxVariation() {
        return getMaxVariation_0(this.nativeObj);
    }

    public int getMinArea() {
        return getMinArea_0(this.nativeObj);
    }

    public double getMinDiversity() {
        return getMinDiversity_0(this.nativeObj);
    }

    public double getMinMargin() {
        return getMinMargin_0(this.nativeObj);
    }

    public boolean getPass2Only() {
        return getPass2Only_0(this.nativeObj);
    }

    public void setAreaThreshold(double d) {
        setAreaThreshold_0(this.nativeObj, d);
    }

    public void setDelta(int i5) {
        setDelta_0(this.nativeObj, i5);
    }

    public void setEdgeBlurSize(int i5) {
        setEdgeBlurSize_0(this.nativeObj, i5);
    }

    public void setMaxArea(int i5) {
        setMaxArea_0(this.nativeObj, i5);
    }

    public void setMaxEvolution(int i5) {
        setMaxEvolution_0(this.nativeObj, i5);
    }

    public void setMaxVariation(double d) {
        setMaxVariation_0(this.nativeObj, d);
    }

    public void setMinArea(int i5) {
        setMinArea_0(this.nativeObj, i5);
    }

    public void setMinDiversity(double d) {
        setMinDiversity_0(this.nativeObj, d);
    }

    public void setMinMargin(double d) {
        setMinMargin_0(this.nativeObj, d);
    }

    public void setPass2Only(boolean z6) {
        setPass2Only_0(this.nativeObj, z6);
    }

    public static MSER create(int i5, int i6, int i7, double d, double d6, int i8, double d7, double d8) {
        return __fromPtr__(create_1(i5, i6, i7, d, d6, i8, d7, d8));
    }

    public static MSER create(int i5, int i6, int i7, double d, double d6, int i8, double d7) {
        return __fromPtr__(create_2(i5, i6, i7, d, d6, i8, d7));
    }

    public static MSER create(int i5, int i6, int i7, double d, double d6, int i8) {
        return __fromPtr__(create_3(i5, i6, i7, d, d6, i8));
    }

    public static MSER create(int i5, int i6, int i7, double d, double d6) {
        return __fromPtr__(create_4(i5, i6, i7, d, d6));
    }

    public static MSER create(int i5, int i6, int i7, double d) {
        return __fromPtr__(create_5(i5, i6, i7, d));
    }

    public static MSER create(int i5, int i6, int i7) {
        return __fromPtr__(create_6(i5, i6, i7));
    }

    public static MSER create(int i5, int i6) {
        return __fromPtr__(create_7(i5, i6));
    }

    public static MSER create(int i5) {
        return __fromPtr__(create_8(i5));
    }

    public static MSER create() {
        return __fromPtr__(create_9());
    }
}
