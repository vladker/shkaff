package E3;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements p {
    private final O3.l safeCast;
    private final p topmostKey;

    public b(p baseKey, O3.l safeCast) {
        E.f(baseKey, "baseKey");
        E.f(safeCast, "safeCast");
        this.safeCast = safeCast;
        this.topmostKey = baseKey instanceof b ? ((b) baseKey).topmostKey : baseKey;
    }

    public final boolean isSubKey$kotlin_stdlib(p key) {
        E.f(key, "key");
        return key == this || this.topmostKey == key;
    }

    public final Object tryCast$kotlin_stdlib(o element) {
        E.f(element, "element");
        return (o) this.safeCast.invoke(element);
    }
}
