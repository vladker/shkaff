package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A3 extends AtomicInteger implements io.reactivex.I, p011b3.c, Runnable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f4865k = new Object();
    private static final long serialVersionUID = 2233020065421370272L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4866a;
    public final int b;
    public final C0942v c = new C0942v(this, 1);
    public final AtomicReference d = new AtomicReference();
    public final AtomicInteger e = new AtomicInteger(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p083o3.b f4867f = new p083o3.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p100r3.c f4868g = new p100r3.c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f4869h = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public p129w3.f f4871j;

    public A3(io.reactivex.I i5, int i6) {
        this.f4866a = i5;
        this.b = i6;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.I i5 = this.f4866a;
        p083o3.b bVar = this.f4867f;
        p100r3.c cVar = this.f4868g;
        int iAddAndGet = 1;
        while (this.e.get() != 0) {
            p129w3.f fVar = this.f4871j;
            boolean z6 = this.f4870i;
            if (z6 && cVar.get() != null) {
                bVar.clear();
                Throwable thB = p100r3.g.b(cVar);
                if (fVar != null) {
                    this.f4871j = null;
                    fVar.onError(thB);
                }
                i5.onError(thB);
                return;
            }
            Object objPoll = bVar.poll();
            boolean z7 = objPoll == null;
            if (z6 && z7) {
                cVar.getClass();
                Throwable thB2 = p100r3.g.b(cVar);
                if (thB2 == null) {
                    if (fVar != null) {
                        this.f4871j = null;
                        fVar.onComplete();
                    }
                    i5.onComplete();
                    return;
                }
                if (fVar != null) {
                    this.f4871j = null;
                    fVar.onError(thB2);
                }
                i5.onError(thB2);
                return;
            }
            if (z7) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (objPoll != f4865k) {
                fVar.onNext(objPoll);
            } else {
                if (fVar != null) {
                    this.f4871j = null;
                    fVar.onComplete();
                }
                if (!this.f4869h.get()) {
                    p129w3.f fVarCreate = p129w3.f.create(this.b, this);
                    this.f4871j = fVarCreate;
                    this.e.getAndIncrement();
                    i5.onNext(fVarCreate);
                }
            }
        }
        bVar.clear();
        this.f4871j = null;
    }

    public final void b() {
        this.f4867f.offer(f4865k);
        a();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f4869h.compareAndSet(false, true)) {
            this.c.dispose();
            if (this.e.decrementAndGet() == 0) {
                p033f3.d.a(this.d);
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4869h.get();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.c.dispose();
        this.f4870i = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.c.dispose();
        p100r3.c cVar = this.f4868g;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4870i = true;
            a();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f4867f.offer(obj);
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.f(this.d, cVar)) {
            b();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.e.decrementAndGet() == 0) {
            p033f3.d.a(this.d);
        }
    }
}
