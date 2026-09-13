package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DProduct implements IDStarAlgorithm {
    private boolean initDone = false;
    private double product;

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        return new NumberEval(this.product);
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval valueEval) {
        if (valueEval instanceof NumericValueEval) {
            if (this.initDone) {
                this.product = ((NumericValueEval) valueEval).getNumberValue() * this.product;
            } else {
                this.product = ((NumericValueEval) valueEval).getNumberValue();
                this.initDone = true;
            }
        }
        return true;
    }
}
