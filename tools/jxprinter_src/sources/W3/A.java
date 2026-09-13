package W3;

import A3.AbstractC0157z;
import A3.C0130a;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class A extends z {
    public static final <R> InterfaceC0233q filterIsInstance(InterfaceC0233q interfaceC0233q, Class<R> klass) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(klass, "klass");
        InterfaceC0233q interfaceC0233qFilter = L.filter(interfaceC0233q, new C0130a(klass, 4));
        kotlin.jvm.internal.E.d(interfaceC0233qFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return interfaceC0233qFilter;
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(InterfaceC0233q interfaceC0233q, C destination, Class<R> klass) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(klass, "klass");
        for (Object obj : interfaceC0233q) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Double m856max(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return L.m864maxOrNull(interfaceC0233q);
    }

    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            return null;
        }
        T t6 = (T) itB.next();
        if (!itB.hasNext()) {
            return t6;
        }
        Comparable comparable = (Comparable) lVar.invoke(t6);
        do {
            Object next = itB.next();
            Comparable comparable2 = (Comparable) lVar.invoke(next);
            if (comparable.compareTo(comparable2) < 0) {
                t6 = (T) next;
                comparable = comparable2;
            }
        } while (itB.hasNext());
        return t6;
    }

    public static final /* synthetic */ Object maxWith(InterfaceC0233q interfaceC0233q, Comparator comparator) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return L.maxWithOrNull(interfaceC0233q, comparator);
    }

    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Double m858min(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return L.m872minOrNull(interfaceC0233q);
    }

    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            return null;
        }
        T t6 = (T) itB.next();
        if (!itB.hasNext()) {
            return t6;
        }
        Comparable comparable = (Comparable) lVar.invoke(t6);
        do {
            Object next = itB.next();
            Comparable comparable2 = (Comparable) lVar.invoke(next);
            if (comparable.compareTo(comparable2) > 0) {
                t6 = (T) next;
                comparable = comparable2;
            }
        } while (itB.hasNext());
        return t6;
    }

    public static final /* synthetic */ Object minWith(InterfaceC0233q interfaceC0233q, Comparator comparator) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return L.minWithOrNull(interfaceC0233q, comparator);
    }

    private static final <T> BigDecimal sumOfBigDecimal(InterfaceC0233q interfaceC0233q, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(it.next()));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(InterfaceC0233q interfaceC0233q, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(it.next()));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return (SortedSet) L.toCollection(interfaceC0233q, new TreeSet());
    }

    /* JADX INFO: renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ Float m857max(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return L.m865maxOrNull(interfaceC0233q);
    }

    /* JADX INFO: renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ Float m859min(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return L.m873minOrNull(interfaceC0233q);
    }

    public static final <T> SortedSet<T> toSortedSet(InterfaceC0233q interfaceC0233q, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return (SortedSet) L.toCollection(interfaceC0233q, new TreeSet(comparator));
    }

    public static final /* synthetic */ Comparable max(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return L.maxOrNull(interfaceC0233q);
    }

    public static final /* synthetic */ Comparable min(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return L.minOrNull(interfaceC0233q);
    }
}
