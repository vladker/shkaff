package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class Ifs implements FreeRefFunction {
    public static final FreeRefFunction instance = new Ifs();

    private Ifs() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length % 2 != 0) {
            return ErrorEval.VALUE_INVALID;
        }
        for (int i5 = 0; i5 < valueEvalArr.length; i5 += 2) {
            if (((BoolEval) valueEvalArr[i5]).getBooleanValue()) {
                return valueEvalArr[i5 + 1];
            }
        }
        return ErrorEval.NA;
    }
}
