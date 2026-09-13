package kotlinx.coroutines.flow.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends p028e4.D {
    public y(E3.q qVar, E3.g<Object> gVar) {
        super(qVar, gVar);
    }

    @Override // p007a4.X0
    public boolean childCancelled(Throwable th) {
        if (th instanceof q) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th);
    }
}
