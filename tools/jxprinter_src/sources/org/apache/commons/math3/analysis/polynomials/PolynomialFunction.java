package org.apache.commons.math3.analysis.polynomials;

import androidx.collection.a;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PolynomialFunction implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction, Serializable {
    private static final long serialVersionUID = -7726511984200295583L;
    private final double[] coefficients;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Parametric implements ParametricUnivariateFunction {
        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double d, double... dArr) {
            double[] dArr2 = new double[dArr.length];
            double d6 = 1.0d;
            for (int i5 = 0; i5 < dArr.length; i5++) {
                dArr2[i5] = d6;
                d6 *= d;
            }
            return dArr2;
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double d, double... dArr) {
            return PolynomialFunction.evaluate(dArr, d);
        }
    }

    public PolynomialFunction(double[] dArr) {
        MathUtils.checkNotNull(dArr);
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        while (length > 1 && dArr[length - 1] == 0.0d) {
            length--;
        }
        double[] dArr2 = new double[length];
        this.coefficients = dArr2;
        System.arraycopy(dArr, 0, dArr2, 0, length);
    }

    public static double[] differentiate(double[] dArr) {
        MathUtils.checkNotNull(dArr);
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        if (length == 1) {
            return new double[]{0.0d};
        }
        int i5 = length - 1;
        double[] dArr2 = new double[i5];
        while (i5 > 0) {
            dArr2[i5 - 1] = ((double) i5) * dArr[i5];
            i5--;
        }
        return dArr2;
    }

    public static double evaluate(double[] dArr, double d) {
        MathUtils.checkNotNull(dArr);
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        double d6 = dArr[length - 1];
        for (int i5 = length - 2; i5 >= 0; i5--) {
            d6 = (d6 * d) + dArr[i5];
        }
        return d6;
    }

    public PolynomialFunction add(PolynomialFunction polynomialFunction) {
        int iMin = FastMath.min(this.coefficients.length, polynomialFunction.coefficients.length);
        int iMax = FastMath.max(this.coefficients.length, polynomialFunction.coefficients.length);
        double[] dArr = new double[iMax];
        for (int i5 = 0; i5 < iMin; i5++) {
            dArr[i5] = this.coefficients[i5] + polynomialFunction.coefficients[i5];
        }
        double[] dArr2 = this.coefficients;
        int length = dArr2.length;
        double[] dArr3 = polynomialFunction.coefficients;
        if (length < dArr3.length) {
            dArr2 = dArr3;
        }
        System.arraycopy(dArr2, iMin, dArr, iMin, iMax - iMin);
        return new PolynomialFunction(dArr);
    }

    public int degree() {
        return this.coefficients.length - 1;
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    public UnivariateFunction derivative() {
        return polynomialDerivative();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PolynomialFunction) && Arrays.equals(this.coefficients, ((PolynomialFunction) obj).coefficients);
    }

    public double[] getCoefficients() {
        return (double[]) this.coefficients.clone();
    }

    public int hashCode() {
        return Arrays.hashCode(this.coefficients) + 31;
    }

    public PolynomialFunction multiply(PolynomialFunction polynomialFunction) {
        int length = (this.coefficients.length + polynomialFunction.coefficients.length) - 1;
        double[] dArr = new double[length];
        int i5 = 0;
        while (i5 < length) {
            dArr[i5] = 0.0d;
            int i6 = i5 + 1;
            for (int iMax = FastMath.max(0, i6 - polynomialFunction.coefficients.length); iMax < FastMath.min(this.coefficients.length, i6); iMax++) {
                dArr[i5] = (this.coefficients[iMax] * polynomialFunction.coefficients[i5 - iMax]) + dArr[i5];
            }
            i5 = i6;
        }
        return new PolynomialFunction(dArr);
    }

    public PolynomialFunction negate() {
        double[] dArr = new double[this.coefficients.length];
        int i5 = 0;
        while (true) {
            double[] dArr2 = this.coefficients;
            if (i5 >= dArr2.length) {
                return new PolynomialFunction(dArr);
            }
            dArr[i5] = -dArr2[i5];
            i5++;
        }
    }

    public PolynomialFunction polynomialDerivative() {
        return new PolynomialFunction(differentiate(this.coefficients));
    }

    public PolynomialFunction subtract(PolynomialFunction polynomialFunction) {
        int iMin = FastMath.min(this.coefficients.length, polynomialFunction.coefficients.length);
        int iMax = FastMath.max(this.coefficients.length, polynomialFunction.coefficients.length);
        double[] dArr = new double[iMax];
        for (int i5 = 0; i5 < iMin; i5++) {
            dArr[i5] = this.coefficients[i5] - polynomialFunction.coefficients[i5];
        }
        double[] dArr2 = this.coefficients;
        if (dArr2.length < polynomialFunction.coefficients.length) {
            while (iMin < iMax) {
                dArr[iMin] = -polynomialFunction.coefficients[iMin];
                iMin++;
            }
        } else {
            System.arraycopy(dArr2, iMin, dArr, iMin, iMax - iMin);
        }
        return new PolynomialFunction(dArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        double[] dArr = this.coefficients;
        double d = dArr[0];
        if (d != 0.0d) {
            sb.append(toString(d));
        } else if (dArr.length == 1) {
            return "0";
        }
        int i5 = 1;
        while (true) {
            double[] dArr2 = this.coefficients;
            if (i5 >= dArr2.length) {
                return sb.toString();
            }
            if (dArr2[i5] != 0.0d) {
                if (sb.length() > 0) {
                    if (this.coefficients[i5] < 0.0d) {
                        sb.append(" - ");
                    } else {
                        sb.append(" + ");
                    }
                } else if (this.coefficients[i5] < 0.0d) {
                    sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                }
                double dAbs = FastMath.abs(this.coefficients[i5]);
                if (dAbs - 1.0d != 0.0d) {
                    sb.append(toString(dAbs));
                    sb.append(Chars.SPACE);
                }
                sb.append("x");
                if (i5 > 1) {
                    sb.append('^');
                    sb.append(Integer.toString(i5));
                }
            }
            i5++;
        }
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        return evaluate(this.coefficients, d);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        MathUtils.checkNotNull(this.coefficients);
        int length = this.coefficients.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(derivativeStructure.getFreeParameters(), derivativeStructure.getOrder(), this.coefficients[length - 1]);
        for (int i5 = length - 2; i5 >= 0; i5--) {
            derivativeStructure2 = derivativeStructure2.multiply(derivativeStructure).add(this.coefficients[i5]);
        }
        return derivativeStructure2;
    }

    private static String toString(double d) {
        String string = Double.toString(d);
        return string.endsWith(".0") ? a.g(2, 0, string) : string;
    }
}
