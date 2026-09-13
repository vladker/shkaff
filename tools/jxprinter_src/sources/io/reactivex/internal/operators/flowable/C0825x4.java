package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.x4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0825x4 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -5677354903406201275L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4824a;
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p083o3.d f4825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t5.d f4827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f4828i = new AtomicLong();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Throwable f4831l;

    public C0825x4(t5.c cVar, long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6, int i5, boolean z6) {
        this.f4824a = cVar;
        this.b = j6;
        this.c = j7;
        this.d = timeUnit;
        this.e = n6;
        this.f4825f = new p083o3.d(i5);
        this.f4826g = z6;
    }

    public final boolean a(t5.c cVar, boolean z6, boolean z7) {
        if (this.f4829j) {
            this.f4825f.clear();
            return true;
        }
        if (z7) {
            if (!z6) {
                return false;
            }
            Throwable th = this.f4831l;
            if (th != null) {
                cVar.onError(th);
                return true;
            }
            cVar.onComplete();
            return true;
        }
        Throwable th2 = this.f4831l;
        if (th2 != null) {
            this.f4825f.clear();
            cVar.onError(th2);
            return true;
        }
        if (!z6) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4824a;
        p083o3.d dVar = this.f4825f;
        boolean z6 = this.f4826g;
        int iAddAndGet = 1;
        do {
            if (this.f4830k) {
                if (a(cVar, dVar.isEmpty(), z6)) {
                    return;
                }
                long j6 = this.f4828i.get();
                long j7 = 0;
                while (true) {
                    if (a(cVar, dVar.peek() == null, z6)) {
                        return;
                    }
                    if (j6 == j7) {
                        if (j7 == 0) {
                            break;
                        }
                        p122v2.a.e(this.f4828i, j7);
                        break;
                    } else {
                        dVar.poll();
                        cVar.onNext(dVar.poll());
                        j7++;
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    public final void c(long j6, p083o3.d dVar) {
        long j7;
        long j8;
        long j9 = this.b;
        boolean z6 = j9 == LocationRequestCompat.PASSIVE_INTERVAL;
        while (!dVar.isEmpty()) {
            if (((Long) dVar.peek()).longValue() >= j6 - this.c) {
                if (z6) {
                    return;
                }
                AtomicLong atomicLong = dVar.f6450h;
                long j10 = atomicLong.get();
                while (true) {
                    j7 = dVar.f6447a.get();
                    j8 = atomicLong.get();
                    if (j10 == j8) {
                        break;
                    } else {
                        j10 = j8;
                    }
                }
                if ((((int) (j7 - j8)) >> 1) <= j9) {
                    return;
                }
            }
            dVar.poll();
            dVar.poll();
        }
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4829j) {
            return;
        }
        this.f4829j = true;
        this.f4827h.cancel();
        if (getAndIncrement() == 0) {
            this.f4825f.clear();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        c(this.e.now(this.d), this.f4825f);
        this.f4830k = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4826g) {
            c(this.e.now(this.d), this.f4825f);
        }
        this.f4831l = th;
        this.f4830k = true;
        b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        long jNow = this.e.now(this.d);
        Long lValueOf = Long.valueOf(jNow);
        p083o3.d dVar = this.f4825f;
        dVar.offer(lValueOf, obj);
        c(jNow, dVar);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4827h, dVar)) {
            this.f4827h = dVar;
            this.f4824a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4828i, j6);
            b();
        }
    }
}
