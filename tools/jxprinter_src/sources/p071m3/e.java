package p071m3;

import p027e3.q;
import p043h3.a;
import p094q3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements a, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f6131a;
    public d b;
    public boolean c;
    public final /* synthetic */ int d;
    public final c e;

    public e(c cVar, q qVar, int i5) {
        this.d = i5;
        this.f6131a = qVar;
        this.e = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.b.cancel();
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        switch (this.d) {
            case 0:
                if (this.c) {
                    return false;
                }
                try {
                    if (this.f6131a.test(obj)) {
                        return ((a) this.e).h(obj);
                    }
                    return false;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return false;
                }
            default:
                if (this.c) {
                    return false;
                }
                try {
                    if (!this.f6131a.test(obj)) {
                        return false;
                    }
                    this.e.onNext(obj);
                    return true;
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                    return false;
                }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.d) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    ((a) this.e).onComplete();
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    this.e.onComplete();
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.d) {
            case 0:
                if (!this.c) {
                    this.c = true;
                    ((a) this.e).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.c) {
                    this.c = true;
                    this.e.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (h(obj) || this.c) {
            return;
        }
        this.b.request(1L);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        switch (this.d) {
            case 0:
                if (g.g(this.b, dVar)) {
                    this.b = dVar;
                    ((a) this.e).onSubscribe(this);
                }
                break;
            default:
                if (g.g(this.b, dVar)) {
                    this.b = dVar;
                    this.e.onSubscribe(this);
                }
                break;
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.b.request(j6);
    }
}
