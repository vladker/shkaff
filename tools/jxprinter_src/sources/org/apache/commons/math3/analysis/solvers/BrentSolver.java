package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BrentSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public BrentSolver() {
        this(1.0E-6d);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00c9  */
    private double brent(double d, double d6, double d7, double d8) {
        double d9;
        double d10;
        double dComputeObjectiveValue;
        double d11;
        double d12;
        double d13;
        double d14;
        double absoluteAccuracy = getAbsoluteAccuracy();
        double relativeAccuracy = getRelativeAccuracy();
        double d15 = d;
        double d16 = d6;
        double d17 = d7;
        double d18 = d17;
        double d19 = d8;
        double d20 = d6 - d;
        double d21 = d20;
        double d22 = d15;
        while (true) {
            if (FastMath.abs(d17) < FastMath.abs(d19)) {
                d15 = d22;
                d22 = d16;
                d18 = d17;
                d17 = d19;
            } else {
                double d23 = d16;
                d16 = d15;
                d15 = d23;
                double d24 = d19;
                d19 = d18;
                d18 = d24;
            }
            double dAbs = (FastMath.abs(d15) * relativeAccuracy * 2.0d) + absoluteAccuracy;
            double d25 = (d22 - d15) * 0.5d;
            if (FastMath.abs(d25) <= dAbs) {
                break;
            }
            double d26 = d22;
            if (Precision.equals(d18, 0.0d)) {
                break;
            }
            if (FastMath.abs(d20) < dAbs || FastMath.abs(d19) <= FastMath.abs(d18)) {
                d9 = d25;
                d21 = d9;
            } else {
                double d27 = d18 / d19;
                if (d16 == d26) {
                    d13 = 2.0d * d25 * d27;
                    d14 = 1.0d - d27;
                } else {
                    double d28 = d19 / d17;
                    double d29 = d18 / d17;
                    double d30 = d28 - d29;
                    double d31 = d29 - 1.0d;
                    d13 = ((d30 * ((2.0d * d25) * d28)) - ((d15 - d16) * d31)) * d27;
                    d14 = (d27 - 1.0d) * (d28 - 1.0d) * d31;
                }
                double d32 = d13;
                double d33 = d14;
                if (d32 > 0.0d) {
                    d33 = -d33;
                } else {
                    d32 = -d32;
                }
                if (d32 >= ((1.5d * d25) * d33) - FastMath.abs(dAbs * d33) || d32 >= FastMath.abs(d20 * 0.5d * d33)) {
                    d9 = d25;
                    d21 = d9;
                } else {
                    d9 = d32 / d33;
                }
            }
            if (FastMath.abs(d9) > dAbs) {
                d10 = d15 + d9;
            } else {
                if (d25 > 0.0d) {
                    d10 = d15 + dAbs;
                } else {
                    d10 = d15 - dAbs;
                }
                dComputeObjectiveValue = computeObjectiveValue(d10);
                if ((dComputeObjectiveValue > r0 || d17 <= 0) && (dComputeObjectiveValue > r0 || d17 > r0)) {
                    d11 = d9;
                    d12 = d26;
                } else {
                    d21 = d10 - d15;
                    d11 = d21;
                    d17 = d18;
                    d12 = d15;
                }
                d22 = d12;
                d16 = d10;
                d19 = dComputeObjectiveValue;
                d20 = d21;
                d21 = d11;
            }
            dComputeObjectiveValue = computeObjectiveValue(d10);
            if (dComputeObjectiveValue > r0) {
                d11 = d9;
                d12 = d26;
            } else {
                d11 = d9;
                d12 = d26;
            }
            d22 = d12;
            d16 = d10;
            d19 = dComputeObjectiveValue;
            d20 = d21;
            d21 = d11;
        }
        return d15;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double doSolve() {
        double min = getMin();
        double max = getMax();
        double startValue = getStartValue();
        double functionValueAccuracy = getFunctionValueAccuracy();
        verifySequence(min, startValue, max);
        double dComputeObjectiveValue = computeObjectiveValue(startValue);
        if (FastMath.abs(dComputeObjectiveValue) <= functionValueAccuracy) {
            return startValue;
        }
        double dComputeObjectiveValue2 = computeObjectiveValue(min);
        if (FastMath.abs(dComputeObjectiveValue2) <= functionValueAccuracy) {
            return min;
        }
        if (dComputeObjectiveValue * dComputeObjectiveValue2 < 0.0d) {
            return brent(min, startValue, dComputeObjectiveValue2, dComputeObjectiveValue);
        }
        double dComputeObjectiveValue3 = computeObjectiveValue(max);
        if (FastMath.abs(dComputeObjectiveValue3) <= functionValueAccuracy) {
            return max;
        }
        if (dComputeObjectiveValue * dComputeObjectiveValue3 < 0.0d) {
            return brent(startValue, max, dComputeObjectiveValue, dComputeObjectiveValue3);
        }
        throw new NoBracketingException(min, max, dComputeObjectiveValue2, dComputeObjectiveValue3);
    }

    public BrentSolver(double d) {
        super(d);
    }

    public BrentSolver(double d, double d6) {
        super(d, d6);
    }

    public BrentSolver(double d, double d6, double d7) {
        super(d, d6, d7);
    }
}
