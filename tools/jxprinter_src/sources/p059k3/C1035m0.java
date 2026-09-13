package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;

/* JADX INFO: renamed from: k3.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1035m0 extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = 2026620218879969836L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5569a;
    public final o b;
    public final boolean c;

    public C1035m0(InterfaceC0988v interfaceC0988v, o oVar, boolean z6) {
        this.f5569a = interfaceC0988v;
        this.b = oVar;
        this.c = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5569a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        boolean z6 = this.c;
        InterfaceC0988v interfaceC0988v = this.f5569a;
        if (!z6 && !(th instanceof Exception)) {
            interfaceC0988v.onError(th);
            return;
        }
        try {
            Object objApply = this.b.apply(th);
            A.b(objApply, "The resumeFunction returned a null MaybeSource");
            y yVar = (y) objApply;
            d.c(this, null);
            ((AbstractC0985s) yVar).subscribe(new C1044v(interfaceC0988v, this, 2));
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            interfaceC0988v.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5569a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.f5569a.onSuccess(obj);
    }
}
