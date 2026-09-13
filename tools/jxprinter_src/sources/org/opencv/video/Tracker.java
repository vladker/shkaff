package org.opencv.video;

import org.opencv.core.Mat;
import org.opencv.core.Rect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Tracker {
    protected final long nativeObj;

    public Tracker(long j6) {
        this.nativeObj = j6;
    }

    public static Tracker __fromPtr__(long j6) {
        return new Tracker(j6);
    }

    private static native void delete(long j6);

    private static native void init_0(long j6, long j7, int i5, int i6, int i7, int i8);

    private static native boolean update_0(long j6, long j7, double[] dArr);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public void init(Mat mat, Rect rect) {
        init_0(this.nativeObj, mat.nativeObj, rect.f7686x, rect.f7687y, rect.width, rect.height);
    }

    public boolean update(Mat mat, Rect rect) {
        double[] dArr = new double[4];
        boolean zUpdate_0 = update_0(this.nativeObj, mat.nativeObj, dArr);
        if (rect != null) {
            rect.f7686x = (int) dArr[0];
            rect.f7687y = (int) dArr[1];
            rect.width = (int) dArr[2];
            rect.height = (int) dArr[3];
        }
        return zUpdate_0;
    }
}
