package org.apache.poi.ss.formula.atp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.PercentRank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class PercentRankExcFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new PercentRankExcFunction(ArgumentsEvaluator.instance);
    private ArgumentsEvaluator evaluator;

    private PercentRankExcFunction(ArgumentsEvaluator argumentsEvaluator) {
        this.evaluator = argumentsEvaluator;
    }

    private ValueEval calculateRank(List<Double> list, double d, int i5, boolean z6) {
        double d6;
        double dDoubleValue;
        double dDoubleValue2 = Double.MIN_VALUE;
        if (z6) {
            double dDoubleValue3 = Double.MAX_VALUE;
            double dDoubleValue4 = Double.MAX_VALUE;
            dDoubleValue = Double.MIN_VALUE;
            for (Double d7 : list) {
                if (d7.doubleValue() <= d && d7.doubleValue() > dDoubleValue) {
                    dDoubleValue = d7.doubleValue();
                }
                if (d7.doubleValue() > d && d7.doubleValue() < dDoubleValue4) {
                    dDoubleValue4 = d7.doubleValue();
                }
                if (d7.doubleValue() < dDoubleValue3) {
                    dDoubleValue3 = d7.doubleValue();
                }
                if (d7.doubleValue() > dDoubleValue2) {
                    dDoubleValue2 = d7.doubleValue();
                }
            }
            if (d < dDoubleValue3 || d > dDoubleValue2) {
                return ErrorEval.NA;
            }
            d6 = dDoubleValue4;
        } else {
            d6 = Double.MAX_VALUE;
            dDoubleValue = Double.MIN_VALUE;
        }
        if (!z6 || dDoubleValue == d || d6 == d) {
            Iterator<Double> it = list.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                if (it.next().doubleValue() < d) {
                    i6++;
                }
            }
            return new NumberEval(PercentRank.round(BigDecimal.valueOf(((double) (i6 + 1)) / ((double) (list.size() + 1))), i5));
        }
        int i7 = i5 < 5 ? 8 : i5 + 3;
        double d8 = dDoubleValue;
        ValueEval valueEvalCalculateRank = calculateRank(list, d8, i7, false);
        if (!(valueEvalCalculateRank instanceof NumberEval)) {
            return valueEvalCalculateRank;
        }
        ValueEval valueEvalCalculateRank2 = calculateRank(list, d6, i7, false);
        if (valueEvalCalculateRank2 instanceof NumberEval) {
            return PercentRank.interpolate(d, d8, d6, (NumberEval) valueEvalCalculateRank, (NumberEval) valueEvalCalculateRank2, i5);
        }
        return valueEvalCalculateRank2;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        return evaluate(valueEvalArr, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
    }

    private ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        int iCoerceValueToInt;
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[1], i5, i6));
            ArrayList arrayList = new ArrayList();
            try {
                for (ValueEval valueEval : PercentRank.getValues(valueEvalArr[0], i5, i6)) {
                    if (!(valueEval instanceof BlankEval) && !(valueEval instanceof MissingArgEval)) {
                        arrayList.add(Double.valueOf(OperandResolver.coerceValueToDouble(valueEval)));
                    }
                }
                if (arrayList.isEmpty()) {
                    return ErrorEval.NUM_ERROR;
                }
                if (valueEvalArr.length > 2) {
                    try {
                        iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[2], i5, i6));
                        if (iCoerceValueToInt < 1) {
                            return ErrorEval.NUM_ERROR;
                        }
                    } catch (EvaluationException e) {
                        return e.getErrorEval();
                    }
                } else {
                    iCoerceValueToInt = 3;
                }
                return calculateRank(arrayList, dCoerceValueToDouble, iCoerceValueToInt, true);
            } catch (EvaluationException e6) {
                ErrorEval errorEval = e6.getErrorEval();
                return errorEval != ErrorEval.NA ? errorEval : ErrorEval.NUM_ERROR;
            }
        } catch (EvaluationException e7) {
            ErrorEval errorEval2 = e7.getErrorEval();
            ErrorEval errorEval3 = ErrorEval.NUM_ERROR;
            return errorEval2 == errorEval3 ? errorEval2 : errorEval3;
        }
    }
}
