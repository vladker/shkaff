package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfRotatedRect extends Mat {
    private static final int _channels = 5;
    private static final int _depth = 5;

    public MatOfRotatedRect() {
    }

    public static MatOfRotatedRect fromNativeAddr(long j6) {
        return new MatOfRotatedRect(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(5, 5));
        }
    }

    public void fromArray(RotatedRect... rotatedRectArr) {
        if (rotatedRectArr == null || rotatedRectArr.length == 0) {
            return;
        }
        int length = rotatedRectArr.length;
        alloc(length);
        float[] fArr = new float[length * 5];
        for (int i5 = 0; i5 < length; i5++) {
            RotatedRect rotatedRect = rotatedRectArr[i5];
            int i6 = i5 * 5;
            Point point = rotatedRect.center;
            fArr[i6] = (float) point.f7681x;
            fArr[i6 + 1] = (float) point.f7682y;
            Size size = rotatedRect.size;
            fArr[i6 + 2] = (float) size.width;
            fArr[i6 + 3] = (float) size.height;
            fArr[i6 + 4] = (float) rotatedRect.angle;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<RotatedRect> list) {
        fromArray((RotatedRect[]) list.toArray(new RotatedRect[0]));
    }

    public RotatedRect[] toArray() {
        int i5 = (int) total();
        RotatedRect[] rotatedRectArr = new RotatedRect[i5];
        if (i5 != 0) {
            float[] fArr = new float[5];
            for (int i6 = 0; i6 < i5; i6++) {
                get(i6, 0, fArr);
                rotatedRectArr[i6] = new RotatedRect(new Point(fArr[0], fArr[1]), new Size(fArr[2], fArr[3]), fArr[4]);
            }
        }
        return rotatedRectArr;
    }

    public List<RotatedRect> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRotatedRect(long j6) {
        super(j6);
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRotatedRect(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRotatedRect(RotatedRect... rotatedRectArr) {
        fromArray(rotatedRectArr);
    }
}
