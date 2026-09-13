package A3;

import W3.InterfaceC0233q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class C extends AbstractC0151t {
    public static final <T> boolean all(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : tArr) {
            if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static <T> Iterable<T> asIterable(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr.length == 0 ? I.emptyList() : new A(tArr, 0);
    }

    public static <T> InterfaceC0233q asSequence(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr.length == 0 ? W3.z.emptySequence() : new B(tArr, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(T[] tArr, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(tArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (T t6 : tArr) {
            C1938s c1938s = (C1938s) transform.invoke(t6);
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, T> associateBy(T[] tArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(tArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (T t6 : tArr) {
            linkedHashMap.put(keySelector.invoke(t6), t6);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(T[] tArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (T t6 : tArr) {
            destination.put(keySelector.invoke(t6), t6);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(T[] tArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (T t6 : tArr) {
            C1938s c1938s = (C1938s) transform.invoke(t6);
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateWith(K[] kArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(kArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(kArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (K k6 : kArr) {
            linkedHashMap.put(k6, valueSelector.invoke(k6));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(K[] kArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(kArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (K k6 : kArr) {
            destination.put(k6, valueSelector.invoke(k6));
        }
        return destination;
    }

    public static final double average(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        double d = 0.0d;
        int i5 = 0;
        for (byte b : bArr) {
            d += (double) b;
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return d / ((double) i5);
    }

    public static final double averageOfByte(Byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        double dByteValue = 0.0d;
        int i5 = 0;
        for (Byte b : bArr) {
            dByteValue += (double) b.byteValue();
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i5);
    }

    public static final double averageOfDouble(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        double dDoubleValue = 0.0d;
        int i5 = 0;
        for (Double d : dArr) {
            dDoubleValue += d.doubleValue();
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i5);
    }

    public static final double averageOfFloat(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        double dFloatValue = 0.0d;
        int i5 = 0;
        for (Float f6 : fArr) {
            dFloatValue += (double) f6.floatValue();
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i5);
    }

    public static final double averageOfInt(Integer[] numArr) {
        kotlin.jvm.internal.E.f(numArr, "<this>");
        double dIntValue = 0.0d;
        int i5 = 0;
        for (Integer num : numArr) {
            dIntValue += (double) num.intValue();
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i5);
    }

    public static final double averageOfLong(Long[] lArr) {
        kotlin.jvm.internal.E.f(lArr, "<this>");
        double dLongValue = 0.0d;
        int i5 = 0;
        for (Long l6 : lArr) {
            dLongValue += l6.longValue();
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i5);
    }

    public static final double averageOfShort(Short[] shArr) {
        kotlin.jvm.internal.E.f(shArr, "<this>");
        double dShortValue = 0.0d;
        int i5 = 0;
        for (Short sh : shArr) {
            dShortValue += (double) sh.shortValue();
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i5);
    }

    private static final <T> T component1(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr[0];
    }

    private static final <T> T component2(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr[1];
    }

    private static final <T> T component3(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr[2];
    }

    private static final <T> T component4(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr[3];
    }

    private static final <T> T component5(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr[4];
    }

    public static <T> boolean contains(T[] tArr, T t6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return indexOf(tArr, t6) >= 0;
    }

    private static final <T> int count(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr.length;
    }

    public static final <T> List<T> distinct(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return T.toList(toMutableSet(tArr));
    }

    public static final <T, K> List<T> distinctBy(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t6 : tArr) {
            if (hashSet.add(selector.invoke(t6))) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static <T> List<T> drop(T[] tArr, int i5) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = tArr.length - i5;
        if (length < 0) {
            length = 0;
        }
        return takeLast(tArr, length);
    }

    public static final <T> List<T> dropLast(T[] tArr, int i5) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        int length = tArr.length - i5;
        if (length < 0) {
            length = 0;
        }
        return take(tArr, length);
    }

    public static final <T> List<T> dropLastWhile(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(tArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(tArr[lastIndex])).booleanValue()) {
                return take(tArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    public static final <T> List<T> dropWhile(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (T t6 : tArr) {
            if (z6) {
                arrayList.add(t6);
            } else if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                arrayList.add(t6);
                z6 = true;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ String e(byte[] bArr, String str, S2.l lVar, int i5) {
        CharSequence charSequence = (i5 & 2) != 0 ? "" : "[";
        String str2 = (i5 & 4) == 0 ? "]" : "";
        if ((i5 & 32) != 0) {
            lVar = null;
        }
        return joinToString(bArr, (CharSequence) str, charSequence, (CharSequence) str2, -1, (CharSequence) "...", (O3.l) lVar);
    }

    private static final <T> T elementAtOrElse(T[] tArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= tArr.length) ? (T) defaultValue.invoke(Integer.valueOf(i5)) : tArr[i5];
    }

    private static final <T> T elementAtOrNull(T[] tArr, int i5) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return (T) getOrNull(tArr, i5);
    }

    public static final <T> List<T> filter(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterIndexed(T[] tArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            T t6 = tArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), t6)).booleanValue()) {
                arrayList.add(t6);
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(T[] tArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            T t6 = tArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), t6)).booleanValue()) {
                destination.add(t6);
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final <T> List<T> filterNot(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t6 : tArr) {
            if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static <T> List<T> filterNotNull(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C destination) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (T t6 : tArr) {
            if (t6 != null) {
                destination.add(t6);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(T[] tArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : tArr) {
            if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                destination.add(t6);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(T[] tArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                destination.add(t6);
            }
        }
        return destination;
    }

    private static final <T> T find(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        return null;
    }

    private static final <T> T findLast(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            T t6 = tArr[length];
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                return t6;
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static <T> T first(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001d  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c A[RETURN] */
    private static final <T, R> R firstNotNullOf(T[] tArr, O3.l transform) {
        R r6;
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (T t6 : tArr) {
            r6 = (R) transform.invoke(t6);
            if (r6 != null) {
                if (r6 != null) {
                    return r6;
                }
                throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
            }
        }
        r6 = null;
        if (r6 != null) {
            return r6;
        }
        throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
    }

    private static final <T, R> R firstNotNullOfOrNull(T[] tArr, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (T t6 : tArr) {
            R r6 = (R) transform.invoke(t6);
            if (r6 != null) {
                return r6;
            }
        }
        return null;
    }

    public static final <T> T firstOrNull(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <T, R> List<R> flatMap(T[] tArr, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t6 : tArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(t6));
        }
        return arrayList;
    }

    private static final <T, R> List<R> flatMapIndexedIterable(T[] tArr, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), tArr[i5]));
            i5++;
            i6++;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(T[] tArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), tArr[i5]));
            i5++;
            i6++;
        }
        return destination;
    }

    private static final <T, R> List<R> flatMapIndexedSequence(T[] tArr, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (InterfaceC0233q) transform.invoke(Integer.valueOf(i6), tArr[i5]));
            i5++;
            i6++;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(T[] tArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (InterfaceC0233q) transform.invoke(Integer.valueOf(i6), tArr[i5]));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <T, R> List<R> flatMapSequence(T[] tArr, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t6 : tArr) {
            O.addAll(arrayList, (InterfaceC0233q) transform.invoke(t6));
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(T[] tArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (T t6 : tArr) {
            O.addAll(destination, (InterfaceC0233q) transform.invoke(t6));
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(T[] tArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (T t6 : tArr) {
            O.addAll(destination, (Iterable) transform.invoke(t6));
        }
        return destination;
    }

    public static final <T, R> R fold(T[] tArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (T t6 : tArr) {
            r6 = (R) operation.invoke(r6, t6);
        }
        return r6;
    }

    public static final <T, R> R foldIndexed(T[] tArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, tArr[i5]);
            i5++;
            i6++;
        }
        return r6;
    }

    public static final <T, R> R foldRight(T[] tArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(tArr[lastIndex], r6);
        }
        return r6;
    }

    public static final <T, R> R foldRightIndexed(T[] tArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), tArr[lastIndex], r6);
        }
        return r6;
    }

    public static final <T> void forEach(T[] tArr, O3.l action) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (T t6 : tArr) {
            action.invoke(t6);
        }
    }

    public static final <T> void forEachIndexed(T[] tArr, O3.p action) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), tArr[i5]);
            i5++;
            i6++;
        }
    }

    public static <T> U3.q getIndices(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return new U3.q(0, getLastIndex(tArr), 1);
    }

    public static final <T> int getLastIndex(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr.length - 1;
    }

    private static final <T> T getOrElse(T[] tArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= tArr.length) ? (T) defaultValue.invoke(Integer.valueOf(i5)) : tArr[i5];
    }

    public static <T> T getOrNull(T[] tArr, int i5) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (i5 < 0 || i5 >= tArr.length) {
            return null;
        }
        return tArr[i5];
    }

    public static final <T, K> Map<K, List<T>> groupBy(T[] tArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t6 : tArr) {
            Object objInvoke = keySelector.invoke(t6);
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(t6);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(T[] tArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (T t6 : tArr) {
            Object objInvoke = keySelector.invoke(t6);
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(t6);
        }
        return destination;
    }

    public static final <T, K> InterfaceC0131a0 groupingBy(T[] tArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        return new S4.h(tArr, keySelector, 1);
    }

    public static <T> int indexOf(T[] tArr, T t6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        int i5 = 0;
        if (t6 == null) {
            int length = tArr.length;
            while (i5 < length) {
                if (tArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i5 < length2) {
            if (t6.equals(tArr[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = tArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(tArr[i5])).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final <T> int indexOfLast(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(tArr[length])).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final <T> Set<T> intersect(T[] tArr, Iterable<? extends T> other) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final <T> boolean isEmpty(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr.length == 0;
    }

    private static final <T> boolean isNotEmpty(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (T t6 : tArr) {
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

    public static final <T> String joinToString(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(tArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static final <T> T last(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[getLastIndex(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> int lastIndexOf(T[] tArr, T t6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (t6 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i5 >= 0) {
                        length = i5;
                    }
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i6 = length2 - 1;
                    if (t6.equals(tArr[length2])) {
                        return length2;
                    }
                    if (i6 < 0) {
                        break;
                    }
                    length2 = i6;
                }
            }
        }
        return -1;
    }

    public static final <T> T lastOrNull(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    public static final <T, R> List<R> map(T[] tArr, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t6 : tArr) {
            arrayList.add(transform.invoke(t6));
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexed(T[] tArr, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), tArr[i5]));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexedNotNull(T[] tArr, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = i6 + 1;
            Object objInvoke = transform.invoke(Integer.valueOf(i6), tArr[i5]);
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(T[] tArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = i6 + 1;
            Object objInvoke = transform.invoke(Integer.valueOf(i6), tArr[i5]);
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(T[] tArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), tArr[i5]));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <T, R> List<R> mapNotNull(T[] tArr, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t6 : tArr) {
            Object objInvoke = transform.invoke(t6);
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(T[] tArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (T t6 : tArr) {
            Object objInvoke = transform.invoke(t6);
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(T[] tArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (T t6 : tArr) {
            destination.add(transform.invoke(t6));
        }
        return destination;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrNull(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t6);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t7 = tArr[i5];
                    Comparable comparable2 = (Comparable) selector.invoke(t7);
                    if (comparable.compareTo(comparable2) < 0) {
                        t6 = t7;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return t6;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t6);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t7 = tArr[i5];
                    Comparable comparable2 = (Comparable) selector.invoke(t7);
                    if (comparable.compareTo(comparable2) < 0) {
                        t6 = t7;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return t6;
    }

    private static final <T> double maxOf(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(tArr[0])).doubleValue();
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(tArr[i5])).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m26maxOfOrNull(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(tArr[0])).doubleValue();
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(tArr[i5])).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <T, R> R maxOfWith(T[] tArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(tArr[i5]);
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <T, R> R maxOfWithOrNull(T[] tArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(tArr[i5]);
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Double maxOrNull(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, dArr[i5].doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double maxOrThrow(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, dArr[i5].doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    public static final <T> T maxWithOrNull(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t7 = tArr[i5];
                if (comparator.compare(t6, t7) < 0) {
                    t6 = t7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return t6;
    }

    public static final <T> T maxWithOrThrow(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t7 = tArr[i5];
                if (comparator.compare(t6, t7) < 0) {
                    t6 = t7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return t6;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrNull(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t6);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t7 = tArr[i5];
                    Comparable comparable2 = (Comparable) selector.invoke(t7);
                    if (comparable.compareTo(comparable2) > 0) {
                        t6 = t7;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return t6;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrThrow(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t6);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t7 = tArr[i5];
                    Comparable comparable2 = (Comparable) selector.invoke(t7);
                    if (comparable.compareTo(comparable2) > 0) {
                        t6 = t7;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return t6;
    }

    private static final <T> double minOf(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(tArr[0])).doubleValue();
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(tArr[i5])).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m62minOfOrNull(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(tArr[0])).doubleValue();
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(tArr[i5])).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <T, R> R minOfWith(T[] tArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(tArr[i5]);
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <T, R> R minOfWithOrNull(T[] tArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(tArr[i5]);
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Double minOrNull(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, dArr[i5].doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double minOrThrow(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, dArr[i5].doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    public static final <T> T minWithOrNull(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t7 = tArr[i5];
                if (comparator.compare(t6, t7) > 0) {
                    t6 = t7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return t6;
    }

    public static final <T> T minWithOrThrow(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t7 = tArr[i5];
                if (comparator.compare(t6, t7) > 0) {
                    t6 = t7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return t6;
    }

    public static final <T> boolean none(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr.length == 0;
    }

    private static final <T> T[] onEach(T[] tArr, O3.l action) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (T t6 : tArr) {
            action.invoke(t6);
        }
        return tArr;
    }

    private static final <T> T[] onEachIndexed(T[] tArr, O3.p action) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = tArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), tArr[i5]);
            i5++;
            i6++;
        }
        return tArr;
    }

    public static final <T> C1938s partition(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                arrayList.add(t6);
            } else {
                arrayList2.add(t6);
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    private static final <T> T random(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return (T) random(tArr, S3.f.Default);
    }

    private static final <T> T randomOrNull(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return (T) randomOrNull(tArr, S3.f.Default);
    }

    public static final <S, T extends S> S reduce(T[] tArr, O3.p operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s6 = (S) tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                s6 = (S) operation.invoke(s6, tArr[i5]);
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return s6;
    }

    public static final <S, T extends S> S reduceIndexed(T[] tArr, O3.q operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s6 = (S) tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                s6 = (S) operation.invoke(Integer.valueOf(i5), s6, tArr[i5]);
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return s6;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(T[] tArr, O3.q operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s6 = (S) tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                s6 = (S) operation.invoke(Integer.valueOf(i5), s6, tArr[i5]);
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return s6;
    }

    public static final <S, T extends S> S reduceOrNull(T[] tArr, O3.p operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s6 = (S) tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                s6 = (S) operation.invoke(s6, tArr[i5]);
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return s6;
    }

    public static final <S, T extends S> S reduceRight(T[] tArr, O3.p operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s6 = (S) tArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            s6 = (S) operation.invoke(tArr[i5], s6);
        }
        return s6;
    }

    public static final <S, T extends S> S reduceRightIndexed(T[] tArr, O3.q operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s6 = (S) tArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            s6 = (S) operation.invoke(Integer.valueOf(i5), tArr[i5], s6);
        }
        return s6;
    }

    public static final <S, T extends S> S reduceRightIndexedOrNull(T[] tArr, O3.q operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s6 = (S) tArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            s6 = (S) operation.invoke(Integer.valueOf(i5), tArr[i5], s6);
        }
        return s6;
    }

    public static final <S, T extends S> S reduceRightOrNull(T[] tArr, O3.p operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s6 = (S) tArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            s6 = (S) operation.invoke(tArr[i5], s6);
        }
        return s6;
    }

    public static final <T> T[] requireNoNulls(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        for (T t6 : tArr) {
            if (t6 == null) {
                throw new IllegalArgumentException("null element found in " + tArr + '.');
            }
        }
        return tArr;
    }

    public static final <T> void reverse(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(tArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            T t6 = tArr[i5];
            tArr[i5] = tArr[lastIndex];
            tArr[lastIndex] = t6;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public static final <T> List<T> reversed(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 0) {
            return I.emptyList();
        }
        List<T> mutableList = toMutableList(tArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    public static final <T> T[] reversedArray(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) AbstractC0145m.arrayOfNulls(tArr, tArr.length);
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                tArr2[lastIndex - i5] = tArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return tArr2;
    }

    public static final <T, R> List<R> runningFold(T[] tArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r6);
        for (T t6 : tArr) {
            r6 = (R) operation.invoke(r6, t6);
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final <T, R> List<R> runningFoldIndexed(T[] tArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r6);
        int length = tArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, tArr[i5]);
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduce(T[] tArr, O3.p operation) {
        Object obj;
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            return I.emptyList();
        }
        T t6 = tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(t6);
        int length = tArr.length;
        int i5 = 1;
        while (i5 < length) {
            obj = t6;
            Object objInvoke = operation.invoke(obj, tArr[i5]);
            arrayList.add(objInvoke);
            i5++;
            obj = objInvoke;
        }
        obj = t6;
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduceIndexed(T[] tArr, O3.q operation) {
        Object obj;
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            return I.emptyList();
        }
        T t6 = tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(t6);
        int length = tArr.length;
        int i5 = 1;
        while (i5 < length) {
            obj = t6;
            Object objInvoke = operation.invoke(Integer.valueOf(i5), obj, tArr[i5]);
            arrayList.add(objInvoke);
            i5++;
            obj = objInvoke;
        }
        obj = t6;
        return arrayList;
    }

    private static final <R> List<R> scan(byte[] bArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r6);
        for (byte b : bArr) {
            r6 = (R) operation.invoke(r6, Byte.valueOf(b));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(byte[] bArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r6);
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Byte.valueOf(bArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final <T> void shuffle(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        shuffle(tArr, S3.f.Default);
    }

    public static final <T> T single(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T singleOrNull(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> List<T> slice(T[] tArr, U3.q indices) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final <T> T[] sliceArray(T[] tArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        T[] tArr2 = (T[]) AbstractC0145m.arrayOfNulls(tArr, indices.size());
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            tArr2[i5] = tArr[it.next().intValue()];
            i5++;
        }
        return tArr2;
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length > 1) {
            AbstractC0151t.sortWith(tArr, new D3.d(0, selector));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length > 1) {
            AbstractC0151t.sortWith(tArr, new D3.d(1, selector));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        AbstractC0151t.sortWith(tArr, D3.g.reverseOrder());
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return AbstractC0151t.asList(sortedArray(tArr));
    }

    public static final <T extends Comparable<? super T>> T[] sortedArray(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.E.e(objArrCopyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        AbstractC0151t.sort((Object[]) tArr2);
        return tArr2;
    }

    public static final <T extends Comparable<? super T>> T[] sortedArrayDescending(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.E.e(objArrCopyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        AbstractC0151t.sortWith(tArr2, D3.g.reverseOrder());
        return tArr2;
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.E.e(tArr2, "copyOf(...)");
        AbstractC0151t.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(tArr, new D3.d(0, selector));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(tArr, new D3.d(1, selector));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return sortedWith(tArr, D3.g.reverseOrder());
    }

    public static final <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return AbstractC0151t.asList(sortedArrayWith(tArr, comparator));
    }

    public static final <T> Set<T> subtract(T[] tArr, Iterable<? extends T> other) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sum(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int i5 = 0;
        for (byte b : bArr) {
            i5 += b;
        }
        return i5;
    }

    public static final <T> int sumBy(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (T t6 : tArr) {
            iIntValue += ((Number) selector.invoke(t6)).intValue();
        }
        return iIntValue;
    }

    public static final <T> double sumByDouble(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (T t6 : tArr) {
            dDoubleValue += ((Number) selector.invoke(t6)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfByte(Byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int iByteValue = 0;
        for (Byte b : bArr) {
            iByteValue += b.byteValue();
        }
        return iByteValue;
    }

    private static final <T> double sumOfDouble(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (T t6 : tArr) {
            dDoubleValue += ((Number) selector.invoke(t6)).doubleValue();
        }
        return dDoubleValue;
    }

    public static final float sumOfFloat(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        float fFloatValue = 0.0f;
        for (Float f6 : fArr) {
            fFloatValue += f6.floatValue();
        }
        return fFloatValue;
    }

    private static final <T> int sumOfInt(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (T t6 : tArr) {
            iIntValue += ((Number) selector.invoke(t6)).intValue();
        }
        return iIntValue;
    }

    private static final <T> long sumOfLong(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (T t6 : tArr) {
            jLongValue += ((Number) selector.invoke(t6)).longValue();
        }
        return jLongValue;
    }

    public static final int sumOfShort(Short[] shArr) {
        kotlin.jvm.internal.E.f(shArr, "<this>");
        int iShortValue = 0;
        for (Short sh : shArr) {
            iShortValue += sh.shortValue();
        }
        return iShortValue;
    }

    private static final <T> int sumOfUInt(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (T t6 : tArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(t6)).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final <T> long sumOfULong(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (T t6 : tArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(t6)).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final <T> List<T> take(T[] tArr, int i5) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= tArr.length) {
            return toList(tArr);
        }
        if (i5 == 1) {
            return G.listOf(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (T t6 : tArr) {
            arrayList.add(t6);
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final <T> List<T> takeLast(T[] tArr, int i5) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = tArr.length;
        if (i5 >= length) {
            return toList(tArr);
        }
        if (i5 == 1) {
            return G.listOf(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(tArr[i6]);
        }
        return arrayList;
    }

    public static final <T> List<T> takeLastWhile(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(tArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(tArr[lastIndex])).booleanValue()) {
                return drop(tArr, lastIndex + 1);
            }
        }
        return toList(tArr);
    }

    public static final <T> List<T> takeWhile(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t6 : tArr) {
            if (!((Boolean) predicate.invoke(t6)).booleanValue()) {
                break;
            }
            arrayList.add(t6);
        }
        return arrayList;
    }

    public static final boolean[] toBooleanArray(Boolean[] boolArr) {
        kotlin.jvm.internal.E.f(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i5 = 0; i5 < length; i5++) {
            zArr[i5] = boolArr[i5].booleanValue();
        }
        return zArr;
    }

    public static final byte[] toByteArray(Byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr2[i5] = bArr[i5].byteValue();
        }
        return bArr2;
    }

    public static final char[] toCharArray(Character[] chArr) {
        kotlin.jvm.internal.E.f(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i5 = 0; i5 < length; i5++) {
            cArr[i5] = chArr[i5].charValue();
        }
        return cArr;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C destination) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (T t6 : tArr) {
            destination.add(t6);
        }
        return destination;
    }

    public static final double[] toDoubleArray(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr2[i5] = dArr[i5].doubleValue();
        }
        return dArr2;
    }

    public static final float[] toFloatArray(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i5 = 0; i5 < length; i5++) {
            fArr2[i5] = fArr[i5].floatValue();
        }
        return fArr2;
    }

    public static final <T> HashSet<T> toHashSet(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return (HashSet) toCollection(tArr, new HashSet(j0.mapCapacity(tArr.length)));
    }

    public static final int[] toIntArray(Integer[] numArr) {
        kotlin.jvm.internal.E.f(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = numArr[i5].intValue();
        }
        return iArr;
    }

    public static <T> List<T> toList(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? toMutableList(tArr) : G.listOf(tArr[0]);
        }
        return I.emptyList();
    }

    public static final long[] toLongArray(Long[] lArr) {
        kotlin.jvm.internal.E.f(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            jArr[i5] = lArr[i5].longValue();
        }
        return jArr;
    }

    public static <T> List<T> toMutableList(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return new ArrayList(I.asCollection(tArr));
    }

    public static final <T> Set<T> toMutableSet(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return (Set) toCollection(tArr, new LinkedHashSet(j0.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> toSet(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? (Set) toCollection(tArr, new LinkedHashSet(j0.mapCapacity(tArr.length))) : v0.setOf(tArr[0]);
        }
        return w0.emptySet();
    }

    public static final short[] toShortArray(Short[] shArr) {
        kotlin.jvm.internal.E.f(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i5 = 0; i5 < length; i5++) {
            sArr[i5] = shArr[i5].shortValue();
        }
        return sArr;
    }

    public static final <T> Set<T> union(T[] tArr, Iterable<? extends T> other) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static <T> Iterable<C0133b0> withIndex(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return new C0135c0(new C0152u(tArr, 4));
    }

    public static final <T, R, V> List<V> zip(T[] tArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(tArr[i5], other[i5]));
        }
        return arrayList;
    }

    public static final boolean all(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (byte b : bArr) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final double average(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        double d = 0.0d;
        int i5 = 0;
        for (short s6 : sArr) {
            d += (double) s6;
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return d / ((double) i5);
    }

    private static final byte component1(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr[0];
    }

    private static final byte component2(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr[1];
    }

    private static final byte component3(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr[2];
    }

    private static final byte component4(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr[3];
    }

    private static final byte component5(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr[4];
    }

    public static boolean contains(byte[] bArr, byte b) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return indexOf(bArr, b) >= 0;
    }

    private static final int count(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr.length;
    }

    public static final List<Byte> distinct(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return T.toList(toMutableSet(bArr));
    }

    private static final byte elementAtOrElse(byte[] bArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= bArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).byteValue() : bArr[i5];
    }

    private static final Byte elementAtOrNull(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return getOrNull(bArr, i5);
    }

    public static final <C extends Collection<? super Byte>> C filterNotTo(byte[] bArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (byte b : bArr) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Byte>> C filterTo(byte[] bArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
        }
        return destination;
    }

    private static final Byte find(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                return Byte.valueOf(b);
            }
        }
        return null;
    }

    public static final Byte firstOrNull(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(byte[] bArr, O3.p transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Byte.valueOf(bArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R> R fold(byte[] bArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (byte b : bArr) {
            r6 = (R) operation.invoke(r6, Byte.valueOf(b));
        }
        return r6;
    }

    public static final <R> R foldIndexed(byte[] bArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Byte.valueOf(bArr[i5]));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final void forEach(byte[] bArr, O3.l action) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (byte b : bArr) {
            action.invoke(Byte.valueOf(b));
        }
    }

    public static final void forEachIndexed(byte[] bArr, O3.p action) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Byte.valueOf(bArr[i5]));
            i5++;
            i6++;
        }
    }

    public static int getLastIndex(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr.length - 1;
    }

    private static final byte getOrElse(byte[] bArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= bArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).byteValue() : bArr[i5];
    }

    public static final Byte getOrNull(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (i5 < 0 || i5 >= bArr.length) {
            return null;
        }
        return Byte.valueOf(bArr[i5]);
    }

    private static final boolean isEmpty(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr.length == 0;
    }

    private static final boolean isNotEmpty(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final String joinToString(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(bArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static final Byte lastOrNull(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    public static final boolean none(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr.length == 0;
    }

    private static final byte[] onEach(byte[] bArr, O3.l action) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (byte b : bArr) {
            action.invoke(Byte.valueOf(b));
        }
        return bArr;
    }

    private static final byte[] onEachIndexed(byte[] bArr, O3.p action) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Byte.valueOf(bArr[i5]));
            i5++;
            i6++;
        }
        return bArr;
    }

    private static final byte random(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return random(bArr, (S3.f) S3.f.Default);
    }

    private static final Byte randomOrNull(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return randomOrNull(bArr, (S3.f) S3.f.Default);
    }

    private static final <R> List<R> scan(short[] sArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r6);
        for (short s6 : sArr) {
            r6 = (R) operation.invoke(r6, Short.valueOf(s6));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(short[] sArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r6);
        int length = sArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Short.valueOf(sArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void shuffle(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        shuffle(bArr, (S3.f) S3.f.Default);
    }

    public static final Byte singleOrNull(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final void sortDescending(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length > 1) {
            AbstractC0151t.sort(bArr);
            reverse(bArr);
        }
    }

    public static final List<Byte> sorted(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        Byte[] typedArray = AbstractC0151t.toTypedArray(bArr);
        AbstractC0151t.sort((Object[]) typedArray);
        return AbstractC0151t.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Byte> sortedBy(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new D3.d(0, selector));
    }

    public static final <R extends Comparable<? super R>> List<Byte> sortedByDescending(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new D3.d(1, selector));
    }

    public static final List<Byte> sortedDescending(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(bArrCopyOf);
        return reversed(bArrCopyOf);
    }

    public static final List<Byte> sortedWith(byte[] bArr, Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Byte[] typedArray = AbstractC0151t.toTypedArray(bArr);
        AbstractC0151t.sortWith(typedArray, comparator);
        return AbstractC0151t.asList(typedArray);
    }

    public static final int sum(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        int i5 = 0;
        for (short s6 : sArr) {
            i5 += s6;
        }
        return i5;
    }

    public static final HashSet<Byte> toHashSet(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return (HashSet) toCollection(bArr, new HashSet(j0.mapCapacity(bArr.length)));
    }

    public static final List<Byte> toMutableList(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    public static final Set<Byte> toMutableSet(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return (Set) toCollection(bArr, new LinkedHashSet(j0.mapCapacity(bArr.length)));
    }

    public static final Iterable<C0133b0> withIndex(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return new C0135c0(new C0155x(bArr, 0));
    }

    public static final boolean all(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (short s6 : sArr) {
            if (!((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static final Iterable<Byte> asIterable(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr.length == 0 ? I.emptyList() : new A(bArr, 1);
    }

    public static final InterfaceC0233q asSequence(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr.length == 0 ? W3.z.emptySequence() : new B(bArr, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Byte>> M associateByTo(byte[] bArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (byte b : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b)), Byte.valueOf(b));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Byte, ? super V>> M associateWithTo(byte[] bArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (byte b : bArr) {
            destination.put(Byte.valueOf(b), valueSelector.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    public static final double average(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        double d = 0.0d;
        int i5 = 0;
        for (int i6 : iArr) {
            d += (double) i6;
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return d / ((double) i5);
    }

    private static final short component1(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr[0];
    }

    private static final short component2(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr[1];
    }

    private static final short component3(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr[2];
    }

    private static final short component4(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr[3];
    }

    private static final short component5(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr[4];
    }

    public static boolean contains(short[] sArr, short s6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return indexOf(sArr, s6) >= 0;
    }

    private static final int count(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr.length;
    }

    public static final List<Short> distinct(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return T.toList(toMutableSet(sArr));
    }

    private static final short elementAtOrElse(short[] sArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= sArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).shortValue() : sArr[i5];
    }

    private static final Short elementAtOrNull(short[] sArr, int i5) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return getOrNull(sArr, i5);
    }

    public static final List<Byte> filter(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Byte>> C filterIndexedTo(byte[] bArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte b = bArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Byte.valueOf(b))).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final List<Byte> filterNot(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C filterNotTo(short[] sArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (short s6 : sArr) {
            if (!((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                destination.add(Short.valueOf(s6));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Short>> C filterTo(short[] sArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                destination.add(Short.valueOf(s6));
            }
        }
        return destination;
    }

    private static final Short find(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                return Short.valueOf(s6);
            }
        }
        return null;
    }

    public static final Short firstOrNull(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(short[] sArr, O3.p transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Short.valueOf(sArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R> R fold(short[] sArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (short s6 : sArr) {
            r6 = (R) operation.invoke(r6, Short.valueOf(s6));
        }
        return r6;
    }

    public static final <R> R foldIndexed(short[] sArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Short.valueOf(sArr[i5]));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final <R> R foldRight(byte[] bArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Byte.valueOf(bArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(byte[] bArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Byte.valueOf(bArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final void forEach(short[] sArr, O3.l action) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (short s6 : sArr) {
            action.invoke(Short.valueOf(s6));
        }
    }

    public static final void forEachIndexed(short[] sArr, O3.p action) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Short.valueOf(sArr[i5]));
            i5++;
            i6++;
        }
    }

    public static U3.q getIndices(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return new U3.q(0, getLastIndex(bArr), 1);
    }

    public static int getLastIndex(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr.length - 1;
    }

    private static final short getOrElse(short[] sArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= sArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).shortValue() : sArr[i5];
    }

    public static final Short getOrNull(short[] sArr, int i5) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (i5 < 0 || i5 >= sArr.length) {
            return null;
        }
        return Short.valueOf(sArr[i5]);
    }

    public static final int indexOfFirst(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(Byte.valueOf(bArr[i5]))).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(Byte.valueOf(bArr[length]))).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Set<Byte> intersect(byte[] bArr, Iterable<Byte> other) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final boolean isEmpty(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr.length == 0;
    }

    private static final boolean isNotEmpty(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static final String joinToString(short[] sArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(sArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static final Short lastOrNull(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(byte[] bArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), Byte.valueOf(bArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(byte[] bArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (byte b : bArr) {
            destination.add(transform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    public static final boolean none(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr.length == 0;
    }

    private static final short[] onEach(short[] sArr, O3.l action) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (short s6 : sArr) {
            action.invoke(Short.valueOf(s6));
        }
        return sArr;
    }

    private static final short[] onEachIndexed(short[] sArr, O3.p action) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Short.valueOf(sArr[i5]));
            i5++;
            i6++;
        }
        return sArr;
    }

    private static final short random(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return random(sArr, (S3.f) S3.f.Default);
    }

    private static final Short randomOrNull(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return randomOrNull(sArr, (S3.f) S3.f.Default);
    }

    private static final <R> List<R> scan(int[] iArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r6);
        for (int i5 : iArr) {
            r6 = (R) operation.invoke(r6, Integer.valueOf(i5));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(int[] iArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r6);
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Integer.valueOf(iArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void shuffle(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        shuffle(sArr, (S3.f) S3.f.Default);
    }

    public static final Short singleOrNull(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    public static final List<Byte> slice(byte[] bArr, U3.q indices) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final List<Short> sorted(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        Short[] typedArray = AbstractC0151t.toTypedArray(sArr);
        AbstractC0151t.sort((Object[]) typedArray);
        return AbstractC0151t.asList(typedArray);
    }

    public static final byte[] sortedArray(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final byte[] sortedArrayDescending(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(...)");
        sortDescending(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Short> sortedBy(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new D3.d(0, selector));
    }

    public static final <R extends Comparable<? super R>> List<Short> sortedByDescending(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new D3.d(1, selector));
    }

    public static final List<Short> sortedDescending(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.E.e(sArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(sArrCopyOf);
        return reversed(sArrCopyOf);
    }

    public static final List<Short> sortedWith(short[] sArr, Comparator<? super Short> comparator) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Short[] typedArray = AbstractC0151t.toTypedArray(sArr);
        AbstractC0151t.sortWith(typedArray, comparator);
        return AbstractC0151t.asList(typedArray);
    }

    public static final Set<Byte> subtract(byte[] bArr, Iterable<Byte> other) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static int sum(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        return i5;
    }

    public static final int sumBy(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (byte b : bArr) {
            iIntValue += ((Number) selector.invoke(Byte.valueOf(b))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b : bArr) {
            dDoubleValue += ((Number) selector.invoke(Byte.valueOf(b))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b : bArr) {
            dDoubleValue += ((Number) selector.invoke(Byte.valueOf(b))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (byte b : bArr) {
            iIntValue += ((Number) selector.invoke(Byte.valueOf(b))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (byte b : bArr) {
            jLongValue += ((Number) selector.invoke(Byte.valueOf(b))).longValue();
        }
        return jLongValue;
    }

    public static final <C extends Collection<? super Byte>> C toCollection(byte[] bArr, C destination) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (byte b : bArr) {
            destination.add(Byte.valueOf(b));
        }
        return destination;
    }

    public static final HashSet<Short> toHashSet(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return (HashSet) toCollection(sArr, new HashSet(j0.mapCapacity(sArr.length)));
    }

    public static final Set<Short> toMutableSet(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return (Set) toCollection(sArr, new LinkedHashSet(j0.mapCapacity(sArr.length)));
    }

    public static final Set<Byte> union(byte[] bArr, Iterable<Byte> other) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Iterable<C0133b0> withIndex(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return new C0135c0(new C0153v(sArr, 0));
    }

    public static final boolean all(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 : iArr) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return !(iArr.length == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Byte, V> associateWith(byte[] bArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(bArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (byte b : bArr) {
            linkedHashMap.put(Byte.valueOf(b), valueSelector.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    public static final double average(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        double d = 0.0d;
        int i5 = 0;
        for (long j6 : jArr) {
            d += j6;
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return d / ((double) i5);
    }

    private static final int component1(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr[0];
    }

    private static final int component2(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr[1];
    }

    private static final int component3(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr[2];
    }

    private static final int component4(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr[3];
    }

    private static final int component5(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr[4];
    }

    public static boolean contains(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return indexOf(iArr, i5) >= 0;
    }

    private static final int count(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr.length;
    }

    public static final List<Integer> distinct(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return T.toList(toMutableSet(iArr));
    }

    private static final int elementAtOrElse(int[] iArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= iArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).intValue() : iArr[i5];
    }

    private static final Integer elementAtOrNull(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return getOrNull(iArr, i5);
    }

    public static final List<Byte> filterIndexed(byte[] bArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte b = bArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Integer>> C filterNotTo(int[] iArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 : iArr) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                destination.add(Integer.valueOf(i5));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Integer>> C filterTo(int[] iArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                destination.add(Integer.valueOf(i5));
            }
        }
        return destination;
    }

    private static final Integer find(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                return Integer.valueOf(i5);
            }
        }
        return null;
    }

    private static final Byte findLast(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            byte b = bArr[length];
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                return Byte.valueOf(b);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static byte first(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer firstOrNull(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(int[] iArr, O3.p transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(byte[] bArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Byte.valueOf(bArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(byte[] bArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (byte b : bArr) {
            O.addAll(destination, (Iterable) transform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    public static final <R> R fold(int[] iArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int i5 : iArr) {
            r6 = (R) operation.invoke(r6, Integer.valueOf(i5));
        }
        return r6;
    }

    public static final <R> R foldIndexed(int[] iArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Integer.valueOf(iArr[i5]));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final void forEach(int[] iArr, O3.l action) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (int i5 : iArr) {
            action.invoke(Integer.valueOf(i5));
        }
    }

    public static final void forEachIndexed(int[] iArr, O3.p action) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i5]));
            i5++;
            i6++;
        }
    }

    public static int getLastIndex(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr.length - 1;
    }

    private static final int getOrElse(int[] iArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= iArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).intValue() : iArr[i5];
    }

    public static final Integer getOrNull(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (i5 < 0 || i5 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i5]);
    }

    private static final boolean isEmpty(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr.length == 0;
    }

    private static final boolean isNotEmpty(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return !(iArr.length == 0);
    }

    public static final String joinToString(int[] iArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(iArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static byte last(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[getLastIndex(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer lastOrNull(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    public static final <R> List<R> map(byte[] bArr, O3.l transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(transform.invoke(Byte.valueOf(b)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(byte[] bArr, O3.p transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Byte.valueOf(bArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final boolean none(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr.length == 0;
    }

    private static final int[] onEach(int[] iArr, O3.l action) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (int i5 : iArr) {
            action.invoke(Integer.valueOf(i5));
        }
        return iArr;
    }

    private static final int[] onEachIndexed(int[] iArr, O3.p action) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i5]));
            i5++;
            i6++;
        }
        return iArr;
    }

    private static final int random(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return random(iArr, (S3.f) S3.f.Default);
    }

    private static final Integer randomOrNull(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return randomOrNull(iArr, (S3.f) S3.f.Default);
    }

    public static final Byte reduceRightIndexedOrNull(byte[] bArr, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte bByteValue = bArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            bByteValue = ((Number) operation.invoke(Integer.valueOf(i5), Byte.valueOf(bArr[i5]), Byte.valueOf(bByteValue))).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    public static final Byte reduceRightOrNull(byte[] bArr, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte bByteValue = bArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            bByteValue = ((Number) operation.invoke(Byte.valueOf(bArr[i5]), Byte.valueOf(bByteValue))).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    public static final List<Byte> reversed(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 0) {
            return I.emptyList();
        }
        List<Byte> mutableList = toMutableList(bArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    private static final <R> List<R> scan(long[] jArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r6);
        for (long j6 : jArr) {
            r6 = (R) operation.invoke(r6, Long.valueOf(j6));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(long[] jArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r6);
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Long.valueOf(jArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void shuffle(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        shuffle(iArr, (S3.f) S3.f.Default);
    }

    public static final Integer singleOrNull(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static byte[] sliceArray(byte[] bArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        byte[] bArr2 = new byte[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            bArr2[i5] = bArr[it.next().intValue()];
            i5++;
        }
        return bArr2;
    }

    public static final List<Integer> sorted(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        Integer[] typedArray = AbstractC0151t.toTypedArray(iArr);
        AbstractC0151t.sort((Object[]) typedArray);
        return AbstractC0151t.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Integer> sortedBy(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new D3.d(0, selector));
    }

    public static final <R extends Comparable<? super R>> List<Integer> sortedByDescending(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new D3.d(1, selector));
    }

    public static final List<Integer> sortedDescending(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.E.e(iArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(iArrCopyOf);
        return reversed(iArrCopyOf);
    }

    public static final List<Integer> sortedWith(int[] iArr, Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Integer[] typedArray = AbstractC0151t.toTypedArray(iArr);
        AbstractC0151t.sortWith(typedArray, comparator);
        return AbstractC0151t.asList(typedArray);
    }

    public static long sum(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        long j6 = 0;
        for (long j7 : jArr) {
            j6 += j7;
        }
        return j6;
    }

    public static final HashSet<Integer> toHashSet(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return (HashSet) toCollection(iArr, new HashSet(j0.mapCapacity(iArr.length)));
    }

    public static final List<Short> toMutableList(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s6 : sArr) {
            arrayList.add(Short.valueOf(s6));
        }
        return arrayList;
    }

    public static final Set<Integer> toMutableSet(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return (Set) toCollection(iArr, new LinkedHashSet(j0.mapCapacity(iArr.length)));
    }

    public static final Iterable<C0133b0> withIndex(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return new C0135c0(new C0156y(iArr, 0));
    }

    public static final <R, V> List<V> zip(byte[] bArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i5]), other[i5]));
        }
        return arrayList;
    }

    public static final boolean all(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (long j6 : jArr) {
            if (!((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static final Iterable<Short> asIterable(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr.length == 0 ? I.emptyList() : new A(sArr, 2);
    }

    public static final InterfaceC0233q asSequence(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr.length == 0 ? W3.z.emptySequence() : new B(sArr, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Byte> associateBy(byte[] bArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(bArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (byte b : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b)), Byte.valueOf(b));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Short>> M associateByTo(short[] sArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (short s6 : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s6)), Short.valueOf(s6));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Short, ? super V>> M associateWithTo(short[] sArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (short s6 : sArr) {
            destination.put(Short.valueOf(s6), valueSelector.invoke(Short.valueOf(s6)));
        }
        return destination;
    }

    public static final double average(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        double d = 0.0d;
        int i5 = 0;
        for (float f6 : fArr) {
            d += (double) f6;
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return d / ((double) i5);
    }

    private static final long component1(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr[0];
    }

    private static final long component2(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr[1];
    }

    private static final long component3(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr[2];
    }

    private static final long component4(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr[3];
    }

    private static final long component5(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr[4];
    }

    public static boolean contains(long[] jArr, long j6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return indexOf(jArr, j6) >= 0;
    }

    private static final int count(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr.length;
    }

    public static final List<Long> distinct(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return T.toList(toMutableSet(jArr));
    }

    public static final List<Byte> dropLastWhile(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(bArr[lastIndex]))).booleanValue()) {
                return take(bArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    private static final long elementAtOrElse(long[] jArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= jArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).longValue() : jArr[i5];
    }

    private static final Long elementAtOrNull(long[] jArr, int i5) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return getOrNull(jArr, i5);
    }

    public static final List<Short> filter(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                arrayList.add(Short.valueOf(s6));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C filterIndexedTo(short[] sArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            short s6 = sArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Short.valueOf(s6))).booleanValue()) {
                destination.add(Short.valueOf(s6));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final List<Short> filterNot(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s6 : sArr) {
            if (!((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                arrayList.add(Short.valueOf(s6));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C filterNotTo(long[] jArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (long j6 : jArr) {
            if (!((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                destination.add(Long.valueOf(j6));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Long>> C filterTo(long[] jArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                destination.add(Long.valueOf(j6));
            }
        }
        return destination;
    }

    private static final Long find(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                return Long.valueOf(j6);
            }
        }
        return null;
    }

    public static final Long firstOrNull(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    public static final <R> List<R> flatMap(byte[] bArr, O3.l transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(Byte.valueOf(b)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(long[] jArr, O3.p transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R> R fold(long[] jArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (long j6 : jArr) {
            r6 = (R) operation.invoke(r6, Long.valueOf(j6));
        }
        return r6;
    }

    public static final <R> R foldIndexed(long[] jArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Long.valueOf(jArr[i5]));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final <R> R foldRight(short[] sArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Short.valueOf(sArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(short[] sArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Short.valueOf(sArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final void forEach(long[] jArr, O3.l action) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (long j6 : jArr) {
            action.invoke(Long.valueOf(j6));
        }
    }

    public static final void forEachIndexed(long[] jArr, O3.p action) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i5]));
            i5++;
            i6++;
        }
    }

    public static U3.q getIndices(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return new U3.q(0, getLastIndex(sArr), 1);
    }

    public static int getLastIndex(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr.length - 1;
    }

    private static final long getOrElse(long[] jArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= jArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).longValue() : jArr[i5];
    }

    public static final Long getOrNull(long[] jArr, int i5) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (i5 < 0 || i5 >= jArr.length) {
            return null;
        }
        return Long.valueOf(jArr[i5]);
    }

    public static final int indexOfFirst(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = sArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(Short.valueOf(sArr[i5]))).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(Short.valueOf(sArr[length]))).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Set<Short> intersect(short[] sArr, Iterable<Short> other) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final boolean isEmpty(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr.length == 0;
    }

    private static final boolean isNotEmpty(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static final String joinToString(long[] jArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(jArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static final Long lastOrNull(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(short[] sArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), Short.valueOf(sArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(short[] sArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (short s6 : sArr) {
            destination.add(transform.invoke(Short.valueOf(s6)));
        }
        return destination;
    }

    public static final boolean none(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr.length == 0;
    }

    private static final long[] onEach(long[] jArr, O3.l action) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (long j6 : jArr) {
            action.invoke(Long.valueOf(j6));
        }
        return jArr;
    }

    private static final long[] onEachIndexed(long[] jArr, O3.p action) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i5]));
            i5++;
            i6++;
        }
        return jArr;
    }

    private static final long random(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return random(jArr, (S3.f) S3.f.Default);
    }

    private static final Long randomOrNull(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return randomOrNull(jArr, (S3.f) S3.f.Default);
    }

    public static final Byte reduceIndexedOrNull(byte[] bArr, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bByteValue = ((Number) operation.invoke(Integer.valueOf(i5), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i5]))).byteValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(bByteValue);
    }

    public static final Byte reduceOrNull(byte[] bArr, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                bByteValue = ((Number) operation.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i5]))).byteValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(bByteValue);
    }

    public static final byte reduceRight(byte[] bArr, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte bByteValue = bArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                bByteValue = ((Number) operation.invoke(Byte.valueOf(bArr[i5]), Byte.valueOf(bByteValue))).byteValue();
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceRightIndexed(byte[] bArr, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte bByteValue = bArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                bByteValue = ((Number) operation.invoke(Integer.valueOf(i5), Byte.valueOf(bArr[i5]), Byte.valueOf(bByteValue))).byteValue();
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static byte[] reversedArray(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                bArr2[lastIndex - i5] = bArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return bArr2;
    }

    private static final <R> List<R> scan(float[] fArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r6);
        for (float f6 : fArr) {
            r6 = (R) operation.invoke(r6, Float.valueOf(f6));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(float[] fArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r6);
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Float.valueOf(fArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void shuffle(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        shuffle(jArr, (S3.f) S3.f.Default);
    }

    public static byte single(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return bArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Long singleOrNull(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    public static final List<Short> slice(short[] sArr, U3.q indices) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length > 1) {
            AbstractC0151t.sort(sArr);
            reverse(sArr);
        }
    }

    public static final List<Long> sorted(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        Long[] typedArray = AbstractC0151t.toTypedArray(jArr);
        AbstractC0151t.sort((Object[]) typedArray);
        return AbstractC0151t.asList(typedArray);
    }

    public static final short[] sortedArray(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.E.e(sArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(sArrCopyOf);
        return sArrCopyOf;
    }

    public static final short[] sortedArrayDescending(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.E.e(sArrCopyOf, "copyOf(...)");
        sortDescending(sArrCopyOf);
        return sArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Long> sortedBy(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new D3.d(0, selector));
    }

    public static final <R extends Comparable<? super R>> List<Long> sortedByDescending(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new D3.d(1, selector));
    }

    public static final List<Long> sortedDescending(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.E.e(jArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(jArrCopyOf);
        return reversed(jArrCopyOf);
    }

    public static final List<Long> sortedWith(long[] jArr, Comparator<? super Long> comparator) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Long[] typedArray = AbstractC0151t.toTypedArray(jArr);
        AbstractC0151t.sortWith(typedArray, comparator);
        return AbstractC0151t.asList(typedArray);
    }

    public static final Set<Short> subtract(short[] sArr, Iterable<Short> other) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final float sum(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        float f6 = 0.0f;
        for (float f7 : fArr) {
            f6 += f7;
        }
        return f6;
    }

    public static final int sumBy(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (short s6 : sArr) {
            iIntValue += ((Number) selector.invoke(Short.valueOf(s6))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s6 : sArr) {
            dDoubleValue += ((Number) selector.invoke(Short.valueOf(s6))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s6 : sArr) {
            dDoubleValue += ((Number) selector.invoke(Short.valueOf(s6))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (short s6 : sArr) {
            iIntValue += ((Number) selector.invoke(Short.valueOf(s6))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (short s6 : sArr) {
            jLongValue += ((Number) selector.invoke(Short.valueOf(s6))).longValue();
        }
        return jLongValue;
    }

    public static final List<Byte> takeLastWhile(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(bArr[lastIndex]))).booleanValue()) {
                return drop(bArr, lastIndex + 1);
            }
        }
        return toList(bArr);
    }

    public static final List<Byte> takeWhile(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (!((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Short>> C toCollection(short[] sArr, C destination) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (short s6 : sArr) {
            destination.add(Short.valueOf(s6));
        }
        return destination;
    }

    public static final HashSet<Long> toHashSet(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return (HashSet) toCollection(jArr, new HashSet(j0.mapCapacity(jArr.length)));
    }

    public static final List<Byte> toList(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return I.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return G.listOf(Byte.valueOf(bArr[0]));
    }

    public static final Set<Long> toMutableSet(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return (Set) toCollection(jArr, new LinkedHashSet(j0.mapCapacity(jArr.length)));
    }

    public static final Set<Byte> toSet(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return w0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(bArr, new LinkedHashSet(j0.mapCapacity(bArr.length)));
        }
        return v0.setOf(Byte.valueOf(bArr[0]));
    }

    public static final Set<Short> union(short[] sArr, Iterable<Short> other) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Iterable<C0133b0> withIndex(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return new C0135c0(new C0154w(jArr, 0));
    }

    public static final boolean all(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (float f6 : fArr) {
            if (!((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return !(fArr.length == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(byte[] bArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (byte b : bArr) {
            C1938s c1938s = (C1938s) transform.invoke(Byte.valueOf(b));
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Short, V> associateWith(short[] sArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(sArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (short s6 : sArr) {
            linkedHashMap.put(Short.valueOf(s6), valueSelector.invoke(Short.valueOf(s6)));
        }
        return linkedHashMap;
    }

    public static final double average(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        double d = 0.0d;
        int i5 = 0;
        for (double d6 : dArr) {
            d += d6;
            i5++;
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return d / ((double) i5);
    }

    private static final float component1(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr[0];
    }

    private static final float component2(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr[1];
    }

    private static final float component3(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr[2];
    }

    private static final float component4(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr[3];
    }

    private static final float component5(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr[4];
    }

    public static final boolean contains(boolean[] zArr, boolean z6) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return indexOf(zArr, z6) >= 0;
    }

    private static final int count(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr.length;
    }

    public static final List<Float> distinct(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return T.toList(toMutableSet(fArr));
    }

    public static final List<Byte> dropWhile(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (byte b : bArr) {
            if (z6) {
                arrayList.add(Byte.valueOf(b));
            } else if (!((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
                z6 = true;
            }
        }
        return arrayList;
    }

    private static final float elementAtOrElse(float[] fArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= fArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).floatValue() : fArr[i5];
    }

    private static final Float elementAtOrNull(float[] fArr, int i5) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return getOrNull(fArr, i5);
    }

    public static final <C extends Collection<? super Float>> C filterNotTo(float[] fArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (float f6 : fArr) {
            if (!((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                destination.add(Float.valueOf(f6));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Float>> C filterTo(float[] fArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                destination.add(Float.valueOf(f6));
            }
        }
        return destination;
    }

    private static final Float find(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                return Float.valueOf(f6);
            }
        }
        return null;
    }

    public static final Float firstOrNull(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(float[] fArr, O3.p transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R> R fold(float[] fArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (float f6 : fArr) {
            r6 = (R) operation.invoke(r6, Float.valueOf(f6));
        }
        return r6;
    }

    public static final <R> R foldIndexed(float[] fArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Float.valueOf(fArr[i5]));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final void forEach(float[] fArr, O3.l action) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (float f6 : fArr) {
            action.invoke(Float.valueOf(f6));
        }
    }

    public static final void forEachIndexed(float[] fArr, O3.p action) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i5]));
            i5++;
            i6++;
        }
    }

    public static final int getLastIndex(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr.length - 1;
    }

    private static final float getOrElse(float[] fArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= fArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).floatValue() : fArr[i5];
    }

    public static final Float getOrNull(float[] fArr, int i5) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (i5 < 0 || i5 >= fArr.length) {
            return null;
        }
        return Float.valueOf(fArr[i5]);
    }

    public static int indexOf(byte[] bArr, byte b) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (b == bArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    private static final boolean isEmpty(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr.length == 0;
    }

    private static final boolean isNotEmpty(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return !(fArr.length == 0);
    }

    public static final String joinToString(float[] fArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(fArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static int lastIndexOf(byte[] bArr, byte b) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (b == bArr[length]) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Float lastOrNull(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    private static final <R> R maxOfWithOrNull(byte[] bArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Byte.valueOf(bArr[i5]));
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Byte maxWithOrNull(byte[] bArr, Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b6 = bArr[i5];
                if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b6)) < 0) {
                    b = b6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(b);
    }

    private static final <R> R minOfWithOrNull(byte[] bArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Byte.valueOf(bArr[i5]));
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Byte minWithOrNull(byte[] bArr, Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b6 = bArr[i5];
                if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b6)) > 0) {
                    b = b6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(b);
    }

    public static final boolean none(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr.length == 0;
    }

    private static final float[] onEach(float[] fArr, O3.l action) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (float f6 : fArr) {
            action.invoke(Float.valueOf(f6));
        }
        return fArr;
    }

    private static final float[] onEachIndexed(float[] fArr, O3.p action) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i5]));
            i5++;
            i6++;
        }
        return fArr;
    }

    private static final float random(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return random(fArr, (S3.f) S3.f.Default);
    }

    private static final Float randomOrNull(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return randomOrNull(fArr, (S3.f) S3.f.Default);
    }

    public static final byte reduce(byte[] bArr, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length != 0) {
            byte bByteValue = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    bByteValue = ((Number) operation.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i5]))).byteValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceIndexed(byte[] bArr, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length != 0) {
            byte bByteValue = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    bByteValue = ((Number) operation.invoke(Integer.valueOf(i5), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i5]))).byteValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return bByteValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(bArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            byte b = bArr[i5];
            bArr[i5] = bArr[lastIndex];
            bArr[lastIndex] = b;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private static final <R> List<R> runningFold(byte[] bArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r6);
        for (byte b : bArr) {
            r6 = (R) operation.invoke(r6, Byte.valueOf(b));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(byte[] bArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r6);
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Byte.valueOf(bArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(double[] dArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r6);
        for (double d : dArr) {
            r6 = (R) operation.invoke(r6, Double.valueOf(d));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(double[] dArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r6);
        int length = dArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Double.valueOf(dArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void shuffle(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        shuffle(fArr, (S3.f) S3.f.Default);
    }

    public static final Float singleOrNull(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    public static final List<Float> sorted(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        Float[] typedArray = AbstractC0151t.toTypedArray(fArr);
        AbstractC0151t.sort((Object[]) typedArray);
        return AbstractC0151t.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Float> sortedBy(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new D3.d(0, selector));
    }

    public static final <R extends Comparable<? super R>> List<Float> sortedByDescending(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new D3.d(1, selector));
    }

    public static final List<Float> sortedDescending(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.E.e(fArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(fArrCopyOf);
        return reversed(fArrCopyOf);
    }

    public static final List<Float> sortedWith(float[] fArr, Comparator<? super Float> comparator) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Float[] typedArray = AbstractC0151t.toTypedArray(fArr);
        AbstractC0151t.sortWith(typedArray, comparator);
        return AbstractC0151t.asList(typedArray);
    }

    public static final double sum(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        double d = 0.0d;
        for (double d6 : dArr) {
            d += d6;
        }
        return d;
    }

    private static final int sumOfUInt(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (byte b : bArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(Byte.valueOf(b))).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (byte b : bArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(Byte.valueOf(b))).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final HashSet<Float> toHashSet(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return (HashSet) toCollection(fArr, new HashSet(j0.mapCapacity(fArr.length)));
    }

    public static final List<Integer> toMutableList(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i5 : iArr) {
            arrayList.add(Integer.valueOf(i5));
        }
        return arrayList;
    }

    public static final Set<Float> toMutableSet(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return (Set) toCollection(fArr, new LinkedHashSet(j0.mapCapacity(fArr.length)));
    }

    public static final Iterable<C0133b0> withIndex(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return new C0135c0(new C0152u(fArr, 2));
    }

    public static final boolean all(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (double d : dArr) {
            if (!((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return !(dArr.length == 0);
    }

    public static final Iterable<Integer> asIterable(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr.length == 0 ? I.emptyList() : new A(iArr, 3);
    }

    public static final InterfaceC0233q asSequence(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr.length == 0 ? W3.z.emptySequence() : new B(iArr, 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Integer>> M associateByTo(int[] iArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (int i5 : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i5)), Integer.valueOf(i5));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Integer, ? super V>> M associateWithTo(int[] iArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (int i5 : iArr) {
            destination.put(Integer.valueOf(i5), valueSelector.invoke(Integer.valueOf(i5)));
        }
        return destination;
    }

    private static final double component1(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr[0];
    }

    private static final double component2(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr[1];
    }

    private static final double component3(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr[2];
    }

    private static final double component4(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr[3];
    }

    private static final double component5(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr[4];
    }

    public static boolean contains(char[] cArr, char c) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return indexOf(cArr, c) >= 0;
    }

    private static final int count(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr.length;
    }

    public static final List<Double> distinct(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return T.toList(toMutableSet(dArr));
    }

    public static final <K> List<Byte> distinctBy(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (hashSet.add(selector.invoke(Byte.valueOf(b)))) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    private static final double elementAtOrElse(double[] dArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= dArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).doubleValue() : dArr[i5];
    }

    private static final Double elementAtOrNull(double[] dArr, int i5) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return getOrNull(dArr, i5);
    }

    public static final List<Integer> filter(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        return arrayList;
    }

    public static final List<Short> filterIndexed(short[] sArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            short s6 = sArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Short.valueOf(s6))).booleanValue()) {
                arrayList.add(Short.valueOf(s6));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Integer>> C filterIndexedTo(int[] iArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = iArr[i5];
            int i8 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Integer.valueOf(i7))).booleanValue()) {
                destination.add(Integer.valueOf(i7));
            }
            i5++;
            i6 = i8;
        }
        return destination;
    }

    public static final List<Integer> filterNot(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C filterNotTo(double[] dArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (double d : dArr) {
            if (!((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Double>> C filterTo(double[] dArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
        }
        return destination;
    }

    private static final Double find(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                return Double.valueOf(d);
            }
        }
        return null;
    }

    private static final Short findLast(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            short s6 = sArr[length];
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                return Short.valueOf(s6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static short first(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double firstOrNull(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(double[] dArr, O3.p transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Double.valueOf(dArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(short[] sArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Short.valueOf(sArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(short[] sArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (short s6 : sArr) {
            O.addAll(destination, (Iterable) transform.invoke(Short.valueOf(s6)));
        }
        return destination;
    }

    public static final <R> R fold(double[] dArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (double d : dArr) {
            r6 = (R) operation.invoke(r6, Double.valueOf(d));
        }
        return r6;
    }

    public static final <R> R foldIndexed(double[] dArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Double.valueOf(dArr[i5]));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final <R> R foldRight(int[] iArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(iArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(int[] iArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Integer.valueOf(iArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final void forEach(double[] dArr, O3.l action) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (double d : dArr) {
            action.invoke(Double.valueOf(d));
        }
    }

    public static final void forEachIndexed(double[] dArr, O3.p action) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Double.valueOf(dArr[i5]));
            i5++;
            i6++;
        }
    }

    public static U3.q getIndices(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return new U3.q(0, getLastIndex(iArr), 1);
    }

    public static final int getLastIndex(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr.length - 1;
    }

    private static final double getOrElse(double[] dArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= dArr.length) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).doubleValue() : dArr[i5];
    }

    public static final Double getOrNull(double[] dArr, int i5) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (i5 < 0 || i5 >= dArr.length) {
            return null;
        }
        return Double.valueOf(dArr[i5]);
    }

    public static final int indexOfFirst(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i5]))).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(Integer.valueOf(iArr[length]))).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Set<Integer> intersect(int[] iArr, Iterable<Integer> other) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final boolean isEmpty(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr.length == 0;
    }

    private static final boolean isNotEmpty(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return !(dArr.length == 0);
    }

    public static final <A extends Appendable> A joinTo(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (byte b : bArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                buffer.append((CharSequence) lVar.invoke(Byte.valueOf(b)));
            } else {
                buffer.append(String.valueOf((int) b));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String joinToString(double[] dArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(dArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static short last(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[getLastIndex(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double lastOrNull(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    public static final <R> List<R> map(short[] sArr, O3.l transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s6 : sArr) {
            arrayList.add(transform.invoke(Short.valueOf(s6)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(short[] sArr, O3.p transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Short.valueOf(sArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(int[] iArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(int[] iArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 : iArr) {
            destination.add(transform.invoke(Integer.valueOf(i5)));
        }
        return destination;
    }

    private static final double maxOf(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).doubleValue();
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Byte.valueOf(bArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m20maxOfOrNull(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).doubleValue();
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Byte.valueOf(bArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(byte[] bArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            R r6 = (Object) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Byte.valueOf(bArr[i5]));
                    if (comparator.compare(r6, objInvoke) < 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final Float maxOrNull(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, fArr[i5].floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final float maxOrThrow(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length != 0) {
            float fFloatValue = fArr[0].floatValue();
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, fArr[i5].floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final byte maxWithOrThrow(byte[] bArr, Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte b6 = bArr[i5];
                    if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b6)) < 0) {
                        b = b6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).doubleValue();
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Byte.valueOf(bArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m56minOfOrNull(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).doubleValue();
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Byte.valueOf(bArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(byte[] bArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            R r6 = (Object) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Byte.valueOf(bArr[i5]));
                    if (comparator.compare(r6, objInvoke) > 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final Float minOrNull(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, fArr[i5].floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final float minOrThrow(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length != 0) {
            float fFloatValue = fArr[0].floatValue();
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, fArr[i5].floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final byte minWithOrThrow(byte[] bArr, Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte b6 = bArr[i5];
                    if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b6)) > 0) {
                        b = b6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr.length == 0;
    }

    private static final double[] onEach(double[] dArr, O3.l action) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (double d : dArr) {
            action.invoke(Double.valueOf(d));
        }
        return dArr;
    }

    private static final double[] onEachIndexed(double[] dArr, O3.p action) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Double.valueOf(dArr[i5]));
            i5++;
            i6++;
        }
        return dArr;
    }

    private static final double random(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return random(dArr, S3.f.Default);
    }

    private static final Double randomOrNull(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return randomOrNull(dArr, S3.f.Default);
    }

    public static final List<Short> reversed(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 0) {
            return I.emptyList();
        }
        List<Short> mutableList = toMutableList(sArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    private static final List<Byte> runningReduce(byte[] bArr, O3.p operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length == 0) {
            return I.emptyList();
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            bByteValue = ((Number) operation.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i5]))).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    private static final List<Byte> runningReduceIndexed(byte[] bArr, O3.q operation) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (bArr.length == 0) {
            return I.emptyList();
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            bByteValue = ((Number) operation.invoke(Integer.valueOf(i5), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i5]))).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    private static final <R> List<R> scan(boolean[] zArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r6);
        for (boolean z6 : zArr) {
            r6 = (R) operation.invoke(r6, Boolean.valueOf(z6));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(boolean[] zArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r6);
        int length = zArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Boolean.valueOf(zArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void shuffle(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        shuffle(dArr, S3.f.Default);
    }

    public static final Double singleOrNull(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    public static final List<Integer> slice(int[] iArr, U3.q indices) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static short[] sliceArray(short[] sArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        short[] sArr2 = new short[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            sArr2[i5] = sArr[it.next().intValue()];
            i5++;
        }
        return sArr2;
    }

    public static final List<Double> sorted(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        Double[] typedArray = AbstractC0151t.toTypedArray(dArr);
        AbstractC0151t.sort((Object[]) typedArray);
        return AbstractC0151t.asList(typedArray);
    }

    public static final int[] sortedArray(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.E.e(iArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(iArrCopyOf);
        return iArrCopyOf;
    }

    public static final int[] sortedArrayDescending(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.E.e(iArrCopyOf, "copyOf(...)");
        sortDescending(iArrCopyOf);
        return iArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Double> sortedBy(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(dArr, new D3.d(0, selector));
    }

    public static final <R extends Comparable<? super R>> List<Double> sortedByDescending(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(dArr, new D3.d(1, selector));
    }

    public static final List<Double> sortedDescending(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.E.e(dArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(dArrCopyOf);
        return reversed(dArrCopyOf);
    }

    public static final List<Double> sortedWith(double[] dArr, Comparator<? super Double> comparator) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Double[] typedArray = AbstractC0151t.toTypedArray(dArr);
        AbstractC0151t.sortWith(typedArray, comparator);
        return AbstractC0151t.asList(typedArray);
    }

    public static final Set<Integer> subtract(int[] iArr, Iterable<Integer> other) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sumBy(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (int i5 : iArr) {
            iIntValue += ((Number) selector.invoke(Integer.valueOf(i5))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i5 : iArr) {
            dDoubleValue += ((Number) selector.invoke(Integer.valueOf(i5))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i5 : iArr) {
            dDoubleValue += ((Number) selector.invoke(Integer.valueOf(i5))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (int i5 : iArr) {
            iIntValue += ((Number) selector.invoke(Integer.valueOf(i5))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (int i5 : iArr) {
            jLongValue += ((Number) selector.invoke(Integer.valueOf(i5))).longValue();
        }
        return jLongValue;
    }

    public static final <C extends Collection<? super Integer>> C toCollection(int[] iArr, C destination) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (int i5 : iArr) {
            destination.add(Integer.valueOf(i5));
        }
        return destination;
    }

    public static final HashSet<Double> toHashSet(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return (HashSet) toCollection(dArr, new HashSet(j0.mapCapacity(dArr.length)));
    }

    public static final Set<Double> toMutableSet(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return (Set) toCollection(dArr, new LinkedHashSet(j0.mapCapacity(dArr.length)));
    }

    public static final Set<Integer> union(int[] iArr, Iterable<Integer> other) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Iterable<C0133b0> withIndex(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return new C0135c0(new C0152u(dArr, 0));
    }

    public static final <R, V> List<V> zip(short[] sArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i5]), other[i5]));
        }
        return arrayList;
    }

    public static final boolean all(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (boolean z6 : zArr) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return !(zArr.length == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(byte[] bArr, O3.l transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(bArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (byte b : bArr) {
            C1938s c1938s = (C1938s) transform.invoke(Byte.valueOf(b));
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Integer, V> associateWith(int[] iArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(iArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 : iArr) {
            linkedHashMap.put(Integer.valueOf(i5), valueSelector.invoke(Integer.valueOf(i5)));
        }
        return linkedHashMap;
    }

    private static final boolean component1(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr[0];
    }

    private static final boolean component2(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr[1];
    }

    private static final boolean component3(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr[2];
    }

    private static final boolean component4(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr[3];
    }

    private static final boolean component5(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr[4];
    }

    public static final /* synthetic */ boolean contains(float[] fArr, float f6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        for (float f7 : fArr) {
            if (f7 == f6) {
                return true;
            }
        }
        return false;
    }

    private static final int count(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr.length;
    }

    public static final List<Boolean> distinct(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return T.toList(toMutableSet(zArr));
    }

    private static final boolean elementAtOrElse(boolean[] zArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= zArr.length) ? ((Boolean) defaultValue.invoke(Integer.valueOf(i5))).booleanValue() : zArr[i5];
    }

    private static final Boolean elementAtOrNull(boolean[] zArr, int i5) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return getOrNull(zArr, i5);
    }

    public static final <C extends Collection<? super Boolean>> C filterNotTo(boolean[] zArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (boolean z6 : zArr) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                destination.add(Boolean.valueOf(z6));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Boolean>> C filterTo(boolean[] zArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                destination.add(Boolean.valueOf(z6));
            }
        }
        return destination;
    }

    private static final Boolean find(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                return Boolean.valueOf(z6);
            }
        }
        return null;
    }

    public static final Boolean firstOrNull(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    private static final <R> List<R> flatMapIndexedIterable(boolean[] zArr, O3.p transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Boolean.valueOf(zArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R> R fold(boolean[] zArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (boolean z6 : zArr) {
            r6 = (R) operation.invoke(r6, Boolean.valueOf(z6));
        }
        return r6;
    }

    public static final <R> R foldIndexed(boolean[] zArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Boolean.valueOf(zArr[i5]));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final void forEach(boolean[] zArr, O3.l action) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (boolean z6 : zArr) {
            action.invoke(Boolean.valueOf(z6));
        }
    }

    public static final void forEachIndexed(boolean[] zArr, O3.p action) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Boolean.valueOf(zArr[i5]));
            i5++;
            i6++;
        }
    }

    public static final int getLastIndex(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr.length - 1;
    }

    private static final boolean getOrElse(boolean[] zArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= zArr.length) ? ((Boolean) defaultValue.invoke(Integer.valueOf(i5))).booleanValue() : zArr[i5];
    }

    public static final Boolean getOrNull(boolean[] zArr, int i5) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (i5 < 0 || i5 >= zArr.length) {
            return null;
        }
        return Boolean.valueOf(zArr[i5]);
    }

    public static int indexOf(short[] sArr, short s6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        int length = sArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (s6 == sArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    private static final boolean isEmpty(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr.length == 0;
    }

    private static final boolean isNotEmpty(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return !(zArr.length == 0);
    }

    public static final String joinToString(boolean[] zArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(zArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static int lastIndexOf(short[] sArr, short s6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (s6 == sArr[length]) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Boolean lastOrNull(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    public static final <R extends Comparable<? super R>> Byte maxByOrNull(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b);
        }
        Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b6 = bArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b6));
                if (comparable.compareTo(comparable2) < 0) {
                    b = b6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(b);
    }

    public static final <R extends Comparable<? super R>> Byte minByOrNull(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b);
        }
        Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b6 = bArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b6));
                if (comparable.compareTo(comparable2) > 0) {
                    b = b6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(b);
    }

    public static final boolean none(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr.length == 0;
    }

    private static final boolean[] onEach(boolean[] zArr, O3.l action) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (boolean z6 : zArr) {
            action.invoke(Boolean.valueOf(z6));
        }
        return zArr;
    }

    private static final boolean[] onEachIndexed(boolean[] zArr, O3.p action) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Boolean.valueOf(zArr[i5]));
            i5++;
            i6++;
        }
        return zArr;
    }

    public static final C1938s partition(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            } else {
                arrayList2.add(Byte.valueOf(b));
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    private static final boolean random(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return random(zArr, S3.f.Default);
    }

    private static final Boolean randomOrNull(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return randomOrNull(zArr, S3.f.Default);
    }

    public static final Short reduceRightIndexedOrNull(short[] sArr, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short sShortValue = sArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            sShortValue = ((Number) operation.invoke(Integer.valueOf(i5), Short.valueOf(sArr[i5]), Short.valueOf(sShortValue))).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    public static final Short reduceRightOrNull(short[] sArr, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short sShortValue = sArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            sShortValue = ((Number) operation.invoke(Short.valueOf(sArr[i5]), Short.valueOf(sShortValue))).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    private static final <R> List<R> scan(char[] cArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r6);
        for (char c : cArr) {
            r6 = (R) operation.invoke(r6, Character.valueOf(c));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(char[] cArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r6);
        int length = cArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Character.valueOf(cArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void shuffle(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        shuffle(zArr, S3.f.Default);
    }

    public static final Boolean singleOrNull(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    public static final void sortDescending(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length > 1) {
            AbstractC0151t.sort(iArr);
            reverse(iArr);
        }
    }

    public static final List<Character> sorted(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        Character[] typedArray = AbstractC0151t.toTypedArray(cArr);
        AbstractC0151t.sort((Object[]) typedArray);
        return AbstractC0151t.asList(typedArray);
    }

    public static final <R extends Comparable<? super R>> List<Boolean> sortedBy(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(zArr, new D3.d(0, selector));
    }

    public static final <R extends Comparable<? super R>> List<Boolean> sortedByDescending(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(zArr, new D3.d(1, selector));
    }

    public static final List<Character> sortedDescending(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.E.e(cArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(cArrCopyOf);
        return reversed(cArrCopyOf);
    }

    public static final List<Boolean> sortedWith(boolean[] zArr, Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Boolean[] typedArray = AbstractC0151t.toTypedArray(zArr);
        AbstractC0151t.sortWith(typedArray, comparator);
        return AbstractC0151t.asList(typedArray);
    }

    public static final HashSet<Boolean> toHashSet(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return (HashSet) toCollection(zArr, new HashSet(j0.mapCapacity(zArr.length)));
    }

    public static final List<Long> toMutableList(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j6 : jArr) {
            arrayList.add(Long.valueOf(j6));
        }
        return arrayList;
    }

    public static final Set<Boolean> toMutableSet(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return (Set) toCollection(zArr, new LinkedHashSet(j0.mapCapacity(zArr.length)));
    }

    public static final Iterable<C0133b0> withIndex(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return new C0135c0(new C0152u(zArr, 3));
    }

    public static final boolean all(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (char c : cArr) {
            if (!((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return !(cArr.length == 0);
    }

    public static final Iterable<Long> asIterable(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr.length == 0 ? I.emptyList() : new A(jArr, 4);
    }

    public static final InterfaceC0233q asSequence(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr.length == 0 ? W3.z.emptySequence() : new B(jArr, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Short> associateBy(short[] sArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(sArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (short s6 : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s6)), Short.valueOf(s6));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Long>> M associateByTo(long[] jArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (long j6 : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j6)), Long.valueOf(j6));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Long, ? super V>> M associateWithTo(long[] jArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (long j6 : jArr) {
            destination.put(Long.valueOf(j6), valueSelector.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    private static final char component1(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr[0];
    }

    private static final char component2(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr[1];
    }

    private static final char component3(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr[2];
    }

    private static final char component4(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr[3];
    }

    private static final char component5(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr[4];
    }

    public static final /* synthetic */ boolean contains(double[] dArr, double d) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        for (double d6 : dArr) {
            if (d6 == d) {
                return true;
            }
        }
        return false;
    }

    private static final int count(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr.length;
    }

    public static final List<Character> distinct(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return T.toList(toMutableSet(cArr));
    }

    public static final List<Short> dropLastWhile(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Short.valueOf(sArr[lastIndex]))).booleanValue()) {
                return take(sArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    private static final char elementAtOrElse(char[] cArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= cArr.length) ? ((Character) defaultValue.invoke(Integer.valueOf(i5))).charValue() : cArr[i5];
    }

    private static final Character elementAtOrNull(char[] cArr, int i5) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return getOrNull(cArr, i5);
    }

    public static final List<Long> filter(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C filterIndexedTo(long[] jArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            long j6 = jArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Long.valueOf(j6))).booleanValue()) {
                destination.add(Long.valueOf(j6));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final List<Long> filterNot(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            if (!((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C filterNotTo(char[] cArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (char c : cArr) {
            if (!((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Character>> C filterTo(char[] cArr, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
        }
        return destination;
    }

    private static final Character find(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                return Character.valueOf(c);
            }
        }
        return null;
    }

    public static final Character firstOrNull(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    public static final <R> List<R> flatMap(short[] sArr, O3.l transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s6 : sArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(Short.valueOf(s6)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(char[] cArr, O3.p transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Character.valueOf(cArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R> R fold(char[] cArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (char c : cArr) {
            r6 = (R) operation.invoke(r6, Character.valueOf(c));
        }
        return r6;
    }

    public static final <R> R foldIndexed(char[] cArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Character.valueOf(cArr[i5]));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final <R> R foldRight(long[] jArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Long.valueOf(jArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(long[] jArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Long.valueOf(jArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final void forEach(char[] cArr, O3.l action) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (char c : cArr) {
            action.invoke(Character.valueOf(c));
        }
    }

    public static final void forEachIndexed(char[] cArr, O3.p action) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Character.valueOf(cArr[i5]));
            i5++;
            i6++;
        }
    }

    public static U3.q getIndices(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return new U3.q(0, getLastIndex(jArr), 1);
    }

    public static final int getLastIndex(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr.length - 1;
    }

    private static final char getOrElse(char[] cArr, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= cArr.length) ? ((Character) defaultValue.invoke(Integer.valueOf(i5))).charValue() : cArr[i5];
    }

    public static final Character getOrNull(char[] cArr, int i5) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (i5 < 0 || i5 >= cArr.length) {
            return null;
        }
        return Character.valueOf(cArr[i5]);
    }

    public static final int indexOfFirst(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(Long.valueOf(jArr[i5]))).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(Long.valueOf(jArr[length]))).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Set<Long> intersect(long[] jArr, Iterable<Long> other) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    private static final boolean isEmpty(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr.length == 0;
    }

    private static final boolean isNotEmpty(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return !(cArr.length == 0);
    }

    public static final String joinToString(char[] cArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(cArr, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static final Character lastOrNull(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(long[] jArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(long[] jArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (long j6 : jArr) {
            destination.add(transform.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    public static final <R extends Comparable<? super R>> byte maxByOrThrow(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        byte b6 = bArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b6));
                        if (comparable.compareTo(comparable2) < 0) {
                            b = b6;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> byte minByOrThrow(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        byte b6 = bArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b6));
                        if (comparable.compareTo(comparable2) > 0) {
                            b = b6;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr.length == 0;
    }

    private static final char[] onEach(char[] cArr, O3.l action) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (char c : cArr) {
            action.invoke(Character.valueOf(c));
        }
        return cArr;
    }

    private static final char[] onEachIndexed(char[] cArr, O3.p action) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            action.invoke(Integer.valueOf(i6), Character.valueOf(cArr[i5]));
            i5++;
            i6++;
        }
        return cArr;
    }

    private static final char random(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return random(cArr, (S3.f) S3.f.Default);
    }

    private static final Character randomOrNull(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return randomOrNull(cArr, (S3.f) S3.f.Default);
    }

    public static final short reduceRight(short[] sArr, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short sShortValue = sArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                sShortValue = ((Number) operation.invoke(Short.valueOf(sArr[i5]), Short.valueOf(sShortValue))).shortValue();
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceRightIndexed(short[] sArr, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short sShortValue = sArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                sShortValue = ((Number) operation.invoke(Integer.valueOf(i5), Short.valueOf(sArr[i5]), Short.valueOf(sShortValue))).shortValue();
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static short[] reversedArray(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                sArr2[lastIndex - i5] = sArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return sArr2;
    }

    public static final <T, R> List<R> scan(T[] tArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r6);
        for (T t6 : tArr) {
            r6 = (R) operation.invoke(r6, t6);
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final <T, R> List<R> scanIndexed(T[] tArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (tArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r6);
        int length = tArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, tArr[i5]);
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void shuffle(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        shuffle(cArr, (S3.f) S3.f.Default);
    }

    public static short single(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Character singleOrNull(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final List<Long> slice(long[] jArr, U3.q indices) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final long[] sortedArray(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.E.e(jArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final long[] sortedArrayDescending(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.E.e(jArrCopyOf, "copyOf(...)");
        sortDescending(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final <R extends Comparable<? super R>> List<Character> sortedBy(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new D3.d(0, selector));
    }

    public static final <R extends Comparable<? super R>> List<Character> sortedByDescending(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new D3.d(1, selector));
    }

    public static final List<Character> sortedWith(char[] cArr, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Character[] typedArray = AbstractC0151t.toTypedArray(cArr);
        AbstractC0151t.sortWith(typedArray, comparator);
        return AbstractC0151t.asList(typedArray);
    }

    public static final Set<Long> subtract(long[] jArr, Iterable<Long> other) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sumBy(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (long j6 : jArr) {
            iIntValue += ((Number) selector.invoke(Long.valueOf(j6))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j6 : jArr) {
            dDoubleValue += ((Number) selector.invoke(Long.valueOf(j6))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j6 : jArr) {
            dDoubleValue += ((Number) selector.invoke(Long.valueOf(j6))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (long j6 : jArr) {
            iIntValue += ((Number) selector.invoke(Long.valueOf(j6))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (long j6 : jArr) {
            jLongValue += ((Number) selector.invoke(Long.valueOf(j6))).longValue();
        }
        return jLongValue;
    }

    public static final List<Short> takeLastWhile(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Short.valueOf(sArr[lastIndex]))).booleanValue()) {
                return drop(sArr, lastIndex + 1);
            }
        }
        return toList(sArr);
    }

    public static final List<Short> takeWhile(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s6 : sArr) {
            if (!((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s6));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C toCollection(long[] jArr, C destination) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (long j6 : jArr) {
            destination.add(Long.valueOf(j6));
        }
        return destination;
    }

    public static final HashSet<Character> toHashSet(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = cArr.length;
        if (length > 128) {
            length = 128;
        }
        return (HashSet) toCollection(cArr, new HashSet(j0.mapCapacity(length)));
    }

    public static final List<Short> toList(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return I.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return G.listOf(Short.valueOf(sArr[0]));
    }

    public static final Set<Character> toMutableSet(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = cArr.length;
        if (length > 128) {
            length = 128;
        }
        return (Set) toCollection(cArr, new LinkedHashSet(j0.mapCapacity(length)));
    }

    public static final Set<Short> toSet(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return w0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(sArr, new LinkedHashSet(j0.mapCapacity(sArr.length)));
        }
        return v0.setOf(Short.valueOf(sArr[0]));
    }

    public static final Set<Long> union(long[] jArr, Iterable<Long> other) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Iterable<C0133b0> withIndex(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return new C0135c0(new C0152u(cArr, 1));
    }

    public static final <T> boolean any(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Long, V> associateWith(long[] jArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(jArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (long j6 : jArr) {
            linkedHashMap.put(Long.valueOf(j6), valueSelector.invoke(Long.valueOf(j6)));
        }
        return linkedHashMap;
    }

    public static final <T> int count(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final List<Byte> drop(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (i5 >= 0) {
            int length = bArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return takeLast(bArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Byte> dropLast(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (i5 >= 0) {
            int length = bArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return take(bArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Integer> filterIndexed(int[] iArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = iArr[i5];
            int i8 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Integer.valueOf(i7))).booleanValue()) {
                arrayList.add(Integer.valueOf(i7));
            }
            i5++;
            i6 = i8;
        }
        return arrayList;
    }

    private static final Integer findLast(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            int i6 = iArr[length];
            if (((Boolean) predicate.invoke(Integer.valueOf(i6))).booleanValue()) {
                return Integer.valueOf(i6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static int first(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T firstOrNull(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        return null;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(int[] iArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(int[] iArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 : iArr) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i5)));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, List<Byte>>> M groupByTo(byte[] bArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (byte b : bArr) {
            Object objInvoke = keySelector.invoke(Byte.valueOf(b));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Byte.valueOf(b));
        }
        return destination;
    }

    public static int indexOf(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (i5 == iArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public static int last(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[getLastIndex(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int lastIndexOf(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i6 = length - 1;
                if (i5 == iArr[length]) {
                    return length;
                }
                if (i6 >= 0) {
                    length = i6;
                }
            }
        }
        return -1;
    }

    public static final <T> T lastOrNull(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            T t6 = tArr[length];
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                return t6;
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final <R> List<R> map(int[] iArr, O3.l transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i5 : iArr) {
            arrayList.add(transform.invoke(Integer.valueOf(i5)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(int[] iArr, O3.p transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <T> boolean none(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> T random(T[] tArr, S3.f random) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (tArr.length != 0) {
            return tArr[random.d(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T randomOrNull(T[] tArr, S3.f random) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.d(tArr.length)];
    }

    public static final Short reduceIndexedOrNull(short[] sArr, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sShortValue = ((Number) operation.invoke(Integer.valueOf(i5), Short.valueOf(sShortValue), Short.valueOf(sArr[i5]))).shortValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(sShortValue);
    }

    public static final Short reduceOrNull(short[] sArr, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                sShortValue = ((Number) operation.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i5]))).shortValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(sShortValue);
    }

    public static final List<Integer> reversed(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 0) {
            return I.emptyList();
        }
        List<Integer> mutableList = toMutableList(iArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    public static final <T> void shuffle(T[] tArr, S3.f random) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(tArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            T t6 = tArr[lastIndex];
            tArr[lastIndex] = tArr[iD];
            tArr[iD] = t6;
        }
    }

    public static final <T> T singleOrNull(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        T t6 = null;
        boolean z6 = false;
        for (T t7 : tArr) {
            if (((Boolean) predicate.invoke(t7)).booleanValue()) {
                if (z6) {
                    return null;
                }
                z6 = true;
                t6 = t7;
            }
        }
        if (z6) {
            return t6;
        }
        return null;
    }

    public static int[] sliceArray(int[] iArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int[] iArr2 = new int[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            iArr2[i5] = iArr[it.next().intValue()];
            i5++;
        }
        return iArr2;
    }

    public static final List<Float> toMutableList(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f6 : fArr) {
            arrayList.add(Float.valueOf(f6));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(int[] iArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i5]), other[i5]));
        }
        return arrayList;
    }

    public static final boolean any(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Float> asIterable(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr.length == 0 ? I.emptyList() : new A(fArr, 5);
    }

    public static final InterfaceC0233q asSequence(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr.length == 0 ? W3.z.emptySequence() : new B(fArr, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Float>> M associateByTo(float[] fArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (float f6 : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f6)), Float.valueOf(f6));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(short[] sArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (short s6 : sArr) {
            C1938s c1938s = (C1938s) transform.invoke(Short.valueOf(s6));
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Float, ? super V>> M associateWithTo(float[] fArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (float f6 : fArr) {
            destination.put(Float.valueOf(f6), valueSelector.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    public static final int count(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final List<Short> dropWhile(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (short s6 : sArr) {
            if (z6) {
                arrayList.add(Short.valueOf(s6));
            } else if (!((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                arrayList.add(Short.valueOf(s6));
                z6 = true;
            }
        }
        return arrayList;
    }

    public static final List<Float> filter(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Float>> C filterIndexedTo(float[] fArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            float f6 = fArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Float.valueOf(f6))).booleanValue()) {
                destination.add(Float.valueOf(f6));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final List<Float> filterNot(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            if (!((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
            }
        }
        return arrayList;
    }

    public static final Byte firstOrNull(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                return Byte.valueOf(b);
            }
        }
        return null;
    }

    public static final <R> R foldRight(float[] fArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Float.valueOf(fArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(float[] fArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Float.valueOf(fArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final U3.q getIndices(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return new U3.q(0, getLastIndex(fArr), 1);
    }

    public static final <K> Map<K, List<Byte>> groupBy(byte[] bArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : bArr) {
            Object objInvoke = keySelector.invoke(Byte.valueOf(b));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Byte.valueOf(b));
        }
        return linkedHashMap;
    }

    public static final int indexOfFirst(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(Float.valueOf(fArr[i5]))).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(Float.valueOf(fArr[length]))).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Set<Float> intersect(float[] fArr, Iterable<Float> other) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(float[] fArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(float[] fArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (float f6 : fArr) {
            destination.add(transform.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    private static final <R> R maxOfWithOrNull(short[] sArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Short.valueOf(sArr[i5]));
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R> R minOfWithOrNull(short[] sArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Short.valueOf(sArr[i5]));
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final boolean none(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final short reduce(short[] sArr, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length != 0) {
            short sShortValue = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    sShortValue = ((Number) operation.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i5]))).shortValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceIndexed(short[] sArr, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length != 0) {
            short sShortValue = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    sShortValue = ((Number) operation.invoke(Integer.valueOf(i5), Short.valueOf(sShortValue), Short.valueOf(sArr[i5]))).shortValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return sShortValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(sArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            short s6 = sArr[i5];
            sArr[i5] = sArr[lastIndex];
            sArr[lastIndex] = s6;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private static final <R> List<R> runningFold(short[] sArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r6);
        for (short s6 : sArr) {
            r6 = (R) operation.invoke(r6, Short.valueOf(s6));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(short[] sArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r6);
        int length = sArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Short.valueOf(sArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final List<Float> slice(float[] fArr, U3.q indices) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length > 1) {
            AbstractC0151t.sort(jArr);
            reverse(jArr);
        }
    }

    public static final float[] sortedArray(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.E.e(fArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final float[] sortedArrayDescending(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.E.e(fArrCopyOf, "copyOf(...)");
        sortDescending(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final Set<Float> subtract(float[] fArr, Iterable<Float> other) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sumBy(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (float f6 : fArr) {
            iIntValue += ((Number) selector.invoke(Float.valueOf(f6))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (float f6 : fArr) {
            dDoubleValue += ((Number) selector.invoke(Float.valueOf(f6))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (float f6 : fArr) {
            dDoubleValue += ((Number) selector.invoke(Float.valueOf(f6))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (float f6 : fArr) {
            iIntValue += ((Number) selector.invoke(Float.valueOf(f6))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (float f6 : fArr) {
            jLongValue += ((Number) selector.invoke(Float.valueOf(f6))).longValue();
        }
        return jLongValue;
    }

    private static final int sumOfUInt(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (short s6 : sArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(Short.valueOf(s6))).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (short s6 : sArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(Short.valueOf(s6))).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final <C extends Collection<? super Float>> C toCollection(float[] fArr, C destination) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (float f6 : fArr) {
            destination.add(Float.valueOf(f6));
        }
        return destination;
    }

    public static final Set<Float> union(float[] fArr, Iterable<Float> other) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Float, V> associateWith(float[] fArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(fArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (float f6 : fArr) {
            linkedHashMap.put(Float.valueOf(f6), valueSelector.invoke(Float.valueOf(f6)));
        }
        return linkedHashMap;
    }

    public static final int count(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final Short firstOrNull(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                return Short.valueOf(s6);
            }
        }
        return null;
    }

    public static int indexOf(long[] jArr, long j6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (j6 == jArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (j6 == jArr[length]) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Short maxWithOrNull(short[] sArr, Comparator<? super Short> comparator) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s6 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s7 = sArr[i5];
                if (comparator.compare(Short.valueOf(s6), Short.valueOf(s7)) < 0) {
                    s6 = s7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(s6);
    }

    public static final Short minWithOrNull(short[] sArr, Comparator<? super Short> comparator) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s6 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s7 = sArr[i5];
                if (comparator.compare(Short.valueOf(s6), Short.valueOf(s7)) > 0) {
                    s6 = s7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(s6);
    }

    public static final boolean none(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Byte randomOrNull(byte[] bArr, S3.f random) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[random.d(bArr.length)]);
    }

    public static final Integer reduceRightIndexedOrNull(int[] iArr, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int iIntValue = iArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            iIntValue = ((Number) operation.invoke(Integer.valueOf(i5), Integer.valueOf(iArr[i5]), Integer.valueOf(iIntValue))).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Integer reduceRightOrNull(int[] iArr, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int iIntValue = iArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            iIntValue = ((Number) operation.invoke(Integer.valueOf(iArr[i5]), Integer.valueOf(iIntValue))).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Byte singleOrNull(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Byte bValueOf = null;
        boolean z6 = false;
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                if (z6) {
                    return null;
                }
                bValueOf = Byte.valueOf(b);
                z6 = true;
            }
        }
        if (z6) {
            return bValueOf;
        }
        return null;
    }

    public static final List<Double> toMutableList(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static final boolean any(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Double> asIterable(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr.length == 0 ? I.emptyList() : new A(dArr, 6);
    }

    public static final InterfaceC0233q asSequence(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr.length == 0 ? W3.z.emptySequence() : new B(dArr, 6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Integer> associateBy(int[] iArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(iArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i5)), Integer.valueOf(i5));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Double>> M associateByTo(double[] dArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (double d : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d)), Double.valueOf(d));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Double, ? super V>> M associateWithTo(double[] dArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (double d : dArr) {
            destination.put(Double.valueOf(d), valueSelector.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    public static final int count(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (int i6 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i6))).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final <K> List<Short> distinctBy(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s6 : sArr) {
            if (hashSet.add(selector.invoke(Short.valueOf(s6)))) {
                arrayList.add(Short.valueOf(s6));
            }
        }
        return arrayList;
    }

    public static final List<Integer> dropLastWhile(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(iArr[lastIndex]))).booleanValue()) {
                return take(iArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    public static final List<Double> filter(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    public static final List<Long> filterIndexed(long[] jArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            long j6 = jArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Long.valueOf(j6))).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C filterIndexedTo(double[] dArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            double d = dArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Double.valueOf(d))).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final List<Double> filterNot(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (!((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    private static final Long findLast(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            long j6 = jArr[length];
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                return Long.valueOf(j6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static long first(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer firstOrNull(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                return Integer.valueOf(i5);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(int[] iArr, O3.l transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i5)));
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(long[] jArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(long[] jArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (long j6 : jArr) {
            O.addAll(destination, (Iterable) transform.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    public static final <R> R foldRight(double[] dArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Double.valueOf(dArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(double[] dArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Double.valueOf(dArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final U3.q getIndices(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return new U3.q(0, getLastIndex(dArr), 1);
    }

    public static final int indexOfFirst(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = dArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(Double.valueOf(dArr[i5]))).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(Double.valueOf(dArr[length]))).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Set<Double> intersect(double[] dArr, Iterable<Double> other) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static long last(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[getLastIndex(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Byte lastOrNull(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            byte b = bArr[length];
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                return Byte.valueOf(b);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final <R> List<R> map(long[] jArr, O3.l transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j6 : jArr) {
            arrayList.add(transform.invoke(Long.valueOf(j6)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(long[] jArr, O3.p transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(double[] dArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), Double.valueOf(dArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(double[] dArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (double d : dArr) {
            destination.add(transform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    private static final double maxOf(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).doubleValue();
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Short.valueOf(sArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m27maxOfOrNull(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).doubleValue();
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Short.valueOf(sArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(short[] sArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            R r6 = (Object) selector.invoke(Short.valueOf(sArr[0]));
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Short.valueOf(sArr[i5]));
                    if (comparator.compare(r6, objInvoke) < 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t7 = tArr[i5];
                if (t6.compareTo(t7) < 0) {
                    t6 = t7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return t6;
    }

    public static final <T extends Comparable<? super T>> T maxOrThrow(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length != 0) {
            T t6 = tArr[0];
            int lastIndex = getLastIndex(tArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t7 = tArr[i5];
                    if (t6.compareTo(t7) < 0) {
                        t6 = t7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return t6;
        }
        throw new NoSuchElementException();
    }

    public static final short maxWithOrThrow(short[] sArr, Comparator<? super Short> comparator) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (sArr.length != 0) {
            short s6 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short s7 = sArr[i5];
                    if (comparator.compare(Short.valueOf(s6), Short.valueOf(s7)) < 0) {
                        s6 = s7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return s6;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).doubleValue();
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Short.valueOf(sArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m63minOfOrNull(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).doubleValue();
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Short.valueOf(sArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(short[] sArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            R r6 = (Object) selector.invoke(Short.valueOf(sArr[0]));
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Short.valueOf(sArr[i5]));
                    if (comparator.compare(r6, objInvoke) > 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> T minOrNull(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t6 = tArr[0];
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t7 = tArr[i5];
                if (t6.compareTo(t7) > 0) {
                    t6 = t7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return t6;
    }

    public static final <T extends Comparable<? super T>> T minOrThrow(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length != 0) {
            T t6 = tArr[0];
            int lastIndex = getLastIndex(tArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t7 = tArr[i5];
                    if (t6.compareTo(t7) > 0) {
                        t6 = t7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return t6;
        }
        throw new NoSuchElementException();
    }

    public static final short minWithOrThrow(short[] sArr, Comparator<? super Short> comparator) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (sArr.length != 0) {
            short s6 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short s7 = sArr[i5];
                    if (comparator.compare(Short.valueOf(s6), Short.valueOf(s7)) > 0) {
                        s6 = s7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return s6;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final byte random(byte[] bArr, S3.f random) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (bArr.length != 0) {
            return bArr[random.d(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int reduceRight(int[] iArr, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int iIntValue = iArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                iIntValue = ((Number) operation.invoke(Integer.valueOf(iArr[i5]), Integer.valueOf(iIntValue))).intValue();
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceRightIndexed(int[] iArr, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int iIntValue = iArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                iIntValue = ((Number) operation.invoke(Integer.valueOf(i5), Integer.valueOf(iArr[i5]), Integer.valueOf(iIntValue))).intValue();
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final List<Long> reversed(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 0) {
            return I.emptyList();
        }
        List<Long> mutableList = toMutableList(jArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    public static int[] reversedArray(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                iArr2[lastIndex - i5] = iArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return iArr2;
    }

    private static final List<Short> runningReduce(short[] sArr, O3.p operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length == 0) {
            return I.emptyList();
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            sShortValue = ((Number) operation.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i5]))).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    private static final List<Short> runningReduceIndexed(short[] sArr, O3.q operation) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (sArr.length == 0) {
            return I.emptyList();
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            sShortValue = ((Number) operation.invoke(Integer.valueOf(i5), Short.valueOf(sShortValue), Short.valueOf(sArr[i5]))).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    public static int single(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Double> slice(double[] dArr, U3.q indices) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static long[] sliceArray(long[] jArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        long[] jArr2 = new long[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            jArr2[i5] = jArr[it.next().intValue()];
            i5++;
        }
        return jArr2;
    }

    public static final double[] sortedArray(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.E.e(dArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final double[] sortedArrayDescending(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.E.e(dArrCopyOf, "copyOf(...)");
        sortDescending(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final Set<Double> subtract(double[] dArr, Iterable<Double> other) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sumBy(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (double d : dArr) {
            iIntValue += ((Number) selector.invoke(Double.valueOf(d))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (double d : dArr) {
            dDoubleValue += ((Number) selector.invoke(Double.valueOf(d))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (double d : dArr) {
            dDoubleValue += ((Number) selector.invoke(Double.valueOf(d))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (double d : dArr) {
            iIntValue += ((Number) selector.invoke(Double.valueOf(d))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (double d : dArr) {
            jLongValue += ((Number) selector.invoke(Double.valueOf(d))).longValue();
        }
        return jLongValue;
    }

    public static final List<Integer> takeLastWhile(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(iArr[lastIndex]))).booleanValue()) {
                return drop(iArr, lastIndex + 1);
            }
        }
        return toList(iArr);
    }

    public static final List<Integer> takeWhile(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (!((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i5));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C toCollection(double[] dArr, C destination) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (double d : dArr) {
            destination.add(Double.valueOf(d));
        }
        return destination;
    }

    public static final List<Integer> toList(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return I.emptyList();
        }
        if (length != 1) {
            return toMutableList(iArr);
        }
        return G.listOf(Integer.valueOf(iArr[0]));
    }

    public static final Set<Integer> toSet(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return w0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(iArr, new LinkedHashSet(j0.mapCapacity(iArr.length)));
        }
        return v0.setOf(Integer.valueOf(iArr[0]));
    }

    public static final Set<Double> union(double[] dArr, Iterable<Double> other) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <R, V> List<V> zip(long[] jArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i5]), other[i5]));
        }
        return arrayList;
    }

    public static final boolean any(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Double, V> associateWith(double[] dArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(dArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (double d : dArr) {
            linkedHashMap.put(Double.valueOf(d), valueSelector.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    public static final int count(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final Long firstOrNull(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                return Long.valueOf(j6);
            }
        }
        return null;
    }

    public static final /* synthetic */ int indexOf(float[] fArr, float f6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (f6 == fArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A joinTo(short[] sArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (short s6 : sArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                buffer.append((CharSequence) lVar.invoke(Short.valueOf(s6)));
            } else {
                buffer.append(String.valueOf((int) s6));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final /* synthetic */ int lastIndexOf(float[] fArr, float f6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (f6 == fArr[length]) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final boolean none(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Short randomOrNull(short[] sArr, S3.f random) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.d(sArr.length)]);
    }

    public static final void sortDescending(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length > 1) {
            AbstractC0151t.sort(fArr);
            reverse(fArr);
        }
    }

    public static final List<Boolean> toMutableList(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z6 : zArr) {
            arrayList.add(Boolean.valueOf(z6));
        }
        return arrayList;
    }

    public static final boolean any(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Boolean> asIterable(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr.length == 0 ? I.emptyList() : new A(zArr, 7);
    }

    public static final InterfaceC0233q asSequence(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr.length == 0 ? W3.z.emptySequence() : new B(zArr, 7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(short[] sArr, O3.l transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(sArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (short s6 : sArr) {
            C1938s c1938s = (C1938s) transform.invoke(Short.valueOf(s6));
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Boolean>> M associateByTo(boolean[] zArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (boolean z6 : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z6)), Boolean.valueOf(z6));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Boolean, ? super V>> M associateWithTo(boolean[] zArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (boolean z6 : zArr) {
            destination.put(Boolean.valueOf(z6), valueSelector.invoke(Boolean.valueOf(z6)));
        }
        return destination;
    }

    public static final int count(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final List<Boolean> filter(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z6));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Boolean>> C filterIndexedTo(boolean[] zArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            boolean z6 = zArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Boolean.valueOf(z6))).booleanValue()) {
                destination.add(Boolean.valueOf(z6));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final List<Boolean> filterNot(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z6 : zArr) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z6));
            }
        }
        return arrayList;
    }

    public static final Float firstOrNull(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                return Float.valueOf(f6);
            }
        }
        return null;
    }

    public static final <R> R foldRight(boolean[] zArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Boolean.valueOf(zArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(boolean[] zArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Boolean.valueOf(zArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final U3.q getIndices(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return new U3.q(0, getLastIndex(zArr), 1);
    }

    public static final int indexOfFirst(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = zArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(zArr[i5]))).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(Boolean.valueOf(zArr[length]))).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Set<Boolean> intersect(boolean[] zArr, Iterable<Boolean> other) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(boolean[] zArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), Boolean.valueOf(zArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(boolean[] zArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (boolean z6 : zArr) {
            destination.add(transform.invoke(Boolean.valueOf(z6)));
        }
        return destination;
    }

    public static final boolean none(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final C1938s partition(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                arrayList.add(Short.valueOf(s6));
            } else {
                arrayList2.add(Short.valueOf(s6));
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    public static final Integer reduceIndexedOrNull(int[] iArr, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iIntValue = ((Number) operation.invoke(Integer.valueOf(i5), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i5]))).intValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Integer.valueOf(iIntValue);
    }

    public static final Integer reduceOrNull(int[] iArr, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                iIntValue = ((Number) operation.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i5]))).intValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Integer.valueOf(iIntValue);
    }

    public static final void shuffle(byte[] bArr, S3.f random) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(bArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            byte b = bArr[lastIndex];
            bArr[lastIndex] = bArr[iD];
            bArr[iD] = b;
        }
    }

    public static final Short singleOrNull(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Short shValueOf = null;
        boolean z6 = false;
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                if (z6) {
                    return null;
                }
                shValueOf = Short.valueOf(s6);
                z6 = true;
            }
        }
        if (z6) {
            return shValueOf;
        }
        return null;
    }

    public static final List<Boolean> slice(boolean[] zArr, U3.q indices) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final char[] sortedArray(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.E.e(cArrCopyOf, "copyOf(...)");
        AbstractC0151t.sort(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final char[] sortedArrayDescending(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.E.e(cArrCopyOf, "copyOf(...)");
        sortDescending(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final Set<Boolean> subtract(boolean[] zArr, Iterable<Boolean> other) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sumBy(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (boolean z6 : zArr) {
            iIntValue += ((Number) selector.invoke(Boolean.valueOf(z6))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z6 : zArr) {
            dDoubleValue += ((Number) selector.invoke(Boolean.valueOf(z6))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z6 : zArr) {
            dDoubleValue += ((Number) selector.invoke(Boolean.valueOf(z6))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (boolean z6 : zArr) {
            iIntValue += ((Number) selector.invoke(Boolean.valueOf(z6))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (boolean z6 : zArr) {
            jLongValue += ((Number) selector.invoke(Boolean.valueOf(z6))).longValue();
        }
        return jLongValue;
    }

    public static final List<Byte> take(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= bArr.length) {
            return toList(bArr);
        }
        if (i5 == 1) {
            return G.listOf(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Byte> takeLast(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = bArr.length;
        if (i5 >= length) {
            return toList(bArr);
        }
        if (i5 == 1) {
            return G.listOf(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(Byte.valueOf(bArr[i6]));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Boolean>> C toCollection(boolean[] zArr, C destination) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (boolean z6 : zArr) {
            destination.add(Boolean.valueOf(z6));
        }
        return destination;
    }

    public static final Set<Boolean> union(boolean[] zArr, Iterable<Boolean> other) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(int[] iArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 : iArr) {
            C1938s c1938s = (C1938s) transform.invoke(Integer.valueOf(i5));
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Boolean, V> associateWith(boolean[] zArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int iMapCapacity = j0.mapCapacity(zArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (boolean z6 : zArr) {
            linkedHashMap.put(Boolean.valueOf(z6), valueSelector.invoke(Boolean.valueOf(z6)));
        }
        return linkedHashMap;
    }

    public static final int count(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final List<Integer> dropWhile(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (int i5 : iArr) {
            if (z6) {
                arrayList.add(Integer.valueOf(i5));
            } else if (!((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                arrayList.add(Integer.valueOf(i5));
                z6 = true;
            }
        }
        return arrayList;
    }

    public static final List<Float> filterIndexed(float[] fArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            float f6 = fArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Float.valueOf(f6))).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    private static final Float findLast(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            float f6 = fArr[length];
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                return Float.valueOf(f6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final float first(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double firstOrNull(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                return Double.valueOf(d);
            }
        }
        return null;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(float[] fArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(float[] fArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (float f6 : fArr) {
            O.addAll(destination, (Iterable) transform.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    public static final /* synthetic */ int indexOf(double[] dArr, double d) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        int length = dArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (d == dArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final float last(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[getLastIndex(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final /* synthetic */ int lastIndexOf(double[] dArr, double d) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (d == dArr[length]) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Short lastOrNull(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            short s6 = sArr[length];
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                return Short.valueOf(s6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final <R> List<R> map(float[] fArr, O3.l transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f6 : fArr) {
            arrayList.add(transform.invoke(Float.valueOf(f6)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(float[] fArr, O3.p transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    private static final <R> R maxOfWithOrNull(int[] iArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Integer.valueOf(iArr[i5]));
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R> R minOfWithOrNull(int[] iArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Integer.valueOf(iArr[i5]));
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final boolean none(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final short random(short[] sArr, S3.f random) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (sArr.length != 0) {
            return sArr[random.d(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer randomOrNull(int[] iArr, S3.f random) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.d(iArr.length)]);
    }

    public static final int reduce(int[] iArr, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length != 0) {
            int iIntValue = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    iIntValue = ((Number) operation.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i5]))).intValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceIndexed(int[] iArr, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length != 0) {
            int iIntValue = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    iIntValue = ((Number) operation.invoke(Integer.valueOf(i5), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i5]))).intValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return iIntValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Long reduceRightIndexedOrNull(long[] jArr, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long jLongValue = jArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            jLongValue = ((Number) operation.invoke(Integer.valueOf(i5), Long.valueOf(jArr[i5]), Long.valueOf(jLongValue))).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static final Long reduceRightOrNull(long[] jArr, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long jLongValue = jArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            jLongValue = ((Number) operation.invoke(Long.valueOf(jArr[i5]), Long.valueOf(jLongValue))).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static void reverse(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(iArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            int i6 = iArr[i5];
            iArr[i5] = iArr[lastIndex];
            iArr[lastIndex] = i6;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public static final List<Float> reversed(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return I.emptyList();
        }
        List<Float> mutableList = toMutableList(fArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    private static final <R> List<R> runningFold(int[] iArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r6);
        for (int i5 : iArr) {
            r6 = (R) operation.invoke(r6, Integer.valueOf(i5));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(int[] iArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r6);
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Integer.valueOf(iArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final float[] sliceArray(float[] fArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        float[] fArr2 = new float[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            fArr2[i5] = fArr[it.next().intValue()];
            i5++;
        }
        return fArr2;
    }

    private static final int sumOfUInt(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (int i5 : iArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(Integer.valueOf(i5))).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (int i5 : iArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(Integer.valueOf(i5))).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final List<Character> toMutableList(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(float[] fArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i5]), other[i5]));
        }
        return arrayList;
    }

    public static final boolean any(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final Iterable<Character> asIterable(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr.length == 0 ? I.emptyList() : new A(cArr, 8);
    }

    public static final InterfaceC0233q asSequence(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr.length == 0 ? W3.z.emptySequence() : new B(cArr, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Long> associateBy(long[] jArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(jArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (long j6 : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j6)), Long.valueOf(j6));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(char[] cArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (char c : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c)), Character.valueOf(c));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(char[] cArr, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (char c : cArr) {
            destination.put(Character.valueOf(c), valueSelector.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    public static final int count(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final List<Long> dropLastWhile(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Long.valueOf(jArr[lastIndex]))).booleanValue()) {
                return take(jArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    public static final List<Character> filter(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C filterIndexedTo(char[] cArr, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            char c = cArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Character.valueOf(c))).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final List<Character> filterNot(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (!((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    public static final Boolean firstOrNull(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                return Boolean.valueOf(z6);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(long[] jArr, O3.l transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(Long.valueOf(j6)));
        }
        return arrayList;
    }

    public static final <R> R foldRight(char[] cArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Character.valueOf(cArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(char[] cArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Character.valueOf(cArr[lastIndex]), r6);
        }
        return r6;
    }

    public static final U3.q getIndices(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return new U3.q(0, getLastIndex(cArr), 1);
    }

    public static final int indexOfFirst(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = cArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (((Boolean) predicate.invoke(Character.valueOf(cArr[i5]))).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) predicate.invoke(Character.valueOf(cArr[length]))).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Set<Character> intersect(char[] cArr, Iterable<Character> other) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        O.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(char[] cArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            destination.add(transform.invoke(Integer.valueOf(i6), Character.valueOf(cArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(char[] cArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (char c : cArr) {
            destination.add(transform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    public static final <R extends Comparable<? super R>> Short maxByOrNull(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s6 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s6);
        }
        Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s7 = sArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s7));
                if (comparable.compareTo(comparable2) < 0) {
                    s6 = s7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(s6);
    }

    public static final <R extends Comparable<? super R>> short maxByOrThrow(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            short s6 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s6));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        short s7 = sArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s7));
                        if (comparable.compareTo(comparable2) < 0) {
                            s6 = s7;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return s6;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> Short minByOrNull(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s6 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s6);
        }
        Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s7 = sArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s7));
                if (comparable.compareTo(comparable2) > 0) {
                    s6 = s7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(s6);
    }

    public static final <R extends Comparable<? super R>> short minByOrThrow(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            short s6 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s6));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        short s7 = sArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s7));
                        if (comparable.compareTo(comparable2) > 0) {
                            s6 = s7;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return s6;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final long reduceRight(long[] jArr, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long jLongValue = jArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                jLongValue = ((Number) operation.invoke(Long.valueOf(jArr[i5]), Long.valueOf(jLongValue))).longValue();
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceRightIndexed(long[] jArr, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long jLongValue = jArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                jLongValue = ((Number) operation.invoke(Integer.valueOf(i5), Long.valueOf(jArr[i5]), Long.valueOf(jLongValue))).longValue();
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static long[] reversedArray(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                jArr2[lastIndex - i5] = jArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return jArr2;
    }

    public static long single(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Character> slice(char[] cArr, U3.q indices) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? I.emptyList() : AbstractC0151t.asList(AbstractC0151t.copyOfRange(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length > 1) {
            AbstractC0151t.sort(dArr);
            reverse(dArr);
        }
    }

    public static final Set<Character> subtract(char[] cArr, Iterable<Character> other) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        O.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final int sumBy(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (char c : cArr) {
            iIntValue += ((Number) selector.invoke(Character.valueOf(c))).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (char c : cArr) {
            dDoubleValue += ((Number) selector.invoke(Character.valueOf(c))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (char c : cArr) {
            dDoubleValue += ((Number) selector.invoke(Character.valueOf(c))).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (char c : cArr) {
            iIntValue += ((Number) selector.invoke(Character.valueOf(c))).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (char c : cArr) {
            jLongValue += ((Number) selector.invoke(Character.valueOf(c))).longValue();
        }
        return jLongValue;
    }

    public static final List<Long> takeLastWhile(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Long.valueOf(jArr[lastIndex]))).booleanValue()) {
                return drop(jArr, lastIndex + 1);
            }
        }
        return toList(jArr);
    }

    public static final List<Long> takeWhile(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            if (!((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j6));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C toCollection(char[] cArr, C destination) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (char c : cArr) {
            destination.add(Character.valueOf(c));
        }
        return destination;
    }

    public static final List<Long> toList(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return I.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return G.listOf(Long.valueOf(jArr[0]));
    }

    public static final Set<Long> toSet(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            return w0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(jArr, new LinkedHashSet(j0.mapCapacity(jArr.length)));
        }
        return v0.setOf(Long.valueOf(jArr[0]));
    }

    public static final Set<Character> union(char[] cArr, Iterable<Character> other) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        O.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean any(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> Map<Character, V> associateWith(char[] cArr, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int length = cArr.length;
        if (length > 128) {
            length = 128;
        }
        int iMapCapacity = j0.mapCapacity(length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (char c : cArr) {
            linkedHashMap.put(Character.valueOf(c), valueSelector.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    public static final int count(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final Character firstOrNull(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                return Character.valueOf(c);
            }
        }
        return null;
    }

    public static final int indexOf(boolean[] zArr, boolean z6) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        int length = zArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (z6 == zArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(boolean[] zArr, boolean z6) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (z6 == zArr[length]) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Byte maxOrNull(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b6 = bArr[i5];
                if (b < b6) {
                    b = b6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(b);
    }

    public static final Integer maxWithOrNull(int[] iArr, Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i5 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i6 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i7 = iArr[i6];
                if (comparator.compare(Integer.valueOf(i5), Integer.valueOf(i7)) < 0) {
                    i5 = i7;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        return Integer.valueOf(i5);
    }

    public static final Byte minOrNull(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b6 = bArr[i5];
                if (b > b6) {
                    b = b6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(b);
    }

    public static final Integer minWithOrNull(int[] iArr, Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i5 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i6 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i7 = iArr[i6];
                if (comparator.compare(Integer.valueOf(i5), Integer.valueOf(i7)) > 0) {
                    i5 = i7;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        return Integer.valueOf(i5);
    }

    public static final boolean none(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final Long randomOrNull(long[] jArr, S3.f random) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.d(jArr.length)]);
    }

    public static final Integer singleOrNull(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Integer numValueOf = null;
        boolean z6 = false;
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                if (z6) {
                    return null;
                }
                numValueOf = Integer.valueOf(i5);
                z6 = true;
            }
        }
        if (z6) {
            return numValueOf;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(T[] tArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (T t6 : tArr) {
            destination.put(keySelector.invoke(t6), valueTransform.invoke(t6));
        }
        return destination;
    }

    public static final <K> List<Integer> distinctBy(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (hashSet.add(selector.invoke(Integer.valueOf(i5)))) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        return arrayList;
    }

    public static final List<Short> drop(short[] sArr, int i5) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (i5 >= 0) {
            int length = sArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return takeLast(sArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Short> dropLast(short[] sArr, int i5) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (i5 >= 0) {
            int length = sArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return take(sArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Double> filterIndexed(double[] dArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            double d = dArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    private static final Double findLast(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            double d = dArr[length];
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                return Double.valueOf(d);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final double first(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(double[] dArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Double.valueOf(dArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(double[] dArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (double d : dArr) {
            O.addAll(destination, (Iterable) transform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, List<Short>>> M groupByTo(short[] sArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (short s6 : sArr) {
            Object objInvoke = keySelector.invoke(Short.valueOf(s6));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Short.valueOf(s6));
        }
        return destination;
    }

    public static final double last(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[getLastIndex(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Integer lastOrNull(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            int i6 = iArr[length];
            if (((Boolean) predicate.invoke(Integer.valueOf(i6))).booleanValue()) {
                return Integer.valueOf(i6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final <R> List<R> map(double[] dArr, O3.l transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(transform.invoke(Double.valueOf(d)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(double[] dArr, O3.p transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Double.valueOf(dArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    private static final double maxOf(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).doubleValue();
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Integer.valueOf(iArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m24maxOfOrNull(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).doubleValue();
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Integer.valueOf(iArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(int[] iArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            R r6 = (Object) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Integer.valueOf(iArr[i5]));
                    if (comparator.compare(r6, objInvoke) < 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final byte maxOrThrow(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte b6 = bArr[i5];
                    if (b < b6) {
                        b = b6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    public static final int maxWithOrThrow(int[] iArr, Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (iArr.length != 0) {
            int i5 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i7 = iArr[i6];
                    if (comparator.compare(Integer.valueOf(i5), Integer.valueOf(i7)) < 0) {
                        i5 = i7;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            return i5;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).doubleValue();
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Integer.valueOf(iArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m60minOfOrNull(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).doubleValue();
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Integer.valueOf(iArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(int[] iArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            R r6 = (Object) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Integer.valueOf(iArr[i5]));
                    if (comparator.compare(r6, objInvoke) > 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final byte minOrThrow(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    byte b6 = bArr[i5];
                    if (b > b6) {
                        b = b6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    public static final int minWithOrThrow(int[] iArr, Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (iArr.length != 0) {
            int i5 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i7 = iArr[i6];
                    if (comparator.compare(Integer.valueOf(i5), Integer.valueOf(i7)) > 0) {
                        i5 = i7;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            return i5;
        }
        throw new NoSuchElementException();
    }

    public static final int random(int[] iArr, S3.f random) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (iArr.length != 0) {
            return iArr[random.d(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List<Double> reversed(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return I.emptyList();
        }
        List<Double> mutableList = toMutableList(dArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    private static final List<Integer> runningReduce(int[] iArr, O3.p operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length == 0) {
            return I.emptyList();
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            iIntValue = ((Number) operation.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i5]))).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    private static final List<Integer> runningReduceIndexed(int[] iArr, O3.q operation) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (iArr.length == 0) {
            return I.emptyList();
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            iIntValue = ((Number) operation.invoke(Integer.valueOf(i5), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i5]))).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    public static final <T> List<T> slice(T[] tArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(tArr[it.next().intValue()]);
        }
        return arrayList;
    }

    public static final double[] sliceArray(double[] dArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        double[] dArr2 = new double[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            dArr2[i5] = dArr[it.next().intValue()];
            i5++;
        }
        return dArr2;
    }

    public static final double sumOfDouble(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        double dDoubleValue = 0.0d;
        for (Double d : dArr) {
            dDoubleValue += d.doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfInt(Integer[] numArr) {
        kotlin.jvm.internal.E.f(numArr, "<this>");
        int iIntValue = 0;
        for (Integer num : numArr) {
            iIntValue += num.intValue();
        }
        return iIntValue;
    }

    public static final long sumOfLong(Long[] lArr) {
        kotlin.jvm.internal.E.f(lArr, "<this>");
        long jLongValue = 0;
        for (Long l6 : lArr) {
            jLongValue += l6.longValue();
        }
        return jLongValue;
    }

    public static final <R, V> List<V> zip(double[] dArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i5]), other[i5]));
        }
        return arrayList;
    }

    public static final int indexOf(char[] cArr, char c) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = cArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (c == cArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(char[] cArr, char c) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (c == cArr[length]) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static final Float randomOrNull(float[] fArr, S3.f random) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.d(fArr.length)]);
    }

    public static final Long reduceIndexedOrNull(long[] jArr, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jLongValue = ((Number) operation.invoke(Integer.valueOf(i5), Long.valueOf(jLongValue), Long.valueOf(jArr[i5]))).longValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(jLongValue);
    }

    public static final Long reduceOrNull(long[] jArr, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                jLongValue = ((Number) operation.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i5]))).longValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(jLongValue);
    }

    public static final Float reduceRightIndexedOrNull(float[] fArr, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float fFloatValue = fArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            fFloatValue = ((Number) operation.invoke(Integer.valueOf(i5), Float.valueOf(fArr[i5]), Float.valueOf(fFloatValue))).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Float reduceRightOrNull(float[] fArr, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float fFloatValue = fArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            fFloatValue = ((Number) operation.invoke(Float.valueOf(fArr[i5]), Float.valueOf(fFloatValue))).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static final void shuffle(short[] sArr, S3.f random) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(sArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            short s6 = sArr[lastIndex];
            sArr[lastIndex] = sArr[iD];
            sArr[iD] = s6;
        }
    }

    public static final void sortDescending(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length > 1) {
            AbstractC0151t.sort(cArr);
            reverse(cArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Float> associateBy(float[] fArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(fArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (float f6 : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f6)), Float.valueOf(f6));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(byte[] bArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (byte b : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b)), valueTransform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(long[] jArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (long j6 : jArr) {
            C1938s c1938s = (C1938s) transform.invoke(Long.valueOf(j6));
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    public static final List<Float> dropLastWhile(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(fArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Float.valueOf(fArr[lastIndex]))).booleanValue()) {
                return take(fArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    public static final List<Long> dropWhile(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (long j6 : jArr) {
            if (z6) {
                arrayList.add(Long.valueOf(j6));
            } else if (!((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
                z6 = true;
            }
        }
        return arrayList;
    }

    public static final <R> List<R> flatMap(float[] fArr, O3.l transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(Float.valueOf(f6)));
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Short>> groupBy(short[] sArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s6 : sArr) {
            Object objInvoke = keySelector.invoke(Short.valueOf(s6));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Short.valueOf(s6));
        }
        return linkedHashMap;
    }

    public static final <A extends Appendable> A joinTo(int[] iArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (int i7 : iArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                buffer.append((CharSequence) lVar.invoke(Integer.valueOf(i7)));
            } else {
                buffer.append(String.valueOf(i7));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    private static final <R> R maxOfWithOrNull(long[] jArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Long.valueOf(jArr[i5]));
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R> R minOfWithOrNull(long[] jArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Long.valueOf(jArr[i5]));
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final long reduce(long[] jArr, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length != 0) {
            long jLongValue = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    jLongValue = ((Number) operation.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i5]))).longValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceIndexed(long[] jArr, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length != 0) {
            long jLongValue = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    jLongValue = ((Number) operation.invoke(Integer.valueOf(i5), Long.valueOf(jLongValue), Long.valueOf(jArr[i5]))).longValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return jLongValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRight(float[] fArr, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float fFloatValue = fArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                fFloatValue = ((Number) operation.invoke(Float.valueOf(fArr[i5]), Float.valueOf(fFloatValue))).floatValue();
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRightIndexed(float[] fArr, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float fFloatValue = fArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                fFloatValue = ((Number) operation.invoke(Integer.valueOf(i5), Float.valueOf(fArr[i5]), Float.valueOf(fFloatValue))).floatValue();
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static void reverse(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(jArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr[i5];
            jArr[i5] = jArr[lastIndex];
            jArr[lastIndex] = j6;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public static final float[] reversedArray(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                fArr2[lastIndex - i5] = fArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return fArr2;
    }

    private static final <R> List<R> runningFold(long[] jArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r6);
        for (long j6 : jArr) {
            r6 = (R) operation.invoke(r6, Long.valueOf(j6));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(long[] jArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r6);
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Long.valueOf(jArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final float single(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return fArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Long singleOrNull(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Long lValueOf = null;
        boolean z6 = false;
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                if (z6) {
                    return null;
                }
                lValueOf = Long.valueOf(j6);
                z6 = true;
            }
        }
        if (z6) {
            return lValueOf;
        }
        return null;
    }

    private static final int sumOfUInt(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (long j6 : jArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(Long.valueOf(j6))).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (long j6 : jArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(Long.valueOf(j6))).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final List<Float> takeLastWhile(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(fArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Float.valueOf(fArr[lastIndex]))).booleanValue()) {
                return drop(fArr, lastIndex + 1);
            }
        }
        return toList(fArr);
    }

    public static final List<Float> takeWhile(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            if (!((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f6));
        }
        return arrayList;
    }

    public static final List<Float> toList(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return I.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return G.listOf(Float.valueOf(fArr[0]));
    }

    public static final Set<Float> toSet(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return w0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(fArr, new LinkedHashSet(j0.mapCapacity(fArr.length)));
        }
        return v0.setOf(Float.valueOf(fArr[0]));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(int[] iArr, O3.l transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(iArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 : iArr) {
            C1938s c1938s = (C1938s) transform.invoke(Integer.valueOf(i5));
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    public static final List<Boolean> filterIndexed(boolean[] zArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            boolean z6 = zArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Boolean.valueOf(z6))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z6));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    private static final Boolean findLast(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            boolean z6 = zArr[length];
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                return Boolean.valueOf(z6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final boolean first(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(boolean[] zArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Boolean.valueOf(zArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(boolean[] zArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (boolean z6 : zArr) {
            O.addAll(destination, (Iterable) transform.invoke(Boolean.valueOf(z6)));
        }
        return destination;
    }

    public static final boolean last(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[getLastIndex(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Long lastOrNull(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            long j6 = jArr[length];
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                return Long.valueOf(j6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final <R> List<R> map(boolean[] zArr, O3.l transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z6 : zArr) {
            arrayList.add(transform.invoke(Boolean.valueOf(z6)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(boolean[] zArr, O3.p transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Boolean.valueOf(zArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final C1938s partition(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                arrayList.add(Integer.valueOf(i5));
            } else {
                arrayList2.add(Integer.valueOf(i5));
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    public static final long random(long[] jArr, S3.f random) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (jArr.length != 0) {
            return jArr[random.d(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double randomOrNull(double[] dArr, S3.f random) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[random.d(dArr.length)]);
    }

    public static final List<Boolean> reversed(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (zArr.length == 0) {
            return I.emptyList();
        }
        List<Boolean> mutableList = toMutableList(zArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    public static final boolean[] sliceArray(boolean[] zArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        boolean[] zArr2 = new boolean[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            zArr2[i5] = zArr[it.next().intValue()];
            i5++;
        }
        return zArr2;
    }

    public static final <R, V> List<V> zip(boolean[] zArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i5]), other[i5]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(short[] sArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (short s6 : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s6)), valueTransform.invoke(Short.valueOf(s6)));
        }
        return destination;
    }

    public static final Short maxOrNull(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s6 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s7 = sArr[i5];
                if (s6 < s7) {
                    s6 = s7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(s6);
    }

    public static final Short minOrNull(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s6 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s7 = sArr[i5];
                if (s6 > s7) {
                    s6 = s7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(s6);
    }

    public static final <T extends Comparable<? super T>> void sortDescending(T[] tArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        AbstractC0151t.sortWith(tArr, D3.g.reverseOrder(), i5, i6);
    }

    public static final short maxOrThrow(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length != 0) {
            short s6 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short s7 = sArr[i5];
                    if (s6 < s7) {
                        s6 = s7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return s6;
        }
        throw new NoSuchElementException();
    }

    public static final Long maxWithOrNull(long[] jArr, Comparator<? super Long> comparator) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j7 = jArr[i5];
                if (comparator.compare(Long.valueOf(j6), Long.valueOf(j7)) < 0) {
                    j6 = j7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final short minOrThrow(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length != 0) {
            short s6 = sArr[0];
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    short s7 = sArr[i5];
                    if (s6 > s7) {
                        s6 = s7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return s6;
        }
        throw new NoSuchElementException();
    }

    public static final Long minWithOrNull(long[] jArr, Comparator<? super Long> comparator) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j7 = jArr[i5];
                if (comparator.compare(Long.valueOf(j6), Long.valueOf(j7)) > 0) {
                    j6 = j7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final Boolean randomOrNull(boolean[] zArr, S3.f random) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[random.d(zArr.length)]);
    }

    public static final Double reduceRightIndexedOrNull(double[] dArr, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double dDoubleValue = dArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i5), Double.valueOf(dArr[i5]), Double.valueOf(dDoubleValue))).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Double reduceRightOrNull(double[] dArr, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double dDoubleValue = dArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            dDoubleValue = ((Number) operation.invoke(Double.valueOf(dArr[i5]), Double.valueOf(dDoubleValue))).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Float singleOrNull(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Float fValueOf = null;
        boolean z6 = false;
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                if (z6) {
                    return null;
                }
                fValueOf = Float.valueOf(f6);
                z6 = true;
            }
        }
        if (z6) {
            return fValueOf;
        }
        return null;
    }

    public static final List<Byte> slice(byte[] bArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final void sortDescending(byte[] bArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        AbstractC0151t.sort(bArr, i5, i6);
        reverse(bArr, i5, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Double> associateBy(double[] dArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(dArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (double d : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d)), Double.valueOf(d));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(int[] iArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (int i5 : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i5)), valueTransform.invoke(Integer.valueOf(i5)));
        }
        return destination;
    }

    public static final <K> List<Long> distinctBy(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j6 : jArr) {
            if (hashSet.add(selector.invoke(Long.valueOf(j6)))) {
                arrayList.add(Long.valueOf(j6));
            }
        }
        return arrayList;
    }

    public static final List<Double> dropLastWhile(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(dArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Double.valueOf(dArr[lastIndex]))).booleanValue()) {
                return take(dArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    public static final List<Character> filterIndexed(char[] cArr, O3.p predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            char c = cArr[i5];
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    private static final Character findLast(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            char c = cArr[length];
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                return Character.valueOf(c);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final char first(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <R> List<R> flatMap(double[] dArr, O3.l transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(Double.valueOf(d)));
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(char[] cArr, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Character.valueOf(cArr[i5])));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(char[] cArr, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (char c : cArr) {
            O.addAll(destination, (Iterable) transform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    public static final char last(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[getLastIndex(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Float lastOrNull(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            float f6 = fArr[length];
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                return Float.valueOf(f6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final <R> List<R> map(char[] cArr, O3.l transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(transform.invoke(Character.valueOf(c)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(char[] cArr, O3.p transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Character.valueOf(cArr[i5])));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> int maxByOrThrow(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            int i5 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i5));
                int i6 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        int i7 = iArr[i6];
                        Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i7));
                        if (comparable.compareTo(comparable2) < 0) {
                            i5 = i7;
                            comparable = comparable2;
                        }
                        if (i6 == lastIndex) {
                            break;
                        }
                        i6++;
                    }
                }
            }
            return i5;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).doubleValue();
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Long.valueOf(jArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m25maxOfOrNull(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).doubleValue();
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Long.valueOf(jArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(long[] jArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            R r6 = (Object) selector.invoke(Long.valueOf(jArr[0]));
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Long.valueOf(jArr[i5]));
                    if (comparator.compare(r6, objInvoke) < 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final long maxWithOrThrow(long[] jArr, Comparator<? super Long> comparator) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (jArr.length != 0) {
            long j6 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long j7 = jArr[i5];
                    if (comparator.compare(Long.valueOf(j6), Long.valueOf(j7)) < 0) {
                        j6 = j7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return j6;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> int minByOrThrow(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            int i5 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i5));
                int i6 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        int i7 = iArr[i6];
                        Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i7));
                        if (comparable.compareTo(comparable2) > 0) {
                            i5 = i7;
                            comparable = comparable2;
                        }
                        if (i6 == lastIndex) {
                            break;
                        }
                        i6++;
                    }
                }
            }
            return i5;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).doubleValue();
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Long.valueOf(jArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m61minOfOrNull(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).doubleValue();
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Long.valueOf(jArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(long[] jArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            R r6 = (Object) selector.invoke(Long.valueOf(jArr[0]));
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Long.valueOf(jArr[i5]));
                    if (comparator.compare(r6, objInvoke) > 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final long minWithOrThrow(long[] jArr, Comparator<? super Long> comparator) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (jArr.length != 0) {
            long j6 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long j7 = jArr[i5];
                    if (comparator.compare(Long.valueOf(j6), Long.valueOf(j7)) > 0) {
                        j6 = j7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return j6;
        }
        throw new NoSuchElementException();
    }

    public static final float random(float[] fArr, S3.f random) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (fArr.length != 0) {
            return fArr[random.d(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Float reduceIndexedOrNull(float[] fArr, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = ((Number) operation.invoke(Integer.valueOf(i5), Float.valueOf(fFloatValue), Float.valueOf(fArr[i5]))).floatValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final Float reduceOrNull(float[] fArr, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = ((Number) operation.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i5]))).floatValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final double reduceRight(double[] dArr, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double dDoubleValue = dArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                dDoubleValue = ((Number) operation.invoke(Double.valueOf(dArr[i5]), Double.valueOf(dDoubleValue))).doubleValue();
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceRightIndexed(double[] dArr, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double dDoubleValue = dArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i5), Double.valueOf(dArr[i5]), Double.valueOf(dDoubleValue))).doubleValue();
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final List<Character> reversed(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 0) {
            return I.emptyList();
        }
        List<Character> mutableList = toMutableList(cArr);
        Q.reverse(mutableList);
        return mutableList;
    }

    public static final double[] reversedArray(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                dArr2[lastIndex - i5] = dArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dArr2;
    }

    private static final List<Long> runningReduce(long[] jArr, O3.p operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length == 0) {
            return I.emptyList();
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            jLongValue = ((Number) operation.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i5]))).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    private static final List<Long> runningReduceIndexed(long[] jArr, O3.q operation) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (jArr.length == 0) {
            return I.emptyList();
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            jLongValue = ((Number) operation.invoke(Integer.valueOf(i5), Long.valueOf(jLongValue), Long.valueOf(jArr[i5]))).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    public static final void shuffle(int[] iArr, S3.f random) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(iArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            int i5 = iArr[lastIndex];
            iArr[lastIndex] = iArr[iD];
            iArr[iD] = i5;
        }
    }

    public static final double single(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return dArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final char[] sliceArray(char[] cArr, Collection<Integer> indices) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        char[] cArr2 = new char[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            cArr2[i5] = cArr[it.next().intValue()];
            i5++;
        }
        return cArr2;
    }

    public static final List<Double> takeLastWhile(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(dArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Double.valueOf(dArr[lastIndex]))).booleanValue()) {
                return drop(dArr, lastIndex + 1);
            }
        }
        return toList(dArr);
    }

    public static final List<Double> takeWhile(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (!((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static final List<Double> toList(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return I.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return G.listOf(Double.valueOf(dArr[0]));
    }

    public static final Set<Double> toSet(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            return w0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(dArr, new LinkedHashSet(j0.mapCapacity(dArr.length)));
        }
        return v0.setOf(Double.valueOf(dArr[0]));
    }

    public static final <R, V> List<V> zip(char[] cArr, R[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i5]), other[i5]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(float[] fArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (float f6 : fArr) {
            C1938s c1938s = (C1938s) transform.invoke(Float.valueOf(f6));
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    public static final List<Float> dropWhile(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (float f6 : fArr) {
            if (z6) {
                arrayList.add(Float.valueOf(f6));
            } else if (!((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
                z6 = true;
            }
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> Integer maxByOrNull(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i5 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i5);
        }
        Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i5));
        int i6 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i7 = iArr[i6];
                Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i7));
                if (comparable.compareTo(comparable2) < 0) {
                    i5 = i7;
                    comparable = comparable2;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        return Integer.valueOf(i5);
    }

    private static final <R> R maxOfWithOrNull(float[] fArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Float.valueOf(fArr[i5]));
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <R extends Comparable<? super R>> Integer minByOrNull(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i5 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i5);
        }
        Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i5));
        int i6 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i7 = iArr[i6];
                Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i7));
                if (comparable.compareTo(comparable2) > 0) {
                    i5 = i7;
                    comparable = comparable2;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        return Integer.valueOf(i5);
    }

    private static final <R> R minOfWithOrNull(float[] fArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Float.valueOf(fArr[i5]));
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Character randomOrNull(char[] cArr, S3.f random) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[random.d(cArr.length)]);
    }

    public static final float reduce(float[] fArr, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length != 0) {
            float fFloatValue = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = ((Number) operation.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i5]))).floatValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceIndexed(float[] fArr, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length != 0) {
            float fFloatValue = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = ((Number) operation.invoke(Integer.valueOf(i5), Float.valueOf(fFloatValue), Float.valueOf(fArr[i5]))).floatValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(fArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            float f6 = fArr[i5];
            fArr[i5] = fArr[lastIndex];
            fArr[lastIndex] = f6;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private static final <R> List<R> runningFold(float[] fArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r6);
        for (float f6 : fArr) {
            r6 = (R) operation.invoke(r6, Float.valueOf(f6));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(float[] fArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r6);
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Float.valueOf(fArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final void sortDescending(short[] sArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        AbstractC0151t.sort(sArr, i5, i6);
        reverse(sArr, i5, i6);
    }

    private static final int sumOfUInt(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (float f6 : fArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(Float.valueOf(f6))).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (float f6 : fArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(Float.valueOf(f6))).f9126a);
        }
        return jM1247constructorimpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(long[] jArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (long j6 : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j6)), valueTransform.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    public static final Double singleOrNull(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Double dValueOf = null;
        boolean z6 = false;
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                if (z6) {
                    return null;
                }
                dValueOf = Double.valueOf(d);
                z6 = true;
            }
        }
        if (z6) {
            return dValueOf;
        }
        return null;
    }

    public static final List<Integer> drop(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (i5 >= 0) {
            int length = iArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return takeLast(iArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Integer> dropLast(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (i5 >= 0) {
            int length = iArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return take(iArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final <T> T first(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (T t6 : tArr) {
            if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <K, M extends Map<? super K, List<Integer>>> M groupByTo(int[] iArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (int i5 : iArr) {
            Object objInvoke = keySelector.invoke(Integer.valueOf(i5));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Integer.valueOf(i5));
        }
        return destination;
    }

    public static final <A extends Appendable> A joinTo(long[] jArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (long j6 : jArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                buffer.append((CharSequence) lVar.invoke(Long.valueOf(j6)));
            } else {
                buffer.append(String.valueOf(j6));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> T last(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                T t6 = tArr[length];
                if (((Boolean) predicate.invoke(t6)).booleanValue()) {
                    return t6;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Double lastOrNull(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            double d = dArr[length];
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                return Double.valueOf(d);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final Integer maxOrNull(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i5 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i6 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i7 = iArr[i6];
                if (i5 < i7) {
                    i5 = i7;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        return Integer.valueOf(i5);
    }

    public static final Integer minOrNull(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i5 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        int i6 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i7 = iArr[i6];
                if (i5 > i7) {
                    i5 = i7;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        return Integer.valueOf(i5);
    }

    public static final double random(double[] dArr, S3.f random) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (dArr.length != 0) {
            return dArr[random.d(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Boolean reduceRightIndexedOrNull(boolean[] zArr, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            zBooleanValue = ((Boolean) operation.invoke(Integer.valueOf(i5), Boolean.valueOf(zArr[i5]), Boolean.valueOf(zBooleanValue))).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final Boolean reduceRightOrNull(boolean[] zArr, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            zBooleanValue = ((Boolean) operation.invoke(Boolean.valueOf(zArr[i5]), Boolean.valueOf(zBooleanValue))).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final <T> T[] sliceArray(T[] tArr, U3.q indices) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? (T[]) AbstractC0151t.copyOfRange(tArr, 0, 0) : (T[]) AbstractC0151t.copyOfRange(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static void sortDescending(int[] iArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        AbstractC0151t.sort(iArr, i5, i6);
        reverse(iArr, i5, i6);
    }

    public static final <T, R, V> List<V> zip(T[] tArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(tArr[i5], r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(long[] jArr, O3.l transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(jArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (long j6 : jArr) {
            C1938s c1938s = (C1938s) transform.invoke(Long.valueOf(j6));
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Boolean> associateBy(boolean[] zArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(zArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (boolean z6 : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z6)), Boolean.valueOf(z6));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(float[] fArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (float f6 : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f6)), valueTransform.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    public static final List<Boolean> dropLastWhile(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(zArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(zArr[lastIndex]))).booleanValue()) {
                return take(zArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    public static final <R> List<R> flatMap(boolean[] zArr, O3.l transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z6 : zArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(Boolean.valueOf(z6)));
        }
        return arrayList;
    }

    public static final int maxOrThrow(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length != 0) {
            int i5 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i7 = iArr[i6];
                    if (i5 < i7) {
                        i5 = i7;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            return i5;
        }
        throw new NoSuchElementException();
    }

    public static final int minOrThrow(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length != 0) {
            int i5 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i7 = iArr[i6];
                    if (i5 > i7) {
                        i5 = i7;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            return i5;
        }
        throw new NoSuchElementException();
    }

    public static final C1938s partition(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                arrayList.add(Long.valueOf(j6));
            } else {
                arrayList2.add(Long.valueOf(j6));
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    public static final boolean reduceRight(boolean[] zArr, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean zBooleanValue = zArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                zBooleanValue = ((Boolean) operation.invoke(Boolean.valueOf(zArr[i5]), Boolean.valueOf(zBooleanValue))).booleanValue();
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceRightIndexed(boolean[] zArr, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean zBooleanValue = zArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                zBooleanValue = ((Boolean) operation.invoke(Integer.valueOf(i5), Boolean.valueOf(zArr[i5]), Boolean.valueOf(zBooleanValue))).booleanValue();
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean[] reversedArray(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                zArr2[lastIndex - i5] = zArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return zArr2;
    }

    public static final boolean single(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Short> slice(short[] sArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Short> take(short[] sArr, int i5) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= sArr.length) {
            return toList(sArr);
        }
        if (i5 == 1) {
            return G.listOf(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (short s6 : sArr) {
            arrayList.add(Short.valueOf(s6));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Short> takeLast(short[] sArr, int i5) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = sArr.length;
        if (i5 >= length) {
            return toList(sArr);
        }
        if (i5 == 1) {
            return G.listOf(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(Short.valueOf(sArr[i6]));
        }
        return arrayList;
    }

    public static final List<Boolean> takeLastWhile(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(zArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(zArr[lastIndex]))).booleanValue()) {
                return drop(zArr, lastIndex + 1);
            }
        }
        return toList(zArr);
    }

    public static final List<Boolean> takeWhile(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z6 : zArr) {
            if (!((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z6));
        }
        return arrayList;
    }

    public static final List<Boolean> toList(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return I.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return G.listOf(Boolean.valueOf(zArr[0]));
    }

    public static final Set<Boolean> toSet(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return w0.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(zArr, new LinkedHashSet(j0.mapCapacity(zArr.length)));
        }
        return v0.setOf(Boolean.valueOf(zArr[0]));
    }

    public static final byte first(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                return b;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Float maxWithOrNull(float[] fArr, Comparator<? super Float> comparator) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f7 = fArr[i5];
                if (comparator.compare(Float.valueOf(f6), Float.valueOf(f7)) < 0) {
                    f6 = f7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(f6);
    }

    public static final Float minWithOrNull(float[] fArr, Comparator<? super Float> comparator) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f7 = fArr[i5];
                if (comparator.compare(Float.valueOf(f6), Float.valueOf(f7)) > 0) {
                    f6 = f7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(f6);
    }

    public static final Double reduceIndexedOrNull(double[] dArr, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i5), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i5]))).doubleValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final Double reduceOrNull(double[] dArr, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = ((Number) operation.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i5]))).doubleValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final void shuffle(long[] jArr, S3.f random) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(jArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            long j6 = jArr[lastIndex];
            jArr[lastIndex] = jArr[iD];
            jArr[iD] = j6;
        }
    }

    public static final Boolean singleOrNull(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Boolean boolValueOf = null;
        boolean z6 = false;
        for (boolean z7 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z7))).booleanValue()) {
                if (z6) {
                    return null;
                }
                boolValueOf = Boolean.valueOf(z7);
                z6 = true;
            }
        }
        if (z6) {
            return boolValueOf;
        }
        return null;
    }

    public static byte[] sliceArray(byte[] bArr, U3.q indices) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? new byte[0] : AbstractC0151t.copyOfRange(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static void sortDescending(long[] jArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        AbstractC0151t.sort(jArr, i5, i6);
        reverse(jArr, i5, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(double[] dArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (double d : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d)), valueTransform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(double[] dArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (double d : dArr) {
            C1938s c1938s = (C1938s) transform.invoke(Double.valueOf(d));
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    public static final <K> List<Float> distinctBy(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f6 : fArr) {
            if (hashSet.add(selector.invoke(Float.valueOf(f6)))) {
                arrayList.add(Float.valueOf(f6));
            }
        }
        return arrayList;
    }

    public static final List<Double> dropWhile(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (double d : dArr) {
            if (z6) {
                arrayList.add(Double.valueOf(d));
            } else if (!((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
                z6 = true;
            }
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Integer>> groupBy(int[] iArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i5 : iArr) {
            Object objInvoke = keySelector.invoke(Integer.valueOf(i5));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Integer.valueOf(i5));
        }
        return linkedHashMap;
    }

    public static final Boolean lastOrNull(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            boolean z6 = zArr[length];
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                return Boolean.valueOf(z6);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    private static final double maxOf(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).doubleValue();
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Float.valueOf(fArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m23maxOfOrNull(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).doubleValue();
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Float.valueOf(fArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(float[] fArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            R r6 = (Object) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Float.valueOf(fArr[i5]));
                    if (comparator.compare(r6, objInvoke) < 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    private static final <R> R maxOfWithOrNull(double[] dArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Double.valueOf(dArr[i5]));
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final float maxWithOrThrow(float[] fArr, Comparator<? super Float> comparator) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (fArr.length != 0) {
            float f6 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    float f7 = fArr[i5];
                    if (comparator.compare(Float.valueOf(f6), Float.valueOf(f7)) < 0) {
                        f6 = f7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return f6;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).doubleValue();
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Float.valueOf(fArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m59minOfOrNull(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).doubleValue();
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Float.valueOf(fArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(float[] fArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            R r6 = (Object) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Float.valueOf(fArr[i5]));
                    if (comparator.compare(r6, objInvoke) > 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    private static final <R> R minOfWithOrNull(double[] dArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Double.valueOf(dArr[i5]));
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final float minWithOrThrow(float[] fArr, Comparator<? super Float> comparator) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (fArr.length != 0) {
            float f6 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    float f7 = fArr[i5];
                    if (comparator.compare(Float.valueOf(f6), Float.valueOf(f7)) > 0) {
                        f6 = f7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return f6;
        }
        throw new NoSuchElementException();
    }

    public static final boolean random(boolean[] zArr, S3.f random) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (zArr.length != 0) {
            return zArr[random.d(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final double reduce(double[] dArr, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length != 0) {
            double dDoubleValue = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = ((Number) operation.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i5]))).doubleValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceIndexed(double[] dArr, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length != 0) {
            double dDoubleValue = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i5), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i5]))).doubleValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(dArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            double d = dArr[i5];
            dArr[i5] = dArr[lastIndex];
            dArr[lastIndex] = d;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private static final <R> List<R> runningFold(double[] dArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r6);
        for (double d : dArr) {
            r6 = (R) operation.invoke(r6, Double.valueOf(d));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(double[] dArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r6);
        int length = dArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Double.valueOf(dArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final List<Float> runningReduce(float[] fArr, O3.p operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length == 0) {
            return I.emptyList();
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            fFloatValue = ((Number) operation.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i5]))).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    private static final List<Float> runningReduceIndexed(float[] fArr, O3.q operation) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (fArr.length == 0) {
            return I.emptyList();
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            fFloatValue = ((Number) operation.invoke(Integer.valueOf(i5), Float.valueOf(fFloatValue), Float.valueOf(fArr[i5]))).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    private static final int sumOfUInt(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (double d : dArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(Double.valueOf(d))).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (double d : dArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(Double.valueOf(d))).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final short first(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                return s6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final byte last(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                byte b = bArr[length];
                if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                    return b;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character reduceRightIndexedOrNull(char[] cArr, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char cCharValue = cArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            cCharValue = ((Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(cArr[i5]), Character.valueOf(cCharValue))).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static final Character reduceRightOrNull(char[] cArr, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char cCharValue = cArr[lastIndex];
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            cCharValue = ((Character) operation.invoke(Character.valueOf(cArr[i5]), Character.valueOf(cCharValue))).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static short[] sliceArray(short[] sArr, U3.q indices) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? new short[0] : AbstractC0151t.copyOfRange(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static void sortDescending(float[] fArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        AbstractC0151t.sort(fArr, i5, i6);
        reverse(fArr, i5, i6);
    }

    public static final <R, V> List<V> zip(byte[] bArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Character> associateBy(char[] cArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(cArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (char c : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c)), Character.valueOf(c));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(boolean[] zArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (boolean z6 : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z6)), valueTransform.invoke(Boolean.valueOf(z6)));
        }
        return destination;
    }

    public static final List<Character> dropLastWhile(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(cArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Character.valueOf(cArr[lastIndex]))).booleanValue()) {
                return take(cArr, lastIndex + 1);
            }
        }
        return I.emptyList();
    }

    public static final <R> List<R> flatMap(char[] cArr, O3.l transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            O.addAll(arrayList, (Iterable) transform.invoke(Character.valueOf(c)));
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> long maxByOrThrow(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            long j6 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j6));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        long j7 = jArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j7));
                        if (comparable.compareTo(comparable2) < 0) {
                            j6 = j7;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return j6;
        }
        throw new NoSuchElementException();
    }

    public static final Long maxOrNull(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j7 = jArr[i5];
                if (j6 < j7) {
                    j6 = j7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final <R extends Comparable<? super R>> long minByOrThrow(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            long j6 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j6));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        long j7 = jArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j7));
                        if (comparable.compareTo(comparable2) > 0) {
                            j6 = j7;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return j6;
        }
        throw new NoSuchElementException();
    }

    public static final Long minOrNull(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j7 = jArr[i5];
                if (j6 > j7) {
                    j6 = j7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final char reduceRight(char[] cArr, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char cCharValue = cArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                cCharValue = ((Character) operation.invoke(Character.valueOf(cArr[i5]), Character.valueOf(cCharValue))).charValue();
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceRightIndexed(char[] cArr, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char cCharValue = cArr[lastIndex];
            for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
                cCharValue = ((Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(cArr[i5]), Character.valueOf(cCharValue))).charValue();
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char[] reversedArray(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            int i5 = 0;
            while (true) {
                cArr2[lastIndex - i5] = cArr[i5];
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return cArr2;
    }

    public static char single(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final Character singleOrNull(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Character chValueOf = null;
        boolean z6 = false;
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                if (z6) {
                    return null;
                }
                chValueOf = Character.valueOf(c);
                z6 = true;
            }
        }
        if (z6) {
            return chValueOf;
        }
        return null;
    }

    public static final List<Character> takeLastWhile(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = getLastIndex(cArr); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Character.valueOf(cArr[lastIndex]))).booleanValue()) {
                return drop(cArr, lastIndex + 1);
            }
        }
        return toList(cArr);
    }

    public static final List<Character> takeWhile(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (!((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    public static final List<Character> toList(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return I.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return G.listOf(Character.valueOf(cArr[0]));
    }

    public static final Set<Character> toSet(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return w0.emptySet();
        }
        if (length != 1) {
            int length2 = cArr.length;
            if (length2 > 128) {
                length2 = 128;
            }
            return (Set) toCollection(cArr, new LinkedHashSet(j0.mapCapacity(length2)));
        }
        return v0.setOf(Character.valueOf(cArr[0]));
    }

    public static final int first(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                return i5;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character lastOrNull(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            char c = cArr[length];
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                return Character.valueOf(c);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final long maxOrThrow(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length != 0) {
            long j6 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long j7 = jArr[i5];
                    if (j6 < j7) {
                        j6 = j7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return j6;
        }
        throw new NoSuchElementException();
    }

    public static final long minOrThrow(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length != 0) {
            long j6 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    long j7 = jArr[i5];
                    if (j6 > j7) {
                        j6 = j7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return j6;
        }
        throw new NoSuchElementException();
    }

    public static final char random(char[] cArr, S3.f random) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (cArr.length != 0) {
            return cArr[random.d(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final List<Integer> slice(int[] iArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static int[] sliceArray(int[] iArr, U3.q indices) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? new int[0] : AbstractC0151t.copyOfRange(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final void sortDescending(double[] dArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        AbstractC0151t.sort(dArr, i5, i6);
        reverse(dArr, i5, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(char[] cArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (char c : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c)), valueTransform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    public static final <A extends Appendable> A joinTo(float[] fArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (float f6 : fArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                buffer.append((CharSequence) lVar.invoke(Float.valueOf(f6)));
            } else {
                buffer.append(String.valueOf(f6));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <R extends Comparable<? super R>> Long maxByOrNull(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j6);
        }
        Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j7 = jArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j7));
                if (comparable.compareTo(comparable2) < 0) {
                    j6 = j7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final <R extends Comparable<? super R>> Long minByOrNull(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j6);
        }
        Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j7 = jArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j7));
                if (comparable.compareTo(comparable2) > 0) {
                    j6 = j7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final Boolean reduceIndexedOrNull(boolean[] zArr, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                zBooleanValue = ((Boolean) operation.invoke(Integer.valueOf(i5), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i5]))).booleanValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final Boolean reduceOrNull(boolean[] zArr, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                zBooleanValue = ((Boolean) operation.invoke(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i5]))).booleanValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final void shuffle(float[] fArr, S3.f random) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(fArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            float f6 = fArr[lastIndex];
            fArr[lastIndex] = fArr[iD];
            fArr[iD] = f6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(float[] fArr, O3.l transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(fArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (float f6 : fArr) {
            C1938s c1938s = (C1938s) transform.invoke(Float.valueOf(f6));
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(boolean[] zArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (boolean z6 : zArr) {
            C1938s c1938s = (C1938s) transform.invoke(Boolean.valueOf(z6));
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    public static final List<Boolean> dropWhile(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (boolean z7 : zArr) {
            if (z6) {
                arrayList.add(Boolean.valueOf(z7));
            } else if (!((Boolean) predicate.invoke(Boolean.valueOf(z7))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z7));
                z6 = true;
            }
        }
        return arrayList;
    }

    public static final long first(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                return j6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final short last(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                short s6 = sArr[length];
                if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                    return s6;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private static final <R> R maxOfWithOrNull(boolean[] zArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Boolean.valueOf(zArr[i5]));
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Double maxWithOrNull(double[] dArr, Comparator<? super Double> comparator) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d6 = dArr[i5];
                if (comparator.compare(Double.valueOf(d), Double.valueOf(d6)) < 0) {
                    d = d6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(d);
    }

    private static final <R> R minOfWithOrNull(boolean[] zArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Boolean.valueOf(zArr[i5]));
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Double minWithOrNull(double[] dArr, Comparator<? super Double> comparator) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d6 = dArr[i5];
                if (comparator.compare(Double.valueOf(d), Double.valueOf(d6)) > 0) {
                    d = d6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(d);
    }

    public static final C1938s partition(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                arrayList.add(Float.valueOf(f6));
            } else {
                arrayList2.add(Float.valueOf(f6));
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    public static final boolean reduce(boolean[] zArr, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length != 0) {
            boolean zBooleanValue = zArr[0];
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    zBooleanValue = ((Boolean) operation.invoke(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i5]))).booleanValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceIndexed(boolean[] zArr, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length != 0) {
            boolean zBooleanValue = zArr[0];
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    zBooleanValue = ((Boolean) operation.invoke(Integer.valueOf(i5), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i5]))).booleanValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return zBooleanValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(zArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            boolean z6 = zArr[i5];
            zArr[i5] = zArr[lastIndex];
            zArr[lastIndex] = z6;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private static final <R> List<R> runningFold(boolean[] zArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r6);
        for (boolean z6 : zArr) {
            r6 = (R) operation.invoke(r6, Boolean.valueOf(z6));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(boolean[] zArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r6);
        int length = zArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Boolean.valueOf(zArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static long[] sliceArray(long[] jArr, U3.q indices) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? new long[0] : AbstractC0151t.copyOfRange(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final void sortDescending(char[] cArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        AbstractC0151t.sort(cArr, i5, i6);
        reverse(cArr, i5, i6);
    }

    private static final int sumOfUInt(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (boolean z6 : zArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(Boolean.valueOf(z6))).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (boolean z6 : zArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(Boolean.valueOf(z6))).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final <R, V> List<V> zip(short[] sArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Short.valueOf(sArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associateBy(T[] tArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(tArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (T t6 : tArr) {
            linkedHashMap.put(keySelector.invoke(t6), valueTransform.invoke(t6));
        }
        return linkedHashMap;
    }

    public static final <K> List<Double> distinctBy(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (hashSet.add(selector.invoke(Double.valueOf(d)))) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    public static final List<Long> drop(long[] jArr, int i5) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (i5 >= 0) {
            int length = jArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return takeLast(jArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Long> dropLast(long[] jArr, int i5) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (i5 >= 0) {
            int length = jArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return take(jArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final <K, M extends Map<? super K, List<Long>>> M groupByTo(long[] jArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (long j6 : jArr) {
            Object objInvoke = keySelector.invoke(Long.valueOf(j6));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Long.valueOf(j6));
        }
        return destination;
    }

    private static final double maxOf(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).doubleValue();
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Double.valueOf(dArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m22maxOfOrNull(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Double.valueOf(dArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(double[] dArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            R r6 = (Object) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Double.valueOf(dArr[i5]));
                    if (comparator.compare(r6, objInvoke) < 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final double maxWithOrThrow(double[] dArr, Comparator<? super Double> comparator) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (dArr.length != 0) {
            double d = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    double d6 = dArr[i5];
                    if (comparator.compare(Double.valueOf(d), Double.valueOf(d6)) < 0) {
                        d = d6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).doubleValue();
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Double.valueOf(dArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m58minOfOrNull(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).doubleValue();
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Double.valueOf(dArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(double[] dArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            R r6 = (Object) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Double.valueOf(dArr[i5]));
                    if (comparator.compare(r6, objInvoke) > 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final double minWithOrThrow(double[] dArr, Comparator<? super Double> comparator) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (dArr.length != 0) {
            double d = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    double d6 = dArr[i5];
                    if (comparator.compare(Double.valueOf(d), Double.valueOf(d6)) > 0) {
                        d = d6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    private static final List<Double> runningReduce(double[] dArr, O3.p operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length == 0) {
            return I.emptyList();
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            dDoubleValue = ((Number) operation.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i5]))).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    private static final List<Double> runningReduceIndexed(double[] dArr, O3.q operation) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (dArr.length == 0) {
            return I.emptyList();
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            dDoubleValue = ((Number) operation.invoke(Integer.valueOf(i5), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i5]))).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    public static final <T> T single(T[] tArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        T t6 = null;
        boolean z6 = false;
        for (T t7 : tArr) {
            if (((Boolean) predicate.invoke(t7)).booleanValue()) {
                if (z6) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                z6 = true;
                t6 = t7;
            }
        }
        if (z6) {
            return t6;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float first(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                return f6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Float maxOrNull(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMax = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fMax = Math.max(fMax, fArr[i5]);
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fMax);
    }

    public static final Float minOrNull(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMin = fArr[0];
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fMin = Math.min(fMin, fArr[i5]);
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fMin);
    }

    public static final float[] sliceArray(float[] fArr, U3.q indices) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? new float[0] : AbstractC0151t.copyOfRange(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final float maxOrThrow(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length != 0) {
            float fMax = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fMax = Math.max(fMax, fArr[i5]);
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fMax;
        }
        throw new NoSuchElementException();
    }

    public static final float minOrThrow(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length != 0) {
            float fMin = fArr[0];
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fMin = Math.min(fMin, fArr[i5]);
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fMin;
        }
        throw new NoSuchElementException();
    }

    public static final List<Long> slice(long[] jArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final double first(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                return d;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int last(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                int i6 = iArr[length];
                if (((Boolean) predicate.invoke(Integer.valueOf(i6))).booleanValue()) {
                    return i6;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character reduceIndexedOrNull(char[] cArr, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                cCharValue = ((Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(cCharValue), Character.valueOf(cArr[i5]))).charValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharValue);
    }

    public static final Character reduceOrNull(char[] cArr, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                cCharValue = ((Character) operation.invoke(Character.valueOf(cCharValue), Character.valueOf(cArr[i5]))).charValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharValue);
    }

    public static final void shuffle(double[] dArr, S3.f random) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(dArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            double d = dArr[lastIndex];
            dArr[lastIndex] = dArr[iD];
            dArr[iD] = d;
        }
    }

    public static final double[] sliceArray(double[] dArr, U3.q indices) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? new double[0] : AbstractC0151t.copyOfRange(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final <R, V> List<V> zip(int[] iArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(byte[] bArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(bArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (byte b : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b)), valueTransform.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(char[] cArr, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (char c : cArr) {
            C1938s c1938s = (C1938s) transform.invoke(Character.valueOf(c));
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    public static final List<Character> dropWhile(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z6 = false;
        for (char c : cArr) {
            if (z6) {
                arrayList.add(Character.valueOf(c));
            } else if (!((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
                z6 = true;
            }
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Long>> groupBy(long[] jArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j6 : jArr) {
            Object objInvoke = keySelector.invoke(Long.valueOf(j6));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Long.valueOf(j6));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> float maxByOrThrow(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            float f6 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f6));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        float f7 = fArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f7));
                        if (comparable.compareTo(comparable2) < 0) {
                            f6 = f7;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return f6;
        }
        throw new NoSuchElementException();
    }

    private static final <R> R maxOfWithOrNull(char[] cArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Character.valueOf(cArr[i5]));
                if (comparator.compare(r6, objInvoke) < 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <R extends Comparable<? super R>> float minByOrThrow(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            float f6 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f6));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        float f7 = fArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f7));
                        if (comparable.compareTo(comparable2) > 0) {
                            f6 = f7;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return f6;
        }
        throw new NoSuchElementException();
    }

    private static final <R> R minOfWithOrNull(char[] cArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R r6 = (Object) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object objInvoke = selector.invoke(Character.valueOf(cArr[i5]));
                if (comparator.compare(r6, objInvoke) > 0) {
                    r6 = (R) objInvoke;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final char reduce(char[] cArr, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length != 0) {
            char cCharValue = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    cCharValue = ((Character) operation.invoke(Character.valueOf(cCharValue), Character.valueOf(cArr[i5]))).charValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceIndexed(char[] cArr, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length != 0) {
            char cCharValue = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    cCharValue = ((Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(cCharValue), Character.valueOf(cArr[i5]))).charValue();
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return cCharValue;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(cArr);
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            char c = cArr[i5];
            cArr[i5] = cArr[lastIndex];
            cArr[lastIndex] = c;
            lastIndex--;
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private static final <R> List<R> runningFold(char[] cArr, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r6);
        for (char c : cArr) {
            r6 = (R) operation.invoke(r6, Character.valueOf(c));
            arrayList.add(r6);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(char[] cArr, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length == 0) {
            return G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r6);
        int length = cArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Character.valueOf(cArr[i5]));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final byte single(byte[] bArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Byte bValueOf = null;
        boolean z6 = false;
        for (byte b : bArr) {
            if (((Boolean) predicate.invoke(Byte.valueOf(b))).booleanValue()) {
                if (!z6) {
                    bValueOf = Byte.valueOf(b);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(bValueOf, "null cannot be cast to non-null type kotlin.Byte");
            return bValueOf.byteValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private static final int sumOfUInt(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (char c : cArr) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(Character.valueOf(c))).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (char c : cArr) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(Character.valueOf(c))).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final boolean first(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                return z6;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <A extends Appendable> A joinTo(double[] dArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (double d : dArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                buffer.append((CharSequence) lVar.invoke(Double.valueOf(d)));
            } else {
                buffer.append(String.valueOf(d));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final Boolean maxWithOrNull(boolean[] zArr, Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z6 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z7 = zArr[i5];
                if (comparator.compare(Boolean.valueOf(z6), Boolean.valueOf(z7)) < 0) {
                    z6 = z7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Boolean.valueOf(z6);
    }

    public static final Boolean minWithOrNull(boolean[] zArr, Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z6 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z7 = zArr[i5];
                if (comparator.compare(Boolean.valueOf(z6), Boolean.valueOf(z7)) > 0) {
                    z6 = z7;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Boolean.valueOf(z6);
    }

    public static final boolean[] sliceArray(boolean[] zArr, U3.q indices) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? new boolean[0] : AbstractC0151t.copyOfRange(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(double[] dArr, O3.l transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(dArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (double d : dArr) {
            C1938s c1938s = (C1938s) transform.invoke(Double.valueOf(d));
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    public static final <K> List<Boolean> distinctBy(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z6 : zArr) {
            if (hashSet.add(selector.invoke(Boolean.valueOf(z6)))) {
                arrayList.add(Boolean.valueOf(z6));
            }
        }
        return arrayList;
    }

    private static final double maxOf(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).doubleValue();
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m28maxOfOrNull(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).doubleValue();
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(boolean[] zArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            R r6 = (Object) selector.invoke(Boolean.valueOf(zArr[0]));
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Boolean.valueOf(zArr[i5]));
                    if (comparator.compare(r6, objInvoke) < 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final boolean maxWithOrThrow(boolean[] zArr, Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (zArr.length != 0) {
            boolean z6 = zArr[0];
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    boolean z7 = zArr[i5];
                    if (comparator.compare(Boolean.valueOf(z6), Boolean.valueOf(z7)) < 0) {
                        z6 = z7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return z6;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).doubleValue();
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m64minOfOrNull(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).doubleValue();
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(boolean[] zArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            R r6 = (Object) selector.invoke(Boolean.valueOf(zArr[0]));
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Boolean.valueOf(zArr[i5]));
                    if (comparator.compare(r6, objInvoke) > 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final boolean minWithOrThrow(boolean[] zArr, Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (zArr.length != 0) {
            boolean z6 = zArr[0];
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    boolean z7 = zArr[i5];
                    if (comparator.compare(Boolean.valueOf(z6), Boolean.valueOf(z7)) > 0) {
                        z6 = z7;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return z6;
        }
        throw new NoSuchElementException();
    }

    public static final C1938s partition(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            } else {
                arrayList2.add(Double.valueOf(d));
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    private static final List<Boolean> runningReduce(boolean[] zArr, O3.p operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length == 0) {
            return I.emptyList();
        }
        boolean z6 = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z6));
        int length = zArr.length;
        int i5 = 1;
        while (i5 < length) {
            Boolean bool = (Boolean) operation.invoke(Boolean.valueOf(z6), Boolean.valueOf(zArr[i5]));
            boolean zBooleanValue = bool.booleanValue();
            arrayList.add(bool);
            i5++;
            z6 = zBooleanValue;
        }
        return arrayList;
    }

    private static final List<Boolean> runningReduceIndexed(boolean[] zArr, O3.q operation) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (zArr.length == 0) {
            return I.emptyList();
        }
        boolean z6 = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z6));
        int length = zArr.length;
        int i5 = 1;
        while (i5 < length) {
            Boolean bool = (Boolean) operation.invoke(Integer.valueOf(i5), Boolean.valueOf(z6), Boolean.valueOf(zArr[i5]));
            boolean zBooleanValue = bool.booleanValue();
            arrayList.add(bool);
            i5++;
            z6 = zBooleanValue;
        }
        return arrayList;
    }

    public static final List<Integer> take(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= iArr.length) {
            return toList(iArr);
        }
        if (i5 == 1) {
            return G.listOf(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (int i7 : iArr) {
            arrayList.add(Integer.valueOf(i7));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Integer> takeLast(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = iArr.length;
        if (i5 >= length) {
            return toList(iArr);
        }
        if (i5 == 1) {
            return G.listOf(Integer.valueOf(iArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(Integer.valueOf(iArr[i6]));
        }
        return arrayList;
    }

    public static final char first(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                return c;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long last(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                long j6 = jArr[length];
                if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                    return j6;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <R extends Comparable<? super R>> Float maxByOrNull(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f6);
        }
        Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f7 = fArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f7));
                if (comparable.compareTo(comparable2) < 0) {
                    f6 = f7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(f6);
    }

    public static final Double maxOrNull(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMax = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dMax = Math.max(dMax, dArr[i5]);
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dMax);
    }

    public static final <R extends Comparable<? super R>> Float minByOrNull(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f6);
        }
        Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f7 = fArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f7));
                if (comparable.compareTo(comparable2) > 0) {
                    f6 = f7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(f6);
    }

    public static final Double minOrNull(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMin = dArr[0];
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dMin = Math.min(dMin, dArr[i5]);
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dMin);
    }

    public static final List<Float> slice(float[] fArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final char[] sliceArray(char[] cArr, U3.q indices) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? new char[0] : AbstractC0151t.copyOfRange(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final <R, V> List<V> zip(long[] jArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Long.valueOf(jArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(short[] sArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(sArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (short s6 : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s6)), valueTransform.invoke(Short.valueOf(s6)));
        }
        return linkedHashMap;
    }

    public static final double maxOrThrow(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length != 0) {
            double dMax = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dMax = Math.max(dMax, dArr[i5]);
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dMax;
        }
        throw new NoSuchElementException();
    }

    public static final double minOrThrow(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length != 0) {
            double dMin = dArr[0];
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dMin = Math.min(dMin, dArr[i5]);
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dMin;
        }
        throw new NoSuchElementException();
    }

    public static final void shuffle(boolean[] zArr, S3.f random) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(zArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            boolean z6 = zArr[lastIndex];
            zArr[lastIndex] = zArr[iD];
            zArr[iD] = z6;
        }
    }

    public static final List<Float> drop(float[] fArr, int i5) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (i5 >= 0) {
            int length = fArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return takeLast(fArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Float> dropLast(float[] fArr, int i5) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (i5 >= 0) {
            int length = fArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return take(fArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final <K, M extends Map<? super K, List<Float>>> M groupByTo(float[] fArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (float f6 : fArr) {
            Object objInvoke = keySelector.invoke(Float.valueOf(f6));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Float.valueOf(f6));
        }
        return destination;
    }

    public static final <T> void reverse(T[] tArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = tArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            T t6 = tArr[i5];
            tArr[i5] = tArr[i8];
            tArr[i8] = t6;
            i8--;
            i5++;
        }
    }

    public static final short single(short[] sArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Short shValueOf = null;
        boolean z6 = false;
        for (short s6 : sArr) {
            if (((Boolean) predicate.invoke(Short.valueOf(s6))).booleanValue()) {
                if (!z6) {
                    shValueOf = Short.valueOf(s6);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(shValueOf, "null cannot be cast to non-null type kotlin.Short");
            return shValueOf.shortValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float last(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                float f6 = fArr[length];
                if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                    return f6;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character maxWithOrNull(char[] cArr, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c6 = cArr[i5];
                if (comparator.compare(Character.valueOf(c), Character.valueOf(c6)) < 0) {
                    c = c6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(c);
    }

    public static final Character minWithOrNull(char[] cArr, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c6 = cArr[i5];
                if (comparator.compare(Character.valueOf(c), Character.valueOf(c6)) > 0) {
                    c = c6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(c);
    }

    public static final <R, V> List<V> zip(float[] fArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Float.valueOf(fArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(int[] iArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(iArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i5)), valueTransform.invoke(Integer.valueOf(i5)));
        }
        return linkedHashMap;
    }

    public static final <K> List<Character> distinctBy(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (hashSet.add(selector.invoke(Character.valueOf(c)))) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    public static final <A extends Appendable> A joinTo(boolean[] zArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (boolean z6 : zArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                buffer.append((CharSequence) lVar.invoke(Boolean.valueOf(z6)));
            } else {
                buffer.append(String.valueOf(z6));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <R extends Comparable<? super R>> double maxByOrThrow(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            double d = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        double d6 = dArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d6));
                        if (comparable.compareTo(comparable2) < 0) {
                            d = d6;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).doubleValue();
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Character.valueOf(cArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m21maxOfOrNull(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).doubleValue();
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(Character.valueOf(cArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R maxOfWith(char[] cArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            R r6 = (Object) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Character.valueOf(cArr[i5]));
                    if (comparator.compare(r6, objInvoke) < 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final char maxWithOrThrow(char[] cArr, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (cArr.length != 0) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char c6 = cArr[i5];
                    if (comparator.compare(Character.valueOf(c), Character.valueOf(c6)) < 0) {
                        c = c6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> double minByOrThrow(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            double d = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        double d6 = dArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d6));
                        if (comparable.compareTo(comparable2) > 0) {
                            d = d6;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            double dDoubleValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).doubleValue();
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Character.valueOf(cArr[i5]))).doubleValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return dDoubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m57minOfOrNull(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).doubleValue();
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(Character.valueOf(cArr[i5]))).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <R> R minOfWith(char[] cArr, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            R r6 = (Object) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object objInvoke = selector.invoke(Character.valueOf(cArr[i5]));
                    if (comparator.compare(r6, objInvoke) > 0) {
                        r6 = (R) objInvoke;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final char minWithOrThrow(char[] cArr, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (cArr.length != 0) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char c6 = cArr[i5];
                    if (comparator.compare(Character.valueOf(c), Character.valueOf(c6)) > 0) {
                        c = c6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    private static final List<Character> runningReduce(char[] cArr, O3.p operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length == 0) {
            return I.emptyList();
        }
        char c = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c));
        int length = cArr.length;
        int i5 = 1;
        while (i5 < length) {
            Character ch = (Character) operation.invoke(Character.valueOf(c), Character.valueOf(cArr[i5]));
            char cCharValue = ch.charValue();
            arrayList.add(ch);
            i5++;
            c = cCharValue;
        }
        return arrayList;
    }

    private static final List<Character> runningReduceIndexed(char[] cArr, O3.q operation) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (cArr.length == 0) {
            return I.emptyList();
        }
        char c = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c));
        int length = cArr.length;
        int i5 = 1;
        while (i5 < length) {
            Character ch = (Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(c), Character.valueOf(cArr[i5]));
            char cCharValue = ch.charValue();
            arrayList.add(ch);
            i5++;
            c = cCharValue;
        }
        return arrayList;
    }

    public static final List<Double> slice(double[] dArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it.next().intValue()]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(boolean[] zArr, O3.l transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(zArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (boolean z6 : zArr) {
            C1938s c1938s = (C1938s) transform.invoke(Boolean.valueOf(z6));
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    public static final Character maxOrNull(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c6 = cArr[i5];
                if (kotlin.jvm.internal.E.h(c, c6) < 0) {
                    c = c6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(c);
    }

    public static final Character minOrNull(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c6 = cArr[i5];
                if (kotlin.jvm.internal.E.h(c, c6) > 0) {
                    c = c6;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(c);
    }

    public static final C1938s partition(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z6 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z6));
            } else {
                arrayList2.add(Boolean.valueOf(z6));
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    public static final void shuffle(char[] cArr, S3.f random) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        for (int lastIndex = getLastIndex(cArr); lastIndex > 0; lastIndex--) {
            int iD = random.d(lastIndex + 1);
            char c = cArr[lastIndex];
            cArr[lastIndex] = cArr[iD];
            cArr[iD] = c;
        }
    }

    public static final <K> Map<K, List<Float>> groupBy(float[] fArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f6 : fArr) {
            Object objInvoke = keySelector.invoke(Float.valueOf(f6));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Float.valueOf(f6));
        }
        return linkedHashMap;
    }

    public static final char maxOrThrow(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length != 0) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char c6 = cArr[i5];
                    if (kotlin.jvm.internal.E.h(c, c6) < 0) {
                        c = c6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    public static final char minOrThrow(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length != 0) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char c6 = cArr[i5];
                    if (kotlin.jvm.internal.E.h(c, c6) > 0) {
                        c = c6;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    public static void reverse(byte[] bArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = bArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            byte b = bArr[i5];
            bArr[i5] = bArr[i8];
            bArr[i8] = b;
            i8--;
            i5++;
        }
    }

    public static final double last(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                double d = dArr[length];
                if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                    return d;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <R, V> List<V> zip(double[] dArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Double.valueOf(dArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(long[] jArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(jArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (long j6 : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j6)), valueTransform.invoke(Long.valueOf(j6)));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> Double maxByOrNull(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d);
        }
        Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d6 = dArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d6));
                if (comparable.compareTo(comparable2) < 0) {
                    d = d6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(d);
    }

    public static final <R extends Comparable<? super R>> Double minByOrNull(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d);
        }
        Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d6 = dArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d6));
                if (comparable.compareTo(comparable2) > 0) {
                    d = d6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(d);
    }

    public static final int single(int[] iArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Integer numValueOf = null;
        boolean z6 = false;
        for (int i5 : iArr) {
            if (((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue()) {
                if (!z6) {
                    numValueOf = Integer.valueOf(i5);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(numValueOf, "null cannot be cast to non-null type kotlin.Int");
            return numValueOf.intValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final List<Boolean> slice(boolean[] zArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Double> drop(double[] dArr, int i5) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (i5 >= 0) {
            int length = dArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return takeLast(dArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Double> dropLast(double[] dArr, int i5) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (i5 >= 0) {
            int length = dArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return take(dArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final <K, M extends Map<? super K, List<Double>>> M groupByTo(double[] dArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (double d : dArr) {
            Object objInvoke = keySelector.invoke(Double.valueOf(d));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Double.valueOf(d));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m8maxOf(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(tArr[0])).floatValue();
            int lastIndex = getLastIndex(tArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(tArr[i5])).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m35maxOfOrNull(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(tArr[0])).floatValue();
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(tArr[i5])).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m44minOf(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(tArr[0])).floatValue();
            int lastIndex = getLastIndex(tArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(tArr[i5])).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m71minOfOrNull(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(tArr[0])).floatValue();
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(tArr[i5])).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <A extends Appendable> A joinTo(char[] cArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (char c : cArr) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                buffer.append((CharSequence) lVar.invoke(Character.valueOf(c)));
            } else {
                buffer.append(c);
            }
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean last(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                boolean z6 = zArr[length];
                if (((Boolean) predicate.invoke(Boolean.valueOf(z6))).booleanValue()) {
                    return z6;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static void reverse(short[] sArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = sArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            short s6 = sArr[i5];
            sArr[i5] = sArr[i8];
            sArr[i8] = s6;
            i8--;
            i5++;
        }
    }

    public static final <R, V> List<V> zip(boolean[] zArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(char[] cArr, O3.l transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(cArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (char c : cArr) {
            C1938s c1938s = (C1938s) transform.invoke(Character.valueOf(c));
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(float[] fArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(fArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (float f6 : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f6)), valueTransform.invoke(Float.valueOf(f6)));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> boolean maxByOrThrow(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            boolean z6 = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z6));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        boolean z7 = zArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z7));
                        if (comparable.compareTo(comparable2) < 0) {
                            z6 = z7;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return z6;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> boolean minByOrThrow(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            boolean z6 = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z6));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        boolean z7 = zArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z7));
                        if (comparable.compareTo(comparable2) > 0) {
                            z6 = z7;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return z6;
        }
        throw new NoSuchElementException();
    }

    public static final C1938s partition(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            } else {
                arrayList2.add(Character.valueOf(c));
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    public static final List<Long> take(long[] jArr, int i5) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= jArr.length) {
            return toList(jArr);
        }
        if (i5 == 1) {
            return G.listOf(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (long j6 : jArr) {
            arrayList.add(Long.valueOf(j6));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Long> takeLast(long[] jArr, int i5) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = jArr.length;
        if (i5 >= length) {
            return toList(jArr);
        }
        if (i5 == 1) {
            return G.listOf(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(Long.valueOf(jArr[i6]));
        }
        return arrayList;
    }

    public static final long single(long[] jArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Long lValueOf = null;
        boolean z6 = false;
        for (long j6 : jArr) {
            if (((Boolean) predicate.invoke(Long.valueOf(j6))).booleanValue()) {
                if (!z6) {
                    lValueOf = Long.valueOf(j6);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(lValueOf, "null cannot be cast to non-null type kotlin.Long");
            return lValueOf.longValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final List<Character> slice(char[] cArr, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return I.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final char last(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                char c = cArr[length];
                if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                    return c;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <R, V> List<V> zip(char[] cArr, Iterable<? extends R> other, O3.p transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Character.valueOf(cArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(double[] dArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(dArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (double d : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d)), valueTransform.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Double>> groupBy(double[] dArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d : dArr) {
            Object objInvoke = keySelector.invoke(Double.valueOf(d));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Double.valueOf(d));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m2maxOf(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).floatValue();
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Byte.valueOf(bArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m29maxOfOrNull(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).floatValue();
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Byte.valueOf(bArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m38minOf(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).floatValue();
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Byte.valueOf(bArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m65minOfOrNull(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Byte.valueOf(bArr[0]))).floatValue();
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Byte.valueOf(bArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static void reverse(int[] iArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = iArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            int i9 = iArr[i5];
            iArr[i5] = iArr[i8];
            iArr[i8] = i9;
            i8--;
            i5++;
        }
    }

    public static final <R extends Comparable<? super R>> Boolean maxByOrNull(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z6 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z6);
        }
        Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z7 = zArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z7));
                if (comparable.compareTo(comparable2) < 0) {
                    z6 = z7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Boolean.valueOf(z6);
    }

    public static final <R extends Comparable<? super R>> Boolean minByOrNull(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z6 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z6);
        }
        Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z7 = zArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z7));
                if (comparable.compareTo(comparable2) > 0) {
                    z6 = z7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Boolean.valueOf(z6);
    }

    public static final List<Boolean> drop(boolean[] zArr, int i5) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (i5 >= 0) {
            int length = zArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return takeLast(zArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Boolean> dropLast(boolean[] zArr, int i5) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (i5 >= 0) {
            int length = zArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return take(zArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final <K, M extends Map<? super K, List<Boolean>>> M groupByTo(boolean[] zArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (boolean z6 : zArr) {
            Object objInvoke = keySelector.invoke(Boolean.valueOf(z6));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Boolean.valueOf(z6));
        }
        return destination;
    }

    public static final <V> List<V> zip(byte[] bArr, byte[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i5]), Byte.valueOf(other[i5])));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(boolean[] zArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(zArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (boolean z6 : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z6)), valueTransform.invoke(Boolean.valueOf(z6)));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> char maxByOrThrow(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        char c6 = cArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c6));
                        if (comparable.compareTo(comparable2) < 0) {
                            c = c6;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> char minByOrThrow(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (lastIndex != 0) {
                Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c));
                int i5 = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        char c6 = cArr[i5];
                        Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c6));
                        if (comparable.compareTo(comparable2) > 0) {
                            c = c6;
                            comparable = comparable2;
                        }
                        if (i5 == lastIndex) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    public static final float single(float[] fArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Float fValueOf = null;
        boolean z6 = false;
        for (float f6 : fArr) {
            if (((Boolean) predicate.invoke(Float.valueOf(f6))).booleanValue()) {
                if (!z6) {
                    fValueOf = Float.valueOf(f6);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(fValueOf, "null cannot be cast to non-null type kotlin.Float");
            return fValueOf.floatValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static void reverse(long[] jArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = jArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            long j6 = jArr[i5];
            jArr[i5] = jArr[i8];
            jArr[i8] = j6;
            i8--;
            i5++;
        }
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m9maxOf(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).floatValue();
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Short.valueOf(sArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m36maxOfOrNull(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).floatValue();
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Short.valueOf(sArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m45minOf(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).floatValue();
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Short.valueOf(sArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m72minOfOrNull(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Short.valueOf(sArr[0]))).floatValue();
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Short.valueOf(sArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <V> List<V> zip(short[] sArr, short[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i5]), Short.valueOf(other[i5])));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(char[] cArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(cArr.length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (char c : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c)), valueTransform.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    public static final <V> List<V> zip(int[] iArr, int[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i5]), Integer.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Boolean>> groupBy(boolean[] zArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z6 : zArr) {
            Object objInvoke = keySelector.invoke(Boolean.valueOf(z6));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Boolean.valueOf(z6));
        }
        return linkedHashMap;
    }

    public static final <R extends Comparable<? super R>> Character maxByOrNull(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c);
        }
        Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c6 = cArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c6));
                if (comparable.compareTo(comparable2) < 0) {
                    c = c6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(c);
    }

    public static final <R extends Comparable<? super R>> Character minByOrNull(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c);
        }
        Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c6 = cArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c6));
                if (comparable.compareTo(comparable2) > 0) {
                    c = c6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(c);
    }

    public static final void reverse(float[] fArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = fArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            float f6 = fArr[i5];
            fArr[i5] = fArr[i8];
            fArr[i8] = f6;
            i8--;
            i5++;
        }
    }

    public static final double single(double[] dArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Double dValueOf = null;
        boolean z6 = false;
        for (double d : dArr) {
            if (((Boolean) predicate.invoke(Double.valueOf(d))).booleanValue()) {
                if (!z6) {
                    dValueOf = Double.valueOf(d);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(dValueOf, "null cannot be cast to non-null type kotlin.Double");
            return dValueOf.doubleValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final List<Float> take(float[] fArr, int i5) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= fArr.length) {
            return toList(fArr);
        }
        if (i5 == 1) {
            return G.listOf(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (float f6 : fArr) {
            arrayList.add(Float.valueOf(f6));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Float> takeLast(float[] fArr, int i5) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = fArr.length;
        if (i5 >= length) {
            return toList(fArr);
        }
        if (i5 == 1) {
            return G.listOf(Float.valueOf(fArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(Float.valueOf(fArr[i6]));
        }
        return arrayList;
    }

    public static final List<Character> drop(char[] cArr, int i5) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (i5 >= 0) {
            int length = cArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return takeLast(cArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final List<Character> dropLast(char[] cArr, int i5) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (i5 >= 0) {
            int length = cArr.length - i5;
            if (length < 0) {
                length = 0;
            }
            return take(cArr, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
    }

    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(char[] cArr, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (char c : cArr) {
            Object objInvoke = keySelector.invoke(Character.valueOf(c));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Character.valueOf(c));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m6maxOf(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).floatValue();
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Integer.valueOf(iArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m33maxOfOrNull(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).floatValue();
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Integer.valueOf(iArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m42minOf(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).floatValue();
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Integer.valueOf(iArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m69minOfOrNull(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Integer.valueOf(iArr[0]))).floatValue();
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Integer.valueOf(iArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <V> List<V> zip(long[] jArr, long[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i5]), Long.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final void reverse(double[] dArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = dArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            double d = dArr[i5];
            dArr[i5] = dArr[i8];
            dArr[i8] = d;
            i8--;
            i5++;
        }
    }

    public static final <V> List<V> zip(float[] fArr, float[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i5]), Float.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final boolean single(boolean[] zArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Boolean boolValueOf = null;
        boolean z6 = false;
        for (boolean z7 : zArr) {
            if (((Boolean) predicate.invoke(Boolean.valueOf(z7))).booleanValue()) {
                if (!z6) {
                    boolValueOf = Boolean.valueOf(z7);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(boolValueOf, "null cannot be cast to non-null type kotlin.Boolean");
            return boolValueOf.booleanValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m7maxOf(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).floatValue();
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Long.valueOf(jArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m34maxOfOrNull(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).floatValue();
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Long.valueOf(jArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m43minOf(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).floatValue();
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Long.valueOf(jArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m70minOfOrNull(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Long.valueOf(jArr[0]))).floatValue();
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Long.valueOf(jArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <V> List<V> zip(double[] dArr, double[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i5]), Double.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final <K> Map<K, List<Character>> groupBy(char[] cArr, O3.l keySelector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c : cArr) {
            Object objInvoke = keySelector.invoke(Character.valueOf(c));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Character.valueOf(c));
        }
        return linkedHashMap;
    }

    public static final void reverse(boolean[] zArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = zArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            boolean z6 = zArr[i5];
            zArr[i5] = zArr[i8];
            zArr[i8] = z6;
            i8--;
            i5++;
        }
    }

    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(T[] tArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (T t6 : tArr) {
            Object objInvoke = keySelector.invoke(t6);
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(t6));
        }
        return destination;
    }

    public static final <V> List<V> zip(boolean[] zArr, boolean[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i5]), Boolean.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final char single(char[] cArr, O3.l predicate) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Character chValueOf = null;
        boolean z6 = false;
        for (char c : cArr) {
            if (((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                if (!z6) {
                    chValueOf = Character.valueOf(c);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(chValueOf, "null cannot be cast to non-null type kotlin.Char");
            return chValueOf.charValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m5maxOf(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).floatValue();
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Float.valueOf(fArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m32maxOfOrNull(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).floatValue();
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Float.valueOf(fArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m41minOf(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).floatValue();
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Float.valueOf(fArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m68minOfOrNull(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Float.valueOf(fArr[0]))).floatValue();
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Float.valueOf(fArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final List<Double> take(double[] dArr, int i5) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= dArr.length) {
            return toList(dArr);
        }
        if (i5 == 1) {
            return G.listOf(Double.valueOf(dArr[0]));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Double> takeLast(double[] dArr, int i5) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = dArr.length;
        if (i5 >= length) {
            return toList(dArr);
        }
        if (i5 == 1) {
            return G.listOf(Double.valueOf(dArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(Double.valueOf(dArr[i6]));
        }
        return arrayList;
    }

    public static final <V> List<V> zip(char[] cArr, char[] other, O3.p transform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i5]), Character.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final void reverse(char[] cArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = cArr.length;
        c0136d.getClass();
        C0136d.d(i5, i6, length);
        int i7 = (i5 + i6) / 2;
        if (i5 == i7) {
            return;
        }
        int i8 = i6 - 1;
        while (i5 < i7) {
            char c = cArr[i5];
            cArr[i5] = cArr[i8];
            cArr[i8] = c;
            i8--;
            i5++;
        }
    }

    public static <T, R> List<C1938s> zip(T[] tArr, R[] other) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(tArr[i5], other[i5]));
        }
        return arrayList;
    }

    public static final <T, K, V> Map<K, List<V>> groupBy(T[] tArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t6 : tArr) {
            Object objInvoke = keySelector.invoke(t6);
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(t6));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(byte[] bArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (byte b : bArr) {
            Object objInvoke = keySelector.invoke(Byte.valueOf(b));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m4maxOf(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).floatValue();
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Double.valueOf(dArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m31maxOfOrNull(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).floatValue();
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Double.valueOf(dArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m40minOf(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).floatValue();
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Double.valueOf(dArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m67minOfOrNull(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Double.valueOf(dArr[0]))).floatValue();
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Double.valueOf(dArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <R> List<C1938s> zip(byte[] bArr, R[] other) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            byte b = bArr[i5];
            arrayList.add(p147z3.A.to(Byte.valueOf(b), other[i5]));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m10maxOf(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).floatValue();
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m37maxOfOrNull(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).floatValue();
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m46minOf(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).floatValue();
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m73minOfOrNull(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Boolean.valueOf(zArr[0]))).floatValue();
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Boolean.valueOf(zArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <R> List<C1938s> zip(short[] sArr, R[] other) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            short s6 = sArr[i5];
            arrayList.add(p147z3.A.to(Short.valueOf(s6), other[i5]));
        }
        return arrayList;
    }

    public static final List<Boolean> take(boolean[] zArr, int i5) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= zArr.length) {
            return toList(zArr);
        }
        if (i5 == 1) {
            return G.listOf(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (boolean z6 : zArr) {
            arrayList.add(Boolean.valueOf(z6));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Boolean> takeLast(boolean[] zArr, int i5) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = zArr.length;
        if (i5 >= length) {
            return toList(zArr);
        }
        if (i5 == 1) {
            return G.listOf(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(Boolean.valueOf(zArr[i6]));
        }
        return arrayList;
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(short[] sArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (short s6 : sArr) {
            Object objInvoke = keySelector.invoke(Short.valueOf(s6));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Short.valueOf(s6)));
        }
        return destination;
    }

    public static final <K, V> Map<K, List<V>> groupBy(byte[] bArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : bArr) {
            Object objInvoke = keySelector.invoke(Byte.valueOf(b));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m3maxOf(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).floatValue();
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Character.valueOf(cArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m30maxOfOrNull(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).floatValue();
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(Character.valueOf(cArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m39minOf(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            float fFloatValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).floatValue();
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Character.valueOf(cArr[i5]))).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m66minOfOrNull(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(Character.valueOf(cArr[0]))).floatValue();
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(Character.valueOf(cArr[i5]))).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <R> List<C1938s> zip(int[] iArr, R[] other) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            int i6 = iArr[i5];
            arrayList.add(p147z3.A.to(Integer.valueOf(i6), other[i5]));
        }
        return arrayList;
    }

    public static final <R> List<C1938s> zip(long[] jArr, R[] other) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            long j6 = jArr[i5];
            arrayList.add(p147z3.A.to(Long.valueOf(j6), other[i5]));
        }
        return arrayList;
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(int[] iArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (int i5 : iArr) {
            Object objInvoke = keySelector.invoke(Integer.valueOf(i5));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Integer.valueOf(i5)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m17maxOf(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length != 0) {
            R r6 = (R) selector.invoke(tArr[0]);
            int lastIndex = getLastIndex(tArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(tArr[i5]);
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(tArr[i5]);
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m53minOf(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length != 0) {
            R r6 = (R) selector.invoke(tArr[0]);
            int lastIndex = getLastIndex(tArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(tArr[i5]);
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R minOfOrNull(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(tArr[i5]);
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <K, V> Map<K, List<V>> groupBy(short[] sArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s6 : sArr) {
            Object objInvoke = keySelector.invoke(Short.valueOf(s6));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Short.valueOf(s6)));
        }
        return linkedHashMap;
    }

    public static final List<Character> take(char[] cArr, int i5) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        if (i5 >= cArr.length) {
            return toList(cArr);
        }
        if (i5 == 1) {
            return G.listOf(Character.valueOf(cArr[0]));
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = 0;
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Character> takeLast(char[] cArr, int i5) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return I.emptyList();
        }
        int length = cArr.length;
        if (i5 >= length) {
            return toList(cArr);
        }
        if (i5 == 1) {
            return G.listOf(Character.valueOf(cArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = length - i5; i6 < length; i6++) {
            arrayList.add(Character.valueOf(cArr[i6]));
        }
        return arrayList;
    }

    public static final <R> List<C1938s> zip(float[] fArr, R[] other) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            float f6 = fArr[i5];
            arrayList.add(p147z3.A.to(Float.valueOf(f6), other[i5]));
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(bArr[i5]));
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(bArr[i5]));
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m11maxOf(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            R r6 = (R) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(bArr[i5]));
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m47minOf(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length != 0) {
            R r6 = (R) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(bArr[i5]));
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(long[] jArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (long j6 : jArr) {
            Object objInvoke = keySelector.invoke(Long.valueOf(j6));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Long.valueOf(j6)));
        }
        return destination;
    }

    public static final <R> List<C1938s> zip(double[] dArr, R[] other) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            double d = dArr[i5];
            arrayList.add(p147z3.A.to(Double.valueOf(d), other[i5]));
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Short.valueOf(sArr[i5]));
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Short.valueOf(sArr[i5]));
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <K, V> Map<K, List<V>> groupBy(int[] iArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i5 : iArr) {
            Object objInvoke = keySelector.invoke(Integer.valueOf(i5));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Integer.valueOf(i5)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m18maxOf(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            R r6 = (R) selector.invoke(Short.valueOf(sArr[0]));
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Short.valueOf(sArr[i5]));
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m54minOf(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length != 0) {
            R r6 = (R) selector.invoke(Short.valueOf(sArr[0]));
            int lastIndex = getLastIndex(sArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Short.valueOf(sArr[i5]));
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<C1938s> zip(boolean[] zArr, R[] other) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            boolean z6 = zArr[i5];
            arrayList.add(p147z3.A.to(Boolean.valueOf(z6), other[i5]));
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(iArr[i5]));
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(iArr[i5]));
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(float[] fArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (float f6 : fArr) {
            Object objInvoke = keySelector.invoke(Float.valueOf(f6));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Float.valueOf(f6)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m15maxOf(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            R r6 = (R) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(iArr[i5]));
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m51minOf(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length != 0) {
            R r6 = (R) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(iArr[i5]));
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<C1938s> zip(char[] cArr, R[] other) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            char c = cArr[i5];
            arrayList.add(p147z3.A.to(Character.valueOf(c), other[i5]));
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Long.valueOf(jArr[i5]));
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Long.valueOf(jArr[i5]));
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <K, V> Map<K, List<V>> groupBy(long[] jArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j6 : jArr) {
            Object objInvoke = keySelector.invoke(Long.valueOf(j6));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Long.valueOf(j6)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m16maxOf(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            R r6 = (R) selector.invoke(Long.valueOf(jArr[0]));
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Long.valueOf(jArr[i5]));
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m52minOf(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length != 0) {
            R r6 = (R) selector.invoke(Long.valueOf(jArr[0]));
            int lastIndex = getLastIndex(jArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Long.valueOf(jArr[i5]));
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <T, R> List<C1938s> zip(T[] tArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(tArr[i5], r6));
            i5++;
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Float.valueOf(fArr[i5]));
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Float.valueOf(fArr[i5]));
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(double[] dArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (double d : dArr) {
            Object objInvoke = keySelector.invoke(Double.valueOf(d));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m14maxOf(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            R r6 = (R) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Float.valueOf(fArr[i5]));
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Double.valueOf(dArr[i5]));
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m50minOf(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length != 0) {
            R r6 = (R) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Float.valueOf(fArr[i5]));
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Double.valueOf(dArr[i5]));
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <R> List<C1938s> zip(byte[] bArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(Byte.valueOf(bArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(float[] fArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f6 : fArr) {
            Object objInvoke = keySelector.invoke(Float.valueOf(f6));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Float.valueOf(f6)));
        }
        return linkedHashMap;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(zArr[i5]));
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(zArr[i5]));
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(boolean[] zArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (boolean z6 : zArr) {
            Object objInvoke = keySelector.invoke(Boolean.valueOf(z6));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Boolean.valueOf(z6)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m13maxOf(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            R r6 = (R) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Double.valueOf(dArr[i5]));
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m49minOf(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length != 0) {
            R r6 = (R) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Double.valueOf(dArr[i5]));
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<C1938s> zip(short[] sArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(Short.valueOf(sArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Character.valueOf(cArr[i5]));
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R r6 = (R) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) selector.invoke(Character.valueOf(cArr[i5]));
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final <K, V> Map<K, List<V>> groupBy(double[] dArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d : dArr) {
            Object objInvoke = keySelector.invoke(Double.valueOf(d));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m19maxOf(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            R r6 = (R) selector.invoke(Boolean.valueOf(zArr[0]));
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(zArr[i5]));
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m55minOf(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length != 0) {
            R r6 = (R) selector.invoke(Boolean.valueOf(zArr[0]));
            int lastIndex = getLastIndex(zArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(zArr[i5]));
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<C1938s> zip(int[] iArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(Integer.valueOf(iArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(char[] cArr, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (char c : cArr) {
            Object objInvoke = keySelector.invoke(Character.valueOf(c));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m12maxOf(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            R r6 = (R) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Character.valueOf(cArr[i5]));
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m48minOf(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length != 0) {
            R r6 = (R) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) selector.invoke(Character.valueOf(cArr[i5]));
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    public static final <R> List<C1938s> zip(long[] jArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(Long.valueOf(jArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(boolean[] zArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z6 : zArr) {
            Object objInvoke = keySelector.invoke(Boolean.valueOf(z6));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Boolean.valueOf(z6)));
        }
        return linkedHashMap;
    }

    public static final <R> List<C1938s> zip(float[] fArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(Float.valueOf(fArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    public static final <R> List<C1938s> zip(double[] dArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(Double.valueOf(dArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    public static final <K, V> Map<K, List<V>> groupBy(char[] cArr, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c : cArr) {
            Object objInvoke = keySelector.invoke(Character.valueOf(c));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    public static final <R> List<C1938s> zip(boolean[] zArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(Boolean.valueOf(zArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    public static final <R> List<C1938s> zip(char[] cArr, Iterable<? extends R> other) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(J.collectionSizeOrDefault(other, 10), length));
        int i5 = 0;
        for (R r6 : other) {
            if (i5 >= length) {
                break;
            }
            arrayList.add(p147z3.A.to(Character.valueOf(cArr[i5]), r6));
            i5++;
        }
        return arrayList;
    }

    public static final List<C1938s> zip(byte[] bArr, byte[] other) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Byte.valueOf(bArr[i5]), Byte.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final List<C1938s> zip(short[] sArr, short[] other) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Short.valueOf(sArr[i5]), Short.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final List<C1938s> zip(int[] iArr, int[] other) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Integer.valueOf(iArr[i5]), Integer.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final List<C1938s> zip(long[] jArr, long[] other) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Long.valueOf(jArr[i5]), Long.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final List<C1938s> zip(float[] fArr, float[] other) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Float.valueOf(fArr[i5]), Float.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final List<C1938s> zip(double[] dArr, double[] other) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Double.valueOf(dArr[i5]), Double.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final List<C1938s> zip(boolean[] zArr, boolean[] other) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Boolean.valueOf(zArr[i5]), Boolean.valueOf(other[i5])));
        }
        return arrayList;
    }

    public static final List<C1938s> zip(char[] cArr, char[] other) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Character.valueOf(cArr[i5]), Character.valueOf(other[i5])));
        }
        return arrayList;
    }
}
