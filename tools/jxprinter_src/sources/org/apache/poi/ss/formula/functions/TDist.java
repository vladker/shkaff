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
public final class TDist extends Fixed3ArgFunction implements FreeRefFunction {
    public static final TDist instance = new TDist();

    private static Double evaluateValue(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
    }

    public static double tdistOneTail(double d, int i5) {
        return 1.0d - new TDistribution((RandomGenerator) null, i5).cumulativeProbability(d);
    }

    public static double tdistTwoTails(double d, int i5) {
        return tdistOneTail(d, i5) * 2.0d;
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            Double dEvaluateValue = evaluateValue(valueEval, i5, i6);
            if (dEvaluateValue == null) {
                return ErrorEval.VALUE_INVALID;
            }
            if (dEvaluateValue.doubleValue() < 0.0d) {
                return ErrorEval.NUM_ERROR;
            }
            Double dEvaluateValue2 = evaluateValue(valueEval2, i5, i6);
            if (dEvaluateValue2 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            int iIntValue = dEvaluateValue2.intValue();
            if (iIntValue < 1) {
                return ErrorEval.NUM_ERROR;
            }
            Double dEvaluateValue3 = evaluateValue(valueEval3, i5, i6);
            if (dEvaluateValue3 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            int iIntValue2 = dEvaluateValue3.intValue();
            if (iIntValue2 == 1 || iIntValue2 == 2) {
                return iIntValue2 == 2 ? new NumberEval(tdistTwoTails(dEvaluateValue.doubleValue(), iIntValue)) : new NumberEval(tdistOneTail(dEvaluateValue.doubleValue(), iIntValue));
            }
            return ErrorEval.NUM_ERROR;
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
