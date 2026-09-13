package p147z3;

import U3.G;
import U3.M;
import androidx.collection.a;
import com.google.common.primitives.UnsignedBytes;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D implements Comparable {
    public static final C Companion = new C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f9122a;

    private /* synthetic */ D(byte b) {
        this.f9122a = b;
    }

    public static final /* synthetic */ D a(byte b) {
        return new D(b);
    }

    /* JADX INFO: renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m1125and7apg3OU(byte b, byte b6) {
        return m1131constructorimpl((byte) (b & b6));
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m1126compareTo7apg3OU(byte b) {
        return E.h(this.f9122a & UnsignedBytes.MAX_VALUE, b & UnsignedBytes.MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m1128compareToVKZWuLQ(byte b, long j6) {
        return Long.compareUnsigned(J.m1247constructorimpl(((long) b) & 255), j6);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m1129compareToWZ4Q5Ns(byte b, int i5) {
        return Integer.compareUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), i5);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m1130compareToxj2QHRw(byte b, short s6) {
        return E.h(b & UnsignedBytes.MAX_VALUE, s6 & 65535);
    }

    /* JADX INFO: renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m1132decw2LRezQ(byte b) {
        return m1131constructorimpl((byte) (b - 1));
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m1133div7apg3OU(byte b, byte b6) {
        return Integer.divideUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m1134divVKZWuLQ(byte b, long j6) {
        return Long.divideUnsigned(J.m1247constructorimpl(((long) b) & 255), j6);
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m1135divWZ4Q5Ns(byte b, int i5) {
        return Integer.divideUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), i5);
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m1136divxj2QHRw(byte b, short s6) {
        return Integer.divideUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m1137floorDiv7apg3OU(byte b, byte b6) {
        return Integer.divideUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m1138floorDivVKZWuLQ(byte b, long j6) {
        return Long.divideUnsigned(J.m1247constructorimpl(((long) b) & 255), j6);
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m1139floorDivWZ4Q5Ns(byte b, int i5) {
        return Integer.divideUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), i5);
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m1140floorDivxj2QHRw(byte b, short s6) {
        return Integer.divideUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m1141incw2LRezQ(byte b) {
        return m1131constructorimpl((byte) (b + 1));
    }

    /* JADX INFO: renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m1142invw2LRezQ(byte b) {
        return m1131constructorimpl((byte) (~b));
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m1143minus7apg3OU(byte b, byte b6) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) - G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m1144minusVKZWuLQ(byte b, long j6) {
        return J.m1247constructorimpl(J.m1247constructorimpl(((long) b) & 255) - j6);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1145minusWZ4Q5Ns(byte b, int i5) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) - i5);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m1146minusxj2QHRw(byte b, short s6) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) - G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m1147mod7apg3OU(byte b, byte b6) {
        return m1131constructorimpl((byte) Integer.remainderUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m1148modVKZWuLQ(byte b, long j6) {
        return Long.remainderUnsigned(J.m1247constructorimpl(((long) b) & 255), j6);
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m1149modWZ4Q5Ns(byte b, int i5) {
        return Integer.remainderUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), i5);
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m1150modxj2QHRw(byte b, short s6) {
        return N.m1306constructorimpl((short) Integer.remainderUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(s6 & 65535)));
    }

    /* JADX INFO: renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m1151or7apg3OU(byte b, byte b6) {
        return m1131constructorimpl((byte) (b | b6));
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m1152plus7apg3OU(byte b, byte b6) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE) + G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m1153plusVKZWuLQ(byte b, long j6) {
        return J.m1247constructorimpl(J.m1247constructorimpl(((long) b) & 255) + j6);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1154plusWZ4Q5Ns(byte b, int i5) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) + i5);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m1155plusxj2QHRw(byte b, short s6) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s6 & 65535) + G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final G m1156rangeTo7apg3OU(byte b, byte b6) {
        return new G(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE), 1);
    }

    /* JADX INFO: renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final G m1157rangeUntil7apg3OU(byte b, byte b6) {
        return M.m853untilJ1ME1BU(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m1158rem7apg3OU(byte b, byte b6) {
        return Integer.remainderUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m1159remVKZWuLQ(byte b, long j6) {
        return Long.remainderUnsigned(J.m1247constructorimpl(((long) b) & 255), j6);
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m1160remWZ4Q5Ns(byte b, int i5) {
        return Integer.remainderUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), i5);
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m1161remxj2QHRw(byte b, short s6) {
        return Integer.remainderUnsigned(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m1162times7apg3OU(byte b, byte b6) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE) * G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m1163timesVKZWuLQ(byte b, long j6) {
        return a.d(((long) b) & 255, j6);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m1164timesWZ4Q5Ns(byte b, int i5) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) * i5);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m1165timesxj2QHRw(byte b, short s6) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s6 & 65535) * G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m1167toDoubleimpl(byte b) {
        return T.uintToDouble(b & UnsignedBytes.MAX_VALUE);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m1168toFloatimpl(byte b) {
        return (float) T.uintToDouble(b & UnsignedBytes.MAX_VALUE);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m1169toIntimpl(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m1170toLongimpl(byte b) {
        return ((long) b) & 255;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m1171toShortimpl(byte b) {
        return (short) (b & 255);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1172toStringimpl(byte b) {
        return String.valueOf(b & UnsignedBytes.MAX_VALUE);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m1174toUIntpVg5ArA(byte b) {
        return G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m1175toULongsVKNKU(byte b) {
        return J.m1247constructorimpl(((long) b) & 255);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m1176toUShortMh2AYeg(byte b) {
        return N.m1306constructorimpl((short) (b & 255));
    }

    /* JADX INFO: renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m1177xor7apg3OU(byte b, byte b6) {
        return m1131constructorimpl((byte) (b ^ b6));
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return E.h(this.f9122a & UnsignedBytes.MAX_VALUE, ((D) obj).f9122a & UnsignedBytes.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof D) {
            return this.f9122a == ((D) obj).f9122a;
        }
        return false;
    }

    public final int hashCode() {
        return Byte.hashCode(this.f9122a);
    }

    public String toString() {
        return m1172toStringimpl(this.f9122a);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m1127compareTo7apg3OU(byte b, byte b6) {
        return E.h(b & UnsignedBytes.MAX_VALUE, b6 & UnsignedBytes.MAX_VALUE);
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte m1131constructorimpl(byte b) {
        return b;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m1166toByteimpl(byte b) {
        return b;
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m1173toUBytew2LRezQ(byte b) {
        return b;
    }
}
