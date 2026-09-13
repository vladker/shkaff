package org.apache.poi.ss.formula.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Mode implements Function {
    private static void collectValue(ValueEval valueEval, List<Double> list, boolean z6) throws EvaluationException {
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval == BlankEval.instance || (valueEval instanceof BoolEval) || (valueEval instanceof StringEval)) {
            if (z6) {
                throw EvaluationException.invalidValue();
            }
        } else {
            if (valueEval instanceof NumberEval) {
                list.add(Double.valueOf(((NumberEval) valueEval).getNumberValue()));
                return;
            }
            throw new RuntimeException("Unexpected value type (" + valueEval.getClass().getName() + ")");
        }
    }

    private static void collectValues(ValueEval valueEval, List<Double> list) throws EvaluationException {
        if (!(valueEval instanceof TwoDEval)) {
            if (!(valueEval instanceof RefEval)) {
                collectValue(valueEval, list, true);
                return;
            }
            RefEval refEval = (RefEval) valueEval;
            int lastSheetIndex = refEval.getLastSheetIndex();
            for (int firstSheetIndex = refEval.getFirstSheetIndex(); firstSheetIndex <= lastSheetIndex; firstSheetIndex++) {
                collectValue(refEval.getInnerValueEval(firstSheetIndex), list, true);
            }
            return;
        }
        TwoDEval twoDEval = (TwoDEval) valueEval;
        int width = twoDEval.getWidth();
        int height = twoDEval.getHeight();
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                collectValue(twoDEval.getValue(i5, i6), list, false);
            }
        }
    }

    public static double evaluate(double[] dArr) throws EvaluationException {
        if (dArr.length < 2) {
            throw new EvaluationException(ErrorEval.NA);
        }
        int length = dArr.length;
        int[] iArr = new int[length];
        Arrays.fill(iArr, 1);
        int length2 = dArr.length;
        int i5 = 0;
        while (i5 < length2) {
            int i6 = i5 + 1;
            int length3 = dArr.length;
            for (int i7 = i6; i7 < length3; i7++) {
                if (dArr[i5] == dArr[i7]) {
                    iArr[i5] = iArr[i5] + 1;
                }
            }
            i5 = i6;
        }
        double d = 0.0d;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = iArr[i9];
            if (i10 > i8) {
                d = dArr[i9];
                i8 = i10;
            }
        }
        if (i8 > 1) {
            return d;
        }
        throw new EvaluationException(ErrorEval.NA);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ValueEval valueEval : valueEvalArr) {
                collectValues(valueEval, arrayList);
            }
            int size = arrayList.size();
            double[] dArr = new double[size];
            for (int i7 = 0; i7 < size; i7++) {
                dArr[i7] = ((Double) arrayList.get(i7)).doubleValue();
            }
            return new NumberEval(evaluate(dArr));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
