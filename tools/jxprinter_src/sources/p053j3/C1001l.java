package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p017c3.d;
import p033f3.h;
import p039g3.A;

/* JADX INFO: renamed from: j3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1001l extends AtomicInteger implements InterfaceC0679f {
    private static final long serialVersionUID = -7965400327305809232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5444a;
    public final Iterator b;
    public final h c = new h();

    public C1001l(InterfaceC0679f interfaceC0679f, Iterator it) {
        this.f5444a = interfaceC0679f;
        this.b = it;
    }

    public final void a() {
        InterfaceC0679f interfaceC0679f = this.f5444a;
        h hVar = this.c;
        if (!hVar.e() && getAndIncrement() == 0) {
            Iterator it = this.b;
            while (!hVar.e()) {
                try {
                    if (!it.hasNext()) {
                        interfaceC0679f.onComplete();
                        return;
                    }
                    try {
                        Object next = it.next();
                        A.b(next, "The CompletableSource returned is null");
                        ((AbstractC0676c) ((InterfaceC0682i) next)).subscribe(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th) {
                        d.throwIfFatal(th);
                        interfaceC0679f.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    interfaceC0679f.onError(th2);
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        a();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5444a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        h hVar = this.c;
        hVar.getClass();
        p033f3.d.c(hVar, cVar);
    }
}
