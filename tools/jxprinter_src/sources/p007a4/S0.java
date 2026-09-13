package p007a4;

import p044h4.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S0 extends O0 {
    public final /* synthetic */ X0 e;
    private final o select;

    public S0(X0 x6, o oVar) {
        this.e = x6;
        this.select = oVar;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return false;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        X0 x6 = this.e;
        Object state$kotlinx_coroutines_core = x6.getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof C0314z)) {
            state$kotlinx_coroutines_core = Y0.unboxState(state$kotlinx_coroutines_core);
        }
        this.select.trySelect(x6, state$kotlinx_coroutines_core);
    }
}
