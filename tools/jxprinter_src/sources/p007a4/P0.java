package p007a4;

import E3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P0 extends C0289m {
    private final X0 job;

    public P0(g<Object> gVar, X0 x6) {
        super(gVar, 1);
        this.job = x6;
    }

    @Override // p007a4.C0289m
    public Throwable getContinuationCancellationCause(H0 h1) {
        Throwable rootCause;
        Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof R0) || (rootCause = ((R0) state$kotlinx_coroutines_core).getRootCause()) == null) {
            return state$kotlinx_coroutines_core instanceof C0314z ? ((C0314z) state$kotlinx_coroutines_core).cause : h1.getCancellationException();
        }
        return rootCause;
    }

    @Override // p007a4.C0289m
    public String nameString() {
        return "AwaitContinuation";
    }
}
