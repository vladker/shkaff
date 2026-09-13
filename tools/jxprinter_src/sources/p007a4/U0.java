package p007a4;

import O3.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.B;
import p044h4.o;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class U0 extends B implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final U0 f946a = new U0(3, X0.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object state$kotlinx_coroutines_core;
        X0 x6 = (X0) obj;
        o oVar = (o) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X0.f949a;
        do {
            state$kotlinx_coroutines_core = x6.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof B0)) {
                if (!(state$kotlinx_coroutines_core instanceof C0314z)) {
                    state$kotlinx_coroutines_core = Y0.unboxState(state$kotlinx_coroutines_core);
                }
                oVar.selectInRegistrationPhase(state$kotlinx_coroutines_core);
            }
            return Q.INSTANCE;
        } while (x6.r(state$kotlinx_coroutines_core) < 0);
        oVar.disposeOnCompletion(K0.invokeOnCompletion(x6, true, new S0(x6, oVar)));
        return Q.INSTANCE;
    }
}
