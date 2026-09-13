package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Standardize extends Fixed3ArgFunction implements FreeRefFunction {
    public static final Standardize instance = new Standardize();

    private static Double evaluateValue(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            Double dEvaluateValue = evaluateValue(valueEval, i5, i6);
            if (dEvaluateValue == null) {
                return ErrorEval.VALUE_INVALID;
            }
            Double dEvaluateValue2 = evaluateValue(valueEval2, i5, i6);
            if (dEvaluateValue2 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            Double dEvaluateValue3 = evaluateValue(valueEval3, i5, i6);
            if (dEvaluateValue3 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            return dEvaluateValue3.doubleValue() <= 0.0d ? ErrorEval.NUM_ERROR : new NumberEval(BigDecimal.valueOf(dEvaluateValue.doubleValue() - dEvaluateValue2.doubleValue()).divide(BigDecimal.valueOf(dEvaluateValue3.doubleValue()), MathContext.DECIMAL128).doubleValue());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 3) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
