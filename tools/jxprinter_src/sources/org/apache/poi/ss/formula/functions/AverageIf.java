package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AverageIf extends Baseifs {
    public static final FreeRefFunction instance = new AverageIf();

    public ValueEval aggregateMatchingCells(Baseifs.Aggregator aggregator, AreaEval areaEval, AreaEval areaEval2, CountUtils.I_MatchPredicate i_MatchPredicate) throws EvaluationException {
        int height = areaEval2.getHeight();
        int width = areaEval2.getWidth();
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                ValueEval relativeValue = areaEval2.getRelativeValue(i5, i6);
                ValueEval relativeValue2 = areaEval.getRelativeValue(i5, i6);
                if (i_MatchPredicate != null && i_MatchPredicate.matches(relativeValue)) {
                    if (relativeValue instanceof ErrorEval) {
                        throw new EvaluationException((ErrorEval) relativeValue);
                    }
                    aggregator.addValue(relativeValue2);
                }
            }
        }
        return aggregator.getResult();
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs
    public Baseifs.Aggregator createAggregator() {
        return new Baseifs.Aggregator() { // from class: org.apache.poi.ss.formula.functions.AverageIf.1
            Double sum = Double.valueOf(0.0d);
            Integer count = 0;

            @Override // org.apache.poi.ss.formula.functions.Baseifs.Aggregator
            public void addValue(ValueEval valueEval) {
                if (valueEval instanceof NumberEval) {
                    this.sum = Double.valueOf(this.sum.doubleValue() + ((NumberEval) valueEval).getNumberValue());
                    this.count = Integer.valueOf(this.count.intValue() + 1);
                }
            }

            @Override // org.apache.poi.ss.formula.functions.Baseifs.Aggregator
            public ValueEval getResult() {
                return this.count.intValue() == 0 ? ErrorEval.DIV_ZERO : new NumberEval(this.sum.doubleValue() / ((double) this.count.intValue()));
            }
        };
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs, org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            AreaEval areaEvalConvertRangeArg = Baseifs.convertRangeArg(valueEvalArr[0]);
            if (valueEvalArr.length == 3) {
                areaEvalConvertRangeArg = Baseifs.convertRangeArg(valueEvalArr[2]);
            }
            AreaEval areaEvalConvertRangeArg2 = Baseifs.convertRangeArg(valueEvalArr[0]);
            CountUtils.I_MatchPredicate i_MatchPredicateCreateCriteriaPredicate = Countif.createCriteriaPredicate(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            if (i_MatchPredicateCreateCriteriaPredicate instanceof Countif.ErrorMatcher) {
                throw new EvaluationException(ErrorEval.valueOf(((Countif.ErrorMatcher) i_MatchPredicateCreateCriteriaPredicate).getValue()));
            }
            return aggregateMatchingCells(createAggregator(), areaEvalConvertRangeArg, areaEvalConvertRangeArg2, i_MatchPredicateCreateCriteriaPredicate);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Baseifs
    public boolean hasInitialRange() {
        return false;
    }
}
