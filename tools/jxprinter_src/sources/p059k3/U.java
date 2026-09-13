package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.O;
import io.reactivex.V;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;
import p048i3.t;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = 4827726964688405508L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5531a;
    public final o b;

    public U(InterfaceC0988v interfaceC0988v, o oVar) {
        this.f5531a = interfaceC0988v;
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

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5531a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5531a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5531a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null SingleSource");
            ((O) ((V) objApply)).subscribe(new t(this, this.f5531a, 2));
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            onError(th);
        }
    }
}
