package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfDouble extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 6;

    public MatOfDouble() {
    }

    public static MatOfDouble fromNativeAddr(long j6) {
        return new MatOfDouble(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(6, 1));
        }
    }

    public void fromArray(double... dArr) {
        if (dArr == null || dArr.length == 0) {
            return;
        }
        alloc(dArr.length);
        put(0, 0, dArr);
    }

    public void fromList(List<Double> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Double[] dArr = (Double[]) list.toArray(new Double[0]);
        double[] dArr2 = new double[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr2[i5] = dArr[i5].doubleValue();
        }
        fromArray(dArr2);
    }

    public double[] toArray() {
        int iCheckVector = checkVector(1, 6);
        if (iCheckVector < 0) {
            throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
        }
        double[] dArr = new double[iCheckVector];
        if (iCheckVector == 0) {
            return dArr;
        }
        get(0, 0, dArr);
        return dArr;
    }

    public List<Double> toList() {
        double[] array = toArray();
        Double[] dArr = new Double[array.length];
        for (int i5 = 0; i5 < array.length; i5++) {
            dArr[i5] = Double.valueOf(array[i5]);
        }
        return Arrays.asList(dArr);
    }

    public MatOfDouble(long j6) {
        super(j6);
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfDouble(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfDouble(double... dArr) {
        fromArray(dArr);
    }
}
