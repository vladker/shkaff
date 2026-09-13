package org.apache.poi.ss.formula.eval;

import A3.AbstractC0157z;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.StringPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StringEval implements StringValueEval {
    public static final StringEval EMPTY_INSTANCE = new StringEval("");
    private final String _value;

    public StringEval(Ptg ptg) {
        this(((StringPtg) ptg).getValue());
    }

    @Override // org.apache.poi.ss.formula.eval.StringValueEval
    public String getStringValue() {
        return this._value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(StringEval.class, sb, " [");
        return AbstractC0157z.s(sb, this._value, "]");
    }

    public StringEval(String str) {
        if (str == null) {
            throw new IllegalArgumentException("value must not be null");
        }
        this._value = str;
    }
}
