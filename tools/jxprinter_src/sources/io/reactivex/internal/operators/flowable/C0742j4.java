package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.j4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0742j4 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -5677354903406201275L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4678a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;
    public final p083o3.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t5.d f4680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f4681h = new AtomicLong();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Throwable f4684k;

    public C0742j4(t5.c cVar, long j6, TimeUnit timeUnit, io.reactivex.N n6, int i5, boolean z6) {
        this.f4678a = cVar;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = new p083o3.d(i5);
        this.f4679f = z6;
    }

    public final void a() {
        long j6;
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4678a;
        p083o3.d dVar = this.e;
        boolean z6 = this.f4679f;
        TimeUnit timeUnit = this.c;
        io.reactivex.N n6 = this.d;
        long j7 = this.b;
        int iAddAndGet = 1;
        do {
            long j8 = this.f4681h.get();
            long j9 = 0;
            while (true) {
                if (j9 == j8) {
                    j6 = 0;
                    break;
                }
                boolean z7 = this.f4683j;
                Long l6 = (Long) dVar.peek();
                boolean z8 = l6 == null;
                long jNow = n6.now(timeUnit);
                if (!z8 && l6.longValue() > jNow - j7) {
                    z8 = true;
                }
                j6 = 0;
                if (this.f4682i) {
                    this.e.clear();
                    return;
                }
                if (z7) {
                    if (!z6) {
                        Throwable th = this.f4684k;
                        if (th != null) {
                            this.e.clear();
                            cVar.onError(th);
                            return;
                        } else if (z8) {
                            cVar.onComplete();
                            return;
                        }
                    } else if (z8) {
                        Throwable th2 = this.f4684k;
                        if (th2 != null) {
                            cVar.onError(th2);
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                if (z8) {
                    break;
                }
                dVar.poll();
                cVar.onNext(dVar.poll());
                j9++;
            }
            if (j9 != j6) {
                p122v2.a.e(this.f4681h, j9);
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4682i) {
            return;
        }
        this.f4682i = true;
        this.f4680g.cancel();
        if (getAndIncrement() == 0) {
            this.e.clear();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4683j = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4684k = th;
        this.f4683j = true;
        a();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.e.offer(Long.valueOf(this.d.now(this.c)), obj);
        a();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4680g, dVar)) {
            this.f4680g = dVar;
            this.f4678a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4681h, j6);
            a();
        }
    }
}
