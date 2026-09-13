package org.opencv.features2d;

import org.opencv.core.MatOfFloat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class AffineFeature extends Feature2D {
    public AffineFeature(long j6) {
        super(j6);
    }

    public static AffineFeature __fromPtr__(long j6) {
        return new AffineFeature(j6);
    }

    public static AffineFeature create(Feature2D feature2D, int i5, int i6, float f6, float f7) {
        return __fromPtr__(create_0(feature2D.getNativeObjAddr(), i5, i6, f6, f7));
    }

    private static native long create_0(long j6, int i5, int i6, float f6, float f7);

    private static native long create_1(long j6, int i5, int i6, float f6);

    private static native long create_2(long j6, int i5, int i6);

    private static native long create_3(long j6, int i5);

    private static native long create_4(long j6);

    private static native void delete(long j6);

    private static native String getDefaultName_0(long j6);

    private static native void getViewParams_0(long j6, long j7, long j8);

    private static native void setViewParams_0(long j6, long j7, long j8);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public void getViewParams(MatOfFloat matOfFloat, MatOfFloat matOfFloat2) {
        getViewParams_0(this.nativeObj, matOfFloat.nativeObj, matOfFloat2.nativeObj);
    }

    public void setViewParams(MatOfFloat matOfFloat, MatOfFloat matOfFloat2) {
        setViewParams_0(this.nativeObj, matOfFloat.nativeObj, matOfFloat2.nativeObj);
    }

    public static AffineFeature create(Feature2D feature2D, int i5, int i6, float f6) {
        return __fromPtr__(create_1(feature2D.getNativeObjAddr(), i5, i6, f6));
    }

    public static AffineFeature create(Feature2D feature2D, int i5, int i6) {
        return __fromPtr__(create_2(feature2D.getNativeObjAddr(), i5, i6));
    }

    public static AffineFeature create(Feature2D feature2D, int i5) {
        return __fromPtr__(create_3(feature2D.getNativeObjAddr(), i5));
    }

    public static AffineFeature create(Feature2D feature2D) {
        return __fromPtr__(create_4(feature2D.getNativeObjAddr()));
    }
}
