package org.opencv.video;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TrackerNano_Params {
    protected final long nativeObj;

    public TrackerNano_Params(long j6) {
        this.nativeObj = j6;
    }

    private static native long TrackerNano_Params_0();

    public static TrackerNano_Params __fromPtr__(long j6) {
        return new TrackerNano_Params(j6);
    }

    private static native void delete(long j6);

    private static native String get_backbone_0(long j6);

    private static native int get_backend_0(long j6);

    private static native String get_neckhead_0(long j6);

    private static native int get_target_0(long j6);

    private static native void set_backbone_0(long j6, String str);

    private static native void set_backend_0(long j6, int i5);

    private static native void set_neckhead_0(long j6, String str);

    private static native void set_target_0(long j6, int i5);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public String get_backbone() {
        return get_backbone_0(this.nativeObj);
    }

    public int get_backend() {
        return get_backend_0(this.nativeObj);
    }

    public String get_neckhead() {
        return get_neckhead_0(this.nativeObj);
    }

    public int get_target() {
        return get_target_0(this.nativeObj);
    }

    public void set_backbone(String str) {
        set_backbone_0(this.nativeObj, str);
    }

    public void set_backend(int i5) {
        set_backend_0(this.nativeObj, i5);
    }

    public void set_neckhead(String str) {
        set_neckhead_0(this.nativeObj, str);
    }

    public void set_target(int i5) {
        set_target_0(this.nativeObj, i5);
    }

    public TrackerNano_Params() {
        this.nativeObj = TrackerNano_Params_0();
    }
}
