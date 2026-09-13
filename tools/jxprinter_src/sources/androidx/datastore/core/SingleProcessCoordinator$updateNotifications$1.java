package androidx.datastore.core;

import E3.g;
import F3.i;
import G3.f;
import G3.m;
import O3.p;
import p023d4.InterfaceC0615p;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.SingleProcessCoordinator$updateNotifications$1", f = "SingleProcessCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SingleProcessCoordinator$updateNotifications$1 extends m implements p {
    int label;

    public SingleProcessCoordinator$updateNotifications$1(g<? super SingleProcessCoordinator$updateNotifications$1> gVar) {
        super(2, gVar);
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new SingleProcessCoordinator$updateNotifications$1(gVar);
    }

    @Override // O3.p
    public final Object invoke(InterfaceC0615p interfaceC0615p, g<? super Q> gVar) {
        return ((SingleProcessCoordinator$updateNotifications$1) create(interfaceC0615p, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        i.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.throwOnFailure(obj);
        return Q.INSTANCE;
    }
}
