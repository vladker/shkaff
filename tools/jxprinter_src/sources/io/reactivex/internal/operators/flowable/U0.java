package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U0 extends p088p3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.g f4460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p027e3.g f4461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p027e3.a f4462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p027e3.a f4463i;

    public U0(p043h3.a aVar, p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar2, p027e3.a aVar3) {
        super(aVar);
        this.f4460f = gVar;
        this.f4461g = gVar2;
        this.f4462h = aVar2;
        this.f4463i = aVar3;
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (this.d) {
            return false;
        }
        try {
            this.f4460f.accept(obj);
            return this.f7735a.h(obj);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    @Override // p088p3.a, t5.c
    public final void onComplete() {
        if (this.d) {
            return;
        }
        try {
            this.f4462h.run();
            this.d = true;
            this.f7735a.onComplete();
            try {
                this.f4463i.run();
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
        } catch (Throwable th2) {
            a(th2);
        }
    }

    @Override // p088p3.a, t5.c
    public final void onError(Throwable th) {
        p043h3.a aVar = this.f7735a;
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.d = true;
        try {
            this.f4461g.accept(th);
            aVar.onError(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            aVar.onError(new p017c3.c(th, th2));
        }
        try {
            this.f4463i.run();
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            io.reactivex.plugins.a.onError(th3);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        int i5 = this.e;
        p043h3.a aVar = this.f7735a;
        if (i5 != 0) {
            aVar.onNext(null);
            return;
        }
        try {
            this.f4460f.accept(obj);
            aVar.onNext(obj);
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // p088p3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() throws Exception {
        p027e3.g gVar = this.f4461g;
        try {
            Object objPoll = this.c.poll();
            p027e3.a aVar = this.f4463i;
            if (objPoll == null) {
                if (this.e == 1) {
                    this.f4462h.run();
                    aVar.run();
                }
                return objPoll;
            }
            try {
                this.f4460f.accept(objPoll);
                aVar.run();
                return objPoll;
            } catch (Throwable th) {
                try {
                    p017c3.d.throwIfFatal(th);
                    try {
                        gVar.accept(th);
                        throw p100r3.g.throwIfThrowable(th);
                    } catch (Throwable th2) {
                        throw new p017c3.c(th, th2);
                    }
                } catch (Throwable th3) {
                    aVar.run();
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            p017c3.d.throwIfFatal(th4);
            try {
                gVar.accept(th4);
                throw p100r3.g.throwIfThrowable(th4);
            } catch (Throwable th5) {
                throw new p017c3.c(th4, th5);
            }
        }
    }
}
