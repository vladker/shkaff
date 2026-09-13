package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S0 extends p094q3.a implements InterfaceC0984q {
    private static final long serialVersionUID = 4109457741734051389L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4423a;
    public final p027e3.a b;
    public t5.d c;
    public p043h3.g d;
    public boolean e;

    public S0(t5.c cVar, p027e3.a aVar) {
        this.f4423a = cVar;
        this.b = aVar;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        p043h3.g gVar = this.d;
        if (gVar == null || (i5 & 4) != 0) {
            return 0;
        }
        int iC = gVar.c(i5);
        if (iC != 0) {
            this.e = iC == 1;
        }
        return iC;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
        e();
    }

    @Override // p043h3.j
    public final void clear() {
        this.d.clear();
    }

    public final void e() {
        if (compareAndSet(0, 1)) {
            try {
                this.b.run();
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
        }
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4423a.onComplete();
        e();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4423a.onError(th);
        e();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4423a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            if (dVar instanceof p043h3.g) {
                this.d = (p043h3.g) dVar;
            }
            this.f4423a.onSubscribe(this);
        }
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.d.poll();
        if (objPoll == null && this.e) {
            e();
        }
        return objPoll;
    }

    @Override // t5.d
    public final void request(long j6) {
        this.c.request(j6);
    }
}
