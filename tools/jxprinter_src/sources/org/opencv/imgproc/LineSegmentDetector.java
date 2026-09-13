package org.opencv.imgproc;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class LineSegmentDetector extends Algorithm {
    public LineSegmentDetector(long j6) {
        super(j6);
    }

    public static LineSegmentDetector __fromPtr__(long j6) {
        return new LineSegmentDetector(j6);
    }

    private static native int compareSegments_0(long j6, double d, double d6, long j7, long j8, long j9);

    private static native int compareSegments_1(long j6, double d, double d6, long j7, long j8);

    private static native void delete(long j6);

    private static native void detect_0(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void detect_1(long j6, long j7, long j8, long j9, long j10);

    private static native void detect_2(long j6, long j7, long j8, long j9);

    private static native void detect_3(long j6, long j7, long j8);

    private static native void drawSegments_0(long j6, long j7, long j8);

    public int compareSegments(Size size, Mat mat, Mat mat2, Mat mat3) {
        return compareSegments_0(this.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        detect_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public void drawSegments(Mat mat, Mat mat2) {
        drawSegments_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int compareSegments(Size size, Mat mat, Mat mat2) {
        return compareSegments_1(this.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        detect_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3) {
        detect_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void detect(Mat mat, Mat mat2) {
        detect_3(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
