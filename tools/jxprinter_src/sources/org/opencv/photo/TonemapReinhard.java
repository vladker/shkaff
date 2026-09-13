package org.opencv.photo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TonemapReinhard extends Tonemap {
    public TonemapReinhard(long j6) {
        super(j6);
    }

    public static TonemapReinhard __fromPtr__(long j6) {
        return new TonemapReinhard(j6);
    }

    private static native void delete(long j6);

    private static native float getColorAdaptation_0(long j6);

    private static native float getIntensity_0(long j6);

    private static native float getLightAdaptation_0(long j6);

    private static native void setColorAdaptation_0(long j6, float f6);

    private static native void setIntensity_0(long j6, float f6);

    private static native void setLightAdaptation_0(long j6, float f6);

    @Override // org.opencv.photo.Tonemap, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getColorAdaptation() {
        return getColorAdaptation_0(this.nativeObj);
    }

    public float getIntensity() {
        return getIntensity_0(this.nativeObj);
    }

    public float getLightAdaptation() {
        return getLightAdaptation_0(this.nativeObj);
    }

    public void setColorAdaptation(float f6) {
        setColorAdaptation_0(this.nativeObj, f6);
    }

    public void setIntensity(float f6) {
        setIntensity_0(this.nativeObj, f6);
    }

    public void setLightAdaptation(float f6) {
        setLightAdaptation_0(this.nativeObj, f6);
    }
}
