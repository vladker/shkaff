package org.apache.commons.math3.analysis;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.function.Identity;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FunctionUtils {
    private FunctionUtils() {
    }

    public static UnivariateFunction add(final UnivariateFunction... univariateFunctionArr) {
        return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.4
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                double dValue = univariateFunctionArr[0].value(d);
                int i5 = 1;
                while (true) {
                    UnivariateFunction[] univariateFunctionArr2 = univariateFunctionArr;
                    if (i5 >= univariateFunctionArr2.length) {
                        return dValue;
                    }
                    dValue += univariateFunctionArr2[i5].value(d);
                    i5++;
                }
            }
        };
    }

    public static MultivariateFunction collector(final BivariateFunction bivariateFunction, final UnivariateFunction univariateFunction, final double d) {
        return new MultivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.11
            @Override // org.apache.commons.math3.analysis.MultivariateFunction
            public double value(double[] dArr) {
                double dValue = bivariateFunction.value(d, univariateFunction.value(dArr[0]));
                for (int i5 = 1; i5 < dArr.length; i5++) {
                    dValue = bivariateFunction.value(dValue, univariateFunction.value(dArr[i5]));
                }
                return dValue;
            }
        };
    }

    public static UnivariateFunction combine(final BivariateFunction bivariateFunction, final UnivariateFunction univariateFunction, final UnivariateFunction univariateFunction2) {
        return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.10
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                return bivariateFunction.value(univariateFunction.value(d), univariateFunction2.value(d));
            }
        };
    }

    public static UnivariateFunction compose(final UnivariateFunction... univariateFunctionArr) {
        return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.1
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                for (int length = univariateFunctionArr.length - 1; length >= 0; length--) {
                    d = univariateFunctionArr[length].value(d);
                }
                return d;
            }
        };
    }

    public static UnivariateFunction fix1stArgument(final BivariateFunction bivariateFunction, final double d) {
        return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.12
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d6) {
                return bivariateFunction.value(d, d6);
            }
        };
    }

    public static UnivariateFunction fix2ndArgument(final BivariateFunction bivariateFunction, final double d) {
        return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.13
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d6) {
                return bivariateFunction.value(d6, d);
            }
        };
    }

    public static UnivariateFunction multiply(final UnivariateFunction... univariateFunctionArr) {
        return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.7
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                double dValue = univariateFunctionArr[0].value(d);
                int i5 = 1;
                while (true) {
                    UnivariateFunction[] univariateFunctionArr2 = univariateFunctionArr;
                    if (i5 >= univariateFunctionArr2.length) {
                        return dValue;
                    }
                    dValue *= univariateFunctionArr2[i5].value(d);
                    i5++;
                }
            }
        };
    }

    public static double[] sample(UnivariateFunction univariateFunction, double d, double d6, int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES, Integer.valueOf(i5));
        }
        if (d >= d6) {
            throw new NumberIsTooLargeException(Double.valueOf(d), Double.valueOf(d6), false);
        }
        double[] dArr = new double[i5];
        double d7 = (d6 - d) / ((double) i5);
        for (int i6 = 0; i6 < i5; i6++) {
            dArr[i6] = univariateFunction.value((((double) i6) * d7) + d);
        }
        return dArr;
    }

    @Deprecated
    public static DifferentiableMultivariateFunction toDifferentiableMultivariateFunction(final MultivariateDifferentiableFunction multivariateDifferentiableFunction) {
        return new DifferentiableMultivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.16
            @Override // org.apache.commons.math3.analysis.DifferentiableMultivariateFunction
            public MultivariateVectorFunction gradient() {
                return new MultivariateVectorFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.16.2
                    @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
                    public double[] value(double[] dArr) {
                        int length = dArr.length;
                        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[length];
                        for (int i5 = 0; i5 < length; i5++) {
                            derivativeStructureArr[i5] = new DerivativeStructure(length, 1, i5, dArr[i5]);
                        }
                        DerivativeStructure derivativeStructureValue = multivariateDifferentiableFunction.value(derivativeStructureArr);
                        double[] dArr2 = new double[length];
                        int[] iArr = new int[length];
                        for (int i6 = 0; i6 < length; i6++) {
                            iArr[i6] = 1;
                            dArr2[i6] = derivativeStructureValue.getPartialDerivative(iArr);
                            iArr[i6] = 0;
                        }
                        return dArr2;
                    }
                };
            }

            @Override // org.apache.commons.math3.analysis.DifferentiableMultivariateFunction
            public MultivariateFunction partialDerivative(final int i5) {
                return new MultivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.16.1
                    @Override // org.apache.commons.math3.analysis.MultivariateFunction
                    public double value(double[] dArr) {
                        int length = dArr.length;
                        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[length];
                        for (int i6 = 0; i6 < length; i6++) {
                            if (i6 == i5) {
                                derivativeStructureArr[i6] = new DerivativeStructure(1, 1, 0, dArr[i6]);
                            } else {
                                derivativeStructureArr[i6] = new DerivativeStructure(1, 1, dArr[i6]);
                            }
                        }
                        return multivariateDifferentiableFunction.value(derivativeStructureArr).getPartialDerivative(1);
                    }
                };
            }

            @Override // org.apache.commons.math3.analysis.MultivariateFunction
            public double value(double[] dArr) {
                return multivariateDifferentiableFunction.value(dArr);
            }
        };
    }

    @Deprecated
    public static DifferentiableMultivariateVectorFunction toDifferentiableMultivariateVectorFunction(final MultivariateDifferentiableVectorFunction multivariateDifferentiableVectorFunction) {
        return new DifferentiableMultivariateVectorFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.18
            @Override // org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction
            public MultivariateMatrixFunction jacobian() {
                return new MultivariateMatrixFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.18.1
                    @Override // org.apache.commons.math3.analysis.MultivariateMatrixFunction
                    public double[][] value(double[] dArr) {
                        int length = dArr.length;
                        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[length];
                        for (int i5 = 0; i5 < length; i5++) {
                            derivativeStructureArr[i5] = new DerivativeStructure(length, 1, i5, dArr[i5]);
                        }
                        DerivativeStructure[] derivativeStructureArrValue = multivariateDifferentiableVectorFunction.value(derivativeStructureArr);
                        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, derivativeStructureArrValue.length, length);
                        int[] iArr = new int[length];
                        for (int i6 = 0; i6 < derivativeStructureArrValue.length; i6++) {
                            for (int i7 = 0; i7 < length; i7++) {
                                iArr[i7] = 1;
                                dArr2[i6][i7] = derivativeStructureArrValue[i6].getPartialDerivative(iArr);
                                iArr[i7] = 0;
                            }
                        }
                        return dArr2;
                    }
                };
            }

            @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
            public double[] value(double[] dArr) {
                return multivariateDifferentiableVectorFunction.value(dArr);
            }
        };
    }

    @Deprecated
    public static DifferentiableUnivariateFunction toDifferentiableUnivariateFunction(final UnivariateDifferentiableFunction univariateDifferentiableFunction) {
        return new DifferentiableUnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.14
            @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
            public UnivariateFunction derivative() {
                return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.14.1
                    @Override // org.apache.commons.math3.analysis.UnivariateFunction
                    public double value(double d) {
                        return univariateDifferentiableFunction.value(new DerivativeStructure(1, 1, 0, d)).getPartialDerivative(1);
                    }
                };
            }

            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                return univariateDifferentiableFunction.value(d);
            }
        };
    }

    @Deprecated
    public static MultivariateDifferentiableFunction toMultivariateDifferentiableFunction(final DifferentiableMultivariateFunction differentiableMultivariateFunction) {
        return new MultivariateDifferentiableFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.17
            @Override // org.apache.commons.math3.analysis.MultivariateFunction
            public double value(double[] dArr) {
                return differentiableMultivariateFunction.value(dArr);
            }

            @Override // org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction
            public DerivativeStructure value(DerivativeStructure[] derivativeStructureArr) {
                int i5 = 0;
                int freeParameters = derivativeStructureArr[0].getFreeParameters();
                int order = derivativeStructureArr[0].getOrder();
                int length = derivativeStructureArr.length;
                if (order > 1) {
                    throw new NumberIsTooLargeException(Integer.valueOf(order), 1, true);
                }
                for (int i6 = 0; i6 < length; i6++) {
                    if (derivativeStructureArr[i6].getFreeParameters() != freeParameters) {
                        throw new DimensionMismatchException(derivativeStructureArr[i6].getFreeParameters(), freeParameters);
                    }
                    if (derivativeStructureArr[i6].getOrder() != order) {
                        throw new DimensionMismatchException(derivativeStructureArr[i6].getOrder(), order);
                    }
                }
                double[] dArr = new double[length];
                for (int i7 = 0; i7 < length; i7++) {
                    dArr[i7] = derivativeStructureArr[i7].getValue();
                }
                double dValue = differentiableMultivariateFunction.value(dArr);
                double[] dArrValue = differentiableMultivariateFunction.gradient().value(dArr);
                double[] dArr2 = new double[freeParameters + 1];
                dArr2[0] = dValue;
                int[] iArr = new int[freeParameters];
                for (int i8 = 0; i8 < freeParameters; i8++) {
                    iArr[i8] = 1;
                    int i9 = i5;
                    while (i9 < length) {
                        int i10 = i8 + 1;
                        dArr2[i10] = (derivativeStructureArr[i9].getPartialDerivative(iArr) * dArrValue[i9]) + dArr2[i10];
                        i9++;
                        i5 = i5;
                    }
                    iArr[i8] = i5;
                }
                return new DerivativeStructure(freeParameters, order, dArr2);
            }
        };
    }

    @Deprecated
    public static MultivariateDifferentiableVectorFunction toMultivariateDifferentiableVectorFunction(final DifferentiableMultivariateVectorFunction differentiableMultivariateVectorFunction) {
        return new MultivariateDifferentiableVectorFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.19
            @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
            public double[] value(double[] dArr) {
                return differentiableMultivariateVectorFunction.value(dArr);
            }

            @Override // org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction
            public DerivativeStructure[] value(DerivativeStructure[] derivativeStructureArr) {
                int i5 = 0;
                int freeParameters = derivativeStructureArr[0].getFreeParameters();
                int order = derivativeStructureArr[0].getOrder();
                int length = derivativeStructureArr.length;
                if (order > 1) {
                    throw new NumberIsTooLargeException(Integer.valueOf(order), 1, true);
                }
                for (int i6 = 0; i6 < length; i6++) {
                    if (derivativeStructureArr[i6].getFreeParameters() != freeParameters) {
                        throw new DimensionMismatchException(derivativeStructureArr[i6].getFreeParameters(), freeParameters);
                    }
                    if (derivativeStructureArr[i6].getOrder() != order) {
                        throw new DimensionMismatchException(derivativeStructureArr[i6].getOrder(), order);
                    }
                }
                double[] dArr = new double[length];
                for (int i7 = 0; i7 < length; i7++) {
                    dArr[i7] = derivativeStructureArr[i7].getValue();
                }
                double[] dArrValue = differentiableMultivariateVectorFunction.value(dArr);
                double[][] dArrValue2 = differentiableMultivariateVectorFunction.jacobian().value(dArr);
                int length2 = dArrValue.length;
                DerivativeStructure[] derivativeStructureArr2 = new DerivativeStructure[length2];
                int i8 = 0;
                while (i8 < length2) {
                    double[] dArr2 = new double[freeParameters + 1];
                    dArr2[i5] = dArrValue[i8];
                    int[] iArr = new int[freeParameters];
                    for (int i9 = i5; i9 < freeParameters; i9++) {
                        iArr[i9] = 1;
                        int i10 = i5;
                        while (i10 < length) {
                            int i11 = i9 + 1;
                            dArr2[i11] = (derivativeStructureArr[i10].getPartialDerivative(iArr) * dArrValue2[i8][i10]) + dArr2[i11];
                            i10++;
                            i5 = i5;
                        }
                        iArr[i9] = i5;
                    }
                    derivativeStructureArr2[i8] = new DerivativeStructure(freeParameters, order, dArr2);
                    i8++;
                    i5 = i5;
                }
                return derivativeStructureArr2;
            }
        };
    }

    @Deprecated
    public static UnivariateDifferentiableFunction toUnivariateDifferential(final DifferentiableUnivariateFunction differentiableUnivariateFunction) {
        return new UnivariateDifferentiableFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.15
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                return differentiableUnivariateFunction.value(d);
            }

            @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
            public DerivativeStructure value(DerivativeStructure derivativeStructure) {
                int order = derivativeStructure.getOrder();
                if (order == 0) {
                    return new DerivativeStructure(derivativeStructure.getFreeParameters(), 0, differentiableUnivariateFunction.value(derivativeStructure.getValue()));
                }
                if (order != 1) {
                    throw new NumberIsTooLargeException(Integer.valueOf(derivativeStructure.getOrder()), 1, true);
                }
                int freeParameters = derivativeStructure.getFreeParameters();
                double[] dArr = new double[freeParameters + 1];
                dArr[0] = differentiableUnivariateFunction.value(derivativeStructure.getValue());
                double dValue = differentiableUnivariateFunction.derivative().value(derivativeStructure.getValue());
                int[] iArr = new int[freeParameters];
                int i5 = 0;
                while (i5 < freeParameters) {
                    iArr[i5] = 1;
                    int i6 = i5 + 1;
                    dArr[i6] = derivativeStructure.getPartialDerivative(iArr) * dValue;
                    iArr[i5] = 0;
                    i5 = i6;
                }
                return new DerivativeStructure(freeParameters, 1, dArr);
            }
        };
    }

    public static UnivariateDifferentiableFunction add(final UnivariateDifferentiableFunction... univariateDifferentiableFunctionArr) {
        return new UnivariateDifferentiableFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.5
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                double dValue = univariateDifferentiableFunctionArr[0].value(d);
                int i5 = 1;
                while (true) {
                    UnivariateDifferentiableFunction[] univariateDifferentiableFunctionArr2 = univariateDifferentiableFunctionArr;
                    if (i5 >= univariateDifferentiableFunctionArr2.length) {
                        return dValue;
                    }
                    dValue += univariateDifferentiableFunctionArr2[i5].value(d);
                    i5++;
                }
            }

            @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
            public DerivativeStructure value(DerivativeStructure derivativeStructure) {
                DerivativeStructure derivativeStructureValue = univariateDifferentiableFunctionArr[0].value(derivativeStructure);
                int i5 = 1;
                while (true) {
                    UnivariateDifferentiableFunction[] univariateDifferentiableFunctionArr2 = univariateDifferentiableFunctionArr;
                    if (i5 >= univariateDifferentiableFunctionArr2.length) {
                        return derivativeStructureValue;
                    }
                    derivativeStructureValue = derivativeStructureValue.add(univariateDifferentiableFunctionArr2[i5].value(derivativeStructure));
                    i5++;
                }
            }
        };
    }

    public static MultivariateFunction collector(BivariateFunction bivariateFunction, double d) {
        return collector(bivariateFunction, new Identity(), d);
    }

    public static UnivariateDifferentiableFunction compose(final UnivariateDifferentiableFunction... univariateDifferentiableFunctionArr) {
        return new UnivariateDifferentiableFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.2
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                for (int length = univariateDifferentiableFunctionArr.length - 1; length >= 0; length--) {
                    d = univariateDifferentiableFunctionArr[length].value(d);
                }
                return d;
            }

            @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
            public DerivativeStructure value(DerivativeStructure derivativeStructure) {
                for (int length = univariateDifferentiableFunctionArr.length - 1; length >= 0; length--) {
                    derivativeStructure = univariateDifferentiableFunctionArr[length].value(derivativeStructure);
                }
                return derivativeStructure;
            }
        };
    }

    public static UnivariateDifferentiableFunction multiply(final UnivariateDifferentiableFunction... univariateDifferentiableFunctionArr) {
        return new UnivariateDifferentiableFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.8
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                double dValue = univariateDifferentiableFunctionArr[0].value(d);
                int i5 = 1;
                while (true) {
                    UnivariateDifferentiableFunction[] univariateDifferentiableFunctionArr2 = univariateDifferentiableFunctionArr;
                    if (i5 >= univariateDifferentiableFunctionArr2.length) {
                        return dValue;
                    }
                    dValue *= univariateDifferentiableFunctionArr2[i5].value(d);
                    i5++;
                }
            }

            @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
            public DerivativeStructure value(DerivativeStructure derivativeStructure) {
                DerivativeStructure derivativeStructureValue = univariateDifferentiableFunctionArr[0].value(derivativeStructure);
                int i5 = 1;
                while (true) {
                    UnivariateDifferentiableFunction[] univariateDifferentiableFunctionArr2 = univariateDifferentiableFunctionArr;
                    if (i5 >= univariateDifferentiableFunctionArr2.length) {
                        return derivativeStructureValue;
                    }
                    derivativeStructureValue = derivativeStructureValue.multiply(univariateDifferentiableFunctionArr2[i5].value(derivativeStructure));
                    i5++;
                }
            }
        };
    }

    @Deprecated
    public static DifferentiableUnivariateFunction add(final DifferentiableUnivariateFunction... differentiableUnivariateFunctionArr) {
        return new DifferentiableUnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.6
            @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
            public UnivariateFunction derivative() {
                return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.6.1
                    @Override // org.apache.commons.math3.analysis.UnivariateFunction
                    public double value(double d) {
                        double dValue = differentiableUnivariateFunctionArr[0].derivative().value(d);
                        int i5 = 1;
                        while (true) {
                            DifferentiableUnivariateFunction[] differentiableUnivariateFunctionArr2 = differentiableUnivariateFunctionArr;
                            if (i5 >= differentiableUnivariateFunctionArr2.length) {
                                return dValue;
                            }
                            dValue += differentiableUnivariateFunctionArr2[i5].derivative().value(d);
                            i5++;
                        }
                    }
                };
            }

            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                double dValue = differentiableUnivariateFunctionArr[0].value(d);
                int i5 = 1;
                while (true) {
                    DifferentiableUnivariateFunction[] differentiableUnivariateFunctionArr2 = differentiableUnivariateFunctionArr;
                    if (i5 >= differentiableUnivariateFunctionArr2.length) {
                        return dValue;
                    }
                    dValue += differentiableUnivariateFunctionArr2[i5].value(d);
                    i5++;
                }
            }
        };
    }

    @Deprecated
    public static DifferentiableUnivariateFunction compose(final DifferentiableUnivariateFunction... differentiableUnivariateFunctionArr) {
        return new DifferentiableUnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.3
            @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
            public UnivariateFunction derivative() {
                return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.3.1
                    @Override // org.apache.commons.math3.analysis.UnivariateFunction
                    public double value(double d) {
                        double dValue = 1.0d;
                        for (int length = differentiableUnivariateFunctionArr.length - 1; length >= 0; length--) {
                            dValue *= differentiableUnivariateFunctionArr[length].derivative().value(d);
                            d = differentiableUnivariateFunctionArr[length].value(d);
                        }
                        return dValue;
                    }
                };
            }

            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                for (int length = differentiableUnivariateFunctionArr.length - 1; length >= 0; length--) {
                    d = differentiableUnivariateFunctionArr[length].value(d);
                }
                return d;
            }
        };
    }

    @Deprecated
    public static DifferentiableUnivariateFunction multiply(final DifferentiableUnivariateFunction... differentiableUnivariateFunctionArr) {
        return new DifferentiableUnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.9
            @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
            public UnivariateFunction derivative() {
                return new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.FunctionUtils.9.1
                    @Override // org.apache.commons.math3.analysis.UnivariateFunction
                    public double value(double d) {
                        double d6 = 0.0d;
                        int i5 = 0;
                        while (true) {
                            DifferentiableUnivariateFunction[] differentiableUnivariateFunctionArr2 = differentiableUnivariateFunctionArr;
                            if (i5 >= differentiableUnivariateFunctionArr2.length) {
                                return d6;
                            }
                            double dValue = differentiableUnivariateFunctionArr2[i5].derivative().value(d);
                            int i6 = 0;
                            while (true) {
                                DifferentiableUnivariateFunction[] differentiableUnivariateFunctionArr3 = differentiableUnivariateFunctionArr;
                                if (i6 < differentiableUnivariateFunctionArr3.length) {
                                    if (i5 != i6) {
                                        dValue = differentiableUnivariateFunctionArr3[i6].value(d) * dValue;
                                    }
                                    i6++;
                                }
                            }
                            d6 += dValue;
                            i5++;
                        }
                    }
                };
            }

            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                double dValue = differentiableUnivariateFunctionArr[0].value(d);
                int i5 = 1;
                while (true) {
                    DifferentiableUnivariateFunction[] differentiableUnivariateFunctionArr2 = differentiableUnivariateFunctionArr;
                    if (i5 >= differentiableUnivariateFunctionArr2.length) {
                        return dValue;
                    }
                    dValue *= differentiableUnivariateFunctionArr2[i5].value(d);
                    i5++;
                }
            }
        };
    }
}
