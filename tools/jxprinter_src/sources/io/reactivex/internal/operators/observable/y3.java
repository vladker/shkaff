package io.reactivex.internal.operators.observable;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y3 extends AtomicBoolean implements io.reactivex.I, p011b3.c, Runnable {
    private static final long serialVersionUID = 3366976432059579510L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5314a;
    public final long b;
    public final long c;
    public final int d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p011b3.c f5318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f5319j = new AtomicInteger();
    public final ArrayDeque e = new ArrayDeque();

    public y3(io.reactivex.I i5, long j6, long j7, int i6) {
        this.f5314a = i5;
        this.b = j6;
        this.c = j7;
        this.d = i6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5316g = true;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5316g;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        while (true) {
            ArrayDeque arrayDeque = this.e;
            if (arrayDeque.isEmpty()) {
                this.f5314a.onComplete();
                return;
            }
            ((p129w3.f) arrayDeque.poll()).onComplete();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        while (true) {
            ArrayDeque arrayDeque = this.e;
            if (arrayDeque.isEmpty()) {
                this.f5314a.onError(th);
                return;
            }
            ((p129w3.f) arrayDeque.poll()).onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        ArrayDeque arrayDeque = this.e;
        long j6 = this.f5315f;
        long j7 = this.c;
        if (j6 % j7 == 0 && !this.f5316g) {
            this.f5319j.getAndIncrement();
            p129w3.f fVarCreate = p129w3.f.create(this.d, this);
            arrayDeque.offer(fVarCreate);
            this.f5314a.onNext(fVarCreate);
        }
        long j8 = this.f5317h + 1;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            ((p129w3.f) it.next()).onNext(obj);
        }
        if (j8 >= this.b) {
            ((p129w3.f) arrayDeque.poll()).onComplete();
            if (arrayDeque.isEmpty() && this.f5316g) {
                this.f5318i.dispose();
                return;
            }
            this.f5317h = j8 - j7;
        } else {
            this.f5317h = j8;
        }
        this.f5315f = j6 + 1;
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5318i, cVar)) {
            this.f5318i = cVar;
            this.f5314a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5319j.decrementAndGet() == 0 && this.f5316g) {
            this.f5318i.dispose();
        }
    }
}
