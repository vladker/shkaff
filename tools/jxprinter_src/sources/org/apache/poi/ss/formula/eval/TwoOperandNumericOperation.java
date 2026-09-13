package org.apache.poi.ss.formula.eval;

import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TwoOperandNumericOperation extends Fixed2ArgFunction implements ArrayFunction {
    public static final Function AddEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.ss.formula.eval.TwoOperandNumericOperation.1
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d6) {
            return d + d6;
        }
    };
    public static final Function DivideEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.ss.formula.eval.TwoOperandNumericOperation.2
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d6) throws EvaluationException {
            if (d6 != 0.0d) {
                return new BigDecimal(NumberToTextConverter.toText(d)).divide(new BigDecimal(NumberToTextConverter.toText(d6)), MathContext.DECIMAL128).doubleValue();
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function MultiplyEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.ss.formula.eval.TwoOperandNumericOperation.3
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d6) {
            return new BigDecimal(NumberToTextConverter.toText(d)).multiply(new BigDecimal(NumberToTextConverter.toText(d6))).doubleValue();
        }
    };
    public static final Function PowerEval = new TwoOperandNumericOperation() { // from class: org.apache.poi.ss.formula.eval.TwoOperandNumericOperation.4
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d6) {
            return (d >= 0.0d || Math.abs(d6) <= 0.0d || Math.abs(d6) >= 1.0d) ? Math.pow(d, d6) : Math.pow(d * (-1.0d), d6) * (-1.0d);
        }
    };
    public static final Function SubtractEval = new SubtractEvalClass();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SubtractEvalClass extends TwoOperandNumericOperation {
        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        public double evaluate(double d, double d6) {
            return d - d6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ValueEval lambda$evaluateArray$0(ValueEval valueEval, ValueEval valueEval2) {
        try {
            return new NumberEval(evaluate(OperandResolver.coerceValueToDouble(valueEval), OperandResolver.coerceValueToDouble(valueEval2)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public abstract double evaluate(double d, double d6);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double dEvaluate = evaluate(singleOperandEvaluate(valueEval, i5, i6), singleOperandEvaluate(valueEval2, i5, i6));
            if (dEvaluate != 0.0d || (this instanceof SubtractEvalClass)) {
                return (Double.isNaN(dEvaluate) || Double.isInfinite(dEvaluate)) ? ErrorEval.NUM_ERROR : new NumberEval(dEvaluate);
            }
            return NumberEval.ZERO;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 2 ? ErrorEval.VALUE_INVALID : evaluateTwoArrayArgs(valueEvalArr[0], valueEvalArr[1], i5, i6, new b(this, 1));
    }

    public final double singleOperandEvaluate(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
    }
}
