package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I3 extends p048i3.s implements p011b3.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TimeUnit f4966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final io.reactivex.N f4967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f4969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f4970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final io.reactivex.M f4971m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4972n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f4973o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p011b3.c f4974p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public p129w3.f f4975q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f4976r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicReference f4977s;

    public I3(p112t3.e eVar, long j6, TimeUnit timeUnit, io.reactivex.N n6, int i5, long j7, boolean z6) {
        super(eVar, new p083o3.b());
        this.f4977s = new AtomicReference();
        this.f4965g = j6;
        this.f4966h = timeUnit;
        this.f4967i = n6;
        this.f4968j = i5;
        this.f4970l = j7;
        this.f4969k = z6;
        if (z6) {
            this.f4971m = n6.createWorker();
        } else {
            this.f4971m = null;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d = true;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    public final void h() {
        p033f3.d.a(this.f4977s);
        io.reactivex.M m6 = this.f4971m;
        if (m6 != null) {
            m6.dispose();
        }
    }

    public final void i() {
        p083o3.b bVar = this.c;
        p112t3.e eVar = this.b;
        p129w3.f fVarCreate = this.f4975q;
        int iAddAndGet = 1;
        while (!this.f4976r) {
            boolean z6 = this.e;
            Object objPoll = bVar.poll();
            boolean z7 = objPoll == null;
            boolean z8 = objPoll instanceof H3;
            if (z6 && (z7 || z8)) {
                this.f4975q = null;
                bVar.clear();
                h();
                Throwable th = this.f4061f;
                if (th != null) {
                    fVarCreate.onError(th);
                    return;
                } else {
                    fVarCreate.onComplete();
                    return;
                }
            }
            if (z7) {
                iAddAndGet = this.f4060a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (z8) {
                H3 h6 = (H3) objPoll;
                if (this.f4969k || this.f4973o == h6.f4958a) {
                    fVarCreate.onComplete();
                    this.f4972n = 0L;
                    fVarCreate = p129w3.f.create(this.f4968j);
                    this.f4975q = fVarCreate;
                    eVar.onNext(fVarCreate);
                }
            } else {
                fVarCreate.onNext(objPoll);
                long j6 = this.f4972n + 1;
                if (j6 >= this.f4970l) {
                    this.f4973o++;
                    this.f4972n = 0L;
                    fVarCreate.onComplete();
                    fVarCreate = p129w3.f.create(this.f4968j);
                    this.f4975q = fVarCreate;
                    this.b.onNext(fVarCreate);
                    if (this.f4969k) {
                        p011b3.c cVar = (p011b3.c) this.f4977s.get();
                        cVar.dispose();
                        io.reactivex.M m6 = this.f4971m;
                        H3 h7 = new H3(this.f4973o, this);
                        long j7 = this.f4965g;
                        p011b3.c cVarSchedulePeriodically = m6.schedulePeriodically(h7, j7, j7, this.f4966h);
                        AtomicReference atomicReference = this.f4977s;
                        while (!atomicReference.compareAndSet(cVar, cVarSchedulePeriodically)) {
                            if (atomicReference.get() != cVar) {
                                cVarSchedulePeriodically.dispose();
                                break;
                            }
                        }
                    }
                } else {
                    this.f4972n = j6;
                }
            }
        }
        this.f4974p.dispose();
        bVar.clear();
        h();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.e = true;
        if (c()) {
            i();
        }
        this.b.onComplete();
        h();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onError(Throwable th) {
        this.f4061f = th;
        this.e = true;
        if (c()) {
            i();
        }
        this.b.onError(th);
        h();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f4976r) {
            return;
        }
        if (d()) {
            p129w3.f fVar = this.f4975q;
            fVar.onNext(obj);
            long j6 = this.f4972n + 1;
            if (j6 >= this.f4970l) {
                this.f4973o++;
                this.f4972n = 0L;
                fVar.onComplete();
                p129w3.f fVarCreate = p129w3.f.create(this.f4968j);
                this.f4975q = fVarCreate;
                this.b.onNext(fVarCreate);
                if (this.f4969k) {
                    ((p011b3.c) this.f4977s.get()).dispose();
                    io.reactivex.M m6 = this.f4971m;
                    H3 h6 = new H3(this.f4973o, this);
                    long j7 = this.f4965g;
                    p033f3.d.c(this.f4977s, m6.schedulePeriodically(h6, j7, j7, this.f4966h));
                }
            } else {
                this.f4972n = j6;
            }
            if (this.f4060a.addAndGet(-1) == 0) {
                return;
            }
        } else {
            this.c.offer(obj);
            if (!c()) {
                return;
            }
        }
        i();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p011b3.c cVarSchedulePeriodicallyDirect;
        if (p033f3.d.g(this.f4974p, cVar)) {
            this.f4974p = cVar;
            p112t3.e eVar = this.b;
            eVar.onSubscribe(this);
            if (this.d) {
                return;
            }
            p129w3.f fVarCreate = p129w3.f.create(this.f4968j);
            this.f4975q = fVarCreate;
            eVar.onNext(fVarCreate);
            H3 h6 = new H3(this.f4973o, this);
            if (this.f4969k) {
                io.reactivex.M m6 = this.f4971m;
                long j6 = this.f4965g;
                cVarSchedulePeriodicallyDirect = m6.schedulePeriodically(h6, j6, j6, this.f4966h);
            } else {
                io.reactivex.N n6 = this.f4967i;
                long j7 = this.f4965g;
                cVarSchedulePeriodicallyDirect = n6.schedulePeriodicallyDirect(h6, j7, j7, this.f4966h);
            }
            p033f3.d.c(this.f4977s, cVarSchedulePeriodicallyDirect);
        }
    }
}
