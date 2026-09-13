package org.apache.poi.ss.formula.functions;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NormDist extends Fixed4ArgFunction implements FreeRefFunction {
    public static final NormDist instance = new NormDist();

    private NormDist() {
    }

    private static Double evaluateValue(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
    }

    public static double probability(double d, double d6, double d7, boolean z6) {
        NormalDistribution normalDistribution = new NormalDistribution(d6, d7);
        return z6 ? normalDistribution.cumulativeProbability(d) : normalDistribution.density(d);
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        try {
            Double dEvaluateValue = evaluateValue(valueEval, i5, i6);
            if (dEvaluateValue == null) {
                return ErrorEval.VALUE_INVALID;
            }
            Double dEvaluateValue2 = evaluateValue(valueEval2, i5, i6);
            if (dEvaluateValue2 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            Double dEvaluateValue3 = evaluateValue(valueEval3, i5, i6);
            if (dEvaluateValue3 == null) {
                return ErrorEval.VALUE_INVALID;
            }
            if (dEvaluateValue3.doubleValue() <= 0.0d) {
                return ErrorEval.NUM_ERROR;
            }
            Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(valueEval4, false);
            return boolCoerceValueToBoolean == null ? ErrorEval.VALUE_INVALID : new NumberEval(probability(dEvaluateValue.doubleValue(), dEvaluateValue2.doubleValue(), dEvaluateValue3.doubleValue(), boolCoerceValueToBoolean.booleanValue()));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 4) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEvalArr[3]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
