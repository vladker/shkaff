package X3;

import A3.AbstractC0157z;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 extends b0 {
    private static final char elementAt(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.charAt(i5);
    }

    public static final /* synthetic */ Character max(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return e0.maxOrNull(charSequence);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Character maxBy(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        Comparable comparable = (Comparable) lVar.invoke(Character.valueOf(cCharAt));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                Comparable comparable2 = (Comparable) lVar.invoke(Character.valueOf(cCharAt2));
                if (comparable.compareTo(comparable2) < 0) {
                    cCharAt = cCharAt2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final /* synthetic */ Character maxWith(CharSequence charSequence, Comparator comparator) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return e0.maxWithOrNull(charSequence, comparator);
    }

    public static final /* synthetic */ Character min(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return e0.minOrNull(charSequence);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Character minBy(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        Comparable comparable = (Comparable) lVar.invoke(Character.valueOf(cCharAt));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                Comparable comparable2 = (Comparable) lVar.invoke(Character.valueOf(cCharAt2));
                if (comparable.compareTo(comparable2) > 0) {
                    cCharAt = cCharAt2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final /* synthetic */ Character minWith(CharSequence charSequence, Comparator comparator) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return e0.minWithOrNull(charSequence, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) AbstractC0157z.h(charSequence, i5, selector));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) AbstractC0157z.h(charSequence, i5, selector));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final SortedSet<Character> toSortedSet(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return (SortedSet) e0.toCollection(charSequence, new TreeSet());
    }
}
