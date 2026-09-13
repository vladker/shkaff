package org.apache.commons.math3.fitting;

import java.util.Collection;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresBuilder;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.linear.DiagonalMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PolynomialCurveFitter extends AbstractCurveFitter {
    private static final PolynomialFunction.Parametric FUNCTION = new PolynomialFunction.Parametric();
    private final double[] initialGuess;
    private final int maxIter;

    private PolynomialCurveFitter(double[] dArr, int i5) {
        this.initialGuess = dArr;
        this.maxIter = i5;
    }

    public static PolynomialCurveFitter create(int i5) {
        return new PolynomialCurveFitter(new double[i5 + 1], Integer.MAX_VALUE);
    }

    @Override // org.apache.commons.math3.fitting.AbstractCurveFitter
    public LeastSquaresProblem getProblem(Collection<WeightedObservedPoint> collection) {
        int size = collection.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i5 = 0;
        for (WeightedObservedPoint weightedObservedPoint : collection) {
            dArr[i5] = weightedObservedPoint.getY();
            dArr2[i5] = weightedObservedPoint.getWeight();
            i5++;
        }
        AbstractCurveFitter.TheoreticalValuesFunction theoreticalValuesFunction = new AbstractCurveFitter.TheoreticalValuesFunction(FUNCTION, collection);
        if (this.initialGuess != null) {
            return new LeastSquaresBuilder().maxEvaluations(Integer.MAX_VALUE).maxIterations(this.maxIter).start(this.initialGuess).target(dArr).weight(new DiagonalMatrix(dArr2)).model(theoreticalValuesFunction.getModelFunction(), theoreticalValuesFunction.getModelFunctionJacobian()).build();
        }
        throw new MathInternalError();
    }

    public PolynomialCurveFitter withMaxIterations(int i5) {
        return new PolynomialCurveFitter(this.initialGuess, i5);
    }

    public PolynomialCurveFitter withStartPoint(double[] dArr) {
        return new PolynomialCurveFitter((double[]) dArr.clone(), this.maxIter);
    }
}
