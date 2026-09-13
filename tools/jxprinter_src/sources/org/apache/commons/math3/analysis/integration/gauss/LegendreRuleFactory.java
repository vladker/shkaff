package org.apache.commons.math3.analysis.integration.gauss;

import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LegendreRuleFactory extends BaseRuleFactory<Double> {
    @Override // org.apache.commons.math3.analysis.integration.gauss.BaseRuleFactory
    public Pair<Double[], Double[]> computeRule(int i5) {
        double d;
        double d6 = 0.0d;
        Double dValueOf = Double.valueOf(0.0d);
        double d7 = 2.0d;
        int i6 = 1;
        if (i5 == 1) {
            return new Pair<>(new Double[]{dValueOf}, new Double[]{Double.valueOf(2.0d)});
        }
        Double[] first = getRuleInternal(i5 - 1).getFirst();
        Double[] dArr = new Double[i5];
        Double[] dArr2 = new Double[i5];
        int i7 = i5 / 2;
        int i8 = 0;
        while (true) {
            d = 1.0d;
            if (i8 >= i7) {
                break;
            }
            double dDoubleValue = i8 == 0 ? -1.0d : first[i8 - 1].doubleValue();
            double dDoubleValue2 = i7 == i6 ? 1.0d : first[i8].doubleValue();
            double d8 = d6;
            int i9 = i6;
            double d9 = 1.0d;
            double d10 = dDoubleValue;
            while (i9 < i5) {
                double d11 = d7;
                int i10 = i9 + 1;
                int i11 = i6;
                double d12 = (((((double) ((i9 * 2) + i6)) * dDoubleValue) * d10) - (((double) i9) * d9)) / ((double) i10);
                i9 = i10;
                d9 = d10;
                d10 = d12;
                first = first;
                i6 = i11;
                d7 = d11;
            }
            double d13 = d7;
            int i12 = i6;
            Double[] dArr3 = first;
            double d14 = 0.5d;
            double d15 = (dDoubleValue + dDoubleValue2) * 0.5d;
            double d16 = 1.0d;
            double d17 = d10;
            int i13 = 0;
            double d18 = dDoubleValue2;
            double d19 = dDoubleValue;
            double d20 = d15;
            while (i13 == 0) {
                i13 = d18 - d19 <= Math.ulp(d15) ? i12 : 0;
                d20 = d15;
                int i14 = i12;
                d16 = 1.0d;
                while (i12 < i5) {
                    double d21 = d14;
                    double d22 = ((((double) ((i12 * 2) + 1)) * d15) * d20) - (((double) i12) * d16);
                    i12++;
                    d16 = d20;
                    i8 = i8;
                    d20 = d22 / ((double) i12);
                    d14 = d21;
                }
                double d23 = d14;
                int i15 = i8;
                if (i13 == 0) {
                    if (d17 * d20 <= d8) {
                        d18 = d15;
                    } else {
                        d19 = d15;
                        d17 = d20;
                    }
                    d15 = (d19 + d18) * d23;
                }
                i12 = i14;
                d14 = d23;
                i8 = i15;
            }
            int i16 = i8;
            double d24 = (d16 - (d20 * d15)) * ((double) i5);
            double d25 = ((1.0d - (d15 * d15)) * d13) / (d24 * d24);
            dArr[i16] = Double.valueOf(d15);
            dArr2[i16] = Double.valueOf(d25);
            int i17 = (i5 - i16) - 1;
            dArr[i17] = Double.valueOf(-d15);
            dArr2[i17] = Double.valueOf(d25);
            i8 = i16 + 1;
            d6 = d8;
            d7 = d13;
            first = dArr3;
            i6 = i12;
        }
        double d26 = d7;
        int i18 = i6;
        if (i5 % 2 != 0) {
            for (int i19 = i18; i19 < i5; i19 += 2) {
                d = (((double) (-i19)) * d) / ((double) (i19 + 1));
            }
            double d27 = ((double) i5) * d;
            dArr[i7] = dValueOf;
            dArr2[i7] = Double.valueOf(d26 / (d27 * d27));
        }
        return new Pair<>(dArr, dArr2);
    }
}
