package org.opencv.objdetect;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class QRCodeEncoder {
    public static final int CORRECT_LEVEL_H = 3;
    public static final int CORRECT_LEVEL_L = 0;
    public static final int CORRECT_LEVEL_M = 1;
    public static final int CORRECT_LEVEL_Q = 2;
    public static final int ECI_UTF8 = 26;
    public static final int MODE_ALPHANUMERIC = 2;
    public static final int MODE_AUTO = -1;
    public static final int MODE_BYTE = 4;
    public static final int MODE_ECI = 7;
    public static final int MODE_KANJI = 8;
    public static final int MODE_NUMERIC = 1;
    public static final int MODE_STRUCTURED_APPEND = 3;
    protected final long nativeObj;

    public QRCodeEncoder(long j6) {
        this.nativeObj = j6;
    }

    public static QRCodeEncoder __fromPtr__(long j6) {
        return new QRCodeEncoder(j6);
    }

    public static QRCodeEncoder create(QRCodeEncoder_Params qRCodeEncoder_Params) {
        return __fromPtr__(create_0(qRCodeEncoder_Params.nativeObj));
    }

    private static native long create_0(long j6);

    private static native long create_1();

    private static native void delete(long j6);

    private static native void encodeStructuredAppend_0(long j6, String str, long j7);

    private static native void encode_0(long j6, String str, long j7);

    public void encode(String str, Mat mat) {
        encode_0(this.nativeObj, str, mat.nativeObj);
    }

    public void encodeStructuredAppend(String str, List<Mat> list) {
        Mat mat = new Mat();
        encodeStructuredAppend_0(this.nativeObj, str, mat.nativeObj);
        Converters.Mat_to_vector_Mat(mat, list);
        mat.release();
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public static QRCodeEncoder create() {
        return __fromPtr__(create_1());
    }
}
