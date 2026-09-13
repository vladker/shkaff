package org.apache.poi.ss.formula.eval;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FunctionNameEval implements ValueEval {
    private final String _functionName;

    public FunctionNameEval(String str) {
        this._functionName = str;
    }

    public String getFunctionName() {
        return this._functionName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(FunctionNameEval.class, sb, " [");
        return AbstractC0157z.s(sb, this._functionName, "]");
    }
}
