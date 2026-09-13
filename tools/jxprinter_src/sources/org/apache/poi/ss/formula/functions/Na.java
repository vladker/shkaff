package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Na {
    public static ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 0 ? ErrorEval.VALUE_INVALID : ErrorEval.NA;
    }
}
