package p007a4;

import E3.g;
import E3.j;
import E3.q;
import p028e4.D;
import p028e4.L;
import p147z3.A;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z1 extends D {
    private volatile boolean threadLocalIsSet;
    private final ThreadLocal<C1938s> threadStateToRecover;

    /* JADX WARN: Illegal instructions before constructor call */
    public z1(q qVar, g<Object> gVar) {
        A1 a6 = A1.INSTANCE;
        super(qVar.get(a6) == null ? qVar.plus(a6) : qVar, gVar);
        this.threadStateToRecover = new ThreadLocal<>();
        if (gVar.getContext().get(j.Key) instanceof F) {
            return;
        }
        Object objUpdateThreadContext = L.updateThreadContext(qVar, null);
        L.restoreThreadContext(qVar, objUpdateThreadContext);
        saveThreadContext(qVar, objUpdateThreadContext);
    }

    @Override // p028e4.D, p007a4.AbstractC0260a
    public void afterResume(Object obj) {
        if (this.threadLocalIsSet) {
            C1938s c1938s = this.threadStateToRecover.get();
            if (c1938s != null) {
                L.restoreThreadContext((q) c1938s.f9134a, c1938s.b);
            }
            this.threadStateToRecover.remove();
        }
        Object objRecoverResult = B.recoverResult(obj, this.uCont);
        g<Object> gVar = this.uCont;
        q context = gVar.getContext();
        Object objUpdateThreadContext = L.updateThreadContext(context, null);
        z1 z1VarUpdateUndispatchedCompletion = objUpdateThreadContext != L.NO_THREAD_ELEMENTS ? D.updateUndispatchedCompletion(gVar, context, objUpdateThreadContext) : null;
        try {
            this.uCont.resumeWith(objRecoverResult);
        } finally {
            if (z1VarUpdateUndispatchedCompletion == null || z1VarUpdateUndispatchedCompletion.w()) {
                L.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }

    public final void saveThreadContext(q qVar, Object obj) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(A.to(qVar, obj));
    }

    public final boolean w() {
        boolean z6 = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        this.threadStateToRecover.remove();
        return !z6;
    }
}
