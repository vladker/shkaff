package androidx.datastore.preferences.core;

import A3.T;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.E;
import p007a4.C0276f0;
import p007a4.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Actual_jvmAndroidKt {
    public static final <T> Set<T> immutableCopyOfSet(Set<? extends T> set) {
        E.f(set, "set");
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(T.toSet(set));
        E.e(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
        return setUnmodifiableSet;
    }

    public static final <K, V> Map<K, V> immutableMap(Map<K, ? extends V> map) {
        E.f(map, "map");
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        E.e(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }

    public static final F ioDispatcher() {
        return C0276f0.getIO();
    }
}
