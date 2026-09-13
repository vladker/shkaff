package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K extends AbstractC0683a implements InterfaceC0984q {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final J[] f4309l = new J[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final J[] f4310m = new J[0];
    public final AtomicBoolean c;
    public final int d;
    public final AtomicReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f4311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final L0.j f4312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public L0.j f4313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f4315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4316k;

    public K(AbstractC0979l abstractC0979l, int i5) {
        super(abstractC0979l);
        this.d = i5;
        this.c = new AtomicBoolean();
        L0.j jVar = new L0.j(i5, 1);
        this.f4312g = jVar;
        this.f4313h = jVar;
        this.e = new AtomicReference(f4309l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        J j6 = new J(cVar, this);
        cVar.onSubscribe(j6);
        loop0: while (true) {
            AtomicReference atomicReference = this.e;
            J[] jArr = (J[]) atomicReference.get();
            if (jArr == f4310m) {
                break;
            }
            int length = jArr.length;
            J[] jArr2 = new J[length + 1];
            System.arraycopy(jArr, 0, jArr2, 0, length);
            jArr2[length] = j6;
            do {
                if (atomicReference.compareAndSet(jArr, jArr2)) {
                    break loop0;
                }
            } while (atomicReference.get() == jArr);
        }
        AtomicBoolean atomicBoolean = this.c;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            g(j6);
        } else {
            this.b.subscribe((InterfaceC0984q) this);
        }
    }

    public final void g(J j6) {
        if (j6.getAndIncrement() != 0) {
            return;
        }
        long j7 = j6.f4297f;
        int i5 = j6.e;
        L0.j jVar = j6.d;
        AtomicLong atomicLong = j6.c;
        t5.c cVar = j6.f4296a;
        int i6 = this.d;
        int iAddAndGet = 1;
        while (true) {
            boolean z6 = this.f4316k;
            boolean z7 = this.f4311f == j7;
            if (z6 && z7) {
                j6.d = null;
                Throwable th = this.f4315j;
                if (th != null) {
                    cVar.onError(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            if (!z7) {
                long j8 = atomicLong.get();
                if (j8 == Long.MIN_VALUE) {
                    j6.d = null;
                    return;
                } else if (j8 != j7) {
                    if (i5 == i6) {
                        jVar = (L0.j) jVar.b;
                        i5 = 0;
                    }
                    cVar.onNext(((Object[]) jVar.f404a)[i5]);
                    i5++;
                    j7++;
                }
            }
            j6.f4297f = j7;
            j6.e = i5;
            j6.d = jVar;
            iAddAndGet = j6.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4316k = true;
        for (J j6 : (J[]) this.e.getAndSet(f4310m)) {
            g(j6);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4316k) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4315j = th;
        this.f4316k = true;
        for (J j6 : (J[]) this.e.getAndSet(f4310m)) {
            g(j6);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        int i5 = this.f4314i;
        if (i5 == this.d) {
            L0.j jVar = new L0.j(i5, 1);
            ((Object[]) jVar.f404a)[0] = obj;
            this.f4314i = 1;
            this.f4313h.b = jVar;
            this.f4313h = jVar;
        } else {
            ((Object[]) this.f4313h.f404a)[i5] = obj;
            this.f4314i = i5 + 1;
        }
        this.f4311f++;
        for (J j6 : (J[]) this.e.get()) {
            g(j6);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
