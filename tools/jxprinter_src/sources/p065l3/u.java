package p065l3;

import io.reactivex.InterfaceC0984q;
import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p027e3.o;
import p039g3.A;
import p094q3.g;
import t5.b;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends AtomicReference implements InterfaceC0984q, InterfaceC0988v, d {
    private static final long serialVersionUID = -8948264376121066672L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5879a;
    public final o b;
    public p011b3.c c;
    public final AtomicLong d = new AtomicLong();

    public u(c cVar, o oVar) {
        this.f5879a = cVar;
        this.b = oVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.dispose();
        g.a(this);
    }

    @Override // t5.c
    public final void onComplete() {
        this.f5879a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f5879a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f5879a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5879a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null Publisher");
            ((b) objApply).subscribe(this);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5879a.onError(th);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        g.b(this, this.d, j6);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        g.c(this, this.d, dVar);
    }
}
