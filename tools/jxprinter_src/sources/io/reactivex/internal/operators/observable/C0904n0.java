package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0904n0 implements io.reactivex.I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5239a;
    public final io.reactivex.I b;
    public final p033f3.h c;
    public boolean d;
    public final io.reactivex.G e;

    public C0904n0(io.reactivex.I i5, io.reactivex.G g6) {
        this.f5239a = 1;
        this.b = i5;
        this.e = g6;
        this.d = true;
        this.c = new p033f3.h();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5239a) {
            case 0:
                if (!this.d) {
                    this.d = true;
                    ((io.reactivex.B) ((C0898m) this.e).b).subscribe(new C0899m0(this, 0));
                    break;
                }
                break;
            default:
                if (!this.d) {
                    this.b.onComplete();
                } else {
                    this.d = false;
                    this.e.subscribe(this);
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5239a) {
            case 0:
                if (!this.d) {
                    this.d = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                this.b.onError(th);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5239a) {
            case 0:
                onComplete();
                break;
            default:
                if (this.d) {
                    this.d = false;
                }
                this.b.onNext(obj);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5239a) {
            case 0:
                p033f3.h hVar = this.c;
                hVar.getClass();
                p033f3.d.d(hVar, cVar);
                break;
            default:
                p033f3.h hVar2 = this.c;
                hVar2.getClass();
                p033f3.d.d(hVar2, cVar);
                break;
        }
    }

    public C0904n0(C0898m c0898m, p033f3.h hVar, io.reactivex.I i5) {
        this.f5239a = 0;
        this.e = c0898m;
        this.c = hVar;
        this.b = i5;
    }
}
