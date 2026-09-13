package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfPoint extends Mat {
    private static final int _channels = 2;
    private static final int _depth = 4;

    public MatOfPoint() {
    }

    public static MatOfPoint fromNativeAddr(long j6) {
        return new MatOfPoint(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(4, 2));
        }
    }

    public void fromArray(Point... pointArr) {
        if (pointArr == null || pointArr.length == 0) {
            return;
        }
        int length = pointArr.length;
        alloc(length);
        int[] iArr = new int[length * 2];
        for (int i5 = 0; i5 < length; i5++) {
            Point point = pointArr[i5];
            int i6 = i5 * 2;
            iArr[i6] = (int) point.f7681x;
            iArr[i6 + 1] = (int) point.f7682y;
        }
        put(0, 0, iArr);
    }

    public void fromList(List<Point> list) {
        fromArray((Point[]) list.toArray(new Point[0]));
    }

    public Point[] toArray() {
        int i5 = (int) total();
        Point[] pointArr = new Point[i5];
        if (i5 != 0) {
            int[] iArr = new int[i5 * 2];
            get(0, 0, iArr);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 2;
                pointArr[i6] = new Point(iArr[i7], iArr[i7 + 1]);
            }
        }
        return pointArr;
    }

    public List<Point> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint(long j6) {
        super(j6);
        if (!empty() && checkVector(2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint(Point... pointArr) {
        fromArray(pointArr);
    }
}
