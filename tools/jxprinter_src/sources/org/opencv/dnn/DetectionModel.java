package org.opencv.dnn;

import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DetectionModel extends Model {
    public DetectionModel(long j6) {
        super(j6);
    }

    private static native long DetectionModel_0(String str, String str2);

    private static native long DetectionModel_1(String str);

    private static native long DetectionModel_2(long j6);

    public static DetectionModel __fromPtr__(long j6) {
        return new DetectionModel(j6);
    }

    private static native void delete(long j6);

    private static native void detect_0(long j6, long j7, long j8, long j9, long j10, float f6, float f7);

    private static native void detect_1(long j6, long j7, long j8, long j9, long j10, float f6);

    private static native void detect_2(long j6, long j7, long j8, long j9, long j10);

    private static native boolean getNmsAcrossClasses_0(long j6);

    private static native long setNmsAcrossClasses_0(long j6, boolean z6);

    public void detect(Mat mat, MatOfInt matOfInt, MatOfFloat matOfFloat, MatOfRect matOfRect, float f6, float f7) {
        detect_0(this.nativeObj, mat.nativeObj, matOfInt.nativeObj, matOfFloat.nativeObj, matOfRect.nativeObj, f6, f7);
    }

    @Override // org.opencv.dnn.Model
    public void finalize() {
        delete(this.nativeObj);
    }

    public boolean getNmsAcrossClasses() {
        return getNmsAcrossClasses_0(this.nativeObj);
    }

    public DetectionModel setNmsAcrossClasses(boolean z6) {
        return new DetectionModel(setNmsAcrossClasses_0(this.nativeObj, z6));
    }

    public DetectionModel(String str, String str2) {
        super(DetectionModel_0(str, str2));
    }

    public void detect(Mat mat, MatOfInt matOfInt, MatOfFloat matOfFloat, MatOfRect matOfRect, float f6) {
        detect_1(this.nativeObj, mat.nativeObj, matOfInt.nativeObj, matOfFloat.nativeObj, matOfRect.nativeObj, f6);
    }

    public DetectionModel(String str) {
        super(DetectionModel_1(str));
    }

    public void detect(Mat mat, MatOfInt matOfInt, MatOfFloat matOfFloat, MatOfRect matOfRect) {
        detect_2(this.nativeObj, mat.nativeObj, matOfInt.nativeObj, matOfFloat.nativeObj, matOfRect.nativeObj);
    }

    public DetectionModel(Net net) {
        super(DetectionModel_2(net.nativeObj));
    }
}
