package org.opencv.features2d;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BOWImgDescriptorExtractor {
    protected final long nativeObj;

    public BOWImgDescriptorExtractor(long j6) {
        this.nativeObj = j6;
    }

    public static BOWImgDescriptorExtractor __fromPtr__(long j6) {
        return new BOWImgDescriptorExtractor(j6);
    }

    private static native void compute_0(long j6, long j7, long j8, long j9);

    private static native void delete(long j6);

    private static native int descriptorSize_0(long j6);

    private static native int descriptorType_0(long j6);

    private static native long getVocabulary_0(long j6);

    private static native void setVocabulary_0(long j6, long j7);

    public void compute(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2) {
        compute_0(this.nativeObj, mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj);
    }

    public int descriptorSize() {
        return descriptorSize_0(this.nativeObj);
    }

    public int descriptorType() {
        return descriptorType_0(this.nativeObj);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public Mat getVocabulary() {
        return new Mat(getVocabulary_0(this.nativeObj));
    }

    public void setVocabulary(Mat mat) {
        setVocabulary_0(this.nativeObj, mat.nativeObj);
    }
}
