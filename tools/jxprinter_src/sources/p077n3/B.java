package p077n3;

import io.reactivex.InterfaceC0984q;
import io.reactivex.S;
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
public final class B extends AtomicLong implements S, InterfaceC0984q, d {
    private static final long serialVersionUID = 7759721921468635667L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f6261a;
    public final o b;
    public final AtomicReference c = new AtomicReference();
    public p011b3.c d;

    public B(c cVar, o oVar) {
        this.f6261a = cVar;
        this.b = oVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.d.dispose();
        g.a(this.c);
    }

    @Override // t5.c
    public final void onComplete() {
        this.f6261a.onComplete();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6261a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f6261a.onNext(obj);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        this.d = cVar;
        this.f6261a.onSubscribe(this);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "the mapper returned a null Publisher");
            ((b) objApply).subscribe(this);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f6261a.onError(th);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        g.b(this.c, this, j6);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        g.c(this.c, this, dVar);
    }
}
