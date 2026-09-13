package org.apache.commons.math3.ml.neuralnet.sofm.util;

import org.apache.commons.math3.analysis.function.Logistic;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class QuasiSigmoidDecayFunction {
    private final double scale;
    private final Logistic sigmoid;

    public QuasiSigmoidDecayFunction(double d, double d6, long j6) {
        if (d <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d));
        }
        if (d6 >= 0.0d) {
            throw new NumberIsTooLargeException(Double.valueOf(d6), 0, false);
        }
        if (j6 <= 1) {
            throw new NotStrictlyPositiveException(Long.valueOf(j6));
        }
        Logistic logistic = new Logistic(d, j6, (4.0d * d6) / d, 1.0d, 0.0d, 1.0d);
        this.sigmoid = logistic;
        this.scale = d / logistic.value(0.0d);
    }

    public double value(long j6) {
        return this.sigmoid.value(j6) * this.scale;
    }
}
