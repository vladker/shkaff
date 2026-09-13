package p007a4;

import p028e4.AbstractC0659m;

/* JADX INFO: renamed from: a4.b1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0265b1 extends F {
    public abstract AbstractC0265b1 getImmediate();

    @Override // p007a4.F
    public F limitedParallelism(int i5, String str) {
        AbstractC0659m.a(i5);
        return AbstractC0659m.namedOrThis(this, str);
    }

    @Override // p007a4.F
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        return S.getClassSimpleName(this) + '@' + S.getHexAddress(this);
    }

    public final String toStringInternalImpl() {
        AbstractC0265b1 immediate;
        AbstractC0265b1 main = C0276f0.getMain();
        if (this == main) {
            return "Dispatchers.Main";
        }
        try {
            immediate = main.getImmediate();
        } catch (UnsupportedOperationException unused) {
            immediate = null;
        }
        if (this == immediate) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
