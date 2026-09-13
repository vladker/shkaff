package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.V;
import io.reactivex.plugins.a;
import java.util.concurrent.Callable;
import p011b3.c;
import p017c3.d;
import p033f3.e;
import p039g3.A;

/* JADX INFO: renamed from: n3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1251e extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6293a;
    public final Callable b;

    public /* synthetic */ C1251e(Callable callable, int i5) {
        this.f6293a = i5;
        this.b = callable;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f6293a) {
            case 0:
                try {
                    Object objCall = this.b.call();
                    A.b(objCall, "The singleSupplier returned a null SingleSource");
                    ((O) ((V) objCall)).subscribe(s6);
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    e.f(th, s6);
                    return;
                }
                break;
            case 1:
                try {
                    Object objCall2 = this.b.call();
                    A.b(objCall2, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
                    th = (Throwable) objCall2;
                } catch (Throwable th2) {
                    th = th2;
                    d.throwIfFatal(th);
                }
                e.f(th, s6);
                break;
            default:
                c cVarEmpty = p011b3.d.empty();
                s6.onSubscribe(cVarEmpty);
                if (!cVarEmpty.e()) {
                    try {
                        Object objCall3 = this.b.call();
                        A.b(objCall3, "The callable returned a null value");
                        if (!cVarEmpty.e()) {
                            s6.onSuccess(objCall3);
                        }
                        break;
                    } catch (Throwable th3) {
                        d.throwIfFatal(th3);
                        if (!cVarEmpty.e()) {
                            s6.onError(th3);
                            return;
                        }
                        a.onError(th3);
                    }
                }
                break;
        }
    }
}
