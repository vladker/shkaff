package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LogicalFunction extends Fixed1ArgFunction implements ArrayFunction {
    public static final Function ISLOGICAL = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.1
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        public boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof BoolEval;
        }
    };
    public static final Function ISNONTEXT = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.2
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        public boolean evaluate(ValueEval valueEval) {
            return !(valueEval instanceof StringEval);
        }
    };
    public static final Function ISNUMBER = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.3
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        public boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof NumberEval;
        }
    };
    public static final Function ISTEXT = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.4
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        public boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof StringEval;
        }
    };
    public static final Function ISBLANK = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.5
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        public boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof BlankEval;
        }
    };
    public static final Function ISERROR = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.6
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        public boolean evaluate(ValueEval valueEval) {
            return valueEval instanceof ErrorEval;
        }
    };
    public static final Function ISERR = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.7
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        public boolean evaluate(ValueEval valueEval) {
            return (valueEval instanceof ErrorEval) && valueEval != ErrorEval.NA;
        }
    };
    public static final Function ISNA = new LogicalFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.8
        @Override // org.apache.poi.ss.formula.functions.LogicalFunction
        public boolean evaluate(ValueEval valueEval) {
            return valueEval == ErrorEval.NA;
        }
    };
    public static final Function ISREF = new Fixed1ArgFunction() { // from class: org.apache.poi.ss.formula.functions.LogicalFunction.9
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        /* JADX INFO: renamed from: evaluate */
        public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
            return ((valueEval instanceof RefEval) || (valueEval instanceof AreaEval) || (valueEval instanceof RefListEval)) ? BoolEval.TRUE : BoolEval.FALSE;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ValueEval lambda$evaluateArray$0(ValueEval valueEval) {
        return BoolEval.valueOf(evaluate(valueEval));
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        ValueEval errorEval;
        try {
            errorEval = OperandResolver.getSingleValue(valueEval, i5, i6);
        } catch (EvaluationException e) {
            errorEval = e.getErrorEval();
        }
        return BoolEval.valueOf(evaluate(errorEval));
    }

    public abstract boolean evaluate(ValueEval valueEval);

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 1 ? ErrorEval.VALUE_INVALID : evaluateOneArrayArg(valueEvalArr[0], i5, i6, new java.util.function.Function() { // from class: org.apache.poi.ss.formula.functions.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f7206a.lambda$evaluateArray$0((ValueEval) obj);
            }
        });
    }
}
