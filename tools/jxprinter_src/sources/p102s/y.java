package p102s;

import E3.g;
import F3.i;
import G3.m;
import O3.l;
import O3.p;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p007a4.M;
import p051j0.f;
import p134x2.K0;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8183a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ l c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(boolean z6, l lVar, g gVar) {
        super(2, gVar);
        this.b = z6;
        this.c = lVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        return new y(this.b, this.c, gVar);
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((y) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM1110setWifiDHCPgIAlus;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f8183a;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            K0 printer = f.getPrinter();
            if (printer != null) {
                this.f8183a = 1;
                objM1110setWifiDHCPgIAlus = printer.m1110setWifiDHCPgIAlus(this.b, this);
                if (objM1110setWifiDHCPgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Q q6 = Q.INSTANCE;
            AbstractC1125a.q(q6, this.c);
            return q6;
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.throwOnFailure(obj);
        objM1110setWifiDHCPgIAlus = ((u) obj).b();
        u.a(objM1110setWifiDHCPgIAlus);
        Q q7 = Q.INSTANCE;
        AbstractC1125a.q(q7, this.c);
        return q7;
    }
}
