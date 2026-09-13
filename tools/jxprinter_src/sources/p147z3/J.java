package p147z3;

import U3.L;
import U3.M;
import androidx.collection.a;
import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J implements Comparable {
    public static final I Companion = new I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9126a;

    private /* synthetic */ J(long j6) {
        this.f9126a = j6;
    }

    public static final /* synthetic */ J a(long j6) {
        return new J(j6);
    }

    /* JADX INFO: renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m1241andVKZWuLQ(long j6, long j7) {
        return m1247constructorimpl(j6 & j7);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m1242compareTo7apg3OU(long j6, byte b) {
        return Long.compareUnsigned(j6, m1247constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m1243compareToVKZWuLQ(long j6) {
        return T.ulongCompare(this.f9126a, j6);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m1245compareToWZ4Q5Ns(long j6, int i5) {
        return Long.compareUnsigned(j6, m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m1246compareToxj2QHRw(long j6, short s6) {
        return Long.compareUnsigned(j6, m1247constructorimpl(((long) s6) & 65535));
    }

    /* JADX INFO: renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m1248decsVKNKU(long j6) {
        return m1247constructorimpl(j6 - 1);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m1249div7apg3OU(long j6, byte b) {
        return Long.divideUnsigned(j6, m1247constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m1250divVKZWuLQ(long j6, long j7) {
        return T.m1359ulongDivideeb3DHEI(j6, j7);
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m1251divWZ4Q5Ns(long j6, int i5) {
        return Long.divideUnsigned(j6, m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m1252divxj2QHRw(long j6, short s6) {
        return Long.divideUnsigned(j6, m1247constructorimpl(((long) s6) & 65535));
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m1253floorDiv7apg3OU(long j6, byte b) {
        return Long.divideUnsigned(j6, m1247constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m1254floorDivVKZWuLQ(long j6, long j7) {
        return Long.divideUnsigned(j6, j7);
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m1255floorDivWZ4Q5Ns(long j6, int i5) {
        return Long.divideUnsigned(j6, m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m1256floorDivxj2QHRw(long j6, short s6) {
        return Long.divideUnsigned(j6, m1247constructorimpl(((long) s6) & 65535));
    }

    /* JADX INFO: renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m1257incsVKNKU(long j6) {
        return m1247constructorimpl(j6 + 1);
    }

    /* JADX INFO: renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m1258invsVKNKU(long j6) {
        return m1247constructorimpl(~j6);
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m1259minus7apg3OU(long j6, byte b) {
        return m1247constructorimpl(j6 - m1247constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m1260minusVKZWuLQ(long j6, long j7) {
        return m1247constructorimpl(j6 - j7);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m1261minusWZ4Q5Ns(long j6, int i5) {
        return m1247constructorimpl(j6 - m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m1262minusxj2QHRw(long j6, short s6) {
        return m1247constructorimpl(j6 - m1247constructorimpl(((long) s6) & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m1263mod7apg3OU(long j6, byte b) {
        return D.m1131constructorimpl((byte) Long.remainderUnsigned(j6, m1247constructorimpl(((long) b) & 255)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m1264modVKZWuLQ(long j6, long j7) {
        return Long.remainderUnsigned(j6, j7);
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m1265modWZ4Q5Ns(long j6, int i5) {
        return G.m1188constructorimpl((int) Long.remainderUnsigned(j6, m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask)));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m1266modxj2QHRw(long j6, short s6) {
        return N.m1306constructorimpl((short) Long.remainderUnsigned(j6, m1247constructorimpl(((long) s6) & 65535)));
    }

    /* JADX INFO: renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m1267orVKZWuLQ(long j6, long j7) {
        return m1247constructorimpl(j6 | j7);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m1268plus7apg3OU(long j6, byte b) {
        return m1247constructorimpl(m1247constructorimpl(((long) b) & 255) + j6);
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m1269plusVKZWuLQ(long j6, long j7) {
        return m1247constructorimpl(j6 + j7);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m1270plusWZ4Q5Ns(long j6, int i5) {
        return m1247constructorimpl(m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask) + j6);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m1271plusxj2QHRw(long j6, short s6) {
        return m1247constructorimpl(m1247constructorimpl(((long) s6) & 65535) + j6);
    }

    /* JADX INFO: renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final L m1272rangeToVKZWuLQ(long j6, long j7) {
        return new L(j6, j7);
    }

    /* JADX INFO: renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final L m1273rangeUntilVKZWuLQ(long j6, long j7) {
        return M.m855untileb3DHEI(j6, j7);
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m1274rem7apg3OU(long j6, byte b) {
        return Long.remainderUnsigned(j6, m1247constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m1275remVKZWuLQ(long j6, long j7) {
        return T.m1360ulongRemaindereb3DHEI(j6, j7);
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m1276remWZ4Q5Ns(long j6, int i5) {
        return Long.remainderUnsigned(j6, m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m1277remxj2QHRw(long j6, short s6) {
        return Long.remainderUnsigned(j6, m1247constructorimpl(((long) s6) & 65535));
    }

    /* JADX INFO: renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m1278shlsVKNKU(long j6, int i5) {
        return m1247constructorimpl(j6 << i5);
    }

    /* JADX INFO: renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m1279shrsVKNKU(long j6, int i5) {
        return m1247constructorimpl(j6 >>> i5);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m1280times7apg3OU(long j6, byte b) {
        return a.d(((long) b) & 255, j6);
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m1281timesVKZWuLQ(long j6, long j7) {
        return m1247constructorimpl(j6 * j7);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m1282timesWZ4Q5Ns(long j6, int i5) {
        return a.d(((long) i5) & KeyboardMap.kValueMask, j6);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m1283timesxj2QHRw(long j6, short s6) {
        return a.d(((long) s6) & 65535, j6);
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m1284toByteimpl(long j6) {
        return (byte) j6;
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m1285toDoubleimpl(long j6) {
        return T.ulongToDouble(j6);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m1286toFloatimpl(long j6) {
        return (float) T.ulongToDouble(j6);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m1287toIntimpl(long j6) {
        return (int) j6;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m1289toShortimpl(long j6) {
        return (short) j6;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1290toStringimpl(long j6) {
        return T.ulongToString(j6, 10);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m1291toUBytew2LRezQ(long j6) {
        return D.m1131constructorimpl((byte) j6);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m1292toUIntpVg5ArA(long j6) {
        return G.m1188constructorimpl((int) j6);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m1294toUShortMh2AYeg(long j6) {
        return N.m1306constructorimpl((short) j6);
    }

    /* JADX INFO: renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m1295xorVKZWuLQ(long j6, long j7) {
        return m1247constructorimpl(j6 ^ j7);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return T.ulongCompare(this.f9126a, ((J) obj).f9126a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof J) {
            return this.f9126a == ((J) obj).f9126a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9126a);
    }

    public String toString() {
        return m1290toStringimpl(this.f9126a);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m1244compareToVKZWuLQ(long j6, long j7) {
        return T.ulongCompare(j6, j7);
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1247constructorimpl(long j6) {
        return j6;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m1288toLongimpl(long j6) {
        return j6;
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m1293toULongsVKNKU(long j6) {
        return j6;
    }
}
