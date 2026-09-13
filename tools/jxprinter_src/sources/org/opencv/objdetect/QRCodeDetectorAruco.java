package org.opencv.objdetect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class QRCodeDetectorAruco extends GraphicalCodeDetector {
    public QRCodeDetectorAruco(long j6) {
        super(j6);
    }

    private static native long QRCodeDetectorAruco_0();

    private static native long QRCodeDetectorAruco_1(long j6);

    public static QRCodeDetectorAruco __fromPtr__(long j6) {
        return new QRCodeDetectorAruco(j6);
    }

    private static native void delete(long j6);

    private static native long getDetectorParameters_0(long j6);

    private static native long setDetectorParameters_0(long j6, long j7);

    @Override // org.opencv.objdetect.GraphicalCodeDetector
    public void finalize() {
        delete(this.nativeObj);
    }

    public QRCodeDetectorAruco_Params getDetectorParameters() {
        return new QRCodeDetectorAruco_Params(getDetectorParameters_0(this.nativeObj));
    }

    public QRCodeDetectorAruco setDetectorParameters(QRCodeDetectorAruco_Params qRCodeDetectorAruco_Params) {
        return new QRCodeDetectorAruco(setDetectorParameters_0(this.nativeObj, qRCodeDetectorAruco_Params.nativeObj));
    }

    public QRCodeDetectorAruco() {
        super(QRCodeDetectorAruco_0());
    }

    public QRCodeDetectorAruco(QRCodeDetectorAruco_Params qRCodeDetectorAruco_Params) {
        super(QRCodeDetectorAruco_1(qRCodeDetectorAruco_Params.nativeObj));
    }
}
