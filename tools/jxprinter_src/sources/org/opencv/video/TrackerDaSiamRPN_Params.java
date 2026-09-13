package org.opencv.video;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TrackerDaSiamRPN_Params {
    protected final long nativeObj;

    public TrackerDaSiamRPN_Params(long j6) {
        this.nativeObj = j6;
    }

    private static native long TrackerDaSiamRPN_Params_0();

    public static TrackerDaSiamRPN_Params __fromPtr__(long j6) {
        return new TrackerDaSiamRPN_Params(j6);
    }

    private static native void delete(long j6);

    private static native int get_backend_0(long j6);

    private static native String get_kernel_cls1_0(long j6);

    private static native String get_kernel_r1_0(long j6);

    private static native String get_model_0(long j6);

    private static native int get_target_0(long j6);

    private static native void set_backend_0(long j6, int i5);

    private static native void set_kernel_cls1_0(long j6, String str);

    private static native void set_kernel_r1_0(long j6, String str);

    private static native void set_model_0(long j6, String str);

    private static native void set_target_0(long j6, int i5);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int get_backend() {
        return get_backend_0(this.nativeObj);
    }

    public String get_kernel_cls1() {
        return get_kernel_cls1_0(this.nativeObj);
    }

    public String get_kernel_r1() {
        return get_kernel_r1_0(this.nativeObj);
    }

    public String get_model() {
        return get_model_0(this.nativeObj);
    }

    public int get_target() {
        return get_target_0(this.nativeObj);
    }

    public void set_backend(int i5) {
        set_backend_0(this.nativeObj, i5);
    }

    public void set_kernel_cls1(String str) {
        set_kernel_cls1_0(this.nativeObj, str);
    }

    public void set_kernel_r1(String str) {
        set_kernel_r1_0(this.nativeObj, str);
    }

    public void set_model(String str) {
        set_model_0(this.nativeObj, str);
    }

    public void set_target(int i5) {
        set_target_0(this.nativeObj, i5);
    }

    public TrackerDaSiamRPN_Params() {
        this.nativeObj = TrackerDaSiamRPN_Params_0();
    }
}
