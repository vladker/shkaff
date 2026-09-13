package org.opencv.objdetect;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint3f;
import org.opencv.core.Point3;
import org.opencv.core.Size;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Board {
    protected final long nativeObj;

    public Board(long j6) {
        this.nativeObj = j6;
    }

    private static native long Board_0(long j6, long j7, long j8);

    public static Board __fromPtr__(long j6) {
        return new Board(j6);
    }

    private static native void delete(long j6);

    private static native void generateImage_0(long j6, double d, double d6, long j7, int i5, int i6);

    private static native void generateImage_1(long j6, double d, double d6, long j7, int i5);

    private static native void generateImage_2(long j6, double d, double d6, long j7);

    private static native long getDictionary_0(long j6);

    private static native long getIds_0(long j6);

    private static native long getObjPoints_0(long j6);

    private static native double[] getRightBottomCorner_0(long j6);

    private static native void matchImagePoints_0(long j6, long j7, long j8, long j9, long j10);

    public void finalize() {
        delete(this.nativeObj);
    }

    public void generateImage(Size size, Mat mat, int i5, int i6) {
        generateImage_0(this.nativeObj, size.width, size.height, mat.nativeObj, i5, i6);
    }

    public Dictionary getDictionary() {
        return new Dictionary(getDictionary_0(this.nativeObj));
    }

    public MatOfInt getIds() {
        return MatOfInt.fromNativeAddr(getIds_0(this.nativeObj));
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public List<MatOfPoint3f> getObjPoints() {
        ArrayList arrayList = new ArrayList();
        Converters.Mat_to_vector_vector_Point3f(new Mat(getObjPoints_0(this.nativeObj)), arrayList);
        return arrayList;
    }

    public Point3 getRightBottomCorner() {
        return new Point3(getRightBottomCorner_0(this.nativeObj));
    }

    public void matchImagePoints(List<Mat> list, Mat mat, Mat mat2, Mat mat3) {
        matchImagePoints_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public Board(List<Mat> list, Dictionary dictionary, Mat mat) {
        this.nativeObj = Board_0(Converters.vector_Mat_to_Mat(list).nativeObj, dictionary.nativeObj, mat.nativeObj);
    }

    public void generateImage(Size size, Mat mat, int i5) {
        generateImage_1(this.nativeObj, size.width, size.height, mat.nativeObj, i5);
    }

    public void generateImage(Size size, Mat mat) {
        generateImage_2(this.nativeObj, size.width, size.height, mat.nativeObj);
    }
}
