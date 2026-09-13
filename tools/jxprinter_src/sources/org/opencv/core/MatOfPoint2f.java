package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfPoint2f extends Mat {
    private static final int _channels = 2;
    private static final int _depth = 5;

    public MatOfPoint2f() {
    }

    public static MatOfPoint2f fromNativeAddr(long j6) {
        return new MatOfPoint2f(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(5, 2));
        }
    }

    public void fromArray(Point... pointArr) {
        if (pointArr == null || pointArr.length == 0) {
            return;
        }
        int length = pointArr.length;
        alloc(length);
        float[] fArr = new float[length * 2];
        for (int i5 = 0; i5 < length; i5++) {
            Point point = pointArr[i5];
            int i6 = i5 * 2;
            fArr[i6] = (float) point.f7681x;
            fArr[i6 + 1] = (float) point.f7682y;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<Point> list) {
        fromArray((Point[]) list.toArray(new Point[0]));
    }

    public Point[] toArray() {
        int i5 = (int) total();
        Point[] pointArr = new Point[i5];
        if (i5 != 0) {
            float[] fArr = new float[i5 * 2];
            get(0, 0, fArr);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 2;
                pointArr[i6] = new Point(fArr[i7], fArr[i7 + 1]);
            }
        }
        return pointArr;
    }

    public List<Point> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint2f(long j6) {
        super(j6);
        if (!empty() && checkVector(2, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint2f(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(2, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint2f(Point... pointArr) {
        fromArray(pointArr);
    }
}
