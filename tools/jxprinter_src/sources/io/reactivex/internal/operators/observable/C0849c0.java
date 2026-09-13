package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0849c0 extends AtomicInteger implements io.reactivex.D {
    private static final long serialVersionUID = 4883307006032401862L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0844b0 f5160a;
    public final p100r3.c b = new p100r3.c();
    public final p083o3.d c = new p083o3.d(16);
    public volatile boolean d;

    public C0849c0(C0844b0 c0844b0) {
        this.f5160a = c0844b0;
    }

    public final void a() {
        C0844b0 c0844b0 = this.f5160a;
        p083o3.d dVar = this.c;
        p100r3.c cVar = this.b;
        int iAddAndGet = 1;
        while (!c0844b0.e()) {
            if (cVar.get() != null) {
                dVar.clear();
                c0844b0.onError(p100r3.g.b(cVar));
                return;
            }
            boolean z6 = this.d;
            Object objPoll = dVar.poll();
            boolean z7 = objPoll == null;
            if (z6 && z7) {
                if (c0844b0.e()) {
                    return;
                }
                try {
                    c0844b0.f5146a.onComplete();
                    return;
                } finally {
                    p033f3.d.a(c0844b0);
                }
            }
            if (z7) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                c0844b0.onNext(objPoll);
            }
        }
        dVar.clear();
    }

    @Override // io.reactivex.D, io.reactivex.InterfaceC0978k
    public final void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        io.reactivex.plugins.a.onError(th);
    }

    @Override // io.reactivex.D, io.reactivex.InterfaceC0978k
    public final void onNext(Object obj) {
        if (this.f5160a.e() || this.d) {
            return;
        }
        if (obj == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            this.f5160a.onNext(obj);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            p083o3.d dVar = this.c;
            synchronized (dVar) {
                dVar.offer(obj);
            }
            if (getAndIncrement() != 0) {
                return;
            }
        }
        a();
    }

    @Override // io.reactivex.D
    public final void setCancellable(p027e3.f fVar) {
        this.f5160a.setCancellable(null);
    }

    @Override // io.reactivex.D
    public final void setDisposable(p011b3.c cVar) {
        C0844b0 c0844b0 = this.f5160a;
        c0844b0.getClass();
        p033f3.d.d(c0844b0, cVar);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final String toString() {
        return this.f5160a.toString();
    }

    @Override // io.reactivex.D
    public final boolean tryOnError(Throwable th) {
        if (this.f5160a.e() || this.d) {
            return false;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        p100r3.c cVar = this.b;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            return false;
        }
        this.d = true;
        if (getAndIncrement() == 0) {
            a();
        }
        return true;
    }

    @Override // io.reactivex.D
    public final io.reactivex.D serialize() {
        return this;
    }
}
