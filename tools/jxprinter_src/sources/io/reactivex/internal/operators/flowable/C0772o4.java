package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.o4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0772o4 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4719a;
    public final t5.c b;
    public final p027e3.q c;
    public t5.d d;
    public boolean e;

    public /* synthetic */ C0772o4(t5.c cVar, p027e3.q qVar, int i5) {
        this.f4719a = i5;
        this.b = cVar;
        this.c = qVar;
    }

    @Override // t5.d
    public final void cancel() {
        switch (this.f4719a) {
            case 0:
                this.d.cancel();
                break;
            case 1:
                this.d.cancel();
                break;
            default:
                this.d.cancel();
                break;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4719a) {
            case 0:
                this.b.onComplete();
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.b.onComplete();
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.b.onComplete();
                    break;
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4719a) {
            case 0:
                this.b.onError(th);
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4719a) {
            case 0:
                boolean z6 = this.e;
                t5.c cVar = this.b;
                if (z6) {
                    cVar.onNext(obj);
                } else {
                    try {
                        if (!this.c.test(obj)) {
                            this.e = true;
                            cVar.onNext(obj);
                        } else {
                            this.d.request(1L);
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.d.cancel();
                        cVar.onError(th);
                        return;
                    }
                }
                break;
            case 1:
                if (!this.e) {
                    t5.c cVar2 = this.b;
                    cVar2.onNext(obj);
                    try {
                        if (this.c.test(obj)) {
                            this.e = true;
                            this.d.cancel();
                            cVar2.onComplete();
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        this.d.cancel();
                        onError(th2);
                        return;
                    }
                }
                break;
            default:
                if (!this.e) {
                    try {
                        boolean zTest = this.c.test(obj);
                        t5.c cVar3 = this.b;
                        if (!zTest) {
                            this.e = true;
                            this.d.cancel();
                            cVar3.onComplete();
                        } else {
                            cVar3.onNext(obj);
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        this.d.cancel();
                        onError(th3);
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4719a) {
            case 0:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                }
                break;
            case 1:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                }
                break;
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        switch (this.f4719a) {
            case 0:
                this.d.request(j6);
                break;
            case 1:
                this.d.request(j6);
                break;
            default:
                this.d.request(j6);
                break;
        }
    }
}
