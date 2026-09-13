package org.apache.poi.ss.formula.functions;

import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Poisson implements FreeRefFunction {
    private static final double DEFAULT_RETURN_RESULT = 1.0d;
    public static final Poisson instance = new Poisson();

    private static void checkArgument(double d) throws EvaluationException {
        NumericFunction.checkValue(d);
        if (d < 0.0d) {
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }
    }

    private static boolean isDefaultResult(double d, double d6) {
        return d == 0.0d && d6 == 0.0d;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        return evaluate(valueEvalArr, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
    }

    public static ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length != 3) {
            return ErrorEval.VALUE_INVALID;
        }
        ValueEval valueEval = valueEvalArr[0];
        ValueEval valueEval2 = valueEvalArr[1];
        ValueEval valueEval3 = valueEvalArr[2];
        try {
            try {
                double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEval, i5, i6);
                double dSingleOperandEvaluate2 = NumericFunction.singleOperandEvaluate(valueEval2, i5, i6);
                if (isDefaultResult(dSingleOperandEvaluate, dSingleOperandEvaluate2)) {
                    return new NumberEval(1.0d);
                }
                checkArgument(dSingleOperandEvaluate);
                checkArgument(dSingleOperandEvaluate2);
                boolean booleanValue = ((BoolEval) valueEval3).getBooleanValue();
                PoissonDistribution poissonDistribution = new PoissonDistribution(dSingleOperandEvaluate2);
                double dCumulativeProbability = booleanValue ? poissonDistribution.cumulativeProbability((int) dSingleOperandEvaluate) : poissonDistribution.probability((int) dSingleOperandEvaluate);
                NumericFunction.checkValue(dCumulativeProbability);
                return new NumberEval(dCumulativeProbability);
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
