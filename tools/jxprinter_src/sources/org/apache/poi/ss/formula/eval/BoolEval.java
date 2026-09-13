package org.apache.poi.ss.formula.eval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BoolEval implements NumericValueEval, StringValueEval {
    public static final BoolEval FALSE = new BoolEval(false);
    public static final BoolEval TRUE = new BoolEval(true);
    private final boolean _value;

    private BoolEval(boolean z6) {
        this._value = z6;
    }

    public static BoolEval valueOf(boolean z6) {
        return z6 ? TRUE : FALSE;
    }

    public boolean getBooleanValue() {
        return this._value;
    }

    @Override // org.apache.poi.ss.formula.eval.NumericValueEval
    public double getNumberValue() {
        return this._value ? 1.0d : 0.0d;
    }

    @Override // org.apache.poi.ss.formula.eval.StringValueEval
    public String getStringValue() {
        return this._value ? "TRUE" : "FALSE";
    }

    public String toString() {
        return BoolEval.class.getName() + " [" + getStringValue() + "]";
    }
}
