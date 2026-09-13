package org.apache.commons.math3.ml.neuralnet.sofm;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.ml.neuralnet.sofm.util.ExponentialDecayFunction;
import org.apache.commons.math3.ml.neuralnet.sofm.util.QuasiSigmoidDecayFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LearningFactorFunctionFactory {
    private LearningFactorFunctionFactory() {
    }

    public static LearningFactorFunction exponentialDecay(double d, double d6, long j6) {
        if (d <= 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        return new LearningFactorFunction(d, d6, j6) { // from class: org.apache.commons.math3.ml.neuralnet.sofm.LearningFactorFunctionFactory.1
            private final ExponentialDecayFunction decay;
            final /* synthetic */ double val$initValue;
            final /* synthetic */ long val$numCall;
            final /* synthetic */ double val$valueAtNumCall;

            {
                this.val$initValue = d;
                this.val$valueAtNumCall = d6;
                this.val$numCall = j6;
                this.decay = new ExponentialDecayFunction(d, d6, j6);
            }

            @Override // org.apache.commons.math3.ml.neuralnet.sofm.LearningFactorFunction
            public double value(long j7) {
                return this.decay.value(j7);
            }
        };
    }

    public static LearningFactorFunction quasiSigmoidDecay(double d, double d6, long j6) {
        if (d <= 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        return new LearningFactorFunction(d, d6, j6) { // from class: org.apache.commons.math3.ml.neuralnet.sofm.LearningFactorFunctionFactory.2
            private final QuasiSigmoidDecayFunction decay;
            final /* synthetic */ double val$initValue;
            final /* synthetic */ long val$numCall;
            final /* synthetic */ double val$slope;

            {
                this.val$initValue = d;
                this.val$slope = d6;
                this.val$numCall = j6;
                this.decay = new QuasiSigmoidDecayFunction(d, d6, j6);
            }

            @Override // org.apache.commons.math3.ml.neuralnet.sofm.LearningFactorFunction
            public double value(long j7) {
                return this.decay.value(j7);
            }
        };
    }
}
