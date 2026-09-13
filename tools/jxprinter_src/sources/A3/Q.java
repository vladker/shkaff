package A3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Q extends P {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> klass) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(klass, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), klass);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C destination, Class<R> klass) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Double m86max(Iterable iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return T.m94maxOrNull((Iterable<Double>) iterable);
    }

    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            return null;
        }
        T t6 = (T) itC.next();
        if (!itC.hasNext()) {
            return t6;
        }
        Comparable comparable = (Comparable) lVar.invoke(t6);
        do {
            Object next = itC.next();
            Comparable comparable2 = (Comparable) lVar.invoke(next);
            if (comparable.compareTo(comparable2) < 0) {
                t6 = (T) next;
                comparable = comparable2;
            }
        } while (itC.hasNext());
        return t6;
    }

    public static final /* synthetic */ Object maxWith(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return T.maxWithOrNull(iterable, comparator);
    }

    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Double m88min(Iterable iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return T.m102minOrNull((Iterable<Double>) iterable);
    }

    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            return null;
        }
        T t6 = (T) itC.next();
        if (!itC.hasNext()) {
            return t6;
        }
        Comparable comparable = (Comparable) lVar.invoke(t6);
        do {
            Object next = itC.next();
            Comparable comparable2 = (Comparable) lVar.invoke(next);
            if (comparable.compareTo(comparable2) > 0) {
                t6 = (T) next;
                comparable = comparable2;
            }
        } while (itC.hasNext());
        return t6;
    }

    public static final /* synthetic */ Object minWith(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return T.minWithOrNull(iterable, comparator);
    }

    public static <T> void reverse(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        Collections.reverse(list);
    }

    private static final <T> BigDecimal sumOfBigDecimal(Iterable<? extends T> iterable, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(it.next()));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(Iterable<? extends T> iterable, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(it.next()));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return (SortedSet) T.toCollection(iterable, new TreeSet());
    }

    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Float m87max(Iterable iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return T.m95maxOrNull((Iterable<Float>) iterable);
    }

    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Float m89min(Iterable iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return T.m103minOrNull((Iterable<Float>) iterable);
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return (SortedSet) T.toCollection(iterable, new TreeSet(comparator));
    }

    public static final /* synthetic */ Comparable max(Iterable iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return T.maxOrNull(iterable);
    }

    public static final /* synthetic */ Comparable min(Iterable iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return T.minOrNull(iterable);
    }
}
