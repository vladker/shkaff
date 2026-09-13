package org.apache.poi.ss.formula.functions;

import java.util.Iterator;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Rank extends Var2or3ArgFunction {
    private static AreaEval convertRangeArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static ValueEval eval(double d, AreaEval areaEval, boolean z6) {
        int height = areaEval.getHeight();
        int width = areaEval.getWidth();
        int i5 = 1;
        for (int i6 = 0; i6 < height; i6++) {
            for (int i7 = 0; i7 < width; i7++) {
                Double value = getValue(areaEval, i6, i7);
                if (value != null && ((z6 && value.doubleValue() > d) || (!z6 && value.doubleValue() < d))) {
                    i5++;
                }
            }
        }
        return new NumberEval(i5);
    }

    private static Double getValue(AreaEval areaEval, int i5, int i6) {
        ValueEval relativeValue = areaEval.getRelativeValue(i5, i6);
        if (relativeValue instanceof NumberEval) {
            return Double.valueOf(((NumberEval) relativeValue).getNumberValue());
        }
        return null;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
            if (Double.isNaN(dCoerceValueToDouble) || Double.isInfinite(dCoerceValueToDouble)) {
                throw new EvaluationException(ErrorEval.NUM_ERROR);
            }
            return valueEval2 instanceof RefListEval ? eval(dCoerceValueToDouble, (RefListEval) valueEval2, true) : eval(dCoerceValueToDouble, convertRangeArg(valueEval2), true);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static ValueEval eval(double d, RefListEval refListEval, boolean z6) {
        Iterator<ValueEval> it = refListEval.getList().iterator();
        int i5 = 1;
        while (it.hasNext()) {
            ValueEval next = it.next();
            if (next instanceof RefEval) {
                RefEval refEval = (RefEval) next;
                next = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
            }
            if (next instanceof NumberEval) {
                double numberValue = ((NumberEval) next).getNumberValue();
                if ((z6 && numberValue > d) || (!z6 && numberValue < d)) {
                    i5++;
                }
            }
        }
        return new NumberEval(i5);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
            if (!Double.isNaN(dCoerceValueToDouble) && !Double.isInfinite(dCoerceValueToDouble)) {
                int iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval3, i5, i6));
                boolean z6 = true;
                if (iCoerceValueToInt != 0) {
                    if (iCoerceValueToInt != 1) {
                        throw new EvaluationException(ErrorEval.NUM_ERROR);
                    }
                    z6 = false;
                }
                if (valueEval2 instanceof RefListEval) {
                    return eval(dCoerceValueToDouble, (RefListEval) valueEval2, z6);
                }
                return eval(dCoerceValueToDouble, convertRangeArg(valueEval2), z6);
            }
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
