package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Rept extends Fixed2ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            String strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6));
            try {
                int iCoerceValueToDouble = (int) OperandResolver.coerceValueToDouble(valueEval2);
                StringBuilder sb = new StringBuilder(strCoerceValueToString.length() * iCoerceValueToDouble);
                for (int i7 = 0; i7 < iCoerceValueToDouble; i7++) {
                    sb.append(strCoerceValueToString);
                }
                return sb.toString().length() > 32767 ? ErrorEval.VALUE_INVALID : new StringEval(sb.toString());
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
