package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import p017c3.d;
import p033f3.e;

/* JADX INFO: renamed from: k3.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1029j0 extends AbstractC0985s {
    public static final C1029j0 b = new C1029j0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5564a;

    public /* synthetic */ C1029j0(int i5) {
        this.f5564a = i5;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.f5564a) {
            case 0:
                interfaceC0988v.onSubscribe(e.b);
                return;
            default:
                C1036n c1036n = new C1036n(interfaceC0988v);
                interfaceC0988v.onSubscribe(c1036n);
                try {
                    throw null;
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    c1036n.onError(th);
                    return;
                }
        }
    }
}
