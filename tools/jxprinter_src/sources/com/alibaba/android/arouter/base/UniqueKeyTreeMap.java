package com.alibaba.android.arouter.base;

import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class UniqueKeyTreeMap<K, V> extends TreeMap<K, V> {
    private String tipText;

    public UniqueKeyTreeMap(String str) {
        this.tipText = str;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public V put(K k6, V v6) {
        if (containsKey(k6)) {
            throw new RuntimeException(String.format(this.tipText, k6));
        }
        return (V) super.put(k6, v6);
    }
}
