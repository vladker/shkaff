package org.apache.poi.ss.formula.functions;

import java.util.List;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Covar extends Fixed2ArgFunction implements FreeRefFunction {
    public static final Covar instanceP = new Covar(false);
    public static final Covar instanceS = new Covar(true);
    private final boolean sampleBased;

    private Covar(boolean z6) {
        this.sampleBased = z6;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            List<DoubleList> numberArrays = ArrayFunctionUtils.getNumberArrays(valueEval, valueEval2);
            return new NumberEval(new Covariance().covariance(numberArrays.get(0).toArray(), numberArrays.get(1).toArray(), this.sampleBased));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        } catch (Exception unused) {
            return ErrorEval.NA;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
    }
}
