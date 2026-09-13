package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.v2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0945v2 extends AbstractC0896l2 {
    private static final long serialVersionUID = 3457957419649567404L;
    public final io.reactivex.N c;
    public final long d;
    public final TimeUnit e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5293f;

    public C0945v2(int i5, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.c = n6;
        this.f5293f = i5;
        this.d = j6;
        this.e = timeUnit;
    }

    @Override // io.reactivex.internal.operators.observable.AbstractC0896l2
    public final Object b(Object obj) {
        io.reactivex.N n6 = this.c;
        TimeUnit timeUnit = this.e;
        return new io.reactivex.schedulers.k(obj, n6.now(timeUnit), timeUnit);
    }

    @Override // io.reactivex.internal.operators.observable.AbstractC0896l2
    public final C0916p2 c() {
        C0916p2 c0916p2;
        long jNow = this.c.now(this.e) - this.d;
        C0916p2 c0916p3 = (C0916p2) get();
        Object obj = c0916p3.get();
        while (true) {
            C0916p2 c0916p4 = (C0916p2) obj;
            c0916p2 = c0916p3;
            c0916p3 = c0916p4;
            if (c0916p3 == null) {
                break;
            }
            io.reactivex.schedulers.k kVar = (io.reactivex.schedulers.k) c0916p3.f5253a;
            if (p100r3.n.c(kVar.value()) || (kVar.value() instanceof p100r3.l) || kVar.b > jNow) {
                break;
            }
            obj = c0916p3.get();
        }
        return c0916p2;
    }

    @Override // io.reactivex.internal.operators.observable.AbstractC0896l2
    public final Object d(Object obj) {
        return ((io.reactivex.schedulers.k) obj).value();
    }

    @Override // io.reactivex.internal.operators.observable.AbstractC0896l2
    public final void f() {
        C0916p2 c0916p2;
        long jNow = this.c.now(this.e) - this.d;
        C0916p2 c0916p3 = (C0916p2) get();
        C0916p2 c0916p4 = (C0916p2) c0916p3.get();
        int i5 = 0;
        while (true) {
            C0916p2 c0916p5 = c0916p4;
            c0916p2 = c0916p3;
            c0916p3 = c0916p5;
            if (c0916p3 != null) {
                int i6 = this.b;
                if (i6 <= this.f5293f) {
                    if (((io.reactivex.schedulers.k) c0916p3.f5253a).b > jNow) {
                        break;
                    }
                    i5++;
                    this.b = i6 - 1;
                    c0916p4 = (C0916p2) c0916p3.get();
                } else {
                    i5++;
                    this.b = i6 - 1;
                    c0916p4 = (C0916p2) c0916p3.get();
                }
            } else {
                break;
            }
        }
        if (i5 != 0) {
            set(c0916p2);
        }
    }

    @Override // io.reactivex.internal.operators.observable.AbstractC0896l2
    public final void g() {
        C0916p2 c0916p2;
        int i5;
        long jNow = this.c.now(this.e) - this.d;
        C0916p2 c0916p3 = (C0916p2) get();
        C0916p2 c0916p4 = (C0916p2) c0916p3.get();
        int i6 = 0;
        while (true) {
            C0916p2 c0916p5 = c0916p4;
            c0916p2 = c0916p3;
            c0916p3 = c0916p5;
            if (c0916p3 == null || (i5 = this.b) <= 1 || ((io.reactivex.schedulers.k) c0916p3.f5253a).b > jNow) {
                break;
            }
            i6++;
            this.b = i5 - 1;
            c0916p4 = (C0916p2) c0916p3.get();
        }
        if (i6 != 0) {
            set(c0916p2);
        }
    }
}
