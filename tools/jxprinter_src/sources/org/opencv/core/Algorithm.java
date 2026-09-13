package org.opencv.core;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Algorithm {
    protected final long nativeObj;

    public Algorithm(long j6) {
        this.nativeObj = j6;
    }

    public static Algorithm __fromPtr__(long j6) {
        return new Algorithm(j6);
    }

    private static native void clear_0(long j6);

    private static native void delete(long j6);

    private static native boolean empty_0(long j6);

    private static native String getDefaultName_0(long j6);

    private static native void save_0(long j6, String str);

    public void clear() {
        clear_0(this.nativeObj);
    }

    public boolean empty() {
        return empty_0(this.nativeObj);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public void save(String str) {
        save_0(this.nativeObj, str);
    }
}
