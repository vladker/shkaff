package org.opencv.video;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BackgroundSubtractor extends Algorithm {
    public BackgroundSubtractor(long j6) {
        super(j6);
    }

    public static BackgroundSubtractor __fromPtr__(long j6) {
        return new BackgroundSubtractor(j6);
    }

    private static native void apply_0(long j6, long j7, long j8, double d);

    private static native void apply_1(long j6, long j7, long j8);

    private static native void delete(long j6);

    private static native void getBackgroundImage_0(long j6, long j7);

    public void apply(Mat mat, Mat mat2, double d) {
        apply_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, d);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public void getBackgroundImage(Mat mat) {
        getBackgroundImage_0(this.nativeObj, mat.nativeObj);
    }

    public void apply(Mat mat, Mat mat2) {
        apply_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
