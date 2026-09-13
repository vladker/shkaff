package y5;

import io.reactivex.I;
import retrofit2.r0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f9044a;
    public boolean b;

    public a(I i5) {
        this.f9044a = i5;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.b) {
            return;
        }
        this.f9044a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (!this.b) {
            this.f9044a.onError(th);
            return;
        }
        AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
        assertionError.initCause(th);
        io.reactivex.plugins.a.onError(assertionError);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        r0 r0Var = (r0) obj;
        boolean zA = r0Var.f8159a.a();
        I i5 = this.f9044a;
        if (zA) {
            i5.onNext(r0Var.body());
            return;
        }
        this.b = true;
        f fVar = new f(r0Var);
        try {
            i5.onError(fVar);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(new p017c3.c(fVar, th));
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        this.f9044a.onSubscribe(cVar);
    }
}
