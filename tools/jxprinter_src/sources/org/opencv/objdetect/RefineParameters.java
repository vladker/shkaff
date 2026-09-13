package org.opencv.objdetect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class RefineParameters {
    protected final long nativeObj;

    public RefineParameters(long j6) {
        this.nativeObj = j6;
    }

    private static native long RefineParameters_0(float f6, float f7, boolean z6);

    private static native long RefineParameters_1(float f6, float f7);

    private static native long RefineParameters_2(float f6);

    private static native long RefineParameters_3();

    public static RefineParameters __fromPtr__(long j6) {
        return new RefineParameters(j6);
    }

    private static native void delete(long j6);

    private static native boolean get_checkAllOrders_0(long j6);

    private static native float get_errorCorrectionRate_0(long j6);

    private static native float get_minRepDistance_0(long j6);

    private static native void set_checkAllOrders_0(long j6, boolean z6);

    private static native void set_errorCorrectionRate_0(long j6, float f6);

    private static native void set_minRepDistance_0(long j6, float f6);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public boolean get_checkAllOrders() {
        return get_checkAllOrders_0(this.nativeObj);
    }

    public float get_errorCorrectionRate() {
        return get_errorCorrectionRate_0(this.nativeObj);
    }

    public float get_minRepDistance() {
        return get_minRepDistance_0(this.nativeObj);
    }

    public void set_checkAllOrders(boolean z6) {
        set_checkAllOrders_0(this.nativeObj, z6);
    }

    public void set_errorCorrectionRate(float f6) {
        set_errorCorrectionRate_0(this.nativeObj, f6);
    }

    public void set_minRepDistance(float f6) {
        set_minRepDistance_0(this.nativeObj, f6);
    }

    public RefineParameters(float f6, float f7, boolean z6) {
        this.nativeObj = RefineParameters_0(f6, f7, z6);
    }

    public RefineParameters(float f6, float f7) {
        this.nativeObj = RefineParameters_1(f6, f7);
    }

    public RefineParameters(float f6) {
        this.nativeObj = RefineParameters_2(f6);
    }

    public RefineParameters() {
        this.nativeObj = RefineParameters_3();
    }
}
