package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfPoint3 extends Mat {
    private static final int _channels = 3;
    private static final int _depth = 4;

    public MatOfPoint3() {
    }

    public static MatOfPoint3 fromNativeAddr(long j6) {
        return new MatOfPoint3(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(4, 3));
        }
    }

    public void fromArray(Point3... point3Arr) {
        if (point3Arr == null || point3Arr.length == 0) {
            return;
        }
        int length = point3Arr.length;
        alloc(length);
        int[] iArr = new int[length * 3];
        for (int i5 = 0; i5 < length; i5++) {
            Point3 point3 = point3Arr[i5];
            int i6 = i5 * 3;
            iArr[i6] = (int) point3.f7683x;
            iArr[i6 + 1] = (int) point3.f7684y;
            iArr[i6 + 2] = (int) point3.f7685z;
        }
        put(0, 0, iArr);
    }

    public void fromList(List<Point3> list) {
        fromArray((Point3[]) list.toArray(new Point3[0]));
    }

    public Point3[] toArray() {
        int i5 = (int) total();
        Point3[] point3Arr = new Point3[i5];
        if (i5 != 0) {
            int[] iArr = new int[i5 * 3];
            get(0, 0, iArr);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 3;
                point3Arr[i6] = new Point3(iArr[i7], iArr[i7 + 1], iArr[i7 + 2]);
            }
        }
        return point3Arr;
    }

    public List<Point3> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint3(long j6) {
        super(j6);
        if (!empty() && checkVector(3, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(3, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3(Point3... point3Arr) {
        fromArray(point3Arr);
    }
}
