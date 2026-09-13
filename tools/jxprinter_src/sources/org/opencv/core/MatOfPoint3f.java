package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfPoint3f extends Mat {
    private static final int _channels = 3;
    private static final int _depth = 5;

    public MatOfPoint3f() {
    }

    public static MatOfPoint3f fromNativeAddr(long j6) {
        return new MatOfPoint3f(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(5, 3));
        }
    }

    public void fromArray(Point3... point3Arr) {
        if (point3Arr == null || point3Arr.length == 0) {
            return;
        }
        int length = point3Arr.length;
        alloc(length);
        float[] fArr = new float[length * 3];
        for (int i5 = 0; i5 < length; i5++) {
            Point3 point3 = point3Arr[i5];
            int i6 = i5 * 3;
            fArr[i6] = (float) point3.f7683x;
            fArr[i6 + 1] = (float) point3.f7684y;
            fArr[i6 + 2] = (float) point3.f7685z;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<Point3> list) {
        fromArray((Point3[]) list.toArray(new Point3[0]));
    }

    public Point3[] toArray() {
        int i5 = (int) total();
        Point3[] point3Arr = new Point3[i5];
        if (i5 != 0) {
            float[] fArr = new float[i5 * 3];
            get(0, 0, fArr);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 3;
                point3Arr[i6] = new Point3(fArr[i7], fArr[i7 + 1], fArr[i7 + 2]);
            }
        }
        return point3Arr;
    }

    public List<Point3> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint3f(long j6) {
        super(j6);
        if (!empty() && checkVector(3, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3f(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(3, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3f(Point3... point3Arr) {
        fromArray(point3Arr);
    }
}
