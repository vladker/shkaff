package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfRect2d extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 6;

    public MatOfRect2d() {
    }

    public static MatOfRect2d fromNativeAddr(long j6) {
        return new MatOfRect2d(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(6, 4));
        }
    }

    public void fromArray(Rect2d... rect2dArr) {
        if (rect2dArr == null || rect2dArr.length == 0) {
            return;
        }
        int length = rect2dArr.length;
        alloc(length);
        double[] dArr = new double[length * 4];
        for (int i5 = 0; i5 < length; i5++) {
            Rect2d rect2d = rect2dArr[i5];
            int i6 = i5 * 4;
            dArr[i6] = rect2d.f7688x;
            dArr[i6 + 1] = rect2d.f7689y;
            dArr[i6 + 2] = rect2d.width;
            dArr[i6 + 3] = rect2d.height;
        }
        put(0, 0, dArr);
    }

    public void fromList(List<Rect2d> list) {
        fromArray((Rect2d[]) list.toArray(new Rect2d[0]));
    }

    public Rect2d[] toArray() {
        int i5 = (int) total();
        Rect2d[] rect2dArr = new Rect2d[i5];
        if (i5 != 0) {
            double[] dArr = new double[i5 * 4];
            get(0, 0, dArr);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 4;
                rect2dArr[i6] = new Rect2d(dArr[i7], dArr[i7 + 1], dArr[i7 + 2], dArr[i7 + 3]);
            }
        }
        return rect2dArr;
    }

    public List<Rect2d> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRect2d(long j6) {
        super(j6);
        if (!empty() && checkVector(4, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect2d(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect2d(Rect2d... rect2dArr) {
        fromArray(rect2dArr);
    }
}
