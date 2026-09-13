package B4;

import A3.C0144l;
import A4.AbstractC0180x;
import A4.V;
import W3.AbstractC0234s;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f104a;
    public /* synthetic */ Object b;
    public final /* synthetic */ AbstractC0180x c;
    public final /* synthetic */ V d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AbstractC0180x abstractC0180x, V v6, E3.g gVar) {
        super(2, gVar);
        this.c = abstractC0180x;
        this.d = v6;
    }

    @Override // G3.a
    public final E3.g<Q> create(Object obj, E3.g<?> gVar) {
        d dVar = new d(this.c, this.d, gVar);
        dVar.b = obj;
        return dVar;
    }

    @Override // O3.p
    public final Object invoke(AbstractC0234s abstractC0234s, E3.g<? super Q> gVar) {
        return ((d) create(abstractC0234s, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i5 = this.f104a;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            AbstractC0234s abstractC0234s = (AbstractC0234s) this.b;
            C0144l c0144l = new C0144l();
            this.f104a = 1;
            if (f.collectRecursively(abstractC0234s, this.c, c0144l, this.d, false, true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        return Q.INSTANCE;
    }
}
