package p023d4;

import A3.AbstractC0157z;
import A3.C;
import E3.r;
import O3.p;
import O3.q;
import kotlinx.coroutines.flow.internal.C1121j;
import kotlinx.coroutines.flow.internal.o;
import p018c4.EnumC0368b;
import p028e4.I;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class Y0 {
    static {
        I.systemProp(AbstractC0618q.DEFAULT_CONCURRENCY_PROPERTY_NAME, 16, 1, Integer.MAX_VALUE);
    }

    public static final <T, R> InterfaceC0612o flatMapConcat(InterfaceC0612o interfaceC0612o, p pVar) {
        return AbstractC0618q.flattenConcat(new C0616p0(interfaceC0612o, 3, pVar));
    }

    public static final <T, R> InterfaceC0612o flatMapLatest(InterfaceC0612o interfaceC0612o, p pVar) {
        return AbstractC0618q.transformLatest(interfaceC0612o, new U0(pVar, null, 0));
    }

    public static final <T, R> InterfaceC0612o flatMapMerge(InterfaceC0612o interfaceC0612o, int i5, p pVar) {
        return AbstractC0618q.flattenMerge(new C0616p0(interfaceC0612o, 4, pVar), i5);
    }

    public static final <T> InterfaceC0612o flattenConcat(InterfaceC0612o interfaceC0612o) {
        return new W0(interfaceC0612o, 0);
    }

    public static final <T> InterfaceC0612o flattenMerge(InterfaceC0612o interfaceC0612o, int i5) {
        if (i5 > 0) {
            return i5 == 1 ? AbstractC0618q.flattenConcat(interfaceC0612o) : new C1121j(interfaceC0612o, i5, r.INSTANCE, -2, EnumC0368b.f1135a);
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected positive concurrency level, but had ").toString());
    }

    public static final <T, R> InterfaceC0612o mapLatest(InterfaceC0612o interfaceC0612o, p pVar) {
        return AbstractC0618q.transformLatest(interfaceC0612o, new U0(pVar, null, 1));
    }

    public static final <T> InterfaceC0612o merge(Iterable<? extends InterfaceC0612o> iterable) {
        return new kotlinx.coroutines.flow.internal.p(iterable, r.INSTANCE, -2, EnumC0368b.f1135a);
    }

    public static final <T, R> InterfaceC0612o transformLatest(InterfaceC0612o interfaceC0612o, q qVar) {
        return new o(qVar, interfaceC0612o, r.INSTANCE, -2, EnumC0368b.f1135a);
    }

    public static final <T> InterfaceC0612o merge(InterfaceC0612o... interfaceC0612oArr) {
        return AbstractC0618q.merge((Iterable<? extends InterfaceC0612o>) C.asIterable(interfaceC0612oArr));
    }

    public static /* synthetic */ void getDEFAULT_CONCURRENCY$annotations() {
    }

    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }
}
