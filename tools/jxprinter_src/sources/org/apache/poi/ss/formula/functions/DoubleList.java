package org.apache.poi.ss.formula.functions;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class DoubleList {
    static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    private double[] _array = new double[8];
    private int _count = 0;

    private void ensureCapacity(int i5) {
        double[] dArr = this._array;
        if (i5 > dArr.length) {
            this._array = Arrays.copyOf(dArr, (i5 * 3) / 2);
        }
    }

    public void add(double d) {
        ensureCapacity(this._count + 1);
        double[] dArr = this._array;
        int i5 = this._count;
        dArr[i5] = d;
        this._count = i5 + 1;
    }

    public int getLength() {
        return this._count;
    }

    public double[] toArray() {
        int i5 = this._count;
        return i5 < 1 ? EMPTY_DOUBLE_ARRAY : Arrays.copyOf(this._array, i5);
    }
}
