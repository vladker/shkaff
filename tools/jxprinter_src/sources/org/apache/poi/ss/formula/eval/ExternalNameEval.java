package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.EvaluationName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExternalNameEval implements ValueEval {
    private final EvaluationName _name;

    public ExternalNameEval(EvaluationName evaluationName) {
        this._name = evaluationName;
    }

    public EvaluationName getName() {
        return this._name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(ExternalNameEval.class, sb, " [");
        sb.append(this._name.getNameText());
        sb.append("]");
        return sb.toString();
    }
}
