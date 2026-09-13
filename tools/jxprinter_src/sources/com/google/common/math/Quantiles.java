package com.google.common.math;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class Quantiles {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Scale {
        private final int scale;

        public ScaleAndIndex index(int i5) {
            return new ScaleAndIndex(this.scale, i5);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone());
        }

        private Scale(int i5) {
            Preconditions.checkArgument(i5 > 0, "Quantile scale must be positive");
            this.scale = i5;
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.index) * ((long) (dArr.length - 1));
            int iDivide = (int) LongMath.divide(length, this.scale, RoundingMode.DOWN);
            int i5 = (int) (length - (((long) iDivide) * ((long) this.scale)));
            Quantiles.selectInPlace(iDivide, dArr, 0, dArr.length - 1);
            if (i5 == 0) {
                return dArr[iDivide];
            }
            int i6 = iDivide + 1;
            Quantiles.selectInPlace(i6, dArr, i6, dArr.length - 1);
            return Quantiles.interpolate(dArr[iDivide], dArr[i6], i5, this.scale);
        }

        private ScaleAndIndex(int i5, int i6) {
            Quantiles.checkIndex(i6, i5);
            this.scale = i5;
            this.index = i6;
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            int i5 = 0;
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (i5 < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i5]), Double.valueOf(Double.NaN));
                    i5++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr6 = this.indexes;
                if (i6 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i6]) * ((long) (dArr.length - 1));
                int iDivide = (int) LongMath.divide(length2, this.scale, RoundingMode.DOWN);
                int i8 = (int) (length2 - (((long) iDivide) * ((long) this.scale)));
                iArr3[i6] = iDivide;
                iArr4[i6] = i8;
                iArr5[i7] = iDivide;
                int i9 = i7 + 1;
                if (i8 != 0) {
                    iArr5[i9] = iDivide + 1;
                    i7 += 2;
                } else {
                    i7 = i9;
                }
                i6++;
            }
            Arrays.sort(iArr5, 0, i7);
            Quantiles.selectAllInPlace(iArr5, 0, i7 - 1, dArr, 0, dArr.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr7 = this.indexes;
                if (i5 >= iArr7.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i10 = iArr3[i5];
                int i11 = iArr4[i5];
                if (i11 == 0) {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i5]), Double.valueOf(dArr[i10]));
                } else {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i5]), Double.valueOf(Quantiles.interpolate(dArr[i10], dArr[i10 + 1], i11, this.scale)));
                }
                i5++;
            }
        }

        private ScaleAndIndexes(int i5, int[] iArr) {
            for (int i6 : iArr) {
                Quantiles.checkIndex(i6, i5);
            }
            Preconditions.checkArgument(iArr.length > 0, "Indexes must be a non empty array");
            this.scale = i5;
            this.indexes = iArr;
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkIndex(int i5, int i6) {
        if (i5 < 0 || i5 > i6) {
            throw new IllegalArgumentException(a.h(70, i6, "Quantile indexes must be between 0 and the scale, which is "));
        }
    }

    private static int chooseNextSelection(int[] iArr, int i5, int i6, int i7, int i8) {
        if (i5 == i6) {
            return i5;
        }
        int i9 = i7 + i8;
        int i10 = i9 >>> 1;
        while (i6 > i5 + 1) {
            int i11 = (i5 + i6) >>> 1;
            int i12 = iArr[i11];
            if (i12 > i10) {
                i6 = i11;
            } else {
                if (i12 >= i10) {
                    return i11;
                }
                i5 = i11;
            }
        }
        return (i9 - iArr[i5]) - iArr[i6] > 0 ? i6 : i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsNaN(double... dArr) {
        for (double d : dArr) {
            if (Double.isNaN(d)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double interpolate(double d, double d6, double d7, double d8) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d6 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d6 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return (((d6 - d) * d7) / d8) + d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = iArr[i5];
        }
        return dArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = jArr[i5];
        }
        return dArr;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    private static void movePivotToStartOfSlice(double[] dArr, int i5, int i6) {
        int i7 = (i5 + i6) >>> 1;
        double d = dArr[i6];
        double d6 = dArr[i7];
        boolean z6 = d < d6;
        double d7 = dArr[i5];
        boolean z7 = d6 < d7;
        boolean z8 = d < d7;
        if (z6 == z7) {
            swap(dArr, i7, i5);
        } else if (z6 != z8) {
            swap(dArr, i5, i6);
        }
    }

    private static int partition(double[] dArr, int i5, int i6) {
        movePivotToStartOfSlice(dArr, i5, i6);
        double d = dArr[i5];
        int i7 = i6;
        while (i6 > i5) {
            if (dArr[i6] > d) {
                swap(dArr, i7, i6);
                i7--;
            }
            i6--;
        }
        swap(dArr, i5, i7);
        return i7;
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i5) {
        return new Scale(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectAllInPlace(int[] iArr, int i5, int i6, double[] dArr, int i7, int i8) {
        int iChooseNextSelection = chooseNextSelection(iArr, i5, i6, i7, i8);
        int i9 = iArr[iChooseNextSelection];
        selectInPlace(i9, dArr, i7, i8);
        int i10 = iChooseNextSelection - 1;
        while (i10 >= i5 && iArr[i10] == i9) {
            i10--;
        }
        if (i10 >= i5) {
            selectAllInPlace(iArr, i5, i10, dArr, i7, i9 - 1);
        }
        int i11 = iChooseNextSelection + 1;
        while (i11 <= i6 && iArr[i11] == i9) {
            i11++;
        }
        if (i11 <= i6) {
            selectAllInPlace(iArr, i11, i6, dArr, i9 + 1, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectInPlace(int i5, double[] dArr, int i6, int i7) {
        if (i5 != i6) {
            while (i7 > i6) {
                int iPartition = partition(dArr, i6, i7);
                if (iPartition >= i5) {
                    i7 = iPartition - 1;
                }
                if (iPartition <= i5) {
                    i6 = iPartition + 1;
                }
            }
            return;
        }
        int i8 = i6;
        for (int i9 = i6 + 1; i9 <= i7; i9++) {
            if (dArr[i8] > dArr[i9]) {
                i8 = i9;
            }
        }
        if (i8 != i6) {
            swap(dArr, i8, i6);
        }
    }

    private static void swap(double[] dArr, int i5, int i6) {
        double d = dArr[i5];
        dArr[i5] = dArr[i6];
        dArr[i6] = d;
    }
}
