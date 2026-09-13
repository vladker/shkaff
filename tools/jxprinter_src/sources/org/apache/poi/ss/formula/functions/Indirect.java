package org.apache.poi.ss.formula.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.Table;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Indirect implements FreeRefFunction {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) Indirect.class);
    public static final FreeRefFunction instance = new Indirect();

    private Indirect() {
    }

    private static boolean canTrim(CharSequence charSequence) {
        int length = charSequence.length() - 1;
        if (length < 0) {
            return false;
        }
        if (Character.isWhitespace(charSequence.charAt(0))) {
            return true;
        }
        return Character.isWhitespace(charSequence.charAt(length));
    }

    private static boolean evaluateBooleanArg(ValueEval valueEval, OperationEvaluationContext operationEvaluationContext) {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        if (singleValue == BlankEval.instance || singleValue == MissingArgEval.instance) {
            return false;
        }
        return OperandResolver.coerceValueToBoolean(singleValue, false).booleanValue();
    }

    private static ValueEval evaluateIndirect(OperationEvaluationContext operationEvaluationContext, String str, boolean z6) {
        String str2;
        String strSubstring;
        String str3;
        String strTrim;
        int iLastIndexOf = str.lastIndexOf(33);
        String strTrim2 = null;
        if (iLastIndexOf < 0) {
            strSubstring = str;
            str2 = null;
            str3 = null;
        } else {
            String[] workbookAndSheetName = parseWorkbookAndSheetName(str.subSequence(0, iLastIndexOf));
            if (workbookAndSheetName == null) {
                return ErrorEval.REF_INVALID;
            }
            str2 = workbookAndSheetName[0];
            String str4 = workbookAndSheetName[1];
            strSubstring = str.substring(iLastIndexOf + 1);
            str3 = str4;
        }
        if (z6 && Table.isStructuredReference.matcher(strSubstring).matches()) {
            try {
                return operationEvaluationContext.getArea3DEval(FormulaParser.parseStructuredReference(strSubstring, (FormulaParsingWorkbook) operationEvaluationContext.getWorkbook(), operationEvaluationContext.getRowIndex()));
            } catch (FormulaParseException unused) {
                return ErrorEval.REF_INVALID;
            }
        }
        int iIndexOf = strSubstring.indexOf(58);
        if (iIndexOf < 0) {
            strTrim = strSubstring.trim();
        } else {
            String strTrim3 = strSubstring.substring(0, iIndexOf).trim();
            strTrim2 = strSubstring.substring(iIndexOf + 1).trim();
            strTrim = strTrim3;
        }
        try {
            return operationEvaluationContext.getDynamicReference(str2, str3, strTrim, strTrim2, z6);
        } catch (Exception e) {
            LOGGER.atWarn().log("Indirect function: failed to parse reference {}", str, e);
            return ErrorEval.REF_INVALID;
        }
    }

    private static String[] parseWorkbookAndSheetName(CharSequence charSequence) {
        String strUnescapeString;
        int i5 = 1;
        int length = charSequence.length() - 1;
        if (length < 0 || canTrim(charSequence)) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        if (Character.isWhitespace(cCharAt)) {
            return null;
        }
        if (cCharAt != '\'') {
            if (cCharAt != '[') {
                return new String[]{null, charSequence.toString()};
            }
            int iLastIndexOf = charSequence.toString().lastIndexOf(93);
            if (iLastIndexOf < 0) {
                return null;
            }
            CharSequence charSequenceSubSequence = charSequence.subSequence(1, iLastIndexOf);
            if (canTrim(charSequenceSubSequence)) {
                return null;
            }
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(iLastIndexOf + 1, charSequence.length());
            if (canTrim(charSequenceSubSequence2)) {
                return null;
            }
            return new String[]{charSequenceSubSequence.toString(), charSequenceSubSequence2.toString()};
        }
        if (charSequence.charAt(length) != '\'') {
            return null;
        }
        char cCharAt2 = charSequence.charAt(1);
        if (Character.isWhitespace(cCharAt2)) {
            return null;
        }
        if (cCharAt2 == '[') {
            int iLastIndexOf2 = charSequence.toString().lastIndexOf(93);
            if (iLastIndexOf2 < 0 || (strUnescapeString = unescapeString(charSequence.subSequence(2, iLastIndexOf2))) == null || canTrim(strUnescapeString)) {
                return null;
            }
            i5 = 1 + iLastIndexOf2;
        } else {
            strUnescapeString = null;
        }
        String strUnescapeString2 = unescapeString(charSequence.subSequence(i5, length));
        if (strUnescapeString2 == null) {
            return null;
        }
        return new String[]{strUnescapeString, strUnescapeString2};
    }

    private static String unescapeString(CharSequence charSequence) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i5 = 0;
        while (i5 < length) {
            char cCharAt2 = charSequence.charAt(i5);
            if (cCharAt2 == '\'') {
                i5++;
                if (i5 >= length || (cCharAt = charSequence.charAt(i5)) != '\'') {
                    return null;
                }
                cCharAt2 = cCharAt;
            }
            sb.append(cCharAt2);
            i5++;
        }
        return sb.toString();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        boolean zEvaluateBooleanArg = true;
        if (valueEvalArr.length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            String strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            int length = valueEvalArr.length;
            if (length != 1) {
                if (length != 2) {
                    return ErrorEval.VALUE_INVALID;
                }
                zEvaluateBooleanArg = evaluateBooleanArg(valueEvalArr[1], operationEvaluationContext);
            }
            return evaluateIndirect(operationEvaluationContext, strCoerceValueToString, zEvaluateBooleanArg);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
