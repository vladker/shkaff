package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RiddersSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public RiddersSolver() {
        this(1.0E-6d);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double doSolve() {
        RiddersSolver riddersSolver = this;
        double min = riddersSolver.getMin();
        double max = riddersSolver.getMax();
        double dComputeObjectiveValue = riddersSolver.computeObjectiveValue(min);
        double dComputeObjectiveValue2 = riddersSolver.computeObjectiveValue(max);
        double d = 0.0d;
        if (dComputeObjectiveValue == 0.0d) {
            return min;
        }
        if (dComputeObjectiveValue2 == 0.0d) {
            return max;
        }
        riddersSolver.verifyBracketing(min, max);
        double absoluteAccuracy = riddersSolver.getAbsoluteAccuracy();
        double functionValueAccuracy = riddersSolver.getFunctionValueAccuracy();
        double relativeAccuracy = riddersSolver.getRelativeAccuracy();
        double d6 = Double.POSITIVE_INFINITY;
        while (true) {
            double d7 = d;
            double d8 = (min + max) * 0.5d;
            double dComputeObjectiveValue3 = riddersSolver.computeObjectiveValue(d8);
            if (FastMath.abs(dComputeObjectiveValue3) <= functionValueAccuracy) {
                return d8;
            }
            double dSignum = FastMath.signum(dComputeObjectiveValue3) * FastMath.signum(dComputeObjectiveValue2);
            double dSqrt = ((d8 - min) * dSignum) / FastMath.sqrt(1.0d - ((dComputeObjectiveValue * dComputeObjectiveValue2) / (dComputeObjectiveValue3 * dComputeObjectiveValue3)));
            double d9 = min;
            double d10 = d8 - dSqrt;
            double dComputeObjectiveValue4 = riddersSolver.computeObjectiveValue(d10);
            if (FastMath.abs(d10 - d6) <= FastMath.max(FastMath.abs(d10) * relativeAccuracy, absoluteAccuracy) || FastMath.abs(dComputeObjectiveValue4) <= functionValueAccuracy) {
                return d10;
            }
            if (dSqrt > d7) {
                if (FastMath.signum(dComputeObjectiveValue4) + FastMath.signum(dComputeObjectiveValue) == d7) {
                    min = d9;
                    dComputeObjectiveValue2 = dComputeObjectiveValue4;
                    max = d10;
                } else {
                    max = d8;
                    dComputeObjectiveValue2 = dComputeObjectiveValue3;
                    dComputeObjectiveValue = dComputeObjectiveValue4;
                    min = d10;
                }
            } else {
                if (FastMath.signum(dComputeObjectiveValue4) + FastMath.signum(dComputeObjectiveValue2) == d7) {
                    dComputeObjectiveValue = dComputeObjectiveValue4;
                    min = d10;
                } else {
                    min = d8;
                    dComputeObjectiveValue = dComputeObjectiveValue3;
                    dComputeObjectiveValue2 = dComputeObjectiveValue4;
                    max = d10;
                }
            }
            riddersSolver = this;
            d = d7;
            d6 = d10;
        }
    }

    public RiddersSolver(double d) {
        super(d);
    }

    public RiddersSolver(double d, double d6) {
        super(d, d6);
    }
}
