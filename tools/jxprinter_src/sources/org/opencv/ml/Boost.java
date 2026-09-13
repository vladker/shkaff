package org.opencv.ml;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Boost extends DTrees {
    public static final int DISCRETE = 0;
    public static final int GENTLE = 3;
    public static final int LOGIT = 2;
    public static final int REAL = 1;

    public Boost(long j6) {
        super(j6);
    }

    public static Boost __fromPtr__(long j6) {
        return new Boost(j6);
    }

    public static Boost create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    private static native int getBoostType_0(long j6);

    private static native int getWeakCount_0(long j6);

    private static native double getWeightTrimRate_0(long j6);

    public static Boost load(String str, String str2) {
        return __fromPtr__(load_0(str, str2));
    }

    private static native long load_0(String str, String str2);

    private static native long load_1(String str);

    private static native void setBoostType_0(long j6, int i5);

    private static native void setWeakCount_0(long j6, int i5);

    private static native void setWeightTrimRate_0(long j6, double d);

    @Override // org.opencv.ml.DTrees, org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getBoostType() {
        return getBoostType_0(this.nativeObj);
    }

    public int getWeakCount() {
        return getWeakCount_0(this.nativeObj);
    }

    public double getWeightTrimRate() {
        return getWeightTrimRate_0(this.nativeObj);
    }

    public void setBoostType(int i5) {
        setBoostType_0(this.nativeObj, i5);
    }

    public void setWeakCount(int i5) {
        setWeakCount_0(this.nativeObj, i5);
    }

    public void setWeightTrimRate(double d) {
        setWeightTrimRate_0(this.nativeObj, d);
    }

    public static Boost load(String str) {
        return __fromPtr__(load_1(str));
    }
}
