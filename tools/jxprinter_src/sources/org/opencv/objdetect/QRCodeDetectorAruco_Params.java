package org.opencv.objdetect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class QRCodeDetectorAruco_Params {
    protected final long nativeObj;

    public QRCodeDetectorAruco_Params(long j6) {
        this.nativeObj = j6;
    }

    private static native long QRCodeDetectorAruco_Params_0();

    public static QRCodeDetectorAruco_Params __fromPtr__(long j6) {
        return new QRCodeDetectorAruco_Params(j6);
    }

    private static native void delete(long j6);

    private static native float get_maxColorsMismatch_0(long j6);

    private static native float get_maxModuleSizeMismatch_0(long j6);

    private static native float get_maxPenalties_0(long j6);

    private static native float get_maxRotation_0(long j6);

    private static native float get_maxTimingPatternMismatch_0(long j6);

    private static native float get_minModuleSizeInPyramid_0(long j6);

    private static native float get_scaleTimingPatternScore_0(long j6);

    private static native void set_maxColorsMismatch_0(long j6, float f6);

    private static native void set_maxModuleSizeMismatch_0(long j6, float f6);

    private static native void set_maxPenalties_0(long j6, float f6);

    private static native void set_maxRotation_0(long j6, float f6);

    private static native void set_maxTimingPatternMismatch_0(long j6, float f6);

    private static native void set_minModuleSizeInPyramid_0(long j6, float f6);

    private static native void set_scaleTimingPatternScore_0(long j6, float f6);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public float get_maxColorsMismatch() {
        return get_maxColorsMismatch_0(this.nativeObj);
    }

    public float get_maxModuleSizeMismatch() {
        return get_maxModuleSizeMismatch_0(this.nativeObj);
    }

    public float get_maxPenalties() {
        return get_maxPenalties_0(this.nativeObj);
    }

    public float get_maxRotation() {
        return get_maxRotation_0(this.nativeObj);
    }

    public float get_maxTimingPatternMismatch() {
        return get_maxTimingPatternMismatch_0(this.nativeObj);
    }

    public float get_minModuleSizeInPyramid() {
        return get_minModuleSizeInPyramid_0(this.nativeObj);
    }

    public float get_scaleTimingPatternScore() {
        return get_scaleTimingPatternScore_0(this.nativeObj);
    }

    public void set_maxColorsMismatch(float f6) {
        set_maxColorsMismatch_0(this.nativeObj, f6);
    }

    public void set_maxModuleSizeMismatch(float f6) {
        set_maxModuleSizeMismatch_0(this.nativeObj, f6);
    }

    public void set_maxPenalties(float f6) {
        set_maxPenalties_0(this.nativeObj, f6);
    }

    public void set_maxRotation(float f6) {
        set_maxRotation_0(this.nativeObj, f6);
    }

    public void set_maxTimingPatternMismatch(float f6) {
        set_maxTimingPatternMismatch_0(this.nativeObj, f6);
    }

    public void set_minModuleSizeInPyramid(float f6) {
        set_minModuleSizeInPyramid_0(this.nativeObj, f6);
    }

    public void set_scaleTimingPatternScore(float f6) {
        set_scaleTimingPatternScore_0(this.nativeObj, f6);
    }

    public QRCodeDetectorAruco_Params() {
        this.nativeObj = QRCodeDetectorAruco_Params_0();
    }
}
