package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H3 extends AbstractC0824x3 {
    private static final long serialVersionUID = 3457957419649567404L;
    public final io.reactivex.N d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeUnit f4274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4275g;

    public H3(int i5, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.d = n6;
        this.f4275g = i5;
        this.e = j6;
        this.f4274f = timeUnit;
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0824x3
    public final Object b(Object obj) {
        io.reactivex.N n6 = this.d;
        TimeUnit timeUnit = this.f4274f;
        return new io.reactivex.schedulers.k(obj, n6.now(timeUnit), timeUnit);
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0824x3
    public final B3 c() {
        B3 b6;
        long jNow = this.d.now(this.f4274f) - this.e;
        B3 b7 = (B3) get();
        Object obj = b7.get();
        while (true) {
            B3 b8 = (B3) obj;
            b6 = b7;
            b7 = b8;
            if (b7 == null) {
                break;
            }
            io.reactivex.schedulers.k kVar = (io.reactivex.schedulers.k) b7.f4183a;
            if (p100r3.n.c(kVar.value()) || (kVar.value() instanceof p100r3.l) || kVar.b > jNow) {
                break;
            }
            obj = b7.get();
        }
        return b6;
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0824x3
    public final Object d(Object obj) {
        return ((io.reactivex.schedulers.k) obj).value();
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0824x3
    public final void f() {
        B3 b6;
        long jNow = this.d.now(this.f4274f) - this.e;
        B3 b7 = (B3) get();
        B3 b8 = (B3) b7.get();
        int i5 = 0;
        while (true) {
            B3 b9 = b8;
            b6 = b7;
            b7 = b9;
            if (b7 != null) {
                int i6 = this.b;
                if (i6 <= this.f4275g) {
                    if (((io.reactivex.schedulers.k) b7.f4183a).b > jNow) {
                        break;
                    }
                    i5++;
                    this.b = i6 - 1;
                    b8 = (B3) b7.get();
                } else {
                    i5++;
                    this.b = i6 - 1;
                    b8 = (B3) b7.get();
                }
            } else {
                break;
            }
        }
        if (i5 != 0) {
            set(b6);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0824x3
    public final void g() {
        B3 b6;
        int i5;
        long jNow = this.d.now(this.f4274f) - this.e;
        B3 b7 = (B3) get();
        B3 b8 = (B3) b7.get();
        int i6 = 0;
        while (true) {
            B3 b9 = b8;
            b6 = b7;
            b7 = b9;
            if (b7 == null || (i5 = this.b) <= 1 || ((io.reactivex.schedulers.k) b7.f4183a).b > jNow) {
                break;
            }
            i6++;
            this.b = i5 - 1;
            b8 = (B3) b7.get();
        }
        if (i6 != 0) {
            set(b6);
        }
    }
}
