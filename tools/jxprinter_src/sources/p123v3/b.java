package p123v3;

import p100r3.a;
import p100r3.l;
import p100r3.m;
import p100r3.n;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {
    public final a b;
    public boolean c;
    public a d;
    public volatile boolean e;

    public b(a aVar) {
        this.b = aVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(c cVar) {
        this.b.subscribe(cVar);
    }

    public final void g() {
        a aVar;
        while (true) {
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
            aVar.a(this.b);
        }
    }

    @Override // p123v3.a
    public Throwable getThrowable() {
        return this.b.getThrowable();
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
                this.e = true;
                if (!this.c) {
                    this.c = true;
                    this.b.onComplete();
                    return;
                }
                a aVar = this.d;
                if (aVar == null) {
                    aVar = new a();
                    this.d = aVar;
                }
                aVar.b(n.f7968a);
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
                    this.e = true;
                    if (this.c) {
                        a aVar = this.d;
                        if (aVar == null) {
                            aVar = new a();
                            this.d = aVar;
                        }
                        aVar.f7957a[0] = new l(th);
                        return;
                    }
                    this.c = true;
                    z6 = false;
                }
                if (z6) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.b.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.e) {
                    return;
                }
                if (!this.c) {
                    this.c = true;
                    this.b.onNext(obj);
                    g();
                } else {
                    a aVar = this.d;
                    if (aVar == null) {
                        aVar = new a();
                        this.d = aVar;
                    }
                    aVar.b(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t5.c
    public final void onSubscribe(d dVar) {
        boolean z6 = true;
        if (!this.e) {
            synchronized (this) {
                try {
                    if (!this.e) {
                        if (this.c) {
                            a aVar = this.d;
                            if (aVar == null) {
                                aVar = new a();
                                this.d = aVar;
                            }
                            aVar.b(new m(dVar));
                            return;
                        }
                        this.c = true;
                        z6 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z6) {
            dVar.cancel();
        } else {
            this.b.onSubscribe(dVar);
            g();
        }
    }
}
