package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q4 extends AtomicBoolean implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 5904473792286235046L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4418a;
    public final Object b;
    public final p027e3.g c;
    public final boolean d;
    public t5.d e;

    public Q4(t5.c cVar, Object obj, p027e3.g gVar, boolean z6) {
        this.f4418a = cVar;
        this.b = obj;
        this.c = gVar;
        this.d = z6;
    }

    public final void a() {
        if (compareAndSet(false, true)) {
            try {
                this.c.accept(this.b);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        a();
        this.e.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        boolean z6 = this.d;
        t5.c cVar = this.f4418a;
        if (!z6) {
            cVar.onComplete();
            this.e.cancel();
            a();
            return;
        }
        if (compareAndSet(false, true)) {
            try {
                this.c.accept(this.b);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cVar.onError(th);
                return;
            }
        }
        this.e.cancel();
        cVar.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        boolean z6 = this.d;
        t5.c cVar = this.f4418a;
        if (!z6) {
            cVar.onError(th);
            this.e.cancel();
            a();
            return;
        }
        if (compareAndSet(false, true)) {
            try {
                this.c.accept(this.b);
            } catch (Throwable th2) {
                th = th2;
                p017c3.d.throwIfFatal(th);
            }
        }
        th = null;
        this.e.cancel();
        if (th != null) {
            cVar.onError(new p017c3.c(th, th));
        } else {
            cVar.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4418a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.e, dVar)) {
            this.e = dVar;
            this.f4418a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.e.request(j6);
    }
}
