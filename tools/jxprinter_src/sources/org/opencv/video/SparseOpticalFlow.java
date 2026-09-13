package org.opencv.video;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SparseOpticalFlow extends Algorithm {
    public SparseOpticalFlow(long j6) {
        super(j6);
    }

    public static SparseOpticalFlow __fromPtr__(long j6) {
        return new SparseOpticalFlow(j6);
    }

    private static native void calc_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12);

    private static native void calc_1(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void delete(long j6);

    public void calc(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        calc_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public void calc(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        calc_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }
}
