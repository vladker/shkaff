package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class FinanceFunction implements Function3Arg, Function4Arg {
    private static final ValueEval DEFAULT_ARG3 = NumberEval.ZERO;
    private static final ValueEval DEFAULT_ARG4 = BoolEval.FALSE;
    public static final Function FV = new FinanceFunction() { // from class: org.apache.poi.ss.formula.functions.FinanceFunction.1
        @Override // org.apache.poi.ss.formula.functions.FinanceFunction
        public double evaluate(double d, double d6, double d7, double d8, boolean z6) {
            return FinanceLib.fv(d, d6, d7, d8, z6);
        }
    };
    public static final Function NPER = new FinanceFunction() { // from class: org.apache.poi.ss.formula.functions.FinanceFunction.2
        @Override // org.apache.poi.ss.formula.functions.FinanceFunction
        public double evaluate(double d, double d6, double d7, double d8, boolean z6) {
            return FinanceLib.nper(d, d6, d7, d8, z6);
        }
    };
    public static final Function PMT = new FinanceFunction() { // from class: org.apache.poi.ss.formula.functions.FinanceFunction.3
        @Override // org.apache.poi.ss.formula.functions.FinanceFunction
        public double evaluate(double d, double d6, double d7, double d8, boolean z6) {
            return FinanceLib.pmt(d, d6, d7, d8, z6);
        }
    };
    public static final Function PV = new FinanceFunction() { // from class: org.apache.poi.ss.formula.functions.FinanceFunction.4
        @Override // org.apache.poi.ss.formula.functions.FinanceFunction
        public double evaluate(double d, double d6, double d7, double d8, boolean z6) {
            return FinanceLib.pv(d, d6, d7, d8, z6);
        }
    };

    public abstract double evaluate(double d, double d6, double d7, double d8, boolean z6);

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        return evaluate(i5, i6, valueEval, valueEval2, valueEval3, DEFAULT_ARG3);
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        return evaluate(i5, i6, valueEval, valueEval2, valueEval3, valueEval4, DEFAULT_ARG4);
    }

    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4, ValueEval valueEval5) {
        try {
            double dEvaluate = evaluate(NumericFunction.singleOperandEvaluate(valueEval, i5, i6), NumericFunction.singleOperandEvaluate(valueEval2, i5, i6), NumericFunction.singleOperandEvaluate(valueEval3, i5, i6), NumericFunction.singleOperandEvaluate(valueEval4, i5, i6), NumericFunction.singleOperandEvaluate(valueEval5, i5, i6) != 0.0d);
            NumericFunction.checkValue(dEvaluate);
            return new NumberEval(dEvaluate);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        int length = valueEvalArr.length;
        if (length == 3) {
            return evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], DEFAULT_ARG3, DEFAULT_ARG4);
        }
        if (length == 4) {
            ValueEval valueEval = valueEvalArr[3];
            if (valueEval == MissingArgEval.instance) {
                valueEval = DEFAULT_ARG3;
            }
            return evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEval, DEFAULT_ARG4);
        }
        if (length != 5) {
            return ErrorEval.VALUE_INVALID;
        }
        ValueEval valueEval2 = valueEvalArr[3];
        MissingArgEval missingArgEval = MissingArgEval.instance;
        if (valueEval2 == missingArgEval) {
            valueEval2 = DEFAULT_ARG3;
        }
        ValueEval valueEval3 = valueEval2;
        ValueEval valueEval4 = valueEvalArr[4];
        if (valueEval4 == missingArgEval) {
            valueEval4 = DEFAULT_ARG4;
        }
        return evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEval3, valueEval4);
    }

    public double evaluate(double[] dArr) {
        double d;
        double d6;
        int length = dArr.length;
        if (length != 3) {
            if (length == 4) {
                d = 0.0d;
            } else if (length == 5) {
                d = dArr[4];
            } else {
                throw new IllegalStateException("Wrong number of arguments");
            }
            d6 = dArr[3];
        } else {
            d = 0.0d;
            d6 = 0.0d;
        }
        return evaluate(dArr[0], dArr[1], dArr[2], d6, d != 0.0d);
    }
}
