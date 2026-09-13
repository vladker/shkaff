package p007a4;

import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends O0 {
    private final C0289m continuation;

    public h1(C0289m c0289m) {
        this.continuation = c0289m;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return false;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        Object state$kotlinx_coroutines_core = getJob().getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof C0314z) {
            this.continuation.resumeWith(u.m1361constructorimpl(v.createFailure(((C0314z) state$kotlinx_coroutines_core).cause)));
        } else {
            this.continuation.resumeWith(u.m1361constructorimpl(Y0.unboxState(state$kotlinx_coroutines_core)));
        }
    }
}
