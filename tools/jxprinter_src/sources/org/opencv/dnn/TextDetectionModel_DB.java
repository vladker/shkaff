package org.opencv.dnn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TextDetectionModel_DB extends TextDetectionModel {
    public TextDetectionModel_DB(long j6) {
        super(j6);
    }

    private static native long TextDetectionModel_DB_0(long j6);

    private static native long TextDetectionModel_DB_1(String str, String str2);

    private static native long TextDetectionModel_DB_2(String str);

    public static TextDetectionModel_DB __fromPtr__(long j6) {
        return new TextDetectionModel_DB(j6);
    }

    private static native void delete(long j6);

    private static native float getBinaryThreshold_0(long j6);

    private static native int getMaxCandidates_0(long j6);

    private static native float getPolygonThreshold_0(long j6);

    private static native double getUnclipRatio_0(long j6);

    private static native long setBinaryThreshold_0(long j6, float f6);

    private static native long setMaxCandidates_0(long j6, int i5);

    private static native long setPolygonThreshold_0(long j6, float f6);

    private static native long setUnclipRatio_0(long j6, double d);

    @Override // org.opencv.dnn.TextDetectionModel, org.opencv.dnn.Model
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getBinaryThreshold() {
        return getBinaryThreshold_0(this.nativeObj);
    }

    public int getMaxCandidates() {
        return getMaxCandidates_0(this.nativeObj);
    }

    public float getPolygonThreshold() {
        return getPolygonThreshold_0(this.nativeObj);
    }

    public double getUnclipRatio() {
        return getUnclipRatio_0(this.nativeObj);
    }

    public TextDetectionModel_DB setBinaryThreshold(float f6) {
        return new TextDetectionModel_DB(setBinaryThreshold_0(this.nativeObj, f6));
    }

    public TextDetectionModel_DB setMaxCandidates(int i5) {
        return new TextDetectionModel_DB(setMaxCandidates_0(this.nativeObj, i5));
    }

    public TextDetectionModel_DB setPolygonThreshold(float f6) {
        return new TextDetectionModel_DB(setPolygonThreshold_0(this.nativeObj, f6));
    }

    public TextDetectionModel_DB setUnclipRatio(double d) {
        return new TextDetectionModel_DB(setUnclipRatio_0(this.nativeObj, d));
    }

    public TextDetectionModel_DB(Net net) {
        super(TextDetectionModel_DB_0(net.nativeObj));
    }

    public TextDetectionModel_DB(String str, String str2) {
        super(TextDetectionModel_DB_1(str, str2));
    }

    public TextDetectionModel_DB(String str) {
        super(TextDetectionModel_DB_2(str));
    }
}
