package org.apache.poi.ss.formula.functions;

import java.util.ArrayList;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Gcd implements FreeRefFunction {
    public static final Gcd instance = new Gcd();
    private static final long MAX_INPUT = (long) Math.pow(2.0d, 53.0d);

    private boolean isInvalidInput(double d) {
        return d < 0.0d || d > ((double) MAX_INPUT);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        if (valueEvalArr.length == 1) {
            try {
                double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
                return isInvalidInput(dCoerceValueToDouble) ? ErrorEval.NUM_ERROR : new NumberEval((long) dCoerceValueToDouble);
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (ValueEval valueEval : valueEvalArr) {
                double dCoerceValueToDouble2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
                if (isInvalidInput(dCoerceValueToDouble2)) {
                    return ErrorEval.NUM_ERROR;
                }
                arrayList.add(Long.valueOf((long) dCoerceValueToDouble2));
            }
            long jLongValue = ((Long) arrayList.get(0)).longValue();
            for (int i5 = 1; i5 < arrayList.size(); i5++) {
                jLongValue = ArithmeticUtils.gcd(jLongValue, ((Long) arrayList.get(i5)).longValue());
            }
            return new NumberEval(jLongValue);
        } catch (EvaluationException unused2) {
            return ErrorEval.VALUE_INVALID;
        }
    }
}
