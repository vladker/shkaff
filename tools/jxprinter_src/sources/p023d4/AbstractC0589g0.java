package p023d4;

import E3.d;
import O3.l;
import O3.p;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.Y;

/* JADX INFO: renamed from: d4.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0589g0 {
    private static final l defaultKeySelector = new S2.l(3);
    private static final p defaultAreEquivalent = new d(8);

    public static final C0606m a(InterfaceC0612o interfaceC0612o, l lVar, p pVar) {
        if (interfaceC0612o instanceof C0606m) {
            C0606m c0606m = (C0606m) interfaceC0612o;
            if (c0606m.keySelector == lVar && c0606m.areEquivalent == pVar) {
                return c0606m;
            }
        }
        return new C0606m(interfaceC0612o, lVar, pVar);
    }

    public static final <T> InterfaceC0612o distinctUntilChanged(InterfaceC0612o interfaceC0612o) {
        return interfaceC0612o instanceof n2 ? interfaceC0612o : a(interfaceC0612o, defaultKeySelector, defaultAreEquivalent);
    }

    public static final <T, K> InterfaceC0612o distinctUntilChangedBy(InterfaceC0612o interfaceC0612o, l lVar) {
        return a(interfaceC0612o, lVar, defaultAreEquivalent);
    }

    public static final <T> InterfaceC0612o distinctUntilChanged(InterfaceC0612o interfaceC0612o, p pVar) {
        l lVar = defaultKeySelector;
        E.d(pVar, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        Y.c(2, pVar);
        return a(interfaceC0612o, lVar, pVar);
    }
}
