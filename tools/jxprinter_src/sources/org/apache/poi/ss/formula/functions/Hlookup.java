package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Hlookup extends Var3or4ArgFunction {
    private static final ValueEval DEFAULT_ARG3 = BoolEval.TRUE;

    private LookupUtils.ValueVector createResultColumnVector(TwoDEval twoDEval, int i5) throws EvaluationException {
        if (i5 < twoDEval.getHeight()) {
            return LookupUtils.createRowVector(twoDEval, i5);
        }
        throw EvaluationException.invalidRef();
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        return evaluate(i5, i6, valueEval, valueEval2, valueEval3, DEFAULT_ARG3);
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
            TwoDEval twoDEvalResolveTableArrayArg = LookupUtils.resolveTableArrayArg(valueEval2);
            return createResultColumnVector(twoDEvalResolveTableArrayArg, LookupUtils.resolveRowOrColIndexArg(valueEval3, i5, i6)).getItem(LookupUtils.lookupFirstIndexOfValue(singleValue, LookupUtils.createRowVector(twoDEvalResolveTableArrayArg, 0), LookupUtils.resolveRangeLookupArg(valueEval4, i5, i6)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
