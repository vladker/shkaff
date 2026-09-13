package A3;

import W3.InterfaceC0233q;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class O extends N {
    public static <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z6 = true;
            }
        }
        return z6;
    }

    public static final boolean b(Iterable iterable, O3.l lVar, boolean z6) {
        Iterator it = iterable.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (((Boolean) lVar.invoke(it.next())).booleanValue() == z6) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    public static final boolean c(List list, O3.l lVar, boolean z6) {
        int i5;
        if (!(list instanceof RandomAccess)) {
            if (!(list instanceof P3.a) || (list instanceof P3.b)) {
                return b(list, lVar, z6);
            }
            kotlin.jvm.internal.Y.h(list, "kotlin.collections.MutableIterable");
            throw null;
        }
        int lastIndex = I.getLastIndex(list);
        if (lastIndex >= 0) {
            int i6 = 0;
            i5 = 0;
            while (true) {
                Object obj = list.get(i6);
                if (((Boolean) lVar.invoke(obj)).booleanValue() != z6) {
                    if (i5 != i6) {
                        list.set(i5, obj);
                    }
                    i5++;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        } else {
            i5 = 0;
        }
        if (i5 >= list.size()) {
            return false;
        }
        int lastIndex2 = I.getLastIndex(list);
        if (i5 > lastIndex2) {
            return true;
        }
        while (true) {
            list.remove(lastIndex2);
            if (lastIndex2 == i5) {
                return true;
            }
            lastIndex2--;
        }
    }

    public static <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : T.toList(iterable);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T t6) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        collection.remove(t6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void plusAssign(Collection<? super T> collection, T t6) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        collection.add(t6);
    }

    private static final <T> boolean remove(Collection<? extends T> collection, T t6) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.Y.a(collection);
        return collection.remove(t6);
    }

    private static final <T> boolean removeAll(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        kotlin.jvm.internal.Y.a(collection);
        return collection.removeAll(elements);
    }

    public static final <T> T removeFirst(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static final <T> T removeFirstOrNull(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public static <T> T removeLast(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(I.getLastIndex(list));
    }

    public static <T> T removeLastOrNull(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(I.getLastIndex(list));
    }

    private static final <T> boolean retainAll(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        kotlin.jvm.internal.Y.a(collection);
        return collection.retainAll(elements);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        removeAll(collection, elements);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        addAll(collection, elements);
    }

    private static final <T> T remove(List<T> list, int i5) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.remove(i5);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return collection.removeAll(convertToListIfNotCollection(elements));
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return collection.retainAll(convertToListIfNotCollection(elements));
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        removeAll(collection, elements);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        addAll(collection, elements);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        List list = W3.L.toList(elements);
        return !list.isEmpty() && collection.removeAll(list);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        if (!(elements.length == 0)) {
            return collection.retainAll(AbstractC0151t.asList(elements));
        }
        boolean z6 = !collection.isEmpty();
        collection.clear();
        return z6;
    }

    public static <T> boolean addAll(Collection<? super T> collection, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        Iterator<Object> it = elements.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z6 = true;
            }
        }
        return z6;
    }

    private static final <T> void minusAssign(Collection<? super T> collection, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        removeAll(collection, elements);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        addAll(collection, elements);
    }

    public static final <T> boolean removeAll(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return !(elements.length == 0) && collection.removeAll(AbstractC0151t.asList(elements));
    }

    public static final <T> boolean addAll(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return collection.addAll(AbstractC0151t.asList(elements));
    }

    public static final <T> boolean removeAll(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return b(iterable, predicate, true);
    }

    public static final <T> boolean removeAll(List<T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return c(list, predicate, true);
    }

    public static final <T> boolean retainAll(Collection<? super T> collection, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        List list = W3.L.toList(elements);
        if (!list.isEmpty()) {
            return collection.retainAll(list);
        }
        boolean z6 = !collection.isEmpty();
        collection.clear();
        return z6;
    }

    public static <T> boolean retainAll(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return b(iterable, predicate, false);
    }

    public static final <T> boolean retainAll(List<T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return c(list, predicate, false);
    }
}
