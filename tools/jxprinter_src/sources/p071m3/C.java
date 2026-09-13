package p071m3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.plugins.a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends AtomicInteger implements d {
    private static final long serialVersionUID = 3481980673745556697L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f6121a;
    public final B[] b;
    public final List[] c;
    public final int[] d;
    public final Comparator e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f6123g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f6122f = new AtomicLong();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f6124h = new AtomicInteger();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f6125i = new AtomicReference();

    public C(c cVar, int i5, Comparator comparator) {
        this.f6121a = cVar;
        this.e = comparator;
        B[] bArr = new B[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = new B(this, i6);
        }
        this.b = bArr;
        this.c = new List[i5];
        this.d = new int[i5];
        this.f6124h.lazySet(i5);
    }

    public final void a() {
        for (B b : this.b) {
            b.getClass();
            g.a(b);
        }
    }

    public final void b() {
        int i5;
        if (getAndIncrement() != 0) {
            return;
        }
        c cVar = this.f6121a;
        List[] listArr = this.c;
        int[] iArr = this.d;
        int length = iArr.length;
        int i6 = 1;
        while (true) {
            long j6 = this.f6122f.get();
            long j7 = 0;
            while (true) {
                i5 = 0;
                if (j7 != j6) {
                    if (this.f6123g) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th = (Throwable) this.f6125i.get();
                    if (th != null) {
                        a();
                        Arrays.fill(listArr, (Object) null);
                        cVar.onError(th);
                        return;
                    }
                    int i7 = -1;
                    Object obj = null;
                    while (i5 < length) {
                        List list = listArr[i5];
                        int i8 = iArr[i5];
                        if (list.size() != i8) {
                            if (obj == null) {
                                obj = list.get(i8);
                            } else {
                                Object obj2 = list.get(i8);
                                try {
                                    if (this.e.compare(obj, obj2) > 0) {
                                        obj = obj2;
                                    }
                                } catch (Throwable th2) {
                                    p017c3.d.throwIfFatal(th2);
                                    a();
                                    Arrays.fill(listArr, (Object) null);
                                    AtomicReference atomicReference = this.f6125i;
                                    for (boolean z6 = false; !atomicReference.compareAndSet(z6, th2); z6 = false) {
                                        if (atomicReference.get() != null) {
                                            a.onError(th2);
                                            break;
                                        }
                                    }
                                    cVar.onError((Throwable) this.f6125i.get());
                                    return;
                                }
                            }
                            i7 = i5;
                        }
                        i5++;
                    }
                    if (obj == null) {
                        Arrays.fill(listArr, (Object) null);
                        cVar.onComplete();
                        return;
                    } else {
                        cVar.onNext(obj);
                        iArr[i7] = iArr[i7] + 1;
                        j7++;
                    }
                }
            }
            if (j7 == j6) {
                if (this.f6123g) {
                    Arrays.fill(listArr, (Object) null);
                    return;
                }
                Throwable th3 = (Throwable) this.f6125i.get();
                if (th3 != null) {
                    a();
                    Arrays.fill(listArr, (Object) null);
                    cVar.onError(th3);
                    return;
                } else {
                    while (true) {
                        if (i5 >= length) {
                            Arrays.fill(listArr, (Object) null);
                            cVar.onComplete();
                            return;
                        } else if (iArr[i5] != listArr[i5].size()) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            }
            if (j7 != 0 && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f6122f.addAndGet(-j7);
            }
            int iAddAndGet = get();
            if (iAddAndGet == i6 && (iAddAndGet = addAndGet(-i6)) == 0) {
                return;
            } else {
                i6 = iAddAndGet;
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f6123g) {
            return;
        }
        this.f6123g = true;
        a();
        if (getAndIncrement() == 0) {
            Arrays.fill(this.c, (Object) null);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (g.f(j6)) {
            p122v2.a.a(this.f6122f, j6);
            if (this.f6124h.get() == 0) {
                b();
            }
        }
    }
}
