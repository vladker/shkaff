package org.opencv.photo;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CalibrateRobertson extends CalibrateCRF {
    public CalibrateRobertson(long j6) {
        super(j6);
    }

    public static CalibrateRobertson __fromPtr__(long j6) {
        return new CalibrateRobertson(j6);
    }

    private static native void delete(long j6);

    private static native int getMaxIter_0(long j6);

    private static native long getRadiance_0(long j6);

    private static native float getThreshold_0(long j6);

    private static native void setMaxIter_0(long j6, int i5);

    private static native void setThreshold_0(long j6, float f6);

    @Override // org.opencv.photo.CalibrateCRF, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getMaxIter() {
        return getMaxIter_0(this.nativeObj);
    }

    public Mat getRadiance() {
        return new Mat(getRadiance_0(this.nativeObj));
    }

    public float getThreshold() {
        return getThreshold_0(this.nativeObj);
    }

    public void setMaxIter(int i5) {
        setMaxIter_0(this.nativeObj, i5);
    }

    public void setThreshold(float f6) {
        setThreshold_0(this.nativeObj, f6);
    }
}
