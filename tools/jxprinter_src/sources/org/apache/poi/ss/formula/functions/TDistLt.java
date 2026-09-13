package org.apache.poi.ss.formula.functions;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class TDistLt extends Fixed3ArgFunction implements FreeRefFunction {
    public static final TDistLt instance = new TDistLt();

    private static Boolean evaluateBoolean(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(valueEval, i5, i6), false);
    }

    private static Double evaluateValue(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
    }

    private static double tdistCumulative(double d, int i5) {
        return new TDistribution((RandomGenerator) null, i5).cumulativeProbability(d);
    }

    private static double tdistDensity(double d, int i5) {
        return new TDistribution((RandomGenerator) null, i5).density(d);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            Double dEvaluateValue = evaluateValue(valueEval, i5, i6);
            if (dEvaluateValue == null) {
                return ErrorEval.VALUE_INVALID;
            }
            Double dEvaluateValue2 = evaluateValue(valueEval2, i5, i6);
            if (dEvaluateValue2 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            int iIntValue = dEvaluateValue2.intValue();
            if (iIntValue < 1) {
                return ErrorEval.NUM_ERROR;
            }
            Boolean boolEvaluateBoolean = evaluateBoolean(valueEval3, i5, i6);
            if (boolEvaluateBoolean == null) {
                return ErrorEval.VALUE_INVALID;
            }
            return boolEvaluateBoolean.booleanValue() ? new NumberEval(tdistCumulative(dEvaluateValue.doubleValue(), iIntValue)) : new NumberEval(tdistDensity(dEvaluateValue.doubleValue(), iIntValue));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 3) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
