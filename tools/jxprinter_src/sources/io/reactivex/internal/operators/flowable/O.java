package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O extends p094q3.a {
    private static final long serialVersionUID = -5082275438355852221L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4382a;
    public final p027e3.o b;
    public final P[] c;
    public final p083o3.d d;
    public final Object[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f4388k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f4389l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference f4390m;

    public O(int i5, int i6, p027e3.o oVar, t5.c cVar, boolean z6) {
        this.f4382a = cVar;
        this.b = oVar;
        P[] pArr = new P[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            pArr[i7] = new P(this, i7, i6);
        }
        this.c = pArr;
        this.e = new Object[i5];
        this.d = new p083o3.d(i6);
        this.f4388k = new AtomicLong();
        this.f4390m = new AtomicReference();
        this.f4383f = z6;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        if ((i5 & 4) != 0) {
            return 0;
        }
        this.f4384g = true;
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        this.f4387j = true;
        e();
    }

    @Override // p043h3.j
    public final void clear() {
        this.d.clear();
    }

    public final void e() {
        for (P p6 : this.c) {
            p6.getClass();
            p094q3.g.a(p6);
        }
    }

    public final void f() {
        if (getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        if (this.f4384g) {
            t5.c cVar = this.f4382a;
            p083o3.d dVar = this.d;
            while (!this.f4387j) {
                Throwable th = (Throwable) this.f4390m.get();
                if (th != null) {
                    dVar.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z6 = this.f4389l;
                boolean zIsEmpty = dVar.isEmpty();
                if (!zIsEmpty) {
                    cVar.onNext(null);
                }
                if (z6 && zIsEmpty) {
                    cVar.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            dVar.clear();
            return;
        }
        t5.c cVar2 = this.f4382a;
        p083o3.d dVar2 = this.d;
        int iAddAndGet2 = 1;
        do {
            long j6 = this.f4388k.get();
            long j7 = 0;
            while (j7 != j6) {
                boolean z7 = this.f4389l;
                Object objPoll = dVar2.poll();
                boolean z8 = objPoll == null;
                if (i(z7, z8, cVar2, dVar2)) {
                    return;
                }
                if (z8) {
                    break;
                }
                try {
                    Object objApply = this.b.apply((Object[]) dVar2.poll());
                    p039g3.A.b(objApply, "The combiner returned a null value");
                    cVar2.onNext(objApply);
                    ((P) objPoll).a();
                    j7++;
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    e();
                    p100r3.g.a(this.f4390m, th2);
                    cVar2.onError(p100r3.g.b(this.f4390m));
                    return;
                }
            }
            if (j7 == j6 && i(this.f4389l, dVar2.isEmpty(), cVar2, dVar2)) {
                return;
            }
            if (j7 != 0 && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f4388k.addAndGet(-j7);
            }
            iAddAndGet2 = addAndGet(-iAddAndGet2);
        } while (iAddAndGet2 != 0);
    }

    public final boolean i(boolean z6, boolean z7, t5.c cVar, p083o3.d dVar) {
        if (this.f4387j) {
            e();
            dVar.clear();
            return true;
        }
        if (!z6) {
            return false;
        }
        if (this.f4383f) {
            if (!z7) {
                return false;
            }
            e();
            Throwable thB = p100r3.g.b(this.f4390m);
            if (thB == null || thB == p100r3.g.f7961a) {
                cVar.onComplete();
                return true;
            }
            cVar.onError(thB);
            return true;
        }
        Throwable thB2 = p100r3.g.b(this.f4390m);
        if (thB2 != null && thB2 != p100r3.g.f7961a) {
            e();
            dVar.clear();
            cVar.onError(thB2);
            return true;
        }
        if (!z7) {
            return false;
        }
        e();
        cVar.onComplete();
        return true;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.d.isEmpty();
    }

    public final void j(int i5) {
        int i6;
        synchronized (this) {
            try {
                Object[] objArr = this.e;
                if (objArr[i5] != null && (i6 = this.f4386i + 1) != objArr.length) {
                    this.f4386i = i6;
                } else {
                    this.f4389l = true;
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        p083o3.d dVar = this.d;
        Object objPoll = dVar.poll();
        if (objPoll == null) {
            return null;
        }
        Object objApply = this.b.apply((Object[]) dVar.poll());
        p039g3.A.b(objApply, "The combiner returned a null value");
        ((P) objPoll).a();
        return objApply;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4388k, j6);
            f();
        }
    }
}
