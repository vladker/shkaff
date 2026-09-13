package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Sumif extends Var2or3ArgFunction {
    private static double accumulate(AreaEval areaEval, CountUtils.I_MatchPredicate i_MatchPredicate, AreaEval areaEval2, int i5, int i6) throws EvaluationException {
        if (!i_MatchPredicate.matches(areaEval.getRelativeValue(i5, i6))) {
            return 0.0d;
        }
        ValueEval relativeValue = areaEval2.getRelativeValue(i5, i6);
        if (relativeValue instanceof NumberEval) {
            return ((NumberEval) relativeValue).getNumberValue();
        }
        if (relativeValue instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) relativeValue);
        }
        return 0.0d;
    }

    private static AreaEval convertRangeArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static AreaEval createSumRange(ValueEval valueEval, AreaEval areaEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return ((AreaEval) valueEval).offset(0, areaEval.getHeight() - 1, 0, areaEval.getWidth() - 1);
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, areaEval.getHeight() - 1, 0, areaEval.getWidth() - 1);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static ValueEval eval(int i5, int i6, ValueEval valueEval, AreaEval areaEval, AreaEval areaEval2) {
        CountUtils.I_MatchPredicate i_MatchPredicateCreateCriteriaPredicate = Countif.createCriteriaPredicate(valueEval, i5, i6);
        if (i_MatchPredicateCreateCriteriaPredicate == null) {
            return NumberEval.ZERO;
        }
        try {
            return new NumberEval(sumMatchingCells(areaEval, i_MatchPredicateCreateCriteriaPredicate, areaEval2));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static double sumMatchingCells(AreaEval areaEval, CountUtils.I_MatchPredicate i_MatchPredicate, AreaEval areaEval2) {
        int height = areaEval.getHeight();
        int width = areaEval.getWidth();
        double dAccumulate = 0.0d;
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                dAccumulate += accumulate(areaEval, i_MatchPredicate, areaEval2, i5, i6);
            }
        }
        return dAccumulate;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            AreaEval areaEvalConvertRangeArg = convertRangeArg(valueEval);
            return eval(i5, i6, valueEval2, areaEvalConvertRangeArg, areaEvalConvertRangeArg);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            AreaEval areaEvalConvertRangeArg = convertRangeArg(valueEval);
            return eval(i5, i6, valueEval2, areaEvalConvertRangeArg, createSumRange(valueEval3, areaEvalConvertRangeArg));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
