package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = 4375739915521278546L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5529a;
    public final o b;
    public final o c;
    public final Callable d;
    public c e;

    public Q(InterfaceC0988v interfaceC0988v, o oVar, o oVar2, Callable callable) {
        this.f5529a = interfaceC0988v;
        this.b = oVar;
        this.c = oVar2;
        this.d = callable;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        try {
            Object objCall = this.d.call();
            A.b(objCall, "The onCompleteSupplier returned a null MaybeSource");
            ((AbstractC0985s) ((y) objCall)).subscribe(new P(this, 0));
        } catch (Exception e) {
            p017c3.d.throwIfFatal(e);
            this.f5529a.onError(e);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        try {
            Object objApply = this.c.apply(th);
            A.b(objApply, "The onErrorMapper returned a null MaybeSource");
            ((AbstractC0985s) ((y) objApply)).subscribe(new P(this, 0));
        } catch (Exception e) {
            p017c3.d.throwIfFatal(e);
            this.f5529a.onError(new p017c3.c(th, e));
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (d.g(this.e, cVar)) {
            this.e = cVar;
            this.f5529a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The onSuccessMapper returned a null MaybeSource");
            ((AbstractC0985s) ((y) objApply)).subscribe(new P(this, 0));
        } catch (Exception e) {
            p017c3.d.throwIfFatal(e);
            this.f5529a.onError(e);
        }
    }
}
