package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Choose implements Function {
    public static int evaluateFirstArg(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i5, i6));
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            int iEvaluateFirstArg = evaluateFirstArg(valueEvalArr[0], i5, i6);
            if (iEvaluateFirstArg >= 1 && iEvaluateFirstArg < valueEvalArr.length) {
                ValueEval singleValue = OperandResolver.getSingleValue(valueEvalArr[iEvaluateFirstArg], i5, i6);
                return singleValue == MissingArgEval.instance ? BlankEval.instance : singleValue;
            }
            return ErrorEval.VALUE_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
