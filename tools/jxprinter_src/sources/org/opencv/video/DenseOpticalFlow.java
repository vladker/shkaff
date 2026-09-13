package org.opencv.video;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DenseOpticalFlow extends Algorithm {
    public DenseOpticalFlow(long j6) {
        super(j6);
    }

    public static DenseOpticalFlow __fromPtr__(long j6) {
        return new DenseOpticalFlow(j6);
    }

    private static native void calc_0(long j6, long j7, long j8, long j9);

    private static native void collectGarbage_0(long j6);

    private static native void delete(long j6);

    public void calc(Mat mat, Mat mat2, Mat mat3) {
        calc_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void collectGarbage() {
        collectGarbage_0(this.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }
}
