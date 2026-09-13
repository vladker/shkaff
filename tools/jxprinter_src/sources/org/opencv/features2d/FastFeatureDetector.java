package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FastFeatureDetector extends Feature2D {
    public static final int FAST_N = 10002;
    public static final int NONMAX_SUPPRESSION = 10001;
    public static final int THRESHOLD = 10000;
    public static final int TYPE_5_8 = 0;
    public static final int TYPE_7_12 = 1;
    public static final int TYPE_9_16 = 2;

    public FastFeatureDetector(long j6) {
        super(j6);
    }

    public static FastFeatureDetector __fromPtr__(long j6) {
        return new FastFeatureDetector(j6);
    }

    public static FastFeatureDetector create(int i5, boolean z6, int i6) {
        return __fromPtr__(create_0(i5, z6, i6));
    }

    private static native long create_0(int i5, boolean z6, int i6);

    private static native long create_1(int i5, boolean z6);

    private static native long create_2(int i5);

    private static native long create_3();

    private static native void delete(long j6);

    private static native String getDefaultName_0(long j6);

    private static native boolean getNonmaxSuppression_0(long j6);

    private static native int getThreshold_0(long j6);

    private static native int getType_0(long j6);

    private static native void setNonmaxSuppression_0(long j6, boolean z6);

    private static native void setThreshold_0(long j6, int i5);

    private static native void setType_0(long j6, int i5);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public boolean getNonmaxSuppression() {
        return getNonmaxSuppression_0(this.nativeObj);
    }

    public int getThreshold() {
        return getThreshold_0(this.nativeObj);
    }

    public int getType() {
        return getType_0(this.nativeObj);
    }

    public void setNonmaxSuppression(boolean z6) {
        setNonmaxSuppression_0(this.nativeObj, z6);
    }

    public void setThreshold(int i5) {
        setThreshold_0(this.nativeObj, i5);
    }

    public void setType(int i5) {
        setType_0(this.nativeObj, i5);
    }

    public static FastFeatureDetector create(int i5, boolean z6) {
        return __fromPtr__(create_1(i5, z6));
    }

    public static FastFeatureDetector create(int i5) {
        return __fromPtr__(create_2(i5));
    }

    public static FastFeatureDetector create() {
        return __fromPtr__(create_3());
    }
}
