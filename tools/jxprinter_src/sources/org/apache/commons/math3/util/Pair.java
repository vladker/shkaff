package org.apache.commons.math3.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K k6, V v6) {
        this.key = k6;
        this.value = v6;
    }

    public static <K, V> Pair<K, V> create(K k6, V v6) {
        return new Pair<>(k6, v6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        K k6 = this.key;
        if (k6 != null ? k6.equals(pair.key) : pair.key == null) {
            V v6 = this.value;
            V v7 = pair.value;
            if (v6 != null ? v6.equals(v7) : v7 == null) {
                return true;
            }
        }
        return false;
    }

    public K getFirst() {
        return this.key;
    }

    public K getKey() {
        return this.key;
    }

    public V getSecond() {
        return this.value;
    }

    public V getValue() {
        return this.value;
    }

    public int hashCode() {
        K k6 = this.key;
        int iHashCode = k6 == null ? 0 : k6.hashCode();
        V v6 = this.value;
        int iHashCode2 = v6 != null ? v6.hashCode() : 0;
        return ((iHashCode * 37) + iHashCode2) ^ (iHashCode2 >>> 16);
    }

    public String toString() {
        return "[" + getKey() + ", " + getValue() + "]";
    }

    public Pair(Pair<? extends K, ? extends V> pair) {
        this(pair.getKey(), pair.getValue());
    }
}
