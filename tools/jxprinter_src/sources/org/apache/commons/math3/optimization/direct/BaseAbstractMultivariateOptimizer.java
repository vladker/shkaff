package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.BaseMultivariateOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleBounds;
import org.apache.commons.math3.optimization.SimpleValueChecker;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class BaseAbstractMultivariateOptimizer<FUNC extends MultivariateFunction> implements BaseMultivariateOptimizer<FUNC> {
    private ConvergenceChecker<PointValuePair> checker;
    protected final Incrementor evaluations;
    private MultivariateFunction function;
    private GoalType goal;
    private double[] lowerBound;
    private double[] start;
    private double[] upperBound;

    @Deprecated
    public BaseAbstractMultivariateOptimizer() {
        this(new SimpleValueChecker());
    }

    private void checkParameters() {
        double[] dArr = this.start;
        if (dArr != null) {
            int length = dArr.length;
            double[] dArr2 = this.lowerBound;
            if (dArr2 != null) {
                if (dArr2.length != length) {
                    throw new DimensionMismatchException(this.lowerBound.length, length);
                }
                for (int i5 = 0; i5 < length; i5++) {
                    double d = this.start[i5];
                    double d6 = this.lowerBound[i5];
                    if (d < d6) {
                        throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(d6), true);
                    }
                }
            }
            double[] dArr3 = this.upperBound;
            if (dArr3 != null) {
                if (dArr3.length != length) {
                    throw new DimensionMismatchException(this.upperBound.length, length);
                }
                for (int i6 = 0; i6 < length; i6++) {
                    double d7 = this.start[i6];
                    double d8 = this.upperBound[i6];
                    if (d7 > d8) {
                        throw new NumberIsTooLargeException(Double.valueOf(d7), Double.valueOf(d8), true);
                    }
                }
            }
            if (this.lowerBound == null) {
                this.lowerBound = new double[length];
                for (int i7 = 0; i7 < length; i7++) {
                    this.lowerBound[i7] = Double.NEGATIVE_INFINITY;
                }
            }
            if (this.upperBound == null) {
                this.upperBound = new double[length];
                for (int i8 = 0; i8 < length; i8++) {
                    this.upperBound[i8] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }

    private void parseOptimizationData(OptimizationData... optimizationDataArr) {
        for (OptimizationData optimizationData : optimizationDataArr) {
            if (optimizationData instanceof InitialGuess) {
                this.start = ((InitialGuess) optimizationData).getInitialGuess();
            } else if (optimizationData instanceof SimpleBounds) {
                SimpleBounds simpleBounds = (SimpleBounds) optimizationData;
                this.lowerBound = simpleBounds.getLower();
                this.upperBound = simpleBounds.getUpper();
            }
        }
    }

    public double computeObjectiveValue(double[] dArr) {
        try {
            this.evaluations.incrementCount();
            return this.function.value(dArr);
        } catch (MaxCountExceededException e) {
            throw new TooManyEvaluationsException(e.getMax());
        }
    }

    public abstract PointValuePair doOptimize();

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<PointValuePair> getConvergenceChecker() {
        return this.checker;
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    public GoalType getGoalType() {
        return this.goal;
    }

    public double[] getLowerBound() {
        double[] dArr = this.lowerBound;
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    public double[] getStartPoint() {
        double[] dArr = this.start;
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public double[] getUpperBound() {
        double[] dArr = this.upperBound;
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateOptimizer
    @Deprecated
    public PointValuePair optimize(int i5, FUNC func, GoalType goalType, double[] dArr) {
        return optimizeInternal(i5, func, goalType, new InitialGuess(dArr));
    }

    @Deprecated
    public PointValuePair optimizeInternal(int i5, FUNC func, GoalType goalType, double[] dArr) {
        return optimizeInternal(i5, func, goalType, new InitialGuess(dArr));
    }

    public BaseAbstractMultivariateOptimizer(ConvergenceChecker<PointValuePair> convergenceChecker) {
        this.evaluations = new Incrementor();
        this.checker = convergenceChecker;
    }

    public PointValuePair optimize(int i5, FUNC func, GoalType goalType, OptimizationData... optimizationDataArr) {
        return optimizeInternal(i5, func, goalType, optimizationDataArr);
    }

    public PointValuePair optimizeInternal(int i5, FUNC func, GoalType goalType, OptimizationData... optimizationDataArr) {
        this.evaluations.setMaximalCount(i5);
        this.evaluations.resetCount();
        this.function = func;
        this.goal = goalType;
        parseOptimizationData(optimizationDataArr);
        checkParameters();
        return doOptimize();
    }
}
