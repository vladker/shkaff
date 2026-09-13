package org.apache.commons.math3.util;

import androidx.collection.a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MathArrays {

    /* JADX INFO: renamed from: org.apache.commons.math3.util.MathArrays$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$MathArrays$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$org$apache$commons$math3$util$MathArrays$Position = iArr;
            try {
                iArr[Position.TAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$util$MathArrays$Position[Position.HEAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[OrderDirection.values().length];
            $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection = iArr2;
            try {
                iArr2[OrderDirection.INCREASING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection[OrderDirection.DECREASING.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Function {
        double evaluate(double[] dArr);

        double evaluate(double[] dArr, int i5, int i6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum OrderDirection {
        INCREASING,
        DECREASING
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PairDoubleInteger {
        private final double key;
        private final int value;

        public PairDoubleInteger(double d, int i5) {
            this.key = d;
            this.value = i5;
        }

        public double getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Position {
        HEAD,
        TAIL
    }

    private MathArrays() {
    }

    public static <T> T[] buildArray(Field<T> field, int i5) {
        T[] tArr = (T[]) ((Object[]) Array.newInstance(field.getRuntimeClass(), i5));
        Arrays.fill(tArr, field.getZero());
        return tArr;
    }

    public static boolean checkEqualLength(double[] dArr, double[] dArr2, boolean z6) {
        if (dArr.length == dArr2.length) {
            return true;
        }
        if (z6) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        return false;
    }

    public static void checkNonNegative(long[] jArr) {
        for (int i5 = 0; i5 < jArr.length; i5++) {
            if (jArr[i5] < 0) {
                throw new NotPositiveException(Long.valueOf(jArr[i5]));
            }
        }
    }

    public static void checkNotNaN(double[] dArr) {
        for (double d : dArr) {
            if (Double.isNaN(d)) {
                throw new NotANumberException();
            }
        }
    }

    public static boolean checkOrder(double[] dArr, OrderDirection orderDirection, boolean z6, boolean z7) {
        double d = dArr[0];
        int length = dArr.length;
        int i5 = 1;
        while (i5 < length) {
            int i6 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection[orderDirection.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new MathInternalError();
                }
                if (z6) {
                    if (dArr[i5] >= d) {
                        break;
                    }
                    d = dArr[i5];
                    i5++;
                } else {
                    if (dArr[i5] > d) {
                        break;
                    }
                    d = dArr[i5];
                    i5++;
                }
            } else if (z6) {
                if (dArr[i5] <= d) {
                    break;
                }
                d = dArr[i5];
                i5++;
            } else {
                if (dArr[i5] < d) {
                    break;
                }
                d = dArr[i5];
                i5++;
            }
        }
        if (i5 == length) {
            return true;
        }
        if (z7) {
            throw new NonMonotonicSequenceException(Double.valueOf(dArr[i5]), Double.valueOf(d), i5, orderDirection, z6);
        }
        return false;
    }

    public static void checkPositive(double[] dArr) {
        for (int i5 = 0; i5 < dArr.length; i5++) {
            if (dArr[i5] <= 0.0d) {
                throw new NotStrictlyPositiveException(Double.valueOf(dArr[i5]));
            }
        }
    }

    public static void checkRectangular(long[][] jArr) {
        MathUtils.checkNotNull(jArr);
        for (int i5 = 1; i5 < jArr.length; i5++) {
            if (jArr[i5].length != jArr[0].length) {
                throw new DimensionMismatchException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, jArr[i5].length, jArr[0].length);
            }
        }
    }

    public static double[] concatenate(double[]... dArr) {
        int length = 0;
        for (double[] dArr2 : dArr) {
            length += dArr2.length;
        }
        double[] dArr3 = new double[length];
        int i5 = 0;
        for (double[] dArr4 : dArr) {
            int length2 = dArr4.length;
            System.arraycopy(dArr4, 0, dArr3, i5, length2);
            i5 += length2;
        }
        return dArr3;
    }

    public static double[] convolve(double[] dArr, double[] dArr2) {
        MathUtils.checkNotNull(dArr);
        MathUtils.checkNotNull(dArr2);
        int length = dArr.length;
        int length2 = dArr2.length;
        if (length == 0 || length2 == 0) {
            throw new NoDataException();
        }
        int i5 = (length + length2) - 1;
        double[] dArr3 = new double[i5];
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i6 + 1;
            int iMax = FastMath.max(0, i7 - length);
            double d = 0.0d;
            for (int i8 = i6 - iMax; iMax < length2 && i8 >= 0; i8--) {
                d += dArr[i8] * dArr2[iMax];
                iMax++;
            }
            dArr3[i6] = d;
            i6 = i7;
        }
        return dArr3;
    }

    public static int[] copyOf(int[] iArr) {
        return copyOf(iArr, iArr.length);
    }

    public static double[] copyOfRange(double[] dArr, int i5, int i6) {
        int i7 = i6 - i5;
        double[] dArr2 = new double[i7];
        System.arraycopy(dArr, i5, dArr2, 0, FastMath.min(i7, dArr.length - i5));
        return dArr2;
    }

    public static double cosAngle(double[] dArr, double[] dArr2) {
        return linearCombination(dArr, dArr2) / (safeNorm(dArr2) * safeNorm(dArr));
    }

    public static double distance(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2);
        double d = 0.0d;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double d6 = dArr[i5] - dArr2[i5];
            d += d6 * d6;
        }
        return FastMath.sqrt(d);
    }

    public static double distance1(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2);
        double dAbs = 0.0d;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dAbs += FastMath.abs(dArr[i5] - dArr2[i5]);
        }
        return dAbs;
    }

    public static double distanceInf(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2);
        double dMax = 0.0d;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dMax = FastMath.max(dMax, FastMath.abs(dArr[i5] - dArr2[i5]));
        }
        return dMax;
    }

    public static double[] ebeAdd(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2);
        double[] dArr3 = (double[]) dArr.clone();
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr3[i5] = dArr3[i5] + dArr2[i5];
        }
        return dArr3;
    }

    public static double[] ebeDivide(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2);
        double[] dArr3 = (double[]) dArr.clone();
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr3[i5] = dArr3[i5] / dArr2[i5];
        }
        return dArr3;
    }

    public static double[] ebeMultiply(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2);
        double[] dArr3 = (double[]) dArr.clone();
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr3[i5] = dArr3[i5] * dArr2[i5];
        }
        return dArr3;
    }

    public static double[] ebeSubtract(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2);
        double[] dArr3 = (double[]) dArr.clone();
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr3[i5] = dArr3[i5] - dArr2[i5];
        }
        return dArr3;
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr2 == null) {
            return !((fArr == null) ^ (fArr2 == null));
        }
        if (fArr.length != fArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < fArr.length; i5++) {
            if (!Precision.equals(fArr[i5], fArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIncludingNaN(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr2 == null) {
            return !((fArr == null) ^ (fArr2 == null));
        }
        if (fArr.length != fArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < fArr.length; i5++) {
            if (!Precision.equalsIncludingNaN(fArr[i5], fArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<? super T>> boolean isMonotonic(T[] tArr, OrderDirection orderDirection, boolean z6) {
        T t6 = tArr[0];
        int length = tArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            int i6 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection[orderDirection.ordinal()];
            if (i6 == 1) {
                int iCompareTo = t6.compareTo(tArr[i5]);
                if (z6) {
                    if (iCompareTo >= 0) {
                        return false;
                    }
                } else if (iCompareTo > 0) {
                    return false;
                }
            } else {
                if (i6 != 2) {
                    throw new MathInternalError();
                }
                int iCompareTo2 = tArr[i5].compareTo(t6);
                if (z6) {
                    if (iCompareTo2 >= 0) {
                        return false;
                    }
                } else if (iCompareTo2 > 0) {
                    return false;
                }
            }
            t6 = tArr[i5];
        }
        return true;
    }

    public static double linearCombination(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2);
        int length = dArr.length;
        int i5 = 1;
        if (length == 1) {
            return dArr[0] * dArr2[0];
        }
        double[] dArr3 = new double[length];
        double d = 0.0d;
        double d6 = 0.0d;
        for (int i6 = 0; i6 < length; i6++) {
            double d7 = dArr[i6];
            double dLongBitsToDouble = Double.longBitsToDouble(Double.doubleToRawLongBits(d7) & (-134217728));
            double d8 = d7 - dLongBitsToDouble;
            double d9 = dArr2[i6];
            double dLongBitsToDouble2 = Double.longBitsToDouble(Double.doubleToRawLongBits(d9) & (-134217728));
            double d10 = d9 - dLongBitsToDouble2;
            double d11 = d7 * d9;
            dArr3[i6] = d11;
            d6 = ((d8 * d10) - (((d11 - (dLongBitsToDouble * dLongBitsToDouble2)) - (d8 * dLongBitsToDouble2)) - (dLongBitsToDouble * d10))) + d6;
        }
        double d12 = dArr3[0];
        double d13 = dArr3[1];
        double d14 = d12 + d13;
        double d15 = d14 - d13;
        double d16 = (d12 - d15) + (d13 - (d14 - d15));
        int i7 = length - 1;
        while (i5 < i7) {
            i5++;
            double d17 = dArr3[i5];
            double d18 = d14 + d17;
            double d19 = d18 - d17;
            d16 += (d14 - d19) + (d17 - (d18 - d19));
            d14 = d18;
        }
        double d20 = d6 + d16 + d14;
        if (!Double.isNaN(d20)) {
            return d20;
        }
        for (int i8 = 0; i8 < length; i8++) {
            d += dArr[i8] * dArr2[i8];
        }
        return d;
    }

    public static int[] natural(int i5) {
        return sequence(i5, 0, 1);
    }

    public static double[] normalizeArray(double[] dArr, double d) {
        if (Double.isInfinite(d)) {
            throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_INFINITE, new Object[0]);
        }
        if (Double.isNaN(d)) {
            throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_NAN, new Object[0]);
        }
        int length = dArr.length;
        double[] dArr2 = new double[length];
        double d6 = 0.0d;
        for (int i5 = 0; i5 < length; i5++) {
            if (Double.isInfinite(dArr[i5])) {
                throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, Double.valueOf(dArr[i5]), Integer.valueOf(i5));
            }
            if (!Double.isNaN(dArr[i5])) {
                d6 += dArr[i5];
            }
        }
        if (d6 == 0.0d) {
            throw new MathArithmeticException(LocalizedFormats.ARRAY_SUMS_TO_ZERO, new Object[0]);
        }
        for (int i6 = 0; i6 < length; i6++) {
            if (Double.isNaN(dArr[i6])) {
                dArr2[i6] = Double.NaN;
            } else {
                dArr2[i6] = (dArr[i6] * d) / d6;
            }
        }
        return dArr2;
    }

    public static double safeNorm(double[] dArr) {
        double length = 1.304E19d / ((double) dArr.length);
        double dC = 0.0d;
        double d = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        double dC2 = 0.0d;
        for (double d8 : dArr) {
            double dAbs = FastMath.abs(d8);
            if (dAbs >= 3.834E-20d && dAbs <= length) {
                d6 = (dAbs * dAbs) + d6;
            } else if (dAbs > 3.834E-20d) {
                if (dAbs > d) {
                    double d9 = d / dAbs;
                    dC = a.C(dC, d9, d9, 1.0d);
                    d = dAbs;
                } else {
                    double d10 = dAbs / d;
                    dC = (d10 * d10) + dC;
                }
            } else if (dAbs > d7) {
                double d11 = d7 / dAbs;
                dC2 = a.C(dC2, d11, d11, 1.0d);
                d7 = dAbs;
            } else if (dAbs != 0.0d) {
                double d12 = dAbs / d7;
                dC2 = (d12 * d12) + dC2;
            }
        }
        if (dC != 0.0d) {
            return Math.sqrt(((d6 / d) / d) + dC) * d;
        }
        if (d6 == 0.0d) {
            return Math.sqrt(dC2) * d7;
        }
        if (d6 < d7) {
            return Math.sqrt(a.B(d7, dC2, d6 / d7, d7));
        }
        return Math.sqrt(((d7 * dC2 * (d7 / d6)) + 1.0d) * d6);
    }

    public static double[] scale(double d, double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr2[i5] = dArr[i5] * d;
        }
        return dArr2;
    }

    public static void scaleInPlace(double d, double[] dArr) {
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr[i5] = dArr[i5] * d;
        }
    }

    public static int[] sequence(int i5, int i6, int i7) {
        int[] iArr = new int[i5];
        for (int i8 = 0; i8 < i5; i8++) {
            iArr[i8] = (i8 * i7) + i6;
        }
        return iArr;
    }

    public static void shuffle(int[] iArr, int i5, Position position) {
        shuffle(iArr, i5, position, new Well19937c());
    }

    public static void sortInPlace(double[] dArr, double[]... dArr2) {
        sortInPlace(dArr, OrderDirection.INCREASING, dArr2);
    }

    public static double[] unique(double[] dArr) {
        TreeSet treeSet = new TreeSet();
        int i5 = 0;
        for (double d : dArr) {
            treeSet.add(Double.valueOf(d));
        }
        int size = treeSet.size();
        double[] dArr2 = new double[size];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            i5++;
            dArr2[size - i5] = ((Double) it.next()).doubleValue();
        }
        return dArr2;
    }

    public static boolean verifyValues(double[] dArr, int i5, int i6) {
        return verifyValues(dArr, i5, i6, false);
    }

    public static double[] copyOf(double[] dArr) {
        return copyOf(dArr, dArr.length);
    }

    public static void shuffle(int[] iArr, int i5, Position position, RandomGenerator randomGenerator) {
        int i6 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$util$MathArrays$Position[position.ordinal()];
        if (i6 == 1) {
            int length = iArr.length - 1;
            while (length >= i5) {
                int iSample = length == i5 ? i5 : new UniformIntegerDistribution(randomGenerator, i5, length).sample();
                int i7 = iArr[iSample];
                iArr[iSample] = iArr[length];
                iArr[length] = i7;
                length--;
            }
            return;
        }
        if (i6 != 2) {
            throw new MathInternalError();
        }
        int i8 = 0;
        while (i8 <= i5) {
            int iSample2 = i8 == i5 ? i5 : new UniformIntegerDistribution(randomGenerator, i8, i5).sample();
            int i9 = iArr[iSample2];
            iArr[iSample2] = iArr[i8];
            iArr[i8] = i9;
            i8++;
        }
    }

    public static void sortInPlace(double[] dArr, OrderDirection orderDirection, double[]... dArr2) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        int length = dArr.length;
        for (double[] dArr3 : dArr2) {
            if (dArr3 == null) {
                throw new NullArgumentException();
            }
            if (dArr3.length != length) {
                throw new DimensionMismatchException(dArr3.length, length);
            }
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i5 = 0; i5 < length; i5++) {
            arrayList.add(new PairDoubleInteger(dArr[i5], i5));
        }
        Collections.sort(arrayList, orderDirection == OrderDirection.INCREASING ? new Comparator<PairDoubleInteger>() { // from class: org.apache.commons.math3.util.MathArrays.1
            @Override // java.util.Comparator
            public int compare(PairDoubleInteger pairDoubleInteger, PairDoubleInteger pairDoubleInteger2) {
                return Double.compare(pairDoubleInteger.getKey(), pairDoubleInteger2.getKey());
            }
        } : new Comparator<PairDoubleInteger>() { // from class: org.apache.commons.math3.util.MathArrays.2
            @Override // java.util.Comparator
            public int compare(PairDoubleInteger pairDoubleInteger, PairDoubleInteger pairDoubleInteger2) {
                return Double.compare(pairDoubleInteger2.getKey(), pairDoubleInteger.getKey());
            }
        });
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            PairDoubleInteger pairDoubleInteger = (PairDoubleInteger) arrayList.get(i6);
            dArr[i6] = pairDoubleInteger.getKey();
            iArr[i6] = pairDoubleInteger.getValue();
        }
        for (double[] dArr4 : dArr2) {
            double[] dArr5 = (double[]) dArr4.clone();
            for (int i7 = 0; i7 < length; i7++) {
                dArr4[i7] = dArr5[iArr[i7]];
            }
        }
    }

    public static boolean verifyValues(double[] dArr, int i5, int i6, boolean z6) {
        if (dArr == null) {
            throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
        }
        if (i5 < 0) {
            throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(i5));
        }
        if (i6 < 0) {
            throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(i6));
        }
        int i7 = i5 + i6;
        if (i7 <= dArr.length) {
            return i6 != 0 || z6;
        }
        throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, Integer.valueOf(i7), Integer.valueOf(dArr.length), true);
    }

    public static <T> T[][] buildArray(Field<T> field, int i5, int i6) {
        if (i6 < 0) {
            return (T[][]) ((Object[][]) Array.newInstance(buildArray(field, 0).getClass(), i5));
        }
        T[][] tArr = (T[][]) ((Object[][]) Array.newInstance(field.getRuntimeClass(), i5, i6));
        for (int i7 = 0; i7 < i5; i7++) {
            Arrays.fill(tArr[i7], field.getZero());
        }
        return tArr;
    }

    public static void checkEqualLength(double[] dArr, double[] dArr2) {
        checkEqualLength(dArr, dArr2, true);
    }

    public static int[] copyOf(int[] iArr, int i5) {
        int[] iArr2 = new int[i5];
        System.arraycopy(iArr, 0, iArr2, 0, FastMath.min(i5, iArr.length));
        return iArr2;
    }

    public static boolean checkEqualLength(int[] iArr, int[] iArr2, boolean z6) {
        if (iArr.length == iArr2.length) {
            return true;
        }
        if (z6) {
            throw new DimensionMismatchException(iArr.length, iArr2.length);
        }
        return false;
    }

    public static void checkNonNegative(long[][] jArr) {
        for (int i5 = 0; i5 < jArr.length; i5++) {
            int i6 = 0;
            while (true) {
                long[] jArr2 = jArr[i5];
                if (i6 < jArr2.length) {
                    if (jArr2[i6] < 0) {
                        throw new NotPositiveException(Long.valueOf(jArr[i5][i6]));
                    }
                    i6++;
                }
            }
        }
    }

    public static int distance1(int[] iArr, int[] iArr2) {
        checkEqualLength(iArr, iArr2);
        int iAbs = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iAbs += FastMath.abs(iArr[i5] - iArr2[i5]);
        }
        return iAbs;
    }

    public static int distanceInf(int[] iArr, int[] iArr2) {
        checkEqualLength(iArr, iArr2);
        int iMax = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iMax = FastMath.max(iMax, FastMath.abs(iArr[i5] - iArr2[i5]));
        }
        return iMax;
    }

    public static boolean equals(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null) {
            return !((dArr == null) ^ (dArr2 == null));
        }
        if (dArr.length != dArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            if (!Precision.equals(dArr[i5], dArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIncludingNaN(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null) {
            return !((dArr == null) ^ (dArr2 == null));
        }
        if (dArr.length != dArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            if (!Precision.equalsIncludingNaN(dArr[i5], dArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    public static double[] copyOf(double[] dArr, int i5) {
        double[] dArr2 = new double[i5];
        System.arraycopy(dArr, 0, dArr2, 0, FastMath.min(i5, dArr.length));
        return dArr2;
    }

    public static double distance(int[] iArr, int[] iArr2) {
        checkEqualLength(iArr, iArr2);
        double d = 0.0d;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            double d6 = iArr[i5] - iArr2[i5];
            d += d6 * d6;
        }
        return FastMath.sqrt(d);
    }

    public static void checkEqualLength(int[] iArr, int[] iArr2) {
        checkEqualLength(iArr, iArr2, true);
    }

    public static boolean verifyValues(double[] dArr, double[] dArr2, int i5, int i6) {
        return verifyValues(dArr, dArr2, i5, i6, false);
    }

    public static boolean isMonotonic(double[] dArr, OrderDirection orderDirection, boolean z6) {
        return checkOrder(dArr, orderDirection, z6, false);
    }

    public static boolean verifyValues(double[] dArr, double[] dArr2, int i5, int i6, boolean z6) {
        if (dArr2 != null && dArr != null) {
            checkEqualLength(dArr2, dArr);
            boolean z7 = false;
            for (int i7 = i5; i7 < i5 + i6; i7++) {
                double d = dArr2[i7];
                if (!Double.isNaN(d)) {
                    if (Double.isInfinite(d)) {
                        throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, Double.valueOf(d), Integer.valueOf(i7));
                    }
                    if (d < 0.0d) {
                        throw new MathIllegalArgumentException(LocalizedFormats.NEGATIVE_ELEMENT_AT_INDEX, Integer.valueOf(i7), Double.valueOf(d));
                    }
                    if (!z7 && d > 0.0d) {
                        z7 = true;
                    }
                } else {
                    throw new MathIllegalArgumentException(LocalizedFormats.NAN_ELEMENT_AT_INDEX, Integer.valueOf(i7));
                }
            }
            if (z7) {
                return verifyValues(dArr, i5, i6, z6);
            }
            throw new MathIllegalArgumentException(LocalizedFormats.WEIGHT_AT_LEAST_ONE_NON_ZERO, new Object[0]);
        }
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public static void checkOrder(double[] dArr, OrderDirection orderDirection, boolean z6) {
        checkOrder(dArr, orderDirection, z6, true);
    }

    public static void checkOrder(double[] dArr) {
        checkOrder(dArr, OrderDirection.INCREASING, true);
    }

    public static void shuffle(int[] iArr, RandomGenerator randomGenerator) {
        shuffle(iArr, 0, Position.TAIL, randomGenerator);
    }

    public static void shuffle(int[] iArr) {
        shuffle(iArr, new Well19937c());
    }

    public static double linearCombination(double d, double d6, double d7, double d8) {
        double dLongBitsToDouble = Double.longBitsToDouble(Double.doubleToRawLongBits(d) & (-134217728));
        double d9 = d - dLongBitsToDouble;
        double dLongBitsToDouble2 = Double.longBitsToDouble(Double.doubleToRawLongBits(d6) & (-134217728));
        double d10 = d6 - dLongBitsToDouble2;
        double d11 = d * d6;
        double d12 = (d9 * d10) - (((d11 - (dLongBitsToDouble * dLongBitsToDouble2)) - (d9 * dLongBitsToDouble2)) - (dLongBitsToDouble * d10));
        double dLongBitsToDouble3 = Double.longBitsToDouble(Double.doubleToRawLongBits(d7) & (-134217728));
        double d13 = d7 - dLongBitsToDouble3;
        double dLongBitsToDouble4 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(d8));
        double d14 = d8 - dLongBitsToDouble4;
        double d15 = d7 * d8;
        double d16 = (d13 * d14) - (((d15 - (dLongBitsToDouble3 * dLongBitsToDouble4)) - (d13 * dLongBitsToDouble4)) - (dLongBitsToDouble3 * d14));
        double d17 = d11 + d15;
        double d18 = d17 - d15;
        double d19 = d12 + d16 + (d11 - d18) + (d15 - (d17 - d18)) + d17;
        return Double.isNaN(d19) ? d17 : d19;
    }

    public static double linearCombination(double d, double d6, double d7, double d8, double d9, double d10) {
        double dLongBitsToDouble = Double.longBitsToDouble(Double.doubleToRawLongBits(d) & (-134217728));
        double d11 = d - dLongBitsToDouble;
        double dLongBitsToDouble2 = Double.longBitsToDouble(Double.doubleToRawLongBits(d6) & (-134217728));
        double d12 = d6 - dLongBitsToDouble2;
        double d13 = d * d6;
        double d14 = (d11 * d12) - (((d13 - (dLongBitsToDouble * dLongBitsToDouble2)) - (d11 * dLongBitsToDouble2)) - (dLongBitsToDouble * d12));
        double dLongBitsToDouble3 = Double.longBitsToDouble(Double.doubleToRawLongBits(d7) & (-134217728));
        double d15 = d7 - dLongBitsToDouble3;
        double dLongBitsToDouble4 = Double.longBitsToDouble(Double.doubleToRawLongBits(d8) & (-134217728));
        double d16 = d8 - dLongBitsToDouble4;
        double d17 = d7 * d8;
        double d18 = (d15 * d16) - (((d17 - (dLongBitsToDouble3 * dLongBitsToDouble4)) - (d15 * dLongBitsToDouble4)) - (dLongBitsToDouble3 * d16));
        double dLongBitsToDouble5 = Double.longBitsToDouble(Double.doubleToRawLongBits(d9) & (-134217728));
        double d19 = d9 - dLongBitsToDouble5;
        double dLongBitsToDouble6 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(d10));
        double d20 = d10 - dLongBitsToDouble6;
        double d21 = d9 * d10;
        double d22 = (d19 * d20) - (((d21 - (dLongBitsToDouble5 * dLongBitsToDouble6)) - (d19 * dLongBitsToDouble6)) - (dLongBitsToDouble5 * d20));
        double d23 = d13 + d17;
        double d24 = d23 - d17;
        double d25 = (d13 - d24) + (d17 - (d23 - d24));
        double d26 = d23 + d21;
        double d27 = d26 - d21;
        double d28 = d14 + d18 + d22 + d25 + (d23 - d27) + (d21 - (d26 - d27)) + d26;
        return Double.isNaN(d28) ? d26 : d28;
    }

    public static double linearCombination(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        double dLongBitsToDouble = Double.longBitsToDouble(Double.doubleToRawLongBits(d) & (-134217728));
        double d13 = d - dLongBitsToDouble;
        double dLongBitsToDouble2 = Double.longBitsToDouble(Double.doubleToRawLongBits(d6) & (-134217728));
        double d14 = d6 - dLongBitsToDouble2;
        double d15 = d * d6;
        double d16 = (d13 * d14) - (((d15 - (dLongBitsToDouble * dLongBitsToDouble2)) - (d13 * dLongBitsToDouble2)) - (dLongBitsToDouble * d14));
        double dLongBitsToDouble3 = Double.longBitsToDouble(Double.doubleToRawLongBits(d7) & (-134217728));
        double d17 = d7 - dLongBitsToDouble3;
        double dLongBitsToDouble4 = Double.longBitsToDouble(Double.doubleToRawLongBits(d8) & (-134217728));
        double d18 = d8 - dLongBitsToDouble4;
        double d19 = d7 * d8;
        double d20 = (d17 * d18) - (((d19 - (dLongBitsToDouble3 * dLongBitsToDouble4)) - (d17 * dLongBitsToDouble4)) - (dLongBitsToDouble3 * d18));
        double dLongBitsToDouble5 = Double.longBitsToDouble(Double.doubleToRawLongBits(d9) & (-134217728));
        double d21 = d9 - dLongBitsToDouble5;
        double dLongBitsToDouble6 = Double.longBitsToDouble(Double.doubleToRawLongBits(d10) & (-134217728));
        double d22 = d10 - dLongBitsToDouble6;
        double d23 = d9 * d10;
        double d24 = (d21 * d22) - (((d23 - (dLongBitsToDouble5 * dLongBitsToDouble6)) - (d21 * dLongBitsToDouble6)) - (dLongBitsToDouble5 * d22));
        double dLongBitsToDouble7 = Double.longBitsToDouble(Double.doubleToRawLongBits(d11) & (-134217728));
        double d25 = d11 - dLongBitsToDouble7;
        double dLongBitsToDouble8 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(d12));
        double d26 = d12 - dLongBitsToDouble8;
        double d27 = d11 * d12;
        double d28 = (d25 * d26) - (((d27 - (dLongBitsToDouble7 * dLongBitsToDouble8)) - (d25 * dLongBitsToDouble8)) - (dLongBitsToDouble7 * d26));
        double d29 = d15 + d19;
        double d30 = d29 - d19;
        double d31 = (d15 - d30) + (d19 - (d29 - d30));
        double d32 = d29 + d23;
        double d33 = d32 - d23;
        double d34 = (d29 - d33) + (d23 - (d32 - d33));
        double d35 = d32 + d27;
        double d36 = d35 - d27;
        double d37 = d16 + d20 + d24 + d28 + d31 + d34 + (d32 - d36) + (d27 - (d35 - d36)) + d35;
        return Double.isNaN(d37) ? d35 : d37;
    }
}
