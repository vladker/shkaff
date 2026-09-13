package org.apache.commons.math3.stat.inference;

import java.util.Collection;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TestUtils {
    private static final TTest T_TEST = new TTest();
    private static final ChiSquareTest CHI_SQUARE_TEST = new ChiSquareTest();
    private static final OneWayAnova ONE_WAY_ANANOVA = new OneWayAnova();
    private static final GTest G_TEST = new GTest();
    private static final KolmogorovSmirnovTest KS_TEST = new KolmogorovSmirnovTest();

    private TestUtils() {
    }

    public static double approximateP(double d, int i5, int i6) {
        return KS_TEST.approximateP(d, i5, i6);
    }

    public static double chiSquare(double[] dArr, long[] jArr) {
        return CHI_SQUARE_TEST.chiSquare(dArr, jArr);
    }

    public static double chiSquareDataSetsComparison(long[] jArr, long[] jArr2) {
        return CHI_SQUARE_TEST.chiSquareDataSetsComparison(jArr, jArr2);
    }

    public static boolean chiSquareTest(double[] dArr, long[] jArr, double d) {
        return CHI_SQUARE_TEST.chiSquareTest(dArr, jArr, d);
    }

    public static double chiSquareTestDataSetsComparison(long[] jArr, long[] jArr2) {
        return CHI_SQUARE_TEST.chiSquareTestDataSetsComparison(jArr, jArr2);
    }

    public static double exactP(double d, int i5, int i6, boolean z6) {
        return KS_TEST.exactP(d, i6, i5, z6);
    }

    public static double g(double[] dArr, long[] jArr) {
        return G_TEST.g(dArr, jArr);
    }

    public static double gDataSetsComparison(long[] jArr, long[] jArr2) {
        return G_TEST.gDataSetsComparison(jArr, jArr2);
    }

    public static double gTest(double[] dArr, long[] jArr) {
        return G_TEST.gTest(dArr, jArr);
    }

    public static double gTestDataSetsComparison(long[] jArr, long[] jArr2) {
        return G_TEST.gTestDataSetsComparison(jArr, jArr2);
    }

    public static double gTestIntrinsic(double[] dArr, long[] jArr) {
        return G_TEST.gTestIntrinsic(dArr, jArr);
    }

    public static double homoscedasticT(double[] dArr, double[] dArr2) {
        return T_TEST.homoscedasticT(dArr, dArr2);
    }

    public static boolean homoscedasticTTest(double[] dArr, double[] dArr2, double d) {
        return T_TEST.homoscedasticTTest(dArr, dArr2, d);
    }

    public static double kolmogorovSmirnovStatistic(RealDistribution realDistribution, double[] dArr) {
        return KS_TEST.kolmogorovSmirnovStatistic(realDistribution, dArr);
    }

    public static double kolmogorovSmirnovTest(RealDistribution realDistribution, double[] dArr) {
        return KS_TEST.kolmogorovSmirnovTest(realDistribution, dArr);
    }

    public static double monteCarloP(double d, int i5, int i6, boolean z6, int i7) {
        return KS_TEST.monteCarloP(d, i5, i6, z6, i7);
    }

    public static double oneWayAnovaFValue(Collection<double[]> collection) {
        return ONE_WAY_ANANOVA.anovaFValue(collection);
    }

    public static double oneWayAnovaPValue(Collection<double[]> collection) {
        return ONE_WAY_ANANOVA.anovaPValue(collection);
    }

    public static boolean oneWayAnovaTest(Collection<double[]> collection, double d) {
        return ONE_WAY_ANANOVA.anovaTest(collection, d);
    }

    public static double pairedT(double[] dArr, double[] dArr2) {
        return T_TEST.pairedT(dArr, dArr2);
    }

    public static boolean pairedTTest(double[] dArr, double[] dArr2, double d) {
        return T_TEST.pairedTTest(dArr, dArr2, d);
    }

    public static double rootLogLikelihoodRatio(long j6, long j7, long j8, long j9) {
        return G_TEST.rootLogLikelihoodRatio(j6, j7, j8, j9);
    }

    public static double t(double d, double[] dArr) {
        return T_TEST.t(d, dArr);
    }

    public static boolean tTest(double d, double[] dArr, double d6) {
        return T_TEST.tTest(d, dArr, d6);
    }

    public static double chiSquare(long[][] jArr) {
        return CHI_SQUARE_TEST.chiSquare(jArr);
    }

    public static double chiSquareTest(double[] dArr, long[] jArr) {
        return CHI_SQUARE_TEST.chiSquareTest(dArr, jArr);
    }

    public static boolean chiSquareTestDataSetsComparison(long[] jArr, long[] jArr2, double d) {
        return CHI_SQUARE_TEST.chiSquareTestDataSetsComparison(jArr, jArr2, d);
    }

    public static boolean gTest(double[] dArr, long[] jArr, double d) {
        return G_TEST.gTest(dArr, jArr, d);
    }

    public static boolean gTestDataSetsComparison(long[] jArr, long[] jArr2, double d) {
        return G_TEST.gTestDataSetsComparison(jArr, jArr2, d);
    }

    public static double homoscedasticT(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2) {
        return T_TEST.homoscedasticT(statisticalSummary, statisticalSummary2);
    }

    public static double homoscedasticTTest(double[] dArr, double[] dArr2) {
        return T_TEST.homoscedasticTTest(dArr, dArr2);
    }

    public static double kolmogorovSmirnovStatistic(double[] dArr, double[] dArr2) {
        return KS_TEST.kolmogorovSmirnovStatistic(dArr, dArr2);
    }

    public static double kolmogorovSmirnovTest(RealDistribution realDistribution, double[] dArr, boolean z6) {
        return KS_TEST.kolmogorovSmirnovTest(realDistribution, dArr, z6);
    }

    public static double pairedTTest(double[] dArr, double[] dArr2) {
        return T_TEST.pairedTTest(dArr, dArr2);
    }

    public static double t(double d, StatisticalSummary statisticalSummary) {
        return T_TEST.t(d, statisticalSummary);
    }

    public static double tTest(double d, double[] dArr) {
        return T_TEST.tTest(d, dArr);
    }

    public static boolean chiSquareTest(long[][] jArr, double d) {
        return CHI_SQUARE_TEST.chiSquareTest(jArr, d);
    }

    public static double homoscedasticTTest(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2) {
        return T_TEST.homoscedasticTTest(statisticalSummary, statisticalSummary2);
    }

    public static boolean kolmogorovSmirnovTest(RealDistribution realDistribution, double[] dArr, double d) {
        return KS_TEST.kolmogorovSmirnovTest(realDistribution, dArr, d);
    }

    public static double t(double[] dArr, double[] dArr2) {
        return T_TEST.t(dArr, dArr2);
    }

    public static boolean tTest(double d, StatisticalSummary statisticalSummary, double d6) {
        return T_TEST.tTest(d, statisticalSummary, d6);
    }

    public static double chiSquareTest(long[][] jArr) {
        return CHI_SQUARE_TEST.chiSquareTest(jArr);
    }

    public static double kolmogorovSmirnovTest(double[] dArr, double[] dArr2) {
        return KS_TEST.kolmogorovSmirnovTest(dArr, dArr2);
    }

    public static double t(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2) {
        return T_TEST.t(statisticalSummary, statisticalSummary2);
    }

    public static double tTest(double d, StatisticalSummary statisticalSummary) {
        return T_TEST.tTest(d, statisticalSummary);
    }

    public static double kolmogorovSmirnovTest(double[] dArr, double[] dArr2, boolean z6) {
        return KS_TEST.kolmogorovSmirnovTest(dArr, dArr2, z6);
    }

    public static boolean tTest(double[] dArr, double[] dArr2, double d) {
        return T_TEST.tTest(dArr, dArr2, d);
    }

    public static double tTest(double[] dArr, double[] dArr2) {
        return T_TEST.tTest(dArr, dArr2);
    }

    public static boolean tTest(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2, double d) {
        return T_TEST.tTest(statisticalSummary, statisticalSummary2, d);
    }

    public static double tTest(StatisticalSummary statisticalSummary, StatisticalSummary statisticalSummary2) {
        return T_TEST.tTest(statisticalSummary, statisticalSummary2);
    }
}
