package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T2 extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -5677354903406201275L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5108a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;
    public final p083o3.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p011b3.c f5110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5112i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f5113j;

    public T2(io.reactivex.I i5, long j6, TimeUnit timeUnit, io.reactivex.N n6, int i6, boolean z6) {
        this.f5108a = i5;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = new p083o3.d(i6);
        this.f5109f = z6;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.I i5 = this.f5108a;
        p083o3.d dVar = this.e;
        boolean z6 = this.f5109f;
        TimeUnit timeUnit = this.c;
        io.reactivex.N n6 = this.d;
        long j6 = this.b;
        int iAddAndGet = 1;
        while (!this.f5111h) {
            boolean z7 = this.f5112i;
            Long l6 = (Long) dVar.peek();
            boolean z8 = l6 == null;
            long jNow = n6.now(timeUnit);
            if (!z8 && l6.longValue() > jNow - j6) {
                z8 = true;
            }
            if (z7) {
                if (!z6) {
                    Throwable th = this.f5113j;
                    if (th != null) {
                        this.e.clear();
                        i5.onError(th);
                        return;
                    } else if (z8) {
                        i5.onComplete();
                        return;
                    }
                } else if (z8) {
                    Throwable th2 = this.f5113j;
                    if (th2 != null) {
                        i5.onError(th2);
                        return;
                    } else {
                        i5.onComplete();
                        return;
                    }
                }
            }
            if (z8) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                dVar.poll();
                i5.onNext(dVar.poll());
            }
        }
        this.e.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5111h) {
            return;
        }
        this.f5111h = true;
        this.f5110g.dispose();
        if (getAndIncrement() == 0) {
            this.e.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5111h;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5112i = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5113j = th;
        this.f5112i = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.e.offer(Long.valueOf(this.d.now(this.c)), obj);
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5110g, cVar)) {
            this.f5110g = cVar;
            this.f5108a.onSubscribe(this);
        }
    }
}
