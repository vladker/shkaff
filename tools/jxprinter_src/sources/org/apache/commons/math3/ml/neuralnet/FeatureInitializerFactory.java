package org.apache.commons.math3.ml.neuralnet;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Constant;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FeatureInitializerFactory {
    private FeatureInitializerFactory() {
    }

    public static FeatureInitializer function(UnivariateFunction univariateFunction, double d, double d6) {
        return new FeatureInitializer(d, univariateFunction, d6) { // from class: org.apache.commons.math3.ml.neuralnet.FeatureInitializerFactory.1
            private double arg;
            final /* synthetic */ UnivariateFunction val$f;
            final /* synthetic */ double val$inc;
            final /* synthetic */ double val$init;

            {
                this.val$init = d;
                this.val$f = univariateFunction;
                this.val$inc = d6;
                this.arg = d;
            }

            @Override // org.apache.commons.math3.ml.neuralnet.FeatureInitializer
            public double value() {
                double dValue = this.val$f.value(this.arg);
                this.arg += this.val$inc;
                return dValue;
            }
        };
    }

    public static FeatureInitializer randomize(final RealDistribution realDistribution, final FeatureInitializer featureInitializer) {
        return new FeatureInitializer() { // from class: org.apache.commons.math3.ml.neuralnet.FeatureInitializerFactory.2
            @Override // org.apache.commons.math3.ml.neuralnet.FeatureInitializer
            public double value() {
                return realDistribution.sample() + featureInitializer.value();
            }
        };
    }

    public static FeatureInitializer uniform(RandomGenerator randomGenerator, double d, double d6) {
        return randomize(new UniformRealDistribution(randomGenerator, d, d6), function(new Constant(0.0d), 0.0d, 0.0d));
    }

    public static FeatureInitializer uniform(double d, double d6) {
        return randomize(new UniformRealDistribution(d, d6), function(new Constant(0.0d), 0.0d, 0.0d));
    }
}
