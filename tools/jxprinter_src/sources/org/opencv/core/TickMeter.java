package org.opencv.core;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TickMeter {
    protected final long nativeObj;

    public TickMeter(long j6) {
        this.nativeObj = j6;
    }

    private static native long TickMeter_0();

    public static TickMeter __fromPtr__(long j6) {
        return new TickMeter(j6);
    }

    private static native void delete(long j6);

    private static native double getAvgTimeMilli_0(long j6);

    private static native double getAvgTimeSec_0(long j6);

    private static native long getCounter_0(long j6);

    private static native double getFPS_0(long j6);

    private static native double getTimeMicro_0(long j6);

    private static native double getTimeMilli_0(long j6);

    private static native double getTimeSec_0(long j6);

    private static native long getTimeTicks_0(long j6);

    private static native void reset_0(long j6);

    private static native void start_0(long j6);

    private static native void stop_0(long j6);

    public void finalize() {
        delete(this.nativeObj);
    }

    public double getAvgTimeMilli() {
        return getAvgTimeMilli_0(this.nativeObj);
    }

    public double getAvgTimeSec() {
        return getAvgTimeSec_0(this.nativeObj);
    }

    public long getCounter() {
        return getCounter_0(this.nativeObj);
    }

    public double getFPS() {
        return getFPS_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public double getTimeMicro() {
        return getTimeMicro_0(this.nativeObj);
    }

    public double getTimeMilli() {
        return getTimeMilli_0(this.nativeObj);
    }

    public double getTimeSec() {
        return getTimeSec_0(this.nativeObj);
    }

    public long getTimeTicks() {
        return getTimeTicks_0(this.nativeObj);
    }

    public void reset() {
        reset_0(this.nativeObj);
    }

    public void start() {
        start_0(this.nativeObj);
    }

    public void stop() {
        stop_0(this.nativeObj);
    }

    public TickMeter() {
        this.nativeObj = TickMeter_0();
    }
}
