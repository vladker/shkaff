package F3;

import E3.q;
import O3.l;
import kotlin.jvm.internal.Y;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f267a;
    public int b;
    public final /* synthetic */ l c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(E3.g gVar, q qVar, l lVar, int i5) {
        super(gVar, qVar);
        this.f267a = i5;
        this.c = lVar;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f267a) {
            case 0:
                int i5 = this.b;
                if (i5 == 0) {
                    this.b = 1;
                    v.throwOnFailure(obj);
                    return this.c.invoke(this);
                }
                if (i5 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.b = 2;
                v.throwOnFailure(obj);
                return obj;
            default:
                int i6 = this.b;
                if (i6 != 0) {
                    if (i6 != 1) {
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.b = 2;
                    v.throwOnFailure(obj);
                    return obj;
                }
                this.b = 1;
                v.throwOnFailure(obj);
                l lVar = this.c;
                Y.c(1, lVar);
                return lVar.invoke(this);
        }
    }
}
