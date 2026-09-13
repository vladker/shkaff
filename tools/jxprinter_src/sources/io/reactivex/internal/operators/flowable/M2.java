package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M2 extends K2 {
    private static final long serialVersionUID = -4547113800637756442L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t5.c f4358n;

    public M2(t5.c cVar, io.reactivex.M m6, boolean z6, int i5) {
        super(m6, z6, i5);
        this.f4358n = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.K2
    public final void i() {
        t5.c cVar = this.f4358n;
        p043h3.j jVar = this.f4321g;
        long j6 = this.f4326l;
        int iAddAndGet = 1;
        while (true) {
            long jAddAndGet = this.e.get();
            while (j6 != jAddAndGet) {
                boolean z6 = this.f4323i;
                try {
                    Object objPoll = jVar.poll();
                    boolean z7 = objPoll == null;
                    if (e(cVar, z6, z7)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    cVar.onNext(objPoll);
                    j6++;
                    if (j6 == this.d) {
                        if (jAddAndGet != LocationRequestCompat.PASSIVE_INTERVAL) {
                            jAddAndGet = this.e.addAndGet(-j6);
                        }
                        this.f4320f.request(j6);
                        j6 = 0;
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    this.f4322h = true;
                    this.f4320f.cancel();
                    jVar.clear();
                    cVar.onError(th);
                    this.f4319a.dispose();
                    return;
                }
            }
            if (j6 == jAddAndGet && e(cVar, this.f4323i, jVar.isEmpty())) {
                return;
            }
            int i5 = get();
            if (iAddAndGet == i5) {
                this.f4326l = j6;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                iAddAndGet = i5;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.K2
    public final void j() {
        int iAddAndGet = 1;
        while (!this.f4322h) {
            boolean z6 = this.f4323i;
            this.f4358n.onNext(null);
            if (z6) {
                this.f4322h = true;
                Throwable th = this.f4324j;
                if (th != null) {
                    this.f4358n.onError(th);
                } else {
                    this.f4358n.onComplete();
                }
                this.f4319a.dispose();
                return;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.K2
    public final void k() {
        t5.c cVar = this.f4358n;
        p043h3.j jVar = this.f4321g;
        long j6 = this.f4326l;
        int iAddAndGet = 1;
        while (true) {
            long j7 = this.e.get();
            while (j6 != j7) {
                try {
                    Object objPoll = jVar.poll();
                    if (this.f4322h) {
                        return;
                    }
                    if (objPoll == null) {
                        this.f4322h = true;
                        cVar.onComplete();
                        this.f4319a.dispose();
                        return;
                    }
                    cVar.onNext(objPoll);
                    j6++;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    this.f4322h = true;
                    this.f4320f.cancel();
                    cVar.onError(th);
                    this.f4319a.dispose();
                    return;
                }
            }
            if (this.f4322h) {
                return;
            }
            if (jVar.isEmpty()) {
                this.f4322h = true;
                cVar.onComplete();
                this.f4319a.dispose();
                return;
            } else {
                int i5 = get();
                if (iAddAndGet == i5) {
                    this.f4326l = j6;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i5;
                }
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4320f, dVar)) {
            this.f4320f = dVar;
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(7);
                if (iC == 1) {
                    this.f4325k = 1;
                    this.f4321g = gVar;
                    this.f4323i = true;
                    this.f4358n.onSubscribe(this);
                    return;
                }
                if (iC == 2) {
                    this.f4325k = 2;
                    this.f4321g = gVar;
                    this.f4358n.onSubscribe(this);
                    dVar.request(this.c);
                    return;
                }
            }
            this.f4321g = new p083o3.c(this.c);
            this.f4358n.onSubscribe(this);
            dVar.request(this.c);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.K2, p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.f4321g.poll();
        if (objPoll != null && this.f4325k != 1) {
            long j6 = this.f4326l + 1;
            if (j6 == this.d) {
                this.f4326l = 0L;
                this.f4320f.request(j6);
                return objPoll;
            }
            this.f4326l = j6;
        }
        return objPoll;
    }
}
