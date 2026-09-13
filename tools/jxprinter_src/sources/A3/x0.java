package A3;

import W3.InterfaceC0233q;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x0 extends w0 {
    public static final <T> Set<T> minus(Set<? extends T> set, T t6) {
        kotlin.jvm.internal.E.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.mapCapacity(set.size()));
        boolean z6 = false;
        for (T t7 : set) {
            boolean z7 = true;
            if (!z6 && kotlin.jvm.internal.E.a(t7, t6)) {
                z6 = true;
                z7 = false;
            }
            if (z7) {
                linkedHashSet.add(t7);
            }
        }
        return linkedHashSet;
    }

    private static final <T> Set<T> minusElement(Set<? extends T> set, T t6) {
        kotlin.jvm.internal.E.f(set, "<this>");
        return minus(set, t6);
    }

    public static <T> Set<T> plus(Set<? extends T> set, T t6) {
        kotlin.jvm.internal.E.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t6);
        return linkedHashSet;
    }

    private static final <T> Set<T> plusElement(Set<? extends T> set, T t6) {
        kotlin.jvm.internal.E.f(set, "<this>");
        return plus(set, t6);
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T[] elements) {
        kotlin.jvm.internal.E.f(set, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.mapCapacity(set.size() + elements.length));
        linkedHashSet.addAll(set);
        O.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, T[] elements) {
        kotlin.jvm.internal.E.f(set, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        O.removeAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(set, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        Collection<?> collectionConvertToListIfNotCollection = O.convertToListIfNotCollection(elements);
        if (collectionConvertToListIfNotCollection.isEmpty()) {
            return T.toSet(set);
        }
        if (collectionConvertToListIfNotCollection instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t6 : set) {
                if (!((Set) collectionConvertToListIfNotCollection).contains(t6)) {
                    linkedHashSet.add(t6);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(collectionConvertToListIfNotCollection);
        return linkedHashSet2;
    }

    public static <T> Set<T> plus(Set<? extends T> set, Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.E.f(set, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        Integer numCollectionSizeOrNull = J.collectionSizeOrNull(elements);
        if (numCollectionSizeOrNull != null) {
            size = set.size() + numCollectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.mapCapacity(size));
        linkedHashSet.addAll(set);
        O.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(set, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.mapCapacity(set.size() * 2));
        linkedHashSet.addAll(set);
        O.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(set, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        O.removeAll(linkedHashSet, elements);
        return linkedHashSet;
    }
}
