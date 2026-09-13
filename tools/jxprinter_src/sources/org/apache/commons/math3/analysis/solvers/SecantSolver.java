package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SecantSolver extends AbstractUnivariateSolver {
    protected static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;

    public SecantSolver() {
        super(1.0E-6d);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public final double doSolve() {
        double d;
        double min = getMin();
        double max = getMax();
        double dComputeObjectiveValue = computeObjectiveValue(min);
        double dComputeObjectiveValue2 = computeObjectiveValue(max);
        double d6 = 0.0d;
        if (dComputeObjectiveValue == 0.0d) {
            return min;
        }
        if (dComputeObjectiveValue2 == 0.0d) {
            return max;
        }
        verifyBracketing(min, max);
        double functionValueAccuracy = getFunctionValueAccuracy();
        double absoluteAccuracy = getAbsoluteAccuracy();
        double relativeAccuracy = getRelativeAccuracy();
        double d7 = min;
        double d8 = max;
        double d9 = dComputeObjectiveValue;
        double d10 = dComputeObjectiveValue2;
        while (true) {
            d = d8 - (((d8 - d7) * d10) / (d10 - d9));
            double dComputeObjectiveValue3 = computeObjectiveValue(d);
            if (dComputeObjectiveValue3 == d6 || FastMath.abs(dComputeObjectiveValue3) <= functionValueAccuracy || FastMath.abs(d - d8) < FastMath.max(FastMath.abs(d) * relativeAccuracy, absoluteAccuracy)) {
                break;
            }
            d7 = d8;
            d8 = d;
            d9 = d10;
            d10 = dComputeObjectiveValue3;
            d6 = 0.0d;
        }
        return d;
    }

    public SecantSolver(double d) {
        super(d);
    }

    public SecantSolver(double d, double d6) {
        super(d, d6);
    }
}
