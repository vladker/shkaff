package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MullerSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public MullerSolver() {
        this(1.0E-6d);
    }

    private double solve(double d, double d6, double d7, double d8) {
        double d9;
        MullerSolver mullerSolver = this;
        double relativeAccuracy = mullerSolver.getRelativeAccuracy();
        double absoluteAccuracy = mullerSolver.getAbsoluteAccuracy();
        double functionValueAccuracy = mullerSolver.getFunctionValueAccuracy();
        double d10 = 0.5d;
        double d11 = (d + d6) * 0.5d;
        double d12 = d7;
        double d13 = d8;
        double d14 = d11;
        double dComputeObjectiveValue = mullerSolver.computeObjectiveValue(d11);
        double d15 = Double.POSITIVE_INFINITY;
        double d16 = d;
        double d17 = d6;
        while (true) {
            double d18 = d14 - d16;
            double d19 = (dComputeObjectiveValue - d12) / d18;
            double d20 = d17 - d14;
            double d21 = d17 - d16;
            double d22 = (((d13 - dComputeObjectiveValue) / d20) - d19) / d21;
            double d23 = (d18 * d22) + d19;
            double d24 = (d23 * d23) - ((4.0d * dComputeObjectiveValue) * d22);
            double d25 = (-2.0d) * dComputeObjectiveValue;
            double dSqrt = (d25 / (FastMath.sqrt(d24) + d23)) + d14;
            double dSqrt2 = (d25 / (d23 - FastMath.sqrt(d24))) + d14;
            MullerSolver mullerSolver2 = mullerSolver;
            double d26 = d10;
            d9 = mullerSolver2.isSequence(d16, dSqrt, d17) ? dSqrt : dSqrt2;
            double dComputeObjectiveValue2 = mullerSolver2.computeObjectiveValue(d9);
            double d27 = relativeAccuracy;
            if (FastMath.abs(d9 - d15) <= FastMath.max(FastMath.abs(d9) * d27, absoluteAccuracy) || FastMath.abs(dComputeObjectiveValue2) <= functionValueAccuracy) {
                break;
            }
            if ((d9 >= d14 || d18 <= d21 * 0.95d) && ((d9 <= d14 || d20 <= d21 * 0.95d) && d9 != d14)) {
                if (d9 >= d14) {
                    d16 = d14;
                }
                if (d9 >= d14) {
                    d12 = dComputeObjectiveValue;
                }
                if (d9 <= d14) {
                    d17 = d14;
                }
                if (d9 <= d14) {
                    d13 = dComputeObjectiveValue;
                }
                d14 = d9;
                d15 = d14;
                dComputeObjectiveValue = dComputeObjectiveValue2;
            } else {
                double d28 = (d16 + d17) * d26;
                double dComputeObjectiveValue3 = mullerSolver2.computeObjectiveValue(d28);
                if (FastMath.signum(dComputeObjectiveValue3) + FastMath.signum(d12) == 0.0d) {
                    d17 = d28;
                    d13 = dComputeObjectiveValue3;
                } else {
                    d16 = d28;
                    d12 = dComputeObjectiveValue3;
                }
                double d29 = (d16 + d17) * d26;
                d14 = d29;
                dComputeObjectiveValue = mullerSolver2.computeObjectiveValue(d29);
                d15 = Double.POSITIVE_INFINITY;
            }
            mullerSolver = mullerSolver2;
            d10 = d26;
            relativeAccuracy = d27;
        }
        return d9;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double doSolve() {
        double min = getMin();
        double max = getMax();
        double startValue = getStartValue();
        double functionValueAccuracy = getFunctionValueAccuracy();
        verifySequence(min, startValue, max);
        double dComputeObjectiveValue = computeObjectiveValue(min);
        if (FastMath.abs(dComputeObjectiveValue) < functionValueAccuracy) {
            return min;
        }
        double dComputeObjectiveValue2 = computeObjectiveValue(max);
        if (FastMath.abs(dComputeObjectiveValue2) < functionValueAccuracy) {
            return max;
        }
        double dComputeObjectiveValue3 = computeObjectiveValue(startValue);
        if (FastMath.abs(dComputeObjectiveValue3) < functionValueAccuracy) {
            return startValue;
        }
        verifyBracketing(min, max);
        return isBracketing(min, startValue) ? solve(min, startValue, dComputeObjectiveValue, dComputeObjectiveValue3) : solve(startValue, max, dComputeObjectiveValue3, dComputeObjectiveValue2);
    }

    public MullerSolver(double d) {
        super(d);
    }

    public MullerSolver(double d, double d6) {
        super(d, d6);
    }
}
