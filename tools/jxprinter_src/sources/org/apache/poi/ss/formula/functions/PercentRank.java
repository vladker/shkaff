package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PercentRank implements Function {
    public static final Function instance = new PercentRank();

    private PercentRank() {
    }

    private ValueEval calculateRank(List<Double> list, double d, int i5, boolean z6) {
        double dDoubleValue = Double.MIN_VALUE;
        double dDoubleValue2 = Double.MAX_VALUE;
        if (z6) {
            for (Double d6 : list) {
                if (d6.doubleValue() <= d && d6.doubleValue() > dDoubleValue) {
                    dDoubleValue = d6.doubleValue();
                }
                if (d6.doubleValue() > d && d6.doubleValue() < dDoubleValue2) {
                    dDoubleValue2 = d6.doubleValue();
                }
            }
        }
        double d7 = dDoubleValue;
        if (z6 && d7 != d && dDoubleValue2 != d) {
            int i6 = i5 < 5 ? 8 : i5 + 3;
            ValueEval valueEvalCalculateRank = calculateRank(list, d7, i6, false);
            if (!(valueEvalCalculateRank instanceof NumberEval)) {
                return valueEvalCalculateRank;
            }
            ValueEval valueEvalCalculateRank2 = calculateRank(list, dDoubleValue2, i6, false);
            if (valueEvalCalculateRank2 instanceof NumberEval) {
                return interpolate(d, d7, dDoubleValue2, (NumberEval) valueEvalCalculateRank, (NumberEval) valueEvalCalculateRank2, i5);
            }
            return valueEvalCalculateRank2;
        }
        int i7 = 0;
        int i8 = 0;
        for (Double d8 : list) {
            if (d8.doubleValue() < d) {
                i8++;
            } else if (d8.doubleValue() > d) {
                i7++;
            }
        }
        if (i7 == list.size() || i8 == list.size()) {
            return ErrorEval.NA;
        }
        int i9 = i7 + i8;
        return i9 == 0 ? new NumberEval(0.0d) : new NumberEval(round(BigDecimal.valueOf(((double) i8) / ((double) i9)), i5));
    }

    @Internal
    public static List<ValueEval> getValues(ValueEval valueEval, int i5, int i6) {
        if (!(valueEval instanceof AreaEval)) {
            return Collections.singletonList(OperandResolver.getSingleValue(valueEval, i5, i6));
        }
        AreaEval areaEval = (AreaEval) valueEval;
        ArrayList arrayList = new ArrayList();
        for (int firstRow = areaEval.getFirstRow(); firstRow <= areaEval.getLastRow(); firstRow++) {
            for (int firstColumn = areaEval.getFirstColumn(); firstColumn <= areaEval.getLastColumn(); firstColumn++) {
                arrayList.add(OperandResolver.getSingleValue(areaEval.getAbsoluteValue(firstRow, firstColumn), firstRow, firstColumn));
            }
        }
        return arrayList;
    }

    @Internal
    public static NumberEval interpolate(double d, double d6, double d7, NumberEval numberEval, NumberEval numberEval2, int i5) {
        double d8 = d7 - d6;
        double d9 = d - d6;
        return new NumberEval(round(BigDecimal.valueOf(numberEval.getNumberValue()).add(new BigDecimal(NumberToTextConverter.toText(numberEval2.getNumberValue() - numberEval.getNumberValue())).multiply(BigDecimal.valueOf(d9 / d8))), i5));
    }

    @Internal
    public static double round(BigDecimal bigDecimal, int i5) {
        return bigDecimal.setScale(i5 + 3, RoundingMode.HALF_UP).setScale(i5, RoundingMode.DOWN).doubleValue();
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        int iCoerceValueToInt;
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[1], i5, i6));
            ArrayList arrayList = new ArrayList();
            try {
                for (ValueEval valueEval : getValues(valueEvalArr[0], i5, i6)) {
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
