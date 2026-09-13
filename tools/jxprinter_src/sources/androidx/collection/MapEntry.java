package androidx.collection;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
final class MapEntry<K, V> implements Map.Entry<K, V>, P3.a {
    private final K key;
    private final V value;

    public MapEntry(K k6, V v6) {
        this.key = k6;
        this.value = v6;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
