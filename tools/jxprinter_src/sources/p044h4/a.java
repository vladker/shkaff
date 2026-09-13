package p044h4;

import O3.q;
import Q0.b;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0261a0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a extends B implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4032a = new a(3, b.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        b bVar = (b) obj;
        o oVar = (o) obj2;
        long j6 = bVar.f4033a;
        if (j6 <= 0) {
            oVar.selectInRegistrationPhase(Q.INSTANCE);
        } else {
            b bVar2 = new b(oVar, bVar, 10);
            E.d(oVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            m mVar = (m) oVar;
            E3.q context = mVar.getContext();
            mVar.disposeOnCompletion(AbstractC0261a0.getDelay(context).invokeOnTimeout(j6, bVar2, context));
        }
        return Q.INSTANCE;
    }
}
