package p135x3;

import io.reactivex.InterfaceC0984q;
import p094q3.g;
import p100r3.a;
import p100r3.l;
import p100r3.n;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements InterfaceC0984q, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f8956a;
    public d b;
    public boolean c;
    public a d;
    public volatile boolean e;

    public c(t5.c cVar) {
        this.f8956a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.b.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.e) {
                    return;
                }
                if (!this.c) {
                    this.e = true;
                    this.c = true;
                    this.f8956a.onComplete();
                } else {
                    a aVar = this.d;
                    if (aVar == null) {
                        aVar = new a();
                        this.d = aVar;
                    }
                    aVar.b(n.f7968a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.e) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z6 = true;
                if (!this.e) {
                    if (this.c) {
                        this.e = true;
                        a aVar = this.d;
                        if (aVar == null) {
                            aVar = new a();
                            this.d = aVar;
                        }
                        aVar.f7957a[0] = new l(th);
                        return;
                    }
                    this.e = true;
                    this.c = true;
                    z6 = false;
                }
                if (z6) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.f8956a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        a aVar;
        if (this.e) {
            return;
        }
        if (obj == null) {
            this.b.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            try {
                if (this.e) {
                    return;
                }
                if (this.c) {
                    a aVar2 = this.d;
                    if (aVar2 == null) {
                        aVar2 = new a();
                        this.d = aVar2;
                    }
                    aVar2.b(obj);
                    return;
                }
                this.c = true;
                this.f8956a.onNext(obj);
                do {
                    synchronized (this) {
                        try {
                            aVar = this.d;
                            if (aVar == null) {
                                this.c = false;
                                return;
                            }
                            this.d = null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } while (!aVar.a(this.f8956a));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.b, dVar)) {
            this.b = dVar;
            this.f8956a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.b.request(j6);
    }
}
