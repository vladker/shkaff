package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 8828587559905699186L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f5048a;
    public final p027e3.o b;
    public final N c;
    public final int d;
    public p043h3.j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p011b3.c f5049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5052i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5053j;

    public O(p112t3.e eVar, p027e3.o oVar, int i5) {
        this.f5048a = eVar;
        this.b = oVar;
        this.d = i5;
        this.c = new N(eVar, this);
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        while (!this.f5051h) {
            if (!this.f5050g) {
                boolean z6 = this.f5052i;
                try {
                    Object objPoll = this.e.poll();
                    boolean z7 = objPoll == null;
                    if (z6 && z7) {
                        this.f5051h = true;
                        this.f5048a.onComplete();
                        return;
                    }
                    if (!z7) {
                        try {
                            Object objApply = this.b.apply(objPoll);
                            p039g3.A.b(objApply, "The mapper returned a null ObservableSource");
                            io.reactivex.G g6 = (io.reactivex.G) objApply;
                            this.f5050g = true;
                            g6.subscribe(this.c);
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            dispose();
                            this.e.clear();
                            this.f5048a.onError(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    dispose();
                    this.e.clear();
                    this.f5048a.onError(th2);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.e.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5051h = true;
        N n6 = this.c;
        n6.getClass();
        p033f3.d.a(n6);
        this.f5049f.dispose();
        if (getAndIncrement() == 0) {
            this.e.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5051h;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5052i) {
            return;
        }
        this.f5052i = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f5052i) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f5052i = true;
        dispose();
        this.f5048a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5052i) {
            return;
        }
        if (this.f5053j == 0) {
            this.e.offer(obj);
        }
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5049f, cVar)) {
            this.f5049f = cVar;
            if (cVar instanceof p043h3.e) {
                p043h3.e eVar = (p043h3.e) cVar;
                int iC = eVar.c(3);
                if (iC == 1) {
                    this.f5053j = iC;
                    this.e = eVar;
                    this.f5052i = true;
                    this.f5048a.onSubscribe(this);
                    a();
                    return;
                }
                if (iC == 2) {
                    this.f5053j = iC;
                    this.e = eVar;
                    this.f5048a.onSubscribe(this);
                    return;
                }
            }
            this.e = new p083o3.d(this.d);
            this.f5048a.onSubscribe(this);
        }
    }
}
