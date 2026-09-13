package I3;

import kotlin.jvm.internal.E;
import p147z3.C1932l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final b IMPLEMENTATIONS = new K3.b();

    public static final boolean apiVersionIsAtLeast(int i5, int i6, int i7) {
        C1932l.CURRENT.getClass();
        if (2 <= i5) {
            if (2 != i5) {
                return false;
            }
            if (1 <= i6 && (1 != i6 || i7 > 0)) {
                return false;
            }
        }
        return true;
    }

    private static final <T> T castToBaseType(Object obj) {
        try {
            E.l();
            throw null;
        } catch (ClassCastException unused) {
            obj.getClass().getClassLoader();
            E.l();
            throw null;
        }
    }
}
