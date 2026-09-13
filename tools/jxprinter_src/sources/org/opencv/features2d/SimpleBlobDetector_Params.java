package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SimpleBlobDetector_Params {
    protected final long nativeObj;

    public SimpleBlobDetector_Params(long j6) {
        this.nativeObj = j6;
    }

    private static native long SimpleBlobDetector_Params_0();

    public static SimpleBlobDetector_Params __fromPtr__(long j6) {
        return new SimpleBlobDetector_Params(j6);
    }

    private static native void delete(long j6);

    private static native boolean get_collectContours_0(long j6);

    private static native boolean get_filterByArea_0(long j6);

    private static native boolean get_filterByCircularity_0(long j6);

    private static native boolean get_filterByColor_0(long j6);

    private static native boolean get_filterByConvexity_0(long j6);

    private static native boolean get_filterByInertia_0(long j6);

    private static native float get_maxArea_0(long j6);

    private static native float get_maxCircularity_0(long j6);

    private static native float get_maxConvexity_0(long j6);

    private static native float get_maxInertiaRatio_0(long j6);

    private static native float get_maxThreshold_0(long j6);

    private static native float get_minArea_0(long j6);

    private static native float get_minCircularity_0(long j6);

    private static native float get_minConvexity_0(long j6);

    private static native float get_minDistBetweenBlobs_0(long j6);

    private static native float get_minInertiaRatio_0(long j6);

    private static native long get_minRepeatability_0(long j6);

    private static native float get_minThreshold_0(long j6);

    private static native float get_thresholdStep_0(long j6);

    private static native void set_collectContours_0(long j6, boolean z6);

    private static native void set_filterByArea_0(long j6, boolean z6);

    private static native void set_filterByCircularity_0(long j6, boolean z6);

    private static native void set_filterByColor_0(long j6, boolean z6);

    private static native void set_filterByConvexity_0(long j6, boolean z6);

    private static native void set_filterByInertia_0(long j6, boolean z6);

    private static native void set_maxArea_0(long j6, float f6);

    private static native void set_maxCircularity_0(long j6, float f6);

    private static native void set_maxConvexity_0(long j6, float f6);

    private static native void set_maxInertiaRatio_0(long j6, float f6);

    private static native void set_maxThreshold_0(long j6, float f6);

    private static native void set_minArea_0(long j6, float f6);

    private static native void set_minCircularity_0(long j6, float f6);

    private static native void set_minConvexity_0(long j6, float f6);

    private static native void set_minDistBetweenBlobs_0(long j6, float f6);

    private static native void set_minInertiaRatio_0(long j6, float f6);

    private static native void set_minRepeatability_0(long j6, long j7);

    private static native void set_minThreshold_0(long j6, float f6);

    private static native void set_thresholdStep_0(long j6, float f6);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public boolean get_collectContours() {
        return get_collectContours_0(this.nativeObj);
    }

    public boolean get_filterByArea() {
        return get_filterByArea_0(this.nativeObj);
    }

    public boolean get_filterByCircularity() {
        return get_filterByCircularity_0(this.nativeObj);
    }

    public boolean get_filterByColor() {
        return get_filterByColor_0(this.nativeObj);
    }

    public boolean get_filterByConvexity() {
        return get_filterByConvexity_0(this.nativeObj);
    }

    public boolean get_filterByInertia() {
        return get_filterByInertia_0(this.nativeObj);
    }

    public float get_maxArea() {
        return get_maxArea_0(this.nativeObj);
    }

    public float get_maxCircularity() {
        return get_maxCircularity_0(this.nativeObj);
    }

    public float get_maxConvexity() {
        return get_maxConvexity_0(this.nativeObj);
    }

    public float get_maxInertiaRatio() {
        return get_maxInertiaRatio_0(this.nativeObj);
    }

    public float get_maxThreshold() {
        return get_maxThreshold_0(this.nativeObj);
    }

    public float get_minArea() {
        return get_minArea_0(this.nativeObj);
    }

    public float get_minCircularity() {
        return get_minCircularity_0(this.nativeObj);
    }

    public float get_minConvexity() {
        return get_minConvexity_0(this.nativeObj);
    }

    public float get_minDistBetweenBlobs() {
        return get_minDistBetweenBlobs_0(this.nativeObj);
    }

    public float get_minInertiaRatio() {
        return get_minInertiaRatio_0(this.nativeObj);
    }

    public long get_minRepeatability() {
        return get_minRepeatability_0(this.nativeObj);
    }

    public float get_minThreshold() {
        return get_minThreshold_0(this.nativeObj);
    }

    public float get_thresholdStep() {
        return get_thresholdStep_0(this.nativeObj);
    }

    public void set_collectContours(boolean z6) {
        set_collectContours_0(this.nativeObj, z6);
    }

    public void set_filterByArea(boolean z6) {
        set_filterByArea_0(this.nativeObj, z6);
    }

    public void set_filterByCircularity(boolean z6) {
        set_filterByCircularity_0(this.nativeObj, z6);
    }

    public void set_filterByColor(boolean z6) {
        set_filterByColor_0(this.nativeObj, z6);
    }

    public void set_filterByConvexity(boolean z6) {
        set_filterByConvexity_0(this.nativeObj, z6);
    }

    public void set_filterByInertia(boolean z6) {
        set_filterByInertia_0(this.nativeObj, z6);
    }

    public void set_maxArea(float f6) {
        set_maxArea_0(this.nativeObj, f6);
    }

    public void set_maxCircularity(float f6) {
        set_maxCircularity_0(this.nativeObj, f6);
    }

    public void set_maxConvexity(float f6) {
        set_maxConvexity_0(this.nativeObj, f6);
    }

    public void set_maxInertiaRatio(float f6) {
        set_maxInertiaRatio_0(this.nativeObj, f6);
    }

    public void set_maxThreshold(float f6) {
        set_maxThreshold_0(this.nativeObj, f6);
    }

    public void set_minArea(float f6) {
        set_minArea_0(this.nativeObj, f6);
    }

    public void set_minCircularity(float f6) {
        set_minCircularity_0(this.nativeObj, f6);
    }

    public void set_minConvexity(float f6) {
        set_minConvexity_0(this.nativeObj, f6);
    }

    public void set_minDistBetweenBlobs(float f6) {
        set_minDistBetweenBlobs_0(this.nativeObj, f6);
    }

    public void set_minInertiaRatio(float f6) {
        set_minInertiaRatio_0(this.nativeObj, f6);
    }

    public void set_minRepeatability(long j6) {
        set_minRepeatability_0(this.nativeObj, j6);
    }

    public void set_minThreshold(float f6) {
        set_minThreshold_0(this.nativeObj, f6);
    }

    public void set_thresholdStep(float f6) {
        set_thresholdStep_0(this.nativeObj, f6);
    }

    public SimpleBlobDetector_Params() {
        this.nativeObj = SimpleBlobDetector_Params_0();
    }
}
