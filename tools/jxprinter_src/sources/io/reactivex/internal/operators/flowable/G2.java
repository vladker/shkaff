package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G2 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -4592979584110982903L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4254a;
    public final AtomicReference b = new AtomicReference();
    public final F2 c = new F2(this);
    public final p100r3.c d = new p100r3.c();
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile p083o3.c f4257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f4258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f4261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4262m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4263n;

    public G2(t5.c cVar) {
        this.f4254a = cVar;
        int i5 = AbstractC0979l.f5366a;
        this.f4255f = i5;
        this.f4256g = i5 - (i5 >> 2);
    }

    public final void a() {
        t5.c cVar = this.f4254a;
        long j6 = this.f4262m;
        int i5 = this.f4263n;
        int i6 = this.f4256g;
        int i7 = 1;
        int iAddAndGet = 1;
        while (true) {
            long j7 = this.e.get();
            while (j6 != j7) {
                if (this.f4259j) {
                    this.f4258i = null;
                    this.f4257h = null;
                    return;
                }
                if (this.d.get() != null) {
                    this.f4258i = null;
                    this.f4257h = null;
                    p100r3.c cVar2 = this.d;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
                    return;
                }
                int i8 = this.f4261l;
                if (i8 == i7) {
                    Object obj = this.f4258i;
                    this.f4258i = null;
                    this.f4261l = 2;
                    cVar.onNext(obj);
                    j6++;
                } else {
                    boolean z6 = this.f4260k;
                    p083o3.c cVar3 = this.f4257h;
                    Object objPoll = cVar3 != null ? cVar3.poll() : null;
                    boolean z7 = objPoll == null;
                    if (z6 && z7 && i8 == 2) {
                        this.f4257h = null;
                        cVar.onComplete();
                        return;
                    } else {
                        if (z7) {
                            break;
                        }
                        cVar.onNext(objPoll);
                        j6++;
                        i5++;
                        if (i5 == i6) {
                            ((t5.d) this.b.get()).request(i6);
                            i5 = 0;
                        }
                        i7 = 1;
                    }
                }
            }
            if (j6 == j7) {
                if (this.f4259j) {
                    this.f4258i = null;
                    this.f4257h = null;
                    return;
                }
                if (this.d.get() != null) {
                    this.f4258i = null;
                    this.f4257h = null;
                    p100r3.c cVar4 = this.d;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar4, cVar4, cVar);
                    return;
                }
                boolean z8 = this.f4260k;
                p083o3.c cVar5 = this.f4257h;
                boolean z9 = cVar5 == null || cVar5.isEmpty();
                if (z8 && z9 && this.f4261l == 2) {
                    this.f4257h = null;
                    cVar.onComplete();
                    return;
                }
            }
            this.f4262m = j6;
            this.f4263n = i5;
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                i7 = 1;
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        this.f4259j = true;
        p094q3.g.a(this.b);
        p033f3.d.a(this.c);
        if (getAndIncrement() == 0) {
            this.f4257h = null;
            this.f4258i = null;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4260k = true;
        if (getAndIncrement() == 0) {
            a();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p094q3.g.a(this.b);
        if (getAndIncrement() == 0) {
            a();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (compareAndSet(0, 1)) {
            long j6 = this.f4262m;
            if (this.e.get() != j6) {
                p083o3.c cVar = this.f4257h;
                if (cVar == null || cVar.isEmpty()) {
                    this.f4262m = j6 + 1;
                    this.f4254a.onNext(obj);
                    int i5 = this.f4263n + 1;
                    if (i5 == this.f4256g) {
                        this.f4263n = 0;
                        ((t5.d) this.b.get()).request(i5);
                    } else {
                        this.f4263n = i5;
                    }
                } else {
                    cVar.offer(obj);
                }
            } else {
                p083o3.c cVar2 = this.f4257h;
                if (cVar2 == null) {
                    cVar2 = new p083o3.c(AbstractC0979l.f5366a);
                    this.f4257h = cVar2;
                }
                cVar2.offer(obj);
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            p083o3.c cVar3 = this.f4257h;
            if (cVar3 == null) {
                cVar3 = new p083o3.c(AbstractC0979l.f5366a);
                this.f4257h = cVar3;
            }
            cVar3.offer(obj);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        a();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this.b, dVar, this.f4255f);
    }

    @Override // t5.d
    public final void request(long j6) {
        p122v2.a.a(this.e, j6);
        if (getAndIncrement() == 0) {
            a();
        }
    }
}
