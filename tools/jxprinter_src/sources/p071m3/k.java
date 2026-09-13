package p071m3;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import p017c3.e;
import p043h3.j;
import p094q3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends AtomicInteger implements InterfaceC0984q {
    private static final long serialVersionUID = -4470634016609963609L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c[] f6138a;
    public final AtomicLongArray b;
    public final long[] c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f6139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f6140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Throwable f6141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f6142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f6144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f6145l = new AtomicInteger();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6146m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6147n;

    public k(c[] cVarArr, int i5) {
        this.f6138a = cVarArr;
        this.d = i5;
        this.e = i5 - (i5 >> 2);
        int length = cVarArr.length;
        int i6 = length + length;
        AtomicLongArray atomicLongArray = new AtomicLongArray(i6 + 1);
        this.b = atomicLongArray;
        atomicLongArray.lazySet(i6, length);
        this.c = new long[length];
    }

    public final void a() {
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        long j6 = 1;
        long j7 = 0;
        int i5 = 0;
        if (this.f6147n == 1) {
            j jVar = this.f6140g;
            c[] cVarArr = this.f6138a;
            AtomicLongArray atomicLongArray = this.b;
            long[] jArr = this.c;
            int length = jArr.length;
            int i6 = this.f6143j;
            int iAddAndGet = 1;
            while (true) {
                int i7 = 0;
                do {
                    if (this.f6144k) {
                        jVar.clear();
                        return;
                    }
                    if (jVar.isEmpty()) {
                        int length2 = cVarArr.length;
                        while (i5 < length2) {
                            cVarArr[i5].onComplete();
                            i5++;
                        }
                        return;
                    }
                    long j8 = atomicLongArray.get(i6);
                    long j9 = jArr[i6];
                    if (j8 == j9 || atomicLongArray.get(length + i6) != 0) {
                        i7++;
                    } else {
                        try {
                            Object objPoll = jVar.poll();
                            if (objPoll == null) {
                                int length3 = cVarArr.length;
                                while (i5 < length3) {
                                    cVarArr[i5].onComplete();
                                    i5++;
                                }
                                return;
                            }
                            cVarArr[i6].onNext(objPoll);
                            jArr[i6] = j9 + 1;
                            i7 = 0;
                        } catch (Throwable th2) {
                            p017c3.d.throwIfFatal(th2);
                            this.f6139f.cancel();
                            int length4 = cVarArr.length;
                            while (i5 < length4) {
                                cVarArr[i5].onError(th2);
                                i5++;
                            }
                            return;
                        }
                    }
                    i6++;
                    if (i6 == length) {
                        i6 = 0;
                    }
                } while (i7 != length);
                int i8 = get();
                if (i8 == iAddAndGet) {
                    this.f6143j = i6;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i8;
                }
            }
        } else {
            j jVar2 = this.f6140g;
            c[] cVarArr2 = this.f6138a;
            AtomicLongArray atomicLongArray2 = this.b;
            long[] jArr2 = this.c;
            int length5 = jArr2.length;
            int i9 = this.f6143j;
            int i10 = this.f6146m;
            int i11 = 1;
            while (true) {
                long j10 = j6;
                int i12 = 0;
                while (true) {
                    if (this.f6144k) {
                        jVar2.clear();
                        return;
                    }
                    boolean z6 = this.f6142i;
                    if (z6 && (th = this.f6141h) != null) {
                        jVar2.clear();
                        int length6 = cVarArr2.length;
                        while (i5 < length6) {
                            cVarArr2[i5].onError(th);
                            i5++;
                        }
                        return;
                    }
                    boolean zIsEmpty = jVar2.isEmpty();
                    if (z6 && zIsEmpty) {
                        int length7 = cVarArr2.length;
                        while (i5 < length7) {
                            cVarArr2[i5].onComplete();
                            i5++;
                        }
                        return;
                    }
                    if (zIsEmpty) {
                        break;
                    }
                    long j11 = atomicLongArray2.get(i9);
                    long j12 = jArr2[i9];
                    if (j11 == j12 || atomicLongArray2.get(length5 + i9) != j7) {
                        i12++;
                    } else {
                        try {
                            Object objPoll2 = jVar2.poll();
                            if (objPoll2 == null) {
                                break;
                            }
                            cVarArr2[i9].onNext(objPoll2);
                            jArr2[i9] = j12 + j10;
                            i10++;
                            if (i10 == this.e) {
                                this.f6139f.request(i10);
                                i10 = 0;
                            }
                            i12 = 0;
                        } catch (Throwable th3) {
                            p017c3.d.throwIfFatal(th3);
                            this.f6139f.cancel();
                            int length8 = cVarArr2.length;
                            while (i5 < length8) {
                                cVarArr2[i5].onError(th3);
                                i5++;
                            }
                            return;
                        }
                    }
                    i9++;
                    if (i9 == length5) {
                        i9 = 0;
                    }
                    if (i12 == length5) {
                        break;
                    } else {
                        j7 = 0;
                    }
                }
                int iAddAndGet2 = get();
                if (iAddAndGet2 == i11) {
                    this.f6143j = i9;
                    this.f6146m = i10;
                    iAddAndGet2 = addAndGet(-i11);
                    if (iAddAndGet2 == 0) {
                        return;
                    }
                }
                i11 = iAddAndGet2;
                j6 = j10;
                j7 = 0;
            }
        }
    }

    public final void b() {
        c[] cVarArr = this.f6138a;
        int length = cVarArr.length;
        int i5 = 0;
        while (i5 < length && !this.f6144k) {
            int i6 = i5 + 1;
            this.f6145l.lazySet(i6);
            cVarArr[i5].onSubscribe(new j(this, i5, length));
            i5 = i6;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f6142i = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f6141h = th;
        this.f6142i = true;
        a();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f6147n != 0 || this.f6140g.offer(obj)) {
            a();
        } else {
            this.f6139f.cancel();
            onError(new e("Queue is full?"));
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.f6139f, dVar)) {
            this.f6139f = dVar;
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(7);
                if (iC == 1) {
                    this.f6147n = iC;
                    this.f6140g = gVar;
                    this.f6142i = true;
                    b();
                    a();
                    return;
                }
                if (iC == 2) {
                    this.f6147n = iC;
                    this.f6140g = gVar;
                    b();
                    dVar.request(this.d);
                    return;
                }
            }
            this.f6140g = new p083o3.c(this.d);
            b();
            dVar.request(this.d);
        }
    }
}
