package p112t3;

import io.reactivex.I;
import p011b3.c;
import p033f3.d;
import p100r3.a;
import p100r3.l;
import p100r3.n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements I, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f8662a;
    public final boolean b;
    public c c;
    public boolean d;
    public a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f8663f;

    public e(I i5) {
        this(i5, false);
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
        if (this.f8663f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f8663f) {
                    return;
                }
                if (!this.d) {
                    this.f8663f = true;
                    this.d = true;
                    this.f8662a.onComplete();
                } else {
                    a aVar = this.e;
                    if (aVar == null) {
                        aVar = new a();
                        this.e = aVar;
                    }
                    aVar.b(n.f7968a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.I
    public void onError(Throwable th) {
        if (this.f8663f) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z6 = true;
                if (!this.f8663f) {
                    if (this.d) {
                        this.f8663f = true;
                        a aVar = this.e;
                        if (aVar == null) {
                            aVar = new a();
                            this.e = aVar;
                        }
                        l lVar = new l(th);
                        if (this.b) {
                            aVar.b(lVar);
                        } else {
                            aVar.f7957a[0] = lVar;
                        }
                        return;
                    }
                    this.f8663f = true;
                    this.d = true;
                    z6 = false;
                }
                if (z6) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.f8662a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.I
    public void onNext(Object obj) {
        Object[] objArr;
        if (this.f8663f) {
            return;
        }
        if (obj == null) {
            this.c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f8663f) {
                    return;
                }
                if (this.d) {
                    a aVar = this.e;
                    if (aVar == null) {
                        aVar = new a();
                        this.e = aVar;
                    }
                    aVar.b(obj);
                    return;
                }
                this.d = true;
                this.f8662a.onNext(obj);
                while (true) {
                    synchronized (this) {
                        try {
                            a aVar2 = this.e;
                            if (aVar2 == null) {
                                this.d = false;
                                return;
                            }
                            this.e = null;
                            I i5 = this.f8662a;
                            for (Object[] objArr2 = aVar2.f7957a; objArr2 != null; objArr2 = objArr2[4]) {
                                for (int i6 = 0; i6 < 4 && (objArr = objArr2[i6]) != null; i6++) {
                                    if (n.a(i5, objArr)) {
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.I
    public void onSubscribe(c cVar) {
        if (d.g(this.c, cVar)) {
            this.c = cVar;
            this.f8662a.onSubscribe(this);
        }
    }

    public e(I i5, boolean z6) {
        this.f8662a = i5;
        this.b = z6;
    }
}
