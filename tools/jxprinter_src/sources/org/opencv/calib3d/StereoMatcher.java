package org.opencv.calib3d;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StereoMatcher extends Algorithm {
    public static final int DISP_SCALE = 16;
    public static final int DISP_SHIFT = 4;

    public StereoMatcher(long j6) {
        super(j6);
    }

    public static StereoMatcher __fromPtr__(long j6) {
        return new StereoMatcher(j6);
    }

    private static native void compute_0(long j6, long j7, long j8, long j9);

    private static native void delete(long j6);

    private static native int getBlockSize_0(long j6);

    private static native int getDisp12MaxDiff_0(long j6);

    private static native int getMinDisparity_0(long j6);

    private static native int getNumDisparities_0(long j6);

    private static native int getSpeckleRange_0(long j6);

    private static native int getSpeckleWindowSize_0(long j6);

    private static native void setBlockSize_0(long j6, int i5);

    private static native void setDisp12MaxDiff_0(long j6, int i5);

    private static native void setMinDisparity_0(long j6, int i5);

    private static native void setNumDisparities_0(long j6, int i5);

    private static native void setSpeckleRange_0(long j6, int i5);

    private static native void setSpeckleWindowSize_0(long j6, int i5);

    public void compute(Mat mat, Mat mat2, Mat mat3) {
        compute_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getBlockSize() {
        return getBlockSize_0(this.nativeObj);
    }

    public int getDisp12MaxDiff() {
        return getDisp12MaxDiff_0(this.nativeObj);
    }

    public int getMinDisparity() {
        return getMinDisparity_0(this.nativeObj);
    }

    public int getNumDisparities() {
        return getNumDisparities_0(this.nativeObj);
    }

    public int getSpeckleRange() {
        return getSpeckleRange_0(this.nativeObj);
    }

    public int getSpeckleWindowSize() {
        return getSpeckleWindowSize_0(this.nativeObj);
    }

    public void setBlockSize(int i5) {
        setBlockSize_0(this.nativeObj, i5);
    }

    public void setDisp12MaxDiff(int i5) {
        setDisp12MaxDiff_0(this.nativeObj, i5);
    }

    public void setMinDisparity(int i5) {
        setMinDisparity_0(this.nativeObj, i5);
    }

    public void setNumDisparities(int i5) {
        setNumDisparities_0(this.nativeObj, i5);
    }

    public void setSpeckleRange(int i5) {
        setSpeckleRange_0(this.nativeObj, i5);
    }

    public void setSpeckleWindowSize(int i5) {
        setSpeckleWindowSize_0(this.nativeObj, i5);
    }
}
