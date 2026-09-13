package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DollarFr extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new DollarFr();

    private static Double evaluateValue(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        boolean z6;
        try {
            Double dEvaluateValue = evaluateValue(valueEval, i5, i6);
            if (dEvaluateValue == null) {
                return ErrorEval.VALUE_INVALID;
            }
            Double dEvaluateValue2 = evaluateValue(valueEval2, i5, i6);
            if (dEvaluateValue2 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            int iIntValue = dEvaluateValue2.intValue();
            if (iIntValue < 0) {
                return ErrorEval.NUM_ERROR;
            }
            if (iIntValue == 0) {
                return ErrorEval.DIV_ZERO;
            }
            int length = String.valueOf(iIntValue).length();
            long jLongValue = dEvaluateValue.longValue();
            if (jLongValue < 0) {
                jLongValue = -jLongValue;
                dEvaluateValue = Double.valueOf(-dEvaluateValue.doubleValue());
                z6 = true;
            } else {
                z6 = false;
            }
            double d = jLongValue;
            double dDoubleValue = dEvaluateValue.doubleValue() - d;
            if (dDoubleValue == 0.0d) {
                return new NumberEval(d);
            }
            BigDecimal bigDecimalAdd = BigDecimal.valueOf(dDoubleValue).multiply(BigDecimal.valueOf(iIntValue)).divide(BigDecimal.valueOf(Math.pow(10.0d, length)), MathContext.DECIMAL128).add(BigDecimal.valueOf(jLongValue));
            if (z6) {
                bigDecimalAdd = bigDecimalAdd.multiply(BigDecimal.valueOf(-1L));
            }
            return new NumberEval(bigDecimalAdd.doubleValue());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
