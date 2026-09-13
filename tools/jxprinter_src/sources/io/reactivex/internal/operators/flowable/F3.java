package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F3 extends AtomicReference implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0836z3[] f4232h = new C0836z3[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0836z3[] f4233i = new C0836z3[0];
    private static final long serialVersionUID = 7224554242710036740L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3 f4234a;
    public boolean b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4236g;
    public final AtomicInteger e = new AtomicInteger();
    public final AtomicReference c = new AtomicReference(f4232h);
    public final AtomicBoolean d = new AtomicBoolean();

    public F3(C3 c6) {
        this.f4234a = c6;
    }

    public final void a() {
        AtomicInteger atomicInteger = this.e;
        if (atomicInteger.getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        while (!e()) {
            C0836z3[] c0836z3Arr = (C0836z3[]) this.c.get();
            long j6 = this.f4235f;
            long jMax = j6;
            for (C0836z3 c0836z3 : c0836z3Arr) {
                jMax = Math.max(jMax, c0836z3.d.get());
            }
            long j7 = this.f4236g;
            t5.d dVar = (t5.d) get();
            long j8 = jMax - j6;
            if (j8 != 0) {
                this.f4235f = jMax;
                if (dVar == null) {
                    long j9 = j7 + j8;
                    if (j9 < 0) {
                        j9 = LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                    this.f4236g = j9;
                } else if (j7 != 0) {
                    this.f4236g = 0L;
                    dVar.request(j7 + j8);
                } else {
                    dVar.request(j8);
                }
            } else if (j7 != 0 && dVar != null) {
                this.f4236g = 0L;
                dVar.request(j7);
            }
            iAddAndGet = atomicInteger.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(C0836z3 c0836z3) {
        C0836z3[] c0836z3Arr;
        while (true) {
            AtomicReference atomicReference = this.c;
            C0836z3[] c0836z3Arr2 = (C0836z3[]) atomicReference.get();
            int length = c0836z3Arr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (c0836z3Arr2[i5].equals(c0836z3)) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                c0836z3Arr = f4232h;
            } else {
                C0836z3[] c0836z3Arr3 = new C0836z3[length - 1];
                System.arraycopy(c0836z3Arr2, 0, c0836z3Arr3, 0, i5);
                System.arraycopy(c0836z3Arr2, i5 + 1, c0836z3Arr3, i5, (length - i5) - 1);
                c0836z3Arr = c0836z3Arr3;
            }
            while (!atomicReference.compareAndSet(c0836z3Arr2, c0836z3Arr)) {
                if (atomicReference.get() != c0836z3Arr2) {
                }
            }
            return;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c.set(f4233i);
        p094q3.g.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.get() == f4233i;
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.b) {
            return;
        }
        this.b = true;
        C3 c6 = this.f4234a;
        c6.complete();
        for (C0836z3 c0836z3 : (C0836z3[]) this.c.getAndSet(f4233i)) {
            c6.e(c0836z3);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.b) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.b = true;
        C3 c6 = this.f4234a;
        c6.error(th);
        for (C0836z3 c0836z3 : (C0836z3[]) this.c.getAndSet(f4233i)) {
            c6.e(c0836z3);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.b) {
            return;
        }
        C3 c6 = this.f4234a;
        c6.a(obj);
        for (C0836z3 c0836z3 : (C0836z3[]) this.c.get()) {
            c6.e(c0836z3);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this, dVar)) {
            a();
            for (C0836z3 c0836z3 : (C0836z3[]) this.c.get()) {
                this.f4234a.e(c0836z3);
            }
        }
    }
}
