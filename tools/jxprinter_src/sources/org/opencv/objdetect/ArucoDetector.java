package org.opencv.objdetect;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ArucoDetector extends Algorithm {
    public ArucoDetector(long j6) {
        super(j6);
    }

    private static native long ArucoDetector_0(long j6, long j7, long j8);

    private static native long ArucoDetector_1(long j6, long j7);

    private static native long ArucoDetector_2(long j6);

    private static native long ArucoDetector_3();

    public static ArucoDetector __fromPtr__(long j6) {
        return new ArucoDetector(j6);
    }

    private static native void delete(long j6);

    private static native void detectMarkers_0(long j6, long j7, long j8, long j9, long j10);

    private static native void detectMarkers_1(long j6, long j7, long j8, long j9);

    private static native long getDetectorParameters_0(long j6);

    private static native long getDictionary_0(long j6);

    private static native long getRefineParameters_0(long j6);

    private static native void refineDetectedMarkers_0(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14);

    private static native void refineDetectedMarkers_1(long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13);

    private static native void refineDetectedMarkers_2(long j6, long j7, long j8, long j9, long j10, long j11, long j12);

    private static native void refineDetectedMarkers_3(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void setDetectorParameters_0(long j6, long j7);

    private static native void setDictionary_0(long j6, long j7);

    private static native void setRefineParameters_0(long j6, long j7);

    public void detectMarkers(Mat mat, List<Mat> list, Mat mat2, List<Mat> list2) {
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        detectMarkers_0(this.nativeObj, mat.nativeObj, mat3.nativeObj, mat2.nativeObj, mat4.nativeObj);
        AbstractC1125a.p(mat3, list, mat4, list2);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public DetectorParameters getDetectorParameters() {
        return new DetectorParameters(getDetectorParameters_0(this.nativeObj));
    }

    public Dictionary getDictionary() {
        return new Dictionary(getDictionary_0(this.nativeObj));
    }

    public RefineParameters getRefineParameters() {
        return new RefineParameters(getRefineParameters_0(this.nativeObj));
    }

    public void refineDetectedMarkers(Mat mat, Board board, List<Mat> list, Mat mat2, List<Mat> list2, Mat mat3, Mat mat4, Mat mat5) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        refineDetectedMarkers_0(this.nativeObj, mat.nativeObj, board.nativeObj, matVector_Mat_to_Mat.nativeObj, mat2.nativeObj, matVector_Mat_to_Mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
        AbstractC1125a.p(matVector_Mat_to_Mat, list, matVector_Mat_to_Mat2, list2);
    }

    public void setDetectorParameters(DetectorParameters detectorParameters) {
        setDetectorParameters_0(this.nativeObj, detectorParameters.nativeObj);
    }

    public void setDictionary(Dictionary dictionary) {
        setDictionary_0(this.nativeObj, dictionary.nativeObj);
    }

    public void setRefineParameters(RefineParameters refineParameters) {
        setRefineParameters_0(this.nativeObj, refineParameters.nativeObj);
    }

    public ArucoDetector(Dictionary dictionary, DetectorParameters detectorParameters, RefineParameters refineParameters) {
        super(ArucoDetector_0(dictionary.nativeObj, detectorParameters.nativeObj, refineParameters.nativeObj));
    }

    public ArucoDetector(Dictionary dictionary, DetectorParameters detectorParameters) {
        super(ArucoDetector_1(dictionary.nativeObj, detectorParameters.nativeObj));
    }

    public ArucoDetector(Dictionary dictionary) {
        super(ArucoDetector_2(dictionary.nativeObj));
    }

    public ArucoDetector() {
        super(ArucoDetector_3());
    }

    public void detectMarkers(Mat mat, List<Mat> list, Mat mat2) {
        Mat mat3 = new Mat();
        detectMarkers_1(this.nativeObj, mat.nativeObj, mat3.nativeObj, mat2.nativeObj);
        Converters.Mat_to_vector_Mat(mat3, list);
        mat3.release();
    }

    public void refineDetectedMarkers(Mat mat, Board board, List<Mat> list, Mat mat2, List<Mat> list2, Mat mat3, Mat mat4) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        refineDetectedMarkers_1(this.nativeObj, mat.nativeObj, board.nativeObj, matVector_Mat_to_Mat.nativeObj, mat2.nativeObj, matVector_Mat_to_Mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
        AbstractC1125a.p(matVector_Mat_to_Mat, list, matVector_Mat_to_Mat2, list2);
    }

    public void refineDetectedMarkers(Mat mat, Board board, List<Mat> list, Mat mat2, List<Mat> list2, Mat mat3) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        refineDetectedMarkers_2(this.nativeObj, mat.nativeObj, board.nativeObj, matVector_Mat_to_Mat.nativeObj, mat2.nativeObj, matVector_Mat_to_Mat2.nativeObj, mat3.nativeObj);
        AbstractC1125a.p(matVector_Mat_to_Mat, list, matVector_Mat_to_Mat2, list2);
    }

    public void refineDetectedMarkers(Mat mat, Board board, List<Mat> list, Mat mat2, List<Mat> list2) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list2);
        refineDetectedMarkers_3(this.nativeObj, mat.nativeObj, board.nativeObj, matVector_Mat_to_Mat.nativeObj, mat2.nativeObj, matVector_Mat_to_Mat2.nativeObj);
        AbstractC1125a.p(matVector_Mat_to_Mat, list, matVector_Mat_to_Mat2, list2);
    }
}
