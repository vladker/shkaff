package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Sqrtpi implements FreeRefFunction {
    public static final Sqrtpi instance = new Sqrtpi();

    private boolean isInvalidInput(double d) {
        return d < 0.0d;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        return valueEvalArr.length != 1 ? ErrorEval.VALUE_INVALID : evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
    }

    private ValueEval evaluate(int i5, int i6, ValueEval valueEval) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
            if (isInvalidInput(dCoerceValueToDouble)) {
                return ErrorEval.NUM_ERROR;
            }
            return new NumberEval(Double.parseDouble(NumberToTextConverter.toText(Math.sqrt(dCoerceValueToDouble * 3.141592653589793d))));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
