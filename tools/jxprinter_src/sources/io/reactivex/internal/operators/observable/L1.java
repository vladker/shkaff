package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L1 extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -4592979584110982903L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5006a;
    public final AtomicReference b = new AtomicReference();
    public final K1 c = new K1(this);
    public final p100r3.c d = new p100r3.c();
    public volatile p083o3.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f5007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f5010i;

    public L1(io.reactivex.I i5) {
        this.f5006a = i5;
    }

    public final void a() {
        io.reactivex.I i5 = this.f5006a;
        int iAddAndGet = 1;
        while (!this.f5008g) {
            if (this.d.get() != null) {
                this.f5007f = null;
                this.e = null;
                p100r3.c cVar = this.d;
                cVar.getClass();
                i5.onError(p100r3.g.b(cVar));
                return;
            }
            int i6 = this.f5010i;
            if (i6 == 1) {
                Object obj = this.f5007f;
                this.f5007f = null;
                this.f5010i = 2;
                i5.onNext(obj);
                i6 = 2;
            }
            boolean z6 = this.f5009h;
            p083o3.d dVar = this.e;
            Object objPoll = dVar != null ? dVar.poll() : null;
            boolean z7 = objPoll == null;
            if (z6 && z7 && i6 == 2) {
                this.e = null;
                i5.onComplete();
                return;
            } else if (z7) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                i5.onNext(objPoll);
            }
        }
        this.f5007f = null;
        this.e = null;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5008g = true;
        p033f3.d.a(this.b);
        p033f3.d.a(this.c);
        if (getAndIncrement() == 0) {
            this.e = null;
            this.f5007f = null;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) this.b.get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5009h = true;
        if (getAndIncrement() == 0) {
            a();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.d.a(this.b);
        if (getAndIncrement() == 0) {
            a();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (compareAndSet(0, 1)) {
            this.f5006a.onNext(obj);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            p083o3.d dVar = this.e;
            if (dVar == null) {
                dVar = new p083o3.d(AbstractC0979l.f5366a);
                this.e = dVar;
            }
            dVar.offer(obj);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.b, cVar);
    }
}
