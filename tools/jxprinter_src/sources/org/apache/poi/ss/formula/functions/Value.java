package org.apache.poi.ss.formula.functions;

import java.time.DateTimeException;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Value extends Fixed1ArgFunction implements ArrayFunction {
    private static final int MIN_DISTANCE_BETWEEN_THOUSANDS_SEPARATOR = 4;
    private static final Double ZERO = Double.valueOf(0.0d);

    /* JADX WARN: Code duplicated, block: B:72:0x00a6  */
    public static Double convertTextToNumber(String str) {
        int length = str.length();
        boolean z6 = false;
        int i5 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i5 < length) {
            char cCharAt = str.charAt(i5);
            if (Character.isDigit(cCharAt) || cCharAt == '.') {
                break;
            }
            if (cCharAt != ' ') {
                if (cCharAt != '$') {
                    if (cCharAt != '+') {
                        if (cCharAt != '-' || z8 || z9) {
                            return null;
                        }
                        z8 = true;
                    } else {
                        if (z8 || z9) {
                            return null;
                        }
                        z9 = true;
                    }
                } else {
                    if (z7) {
                        return null;
                    }
                    z7 = true;
                }
            }
            i5++;
        }
        if (i5 >= length) {
            if (z7 || z8 || z9) {
                return null;
            }
            return ZERO;
        }
        StringBuilder sb = new StringBuilder(length);
        int i6 = -32768;
        int i7 = i5;
        boolean z10 = false;
        while (i7 < length) {
            char cCharAt2 = str.charAt(i7);
            if (Character.isDigit(cCharAt2)) {
                sb.append(cCharAt2);
            } else if (cCharAt2 == ' ') {
                String strTrim = str.substring(i7).trim();
                if (strTrim.equals("%")) {
                    z10 = true;
                } else if (strTrim.length() > 0) {
                    return null;
                }
            } else if (cCharAt2 == '%') {
                z10 = true;
            } else if (cCharAt2 != ',') {
                if (cCharAt2 != '.') {
                    if ((cCharAt2 != 'E' && cCharAt2 != 'e') || i7 - i6 < 4) {
                        return null;
                    }
                    sb.append(str.substring(i7));
                    i7 = length;
                } else {
                    if (z6 || i7 - i6 < 4) {
                        return null;
                    }
                    sb.append('.');
                    z6 = true;
                }
            } else {
                if (z6 || i7 - i6 < 4) {
                    return null;
                }
                i6 = i7;
            }
            i7++;
        }
        if (!z6 && i7 - i6 < 4) {
            return null;
        }
        try {
            double d = Double.parseDouble(sb.toString());
            if (z8) {
                d = -d;
            }
            if (z10) {
                d /= 100.0d;
            }
            return Double.valueOf(d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Double parseDateTime(String str) {
        try {
            return DateUtil.parseDateTime(str);
        } catch (DateTimeException unused) {
            return null;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate, reason: merged with bridge method [inline-methods] */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        try {
            String strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6));
            if (StringUtil.isBlank(strCoerceValueToString)) {
                return ErrorEval.VALUE_INVALID;
            }
            Double dConvertTextToNumber = convertTextToNumber(strCoerceValueToString);
            if (dConvertTextToNumber == null) {
                dConvertTextToNumber = parseDateTime(strCoerceValueToString);
            }
            return dConvertTextToNumber == null ? ErrorEval.VALUE_INVALID : new NumberEval(dConvertTextToNumber.doubleValue());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 1 ? ErrorEval.VALUE_INVALID : evaluateOneArrayArg(valueEvalArr[0], i5, i6, new org.apache.poi.ss.formula.eval.c(this, i5, i6, 2));
    }
}
