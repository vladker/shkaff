package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends AtomicInteger implements p011b3.c {
    private static final long serialVersionUID = 8567835998786448817L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4978a;
    public final p027e3.o b;
    public final I[] c;
    public Object[] d;
    public final p083o3.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p100r3.c f4982i = new p100r3.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4984k;

    public J(int i5, int i6, p027e3.o oVar, io.reactivex.I i7, boolean z6) {
        this.f4978a = i7;
        this.b = oVar;
        this.f4979f = z6;
        this.d = new Object[i5];
        I[] iArr = new I[i5];
        for (int i8 = 0; i8 < i5; i8++) {
            iArr[i8] = new I(this, i8);
        }
        this.c = iArr;
        this.e = new p083o3.d(i6);
    }

    public final void a() {
        for (I i5 : this.c) {
            i5.getClass();
            p033f3.d.a(i5);
        }
    }

    public final void b(p083o3.d dVar) {
        synchronized (this) {
            this.d = null;
        }
        dVar.clear();
    }

    public final void c() {
        if (getAndIncrement() != 0) {
            return;
        }
        p083o3.d dVar = this.e;
        io.reactivex.I i5 = this.f4978a;
        boolean z6 = this.f4979f;
        int iAddAndGet = 1;
        while (!this.f4980g) {
            if (!z6 && this.f4982i.get() != null) {
                a();
                b(dVar);
                p100r3.c cVar = this.f4982i;
                cVar.getClass();
                i5.onError(p100r3.g.b(cVar));
                return;
            }
            boolean z7 = this.f4981h;
            Object[] objArr = (Object[]) dVar.poll();
            boolean z8 = objArr == null;
            if (z7 && z8) {
                b(dVar);
                p100r3.c cVar2 = this.f4982i;
                cVar2.getClass();
                Throwable thB = p100r3.g.b(cVar2);
                if (thB == null) {
                    i5.onComplete();
                    return;
                } else {
                    i5.onError(thB);
                    return;
                }
            }
            if (z8) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                try {
                    Object objApply = this.b.apply(objArr);
                    p039g3.A.b(objApply, "The combiner returned a null value");
                    i5.onNext(objApply);
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    p100r3.c cVar3 = this.f4982i;
                    cVar3.getClass();
                    p100r3.g.a(cVar3, th);
                    a();
                    b(dVar);
                    p100r3.c cVar4 = this.f4982i;
                    cVar4.getClass();
                    i5.onError(p100r3.g.b(cVar4));
                    return;
                }
            }
        }
        b(dVar);
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f4980g) {
            return;
        }
        this.f4980g = true;
        a();
        if (getAndIncrement() == 0) {
            b(this.e);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4980g;
    }
}
