package org.apache.logging.log4j.util;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ReadOnlyStringMap extends Serializable {
    boolean containsKey(String str);

    <V> void forEach(BiConsumer<String, ? super V> biConsumer);

    <V, S> void forEach(TriConsumer<String, ? super V, S> triConsumer, S s6);

    <V> V getValue(String str);

    boolean isEmpty();

    int size();

    Map<String, String> toMap();
}
