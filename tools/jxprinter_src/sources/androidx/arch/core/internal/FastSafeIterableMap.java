package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap<>();

    @Nullable
    public Map.Entry<K, V> ceil(K k6) {
        if (contains(k6)) {
            return this.mHashMap.get(k6).mPrevious;
        }
        return null;
    }

    public boolean contains(K k6) {
        return this.mHashMap.containsKey(k6);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    @Nullable
    public SafeIterableMap.Entry<K, V> get(K k6) {
        return this.mHashMap.get(k6);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(@NonNull K k6, @NonNull V v6) {
        SafeIterableMap.Entry<K, V> entry = get(k6);
        if (entry != null) {
            return entry.mValue;
        }
        this.mHashMap.put(k6, put(k6, v6));
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(@NonNull K k6) {
        V v6 = (V) super.remove(k6);
        this.mHashMap.remove(k6);
        return v6;
    }
}
