package org.opencv.objdetect;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CharucoParameters {
    protected final long nativeObj;

    public CharucoParameters(long j6) {
        this.nativeObj = j6;
    }

    private static native long CharucoParameters_0();

    public static CharucoParameters __fromPtr__(long j6) {
        return new CharucoParameters(j6);
    }

    private static native void delete(long j6);

    private static native long get_cameraMatrix_0(long j6);

    private static native long get_distCoeffs_0(long j6);

    private static native int get_minMarkers_0(long j6);

    private static native boolean get_tryRefineMarkers_0(long j6);

    private static native void set_cameraMatrix_0(long j6, long j7);

    private static native void set_distCoeffs_0(long j6, long j7);

    private static native void set_minMarkers_0(long j6, int i5);

    private static native void set_tryRefineMarkers_0(long j6, boolean z6);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public Mat get_cameraMatrix() {
        return new Mat(get_cameraMatrix_0(this.nativeObj));
    }

    public Mat get_distCoeffs() {
        return new Mat(get_distCoeffs_0(this.nativeObj));
    }

    public int get_minMarkers() {
        return get_minMarkers_0(this.nativeObj);
    }

    public boolean get_tryRefineMarkers() {
        return get_tryRefineMarkers_0(this.nativeObj);
    }

    public void set_cameraMatrix(Mat mat) {
        set_cameraMatrix_0(this.nativeObj, mat.nativeObj);
    }

    public void set_distCoeffs(Mat mat) {
        set_distCoeffs_0(this.nativeObj, mat.nativeObj);
    }

    public void set_minMarkers(int i5) {
        set_minMarkers_0(this.nativeObj, i5);
    }

    public void set_tryRefineMarkers(boolean z6) {
        set_tryRefineMarkers_0(this.nativeObj, z6);
    }

    public CharucoParameters() {
        this.nativeObj = CharucoParameters_0();
    }
}
