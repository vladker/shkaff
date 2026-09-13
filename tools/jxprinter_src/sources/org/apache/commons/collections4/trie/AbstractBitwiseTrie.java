package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import org.apache.commons.collections4.Trie;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractBitwiseTrie<K, V> extends AbstractMap<K, V> implements Trie<K, V>, Serializable {
    private static final long serialVersionUID = 5826987063535505652L;
    private final KeyAnalyzer<? super K> keyAnalyzer;

    public AbstractBitwiseTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        if (keyAnalyzer == null) {
            throw new NullPointerException("keyAnalyzer");
        }
        this.keyAnalyzer = keyAnalyzer;
    }

    public static boolean compare(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final int bitIndex(K k6, K k7) {
        return this.keyAnalyzer.bitIndex(k6, 0, lengthInBits(k6), k7, 0, lengthInBits(k7));
    }

    public final int bitsPerElement() {
        return this.keyAnalyzer.bitsPerElement();
    }

    public final boolean compareKeys(K k6, K k7) {
        if (k6 == null) {
            return k7 == null;
        }
        return k7 != null && this.keyAnalyzer.compare(k6, k7) == 0;
    }

    public KeyAnalyzer<? super K> getKeyAnalyzer() {
        return this.keyAnalyzer;
    }

    public final boolean isBitSet(K k6, int i5, int i6) {
        if (k6 == null) {
            return false;
        }
        return this.keyAnalyzer.isBitSet(k6, i5, i6);
    }

    public final int lengthInBits(K k6) {
        if (k6 == null) {
            return 0;
        }
        return this.keyAnalyzer.lengthInBits(k6);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder("Trie[");
        sb.append(size());
        sb.append("]={\n");
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append("  ");
            sb.append(entry);
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class BasicEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = -944364551314110330L;
        protected K key;
        protected V value;

        public BasicEntry(K k6) {
            this.key = k6;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractBitwiseTrie.compare(this.key, entry.getKey()) && AbstractBitwiseTrie.compare(this.value, entry.getValue());
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
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        public V setKeyValue(K k6, V v6) {
            this.key = k6;
            return setValue(v6);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v6) {
            V v7 = this.value;
            this.value = v6;
            return v7;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public BasicEntry(K k6, V v6) {
            this.key = k6;
            this.value = v6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final K castKey(Object obj) {
        return obj;
    }
}
