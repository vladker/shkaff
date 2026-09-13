package io.reactivex.internal.operators.observable;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 8080567949447303262L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5063a;
    public final p027e3.o b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p100r3.c f5064f = new p100r3.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque f5065g = new ArrayDeque();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p043h3.j f5066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p011b3.c f5067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5068j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5069k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f5070l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p048i3.q f5071m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5072n;

    public P(io.reactivex.I i5, p027e3.o oVar, int i6, int i7, int i8) {
        this.f5063a = i5;
        this.b = oVar;
        this.c = i6;
        this.d = i7;
        this.e = i8;
    }

    public final void a() {
        p048i3.q qVar = this.f5071m;
        if (qVar != null) {
            p033f3.d.a(qVar);
        }
        while (true) {
            p048i3.q qVar2 = (p048i3.q) this.f5065g.poll();
            if (qVar2 == null) {
                return;
            } else {
                p033f3.d.a(qVar2);
            }
        }
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        p043h3.j jVar = this.f5066h;
        ArrayDeque arrayDeque = this.f5065g;
        io.reactivex.I i5 = this.f5063a;
        int i6 = this.e;
        int iAddAndGet = 1;
        while (true) {
            int i7 = this.f5072n;
            while (i7 != this.c) {
                if (this.f5070l) {
                    jVar.clear();
                    a();
                    return;
                }
                if (i6 == 1 && ((Throwable) this.f5064f.get()) != null) {
                    jVar.clear();
                    a();
                    p100r3.c cVar = this.f5064f;
                    cVar.getClass();
                    i5.onError(p100r3.g.b(cVar));
                    return;
                }
                try {
                    Object objPoll = jVar.poll();
                    if (objPoll == null) {
                        break;
                    }
                    Object objApply = this.b.apply(objPoll);
                    p039g3.A.b(objApply, "The mapper returned a null ObservableSource");
                    io.reactivex.G g6 = (io.reactivex.G) objApply;
                    p048i3.q qVar = new p048i3.q(this, this.d);
                    arrayDeque.offer(qVar);
                    g6.subscribe(qVar);
                    i7++;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    this.f5067i.dispose();
                    jVar.clear();
                    a();
                    p100r3.c cVar2 = this.f5064f;
                    cVar2.getClass();
                    p100r3.g.a(cVar2, th);
                    p100r3.c cVar3 = this.f5064f;
                    cVar3.getClass();
                    i5.onError(p100r3.g.b(cVar3));
                    return;
                }
            }
            this.f5072n = i7;
            if (this.f5070l) {
                jVar.clear();
                a();
                return;
            }
            if (i6 == 1 && ((Throwable) this.f5064f.get()) != null) {
                jVar.clear();
                a();
                p100r3.c cVar4 = this.f5064f;
                cVar4.getClass();
                i5.onError(p100r3.g.b(cVar4));
                return;
            }
            p048i3.q qVar2 = this.f5071m;
            if (qVar2 == null) {
                if (i6 == 2 && ((Throwable) this.f5064f.get()) != null) {
                    jVar.clear();
                    a();
                    p100r3.c cVar5 = this.f5064f;
                    cVar5.getClass();
                    i5.onError(p100r3.g.b(cVar5));
                    return;
                }
                boolean z6 = this.f5068j;
                p048i3.q qVar3 = (p048i3.q) arrayDeque.poll();
                boolean z7 = qVar3 == null;
                if (z6 && z7) {
                    if (((Throwable) this.f5064f.get()) == null) {
                        i5.onComplete();
                        return;
                    }
                    jVar.clear();
                    a();
                    p100r3.c cVar6 = this.f5064f;
                    cVar6.getClass();
                    i5.onError(p100r3.g.b(cVar6));
                    return;
                }
                if (!z7) {
                    this.f5071m = qVar3;
                }
                qVar2 = qVar3;
            }
            if (qVar2 != null) {
                p043h3.j jVar2 = qVar2.c;
                while (true) {
                    if (this.f5070l) {
                        jVar.clear();
                        a();
                        return;
                    }
                    boolean z8 = qVar2.d;
                    if (i6 == 1 && ((Throwable) this.f5064f.get()) != null) {
                        jVar.clear();
                        a();
                        p100r3.c cVar7 = this.f5064f;
                        cVar7.getClass();
                        i5.onError(p100r3.g.b(cVar7));
                        return;
                    }
                    try {
                        Object objPoll2 = jVar2.poll();
                        boolean z9 = objPoll2 == null;
                        if (z8 && z9) {
                            this.f5071m = null;
                            this.f5072n--;
                        } else if (!z9) {
                            i5.onNext(objPoll2);
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        p100r3.c cVar8 = this.f5064f;
                        cVar8.getClass();
                        p100r3.g.a(cVar8, th2);
                        this.f5071m = null;
                        this.f5072n--;
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5070l) {
            return;
        }
        this.f5070l = true;
        this.f5067i.dispose();
        if (getAndIncrement() == 0) {
            do {
                this.f5066h.clear();
                a();
            } while (decrementAndGet() != 0);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5070l;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5068j = true;
        b();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.f5064f;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f5068j = true;
            b();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5069k == 0) {
            this.f5066h.offer(obj);
        }
        b();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5067i, cVar)) {
            this.f5067i = cVar;
            if (cVar instanceof p043h3.e) {
                p043h3.e eVar = (p043h3.e) cVar;
                int iC = eVar.c(3);
                if (iC == 1) {
                    this.f5069k = iC;
                    this.f5066h = eVar;
                    this.f5068j = true;
                    this.f5063a.onSubscribe(this);
                    b();
                    return;
                }
                if (iC == 2) {
                    this.f5069k = iC;
                    this.f5066h = eVar;
                    this.f5063a.onSubscribe(this);
                    return;
                }
            }
            this.f5066h = new p083o3.d(this.d);
            this.f5063a.onSubscribe(this);
        }
    }
}
