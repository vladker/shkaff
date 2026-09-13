package org.apache.poi.ss.formula.functions;

import java.math.RoundingMode;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CeilingPrecise implements FreeRefFunction {
    public static final CeilingPrecise instance = new CeilingPrecise();

    private CeilingPrecise() {
    }

    private static Double evaluateValue(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        Double dEvaluateValue;
        if (valueEvalArr.length == 0) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            Double dEvaluateValue2 = evaluateValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            if (dEvaluateValue2 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            double dAbs = (valueEvalArr.length <= 1 || (dEvaluateValue = evaluateValue(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex())) == null) ? 1.0d : Math.abs(dEvaluateValue.doubleValue());
            return dAbs != 1.0d ? new NumberEval(MathX.scaledRoundUsingBigDecimal(dEvaluateValue2.doubleValue(), dAbs, RoundingMode.CEILING)) : new NumberEval(Math.ceil(dEvaluateValue2.doubleValue()));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
