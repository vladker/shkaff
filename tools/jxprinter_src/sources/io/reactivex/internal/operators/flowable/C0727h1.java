package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.h1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0727h1 extends AtomicInteger implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C0721g1[] f4638r = new C0721g1[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C0721g1[] f4639s = new C0721g1[0];
    private static final long serialVersionUID = -2117620485640801370L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4640a;
    public final p027e3.o b;
    public final boolean c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile p043h3.i f4641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p100r3.c f4643h = new p100r3.c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReference f4645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f4646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public t5.d f4647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4649n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4650o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f4652q;

    public C0727h1(int i5, int i6, p027e3.o oVar, t5.c cVar, boolean z6) {
        AtomicReference atomicReference = new AtomicReference();
        this.f4645j = atomicReference;
        this.f4646k = new AtomicLong();
        this.f4640a = cVar;
        this.b = oVar;
        this.c = z6;
        this.d = i5;
        this.e = i6;
        this.f4652q = Math.max(1, i5 >> 1);
        atomicReference.lazySet(f4638r);
    }

    public final boolean a() {
        if (this.f4644i) {
            p043h3.i iVar = this.f4641f;
            if (iVar != null) {
                iVar.clear();
                return true;
            }
        } else {
            if (this.c || this.f4643h.get() == null) {
                return false;
            }
            p043h3.i iVar2 = this.f4641f;
            if (iVar2 != null) {
                iVar2.clear();
            }
            p100r3.c cVar = this.f4643h;
            cVar.getClass();
            Throwable thB = p100r3.g.b(cVar);
            if (thB != p100r3.g.f7961a) {
                this.f4640a.onError(thB);
            }
        }
        return true;
    }

    public final void b() {
        if (getAndIncrement() == 0) {
            c();
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0159  */
    /* JADX WARN: Code duplicated, block: B:114:0x017d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0187  */
    /* JADX WARN: Code duplicated, block: B:120:0x018b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x01be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x01be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x01be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x0193 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x0185 A[EDGE_INSN: B:156:0x0185->B:117:0x0185 BREAK  A[LOOP:3: B:65:0x00dc->B:121:0x018c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x018c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x0140 A[EDGE_INSN: B:163:0x0140->B:94:0x0140 BREAK  A[LOOP:5: B:77:0x00fc->B:85:0x0112], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00de  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:82:0x0107  */
    /* JADX WARN: Code duplicated, block: B:85:0x0112 A[LOOP:5: B:77:0x00fc->B:85:0x0112, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x0144 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0146  */
    /* JADX WARN: Code duplicated, block: B:98:0x014f  */
    public final void c() {
        boolean z6;
        long j6;
        long j7;
        boolean z7;
        long j8;
        int i5;
        boolean z8;
        int i6;
        C0721g1 c0721g1;
        Object objPoll;
        p043h3.j jVar;
        boolean z9;
        Object obj;
        t5.c cVar = this.f4640a;
        int iAddAndGet = 1;
        while (!a()) {
            p043h3.i iVar = this.f4641f;
            long jAddAndGet = this.f4646k.get();
            boolean z10 = jAddAndGet == LocationRequestCompat.PASSIVE_INTERVAL;
            long j9 = 0;
            if (iVar != null) {
                j6 = 0;
                do {
                    long j10 = 0;
                    obj = null;
                    while (true) {
                        if (jAddAndGet == 0) {
                            z6 = true;
                            break;
                        }
                        z6 = true;
                        Object objPoll2 = iVar.poll();
                        if (a()) {
                            return;
                        }
                        if (objPoll2 == null) {
                            obj = objPoll2;
                            break;
                        }
                        cVar.onNext(objPoll2);
                        j6++;
                        j10++;
                        jAddAndGet--;
                        obj = objPoll2;
                    }
                    if (j10 != 0) {
                        jAddAndGet = z10 ? LocationRequestCompat.PASSIVE_INTERVAL : this.f4646k.addAndGet(-j10);
                    }
                    if (jAddAndGet == 0) {
                        break;
                    }
                } while (obj != null);
            } else {
                z6 = true;
                j6 = 0;
            }
            boolean z11 = this.f4642g;
            p043h3.i iVar2 = this.f4641f;
            C0721g1[] c0721g1Arr = (C0721g1[]) this.f4645j.get();
            int length = c0721g1Arr.length;
            if (z11 && ((iVar2 == null || iVar2.isEmpty()) && length == 0)) {
                p100r3.c cVar2 = this.f4643h;
                cVar2.getClass();
                Throwable thB = p100r3.g.b(cVar2);
                if (thB != p100r3.g.f7961a) {
                    if (thB == null) {
                        cVar.onComplete();
                        return;
                    } else {
                        cVar.onError(thB);
                        return;
                    }
                }
                return;
            }
            if (length != 0) {
                long j11 = this.f4649n;
                int i7 = this.f4650o;
                if (length > i7) {
                    j8 = 1;
                    if (c0721g1Arr[i7].f4628a != j11) {
                    }
                    i5 = i7;
                    z8 = false;
                    i6 = 0;
                    while (true) {
                        if (i6 < length) {
                            c0721g1Arr = c0721g1Arr;
                            j7 = j9;
                            break;
                        }
                        if (a()) {
                            return;
                        }
                        c0721g1 = c0721g1Arr[i5];
                        objPoll = null;
                        while (!a()) {
                            jVar = c0721g1.f4629f;
                            if (jVar == null) {
                                c0721g1Arr = c0721g1Arr;
                                j7 = j9;
                            } else {
                                j7 = j9;
                                while (jAddAndGet != j7) {
                                    try {
                                        objPoll = jVar.poll();
                                        if (objPoll == null) {
                                            break;
                                        }
                                        cVar.onNext(objPoll);
                                        if (a()) {
                                            return;
                                        }
                                        jAddAndGet -= j8;
                                        j9 += j8;
                                    } catch (Throwable th) {
                                        p017c3.d.throwIfFatal(th);
                                        p094q3.g.a(c0721g1);
                                        p100r3.c cVar3 = this.f4643h;
                                        cVar3.getClass();
                                        p100r3.g.a(cVar3, th);
                                        if (!this.c) {
                                            this.f4647l.cancel();
                                        }
                                        if (a()) {
                                            return;
                                        }
                                        e(c0721g1);
                                        i6++;
                                        c0721g1Arr = c0721g1Arr;
                                        z8 = z6;
                                    }
                                }
                                if (j9 != j7) {
                                    if (z10) {
                                        jAddAndGet = LocationRequestCompat.PASSIVE_INTERVAL;
                                    } else {
                                        jAddAndGet = this.f4646k.addAndGet(-j9);
                                    }
                                    c0721g1.a(j9);
                                } else {
                                    c0721g1Arr = c0721g1Arr;
                                }
                                if (jAddAndGet == j7 && objPoll != null) {
                                    c0721g1Arr = c0721g1Arr;
                                    j9 = j7;
                                }
                            }
                            z9 = c0721g1.e;
                            p043h3.j jVar2 = c0721g1.f4629f;
                            if (z9 && (jVar2 == null || jVar2.isEmpty())) {
                                e(c0721g1);
                                if (a()) {
                                    return;
                                }
                                j6 += j8;
                                z8 = z6;
                            }
                            if (jAddAndGet == j7) {
                                break;
                            }
                            i5++;
                            if (i5 == length) {
                                i5 = 0;
                            }
                            i6++;
                            c0721g1Arr = c0721g1Arr;
                            j9 = j7;
                        }
                        return;
                    }
                    z7 = z8;
                    this.f4650o = i5;
                    this.f4649n = c0721g1Arr[i5].f4628a;
                } else {
                    j8 = 1;
                }
                if (length <= i7) {
                    i7 = 0;
                }
                for (int i8 = 0; i8 < length && c0721g1Arr[i7].f4628a != j11; i8++) {
                    i7++;
                    if (i7 == length) {
                        i7 = 0;
                    }
                }
                this.f4650o = i7;
                this.f4649n = c0721g1Arr[i7].f4628a;
                i5 = i7;
                z8 = false;
                i6 = 0;
                while (true) {
                    if (i6 < length) {
                        c0721g1Arr = c0721g1Arr;
                        j7 = j9;
                        break;
                    }
                    if (a()) {
                        return;
                    }
                    c0721g1 = c0721g1Arr[i5];
                    objPoll = null;
                    while (!a()) {
                        jVar = c0721g1.f4629f;
                        if (jVar == null) {
                            c0721g1Arr = c0721g1Arr;
                            j7 = j9;
                        } else {
                            j7 = j9;
                            while (jAddAndGet != j7) {
                                objPoll = jVar.poll();
                                if (objPoll == null) {
                                    break;
                                    break;
                                }
                                cVar.onNext(objPoll);
                                if (a()) {
                                    return;
                                }
                                jAddAndGet -= j8;
                                j9 += j8;
                            }
                            if (j9 != j7) {
                                if (z10) {
                                    jAddAndGet = this.f4646k.addAndGet(-j9);
                                } else {
                                    jAddAndGet = LocationRequestCompat.PASSIVE_INTERVAL;
                                }
                                c0721g1.a(j9);
                            } else {
                                c0721g1Arr = c0721g1Arr;
                            }
                            if (jAddAndGet == j7) {
                            }
                        }
                        z9 = c0721g1.e;
                        p043h3.j jVar3 = c0721g1.f4629f;
                        if (z9) {
                            e(c0721g1);
                            if (a()) {
                                return;
                            }
                            j6 += j8;
                            z8 = z6;
                        }
                        if (jAddAndGet == j7) {
                            break;
                            break;
                        }
                        i5++;
                        if (i5 == length) {
                            i5 = 0;
                        }
                        i6++;
                        c0721g1Arr = c0721g1Arr;
                        j9 = j7;
                    }
                    return;
                }
                z7 = z8;
                this.f4650o = i5;
                this.f4649n = c0721g1Arr[i5].f4628a;
            } else {
                j7 = 0;
                z7 = false;
            }
            long j12 = j6;
            if (j12 != j7 && !this.f4644i) {
                this.f4647l.request(j12);
            }
            if (!z7 && (iAddAndGet = addAndGet(-iAddAndGet)) == 0) {
                return;
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        p043h3.i iVar;
        C0721g1[] c0721g1Arr;
        if (this.f4644i) {
            return;
        }
        this.f4644i = true;
        this.f4647l.cancel();
        AtomicReference atomicReference = this.f4645j;
        C0721g1[] c0721g1Arr2 = (C0721g1[]) atomicReference.get();
        C0721g1[] c0721g1Arr3 = f4639s;
        if (c0721g1Arr2 != c0721g1Arr3 && (c0721g1Arr = (C0721g1[]) atomicReference.getAndSet(c0721g1Arr3)) != c0721g1Arr3) {
            for (C0721g1 c0721g1 : c0721g1Arr) {
                c0721g1.getClass();
                p094q3.g.a(c0721g1);
            }
            p100r3.c cVar = this.f4643h;
            cVar.getClass();
            Throwable thB = p100r3.g.b(cVar);
            if (thB != null && thB != p100r3.g.f7961a) {
                io.reactivex.plugins.a.onError(thB);
            }
        }
        if (getAndIncrement() != 0 || (iVar = this.f4641f) == null) {
            return;
        }
        iVar.clear();
    }

    public final p043h3.i d() {
        p043h3.i dVar = this.f4641f;
        if (dVar == null) {
            dVar = this.d == Integer.MAX_VALUE ? new p083o3.d(this.e) : new p083o3.c(this.d);
            this.f4641f = dVar;
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(C0721g1 c0721g1) {
        C0721g1[] c0721g1Arr;
        while (true) {
            AtomicReference atomicReference = this.f4645j;
            C0721g1[] c0721g1Arr2 = (C0721g1[]) atomicReference.get();
            int length = c0721g1Arr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (c0721g1Arr2[i5] == c0721g1) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                c0721g1Arr = f4638r;
            } else {
                C0721g1[] c0721g1Arr3 = new C0721g1[length - 1];
                System.arraycopy(c0721g1Arr2, 0, c0721g1Arr3, 0, i5);
                System.arraycopy(c0721g1Arr2, i5 + 1, c0721g1Arr3, i5, (length - i5) - 1);
                c0721g1Arr = c0721g1Arr3;
            }
            while (!atomicReference.compareAndSet(c0721g1Arr2, c0721g1Arr)) {
                if (atomicReference.get() != c0721g1Arr2) {
                }
            }
            return;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4642g) {
            return;
        }
        this.f4642g = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4642g) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p100r3.c cVar = this.f4643h;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4642g = true;
            b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4642g) {
            return;
        }
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null Publisher");
            t5.b bVar = (t5.b) objApply;
            if (bVar instanceof Callable) {
                try {
                    Object objCall = ((Callable) bVar).call();
                    if (objCall == null) {
                        if (this.d == Integer.MAX_VALUE || this.f4644i) {
                            return;
                        }
                        int i5 = this.f4651p + 1;
                        this.f4651p = i5;
                        int i6 = this.f4652q;
                        if (i5 == i6) {
                            this.f4651p = 0;
                            this.f4647l.request(i6);
                            return;
                        }
                        return;
                    }
                    if (get() == 0 && compareAndSet(0, 1)) {
                        long j6 = this.f4646k.get();
                        p043h3.i iVarD = this.f4641f;
                        if (j6 == 0 || !(iVarD == null || iVarD.isEmpty())) {
                            if (iVarD == null) {
                                iVarD = d();
                            }
                            if (!iVarD.offer(objCall)) {
                                onError(new IllegalStateException("Scalar queue full?!"));
                                return;
                            }
                        } else {
                            this.f4640a.onNext(objCall);
                            if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                                this.f4646k.decrementAndGet();
                            }
                            if (this.d != Integer.MAX_VALUE && !this.f4644i) {
                                int i7 = this.f4651p + 1;
                                this.f4651p = i7;
                                int i8 = this.f4652q;
                                if (i7 == i8) {
                                    this.f4651p = 0;
                                    this.f4647l.request(i8);
                                }
                            }
                        }
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } else if (!d().offer(objCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    } else if (getAndIncrement() != 0) {
                        return;
                    }
                    c();
                    return;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    p100r3.c cVar = this.f4643h;
                    cVar.getClass();
                    p100r3.g.a(cVar, th);
                    b();
                    return;
                }
            }
            long j7 = this.f4648m;
            this.f4648m = 1 + j7;
            C0721g1 c0721g1 = new C0721g1(this, j7);
            AtomicReference atomicReference = this.f4645j;
            while (true) {
                C0721g1[] c0721g1Arr = (C0721g1[]) atomicReference.get();
                if (c0721g1Arr == f4639s) {
                    p094q3.g.a(c0721g1);
                    return;
                }
                int length = c0721g1Arr.length;
                C0721g1[] c0721g1Arr2 = new C0721g1[length + 1];
                System.arraycopy(c0721g1Arr, 0, c0721g1Arr2, 0, length);
                c0721g1Arr2[length] = c0721g1;
                do {
                    if (atomicReference.compareAndSet(c0721g1Arr, c0721g1Arr2)) {
                        bVar.subscribe(c0721g1);
                        return;
                    }
                } while (atomicReference.get() == c0721g1Arr);
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            this.f4647l.cancel();
            onError(th2);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4647l, dVar)) {
            this.f4647l = dVar;
            this.f4640a.onSubscribe(this);
            if (this.f4644i) {
                return;
            }
            int i5 = this.d;
            if (i5 == Integer.MAX_VALUE) {
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                dVar.request(i5);
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4646k, j6);
            b();
        }
    }
}
