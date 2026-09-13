package org.opencv.videoio;

import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class VideoWriter {
    protected final long nativeObj;

    public VideoWriter(long j6) {
        this.nativeObj = j6;
    }

    private static native long VideoWriter_0();

    private static native long VideoWriter_1(String str, int i5, double d, double d6, double d7, boolean z6);

    private static native long VideoWriter_2(String str, int i5, double d, double d6, double d7);

    private static native long VideoWriter_3(String str, int i5, int i6, double d, double d6, double d7, boolean z6);

    private static native long VideoWriter_4(String str, int i5, int i6, double d, double d6, double d7);

    private static native long VideoWriter_5(String str, int i5, double d, double d6, double d7, long j6);

    private static native long VideoWriter_6(String str, int i5, int i6, double d, double d6, double d7, long j6);

    public static VideoWriter __fromPtr__(long j6) {
        return new VideoWriter(j6);
    }

    private static native void delete(long j6);

    public static int fourcc(char c, char c6, char c7, char c8) {
        return fourcc_0(c, c6, c7, c8);
    }

    private static native int fourcc_0(char c, char c6, char c7, char c8);

    private static native String getBackendName_0(long j6);

    private static native double get_0(long j6, int i5);

    private static native boolean isOpened_0(long j6);

    private static native boolean open_0(long j6, String str, int i5, double d, double d6, double d7, boolean z6);

    private static native boolean open_1(long j6, String str, int i5, double d, double d6, double d7);

    private static native boolean open_2(long j6, String str, int i5, int i6, double d, double d6, double d7, boolean z6);

    private static native boolean open_3(long j6, String str, int i5, int i6, double d, double d6, double d7);

    private static native boolean open_4(long j6, String str, int i5, double d, double d6, double d7, long j7);

    private static native boolean open_5(long j6, String str, int i5, int i6, double d, double d6, double d7, long j7);

    private static native void release_0(long j6);

    private static native boolean set_0(long j6, int i5, double d);

    private static native void write_0(long j6, long j7);

    public void finalize() {
        delete(this.nativeObj);
    }

    public double get(int i5) {
        return get_0(this.nativeObj, i5);
    }

    public String getBackendName() {
        return getBackendName_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public boolean isOpened() {
        return isOpened_0(this.nativeObj);
    }

    public boolean open(String str, int i5, double d, Size size, boolean z6) {
        return open_0(this.nativeObj, str, i5, d, size.width, size.height, z6);
    }

    public void release() {
        release_0(this.nativeObj);
    }

    public boolean set(int i5, double d) {
        return set_0(this.nativeObj, i5, d);
    }

    public void write(Mat mat) {
        write_0(this.nativeObj, mat.nativeObj);
    }

    public VideoWriter() {
        this.nativeObj = VideoWriter_0();
    }

    public boolean open(String str, int i5, double d, Size size) {
        return open_1(this.nativeObj, str, i5, d, size.width, size.height);
    }

    public boolean open(String str, int i5, int i6, double d, Size size, boolean z6) {
        return open_2(this.nativeObj, str, i5, i6, d, size.width, size.height, z6);
    }

    public VideoWriter(String str, int i5, double d, Size size, boolean z6) {
        this.nativeObj = VideoWriter_1(str, i5, d, size.width, size.height, z6);
    }

    public boolean open(String str, int i5, int i6, double d, Size size) {
        return open_3(this.nativeObj, str, i5, i6, d, size.width, size.height);
    }

    public boolean open(String str, int i5, double d, Size size, MatOfInt matOfInt) {
        return open_4(this.nativeObj, str, i5, d, size.width, size.height, matOfInt.nativeObj);
    }

    public VideoWriter(String str, int i5, double d, Size size) {
        this.nativeObj = VideoWriter_2(str, i5, d, size.width, size.height);
    }

    public boolean open(String str, int i5, int i6, double d, Size size, MatOfInt matOfInt) {
        return open_5(this.nativeObj, str, i5, i6, d, size.width, size.height, matOfInt.nativeObj);
    }

    public VideoWriter(String str, int i5, int i6, double d, Size size, boolean z6) {
        this.nativeObj = VideoWriter_3(str, i5, i6, d, size.width, size.height, z6);
    }

    public VideoWriter(String str, int i5, int i6, double d, Size size) {
        this.nativeObj = VideoWriter_4(str, i5, i6, d, size.width, size.height);
    }

    public VideoWriter(String str, int i5, double d, Size size, MatOfInt matOfInt) {
        this.nativeObj = VideoWriter_5(str, i5, d, size.width, size.height, matOfInt.nativeObj);
    }

    public VideoWriter(String str, int i5, int i6, double d, Size size, MatOfInt matOfInt) {
        this.nativeObj = VideoWriter_6(str, i5, i6, d, size.width, size.height, matOfInt.nativeObj);
    }
}
