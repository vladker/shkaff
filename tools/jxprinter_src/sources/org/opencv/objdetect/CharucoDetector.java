package org.opencv.objdetect;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CharucoDetector extends Algorithm {
    public CharucoDetector(long j6) {
        super(j6);
    }

    private static native long CharucoDetector_0(long j6, long j7, long j8, long j9);

    private static native long CharucoDetector_1(long j6, long j7, long j8);

    private static native long CharucoDetector_2(long j6, long j7);

    private static native long CharucoDetector_3(long j6);

    public static CharucoDetector __fromPtr__(long j6) {
        return new CharucoDetector(j6);
    }

    private static native void delete(long j6);

    private static native void detectBoard_0(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void detectBoard_1(long j6, long j7, long j8, long j9, long j10);

    private static native void detectBoard_2(long j6, long j7, long j8, long j9);

    private static native void detectDiamonds_0(long j6, long j7, long j8, long j9, long j10, long j11);

    private static native void detectDiamonds_1(long j6, long j7, long j8, long j9, long j10);

    private static native void detectDiamonds_2(long j6, long j7, long j8, long j9);

    private static native long getBoard_0(long j6);

    private static native long getCharucoParameters_0(long j6);

    private static native long getDetectorParameters_0(long j6);

    private static native long getRefineParameters_0(long j6);

    private static native void setBoard_0(long j6, long j7);

    private static native void setCharucoParameters_0(long j6, long j7);

    private static native void setDetectorParameters_0(long j6, long j7);

    private static native void setRefineParameters_0(long j6, long j7);

    public void detectBoard(Mat mat, Mat mat2, Mat mat3, List<Mat> list, Mat mat4) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        detectBoard_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, matVector_Mat_to_Mat.nativeObj, mat4.nativeObj);
        Converters.Mat_to_vector_Mat(matVector_Mat_to_Mat, list);
        matVector_Mat_to_Mat.release();
    }

    public void detectDiamonds(Mat mat, List<Mat> list, Mat mat2, List<Mat> list2, Mat mat3) {
        Mat mat4 = new Mat();
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list2);
        detectDiamonds_0(this.nativeObj, mat.nativeObj, mat4.nativeObj, mat2.nativeObj, matVector_Mat_to_Mat.nativeObj, mat3.nativeObj);
        AbstractC1125a.p(mat4, list, matVector_Mat_to_Mat, list2);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public CharucoBoard getBoard() {
        return new CharucoBoard(getBoard_0(this.nativeObj));
    }

    public CharucoParameters getCharucoParameters() {
        return new CharucoParameters(getCharucoParameters_0(this.nativeObj));
    }

    public DetectorParameters getDetectorParameters() {
        return new DetectorParameters(getDetectorParameters_0(this.nativeObj));
    }

    public RefineParameters getRefineParameters() {
        return new RefineParameters(getRefineParameters_0(this.nativeObj));
    }

    public void setBoard(CharucoBoard charucoBoard) {
        setBoard_0(this.nativeObj, charucoBoard.nativeObj);
    }

    public void setCharucoParameters(CharucoParameters charucoParameters) {
        setCharucoParameters_0(this.nativeObj, charucoParameters.nativeObj);
    }

    public void setDetectorParameters(DetectorParameters detectorParameters) {
        setDetectorParameters_0(this.nativeObj, detectorParameters.nativeObj);
    }

    public void setRefineParameters(RefineParameters refineParameters) {
        setRefineParameters_0(this.nativeObj, refineParameters.nativeObj);
    }

    public CharucoDetector(CharucoBoard charucoBoard, CharucoParameters charucoParameters, DetectorParameters detectorParameters, RefineParameters refineParameters) {
        super(CharucoDetector_0(charucoBoard.nativeObj, charucoParameters.nativeObj, detectorParameters.nativeObj, refineParameters.nativeObj));
    }

    public CharucoDetector(CharucoBoard charucoBoard, CharucoParameters charucoParameters, DetectorParameters detectorParameters) {
        super(CharucoDetector_1(charucoBoard.nativeObj, charucoParameters.nativeObj, detectorParameters.nativeObj));
    }

    public CharucoDetector(CharucoBoard charucoBoard, CharucoParameters charucoParameters) {
        super(CharucoDetector_2(charucoBoard.nativeObj, charucoParameters.nativeObj));
    }

    public CharucoDetector(CharucoBoard charucoBoard) {
        super(CharucoDetector_3(charucoBoard.nativeObj));
    }

    public void detectBoard(Mat mat, Mat mat2, Mat mat3, List<Mat> list) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        detectBoard_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, matVector_Mat_to_Mat.nativeObj);
        Converters.Mat_to_vector_Mat(matVector_Mat_to_Mat, list);
        matVector_Mat_to_Mat.release();
    }

    public void detectBoard(Mat mat, Mat mat2, Mat mat3) {
        detectBoard_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void detectDiamonds(Mat mat, List<Mat> list, Mat mat2, List<Mat> list2) {
        Mat mat3 = new Mat();
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list2);
        detectDiamonds_1(this.nativeObj, mat.nativeObj, mat3.nativeObj, mat2.nativeObj, matVector_Mat_to_Mat.nativeObj);
        AbstractC1125a.p(mat3, list, matVector_Mat_to_Mat, list2);
    }

    public void detectDiamonds(Mat mat, List<Mat> list, Mat mat2) {
        Mat mat3 = new Mat();
        detectDiamonds_2(this.nativeObj, mat.nativeObj, mat3.nativeObj, mat2.nativeObj);
        Converters.Mat_to_vector_Mat(mat3, list);
        mat3.release();
    }
}
