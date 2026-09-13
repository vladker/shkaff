package io.reactivex.internal.operators.observable;

import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F0 extends AtomicInteger implements p011b3.c, io.reactivex.I {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final E0[] f4925q = new E0[0];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final E0[] f4926r = new E0[0];
    private static final long serialVersionUID = -2117620485640801370L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4927a;
    public final p027e3.o b;
    public final boolean c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile p043h3.i f4928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p100r3.c f4930h = new p100r3.c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReference f4932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p011b3.c f4933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4935m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4936n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayDeque f4937o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4938p;

    public F0(int i5, int i6, p027e3.o oVar, io.reactivex.I i7, boolean z6) {
        this.f4927a = i7;
        this.b = oVar;
        this.c = z6;
        this.d = i5;
        this.e = i6;
        if (i5 != Integer.MAX_VALUE) {
            this.f4937o = new ArrayDeque(i5);
        }
        this.f4932j = new AtomicReference(f4925q);
    }

    public final boolean a() {
        if (!this.f4931i) {
            Throwable th = (Throwable) this.f4930h.get();
            if (this.c || th == null) {
                return false;
            }
            b();
            p100r3.c cVar = this.f4930h;
            cVar.getClass();
            Throwable thB = p100r3.g.b(cVar);
            if (thB != p100r3.g.f7961a) {
                this.f4927a.onError(thB);
            }
        }
        return true;
    }

    public final boolean b() {
        E0[] e0Arr;
        this.f4933k.dispose();
        AtomicReference atomicReference = this.f4932j;
        E0[] e0Arr2 = (E0[]) atomicReference.get();
        E0[] e0Arr3 = f4926r;
        if (e0Arr2 == e0Arr3 || (e0Arr = (E0[]) atomicReference.getAndSet(e0Arr3)) == e0Arr3) {
            return false;
        }
        for (E0 e1 : e0Arr) {
            e1.getClass();
            p033f3.d.a(e1);
        }
        return true;
    }

    public final void c() {
        if (getAndIncrement() == 0) {
            d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fe A[PHI: r4
  0x00fe: PHI (r4v10 int) = (r4v8 int), (r4v11 int) binds: [B:71:0x00dd, B:83:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
    public final void d() {
        int size;
        boolean z6;
        io.reactivex.I i5 = this.f4927a;
        int iAddAndGet = 1;
        while (!a()) {
            p043h3.i iVar = this.f4928f;
            if (iVar != null) {
                while (!a()) {
                    Object objPoll = iVar.poll();
                    if (objPoll != null) {
                        i5.onNext(objPoll);
                    }
                }
                return;
            }
            boolean z7 = this.f4929g;
            p043h3.i iVar2 = this.f4928f;
            E0[] e0Arr = (E0[]) this.f4932j.get();
            int length = e0Arr.length;
            int i6 = 0;
            if (this.d != Integer.MAX_VALUE) {
                synchronized (this) {
                    size = this.f4937o.size();
                }
            } else {
                size = 0;
            }
            if (z7 && ((iVar2 == null || iVar2.isEmpty()) && length == 0 && size == 0)) {
                p100r3.c cVar = this.f4930h;
                cVar.getClass();
                Throwable thB = p100r3.g.b(cVar);
                if (thB != p100r3.g.f7961a) {
                    if (thB == null) {
                        i5.onComplete();
                        return;
                    } else {
                        i5.onError(thB);
                        return;
                    }
                }
                return;
            }
            if (length != 0) {
                long j6 = this.f4935m;
                int i7 = this.f4936n;
                if (length <= i7 || e0Arr[i7].f4911a != j6) {
                    if (length <= i7) {
                        i7 = 0;
                    }
                    for (int i8 = 0; i8 < length && e0Arr[i7].f4911a != j6; i8++) {
                        i7++;
                        if (i7 == length) {
                            i7 = 0;
                        }
                    }
                    this.f4936n = i7;
                    this.f4935m = e0Arr[i7].f4911a;
                }
                int i9 = 0;
                for (int i10 = 0; i10 < length; i10++) {
                    if (a()) {
                        return;
                    }
                    E0 e1 = e0Arr[i7];
                    p043h3.j jVar = e1.d;
                    if (jVar != null) {
                        do {
                            try {
                                Object objPoll2 = jVar.poll();
                                if (objPoll2 == null) {
                                    z6 = e1.c;
                                    p043h3.j jVar2 = e1.d;
                                    if (z6 && (jVar2 == null || jVar2.isEmpty())) {
                                        f(e1);
                                        if (a()) {
                                            return;
                                        } else {
                                            i9++;
                                        }
                                    }
                                    i7++;
                                    if (i7 == length) {
                                        i7 = 0;
                                    }
                                } else {
                                    i5.onNext(objPoll2);
                                }
                            } catch (Throwable th) {
                                p017c3.d.throwIfFatal(th);
                                p033f3.d.a(e1);
                                p100r3.c cVar2 = this.f4930h;
                                cVar2.getClass();
                                p100r3.g.a(cVar2, th);
                                if (a()) {
                                    return;
                                }
                                f(e1);
                                i9++;
                                i7++;
                                if (i7 == length) {
                                }
                            }
                        } while (!a());
                        return;
                    }
                    z6 = e1.c;
                    p043h3.j jVar3 = e1.d;
                    if (z6) {
                        f(e1);
                        if (a()) {
                            return;
                        } else {
                            i9++;
                        }
                    }
                    i7++;
                    if (i7 == length) {
                        i7 = 0;
                    }
                }
                this.f4936n = i7;
                this.f4935m = e0Arr[i7].f4911a;
                i6 = i9;
            }
            if (i6 == 0) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (this.d != Integer.MAX_VALUE) {
                while (true) {
                    int i11 = i6 - 1;
                    if (i6 != 0) {
                        synchronized (this) {
                            try {
                                io.reactivex.G g6 = (io.reactivex.G) this.f4937o.poll();
                                if (g6 == null) {
                                    this.f4938p--;
                                } else {
                                    g(g6);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        i6 = i11;
                    }
                }
            } else {
                continue;
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f4931i) {
            return;
        }
        this.f4931i = true;
        if (b()) {
            p100r3.c cVar = this.f4930h;
            cVar.getClass();
            Throwable thB = p100r3.g.b(cVar);
            if (thB == null || thB == p100r3.g.f7961a) {
                return;
            }
            io.reactivex.plugins.a.onError(thB);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4931i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(E0 e1) {
        E0[] e0Arr;
        while (true) {
            AtomicReference atomicReference = this.f4932j;
            E0[] e0Arr2 = (E0[]) atomicReference.get();
            int length = e0Arr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (e0Arr2[i5] == e1) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                e0Arr = f4925q;
            } else {
                E0[] e0Arr3 = new E0[length - 1];
                System.arraycopy(e0Arr2, 0, e0Arr3, 0, i5);
                System.arraycopy(e0Arr2, i5 + 1, e0Arr3, i5, (length - i5) - 1);
                e0Arr = e0Arr3;
            }
            while (!atomicReference.compareAndSet(e0Arr2, e0Arr)) {
                if (atomicReference.get() != e0Arr2) {
                }
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(io.reactivex.G g6) {
        boolean z6;
        do {
            z6 = false;
            if (g6 instanceof Callable) {
                try {
                    Object objCall = ((Callable) g6).call();
                    if (objCall != null) {
                        if (get() == 0 && compareAndSet(0, 1)) {
                            this.f4927a.onNext(objCall);
                            if (decrementAndGet() != 0) {
                                d();
                            }
                        } else {
                            p043h3.i dVar = this.f4928f;
                            if (dVar == null) {
                                dVar = this.d == Integer.MAX_VALUE ? new p083o3.d(this.e) : new p083o3.c(this.d);
                                this.f4928f = dVar;
                            }
                            if (dVar.offer(objCall)) {
                                if (getAndIncrement() != 0) {
                                    return;
                                }
                                d();
                            } else {
                                onError(new IllegalStateException("Scalar queue full?!"));
                            }
                        }
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    p100r3.c cVar = this.f4930h;
                    cVar.getClass();
                    p100r3.g.a(cVar, th);
                    c();
                }
                if (this.d == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    try {
                        g6 = (io.reactivex.G) this.f4937o.poll();
                        if (g6 == null) {
                            this.f4938p--;
                            z6 = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } else {
                long j6 = this.f4934l;
                this.f4934l = 1 + j6;
                E0 e1 = new E0(this, j6);
                AtomicReference atomicReference = this.f4932j;
                while (true) {
                    E0[] e0Arr = (E0[]) atomicReference.get();
                    if (e0Arr == f4926r) {
                        p033f3.d.a(e1);
                        return;
                    }
                    int length = e0Arr.length;
                    E0[] e0Arr2 = new E0[length + 1];
                    System.arraycopy(e0Arr, 0, e0Arr2, 0, length);
                    e0Arr2[length] = e1;
                    do {
                        if (atomicReference.compareAndSet(e0Arr, e0Arr2)) {
                            g6.subscribe(e1);
                            return;
                        }
                    } while (atomicReference.get() == e0Arr);
                }
            }
        } while (!z6);
        c();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f4929g) {
            return;
        }
        this.f4929g = true;
        c();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f4929g) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p100r3.c cVar = this.f4930h;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4929g = true;
            c();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f4929g) {
            return;
        }
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null ObservableSource");
            io.reactivex.G g6 = (io.reactivex.G) objApply;
            if (this.d != Integer.MAX_VALUE) {
                synchronized (this) {
                    try {
                        int i5 = this.f4938p;
                        if (i5 == this.d) {
                            this.f4937o.offer(g6);
                            return;
                        }
                        this.f4938p = i5 + 1;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            g(g6);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            this.f4933k.dispose();
            onError(th2);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f4933k, cVar)) {
            this.f4933k = cVar;
            this.f4927a.onSubscribe(this);
        }
    }
}
