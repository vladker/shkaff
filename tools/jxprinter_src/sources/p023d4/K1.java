package p023d4;

import A3.AbstractC0157z;
import O3.p;
import O3.q;
import V3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class K1 {
    public static final <T> InterfaceC0612o chunked(InterfaceC0612o interfaceC0612o, int i5) {
        if (i5 >= 1) {
            return new F0(interfaceC0612o, i5, 2);
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected positive chunk size, but got ").toString());
    }

    public static final <T> InterfaceC0612o filter(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0616p0(interfaceC0612o, 5, pVar);
    }

    public static final <R> InterfaceC0612o filterIsInstance(InterfaceC0612o interfaceC0612o, c cVar) {
        return new B0(interfaceC0612o, cVar, 1);
    }

    public static final <T> InterfaceC0612o filterNot(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0616p0(interfaceC0612o, 6, pVar);
    }

    public static final <T> InterfaceC0612o filterNotNull(InterfaceC0612o interfaceC0612o) {
        return new W0(interfaceC0612o, 1);
    }

    public static final <T, R> InterfaceC0612o map(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0616p0(interfaceC0612o, 7, pVar);
    }

    public static final <T, R> InterfaceC0612o mapNotNull(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0616p0(interfaceC0612o, 8, pVar);
    }

    public static final <T> InterfaceC0612o onEach(InterfaceC0612o interfaceC0612o, p pVar) {
        return new C0616p0(interfaceC0612o, 9, pVar);
    }

    public static final <T, R> InterfaceC0612o runningFold(InterfaceC0612o interfaceC0612o, R r6, q qVar) {
        return new O1(interfaceC0612o, r6, qVar);
    }

    public static final <T> InterfaceC0612o runningReduce(InterfaceC0612o interfaceC0612o, q qVar) {
        return new C0627t0(interfaceC0612o, qVar, 2);
    }

    public static final <T, R> InterfaceC0612o scan(InterfaceC0612o interfaceC0612o, R r6, q qVar) {
        return AbstractC0618q.runningFold(interfaceC0612o, r6, qVar);
    }

    public static final <T> InterfaceC0612o withIndex(InterfaceC0612o interfaceC0612o) {
        return new W0(interfaceC0612o, 2);
    }
}
