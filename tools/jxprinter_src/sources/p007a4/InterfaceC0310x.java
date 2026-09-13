package p007a4;

import E3.g;
import E3.o;
import E3.q;
import O3.l;
import O3.p;
import W3.InterfaceC0233q;
import java.util.concurrent.CancellationException;
import p044h4.f;

/* JADX INFO: renamed from: a4.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0310x extends H0 {
    @Override // p007a4.H0
    /* synthetic */ r attachChild(InterfaceC0302t interfaceC0302t);

    @Override // p007a4.H0
    /* synthetic */ void cancel();

    @Override // p007a4.H0
    /* synthetic */ void cancel(CancellationException cancellationException);

    @Override // p007a4.H0
    /* synthetic */ boolean cancel(Throwable th);

    boolean completeExceptionally(Throwable th);

    @Override // p007a4.H0, E3.o, E3.q
    /* synthetic */ Object fold(Object obj, p pVar);

    @Override // p007a4.H0, E3.o, E3.q
    /* synthetic */ o get(E3.p pVar);

    @Override // p007a4.H0
    /* synthetic */ CancellationException getCancellationException();

    @Override // p007a4.H0
    /* synthetic */ InterfaceC0233q getChildren();

    @Override // p007a4.H0, E3.o
    /* synthetic */ E3.p getKey();

    @Override // p007a4.H0
    /* synthetic */ f getOnJoin();

    @Override // p007a4.H0
    /* synthetic */ H0 getParent();

    @Override // p007a4.H0
    /* synthetic */ InterfaceC0280h0 invokeOnCompletion(l lVar);

    @Override // p007a4.H0
    /* synthetic */ InterfaceC0280h0 invokeOnCompletion(boolean z6, boolean z7, l lVar);

    @Override // p007a4.H0
    /* synthetic */ Object join(g gVar);

    @Override // p007a4.H0, E3.o, E3.q
    /* synthetic */ q minusKey(E3.p pVar);

    @Override // p007a4.H0, E3.o, E3.q
    /* synthetic */ q plus(q qVar);

    @Override // p007a4.H0
    /* synthetic */ H0 plus(H0 h1);
}
