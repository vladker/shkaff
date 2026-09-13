package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class WeekdayFunc implements Function {
    public static final Function instance = new WeekdayFunc();

    private WeekdayFunc() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        int iCoerceValueToInt;
        double d;
        try {
            if (valueEvalArr.length >= 1 && valueEvalArr.length <= 2) {
                double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], i5, i6));
                if (!DateUtil.isValidExcelDate(dCoerceValueToDouble)) {
                    return ErrorEval.NUM_ERROR;
                }
                int i7 = DateUtil.getJavaCalendar(dCoerceValueToDouble, false).get(7);
                if (valueEvalArr.length == 2) {
                    ValueEval singleValue = OperandResolver.getSingleValue(valueEvalArr[1], i5, i6);
                    if (singleValue != MissingArgEval.instance && singleValue != BlankEval.instance) {
                        iCoerceValueToInt = OperandResolver.coerceValueToInt(singleValue);
                        if (iCoerceValueToInt == 2) {
                            iCoerceValueToInt = 11;
                        }
                    }
                    return ErrorEval.NUM_ERROR;
                }
                iCoerceValueToInt = 1;
                if (iCoerceValueToInt == 1) {
                    d = i7;
                } else if (iCoerceValueToInt == 3) {
                    i7 = (i7 + 5) % 7;
                    d = i7;
                } else {
                    if (iCoerceValueToInt < 11 || iCoerceValueToInt > 17) {
                        return ErrorEval.NUM_ERROR;
                    }
                    d = ((double) (((i7 + 6) - (iCoerceValueToInt - 10)) % 7)) + 1.0d;
                }
                return new NumberEval(d);
            }
            return ErrorEval.VALUE_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
