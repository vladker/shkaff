package org.apache.commons.math3.util;

import java.util.NoSuchElementException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultidimensionalCounter implements Iterable<Integer> {
    private final int dimension;
    private final int last;
    private final int[] size;
    private final int totalSize;
    private final int[] uniCounterOffset;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Iterator implements java.util.Iterator<Integer> {
        private int count;
        private final int[] counter;
        private final int maxCount;

        public Iterator() {
            int[] iArr = new int[MultidimensionalCounter.this.dimension];
            this.counter = iArr;
            this.count = -1;
            this.maxCount = MultidimensionalCounter.this.totalSize - 1;
            iArr[MultidimensionalCounter.this.last] = -1;
        }

        public int getCount() {
            return this.count;
        }

        public int[] getCounts() {
            return MathArrays.copyOf(this.counter);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.count < this.maxCount;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public int getCount(int i5) {
            return this.counter[i5];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            for (int i5 = MultidimensionalCounter.this.last; i5 >= 0; i5--) {
                if (this.counter[i5] != MultidimensionalCounter.this.size[i5] - 1) {
                    int[] iArr = this.counter;
                    iArr[i5] = iArr[i5] + 1;
                    break;
                }
                this.counter[i5] = 0;
            }
            int i6 = this.count + 1;
            this.count = i6;
            return Integer.valueOf(i6);
        }
    }

    public MultidimensionalCounter(int... iArr) {
        int i5;
        int length = iArr.length;
        this.dimension = length;
        this.size = MathArrays.copyOf(iArr);
        this.uniCounterOffset = new int[length];
        int i6 = length - 1;
        this.last = i6;
        int i7 = iArr[i6];
        int i8 = 0;
        while (true) {
            i5 = this.last;
            if (i8 >= i5) {
                break;
            }
            int i9 = i8 + 1;
            int i10 = 1;
            for (int i11 = i9; i11 < this.dimension; i11++) {
                i10 *= iArr[i11];
            }
            this.uniCounterOffset[i8] = i10;
            i7 *= iArr[i8];
            i8 = i9;
        }
        this.uniCounterOffset[i5] = 0;
        if (i7 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i7));
        }
        this.totalSize = i7;
    }

    public int getCount(int... iArr) {
        if (iArr.length != this.dimension) {
            throw new DimensionMismatchException(iArr.length, this.dimension);
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.dimension; i6++) {
            int i7 = iArr[i6];
            if (i7 < 0 || i7 >= this.size[i6]) {
                throw new OutOfRangeException(Integer.valueOf(i7), 0, Integer.valueOf(this.size[i6] - 1));
            }
            i5 += this.uniCounterOffset[i6] * i7;
        }
        return i5 + iArr[this.last];
    }

    public int[] getCounts(int i5) {
        if (i5 < 0 || i5 >= this.totalSize) {
            throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(this.totalSize));
        }
        int[] iArr = new int[this.dimension];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = this.last;
            if (i6 >= i8) {
                iArr[i8] = i5 - i7;
                return iArr;
            }
            int i9 = this.uniCounterOffset[i6];
            int i10 = 0;
            while (i7 <= i5) {
                i7 += i9;
                i10++;
            }
            i7 -= i9;
            iArr[i6] = i10 - 1;
            i6++;
        }
    }

    public int getDimension() {
        return this.dimension;
    }

    public int getSize() {
        return this.totalSize;
    }

    public int[] getSizes() {
        return MathArrays.copyOf(this.size);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < this.dimension; i5++) {
            sb.append("[");
            sb.append(getCount(i5));
            sb.append("]");
        }
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<Integer> iterator() {
        return new Iterator();
    }
}
