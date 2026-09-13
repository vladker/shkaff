package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.util.NumberComparer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RelationalOperationEval extends Fixed2ArgFunction implements ArrayFunction {
    public static final Function EqualEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.1
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        public boolean convertComparisonResult(int i5) {
            return i5 == 0;
        }
    };
    public static final Function GreaterEqualEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.2
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        public boolean convertComparisonResult(int i5) {
            return i5 >= 0;
        }
    };
    public static final Function GreaterThanEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.3
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        public boolean convertComparisonResult(int i5) {
            return i5 > 0;
        }
    };
    public static final Function LessEqualEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.4
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        public boolean convertComparisonResult(int i5) {
            return i5 <= 0;
        }
    };
    public static final Function LessThanEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.5
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        public boolean convertComparisonResult(int i5) {
            return i5 < 0;
        }
    };
    public static final Function NotEqualEval = new RelationalOperationEval() { // from class: org.apache.poi.ss.formula.eval.RelationalOperationEval.6
        @Override // org.apache.poi.ss.formula.eval.RelationalOperationEval
        public boolean convertComparisonResult(int i5) {
            return i5 != 0;
        }
    };

    private static int compareBlank(ValueEval valueEval) {
        if (valueEval == BlankEval.instance || (valueEval instanceof MissingArgEval)) {
            return 0;
        }
        if (valueEval instanceof BoolEval) {
            return ((BoolEval) valueEval).getBooleanValue() ? -1 : 0;
        }
        if (valueEval instanceof NumberEval) {
            return NumberComparer.compare(0.0d, ((NumberEval) valueEval).getNumberValue());
        }
        if (valueEval instanceof StringEval) {
            return ((StringEval) valueEval).getStringValue().length() < 1 ? 0 : -1;
        }
        throw new IllegalArgumentException("bad value class (" + valueEval.getClass().getName() + ")");
    }

    private static int doCompare(ValueEval valueEval, ValueEval valueEval2) {
        BlankEval blankEval = BlankEval.instance;
        if (valueEval == blankEval || (valueEval instanceof MissingArgEval)) {
            return compareBlank(valueEval2);
        }
        if (valueEval2 == blankEval || (valueEval2 instanceof MissingArgEval)) {
            return -compareBlank(valueEval);
        }
        if (valueEval instanceof BoolEval) {
            if (!(valueEval2 instanceof BoolEval)) {
                return 1;
            }
            BoolEval boolEval = (BoolEval) valueEval;
            if (boolEval.getBooleanValue() == ((BoolEval) valueEval2).getBooleanValue()) {
                return 0;
            }
            return boolEval.getBooleanValue() ? 1 : -1;
        }
        if (valueEval2 instanceof BoolEval) {
            return -1;
        }
        if (valueEval instanceof StringEval) {
            if (valueEval2 instanceof StringEval) {
                return ((StringEval) valueEval).getStringValue().compareToIgnoreCase(((StringEval) valueEval2).getStringValue());
            }
            return 1;
        }
        if (valueEval2 instanceof StringEval) {
            return -1;
        }
        if ((valueEval instanceof NumberEval) && (valueEval2 instanceof NumberEval)) {
            return NumberComparer.compare(((NumberEval) valueEval).getNumberValue(), ((NumberEval) valueEval2).getNumberValue());
        }
        throw new IllegalArgumentException("Bad operand types (" + valueEval.getClass().getName() + "), (" + valueEval2.getClass().getName() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ValueEval lambda$evaluateArray$0(ValueEval valueEval, ValueEval valueEval2) {
        return BoolEval.valueOf(convertComparisonResult(doCompare(valueEval, valueEval2)));
    }

    public abstract boolean convertComparisonResult(int i5);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            return BoolEval.valueOf(convertComparisonResult(doCompare(OperandResolver.getSingleValue(valueEval, i5, i6), OperandResolver.getSingleValue(valueEval2, i5, i6))));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6) {
        return evaluateTwoArrayArgs(valueEvalArr[0], valueEvalArr[1], i5, i6, new b(this, 0));
    }
}
