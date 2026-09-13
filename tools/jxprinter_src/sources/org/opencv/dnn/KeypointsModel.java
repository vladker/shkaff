package org.opencv.dnn;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class KeypointsModel extends Model {
    public KeypointsModel(long j6) {
        super(j6);
    }

    private static native long KeypointsModel_0(String str, String str2);

    private static native long KeypointsModel_1(String str);

    private static native long KeypointsModel_2(long j6);

    public static KeypointsModel __fromPtr__(long j6) {
        return new KeypointsModel(j6);
    }

    private static native void delete(long j6);

    private static native long estimate_0(long j6, long j7, float f6);

    private static native long estimate_1(long j6, long j7);

    public MatOfPoint2f estimate(Mat mat, float f6) {
        return MatOfPoint2f.fromNativeAddr(estimate_0(this.nativeObj, mat.nativeObj, f6));
    }

    @Override // org.opencv.dnn.Model
    public void finalize() {
        delete(this.nativeObj);
    }

    public KeypointsModel(String str, String str2) {
        super(KeypointsModel_0(str, str2));
    }

    public MatOfPoint2f estimate(Mat mat) {
        return MatOfPoint2f.fromNativeAddr(estimate_1(this.nativeObj, mat.nativeObj));
    }

    public KeypointsModel(String str) {
        super(KeypointsModel_1(str));
    }

    public KeypointsModel(Net net) {
        super(KeypointsModel_2(net.nativeObj));
    }
}
