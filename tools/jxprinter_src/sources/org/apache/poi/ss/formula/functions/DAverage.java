package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DAverage implements IDStarAlgorithm {
    private long count;
    private double total;

    private static double divide(double d, long j6) {
        return BigDecimal.valueOf(d).divide(BigDecimal.valueOf(j6), MathContext.DECIMAL128).doubleValue();
    }

    private double getAverage() {
        return divide(this.total, this.count);
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        return this.count == 0 ? NumberEval.ZERO : new NumberEval(getAverage());
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval valueEval) {
        if (!(valueEval instanceof NumericValueEval)) {
            return true;
        }
        this.count++;
        this.total = ((NumericValueEval) valueEval).getNumberValue() + this.total;
        return true;
    }
}
