package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.commons.collections4.multimap.TransformedMultiValuedMap;
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiMapUtils {
    public static final MultiValuedMap EMPTY_MULTI_VALUED_MAP = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(new ArrayListValuedHashMap(0, 0));

    private MultiMapUtils() {
    }

    public static <K, V> MultiValuedMap<K, V> emptyIfNull(MultiValuedMap<K, V> multiValuedMap) {
        return multiValuedMap == null ? EMPTY_MULTI_VALUED_MAP : multiValuedMap;
    }

    public static <K, V> MultiValuedMap<K, V> emptyMultiValuedMap() {
        return EMPTY_MULTI_VALUED_MAP;
    }

    public static <K, V> Collection<V> getCollection(MultiValuedMap<K, V> multiValuedMap, K k6) {
        if (multiValuedMap != null) {
            return multiValuedMap.get(k6);
        }
        return null;
    }

    public static <K, V> Bag<V> getValuesAsBag(MultiValuedMap<K, V> multiValuedMap, K k6) {
        if (multiValuedMap == null) {
            return null;
        }
        Collection<V> collection = multiValuedMap.get(k6);
        return collection instanceof Bag ? (Bag) collection : new HashBag(collection);
    }

    public static <K, V> List<V> getValuesAsList(MultiValuedMap<K, V> multiValuedMap, K k6) {
        if (multiValuedMap == null) {
            return null;
        }
        Collection<V> collection = multiValuedMap.get(k6);
        return collection instanceof List ? (List) collection : new ArrayList(collection);
    }

    public static <K, V> Set<V> getValuesAsSet(MultiValuedMap<K, V> multiValuedMap, K k6) {
        if (multiValuedMap == null) {
            return null;
        }
        Collection<V> collection = multiValuedMap.get(k6);
        return collection instanceof Set ? (Set) collection : new HashSet(collection);
    }

    public static boolean isEmpty(MultiValuedMap<?, ?> multiValuedMap) {
        return multiValuedMap == null || multiValuedMap.isEmpty();
    }

    public static <K, V> ListValuedMap<K, V> newListValuedHashMap() {
        return new ArrayListValuedHashMap();
    }

    public static <K, V> SetValuedMap<K, V> newSetValuedHashMap() {
        return new HashSetValuedHashMap();
    }

    public static <K, V> MultiValuedMap<K, V> transformedMultiValuedMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedMultiValuedMap.transformingMap(multiValuedMap, transformer, transformer2);
    }

    public static <K, V> MultiValuedMap<K, V> unmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        return UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(multiValuedMap);
    }
}
