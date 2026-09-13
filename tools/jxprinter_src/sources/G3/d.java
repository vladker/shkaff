package G3;

import E3.o;
import E3.q;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends a {
    private final q _context;
    private transient E3.g<Object> intercepted;

    public d(E3.g<Object> gVar, q qVar) {
        super(gVar);
        this._context = qVar;
    }

    @Override // G3.a, E3.g
    public q getContext() {
        q qVar = this._context;
        E.c(qVar);
        return qVar;
    }

    public final E3.g<Object> intercepted() {
        E3.g<Object> gVarInterceptContinuation = this.intercepted;
        if (gVarInterceptContinuation == null) {
            E3.j jVar = (E3.j) getContext().get(E3.j.Key);
            if (jVar == null || (gVarInterceptContinuation = jVar.interceptContinuation(this)) == null) {
                gVarInterceptContinuation = this;
            }
            this.intercepted = gVarInterceptContinuation;
        }
        return gVarInterceptContinuation;
    }

    @Override // G3.a
    public void releaseIntercepted() {
        E3.g<?> gVar = this.intercepted;
        if (gVar != null && gVar != this) {
            o oVar = getContext().get(E3.j.Key);
            E.c(oVar);
            ((E3.j) oVar).releaseInterceptedContinuation(gVar);
        }
        this.intercepted = c.INSTANCE;
    }

    public d(E3.g<Object> gVar) {
        this(gVar, gVar != null ? gVar.getContext() : null);
    }
}
