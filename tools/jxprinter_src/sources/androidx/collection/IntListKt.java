package androidx.collection;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class IntListKt {
    private static final IntList EmptyIntList = new MutableIntList(0);

    public static final IntList emptyIntList() {
        return EmptyIntList;
    }

    public static final IntList intListOf() {
        return EmptyIntList;
    }

    public static final MutableIntList mutableIntListOf() {
        return new MutableIntList(0, 1, null);
    }

    public static final IntList intListOf(int i5) {
        return mutableIntListOf(i5);
    }

    public static final MutableIntList mutableIntListOf(int i5) {
        MutableIntList mutableIntList = new MutableIntList(1);
        mutableIntList.add(i5);
        return mutableIntList;
    }

    public static final IntList intListOf(int i5, int i6) {
        return mutableIntListOf(i5, i6);
    }

    public static final IntList intListOf(int i5, int i6, int i7) {
        return mutableIntListOf(i5, i6, i7);
    }

    public static final MutableIntList mutableIntListOf(int i5, int i6) {
        MutableIntList mutableIntList = new MutableIntList(2);
        mutableIntList.add(i5);
        mutableIntList.add(i6);
        return mutableIntList;
    }

    public static final IntList intListOf(int... elements) {
        E.f(elements, "elements");
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        mutableIntList.plusAssign(elements);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf(int i5, int i6, int i7) {
        MutableIntList mutableIntList = new MutableIntList(3);
        mutableIntList.add(i5);
        mutableIntList.add(i6);
        mutableIntList.add(i7);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf(int... elements) {
        E.f(elements, "elements");
        MutableIntList mutableIntList = new MutableIntList(elements.length);
        mutableIntList.plusAssign(elements);
        return mutableIntList;
    }
}
