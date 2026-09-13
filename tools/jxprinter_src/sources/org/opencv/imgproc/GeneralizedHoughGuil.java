package org.opencv.imgproc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class GeneralizedHoughGuil extends GeneralizedHough {
    public GeneralizedHoughGuil(long j6) {
        super(j6);
    }

    public static GeneralizedHoughGuil __fromPtr__(long j6) {
        return new GeneralizedHoughGuil(j6);
    }

    private static native void delete(long j6);

    private static native double getAngleEpsilon_0(long j6);

    private static native double getAngleStep_0(long j6);

    private static native int getAngleThresh_0(long j6);

    private static native int getLevels_0(long j6);

    private static native double getMaxAngle_0(long j6);

    private static native double getMaxScale_0(long j6);

    private static native double getMinAngle_0(long j6);

    private static native double getMinScale_0(long j6);

    private static native int getPosThresh_0(long j6);

    private static native double getScaleStep_0(long j6);

    private static native int getScaleThresh_0(long j6);

    private static native double getXi_0(long j6);

    private static native void setAngleEpsilon_0(long j6, double d);

    private static native void setAngleStep_0(long j6, double d);

    private static native void setAngleThresh_0(long j6, int i5);

    private static native void setLevels_0(long j6, int i5);

    private static native void setMaxAngle_0(long j6, double d);

    private static native void setMaxScale_0(long j6, double d);

    private static native void setMinAngle_0(long j6, double d);

    private static native void setMinScale_0(long j6, double d);

    private static native void setPosThresh_0(long j6, int i5);

    private static native void setScaleStep_0(long j6, double d);

    private static native void setScaleThresh_0(long j6, int i5);

    private static native void setXi_0(long j6, double d);

    @Override // org.opencv.imgproc.GeneralizedHough, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public double getAngleEpsilon() {
        return getAngleEpsilon_0(this.nativeObj);
    }

    public double getAngleStep() {
        return getAngleStep_0(this.nativeObj);
    }

    public int getAngleThresh() {
        return getAngleThresh_0(this.nativeObj);
    }

    public int getLevels() {
        return getLevels_0(this.nativeObj);
    }

    public double getMaxAngle() {
        return getMaxAngle_0(this.nativeObj);
    }

    public double getMaxScale() {
        return getMaxScale_0(this.nativeObj);
    }

    public double getMinAngle() {
        return getMinAngle_0(this.nativeObj);
    }

    public double getMinScale() {
        return getMinScale_0(this.nativeObj);
    }

    public int getPosThresh() {
        return getPosThresh_0(this.nativeObj);
    }

    public double getScaleStep() {
        return getScaleStep_0(this.nativeObj);
    }

    public int getScaleThresh() {
        return getScaleThresh_0(this.nativeObj);
    }

    public double getXi() {
        return getXi_0(this.nativeObj);
    }

    public void setAngleEpsilon(double d) {
        setAngleEpsilon_0(this.nativeObj, d);
    }

    public void setAngleStep(double d) {
        setAngleStep_0(this.nativeObj, d);
    }

    public void setAngleThresh(int i5) {
        setAngleThresh_0(this.nativeObj, i5);
    }

    public void setLevels(int i5) {
        setLevels_0(this.nativeObj, i5);
    }

    public void setMaxAngle(double d) {
        setMaxAngle_0(this.nativeObj, d);
    }

    public void setMaxScale(double d) {
        setMaxScale_0(this.nativeObj, d);
    }

    public void setMinAngle(double d) {
        setMinAngle_0(this.nativeObj, d);
    }

    public void setMinScale(double d) {
        setMinScale_0(this.nativeObj, d);
    }

    public void setPosThresh(int i5) {
        setPosThresh_0(this.nativeObj, i5);
    }

    public void setScaleStep(double d) {
        setScaleStep_0(this.nativeObj, d);
    }

    public void setScaleThresh(int i5) {
        setScaleThresh_0(this.nativeObj, i5);
    }

    public void setXi(double d) {
        setXi_0(this.nativeObj, d);
    }
}
