package androidx.collection;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class IntSetKt {
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);
    private static final int[] EmptyIntArray = new int[0];

    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final int hash(int i5) {
        int iHashCode = Integer.hashCode(i5) * ScatterMapKt.MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    public static final IntSet intSetOf(int i5) {
        return mutableIntSetOf(i5);
    }

    public static final MutableIntSet mutableIntSetOf(int i5) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i5);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int i5, int i6) {
        return mutableIntSetOf(i5, i6);
    }

    public static final IntSet intSetOf(int i5, int i6, int i7) {
        return mutableIntSetOf(i5, i6, i7);
    }

    public static final MutableIntSet mutableIntSetOf(int i5, int i6) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i5);
        mutableIntSet.plusAssign(i6);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int... elements) {
        E.f(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i5, int i6, int i7) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i5);
        mutableIntSet.plusAssign(i6);
        mutableIntSet.plusAssign(i7);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int... elements) {
        E.f(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }
}
