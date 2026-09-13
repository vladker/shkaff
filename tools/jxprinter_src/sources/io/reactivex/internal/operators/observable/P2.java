package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P2 extends AtomicInteger implements p011b3.c {
    private static final long serialVersionUID = -6178010334400373240L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.S f5081a;
    public final p027e3.d b;
    public final p033f3.a c = new p033f3.a(2);
    public final io.reactivex.G d;
    public final io.reactivex.G e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final O2[] f5082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f5084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f5085i;

    public P2(io.reactivex.S s6, int i5, io.reactivex.G g6, io.reactivex.G g7, p027e3.d dVar) {
        this.f5081a = s6;
        this.d = g6;
        this.e = g7;
        this.b = dVar;
        this.f5082f = new O2[]{new O2(this, 0, i5), new O2(this, 1, i5)};
    }

    public final void a() {
        Throwable th;
        Throwable th2;
        if (getAndIncrement() != 0) {
            return;
        }
        O2[] o2Arr = this.f5082f;
        O2 o6 = o2Arr[0];
        p083o3.d dVar = o6.b;
        O2 o7 = o2Arr[1];
        p083o3.d dVar2 = o7.b;
        int iAddAndGet = 1;
        while (!this.f5083g) {
            boolean z6 = o6.d;
            if (z6 && (th2 = o6.e) != null) {
                this.f5083g = true;
                dVar.clear();
                dVar2.clear();
                this.f5081a.onError(th2);
                return;
            }
            boolean z7 = o7.d;
            if (z7 && (th = o7.e) != null) {
                this.f5083g = true;
                dVar.clear();
                dVar2.clear();
                this.f5081a.onError(th);
                return;
            }
            if (this.f5084h == null) {
                this.f5084h = dVar.poll();
            }
            boolean z8 = this.f5084h == null;
            if (this.f5085i == null) {
                this.f5085i = dVar2.poll();
            }
            Object obj = this.f5085i;
            boolean z9 = obj == null;
            if (z6 && z7 && z8 && z9) {
                this.f5081a.onSuccess(Boolean.TRUE);
                return;
            }
            if (z6 && z7 && z8 != z9) {
                this.f5083g = true;
                dVar.clear();
                dVar2.clear();
                this.f5081a.onSuccess(Boolean.FALSE);
                return;
            }
            if (!z8 && !z9) {
                try {
                    p027e3.d dVar3 = this.b;
                    Object obj2 = this.f5084h;
                    ((V1.b) dVar3).getClass();
                    if (!p039g3.A.a(obj2, obj)) {
                        this.f5083g = true;
                        dVar.clear();
                        dVar2.clear();
                        this.f5081a.onSuccess(Boolean.FALSE);
                        return;
                    }
                    this.f5084h = null;
                    this.f5085i = null;
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    this.f5083g = true;
                    dVar.clear();
                    dVar2.clear();
                    this.f5081a.onError(th3);
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
        if (this.f5083g) {
            return;
        }
        this.f5083g = true;
        this.c.dispose();
        if (getAndIncrement() == 0) {
            O2[] o2Arr = this.f5082f;
            o2Arr[0].b.clear();
            o2Arr[1].b.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5083g;
    }
}
