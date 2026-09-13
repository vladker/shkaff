package H3;

import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Serializable {
    private static final d Companion = new d();
    private static final long serialVersionUID = 0;
    private final Class<Enum<Object>> c;

    public e(Enum<Object>[] entries) {
        E.f(entries, "entries");
        Class componentType = entries.getClass().getComponentType();
        E.c(componentType);
        this.c = componentType;
    }

    private final Object readResolve() {
        Enum<Object>[] enumConstants = this.c.getEnumConstants();
        E.e(enumConstants, "getEnumConstants(...)");
        return b.enumEntries(enumConstants);
    }
}
