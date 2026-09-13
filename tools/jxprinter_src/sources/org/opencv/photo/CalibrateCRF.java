package org.opencv.photo;

import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CalibrateCRF extends Algorithm {
    public CalibrateCRF(long j6) {
        super(j6);
    }

    public static CalibrateCRF __fromPtr__(long j6) {
        return new CalibrateCRF(j6);
    }

    private static native void delete(long j6);

    private static native void process_0(long j6, long j7, long j8, long j9);

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public void process(List<Mat> list, Mat mat, Mat mat2) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
