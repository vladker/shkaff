package org.apache.commons.math3.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Combinations implements Iterable<int[]> {
    private final IterationOrder iterationOrder;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f6934k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f6935n;

    /* JADX INFO: renamed from: org.apache.commons.math3.util.Combinations$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder;

        static {
            int[] iArr = new int[IterationOrder.values().length];
            $SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder = iArr;
            try {
                iArr[IterationOrder.LEXICOGRAPHIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum IterationOrder {
        LEXICOGRAPHIC
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LexicographicComparator implements Comparator<int[]>, Serializable {
        private static final long serialVersionUID = 20130906;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f6936k;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f6937n;

        public LexicographicComparator(int i5, int i6) {
            this.f6937n = i5;
            this.f6936k = i6;
        }

        private long lexNorm(int[] iArr) {
            int i5;
            long jPow = 0;
            for (int i6 = 0; i6 < iArr.length; i6++) {
                int i7 = iArr[i6];
                if (i7 < 0 || i7 >= (i5 = this.f6937n)) {
                    throw new OutOfRangeException(Integer.valueOf(i7), 0, Integer.valueOf(this.f6937n - 1));
                }
                jPow += (long) (ArithmeticUtils.pow(i5, i6) * i7);
            }
            return jPow;
        }

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int length = iArr.length;
            int i5 = this.f6936k;
            if (length != i5) {
                throw new DimensionMismatchException(iArr.length, this.f6936k);
            }
            if (iArr2.length != i5) {
                throw new DimensionMismatchException(iArr2.length, this.f6936k);
            }
            int[] iArrCopyOf = MathArrays.copyOf(iArr);
            Arrays.sort(iArrCopyOf);
            int[] iArrCopyOf2 = MathArrays.copyOf(iArr2);
            Arrays.sort(iArrCopyOf2);
            long jLexNorm = lexNorm(iArrCopyOf);
            long jLexNorm2 = lexNorm(iArrCopyOf2);
            if (jLexNorm < jLexNorm2) {
                return -1;
            }
            return jLexNorm > jLexNorm2 ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LexicographicIterator implements Iterator<int[]> {
        private final int[] c;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f6938j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f6939k;
        private boolean more;

        public LexicographicIterator(int i5, int i6) {
            this.more = true;
            this.f6939k = i6;
            this.c = new int[i6 + 3];
            if (i6 == 0 || i6 >= i5) {
                this.more = false;
                return;
            }
            for (int i7 = 1; i7 <= i6; i7++) {
                this.c[i7] = i7 - 1;
            }
            int[] iArr = this.c;
            iArr[i6 + 1] = i5;
            iArr[i6 + 2] = 0;
            this.f6938j = i6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.more;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public int[] next() {
            if (!this.more) {
                throw new NoSuchElementException();
            }
            int i5 = this.f6939k;
            int[] iArr = new int[i5];
            System.arraycopy(this.c, 1, iArr, 0, i5);
            int i6 = this.f6938j;
            if (i6 > 0) {
                this.c[i6] = i6;
                this.f6938j = i6 - 1;
                return iArr;
            }
            int[] iArr2 = this.c;
            int i7 = iArr2[1];
            if (i7 + 1 < iArr2[2]) {
                iArr2[1] = i7 + 1;
                return iArr;
            }
            this.f6938j = 2;
            boolean z6 = false;
            int i8 = 0;
            while (!z6) {
                int[] iArr3 = this.c;
                int i9 = this.f6938j;
                iArr3[i9 - 1] = i9 - 2;
                int i10 = iArr3[i9] + 1;
                if (i10 == iArr3[i9 + 1]) {
                    this.f6938j = i9 + 1;
                } else {
                    z6 = true;
                }
                i8 = i10;
            }
            int i11 = this.f6938j;
            if (i11 > this.f6939k) {
                this.more = false;
                return iArr;
            }
            this.c[i11] = i8;
            this.f6938j = i11 - 1;
            return iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SingletonIterator implements Iterator<int[]> {
        private boolean more = true;
        private final int[] singleton;

        public SingletonIterator(int[] iArr) {
            this.singleton = iArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.more;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public int[] next() {
            if (!this.more) {
                throw new NoSuchElementException();
            }
            this.more = false;
            return this.singleton;
        }
    }

    public Combinations(int i5, int i6) {
        this(i5, i6, IterationOrder.LEXICOGRAPHIC);
    }

    public Comparator<int[]> comparator() {
        return new LexicographicComparator(this.f6935n, this.f6934k);
    }

    public int getK() {
        return this.f6934k;
    }

    public int getN() {
        return this.f6935n;
    }

    @Override // java.lang.Iterable
    public Iterator<int[]> iterator() {
        int i5 = this.f6934k;
        if (i5 == 0 || i5 == this.f6935n) {
            return new SingletonIterator(MathArrays.natural(i5));
        }
        if (AnonymousClass1.$SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder[this.iterationOrder.ordinal()] == 1) {
            return new LexicographicIterator(this.f6935n, this.f6934k);
        }
        throw new MathInternalError();
    }

    private Combinations(int i5, int i6, IterationOrder iterationOrder) {
        CombinatoricsUtils.checkBinomial(i5, i6);
        this.f6935n = i5;
        this.f6934k = i6;
        this.iterationOrder = iterationOrder;
    }
}
