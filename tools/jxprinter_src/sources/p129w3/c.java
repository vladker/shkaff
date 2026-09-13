package p129w3;

import io.reactivex.I;
import p027e3.q;
import p100r3.a;
import p100r3.k;
import p100r3.l;
import p100r3.n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends d implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8818a;
    public boolean b;
    public a c;
    public volatile boolean d;

    public c(d dVar) {
        this.f8818a = dVar;
    }

    @Override // io.reactivex.B
    public final void b(I i5) {
        this.f8818a.subscribe(i5);
    }

    public final void e() {
        a aVar;
        Object[] objArr;
        while (true) {
            synchronized (this) {
                try {
                    aVar = this.c;
                    if (aVar == null) {
                        this.b = false;
                        return;
                    }
                    this.c = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (Object[] objArr2 = aVar.f7957a; objArr2 != null; objArr2 = objArr2[4]) {
                for (int i5 = 0; i5 < 4 && (objArr = objArr2[i5]) != null; i5++) {
                    if (n.a(this.f8818a, objArr)) {
                        break;
                    }
                }
            }
        }
    }

    @Override // p129w3.d
    public Throwable getThrowable() {
        return this.f8818a.getThrowable();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.d) {
                    return;
                }
                this.d = true;
                if (!this.b) {
                    this.b = true;
                    this.f8818a.onComplete();
                    return;
                }
                a aVar = this.c;
                if (aVar == null) {
                    aVar = new a();
                    this.c = aVar;
                }
                aVar.b(n.f7968a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z6 = true;
                if (!this.d) {
                    this.d = true;
                    if (this.b) {
                        a aVar = this.c;
                        if (aVar == null) {
                            aVar = new a();
                            this.c = aVar;
                        }
                        aVar.f7957a[0] = new l(th);
                        return;
                    }
                    this.b = true;
                    z6 = false;
                }
                if (z6) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.f8818a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.d) {
                    return;
                }
                if (!this.b) {
                    this.b = true;
                    this.f8818a.onNext(obj);
                    e();
                } else {
                    a aVar = this.c;
                    if (aVar == null) {
                        aVar = new a();
                        this.c = aVar;
                    }
                    aVar.b(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        boolean z6 = true;
        if (!this.d) {
            synchronized (this) {
                try {
                    if (!this.d) {
                        if (this.b) {
                            a aVar = this.c;
                            if (aVar == null) {
                                aVar = new a();
                                this.c = aVar;
                            }
                            aVar.b(new k(cVar));
                            return;
                        }
                        this.b = true;
                        z6 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z6) {
            cVar.dispose();
        } else {
            this.f8818a.onSubscribe(cVar);
            e();
        }
    }

    @Override // p027e3.q
    public final boolean test(Object obj) {
        return n.a(this.f8818a, obj);
    }
}
