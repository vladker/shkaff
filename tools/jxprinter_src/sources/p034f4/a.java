package p034f4;

import E3.g;
import F3.h;
import O3.l;
import O3.p;
import p028e4.AbstractC0655i;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final <T> void startCoroutineCancellable(l lVar, g<? super T> gVar) {
        try {
            AbstractC0655i.resumeCancellableWith(h.intercepted(h.createCoroutineUnintercepted(lVar, gVar)), u.m1361constructorimpl(Q.INSTANCE));
        } catch (Throwable th) {
            gVar.resumeWith(u.m1361constructorimpl(v.createFailure(th)));
            throw th;
        }
    }

    public static final <R, T> void startCoroutineCancellable(p pVar, R r6, g<? super T> gVar) {
        try {
            AbstractC0655i.resumeCancellableWith(h.intercepted(h.createCoroutineUnintercepted(pVar, r6, gVar)), u.m1361constructorimpl(Q.INSTANCE));
        } catch (Throwable th) {
            gVar.resumeWith(u.m1361constructorimpl(v.createFailure(th)));
            throw th;
        }
    }

    public static final void startCoroutineCancellable(g<? super Q> gVar, g<?> gVar2) {
        try {
            AbstractC0655i.resumeCancellableWith(h.intercepted(gVar), u.m1361constructorimpl(Q.INSTANCE));
        } catch (Throwable th) {
            gVar2.resumeWith(u.m1361constructorimpl(v.createFailure(th)));
            throw th;
        }
    }
}
