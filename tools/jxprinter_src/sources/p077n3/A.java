package p077n3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p059k3.C1044v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends AtomicReference implements S, c {
    private static final long serialVersionUID = -5843758257109742742L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f6260a;
    public final o b;

    public A(InterfaceC0988v interfaceC0988v, o oVar) {
        this.f6260a = interfaceC0988v;
        this.b = oVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6260a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f6260a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null MaybeSource");
            y yVar = (y) objApply;
            if (e()) {
                return;
            }
            ((AbstractC0985s) yVar).subscribe(new C1044v(4, this.f6260a, this));
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            onError(th);
        }
    }
}
