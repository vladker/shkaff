package org.apache.poi.ss.formula.atp;

import java.util.ArrayList;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class ArgumentsEvaluator {
    public static final ArgumentsEvaluator instance = new ArgumentsEvaluator();

    private ArgumentsEvaluator() {
    }

    public double evaluateDateArg(ValueEval valueEval, int i5, int i6) {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, (short) i6);
        if (!(singleValue instanceof StringEval)) {
            return OperandResolver.coerceValueToDouble(singleValue);
        }
        String stringValue = ((StringEval) singleValue).getStringValue();
        Double d = OperandResolver.parseDouble(stringValue);
        return d != null ? d.doubleValue() : DateUtil.getExcelDate(org.apache.poi.ss.util.DateParser.parseLocalDate(stringValue), false);
    }

    public double[] evaluateDatesArg(ValueEval valueEval, int i5, int i6) {
        if (valueEval == null) {
            return new double[0];
        }
        if (valueEval instanceof StringEval) {
            return new double[]{evaluateDateArg(valueEval, i5, i6)};
        }
        if (!(valueEval instanceof AreaEvalBase)) {
            return new double[]{OperandResolver.coerceValueToDouble(valueEval)};
        }
        ArrayList arrayList = new ArrayList();
        AreaEvalBase areaEvalBase = (AreaEvalBase) valueEval;
        for (int firstRow = areaEvalBase.getFirstRow(); firstRow <= areaEvalBase.getLastRow(); firstRow++) {
            for (int firstColumn = areaEvalBase.getFirstColumn(); firstColumn <= areaEvalBase.getLastColumn(); firstColumn++) {
                arrayList.add(Double.valueOf(evaluateDateArg(areaEvalBase.getAbsoluteValue(firstRow, firstColumn), firstRow, firstColumn)));
            }
        }
        double[] dArr = new double[arrayList.size()];
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            dArr[i7] = ((Double) arrayList.get(i7)).doubleValue();
        }
        return dArr;
    }

    public double evaluateNumberArg(ValueEval valueEval, int i5, int i6) {
        if (valueEval == null) {
            return 0.0d;
        }
        return OperandResolver.coerceValueToDouble(valueEval);
    }
}
