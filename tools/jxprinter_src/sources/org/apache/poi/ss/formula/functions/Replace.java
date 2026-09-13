package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Replace extends Fixed4ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        try {
            String strEvaluateStringArg = TextFunction.evaluateStringArg(valueEval, i5, i6);
            int iEvaluateIntArg = TextFunction.evaluateIntArg(valueEval2, i5, i6);
            int iEvaluateIntArg2 = TextFunction.evaluateIntArg(valueEval3, i5, i6);
            String strEvaluateStringArg2 = TextFunction.evaluateStringArg(valueEval4, i5, i6);
            if (iEvaluateIntArg < 1 || iEvaluateIntArg2 < 0) {
                return ErrorEval.VALUE_INVALID;
            }
            StringBuilder sb = new StringBuilder(strEvaluateStringArg);
            if (iEvaluateIntArg <= strEvaluateStringArg.length() && iEvaluateIntArg2 != 0) {
                int i7 = iEvaluateIntArg - 1;
                sb.delete(i7, iEvaluateIntArg2 + i7);
            }
            if (iEvaluateIntArg > sb.length()) {
                sb.append(strEvaluateStringArg2);
            } else {
                sb.insert(iEvaluateIntArg - 1, strEvaluateStringArg2);
            }
            return new StringEval(sb.toString());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
