package org.apache.poi.ss.formula.functions;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MatrixFunction implements Function {
    public static final Function MINVERSE = new OneArrayArg() { // from class: org.apache.poi.ss.formula.functions.MatrixFunction.1
        private final MutableValueCollector instance = new MutableValueCollector(false, false);

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.OneArrayArg
        public double[] collectValues(ValueEval valueEval) throws EvaluationException {
            double[] dArrCollectValues = this.instance.collectValues(valueEval);
            if ((valueEval instanceof AreaEval) && dArrCollectValues.length == 1) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return dArrCollectValues;
        }

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.OneArrayArg
        public double[][] evaluate(double[][] dArr) throws EvaluationException {
            if (dArr.length == dArr[0].length) {
                return MatrixUtils.inverse(new Array2DRowRealMatrix(dArr)).getData();
            }
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
    };
    public static final Function TRANSPOSE = new OneArrayArg() { // from class: org.apache.poi.ss.formula.functions.MatrixFunction.2
        private final MutableValueCollector instance = new MutableValueCollector(false, true);

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.OneArrayArg
        public double[] collectValues(ValueEval valueEval) {
            return this.instance.collectValues(valueEval);
        }

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.OneArrayArg
        public double[][] evaluate(double[][] dArr) {
            return new Array2DRowRealMatrix(dArr).transpose().getData();
        }
    };
    public static final Function MDETERM = new Mdeterm();
    public static final Function MMULT = new TwoArrayArg() { // from class: org.apache.poi.ss.formula.functions.MatrixFunction.3
        private final MutableValueCollector instance = new MutableValueCollector(false, false);

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.TwoArrayArg
        public double[] collectValues(ValueEval valueEval) throws EvaluationException {
            double[] dArrCollectValues = this.instance.collectValues(valueEval);
            if ((valueEval instanceof AreaEval) && dArrCollectValues.length == 1) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return dArrCollectValues;
        }

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.TwoArrayArg
        public double[][] evaluate(double[][] dArr, double[][] dArr2) throws EvaluationException {
            Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(dArr);
            Array2DRowRealMatrix array2DRowRealMatrix2 = new Array2DRowRealMatrix(dArr2);
            try {
                MatrixUtils.checkMultiplicationCompatible(array2DRowRealMatrix, array2DRowRealMatrix2);
                return array2DRowRealMatrix.multiply(array2DRowRealMatrix2).getData();
            } catch (DimensionMismatchException unused) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Mdeterm extends OneArrayArg {
        private final MutableValueCollector instance;

        public Mdeterm() {
            MutableValueCollector mutableValueCollector = new MutableValueCollector(false, false);
            this.instance = mutableValueCollector;
            mutableValueCollector.setBlankEvalPolicy(MultiOperandNumericFunction.Policy.ERROR);
        }

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.OneArrayArg
        public double[] collectValues(ValueEval valueEval) throws EvaluationException {
            double[] dArrCollectValues = this.instance.collectValues(valueEval);
            if ((valueEval instanceof AreaEval) && dArrCollectValues.length == 1) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return this.instance.collectValues(valueEval);
        }

        @Override // org.apache.poi.ss.formula.functions.MatrixFunction.OneArrayArg
        public double[][] evaluate(double[][] dArr) throws EvaluationException {
            if (dArr.length != dArr[0].length) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 1, 1);
            dArr2[0][0] = new LUDecomposition(new Array2DRowRealMatrix(dArr)).getDeterminant();
            return dArr2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class MutableValueCollector extends MultiOperandNumericFunction {
        public MutableValueCollector(boolean z6, boolean z7) {
            super(z6, z7);
        }

        public double[] collectValues(ValueEval... valueEvalArr) {
            return getNumberArray(valueEvalArr);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            throw new IllegalStateException("should not be called");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class OneArrayArg extends Fixed1ArgFunction {
        public abstract double[] collectValues(ValueEval valueEval);

        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        /* JADX INFO: renamed from: evaluate */
        public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
            if (!(valueEval instanceof AreaEval)) {
                try {
                    double[][] dArrEvaluate = evaluate(new double[][]{new double[]{NumericFunction.singleOperandEvaluate(valueEval, i5, i6)}});
                    NumericFunction.checkValue(dArrEvaluate[0][0]);
                    return new NumberEval(dArrEvaluate[0][0]);
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            }
            try {
                double[][] dArrEvaluate2 = evaluate(MatrixFunction.fillDoubleArray(collectValues(valueEval), ((AreaEval) valueEval).getHeight(), ((AreaEval) valueEval).getWidth()));
                int length = dArrEvaluate2[0].length;
                int length2 = dArrEvaluate2.length;
                double[] dArrExtractDoubleArray = MatrixFunction.extractDoubleArray(dArrEvaluate2);
                MatrixFunction.checkValues(dArrExtractDoubleArray);
                ValueEval[] valueEvalArr = new ValueEval[dArrExtractDoubleArray.length];
                for (int i7 = 0; i7 < dArrExtractDoubleArray.length; i7++) {
                    valueEvalArr[i7] = new NumberEval(dArrExtractDoubleArray[i7]);
                }
                if (dArrExtractDoubleArray.length == 1) {
                    return valueEvalArr[0];
                }
                AreaEval areaEval = (AreaEval) valueEval;
                return new CacheAreaEval(areaEval.getFirstRow(), areaEval.getFirstColumn(), (areaEval.getFirstRow() + length2) - 1, (areaEval.getFirstColumn() + length) - 1, valueEvalArr);
            } catch (EvaluationException e6) {
                return e6.getErrorEval();
            }
        }

        public abstract double[][] evaluate(double[][] dArr);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class TwoArrayArg extends Fixed2ArgFunction {
        public abstract double[] collectValues(ValueEval valueEval);

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
            double[][] dArrFillDoubleArray;
            double[][] dArrFillDoubleArray2;
            try {
                try {
                    if (valueEval instanceof AreaEval) {
                        try {
                            dArrFillDoubleArray = MatrixFunction.fillDoubleArray(collectValues(valueEval), ((AreaEval) valueEval).getHeight(), ((AreaEval) valueEval).getWidth());
                        } catch (EvaluationException e) {
                            return e.getErrorEval();
                        }
                    } else {
                        try {
                            dArrFillDoubleArray = new double[][]{new double[]{NumericFunction.singleOperandEvaluate(valueEval, i5, i6)}};
                        } catch (EvaluationException e6) {
                            return e6.getErrorEval();
                        }
                    }
                    if (valueEval2 instanceof AreaEval) {
                        try {
                            dArrFillDoubleArray2 = MatrixFunction.fillDoubleArray(collectValues(valueEval2), ((AreaEval) valueEval2).getHeight(), ((AreaEval) valueEval2).getWidth());
                        } catch (EvaluationException e7) {
                            return e7.getErrorEval();
                        }
                    } else {
                        try {
                            dArrFillDoubleArray2 = new double[][]{new double[]{NumericFunction.singleOperandEvaluate(valueEval2, i5, i6)}};
                        } catch (EvaluationException e8) {
                            return e8.getErrorEval();
                        }
                    }
                    double[][] dArrEvaluate = evaluate(dArrFillDoubleArray, dArrFillDoubleArray2);
                    int length = dArrEvaluate[0].length;
                    int length2 = dArrEvaluate.length;
                    double[] dArrExtractDoubleArray = MatrixFunction.extractDoubleArray(dArrEvaluate);
                    MatrixFunction.checkValues(dArrExtractDoubleArray);
                    ValueEval[] valueEvalArr = new ValueEval[dArrExtractDoubleArray.length];
                    for (int i7 = 0; i7 < dArrExtractDoubleArray.length; i7++) {
                        valueEvalArr[i7] = new NumberEval(dArrExtractDoubleArray[i7]);
                    }
                    if (dArrExtractDoubleArray.length == 1) {
                        return valueEvalArr[0];
                    }
                    AreaEval areaEval = (AreaEval) valueEval;
                    return new CacheAreaEval(areaEval.getFirstRow(), areaEval.getFirstColumn(), (areaEval.getFirstRow() + length2) - 1, (areaEval.getFirstColumn() + length) - 1, valueEvalArr);
                } catch (IllegalArgumentException unused) {
                    return ErrorEval.VALUE_INVALID;
                }
            } catch (EvaluationException e9) {
                return e9.getErrorEval();
            }
        }

        public abstract double[][] evaluate(double[][] dArr, double[][] dArr2);
    }

    public static void checkValues(double[] dArr) throws EvaluationException {
        for (double d : dArr) {
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new EvaluationException(ErrorEval.NUM_ERROR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] extractDoubleArray(double[][] dArr) throws EvaluationException {
        if (dArr != null && dArr.length >= 1) {
            double[] dArr2 = dArr[0];
            if (dArr2.length >= 1) {
                double[] dArr3 = new double[dArr.length * dArr2.length];
                int i5 = 0;
                for (double[] dArr4 : dArr) {
                    int i6 = 0;
                    while (i6 < dArr[0].length) {
                        dArr3[i5] = dArr4[i6];
                        i6++;
                        i5++;
                    }
                }
                return dArr3;
            }
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[][] fillDoubleArray(double[] dArr, int i5, int i6) throws EvaluationException {
        if (i5 < 1 || i6 < 1 || dArr.length < 1) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
        int i7 = 0;
        int i8 = 0;
        for (double d : dArr) {
            if (i7 < dArr2.length) {
                if (i8 == dArr2[0].length) {
                    i7++;
                    i8 = 0;
                }
                if (i7 < dArr2.length) {
                    dArr2[i7][i8] = d;
                    i8++;
                }
            }
        }
        return dArr2;
    }

    public final double singleOperandEvaluate(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
    }
}
