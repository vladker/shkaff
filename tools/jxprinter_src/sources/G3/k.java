package G3;

import E3.q;
import E3.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends a {
    public k(E3.g<Object> gVar) {
        super(gVar);
        if (gVar != null && gVar.getContext() != r.INSTANCE) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // G3.a, E3.g
    public q getContext() {
        return r.INSTANCE;
    }
}
