package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7203a;

    public /* synthetic */ a(int i5) {
        this.f7203a = i5;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        switch (this.f7203a) {
            case 0:
                return BooleanFunction.evaluateFalse(valueEvalArr, i5, i6);
            case 1:
                return BooleanFunction.evaluateTrue(valueEvalArr, i5, i6);
            case 2:
                return BooleanFunction.evaluateNot(valueEvalArr, i5, i6);
            case 3:
                return NumericFunction.evaluateDollar(valueEvalArr, i5, i6);
            case 4:
                return NumericFunction.evaluateTrunc(valueEvalArr, i5, i6);
            case 5:
                return Log.evaluate(valueEvalArr, i5, i6);
            case 6:
                return NumericFunction.evaluatePI(valueEvalArr, i5, i6);
            case 7:
                return NumericFunction.evaluateRand(valueEvalArr, i5, i6);
            case 8:
                return Poisson.evaluate(valueEvalArr, i5, i6);
            default:
                return TextFunction.lambda$static$1(valueEvalArr, i5, i6);
        }
    }
}
