package org.opencv.photo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TonemapDrago extends Tonemap {
    public TonemapDrago(long j6) {
        super(j6);
    }

    public static TonemapDrago __fromPtr__(long j6) {
        return new TonemapDrago(j6);
    }

    private static native void delete(long j6);

    private static native float getBias_0(long j6);

    private static native float getSaturation_0(long j6);

    private static native void setBias_0(long j6, float f6);

    private static native void setSaturation_0(long j6, float f6);

    @Override // org.opencv.photo.Tonemap, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getBias() {
        return getBias_0(this.nativeObj);
    }

    public float getSaturation() {
        return getSaturation_0(this.nativeObj);
    }

    public void setBias(float f6) {
        setBias_0(this.nativeObj, f6);
    }

    public void setSaturation(float f6) {
        setSaturation_0(this.nativeObj, f6);
    }
}
