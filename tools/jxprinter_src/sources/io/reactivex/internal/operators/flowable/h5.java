package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h5 extends p088p3.k implements t5.d, Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TimeUnit f4658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final io.reactivex.M f4659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f4660l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList f4661m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t5.d f4662n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f4663o;

    public h5(p135x3.c cVar, long j6, long j7, TimeUnit timeUnit, io.reactivex.M m6, int i5) {
        super(cVar, new p083o3.b());
        this.f4656h = j6;
        this.f4657i = j7;
        this.f4658j = timeUnit;
        this.f4659k = m6;
        this.f4660l = i5;
        this.f4661m = new LinkedList();
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
        this.f4659k.dispose();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7749g = th;
        this.f7748f = true;
        if (p()) {
            u();
        }
        this.c.onError(th);
        this.f4659k.dispose();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (q()) {
            Iterator it = this.f4661m.iterator();
            while (it.hasNext()) {
                ((p123v3.d) it.next()).onNext(obj);
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
        if (p094q3.g.g(this.f4662n, dVar)) {
            this.f4662n = dVar;
            this.c.onSubscribe(this);
            if (!this.e) {
                long j6 = this.b.get();
                if (j6 == 0) {
                    dVar.cancel();
                    this.c.onError(new p017c3.e("Could not emit the first window due to lack of requests"));
                    return;
                }
                p123v3.d dVarCreate = p123v3.d.create(this.f4660l);
                this.f4661m.add(dVarCreate);
                this.c.onNext(dVarCreate);
                if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    t(1L);
                }
                this.f4659k.schedule(new Q0.b(this, 14, dVarCreate, false), this.f4656h, this.f4658j);
                io.reactivex.M m6 = this.f4659k;
                long j7 = this.f4657i;
                m6.schedulePeriodically(this, j7, j7, this.f4658j);
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        g5 g5Var = new g5(p123v3.d.create(this.f4660l), true);
        if (!this.e) {
            this.d.offer(g5Var);
        }
        if (p()) {
            u();
        }
    }

    public final void u() {
        p083o3.b bVar = this.d;
        p135x3.c cVar = this.c;
        LinkedList linkedList = this.f4661m;
        int iAddAndGet = 1;
        while (!this.f4663o) {
            boolean z6 = this.f7748f;
            Object objPoll = bVar.poll();
            boolean z7 = objPoll == null;
            boolean z8 = objPoll instanceof g5;
            if (z6 && (z7 || z8)) {
                bVar.clear();
                Throwable th = this.f7749g;
                if (th != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((p123v3.d) it.next()).onError(th);
                    }
                } else {
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        ((p123v3.d) it2.next()).onComplete();
                    }
                }
                linkedList.clear();
                this.f4659k.dispose();
                return;
            }
            if (z7) {
                iAddAndGet = this.f7747a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (z8) {
                g5 g5Var = (g5) objPoll;
                if (!g5Var.b) {
                    linkedList.remove(g5Var.f4634a);
                    g5Var.f4634a.onComplete();
                    if (linkedList.isEmpty() && this.e) {
                        this.f4663o = true;
                    }
                } else if (!this.e) {
                    long j6 = this.b.get();
                    if (j6 != 0) {
                        p123v3.d dVarCreate = p123v3.d.create(this.f4660l);
                        linkedList.add(dVarCreate);
                        cVar.onNext(dVarCreate);
                        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                            t(1L);
                        }
                        this.f4659k.schedule(new Q0.b(this, 14, dVarCreate, false), this.f4656h, this.f4658j);
                    } else {
                        cVar.onError(new p017c3.e("Can't emit window due to lack of requests"));
                    }
                }
            } else {
                Iterator it3 = linkedList.iterator();
                while (it3.hasNext()) {
                    ((p123v3.d) it3.next()).onNext(objPoll);
                }
            }
        }
        this.f4662n.cancel();
        this.f4659k.dispose();
        bVar.clear();
        linkedList.clear();
    }
}
