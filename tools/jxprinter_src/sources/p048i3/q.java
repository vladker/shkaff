package p048i3;

import io.reactivex.I;
import io.reactivex.internal.operators.observable.P;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p043h3.e;
import p043h3.j;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends AtomicReference implements I, c {
    private static final long serialVersionUID = -5417183359794346637L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P f4058a;
    public final int b;
    public j c;
    public volatile boolean d;
    public int e;

    public q(P p6, int i5) {
        this.f4058a = p6;
        this.b = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        P p6 = this.f4058a;
        p6.getClass();
        this.d = true;
        p6.b();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        P p6 = this.f4058a;
        p100r3.c cVar = p6.f5064f;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (p6.e == 1) {
            p6.f5067i.dispose();
        }
        this.d = true;
        p6.b();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        int i5 = this.e;
        P p6 = this.f4058a;
        if (i5 != 0) {
            p6.b();
            return;
        }
        p6.getClass();
        this.c.offer(obj);
        p6.b();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            if (cVar instanceof e) {
                e eVar = (e) cVar;
                int iC = eVar.c(3);
                if (iC == 1) {
                    this.e = iC;
                    this.c = eVar;
                    this.d = true;
                    P p6 = this.f4058a;
                    p6.getClass();
                    this.d = true;
                    p6.b();
                    return;
                }
                if (iC == 2) {
                    this.e = iC;
                    this.c = eVar;
                    return;
                }
            }
            int i5 = -this.b;
            this.c = i5 < 0 ? new p083o3.d(-i5) : new p083o3.c(i5);
        }
    }
}
