package kotlinx.coroutines.flow.internal;

import p007a4.H0;
import p023d4.C0623s;
import p023d4.InterfaceC0612o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class I {
    public static final void checkContext(F f6, E3.q qVar) {
        if (((Number) qVar.fold(0, new p051j0.g(f6, 1))).intValue() == f6.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + f6.collectContext + ",\n\t\tbut emission happened in " + qVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final H0 transitiveCoroutineParent(H0 h1, H0 h6) {
        while (h1 != null) {
            if (h1 == h6 || !(h1 instanceof p028e4.D)) {
                return h1;
            }
            h1 = ((p028e4.D) h1).getParent();
        }
        return null;
    }

    public static final <T> InterfaceC0612o unsafeFlow(O3.p pVar) {
        return new C0623s(pVar, 11);
    }
}
