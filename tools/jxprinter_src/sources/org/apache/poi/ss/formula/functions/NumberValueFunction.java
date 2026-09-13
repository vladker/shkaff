package org.apache.poi.ss.formula.functions;

import com.alibaba.android.arouter.utils.Consts;
import java.text.DecimalFormatSymbols;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NumberValueFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new NumberValueFunction();

    private NumberValueFunction() {
    }

    private static void checkValue(double d) throws EvaluationException {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        String strCoerceValueToString;
        String strCoerceValueToString2;
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(LocaleUtil.getUserLocale());
        String strValueOf = String.valueOf(decimalFormatSymbols.getDecimalSeparator());
        String strValueOf2 = String.valueOf(decimalFormatSymbols.getGroupingSeparator());
        try {
            if (valueEvalArr.length == 1) {
                strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            } else {
                if (valueEvalArr.length == 2) {
                    ValueEval singleValue = OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                    ValueEval singleValue2 = OperandResolver.getSingleValue(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                    strCoerceValueToString2 = OperandResolver.coerceValueToString(singleValue);
                    strValueOf = OperandResolver.coerceValueToString(singleValue2).substring(0, 1);
                } else if (valueEvalArr.length == 3) {
                    ValueEval singleValue3 = OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                    ValueEval singleValue4 = OperandResolver.getSingleValue(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                    ValueEval singleValue5 = OperandResolver.getSingleValue(valueEvalArr[2], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                    strCoerceValueToString2 = OperandResolver.coerceValueToString(singleValue3);
                    strValueOf = OperandResolver.coerceValueToString(singleValue4).substring(0, 1);
                    strValueOf2 = OperandResolver.coerceValueToString(singleValue5).substring(0, 1);
                } else {
                    strCoerceValueToString = null;
                }
                strCoerceValueToString = strCoerceValueToString2;
            }
            if ("".equals(strCoerceValueToString) || strCoerceValueToString == null) {
                strCoerceValueToString = "0";
            }
            String strReplace = strCoerceValueToString.replace(" ", "");
            String[] strArrSplit = strReplace.split("[" + strValueOf + "]");
            if (strArrSplit.length > 2) {
                return ErrorEval.VALUE_INVALID;
            }
            if (strArrSplit.length > 1) {
                String str = strArrSplit[0];
                String str2 = strArrSplit[1];
                if (str2.contains(strValueOf2)) {
                    return ErrorEval.VALUE_INVALID;
                }
                strReplace = androidx.collection.a.o(str.replace(strValueOf2, ""), Consts.DOT, str2);
            } else if (strArrSplit.length > 0) {
                strReplace = strArrSplit[0].replace(strValueOf2, "");
            }
            int i5 = 0;
            while (strReplace.endsWith("%")) {
                i5++;
                strReplace = androidx.collection.a.g(1, 0, strReplace);
            }
            try {
                double d = Double.parseDouble(strReplace) / Math.pow(100.0d, i5);
                checkValue(d);
                return new NumberEval(d);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            } catch (Exception unused) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException e6) {
            return e6.getErrorEval();
        }
    }
}
