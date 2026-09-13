package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3 extends p112t3.c {
    public final D3 b;
    public final p129w3.f c;
    public boolean d;

    public C3(D3 d6, p129w3.f fVar) {
        this.b = d6;
        this.c = fVar;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        D3 d6 = this.b;
        d6.f4903j.delete(this);
        d6.c.offer(new E3(this.c, null));
        if (d6.c()) {
            d6.h();
        }
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.d = true;
        D3 d6 = this.b;
        d6.f4904k.dispose();
        d6.f4903j.dispose();
        d6.onError(th);
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onNext(Object obj) {
        dispose();
        onComplete();
    }
}
