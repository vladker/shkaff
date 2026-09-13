package org.opencv.dnn;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfRotatedRect;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TextDetectionModel extends Model {
    public TextDetectionModel(long j6) {
        super(j6);
    }

    public static TextDetectionModel __fromPtr__(long j6) {
        return new TextDetectionModel(j6);
    }

    private static native void delete(long j6);

    private static native void detectTextRectangles_0(long j6, long j7, long j8, long j9);

    private static native void detectTextRectangles_1(long j6, long j7, long j8);

    private static native void detect_0(long j6, long j7, long j8, long j9);

    private static native void detect_1(long j6, long j7, long j8);

    public void detect(Mat mat, List<MatOfPoint> list, MatOfFloat matOfFloat) {
        Mat mat2 = new Mat();
        detect_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, matOfFloat.nativeObj);
        Converters.Mat_to_vector_vector_Point(mat2, list);
        mat2.release();
    }

    public void detectTextRectangles(Mat mat, MatOfRotatedRect matOfRotatedRect, MatOfFloat matOfFloat) {
        detectTextRectangles_0(this.nativeObj, mat.nativeObj, matOfRotatedRect.nativeObj, matOfFloat.nativeObj);
    }

    @Override // org.opencv.dnn.Model
    public void finalize() {
        delete(this.nativeObj);
    }

    public void detectTextRectangles(Mat mat, MatOfRotatedRect matOfRotatedRect) {
        detectTextRectangles_1(this.nativeObj, mat.nativeObj, matOfRotatedRect.nativeObj);
    }

    public void detect(Mat mat, List<MatOfPoint> list) {
        Mat mat2 = new Mat();
        detect_1(this.nativeObj, mat.nativeObj, mat2.nativeObj);
        Converters.Mat_to_vector_vector_Point(mat2, list);
        mat2.release();
    }
}
