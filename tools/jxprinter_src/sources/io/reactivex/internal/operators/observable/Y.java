package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5131a;
    public final Object b;
    public long c;
    public p011b3.c d;

    public /* synthetic */ Y(Object obj, int i5) {
        this.f5131a = i5;
        this.b = obj;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5131a) {
            case 0:
                this.d.dispose();
                break;
            case 1:
                this.d.dispose();
                break;
            default:
                this.d.dispose();
                this.d = p033f3.d.f3969a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5131a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5131a) {
            case 0:
                io.reactivex.I i5 = (io.reactivex.I) this.b;
                i5.onNext(Long.valueOf(this.c));
                i5.onComplete();
                break;
            case 1:
                ((io.reactivex.I) this.b).onComplete();
                break;
            default:
                this.d = p033f3.d.f3969a;
                ((io.reactivex.S) this.b).onSuccess(Long.valueOf(this.c));
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5131a) {
            case 0:
                ((io.reactivex.I) this.b).onError(th);
                break;
            case 1:
                ((io.reactivex.I) this.b).onError(th);
                break;
            default:
                this.d = p033f3.d.f3969a;
                ((io.reactivex.S) this.b).onError(th);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5131a) {
            case 0:
                this.c++;
                break;
            case 1:
                long j6 = this.c;
                if (j6 == 0) {
                    ((io.reactivex.I) this.b).onNext(obj);
                } else {
                    this.c = j6 - 1;
                }
                break;
            default:
                this.c++;
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5131a) {
            case 0:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    ((io.reactivex.I) this.b).onSubscribe(this);
                }
                break;
            case 1:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    ((io.reactivex.I) this.b).onSubscribe(this);
                }
                break;
            default:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    ((io.reactivex.S) this.b).onSubscribe(this);
                }
                break;
        }
    }

    public Y(io.reactivex.I i5, long j6) {
        this.f5131a = 1;
        this.b = i5;
        this.c = j6;
    }
}
