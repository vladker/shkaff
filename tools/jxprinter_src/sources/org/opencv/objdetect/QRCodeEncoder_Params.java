package org.opencv.objdetect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class QRCodeEncoder_Params {
    protected final long nativeObj;

    public QRCodeEncoder_Params(long j6) {
        this.nativeObj = j6;
    }

    private static native long QRCodeEncoder_Params_0();

    public static QRCodeEncoder_Params __fromPtr__(long j6) {
        return new QRCodeEncoder_Params(j6);
    }

    private static native void delete(long j6);

    private static native int get_structure_number_0(long j6);

    private static native int get_version_0(long j6);

    private static native void set_structure_number_0(long j6, int i5);

    private static native void set_version_0(long j6, int i5);

    public void finalize() {
        delete(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int get_structure_number() {
        return get_structure_number_0(this.nativeObj);
    }

    public int get_version() {
        return get_version_0(this.nativeObj);
    }

    public void set_structure_number(int i5) {
        set_structure_number_0(this.nativeObj, i5);
    }

    public void set_version(int i5) {
        set_version_0(this.nativeObj, i5);
    }

    public QRCodeEncoder_Params() {
        this.nativeObj = QRCodeEncoder_Params_0();
    }
}
