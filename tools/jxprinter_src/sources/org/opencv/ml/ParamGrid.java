package org.opencv.ml;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ParamGrid {
    protected final long nativeObj;

    public ParamGrid(long j6) {
        this.nativeObj = j6;
    }

    public static ParamGrid __fromPtr__(long j6) {
        return new ParamGrid(j6);
    }

    public static ParamGrid create(double d, double d6, double d7) {
        return __fromPtr__(create_0(d, d6, d7));
    }

    private static native long create_0(double d, double d6, double d7);

    private static native long create_1(double d, double d6);

    private static native long create_2(double d);

    private static native long create_3();

    private static native void delete(long j6);

    private static native double get_logStep_0(long j6);

    private static native double get_maxVal_0(long j6);

    private static native double get_minVal_0(long j6);

    private static native void set_logStep_0(long j6, double d);

    private static native void set_maxVal_0(long j6, double d);

    private static native void set_minVal_0(long j6, double d);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public double get_logStep() {
        return get_logStep_0(this.nativeObj);
    }

    public double get_maxVal() {
        return get_maxVal_0(this.nativeObj);
    }

    public double get_minVal() {
        return get_minVal_0(this.nativeObj);
    }

    public void set_logStep(double d) {
        set_logStep_0(this.nativeObj, d);
    }

    public void set_maxVal(double d) {
        set_maxVal_0(this.nativeObj, d);
    }

    public void set_minVal(double d) {
        set_minVal_0(this.nativeObj, d);
    }

    public static ParamGrid create(double d, double d6) {
        return __fromPtr__(create_1(d, d6));
    }

    public static ParamGrid create(double d) {
        return __fromPtr__(create_2(d));
    }

    public static ParamGrid create() {
        return __fromPtr__(create_3());
    }
}
