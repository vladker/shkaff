package H3;

import A3.AbstractC0139g;
import A3.C;
import A3.C0136d;
import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends AbstractC0139g implements a, Serializable {
    private final Enum<Object>[] entries;

    public c(Enum<Object>[] entries) {
        E.f(entries, "entries");
        this.entries = entries;
    }

    private final Object writeReplace() {
        return new e(this.entries);
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        return this.entries.length;
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return contains((Enum<Object>) obj);
        }
        return false;
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((Enum<Object>) obj);
        }
        return -1;
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return lastIndexOf((Enum<Object>) obj);
        }
        return -1;
    }

    public boolean contains(Enum<Object> element) {
        E.f(element, "element");
        return ((Enum) C.getOrNull(this.entries, element.ordinal())) == element;
    }

    @Override // java.util.List
    public Enum<Object> get(int i5) {
        C0136d c0136d = AbstractC0139g.Companion;
        int length = this.entries.length;
        c0136d.getClass();
        C0136d.b(i5, length);
        return this.entries[i5];
    }

    public int indexOf(Enum<Object> element) {
        E.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) C.getOrNull(this.entries, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    public int lastIndexOf(Enum<Object> element) {
        E.f(element, "element");
        return indexOf((Object) element);
    }
}
