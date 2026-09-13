package org.opencv.dnn;

import org.opencv.core.Scalar;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Image2BlobParams {
    protected final long nativeObj;

    public Image2BlobParams(long j6) {
        this.nativeObj = j6;
    }

    private static native long Image2BlobParams_0();

    private static native long Image2BlobParams_1(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, boolean z6, int i5);

    private static native long Image2BlobParams_4(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, boolean z6);

    private static native long Image2BlobParams_5(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14);

    private static native long Image2BlobParams_6(double d, double d6, double d7, double d8, double d9, double d10);

    private static native long Image2BlobParams_7(double d, double d6, double d7, double d8);

    public static Image2BlobParams __fromPtr__(long j6) {
        return new Image2BlobParams(j6);
    }

    private static native void delete(long j6);

    private static native int get_ddepth_0(long j6);

    private static native double[] get_mean_0(long j6);

    private static native double[] get_scalefactor_0(long j6);

    private static native double[] get_size_0(long j6);

    private static native boolean get_swapRB_0(long j6);

    private static native void set_ddepth_0(long j6, int i5);

    private static native void set_mean_0(long j6, double d, double d6, double d7, double d8);

    private static native void set_scalefactor_0(long j6, double d, double d6, double d7, double d8);

    private static native void set_size_0(long j6, double d, double d6);

    private static native void set_swapRB_0(long j6, boolean z6);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int get_ddepth() {
        return get_ddepth_0(this.nativeObj);
    }

    public Scalar get_mean() {
        return new Scalar(get_mean_0(this.nativeObj));
    }

    public Scalar get_scalefactor() {
        return new Scalar(get_scalefactor_0(this.nativeObj));
    }

    public Size get_size() {
        return new Size(get_size_0(this.nativeObj));
    }

    public boolean get_swapRB() {
        return get_swapRB_0(this.nativeObj);
    }

    public void set_ddepth(int i5) {
        set_ddepth_0(this.nativeObj, i5);
    }

    public void set_mean(Scalar scalar) {
        long j6 = this.nativeObj;
        double[] dArr = scalar.val;
        set_mean_0(j6, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public void set_scalefactor(Scalar scalar) {
        long j6 = this.nativeObj;
        double[] dArr = scalar.val;
        set_scalefactor_0(j6, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public void set_size(Size size) {
        set_size_0(this.nativeObj, size.width, size.height);
    }

    public void set_swapRB(boolean z6) {
        set_swapRB_0(this.nativeObj, z6);
    }

    public Image2BlobParams() {
        this.nativeObj = Image2BlobParams_0();
    }

    public Image2BlobParams(Scalar scalar, Size size, Scalar scalar2, boolean z6, int i5) {
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = dArr[3];
        double d9 = size.width;
        double d10 = size.height;
        double[] dArr2 = scalar2.val;
        this.nativeObj = Image2BlobParams_1(d, d6, d7, d8, d9, d10, dArr2[0], dArr2[1], dArr2[2], dArr2[3], z6, i5);
    }

    public Image2BlobParams(Scalar scalar, Size size, Scalar scalar2, boolean z6) {
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = dArr[3];
        double d9 = size.width;
        double d10 = size.height;
        double[] dArr2 = scalar2.val;
        this.nativeObj = Image2BlobParams_4(d, d6, d7, d8, d9, d10, dArr2[0], dArr2[1], dArr2[2], dArr2[3], z6);
    }

    public Image2BlobParams(Scalar scalar, Size size, Scalar scalar2) {
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = dArr[3];
        double d9 = size.width;
        double d10 = size.height;
        double[] dArr2 = scalar2.val;
        this.nativeObj = Image2BlobParams_5(d, d6, d7, d8, d9, d10, dArr2[0], dArr2[1], dArr2[2], dArr2[3]);
    }

    public Image2BlobParams(Scalar scalar, Size size) {
        double[] dArr = scalar.val;
        this.nativeObj = Image2BlobParams_6(dArr[0], dArr[1], dArr[2], dArr[3], size.width, size.height);
    }

    public Image2BlobParams(Scalar scalar) {
        double[] dArr = scalar.val;
        this.nativeObj = Image2BlobParams_7(dArr[0], dArr[1], dArr[2], dArr[3]);
    }
}
