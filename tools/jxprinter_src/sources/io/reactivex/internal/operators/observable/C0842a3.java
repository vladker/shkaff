package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.a3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0842a3 extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = 3837284832786408377L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0847b3 f5144a;
    public final long b;
    public final int c;
    public volatile p043h3.j d;
    public volatile boolean e;

    public C0842a3(C0847b3 c0847b3, long j6, int i5) {
        this.f5144a = c0847b3;
        this.b = j6;
        this.c = i5;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.b == this.f5144a.f5159j) {
            this.e = true;
            this.f5144a.b();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        C0847b3 c0847b3 = this.f5144a;
        c0847b3.getClass();
        if (this.b == c0847b3.f5159j) {
            p100r3.c cVar = c0847b3.e;
            cVar.getClass();
            if (p100r3.g.a(cVar, th)) {
                if (!c0847b3.d) {
                    c0847b3.f5157h.dispose();
                }
                this.e = true;
                c0847b3.b();
                return;
            }
        }
        io.reactivex.plugins.a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.b == this.f5144a.f5159j) {
            if (obj != null) {
                this.d.offer(obj);
            }
            this.f5144a.b();
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.f(this, cVar)) {
            if (cVar instanceof p043h3.e) {
                p043h3.e eVar = (p043h3.e) cVar;
                int iC = eVar.c(7);
                if (iC == 1) {
                    this.d = eVar;
                    this.e = true;
                    this.f5144a.b();
                    return;
                } else if (iC == 2) {
                    this.d = eVar;
                    return;
                }
            }
            this.d = new p083o3.d(this.c);
        }
    }
}
