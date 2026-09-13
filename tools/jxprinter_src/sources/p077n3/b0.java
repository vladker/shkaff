package p077n3;

import io.reactivex.S;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends AtomicReference implements S {
    private static final long serialVersionUID = 3323743579927613702L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f6287a;
    public final int b;

    public b0(a0 a0Var, int i5) {
        this.f6287a = a0Var;
        this.b = i5;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6287a.a(th, this.b);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        a0 a0Var = this.f6287a;
        S s6 = a0Var.f6285a;
        Object[] objArr = a0Var.d;
        objArr[this.b] = obj;
        if (a0Var.decrementAndGet() == 0) {
            try {
                Object objApply = a0Var.b.apply(objArr);
                A.b(objApply, "The zipper returned a null value");
                s6.onSuccess(objApply);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                s6.onError(th);
            }
        }
    }
}
