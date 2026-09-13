package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0852c3 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5162a;
    public boolean b;
    public p011b3.c c;
    public long d;

    public C0852c3(io.reactivex.I i5, long j6) {
        this.f5162a = i5;
        this.d = j6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.c.dispose();
        this.f5162a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.b) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.b = true;
        this.c.dispose();
        this.f5162a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.b) {
            return;
        }
        long j6 = this.d;
        long j7 = j6 - 1;
        this.d = j7;
        if (j6 > 0) {
            boolean z6 = j7 == 0;
            this.f5162a.onNext(obj);
            if (z6) {
                onComplete();
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            long j6 = this.d;
            io.reactivex.I i5 = this.f5162a;
            if (j6 != 0) {
                i5.onSubscribe(this);
                return;
            }
            this.b = true;
            cVar.dispose();
            i5.onSubscribe(p033f3.e.f3970a);
            i5.onComplete();
        }
    }
}
