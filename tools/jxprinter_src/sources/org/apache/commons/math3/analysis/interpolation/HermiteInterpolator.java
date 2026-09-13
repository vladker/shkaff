package org.apache.commons.math3.analysis.interpolation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableVectorFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.CombinatoricsUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HermiteInterpolator implements UnivariateDifferentiableVectorFunction {
    private final List<Double> abscissae = new ArrayList();
    private final List<double[]> topDiagonal = new ArrayList();
    private final List<double[]> bottomDiagonal = new ArrayList();

    private void checkInterpolation() {
        if (this.abscissae.isEmpty()) {
            throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
        }
    }

    private PolynomialFunction polynomial(double... dArr) {
        return new PolynomialFunction(dArr);
    }

    public void addSamplePoint(double d, double[]... dArr) {
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double[] dArr2 = (double[]) dArr[i5].clone();
            if (i5 > 1) {
                double dFactorial = 1.0d / CombinatoricsUtils.factorial(i5);
                for (int i6 = 0; i6 < dArr2.length; i6++) {
                    dArr2[i6] = dArr2[i6] * dFactorial;
                }
            }
            int size = this.abscissae.size();
            this.bottomDiagonal.add(size - i5, dArr2);
            int i7 = i5;
            double[] dArr3 = dArr2;
            while (i7 < size) {
                i7++;
                int i8 = size - i7;
                double[] dArr4 = this.bottomDiagonal.get(i8);
                double dDoubleValue = 1.0d / (d - this.abscissae.get(i8).doubleValue());
                if (Double.isInfinite(dDoubleValue)) {
                    throw new ZeroException(LocalizedFormats.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO, Double.valueOf(d));
                }
                for (int i9 = 0; i9 < dArr2.length; i9++) {
                    dArr4[i9] = (dArr3[i9] - dArr4[i9]) * dDoubleValue;
                }
                dArr3 = dArr4;
            }
            this.topDiagonal.add((double[]) dArr3.clone());
            this.abscissae.add(Double.valueOf(d));
        }
    }

    public PolynomialFunction[] getPolynomials() {
        checkInterpolation();
        PolynomialFunction polynomialFunctionPolynomial = polynomial(0.0d);
        int length = this.topDiagonal.get(0).length;
        PolynomialFunction[] polynomialFunctionArr = new PolynomialFunction[length];
        for (int i5 = 0; i5 < length; i5++) {
            polynomialFunctionArr[i5] = polynomialFunctionPolynomial;
        }
        PolynomialFunction polynomialFunctionPolynomial2 = polynomial(1.0d);
        for (int i6 = 0; i6 < this.topDiagonal.size(); i6++) {
            double[] dArr = this.topDiagonal.get(i6);
            for (int i7 = 0; i7 < length; i7++) {
                polynomialFunctionArr[i7] = polynomialFunctionArr[i7].add(polynomialFunctionPolynomial2.multiply(polynomial(dArr[i7])));
            }
            polynomialFunctionPolynomial2 = polynomialFunctionPolynomial2.multiply(polynomial(-this.abscissae.get(i6).doubleValue(), 1.0d));
        }
        return polynomialFunctionArr;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateVectorFunction
    public double[] value(double d) {
        checkInterpolation();
        int length = this.topDiagonal.get(0).length;
        double[] dArr = new double[length];
        double dDoubleValue = 1.0d;
        for (int i5 = 0; i5 < this.topDiagonal.size(); i5++) {
            double[] dArr2 = this.topDiagonal.get(i5);
            for (int i6 = 0; i6 < length; i6++) {
                dArr[i6] = (dArr2[i6] * dDoubleValue) + dArr[i6];
            }
            dDoubleValue *= d - this.abscissae.get(i5).doubleValue();
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableVectorFunction
    public DerivativeStructure[] value(DerivativeStructure derivativeStructure) {
        checkInterpolation();
        int length = this.topDiagonal.get(0).length;
        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[length];
        Arrays.fill(derivativeStructureArr, derivativeStructure.getField().getZero());
        DerivativeStructure one = derivativeStructure.getField().getOne();
        for (int i5 = 0; i5 < this.topDiagonal.size(); i5++) {
            double[] dArr = this.topDiagonal.get(i5);
            for (int i6 = 0; i6 < length; i6++) {
                derivativeStructureArr[i6] = derivativeStructureArr[i6].add(one.multiply(dArr[i6]));
            }
            one = one.multiply(derivativeStructure.subtract(this.abscissae.get(i5).doubleValue()));
        }
        return derivativeStructureArr;
    }
}
