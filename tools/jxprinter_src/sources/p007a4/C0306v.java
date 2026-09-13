package p007a4;

import E3.g;
import F3.i;
import kotlin.jvm.internal.E;
import p044h4.h;

/* JADX INFO: renamed from: a4.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0306v extends X0 implements InterfaceC0304u {
    public C0306v(H0 h1) {
        super(true);
        initParentJob(h1);
    }

    @Override // p007a4.InterfaceC0304u, p007a4.V
    public Object await(g<Object> gVar) throws Throwable {
        Object objAwaitInternal = awaitInternal(gVar);
        i.getCOROUTINE_SUSPENDED();
        return objAwaitInternal;
    }

    @Override // p007a4.InterfaceC0304u
    public boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new C0314z(th, false));
    }

    @Override // p007a4.InterfaceC0304u, p007a4.V
    public h getOnAwait() {
        h onAwaitInternal = getOnAwaitInternal();
        E.d(onAwaitInternal, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return onAwaitInternal;
    }
}
