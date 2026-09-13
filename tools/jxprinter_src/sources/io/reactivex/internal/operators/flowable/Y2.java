package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y2 extends AtomicInteger implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final X2[] f4520i = new X2[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final X2[] f4521j = new X2[0];
    private static final long serialVersionUID = -202316842419149694L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f4522a;
    public final int b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Serializable f4523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile p043h3.j f4525h;
    public final AtomicReference e = new AtomicReference();
    public final AtomicReference c = new AtomicReference(f4520i);
    public final AtomicBoolean d = new AtomicBoolean();

    public Y2(AtomicReference atomicReference, int i5) {
        this.f4522a = atomicReference;
        this.b = i5;
    }

    public final boolean a(Object obj, boolean z6) {
        int i5 = 0;
        if (obj != null) {
            boolean zC = p100r3.n.c(obj);
            X2[] x2Arr = f4521j;
            AtomicReference atomicReference = this.c;
            AtomicReference atomicReference2 = this.f4522a;
            if (!zC) {
                Throwable th = ((p100r3.l) obj).f7966a;
                while (!atomicReference2.compareAndSet(this, null) && atomicReference2.get() == this) {
                }
                X2[] x2Arr2 = (X2[]) atomicReference.getAndSet(x2Arr);
                if (x2Arr2.length != 0) {
                    int length = x2Arr2.length;
                    while (i5 < length) {
                        x2Arr2[i5].f4508a.onError(th);
                        i5++;
                    }
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                return true;
            }
            if (z6) {
                while (!atomicReference2.compareAndSet(this, null) && atomicReference2.get() == this) {
                }
                X2[] x2Arr3 = (X2[]) atomicReference.getAndSet(x2Arr);
                int length2 = x2Arr3.length;
                while (i5 < length2) {
                    x2Arr3[i5].f4508a.onComplete();
                    i5++;
                }
                return true;
            }
        }
        return false;
    }

    public final void b() {
        boolean z6;
        Object objPoll;
        X2[] x2Arr;
        Object objPoll2;
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.c;
        boolean z7 = true;
        X2[] x2Arr2 = (X2[]) atomicReference.get();
        int iAddAndGet = 1;
        while (true) {
            Object obj = this.f4523f;
            p043h3.j jVar = this.f4525h;
            boolean z8 = (jVar == null || jVar.isEmpty()) ? z7 : false;
            if (a(obj, z8)) {
                return;
            }
            if (z8) {
                z6 = z7;
            } else {
                int length = x2Arr2.length;
                int i5 = 0;
                long jMin = LocationRequestCompat.PASSIVE_INTERVAL;
                for (X2 x6 : x2Arr2) {
                    long j6 = x6.get();
                    if (j6 != Long.MIN_VALUE) {
                        jMin = Math.min(jMin, j6 - x6.c);
                    } else {
                        i5++;
                    }
                }
                long j7 = 1;
                if (length == i5) {
                    Object obj2 = this.f4523f;
                    try {
                        objPoll = jVar.poll();
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        ((t5.d) this.e.get()).cancel();
                        p100r3.l lVar = new p100r3.l(th);
                        this.f4523f = lVar;
                        obj2 = lVar;
                        objPoll = null;
                    }
                    if (a(obj2, objPoll == null ? z7 : false)) {
                        return;
                    }
                    if (this.f4524g != z7) {
                        ((t5.d) this.e.get()).request(1L);
                    }
                    z6 = z7;
                    x2Arr = x2Arr2;
                } else {
                    int i6 = 0;
                    while (true) {
                        long j8 = i6;
                        if (j8 < jMin) {
                            Object obj3 = this.f4523f;
                            try {
                                objPoll2 = jVar.poll();
                            } catch (Throwable th2) {
                                p017c3.d.throwIfFatal(th2);
                                ((t5.d) this.e.get()).cancel();
                                p100r3.l lVar2 = new p100r3.l(th2);
                                this.f4523f = lVar2;
                                obj3 = lVar2;
                                objPoll2 = null;
                            }
                            boolean z9 = objPoll2 == null ? z7 : false;
                            if (a(obj3, z9)) {
                                return;
                            }
                            if (z9) {
                                z8 = z9;
                            } else {
                                int length2 = x2Arr2.length;
                                int i7 = 0;
                                boolean z10 = false;
                                while (i7 < length2) {
                                    long j9 = j7;
                                    X2 x7 = x2Arr2[i7];
                                    long j10 = x7.get();
                                    if (j10 != Long.MIN_VALUE) {
                                        if (j10 != LocationRequestCompat.PASSIVE_INTERVAL) {
                                            x7.c += j9;
                                        }
                                        x7.f4508a.onNext(objPoll2);
                                    } else {
                                        z10 = true;
                                    }
                                    i7++;
                                    x2Arr2 = x2Arr2;
                                    j7 = j9;
                                }
                                X2[] x2Arr3 = x2Arr2;
                                long j11 = j7;
                                i6++;
                                X2[] x2Arr4 = (X2[]) atomicReference.get();
                                if (z10 || x2Arr4 != x2Arr3) {
                                    if (i6 != 0 && this.f4524g != 1) {
                                        ((t5.d) this.e.get()).request(i6);
                                    }
                                    x2Arr2 = x2Arr4;
                                    z7 = true;
                                } else {
                                    x2Arr2 = x2Arr3;
                                    z8 = z9;
                                    j7 = j11;
                                    z7 = true;
                                }
                            }
                        }
                        x2Arr = x2Arr2;
                        if (i6 != 0) {
                            z6 = true;
                            if (this.f4524g != 1) {
                                ((t5.d) this.e.get()).request(j8);
                            }
                        } else {
                            z6 = true;
                        }
                        if (jMin == 0 || z8) {
                        }
                        z7 = z6;
                    }
                }
                x2Arr2 = x2Arr;
                z7 = z6;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            x2Arr2 = (X2[]) atomicReference.get();
            z7 = z6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(X2 x6) {
        X2[] x2Arr;
        while (true) {
            AtomicReference atomicReference = this.c;
            X2[] x2Arr2 = (X2[]) atomicReference.get();
            int length = x2Arr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (x2Arr2[i5].equals(x6)) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                x2Arr = f4520i;
            } else {
                X2[] x2Arr3 = new X2[length - 1];
                System.arraycopy(x2Arr2, 0, x2Arr3, 0, i5);
                System.arraycopy(x2Arr2, i5 + 1, x2Arr3, i5, (length - i5) - 1);
                x2Arr = x2Arr3;
            }
            while (!atomicReference.compareAndSet(x2Arr2, x2Arr)) {
                if (atomicReference.get() != x2Arr2) {
                }
            }
            return;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.c;
        Object obj = atomicReference2.get();
        Object obj2 = f4521j;
        if (obj == obj2 || ((X2[]) atomicReference2.getAndSet(obj2)) == obj2) {
            return;
        }
        do {
            atomicReference = this.f4522a;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        p094q3.g.a(this.e);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.get() == f4521j;
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4523f == null) {
            this.f4523f = p100r3.n.f7968a;
            b();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4523f != null) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4523f = new p100r3.l(th);
            b();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4524g != 0 || this.f4525h.offer(obj)) {
            b();
        } else {
            onError(new p017c3.e("Prefetch queue is full?!"));
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this.e, dVar)) {
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(7);
                if (iC == 1) {
                    this.f4524g = iC;
                    this.f4525h = gVar;
                    this.f4523f = p100r3.n.f7968a;
                    b();
                    return;
                }
                if (iC == 2) {
                    this.f4524g = iC;
                    this.f4525h = gVar;
                    dVar.request(this.b);
                    return;
                }
            }
            this.f4525h = new p083o3.c(this.b);
            dVar.request(this.b);
        }
    }
}
