package p007a4;

import E3.g;
import E3.q;
import F3.i;
import kotlin.jvm.internal.E;
import p044h4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class W extends AbstractC0260a implements V {
    public W(q qVar, boolean z6) {
        super(qVar, true, z6);
    }

    @Override // p007a4.V
    public Object await(g<Object> gVar) throws Throwable {
        Object objAwaitInternal = awaitInternal(gVar);
        i.getCOROUTINE_SUSPENDED();
        return objAwaitInternal;
    }

    @Override // p007a4.V
    public h getOnAwait() {
        h onAwaitInternal = getOnAwaitInternal();
        E.d(onAwaitInternal, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return onAwaitInternal;
    }
}
