package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfInt4 extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 4;

    public MatOfInt4() {
    }

    public static MatOfInt4 fromNativeAddr(long j6) {
        return new MatOfInt4(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(4, 4));
        }
    }

    public void fromArray(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        alloc(iArr.length / 4);
        put(0, 0, iArr);
    }

    public void fromList(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Integer[] numArr = (Integer[]) list.toArray(new Integer[0]);
        int[] iArr = new int[numArr.length];
        for (int i5 = 0; i5 < numArr.length; i5++) {
            iArr[i5] = numArr[i5].intValue();
        }
        fromArray(iArr);
    }

    public int[] toArray() {
        int iCheckVector = checkVector(4, 4);
        if (iCheckVector < 0) {
            throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
        }
        int[] iArr = new int[iCheckVector * 4];
        if (iCheckVector == 0) {
            return iArr;
        }
        get(0, 0, iArr);
        return iArr;
    }

    public List<Integer> toList() {
        int[] array = toArray();
        Integer[] numArr = new Integer[array.length];
        for (int i5 = 0; i5 < array.length; i5++) {
            numArr[i5] = Integer.valueOf(array[i5]);
        }
        return Arrays.asList(numArr);
    }

    public MatOfInt4(long j6) {
        super(j6);
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfInt4(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfInt4(int... iArr) {
        fromArray(iArr);
    }
}
