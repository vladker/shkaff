package p007a4;

/* JADX INFO: renamed from: a4.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0297q extends O0 {
    public final C0289m child;

    public C0297q(C0289m c0289m) {
        this.child = c0289m;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return true;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        C0289m c0289m = this.child;
        c0289m.parentCancelled$kotlinx_coroutines_core(c0289m.getContinuationCancellationCause(getJob()));
    }
}
