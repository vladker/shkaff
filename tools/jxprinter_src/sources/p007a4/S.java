package p007a4;

import E3.g;
import p028e4.C0654h;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class S {
    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(g<?> gVar) {
        Object objM1361constructorimpl;
        if (gVar instanceof C0654h) {
            return ((C0654h) gVar).toString();
        }
        try {
            objM1361constructorimpl = u.m1361constructorimpl(gVar + '@' + getHexAddress(gVar));
        } catch (Throwable th) {
            objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(th));
        }
        if (u.m1362exceptionOrNullimpl(objM1361constructorimpl) != null) {
            objM1361constructorimpl = gVar.getClass().getName() + '@' + getHexAddress(gVar);
        }
        return (String) objM1361constructorimpl;
    }
}
