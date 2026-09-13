package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.SimpleVectorValueChecker;
import org.apache.commons.math3.optimization.Target;
import org.apache.commons.math3.optimization.Weight;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class BaseAbstractMultivariateVectorOptimizer<FUNC extends MultivariateVectorFunction> implements BaseMultivariateVectorOptimizer<FUNC> {
    private ConvergenceChecker<PointVectorValuePair> checker;
    protected final Incrementor evaluations;
    private FUNC function;
    private double[] start;
    private double[] target;

    @Deprecated
    private double[] weight;
    private RealMatrix weightMatrix;

    @Deprecated
    public BaseAbstractMultivariateVectorOptimizer() {
        this(new SimpleVectorValueChecker());
    }

    private void checkParameters() {
        if (this.target.length != this.weightMatrix.getColumnDimension()) {
            throw new DimensionMismatchException(this.target.length, this.weightMatrix.getColumnDimension());
        }
    }

    private void parseOptimizationData(OptimizationData... optimizationDataArr) {
        for (OptimizationData optimizationData : optimizationDataArr) {
            if (optimizationData instanceof Target) {
                this.target = ((Target) optimizationData).getTarget();
            } else if (optimizationData instanceof Weight) {
                this.weightMatrix = ((Weight) optimizationData).getWeight();
            } else if (optimizationData instanceof InitialGuess) {
                this.start = ((InitialGuess) optimizationData).getInitialGuess();
            }
        }
    }

    public double[] computeObjectiveValue(double[] dArr) {
        try {
            this.evaluations.incrementCount();
            return this.function.value(dArr);
        } catch (MaxCountExceededException e) {
            throw new TooManyEvaluationsException(e.getMax());
        }
    }

    public abstract PointVectorValuePair doOptimize();

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<PointVectorValuePair> getConvergenceChecker() {
        return this.checker;
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    public FUNC getObjectiveFunction() {
        return this.function;
    }

    public double[] getStartPoint() {
        return (double[]) this.start.clone();
    }

    public double[] getTarget() {
        return (double[]) this.target.clone();
    }

    @Deprecated
    public double[] getTargetRef() {
        return this.target;
    }

    public RealMatrix getWeight() {
        return this.weightMatrix.copy();
    }

    @Deprecated
    public double[] getWeightRef() {
        return this.weight;
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer
    @Deprecated
    public PointVectorValuePair optimize(int i5, FUNC func, double[] dArr, double[] dArr2, double[] dArr3) {
        return optimizeInternal(i5, func, dArr, dArr2, dArr3);
    }

    @Deprecated
    public PointVectorValuePair optimizeInternal(int i5, FUNC func, double[] dArr, double[] dArr2, double[] dArr3) {
        if (func == null) {
            throw new NullArgumentException();
        }
        if (dArr == null) {
            throw new NullArgumentException();
        }
        if (dArr2 == null) {
            throw new NullArgumentException();
        }
        if (dArr3 == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == dArr2.length) {
            return optimizeInternal(i5, func, new Target(dArr), new Weight(dArr2), new InitialGuess(dArr3));
        }
        throw new DimensionMismatchException(dArr.length, dArr2.length);
    }

    public void setUp() {
        int length = this.target.length;
        this.weight = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            this.weight[i5] = this.weightMatrix.getEntry(i5, i5);
        }
    }

    public BaseAbstractMultivariateVectorOptimizer(ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        this.evaluations = new Incrementor();
        this.checker = convergenceChecker;
    }

    public PointVectorValuePair optimize(int i5, FUNC func, OptimizationData... optimizationDataArr) {
        return optimizeInternal(i5, func, optimizationDataArr);
    }

    public PointVectorValuePair optimizeInternal(int i5, FUNC func, OptimizationData... optimizationDataArr) {
        this.evaluations.setMaximalCount(i5);
        this.evaluations.resetCount();
        this.function = func;
        parseOptimizationData(optimizationDataArr);
        checkParameters();
        setUp();
        return doOptimize();
    }
}
