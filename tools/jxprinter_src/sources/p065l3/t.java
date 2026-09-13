package p065l3;

import io.reactivex.G;
import io.reactivex.I;
import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends AtomicReference implements I, InterfaceC0988v, c {
    private static final long serialVersionUID = -8948264376121066672L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f5878a;
    public final o b;

    public t(I i5, o oVar) {
        this.f5878a = i5;
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

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5878a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5878a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5878a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        d.c(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null Publisher");
            ((G) objApply).subscribe(this);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5878a.onError(th);
        }
    }
}
