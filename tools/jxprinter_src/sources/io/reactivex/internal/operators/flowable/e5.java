package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e5 extends p088p3.k implements t5.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TimeUnit f4601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final io.reactivex.N f4602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f4605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final io.reactivex.M f4606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f4607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f4608p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t5.d f4609q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public p123v3.d f4610r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f4611s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final p033f3.h f4612t;

    public e5(p135x3.c cVar, long j6, TimeUnit timeUnit, io.reactivex.N n6, int i5, long j7, boolean z6) {
        super(cVar, new p083o3.b());
        this.f4612t = new p033f3.h();
        this.f4600h = j6;
        this.f4601i = timeUnit;
        this.f4602j = n6;
        this.f4603k = i5;
        this.f4605m = j7;
        this.f4604l = z6;
        if (z6) {
            this.f4606n = n6.createWorker();
        } else {
            this.f4606n = null;
        }
    }

    @Override // t5.d
    public final void cancel() {
        this.e = true;
    }

    public final void dispose() {
        p033f3.d.a(this.f4612t);
        io.reactivex.M m6 = this.f4606n;
        if (m6 != null) {
            m6.dispose();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f7748f = true;
        if (p()) {
            u();
        }
        this.c.onComplete();
        dispose();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7749g = th;
        this.f7748f = true;
        if (p()) {
            u();
        }
        this.c.onError(th);
        dispose();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4611s) {
            return;
        }
        if (q()) {
            p123v3.d dVar = this.f4610r;
            dVar.onNext(obj);
            long j6 = this.f4607o + 1;
            if (j6 >= this.f4605m) {
                this.f4608p++;
                this.f4607o = 0L;
                dVar.onComplete();
                long j7 = this.b.get();
                if (j7 == 0) {
                    this.f4610r = null;
                    this.f4609q.cancel();
                    this.c.onError(new p017c3.e("Could not deliver window due to lack of requests"));
                    dispose();
                    return;
                }
                p123v3.d dVarCreate = p123v3.d.create(this.f4603k);
                this.f4610r = dVarCreate;
                this.c.onNext(dVarCreate);
                if (j7 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    t(1L);
                }
                if (this.f4604l) {
                    ((p011b3.c) this.f4612t.get()).dispose();
                    io.reactivex.M m6 = this.f4606n;
                    d5 d5Var = new d5(this.f4608p, this);
                    long j8 = this.f4600h;
                    p011b3.c cVarSchedulePeriodically = m6.schedulePeriodically(d5Var, j8, j8, this.f4601i);
                    p033f3.h hVar = this.f4612t;
                    hVar.getClass();
                    p033f3.d.c(hVar, cVarSchedulePeriodically);
                }
            } else {
                this.f4607o = j6;
            }
            if (this.f7747a.addAndGet(-1) == 0) {
                return;
            }
        } else {
            this.d.offer(obj);
            if (!p()) {
                return;
            }
        }
        u();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p011b3.c cVarSchedulePeriodicallyDirect;
        if (p094q3.g.g(this.f4609q, dVar)) {
            this.f4609q = dVar;
            p135x3.c cVar = this.c;
            cVar.onSubscribe(this);
            if (this.e) {
                return;
            }
            p123v3.d dVarCreate = p123v3.d.create(this.f4603k);
            this.f4610r = dVarCreate;
            long j6 = this.b.get();
            if (j6 == 0) {
                this.e = true;
                dVar.cancel();
                cVar.onError(new p017c3.e("Could not deliver initial window due to lack of requests."));
                return;
            }
            cVar.onNext(dVarCreate);
            if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                t(1L);
            }
            d5 d5Var = new d5(this.f4608p, this);
            if (this.f4604l) {
                io.reactivex.M m6 = this.f4606n;
                long j7 = this.f4600h;
                cVarSchedulePeriodicallyDirect = m6.schedulePeriodically(d5Var, j7, j7, this.f4601i);
            } else {
                io.reactivex.N n6 = this.f4602j;
                long j8 = this.f4600h;
                cVarSchedulePeriodicallyDirect = n6.schedulePeriodicallyDirect(d5Var, j8, j8, this.f4601i);
            }
            p033f3.h hVar = this.f4612t;
            hVar.getClass();
            if (p033f3.d.c(hVar, cVarSchedulePeriodicallyDirect)) {
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }

    public final void u() {
        p083o3.b bVar = this.d;
        p135x3.c cVar = this.c;
        p123v3.d dVarCreate = this.f4610r;
        int iAddAndGet = 1;
        while (!this.f4611s) {
            boolean z6 = this.f7748f;
            Object objPoll = bVar.poll();
            boolean z7 = objPoll == null;
            boolean z8 = objPoll instanceof d5;
            if (z6 && (z7 || z8)) {
                this.f4610r = null;
                bVar.clear();
                Throwable th = this.f7749g;
                if (th != null) {
                    dVarCreate.onError(th);
                } else {
                    dVarCreate.onComplete();
                }
                dispose();
                return;
            }
            if (z7) {
                iAddAndGet = this.f7747a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                int i5 = iAddAndGet;
                if (z8) {
                    d5 d5Var = (d5) objPoll;
                    if (this.f4604l || this.f4608p == d5Var.f4595a) {
                        dVarCreate.onComplete();
                        this.f4607o = 0L;
                        dVarCreate = p123v3.d.create(this.f4603k);
                        this.f4610r = dVarCreate;
                        long j6 = this.b.get();
                        if (j6 == 0) {
                            this.f4610r = null;
                            this.d.clear();
                            this.f4609q.cancel();
                            cVar.onError(new p017c3.e("Could not deliver first window due to lack of requests."));
                            dispose();
                            return;
                        }
                        cVar.onNext(dVarCreate);
                        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                            t(1L);
                        }
                    }
                } else {
                    dVarCreate.onNext(objPoll);
                    long j7 = this.f4607o + 1;
                    if (j7 >= this.f4605m) {
                        this.f4608p++;
                        this.f4607o = 0L;
                        dVarCreate.onComplete();
                        long j8 = this.b.get();
                        if (j8 == 0) {
                            this.f4610r = null;
                            this.f4609q.cancel();
                            this.c.onError(new p017c3.e("Could not deliver window due to lack of requests"));
                            dispose();
                            return;
                        }
                        dVarCreate = p123v3.d.create(this.f4603k);
                        this.f4610r = dVarCreate;
                        this.c.onNext(dVarCreate);
                        if (j8 != LocationRequestCompat.PASSIVE_INTERVAL) {
                            t(1L);
                        }
                        if (this.f4604l) {
                            ((p011b3.c) this.f4612t.get()).dispose();
                            io.reactivex.M m6 = this.f4606n;
                            d5 d5Var2 = new d5(this.f4608p, this);
                            long j9 = this.f4600h;
                            p011b3.c cVarSchedulePeriodically = m6.schedulePeriodically(d5Var2, j9, j9, this.f4601i);
                            p033f3.h hVar = this.f4612t;
                            hVar.getClass();
                            p033f3.d.c(hVar, cVarSchedulePeriodically);
                        }
                    } else {
                        this.f4607o = j7;
                    }
                }
                iAddAndGet = i5;
            }
        }
        this.f4609q.cancel();
        bVar.clear();
        dispose();
    }
}
