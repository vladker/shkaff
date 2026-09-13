package org.opencv.video;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TrackerGOTURN_Params {
    protected final long nativeObj;

    public TrackerGOTURN_Params(long j6) {
        this.nativeObj = j6;
    }

    private static native long TrackerGOTURN_Params_0();

    public static TrackerGOTURN_Params __fromPtr__(long j6) {
        return new TrackerGOTURN_Params(j6);
    }

    private static native void delete(long j6);

    private static native String get_modelBin_0(long j6);

    private static native String get_modelTxt_0(long j6);

    private static native void set_modelBin_0(long j6, String str);

    private static native void set_modelTxt_0(long j6, String str);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public String get_modelBin() {
        return get_modelBin_0(this.nativeObj);
    }

    public String get_modelTxt() {
        return get_modelTxt_0(this.nativeObj);
    }

    public void set_modelBin(String str) {
        set_modelBin_0(this.nativeObj, str);
    }

    public void set_modelTxt(String str) {
        set_modelTxt_0(this.nativeObj, str);
    }

    public TrackerGOTURN_Params() {
        this.nativeObj = TrackerGOTURN_Params_0();
    }
}
