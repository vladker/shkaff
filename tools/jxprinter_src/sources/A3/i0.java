package A3;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        if (map instanceof g0) {
            return (V) ((g0) map).a(k6);
        }
        V v6 = map.get(k6);
        if (v6 != null || map.containsKey(k6)) {
            return v6;
        }
        throw new NoSuchElementException("Key " + k6 + " is missing in the map.");
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> map, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return map instanceof g0 ? withDefault(((g0) map).getMap(), defaultValue) : new h0(map, defaultValue);
    }

    public static final <K, V> Map<K, V> withDefaultMutable(Map<K, V> map, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return map instanceof o0 ? withDefaultMutable(((o0) map).getMap(), defaultValue) : new p0(map, defaultValue);
    }
}
