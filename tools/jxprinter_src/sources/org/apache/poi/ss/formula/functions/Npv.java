package org.apache.poi.ss.formula.functions;

import java.util.Arrays;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Npv implements Function {
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dNpv = FinanceLib.npv(NumericFunction.singleOperandEvaluate(valueEvalArr[0], i5, i6), AggregateFunction.ValueCollector.collectValues((ValueEval[]) Arrays.copyOfRange(valueEvalArr, 1, valueEvalArr.length, ValueEval[].class)));
            NumericFunction.checkValue(dNpv);
            return new NumberEval(dNpv);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
