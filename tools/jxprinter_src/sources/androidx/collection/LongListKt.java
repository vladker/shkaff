package androidx.collection;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class LongListKt {
    private static final LongList EmptyLongList = new MutableLongList(0);

    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    public static final LongList longListOf() {
        return EmptyLongList;
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    public static final LongList longListOf(long j6) {
        return mutableLongListOf(j6);
    }

    public static final MutableLongList mutableLongListOf(long j6) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j6);
        return mutableLongList;
    }

    public static final LongList longListOf(long j6, long j7) {
        return mutableLongListOf(j6, j7);
    }

    public static final LongList longListOf(long j6, long j7, long j8) {
        return mutableLongListOf(j6, j7, j8);
    }

    public static final MutableLongList mutableLongListOf(long j6, long j7) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j6);
        mutableLongList.add(j7);
        return mutableLongList;
    }

    public static final LongList longListOf(long... elements) {
        E.f(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j6, long j7, long j8) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j6);
        mutableLongList.add(j7);
        mutableLongList.add(j8);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long... elements) {
        E.f(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.plusAssign(elements);
        return mutableLongList;
    }
}
