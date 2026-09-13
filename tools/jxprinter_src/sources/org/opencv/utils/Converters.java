package org.opencv.utils;

import io.flutter.embedding.android.KeyboardMap;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.DMatch;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint3f;
import org.opencv.core.Point;
import org.opencv.core.Point3;
import org.opencv.core.Rect;
import org.opencv.core.Rect2d;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Converters {
    public static void Mat_to_vector_DMatch(Mat mat, List<DMatch> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        int iRows = mat.rows();
        if (CvType.CV_64FC4 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_64FC4 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        double[] dArr = new double[iRows * 4];
        mat.get(0, 0, dArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            int i6 = i5 * 4;
            list.add(new DMatch((int) dArr[i6], (int) dArr[i6 + 1], (int) dArr[i6 + 2], (float) dArr[i6 + 3]));
        }
    }

    public static void Mat_to_vector_KeyPoint(Mat mat, List<KeyPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        int iRows = mat.rows();
        if (CvType.CV_64FC(7) != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_64FC(7) != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        double[] dArr = new double[iRows * 7];
        mat.get(0, 0, dArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            int i6 = i5 * 7;
            list.add(new KeyPoint((float) dArr[i6], (float) dArr[i6 + 1], (float) dArr[i6 + 2], (float) dArr[i6 + 3], (float) dArr[i6 + 4], (int) dArr[i6 + 5], (int) dArr[i6 + 6]));
        }
    }

    public static void Mat_to_vector_Mat(Mat mat, List<Mat> list) {
        if (list == null) {
            throw new IllegalArgumentException("mats == null");
        }
        int iRows = mat.rows();
        if (CvType.CV_32SC2 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32SC2 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        int[] iArr = new int[iRows * 2];
        mat.get(0, 0, iArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            int i6 = i5 * 2;
            list.add(new Mat((((long) iArr[i6]) << 32) | (((long) iArr[i6 + 1]) & KeyboardMap.kValueMask)));
        }
    }

    public static void Mat_to_vector_Point(Mat mat, List<Point> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        int iRows = mat.rows();
        int iType = mat.type();
        if (mat.cols() != 1) {
            throw new IllegalArgumentException("Input Mat should have one column\n" + mat);
        }
        list.clear();
        int i5 = 0;
        if (iType == CvType.CV_32SC2) {
            int[] iArr = new int[iRows * 2];
            mat.get(0, 0, iArr);
            while (i5 < iRows) {
                int i6 = i5 * 2;
                list.add(new Point(iArr[i6], iArr[i6 + 1]));
                i5++;
            }
            return;
        }
        if (iType == CvType.CV_32FC2) {
            float[] fArr = new float[iRows * 2];
            mat.get(0, 0, fArr);
            while (i5 < iRows) {
                int i7 = i5 * 2;
                list.add(new Point(fArr[i7], fArr[i7 + 1]));
                i5++;
            }
            return;
        }
        if (iType != CvType.CV_64FC2) {
            throw new IllegalArgumentException("Input Mat should be of CV_32SC2, CV_32FC2 or CV_64FC2 type\n" + mat);
        }
        double[] dArr = new double[iRows * 2];
        mat.get(0, 0, dArr);
        while (i5 < iRows) {
            int i8 = i5 * 2;
            list.add(new Point(dArr[i8], dArr[i8 + 1]));
            i5++;
        }
    }

    public static void Mat_to_vector_Point2d(Mat mat, List<Point> list) {
        Mat_to_vector_Point(mat, list);
    }

    public static void Mat_to_vector_Point2f(Mat mat, List<Point> list) {
        Mat_to_vector_Point(mat, list);
    }

    public static void Mat_to_vector_Point3(Mat mat, List<Point3> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        int iRows = mat.rows();
        int iType = mat.type();
        if (mat.cols() != 1) {
            throw new IllegalArgumentException("Input Mat should have one column\n" + mat);
        }
        list.clear();
        int i5 = 0;
        if (iType == CvType.CV_32SC3) {
            int[] iArr = new int[iRows * 3];
            mat.get(0, 0, iArr);
            while (i5 < iRows) {
                int i6 = i5 * 3;
                list.add(new Point3(iArr[i6], iArr[i6 + 1], iArr[i6 + 2]));
                i5++;
            }
            return;
        }
        if (iType == CvType.CV_32FC3) {
            float[] fArr = new float[iRows * 3];
            mat.get(0, 0, fArr);
            while (i5 < iRows) {
                int i7 = i5 * 3;
                list.add(new Point3(fArr[i7], fArr[i7 + 1], fArr[i7 + 2]));
                i5++;
            }
            return;
        }
        if (iType != CvType.CV_64FC3) {
            throw new IllegalArgumentException("Input Mat should be of CV_32SC3, CV_32FC3 or CV_64FC3 type\n" + mat);
        }
        double[] dArr = new double[iRows * 3];
        mat.get(0, 0, dArr);
        while (i5 < iRows) {
            int i8 = i5 * 3;
            list.add(new Point3(dArr[i8], dArr[i8 + 1], dArr[i8 + 2]));
            i5++;
        }
    }

    public static void Mat_to_vector_Point3d(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Point3f(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Point3i(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Rect(Mat mat, List<Rect> list) {
        if (list == null) {
            throw new IllegalArgumentException("rs == null");
        }
        int iRows = mat.rows();
        if (CvType.CV_32SC4 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32SC4 != m.type() ||  m.rows()!=1\n" + mat);
        }
        list.clear();
        int[] iArr = new int[iRows * 4];
        mat.get(0, 0, iArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            int i6 = i5 * 4;
            list.add(new Rect(iArr[i6], iArr[i6 + 1], iArr[i6 + 2], iArr[i6 + 3]));
        }
    }

    public static void Mat_to_vector_Rect2d(Mat mat, List<Rect2d> list) {
        if (list == null) {
            throw new IllegalArgumentException("rs == null");
        }
        int iRows = mat.rows();
        if (CvType.CV_64FC4 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_64FC4 != m.type() ||  m.rows()!=1\n" + mat);
        }
        list.clear();
        double[] dArr = new double[iRows * 4];
        mat.get(0, 0, dArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            int i6 = i5 * 4;
            list.add(new Rect2d(dArr[i6], dArr[i6 + 1], dArr[i6 + 2], dArr[i6 + 3]));
        }
    }

    public static void Mat_to_vector_RotatedRect(Mat mat, List<RotatedRect> list) {
        if (list == null) {
            throw new IllegalArgumentException("rs == null");
        }
        int iRows = mat.rows();
        if (CvType.CV_32FC(5) != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32FC5 != m.type() ||  m.rows()!=1\n" + mat);
        }
        list.clear();
        float[] fArr = new float[iRows * 5];
        mat.get(0, 0, fArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            int i6 = i5 * 5;
            list.add(new RotatedRect(new Point(fArr[i6], fArr[i6 + 1]), new Size(fArr[i6 + 2], fArr[i6 + 3]), fArr[i6 + 4]));
        }
    }

    public static void Mat_to_vector_char(Mat mat, List<Byte> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        int iRows = mat.rows();
        if (CvType.CV_8SC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_8SC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        byte[] bArr = new byte[iRows];
        mat.get(0, 0, bArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            list.add(Byte.valueOf(bArr[i5]));
        }
    }

    public static void Mat_to_vector_double(Mat mat, List<Double> list) {
        if (list == null) {
            throw new IllegalArgumentException("ds == null");
        }
        int iRows = mat.rows();
        if (CvType.CV_64FC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_64FC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        double[] dArr = new double[iRows];
        mat.get(0, 0, dArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            list.add(Double.valueOf(dArr[i5]));
        }
    }

    public static void Mat_to_vector_float(Mat mat, List<Float> list) {
        if (list == null) {
            throw new IllegalArgumentException("fs == null");
        }
        int iRows = mat.rows();
        if (CvType.CV_32FC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32FC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        float[] fArr = new float[iRows];
        mat.get(0, 0, fArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            list.add(Float.valueOf(fArr[i5]));
        }
    }

    public static void Mat_to_vector_int(Mat mat, List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("is == null");
        }
        int iRows = mat.rows();
        if (CvType.CV_32SC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_32SC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        int[] iArr = new int[iRows];
        mat.get(0, 0, iArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            list.add(Integer.valueOf(iArr[i5]));
        }
    }

    public static void Mat_to_vector_uchar(Mat mat, List<Byte> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        int iRows = mat.rows();
        if (CvType.CV_8UC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException("CvType.CV_8UC1 != m.type() ||  m.cols()!=1\n" + mat);
        }
        list.clear();
        byte[] bArr = new byte[iRows];
        mat.get(0, 0, bArr);
        for (int i5 = 0; i5 < iRows; i5++) {
            list.add(Byte.valueOf(bArr[i5]));
        }
    }

    public static void Mat_to_vector_vector_DMatch(Mat mat, List<MatOfDMatch> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        ArrayList arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        list.clear();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Mat mat2 = (Mat) obj;
            list.add(new MatOfDMatch(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_KeyPoint(Mat mat, List<MatOfKeyPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        ArrayList arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Mat mat2 = (Mat) obj;
            list.add(new MatOfKeyPoint(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_Point(Mat mat, List<MatOfPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        ArrayList arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Mat mat2 = (Mat) obj;
            list.add(new MatOfPoint(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_Point2f(Mat mat, List<MatOfPoint2f> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        ArrayList arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Mat mat2 = (Mat) obj;
            list.add(new MatOfPoint2f(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_Point3f(Mat mat, List<MatOfPoint3f> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        ArrayList arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Mat mat2 = (Mat) obj;
            list.add(new MatOfPoint3f(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_char(Mat mat, List<List<Byte>> list) {
        if (list == null) {
            throw new IllegalArgumentException("Output List can't be null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("Input Mat can't be null");
        }
        ArrayList arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Mat mat2 = (Mat) obj;
            ArrayList arrayList2 = new ArrayList();
            Mat_to_vector_char(mat2, arrayList2);
            list.add(arrayList2);
            mat2.release();
        }
        arrayList.clear();
    }

    public static Mat vector_DMatch_to_Mat(List<DMatch> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_64FC4);
        double[] dArr = new double[size * 4];
        for (int i5 = 0; i5 < size; i5++) {
            DMatch dMatch = list.get(i5);
            int i6 = i5 * 4;
            dArr[i6] = dMatch.queryIdx;
            dArr[i6 + 1] = dMatch.trainIdx;
            dArr[i6 + 2] = dMatch.imgIdx;
            dArr[i6 + 3] = dMatch.distance;
        }
        mat.put(0, 0, dArr);
        return mat;
    }

    public static Mat vector_KeyPoint_to_Mat(List<KeyPoint> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_64FC(7));
        double[] dArr = new double[size * 7];
        for (int i5 = 0; i5 < size; i5++) {
            KeyPoint keyPoint = list.get(i5);
            int i6 = i5 * 7;
            Point point = keyPoint.pt;
            dArr[i6] = point.f7681x;
            dArr[i6 + 1] = point.f7682y;
            dArr[i6 + 2] = keyPoint.size;
            dArr[i6 + 3] = keyPoint.angle;
            dArr[i6 + 4] = keyPoint.response;
            dArr[i6 + 5] = keyPoint.octave;
            dArr[i6 + 6] = keyPoint.class_id;
        }
        mat.put(0, 0, dArr);
        return mat;
    }

    public static Mat vector_Mat_to_Mat(List<Mat> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32SC2);
        int[] iArr = new int[size * 2];
        for (int i5 = 0; i5 < size; i5++) {
            long j6 = list.get(i5).nativeObj;
            int i6 = i5 * 2;
            iArr[i6] = (int) (j6 >> 32);
            iArr[i6 + 1] = (int) j6;
        }
        mat.put(0, 0, iArr);
        return mat;
    }

    public static Mat vector_Point2d_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 6);
    }

    public static Mat vector_Point2f_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 5);
    }

    public static Mat vector_Point3_to_Mat(List<Point3> list, int i5) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        if (i5 == 4) {
            Mat mat = new Mat(size, 1, CvType.CV_32SC3);
            int[] iArr = new int[size * 3];
            for (int i6 = 0; i6 < size; i6++) {
                Point3 point3 = list.get(i6);
                int i7 = i6 * 3;
                iArr[i7] = (int) point3.f7683x;
                iArr[i7 + 1] = (int) point3.f7684y;
                iArr[i7 + 2] = (int) point3.f7685z;
            }
            mat.put(0, 0, iArr);
            return mat;
        }
        if (i5 == 5) {
            Mat mat2 = new Mat(size, 1, CvType.CV_32FC3);
            float[] fArr = new float[size * 3];
            for (int i8 = 0; i8 < size; i8++) {
                Point3 point4 = list.get(i8);
                int i9 = i8 * 3;
                fArr[i9] = (float) point4.f7683x;
                fArr[i9 + 1] = (float) point4.f7684y;
                fArr[i9 + 2] = (float) point4.f7685z;
            }
            mat2.put(0, 0, fArr);
            return mat2;
        }
        if (i5 != 6) {
            throw new IllegalArgumentException("'typeDepth' can be CV_32S, CV_32F or CV_64F");
        }
        Mat mat3 = new Mat(size, 1, CvType.CV_64FC3);
        double[] dArr = new double[size * 3];
        for (int i10 = 0; i10 < size; i10++) {
            Point3 point5 = list.get(i10);
            int i11 = i10 * 3;
            dArr[i11] = point5.f7683x;
            dArr[i11 + 1] = point5.f7684y;
            dArr[i11 + 2] = point5.f7685z;
        }
        mat3.put(0, 0, dArr);
        return mat3;
    }

    public static Mat vector_Point3d_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 6);
    }

    public static Mat vector_Point3f_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 5);
    }

    public static Mat vector_Point3i_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 4);
    }

    public static Mat vector_Point_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 4);
    }

    public static Mat vector_Rect2d_to_Mat(List<Rect2d> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_64FC4);
        double[] dArr = new double[size * 4];
        for (int i5 = 0; i5 < size; i5++) {
            Rect2d rect2d = list.get(i5);
            int i6 = i5 * 4;
            dArr[i6] = rect2d.f7688x;
            dArr[i6 + 1] = rect2d.f7689y;
            dArr[i6 + 2] = rect2d.width;
            dArr[i6 + 3] = rect2d.height;
        }
        mat.put(0, 0, dArr);
        return mat;
    }

    public static Mat vector_Rect_to_Mat(List<Rect> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32SC4);
        int[] iArr = new int[size * 4];
        for (int i5 = 0; i5 < size; i5++) {
            Rect rect = list.get(i5);
            int i6 = i5 * 4;
            iArr[i6] = rect.f7686x;
            iArr[i6 + 1] = rect.f7687y;
            iArr[i6 + 2] = rect.width;
            iArr[i6 + 3] = rect.height;
        }
        mat.put(0, 0, iArr);
        return mat;
    }

    public static Mat vector_RotatedRect_to_Mat(List<RotatedRect> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32FC(5));
        float[] fArr = new float[size * 5];
        for (int i5 = 0; i5 < size; i5++) {
            RotatedRect rotatedRect = list.get(i5);
            int i6 = i5 * 5;
            Point point = rotatedRect.center;
            fArr[i6] = (float) point.f7681x;
            fArr[i6 + 1] = (float) point.f7682y;
            Size size2 = rotatedRect.size;
            fArr[i6 + 2] = (float) size2.width;
            fArr[i6 + 3] = (float) size2.height;
            fArr[i6 + 4] = (float) rotatedRect.angle;
        }
        mat.put(0, 0, fArr);
        return mat;
    }

    public static Mat vector_char_to_Mat(List<Byte> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_8SC1);
        byte[] bArr = new byte[size];
        for (int i5 = 0; i5 < size; i5++) {
            bArr[i5] = list.get(i5).byteValue();
        }
        mat.put(0, 0, bArr);
        return mat;
    }

    public static Mat vector_double_to_Mat(List<Double> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_64FC1);
        double[] dArr = new double[size];
        for (int i5 = 0; i5 < size; i5++) {
            dArr[i5] = list.get(i5).doubleValue();
        }
        mat.put(0, 0, dArr);
        return mat;
    }

    public static Mat vector_float_to_Mat(List<Float> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32FC1);
        float[] fArr = new float[size];
        for (int i5 = 0; i5 < size; i5++) {
            fArr[i5] = list.get(i5).floatValue();
        }
        mat.put(0, 0, fArr);
        return mat;
    }

    public static Mat vector_int_to_Mat(List<Integer> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32SC1);
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr[i5] = list.get(i5).intValue();
        }
        mat.put(0, 0, iArr);
        return mat;
    }

    public static Mat vector_uchar_to_Mat(List<Byte> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_8UC1);
        byte[] bArr = new byte[size];
        for (int i5 = 0; i5 < size; i5++) {
            bArr[i5] = list.get(i5).byteValue();
        }
        mat.put(0, 0, bArr);
        return mat;
    }

    public static Mat vector_vector_DMatch_to_Mat(List<MatOfDMatch> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_KeyPoint_to_Mat(List<MatOfKeyPoint> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_Point2f_to_Mat(List<MatOfPoint2f> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_Point3f_to_Mat(List<MatOfPoint3f> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_Point_to_Mat(List<MatOfPoint> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_char_to_Mat(List<MatOfByte> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_Point_to_Mat(List<Point> list, int i5) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        if (i5 == 4) {
            Mat mat = new Mat(size, 1, CvType.CV_32SC2);
            int[] iArr = new int[size * 2];
            for (int i6 = 0; i6 < size; i6++) {
                Point point = list.get(i6);
                int i7 = i6 * 2;
                iArr[i7] = (int) point.f7681x;
                iArr[i7 + 1] = (int) point.f7682y;
            }
            mat.put(0, 0, iArr);
            return mat;
        }
        if (i5 == 5) {
            Mat mat2 = new Mat(size, 1, CvType.CV_32FC2);
            float[] fArr = new float[size * 2];
            for (int i8 = 0; i8 < size; i8++) {
                Point point2 = list.get(i8);
                int i9 = i8 * 2;
                fArr[i9] = (float) point2.f7681x;
                fArr[i9 + 1] = (float) point2.f7682y;
            }
            mat2.put(0, 0, fArr);
            return mat2;
        }
        if (i5 != 6) {
            throw new IllegalArgumentException("'typeDepth' can be CV_32S, CV_32F or CV_64F");
        }
        Mat mat3 = new Mat(size, 1, CvType.CV_64FC2);
        double[] dArr = new double[size * 2];
        for (int i10 = 0; i10 < size; i10++) {
            Point point3 = list.get(i10);
            int i11 = i10 * 2;
            dArr[i11] = point3.f7681x;
            dArr[i11 + 1] = point3.f7682y;
        }
        mat3.put(0, 0, dArr);
        return mat3;
    }
}
