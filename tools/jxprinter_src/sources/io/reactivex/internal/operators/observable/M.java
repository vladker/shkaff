package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -6951100001833242599L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5020a;
    public final p027e3.o b;
    public final int c;
    public final p100r3.c d = new p100r3.c();
    public final L e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p043h3.j f5022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p011b3.c f5023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f5026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5027l;

    public M(io.reactivex.I i5, p027e3.o oVar, int i6, boolean z6) {
        this.f5020a = i5;
        this.b = oVar;
        this.c = i6;
        this.f5021f = z6;
        this.e = new L(i5, this);
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.I i5 = this.f5020a;
        p043h3.j jVar = this.f5022g;
        p100r3.c cVar = this.d;
        while (true) {
            if (!this.f5024i) {
                if (this.f5026k) {
                    jVar.clear();
                    return;
                }
                if (!this.f5021f && ((Throwable) cVar.get()) != null) {
                    jVar.clear();
                    this.f5026k = true;
                    i5.onError(p100r3.g.b(cVar));
                    return;
                }
                boolean z6 = this.f5025j;
                try {
                    Object objPoll = jVar.poll();
                    boolean z7 = objPoll == null;
                    if (z6 && z7) {
                        this.f5026k = true;
                        cVar.getClass();
                        Throwable thB = p100r3.g.b(cVar);
                        if (thB != null) {
                            i5.onError(thB);
                            return;
                        } else {
                            i5.onComplete();
                            return;
                        }
                    }
                    if (!z7) {
                        try {
                            Object objApply = this.b.apply(objPoll);
                            p039g3.A.b(objApply, "The mapper returned a null ObservableSource");
                            io.reactivex.G g6 = (io.reactivex.G) objApply;
                            if (g6 instanceof Callable) {
                                try {
                                    Object objCall = ((Callable) g6).call();
                                    if (objCall != null && !this.f5026k) {
                                        i5.onNext(objCall);
                                    }
                                } catch (Throwable th) {
                                    p017c3.d.throwIfFatal(th);
                                    cVar.getClass();
                                    p100r3.g.a(cVar, th);
                                }
                            } else {
                                this.f5024i = true;
                                g6.subscribe(this.e);
                            }
                        } catch (Throwable th2) {
                            p017c3.d.throwIfFatal(th2);
                            this.f5026k = true;
                            this.f5023h.dispose();
                            jVar.clear();
                            cVar.getClass();
                            p100r3.g.a(cVar, th2);
                            i5.onError(p100r3.g.b(cVar));
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    this.f5026k = true;
                    this.f5023h.dispose();
                    cVar.getClass();
                    p100r3.g.a(cVar, th3);
                    i5.onError(p100r3.g.b(cVar));
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5026k = true;
        this.f5023h.dispose();
        L l6 = this.e;
        l6.getClass();
        p033f3.d.a(l6);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5026k;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5025j = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f5025j = true;
            a();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5027l == 0) {
            this.f5022g.offer(obj);
        }
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5023h, cVar)) {
            this.f5023h = cVar;
            if (cVar instanceof p043h3.e) {
                p043h3.e eVar = (p043h3.e) cVar;
                int iC = eVar.c(3);
                if (iC == 1) {
                    this.f5027l = iC;
                    this.f5022g = eVar;
                    this.f5025j = true;
                    this.f5020a.onSubscribe(this);
                    a();
                    return;
                }
                if (iC == 2) {
                    this.f5027l = iC;
                    this.f5022g = eVar;
                    this.f5020a.onSubscribe(this);
                    return;
                }
            }
            this.f5022g = new p083o3.d(this.c);
            this.f5020a.onSubscribe(this);
        }
    }
}
