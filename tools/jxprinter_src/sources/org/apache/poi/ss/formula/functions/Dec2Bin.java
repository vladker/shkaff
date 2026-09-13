package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Dec2Bin extends Var1or2ArgFunction implements FreeRefFunction {
    private static final int DEFAULT_PLACES_VALUE = 10;
    private static final long MAX_VALUE = 511;
    private static final long MIN_VALUE = -512;
    public static final FreeRefFunction instance = new Dec2Bin();

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        int iIntValue;
        try {
            Double d = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
            if (d == null) {
                return ErrorEval.VALUE_INVALID;
            }
            if (d.longValue() < MIN_VALUE || d.longValue() > MAX_VALUE) {
                return ErrorEval.NUM_ERROR;
            }
            if (d.doubleValue() < 0.0d || valueEval2 == null) {
                iIntValue = 10;
            } else {
                try {
                    Double d6 = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval2, i5, i6)));
                    if (d6 == null) {
                        return ErrorEval.VALUE_INVALID;
                    }
                    iIntValue = d6.intValue();
                    if (iIntValue < 0 || iIntValue == 0) {
                        return ErrorEval.NUM_ERROR;
                    }
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            }
            String binaryString = Integer.toBinaryString(d.intValue());
            if (binaryString.length() > 10) {
                binaryString = binaryString.substring(binaryString.length() - 10);
            }
            return binaryString.length() > iIntValue ? ErrorEval.NUM_ERROR : new StringEval(binaryString);
        } catch (EvaluationException e6) {
            return e6.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        return evaluate(i5, i6, valueEval, null);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 1) {
            return lambda$evaluateArray$0(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
        }
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
