package F3;

import E3.q;
import O3.p;
import kotlin.jvm.internal.Y;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f269a;
    public final /* synthetic */ p b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(E3.g gVar, q qVar, p pVar, Object obj) {
        super(gVar, qVar);
        this.b = pVar;
        this.c = obj;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i5 = this.f269a;
        if (i5 != 0) {
            if (i5 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f269a = 2;
            v.throwOnFailure(obj);
            return obj;
        }
        this.f269a = 1;
        v.throwOnFailure(obj);
        p pVar = this.b;
        Y.c(2, pVar);
        return pVar.invoke(this.c, this);
    }
}
