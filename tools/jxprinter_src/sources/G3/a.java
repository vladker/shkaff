package G3;

import E3.q;
import java.io.Serializable;
import kotlin.jvm.internal.E;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements E3.g, e, Serializable {
    private final E3.g<Object> completion;

    public a(E3.g<Object> gVar) {
        this.completion = gVar;
    }

    public E3.g<Q> create(E3.g<?> completion) {
        E.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // G3.e
    public e getCallerFrame() {
        E3.g<Object> gVar = this.completion;
        if (gVar instanceof e) {
            return (e) gVar;
        }
        return null;
    }

    public final E3.g<Object> getCompletion() {
        return this.completion;
    }

    @Override // E3.g
    public abstract /* synthetic */ q getContext();

    @Override // G3.e
    public StackTraceElement getStackTraceElement() {
        return g.getStackTraceElement(this);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // E3.g
    public final void resumeWith(Object obj) {
        E3.g<Object> gVar = this;
        while (true) {
            h.probeCoroutineResumed(gVar);
            a aVar = (a) gVar;
            E3.g<Object> gVar2 = aVar.completion;
            E.c(gVar2);
            try {
                Object objInvokeSuspend = aVar.invokeSuspend(obj);
                if (objInvokeSuspend == F3.i.getCOROUTINE_SUSPENDED()) {
                    return;
                } else {
                    obj = u.m1361constructorimpl(objInvokeSuspend);
                }
            } catch (Throwable th) {
                obj = u.m1361constructorimpl(v.createFailure(th));
            }
            aVar.releaseIntercepted();
            if (!(gVar2 instanceof a)) {
                gVar2.resumeWith(obj);
                return;
            }
            gVar = gVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public E3.g<Q> create(Object obj, E3.g<?> completion) {
        E.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
