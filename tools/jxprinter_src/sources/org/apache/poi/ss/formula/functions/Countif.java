package org.apache.poi.ss.formula.functions;

import A3.AbstractC0157z;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.FormulaError;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Countif extends Fixed2ArgFunction {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ErrorMatcher extends MatcherBase {
        private final int _value;

        public ErrorMatcher(int i5, CmpOp cmpOp) {
            super(cmpOp);
            this._value = i5;
        }

        public int getValue() {
            return this._value;
        }

        @Override // org.apache.poi.ss.formula.functions.Countif.MatcherBase
        public String getValueText() {
            return FormulaError.forInt(this._value).getString();
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            if (valueEval instanceof ErrorEval) {
                return evaluate(((ErrorEval) valueEval).getErrorCode() - this._value);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class MatcherBase implements CountUtils.I_MatchPredicate {
        private final CmpOp _operator;

        public MatcherBase(CmpOp cmpOp) {
            this._operator = cmpOp;
        }

        public final boolean evaluate(int i5) {
            return this._operator.evaluate(i5);
        }

        public final int getCode() {
            return this._operator.getCode();
        }

        public abstract String getValueText();

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(" [");
            sb.append(this._operator.getRepresentation());
            return AbstractC0157z.s(sb, getValueText(), "]");
        }

        public final boolean evaluate(boolean z6) {
            return this._operator.evaluate(z6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class NumberMatcher extends MatcherBase {
        private final double _value;

        public NumberMatcher(double d, CmpOp cmpOp) {
            super(cmpOp);
            this._value = d;
        }

        @Override // org.apache.poi.ss.formula.functions.Countif.MatcherBase
        public String getValueText() {
            return String.valueOf(this._value);
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            if (!(valueEval instanceof StringEval)) {
                if (valueEval instanceof NumberEval) {
                    return evaluate(Double.compare(((NumberEval) valueEval).getNumberValue(), this._value));
                }
                return (valueEval instanceof BlankEval) && getCode() == 2;
            }
            int code = getCode();
            if (code != 0 && code != 1) {
                return code == 2;
            }
            Double d = OperandResolver.parseDouble(((StringEval) valueEval).getStringValue());
            return d != null && this._value == d.doubleValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class StringMatcher extends MatcherBase {
        private final Pattern _pattern;
        private final String _value;

        public StringMatcher(String str, CmpOp cmpOp) {
            super(cmpOp);
            this._value = str;
            int code = cmpOp.getCode();
            if (code == 0 || code == 1 || code == 2) {
                this._pattern = getWildCardPattern(str);
            } else {
                this._pattern = null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:30:0x005e  */
        public static Pattern getWildCardPattern(String str) {
            char cCharAt;
            int length = str.length();
            StringBuilder sb = new StringBuilder(length);
            int i5 = 0;
            boolean z6 = false;
            while (i5 < length) {
                char cCharAt2 = str.charAt(i5);
                if (cCharAt2 == '$' || cCharAt2 == '.') {
                    sb.append("\\");
                    sb.append(cCharAt2);
                    continue;
                } else {
                    if (cCharAt2 == '?') {
                        sb.append('.');
                    } else if (cCharAt2 == '[') {
                        sb.append("\\");
                        sb.append(cCharAt2);
                        continue;
                    } else if (cCharAt2 == '~') {
                        int i6 = i5 + 1;
                        if (i6 >= length || !((cCharAt = str.charAt(i6)) == '*' || cCharAt == '?')) {
                            sb.append('~');
                        } else {
                            sb.append('[');
                            sb.append(cCharAt);
                            sb.append(']');
                            i5 = i6;
                        }
                    } else if (cCharAt2 != ']' && cCharAt2 != '^') {
                        switch (cCharAt2) {
                            case '(':
                            case ')':
                                sb.append("\\");
                                sb.append(cCharAt2);
                                continue;
                            case '*':
                                sb.append(".*");
                                break;
                            default:
                                sb.append(cCharAt2);
                                continue;
                        }
                    } else {
                        sb.append("\\");
                        sb.append(cCharAt2);
                        continue;
                    }
                    z6 = true;
                }
                i5++;
            }
            if (z6) {
                return Pattern.compile(sb.toString(), 2);
            }
            return null;
        }

        @Override // org.apache.poi.ss.formula.functions.Countif.MatcherBase
        public String getValueText() {
            Pattern pattern = this._pattern;
            return pattern == null ? this._value : pattern.pattern();
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            if (valueEval instanceof BlankEval) {
                int code = getCode();
                if (code == 0 || code == 1) {
                    return this._value.length() == 0;
                }
                return code == 2 && this._value.length() != 0;
            }
            if (!(valueEval instanceof StringEval)) {
                return false;
            }
            String stringValue = ((StringEval) valueEval).getStringValue();
            if (stringValue.length() >= 1 || this._value.length() >= 1) {
                Pattern pattern = this._pattern;
                return pattern != null ? evaluate(pattern.matcher(stringValue).matches()) : evaluate(stringValue.compareToIgnoreCase(this._value));
            }
            int code2 = getCode();
            return code2 == 0 || code2 == 2;
        }
    }

    private double countMatchingCellsInArea(ValueEval valueEval, CountUtils.I_MatchPredicate i_MatchPredicate) {
        int iCountMatchingCellsInArea;
        if (valueEval instanceof RefEval) {
            iCountMatchingCellsInArea = CountUtils.countMatchingCellsInRef((RefEval) valueEval, i_MatchPredicate);
        } else {
            if (!(valueEval instanceof ThreeDEval)) {
                throw new IllegalArgumentException("Bad range arg type (" + valueEval.getClass().getName() + ")");
            }
            iCountMatchingCellsInArea = CountUtils.countMatchingCellsInArea((ThreeDEval) valueEval, i_MatchPredicate);
        }
        return iCountMatchingCellsInArea;
    }

    public static CountUtils.I_MatchPredicate createCriteriaPredicate(ValueEval valueEval, int i5, int i6) {
        ValueEval valueEvalEvaluateCriteriaArg = evaluateCriteriaArg(valueEval, i5, i6);
        if (valueEvalEvaluateCriteriaArg instanceof NumberEval) {
            return new NumberMatcher(((NumberEval) valueEvalEvaluateCriteriaArg).getNumberValue(), CmpOp.OP_NONE);
        }
        if (valueEvalEvaluateCriteriaArg instanceof BoolEval) {
            return new BooleanMatcher(((BoolEval) valueEvalEvaluateCriteriaArg).getBooleanValue(), CmpOp.OP_NONE);
        }
        if (valueEvalEvaluateCriteriaArg instanceof StringEval) {
            return createGeneralMatchPredicate((StringEval) valueEvalEvaluateCriteriaArg);
        }
        if (valueEvalEvaluateCriteriaArg instanceof ErrorEval) {
            return new ErrorMatcher(((ErrorEval) valueEvalEvaluateCriteriaArg).getErrorCode(), CmpOp.OP_NONE);
        }
        if (valueEvalEvaluateCriteriaArg == BlankEval.instance) {
            return null;
        }
        throw new RuntimeException("Unexpected type for criteria (" + valueEvalEvaluateCriteriaArg.getClass().getName() + ")");
    }

    private static CountUtils.I_MatchPredicate createGeneralMatchPredicate(StringEval stringEval) {
        String stringValue = stringEval.getStringValue();
        CmpOp operator = CmpOp.getOperator(stringValue);
        String strSubstring = stringValue.substring(operator.getLength());
        Boolean bool = parseBoolean(strSubstring);
        if (bool != null) {
            return new BooleanMatcher(bool.booleanValue(), operator);
        }
        Double d = OperandResolver.parseDouble(strSubstring);
        if (d != null) {
            return new NumberMatcher(d.doubleValue(), operator);
        }
        ErrorEval error = parseError(strSubstring);
        return error != null ? new ErrorMatcher(error.getErrorCode(), operator) : new StringMatcher(strSubstring, operator);
    }

    private static ValueEval evaluateCriteriaArg(ValueEval valueEval, int i5, int i6) {
        try {
            return OperandResolver.getSingleValue(valueEval, i5, i6);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0027  */
    /* JADX WARN: Code duplicated, block: B:18:0x002a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0032  */
    public static Boolean parseBoolean(String str) {
        if (str.length() < 1) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            if ("FALSE".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
        } else if (cCharAt == 'T') {
            if ("TRUE".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
        } else if (cCharAt != 'f') {
            if (cCharAt == 't') {
                if ("TRUE".equalsIgnoreCase(str)) {
                    return Boolean.TRUE;
                }
            }
        } else if ("FALSE".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static ErrorEval parseError(String str) {
        if (str.length() >= 4 && str.charAt(0) == '#') {
            if (str.equals("#NULL!")) {
                return ErrorEval.NULL_INTERSECTION;
            }
            if (str.equals("#DIV/0!")) {
                return ErrorEval.DIV_ZERO;
            }
            if (str.equals("#VALUE!")) {
                return ErrorEval.VALUE_INVALID;
            }
            if (str.equals("#REF!")) {
                return ErrorEval.REF_INVALID;
            }
            if (str.equals("#NAME?")) {
                return ErrorEval.NAME_INVALID;
            }
            if (str.equals("#NUM!")) {
                return ErrorEval.NUM_ERROR;
            }
            if (str.equals("#N/A")) {
                return ErrorEval.NA;
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        CountUtils.I_MatchPredicate i_MatchPredicateCreateCriteriaPredicate = createCriteriaPredicate(valueEval2, i5, i6);
        return i_MatchPredicateCreateCriteriaPredicate == null ? NumberEval.ZERO : new NumberEval(countMatchingCellsInArea(valueEval, i_MatchPredicateCreateCriteriaPredicate));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CmpOp {
        public static final int EQ = 1;
        public static final int GE = 6;
        public static final int GT = 5;
        public static final int LE = 3;
        public static final int LT = 4;
        public static final int NE = 2;
        public static final int NONE = 0;
        private final int _code;
        private final String _representation;
        public static final CmpOp OP_NONE = op("", 0);
        public static final CmpOp OP_EQ = op("=", 1);
        public static final CmpOp OP_NE = op("<>", 2);
        public static final CmpOp OP_LE = op("<=", 3);
        public static final CmpOp OP_LT = op("<", 4);
        public static final CmpOp OP_GT = op(">", 5);
        public static final CmpOp OP_GE = op(">=", 6);

        private CmpOp(String str, int i5) {
            this._representation = str;
            this._code = i5;
        }

        public static CmpOp getOperator(String str) {
            int length = str.length();
            if (length < 1) {
                return OP_NONE;
            }
            switch (str.charAt(0)) {
                case '<':
                    if (length > 1) {
                        char cCharAt = str.charAt(1);
                        if (cCharAt == '=') {
                            return OP_LE;
                        }
                        if (cCharAt == '>') {
                            return OP_NE;
                        }
                    }
                    return OP_LT;
                case '=':
                    return OP_EQ;
                case '>':
                    return (length <= 1 || str.charAt(1) != '=') ? OP_GT : OP_GE;
                default:
                    return OP_NONE;
            }
        }

        private static CmpOp op(String str, int i5) {
            return new CmpOp(str, i5);
        }

        public boolean evaluate(boolean z6) {
            int i5 = this._code;
            if (i5 == 0 || i5 == 1) {
                return z6;
            }
            if (i5 == 2) {
                return !z6;
            }
            throw new RuntimeException(AbstractC0157z.s(new StringBuilder("Cannot call boolean evaluate on non-equality operator '"), this._representation, "'"));
        }

        public int getCode() {
            return this._code;
        }

        public int getLength() {
            return this._representation.length();
        }

        public String getRepresentation() {
            return this._representation;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            androidx.collection.a.w(CmpOp.class, sb, " [");
            return AbstractC0157z.s(sb, this._representation, "]");
        }

        public boolean evaluate(int i5) {
            switch (this._code) {
                case 0:
                case 1:
                    return i5 == 0;
                case 2:
                    return i5 != 0;
                case 3:
                    return i5 <= 0;
                case 4:
                    return i5 < 0;
                case 5:
                    return i5 > 0;
                case 6:
                    return i5 >= 0;
                default:
                    throw new RuntimeException(AbstractC0157z.s(new StringBuilder("Cannot call boolean evaluate on non-equality operator '"), this._representation, "'"));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BooleanMatcher extends MatcherBase {
        private final int _value;

        public BooleanMatcher(boolean z6, CmpOp cmpOp) {
            super(cmpOp);
            this._value = boolToInt(z6);
        }

        @Override // org.apache.poi.ss.formula.functions.Countif.MatcherBase
        public String getValueText() {
            return this._value == 1 ? "TRUE" : "FALSE";
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            if (valueEval instanceof StringEval) {
                return false;
            }
            if (valueEval instanceof BoolEval) {
                return evaluate(boolToInt(((BoolEval) valueEval).getBooleanValue()) - this._value);
            }
            if (valueEval instanceof BlankEval) {
                return getCode() == 2;
            }
            return (valueEval instanceof NumberEval) && getCode() == 2;
        }

        private static int boolToInt(boolean z6) {
            return z6 ? 1 : 0;
        }
    }
}
