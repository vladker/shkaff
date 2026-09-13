package p065l3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends AtomicReference implements S {
    private static final long serialVersionUID = -3051469169682093892L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B f5790a;

    public A(B b) {
        this.f5790a = b;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        B b = this.f5790a;
        c cVar = b.c;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (b.f5792f != 3) {
            b.f5793g.dispose();
        }
        b.f5797k = 0;
        b.a();
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        d.c(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        B b = this.f5790a;
        b.f5796j = obj;
        b.f5797k = 2;
        b.a();
    }
}
