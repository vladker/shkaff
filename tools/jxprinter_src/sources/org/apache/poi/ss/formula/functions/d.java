package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.NumberEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements java.util.function.Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return new NumberEval(((Integer) obj).intValue());
    }
}
