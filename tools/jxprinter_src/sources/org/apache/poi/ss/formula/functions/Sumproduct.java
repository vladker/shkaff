package org.apache.poi.ss.formula.functions;

import java.util.Arrays;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Sumproduct implements Function {
    private static boolean areasAllSameSize(TwoDEval[] twoDEvalArr, int i5, int i6) {
        for (TwoDEval twoDEval : twoDEvalArr) {
            if (twoDEval.getHeight() != i5 || twoDEval.getWidth() != i6) {
                return false;
            }
        }
        return true;
    }

    private static ValueEval evaluateAreaSumProduct(ValueEval[] valueEvalArr) throws EvaluationException {
        int length = valueEvalArr.length;
        try {
            TwoDEval[] twoDEvalArr = (TwoDEval[]) Arrays.copyOf(valueEvalArr, length, TwoDEval[].class);
            TwoDEval twoDEval = twoDEvalArr[0];
            int height = twoDEval.getHeight();
            int width = twoDEval.getWidth();
            if (!areasAllSameSize(twoDEvalArr, height, width)) {
                for (int i5 = 1; i5 < twoDEvalArr.length; i5++) {
                    throwFirstError(twoDEvalArr[i5]);
                }
                return ErrorEval.VALUE_INVALID;
            }
            double d = 0.0d;
            for (int i6 = 0; i6 < height; i6++) {
                for (int i7 = 0; i7 < width; i7++) {
                    double productTerm = 1.0d;
                    for (int i8 = 0; i8 < length; i8++) {
                        productTerm *= getProductTerm(twoDEvalArr[i8].getValue(i6, i7), false);
                    }
                    d += productTerm;
                }
            }
            return new NumberEval(d);
        } catch (ArrayStoreException unused) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    private static ValueEval evaluateSingleProduct(ValueEval[] valueEvalArr) {
        int length = valueEvalArr.length;
        double scalarValue = 1.0d;
        for (ValueEval valueEval : valueEvalArr) {
            scalarValue *= getScalarValue(valueEval);
        }
        return new NumberEval(scalarValue);
    }

    private static double getProductTerm(ValueEval valueEval, boolean z6) throws EvaluationException {
        if ((valueEval instanceof BlankEval) || valueEval == null) {
            if (z6) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return 0.0d;
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval instanceof StringEval) {
            if (z6) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return 0.0d;
        }
        if (valueEval instanceof NumericValueEval) {
            return ((NumericValueEval) valueEval).getNumberValue();
        }
        throw new RuntimeException("Unexpected value eval class (" + valueEval.getClass().getName() + ")");
    }

    private static double getScalarValue(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            if (refEval.getNumberOfSheets() > 1) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
        }
        if (valueEval == null) {
            throw new RuntimeException("parameter may not be null");
        }
        if (valueEval instanceof AreaEval) {
            AreaEval areaEval = (AreaEval) valueEval;
            if (!areaEval.isColumn() || !areaEval.isRow()) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            valueEval = areaEval.getRelativeValue(0, 0);
        }
        return getProductTerm(valueEval, true);
    }

    private static void throwFirstError(TwoDEval twoDEval) throws EvaluationException {
        int height = twoDEval.getHeight();
        int width = twoDEval.getWidth();
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                ValueEval value = twoDEval.getValue(i5, i6);
                if (value instanceof ErrorEval) {
                    throw new EvaluationException((ErrorEval) value);
                }
            }
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        ValueEval valueEval = valueEvalArr[0];
        try {
            if (valueEval instanceof NumericValueEval) {
                return evaluateSingleProduct(valueEvalArr);
            }
            if (valueEval instanceof RefEval) {
                return evaluateSingleProduct(valueEvalArr);
            }
            if (valueEval instanceof TwoDEval) {
                TwoDEval twoDEval = (TwoDEval) valueEval;
                return (twoDEval.isRow() && twoDEval.isColumn()) ? evaluateSingleProduct(valueEvalArr) : evaluateAreaSumProduct(valueEvalArr);
            }
            throw new RuntimeException("Invalid arg type for SUMPRODUCT: (" + valueEval.getClass().getName() + ")");
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
