package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(Object obj);

    @Override // 
    List<V> get(@ParametricNullness K k6);

    @Override // 
    @CanIgnoreReturnValue
    List<V> removeAll(Object obj);

    @Override // 
    @CanIgnoreReturnValue
    List<V> replaceValues(@ParametricNullness K k6, Iterable<? extends V> iterable);
}
