package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P1 extends p048i3.b implements io.reactivex.I, Runnable {
    private static final long serialVersionUID = 6576896619930983584L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5074a;
    public final io.reactivex.M b;
    public final boolean c;
    public final int d;
    public p043h3.j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p011b3.c f5075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f5076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5080k;

    public P1(io.reactivex.I i5, io.reactivex.M m6, boolean z6, int i6) {
        this.f5074a = i5;
        this.b = m6;
        this.c = z6;
        this.d = i6;
    }

    public final boolean a(boolean z6, boolean z7, io.reactivex.I i5) {
        if (this.f5078i) {
            this.e.clear();
            return true;
        }
        if (!z6) {
            return false;
        }
        Throwable th = this.f5076g;
        if (this.c) {
            if (!z7) {
                return false;
            }
            this.f5078i = true;
            if (th != null) {
                i5.onError(th);
            } else {
                i5.onComplete();
            }
            this.b.dispose();
            return true;
        }
        if (th != null) {
            this.f5078i = true;
            this.e.clear();
            i5.onError(th);
            this.b.dispose();
            return true;
        }
        if (!z7) {
            return false;
        }
        this.f5078i = true;
        i5.onComplete();
        this.b.dispose();
        return true;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f5080k = true;
        return 2;
    }

    @Override // p043h3.j
    public final void clear() {
        this.e.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5078i) {
            return;
        }
        this.f5078i = true;
        this.f5075f.dispose();
        this.b.dispose();
        if (getAndIncrement() == 0) {
            this.e.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5078i;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.e.isEmpty();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5077h) {
            return;
        }
        this.f5077h = true;
        if (getAndIncrement() == 0) {
            this.b.schedule(this);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f5077h) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f5076g = th;
        this.f5077h = true;
        if (getAndIncrement() == 0) {
            this.b.schedule(this);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5077h) {
            return;
        }
        if (this.f5079j != 2) {
            this.e.offer(obj);
        }
        if (getAndIncrement() == 0) {
            this.b.schedule(this);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5075f, cVar)) {
            this.f5075f = cVar;
            if (cVar instanceof p043h3.e) {
                p043h3.e eVar = (p043h3.e) cVar;
                int iC = eVar.c(7);
                if (iC == 1) {
                    this.f5079j = iC;
                    this.e = eVar;
                    this.f5077h = true;
                    this.f5074a.onSubscribe(this);
                    if (getAndIncrement() == 0) {
                        this.b.schedule(this);
                        return;
                    }
                    return;
                }
                if (iC == 2) {
                    this.f5079j = iC;
                    this.e = eVar;
                    this.f5074a.onSubscribe(this);
                    return;
                }
            }
            this.e = new p083o3.d(this.d);
            this.f5074a.onSubscribe(this);
        }
    }

    @Override // p048i3.b, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        return this.e.poll();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5080k) {
            int iAddAndGet = 1;
            while (!this.f5078i) {
                boolean z6 = this.f5077h;
                Throwable th = this.f5076g;
                if (!this.c && z6 && th != null) {
                    this.f5078i = true;
                    this.f5074a.onError(this.f5076g);
                    this.b.dispose();
                    return;
                }
                this.f5074a.onNext(null);
                if (z6) {
                    this.f5078i = true;
                    Throwable th2 = this.f5076g;
                    if (th2 != null) {
                        this.f5074a.onError(th2);
                    } else {
                        this.f5074a.onComplete();
                    }
                    this.b.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            return;
        }
        p043h3.j jVar = this.e;
        io.reactivex.I i5 = this.f5074a;
        int iAddAndGet2 = 1;
        while (!a(this.f5077h, jVar.isEmpty(), i5)) {
            while (true) {
                boolean z7 = this.f5077h;
                try {
                    Object objPoll = jVar.poll();
                    boolean z8 = objPoll == null;
                    if (a(z7, z8, i5)) {
                        return;
                    }
                    if (z8) {
                        break;
                    } else {
                        i5.onNext(objPoll);
                    }
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    this.f5078i = true;
                    this.f5075f.dispose();
                    jVar.clear();
                    i5.onError(th3);
                    this.b.dispose();
                    return;
                }
            }
            iAddAndGet2 = addAndGet(-iAddAndGet2);
            if (iAddAndGet2 == 0) {
                return;
            }
        }
    }
}
