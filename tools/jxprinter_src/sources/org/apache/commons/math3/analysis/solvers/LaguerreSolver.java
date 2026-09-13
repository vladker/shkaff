package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexUtils;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LaguerreSolver extends AbstractPolynomialSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;
    private final ComplexSolver complexSolver;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ComplexSolver {
        private ComplexSolver() {
        }

        public boolean isRoot(double d, double d6, Complex complex) {
            if (LaguerreSolver.this.isSequence(d, complex.getReal(), d6)) {
                return FastMath.abs(complex.getImaginary()) <= FastMath.max(complex.abs() * LaguerreSolver.this.getRelativeAccuracy(), LaguerreSolver.this.getAbsoluteAccuracy()) || complex.abs() <= LaguerreSolver.this.getFunctionValueAccuracy();
            }
            return false;
        }

        public Complex solve(Complex[] complexArr, Complex complex) {
            long j6;
            Complex complexSubtract;
            Complex[] complexArr2 = complexArr;
            if (complexArr2 == null) {
                throw new NullArgumentException();
            }
            int length = complexArr2.length;
            int i5 = length - 1;
            if (i5 == 0) {
                throw new NoDataException(LocalizedFormats.POLYNOMIAL);
            }
            double absoluteAccuracy = LaguerreSolver.this.getAbsoluteAccuracy();
            double relativeAccuracy = LaguerreSolver.this.getRelativeAccuracy();
            double functionValueAccuracy = LaguerreSolver.this.getFunctionValueAccuracy();
            Complex complex2 = new Complex(i5, 0.0d);
            int i6 = length - 2;
            Complex complex3 = new Complex(i6, 0.0d);
            Complex complex4 = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
            Complex complex5 = complex;
            while (true) {
                Complex complexAdd = complexArr2[i5];
                Complex complexAdd2 = Complex.ZERO;
                Complex complexAdd3 = complexAdd2;
                for (int i7 = i6; i7 >= 0; i7--) {
                    complexAdd2 = complexAdd3.add(complex5.multiply(complexAdd2));
                    complexAdd3 = complexAdd.add(complex5.multiply(complexAdd3));
                    complexAdd = complexArr[i7].add(complex5.multiply(complexAdd));
                }
                int i8 = i6;
                int i9 = i5;
                double d = functionValueAccuracy;
                Complex complexMultiply = complexAdd2.multiply(new Complex(2.0d, 0.0d));
                if (complex5.subtract(complex4).abs() <= FastMath.max(complex5.abs() * relativeAccuracy, absoluteAccuracy) || complexAdd.abs() <= d) {
                    break;
                }
                Complex complexDivide = complexAdd3.divide(complexAdd);
                Complex complexMultiply2 = complexDivide.multiply(complexDivide);
                Complex complexSqrt = complex3.multiply(complex2.multiply(complexMultiply2.subtract(complexMultiply.divide(complexAdd))).subtract(complexMultiply2)).sqrt();
                Complex complexAdd4 = complexDivide.add(complexSqrt);
                Complex complexSubtract2 = complexDivide.subtract(complexSqrt);
                if (complexAdd4.abs() <= complexSubtract2.abs()) {
                    complexAdd4 = complexSubtract2;
                }
                if (complexAdd4.equals(new Complex(0.0d, 0.0d))) {
                    complexSubtract = complex5.add(new Complex(absoluteAccuracy, absoluteAccuracy));
                    j6 = 9218868437227405312L;
                    complex4 = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
                } else {
                    j6 = 9218868437227405312L;
                    complexSubtract = complex5.subtract(complex2.divide(complexAdd4));
                    complex4 = complex5;
                }
                complex5 = complexSubtract;
                LaguerreSolver.this.incrementEvaluationCount();
                complexArr2 = complexArr;
                i5 = i9;
                i6 = i8;
                functionValueAccuracy = d;
            }
            return complex5;
        }

        public Complex[] solveAll(Complex[] complexArr, Complex complex) {
            if (complexArr == null) {
                throw new NullArgumentException();
            }
            int length = complexArr.length;
            int i5 = length - 1;
            if (i5 == 0) {
                throw new NoDataException(LocalizedFormats.POLYNOMIAL);
            }
            Complex[] complexArr2 = new Complex[length];
            for (int i6 = 0; i6 <= i5; i6++) {
                complexArr2[i6] = complexArr[i6];
            }
            Complex[] complexArr3 = new Complex[i5];
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = i5 - i7;
                int i9 = i8 + 1;
                Complex[] complexArr4 = new Complex[i9];
                System.arraycopy(complexArr2, 0, complexArr4, 0, i9);
                complexArr3[i7] = solve(complexArr4, complex);
                Complex complexAdd = complexArr2[i8];
                for (int i10 = i8 - 1; i10 >= 0; i10--) {
                    Complex complex2 = complexArr2[i10];
                    complexArr2[i10] = complexAdd;
                    complexAdd = complex2.add(complexAdd.multiply(complexArr3[i7]));
                }
            }
            return complexArr3;
        }
    }

    public LaguerreSolver() {
        this(1.0E-6d);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double doSolve() {
        double min = getMin();
        double max = getMax();
        double startValue = getStartValue();
        double functionValueAccuracy = getFunctionValueAccuracy();
        verifySequence(min, startValue, max);
        double dComputeObjectiveValue = computeObjectiveValue(startValue);
        if (FastMath.abs(dComputeObjectiveValue) <= functionValueAccuracy) {
            return startValue;
        }
        double dComputeObjectiveValue2 = computeObjectiveValue(min);
        if (FastMath.abs(dComputeObjectiveValue2) <= functionValueAccuracy) {
            return min;
        }
        if (dComputeObjectiveValue * dComputeObjectiveValue2 < 0.0d) {
            return laguerre(min, startValue, dComputeObjectiveValue2, dComputeObjectiveValue);
        }
        double dComputeObjectiveValue3 = computeObjectiveValue(max);
        if (FastMath.abs(dComputeObjectiveValue3) <= functionValueAccuracy) {
            return max;
        }
        if (dComputeObjectiveValue * dComputeObjectiveValue3 < 0.0d) {
            return laguerre(startValue, max, dComputeObjectiveValue, dComputeObjectiveValue3);
        }
        throw new NoBracketingException(min, max, dComputeObjectiveValue2, dComputeObjectiveValue3);
    }

    @Deprecated
    public double laguerre(double d, double d6, double d7, double d8) {
        Complex[] complexArrConvertToComplex = ComplexUtils.convertToComplex(getCoefficients());
        Complex complex = new Complex((d + d6) * 0.5d, 0.0d);
        Complex complexSolve = this.complexSolver.solve(complexArrConvertToComplex, complex);
        if (this.complexSolver.isRoot(d, d6, complexSolve)) {
            return complexSolve.getReal();
        }
        Complex[] complexArrSolveAll = this.complexSolver.solveAll(complexArrConvertToComplex, complex);
        for (int i5 = 0; i5 < complexArrSolveAll.length; i5++) {
            if (this.complexSolver.isRoot(d, d6, complexArrSolveAll[i5])) {
                return complexArrSolveAll[i5].getReal();
            }
        }
        return Double.NaN;
    }

    public Complex[] solveAllComplex(double[] dArr, double d) {
        return solveAllComplex(dArr, d, Integer.MAX_VALUE);
    }

    public Complex solveComplex(double[] dArr, double d) {
        return solveComplex(dArr, d, Integer.MAX_VALUE);
    }

    public LaguerreSolver(double d) {
        super(d);
        this.complexSolver = new ComplexSolver();
    }

    public Complex[] solveAllComplex(double[] dArr, double d, int i5) {
        setup(i5, new PolynomialFunction(dArr), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, d);
        return this.complexSolver.solveAll(ComplexUtils.convertToComplex(dArr), new Complex(d, 0.0d));
    }

    public Complex solveComplex(double[] dArr, double d, int i5) {
        setup(i5, new PolynomialFunction(dArr), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, d);
        return this.complexSolver.solve(ComplexUtils.convertToComplex(dArr), new Complex(d, 0.0d));
    }

    public LaguerreSolver(double d, double d6) {
        super(d, d6);
        this.complexSolver = new ComplexSolver();
    }

    public LaguerreSolver(double d, double d6, double d7) {
        super(d, d6, d7);
        this.complexSolver = new ComplexSolver();
    }
}
