package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.EMPTY_LIST;
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k6, @NonNull V v6, @NonNull K k7, @NonNull V v7, @NonNull K k8, @NonNull V v8) {
        Map mapZzb = zzb(3, false);
        mapZzb.put(k6, v6);
        mapZzb.put(k7, v7);
        mapZzb.put(k8, v8);
        return Collections.unmodifiableMap(mapZzb);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(@NonNull K[] kArr, @NonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 44 + String.valueOf(length2).length());
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length == 0) {
            return Collections.EMPTY_MAP;
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map mapZzb = zzb(length, false);
        for (int i5 = 0; i5 < kArr.length; i5++) {
            mapZzb.put(kArr[i5], vArr[i5]);
        }
        return Collections.unmodifiableMap(mapZzb);
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i5) {
        return i5 == 0 ? new ArraySet() : zza(i5, true);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T t6, @NonNull T t7, @NonNull T t8) {
        Set setZza = zza(3, false);
        setZza.add(t6);
        setZza.add(t7);
        setZza.add(t8);
        return Collections.unmodifiableSet(setZza);
    }

    private static Set zza(int i5, boolean z6) {
        if (i5 <= (true != z6 ? 256 : 128)) {
            return new ArraySet(i5);
        }
        return new HashSet(i5, true != z6 ? 1.0f : 0.75f);
    }

    private static Map zzb(int i5, boolean z6) {
        return i5 <= 256 ? new ArrayMap(i5) : new HashMap(i5, 1.0f);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T t6) {
        return Collections.singletonList(t6);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.EMPTY_LIST;
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k6, @NonNull V v6, @NonNull K k7, @NonNull V v7, @NonNull K k8, @NonNull V v8, @NonNull K k9, @NonNull V v9, @NonNull K k10, @NonNull V v10, @NonNull K k11, @NonNull V v11) {
        Map mapZzb = zzb(6, false);
        mapZzb.put(k6, v6);
        mapZzb.put(k7, v7);
        mapZzb.put(k8, v8);
        mapZzb.put(k9, v9);
        mapZzb.put(k10, v10);
        mapZzb.put(k11, v11);
        return Collections.unmodifiableMap(mapZzb);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.EMPTY_SET;
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t6 = tArr[0];
            T t7 = tArr[1];
            Set setZza = zza(2, false);
            setZza.add(t6);
            setZza.add(t7);
            return Collections.unmodifiableSet(setZza);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set setZza2 = zza(length, false);
            Collections.addAll(setZza2, tArr);
            return Collections.unmodifiableSet(setZza2);
        }
        T t8 = tArr[0];
        T t9 = tArr[1];
        T t10 = tArr[2];
        T t11 = tArr[3];
        Set setZza3 = zza(4, false);
        setZza3.add(t8);
        setZza3.add(t9);
        setZza3.add(t10);
        setZza3.add(t11);
        return Collections.unmodifiableSet(setZza3);
    }
}
