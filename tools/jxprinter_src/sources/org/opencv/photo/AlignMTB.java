package org.opencv.photo;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class AlignMTB extends AlignExposures {
    public AlignMTB(long j6) {
        super(j6);
    }

    public static AlignMTB __fromPtr__(long j6) {
        return new AlignMTB(j6);
    }

    private static native double[] calculateShift_0(long j6, long j7, long j8);

    private static native void computeBitmaps_0(long j6, long j7, long j8, long j9);

    private static native void delete(long j6);

    private static native boolean getCut_0(long j6);

    private static native int getExcludeRange_0(long j6);

    private static native int getMaxBits_0(long j6);

    private static native void process_0(long j6, long j7, long j8, long j9, long j10);

    private static native void process_1(long j6, long j7, long j8);

    private static native void setCut_0(long j6, boolean z6);

    private static native void setExcludeRange_0(long j6, int i5);

    private static native void setMaxBits_0(long j6, int i5);

    private static native void shiftMat_0(long j6, long j7, long j8, double d, double d6);

    public Point calculateShift(Mat mat, Mat mat2) {
        return new Point(calculateShift_0(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }

    public void computeBitmaps(Mat mat, Mat mat2, Mat mat3) {
        computeBitmaps_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    @Override // org.opencv.photo.AlignExposures, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public boolean getCut() {
        return getCut_0(this.nativeObj);
    }

    public int getExcludeRange() {
        return getExcludeRange_0(this.nativeObj);
    }

    public int getMaxBits() {
        return getMaxBits_0(this.nativeObj);
    }

    @Override // org.opencv.photo.AlignExposures
    public void process(List<Mat> list, List<Mat> list2, Mat mat, Mat mat2) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void setCut(boolean z6) {
        setCut_0(this.nativeObj, z6);
    }

    public void setExcludeRange(int i5) {
        setExcludeRange_0(this.nativeObj, i5);
    }

    public void setMaxBits(int i5) {
        setMaxBits_0(this.nativeObj, i5);
    }

    public void shiftMat(Mat mat, Mat mat2, Point point) {
        shiftMat_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, point.f7681x, point.f7682y);
    }

    public void process(List<Mat> list, List<Mat> list2) {
        process_1(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj);
    }
}
