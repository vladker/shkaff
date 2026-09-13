package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import p017c3.d;
import p033f3.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H extends O {
    public static final H b = new H(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6267a;

    public /* synthetic */ H(int i5) {
        this.f6267a = i5;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f6267a) {
            case 0:
                s6.onSubscribe(e.b);
                return;
            case 1:
                C1250d c1250d = new C1250d(s6);
                s6.onSubscribe(c1250d);
                try {
                    throw null;
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    c1250d.onError(th);
                    return;
                }
            default:
                try {
                    throw null;
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    e.f(th2, s6);
                    return;
                }
        }
    }

    public H(O o6) {
        this.f6267a = 2;
    }
}
