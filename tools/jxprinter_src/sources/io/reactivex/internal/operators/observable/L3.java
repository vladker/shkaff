package io.reactivex.internal.operators.observable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L3 extends p048i3.s implements p011b3.c, Runnable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f5013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TimeUnit f5014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final io.reactivex.M f5015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedList f5017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p011b3.c f5018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f5019n;

    public L3(p112t3.e eVar, long j6, long j7, TimeUnit timeUnit, io.reactivex.M m6, int i5) {
        super(eVar, new p083o3.b());
        this.f5012g = j6;
        this.f5013h = j7;
        this.f5014i = timeUnit;
        this.f5015j = m6;
        this.f5016k = i5;
        this.f5017l = new LinkedList();
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
        p083o3.b bVar = this.c;
        p112t3.e eVar = this.b;
        LinkedList linkedList = this.f5017l;
        int iAddAndGet = 1;
        while (!this.f5019n) {
            boolean z6 = this.e;
            Object objPoll = bVar.poll();
            boolean z7 = objPoll == null;
            boolean z8 = objPoll instanceof K3;
            if (z6 && (z7 || z8)) {
                bVar.clear();
                Throwable th = this.f4061f;
                if (th != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((p129w3.f) it.next()).onError(th);
                    }
                } else {
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        ((p129w3.f) it2.next()).onComplete();
                    }
                }
                this.f5015j.dispose();
                linkedList.clear();
                return;
            }
            if (z7) {
                iAddAndGet = this.f4060a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (z8) {
                K3 k6 = (K3) objPoll;
                if (!k6.b) {
                    linkedList.remove(k6.f5001a);
                    k6.f5001a.onComplete();
                    if (linkedList.isEmpty() && this.d) {
                        this.f5019n = true;
                    }
                } else if (!this.d) {
                    p129w3.f fVarCreate = p129w3.f.create(this.f5016k);
                    linkedList.add(fVarCreate);
                    eVar.onNext(fVarCreate);
                    this.f5015j.schedule(new Q0.b(this, 18, fVarCreate, false), this.f5012g, this.f5014i);
                }
            } else {
                Iterator it3 = linkedList.iterator();
                while (it3.hasNext()) {
                    ((p129w3.f) it3.next()).onNext(objPoll);
                }
            }
        }
        this.f5018m.dispose();
        this.f5015j.dispose();
        bVar.clear();
        linkedList.clear();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.e = true;
        if (c()) {
            h();
        }
        this.b.onComplete();
        this.f5015j.dispose();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onError(Throwable th) {
        this.f4061f = th;
        this.e = true;
        if (c()) {
            h();
        }
        this.b.onError(th);
        this.f5015j.dispose();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onNext(Object obj) {
        if (d()) {
            Iterator it = this.f5017l.iterator();
            while (it.hasNext()) {
                ((p129w3.f) it.next()).onNext(obj);
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
        h();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5018m, cVar)) {
            this.f5018m = cVar;
            this.b.onSubscribe(this);
            if (this.d) {
                return;
            }
            p129w3.f fVarCreate = p129w3.f.create(this.f5016k);
            this.f5017l.add(fVarCreate);
            this.b.onNext(fVarCreate);
            this.f5015j.schedule(new Q0.b(this, 18, fVarCreate, false), this.f5012g, this.f5014i);
            io.reactivex.M m6 = this.f5015j;
            long j6 = this.f5013h;
            m6.schedulePeriodically(this, j6, j6, this.f5014i);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        K3 k6 = new K3(p129w3.f.create(this.f5016k), true);
        if (!this.d) {
            this.c.offer(k6);
        }
        if (c()) {
            h();
        }
    }
}
