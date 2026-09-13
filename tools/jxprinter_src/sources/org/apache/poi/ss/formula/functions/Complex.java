package org.apache.poi.ss.formula.functions;

import java.util.Locale;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Complex extends Var2or3ArgFunction implements FreeRefFunction {
    public static final String DEFAULT_SUFFIX = "i";
    public static final String SUPPORTED_SUFFIX = "j";
    public static final FreeRefFunction instance = new Complex();

    private boolean isDoubleAnInt(double d) {
        return d == Math.floor(d) && !Double.isInfinite(d);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        return evaluate(i5, i6, valueEval, valueEval2, new StringEval(DEFAULT_SUFFIX));
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            try {
                double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
                try {
                    try {
                        double dCoerceValueToDouble2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval2, i5, i6));
                        String strCoerceValueToString = OperandResolver.coerceValueToString(valueEval3);
                        if (strCoerceValueToString.length() == 0) {
                            strCoerceValueToString = DEFAULT_SUFFIX;
                        }
                        Locale locale = Locale.ROOT;
                        if (strCoerceValueToString.equals(DEFAULT_SUFFIX.toUpperCase(locale)) || strCoerceValueToString.equals(SUPPORTED_SUFFIX.toUpperCase(locale))) {
                            return ErrorEval.VALUE_INVALID;
                        }
                        if (!strCoerceValueToString.equals(DEFAULT_SUFFIX) && !strCoerceValueToString.equals(SUPPORTED_SUFFIX)) {
                            return ErrorEval.VALUE_INVALID;
                        }
                        StringBuilder sb = new StringBuilder();
                        if (dCoerceValueToDouble != 0.0d) {
                            if (isDoubleAnInt(dCoerceValueToDouble)) {
                                sb.append((int) dCoerceValueToDouble);
                            } else {
                                sb.append(dCoerceValueToDouble);
                            }
                        }
                        if (dCoerceValueToDouble2 != 0.0d) {
                            if (sb.length() != 0 && dCoerceValueToDouble2 > 0.0d) {
                                sb.append("+");
                            }
                            if (dCoerceValueToDouble2 != 1.0d && dCoerceValueToDouble2 != -1.0d) {
                                if (isDoubleAnInt(dCoerceValueToDouble2)) {
                                    sb.append((int) dCoerceValueToDouble2);
                                } else {
                                    sb.append(dCoerceValueToDouble2);
                                }
                            }
                            sb.append(strCoerceValueToString);
                        }
                        return new StringEval(sb.toString());
                    } catch (EvaluationException unused) {
                        return ErrorEval.VALUE_INVALID;
                    }
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            } catch (EvaluationException unused2) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException e6) {
            return e6.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        if (valueEvalArr.length == 3) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
