package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements NumericFunction.OneDoubleIf, CountUtils.I_MatchPredicate, XYNumericFunction.Accumulator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7208a;

    public /* synthetic */ h(int i5) {
        this.f7208a = i5;
    }

    @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.Accumulator
    public double accumulate(double d, double d6) {
        switch (this.f7208a) {
            case 11:
                return Sumx2my2.lambda$static$0(d, d6);
            case 12:
                return Sumx2py2.lambda$static$0(d, d6);
            default:
                return Sumxmy2.lambda$static$0(d, d6);
        }
    }

    @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneDoubleIf
    public double apply(double d) {
        switch (this.f7208a) {
            case 0:
                return Math.toDegrees(d);
            case 1:
                return MathX.factorial(d);
            case 2:
                return NumericFunction.lambda$static$1(d);
            case 3:
                return Math.log(d);
            case 4:
                return NumericFunction.lambda$static$2(d);
            case 5:
                return Math.toRadians(d);
            case 6:
                return MathX.sign(d);
            default:
                return Math.sin(d);
        }
    }

    @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
    public boolean matches(ValueEval valueEval) {
        switch (this.f7208a) {
            case 8:
                return Count.lambda$static$0(valueEval);
            case 9:
                return Counta.lambda$static$0(valueEval);
            default:
                return Countblank.lambda$static$0(valueEval);
        }
    }
}
