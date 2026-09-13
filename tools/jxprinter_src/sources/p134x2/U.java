package p134x2;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ X f8881a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(X x6, g gVar) {
        super(2, gVar);
        this.f8881a = x6;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new U(this.f8881a, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super Q> gVar) {
        return ((U) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        i.getCOROUTINE_SUSPENDED();
        v.throwOnFailure(obj);
        this.f8881a.a();
        return Q.INSTANCE;
    }
}
