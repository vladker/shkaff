package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y4 extends p135x3.a {
    public final Z4 b;
    public final p123v3.d c;
    public boolean d;

    public Y4(Z4 z6, p123v3.d dVar) {
        this.b = z6;
        this.c = dVar;
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        Z4 z6 = this.b;
        z6.f4535k.delete(this);
        z6.d.offer(new a5(this.c, null));
        if (z6.p()) {
            z6.u();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.d = true;
        Z4 z6 = this.b;
        z6.f4536l.cancel();
        z6.f4535k.dispose();
        p033f3.d.a(z6.f4537m);
        z6.c.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        dispose();
        onComplete();
    }
}
