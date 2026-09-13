package org.opencv.dnn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TextDetectionModel_EAST extends TextDetectionModel {
    public TextDetectionModel_EAST(long j6) {
        super(j6);
    }

    private static native long TextDetectionModel_EAST_0(long j6);

    private static native long TextDetectionModel_EAST_1(String str, String str2);

    private static native long TextDetectionModel_EAST_2(String str);

    public static TextDetectionModel_EAST __fromPtr__(long j6) {
        return new TextDetectionModel_EAST(j6);
    }

    private static native void delete(long j6);

    private static native float getConfidenceThreshold_0(long j6);

    private static native float getNMSThreshold_0(long j6);

    private static native long setConfidenceThreshold_0(long j6, float f6);

    private static native long setNMSThreshold_0(long j6, float f6);

    @Override // org.opencv.dnn.TextDetectionModel, org.opencv.dnn.Model
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getConfidenceThreshold() {
        return getConfidenceThreshold_0(this.nativeObj);
    }

    public float getNMSThreshold() {
        return getNMSThreshold_0(this.nativeObj);
    }

    public TextDetectionModel_EAST setConfidenceThreshold(float f6) {
        return new TextDetectionModel_EAST(setConfidenceThreshold_0(this.nativeObj, f6));
    }

    public TextDetectionModel_EAST setNMSThreshold(float f6) {
        return new TextDetectionModel_EAST(setNMSThreshold_0(this.nativeObj, f6));
    }

    public TextDetectionModel_EAST(Net net) {
        super(TextDetectionModel_EAST_0(net.nativeObj));
    }

    public TextDetectionModel_EAST(String str, String str2) {
        super(TextDetectionModel_EAST_1(str, str2));
    }

    public TextDetectionModel_EAST(String str) {
        super(TextDetectionModel_EAST_2(str));
    }
}
