package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.SimpleValueChecker;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SimplexOptimizer extends MultivariateOptimizer {
    private AbstractSimplex simplex;

    public SimplexOptimizer(ConvergenceChecker<PointValuePair> convergenceChecker) {
        super(convergenceChecker);
    }

    private void checkParameters() {
        if (this.simplex == null) {
            throw new NullArgumentException();
        }
        if (getLowerBound() != null || getUpperBound() != null) {
            throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
        }
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public void parseOptimizationData(OptimizationData... optimizationDataArr) {
        super.parseOptimizationData(optimizationDataArr);
        for (OptimizationData optimizationData : optimizationDataArr) {
            if (optimizationData instanceof AbstractSimplex) {
                this.simplex = (AbstractSimplex) optimizationData;
                return;
            }
        }
    }

    public SimplexOptimizer(double d, double d6) {
        this(new SimpleValueChecker(d, d6));
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair doOptimize() {
        checkParameters();
        MultivariateFunction multivariateFunction = new MultivariateFunction() { // from class: org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer.1
            @Override // org.apache.commons.math3.analysis.MultivariateFunction
            public double value(double[] dArr) {
                return SimplexOptimizer.this.computeObjectiveValue(dArr);
            }
        };
        final boolean z6 = getGoalType() == GoalType.MINIMIZE;
        Comparator<PointValuePair> comparator = new Comparator<PointValuePair>() { // from class: org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer.2
            @Override // java.util.Comparator
            public int compare(PointValuePair pointValuePair, PointValuePair pointValuePair2) {
                double dDoubleValue = pointValuePair.getValue().doubleValue();
                double dDoubleValue2 = pointValuePair2.getValue().doubleValue();
                return z6 ? Double.compare(dDoubleValue, dDoubleValue2) : Double.compare(dDoubleValue2, dDoubleValue);
            }
        };
        this.simplex.build(getStartPoint());
        this.simplex.evaluate(multivariateFunction, comparator);
        ConvergenceChecker<PointValuePair> convergenceChecker = getConvergenceChecker();
        PointValuePair[] points = null;
        while (true) {
            if (getIterations() > 0) {
                boolean z7 = true;
                for (int i5 = 0; i5 < this.simplex.getSize(); i5++) {
                    z7 = z7 && convergenceChecker.converged(0, points[i5], this.simplex.getPoint(i5));
                }
                if (z7) {
                    return this.simplex.getPoint(0);
                }
            }
            points = this.simplex.getPoints();
            this.simplex.iterate(multivariateFunction, comparator);
            incrementIterationCount();
        }
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... optimizationDataArr) {
        return super.optimize(optimizationDataArr);
    }
}
