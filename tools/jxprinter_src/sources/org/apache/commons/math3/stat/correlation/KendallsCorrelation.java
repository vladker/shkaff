package org.apache.commons.math3.stat.correlation;

import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KendallsCorrelation {
    private final RealMatrix correlationMatrix;

    public KendallsCorrelation() {
        this.correlationMatrix = null;
    }

    private static long sum(long j6) {
        return ((1 + j6) * j6) / 2;
    }

    public RealMatrix computeCorrelationMatrix(RealMatrix realMatrix) {
        int columnDimension = realMatrix.getColumnDimension();
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(columnDimension, columnDimension);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < i5; i6++) {
                double dCorrelation = correlation(realMatrix.getColumn(i5), realMatrix.getColumn(i6));
                blockRealMatrix.setEntry(i5, i6, dCorrelation);
                blockRealMatrix.setEntry(i6, i5, dCorrelation);
            }
            blockRealMatrix.setEntry(i5, i5, 1.0d);
        }
        return blockRealMatrix;
    }

    public double correlation(double[] dArr, double[] dArr2) {
        Pair[] pairArr;
        int i5;
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        int length = dArr.length;
        long jSum = sum(length - 1);
        Pair[] pairArr2 = new Pair[length];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            pairArr2[i7] = new Pair(Double.valueOf(dArr[i7]), Double.valueOf(dArr2[i7]));
        }
        Arrays.sort(pairArr2, new Comparator<Pair<Double, Double>>() { // from class: org.apache.commons.math3.stat.correlation.KendallsCorrelation.1
            @Override // java.util.Comparator
            public int compare(Pair<Double, Double> pair, Pair<Double, Double> pair2) {
                int iCompareTo = pair.getFirst().compareTo(pair2.getFirst());
                return iCompareTo != 0 ? iCompareTo : pair.getSecond().compareTo(pair2.getSecond());
            }
        });
        Pair pair = pairArr2[0];
        long j6 = 1;
        long j7 = 1;
        long j8 = 1;
        int i8 = 1;
        long jSum2 = 0;
        long jSum3 = 0;
        while (i8 < length) {
            Pair pair2 = pairArr2[i8];
            int i9 = i6;
            if (((Double) pair2.getFirst()).equals(pair.getFirst())) {
                j7++;
                if (((Double) pair2.getSecond()).equals(pair.getSecond())) {
                    j8++;
                } else {
                    jSum3 += sum(j8 - 1);
                    j8 = 1;
                }
            } else {
                jSum2 += sum(j7 - 1);
                jSum3 += sum(j8 - 1);
                j7 = 1;
                j8 = 1;
            }
            i8++;
            pair = pair2;
            i6 = i9;
        }
        int i10 = i6;
        long jSum4 = jSum2 + sum(j7 - 1);
        long jSum5 = jSum3 + sum(j8 - 1);
        Pair[] pairArr3 = new Pair[length];
        int i11 = 1;
        long j9 = 0;
        while (i11 < length) {
            int i12 = i10;
            while (i12 < length) {
                int iMin = FastMath.min(i12 + i11, length);
                int iMin2 = FastMath.min(iMin + i11, length);
                int i13 = i12;
                long j10 = j6;
                int i14 = iMin;
                int i15 = i13;
                while (true) {
                    if (i13 < iMin || i14 < iMin2) {
                        if (i13 < iMin) {
                            if (i14 < iMin2) {
                                pairArr = pairArr3;
                                i5 = i11;
                                if (((Double) pairArr2[i13].getSecond()).compareTo((Double) pairArr2[i14].getSecond()) <= 0) {
                                    pairArr[i15] = pairArr2[i13];
                                } else {
                                    pairArr[i15] = pairArr2[i14];
                                    i14++;
                                    j9 += (long) (iMin - i13);
                                }
                            } else {
                                pairArr = pairArr3;
                                i5 = i11;
                                pairArr[i15] = pairArr2[i13];
                            }
                            i13++;
                        } else {
                            pairArr = pairArr3;
                            i5 = i11;
                            pairArr[i15] = pairArr2[i14];
                            i14++;
                        }
                        i15++;
                        pairArr3 = pairArr;
                        i11 = i5;
                    }
                }
                i12 += i11 * 2;
                j6 = j10;
            }
            Pair[] pairArr4 = pairArr3;
            i11 <<= 1;
            pairArr3 = pairArr2;
            pairArr2 = pairArr4;
        }
        long j11 = j6;
        Pair pair3 = pairArr2[i10];
        int i16 = 1;
        long jSum6 = 0;
        while (i16 < length) {
            Pair pair4 = pairArr2[i16];
            if (((Double) pair4.getSecond()).equals(pair3.getSecond())) {
                j6 += j11;
            } else {
                jSum6 += sum(j6 - j11);
                j6 = j11;
            }
            i16++;
            pair3 = pair4;
        }
        long jSum7 = jSum6 + sum(j6 - j11);
        long j12 = jSum - jSum4;
        return (((j12 - jSum7) + jSum5) - (j9 * 2)) / FastMath.sqrt(j12 * (jSum - jSum7));
    }

    public RealMatrix getCorrelationMatrix() {
        return this.correlationMatrix;
    }

    public KendallsCorrelation(double[][] dArr) {
        this(MatrixUtils.createRealMatrix(dArr));
    }

    public KendallsCorrelation(RealMatrix realMatrix) {
        this.correlationMatrix = computeCorrelationMatrix(realMatrix);
    }

    public RealMatrix computeCorrelationMatrix(double[][] dArr) {
        return computeCorrelationMatrix(new BlockRealMatrix(dArr));
    }
}
