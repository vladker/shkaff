package org.apache.commons.math3.util;

import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ContinuedFraction {
    private static final double DEFAULT_EPSILON = 1.0E-8d;

    public double evaluate(double d) {
        return evaluate(d, 1.0E-8d, Integer.MAX_VALUE);
    }

    public abstract double getA(int i5, double d);

    public abstract double getB(int i5, double d);

    public double evaluate(double d, double d6) {
        return evaluate(d, d6, Integer.MAX_VALUE);
    }

    public double evaluate(double d, int i5) {
        return evaluate(d, 1.0E-8d, i5);
    }

    public double evaluate(double d, double d6, int i5) {
        double a6 = getA(0, d);
        if (Precision.equals(a6, 0.0d, 1.0E-50d)) {
            a6 = 1.0E-50d;
        }
        int i6 = 1;
        double d7 = 0.0d;
        double d8 = a6;
        while (i6 < i5) {
            double a7 = getA(i6, d);
            double b = getB(i6, d);
            double d9 = (d7 * b) + a7;
            if (Precision.equals(d9, 0.0d, 1.0E-50d)) {
                d9 = 1.0E-50d;
            }
            double d10 = (b / a6) + a7;
            a6 = Precision.equals(d10, 0.0d, 1.0E-50d) ? 1.0E-50d : d10;
            double d11 = 1.0d / d9;
            double d12 = a6 * d11;
            d8 *= d12;
            if (!Double.isInfinite(d8)) {
                if (Double.isNaN(d8)) {
                    throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_NAN_DIVERGENCE, Double.valueOf(d));
                }
                if (FastMath.abs(d12 - 1.0d) < d6) {
                    break;
                }
                i6++;
                d7 = d11;
            } else {
                throw new ConvergenceException(LocalizedFormats.CONTINUED_FRACTION_INFINITY_DIVERGENCE, Double.valueOf(d));
            }
        }
        if (i6 < i5) {
            return d8;
        }
        throw new MaxCountExceededException(LocalizedFormats.NON_CONVERGENT_CONTINUED_FRACTION, Integer.valueOf(i5), Double.valueOf(d));
    }
}
