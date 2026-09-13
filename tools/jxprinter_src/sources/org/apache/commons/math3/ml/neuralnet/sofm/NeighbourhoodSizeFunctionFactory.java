package org.apache.commons.math3.ml.neuralnet.sofm;

import org.apache.commons.math3.ml.neuralnet.sofm.util.ExponentialDecayFunction;
import org.apache.commons.math3.ml.neuralnet.sofm.util.QuasiSigmoidDecayFunction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NeighbourhoodSizeFunctionFactory {
    private NeighbourhoodSizeFunctionFactory() {
    }

    public static NeighbourhoodSizeFunction exponentialDecay(double d, double d6, long j6) {
        return new NeighbourhoodSizeFunction(d, d6, j6) { // from class: org.apache.commons.math3.ml.neuralnet.sofm.NeighbourhoodSizeFunctionFactory.1
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

            @Override // org.apache.commons.math3.ml.neuralnet.sofm.NeighbourhoodSizeFunction
            public int value(long j7) {
                return (int) FastMath.rint(this.decay.value(j7));
            }
        };
    }

    public static NeighbourhoodSizeFunction quasiSigmoidDecay(double d, double d6, long j6) {
        return new NeighbourhoodSizeFunction(d, d6, j6) { // from class: org.apache.commons.math3.ml.neuralnet.sofm.NeighbourhoodSizeFunctionFactory.2
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

            @Override // org.apache.commons.math3.ml.neuralnet.sofm.NeighbourhoodSizeFunction
            public int value(long j7) {
                return (int) FastMath.rint(this.decay.value(j7));
            }
        };
    }
}
