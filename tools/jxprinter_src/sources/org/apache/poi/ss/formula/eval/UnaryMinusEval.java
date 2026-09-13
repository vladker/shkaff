package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class UnaryMinusEval extends Fixed1ArgFunction implements ArrayFunction {
    public static final Function instance = new UnaryMinusEval();

    private UnaryMinusEval() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
            return dCoerceValueToDouble == 0.0d ? NumberEval.ZERO : new NumberEval(-dCoerceValueToDouble);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 1 ? ErrorEval.VALUE_INVALID : evaluateOneArrayArg(valueEvalArr[0], i5, i6, new c(this, i5, i6, 0));
    }
}
