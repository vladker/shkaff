package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Code extends Fixed1ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        try {
            String strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6));
            return strCoerceValueToString.length() == 0 ? ErrorEval.VALUE_INVALID : new StringEval(String.valueOf((int) strCoerceValueToString.charAt(0)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
