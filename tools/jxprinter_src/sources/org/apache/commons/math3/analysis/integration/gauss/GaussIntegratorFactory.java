package org.apache.commons.math3.analysis.integration.gauss;

import java.math.BigDecimal;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GaussIntegratorFactory {
    private final BaseRuleFactory<Double> legendre = new LegendreRuleFactory();
    private final BaseRuleFactory<BigDecimal> legendreHighPrecision = new LegendreHighPrecisionRuleFactory();
    private final BaseRuleFactory<Double> hermite = new HermiteRuleFactory();

    private static Pair<double[], double[]> getRule(BaseRuleFactory<? extends Number> baseRuleFactory, int i5) {
        return baseRuleFactory.getRule(i5);
    }

    private static Pair<double[], double[]> transform(Pair<double[], double[]> pair, double d, double d6) {
        double[] first = pair.getFirst();
        double[] second = pair.getSecond();
        double d7 = (d6 - d) / 2.0d;
        double d8 = d + d7;
        for (int i5 = 0; i5 < first.length; i5++) {
            first[i5] = (first[i5] * d7) + d8;
            second[i5] = second[i5] * d7;
        }
        return new Pair<>(first, second);
    }

    public SymmetricGaussIntegrator hermite(int i5) {
        return new SymmetricGaussIntegrator(getRule(this.hermite, i5));
    }

    public GaussIntegrator legendre(int i5) {
        return new GaussIntegrator(getRule(this.legendre, i5));
    }

    public GaussIntegrator legendreHighPrecision(int i5) {
        return new GaussIntegrator(getRule(this.legendreHighPrecision, i5));
    }

    public GaussIntegrator legendre(int i5, double d, double d6) {
        return new GaussIntegrator(transform(getRule(this.legendre, i5), d, d6));
    }

    public GaussIntegrator legendreHighPrecision(int i5, double d, double d6) {
        return new GaussIntegrator(transform(getRule(this.legendreHighPrecision, i5), d, d6));
    }
}
