package org.opencv.objdetect;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class QRCodeDetector extends GraphicalCodeDetector {
    public QRCodeDetector(long j6) {
        super(j6);
    }

    private static native long QRCodeDetector_0();

    public static QRCodeDetector __fromPtr__(long j6) {
        return new QRCodeDetector(j6);
    }

    private static native String decodeCurved_0(long j6, long j7, long j8, long j9);

    private static native String decodeCurved_1(long j6, long j7, long j8);

    private static native void delete(long j6);

    private static native String detectAndDecodeCurved_0(long j6, long j7, long j8, long j9);

    private static native String detectAndDecodeCurved_1(long j6, long j7, long j8);

    private static native String detectAndDecodeCurved_2(long j6, long j7);

    private static native long setEpsX_0(long j6, double d);

    private static native long setEpsY_0(long j6, double d);

    private static native long setUseAlignmentMarkers_0(long j6, boolean z6);

    public String decodeCurved(Mat mat, Mat mat2, Mat mat3) {
        return decodeCurved_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public String detectAndDecodeCurved(Mat mat, Mat mat2, Mat mat3) {
        return detectAndDecodeCurved_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    @Override // org.opencv.objdetect.GraphicalCodeDetector
    public void finalize() {
        delete(this.nativeObj);
    }

    public QRCodeDetector setEpsX(double d) {
        return new QRCodeDetector(setEpsX_0(this.nativeObj, d));
    }

    public QRCodeDetector setEpsY(double d) {
        return new QRCodeDetector(setEpsY_0(this.nativeObj, d));
    }

    public QRCodeDetector setUseAlignmentMarkers(boolean z6) {
        return new QRCodeDetector(setUseAlignmentMarkers_0(this.nativeObj, z6));
    }

    public QRCodeDetector() {
        super(QRCodeDetector_0());
    }

    public String decodeCurved(Mat mat, Mat mat2) {
        return decodeCurved_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public String detectAndDecodeCurved(Mat mat, Mat mat2) {
        return detectAndDecodeCurved_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public String detectAndDecodeCurved(Mat mat) {
        return detectAndDecodeCurved_2(this.nativeObj, mat.nativeObj);
    }
}
