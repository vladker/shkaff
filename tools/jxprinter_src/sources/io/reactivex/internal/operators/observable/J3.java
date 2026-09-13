package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J3 extends p048i3.s implements p011b3.c, Runnable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f4987o = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TimeUnit f4989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final io.reactivex.N f4990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p011b3.c f4992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p129w3.f f4993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference f4994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f4995n;

    public J3(p112t3.e eVar, long j6, TimeUnit timeUnit, io.reactivex.N n6, int i5) {
        super(eVar, new p083o3.b());
        this.f4994m = new AtomicReference();
        this.f4988g = j6;
        this.f4989h = timeUnit;
        this.f4990i = n6;
        this.f4991j = i5;
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
        Object obj = f4987o;
        p083o3.b bVar = this.c;
        p112t3.e eVar = this.b;
        p129w3.f fVarCreate = this.f4993l;
        int iAddAndGet = 1;
        while (true) {
            boolean z6 = this.f4995n;
            boolean z7 = this.e;
            Object objPoll = bVar.poll();
            if (z7 && (objPoll == null || objPoll == obj)) {
                break;
            }
            if (objPoll == null) {
                iAddAndGet = this.f4060a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (objPoll == obj) {
                fVarCreate.onComplete();
                if (z6) {
                    this.f4992k.dispose();
                } else {
                    fVarCreate = p129w3.f.create(this.f4991j);
                    this.f4993l = fVarCreate;
                    eVar.onNext(fVarCreate);
                }
            } else {
                fVarCreate.onNext(objPoll);
            }
        }
        this.f4993l = null;
        bVar.clear();
        p033f3.d.a(this.f4994m);
        Throwable th = this.f4061f;
        if (th != null) {
            fVarCreate.onError(th);
        } else {
            fVarCreate.onComplete();
        }
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.e = true;
        if (c()) {
            h();
        }
        p033f3.d.a(this.f4994m);
        this.b.onComplete();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onError(Throwable th) {
        this.f4061f = th;
        this.e = true;
        if (c()) {
            h();
        }
        p033f3.d.a(this.f4994m);
        this.b.onError(th);
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f4995n) {
            return;
        }
        if (d()) {
            this.f4993l.onNext(obj);
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
        if (p033f3.d.g(this.f4992k, cVar)) {
            this.f4992k = cVar;
            this.f4993l = p129w3.f.create(this.f4991j);
            p112t3.e eVar = this.b;
            eVar.onSubscribe(this);
            eVar.onNext(this.f4993l);
            if (!this.d) {
                io.reactivex.N n6 = this.f4990i;
                long j6 = this.f4988g;
                p033f3.d.c(this.f4994m, n6.schedulePeriodicallyDirect(this, j6, j6, this.f4989h));
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d) {
            this.f4995n = true;
            p033f3.d.a(this.f4994m);
        }
        this.c.offer(f4987o);
        if (c()) {
            h();
        }
    }
}
