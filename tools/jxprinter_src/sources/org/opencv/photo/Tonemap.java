package org.opencv.photo;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Tonemap extends Algorithm {
    public Tonemap(long j6) {
        super(j6);
    }

    public static Tonemap __fromPtr__(long j6) {
        return new Tonemap(j6);
    }

    private static native void delete(long j6);

    private static native float getGamma_0(long j6);

    private static native void process_0(long j6, long j7, long j8);

    private static native void setGamma_0(long j6, float f6);

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getGamma() {
        return getGamma_0(this.nativeObj);
    }

    public void process(Mat mat, Mat mat2) {
        process_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void setGamma(float f6) {
        setGamma_0(this.nativeObj, f6);
    }
}
