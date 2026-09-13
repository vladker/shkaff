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
public final class CeilingMath implements FreeRefFunction {
    public static final CeilingMath instance = new CeilingMath();

    private CeilingMath() {
    }

    private static Double evaluateValue(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        Double dEvaluateValue;
        Double dEvaluateValue2;
        if (valueEvalArr.length == 0) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            Double dEvaluateValue3 = evaluateValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            if (dEvaluateValue3 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            double dDoubleValue = (valueEvalArr.length <= 1 || (dEvaluateValue2 = evaluateValue(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex())) == null) ? 1.0d : dEvaluateValue2.doubleValue();
            if (valueEvalArr.length <= 2 || (dEvaluateValue = evaluateValue(valueEvalArr[2], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex())) == null || dEvaluateValue.doubleValue() >= 0.0d || dEvaluateValue3.doubleValue() >= 0.0d) {
                if (dDoubleValue != 1.0d) {
                    return new NumberEval(MathX.scaledRoundUsingBigDecimal(dEvaluateValue3.doubleValue(), dDoubleValue, dDoubleValue < 0.0d ? RoundingMode.FLOOR : RoundingMode.CEILING));
                }
                return new NumberEval(Math.ceil(dEvaluateValue3.doubleValue()));
            }
            if (dDoubleValue != 1.0d) {
                return new NumberEval(MathX.scaledRoundUsingBigDecimal(dEvaluateValue3.doubleValue(), dDoubleValue, dDoubleValue < 0.0d ? RoundingMode.CEILING : RoundingMode.FLOOR));
            }
            return new NumberEval(Math.floor(dEvaluateValue3.doubleValue()));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
