package org.opencv.imgproc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class GeneralizedHoughBallard extends GeneralizedHough {
    public GeneralizedHoughBallard(long j6) {
        super(j6);
    }

    public static GeneralizedHoughBallard __fromPtr__(long j6) {
        return new GeneralizedHoughBallard(j6);
    }

    private static native void delete(long j6);

    private static native int getLevels_0(long j6);

    private static native int getVotesThreshold_0(long j6);

    private static native void setLevels_0(long j6, int i5);

    private static native void setVotesThreshold_0(long j6, int i5);

    @Override // org.opencv.imgproc.GeneralizedHough, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getLevels() {
        return getLevels_0(this.nativeObj);
    }

    public int getVotesThreshold() {
        return getVotesThreshold_0(this.nativeObj);
    }

    public void setLevels(int i5) {
        setLevels_0(this.nativeObj, i5);
    }

    public void setVotesThreshold(int i5) {
        setVotesThreshold_0(this.nativeObj, i5);
    }
}
