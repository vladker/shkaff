package org.apache.commons.collections4;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Put<K, V> {
    void clear();

    Object put(K k6, V v6);

    void putAll(Map<? extends K, ? extends V> map);
}
