package p007a4;

import E3.g;
import E3.o;
import E3.q;
import O3.l;
import O3.p;
import W3.InterfaceC0233q;
import java.util.concurrent.CancellationException;
import p044h4.f;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface H0 extends o {
    public static final G0 Key = G0.f940a;

    r attachChild(InterfaceC0302t interfaceC0302t);

    boolean b();

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    @Override // E3.o, E3.q
    /* synthetic */ Object fold(Object obj, p pVar);

    @Override // E3.o, E3.q
    /* synthetic */ o get(E3.p pVar);

    CancellationException getCancellationException();

    InterfaceC0233q getChildren();

    @Override // E3.o
    /* synthetic */ E3.p getKey();

    f getOnJoin();

    H0 getParent();

    InterfaceC0280h0 invokeOnCompletion(l lVar);

    InterfaceC0280h0 invokeOnCompletion(boolean z6, boolean z7, l lVar);

    boolean isActive();

    Object join(g<? super Q> gVar);

    @Override // E3.o, E3.q
    /* synthetic */ q minusKey(E3.p pVar);

    @Override // E3.o, E3.q
    /* synthetic */ q plus(q qVar);

    H0 plus(H0 h1);

    boolean start();
}
