package p147z3;

import U3.G;
import U3.M;
import androidx.collection.a;
import com.google.common.primitives.UnsignedBytes;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N implements Comparable {
    public static final M Companion = new M();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f9128a;

    private /* synthetic */ N(short s6) {
        this.f9128a = s6;
    }

    public static final /* synthetic */ N a(short s6) {
        return new N(s6);
    }

    /* JADX INFO: renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m1300andxj2QHRw(short s6, short s7) {
        return m1306constructorimpl((short) (s6 & s7));
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m1301compareTo7apg3OU(short s6, byte b) {
        return E.h(s6 & 65535, b & UnsignedBytes.MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m1302compareToVKZWuLQ(short s6, long j6) {
        return Long.compareUnsigned(J.m1247constructorimpl(((long) s6) & 65535), j6);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m1303compareToWZ4Q5Ns(short s6, int i5) {
        return Integer.compareUnsigned(G.m1188constructorimpl(s6 & 65535), i5);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m1304compareToxj2QHRw(short s6) {
        return E.h(this.f9128a & 65535, s6 & 65535);
    }

    /* JADX INFO: renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m1307decMh2AYeg(short s6) {
        return m1306constructorimpl((short) (s6 - 1));
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m1308div7apg3OU(short s6, byte b) {
        return Integer.divideUnsigned(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m1309divVKZWuLQ(short s6, long j6) {
        return Long.divideUnsigned(J.m1247constructorimpl(((long) s6) & 65535), j6);
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m1310divWZ4Q5Ns(short s6, int i5) {
        return Integer.divideUnsigned(G.m1188constructorimpl(s6 & 65535), i5);
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m1311divxj2QHRw(short s6, short s7) {
        return Integer.divideUnsigned(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(s7 & 65535));
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m1312floorDiv7apg3OU(short s6, byte b) {
        return Integer.divideUnsigned(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m1313floorDivVKZWuLQ(short s6, long j6) {
        return Long.divideUnsigned(J.m1247constructorimpl(((long) s6) & 65535), j6);
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m1314floorDivWZ4Q5Ns(short s6, int i5) {
        return Integer.divideUnsigned(G.m1188constructorimpl(s6 & 65535), i5);
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m1315floorDivxj2QHRw(short s6, short s7) {
        return Integer.divideUnsigned(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(s7 & 65535));
    }

    /* JADX INFO: renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m1316incMh2AYeg(short s6) {
        return m1306constructorimpl((short) (s6 + 1));
    }

    /* JADX INFO: renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m1317invMh2AYeg(short s6) {
        return m1306constructorimpl((short) (~s6));
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m1318minus7apg3OU(short s6, byte b) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s6 & 65535) - G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m1319minusVKZWuLQ(short s6, long j6) {
        return J.m1247constructorimpl(J.m1247constructorimpl(((long) s6) & 65535) - j6);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1320minusWZ4Q5Ns(short s6, int i5) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s6 & 65535) - i5);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m1321minusxj2QHRw(short s6, short s7) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s6 & 65535) - G.m1188constructorimpl(s7 & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m1322mod7apg3OU(short s6, byte b) {
        return D.m1131constructorimpl((byte) Integer.remainderUnsigned(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m1323modVKZWuLQ(short s6, long j6) {
        return Long.remainderUnsigned(J.m1247constructorimpl(((long) s6) & 65535), j6);
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m1324modWZ4Q5Ns(short s6, int i5) {
        return Integer.remainderUnsigned(G.m1188constructorimpl(s6 & 65535), i5);
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m1325modxj2QHRw(short s6, short s7) {
        return m1306constructorimpl((short) Integer.remainderUnsigned(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(s7 & 65535)));
    }

    /* JADX INFO: renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m1326orxj2QHRw(short s6, short s7) {
        return m1306constructorimpl((short) (s6 | s7));
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m1327plus7apg3OU(short s6, byte b) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) + G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m1328plusVKZWuLQ(short s6, long j6) {
        return J.m1247constructorimpl(J.m1247constructorimpl(((long) s6) & 65535) + j6);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1329plusWZ4Q5Ns(short s6, int i5) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s6 & 65535) + i5);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m1330plusxj2QHRw(short s6, short s7) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s7 & 65535) + G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final G m1331rangeToxj2QHRw(short s6, short s7) {
        return new G(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(s7 & 65535), 1);
    }

    /* JADX INFO: renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final G m1332rangeUntilxj2QHRw(short s6, short s7) {
        return M.m853untilJ1ME1BU(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(s7 & 65535));
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m1333rem7apg3OU(short s6, byte b) {
        return Integer.remainderUnsigned(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m1334remVKZWuLQ(short s6, long j6) {
        return Long.remainderUnsigned(J.m1247constructorimpl(((long) s6) & 65535), j6);
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m1335remWZ4Q5Ns(short s6, int i5) {
        return Integer.remainderUnsigned(G.m1188constructorimpl(s6 & 65535), i5);
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m1336remxj2QHRw(short s6, short s7) {
        return Integer.remainderUnsigned(G.m1188constructorimpl(s6 & 65535), G.m1188constructorimpl(s7 & 65535));
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m1337times7apg3OU(short s6, byte b) {
        return G.m1188constructorimpl(G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE) * G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m1338timesVKZWuLQ(short s6, long j6) {
        return a.d(((long) s6) & 65535, j6);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m1339timesWZ4Q5Ns(short s6, int i5) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s6 & 65535) * i5);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m1340timesxj2QHRw(short s6, short s7) {
        return G.m1188constructorimpl(G.m1188constructorimpl(s7 & 65535) * G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m1341toByteimpl(short s6) {
        return (byte) s6;
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m1342toDoubleimpl(short s6) {
        return T.uintToDouble(s6 & 65535);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m1343toFloatimpl(short s6) {
        return (float) T.uintToDouble(s6 & 65535);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m1344toIntimpl(short s6) {
        return s6 & 65535;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m1345toLongimpl(short s6) {
        return ((long) s6) & 65535;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1347toStringimpl(short s6) {
        return String.valueOf(s6 & 65535);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m1348toUBytew2LRezQ(short s6) {
        return D.m1131constructorimpl((byte) s6);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m1349toUIntpVg5ArA(short s6) {
        return G.m1188constructorimpl(s6 & 65535);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m1350toULongsVKNKU(short s6) {
        return J.m1247constructorimpl(((long) s6) & 65535);
    }

    /* JADX INFO: renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m1352xorxj2QHRw(short s6, short s7) {
        return m1306constructorimpl((short) (s6 ^ s7));
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return E.h(this.f9128a & 65535, ((N) obj).f9128a & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof N) {
            return this.f9128a == ((N) obj).f9128a;
        }
        return false;
    }

    public final int hashCode() {
        return Short.hashCode(this.f9128a);
    }

    public String toString() {
        return m1347toStringimpl(this.f9128a);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m1305compareToxj2QHRw(short s6, short s7) {
        return E.h(s6 & 65535, s7 & 65535);
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m1306constructorimpl(short s6) {
        return s6;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m1346toShortimpl(short s6) {
        return s6;
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m1351toUShortMh2AYeg(short s6) {
        return s6;
    }
}
