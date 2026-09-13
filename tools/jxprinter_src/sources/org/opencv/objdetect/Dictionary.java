package org.opencv.objdetect;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Dictionary {
    protected final long nativeObj;

    public Dictionary(long j6) {
        this.nativeObj = j6;
    }

    private static native long Dictionary_0();

    private static native long Dictionary_1(long j6, int i5, int i6);

    private static native long Dictionary_2(long j6, int i5);

    public static Dictionary __fromPtr__(long j6) {
        return new Dictionary(j6);
    }

    private static native void delete(long j6);

    private static native void generateImageMarker_0(long j6, int i5, int i6, long j7, int i7);

    private static native void generateImageMarker_1(long j6, int i5, int i6, long j7);

    public static Mat getBitsFromByteList(Mat mat, int i5) {
        return new Mat(getBitsFromByteList_0(mat.nativeObj, i5));
    }

    private static native long getBitsFromByteList_0(long j6, int i5);

    public static Mat getByteListFromBits(Mat mat) {
        return new Mat(getByteListFromBits_0(mat.nativeObj));
    }

    private static native long getByteListFromBits_0(long j6);

    private static native int getDistanceToId_0(long j6, long j7, int i5, boolean z6);

    private static native int getDistanceToId_1(long j6, long j7, int i5);

    private static native long get_bytesList_0(long j6);

    private static native int get_markerSize_0(long j6);

    private static native int get_maxCorrectionBits_0(long j6);

    private static native boolean identify_0(long j6, long j7, double[] dArr, double[] dArr2, double d);

    private static native void set_bytesList_0(long j6, long j7);

    private static native void set_markerSize_0(long j6, int i5);

    private static native void set_maxCorrectionBits_0(long j6, int i5);

    public void finalize() {
        delete(this.nativeObj);
    }

    public void generateImageMarker(int i5, int i6, Mat mat, int i7) {
        generateImageMarker_0(this.nativeObj, i5, i6, mat.nativeObj, i7);
    }

    public int getDistanceToId(Mat mat, int i5, boolean z6) {
        return getDistanceToId_0(this.nativeObj, mat.nativeObj, i5, z6);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public Mat get_bytesList() {
        return new Mat(get_bytesList_0(this.nativeObj));
    }

    public int get_markerSize() {
        return get_markerSize_0(this.nativeObj);
    }

    public int get_maxCorrectionBits() {
        return get_maxCorrectionBits_0(this.nativeObj);
    }

    public boolean identify(Mat mat, int[] iArr, int[] iArr2, double d) {
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        boolean zIdentify_0 = identify_0(this.nativeObj, mat.nativeObj, dArr, dArr2, d);
        if (iArr != null) {
            iArr[0] = (int) dArr[0];
        }
        if (iArr2 != null) {
            iArr2[0] = (int) dArr2[0];
        }
        return zIdentify_0;
    }

    public void set_bytesList(Mat mat) {
        set_bytesList_0(this.nativeObj, mat.nativeObj);
    }

    public void set_markerSize(int i5) {
        set_markerSize_0(this.nativeObj, i5);
    }

    public void set_maxCorrectionBits(int i5) {
        set_maxCorrectionBits_0(this.nativeObj, i5);
    }

    public Dictionary() {
        this.nativeObj = Dictionary_0();
    }

    public void generateImageMarker(int i5, int i6, Mat mat) {
        generateImageMarker_1(this.nativeObj, i5, i6, mat.nativeObj);
    }

    public int getDistanceToId(Mat mat, int i5) {
        return getDistanceToId_1(this.nativeObj, mat.nativeObj, i5);
    }

    public Dictionary(Mat mat, int i5, int i6) {
        this.nativeObj = Dictionary_1(mat.nativeObj, i5, i6);
    }

    public Dictionary(Mat mat, int i5) {
        this.nativeObj = Dictionary_2(mat.nativeObj, i5);
    }
}
