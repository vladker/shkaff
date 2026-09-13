package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BooleanFunction implements Function, ArrayFunction {
    public static final Function AND = new BooleanFunction() { // from class: org.apache.poi.ss.formula.functions.BooleanFunction.1
        @Override // org.apache.poi.ss.formula.functions.BooleanFunction
        public boolean getInitialResultValue() {
            return true;
        }

        @Override // org.apache.poi.ss.formula.functions.BooleanFunction
        public boolean partialEvaluate(boolean z6, boolean z7) {
            return z6 && z7;
        }
    };
    public static final Function OR = new BooleanFunction() { // from class: org.apache.poi.ss.formula.functions.BooleanFunction.2
        @Override // org.apache.poi.ss.formula.functions.BooleanFunction
        public boolean getInitialResultValue() {
            return false;
        }

        @Override // org.apache.poi.ss.formula.functions.BooleanFunction
        public boolean partialEvaluate(boolean z6, boolean z7) {
            return z6 || z7;
        }
    };
    public static final Function FALSE = new a(0);
    public static final Function TRUE = new a(1);
    public static final Function NOT = new a(2);

    private boolean calculate(ValueEval[] valueEvalArr) throws EvaluationException {
        boolean initialResultValue = getInitialResultValue();
        int length = valueEvalArr.length;
        boolean z6 = false;
        for (int i5 = 0; i5 < length; i5++) {
            ValueEval valueEval = valueEvalArr[i5];
            if (valueEval instanceof TwoDEval) {
                TwoDEval twoDEval = (TwoDEval) valueEval;
                int height = twoDEval.getHeight();
                int width = twoDEval.getWidth();
                for (int i6 = 0; i6 < height; i6++) {
                    for (int i7 = 0; i7 < width; i7++) {
                        Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(twoDEval.getValue(i6, i7), true);
                        if (boolCoerceValueToBoolean != null) {
                            initialResultValue = partialEvaluate(initialResultValue, boolCoerceValueToBoolean.booleanValue());
                            z6 = true;
                        }
                    }
                }
            } else if (valueEval instanceof RefEval) {
                RefEval refEval = (RefEval) valueEval;
                int lastSheetIndex = refEval.getLastSheetIndex();
                for (int firstSheetIndex = refEval.getFirstSheetIndex(); firstSheetIndex <= lastSheetIndex; firstSheetIndex++) {
                    Boolean boolCoerceValueToBoolean2 = OperandResolver.coerceValueToBoolean(refEval.getInnerValueEval(firstSheetIndex), true);
                    if (boolCoerceValueToBoolean2 != null) {
                        initialResultValue = partialEvaluate(initialResultValue, boolCoerceValueToBoolean2.booleanValue());
                        z6 = true;
                    }
                }
            } else {
                Boolean boolCoerceValueToBoolean3 = valueEval == MissingArgEval.instance ? Boolean.FALSE : OperandResolver.coerceValueToBoolean(valueEval, false);
                if (boolCoerceValueToBoolean3 != null) {
                    initialResultValue = partialEvaluate(initialResultValue, boolCoerceValueToBoolean3.booleanValue());
                    z6 = true;
                }
            }
        }
        if (z6) {
            return initialResultValue;
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueEval evaluateFalse(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 0 ? ErrorEval.VALUE_INVALID : BoolEval.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueEval evaluateNot(ValueEval[] valueEvalArr, final int i5, final int i6) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return ArrayFunction._evaluateOneArrayArg(valueEvalArr[0], i5, i6, new java.util.function.Function() { // from class: org.apache.poi.ss.formula.functions.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return BooleanFunction.lambda$evaluateNot$0(i5, i6, (ValueEval) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueEval evaluateTrue(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 0 ? ErrorEval.VALUE_INVALID : BoolEval.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ValueEval lambda$evaluateNot$0(int i5, int i6, ValueEval valueEval) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
            boolean z6 = false;
            Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(singleValue, false);
            if (boolCoerceValueToBoolean != null && boolCoerceValueToBoolean.booleanValue()) {
                z6 = true;
            }
            return BoolEval.valueOf(!z6);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            return BoolEval.valueOf(calculate(valueEvalArr));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6) {
        return evaluate(valueEvalArr, i5, i6);
    }

    public abstract boolean getInitialResultValue();

    public abstract boolean partialEvaluate(boolean z6, boolean z7);
}
