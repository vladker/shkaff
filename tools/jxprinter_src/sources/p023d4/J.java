package p023d4;

import E3.g;
import F3.i;
import O3.p;
import O3.q;
import kotlinx.coroutines.flow.internal.D;
import p007a4.AbstractC0272e;
import p007a4.H0;
import p007a4.M;
import p018c4.EnumC0368b;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class J {
    public static final Object collect(InterfaceC0612o interfaceC0612o, g<? super Q> gVar) {
        Object objCollect = interfaceC0612o.collect(D.INSTANCE, gVar);
        return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }

    private static final /* synthetic */ <T> Object collect$$forInline(InterfaceC0612o interfaceC0612o, p pVar, g<? super Q> gVar) {
        interfaceC0612o.collect(new G(pVar, 0), gVar);
        return Q.INSTANCE;
    }

    public static final <T> Object collectIndexed(InterfaceC0612o interfaceC0612o, q qVar, g<? super Q> gVar) {
        Object objCollect = interfaceC0612o.collect(new H(qVar), gVar);
        return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }

    public static final <T> Object collectLatest(InterfaceC0612o interfaceC0612o, p pVar, g<? super Q> gVar) {
        Object objCollect = AbstractC0618q.collect(AbstractC0618q.buffer(AbstractC0618q.mapLatest(interfaceC0612o, pVar), 0, EnumC0368b.f1135a), gVar);
        return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }

    public static final <T> Object emitAll(InterfaceC0615p interfaceC0615p, InterfaceC0612o interfaceC0612o, g<? super Q> gVar) {
        AbstractC0618q.ensureActive(interfaceC0615p);
        Object objCollect = interfaceC0612o.collect(interfaceC0615p, gVar);
        return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }

    public static final <T> H0 launchIn(InterfaceC0612o interfaceC0612o, M m6) {
        return AbstractC0272e.b(m6, null, 3, new I(interfaceC0612o, null, 0));
    }

    public static final /* synthetic */ <T> Object collect(InterfaceC0612o interfaceC0612o, p pVar, g<? super Q> gVar) {
        Object objCollect = interfaceC0612o.collect(new G(pVar, 0), gVar);
        return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }
}
