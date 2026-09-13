package p007a4;

import E3.g;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class B {
    public static final <T> Object recoverResult(Object obj, g<? super T> gVar) {
        return obj instanceof C0314z ? u.m1361constructorimpl(v.createFailure(((C0314z) obj).cause)) : u.m1361constructorimpl(obj);
    }

    public static final <T> Object toState(Object obj) {
        Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(obj);
        return thM1362exceptionOrNullimpl == null ? obj : new C0314z(thM1362exceptionOrNullimpl, false);
    }

    public static final <T> Object toState(Object obj, InterfaceC0285k interfaceC0285k) {
        Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(obj);
        return thM1362exceptionOrNullimpl == null ? obj : new C0314z(thM1362exceptionOrNullimpl, false);
    }
}
