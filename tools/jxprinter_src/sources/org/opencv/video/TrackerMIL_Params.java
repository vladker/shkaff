package org.opencv.video;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TrackerMIL_Params {
    protected final long nativeObj;

    public TrackerMIL_Params(long j6) {
        this.nativeObj = j6;
    }

    private static native long TrackerMIL_Params_0();

    public static TrackerMIL_Params __fromPtr__(long j6) {
        return new TrackerMIL_Params(j6);
    }

    private static native void delete(long j6);

    private static native int get_featureSetNumFeatures_0(long j6);

    private static native float get_samplerInitInRadius_0(long j6);

    private static native int get_samplerInitMaxNegNum_0(long j6);

    private static native float get_samplerSearchWinSize_0(long j6);

    private static native float get_samplerTrackInRadius_0(long j6);

    private static native int get_samplerTrackMaxNegNum_0(long j6);

    private static native int get_samplerTrackMaxPosNum_0(long j6);

    private static native void set_featureSetNumFeatures_0(long j6, int i5);

    private static native void set_samplerInitInRadius_0(long j6, float f6);

    private static native void set_samplerInitMaxNegNum_0(long j6, int i5);

    private static native void set_samplerSearchWinSize_0(long j6, float f6);

    private static native void set_samplerTrackInRadius_0(long j6, float f6);

    private static native void set_samplerTrackMaxNegNum_0(long j6, int i5);

    private static native void set_samplerTrackMaxPosNum_0(long j6, int i5);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int get_featureSetNumFeatures() {
        return get_featureSetNumFeatures_0(this.nativeObj);
    }

    public float get_samplerInitInRadius() {
        return get_samplerInitInRadius_0(this.nativeObj);
    }

    public int get_samplerInitMaxNegNum() {
        return get_samplerInitMaxNegNum_0(this.nativeObj);
    }

    public float get_samplerSearchWinSize() {
        return get_samplerSearchWinSize_0(this.nativeObj);
    }

    public float get_samplerTrackInRadius() {
        return get_samplerTrackInRadius_0(this.nativeObj);
    }

    public int get_samplerTrackMaxNegNum() {
        return get_samplerTrackMaxNegNum_0(this.nativeObj);
    }

    public int get_samplerTrackMaxPosNum() {
        return get_samplerTrackMaxPosNum_0(this.nativeObj);
    }

    public void set_featureSetNumFeatures(int i5) {
        set_featureSetNumFeatures_0(this.nativeObj, i5);
    }

    public void set_samplerInitInRadius(float f6) {
        set_samplerInitInRadius_0(this.nativeObj, f6);
    }

    public void set_samplerInitMaxNegNum(int i5) {
        set_samplerInitMaxNegNum_0(this.nativeObj, i5);
    }

    public void set_samplerSearchWinSize(float f6) {
        set_samplerSearchWinSize_0(this.nativeObj, f6);
    }

    public void set_samplerTrackInRadius(float f6) {
        set_samplerTrackInRadius_0(this.nativeObj, f6);
    }

    public void set_samplerTrackMaxNegNum(int i5) {
        set_samplerTrackMaxNegNum_0(this.nativeObj, i5);
    }

    public void set_samplerTrackMaxPosNum(int i5) {
        set_samplerTrackMaxPosNum_0(this.nativeObj, i5);
    }

    public TrackerMIL_Params() {
        this.nativeObj = TrackerMIL_Params_0();
    }
}
