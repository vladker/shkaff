package org.opencv.imgproc;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CLAHE extends Algorithm {
    public CLAHE(long j6) {
        super(j6);
    }

    public static CLAHE __fromPtr__(long j6) {
        return new CLAHE(j6);
    }

    private static native void apply_0(long j6, long j7, long j8);

    private static native void collectGarbage_0(long j6);

    private static native void delete(long j6);

    private static native double getClipLimit_0(long j6);

    private static native double[] getTilesGridSize_0(long j6);

    private static native void setClipLimit_0(long j6, double d);

    private static native void setTilesGridSize_0(long j6, double d, double d6);

    public void apply(Mat mat, Mat mat2) {
        apply_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void collectGarbage() {
        collectGarbage_0(this.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public double getClipLimit() {
        return getClipLimit_0(this.nativeObj);
    }

    public Size getTilesGridSize() {
        return new Size(getTilesGridSize_0(this.nativeObj));
    }

    public void setClipLimit(double d) {
        setClipLimit_0(this.nativeObj, d);
    }

    public void setTilesGridSize(Size size) {
        setTilesGridSize_0(this.nativeObj, size.width, size.height);
    }
}
