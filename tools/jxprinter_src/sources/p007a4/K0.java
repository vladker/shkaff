package p007a4;

import E3.g;
import E3.q;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import p147z3.Q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class K0 {
    /* JADX INFO: renamed from: Job, reason: collision with other method in class */
    public static final InterfaceC0310x m927Job(H0 h1) {
        return N0.m928Job(h1);
    }

    public static final Object cancelAndJoin(H0 h1, g<? super Q> gVar) {
        return N0.cancelAndJoin(h1, gVar);
    }

    public static final void cancelFutureOnCancellation(InterfaceC0285k interfaceC0285k, Future<?> future) {
        L0.cancelFutureOnCancellation(interfaceC0285k, future);
    }

    public static final InterfaceC0280h0 disposeOnCompletion(H0 h1, InterfaceC0280h0 interfaceC0280h0) {
        return N0.disposeOnCompletion(h1, interfaceC0280h0);
    }

    public static final void ensureActive(q qVar) {
        N0.ensureActive(qVar);
    }

    public static final H0 getJob(q qVar) {
        return N0.getJob(qVar);
    }

    public static final InterfaceC0280h0 invokeOnCompletion(H0 h1, boolean z6, O0 o6) {
        return N0.invokeOnCompletion(h1, z6, o6);
    }

    public static final boolean isActive(q qVar) {
        return N0.isActive(qVar);
    }

    public static final void cancel(q qVar, CancellationException cancellationException) {
        N0.cancel(qVar, cancellationException);
    }

    public static final void ensureActive(H0 h1) {
        N0.ensureActive(h1);
    }

    public static final void cancel(H0 h1, String str, Throwable th) {
        N0.cancel(h1, str, th);
    }

    public static final void cancelChildren(q qVar, CancellationException cancellationException) {
        N0.cancelChildren(qVar, cancellationException);
    }

    public static final void cancelChildren(H0 h1, CancellationException cancellationException) {
        N0.cancelChildren(h1, cancellationException);
    }
}
