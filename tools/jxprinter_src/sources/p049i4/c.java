package p049i4;

import E3.q;
import O3.l;
import W3.G;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p007a4.B1;
import p007a4.C0289m;
import p007a4.F;
import p007a4.InterfaceC0285k;
import p018c4.C0370c;
import p028e4.E;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements InterfaceC0285k, B1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f4064a;
    public final C0289m cont;
    public final Object owner;

    public c(g gVar, C0289m c0289m, Object obj) {
        this.f4064a = gVar;
        this.cont = c0289m;
        this.owner = obj;
    }

    @Override // p007a4.InterfaceC0285k
    public boolean cancel(Throwable th) {
        return this.cont.cancel(th);
    }

    @Override // p007a4.InterfaceC0285k
    public void completeResume(Object obj) {
        this.cont.completeResume(obj);
    }

    @Override // p007a4.InterfaceC0285k, E3.g
    public q getContext() {
        return this.cont.getContext();
    }

    @Override // p007a4.InterfaceC0285k
    public void initCancellability() {
        this.cont.initCancellability();
    }

    @Override // p007a4.InterfaceC0285k
    public void invokeOnCancellation(l lVar) {
        this.cont.invokeOnCancellation(lVar);
    }

    @Override // p007a4.InterfaceC0285k
    public void resume(Q q6, l lVar) {
        this.cont.resume(q6, lVar);
    }

    @Override // p007a4.InterfaceC0285k
    public void resumeUndispatched(F f6, Q q6) {
        this.cont.resumeUndispatched(f6, q6);
    }

    @Override // p007a4.InterfaceC0285k
    public void resumeUndispatchedWithException(F f6, Throwable th) {
        this.cont.resumeUndispatchedWithException(f6, th);
    }

    @Override // p007a4.InterfaceC0285k, E3.g
    public void resumeWith(Object obj) {
        this.cont.resumeWith(obj);
    }

    @Override // p007a4.InterfaceC0285k
    public Object tryResume(Q q6, Object obj) {
        return this.cont.tryResume(q6, obj);
    }

    @Override // p007a4.InterfaceC0285k
    public Object tryResumeWithException(Throwable th) {
        return this.cont.tryResumeWithException(th);
    }

    @Override // p007a4.B1
    public void invokeOnCancellation(E e, int i5) {
        this.cont.invokeOnCancellation(e, i5);
    }

    @Override // p007a4.InterfaceC0285k
    public <R extends Q> void resume(R r6, O3.q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g.f4068g;
        Object obj = this.owner;
        g gVar = this.f4064a;
        atomicReferenceFieldUpdater.set(gVar, obj);
        this.cont.resume(r6, new G(gVar, this, 2));
    }

    @Override // p007a4.InterfaceC0285k
    public <R extends Q> Object tryResume(R r6, Object obj, O3.q qVar) {
        C0289m c0289m = this.cont;
        g gVar = this.f4064a;
        Object objTryResume = c0289m.tryResume(r6, obj, new C0370c(gVar, this, 2));
        if (objTryResume != null) {
            g.f4068g.set(gVar, this.owner);
        }
        return objTryResume;
    }
}
