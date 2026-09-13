package androidx.collection;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatSetKt {
    private static final MutableFloatSet EmptyFloatSet = new MutableFloatSet(0);
    private static final float[] EmptyFloatArray = new float[0];

    public static final FloatSet emptyFloatSet() {
        return EmptyFloatSet;
    }

    public static final FloatSet floatSetOf() {
        return EmptyFloatSet;
    }

    public static final float[] getEmptyFloatArray() {
        return EmptyFloatArray;
    }

    public static final int hash(float f6) {
        int iHashCode = Float.hashCode(f6) * ScatterMapKt.MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, null);
    }

    public static final FloatSet floatSetOf(float f6) {
        return mutableFloatSetOf(f6);
    }

    public static final MutableFloatSet mutableFloatSetOf(float f6) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(1);
        mutableFloatSet.plusAssign(f6);
        return mutableFloatSet;
    }

    public static final FloatSet floatSetOf(float f6, float f7) {
        return mutableFloatSetOf(f6, f7);
    }

    public static final FloatSet floatSetOf(float f6, float f7, float f8) {
        return mutableFloatSetOf(f6, f7, f8);
    }

    public static final MutableFloatSet mutableFloatSetOf(float f6, float f7) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(2);
        mutableFloatSet.plusAssign(f6);
        mutableFloatSet.plusAssign(f7);
        return mutableFloatSet;
    }

    public static final FloatSet floatSetOf(float... elements) {
        E.f(elements, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(elements.length);
        mutableFloatSet.plusAssign(elements);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float f6, float f7, float f8) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(3);
        mutableFloatSet.plusAssign(f6);
        mutableFloatSet.plusAssign(f7);
        mutableFloatSet.plusAssign(f8);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float... elements) {
        E.f(elements, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(elements.length);
        mutableFloatSet.plusAssign(elements);
        return mutableFloatSet;
    }
}
