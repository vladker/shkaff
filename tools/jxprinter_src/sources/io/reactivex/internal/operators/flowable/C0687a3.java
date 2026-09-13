package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.a3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0687a3 extends AbstractC0979l implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0693b3[] f4544l = new C0693b3[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0693b3[] f4545m = new C0693b3[0];
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile p043h3.j f4547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f4550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4551k;
    public final AtomicInteger b = new AtomicInteger();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f4546f = new AtomicReference();
    public final AtomicReference c = new AtomicReference(f4544l);

    public C0687a3(int i5) {
        this.d = i5;
        this.e = i5 - (i5 >> 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        C0693b3 c0693b3 = new C0693b3(cVar, this);
        cVar.onSubscribe(c0693b3);
        while (true) {
            AtomicReference atomicReference = this.c;
            C0693b3[] c0693b3Arr = (C0693b3[]) atomicReference.get();
            if (c0693b3Arr == f4545m) {
                Throwable th = this.f4550j;
                if (th != null) {
                    cVar.onError(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            int length = c0693b3Arr.length;
            C0693b3[] c0693b3Arr2 = new C0693b3[length + 1];
            System.arraycopy(c0693b3Arr, 0, c0693b3Arr2, 0, length);
            c0693b3Arr2[length] = c0693b3;
            do {
                if (atomicReference.compareAndSet(c0693b3Arr, c0693b3Arr2)) {
                    if (c0693b3.get() == Long.MIN_VALUE) {
                        k(c0693b3);
                        return;
                    } else {
                        i();
                        return;
                    }
                }
            } while (atomicReference.get() == c0693b3Arr);
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p043h3.j jVar;
        p094q3.g.a(this.f4546f);
        if (this.b.getAndIncrement() != 0 || (jVar = this.f4547g) == null) {
            return;
        }
        jVar.clear();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4546f.get() == p094q3.g.f7849a;
    }

    public final void g() {
        for (C0693b3 c0693b3 : (C0693b3[]) this.c.getAndSet(f4545m)) {
            if (c0693b3.get() != Long.MIN_VALUE) {
                c0693b3.f4571a.onComplete();
            }
        }
    }

    public final void i() {
        AtomicReference atomicReference;
        Throwable th;
        Throwable th2;
        if (this.b.getAndIncrement() != 0) {
            return;
        }
        p043h3.j jVar = this.f4547g;
        int i5 = this.f4551k;
        int i6 = this.e;
        boolean z6 = this.f4548h != 1;
        AtomicReference atomicReference2 = this.c;
        C0693b3[] c0693b3Arr = (C0693b3[]) atomicReference2.get();
        int iAddAndGet = 1;
        while (true) {
            int length = c0693b3Arr.length;
            if (jVar == null || length == 0) {
                atomicReference = atomicReference2;
            } else {
                int length2 = c0693b3Arr.length;
                long j6 = LocationRequestCompat.PASSIVE_INTERVAL;
                long j7 = Long.MAX_VALUE;
                int i7 = 0;
                while (i7 < length2) {
                    C0693b3 c0693b3 = c0693b3Arr[i7];
                    AtomicReference atomicReference3 = atomicReference2;
                    long j8 = c0693b3.get() - c0693b3.c;
                    if (j8 == Long.MIN_VALUE) {
                        length--;
                    } else if (j7 > j8) {
                        j7 = j8;
                    }
                    i7++;
                    atomicReference2 = atomicReference3;
                }
                atomicReference = atomicReference2;
                long j9 = 0;
                if (length == 0) {
                    j7 = 0;
                }
                while (true) {
                    if (j7 != j9) {
                        if (e()) {
                            jVar.clear();
                            return;
                        }
                        boolean z7 = this.f4549i;
                        if (z7 && (th2 = this.f4550j) != null) {
                            j(th2);
                            return;
                        }
                        try {
                            Object objPoll = jVar.poll();
                            boolean z8 = objPoll == null;
                            if (z7 && z8) {
                                Throwable th3 = this.f4550j;
                                if (th3 != null) {
                                    j(th3);
                                    return;
                                } else {
                                    g();
                                    return;
                                }
                            }
                            if (!z8) {
                                int length3 = c0693b3Arr.length;
                                int i8 = 0;
                                boolean z9 = false;
                                while (i8 < length3) {
                                    C0693b3 c0693b4 = c0693b3Arr[i8];
                                    long j10 = c0693b4.get();
                                    if (j10 != Long.MIN_VALUE) {
                                        if (j10 != j6) {
                                            c0693b4.c++;
                                        }
                                        c0693b4.f4571a.onNext(objPoll);
                                    } else {
                                        z9 = true;
                                    }
                                    i8++;
                                    j6 = LocationRequestCompat.PASSIVE_INTERVAL;
                                }
                                j7--;
                                if (z6 && (i5 = i5 + 1) == i6) {
                                    ((t5.d) this.f4546f.get()).request(i6);
                                    i5 = 0;
                                }
                                C0693b3[] c0693b3Arr2 = (C0693b3[]) atomicReference.get();
                                if (z9 || c0693b3Arr2 != c0693b3Arr) {
                                    c0693b3Arr = c0693b3Arr2;
                                } else {
                                    j9 = 0;
                                    j6 = LocationRequestCompat.PASSIVE_INTERVAL;
                                }
                            }
                            atomicReference2 = atomicReference;
                        } catch (Throwable th4) {
                            p017c3.d.throwIfFatal(th4);
                            p094q3.g.a(this.f4546f);
                            j(th4);
                            return;
                        }
                    }
                    if (j7 == j9) {
                        if (e()) {
                            jVar.clear();
                            return;
                        }
                        boolean z10 = this.f4549i;
                        if (z10 && (th = this.f4550j) != null) {
                            j(th);
                            return;
                        }
                        if (z10 && jVar.isEmpty()) {
                            Throwable th5 = this.f4550j;
                            if (th5 != null) {
                                j(th5);
                                return;
                            } else {
                                g();
                                return;
                            }
                        }
                    }
                }
            }
            this.f4551k = i5;
            iAddAndGet = this.b.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            if (jVar == null) {
                jVar = this.f4547g;
            }
            c0693b3Arr = (C0693b3[]) atomicReference.get();
            atomicReference2 = atomicReference;
        }
    }

    public final void j(Throwable th) {
        for (C0693b3 c0693b3 : (C0693b3[]) this.c.getAndSet(f4545m)) {
            if (c0693b3.get() != Long.MIN_VALUE) {
                c0693b3.f4571a.onError(th);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(C0693b3 c0693b3) {
        C0693b3[] c0693b3Arr;
        while (true) {
            AtomicReference atomicReference = this.c;
            C0693b3[] c0693b3Arr2 = (C0693b3[]) atomicReference.get();
            int length = c0693b3Arr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (c0693b3Arr2[i5] == c0693b3) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                c0693b3Arr = f4544l;
            } else {
                C0693b3[] c0693b3Arr3 = new C0693b3[length - 1];
                System.arraycopy(c0693b3Arr2, 0, c0693b3Arr3, 0, i5);
                System.arraycopy(c0693b3Arr2, i5 + 1, c0693b3Arr3, i5, (length - i5) - 1);
                c0693b3Arr = c0693b3Arr3;
            }
            while (!atomicReference.compareAndSet(c0693b3Arr2, c0693b3Arr)) {
                if (atomicReference.get() != c0693b3Arr2) {
                }
            }
            return;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4549i) {
            return;
        }
        this.f4549i = true;
        i();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4549i) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4550j = th;
        this.f4549i = true;
        i();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4549i) {
            return;
        }
        if (this.f4548h != 0 || this.f4547g.offer(obj)) {
            i();
        } else {
            ((t5.d) this.f4546f.get()).cancel();
            onError(new p017c3.e());
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this.f4546f, dVar)) {
            boolean z6 = dVar instanceof p043h3.g;
            long j6 = LocationRequestCompat.PASSIVE_INTERVAL;
            if (z6) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(3);
                if (iC == 1) {
                    this.f4548h = iC;
                    this.f4547g = gVar;
                    this.f4549i = true;
                    i();
                    return;
                }
                if (iC == 2) {
                    this.f4548h = iC;
                    this.f4547g = gVar;
                    int i5 = this.d;
                    if (i5 >= 0) {
                        j6 = i5;
                    }
                    dVar.request(j6);
                    return;
                }
            }
            int i6 = this.d;
            this.f4547g = i6 < 0 ? new p083o3.d(-i6) : new p083o3.c(i6);
            int i7 = this.d;
            if (i7 >= 0) {
                j6 = i7;
            }
            dVar.request(j6);
        }
    }
}
