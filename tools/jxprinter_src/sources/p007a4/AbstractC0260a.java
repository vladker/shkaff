package p007a4;

import A3.AbstractC0157z;
import E3.g;
import E3.q;
import O3.p;

/* JADX INFO: renamed from: a4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0260a extends X0 implements g, M {
    private final q context;

    public AbstractC0260a(q qVar, boolean z6, boolean z7) {
        super(z7);
        if (z6) {
            initParentJob((H0) qVar.get(H0.Key));
        }
        this.context = qVar.plus(this);
    }

    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    @Override // p007a4.X0
    public String cancellationExceptionMessage() {
        return S.getClassSimpleName(this) + " was cancelled";
    }

    @Override // E3.g
    public final q getContext() {
        return this.context;
    }

    @Override // p007a4.M
    public q getCoroutineContext() {
        return this.context;
    }

    @Override // p007a4.X0
    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) {
        J.handleCoroutineException(this.context, th);
    }

    @Override // p007a4.X0
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = D.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        StringBuilder sbY = AbstractC0157z.y("\"", coroutineName, "\":");
        sbY.append(super.nameString$kotlinx_coroutines_core());
        return sbY.toString();
    }

    @Override // p007a4.X0
    public final void onCompletionInternal(Object obj) {
        if (!(obj instanceof C0314z)) {
            v(obj);
        } else {
            C0314z c0314z = (C0314z) obj;
            onCancelled(c0314z.cause, C0314z.f960a.get(c0314z) != 0);
        }
    }

    @Override // E3.g
    public final void resumeWith(Object obj) {
        Object objMakeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(B.toState(obj));
        if (objMakeCompletingOnce$kotlinx_coroutines_core == Y0.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        afterResume(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    public final <R> void start(P p6, R r6, p pVar) {
        p6.invoke(pVar, r6, this);
    }

    public void v(Object obj) {
    }

    public void onCancelled(Throwable th, boolean z6) {
    }
}
