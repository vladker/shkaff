package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W4 extends AtomicInteger implements InterfaceC0984q, t5.d, Runnable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f4493m = new Object();
    private static final long serialVersionUID = 2233020065421370272L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4494a;
    public final int b;
    public final B c = new B(this, 1);
    public final AtomicReference d = new AtomicReference();
    public final AtomicInteger e = new AtomicInteger(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p083o3.b f4495f = new p083o3.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p100r3.c f4496g = new p100r3.c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f4497h = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f4498i = new AtomicLong();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p123v3.d f4500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4501l;

    public W4(t5.c cVar, int i5) {
        this.f4494a = cVar;
        this.b = i5;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4494a;
        p083o3.b bVar = this.f4495f;
        p100r3.c cVar2 = this.f4496g;
        long j6 = this.f4501l;
        int iAddAndGet = 1;
        while (this.e.get() != 0) {
            p123v3.d dVar = this.f4500k;
            boolean z6 = this.f4499j;
            if (z6 && cVar2.get() != null) {
                bVar.clear();
                Throwable thB = p100r3.g.b(cVar2);
                if (dVar != null) {
                    this.f4500k = null;
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
                        this.f4500k = null;
                        dVar.onComplete();
                    }
                    cVar.onComplete();
                    return;
                }
                if (dVar != null) {
                    this.f4500k = null;
                    dVar.onError(thB2);
                }
                cVar.onError(thB2);
                return;
            }
            if (z7) {
                this.f4501l = j6;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (objPoll != f4493m) {
                dVar.onNext(objPoll);
            } else {
                if (dVar != null) {
                    this.f4500k = null;
                    dVar.onComplete();
                }
                if (!this.f4497h.get()) {
                    p123v3.d dVarCreate = p123v3.d.create(this.b, this);
                    this.f4500k = dVarCreate;
                    this.e.getAndIncrement();
                    if (j6 != this.f4498i.get()) {
                        j6++;
                        cVar.onNext(dVarCreate);
                    } else {
                        p094q3.g.a(this.d);
                        this.c.dispose();
                        p017c3.e eVar = new p017c3.e("Could not deliver a window due to lack of requests");
                        cVar2.getClass();
                        p100r3.g.a(cVar2, eVar);
                        this.f4499j = true;
                    }
                }
            }
        }
        bVar.clear();
        this.f4500k = null;
    }

    public final void b() {
        this.f4495f.offer(f4493m);
        a();
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4497h.compareAndSet(false, true)) {
            this.c.dispose();
            if (this.e.decrementAndGet() == 0) {
                p094q3.g.a(this.d);
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.c.dispose();
        this.f4499j = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.c.dispose();
        p100r3.c cVar = this.f4496g;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4499j = true;
            a();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4495f.offer(obj);
        a();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this.d, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // t5.d
    public final void request(long j6) {
        p122v2.a.a(this.f4498i, j6);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.e.decrementAndGet() == 0) {
            p094q3.g.a(this.d);
        }
    }
}
