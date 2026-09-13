package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G3 extends AtomicInteger implements io.reactivex.I, p011b3.c, Runnable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0942v f4944l = new C0942v(null, 2);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f4945m = new Object();
    private static final long serialVersionUID = 2233020065421370272L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4946a;
    public final int b;
    public final AtomicReference c = new AtomicReference();
    public final AtomicInteger d = new AtomicInteger(1);
    public final p083o3.b e = new p083o3.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p100r3.c f4947f = new p100r3.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f4948g = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f4949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p011b3.c f4950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p129w3.f f4952k;

    public G3(io.reactivex.I i5, int i6, Callable callable) {
        this.f4946a = i5;
        this.b = i6;
        this.f4949h = callable;
    }

    public final void a() {
        AtomicReference atomicReference = this.c;
        C0942v c0942v = f4944l;
        p011b3.c cVar = (p011b3.c) atomicReference.getAndSet(c0942v);
        if (cVar == null || cVar == c0942v) {
            return;
        }
        cVar.dispose();
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.I i5 = this.f4946a;
        p083o3.b bVar = this.e;
        p100r3.c cVar = this.f4947f;
        int iAddAndGet = 1;
        while (this.d.get() != 0) {
            p129w3.f fVar = this.f4952k;
            boolean z6 = this.f4951j;
            if (z6 && cVar.get() != null) {
                bVar.clear();
                Throwable thB = p100r3.g.b(cVar);
                if (fVar != null) {
                    this.f4952k = null;
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
                        this.f4952k = null;
                        fVar.onComplete();
                    }
                    i5.onComplete();
                    return;
                }
                if (fVar != null) {
                    this.f4952k = null;
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
            } else if (objPoll != f4945m) {
                fVar.onNext(objPoll);
            } else {
                if (fVar != null) {
                    this.f4952k = null;
                    fVar.onComplete();
                }
                if (!this.f4948g.get()) {
                    p129w3.f fVarCreate = p129w3.f.create(this.b, this);
                    this.f4952k = fVarCreate;
                    this.d.getAndIncrement();
                    try {
                        Object objCall = this.f4949h.call();
                        p039g3.A.b(objCall, "The other Callable returned a null ObservableSource");
                        io.reactivex.G g6 = (io.reactivex.G) objCall;
                        C0942v c0942v = new C0942v(this, 2);
                        AtomicReference atomicReference = this.c;
                        do {
                            if (atomicReference.compareAndSet(null, c0942v)) {
                                g6.subscribe(c0942v);
                                i5.onNext(fVarCreate);
                                break;
                            }
                        } while (atomicReference.get() == null);
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        cVar.getClass();
                        p100r3.g.a(cVar, th);
                        this.f4951j = true;
                    }
                }
            }
        }
        bVar.clear();
        this.f4952k = null;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f4948g.compareAndSet(false, true)) {
            a();
            if (this.d.decrementAndGet() == 0) {
                this.f4950i.dispose();
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4948g.get();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        a();
        this.f4951j = true;
        b();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        a();
        p100r3.c cVar = this.f4947f;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4951j = true;
            b();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.e.offer(obj);
        b();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f4950i, cVar)) {
            this.f4950i = cVar;
            this.f4946a.onSubscribe(this);
            this.e.offer(f4945m);
            b();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d.decrementAndGet() == 0) {
            this.f4950i.dispose();
        }
    }
}
