package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RelationalOperationEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Switch implements FreeRefFunction {
    public static final FreeRefFunction instance = new Switch();

    private Switch() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length < 3) {
            return ErrorEval.NA;
        }
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            int i5 = 1;
            while (i5 < valueEvalArr.length) {
                try {
                    ValueEval singleValue2 = OperandResolver.getSingleValue(valueEvalArr[i5], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                    ValueEval valueEval = valueEvalArr[i5 + 1];
                    ValueEval valueEvalEvaluate = RelationalOperationEval.EqualEval.evaluate(new ValueEval[]{singleValue, singleValue2}, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                    if ((valueEvalEvaluate instanceof BoolEval) && ((BoolEval) valueEvalEvaluate).getBooleanValue()) {
                        return valueEval;
                    }
                    i5 += 2;
                    if (i5 == valueEvalArr.length - 1) {
                        return valueEvalArr[valueEvalArr.length - 1];
                    }
                } catch (EvaluationException unused) {
                    return ErrorEval.NA;
                }
            }
            return ErrorEval.NA;
        } catch (Exception unused2) {
            return ErrorEval.NA;
        }
    }
}
