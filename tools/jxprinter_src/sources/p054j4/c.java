package p054j4;

import E3.g;
import E3.o;
import E3.q;
import O3.l;
import O3.p;
import W3.InterfaceC0233q;
import java.util.concurrent.CancellationException;
import p007a4.H0;
import p007a4.InterfaceC0280h0;
import p007a4.InterfaceC0302t;
import p007a4.InterfaceC0304u;
import p007a4.V;
import p007a4.r;
import p044h4.f;
import p044h4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0304u f5461a;

    public c(InterfaceC0304u interfaceC0304u) {
        this.f5461a = interfaceC0304u;
    }

    @Override // p007a4.V, p007a4.H0
    public r attachChild(InterfaceC0302t interfaceC0302t) {
        return this.f5461a.attachChild(interfaceC0302t);
    }

    @Override // p007a4.V
    public final Object await(g gVar) {
        return this.f5461a.await(gVar);
    }

    @Override // p007a4.H0
    public final boolean b() {
        return this.f5461a.b();
    }

    @Override // p007a4.V, p007a4.H0
    public /* synthetic */ void cancel() {
        this.f5461a.cancel();
    }

    @Override // p007a4.V, p007a4.H0, E3.o, E3.q
    public final Object fold(Object obj, p pVar) {
        return this.f5461a.fold(obj, pVar);
    }

    @Override // p007a4.V, p007a4.H0, E3.o, E3.q
    public final o get(E3.p pVar) {
        return this.f5461a.get(pVar);
    }

    @Override // p007a4.V, p007a4.H0
    public CancellationException getCancellationException() {
        return this.f5461a.getCancellationException();
    }

    @Override // p007a4.V, p007a4.H0
    public final InterfaceC0233q getChildren() {
        return this.f5461a.getChildren();
    }

    @Override // p007a4.V
    public Object getCompleted() {
        return this.f5461a.getCompleted();
    }

    @Override // p007a4.V
    public Throwable getCompletionExceptionOrNull() {
        return this.f5461a.getCompletionExceptionOrNull();
    }

    @Override // p007a4.V, p007a4.H0, E3.o
    public final E3.p getKey() {
        return this.f5461a.getKey();
    }

    @Override // p007a4.V
    public final h getOnAwait() {
        return this.f5461a.getOnAwait();
    }

    @Override // p007a4.V, p007a4.H0
    public final f getOnJoin() {
        return this.f5461a.getOnJoin();
    }

    @Override // p007a4.V, p007a4.H0
    public final H0 getParent() {
        return this.f5461a.getParent();
    }

    @Override // p007a4.V, p007a4.H0
    public final InterfaceC0280h0 invokeOnCompletion(l lVar) {
        return this.f5461a.invokeOnCompletion(lVar);
    }

    @Override // p007a4.H0
    public final boolean isActive() {
        return this.f5461a.isActive();
    }

    @Override // p007a4.V, p007a4.H0
    public final Object join(g gVar) {
        return this.f5461a.join(gVar);
    }

    @Override // p007a4.V, p007a4.H0, E3.o, E3.q
    public final q minusKey(E3.p pVar) {
        return this.f5461a.minusKey(pVar);
    }

    @Override // p007a4.V, p007a4.H0, E3.o, E3.q
    public final q plus(q qVar) {
        return this.f5461a.plus(qVar);
    }

    @Override // p007a4.H0
    public final boolean start() {
        return this.f5461a.start();
    }

    @Override // p007a4.V, p007a4.H0
    public final void cancel(CancellationException cancellationException) {
        this.f5461a.cancel(cancellationException);
    }

    @Override // p007a4.V, p007a4.H0
    public InterfaceC0280h0 invokeOnCompletion(boolean z6, boolean z7, l lVar) {
        return this.f5461a.invokeOnCompletion(z6, z7, lVar);
    }

    @Override // p007a4.V, p007a4.H0
    public H0 plus(H0 h1) {
        return this.f5461a.plus(h1);
    }

    @Override // p007a4.V, p007a4.H0
    public /* synthetic */ boolean cancel(Throwable th) {
        return this.f5461a.cancel(th);
    }
}
