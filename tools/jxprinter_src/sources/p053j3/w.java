package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import p017c3.d;
import p033f3.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends AbstractC0676c {
    public static final w b = new w(0);
    public static final w c = new w(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5456a;

    public /* synthetic */ w(int i5) {
        this.f5456a = i5;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5456a) {
            case 0:
                interfaceC0679f.onSubscribe(e.f3970a);
                interfaceC0679f.onComplete();
                return;
            case 1:
                interfaceC0679f.onSubscribe(e.b);
                return;
            case 2:
                C1003n c1003n = new C1003n(interfaceC0679f);
                interfaceC0679f.onSubscribe(c1003n);
                try {
                    throw null;
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    c1003n.onError(th);
                    return;
                }
            default:
                try {
                    throw null;
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    a.onError(th2);
                    return;
                }
        }
    }

    public w(AbstractC0676c abstractC0676c) {
        this.f5456a = 3;
    }
}
