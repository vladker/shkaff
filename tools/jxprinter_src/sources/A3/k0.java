package A3;

import W3.InterfaceC0233q;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 extends j0 {
    private static final <K, V> Map<K, V> buildMap(O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        Map mapCreateMapBuilder = j0.createMapBuilder();
        builderAction.invoke(mapCreateMapBuilder);
        return j0.build(mapCreateMapBuilder);
    }

    private static final <K, V> K component1(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.E.f(entry, "<this>");
        return entry.getKey();
    }

    private static final <K, V> V component2(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.E.f(entry, "<this>");
        return entry.getValue();
    }

    private static final <K, V> boolean contains(Map<? extends K, ? extends V> map, K k6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.containsKey(k6);
    }

    private static final <K> boolean containsKey(Map<? extends K, ?> map, K k6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.containsKey(k6);
    }

    private static final <K, V> boolean containsValue(Map<K, ? extends V> map, V v6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.containsValue(v6);
    }

    public static <K, V> Map<K, V> emptyMap() {
        X x6 = X.INSTANCE;
        kotlin.jvm.internal.E.d(x6, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return x6;
    }

    public static final <K, V> Map<K, V> filter(Map<? extends K, ? extends V> map, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (((Boolean) predicate.invoke(entry)).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> map, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (((Boolean) predicate.invoke(entry.getKey())).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> map, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!((Boolean) predicate.invoke(entry)).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(Map<? extends K, ? extends V> map, M destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!((Boolean) predicate.invoke(entry)).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(Map<? extends K, ? extends V> map, M destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (((Boolean) predicate.invoke(entry)).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    public static final <K, V> Map<K, V> filterValues(Map<? extends K, ? extends V> map, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (((Boolean) predicate.invoke(entry.getValue())).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private static final <K, V> V get(Map<? extends K, ? extends V> map, K k6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.get(k6);
    }

    private static final <K, V> V getOrElse(Map<K, ? extends V> map, K k6, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        V v6 = map.get(k6);
        return v6 == null ? (V) defaultValue.invoke() : v6;
    }

    public static final <K, V> V getOrElseNullable(Map<K, ? extends V> map, K k6, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        V v6 = map.get(k6);
        return (v6 != null || map.containsKey(k6)) ? v6 : (V) defaultValue.invoke();
    }

    public static final <K, V> V getOrPut(Map<K, V> map, K k6, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        V v6 = map.get(k6);
        if (v6 != null) {
            return v6;
        }
        V v7 = (V) defaultValue.invoke();
        map.put(k6, v7);
        return v7;
    }

    public static <K, V> V getValue(Map<K, ? extends V> map, K k6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return (V) i0.getOrImplicitDefaultNullable(map, k6);
    }

    private static final <K, V> HashMap<K, V> hashMapOf() {
        return new HashMap<>();
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;LO3/a;)TR; */
    private static final Object ifEmpty(Map map, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return map.isEmpty() ? defaultValue.invoke() : map;
    }

    private static final <K, V> boolean isNotEmpty(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return !map.isEmpty();
    }

    private static final <K, V> boolean isNullOrEmpty(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    private static final <K, V> Iterator<Map.Entry<K, V>> iterator(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.entrySet().iterator();
    }

    private static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        return new LinkedHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<R, V> mapKeys(Map<? extends K, ? extends V> map, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(transform.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(Map<? extends K, ? extends V> map, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (Object obj : map.entrySet()) {
            destination.put(transform.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return destination;
    }

    public static <K, V> Map<K, V> mapOf(C1938s... pairs) {
        kotlin.jvm.internal.E.f(pairs, "pairs");
        return pairs.length > 0 ? toMap(pairs, new LinkedHashMap(j0.mapCapacity(pairs.length))) : emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<K, R> mapValues(Map<? extends K, ? extends V> map, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj).getKey(), transform.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(Map<? extends K, ? extends V> map, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (Object obj : map.entrySet()) {
            destination.put(((Map.Entry) obj).getKey(), transform.invoke(obj));
        }
        return destination;
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K k6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        Map mutableMap = toMutableMap(map);
        mutableMap.remove(k6);
        return optimizeReadOnlyMap(mutableMap);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, K k6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        map.remove(k6);
    }

    private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(Map<K, V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.entrySet().iterator();
    }

    private static final <K, V> Map<K, V> mutableMapOf() {
        return new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : j0.toSingletonMap(map);
        }
        return emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> Map<K, V> orEmpty(Map<K, ? extends V> map) {
        return map == 0 ? emptyMap() : map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, C1938s pair) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pair, "pair");
        if (map.isEmpty()) {
            return j0.mapOf(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.f9134a, pair.b);
        return linkedHashMap;
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, C1938s pair) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pair, "pair");
        map.put((Object) pair.f9134a, (Object) pair.b);
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, C1938s[] pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        for (C1938s c1938s : pairs) {
            map.put((Object) c1938s.f9134a, (Object) c1938s.b);
        }
    }

    private static final <K, V> V remove(Map<? extends K, V> map, K k6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return (V) kotlin.jvm.internal.Y.b(map).remove(k6);
    }

    private static final <K, V> void set(Map<K, V> map, K k6, V v6) {
        kotlin.jvm.internal.E.f(map, "<this>");
        map.put(k6, v6);
    }

    public static <K, V> Map<K, V> toMap(Iterable<? extends C1938s> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return optimizeReadOnlyMap(toMap(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMap(iterable, new LinkedHashMap(j0.mapCapacity(collection.size())));
        }
        return j0.mapOf((C1938s) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return new LinkedHashMap(map);
    }

    private static final <K, V> C1938s toPair(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.E.f(entry, "<this>");
        return new C1938s(entry.getKey(), entry.getValue());
    }

    private static final <K, V> Map<K, V> buildMap(int i5, O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        Map mapCreateMapBuilder = j0.createMapBuilder(i5);
        builderAction.invoke(mapCreateMapBuilder);
        return j0.build(mapCreateMapBuilder);
    }

    public static final <K, V> HashMap<K, V> hashMapOf(C1938s... pairs) {
        kotlin.jvm.internal.E.f(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(j0.mapCapacity(pairs.length));
        putAll(map, pairs);
        return map;
    }

    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(C1938s... pairs) {
        kotlin.jvm.internal.E.f(pairs, "pairs");
        return (LinkedHashMap) toMap(pairs, new LinkedHashMap(j0.mapCapacity(pairs.length)));
    }

    private static final <K, V> Map<K, V> mapOf() {
        return emptyMap();
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Iterable<? extends K> keys) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(keys, "keys");
        Map mutableMap = toMutableMap(map);
        O.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, Iterable<? extends K> keys) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(keys, "keys");
        O.removeAll(map.keySet(), keys);
    }

    public static <K, V> Map<K, V> mutableMapOf(C1938s... pairs) {
        kotlin.jvm.internal.E.f(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.mapCapacity(pairs.length));
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K[] keys) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(keys, "keys");
        Map mutableMap = toMutableMap(map);
        O.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, K[] keys) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(keys, "keys");
        O.removeAll(map.keySet(), keys);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, InterfaceC0233q keys) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(keys, "keys");
        Map mutableMap = toMutableMap(map);
        O.removeAll(mutableMap.keySet(), keys);
        return optimizeReadOnlyMap(mutableMap);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, InterfaceC0233q keys) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(keys, "keys");
        O.removeAll(map.keySet(), keys);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Iterable<? extends C1938s> pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        putAll(map, pairs);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Iterable<? extends C1938s> pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        if (map.isEmpty()) {
            return toMap(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, C1938s[] pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        putAll(map, pairs);
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Iterable<? extends C1938s> pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        for (C1938s c1938s : pairs) {
            map.put((Object) c1938s.f9134a, (Object) c1938s.b);
        }
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, C1938s[] pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        if (map.isEmpty()) {
            return toMap(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, pairs);
        return linkedHashMap;
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, InterfaceC0233q pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        putAll(map, pairs);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, InterfaceC0233q pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, pairs);
        return optimizeReadOnlyMap(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(map2, "map");
        map.putAll(map2);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends C1938s> iterable, M destination) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        putAll(destination, iterable);
        return destination;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> toMap(C1938s[] c1938sArr) {
        kotlin.jvm.internal.E.f(c1938sArr, "<this>");
        int length = c1938sArr.length;
        if (length == 0) {
            return emptyMap();
        }
        if (length != 1) {
            return toMap(c1938sArr, new LinkedHashMap(j0.mapCapacity(c1938sArr.length)));
        }
        return j0.mapOf(c1938sArr[0]);
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, InterfaceC0233q pairs) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(pairs, "pairs");
        Iterator<Object> it = pairs.iterator();
        while (it.hasNext()) {
            C1938s c1938s = (C1938s) it.next();
            map.put((Object) c1938s.f9134a, (Object) c1938s.b);
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(C1938s[] c1938sArr, M destination) {
        kotlin.jvm.internal.E.f(c1938sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        putAll(destination, c1938sArr);
        return destination;
    }

    public static final <K, V> Map<K, V> toMap(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return optimizeReadOnlyMap(toMap(interfaceC0233q, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(InterfaceC0233q interfaceC0233q, M destination) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        putAll(destination, interfaceC0233q);
        return destination;
    }

    public static <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMutableMap(map);
        }
        return j0.toSingletonMap(map);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Map<? extends K, ? extends V> map, M destination) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        destination.putAll(map);
        return destination;
    }
}
