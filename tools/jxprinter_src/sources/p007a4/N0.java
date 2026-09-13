package p007a4;

import E3.g;
import E3.o;
import E3.q;
import F3.i;
import W3.InterfaceC0233q;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class N0 {
    /* JADX INFO: renamed from: Job, reason: collision with other method in class */
    public static final InterfaceC0310x m928Job(H0 h1) {
        return new J0(h1);
    }

    public static final void cancel(q qVar, CancellationException cancellationException) {
        H0 h1 = (H0) qVar.get(H0.Key);
        if (h1 != null) {
            h1.cancel(cancellationException);
        }
    }

    public static final Object cancelAndJoin(H0 h1, g<? super Q> gVar) {
        h1.cancel((CancellationException) null);
        Object objJoin = h1.join(gVar);
        return objJoin == i.getCOROUTINE_SUSPENDED() ? objJoin : Q.INSTANCE;
    }

    public static final void cancelChildren(H0 h1, CancellationException cancellationException) {
        Iterator<Object> it = h1.getChildren().iterator();
        while (it.hasNext()) {
            ((H0) it.next()).cancel(cancellationException);
        }
    }

    public static final InterfaceC0280h0 disposeOnCompletion(H0 h1, InterfaceC0280h0 interfaceC0280h0) {
        return K0.invokeOnCompletion(h1, true, new C0284j0(interfaceC0280h0));
    }

    public static final void ensureActive(H0 h1) {
        if (!h1.isActive()) {
            throw h1.getCancellationException();
        }
    }

    public static final H0 getJob(q qVar) {
        H0 h1 = (H0) qVar.get(H0.Key);
        if (h1 != null) {
            return h1;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + qVar).toString());
    }

    public static final InterfaceC0280h0 invokeOnCompletion(H0 h1, boolean z6, O0 o6) {
        return h1 instanceof X0 ? ((X0) h1).invokeOnCompletionInternal$kotlinx_coroutines_core(z6, o6) : h1.invokeOnCompletion(o6.d(), z6, new M0(1, o6, O0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0));
    }

    public static final boolean isActive(q qVar) {
        H0 h1 = (H0) qVar.get(H0.Key);
        if (h1 != null) {
            return h1.isActive();
        }
        return true;
    }

    public static final void ensureActive(q qVar) {
        H0 h1 = (H0) qVar.get(H0.Key);
        if (h1 != null) {
            K0.ensureActive(h1);
        }
    }

    public static final void cancel(H0 h1, String str, Throwable th) {
        h1.cancel(AbstractC0305u0.CancellationException(str, th));
    }

    public static final boolean cancel(q qVar, Throwable th) throws Throwable {
        o oVar = qVar.get(H0.Key);
        X0 x6 = oVar instanceof X0 ? (X0) oVar : null;
        if (x6 == null) {
            return false;
        }
        if (th == null) {
            th = new I0("Job was cancelled", null, x6);
        }
        x6.cancelInternal(th);
        return true;
    }

    public static final void cancelChildren(H0 h1, Throwable th) throws Throwable {
        for (H0 h6 : h1.getChildren()) {
            X0 x6 = h6 instanceof X0 ? (X0) h6 : null;
            if (x6 != null) {
                x6.cancelInternal(th == null ? new I0("Job was cancelled", null, h1) : th);
            }
        }
    }

    public static final void cancelChildren(q qVar, CancellationException cancellationException) {
        InterfaceC0233q children;
        H0 h1 = (H0) qVar.get(H0.Key);
        if (h1 == null || (children = h1.getChildren()) == null) {
            return;
        }
        Iterator<Object> it = children.iterator();
        while (it.hasNext()) {
            ((H0) it.next()).cancel(cancellationException);
        }
    }

    public static final void cancelChildren(q qVar, Throwable th) throws Throwable {
        H0 h1 = (H0) qVar.get(H0.Key);
        if (h1 == null) {
            return;
        }
        for (H0 h6 : h1.getChildren()) {
            X0 x6 = h6 instanceof X0 ? (X0) h6 : null;
            if (x6 != null) {
                x6.cancelInternal(th == null ? new I0("Job was cancelled", null, h1) : th);
            }
        }
    }
}
