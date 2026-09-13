package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Platform {
    private Platform() {
    }

    public static <T> T[] copy(Object[] objArr, int i5, int i6, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i5, i6, tArr.getClass());
    }

    public static <T> T[] newArray(T[] tArr, int i5) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i5));
    }

    public static <K, V> Map<K, V> newHashMapWithExpectedSize(int i5) {
        return CompactHashMap.createWithExpectedSize(i5);
    }

    public static <E> Set<E> newHashSetWithExpectedSize(int i5) {
        return CompactHashSet.createWithExpectedSize(i5);
    }

    public static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i5) {
        return CompactLinkedHashMap.createWithExpectedSize(i5);
    }

    public static <E> Set<E> newLinkedHashSetWithExpectedSize(int i5) {
        return CompactLinkedHashSet.createWithExpectedSize(i5);
    }

    public static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    public static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    public static void checkGwtRpcEnabled() {
    }

    public static int reduceExponentIfGwt(int i5) {
        return i5;
    }

    public static int reduceIterationsIfGwt(int i5) {
        return i5;
    }
}
