package org.apache.poi.ss.formula.functions;

import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Bin2Dec extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new Bin2Dec();

    private int getDecimalValue(String str) {
        int length = str.length();
        int i5 = length - 1;
        int i6 = 0;
        int iPow = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            iPow += (int) (Math.pow(2.0d, i5) * ((double) Integer.parseInt(str.substring(i6, i7))));
            i5--;
            i6 = i7;
        }
        return iPow;
    }

    private static String toggleBits(String str) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(Long.parseLong(str, 2) ^ ((1 << str.length()) - 1)));
        int length = str.length() - sb.length();
        if (length > 0) {
            sb.insert(0, StringUtil.repeat('0', length));
        }
        return sb.toString();
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        String strCoerceValueToString;
        String strSubstring;
        boolean zStartsWith;
        String strValueOf;
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            strCoerceValueToString = OperandResolver.coerceValueToString(refEval.getInnerValueEval(refEval.getFirstSheetIndex()));
        } else {
            strCoerceValueToString = OperandResolver.coerceValueToString(valueEval);
        }
        if (strCoerceValueToString.length() > 10) {
            return ErrorEval.NUM_ERROR;
        }
        if (strCoerceValueToString.length() < 10) {
            strSubstring = strCoerceValueToString;
            zStartsWith = true;
        } else {
            strSubstring = strCoerceValueToString.substring(1);
            zStartsWith = strCoerceValueToString.startsWith("0");
        }
        try {
            if (zStartsWith) {
                strValueOf = String.valueOf(getDecimalValue(strSubstring));
            } else {
                strValueOf = ProcessIdUtil.DEFAULT_PROCESSID + (getDecimalValue(toggleBits(strSubstring)) + 1);
            }
            return new NumberEval(Long.parseLong(strValueOf));
        } catch (NumberFormatException unused) {
            return ErrorEval.NUM_ERROR;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return lambda$evaluateArray$0(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
    }
}
