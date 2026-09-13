package org.opencv.objdetect;

import java.util.List;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BarcodeDetector extends GraphicalCodeDetector {
    public BarcodeDetector(long j6) {
        super(j6);
    }

    private static native long BarcodeDetector_0();

    private static native long BarcodeDetector_1(String str, String str2);

    public static BarcodeDetector __fromPtr__(long j6) {
        return new BarcodeDetector(j6);
    }

    private static native boolean decodeWithType_0(long j6, long j7, long j8, List<String> list, List<String> list2);

    private static native void delete(long j6);

    private static native boolean detectAndDecodeWithType_0(long j6, long j7, List<String> list, List<String> list2, long j8);

    private static native boolean detectAndDecodeWithType_1(long j6, long j7, List<String> list, List<String> list2);

    public boolean decodeWithType(Mat mat, Mat mat2, List<String> list, List<String> list2) {
        return decodeWithType_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, list, list2);
    }

    public boolean detectAndDecodeWithType(Mat mat, List<String> list, List<String> list2, Mat mat2) {
        return detectAndDecodeWithType_0(this.nativeObj, mat.nativeObj, list, list2, mat2.nativeObj);
    }

    @Override // org.opencv.objdetect.GraphicalCodeDetector
    public void finalize() {
        delete(this.nativeObj);
    }

    public BarcodeDetector() {
        super(BarcodeDetector_0());
    }

    public boolean detectAndDecodeWithType(Mat mat, List<String> list, List<String> list2) {
        return detectAndDecodeWithType_1(this.nativeObj, mat.nativeObj, list, list2);
    }

    public BarcodeDetector(String str, String str2) {
        super(BarcodeDetector_1(str, str2));
    }
}
