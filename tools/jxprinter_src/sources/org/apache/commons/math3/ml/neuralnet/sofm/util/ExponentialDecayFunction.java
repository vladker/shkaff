package org.apache.commons.math3.ml.neuralnet.sofm.util;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExponentialDecayFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f6823a;
    private final double oneOverB;

    public ExponentialDecayFunction(double d, double d6, long j6) {
        if (d <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d));
        }
        if (d6 <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d6));
        }
        if (d6 >= d) {
            throw new NumberIsTooLargeException(Double.valueOf(d6), Double.valueOf(d), false);
        }
        if (j6 <= 0) {
            throw new NotStrictlyPositiveException(Long.valueOf(j6));
        }
        this.f6823a = d;
        this.oneOverB = (-FastMath.log(d6 / d)) / j6;
    }

    public double value(long j6) {
        return FastMath.exp((-j6) * this.oneOverB) * this.f6823a;
    }
}
