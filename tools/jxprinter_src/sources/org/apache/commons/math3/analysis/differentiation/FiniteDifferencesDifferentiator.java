package org.apache.commons.math3.analysis.differentiation;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateMatrixFunction;
import org.apache.commons.math3.analysis.UnivariateVectorFunction;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FiniteDifferencesDifferentiator implements UnivariateFunctionDifferentiator, UnivariateVectorFunctionDifferentiator, UnivariateMatrixFunctionDifferentiator, Serializable {
    private static final long serialVersionUID = 20120917;
    private final double halfSampleSpan;
    private final int nbPoints;
    private final double stepSize;
    private final double tMax;
    private final double tMin;

    public FiniteDifferencesDifferentiator(int i5, double d) {
        this(i5, d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DerivativeStructure evaluate(DerivativeStructure derivativeStructure, double d, double[] dArr) {
        int i5 = this.nbPoints;
        double[] dArr2 = new double[i5];
        double[] dArr3 = new double[i5];
        for (int i6 = 0; i6 < this.nbPoints; i6++) {
            dArr3[i6] = dArr[i6];
            for (int i7 = 1; i7 <= i6; i7++) {
                int i8 = i6 - i7;
                dArr3[i8] = (dArr3[i8 + 1] - dArr3[i8]) / (((double) i7) * this.stepSize);
            }
            dArr2[i6] = dArr3[0];
        }
        int order = derivativeStructure.getOrder();
        int freeParameters = derivativeStructure.getFreeParameters();
        double[] allDerivatives = derivativeStructure.getAllDerivatives();
        double value = derivativeStructure.getValue() - d;
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(freeParameters, order, 0.0d);
        DerivativeStructure derivativeStructureMultiply = null;
        for (int i9 = 0; i9 < this.nbPoints; i9++) {
            if (i9 == 0) {
                derivativeStructureMultiply = new DerivativeStructure(freeParameters, order, 1.0d);
            } else {
                allDerivatives[0] = value - (((double) (i9 - 1)) * this.stepSize);
                derivativeStructureMultiply = derivativeStructureMultiply.multiply(new DerivativeStructure(freeParameters, order, allDerivatives));
            }
            derivativeStructure2 = derivativeStructure2.add(derivativeStructureMultiply.multiply(dArr2[i9]));
        }
        return derivativeStructure2;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateFunctionDifferentiator
    public UnivariateDifferentiableFunction differentiate(final UnivariateFunction univariateFunction) {
        return new UnivariateDifferentiableFunction() { // from class: org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.1
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                return univariateFunction.value(d);
            }

            @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
            public DerivativeStructure value(DerivativeStructure derivativeStructure) {
                if (derivativeStructure.getOrder() >= FiniteDifferencesDifferentiator.this.nbPoints) {
                    throw new NumberIsTooLargeException(Integer.valueOf(derivativeStructure.getOrder()), Integer.valueOf(FiniteDifferencesDifferentiator.this.nbPoints), false);
                }
                double dMax = FastMath.max(FastMath.min(derivativeStructure.getValue(), FiniteDifferencesDifferentiator.this.tMax), FiniteDifferencesDifferentiator.this.tMin) - FiniteDifferencesDifferentiator.this.halfSampleSpan;
                double[] dArr = new double[FiniteDifferencesDifferentiator.this.nbPoints];
                for (int i5 = 0; i5 < FiniteDifferencesDifferentiator.this.nbPoints; i5++) {
                    dArr[i5] = univariateFunction.value((FiniteDifferencesDifferentiator.this.stepSize * ((double) i5)) + dMax);
                }
                return FiniteDifferencesDifferentiator.this.evaluate(derivativeStructure, dMax, dArr);
            }
        };
    }

    public int getNbPoints() {
        return this.nbPoints;
    }

    public double getStepSize() {
        return this.stepSize;
    }

    public FiniteDifferencesDifferentiator(int i5, double d, double d6, double d7) {
        if (i5 <= 1) {
            throw new NumberIsTooSmallException(Double.valueOf(d), 1, false);
        }
        this.nbPoints = i5;
        if (d <= 0.0d) {
            throw new NotPositiveException(Double.valueOf(d));
        }
        this.stepSize = d;
        double d8 = d * 0.5d * ((double) (i5 - 1));
        this.halfSampleSpan = d8;
        double d9 = d7 - d6;
        if (d8 * 2.0d >= d9) {
            throw new NumberIsTooLargeException(Double.valueOf(d8 * 2.0d), Double.valueOf(d9), false);
        }
        double dUlp = FastMath.ulp(d8);
        this.tMin = d6 + d8 + dUlp;
        this.tMax = (d7 - d8) - dUlp;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateVectorFunctionDifferentiator
    public UnivariateDifferentiableVectorFunction differentiate(final UnivariateVectorFunction univariateVectorFunction) {
        return new UnivariateDifferentiableVectorFunction() { // from class: org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.2
            @Override // org.apache.commons.math3.analysis.UnivariateVectorFunction
            public double[] value(double d) {
                return univariateVectorFunction.value(d);
            }

            @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableVectorFunction
            public DerivativeStructure[] value(DerivativeStructure derivativeStructure) {
                if (derivativeStructure.getOrder() >= FiniteDifferencesDifferentiator.this.nbPoints) {
                    throw new NumberIsTooLargeException(Integer.valueOf(derivativeStructure.getOrder()), Integer.valueOf(FiniteDifferencesDifferentiator.this.nbPoints), false);
                }
                double dMax = FastMath.max(FastMath.min(derivativeStructure.getValue(), FiniteDifferencesDifferentiator.this.tMax), FiniteDifferencesDifferentiator.this.tMin) - FiniteDifferencesDifferentiator.this.halfSampleSpan;
                double[][] dArr = null;
                for (int i5 = 0; i5 < FiniteDifferencesDifferentiator.this.nbPoints; i5++) {
                    double[] dArrValue = univariateVectorFunction.value((FiniteDifferencesDifferentiator.this.stepSize * ((double) i5)) + dMax);
                    if (i5 == 0) {
                        dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArrValue.length, FiniteDifferencesDifferentiator.this.nbPoints);
                    }
                    for (int i6 = 0; i6 < dArrValue.length; i6++) {
                        dArr[i6][i5] = dArrValue[i6];
                    }
                }
                int length = dArr.length;
                DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[length];
                for (int i7 = 0; i7 < length; i7++) {
                    derivativeStructureArr[i7] = FiniteDifferencesDifferentiator.this.evaluate(derivativeStructure, dMax, dArr[i7]);
                }
                return derivativeStructureArr;
            }
        };
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateMatrixFunctionDifferentiator
    public UnivariateDifferentiableMatrixFunction differentiate(final UnivariateMatrixFunction univariateMatrixFunction) {
        return new UnivariateDifferentiableMatrixFunction() { // from class: org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.3
            @Override // org.apache.commons.math3.analysis.UnivariateMatrixFunction
            public double[][] value(double d) {
                return univariateMatrixFunction.value(d);
            }

            @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableMatrixFunction
            public DerivativeStructure[][] value(DerivativeStructure derivativeStructure) {
                if (derivativeStructure.getOrder() >= FiniteDifferencesDifferentiator.this.nbPoints) {
                    throw new NumberIsTooLargeException(Integer.valueOf(derivativeStructure.getOrder()), Integer.valueOf(FiniteDifferencesDifferentiator.this.nbPoints), false);
                }
                double dMax = FastMath.max(FastMath.min(derivativeStructure.getValue(), FiniteDifferencesDifferentiator.this.tMax), FiniteDifferencesDifferentiator.this.tMin) - FiniteDifferencesDifferentiator.this.halfSampleSpan;
                double[][][] dArr = null;
                for (int i5 = 0; i5 < FiniteDifferencesDifferentiator.this.nbPoints; i5++) {
                    double[][] dArrValue = univariateMatrixFunction.value((FiniteDifferencesDifferentiator.this.stepSize * ((double) i5)) + dMax);
                    if (i5 == 0) {
                        dArr = (double[][][]) Array.newInstance((Class<?>) Double.TYPE, dArrValue.length, dArrValue[0].length, FiniteDifferencesDifferentiator.this.nbPoints);
                    }
                    for (int i6 = 0; i6 < dArrValue.length; i6++) {
                        int i7 = 0;
                        while (true) {
                            double[] dArr2 = dArrValue[i6];
                            if (i7 < dArr2.length) {
                                dArr[i6][i7][i5] = dArr2[i7];
                                i7++;
                            }
                        }
                    }
                }
                DerivativeStructure[][] derivativeStructureArr = (DerivativeStructure[][]) Array.newInstance((Class<?>) DerivativeStructure.class, dArr.length, dArr[0].length);
                for (int i8 = 0; i8 < derivativeStructureArr.length; i8++) {
                    int i9 = 0;
                    while (true) {
                        double[][] dArr3 = dArr[i8];
                        if (i9 < dArr3.length) {
                            derivativeStructureArr[i8][i9] = FiniteDifferencesDifferentiator.this.evaluate(derivativeStructure, dMax, dArr3[i9]);
                            i9++;
                        }
                    }
                }
                return derivativeStructureArr;
            }
        };
    }
}
