package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.LookupUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class XMatchFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new XMatchFunction(ArgumentsEvaluator.instance);
    private final ArgumentsEvaluator evaluator;

    private XMatchFunction(ArgumentsEvaluator argumentsEvaluator) {
        this.evaluator = argumentsEvaluator;
    }

    private ValueEval _evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        LookupUtils.MatchMode matchMode = LookupUtils.MatchMode.ExactMatch;
        if (valueEvalArr.length > 2) {
            try {
                matchMode = LookupUtils.matchMode(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[2], i5, i6)));
            } catch (EvaluationException e) {
                return e.getErrorEval();
            } catch (Exception unused) {
                return ErrorEval.VALUE_INVALID;
            }
        }
        LookupUtils.MatchMode matchMode2 = matchMode;
        LookupUtils.SearchMode searchMode = LookupUtils.SearchMode.IterateForward;
        if (valueEvalArr.length > 3) {
            try {
                searchMode = LookupUtils.searchMode(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[3], i5, i6)));
            } catch (EvaluationException e6) {
                return e6.getErrorEval();
            } catch (Exception unused2) {
                return ErrorEval.VALUE_INVALID;
            }
        }
        return evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1], matchMode2, searchMode);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        return _evaluate(valueEvalArr, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
    }

    private ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, LookupUtils.MatchMode matchMode, LookupUtils.SearchMode searchMode) {
        LookupUtils.ValueVector valueVectorCreateRowVector;
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
            TwoDEval twoDEvalResolveTableArrayArg = LookupUtils.resolveTableArrayArg(valueEval2);
            if (twoDEvalResolveTableArrayArg.isColumn()) {
                valueVectorCreateRowVector = LookupUtils.createColumnVector(twoDEvalResolveTableArrayArg, 0);
            } else {
                valueVectorCreateRowVector = LookupUtils.createRowVector(twoDEvalResolveTableArrayArg, 0);
            }
            return new NumberEval(((double) LookupUtils.xlookupIndexOfValue(singleValue, valueVectorCreateRowVector, matchMode, searchMode)) + 1.0d);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
