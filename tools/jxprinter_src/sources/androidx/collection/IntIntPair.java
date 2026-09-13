package androidx.collection;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class IntIntPair {
    public final long packedValue;

    private /* synthetic */ IntIntPair(long j6) {
        this.packedValue = j6;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntIntPair m952boximpl(long j6) {
        return new IntIntPair(j6);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m953component1impl(long j6) {
        return (int) (j6 >> 32);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m954component2impl(long j6) {
        return (int) (j6 & KeyboardMap.kValueMask);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m956constructorimpl(long j6) {
        return j6;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m957equalsimpl(long j6, Object obj) {
        return (obj instanceof IntIntPair) && j6 == ((IntIntPair) obj).m963unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m958equalsimpl0(long j6, long j7) {
        return j6 == j7;
    }

    /* JADX INFO: renamed from: getFirst-impl, reason: not valid java name */
    public static final int m959getFirstimpl(long j6) {
        return (int) (j6 >> 32);
    }

    /* JADX INFO: renamed from: getSecond-impl, reason: not valid java name */
    public static final int m960getSecondimpl(long j6) {
        return (int) (j6 & KeyboardMap.kValueMask);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m961hashCodeimpl(long j6) {
        return Long.hashCode(j6);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m962toStringimpl(long j6) {
        return "(" + m959getFirstimpl(j6) + ", " + m960getSecondimpl(j6) + ')';
    }

    public boolean equals(Object obj) {
        return m957equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m961hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m962toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m963unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m955constructorimpl(int i5, int i6) {
        return m956constructorimpl((((long) i6) & KeyboardMap.kValueMask) | (((long) i5) << 32));
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }
}
