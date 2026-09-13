package p147z3;

import U3.M;
import androidx.collection.a;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G implements Comparable {
    public static final F Companion = new F();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9124a;

    private /* synthetic */ G(int i5) {
        this.f9124a = i5;
    }

    public static final /* synthetic */ G a(int i5) {
        return new G(i5);
    }

    /* JADX INFO: renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m1182andWZ4Q5Ns(int i5, int i6) {
        return m1188constructorimpl(i5 & i6);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m1183compareTo7apg3OU(int i5, byte b) {
        return Integer.compareUnsigned(i5, m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m1184compareToVKZWuLQ(int i5, long j6) {
        return Long.compareUnsigned(J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask), j6);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m1185compareToWZ4Q5Ns(int i5) {
        return T.uintCompare(this.f9124a, i5);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m1187compareToxj2QHRw(int i5, short s6) {
        return Integer.compareUnsigned(i5, m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m1189decpVg5ArA(int i5) {
        return m1188constructorimpl(i5 - 1);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m1190div7apg3OU(int i5, byte b) {
        return Integer.divideUnsigned(i5, m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m1191divVKZWuLQ(int i5, long j6) {
        return Long.divideUnsigned(J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask), j6);
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m1192divWZ4Q5Ns(int i5, int i6) {
        return T.m1357uintDivideJ1ME1BU(i5, i6);
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m1193divxj2QHRw(int i5, short s6) {
        return Integer.divideUnsigned(i5, m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m1194floorDiv7apg3OU(int i5, byte b) {
        return Integer.divideUnsigned(i5, m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m1195floorDivVKZWuLQ(int i5, long j6) {
        return Long.divideUnsigned(J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask), j6);
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m1196floorDivWZ4Q5Ns(int i5, int i6) {
        return Integer.divideUnsigned(i5, i6);
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m1197floorDivxj2QHRw(int i5, short s6) {
        return Integer.divideUnsigned(i5, m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m1198incpVg5ArA(int i5) {
        return m1188constructorimpl(i5 + 1);
    }

    /* JADX INFO: renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m1199invpVg5ArA(int i5) {
        return m1188constructorimpl(~i5);
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m1200minus7apg3OU(int i5, byte b) {
        return m1188constructorimpl(i5 - m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m1201minusVKZWuLQ(int i5, long j6) {
        return J.m1247constructorimpl(J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask) - j6);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1202minusWZ4Q5Ns(int i5, int i6) {
        return m1188constructorimpl(i5 - i6);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m1203minusxj2QHRw(int i5, short s6) {
        return m1188constructorimpl(i5 - m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m1204mod7apg3OU(int i5, byte b) {
        return D.m1131constructorimpl((byte) Integer.remainderUnsigned(i5, m1188constructorimpl(b & UnsignedBytes.MAX_VALUE)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m1205modVKZWuLQ(int i5, long j6) {
        return Long.remainderUnsigned(J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask), j6);
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m1206modWZ4Q5Ns(int i5, int i6) {
        return Integer.remainderUnsigned(i5, i6);
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m1207modxj2QHRw(int i5, short s6) {
        return N.m1306constructorimpl((short) Integer.remainderUnsigned(i5, m1188constructorimpl(s6 & 65535)));
    }

    /* JADX INFO: renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m1208orWZ4Q5Ns(int i5, int i6) {
        return m1188constructorimpl(i5 | i6);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m1209plus7apg3OU(int i5, byte b) {
        return m1188constructorimpl(m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) + i5);
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m1210plusVKZWuLQ(int i5, long j6) {
        return J.m1247constructorimpl(J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask) + j6);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1211plusWZ4Q5Ns(int i5, int i6) {
        return m1188constructorimpl(i5 + i6);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m1212plusxj2QHRw(int i5, short s6) {
        return m1188constructorimpl(m1188constructorimpl(s6 & 65535) + i5);
    }

    /* JADX INFO: renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final U3.G m1213rangeToWZ4Q5Ns(int i5, int i6) {
        return new U3.G(i5, i6, 1);
    }

    /* JADX INFO: renamed from: rangeUntil-WZ4Q5Ns, reason: not valid java name */
    private static final U3.G m1214rangeUntilWZ4Q5Ns(int i5, int i6) {
        return M.m853untilJ1ME1BU(i5, i6);
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m1215rem7apg3OU(int i5, byte b) {
        return Integer.remainderUnsigned(i5, m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m1216remVKZWuLQ(int i5, long j6) {
        return Long.remainderUnsigned(J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask), j6);
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m1217remWZ4Q5Ns(int i5, int i6) {
        return T.m1358uintRemainderJ1ME1BU(i5, i6);
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m1218remxj2QHRw(int i5, short s6) {
        return Integer.remainderUnsigned(i5, m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m1219shlpVg5ArA(int i5, int i6) {
        return m1188constructorimpl(i5 << i6);
    }

    /* JADX INFO: renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m1220shrpVg5ArA(int i5, int i6) {
        return m1188constructorimpl(i5 >>> i6);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m1221times7apg3OU(int i5, byte b) {
        return m1188constructorimpl(m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) * i5);
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m1222timesVKZWuLQ(int i5, long j6) {
        return a.d(((long) i5) & KeyboardMap.kValueMask, j6);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m1223timesWZ4Q5Ns(int i5, int i6) {
        return m1188constructorimpl(i5 * i6);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m1224timesxj2QHRw(int i5, short s6) {
        return m1188constructorimpl(m1188constructorimpl(s6 & 65535) * i5);
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m1225toByteimpl(int i5) {
        return (byte) i5;
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m1226toDoubleimpl(int i5) {
        return T.uintToDouble(i5);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m1227toFloatimpl(int i5) {
        return (float) T.uintToDouble(i5);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m1229toLongimpl(int i5) {
        return ((long) i5) & KeyboardMap.kValueMask;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m1230toShortimpl(int i5) {
        return (short) i5;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1231toStringimpl(int i5) {
        return String.valueOf(((long) i5) & KeyboardMap.kValueMask);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m1232toUBytew2LRezQ(int i5) {
        return D.m1131constructorimpl((byte) i5);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m1234toULongsVKNKU(int i5) {
        return J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m1235toUShortMh2AYeg(int i5) {
        return N.m1306constructorimpl((short) i5);
    }

    /* JADX INFO: renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m1236xorWZ4Q5Ns(int i5, int i6) {
        return m1188constructorimpl(i5 ^ i6);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return T.uintCompare(this.f9124a, ((G) obj).f9124a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof G) {
            return this.f9124a == ((G) obj).f9124a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9124a);
    }

    public String toString() {
        return m1231toStringimpl(this.f9124a);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m1186compareToWZ4Q5Ns(int i5, int i6) {
        return T.uintCompare(i5, i6);
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1188constructorimpl(int i5) {
        return i5;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m1228toIntimpl(int i5) {
        return i5;
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m1233toUIntpVg5ArA(int i5) {
        return i5;
    }
}
