package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BinomialTest {

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.inference.BinomialTest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis;

        static {
            int[] iArr = new int[AlternativeHypothesis.values().length];
            $SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis = iArr;
            try {
                iArr[AlternativeHypothesis.GREATER_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis[AlternativeHypothesis.LESS_THAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis[AlternativeHypothesis.TWO_SIDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean binomialTest(int i5, int i6, double d, AlternativeHypothesis alternativeHypothesis, double d6) {
        return binomialTest(i5, i6, d, alternativeHypothesis) < d6;
    }

    public double binomialTest(int i5, int i6, double d, AlternativeHypothesis alternativeHypothesis) {
        if (i5 < 0) {
            throw new NotPositiveException(Integer.valueOf(i5));
        }
        if (i6 < 0) {
            throw new NotPositiveException(Integer.valueOf(i6));
        }
        double d6 = 0.0d;
        int i7 = 0;
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        if (i5 < i6) {
            throw new MathIllegalArgumentException(LocalizedFormats.BINOMIAL_INVALID_PARAMETERS_ORDER, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        if (alternativeHypothesis == null) {
            throw new NullArgumentException();
        }
        BinomialDistribution binomialDistribution = new BinomialDistribution(null, i5, d);
        int i8 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$inference$AlternativeHypothesis[alternativeHypothesis.ordinal()];
        if (i8 == 1) {
            return 1.0d - binomialDistribution.cumulativeProbability(i6 - 1);
        }
        if (i8 == 2) {
            return binomialDistribution.cumulativeProbability(i6);
        }
        if (i8 != 3) {
            throw new MathInternalError(LocalizedFormats.OUT_OF_RANGE_SIMPLE, alternativeHypothesis, AlternativeHypothesis.TWO_SIDED, AlternativeHypothesis.LESS_THAN);
        }
        do {
            double dProbability = binomialDistribution.probability(i7);
            double dProbability2 = binomialDistribution.probability(i5);
            if (dProbability == dProbability2) {
                i7++;
                i5--;
                d6 = (dProbability * 2.0d) + d6;
            } else if (dProbability < dProbability2) {
                d6 += dProbability;
                i7++;
            } else {
                d6 += dProbability2;
                i5--;
            }
            if (i7 > i6) {
                break;
            }
        } while (i5 >= i6);
        return d6;
    }
}
