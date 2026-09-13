package F3;

import G3.k;
import O3.p;
import kotlin.jvm.internal.Y;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f268a;
    public final /* synthetic */ p b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(p pVar, Object obj, E3.g gVar) {
        super(gVar);
        this.b = pVar;
        this.c = obj;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i5 = this.f268a;
        if (i5 != 0) {
            if (i5 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f268a = 2;
            v.throwOnFailure(obj);
            return obj;
        }
        this.f268a = 1;
        v.throwOnFailure(obj);
        p pVar = this.b;
        Y.c(2, pVar);
        return pVar.invoke(this.c, this);
    }
}
