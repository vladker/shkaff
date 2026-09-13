package A3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class I extends G {
    private static final <T> List<T> List(int i5, O3.l init) {
        kotlin.jvm.internal.E.f(init, "init");
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(init.invoke(Integer.valueOf(i6)));
        }
        return arrayList;
    }

    private static final <T> List<T> MutableList(int i5, O3.l init) {
        kotlin.jvm.internal.E.f(init, "init");
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(init.invoke(Integer.valueOf(i6)));
        }
        return arrayList;
    }

    public static final void a(int i5, int i6, int i7) {
        if (i6 > i7) {
            throw new IllegalArgumentException(androidx.collection.a.m("fromIndex (", i6, i7, ") is greater than toIndex (", ")."));
        }
        if (i6 < 0) {
            throw new IndexOutOfBoundsException(androidx.collection.a.i(i6, "fromIndex (", ") is less than zero."));
        }
        if (i7 > i5) {
            throw new IndexOutOfBoundsException(androidx.collection.a.m("toIndex (", i7, i5, ") is greater than size (", ")."));
        }
    }

    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<>();
    }

    public static final <T> Collection<T> asCollection(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return new C0142j(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t6, int i5, int i6) {
        kotlin.jvm.internal.E.f(list, "<this>");
        a(list.size(), i5, i6);
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int iCompareValues = D3.g.compareValues(list.get(i8), t6);
            if (iCompareValues < 0) {
                i5 = i8 + 1;
            } else {
                if (iCompareValues <= 0) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return -(i5 + 1);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> list, K k6, int i5, int i6, O3.l selector) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return binarySearch(list, i5, i6, new H(selector, k6));
    }

    private static final <E> List<E> buildList(O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        List listCreateListBuilder = G.createListBuilder();
        builderAction.invoke(listCreateListBuilder);
        return G.build(listCreateListBuilder);
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> collection) {
        kotlin.jvm.internal.E.f(collection, "collection");
        int i5 = 0;
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] objArr = new Object[collection.size()];
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i5] = it.next();
            i5++;
        }
        return objArr;
    }

    private static final <T> boolean containsAll(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return collection.containsAll(elements);
    }

    public static <T> List<T> emptyList() {
        return W.INSTANCE;
    }

    public static U3.q getIndices(Collection<?> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        return new U3.q(0, collection.size() - 1, 1);
    }

    public static <T> int getLastIndex(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;LO3/a;)TR; */
    private static final Object ifEmpty(Collection collection, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return collection.isEmpty() ? defaultValue.invoke() : collection;
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        return !collection.isEmpty();
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> List<T> listOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return elements.length > 0 ? AbstractC0151t.asList(elements) : emptyList();
    }

    public static final <T> List<T> listOfNotNull(T t6) {
        return t6 != null ? G.listOf(t6) : emptyList();
    }

    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : G.listOf(list.get(0));
        }
        return emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Collection<T> orEmpty(Collection<? extends T> collection) {
        return collection == 0 ? emptyList() : collection;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, S3.f random) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        List<T> mutableList = T.toMutableList(iterable);
        T.shuffle(mutableList, random);
        return mutableList;
    }

    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static <T> ArrayList<T> arrayListOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new C0142j(elements, true));
    }

    private static final <E> List<E> buildList(int i5, O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        List listCreateListBuilder = G.createListBuilder(i5);
        builderAction.invoke(listCreateListBuilder);
        return G.build(listCreateListBuilder);
    }

    private static final <T> List<T> listOf() {
        return emptyList();
    }

    public static final <T> List<T> listOfNotNull(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return C.filterNotNull(elements);
    }

    public static <T> List<T> mutableListOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new C0142j(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> orEmpty(List<? extends T> list) {
        return list == 0 ? emptyList() : list;
    }

    public static final <T> int binarySearch(List<? extends T> list, T t6, Comparator<? super T> comparator, int i5, int i6) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        a(list.size(), i5, i6);
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int iCompare = comparator.compare(list.get(i8), t6);
            if (iCompare < 0) {
                i5 = i8 + 1;
            } else {
                if (iCompare <= 0) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return -(i5 + 1);
    }

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> collection, T[] array) {
        Object[] objArr;
        kotlin.jvm.internal.E.f(collection, "collection");
        kotlin.jvm.internal.E.f(array, "array");
        int i5 = 0;
        if (collection.isEmpty()) {
            return (T[]) G.terminateCollectionToArray(0, array);
        }
        if (array.length < collection.size()) {
            objArr = array;
            objArr = (T[]) AbstractC0145m.arrayOfNulls(array, collection.size());
        }
        objArr = array;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            objArr[i5] = it.next();
            i5++;
        }
        return (T[]) G.terminateCollectionToArray(collection.size(), objArr);
    }

    public static final <T> int binarySearch(List<? extends T> list, int i5, int i6, O3.l comparison) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(comparison, "comparison");
        a(list.size(), i5, i6);
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int iIntValue = ((Number) comparison.invoke(list.get(i8))).intValue();
            if (iIntValue < 0) {
                i5 = i8 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return -(i5 + 1);
    }
}
