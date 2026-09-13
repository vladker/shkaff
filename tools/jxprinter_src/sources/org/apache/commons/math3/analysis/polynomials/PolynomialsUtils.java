package org.apache.commons.math3.analysis.polynomials;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PolynomialsUtils {
    private static final List<BigFraction> CHEBYSHEV_COEFFICIENTS;
    private static final List<BigFraction> HERMITE_COEFFICIENTS;
    private static final Map<JacobiKey, List<BigFraction>> JACOBI_COEFFICIENTS;
    private static final List<BigFraction> LAGUERRE_COEFFICIENTS;
    private static final List<BigFraction> LEGENDRE_COEFFICIENTS;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class JacobiKey {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final int f6752v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final int f6753w;

        public JacobiKey(int i5, int i6) {
            this.f6752v = i5;
            this.f6753w = i6;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof JacobiKey)) {
                JacobiKey jacobiKey = (JacobiKey) obj;
                if (this.f6752v == jacobiKey.f6752v && this.f6753w == jacobiKey.f6753w) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f6752v << 16) ^ this.f6753w;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface RecurrenceCoefficientsGenerator {
        BigFraction[] generate(int i5);
    }

    static {
        ArrayList arrayList = new ArrayList();
        CHEBYSHEV_COEFFICIENTS = arrayList;
        BigFraction bigFraction = BigFraction.ONE;
        arrayList.add(bigFraction);
        BigFraction bigFraction2 = BigFraction.ZERO;
        arrayList.add(bigFraction2);
        arrayList.add(bigFraction);
        ArrayList arrayList2 = new ArrayList();
        HERMITE_COEFFICIENTS = arrayList2;
        arrayList2.add(bigFraction);
        arrayList2.add(bigFraction2);
        arrayList2.add(BigFraction.TWO);
        ArrayList arrayList3 = new ArrayList();
        LAGUERRE_COEFFICIENTS = arrayList3;
        arrayList3.add(bigFraction);
        arrayList3.add(bigFraction);
        arrayList3.add(BigFraction.MINUS_ONE);
        ArrayList arrayList4 = new ArrayList();
        LEGENDRE_COEFFICIENTS = arrayList4;
        arrayList4.add(bigFraction);
        arrayList4.add(bigFraction2);
        arrayList4.add(bigFraction);
        JACOBI_COEFFICIENTS = new HashMap();
    }

    private PolynomialsUtils() {
    }

    private static PolynomialFunction buildPolynomial(int i5, List<BigFraction> list, RecurrenceCoefficientsGenerator recurrenceCoefficientsGenerator) {
        synchronized (list) {
            try {
                int iFloor = ((int) FastMath.floor(FastMath.sqrt(list.size() * 2))) - 1;
                if (i5 > iFloor) {
                    computeUpToDegree(i5, iFloor, recurrenceCoefficientsGenerator, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int i6 = i5 + 1;
        int i7 = (i5 * i6) / 2;
        double[] dArr = new double[i6];
        for (int i8 = 0; i8 <= i5; i8++) {
            dArr[i8] = list.get(i7 + i8).doubleValue();
        }
        return new PolynomialFunction(dArr);
    }

    private static void computeUpToDegree(int i5, int i6, RecurrenceCoefficientsGenerator recurrenceCoefficientsGenerator, List<BigFraction> list) {
        int i7 = ((i6 - 1) * i6) / 2;
        while (i6 < i5) {
            int i8 = i7 + i6;
            BigFraction[] bigFractionArrGenerate = recurrenceCoefficientsGenerator.generate(i6);
            BigFraction bigFraction = list.get(i8);
            list.add(bigFraction.multiply(bigFractionArrGenerate[0]).subtract(list.get(i7).multiply(bigFractionArrGenerate[2])));
            int i9 = 1;
            while (i9 < i6) {
                BigFraction bigFraction2 = list.get(i8 + i9);
                list.add(bigFraction2.multiply(bigFractionArrGenerate[0]).add(bigFraction.multiply(bigFractionArrGenerate[1])).subtract(list.get(i7 + i9).multiply(bigFractionArrGenerate[2])));
                i9++;
                bigFraction = bigFraction2;
            }
            BigFraction bigFraction3 = list.get(i8 + i6);
            list.add(bigFraction3.multiply(bigFractionArrGenerate[0]).add(bigFraction.multiply(bigFractionArrGenerate[1])));
            list.add(bigFraction3.multiply(bigFractionArrGenerate[1]));
            i6++;
            i7 = i8;
        }
    }

    public static PolynomialFunction createChebyshevPolynomial(int i5) {
        return buildPolynomial(i5, CHEBYSHEV_COEFFICIENTS, new RecurrenceCoefficientsGenerator() { // from class: org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.1
            private final BigFraction[] coeffs = {BigFraction.ZERO, BigFraction.TWO, BigFraction.ONE};

            @Override // org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.RecurrenceCoefficientsGenerator
            public BigFraction[] generate(int i6) {
                return this.coeffs;
            }
        });
    }

    public static PolynomialFunction createHermitePolynomial(int i5) {
        return buildPolynomial(i5, HERMITE_COEFFICIENTS, new RecurrenceCoefficientsGenerator() { // from class: org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.2
            @Override // org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.RecurrenceCoefficientsGenerator
            public BigFraction[] generate(int i6) {
                return new BigFraction[]{BigFraction.ZERO, BigFraction.TWO, new BigFraction(i6 * 2)};
            }
        });
    }

    public static PolynomialFunction createJacobiPolynomial(int i5, final int i6, final int i7) {
        JacobiKey jacobiKey = new JacobiKey(i6, i7);
        Map<JacobiKey, List<BigFraction>> map = JACOBI_COEFFICIENTS;
        if (!map.containsKey(jacobiKey)) {
            ArrayList arrayList = new ArrayList();
            map.put(jacobiKey, arrayList);
            arrayList.add(BigFraction.ONE);
            arrayList.add(new BigFraction(i6 - i7, 2));
            arrayList.add(new BigFraction(i6 + 2 + i7, 2));
        }
        return buildPolynomial(i5, map.get(jacobiKey), new RecurrenceCoefficientsGenerator() { // from class: org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.5
            @Override // org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.RecurrenceCoefficientsGenerator
            public BigFraction[] generate(int i8) {
                int i9 = i8 + 1;
                int i10 = i6 + i9 + i7;
                int i11 = i10 + i9;
                int i12 = i11 - 1;
                int i13 = i11 - 2;
                int i14 = i9 * 2 * i10 * i13;
                int i15 = i6;
                int i16 = i7;
                return new BigFraction[]{new BigFraction(((i15 * i15) - (i16 * i16)) * i12, i14), new BigFraction(i12 * i11 * i13, i14), new BigFraction(((i9 + i7) - 1) * ((i6 + i9) - 1) * 2 * i11, i14)};
            }
        });
    }

    public static PolynomialFunction createLaguerrePolynomial(int i5) {
        return buildPolynomial(i5, LAGUERRE_COEFFICIENTS, new RecurrenceCoefficientsGenerator() { // from class: org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.3
            @Override // org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.RecurrenceCoefficientsGenerator
            public BigFraction[] generate(int i6) {
                int i7 = i6 + 1;
                return new BigFraction[]{new BigFraction((i6 * 2) + 1, i7), new BigFraction(-1, i7), new BigFraction(i6, i7)};
            }
        });
    }

    public static PolynomialFunction createLegendrePolynomial(int i5) {
        return buildPolynomial(i5, LEGENDRE_COEFFICIENTS, new RecurrenceCoefficientsGenerator() { // from class: org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.4
            @Override // org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.RecurrenceCoefficientsGenerator
            public BigFraction[] generate(int i6) {
                int i7 = i6 + 1;
                return new BigFraction[]{BigFraction.ZERO, new BigFraction(i6 + i7, i7), new BigFraction(i6, i7)};
            }
        });
    }

    public static double[] shift(double[] dArr, double d) {
        int length = dArr.length;
        double[] dArr2 = new double[length];
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, length);
        for (int i5 = 0; i5 < length; i5++) {
            for (int i6 = 0; i6 <= i5; i6++) {
                iArr[i5][i6] = (int) CombinatoricsUtils.binomialCoefficient(i5, i6);
            }
        }
        for (int i7 = 0; i7 < length; i7++) {
            dArr2[0] = (FastMath.pow(d, i7) * dArr[i7]) + dArr2[0];
        }
        int i8 = length - 1;
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = i9;
            while (i10 < i8) {
                int i11 = i9 + 1;
                int i12 = i10 + 1;
                int i13 = i10 - i9;
                dArr2[i11] = (FastMath.pow(d, i13) * ((double) iArr[i12][i13]) * dArr[i12]) + dArr2[i11];
                i10 = i12;
            }
        }
        return dArr2;
    }
}
