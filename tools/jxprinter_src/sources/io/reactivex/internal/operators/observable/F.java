package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F extends AbstractC0838a implements io.reactivex.I {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final E[] f4918k = new E[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final E[] f4919l = new E[0];
    public final AtomicBoolean b;
    public final int c;
    public final AtomicReference d;
    public volatile long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final L0.j f4920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public L0.j f4921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Throwable f4923i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4924j;

    public F(io.reactivex.B b, int i5) {
        super(b);
        this.c = i5;
        this.b = new AtomicBoolean();
        L0.j jVar = new L0.j(i5, 2);
        this.f4920f = jVar;
        this.f4921g = jVar;
        this.d = new AtomicReference(f4918k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        E e = new E(i5, this);
        i5.onSubscribe(e);
        loop0: while (true) {
            AtomicReference atomicReference = this.d;
            E[] eArr = (E[]) atomicReference.get();
            if (eArr == f4919l) {
                break;
            }
            int length = eArr.length;
            E[] eArr2 = new E[length + 1];
            System.arraycopy(eArr, 0, eArr2, 0, length);
            eArr2[length] = e;
            do {
                if (atomicReference.compareAndSet(eArr, eArr2)) {
                    break loop0;
                }
            } while (atomicReference.get() == eArr);
        }
        AtomicBoolean atomicBoolean = this.b;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            e(e);
        } else {
            this.f5141a.subscribe(this);
        }
    }

    public final void e(E e) {
        if (e.getAndIncrement() != 0) {
            return;
        }
        long j6 = e.e;
        int i5 = e.d;
        L0.j jVar = e.c;
        io.reactivex.I i6 = e.f4909a;
        int i7 = this.c;
        int iAddAndGet = 1;
        while (!e.f4910f) {
            boolean z6 = this.f4924j;
            boolean z7 = this.e == j6;
            if (z6 && z7) {
                e.c = null;
                Throwable th = this.f4923i;
                if (th != null) {
                    i6.onError(th);
                    return;
                } else {
                    i6.onComplete();
                    return;
                }
            }
            if (z7) {
                e.e = j6;
                e.d = i5;
                e.c = jVar;
                iAddAndGet = e.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                if (i5 == i7) {
                    jVar = (L0.j) jVar.b;
                    i5 = 0;
                }
                i6.onNext(((Object[]) jVar.f404a)[i5]);
                i5++;
                j6++;
            }
        }
        e.c = null;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f4924j = true;
        for (E e : (E[]) this.d.getAndSet(f4919l)) {
            e(e);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f4923i = th;
        this.f4924j = true;
        for (E e : (E[]) this.d.getAndSet(f4919l)) {
            e(e);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        int i5 = this.f4922h;
        if (i5 == this.c) {
            L0.j jVar = new L0.j(i5, 2);
            ((Object[]) jVar.f404a)[0] = obj;
            this.f4922h = 1;
            this.f4921g.b = jVar;
            this.f4921g = jVar;
        } else {
            ((Object[]) this.f4921g.f404a)[i5] = obj;
            this.f4922h = i5 + 1;
        }
        this.e++;
        for (E e : (E[]) this.d.get()) {
            e(e);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
    }
}
