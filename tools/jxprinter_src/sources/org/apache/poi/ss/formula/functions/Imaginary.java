package org.apache.poi.ss.formula.functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Imaginary extends Fixed1ArgFunction implements FreeRefFunction {
    public static final int GROUP1_REAL_SIGN = 1;
    public static final String GROUP1_REAL_SIGN_REGEX = "([+-]?)";
    public static final int GROUP2_IMAGINARY_INTEGER_OR_DOUBLE = 2;
    public static final String GROUP2_REAL_INTEGER_OR_DOUBLE_REGEX = "([0-9]+\\.[0-9]+|[0-9]*)";
    public static final int GROUP3_IMAGINARY_SIGN = 3;
    public static final String GROUP3_IMAGINARY_SIGN_REGEX = "([+-]?)";
    public static final int GROUP4_IMAGINARY_INTEGER_OR_DOUBLE = 4;
    public static final String GROUP4_IMAGINARY_INTEGER_OR_DOUBLE_REGEX = "([0-9]+\\.[0-9]+|[0-9]*)";
    public static final String GROUP5_IMAGINARY_GROUP_REGEX = "([ij]?)";
    public static final FreeRefFunction instance = new Imaginary();
    public static final Pattern COMPLEX_NUMBER_PATTERN = Pattern.compile("([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([ij]?)");

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        try {
            Matcher matcher = COMPLEX_NUMBER_PATTERN.matcher(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
            if (!matcher.matches()) {
                return ErrorEval.NUM_ERROR;
            }
            String strGroup = matcher.group(5);
            boolean z6 = strGroup.equals(Complex.DEFAULT_SUFFIX) || strGroup.equals(Complex.SUPPORTED_SUFFIX);
            if (strGroup.length() == 0) {
                return new StringEval(String.valueOf(0));
            }
            String strConcat = "";
            if (z6) {
                String strGroup2 = matcher.group(3);
                if (strGroup2.length() != 0 && !strGroup2.equals("+")) {
                    strConcat = strGroup2;
                }
                String strGroup3 = matcher.group(4);
                strConcat = strGroup3.length() != 0 ? strConcat.concat(strGroup3) : strConcat.concat("1");
            }
            return new StringEval(strConcat);
        } catch (EvaluationException e) {
            return e.getErrorEval();
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
