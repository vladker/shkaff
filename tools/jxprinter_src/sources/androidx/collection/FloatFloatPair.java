package androidx.collection;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatFloatPair {
    public final long packedValue;

    private /* synthetic */ FloatFloatPair(long j6) {
        this.packedValue = j6;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FloatFloatPair m940boximpl(long j6) {
        return new FloatFloatPair(j6);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m941component1impl(long j6) {
        return Float.intBitsToFloat((int) (j6 >> 32));
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m942component2impl(long j6) {
        return Float.intBitsToFloat((int) (j6 & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m944constructorimpl(long j6) {
        return j6;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m945equalsimpl(long j6, Object obj) {
        return (obj instanceof FloatFloatPair) && j6 == ((FloatFloatPair) obj).m951unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m946equalsimpl0(long j6, long j7) {
        return j6 == j7;
    }

    /* JADX INFO: renamed from: getFirst-impl, reason: not valid java name */
    public static final float m947getFirstimpl(long j6) {
        return Float.intBitsToFloat((int) (j6 >> 32));
    }

    /* JADX INFO: renamed from: getSecond-impl, reason: not valid java name */
    public static final float m948getSecondimpl(long j6) {
        return Float.intBitsToFloat((int) (j6 & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m949hashCodeimpl(long j6) {
        return Long.hashCode(j6);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m950toStringimpl(long j6) {
        return "(" + Float.intBitsToFloat((int) (j6 >> 32)) + ", " + Float.intBitsToFloat((int) (j6 & KeyboardMap.kValueMask)) + ')';
    }

    public boolean equals(Object obj) {
        return m945equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m949hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m950toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m951unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m943constructorimpl(float f6, float f7) {
        return m944constructorimpl((((long) Float.floatToRawIntBits(f7)) & KeyboardMap.kValueMask) | (Float.floatToRawIntBits(f6) << 32));
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }
}
