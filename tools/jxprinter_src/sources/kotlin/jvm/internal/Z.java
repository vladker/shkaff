package kotlin.jvm.internal;

import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z {
    public final String toString(V3.q typeParameter) {
        E.f(typeParameter, "typeParameter");
        StringBuilder sb = new StringBuilder();
        int iOrdinal = typeParameter.getVariance().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                sb.append("in ");
            } else {
                if (iOrdinal != 2) {
                    throw new C1937q();
                }
                sb.append("out ");
            }
        }
        sb.append(typeParameter.getName());
        return sb.toString();
    }
}
