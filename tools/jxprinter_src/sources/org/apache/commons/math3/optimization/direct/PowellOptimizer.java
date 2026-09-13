package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.univariate.BracketFinder;
import org.apache.commons.math3.optimization.univariate.BrentOptimizer;
import org.apache.commons.math3.optimization.univariate.SimpleUnivariateValueChecker;
import org.apache.commons.math3.optimization.univariate.UnivariatePointValuePair;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class PowellOptimizer extends BaseAbstractMultivariateOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    private static final double MIN_RELATIVE_TOLERANCE = FastMath.ulp(1.0d) * 2.0d;
    private final double absoluteThreshold;
    private final LineSearch line;
    private final double relativeThreshold;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class LineSearch extends BrentOptimizer {
        private static final double ABS_TOL_UNUSED = Double.MIN_VALUE;
        private static final double REL_TOL_UNUSED = 1.0E-15d;
        private final BracketFinder bracket;

        public LineSearch(double d, double d6) {
            super(1.0E-15d, ABS_TOL_UNUSED, new SimpleUnivariateValueChecker(d, d6));
            this.bracket = new BracketFinder();
        }

        public UnivariatePointValuePair search(final double[] dArr, final double[] dArr2) {
            final int length = dArr.length;
            UnivariateFunction univariateFunction = new UnivariateFunction() { // from class: org.apache.commons.math3.optimization.direct.PowellOptimizer.LineSearch.1
                @Override // org.apache.commons.math3.analysis.UnivariateFunction
                public double value(double d) {
                    double[] dArr3 = new double[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        dArr3[i5] = (dArr2[i5] * d) + dArr[i5];
                    }
                    return PowellOptimizer.this.computeObjectiveValue(dArr3);
                }
            };
            GoalType goalType = PowellOptimizer.this.getGoalType();
            this.bracket.search(univariateFunction, goalType, 0.0d, 1.0d);
            return optimize(Integer.MAX_VALUE, univariateFunction, goalType, this.bracket.getLo(), this.bracket.getHi(), this.bracket.getMid());
        }
    }

    public PowellOptimizer(double d, double d6, ConvergenceChecker<PointValuePair> convergenceChecker) {
        this(d, d6, FastMath.sqrt(d), FastMath.sqrt(d6), convergenceChecker);
    }

    private double[][] newPointAndDirection(double[] dArr, double[] dArr2, double d) {
        int length = dArr.length;
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            double d6 = dArr2[i5] * d;
            dArr4[i5] = d6;
            dArr3[i5] = dArr[i5] + d6;
        }
        return new double[][]{dArr3, dArr4};
    }

    /* JADX WARN: Code duplicated, block: B:38:0x011b  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a8, code lost:
    
        r12 = r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v6 */
    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.apache.commons.math3.optimization.PointValuePair doOptimize() {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.math3.optimization.direct.PowellOptimizer.doOptimize():org.apache.commons.math3.optimization.PointValuePair");
    }

    public PowellOptimizer(double d, double d6, double d7, double d8, ConvergenceChecker<PointValuePair> convergenceChecker) {
        super(convergenceChecker);
        double d9 = MIN_RELATIVE_TOLERANCE;
        if (d < d9) {
            throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(d9), true);
        }
        if (d6 <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d6));
        }
        this.relativeThreshold = d;
        this.absoluteThreshold = d6;
        this.line = new LineSearch(d7, d8);
    }

    public PowellOptimizer(double d, double d6) {
        this(d, d6, null);
    }

    public PowellOptimizer(double d, double d6, double d7, double d8) {
        this(d, d6, d7, d8, null);
    }
}
