package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfKeyPoint extends Mat {
    private static final int _channels = 7;
    private static final int _depth = 5;

    public MatOfKeyPoint() {
    }

    public static MatOfKeyPoint fromNativeAddr(long j6) {
        return new MatOfKeyPoint(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(5, 7));
        }
    }

    public void fromArray(KeyPoint... keyPointArr) {
        if (keyPointArr == null || keyPointArr.length == 0) {
            return;
        }
        int length = keyPointArr.length;
        alloc(length);
        float[] fArr = new float[length * 7];
        for (int i5 = 0; i5 < length; i5++) {
            KeyPoint keyPoint = keyPointArr[i5];
            int i6 = i5 * 7;
            Point point = keyPoint.pt;
            fArr[i6] = (float) point.f7681x;
            fArr[i6 + 1] = (float) point.f7682y;
            fArr[i6 + 2] = keyPoint.size;
            fArr[i6 + 3] = keyPoint.angle;
            fArr[i6 + 4] = keyPoint.response;
            fArr[i6 + 5] = keyPoint.octave;
            fArr[i6 + 6] = keyPoint.class_id;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<KeyPoint> list) {
        fromArray((KeyPoint[]) list.toArray(new KeyPoint[0]));
    }

    public KeyPoint[] toArray() {
        int i5 = (int) total();
        KeyPoint[] keyPointArr = new KeyPoint[i5];
        if (i5 != 0) {
            float[] fArr = new float[i5 * 7];
            get(0, 0, fArr);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 7;
                keyPointArr[i6] = new KeyPoint(fArr[i7], fArr[i7 + 1], fArr[i7 + 2], fArr[i7 + 3], fArr[i7 + 4], (int) fArr[i7 + 5], (int) fArr[i7 + 6]);
            }
        }
        return keyPointArr;
    }

    public List<KeyPoint> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfKeyPoint(long j6) {
        super(j6);
        if (!empty() && checkVector(7, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfKeyPoint(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(7, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfKeyPoint(KeyPoint... keyPointArr) {
        fromArray(keyPointArr);
    }
}
