package A3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 extends i0 {
    public static <K, V> Map<K, V> build(Map<K, V> builder) {
        kotlin.jvm.internal.E.f(builder, "builder");
        return (Map<K, V>) ((B3.m) builder).build();
    }

    private static final <K, V> Map<K, V> buildMapInternal(O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        Map mapCreateMapBuilder = createMapBuilder();
        builderAction.invoke(mapCreateMapBuilder);
        return build(mapCreateMapBuilder);
    }

    public static <K, V> Map<K, V> createMapBuilder() {
        return new B3.m();
    }

    public static final <K, V> V getOrPut(ConcurrentMap<K, V> concurrentMap, K k6, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(concurrentMap, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        V v6 = concurrentMap.get(k6);
        if (v6 != null) {
            return v6;
        }
        V v7 = (V) defaultValue.invoke();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k6, v7);
        return vPutIfAbsent == null ? v7 : vPutIfAbsent;
    }

    public static int mapCapacity(int i5) {
        if (i5 < 0) {
            return i5;
        }
        if (i5 < 3) {
            return i5 + 1;
        }
        if (i5 < 1073741824) {
            return (int) ((i5 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> Map<K, V> mapOf(C1938s pair) {
        kotlin.jvm.internal.E.f(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.f9134a, pair.b);
        kotlin.jvm.internal.E.e(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(C1938s... pairs) {
        kotlin.jvm.internal.E.f(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        k0.putAll(treeMap, pairs);
        return treeMap;
    }

    private static final Properties toProperties(Map<String, String> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.E.e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    private static final <K, V> Map<K, V> toSingletonMapOrSelf(Map<K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return toSingletonMap(map);
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return new TreeMap(map);
    }

    private static final <K, V> Map<K, V> buildMapInternal(int i5, O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        Map mapCreateMapBuilder = createMapBuilder(i5);
        builderAction.invoke(mapCreateMapBuilder);
        return build(mapCreateMapBuilder);
    }

    public static <K, V> Map<K, V> createMapBuilder(int i5) {
        return new B3.m(i5);
    }

    public static final <K, V> SortedMap<K, V> sortedMapOf(Comparator<? super K> comparator, C1938s... pairs) {
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        k0.putAll(treeMap, pairs);
        return treeMap;
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
