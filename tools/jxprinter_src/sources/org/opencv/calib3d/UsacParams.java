package org.opencv.calib3d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class UsacParams {
    protected final long nativeObj;

    public UsacParams(long j6) {
        this.nativeObj = j6;
    }

    private static native long UsacParams_0();

    public static UsacParams __fromPtr__(long j6) {
        return new UsacParams(j6);
    }

    private static native void delete(long j6);

    private static native double get_confidence_0(long j6);

    private static native int get_final_polisher_0(long j6);

    private static native int get_final_polisher_iterations_0(long j6);

    private static native boolean get_isParallel_0(long j6);

    private static native int get_loIterations_0(long j6);

    private static native int get_loMethod_0(long j6);

    private static native int get_loSampleSize_0(long j6);

    private static native int get_maxIterations_0(long j6);

    private static native int get_neighborsSearch_0(long j6);

    private static native int get_randomGeneratorState_0(long j6);

    private static native int get_sampler_0(long j6);

    private static native int get_score_0(long j6);

    private static native double get_threshold_0(long j6);

    private static native void set_confidence_0(long j6, double d);

    private static native void set_final_polisher_0(long j6, int i5);

    private static native void set_final_polisher_iterations_0(long j6, int i5);

    private static native void set_isParallel_0(long j6, boolean z6);

    private static native void set_loIterations_0(long j6, int i5);

    private static native void set_loMethod_0(long j6, int i5);

    private static native void set_loSampleSize_0(long j6, int i5);

    private static native void set_maxIterations_0(long j6, int i5);

    private static native void set_neighborsSearch_0(long j6, int i5);

    private static native void set_randomGeneratorState_0(long j6, int i5);

    private static native void set_sampler_0(long j6, int i5);

    private static native void set_score_0(long j6, int i5);

    private static native void set_threshold_0(long j6, double d);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public double get_confidence() {
        return get_confidence_0(this.nativeObj);
    }

    public int get_final_polisher() {
        return get_final_polisher_0(this.nativeObj);
    }

    public int get_final_polisher_iterations() {
        return get_final_polisher_iterations_0(this.nativeObj);
    }

    public boolean get_isParallel() {
        return get_isParallel_0(this.nativeObj);
    }

    public int get_loIterations() {
        return get_loIterations_0(this.nativeObj);
    }

    public int get_loMethod() {
        return get_loMethod_0(this.nativeObj);
    }

    public int get_loSampleSize() {
        return get_loSampleSize_0(this.nativeObj);
    }

    public int get_maxIterations() {
        return get_maxIterations_0(this.nativeObj);
    }

    public int get_neighborsSearch() {
        return get_neighborsSearch_0(this.nativeObj);
    }

    public int get_randomGeneratorState() {
        return get_randomGeneratorState_0(this.nativeObj);
    }

    public int get_sampler() {
        return get_sampler_0(this.nativeObj);
    }

    public int get_score() {
        return get_score_0(this.nativeObj);
    }

    public double get_threshold() {
        return get_threshold_0(this.nativeObj);
    }

    public void set_confidence(double d) {
        set_confidence_0(this.nativeObj, d);
    }

    public void set_final_polisher(int i5) {
        set_final_polisher_0(this.nativeObj, i5);
    }

    public void set_final_polisher_iterations(int i5) {
        set_final_polisher_iterations_0(this.nativeObj, i5);
    }

    public void set_isParallel(boolean z6) {
        set_isParallel_0(this.nativeObj, z6);
    }

    public void set_loIterations(int i5) {
        set_loIterations_0(this.nativeObj, i5);
    }

    public void set_loMethod(int i5) {
        set_loMethod_0(this.nativeObj, i5);
    }

    public void set_loSampleSize(int i5) {
        set_loSampleSize_0(this.nativeObj, i5);
    }

    public void set_maxIterations(int i5) {
        set_maxIterations_0(this.nativeObj, i5);
    }

    public void set_neighborsSearch(int i5) {
        set_neighborsSearch_0(this.nativeObj, i5);
    }

    public void set_randomGeneratorState(int i5) {
        set_randomGeneratorState_0(this.nativeObj, i5);
    }

    public void set_sampler(int i5) {
        set_sampler_0(this.nativeObj, i5);
    }

    public void set_score(int i5) {
        set_score_0(this.nativeObj, i5);
    }

    public void set_threshold(double d) {
        set_threshold_0(this.nativeObj, d);
    }

    public UsacParams() {
        this.nativeObj = UsacParams_0();
    }
}
