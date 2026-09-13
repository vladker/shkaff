package org.apache.poi.ss.formula.eval;

import java.util.function.Function;
import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
import org.apache.poi.ss.formula.functions.Value;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7202a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Fixed1ArgFunction d;

    public /* synthetic */ c(Fixed1ArgFunction fixed1ArgFunction, int i5, int i6, int i7) {
        this.f7202a = i7;
        this.d = fixed1ArgFunction;
        this.b = i5;
        this.c = i6;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7202a) {
            case 0:
                return ((UnaryMinusEval) this.d).lambda$evaluateArray$0(this.b, this.c, (ValueEval) obj);
            case 1:
                return ((UnaryPlusEval) this.d).lambda$evaluateArray$0(this.b, this.c, (ValueEval) obj);
            default:
                return ((Value) this.d).lambda$evaluateArray$0(this.b, this.c, (ValueEval) obj);
        }
    }
}
