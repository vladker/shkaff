package A3;

import W3.InterfaceC0233q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class T extends Q {
    public static final <T> boolean all(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Iterable<T> asIterable(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return iterable;
    }

    public static <T> InterfaceC0233q asSequence(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return new B(iterable, 9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(Iterable<? extends T> iterable, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(J.collectionSizeOrDefault(iterable, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            C1938s c1938s = (C1938s) transform.invoke(it.next());
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, T> associateBy(Iterable<? extends T> iterable, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(J.collectionSizeOrDefault(iterable, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (T t6 : iterable) {
            linkedHashMap.put(keySelector.invoke(t6), t6);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Iterable<? extends T> iterable, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (T t6 : iterable) {
            destination.put(keySelector.invoke(t6), t6);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Iterable<? extends T> iterable, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            C1938s c1938s = (C1938s) transform.invoke(it.next());
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateWith(Iterable<? extends K> iterable, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(J.collectionSizeOrDefault(iterable, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (K k6 : iterable) {
            linkedHashMap.put(k6, valueSelector.invoke(k6));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Iterable<? extends K> iterable, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (K k6 : iterable) {
            destination.put(k6, valueSelector.invoke(k6));
        }
        return destination;
    }

    public static final double averageOfByte(Iterable<Byte> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        double dByteValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dByteValue += (double) it.next().byteValue();
            i5++;
            if (i5 < 0) {
                I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i5);
    }

    public static final double averageOfDouble(Iterable<Double> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i5++;
            if (i5 < 0) {
                I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i5);
    }

    public static final double averageOfFloat(Iterable<Float> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        double dFloatValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i5++;
            if (i5 < 0) {
                I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i5);
    }

    public static final double averageOfInt(Iterable<Integer> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        double dIntValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i5++;
            if (i5 < 0) {
                I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i5);
    }

    public static final double averageOfLong(Iterable<Long> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        double dLongValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i5++;
            if (i5 < 0) {
                I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i5);
    }

    public static final double averageOfShort(Iterable<Short> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        double dShortValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dShortValue += (double) it.next().shortValue();
            i5++;
            if (i5 < 0) {
                I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i5);
    }

    public static final <T> List<List<T>> chunked(Iterable<? extends T> iterable, int i5) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return windowed(iterable, i5, i5, true);
    }

    private static final <T> T component1(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.get(0);
    }

    private static final <T> T component2(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.get(1);
    }

    private static final <T> T component3(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.get(2);
    }

    private static final <T> T component4(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.get(3);
    }

    private static final <T> T component5(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.get(4);
    }

    public static <T> boolean contains(Iterable<? extends T> iterable, T t6) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t6);
        }
        return indexOf(iterable, t6) >= 0;
    }

    public static final <T> int count(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<? extends T> it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            it.next();
            i5++;
            if (i5 < 0) {
                I.throwCountOverflow();
            }
        }
        return i5;
    }

    public static final <T> List<T> distinct(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return toList(toMutableSet(iterable));
    }

    public static final <T, K> List<T> distinctBy(Iterable<? extends T> iterable, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t6 : iterable) {
            if (hashSet.add(selector.invoke(t6))) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static <T> List<T> drop(Iterable<? extends T> iterable, int i5) {
        ArrayList arrayList;
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return toList(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i5;
            if (size <= 0) {
                return I.emptyList();
            }
            if (size == 1) {
                return G.listOf(last(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i5 < size2) {
                        arrayList.add(list.get(i5));
                        i5++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i5);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i6 = 0;
        for (T t6 : iterable) {
            if (i6 >= i5) {
                arrayList.add(t6);
            } else {
                i6++;
            }
        }
        return I.optimizeReadOnlyList(arrayList);
    }

    public static final <T> List<T> dropLast(List<? extends T> list, int i5) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int size = list.size() - i5;
        if (size < 0) {
            size = 0;
        }
        return take(list, size);
    }

    public static final <T> List<T> dropLastWhile(List<? extends T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!((Boolean) predicate.invoke(listIterator.previous())).booleanValue()) {
                    return take(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return I.emptyList();
    }

    public static final <T> List<T> dropWhile(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (T t6 : iterable) {
            if (z6) {
                arrayList.add(t6);
            } else if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                arrayList.add(t6);
                z6 = true;
            }
        }
        return arrayList;
    }

    public static final <T> T elementAt(Iterable<? extends T> iterable, int i5) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(i5) : (T) elementAtOrElse(iterable, i5, new S(i5, 0));
    }

    public static final <T> T elementAtOrElse(Iterable<? extends T> iterable, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i5 < 0 || i5 >= list.size()) ? (T) defaultValue.invoke(Integer.valueOf(i5)) : (T) list.get(i5);
        }
        if (i5 < 0) {
            return (T) defaultValue.invoke(Integer.valueOf(i5));
        }
        int i6 = 0;
        for (T t6 : iterable) {
            int i7 = i6 + 1;
            if (i5 == i6) {
                return t6;
            }
            i6 = i7;
        }
        return (T) defaultValue.invoke(Integer.valueOf(i5));
    }

    public static final <T> T elementAtOrNull(Iterable<? extends T> iterable, int i5) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) getOrNull((List) iterable, i5);
        }
        if (i5 < 0) {
            return null;
        }
        int i6 = 0;
        for (T t6 : iterable) {
            int i7 = i6 + 1;
            if (i5 == i6) {
                return t6;
            }
            i6 = i7;
        }
        return null;
    }

    public static final <T> List<T> filter(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t6 : iterable) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterIndexed(Iterable<? extends T> iterable, O3.p predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            if (((Boolean) predicate.invoke(Integer.valueOf(i5), t6)).booleanValue()) {
                arrayList.add(t6);
            }
            i5 = i6;
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(Iterable<? extends T> iterable, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            if (((Boolean) predicate.invoke(Integer.valueOf(i5), t6)).booleanValue()) {
                destination.add(t6);
            }
            i5 = i6;
        }
        return destination;
    }

    public static final <T> List<T> filterNot(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t6 : iterable) {
            if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (T t6 : iterable) {
            if (t6 != null) {
                destination.add(t6);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(Iterable<? extends T> iterable, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : iterable) {
            if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                destination.add(t6);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(Iterable<? extends T> iterable, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : iterable) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                destination.add(t6);
            }
        }
        return destination;
    }

    private static final <T> T find(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        while (itC.hasNext()) {
            T t6 = (T) itC.next();
            if (((Boolean) lVar.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        return null;
    }

    private static final <T> T findLast(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        T t6 = null;
        while (itC.hasNext()) {
            Object next = itC.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                t6 = (T) next;
            }
        }
        return t6;
    }

    public static final <T> T first(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        while (itC.hasNext()) {
            T t6 = (T) itC.next();
            if (((Boolean) lVar.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    private static final <T, R> R firstNotNullOf(Iterable<? extends T> iterable, O3.l lVar) {
        R r6;
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "transform");
        while (itC.hasNext()) {
            r6 = (R) lVar.invoke(itC.next());
            if (r6 != null) {
                if (r6 != null) {
                    return r6;
                }
                throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
            }
        }
        r6 = null;
        if (r6 != null) {
            return r6;
        }
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }

    private static final <T, R> R firstNotNullOfOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "transform");
        while (itC.hasNext()) {
            R r6 = (R) lVar.invoke(itC.next());
            if (r6 != null) {
                return r6;
            }
        }
        return null;
    }

    public static final <T> T firstOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        while (itC.hasNext()) {
            T t6 = (T) itC.next();
            if (((Boolean) lVar.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        return null;
    }

    public static final <T, R> List<R> flatMap(Iterable<? extends T> iterable, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            O.addAll(arrayList, (Iterable) transform.invoke(it.next()));
        }
        return arrayList;
    }

    private static final <T, R> List<R> flatMapIndexedIterable(Iterable<? extends T> iterable, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i5), t6));
            i5 = i6;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(Iterable<? extends T> iterable, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i5), t6));
            i5 = i6;
        }
        return destination;
    }

    private static final <T, R> List<R> flatMapIndexedSequence(Iterable<? extends T> iterable, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            O.addAll(arrayList, (InterfaceC0233q) transform.invoke(Integer.valueOf(i5), t6));
            i5 = i6;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(Iterable<? extends T> iterable, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            O.addAll(destination, (InterfaceC0233q) transform.invoke(Integer.valueOf(i5), t6));
            i5 = i6;
        }
        return destination;
    }

    public static final <T, R> List<R> flatMapSequence(Iterable<? extends T> iterable, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            O.addAll(arrayList, (InterfaceC0233q) transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(Iterable<? extends T> iterable, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            O.addAll(destination, (InterfaceC0233q) transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(Iterable<? extends T> iterable, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            O.addAll(destination, (Iterable) transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R> R fold(Iterable<? extends T> iterable, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r6 = (R) operation.invoke(r6, it.next());
        }
        return r6;
    }

    public static final <T, R> R foldIndexed(Iterable<? extends T> iterable, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, t6);
            i5 = i6;
        }
        return r6;
    }

    public static final <T, R> R foldRight(List<? extends T> list, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r6 = (R) operation.invoke(listIterator.previous(), r6);
            }
        }
        return r6;
    }

    public static final <T, R> R foldRightIndexed(List<? extends T> list, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r6 = (R) operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r6);
            }
        }
        return r6;
    }

    public static final <T> void forEach(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "action");
        while (itC.hasNext()) {
            lVar.invoke(itC.next());
        }
    }

    public static final <T> void forEachIndexed(Iterable<? extends T> iterable, O3.p action) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i5), t6);
            i5 = i6;
        }
    }

    public static /* synthetic */ String g(Iterable iterable, String str, String str2, String str3, O3.l lVar, int i5) {
        if ((i5 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i5 & 2) != 0 ? "" : str2;
        String str6 = (i5 & 4) != 0 ? "" : str3;
        if ((i5 & 32) != 0) {
            lVar = null;
        }
        return joinToString(iterable, str4, str5, str6, -1, "...", lVar);
    }

    private static final <T> T getOrElse(List<? extends T> list, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= list.size()) ? (T) defaultValue.invoke(Integer.valueOf(i5)) : list.get(i5);
    }

    public static <T> T getOrNull(List<? extends T> list, int i5) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (i5 < 0 || i5 >= list.size()) {
            return null;
        }
        return list.get(i5);
    }

    public static final <T, K> Map<K, List<T>> groupBy(Iterable<? extends T> iterable, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t6 : iterable) {
            Object objInvoke = keySelector.invoke(t6);
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(t6);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Iterable<? extends T> iterable, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (T t6 : iterable) {
            Object objInvoke = keySelector.invoke(t6);
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(t6);
        }
        return destination;
    }

    public static final <T, K> InterfaceC0131a0 groupingBy(Iterable<? extends T> iterable, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        return new p075n1.a(iterable, keySelector, 1);
    }

    public static final <T> int indexOf(Iterable<? extends T> iterable, T t6) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t6);
        }
        int i5 = 0;
        for (T t7 : iterable) {
            if (i5 < 0) {
                I.throwIndexOverflow();
            }
            if (kotlin.jvm.internal.E.a(t6, t7)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        int i5 = 0;
        while (itC.hasNext()) {
            Object next = itC.next();
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        int i5 = -1;
        int i6 = 0;
        while (itC.hasNext()) {
            Object next = itC.next();
            if (i6 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                i5 = i6;
            }
            i6++;
        }
        return i5;
    }

    public static final <T> Set<T> intersect(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (T t6 : iterable) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            X3.M.appendElement(buffer, t6, lVar);
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String joinToString(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(iterable, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static final <T> T last(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        T t6 = null;
        boolean z6 = false;
        while (itC.hasNext()) {
            Object next = itC.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                z6 = true;
                t6 = (T) next;
            }
        }
        if (z6) {
            return t6;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(Iterable<? extends T> iterable, T t6) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t6);
        }
        int i5 = -1;
        int i6 = 0;
        for (T t7 : iterable) {
            if (i6 < 0) {
                I.throwIndexOverflow();
            }
            if (kotlin.jvm.internal.E.a(t6, t7)) {
                i5 = i6;
            }
            i6++;
        }
        return i5;
    }

    public static final <T> T lastOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        T t6 = null;
        while (itC.hasNext()) {
            Object next = itC.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                t6 = (T) next;
            }
        }
        return t6;
    }

    public static final <T, R> List<R> map(Iterable<? extends T> iterable, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexed(Iterable<? extends T> iterable, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(iterable, 10));
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            arrayList.add(transform.invoke(Integer.valueOf(i5), t6));
            i5 = i6;
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexedNotNull(Iterable<? extends T> iterable, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            Object objInvoke = transform.invoke(Integer.valueOf(i5), t6);
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
            i5 = i6;
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Iterable<? extends T> iterable, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            Object objInvoke = transform.invoke(Integer.valueOf(i5), t6);
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
            i5 = i6;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Iterable<? extends T> iterable, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        for (T t6 : iterable) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            destination.add(transform.invoke(Integer.valueOf(i5), t6));
            i5 = i6;
        }
        return destination;
    }

    public static final <T, R> List<R> mapNotNull(Iterable<? extends T> iterable, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object objInvoke = transform.invoke(it.next());
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Iterable<? extends T> iterable, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object objInvoke = transform.invoke(it.next());
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(Iterable<? extends T> iterable, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrNull(Iterable<? extends T> iterable, O3.l lVar) {
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

    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            throw new NoSuchElementException();
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

    private static final <T> double maxOf(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) lVar.invoke(itC.next())).doubleValue();
        while (itC.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) lVar.invoke(itC.next())).doubleValue());
        }
        return dDoubleValue;
    }

    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            return null;
        }
        R r6 = (R) lVar.invoke(itC.next());
        while (itC.hasNext()) {
            Comparable comparable = (Comparable) lVar.invoke(itC.next());
            if (r6.compareTo(comparable) < 0) {
                r6 = (R) comparable;
            }
        }
        return r6;
    }

    private static final <T, R> R maxOfWith(Iterable<? extends T> iterable, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R r6 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Object objInvoke = selector.invoke(it.next());
            if (comparator.compare(r6, objInvoke) < 0) {
                r6 = (R) objInvoke;
            }
        }
        return r6;
    }

    private static final <T, R> R maxOfWithOrNull(Iterable<? extends T> iterable, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R r6 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Object objInvoke = selector.invoke(it.next());
            if (comparator.compare(r6, objInvoke) < 0) {
                r6 = (R) objInvoke;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Double m94maxOrNull(Iterable<Double> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double maxOrThrow(Iterable<Double> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    public static final <T> T maxWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T maxWithOrThrow(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrNull(Iterable<? extends T> iterable, O3.l lVar) {
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

    public static final <T, R extends Comparable<? super R>> T minByOrThrow(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            throw new NoSuchElementException();
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

    private static final <T> double minOf(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) lVar.invoke(itC.next())).doubleValue();
        while (itC.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) lVar.invoke(itC.next())).doubleValue());
        }
        return dDoubleValue;
    }

    private static final <T, R extends Comparable<? super R>> R minOfOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            return null;
        }
        R r6 = (R) lVar.invoke(itC.next());
        while (itC.hasNext()) {
            Comparable comparable = (Comparable) lVar.invoke(itC.next());
            if (r6.compareTo(comparable) > 0) {
                r6 = (R) comparable;
            }
        }
        return r6;
    }

    private static final <T, R> R minOfWith(Iterable<? extends T> iterable, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R r6 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Object objInvoke = selector.invoke(it.next());
            if (comparator.compare(r6, objInvoke) > 0) {
                r6 = (R) objInvoke;
            }
        }
        return r6;
    }

    private static final <T, R> R minOfWithOrNull(Iterable<? extends T> iterable, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R r6 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Object objInvoke = selector.invoke(it.next());
            if (comparator.compare(r6, objInvoke) > 0) {
                r6 = (R) objInvoke;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Double m102minOrNull(Iterable<Double> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double minOrThrow(Iterable<Double> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    public static final <T> T minWithOrNull(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T minWithOrThrow(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, T t6) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(iterable, 10));
        boolean z6 = false;
        for (T t7 : iterable) {
            boolean z7 = true;
            if (!z6 && kotlin.jvm.internal.E.a(t7, t6)) {
                z6 = true;
                z7 = false;
            }
            if (z7) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    private static final <T> List<T> minusElement(Iterable<? extends T> iterable, T t6) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return minus(iterable, t6);
    }

    public static final <T> boolean none(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static final <T, C extends Iterable<? extends T>> C onEach(C c, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(c, "<this>", lVar, "action");
        while (itC.hasNext()) {
            lVar.invoke(itC.next());
        }
        return c;
    }

    public static final <T, C extends Iterable<? extends T>> C onEachIndexed(C c, O3.p action) {
        kotlin.jvm.internal.E.f(c, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int i5 = 0;
        for (T t6 : c) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                I.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i5), t6);
            i5 = i6;
        }
        return c;
    }

    public static final <T> C1938s partition(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t6 : iterable) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                arrayList.add(t6);
            } else {
                arrayList2.add(t6);
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T t6) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object) t6);
        }
        ArrayList arrayList = new ArrayList();
        O.addAll(arrayList, iterable);
        arrayList.add(t6);
        return arrayList;
    }

    private static final <T> List<T> plusElement(Iterable<? extends T> iterable, T t6) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return plus(iterable, t6);
    }

    private static final <T> T random(Collection<? extends T> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        return (T) random(collection, S3.f.Default);
    }

    private static final <T> T randomOrNull(Collection<? extends T> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        return (T) randomOrNull(collection, S3.f.Default);
    }

    public static final <S, T extends S> S reduce(Iterable<? extends T> iterable, O3.p operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = (S) operation.invoke(next, it.next());
        }
        return next;
    }

    public static final <S, T extends S> S reduceIndexed(Iterable<? extends T> iterable, O3.q operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        T next = it.next();
        int i5 = 1;
        while (it.hasNext()) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            next = (S) operation.invoke(Integer.valueOf(i5), next, it.next());
            i5 = i6;
        }
        return next;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(Iterable<? extends T> iterable, O3.q operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        int i5 = 1;
        while (it.hasNext()) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                I.throwIndexOverflow();
            }
            next = (S) operation.invoke(Integer.valueOf(i5), next, it.next());
            i5 = i6;
        }
        return next;
    }

    public static final <S, T extends S> S reduceOrNull(Iterable<? extends T> iterable, O3.p operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = (S) operation.invoke(next, it.next());
        }
        return next;
    }

    public static final <S, T extends S> S reduceRight(List<? extends T> list, O3.p operation) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        T tPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            tPrevious = (S) operation.invoke(listIterator.previous(), tPrevious);
        }
        return tPrevious;
    }

    public static final <S, T extends S> S reduceRightIndexed(List<? extends T> list, O3.q operation) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        T tPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            tPrevious = (S) operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), tPrevious);
        }
        return tPrevious;
    }

    public static final <S, T extends S> S reduceRightIndexedOrNull(List<? extends T> list, O3.q operation) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        T tPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            tPrevious = (S) operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), tPrevious);
        }
        return tPrevious;
    }

    public static final <S, T extends S> S reduceRightOrNull(List<? extends T> list, O3.p operation) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        T tPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            tPrevious = (S) operation.invoke(listIterator.previous(), tPrevious);
        }
        return tPrevious;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Iterable<T> requireNoNulls(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + '.');
            }
        }
        return iterable;
    }

    public static final <T> List<T> reversed(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        Q.reverse(mutableList);
        return mutableList;
    }

    public static final <T, R> List<R> runningFold(Iterable<? extends T> iterable, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r6);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r6 = (R) operation.invoke(r6, it.next());
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final <T, R> List<R> runningFoldIndexed(Iterable<? extends T> iterable, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r6);
        Iterator<? extends T> it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, it.next());
            arrayList.add(r6);
            i5++;
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduce(Iterable<? extends T> iterable, O3.p operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return I.emptyList();
        }
        Object next = it.next();
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduceIndexed(Iterable<? extends T> iterable, O3.q operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return I.emptyList();
        }
        Object next = it.next();
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(iterable, 10));
        arrayList.add(next);
        int i5 = 1;
        while (it.hasNext()) {
            next = operation.invoke(Integer.valueOf(i5), next, it.next());
            arrayList.add(next);
            i5++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> scan(Iterable<? extends T> iterable, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r6);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r6 = (R) operation.invoke(r6, it.next());
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final <T, R> List<R> scanIndexed(Iterable<? extends T> iterable, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(iterable, 9);
        if (iCollectionSizeOrDefault == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault + 1);
        arrayList.add(r6);
        Iterator<? extends T> it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, it.next());
            arrayList.add(r6);
            i5++;
        }
        return arrayList;
    }

    public static final <T> void shuffle(List<T> list, S3.f random) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = I.getLastIndex(list); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            list.set(iD, list.set(lastIndex, list.get(iD)));
        }
    }

    public static final <T> T single(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        T t6 = null;
        boolean z6 = false;
        while (itC.hasNext()) {
            Object next = itC.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                if (z6) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                z6 = true;
                t6 = (T) next;
            }
        }
        if (z6) {
            return t6;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final <T> T singleOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "predicate");
        boolean z6 = false;
        T t6 = null;
        while (itC.hasNext()) {
            Object next = itC.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                if (z6) {
                    return null;
                }
                z6 = true;
                t6 = (T) next;
            }
        }
        if (z6) {
            return t6;
        }
        return null;
    }

    public static final <T> List<T> slice(List<? extends T> list, U3.q indices) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : toList(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(List<T> list, O3.l selector) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (list.size() > 1) {
            N.sortWith(list, new D3.d(0, selector));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(List<T> list, O3.l selector) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (list.size() > 1) {
            N.sortWith(list, new D3.d(1, selector));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        N.sortWith(list, D3.g.reverseOrder());
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            N.sort(mutableList);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        AbstractC0151t.sort(array);
        return AbstractC0151t.asList(array);
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(Iterable<? extends T> iterable, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(iterable, new D3.d(0, selector));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(Iterable<? extends T> iterable, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(iterable, new D3.d(1, selector));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return sortedWith(iterable, D3.g.reverseOrder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> mutableList = toMutableList(iterable);
            N.sortWith(mutableList, comparator);
            return mutableList;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        AbstractC0151t.sortWith(array, comparator);
        return AbstractC0151t.asList(array);
    }

    public static final <T> Set<T> subtract(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T> int sumBy(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        int iIntValue = 0;
        while (itC.hasNext()) {
            iIntValue += ((Number) lVar.invoke(itC.next())).intValue();
        }
        return iIntValue;
    }

    public static final <T> double sumByDouble(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        double dDoubleValue = 0.0d;
        while (itC.hasNext()) {
            dDoubleValue += ((Number) lVar.invoke(itC.next())).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfByte(Iterable<Byte> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += it.next().byteValue();
        }
        return iByteValue;
    }

    private static final <T> double sumOfDouble(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        double dDoubleValue = 0.0d;
        while (itC.hasNext()) {
            dDoubleValue += ((Number) lVar.invoke(itC.next())).doubleValue();
        }
        return dDoubleValue;
    }

    public static final float sumOfFloat(Iterable<Float> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    private static final <T> int sumOfInt(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        int iIntValue = 0;
        while (itC.hasNext()) {
            iIntValue += ((Number) lVar.invoke(itC.next())).intValue();
        }
        return iIntValue;
    }

    private static final <T> long sumOfLong(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        long jLongValue = 0;
        while (itC.hasNext()) {
            jLongValue += ((Number) lVar.invoke(itC.next())).longValue();
        }
        return jLongValue;
    }

    public static final int sumOfShort(Iterable<Short> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += it.next().shortValue();
        }
        return iShortValue;
    }

    private static final <T> int sumOfUInt(Iterable<? extends T> iterable, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(it.next())).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final <T> long sumOfULong(Iterable<? extends T> iterable, O3.l selector) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(it.next())).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static <T> List<T> take(Iterable<? extends T> iterable, int i5) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (iterable instanceof Collection) {
            if (i5 >= ((Collection) iterable).size()) {
                return toList(iterable);
            }
            if (i5 == 1) {
                return G.listOf(first(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i5);
        Iterator<? extends T> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return I.optimizeReadOnlyList(arrayList);
    }

    public static final <T> List<T> takeLast(List<? extends T> list, int i5) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int size = list.size();
        if (i5 >= size) {
            return toList(list);
        }
        if (i5 == 1) {
            return G.listOf(last((List) list));
        }
        ArrayList arrayList = new ArrayList(i5);
        if (list instanceof RandomAccess) {
            for (int i6 = size - i5; i6 < size; i6++) {
                arrayList.add(list.get(i6));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i5);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final <T> List<T> takeLastWhile(List<? extends T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if (list.isEmpty()) {
            return I.emptyList();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!((Boolean) predicate.invoke(listIterator.previous())).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return I.emptyList();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return toList(list);
    }

    public static final <T> List<T> takeWhile(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t6 : iterable) {
            if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                break;
            }
            arrayList.add(t6);
        }
        return arrayList;
    }

    public static boolean[] toBooleanArray(Collection<Boolean> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            zArr[i5] = it.next().booleanValue();
            i5++;
        }
        return zArr;
    }

    public static final byte[] toByteArray(Collection<Byte> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            bArr[i5] = it.next().byteValue();
            i5++;
        }
        return bArr;
    }

    public static final char[] toCharArray(Collection<Character> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            cArr[i5] = it.next().charValue();
            i5++;
        }
        return cArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static final double[] toDoubleArray(Collection<Double> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            dArr[i5] = it.next().doubleValue();
            i5++;
        }
        return dArr;
    }

    public static float[] toFloatArray(Collection<Float> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            fArr[i5] = it.next().floatValue();
            i5++;
        }
        return fArr;
    }

    public static <T> HashSet<T> toHashSet(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return (HashSet) toCollection(iterable, new HashSet(j0.mapCapacity(J.collectionSizeOrDefault(iterable, 12))));
    }

    public static final int[] toIntArray(Collection<Integer> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            iArr[i5] = it.next().intValue();
            i5++;
        }
        return iArr;
    }

    public static <T> List<T> toList(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return I.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return I.emptyList();
        }
        if (size != 1) {
            return toMutableList(collection);
        }
        return G.listOf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final long[] toLongArray(Collection<Long> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            jArr[i5] = it.next().longValue();
            i5++;
        }
        return jArr;
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return iterable instanceof Collection ? toMutableList((Collection) iterable) : (List) toCollection(iterable, new ArrayList());
    }

    public static <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) toCollection(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> toSet(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return w0.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return w0.emptySet();
        }
        if (size != 1) {
            return (Set) toCollection(iterable, new LinkedHashSet(j0.mapCapacity(collection.size())));
        }
        return v0.setOf(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final short[] toShortArray(Collection<Short> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            sArr[i5] = it.next().shortValue();
            i5++;
        }
        return sArr;
    }

    public static final <T> Set<T> union(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T> List<List<T>> windowed(Iterable<? extends T> iterable, int i5, int i6, boolean z6) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        B0.a(i5, i6);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itWindowedIterator = B0.windowedIterator(iterable.iterator(), i5, i6, z6, false);
            while (itWindowedIterator.hasNext()) {
                arrayList.add((List) itWindowedIterator.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i6) + (size % i6 == 0 ? 0 : 1));
        int i7 = 0;
        while (i7 >= 0 && i7 < size) {
            int i8 = size - i7;
            if (i5 <= i8) {
                i8 = i5;
            }
            if (i8 < i5 && !z6) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(i8);
            for (int i9 = 0; i9 < i8; i9++) {
                arrayList3.add(list.get(i9 + i7));
            }
            arrayList2.add(arrayList3);
            i7 += i6;
        }
        return arrayList2;
    }

    public static final <T> Iterable<C0133b0> withIndex(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return new C0135c0(new C0152u(iterable, 5));
    }

    public static final <T, R, V> List<V> zip(Iterable<? extends T> iterable, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(iterable, 10), length));
        int i5 = 0;
        for (T t6 : iterable) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(t6, other[i5]));
            i5++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> zipWithNext(Iterable<? extends T> iterable, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(transform.invoke(next, next2));
            next = next2;
        }
        return arrayList;
    }

    public static final <T, R> List<R> chunked(Iterable<? extends T> iterable, int i5, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return windowed(iterable, i5, i5, true, transform);
    }

    private static final <T> List<T> plusElement(Collection<? extends T> collection, T t6) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        return plus((Collection) collection, (Object) t6);
    }

    public static final <T> T random(Collection<? extends T> collection, S3.f random) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) elementAt(collection, random.d(collection.size()));
    }

    public static final <T> T randomOrNull(Collection<? extends T> collection, S3.f random) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) elementAt(collection, random.d(collection.size()));
    }

    public static final <T> boolean any(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Iterable<? extends T> iterable, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (T t6 : iterable) {
            destination.put(keySelector.invoke(t6), valueTransform.invoke(t6));
        }
        return destination;
    }

    private static final <T> int count(Collection<? extends T> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        return collection.size();
    }

    public static final <T> boolean none(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> requireNoNulls(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + '.');
            }
        }
        return list;
    }

    public static final <T> List<T> slice(List<? extends T> list, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(list.get(it.next().intValue()));
        }
        return arrayList;
    }

    public static final <T> int count(Iterable<? extends T> iterable, O3.l predicate) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue() && (i5 = i5 + 1) < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
                I.throwCountOverflow();
            }
        }
        return i5;
    }

    private static final <T> T elementAt(List<? extends T> list, int i5) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.get(i5);
    }

    public static <T> List<T> toMutableList(Collection<? extends T> collection) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        return new ArrayList(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associateBy(Iterable<? extends T> iterable, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(J.collectionSizeOrDefault(iterable, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (T t6 : iterable) {
            linkedHashMap.put(keySelector.invoke(t6), valueTransform.invoke(t6));
        }
        return linkedHashMap;
    }

    public static final <T> int indexOf(List<? extends T> list, T t6) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.indexOf(t6);
    }

    public static final <T> int lastIndexOf(List<? extends T> list, T t6) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return list.lastIndexOf(t6);
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, T[] elements) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        if (elements.length == 0) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t6 : iterable) {
            if (!C.contains(elements, t6)) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static <T> List<T> plus(Collection<? extends T> collection, T t6) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t6);
        return arrayList;
    }

    public static final <T, R, V> List<V> zip(Iterable<? extends T> iterable, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(iterable, 10), J.collectionSizeOrDefault(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(transform.invoke(it.next(), it2.next()));
        }
        return arrayList;
    }

    private static final <T> T elementAtOrNull(List<? extends T> list, int i5) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return (T) getOrNull(list, i5);
    }

    public static <T> T firstOrNull(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    private static final <T> T findLast(List<? extends T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (((Boolean) predicate.invoke(tPrevious)).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    public static final <T> T first(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T lastOrNull(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) AbstractC0157z.f(1, list);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> T singleOrNull(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static final double sumOfDouble(Iterable<Double> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfInt(Iterable<Integer> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    public static final long sumOfLong(Iterable<Long> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    private static final <T> T elementAtOrElse(List<? extends T> list, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= list.size()) ? (T) defaultValue.invoke(Integer.valueOf(i5)) : list.get(i5);
    }

    public static final <T> int indexOfFirst(List<? extends T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(List<? extends T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (((Boolean) predicate.invoke(listIterator.previous())).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static final <T> T last(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) last((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m95maxOrNull(Iterable<Float> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final float m96maxOrThrow(Iterable<Float> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.max(fFloatValue, it.next().floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Float m103minOrNull(Iterable<Float> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final float m104minOrThrow(Iterable<Float> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.min(fFloatValue, it.next().floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, T[] elements) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object[]) elements);
        }
        ArrayList arrayList = new ArrayList();
        O.addAll(arrayList, iterable);
        O.addAll(arrayList, elements);
        return arrayList;
    }

    public static final <T> List<C1938s> zipWithNext(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(p147z3.A.to(next, next2));
            next = next2;
        }
        return arrayList;
    }

    public static <T> T single(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) single((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Iterable<? extends T> iterable, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (T t6 : iterable) {
            Object objInvoke = keySelector.invoke(t6);
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(t6));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m92maxOfOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) lVar.invoke(itC.next())).doubleValue();
        while (itC.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) lVar.invoke(itC.next())).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m100minOfOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) lVar.invoke(itC.next())).doubleValue();
        while (itC.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) lVar.invoke(itC.next())).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        Collection collectionConvertToListIfNotCollection = O.convertToListIfNotCollection(elements);
        if (collectionConvertToListIfNotCollection.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t6 : iterable) {
            if (!collectionConvertToListIfNotCollection.contains(t6)) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static final <T, R> List<C1938s> zip(Iterable<? extends T> iterable, R[] other) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(iterable, 10), length));
        int i5 = 0;
        for (T t6 : iterable) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(t6, other[i5]));
            i5++;
        }
        return arrayList;
    }

    public static final <T, K, V> Map<K, List<V>> groupBy(Iterable<? extends T> iterable, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t6 : iterable) {
            Object objInvoke = keySelector.invoke(t6);
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(t6));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m90maxOf(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (itC.hasNext()) {
            float fFloatValue = ((Number) lVar.invoke(itC.next())).floatValue();
            while (itC.hasNext()) {
                fFloatValue = Math.max(fFloatValue, ((Number) lVar.invoke(itC.next())).floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m98minOf(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (itC.hasNext()) {
            float fFloatValue = ((Number) lVar.invoke(itC.next())).floatValue();
            while (itC.hasNext()) {
                fFloatValue = Math.min(fFloatValue, ((Number) lVar.invoke(itC.next())).floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final <T, R> List<R> windowed(Iterable<? extends T> iterable, int i5, int i6, boolean z6, O3.l transform) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        B0.a(i5, i6);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            int i7 = 0;
            ArrayList arrayList = new ArrayList((size / i6) + (size % i6 == 0 ? 0 : 1));
            n0 n0Var = new n0(list);
            while (i7 >= 0 && i7 < size) {
                int i8 = size - i7;
                if (i5 <= i8) {
                    i8 = i5;
                }
                if (!z6 && i8 < i5) {
                    break;
                }
                n0Var.c(i7, i8 + i7);
                arrayList.add(transform.invoke(n0Var));
                i7 += i6;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator itWindowedIterator = B0.windowedIterator(iterable.iterator(), i5, i6, z6, true);
        while (itWindowedIterator.hasNext()) {
            arrayList2.add(transform.invoke((List) itWindowedIterator.next()));
        }
        return arrayList2;
    }

    public static final <T> T first(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T firstOrNull(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T[] elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        O.addAll(arrayList, elements);
        return arrayList;
    }

    public static <T> T singleOrNull(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T> T last(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(I.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m97maxOrThrow(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) < 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    public static <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m105minOrThrow(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Iterable) elements);
        }
        ArrayList arrayList = new ArrayList();
        O.addAll(arrayList, iterable);
        O.addAll(arrayList, elements);
        return arrayList;
    }

    public static <T> T lastOrNull(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return (T) AbstractC0157z.f(1, list);
    }

    public static final <T> T single(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T, R> List<C1938s> zip(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(iterable, 10), J.collectionSizeOrDefault(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(p147z3.A.to(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        List list = W3.L.toList(elements);
        if (list.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t6 : iterable) {
            if (!list.contains(t6)) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static final <T> T last(List<? extends T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (((Boolean) predicate.invoke(tPrevious)).booleanValue()) {
                return tPrevious;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public static <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        O.addAll(arrayList2, elements);
        return arrayList2;
    }

    public static final <T> T lastOrNull(List<? extends T> list, O3.l predicate) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (((Boolean) predicate.invoke(tPrevious)).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m93maxOfOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) lVar.invoke(itC.next())).floatValue();
        while (itC.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) lVar.invoke(itC.next())).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m101minOfOrNull(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (!itC.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) lVar.invoke(itC.next())).floatValue();
        while (itC.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) lVar.invoke(itC.next())).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m91maxOf(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (itC.hasNext()) {
            R r6 = (R) lVar.invoke(itC.next());
            while (itC.hasNext()) {
                Comparable comparable = (Comparable) lVar.invoke(itC.next());
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m99minOf(Iterable<? extends T> iterable, O3.l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        if (itC.hasNext()) {
            R r6 = (R) lVar.invoke(itC.next());
            while (itC.hasNext()) {
                Comparable comparable = (Comparable) lVar.invoke(itC.next());
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <T> List<T> plus(Iterable<? extends T> iterable, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        ArrayList arrayList = new ArrayList();
        O.addAll(arrayList, iterable);
        O.addAll(arrayList, elements);
        return arrayList;
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(collection, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        O.addAll(arrayList, elements);
        return arrayList;
    }
}
