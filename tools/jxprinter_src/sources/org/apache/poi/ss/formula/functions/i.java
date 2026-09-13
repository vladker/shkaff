package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class i implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7209a;
    public final /* synthetic */ Object b;

    public /* synthetic */ i(Object obj, int i5) {
        this.f7209a = i5;
        this.b = obj;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        switch (this.f7209a) {
            case 0:
                return NumericFunction.lambda$oneDouble$7((NumericFunction.OneDoubleIf) this.b, valueEvalArr, i5, i6);
            default:
                return NumericFunction.lambda$twoDouble$8((NumericFunction.TwoDoubleIf) this.b, valueEvalArr, i5, i6);
        }
    }
}
