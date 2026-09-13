package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseMultiStartMultivariateOptimizer<PAIR> extends BaseMultivariateOptimizer<PAIR> {
    private RandomVectorGenerator generator;
    private int initialGuessIndex;
    private int maxEvalIndex;
    private OptimizationData[] optimData;
    private final BaseMultivariateOptimizer<PAIR> optimizer;
    private int starts;
    private int totalEvaluations;

    public BaseMultiStartMultivariateOptimizer(BaseMultivariateOptimizer<PAIR> baseMultivariateOptimizer, int i5, RandomVectorGenerator randomVectorGenerator) {
        super(baseMultivariateOptimizer.getConvergenceChecker());
        this.maxEvalIndex = -1;
        this.initialGuessIndex = -1;
        if (i5 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.optimizer = baseMultivariateOptimizer;
        this.starts = i5;
        this.generator = randomVectorGenerator;
    }

    public abstract void clear();

    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PAIR doOptimize() {
        double[] dArr;
        int i5 = 0;
        while (true) {
            OptimizationData[] optimizationDataArr = this.optimData;
            if (i5 >= optimizationDataArr.length) {
                break;
            }
            if (optimizationDataArr[i5] instanceof MaxEval) {
                optimizationDataArr[i5] = null;
                this.maxEvalIndex = i5;
            }
            if (optimizationDataArr[i5] instanceof InitialGuess) {
                optimizationDataArr[i5] = null;
                this.initialGuessIndex = i5;
            }
            i5++;
        }
        if (this.maxEvalIndex == -1) {
            throw new MathIllegalStateException();
        }
        if (this.initialGuessIndex == -1) {
            throw new MathIllegalStateException();
        }
        this.totalEvaluations = 0;
        clear();
        int maxEvaluations = getMaxEvaluations();
        double[] lowerBound = getLowerBound();
        double[] upperBound = getUpperBound();
        double[] startPoint = getStartPoint();
        RuntimeException e = null;
        for (int i6 = 0; i6 < this.starts; i6++) {
            try {
                this.optimData[this.maxEvalIndex] = new MaxEval(maxEvaluations - this.totalEvaluations);
                if (i6 == 0) {
                    dArr = startPoint;
                } else {
                    int i7 = 0;
                    dArr = null;
                    while (dArr == null) {
                        int i8 = i7 + 1;
                        if (i7 >= getMaxEvaluations()) {
                            throw new TooManyEvaluationsException(Integer.valueOf(getMaxEvaluations()));
                        }
                        double[] dArrNextVector = this.generator.nextVector();
                        for (int i9 = 0; dArrNextVector != null && i9 < dArrNextVector.length; i9++) {
                            if (lowerBound != null && dArrNextVector[i9] < lowerBound[i9]) {
                                dArrNextVector = null;
                            } else if (upperBound != null && dArrNextVector[i9] > upperBound[i9]) {
                                dArrNextVector = null;
                            }
                        }
                        double[] dArr2 = dArrNextVector;
                        i7 = i8;
                        dArr = dArr2;
                    }
                }
                this.optimData[this.initialGuessIndex] = new InitialGuess(dArr);
                store(this.optimizer.optimize(this.optimData));
            } catch (RuntimeException e6) {
                e = e6;
            }
            this.totalEvaluations = this.optimizer.getEvaluations() + this.totalEvaluations;
        }
        PAIR[] optima = getOptima();
        if (optima.length != 0) {
            return optima[0];
        }
        throw e;
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public int getEvaluations() {
        return this.totalEvaluations;
    }

    public abstract PAIR[] getOptima();

    @Override // org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PAIR optimize(OptimizationData... optimizationDataArr) {
        this.optimData = optimizationDataArr;
        return (PAIR) super.optimize(optimizationDataArr);
    }

    public abstract void store(PAIR pair);
}
