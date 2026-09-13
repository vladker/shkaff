package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0981n;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.w0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0815w0 extends AtomicInteger implements InterfaceC0981n {
    private static final long serialVersionUID = 4883307006032401862L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0774p0 f4815a;
    public final p100r3.c b = new p100r3.c();
    public final p083o3.d c = new p083o3.d(16);
    public volatile boolean d;

    public C0815w0(AbstractC0774p0 abstractC0774p0) {
        this.f4815a = abstractC0774p0;
    }

    public final void a() {
        AbstractC0774p0 abstractC0774p0 = this.f4815a;
        p083o3.d dVar = this.c;
        p100r3.c cVar = this.b;
        int iAddAndGet = 1;
        while (!abstractC0774p0.b.e()) {
            if (cVar.get() != null) {
                dVar.clear();
                abstractC0774p0.onError(p100r3.g.b(cVar));
                return;
            }
            boolean z6 = this.d;
            Object objPoll = dVar.poll();
            boolean z7 = objPoll == null;
            if (z6 && z7) {
                abstractC0774p0.c();
                return;
            } else if (z7) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                abstractC0774p0.onNext(objPoll);
            }
        }
        dVar.clear();
    }

    @Override // io.reactivex.InterfaceC0981n, io.reactivex.InterfaceC0978k
    public final void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        io.reactivex.plugins.a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0981n, io.reactivex.InterfaceC0978k
    public final void onNext(Object obj) {
        if (this.f4815a.b.e() || this.d) {
            return;
        }
        if (obj == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            this.f4815a.onNext(obj);
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

    @Override // io.reactivex.InterfaceC0981n
    public final void setCancellable(p027e3.f fVar) {
        this.f4815a.setCancellable(null);
    }

    @Override // io.reactivex.InterfaceC0981n
    public final void setDisposable(p011b3.c cVar) {
        this.f4815a.setDisposable(cVar);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final String toString() {
        return this.f4815a.toString();
    }

    @Override // io.reactivex.InterfaceC0981n
    public final boolean tryOnError(Throwable th) {
        if (this.f4815a.b.e() || this.d) {
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

    @Override // io.reactivex.InterfaceC0981n
    public final InterfaceC0981n serialize() {
        return this;
    }
}
