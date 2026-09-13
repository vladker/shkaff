package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.KeyValue;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractKeyValue<K, V> implements KeyValue<K, V> {
    private K key;
    private V value;

    public AbstractKeyValue(K k6, V v6) {
        this.key = k6;
        this.value = v6;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    public K setKey(K k6) {
        K k7 = this.key;
        this.key = k6;
        return k7;
    }

    public V setValue(V v6) {
        V v7 = this.value;
        this.value = v6;
        return v7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(Chars.EQ);
        sb.append(getValue());
        return sb.toString();
    }
}
