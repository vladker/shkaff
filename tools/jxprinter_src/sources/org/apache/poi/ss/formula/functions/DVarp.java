package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DVarp implements IDStarAlgorithm {
    private final ArrayList<NumericValueEval> values = new ArrayList<>();

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        double[] dArr = new double[this.values.size()];
        ArrayList<NumericValueEval> arrayList = this.values;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            NumericValueEval numericValueEval = arrayList.get(i6);
            i6++;
            dArr[i5] = numericValueEval.getNumberValue();
            i5++;
        }
        return new NumberEval(new BigDecimal(NumberToTextConverter.toText(StatsLib.varp(dArr))).doubleValue());
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval valueEval) {
        if (!(valueEval instanceof NumericValueEval)) {
            return true;
        }
        this.values.add((NumericValueEval) valueEval);
        return true;
    }
}
