package androidx.collection;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class LongSetKt {
    private static final MutableLongSet EmptyLongSet = new MutableLongSet(0);
    private static final long[] EmptyLongArray = new long[0];

    public static final LongSet emptyLongSet() {
        return EmptyLongSet;
    }

    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    public static final int hash(long j6) {
        int iHashCode = Long.hashCode(j6) * ScatterMapKt.MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final LongSet longSetOf() {
        return EmptyLongSet;
    }

    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, null);
    }

    public static final LongSet longSetOf(long j6) {
        return mutableLongSetOf(j6);
    }

    public static final MutableLongSet mutableLongSetOf(long j6) {
        MutableLongSet mutableLongSet = new MutableLongSet(1);
        mutableLongSet.plusAssign(j6);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long j6, long j7) {
        return mutableLongSetOf(j6, j7);
    }

    public static final LongSet longSetOf(long j6, long j7, long j8) {
        return mutableLongSetOf(j6, j7, j8);
    }

    public static final MutableLongSet mutableLongSetOf(long j6, long j7) {
        MutableLongSet mutableLongSet = new MutableLongSet(2);
        mutableLongSet.plusAssign(j6);
        mutableLongSet.plusAssign(j7);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long... elements) {
        E.f(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long j6, long j7, long j8) {
        MutableLongSet mutableLongSet = new MutableLongSet(3);
        mutableLongSet.plusAssign(j6);
        mutableLongSet.plusAssign(j7);
        mutableLongSet.plusAssign(j8);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long... elements) {
        E.f(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }
}
