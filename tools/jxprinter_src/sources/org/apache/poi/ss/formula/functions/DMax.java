package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DMax implements IDStarAlgorithm {
    private ValueEval maximumValue;

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        ValueEval valueEval = this.maximumValue;
        return valueEval == null ? NumberEval.ZERO : valueEval;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval valueEval) {
        if (!(valueEval instanceof NumericValueEval)) {
            return true;
        }
        if (this.maximumValue == null) {
            this.maximumValue = valueEval;
            return true;
        }
        if (((NumericValueEval) valueEval).getNumberValue() <= ((NumericValueEval) this.maximumValue).getNumberValue()) {
            return true;
        }
        this.maximumValue = valueEval;
        return true;
    }
}
