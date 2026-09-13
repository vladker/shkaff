package org.apache.poi.ss.formula.functions;

import java.util.Locale;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DataFormatter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TextFunction implements Function {
    protected static final DataFormatter formatter = new DataFormatter();
    public static final Function CHAR = new Fixed1ArgFunction() { // from class: org.apache.poi.ss.formula.functions.TextFunction.1
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        /* JADX INFO: renamed from: evaluate */
        public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
            try {
                int iEvaluateIntArg = TextFunction.evaluateIntArg(valueEval, i5, i6);
                if (iEvaluateIntArg < 0 || iEvaluateIntArg >= 256) {
                    throw new EvaluationException(ErrorEval.VALUE_INVALID);
                }
                return new StringEval(String.valueOf((char) iEvaluateIntArg));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function LEN = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.2
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        public ValueEval evaluate(String str) {
            return new NumberEval(str.length());
        }
    };
    public static final Function LOWER = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.3
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        public ValueEval evaluate(String str) {
            return new StringEval(str.toLowerCase(Locale.ROOT));
        }
    };
    public static final Function UPPER = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.4
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        public ValueEval evaluate(String str) {
            return new StringEval(str.toUpperCase(Locale.ROOT));
        }
    };
    public static final Function PROPER = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.5
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        public ValueEval evaluate(String str) {
            StringBuilder sb = new StringBuilder();
            boolean z6 = true;
            for (char c : str.toCharArray()) {
                if (z6) {
                    sb.append(String.valueOf(c).toUpperCase(Locale.ROOT));
                } else {
                    sb.append(String.valueOf(c).toLowerCase(Locale.ROOT));
                }
                z6 = !Character.isLetter(c);
            }
            return new StringEval(sb.toString());
        }
    };
    public static final Function TRIM = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.6
        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        public ValueEval evaluate(String str) {
            return new StringEval(str.trim().replaceAll(" +", " "));
        }
    };
    public static final Function CLEAN = new SingleArgTextFunc() { // from class: org.apache.poi.ss.formula.functions.TextFunction.7
        private boolean isPrintable(char c) {
            return c >= ' ';
        }

        @Override // org.apache.poi.ss.formula.functions.TextFunction.SingleArgTextFunc
        public ValueEval evaluate(String str) {
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (isPrintable(c)) {
                    sb.append(c);
                }
            }
            return new StringEval(sb.toString());
        }
    };
    public static final Function MID = new Fixed3ArgFunction() { // from class: org.apache.poi.ss.formula.functions.TextFunction.8
        @Override // org.apache.poi.ss.formula.functions.Function3Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
            try {
                String strEvaluateStringArg = TextFunction.evaluateStringArg(valueEval, i5, i6);
                int iEvaluateIntArg = TextFunction.evaluateIntArg(valueEval2, i5, i6);
                int iEvaluateIntArg2 = TextFunction.evaluateIntArg(valueEval3, i5, i6);
                int i7 = iEvaluateIntArg - 1;
                if (i7 < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                if (iEvaluateIntArg2 < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                int length = strEvaluateStringArg.length();
                return i7 > length ? new StringEval("") : new StringEval(strEvaluateStringArg.substring(i7, Math.min(iEvaluateIntArg2 + i7, length)));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function LEFT = new LeftRight(true);
    public static final Function RIGHT = new LeftRight(false);
    public static final FreeRefFunction CONCAT = new j();
    public static final Function CONCATENATE = new a(9);
    public static final Function EXACT = new Fixed2ArgFunction() { // from class: org.apache.poi.ss.formula.functions.TextFunction.9
        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
            try {
                return BoolEval.valueOf(TextFunction.evaluateStringArg(valueEval, i5, i6).equals(TextFunction.evaluateStringArg(valueEval2, i5, i6)));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function TEXT = new Fixed2ArgFunction() { // from class: org.apache.poi.ss.formula.functions.TextFunction.10
        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
            try {
                try {
                    return new StringEval(TextFunction.formatter.formatRawCellContents(TextFunction.evaluateDoubleArg(valueEval, i5, i6), -1, TextFunction.evaluateStringArg(valueEval2, i5, i6)));
                } catch (Exception unused) {
                    return ErrorEval.VALUE_INVALID;
                }
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };
    public static final Function FIND = new SearchFind(true);
    public static final Function SEARCH = new SearchFind(false);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class LeftRight extends Var1or2ArgFunction {
        private static final ValueEval DEFAULT_ARG1 = new NumberEval(1.0d);
        private final boolean _isLeft;

        public LeftRight(boolean z6) {
            this._isLeft = z6;
        }

        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        /* JADX INFO: renamed from: evaluate */
        public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
            return evaluate(i5, i6, valueEval, DEFAULT_ARG1);
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
            try {
                String strEvaluateStringArg = TextFunction.evaluateStringArg(valueEval, i5, i6);
                int iEvaluateIntArg = TextFunction.evaluateIntArg(valueEval2, i5, i6);
                if (iEvaluateIntArg < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                return new StringEval(this._isLeft ? strEvaluateStringArg.substring(0, Math.min(strEvaluateStringArg.length(), iEvaluateIntArg)) : strEvaluateStringArg.substring(Math.max(0, strEvaluateStringArg.length() - iEvaluateIntArg)));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class SingleArgTextFunc extends Fixed1ArgFunction {
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        /* JADX INFO: renamed from: evaluate */
        public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
            try {
                return evaluate(TextFunction.evaluateStringArg(valueEval, i5, i6));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }

        public abstract ValueEval evaluate(String str);
    }

    public static double evaluateDoubleArg(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
    }

    public static int evaluateIntArg(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i5, i6));
    }

    public static String evaluateStringArg(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ValueEval lambda$static$0(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        StringBuilder sb = new StringBuilder();
        for (ValueEval valueEval : valueEvalArr) {
            try {
                if (valueEval instanceof AreaEval) {
                    AreaEval areaEval = (AreaEval) valueEval;
                    for (int i5 = 0; i5 < areaEval.getHeight(); i5++) {
                        for (int i6 = 0; i6 < areaEval.getWidth(); i6++) {
                            sb.append(evaluateStringArg(areaEval.getRelativeValue(i5, i6), operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
                        }
                    }
                } else {
                    sb.append(evaluateStringArg(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
                }
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
        return new StringEval(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ValueEval lambda$static$1(ValueEval[] valueEvalArr, int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        for (ValueEval valueEval : valueEvalArr) {
            try {
                sb.append(evaluateStringArg(valueEval, i5, i6));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
        return new StringEval(sb.toString());
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        try {
            return evaluateFunc(valueEvalArr, i5, i6);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public abstract ValueEval evaluateFunc(ValueEval[] valueEvalArr, int i5, int i6);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SearchFind extends Var2or3ArgFunction {
        private final boolean _isCaseSensitive;

        public SearchFind(boolean z6) {
            this._isCaseSensitive = z6;
        }

        private ValueEval eval(String str, String str2, int i5) {
            int iIndexOf;
            if (this._isCaseSensitive) {
                iIndexOf = str.indexOf(str2, i5);
            } else {
                Locale locale = Locale.ROOT;
                iIndexOf = str.toUpperCase(locale).indexOf(str2.toUpperCase(locale), i5);
            }
            return iIndexOf == -1 ? ErrorEval.VALUE_INVALID : new NumberEval(((double) iIndexOf) + 1.0d);
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
            try {
                return eval(TextFunction.evaluateStringArg(valueEval2, i5, i6), TextFunction.evaluateStringArg(valueEval, i5, i6), 0);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }

        @Override // org.apache.poi.ss.formula.functions.Function3Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
            try {
                String strEvaluateStringArg = TextFunction.evaluateStringArg(valueEval, i5, i6);
                String strEvaluateStringArg2 = TextFunction.evaluateStringArg(valueEval2, i5, i6);
                int iEvaluateIntArg = TextFunction.evaluateIntArg(valueEval3, i5, i6) - 1;
                if (iEvaluateIntArg < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                return eval(strEvaluateStringArg2, strEvaluateStringArg, iEvaluateIntArg);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    }
}
