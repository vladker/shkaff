package org.opencv.calib3d;

import org.opencv.core.Rect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StereoBM extends StereoMatcher {
    public static final int PREFILTER_NORMALIZED_RESPONSE = 0;
    public static final int PREFILTER_XSOBEL = 1;

    public StereoBM(long j6) {
        super(j6);
    }

    public static StereoBM __fromPtr__(long j6) {
        return new StereoBM(j6);
    }

    public static StereoBM create(int i5, int i6) {
        return __fromPtr__(create_0(i5, i6));
    }

    private static native long create_0(int i5, int i6);

    private static native long create_1(int i5);

    private static native long create_2();

    private static native void delete(long j6);

    private static native int getPreFilterCap_0(long j6);

    private static native int getPreFilterSize_0(long j6);

    private static native int getPreFilterType_0(long j6);

    private static native double[] getROI1_0(long j6);

    private static native double[] getROI2_0(long j6);

    private static native int getSmallerBlockSize_0(long j6);

    private static native int getTextureThreshold_0(long j6);

    private static native int getUniquenessRatio_0(long j6);

    private static native void setPreFilterCap_0(long j6, int i5);

    private static native void setPreFilterSize_0(long j6, int i5);

    private static native void setPreFilterType_0(long j6, int i5);

    private static native void setROI1_0(long j6, int i5, int i6, int i7, int i8);

    private static native void setROI2_0(long j6, int i5, int i6, int i7, int i8);

    private static native void setSmallerBlockSize_0(long j6, int i5);

    private static native void setTextureThreshold_0(long j6, int i5);

    private static native void setUniquenessRatio_0(long j6, int i5);

    @Override // org.opencv.calib3d.StereoMatcher, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getPreFilterCap() {
        return getPreFilterCap_0(this.nativeObj);
    }

    public int getPreFilterSize() {
        return getPreFilterSize_0(this.nativeObj);
    }

    public int getPreFilterType() {
        return getPreFilterType_0(this.nativeObj);
    }

    public Rect getROI1() {
        return new Rect(getROI1_0(this.nativeObj));
    }

    public Rect getROI2() {
        return new Rect(getROI2_0(this.nativeObj));
    }

    public int getSmallerBlockSize() {
        return getSmallerBlockSize_0(this.nativeObj);
    }

    public int getTextureThreshold() {
        return getTextureThreshold_0(this.nativeObj);
    }

    public int getUniquenessRatio() {
        return getUniquenessRatio_0(this.nativeObj);
    }

    public void setPreFilterCap(int i5) {
        setPreFilterCap_0(this.nativeObj, i5);
    }

    public void setPreFilterSize(int i5) {
        setPreFilterSize_0(this.nativeObj, i5);
    }

    public void setPreFilterType(int i5) {
        setPreFilterType_0(this.nativeObj, i5);
    }

    public void setROI1(Rect rect) {
        setROI1_0(this.nativeObj, rect.f7686x, rect.f7687y, rect.width, rect.height);
    }

    public void setROI2(Rect rect) {
        setROI2_0(this.nativeObj, rect.f7686x, rect.f7687y, rect.width, rect.height);
    }

    public void setSmallerBlockSize(int i5) {
        setSmallerBlockSize_0(this.nativeObj, i5);
    }

    public void setTextureThreshold(int i5) {
        setTextureThreshold_0(this.nativeObj, i5);
    }

    public void setUniquenessRatio(int i5) {
        setUniquenessRatio_0(this.nativeObj, i5);
    }

    public static StereoBM create(int i5) {
        return __fromPtr__(create_1(i5));
    }

    public static StereoBM create() {
        return __fromPtr__(create_2());
    }
}
