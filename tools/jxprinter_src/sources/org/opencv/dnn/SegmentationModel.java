package org.opencv.dnn;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SegmentationModel extends Model {
    public SegmentationModel(long j6) {
        super(j6);
    }

    private static native long SegmentationModel_0(String str, String str2);

    private static native long SegmentationModel_1(String str);

    private static native long SegmentationModel_2(long j6);

    public static SegmentationModel __fromPtr__(long j6) {
        return new SegmentationModel(j6);
    }

    private static native void delete(long j6);

    private static native void segment_0(long j6, long j7, long j8);

    @Override // org.opencv.dnn.Model
    public void finalize() {
        delete(this.nativeObj);
    }

    public void segment(Mat mat, Mat mat2) {
        segment_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public SegmentationModel(String str, String str2) {
        super(SegmentationModel_0(str, str2));
    }

    public SegmentationModel(String str) {
        super(SegmentationModel_1(str));
    }

    public SegmentationModel(Net net) {
        super(SegmentationModel_2(net.nativeObj));
    }
}
