package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K0 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4317a = 0;
    public t5.c b;
    public t5.d c;

    public /* synthetic */ K0() {
    }

    @Override // t5.d
    public final void cancel() {
        switch (this.f4317a) {
            case 0:
                t5.d dVar = this.c;
                p100r3.e eVar = p100r3.e.f7960a;
                this.c = eVar;
                this.b = eVar;
                dVar.cancel();
                break;
            default:
                this.c.cancel();
                break;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4317a) {
            case 0:
                t5.c cVar = this.b;
                p100r3.e eVar = p100r3.e.f7960a;
                this.c = eVar;
                this.b = eVar;
                cVar.onComplete();
                break;
            default:
                this.b.onComplete();
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4317a) {
            case 0:
                t5.c cVar = this.b;
                p100r3.e eVar = p100r3.e.f7960a;
                this.c = eVar;
                this.b = eVar;
                cVar.onError(th);
                break;
            default:
                this.b.onError(th);
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4317a) {
            case 0:
                this.b.onNext(obj);
                break;
            default:
                this.b.onNext(obj);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4317a) {
            case 0:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    this.b.onSubscribe(this);
                }
                break;
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        switch (this.f4317a) {
            case 0:
                this.c.request(j6);
                break;
            default:
                this.c.request(j6);
                break;
        }
    }

    public K0(t5.c cVar) {
        this.b = cVar;
    }
}
