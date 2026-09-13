package C3;

import A3.AbstractC0139g;
import A3.AbstractC0157z;
import A3.C;
import A3.C0136d;
import A3.C0147o;
import A3.C0148p;
import A3.C0149q;
import A3.r;
import O3.l;
import com.google.common.primitives.UnsignedBytes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.E;
import p147z3.D;
import p147z3.G;
import p147z3.J;
import p147z3.N;
import p147z3.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    /* JADX INFO: renamed from: asList--ajY-9A, reason: not valid java name */
    public static final List<G> m133asListajY9A(int[] asList) {
        E.f(asList, "$this$asList");
        return new C0149q(asList, 1);
    }

    /* JADX INFO: renamed from: asList-GBYM_sE, reason: not valid java name */
    public static final List<D> m134asListGBYM_sE(byte[] asList) {
        E.f(asList, "$this$asList");
        return new C0147o(asList, 1);
    }

    /* JADX INFO: renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<J> m135asListQwZRm1k(long[] asList) {
        E.f(asList, "$this$asList");
        return new r(asList, 1);
    }

    /* JADX INFO: renamed from: asList-rL5Bavg, reason: not valid java name */
    public static final List<N> m136asListrL5Bavg(short[] asList) {
        E.f(asList, "$this$asList");
        return new C0148p(asList, 1);
    }

    /* JADX INFO: renamed from: binarySearch-2fe2U9s, reason: not valid java name */
    public static final int m137binarySearch2fe2U9s(int[] binarySearch, int i5, int i6, int i7) {
        E.f(binarySearch, "$this$binarySearch");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = binarySearch.length;
        c0136d.getClass();
        C0136d.d(i6, i7, length);
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int iUintCompare = T.uintCompare(binarySearch[i9], i5);
            if (iUintCompare < 0) {
                i6 = i9 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i6 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-EtDCXyQ, reason: not valid java name */
    public static final int m138binarySearchEtDCXyQ(short[] binarySearch, short s6, int i5, int i6) {
        E.f(binarySearch, "$this$binarySearch");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = binarySearch.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = s6 & 65535;
        int i8 = i6 - 1;
        while (i5 <= i8) {
            int i9 = (i5 + i8) >>> 1;
            int iUintCompare = T.uintCompare(binarySearch[i9], i7);
            if (iUintCompare < 0) {
                i5 = i9 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-K6DWlUc, reason: not valid java name */
    public static final int m139binarySearchK6DWlUc(long[] binarySearch, long j6, int i5, int i6) {
        E.f(binarySearch, "$this$binarySearch");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = binarySearch.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int iUlongCompare = T.ulongCompare(binarySearch[i8], j6);
            if (iUlongCompare < 0) {
                i5 = i8 + 1;
            } else {
                if (iUlongCompare <= 0) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX INFO: renamed from: binarySearch-WpHrYlw, reason: not valid java name */
    public static final int m140binarySearchWpHrYlw(byte[] binarySearch, byte b, int i5, int i6) {
        E.f(binarySearch, "$this$binarySearch");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = binarySearch.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = b & UnsignedBytes.MAX_VALUE;
        int i8 = i6 - 1;
        while (i5 <= i8) {
            int i9 = (i5 + i8) >>> 1;
            int iUintCompare = T.uintCompare(binarySearch[i9], i7);
            if (iUintCompare < 0) {
                i5 = i9 + 1;
            } else {
                if (iUintCompare <= 0) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX INFO: renamed from: elementAt-PpDY95g, reason: not valid java name */
    private static final byte m141elementAtPpDY95g(byte[] elementAt, int i5) {
        E.f(elementAt, "$this$elementAt");
        return D.m1131constructorimpl(elementAt[i5]);
    }

    /* JADX INFO: renamed from: elementAt-nggk6HY, reason: not valid java name */
    private static final short m142elementAtnggk6HY(short[] elementAt, int i5) {
        E.f(elementAt, "$this$elementAt");
        return N.m1306constructorimpl(elementAt[i5]);
    }

    /* JADX INFO: renamed from: elementAt-qFRl0hI, reason: not valid java name */
    private static final int m143elementAtqFRl0hI(int[] elementAt, int i5) {
        E.f(elementAt, "$this$elementAt");
        return G.m1188constructorimpl(elementAt[i5]);
    }

    /* JADX INFO: renamed from: elementAt-r7IrZao, reason: not valid java name */
    private static final long m144elementAtr7IrZao(long[] elementAt, int i5) {
        E.f(elementAt, "$this$elementAt");
        return J.m1247constructorimpl(elementAt[i5]);
    }

    /* JADX INFO: renamed from: max--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ G m145maxajY9A(int[] max) {
        E.f(max, "$this$max");
        return b.m489maxOrNullajY9A(max);
    }

    /* JADX INFO: renamed from: max-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ D m146maxGBYM_sE(byte[] max) {
        E.f(max, "$this$max");
        return b.m490maxOrNullGBYM_sE(max);
    }

    /* JADX INFO: renamed from: max-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ J m147maxQwZRm1k(long[] max) {
        E.f(max, "$this$max");
        return b.m491maxOrNullQwZRm1k(max);
    }

    /* JADX INFO: renamed from: max-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ N m148maxrL5Bavg(short[] max) {
        E.f(max, "$this$max");
        return b.m492maxOrNullrL5Bavg(max);
    }

    /* JADX INFO: renamed from: maxBy-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> D m149maxByJOV_ifY(byte[] maxBy, l selector) {
        E.f(maxBy, "$this$maxBy");
        E.f(selector, "selector");
        if (maxBy.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(maxBy[0]);
        int lastIndex = C.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return D.a(bM1131constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(D.a(bM1131constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(maxBy[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(D.a(bM1131constructorimpl2));
                if (comparable.compareTo(comparable2) < 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: maxBy-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> J m150maxByMShoTSo(long[] maxBy, l selector) {
        E.f(maxBy, "$this$maxBy");
        E.f(selector, "selector");
        if (maxBy.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(maxBy[0]);
        int lastIndex = C.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return J.a(jM1247constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(J.a(jM1247constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM1247constructorimpl2 = J.m1247constructorimpl(maxBy[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(J.a(jM1247constructorimpl2));
                if (comparable.compareTo(comparable2) < 0) {
                    jM1247constructorimpl = jM1247constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: maxBy-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> G m151maxByjgv0xPQ(int[] maxBy, l selector) {
        E.f(maxBy, "$this$maxBy");
        E.f(selector, "selector");
        if (maxBy.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(maxBy[0]);
        int lastIndex = C.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return G.a(iM1188constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(G.a(iM1188constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM1188constructorimpl2 = G.m1188constructorimpl(maxBy[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(G.a(iM1188constructorimpl2));
                if (comparable.compareTo(comparable2) < 0) {
                    iM1188constructorimpl = iM1188constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: maxBy-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> N m152maxByxTcfx_M(short[] maxBy, l selector) {
        E.f(maxBy, "$this$maxBy");
        E.f(selector, "selector");
        if (maxBy.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(maxBy[0]);
        int lastIndex = C.getLastIndex(maxBy);
        if (lastIndex == 0) {
            return N.a(sM1306constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(N.a(sM1306constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM1306constructorimpl2 = N.m1306constructorimpl(maxBy[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(N.a(sM1306constructorimpl2));
                if (comparable.compareTo(comparable2) < 0) {
                    sM1306constructorimpl = sM1306constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: maxWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ D m153maxWithXMRcp5o(byte[] maxWith, Comparator comparator) {
        E.f(maxWith, "$this$maxWith");
        E.f(comparator, "comparator");
        return b.m497maxWithOrNullXMRcp5o(maxWith, comparator);
    }

    /* JADX INFO: renamed from: maxWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ G m154maxWithYmdZ_VM(int[] maxWith, Comparator comparator) {
        E.f(maxWith, "$this$maxWith");
        E.f(comparator, "comparator");
        return b.m498maxWithOrNullYmdZ_VM(maxWith, comparator);
    }

    /* JADX INFO: renamed from: maxWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ N m155maxWitheOHTfZs(short[] maxWith, Comparator comparator) {
        E.f(maxWith, "$this$maxWith");
        E.f(comparator, "comparator");
        return b.m499maxWithOrNulleOHTfZs(maxWith, comparator);
    }

    /* JADX INFO: renamed from: maxWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ J m156maxWithzrEWJaI(long[] maxWith, Comparator comparator) {
        E.f(maxWith, "$this$maxWith");
        E.f(comparator, "comparator");
        return b.m500maxWithOrNullzrEWJaI(maxWith, comparator);
    }

    /* JADX INFO: renamed from: min--ajY-9A, reason: not valid java name */
    public static final /* synthetic */ G m157minajY9A(int[] min) {
        E.f(min, "$this$min");
        return b.m545minOrNullajY9A(min);
    }

    /* JADX INFO: renamed from: min-GBYM_sE, reason: not valid java name */
    public static final /* synthetic */ D m158minGBYM_sE(byte[] min) {
        E.f(min, "$this$min");
        return b.m546minOrNullGBYM_sE(min);
    }

    /* JADX INFO: renamed from: min-QwZRm1k, reason: not valid java name */
    public static final /* synthetic */ J m159minQwZRm1k(long[] min) {
        E.f(min, "$this$min");
        return b.m547minOrNullQwZRm1k(min);
    }

    /* JADX INFO: renamed from: min-rL5Bavg, reason: not valid java name */
    public static final /* synthetic */ N m160minrL5Bavg(short[] min) {
        E.f(min, "$this$min");
        return b.m548minOrNullrL5Bavg(min);
    }

    /* JADX INFO: renamed from: minBy-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> D m161minByJOV_ifY(byte[] minBy, l selector) {
        E.f(minBy, "$this$minBy");
        E.f(selector, "selector");
        if (minBy.length == 0) {
            return null;
        }
        byte bM1131constructorimpl = D.m1131constructorimpl(minBy[0]);
        int lastIndex = C.getLastIndex(minBy);
        if (lastIndex == 0) {
            return D.a(bM1131constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(D.a(bM1131constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM1131constructorimpl2 = D.m1131constructorimpl(minBy[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(D.a(bM1131constructorimpl2));
                if (comparable.compareTo(comparable2) > 0) {
                    bM1131constructorimpl = bM1131constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return D.a(bM1131constructorimpl);
    }

    /* JADX INFO: renamed from: minBy-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> J m162minByMShoTSo(long[] minBy, l selector) {
        E.f(minBy, "$this$minBy");
        E.f(selector, "selector");
        if (minBy.length == 0) {
            return null;
        }
        long jM1247constructorimpl = J.m1247constructorimpl(minBy[0]);
        int lastIndex = C.getLastIndex(minBy);
        if (lastIndex == 0) {
            return J.a(jM1247constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(J.a(jM1247constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM1247constructorimpl2 = J.m1247constructorimpl(minBy[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(J.a(jM1247constructorimpl2));
                if (comparable.compareTo(comparable2) > 0) {
                    jM1247constructorimpl = jM1247constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return J.a(jM1247constructorimpl);
    }

    /* JADX INFO: renamed from: minBy-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> G m163minByjgv0xPQ(int[] minBy, l selector) {
        E.f(minBy, "$this$minBy");
        E.f(selector, "selector");
        if (minBy.length == 0) {
            return null;
        }
        int iM1188constructorimpl = G.m1188constructorimpl(minBy[0]);
        int lastIndex = C.getLastIndex(minBy);
        if (lastIndex == 0) {
            return G.a(iM1188constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(G.a(iM1188constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM1188constructorimpl2 = G.m1188constructorimpl(minBy[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(G.a(iM1188constructorimpl2));
                if (comparable.compareTo(comparable2) > 0) {
                    iM1188constructorimpl = iM1188constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return G.a(iM1188constructorimpl);
    }

    /* JADX INFO: renamed from: minBy-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> N m164minByxTcfx_M(short[] minBy, l selector) {
        E.f(minBy, "$this$minBy");
        E.f(selector, "selector");
        if (minBy.length == 0) {
            return null;
        }
        short sM1306constructorimpl = N.m1306constructorimpl(minBy[0]);
        int lastIndex = C.getLastIndex(minBy);
        if (lastIndex == 0) {
            return N.a(sM1306constructorimpl);
        }
        Comparable comparable = (Comparable) selector.invoke(N.a(sM1306constructorimpl));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM1306constructorimpl2 = N.m1306constructorimpl(minBy[i5]);
                Comparable comparable2 = (Comparable) selector.invoke(N.a(sM1306constructorimpl2));
                if (comparable.compareTo(comparable2) > 0) {
                    sM1306constructorimpl = sM1306constructorimpl2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return N.a(sM1306constructorimpl);
    }

    /* JADX INFO: renamed from: minWith-XMRcp5o, reason: not valid java name */
    public static final /* synthetic */ D m165minWithXMRcp5o(byte[] minWith, Comparator comparator) {
        E.f(minWith, "$this$minWith");
        E.f(comparator, "comparator");
        return b.m553minWithOrNullXMRcp5o(minWith, comparator);
    }

    /* JADX INFO: renamed from: minWith-YmdZ_VM, reason: not valid java name */
    public static final /* synthetic */ G m166minWithYmdZ_VM(int[] minWith, Comparator comparator) {
        E.f(minWith, "$this$minWith");
        E.f(comparator, "comparator");
        return b.m554minWithOrNullYmdZ_VM(minWith, comparator);
    }

    /* JADX INFO: renamed from: minWith-eOHTfZs, reason: not valid java name */
    public static final /* synthetic */ N m167minWitheOHTfZs(short[] minWith, Comparator comparator) {
        E.f(minWith, "$this$minWith");
        E.f(comparator, "comparator");
        return b.m555minWithOrNulleOHTfZs(minWith, comparator);
    }

    /* JADX INFO: renamed from: minWith-zrEWJaI, reason: not valid java name */
    public static final /* synthetic */ J m168minWithzrEWJaI(long[] minWith, Comparator comparator) {
        E.f(minWith, "$this$minWith");
        E.f(comparator, "comparator");
        return b.m556minWithOrNullzrEWJaI(minWith, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(int[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        E.e(bigDecimalValueOf, "valueOf(...)");
        for (int i5 : sumOf) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) AbstractC0157z.e(i5, selector));
            E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        E.e(bigIntegerValueOf, "valueOf(...)");
        for (int i5 : sumOf) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) AbstractC0157z.e(i5, selector));
            E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(long[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        E.e(bigDecimalValueOf, "valueOf(...)");
        for (long j6 : sumOf) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) AbstractC0157z.g(j6, selector));
            E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        E.e(bigIntegerValueOf, "valueOf(...)");
        for (long j6 : sumOf) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) AbstractC0157z.g(j6, selector));
            E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        E.e(bigDecimalValueOf, "valueOf(...)");
        for (byte b : sumOf) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) AbstractC0157z.d(b, selector));
            E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        E.e(bigIntegerValueOf, "valueOf(...)");
        for (byte b : sumOf) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) AbstractC0157z.d(b, selector));
            E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    private static final BigDecimal sumOfBigDecimal(short[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        E.e(bigDecimalValueOf, "valueOf(...)");
        for (short s6 : sumOf) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) AbstractC0157z.i(s6, selector));
            E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sumOf, l selector) {
        E.f(sumOf, "$this$sumOf");
        E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        E.e(bigIntegerValueOf, "valueOf(...)");
        for (short s6 : sumOf) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) AbstractC0157z.i(s6, selector));
            E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }
}
