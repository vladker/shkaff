package org.opencv.video;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TrackerDaSiamRPN extends Tracker {
    public TrackerDaSiamRPN(long j6) {
        super(j6);
    }

    public static TrackerDaSiamRPN __fromPtr__(long j6) {
        return new TrackerDaSiamRPN(j6);
    }

    public static TrackerDaSiamRPN create(TrackerDaSiamRPN_Params trackerDaSiamRPN_Params) {
        return __fromPtr__(create_0(trackerDaSiamRPN_Params.nativeObj));
    }

    private static native long create_0(long j6);

    private static native long create_1();

    private static native void delete(long j6);

    private static native float getTrackingScore_0(long j6);

    @Override // org.opencv.video.Tracker
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getTrackingScore() {
        return getTrackingScore_0(this.nativeObj);
    }

    public static TrackerDaSiamRPN create() {
        return __fromPtr__(create_1());
    }
}
