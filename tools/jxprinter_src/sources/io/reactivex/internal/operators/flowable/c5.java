package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c5 extends AtomicInteger implements InterfaceC0984q, t5.d, Runnable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final B f4581n = new B(null, 2);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f4582o = new Object();
    private static final long serialVersionUID = 2233020065421370272L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4583a;
    public final int b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f4586h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t5.d f4588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4589k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p123v3.d f4590l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4591m;
    public final AtomicReference c = new AtomicReference();
    public final AtomicInteger d = new AtomicInteger(1);
    public final p083o3.b e = new p083o3.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p100r3.c f4584f = new p100r3.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f4585g = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f4587i = new AtomicLong();

    public c5(t5.c cVar, int i5, Callable callable) {
        this.f4583a = cVar;
        this.b = i5;
        this.f4586h = callable;
    }

    public final void a() {
        AtomicReference atomicReference = this.c;
        B b = f4581n;
        p011b3.c cVar = (p011b3.c) atomicReference.getAndSet(b);
        if (cVar == null || cVar == b) {
            return;
        }
        cVar.dispose();
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4583a;
        p083o3.b bVar = this.e;
        p100r3.c cVar2 = this.f4584f;
        long j6 = this.f4591m;
        int iAddAndGet = 1;
        while (this.d.get() != 0) {
            p123v3.d dVar = this.f4590l;
            boolean z6 = this.f4589k;
            if (z6 && cVar2.get() != null) {
                bVar.clear();
                Throwable thB = p100r3.g.b(cVar2);
                if (dVar != null) {
                    this.f4590l = null;
                    dVar.onError(thB);
                }
                cVar.onError(thB);
                return;
            }
            Object objPoll = bVar.poll();
            boolean z7 = objPoll == null;
            if (z6 && z7) {
                cVar2.getClass();
                Throwable thB2 = p100r3.g.b(cVar2);
                if (thB2 == null) {
                    if (dVar != null) {
                        this.f4590l = null;
                        dVar.onComplete();
                    }
                    cVar.onComplete();
                    return;
                }
                if (dVar != null) {
                    this.f4590l = null;
                    dVar.onError(thB2);
                }
                cVar.onError(thB2);
                return;
            }
            if (z7) {
                this.f4591m = j6;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (objPoll != f4582o) {
                dVar.onNext(objPoll);
            } else {
                if (dVar != null) {
                    this.f4590l = null;
                    dVar.onComplete();
                }
                if (!this.f4585g.get()) {
                    if (j6 != this.f4587i.get()) {
                        p123v3.d dVarCreate = p123v3.d.create(this.b, this);
                        this.f4590l = dVarCreate;
                        this.d.getAndIncrement();
                        try {
                            Object objCall = this.f4586h.call();
                            p039g3.A.b(objCall, "The other Callable returned a null Publisher");
                            t5.b bVar2 = (t5.b) objCall;
                            B b = new B(this, 2);
                            AtomicReference atomicReference = this.c;
                            do {
                                if (atomicReference.compareAndSet(null, b)) {
                                    bVar2.subscribe(b);
                                    j6++;
                                    cVar.onNext(dVarCreate);
                                    break;
                                }
                            } while (atomicReference.get() == null);
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            cVar2.getClass();
                            p100r3.g.a(cVar2, th);
                            this.f4589k = true;
                        }
                    } else {
                        this.f4588j.cancel();
                        a();
                        p017c3.e eVar = new p017c3.e("Could not deliver a window due to lack of requests");
                        cVar2.getClass();
                        p100r3.g.a(cVar2, eVar);
                        this.f4589k = true;
                    }
                }
            }
        }
        bVar.clear();
        this.f4590l = null;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4585g.compareAndSet(false, true)) {
            a();
            if (this.d.decrementAndGet() == 0) {
                this.f4588j.cancel();
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        a();
        this.f4589k = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        a();
        p100r3.c cVar = this.f4584f;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4589k = true;
            b();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.e.offer(obj);
        b();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4588j, dVar)) {
            this.f4588j = dVar;
            this.f4583a.onSubscribe(this);
            this.e.offer(f4582o);
            b();
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        p122v2.a.a(this.f4587i, j6);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d.decrementAndGet() == 0) {
            this.f4588j.cancel();
        }
    }
}
