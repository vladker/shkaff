package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f5 extends p088p3.k implements t5.d, Runnable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f4618p = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TimeUnit f4620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final io.reactivex.N f4621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public t5.d f4623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p123v3.d f4624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p033f3.h f4625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f4626o;

    public f5(p135x3.c cVar, long j6, TimeUnit timeUnit, io.reactivex.N n6, int i5) {
        super(cVar, new p083o3.b());
        this.f4625n = new p033f3.h();
        this.f4619h = j6;
        this.f4620i = timeUnit;
        this.f4621j = n6;
        this.f4622k = i5;
    }

    @Override // t5.d
    public final void cancel() {
        this.e = true;
    }

    @Override // t5.c
    public final void onComplete() {
        this.f7748f = true;
        if (p()) {
            u();
        }
        this.c.onComplete();
        p033f3.d.a(this.f4625n);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7749g = th;
        this.f7748f = true;
        if (p()) {
            u();
        }
        this.c.onError(th);
        p033f3.d.a(this.f4625n);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4626o) {
            return;
        }
        if (q()) {
            this.f4624m.onNext(obj);
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
        if (p094q3.g.g(this.f4623l, dVar)) {
            this.f4623l = dVar;
            this.f4624m = p123v3.d.create(this.f4622k);
            p135x3.c cVar = this.c;
            cVar.onSubscribe(this);
            long j6 = this.b.get();
            if (j6 == 0) {
                this.e = true;
                dVar.cancel();
                cVar.onError(new p017c3.e("Could not deliver first window due to lack of requests."));
                return;
            }
            cVar.onNext(this.f4624m);
            if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                t(1L);
            }
            if (!this.e) {
                p033f3.h hVar = this.f4625n;
                io.reactivex.N n6 = this.f4621j;
                long j7 = this.f4619h;
                p011b3.c cVarSchedulePeriodicallyDirect = n6.schedulePeriodicallyDirect(this, j7, j7, this.f4620i);
                hVar.getClass();
                if (p033f3.d.c(hVar, cVarSchedulePeriodicallyDirect)) {
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.e) {
            this.f4626o = true;
            p033f3.d.a(this.f4625n);
        }
        this.d.offer(f4618p);
        if (p()) {
            u();
        }
    }

    public final void u() {
        Object obj = f4618p;
        p083o3.b bVar = this.d;
        p135x3.c cVar = this.c;
        p123v3.d dVarCreate = this.f4624m;
        int iAddAndGet = 1;
        while (true) {
            boolean z6 = this.f4626o;
            boolean z7 = this.f7748f;
            Object objPoll = bVar.poll();
            if (z7 && (objPoll == null || objPoll == obj)) {
                break;
            }
            if (objPoll == null) {
                iAddAndGet = this.f7747a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (objPoll == obj) {
                dVarCreate.onComplete();
                if (z6) {
                    this.f4623l.cancel();
                } else {
                    dVarCreate = p123v3.d.create(this.f4622k);
                    this.f4624m = dVarCreate;
                    long j6 = this.b.get();
                    if (j6 == 0) {
                        this.f4624m = null;
                        this.d.clear();
                        this.f4623l.cancel();
                        p033f3.d.a(this.f4625n);
                        cVar.onError(new p017c3.e("Could not deliver first window due to lack of requests."));
                        return;
                    }
                    cVar.onNext(dVarCreate);
                    if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                        t(1L);
                    }
                }
            } else {
                dVarCreate.onNext(objPoll);
            }
        }
        this.f4624m = null;
        bVar.clear();
        p033f3.d.a(this.f4625n);
        Throwable th = this.f7749g;
        if (th != null) {
            dVarCreate.onError(th);
        } else {
            dVarCreate.onComplete();
        }
    }
}
