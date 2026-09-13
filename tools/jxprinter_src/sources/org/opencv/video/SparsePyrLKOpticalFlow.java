package org.opencv.video;

import org.opencv.core.Size;
import org.opencv.core.TermCriteria;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SparsePyrLKOpticalFlow extends SparseOpticalFlow {
    public SparsePyrLKOpticalFlow(long j6) {
        super(j6);
    }

    public static SparsePyrLKOpticalFlow __fromPtr__(long j6) {
        return new SparsePyrLKOpticalFlow(j6);
    }

    public static SparsePyrLKOpticalFlow create(Size size, int i5, TermCriteria termCriteria, int i6, double d) {
        return __fromPtr__(create_0(size.width, size.height, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i6, d));
    }

    private static native long create_0(double d, double d6, int i5, int i6, int i7, double d7, int i8, double d8);

    private static native long create_1(double d, double d6, int i5, int i6, int i7, double d7, int i8);

    private static native long create_2(double d, double d6, int i5, int i6, int i7, double d7);

    private static native long create_3(double d, double d6, int i5);

    private static native long create_4(double d, double d6);

    private static native long create_5();

    private static native void delete(long j6);

    private static native int getFlags_0(long j6);

    private static native int getMaxLevel_0(long j6);

    private static native double getMinEigThreshold_0(long j6);

    private static native double[] getTermCriteria_0(long j6);

    private static native double[] getWinSize_0(long j6);

    private static native void setFlags_0(long j6, int i5);

    private static native void setMaxLevel_0(long j6, int i5);

    private static native void setMinEigThreshold_0(long j6, double d);

    private static native void setTermCriteria_0(long j6, int i5, int i6, double d);

    private static native void setWinSize_0(long j6, double d, double d6);

    @Override // org.opencv.video.SparseOpticalFlow, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getFlags() {
        return getFlags_0(this.nativeObj);
    }

    public int getMaxLevel() {
        return getMaxLevel_0(this.nativeObj);
    }

    public double getMinEigThreshold() {
        return getMinEigThreshold_0(this.nativeObj);
    }

    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }

    public Size getWinSize() {
        return new Size(getWinSize_0(this.nativeObj));
    }

    public void setFlags(int i5) {
        setFlags_0(this.nativeObj, i5);
    }

    public void setMaxLevel(int i5) {
        setMaxLevel_0(this.nativeObj, i5);
    }

    public void setMinEigThreshold(double d) {
        setMinEigThreshold_0(this.nativeObj, d);
    }

    public void setTermCriteria(TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public void setWinSize(Size size) {
        setWinSize_0(this.nativeObj, size.width, size.height);
    }

    public static SparsePyrLKOpticalFlow create(Size size, int i5, TermCriteria termCriteria, int i6) {
        return __fromPtr__(create_1(size.width, size.height, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i6));
    }

    public static SparsePyrLKOpticalFlow create(Size size, int i5, TermCriteria termCriteria) {
        return __fromPtr__(create_2(size.width, size.height, i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon));
    }

    public static SparsePyrLKOpticalFlow create(Size size, int i5) {
        return __fromPtr__(create_3(size.width, size.height, i5));
    }

    public static SparsePyrLKOpticalFlow create(Size size) {
        return __fromPtr__(create_4(size.width, size.height));
    }

    public static SparsePyrLKOpticalFlow create() {
        return __fromPtr__(create_5());
    }
}
