package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class Baseifs implements FreeRefFunction {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Aggregator {
        void addValue(ValueEval valueEval);

        ValueEval getResult();
    }

    private static ValueEval aggregateMatchingCells(Aggregator aggregator, AreaEval areaEval, AreaEval[] areaEvalArr, CountUtils.I_MatchPredicate[] i_MatchPredicateArr) throws EvaluationException {
        int height = areaEvalArr[0].getHeight();
        int width = areaEvalArr[0].getWidth();
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                int i7 = 0;
                while (true) {
                    if (i7 >= areaEvalArr.length) {
                        if (areaEval == null) {
                            aggregator.addValue(null);
                            break;
                        }
                        ValueEval relativeValue = areaEval.getRelativeValue(i5, i6);
                        if (!(relativeValue instanceof ErrorEval)) {
                            aggregator.addValue(relativeValue);
                            break;
                        }
                        throw new EvaluationException((ErrorEval) relativeValue);
                    }
                    AreaEval areaEval2 = areaEvalArr[i7];
                    CountUtils.I_MatchPredicate i_MatchPredicate = i_MatchPredicateArr[i7];
                    if (i_MatchPredicate == null || !i_MatchPredicate.matches(areaEval2.getRelativeValue(i5, i6))) {
                        break;
                    }
                    i7++;
                }
            }
        }
        return aggregator.getResult();
    }

    public static AreaEval convertRangeArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static void validateCriteria(CountUtils.I_MatchPredicate[] i_MatchPredicateArr) throws EvaluationException {
        for (CountUtils.I_MatchPredicate i_MatchPredicate : i_MatchPredicateArr) {
            if (i_MatchPredicate instanceof Countif.ErrorMatcher) {
                throw new EvaluationException(ErrorEval.valueOf(((Countif.ErrorMatcher) i_MatchPredicate).getValue()));
            }
        }
    }

    private static void validateCriteriaRanges(AreaEval areaEval, AreaEval[] areaEvalArr) throws EvaluationException {
        int height = areaEvalArr[0].getHeight();
        int width = areaEvalArr[0].getWidth();
        if (areaEval != null && (areaEval.getHeight() != height || areaEval.getWidth() != width)) {
            throw EvaluationException.invalidValue();
        }
        for (AreaEval areaEval2 : areaEvalArr) {
            if (areaEval2.getHeight() != height || areaEval2.getWidth() != width) {
                throw EvaluationException.invalidValue();
            }
        }
    }

    public abstract Aggregator createAggregator();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        AreaEval areaEvalConvertRangeArg;
        ?? HasInitialRange = hasInitialRange();
        if (valueEvalArr.length < HasInitialRange + 2 || valueEvalArr.length % 2 != HasInitialRange) {
            return ErrorEval.VALUE_INVALID;
        }
        int i5 = 0;
        if (HasInitialRange != 0) {
            try {
                areaEvalConvertRangeArg = convertRangeArg(valueEvalArr[0]);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        } else {
            areaEvalConvertRangeArg = null;
        }
        int length = (valueEvalArr.length - HasInitialRange) / 2;
        AreaEval[] areaEvalArr = new AreaEval[length];
        CountUtils.I_MatchPredicate[] i_MatchPredicateArr = new CountUtils.I_MatchPredicate[length];
        for (?? r6 = HasInitialRange; r6 < valueEvalArr.length; r6 += 2) {
            areaEvalArr[i5] = convertRangeArg(valueEvalArr[r6]);
            i_MatchPredicateArr[i5] = Countif.createCriteriaPredicate(valueEvalArr[r6 + 1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            i5++;
        }
        validateCriteriaRanges(areaEvalConvertRangeArg, areaEvalArr);
        validateCriteria(i_MatchPredicateArr);
        return aggregateMatchingCells(createAggregator(), areaEvalConvertRangeArg, areaEvalArr, i_MatchPredicateArr);
    }

    public abstract boolean hasInitialRange();
}
