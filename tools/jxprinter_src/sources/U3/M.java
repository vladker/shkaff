package U3;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.util.NoSuchElementException;
import p147z3.N;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class M {
    /* JADX INFO: renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m826coerceAtLeast5PvTz6A(short s6, short s7) {
        return kotlin.jvm.internal.E.h(s6 & 65535, 65535 & s7) < 0 ? s7 : s6;
    }

    /* JADX INFO: renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m827coerceAtLeastJ1ME1BU(int i5, int i6) {
        return Integer.compareUnsigned(i5, i6) < 0 ? i6 : i5;
    }

    /* JADX INFO: renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m828coerceAtLeastKr8caGY(byte b, byte b6) {
        return kotlin.jvm.internal.E.h(b & UnsignedBytes.MAX_VALUE, b6 & UnsignedBytes.MAX_VALUE) < 0 ? b6 : b;
    }

    /* JADX INFO: renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m829coerceAtLeasteb3DHEI(long j6, long j7) {
        return Long.compareUnsigned(j6, j7) < 0 ? j7 : j6;
    }

    /* JADX INFO: renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m830coerceAtMost5PvTz6A(short s6, short s7) {
        return kotlin.jvm.internal.E.h(s6 & 65535, 65535 & s7) > 0 ? s7 : s6;
    }

    /* JADX INFO: renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m831coerceAtMostJ1ME1BU(int i5, int i6) {
        return Integer.compareUnsigned(i5, i6) > 0 ? i6 : i5;
    }

    /* JADX INFO: renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m832coerceAtMostKr8caGY(byte b, byte b6) {
        return kotlin.jvm.internal.E.h(b & UnsignedBytes.MAX_VALUE, b6 & UnsignedBytes.MAX_VALUE) > 0 ? b6 : b;
    }

    /* JADX INFO: renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m833coerceAtMosteb3DHEI(long j6, long j7) {
        return Long.compareUnsigned(j6, j7) > 0 ? j7 : j6;
    }

    /* JADX INFO: renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m834coerceInJPwROB0(long j6, InterfaceC0213j range) {
        kotlin.jvm.internal.E.f(range, "range");
        if (range instanceof InterfaceC0211h) {
            return ((p147z3.J) B.coerceIn(p147z3.J.a(j6), (InterfaceC0211h) range)).f9126a;
        }
        if (!range.isEmpty()) {
            if (Long.compareUnsigned(j6, ((p147z3.J) range.getStart()).f9126a) < 0) {
                return ((p147z3.J) range.getStart()).f9126a;
            }
            return Long.compareUnsigned(j6, ((p147z3.J) range.getEndInclusive()).f9126a) > 0 ? ((p147z3.J) range.getEndInclusive()).f9126a : j6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    /* JADX INFO: renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m835coerceInVKSA0NQ(short s6, short s7, short s8) {
        int i5 = s7 & 65535;
        int i6 = s8 & 65535;
        if (kotlin.jvm.internal.E.h(i5, i6) <= 0) {
            int i7 = 65535 & s6;
            if (kotlin.jvm.internal.E.h(i7, i5) < 0) {
                return s7;
            }
            return kotlin.jvm.internal.E.h(i7, i6) > 0 ? s8 : s6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) N.m1347toStringimpl(s8)) + " is less than minimum " + ((Object) N.m1347toStringimpl(s7)) + '.');
    }

    /* JADX INFO: renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m836coerceInWZ9TVnA(int i5, int i6, int i7) {
        if (Integer.compareUnsigned(i6, i7) <= 0) {
            if (Integer.compareUnsigned(i5, i6) < 0) {
                return i6;
            }
            return Integer.compareUnsigned(i5, i7) > 0 ? i7 : i5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) p147z3.G.m1231toStringimpl(i7)) + " is less than minimum " + ((Object) p147z3.G.m1231toStringimpl(i6)) + '.');
    }

    /* JADX INFO: renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m837coerceInb33U2AM(byte b, byte b6, byte b7) {
        int i5 = b6 & UnsignedBytes.MAX_VALUE;
        int i6 = b7 & UnsignedBytes.MAX_VALUE;
        if (kotlin.jvm.internal.E.h(i5, i6) <= 0) {
            int i7 = b & UnsignedBytes.MAX_VALUE;
            if (kotlin.jvm.internal.E.h(i7, i5) < 0) {
                return b6;
            }
            return kotlin.jvm.internal.E.h(i7, i6) > 0 ? b7 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) p147z3.D.m1172toStringimpl(b7)) + " is less than minimum " + ((Object) p147z3.D.m1172toStringimpl(b6)) + '.');
    }

    /* JADX INFO: renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m838coerceInsambcqE(long j6, long j7, long j8) {
        if (Long.compareUnsigned(j7, j8) <= 0) {
            if (Long.compareUnsigned(j6, j7) < 0) {
                return j7;
            }
            return Long.compareUnsigned(j6, j8) > 0 ? j8 : j6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) p147z3.J.m1290toStringimpl(j8)) + " is less than minimum " + ((Object) p147z3.J.m1290toStringimpl(j7)) + '.');
    }

    /* JADX INFO: renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m839coerceInwuiCnnA(int i5, InterfaceC0213j range) {
        kotlin.jvm.internal.E.f(range, "range");
        if (range instanceof InterfaceC0211h) {
            return ((p147z3.G) B.coerceIn(p147z3.G.a(i5), (InterfaceC0211h) range)).f9124a;
        }
        if (!range.isEmpty()) {
            if (Integer.compareUnsigned(i5, ((p147z3.G) range.getStart()).f9124a) < 0) {
                return ((p147z3.G) range.getStart()).f9124a;
            }
            return Integer.compareUnsigned(i5, ((p147z3.G) range.getEndInclusive()).f9124a) > 0 ? ((p147z3.G) range.getEndInclusive()).f9124a : i5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    /* JADX INFO: renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m840contains68kG9v0(G contains, byte b) {
        kotlin.jvm.internal.E.f(contains, "$this$contains");
        return contains.c(p147z3.G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE));
    }

    /* JADX INFO: renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m841containsGYNo2lE(L contains, p147z3.J j6) {
        kotlin.jvm.internal.E.f(contains, "$this$contains");
        return j6 != null && contains.c(j6.f9126a);
    }

    /* JADX INFO: renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m842containsGab390E(L contains, int i5) {
        kotlin.jvm.internal.E.f(contains, "$this$contains");
        return contains.c(p147z3.J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask));
    }

    /* JADX INFO: renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m843containsULbyJY(L contains, byte b) {
        kotlin.jvm.internal.E.f(contains, "$this$contains");
        return contains.c(p147z3.J.m1247constructorimpl(((long) b) & 255));
    }

    /* JADX INFO: renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m844containsZsK3CEQ(G contains, short s6) {
        kotlin.jvm.internal.E.f(contains, "$this$contains");
        return contains.c(p147z3.G.m1188constructorimpl(s6 & 65535));
    }

    /* JADX INFO: renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m845containsbiwQdVI(G contains, p147z3.G g6) {
        kotlin.jvm.internal.E.f(contains, "$this$contains");
        return g6 != null && contains.c(g6.f9124a);
    }

    /* JADX INFO: renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m846containsfz5IDCE(G contains, long j6) {
        kotlin.jvm.internal.E.f(contains, "$this$contains");
        return p147z3.J.m1247constructorimpl(j6 >>> 32) == 0 && contains.c(p147z3.G.m1188constructorimpl((int) j6));
    }

    /* JADX INFO: renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m847containsuhHAxoY(L contains, short s6) {
        kotlin.jvm.internal.E.f(contains, "$this$contains");
        return contains.c(p147z3.J.m1247constructorimpl(((long) s6) & 65535));
    }

    /* JADX INFO: renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final D m848downTo5PvTz6A(short s6, short s7) {
        return D.Companion.m822fromClosedRangeNkh28Cs(p147z3.G.m1188constructorimpl(s6 & 65535), p147z3.G.m1188constructorimpl(s7 & 65535), -1);
    }

    /* JADX INFO: renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final D m849downToJ1ME1BU(int i5, int i6) {
        return D.Companion.m822fromClosedRangeNkh28Cs(i5, i6, -1);
    }

    /* JADX INFO: renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final D m850downToKr8caGY(byte b, byte b6) {
        return D.Companion.m822fromClosedRangeNkh28Cs(p147z3.G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), p147z3.G.m1188constructorimpl(b6 & UnsignedBytes.MAX_VALUE), -1);
    }

    /* JADX INFO: renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final I m851downToeb3DHEI(long j6, long j7) {
        return I.Companion.m824fromClosedRange7ftBX0g(j6, j7, -1L);
    }

    public static final int first(D d) {
        kotlin.jvm.internal.E.f(d, "<this>");
        if (!d.isEmpty()) {
            return d.f724a;
        }
        throw new NoSuchElementException("Progression " + d + " is empty.");
    }

    public static final p147z3.G firstOrNull(D d) {
        kotlin.jvm.internal.E.f(d, "<this>");
        if (d.isEmpty()) {
            return null;
        }
        return p147z3.G.a(d.f724a);
    }

    public static final int last(D d) {
        kotlin.jvm.internal.E.f(d, "<this>");
        if (!d.isEmpty()) {
            return d.b;
        }
        throw new NoSuchElementException("Progression " + d + " is empty.");
    }

    public static final p147z3.G lastOrNull(D d) {
        kotlin.jvm.internal.E.f(d, "<this>");
        if (d.isEmpty()) {
            return null;
        }
        return p147z3.G.a(d.b);
    }

    private static final int random(G g6) {
        kotlin.jvm.internal.E.f(g6, "<this>");
        return random(g6, S3.f.Default);
    }

    private static final p147z3.G randomOrNull(G g6) {
        kotlin.jvm.internal.E.f(g6, "<this>");
        return randomOrNull(g6, S3.f.Default);
    }

    public static final D reversed(D d) {
        kotlin.jvm.internal.E.f(d, "<this>");
        return D.Companion.m822fromClosedRangeNkh28Cs(d.b, d.f724a, -d.c);
    }

    public static final D step(D d, int i5) {
        kotlin.jvm.internal.E.f(d, "<this>");
        A.checkStepIsPositive(i5 > 0, Integer.valueOf(i5));
        C c = D.Companion;
        int i6 = d.f724a;
        int i7 = d.b;
        if (d.c <= 0) {
            i5 = -i5;
        }
        return c.m822fromClosedRangeNkh28Cs(i6, i7, i5);
    }

    /* JADX INFO: renamed from: until-5PvTz6A, reason: not valid java name */
    public static final G m852until5PvTz6A(short s6, short s7) {
        int i5 = s7 & 65535;
        return kotlin.jvm.internal.E.h(i5, 0) <= 0 ? G.Companion.getEMPTY() : new G(p147z3.G.m1188constructorimpl(s6 & 65535), p147z3.G.m1188constructorimpl(p147z3.G.m1188constructorimpl(i5) - 1), 1);
    }

    /* JADX INFO: renamed from: until-J1ME1BU, reason: not valid java name */
    public static G m853untilJ1ME1BU(int i5, int i6) {
        return Integer.compareUnsigned(i6, 0) <= 0 ? G.Companion.getEMPTY() : new G(i5, p147z3.G.m1188constructorimpl(i6 - 1), 1);
    }

    /* JADX INFO: renamed from: until-Kr8caGY, reason: not valid java name */
    public static final G m854untilKr8caGY(byte b, byte b6) {
        int i5 = b6 & UnsignedBytes.MAX_VALUE;
        return kotlin.jvm.internal.E.h(i5, 0) <= 0 ? G.Companion.getEMPTY() : new G(p147z3.G.m1188constructorimpl(b & UnsignedBytes.MAX_VALUE), p147z3.G.m1188constructorimpl(p147z3.G.m1188constructorimpl(i5) - 1), 1);
    }

    /* JADX INFO: renamed from: until-eb3DHEI, reason: not valid java name */
    public static L m855untileb3DHEI(long j6, long j7) {
        return Long.compareUnsigned(j7, 0L) <= 0 ? L.Companion.getEMPTY() : new L(j6, p147z3.J.m1247constructorimpl(j7 - p147z3.J.m1247constructorimpl(((long) 1) & KeyboardMap.kValueMask)));
    }

    private static final long random(L l6) {
        kotlin.jvm.internal.E.f(l6, "<this>");
        return random(l6, S3.f.Default);
    }

    private static final p147z3.J randomOrNull(L l6) {
        kotlin.jvm.internal.E.f(l6, "<this>");
        return randomOrNull(l6, S3.f.Default);
    }

    public static final int random(G g6, S3.f random) {
        kotlin.jvm.internal.E.f(g6, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        try {
            return S3.h.nextUInt(random, g6);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final p147z3.G randomOrNull(G g6, S3.f random) {
        kotlin.jvm.internal.E.f(g6, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (g6.isEmpty()) {
            return null;
        }
        return p147z3.G.a(S3.h.nextUInt(random, g6));
    }

    public static final long first(I i5) {
        kotlin.jvm.internal.E.f(i5, "<this>");
        if (!i5.isEmpty()) {
            return i5.f726a;
        }
        throw new NoSuchElementException("Progression " + i5 + " is empty.");
    }

    public static final p147z3.J firstOrNull(I i5) {
        kotlin.jvm.internal.E.f(i5, "<this>");
        if (i5.isEmpty()) {
            return null;
        }
        return p147z3.J.a(i5.f726a);
    }

    public static final long last(I i5) {
        kotlin.jvm.internal.E.f(i5, "<this>");
        if (!i5.isEmpty()) {
            return i5.b;
        }
        throw new NoSuchElementException("Progression " + i5 + " is empty.");
    }

    public static final p147z3.J lastOrNull(I i5) {
        kotlin.jvm.internal.E.f(i5, "<this>");
        if (i5.isEmpty()) {
            return null;
        }
        return p147z3.J.a(i5.b);
    }

    public static final long random(L l6, S3.f random) {
        kotlin.jvm.internal.E.f(l6, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        try {
            return S3.h.nextULong(random, l6);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final p147z3.J randomOrNull(L l6, S3.f random) {
        kotlin.jvm.internal.E.f(l6, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (l6.isEmpty()) {
            return null;
        }
        return p147z3.J.a(S3.h.nextULong(random, l6));
    }

    public static final I reversed(I i5) {
        kotlin.jvm.internal.E.f(i5, "<this>");
        return I.Companion.m824fromClosedRange7ftBX0g(i5.b, i5.f726a, -i5.c);
    }

    public static final I step(I i5, long j6) {
        kotlin.jvm.internal.E.f(i5, "<this>");
        A.checkStepIsPositive(j6 > 0, Long.valueOf(j6));
        H h6 = I.Companion;
        long j7 = i5.f726a;
        long j8 = i5.b;
        if (i5.c <= 0) {
            j6 = -j6;
        }
        return h6.m824fromClosedRange7ftBX0g(j7, j8, j6);
    }
}
