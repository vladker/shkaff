package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfRect extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 4;

    public MatOfRect() {
    }

    public static MatOfRect fromNativeAddr(long j6) {
        return new MatOfRect(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(4, 4));
        }
    }

    public void fromArray(Rect... rectArr) {
        if (rectArr == null || rectArr.length == 0) {
            return;
        }
        int length = rectArr.length;
        alloc(length);
        int[] iArr = new int[length * 4];
        for (int i5 = 0; i5 < length; i5++) {
            Rect rect = rectArr[i5];
            int i6 = i5 * 4;
            iArr[i6] = rect.f7686x;
            iArr[i6 + 1] = rect.f7687y;
            iArr[i6 + 2] = rect.width;
            iArr[i6 + 3] = rect.height;
        }
        put(0, 0, iArr);
    }

    public void fromList(List<Rect> list) {
        fromArray((Rect[]) list.toArray(new Rect[0]));
    }

    public Rect[] toArray() {
        int i5 = (int) total();
        Rect[] rectArr = new Rect[i5];
        if (i5 != 0) {
            int[] iArr = new int[i5 * 4];
            get(0, 0, iArr);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 4;
                rectArr[i6] = new Rect(iArr[i7], iArr[i7 + 1], iArr[i7 + 2], iArr[i7 + 3]);
            }
        }
        return rectArr;
    }

    public List<Rect> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRect(long j6) {
        super(j6);
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect(Rect... rectArr) {
        fromArray(rectArr);
    }
}
