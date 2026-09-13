package org.apache.commons.math3.analysis.integration.gauss;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HermiteRuleFactory extends BaseRuleFactory<Double> {

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    private static final double f6738H0 = 0.7511255444649425d;

    /* JADX INFO: renamed from: H1, reason: collision with root package name */
    private static final double f6739H1 = 1.0622519320271968d;
    private static final double SQRT_PI = 1.772453850905516d;

    @Override // org.apache.commons.math3.analysis.integration.gauss.BaseRuleFactory
    public Pair<Double[], Double[]> computeRule(int i5) {
        double d;
        Double dValueOf = Double.valueOf(0.0d);
        if (i5 == 1) {
            return new Pair<>(new Double[]{dValueOf}, new Double[]{Double.valueOf(SQRT_PI)});
        }
        int i6 = i5 - 1;
        Double[] first = getRuleInternal(i6).getFirst();
        Double[] dArr = new Double[i5];
        Double[] dArr2 = new Double[i5];
        double dSqrt = FastMath.sqrt(i6 * 2);
        double dSqrt2 = FastMath.sqrt(i5 * 2);
        int i7 = i5 / 2;
        int i8 = 0;
        while (true) {
            d = f6738H0;
            if (i8 >= i7) {
                break;
            }
            int i9 = i6;
            double dDoubleValue = i8 == 0 ? -dSqrt : first[i8 - 1].doubleValue();
            int i10 = 1;
            double dDoubleValue2 = i7 == 1 ? -0.5d : first[i8].doubleValue();
            double d6 = dDoubleValue * f6739H1;
            double d7 = 0.7511255444649425d;
            while (i10 < i5) {
                int i11 = i10 + 1;
                Double d8 = dValueOf;
                double d9 = dDoubleValue;
                double d10 = i11;
                int i12 = i8;
                double dSqrt3 = ((FastMath.sqrt(2.0d / d10) * d9) * d6) - (FastMath.sqrt(((double) i10) / d10) * d7);
                d7 = d6;
                dValueOf = d8;
                d6 = dSqrt3;
                i8 = i12;
                i10 = i11;
                dDoubleValue = d9;
            }
            Double d11 = dValueOf;
            double d12 = dDoubleValue;
            int i13 = i8;
            double d13 = 0.5d;
            double d14 = (d12 + dDoubleValue2) * 0.5d;
            double d15 = 0.7511255444649425d;
            boolean z6 = false;
            while (!z6) {
                z6 = dDoubleValue2 - d12 <= Math.ulp(d14);
                double d16 = d14 * f6739H1;
                double d17 = d13;
                double d18 = 0.7511255444649425d;
                int i14 = 1;
                while (i14 < i5) {
                    int i15 = i14 + 1;
                    int i16 = i13;
                    double d19 = i15;
                    double dSqrt4 = ((FastMath.sqrt(2.0d / d19) * d14) * d16) - (FastMath.sqrt(((double) i14) / d19) * d18);
                    d18 = d16;
                    i13 = i16;
                    d16 = dSqrt4;
                    i14 = i15;
                }
                int i17 = i13;
                if (!z6) {
                    if (d6 * d16 < 0.0d) {
                        dDoubleValue2 = d14;
                    } else {
                        d12 = d14;
                        d6 = d16;
                    }
                    d14 = (d12 + dDoubleValue2) * d17;
                }
                d15 = d18;
                d13 = d17;
                i13 = i17;
            }
            int i18 = i13;
            double d20 = d15 * dSqrt2;
            double d21 = 2.0d / (d20 * d20);
            dArr[i18] = Double.valueOf(d14);
            dArr2[i18] = Double.valueOf(d21);
            int i19 = i9 - i18;
            dArr[i19] = Double.valueOf(-d14);
            dArr2[i19] = Double.valueOf(d21);
            i8 = i18 + 1;
            i6 = i9;
            dValueOf = d11;
        }
        Double d22 = dValueOf;
        if (i5 % 2 != 0) {
            for (int i20 = 1; i20 < i5; i20 += 2) {
                d *= -FastMath.sqrt(((double) i20) / ((double) (i20 + 1)));
            }
            double d23 = dSqrt2 * d;
            dArr[i7] = d22;
            dArr2[i7] = Double.valueOf(2.0d / (d23 * d23));
        }
        return new Pair<>(dArr, dArr2);
    }
}
