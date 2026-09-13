package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class IntervalUtils {
    private static final BinomialConfidenceInterval AGRESTI_COULL = new AgrestiCoullInterval();
    private static final BinomialConfidenceInterval CLOPPER_PEARSON = new ClopperPearsonInterval();
    private static final BinomialConfidenceInterval NORMAL_APPROXIMATION = new NormalApproximationInterval();
    private static final BinomialConfidenceInterval WILSON_SCORE = new WilsonScoreInterval();

    private IntervalUtils() {
    }

    public static void checkParameters(int i5, int i6, double d) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_TRIALS, Integer.valueOf(i5));
        }
        if (i6 < 0) {
            throw new NotPositiveException(LocalizedFormats.NEGATIVE_NUMBER_OF_SUCCESSES, Integer.valueOf(i6));
        }
        if (i6 > i5) {
            throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE, Integer.valueOf(i6), Integer.valueOf(i5), true);
        }
        if (d <= 0.0d || d >= 1.0d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_CONFIDENCE_LEVEL, Double.valueOf(d), 0, 1);
        }
    }

    public static ConfidenceInterval getAgrestiCoullInterval(int i5, int i6, double d) {
        return AGRESTI_COULL.createInterval(i5, i6, d);
    }

    public static ConfidenceInterval getClopperPearsonInterval(int i5, int i6, double d) {
        return CLOPPER_PEARSON.createInterval(i5, i6, d);
    }

    public static ConfidenceInterval getNormalApproximationInterval(int i5, int i6, double d) {
        return NORMAL_APPROXIMATION.createInterval(i5, i6, d);
    }

    public static ConfidenceInterval getWilsonScoreInterval(int i5, int i6, double d) {
        return WILSON_SCORE.createInterval(i5, i6, d);
    }
}
