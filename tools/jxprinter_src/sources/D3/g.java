package D3;

import O3.l;
import O3.p;
import java.util.Comparator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final <T> Comparator<T> compareBy(l... selectors) {
        E.f(selectors, "selectors");
        if (selectors.length > 0) {
            return new c(selectors, 0);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final <T> Comparator<T> compareByDescending(l selector) {
        E.f(selector, "selector");
        return new d(1, selector);
    }

    public static <T extends Comparable<?>> int compareValues(T t6, T t7) {
        if (t6 == t7) {
            return 0;
        }
        if (t6 == null) {
            return -1;
        }
        if (t7 == null) {
            return 1;
        }
        return t6.compareTo(t7);
    }

    public static <T> int compareValuesBy(T t6, T t7, l... selectors) {
        E.f(selectors, "selectors");
        if (selectors.length <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (l lVar : selectors) {
            int iCompareValues = compareValues((Comparable) lVar.invoke(t6), (Comparable) lVar.invoke(t7));
            if (iCompareValues != 0) {
                return iCompareValues;
            }
        }
        return 0;
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        h hVar = h.INSTANCE;
        E.d(hVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>");
        return hVar;
    }

    public static final <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        E.f(comparator, "comparator");
        return new a(comparator, 1);
    }

    public static final <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
        E.f(comparator, "comparator");
        return new a(comparator, 0);
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        i iVar = i.INSTANCE;
        E.d(iVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>");
        return iVar;
    }

    public static final <T> Comparator<T> reversed(Comparator<T> comparator) {
        E.f(comparator, "<this>");
        if (comparator instanceof j) {
            return (Comparator<T>) ((j) comparator).getComparator();
        }
        h hVar = h.INSTANCE;
        if (comparator.equals(hVar)) {
            i iVar = i.INSTANCE;
            E.d(iVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
            return iVar;
        }
        if (!comparator.equals(i.INSTANCE)) {
            return new j(comparator);
        }
        E.d(hVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
        return hVar;
    }

    public static final <T> Comparator<T> then(Comparator<T> comparator, Comparator<? super T> comparator2) {
        E.f(comparator, "<this>");
        E.f(comparator2, "comparator");
        return new b(comparator, comparator2, 1);
    }

    private static final <T> Comparator<T> thenBy(Comparator<T> comparator, l selector) {
        E.f(comparator, "<this>");
        E.f(selector, "selector");
        return new e(comparator, selector, 2);
    }

    private static final <T> Comparator<T> thenByDescending(Comparator<T> comparator, l selector) {
        E.f(comparator, "<this>");
        E.f(selector, "selector");
        return new e(comparator, selector, 3);
    }

    private static final <T> Comparator<T> thenComparator(Comparator<T> comparator, p comparison) {
        E.f(comparator, "<this>");
        E.f(comparison, "comparison");
        return new e(comparator, comparison, 4);
    }

    public static final <T> Comparator<T> thenDescending(Comparator<T> comparator, Comparator<? super T> comparator2) {
        E.f(comparator, "<this>");
        E.f(comparator2, "comparator");
        return new b(comparator, comparator2, 0);
    }

    private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> comparator, l selector) {
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        return new e(comparator, selector, 1);
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return nullsFirst(naturalOrder());
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return nullsLast(naturalOrder());
    }

    private static final <T, K> Comparator<T> thenBy(Comparator<T> comparator, Comparator<? super K> comparator2, l selector) {
        E.f(comparator, "<this>");
        E.f(comparator2, "comparator");
        E.f(selector, "selector");
        return new f(comparator, comparator2, selector, 0);
    }

    private static final <T, K> Comparator<T> thenByDescending(Comparator<T> comparator, Comparator<? super K> comparator2, l selector) {
        E.f(comparator, "<this>");
        E.f(comparator2, "comparator");
        E.f(selector, "selector");
        return new f(comparator, comparator2, selector, 1);
    }

    private static final <T> Comparator<T> compareBy(l selector) {
        E.f(selector, "selector");
        return new d(0, selector);
    }

    private static final <T, K> Comparator<T> compareBy(Comparator<? super K> comparator, l selector) {
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        return new e(comparator, selector, 0);
    }

    private static final <T> int compareValuesBy(T t6, T t7, l selector) {
        E.f(selector, "selector");
        return compareValues((Comparable) selector.invoke(t6), (Comparable) selector.invoke(t7));
    }

    private static final <T, K> int compareValuesBy(T t6, T t7, Comparator<? super K> comparator, l selector) {
        E.f(comparator, "comparator");
        E.f(selector, "selector");
        return comparator.compare(selector.invoke(t6), selector.invoke(t7));
    }
}
