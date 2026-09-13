package org.opencv.photo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CalibrateDebevec extends CalibrateCRF {
    public CalibrateDebevec(long j6) {
        super(j6);
    }

    public static CalibrateDebevec __fromPtr__(long j6) {
        return new CalibrateDebevec(j6);
    }

    private static native void delete(long j6);

    private static native float getLambda_0(long j6);

    private static native boolean getRandom_0(long j6);

    private static native int getSamples_0(long j6);

    private static native void setLambda_0(long j6, float f6);

    private static native void setRandom_0(long j6, boolean z6);

    private static native void setSamples_0(long j6, int i5);

    @Override // org.opencv.photo.CalibrateCRF, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getLambda() {
        return getLambda_0(this.nativeObj);
    }

    public boolean getRandom() {
        return getRandom_0(this.nativeObj);
    }

    public int getSamples() {
        return getSamples_0(this.nativeObj);
    }

    public void setLambda(float f6) {
        setLambda_0(this.nativeObj, f6);
    }

    public void setRandom(boolean z6) {
        setRandom_0(this.nativeObj, z6);
    }

    public void setSamples(int i5) {
        setSamples_0(this.nativeObj, i5);
    }
}
