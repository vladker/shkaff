package androidx.collection;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatListKt {
    private static final FloatList EmptyFloatList = new MutableFloatList(0);

    public static final FloatList emptyFloatList() {
        return EmptyFloatList;
    }

    public static final FloatList floatListOf() {
        return EmptyFloatList;
    }

    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, null);
    }

    public static final FloatList floatListOf(float f6) {
        return mutableFloatListOf(f6);
    }

    public static final MutableFloatList mutableFloatListOf(float f6) {
        MutableFloatList mutableFloatList = new MutableFloatList(1);
        mutableFloatList.add(f6);
        return mutableFloatList;
    }

    public static final FloatList floatListOf(float f6, float f7) {
        return mutableFloatListOf(f6, f7);
    }

    public static final FloatList floatListOf(float f6, float f7, float f8) {
        return mutableFloatListOf(f6, f7, f8);
    }

    public static final MutableFloatList mutableFloatListOf(float f6, float f7) {
        MutableFloatList mutableFloatList = new MutableFloatList(2);
        mutableFloatList.add(f6);
        mutableFloatList.add(f7);
        return mutableFloatList;
    }

    public static final FloatList floatListOf(float... elements) {
        E.f(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float f6, float f7, float f8) {
        MutableFloatList mutableFloatList = new MutableFloatList(3);
        mutableFloatList.add(f6);
        mutableFloatList.add(f7);
        mutableFloatList.add(f8);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float... elements) {
        E.f(elements, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(elements.length);
        mutableFloatList.plusAssign(elements);
        return mutableFloatList;
    }
}
