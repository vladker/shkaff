package org.apache.poi.ss.formula.atp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.NumericFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class MRound implements FreeRefFunction {
    public static final FreeRefFunction instance = new MRound();

    private MRound() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            double dCoerceValueToDouble2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            double dDoubleValue = 0.0d;
            if (dCoerceValueToDouble2 != 0.0d) {
                if (dCoerceValueToDouble * dCoerceValueToDouble2 < 0.0d) {
                    throw new EvaluationException(ErrorEval.NUM_ERROR);
                }
                BigDecimal bigDecimalValueOf = BigDecimal.valueOf(dCoerceValueToDouble2);
                dDoubleValue = bigDecimalValueOf.multiply(BigDecimal.valueOf(dCoerceValueToDouble).divide(bigDecimalValueOf, 0, RoundingMode.HALF_UP)).doubleValue();
            }
            NumericFunction.checkValue(dDoubleValue);
            return new NumberEval(dDoubleValue);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
