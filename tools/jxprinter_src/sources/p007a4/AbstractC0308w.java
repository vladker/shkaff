package p007a4;

import p147z3.u;

/* JADX INFO: renamed from: a4.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0308w {
    public static final <T> InterfaceC0304u CompletableDeferred(H0 h1) {
        return new C0306v(h1);
    }

    public static final <T> boolean completeWith(InterfaceC0304u interfaceC0304u, Object obj) {
        Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(obj);
        return thM1362exceptionOrNullimpl == null ? ((C0306v) interfaceC0304u).makeCompleting$kotlinx_coroutines_core(obj) : interfaceC0304u.completeExceptionally(thM1362exceptionOrNullimpl);
    }

    public static final <T> InterfaceC0304u CompletableDeferred(T t6) {
        C0306v c0306v = new C0306v(null);
        c0306v.makeCompleting$kotlinx_coroutines_core(t6);
        return c0306v;
    }
}
