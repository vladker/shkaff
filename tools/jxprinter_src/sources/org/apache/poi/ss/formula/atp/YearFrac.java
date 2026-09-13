package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class YearFrac implements FreeRefFunction {
    public static final FreeRefFunction instance = new YearFrac();

    private YearFrac() {
    }

    private static double evaluateDateArg(ValueEval valueEval, int i5, int i6) {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, (short) i6);
        if (!(singleValue instanceof StringEval)) {
            return OperandResolver.coerceValueToDouble(singleValue);
        }
        String stringValue = ((StringEval) singleValue).getStringValue();
        Double d = OperandResolver.parseDouble(stringValue);
        return d != null ? d.doubleValue() : DateUtil.getExcelDate(org.apache.poi.ss.util.DateParser.parseLocalDate(stringValue), false);
    }

    private static int evaluateIntArg(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i5, (short) i6));
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        int iEvaluateIntArg;
        int rowIndex = operationEvaluationContext.getRowIndex();
        int columnIndex = operationEvaluationContext.getColumnIndex();
        try {
            int length = valueEvalArr.length;
            if (length == 2) {
                iEvaluateIntArg = 0;
            } else {
                if (length != 3) {
                    return ErrorEval.VALUE_INVALID;
                }
                iEvaluateIntArg = evaluateIntArg(valueEvalArr[2], rowIndex, columnIndex);
            }
            return new NumberEval(YearFracCalculator.calculate(evaluateDateArg(valueEvalArr[0], rowIndex, columnIndex), evaluateDateArg(valueEvalArr[1], rowIndex, columnIndex), iEvaluateIntArg));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
