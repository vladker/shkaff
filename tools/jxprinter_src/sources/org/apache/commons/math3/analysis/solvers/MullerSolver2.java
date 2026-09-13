package org.apache.commons.math3.analysis.solvers;

import androidx.collection.a;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MullerSolver2 extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public MullerSolver2() {
        this(1.0E-6d);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double doSolve() {
        double dSqrt;
        double d;
        double d6;
        MullerSolver2 mullerSolver2 = this;
        double min = mullerSolver2.getMin();
        double max = mullerSolver2.getMax();
        mullerSolver2.verifyInterval(min, max);
        double relativeAccuracy = mullerSolver2.getRelativeAccuracy();
        double absoluteAccuracy = mullerSolver2.getAbsoluteAccuracy();
        double functionValueAccuracy = mullerSolver2.getFunctionValueAccuracy();
        double dComputeObjectiveValue = mullerSolver2.computeObjectiveValue(min);
        if (FastMath.abs(dComputeObjectiveValue) < functionValueAccuracy) {
            return min;
        }
        double dComputeObjectiveValue2 = mullerSolver2.computeObjectiveValue(max);
        if (FastMath.abs(dComputeObjectiveValue2) < functionValueAccuracy) {
            return max;
        }
        if (dComputeObjectiveValue * dComputeObjectiveValue2 > 0.0d) {
            throw new NoBracketingException(min, max, dComputeObjectiveValue, dComputeObjectiveValue2);
        }
        double d7 = min;
        double d8 = (min + max) * 0.5d;
        double d9 = max;
        double d10 = dComputeObjectiveValue;
        double dComputeObjectiveValue3 = mullerSolver2.computeObjectiveValue(d8);
        double dA = Double.POSITIVE_INFINITY;
        double d11 = dComputeObjectiveValue2;
        double d12 = d8;
        double d13 = d7;
        while (true) {
            double d14 = d12 - d9;
            double d15 = d14 / (d9 - d13);
            double d16 = d15 + 1.0d;
            double dB = a.B(d15, d10, dComputeObjectiveValue3 - (d16 * d11), d15);
            double dC = a.C(d15, d15, d10, a.B(d15, 2.0d, 1.0d, dComputeObjectiveValue3) - ((d16 * d16) * d11));
            double d17 = d16 * dComputeObjectiveValue3;
            double d18 = dC * dC;
            double d19 = d18 - ((dB * 4.0d) * d17);
            if (d19 >= 0.0d) {
                dSqrt = FastMath.sqrt(d19) + dC;
                double dSqrt2 = dC - FastMath.sqrt(d19);
                if (FastMath.abs(dSqrt) <= FastMath.abs(dSqrt2)) {
                    dSqrt = dSqrt2;
                }
            } else {
                dSqrt = FastMath.sqrt(d18 - d19);
            }
            if (dSqrt != 0.0d) {
                double d20 = d12 - (((d17 * 2.0d) * d14) / dSqrt);
                while (true) {
                    if (d20 != d9 && d20 != d12) {
                        break;
                    }
                    d20 += absoluteAccuracy;
                }
                double d21 = dA;
                dA = d20;
                d = d7;
                d6 = d21;
            } else {
                double d22 = max;
                double d23 = d7;
                dA = a.a(d22, d23, FastMath.random(), d7);
                max = d22;
                d = d23;
                d6 = Double.POSITIVE_INFINITY;
            }
            double dComputeObjectiveValue4 = mullerSolver2.computeObjectiveValue(dA);
            if (FastMath.abs(dA - d6) <= FastMath.max(FastMath.abs(dA) * relativeAccuracy, absoluteAccuracy) || FastMath.abs(dComputeObjectiveValue4) <= functionValueAccuracy) {
                break;
            }
            mullerSolver2 = this;
            d7 = d;
            d10 = d11;
            d11 = dComputeObjectiveValue3;
            d13 = d9;
            d9 = d12;
            dComputeObjectiveValue3 = dComputeObjectiveValue4;
            d12 = dA;
        }
        return dA;
    }

    public MullerSolver2(double d) {
        super(d);
    }

    public MullerSolver2(double d, double d6) {
        super(d, d6);
    }
}
