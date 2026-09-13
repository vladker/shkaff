package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N2 extends AtomicInteger implements p011b3.c {
    private static final long serialVersionUID = -6178010334400373240L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5042a;
    public final p027e3.d b;
    public final p033f3.a c = new p033f3.a(2);
    public final io.reactivex.G d;
    public final io.reactivex.G e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final O2[] f5043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f5045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f5046i;

    public N2(io.reactivex.I i5, int i6, io.reactivex.G g6, io.reactivex.G g7, p027e3.d dVar) {
        this.f5042a = i5;
        this.d = g6;
        this.e = g7;
        this.b = dVar;
        this.f5043f = new O2[]{new O2(this, 0, i6), new O2(this, 1, i6)};
    }

    public final void a() {
        Throwable th;
        Throwable th2;
        if (getAndIncrement() != 0) {
            return;
        }
        O2[] o2Arr = this.f5043f;
        O2 o6 = o2Arr[0];
        p083o3.d dVar = o6.b;
        O2 o7 = o2Arr[1];
        p083o3.d dVar2 = o7.b;
        int iAddAndGet = 1;
        while (!this.f5044g) {
            boolean z6 = o6.d;
            if (z6 && (th2 = o6.e) != null) {
                this.f5044g = true;
                dVar.clear();
                dVar2.clear();
                this.f5042a.onError(th2);
                return;
            }
            boolean z7 = o7.d;
            if (z7 && (th = o7.e) != null) {
                this.f5044g = true;
                dVar.clear();
                dVar2.clear();
                this.f5042a.onError(th);
                return;
            }
            if (this.f5045h == null) {
                this.f5045h = dVar.poll();
            }
            boolean z8 = this.f5045h == null;
            if (this.f5046i == null) {
                this.f5046i = dVar2.poll();
            }
            Object obj = this.f5046i;
            boolean z9 = obj == null;
            if (z6 && z7 && z8 && z9) {
                this.f5042a.onNext(Boolean.TRUE);
                this.f5042a.onComplete();
                return;
            }
            if (z6 && z7 && z8 != z9) {
                this.f5044g = true;
                dVar.clear();
                dVar2.clear();
                this.f5042a.onNext(Boolean.FALSE);
                this.f5042a.onComplete();
                return;
            }
            if (!z8 && !z9) {
                try {
                    p027e3.d dVar3 = this.b;
                    Object obj2 = this.f5045h;
                    ((V1.b) dVar3).getClass();
                    if (!p039g3.A.a(obj2, obj)) {
                        this.f5044g = true;
                        dVar.clear();
                        dVar2.clear();
                        this.f5042a.onNext(Boolean.FALSE);
                        this.f5042a.onComplete();
                        return;
                    }
                    this.f5045h = null;
                    this.f5046i = null;
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    this.f5044g = true;
                    dVar.clear();
                    dVar2.clear();
                    this.f5042a.onError(th3);
                    return;
                }
            }
            if (z8 || z9) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        dVar.clear();
        dVar2.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5044g) {
            return;
        }
        this.f5044g = true;
        this.c.dispose();
        if (getAndIncrement() == 0) {
            O2[] o2Arr = this.f5043f;
            o2Arr[0].b.clear();
            o2Arr[1].b.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5044g;
    }
}
