package org.opencv.videoio;

import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class VideoCapture {
    protected final long nativeObj;

    public VideoCapture(long j6) {
        this.nativeObj = j6;
    }

    private static native long VideoCapture_0();

    private static native long VideoCapture_1(String str, int i5);

    private static native long VideoCapture_2(String str);

    private static native long VideoCapture_3(String str, int i5, long j6);

    private static native long VideoCapture_4(int i5, int i6);

    private static native long VideoCapture_5(int i5);

    private static native long VideoCapture_6(int i5, int i6, long j6);

    public static VideoCapture __fromPtr__(long j6) {
        return new VideoCapture(j6);
    }

    private static native void delete(long j6);

    private static native String getBackendName_0(long j6);

    private static native boolean getExceptionMode_0(long j6);

    private static native double get_0(long j6, int i5);

    private static native boolean grab_0(long j6);

    private static native boolean isOpened_0(long j6);

    private static native boolean open_0(long j6, String str, int i5);

    private static native boolean open_1(long j6, String str);

    private static native boolean open_2(long j6, String str, int i5, long j7);

    private static native boolean open_3(long j6, int i5, int i6);

    private static native boolean open_4(long j6, int i5);

    private static native boolean open_5(long j6, int i5, int i6, long j7);

    private static native boolean read_0(long j6, long j7);

    private static native void release_0(long j6);

    private static native boolean retrieve_0(long j6, long j7, int i5);

    private static native boolean retrieve_1(long j6, long j7);

    private static native void setExceptionMode_0(long j6, boolean z6);

    private static native boolean set_0(long j6, int i5, double d);

    public void finalize() {
        delete(this.nativeObj);
    }

    public double get(int i5) {
        return get_0(this.nativeObj, i5);
    }

    public String getBackendName() {
        return getBackendName_0(this.nativeObj);
    }

    public boolean getExceptionMode() {
        return getExceptionMode_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public boolean grab() {
        return grab_0(this.nativeObj);
    }

    public boolean isOpened() {
        return isOpened_0(this.nativeObj);
    }

    public boolean open(String str, int i5) {
        return open_0(this.nativeObj, str, i5);
    }

    public boolean read(Mat mat) {
        return read_0(this.nativeObj, mat.nativeObj);
    }

    public void release() {
        release_0(this.nativeObj);
    }

    public boolean retrieve(Mat mat, int i5) {
        return retrieve_0(this.nativeObj, mat.nativeObj, i5);
    }

    public boolean set(int i5, double d) {
        return set_0(this.nativeObj, i5, d);
    }

    public void setExceptionMode(boolean z6) {
        setExceptionMode_0(this.nativeObj, z6);
    }

    public VideoCapture() {
        this.nativeObj = VideoCapture_0();
    }

    public boolean open(String str) {
        return open_1(this.nativeObj, str);
    }

    public boolean retrieve(Mat mat) {
        return retrieve_1(this.nativeObj, mat.nativeObj);
    }

    public boolean open(String str, int i5, MatOfInt matOfInt) {
        return open_2(this.nativeObj, str, i5, matOfInt.nativeObj);
    }

    public VideoCapture(String str, int i5) {
        this.nativeObj = VideoCapture_1(str, i5);
    }

    public boolean open(int i5, int i6) {
        return open_3(this.nativeObj, i5, i6);
    }

    public boolean open(int i5) {
        return open_4(this.nativeObj, i5);
    }

    public VideoCapture(String str) {
        this.nativeObj = VideoCapture_2(str);
    }

    public boolean open(int i5, int i6, MatOfInt matOfInt) {
        return open_5(this.nativeObj, i5, i6, matOfInt.nativeObj);
    }

    public VideoCapture(String str, int i5, MatOfInt matOfInt) {
        this.nativeObj = VideoCapture_3(str, i5, matOfInt.nativeObj);
    }

    public VideoCapture(int i5, int i6) {
        this.nativeObj = VideoCapture_4(i5, i6);
    }

    public VideoCapture(int i5) {
        this.nativeObj = VideoCapture_5(i5);
    }

    public VideoCapture(int i5, int i6, MatOfInt matOfInt) {
        this.nativeObj = VideoCapture_6(i5, i6, matOfInt.nativeObj);
    }
}
