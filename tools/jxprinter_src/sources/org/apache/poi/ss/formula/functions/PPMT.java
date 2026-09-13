package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PPMT extends NumericFunction {
    @Override // org.apache.poi.ss.formula.functions.NumericFunction
    public double eval(ValueEval[] valueEvalArr, int i5, int i6) throws EvaluationException {
        if (valueEvalArr.length < 4) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        double dPpmt = Finance.ppmt(OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], i5, i6)), OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[1], i5, i6)), OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[2], i5, i6)), OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[3], i5, i6)));
        NumericFunction.checkValue(dPpmt);
        return dPpmt;
    }
}
