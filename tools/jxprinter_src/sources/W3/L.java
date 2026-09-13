package W3;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.B0;
import A3.C0130a;
import A3.InterfaceC0131a0;
import A3.T;
import A3.v0;
import A3.w0;
import java.io.IOException;
import java.util.ArrayList;
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
public abstract class L extends A {
    public static final <T> boolean all(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        while (itB.hasNext()) {
            if (!((Boolean) lVar.invoke(itB.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        while (itB.hasNext()) {
            if (((Boolean) lVar.invoke(itB.next())).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterable<T> asIterable(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return new A3.A(interfaceC0233q, 10);
    }

    private static final <T> InterfaceC0233q asSequence(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return interfaceC0233q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(InterfaceC0233q interfaceC0233q, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            C1938s c1938s = (C1938s) transform.invoke(it.next());
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, T> associateBy(InterfaceC0233q interfaceC0233q, O3.l keySelector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : interfaceC0233q) {
            linkedHashMap.put(keySelector.invoke(obj), obj);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(InterfaceC0233q interfaceC0233q, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (Object obj : interfaceC0233q) {
            destination.put(keySelector.invoke(obj), obj);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(InterfaceC0233q interfaceC0233q, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            C1938s c1938s = (C1938s) transform.invoke(it.next());
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateWith(InterfaceC0233q interfaceC0233q, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : interfaceC0233q) {
            linkedHashMap.put(obj, valueSelector.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(InterfaceC0233q interfaceC0233q, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (Object obj : interfaceC0233q) {
            destination.put(obj, valueSelector.invoke(obj));
        }
        return destination;
    }

    public static final double averageOfByte(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        double dByteValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dByteValue += (double) ((Number) it.next()).byteValue();
            i5++;
            if (i5 < 0) {
                A3.I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i5);
    }

    public static final double averageOfDouble(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        double dDoubleValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dDoubleValue += ((Number) it.next()).doubleValue();
            i5++;
            if (i5 < 0) {
                A3.I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i5);
    }

    public static final double averageOfFloat(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        double dFloatValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) ((Number) it.next()).floatValue();
            i5++;
            if (i5 < 0) {
                A3.I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i5);
    }

    public static final double averageOfInt(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        double dIntValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dIntValue += (double) ((Number) it.next()).intValue();
            i5++;
            if (i5 < 0) {
                A3.I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i5);
    }

    public static final double averageOfLong(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        double dLongValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dLongValue += ((Number) it.next()).longValue();
            i5++;
            if (i5 < 0) {
                A3.I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i5);
    }

    public static final double averageOfShort(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        double dShortValue = 0.0d;
        int i5 = 0;
        while (it.hasNext()) {
            dShortValue += (double) ((Number) it.next()).shortValue();
            i5++;
            if (i5 < 0) {
                A3.I.throwCountOverflow();
            }
        }
        if (i5 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i5);
    }

    public static final <T> InterfaceC0233q chunked(InterfaceC0233q interfaceC0233q, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return windowed(interfaceC0233q, i5, i5, true);
    }

    public static <T> boolean contains(InterfaceC0233q interfaceC0233q, T t6) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return indexOf(interfaceC0233q, t6) >= 0;
    }

    public static final <T> int count(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        int i5 = 0;
        while (itB.hasNext()) {
            if (((Boolean) lVar.invoke(itB.next())).booleanValue() && (i5 = i5 + 1) < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
                A3.I.throwCountOverflow();
            }
        }
        return i5;
    }

    public static final <T> InterfaceC0233q distinct(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return distinctBy(interfaceC0233q, new S2.l(3));
    }

    public static final <T, K> InterfaceC0233q distinctBy(InterfaceC0233q interfaceC0233q, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return new C0219c(interfaceC0233q, selector);
    }

    public static final <T> InterfaceC0233q drop(InterfaceC0233q interfaceC0233q, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return interfaceC0233q;
        }
        return interfaceC0233q instanceof InterfaceC0222f ? ((InterfaceC0222f) interfaceC0233q).drop(i5) : new C0221e(interfaceC0233q, i5);
    }

    public static final <T> InterfaceC0233q dropWhile(InterfaceC0233q interfaceC0233q, O3.l predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return new C0224h(interfaceC0233q, predicate);
    }

    public static final <T> T elementAt(InterfaceC0233q interfaceC0233q, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return (T) elementAtOrElse(interfaceC0233q, i5, new A3.S(i5, 1));
    }

    public static final <T> T elementAtOrElse(InterfaceC0233q interfaceC0233q, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        if (i5 < 0) {
            return (T) defaultValue.invoke(Integer.valueOf(i5));
        }
        Iterator<Object> it = interfaceC0233q.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            T t6 = (T) it.next();
            int i7 = i6 + 1;
            if (i5 == i6) {
                return t6;
            }
            i6 = i7;
        }
        return (T) defaultValue.invoke(Integer.valueOf(i5));
    }

    public static final <T> T elementAtOrNull(InterfaceC0233q interfaceC0233q, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        if (i5 < 0) {
            return null;
        }
        Iterator<Object> it = interfaceC0233q.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            T t6 = (T) it.next();
            int i7 = i6 + 1;
            if (i5 == i6) {
                return t6;
            }
            i6 = i7;
        }
        return null;
    }

    public static final <T> InterfaceC0233q filter(InterfaceC0233q interfaceC0233q, O3.l predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return new C0226j(interfaceC0233q, true, predicate);
    }

    public static final <T> InterfaceC0233q filterIndexed(InterfaceC0233q interfaceC0233q, O3.p predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return new S(new C0226j(new C0230n(interfaceC0233q), true, new C0130a(predicate, 6)), new S2.l(4));
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(InterfaceC0233q interfaceC0233q, C destination, O3.p predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (Object obj : interfaceC0233q) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            if (((Boolean) predicate.invoke(Integer.valueOf(i5), obj)).booleanValue()) {
                destination.add(obj);
            }
            i5 = i6;
        }
        return destination;
    }

    public static final <T> InterfaceC0233q filterNot(InterfaceC0233q interfaceC0233q, O3.l predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return new C0226j(interfaceC0233q, false, predicate);
    }

    public static final <T> InterfaceC0233q filterNotNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        InterfaceC0233q interfaceC0233qFilterNot = filterNot(interfaceC0233q, new S2.l(5));
        kotlin.jvm.internal.E.d(interfaceC0233qFilterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return interfaceC0233qFilterNot;
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(InterfaceC0233q interfaceC0233q, C destination) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (Object obj : interfaceC0233q) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(InterfaceC0233q interfaceC0233q, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (Object obj : interfaceC0233q) {
            if (!((Boolean) predicate.invoke(obj)).booleanValue()) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(InterfaceC0233q interfaceC0233q, C destination, O3.l predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (Object obj : interfaceC0233q) {
            if (((Boolean) predicate.invoke(obj)).booleanValue()) {
                destination.add(obj);
            }
        }
        return destination;
    }

    private static final <T> T find(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        while (itB.hasNext()) {
            T t6 = (T) itB.next();
            if (((Boolean) lVar.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        return null;
    }

    private static final <T> T findLast(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        T t6 = null;
        while (itB.hasNext()) {
            Object next = itB.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                t6 = (T) next;
            }
        }
        return t6;
    }

    public static final <T> T first(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        while (itB.hasNext()) {
            T t6 = (T) itB.next();
            if (((Boolean) lVar.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    private static final <T, R> R firstNotNullOf(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        R r6;
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "transform");
        while (itB.hasNext()) {
            r6 = (R) lVar.invoke(itB.next());
            if (r6 != null) {
                if (r6 != null) {
                    return r6;
                }
                throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
            }
        }
        r6 = null;
        if (r6 != null) {
            return r6;
        }
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    }

    private static final <T, R> R firstNotNullOfOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "transform");
        while (itB.hasNext()) {
            R r6 = (R) lVar.invoke(itB.next());
            if (r6 != null) {
                return r6;
            }
        }
        return null;
    }

    public static final <T> T firstOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        while (itB.hasNext()) {
            T t6 = (T) itB.next();
            if (((Boolean) lVar.invoke(t6)).booleanValue()) {
                return t6;
            }
        }
        return null;
    }

    public static final <T, R> InterfaceC0233q flatMap(InterfaceC0233q interfaceC0233q, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return new C0227k(interfaceC0233q, transform, D.f794a);
    }

    public static final <T, R> InterfaceC0233q flatMapIndexedIterable(InterfaceC0233q interfaceC0233q, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return z.flatMapIndexed(interfaceC0233q, transform, E.f795a);
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(InterfaceC0233q interfaceC0233q, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        for (Object obj : interfaceC0233q) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            A3.O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i5), obj));
            i5 = i6;
        }
        return destination;
    }

    public static final <T, R> InterfaceC0233q flatMapIndexedSequence(InterfaceC0233q interfaceC0233q, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return z.flatMapIndexed(interfaceC0233q, transform, F.f796a);
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(InterfaceC0233q interfaceC0233q, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        for (Object obj : interfaceC0233q) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            A3.O.addAll(destination, (InterfaceC0233q) transform.invoke(Integer.valueOf(i5), obj));
            i5 = i6;
        }
        return destination;
    }

    public static final <T, R> InterfaceC0233q flatMapIterable(InterfaceC0233q interfaceC0233q, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return new C0227k(interfaceC0233q, transform, C.f793a);
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapIterableTo(InterfaceC0233q interfaceC0233q, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            A3.O.addAll(destination, (Iterable) transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(InterfaceC0233q interfaceC0233q, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            A3.O.addAll(destination, (InterfaceC0233q) transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R> R fold(InterfaceC0233q interfaceC0233q, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            r6 = (R) operation.invoke(r6, it.next());
        }
        return r6;
    }

    public static final <T, R> R foldIndexed(InterfaceC0233q interfaceC0233q, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int i5 = 0;
        for (Object obj : interfaceC0233q) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, obj);
            i5 = i6;
        }
        return r6;
    }

    public static final <T> void forEach(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "action");
        while (itB.hasNext()) {
            lVar.invoke(itB.next());
        }
    }

    public static final <T> void forEachIndexed(InterfaceC0233q interfaceC0233q, O3.p action) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int i5 = 0;
        for (Object obj : interfaceC0233q) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i5), obj);
            i5 = i6;
        }
    }

    public static final <T, K> Map<K, List<T>> groupBy(InterfaceC0233q interfaceC0233q, O3.l keySelector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : interfaceC0233q) {
            Object objInvoke = keySelector.invoke(obj);
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(obj);
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(InterfaceC0233q interfaceC0233q, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (Object obj : interfaceC0233q) {
            Object objInvoke = keySelector.invoke(obj);
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(obj);
        }
        return destination;
    }

    public static final <T, K> InterfaceC0131a0 groupingBy(InterfaceC0233q interfaceC0233q, O3.l keySelector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        return new S4.h(interfaceC0233q, keySelector, 5);
    }

    public static final <T> int indexOf(InterfaceC0233q interfaceC0233q, T t6) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        int i5 = 0;
        for (Object obj : interfaceC0233q) {
            if (i5 < 0) {
                A3.I.throwIndexOverflow();
            }
            if (kotlin.jvm.internal.E.a(t6, obj)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        int i5 = 0;
        while (itB.hasNext()) {
            Object next = itB.next();
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        int i5 = -1;
        int i6 = 0;
        while (itB.hasNext()) {
            Object next = itB.next();
            if (i6 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                i5 = i6;
            }
            i6++;
        }
        return i5;
    }

    public static final <T, A extends Appendable> A joinTo(InterfaceC0233q interfaceC0233q, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) throws IOException {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(buffer, "buffer");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        buffer.append(prefix);
        int i6 = 0;
        for (Object obj : interfaceC0233q) {
            i6++;
            if (i6 > 1) {
                buffer.append(separator);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            X3.M.appendElement(buffer, obj, lVar);
        }
        if (i5 >= 0 && i6 > i5) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String joinToString(InterfaceC0233q interfaceC0233q, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated, O3.l lVar) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(separator, "separator");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(postfix, "postfix");
        kotlin.jvm.internal.E.f(truncated, "truncated");
        return ((StringBuilder) joinTo(interfaceC0233q, new StringBuilder(), separator, prefix, postfix, i5, truncated, lVar)).toString();
    }

    public static final <T> T last(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        T t6 = null;
        boolean z6 = false;
        while (itB.hasNext()) {
            Object next = itB.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                z6 = true;
                t6 = (T) next;
            }
        }
        if (z6) {
            return t6;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(InterfaceC0233q interfaceC0233q, T t6) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        int i5 = -1;
        int i6 = 0;
        for (Object obj : interfaceC0233q) {
            if (i6 < 0) {
                A3.I.throwIndexOverflow();
            }
            if (kotlin.jvm.internal.E.a(t6, obj)) {
                i5 = i6;
            }
            i6++;
        }
        return i5;
    }

    public static final <T> T lastOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        T t6 = null;
        while (itB.hasNext()) {
            Object next = itB.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                t6 = (T) next;
            }
        }
        return t6;
    }

    public static <T, R> InterfaceC0233q map(InterfaceC0233q interfaceC0233q, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return new S(interfaceC0233q, transform);
    }

    public static final <T, R> InterfaceC0233q mapIndexed(InterfaceC0233q interfaceC0233q, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return new P(interfaceC0233q, transform);
    }

    public static final <T, R> InterfaceC0233q mapIndexedNotNull(InterfaceC0233q interfaceC0233q, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return filterNotNull(new P(interfaceC0233q, transform));
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(InterfaceC0233q interfaceC0233q, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        for (Object obj : interfaceC0233q) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            Object objInvoke = transform.invoke(Integer.valueOf(i5), obj);
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
            i5 = i6;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(InterfaceC0233q interfaceC0233q, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        for (Object obj : interfaceC0233q) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            destination.add(transform.invoke(Integer.valueOf(i5), obj));
            i5 = i6;
        }
        return destination;
    }

    public static <T, R> InterfaceC0233q mapNotNull(InterfaceC0233q interfaceC0233q, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return filterNotNull(new S(interfaceC0233q, transform));
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(InterfaceC0233q interfaceC0233q, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            Object objInvoke = transform.invoke(it.next());
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(InterfaceC0233q interfaceC0233q, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
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

    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            throw new NoSuchElementException();
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

    private static final <T> double maxOf(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) lVar.invoke(itB.next())).doubleValue();
        while (itB.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) lVar.invoke(itB.next())).doubleValue());
        }
        return dDoubleValue;
    }

    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            return null;
        }
        R r6 = (R) lVar.invoke(itB.next());
        while (itB.hasNext()) {
            Comparable comparable = (Comparable) lVar.invoke(itB.next());
            if (r6.compareTo(comparable) < 0) {
                r6 = (R) comparable;
            }
        }
        return r6;
    }

    private static final <T, R> R maxOfWith(InterfaceC0233q interfaceC0233q, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<Object> it = interfaceC0233q.iterator();
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

    private static final <T, R> R maxOfWithOrNull(InterfaceC0233q interfaceC0233q, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<Object> it = interfaceC0233q.iterator();
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
    public static final Double m864maxOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double maxOrThrow(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    public static final <T> T maxWithOrNull(InterfaceC0233q interfaceC0233q, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t6 = (T) it.next();
        while (it.hasNext()) {
            Object next = it.next();
            if (comparator.compare(t6, next) < 0) {
                t6 = (T) next;
            }
        }
        return t6;
    }

    public static final <T> T maxWithOrThrow(InterfaceC0233q interfaceC0233q, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T t6 = (T) it.next();
        while (it.hasNext()) {
            Object next = it.next();
            if (comparator.compare(t6, next) < 0) {
                t6 = (T) next;
            }
        }
        return t6;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
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

    public static final <T, R extends Comparable<? super R>> T minByOrThrow(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            throw new NoSuchElementException();
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

    private static final <T> double minOf(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) lVar.invoke(itB.next())).doubleValue();
        while (itB.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) lVar.invoke(itB.next())).doubleValue());
        }
        return dDoubleValue;
    }

    private static final <T, R extends Comparable<? super R>> R minOfOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            return null;
        }
        R r6 = (R) lVar.invoke(itB.next());
        while (itB.hasNext()) {
            Comparable comparable = (Comparable) lVar.invoke(itB.next());
            if (r6.compareTo(comparable) > 0) {
                r6 = (R) comparable;
            }
        }
        return r6;
    }

    private static final <T, R> R minOfWith(InterfaceC0233q interfaceC0233q, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<Object> it = interfaceC0233q.iterator();
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

    private static final <T, R> R minOfWithOrNull(InterfaceC0233q interfaceC0233q, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<Object> it = interfaceC0233q.iterator();
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
    public static final Double m872minOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final double minOrThrow(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    public static final <T> T minWithOrNull(InterfaceC0233q interfaceC0233q, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t6 = (T) it.next();
        while (it.hasNext()) {
            Object next = it.next();
            if (comparator.compare(t6, next) > 0) {
                t6 = (T) next;
            }
        }
        return t6;
    }

    public static final <T> T minWithOrThrow(InterfaceC0233q interfaceC0233q, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T t6 = (T) it.next();
        while (it.hasNext()) {
            Object next = it.next();
            if (comparator.compare(t6, next) > 0) {
                t6 = (T) next;
            }
        }
        return t6;
    }

    public static final <T> InterfaceC0233q minus(InterfaceC0233q interfaceC0233q, T t6) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return new H(interfaceC0233q, t6, 0);
    }

    private static final <T> InterfaceC0233q minusElement(InterfaceC0233q interfaceC0233q, T t6) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return minus(interfaceC0233q, t6);
    }

    public static final <T> boolean none(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        while (itB.hasNext()) {
            if (((Boolean) lVar.invoke(itB.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> InterfaceC0233q onEach(InterfaceC0233q interfaceC0233q, O3.l action) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        return map(interfaceC0233q, new B(0, action));
    }

    public static final <T> InterfaceC0233q onEachIndexed(InterfaceC0233q interfaceC0233q, O3.p action) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        return mapIndexed(interfaceC0233q, new L3.s(action, 1));
    }

    public static final <T> C1938s partition(InterfaceC0233q interfaceC0233q, O3.l predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : interfaceC0233q) {
            if (((Boolean) predicate.invoke(obj)).booleanValue()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        return new C1938s(arrayList, arrayList2);
    }

    public static final <T> InterfaceC0233q plus(InterfaceC0233q interfaceC0233q, T t6) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return z.flatten(z.sequenceOf(interfaceC0233q, z.sequenceOf(t6)));
    }

    private static final <T> InterfaceC0233q plusElement(InterfaceC0233q interfaceC0233q, T t6) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return plus(interfaceC0233q, t6);
    }

    public static final <S, T extends S> S reduce(InterfaceC0233q interfaceC0233q, O3.p operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S s6 = (S) it.next();
        while (it.hasNext()) {
            s6 = (S) operation.invoke(s6, it.next());
        }
        return s6;
    }

    public static final <S, T extends S> S reduceIndexed(InterfaceC0233q interfaceC0233q, O3.q operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S s6 = (S) it.next();
        int i5 = 1;
        while (it.hasNext()) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            s6 = (S) operation.invoke(Integer.valueOf(i5), s6, it.next());
            i5 = i6;
        }
        return s6;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(InterfaceC0233q interfaceC0233q, O3.q operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S s6 = (S) it.next();
        int i5 = 1;
        while (it.hasNext()) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                A3.I.throwIndexOverflow();
            }
            s6 = (S) operation.invoke(Integer.valueOf(i5), s6, it.next());
            i5 = i6;
        }
        return s6;
    }

    public static final <S, T extends S> S reduceOrNull(InterfaceC0233q interfaceC0233q, O3.p operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S s6 = (S) it.next();
        while (it.hasNext()) {
            s6 = (S) operation.invoke(s6, it.next());
        }
        return s6;
    }

    public static final <T> InterfaceC0233q requireNoNulls(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return map(interfaceC0233q, new C0130a(interfaceC0233q, 5));
    }

    public static final <T, R> InterfaceC0233q runningFold(InterfaceC0233q interfaceC0233q, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        return t.sequence(new I(r6, interfaceC0233q, operation, null));
    }

    public static final <T, R> InterfaceC0233q runningFoldIndexed(InterfaceC0233q interfaceC0233q, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        return t.sequence(new J(r6, interfaceC0233q, operation, null));
    }

    public static final <S, T extends S> InterfaceC0233q runningReduce(InterfaceC0233q interfaceC0233q, O3.p operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        return t.sequence(new K(interfaceC0233q, operation, null, 0));
    }

    public static final <S, T extends S> InterfaceC0233q runningReduceIndexed(InterfaceC0233q interfaceC0233q, O3.q operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        return t.sequence(new w(interfaceC0233q, operation, null));
    }

    public static final <T, R> InterfaceC0233q scan(InterfaceC0233q interfaceC0233q, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        return runningFold(interfaceC0233q, r6, operation);
    }

    public static final <T, R> InterfaceC0233q scanIndexed(InterfaceC0233q interfaceC0233q, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        return runningFoldIndexed(interfaceC0233q, r6, operation);
    }

    public static final <T> T single(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        T t6 = null;
        boolean z6 = false;
        while (itB.hasNext()) {
            Object next = itB.next();
            if (((Boolean) lVar.invoke(next)).booleanValue()) {
                if (z6) {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
                z6 = true;
                t6 = (T) next;
            }
        }
        if (z6) {
            return t6;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> T singleOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "predicate");
        boolean z6 = false;
        T t6 = null;
        while (itB.hasNext()) {
            Object next = itB.next();
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

    public static final <T extends Comparable<? super T>> InterfaceC0233q sorted(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return new A3.B(interfaceC0233q, 12);
    }

    public static final <T, R extends Comparable<? super R>> InterfaceC0233q sortedBy(InterfaceC0233q interfaceC0233q, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(interfaceC0233q, new D3.d(0, selector));
    }

    public static final <T, R extends Comparable<? super R>> InterfaceC0233q sortedByDescending(InterfaceC0233q interfaceC0233q, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        return sortedWith(interfaceC0233q, new D3.d(1, selector));
    }

    public static final <T extends Comparable<? super T>> InterfaceC0233q sortedDescending(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return sortedWith(interfaceC0233q, D3.g.reverseOrder());
    }

    public static final <T> InterfaceC0233q sortedWith(InterfaceC0233q interfaceC0233q, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return new H(interfaceC0233q, comparator, 4);
    }

    public static final <T> int sumBy(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        int iIntValue = 0;
        while (itB.hasNext()) {
            iIntValue += ((Number) lVar.invoke(itB.next())).intValue();
        }
        return iIntValue;
    }

    public static final <T> double sumByDouble(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        double dDoubleValue = 0.0d;
        while (itB.hasNext()) {
            dDoubleValue += ((Number) lVar.invoke(itB.next())).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfByte(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += ((Number) it.next()).byteValue();
        }
        return iByteValue;
    }

    private static final <T> double sumOfDouble(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        double dDoubleValue = 0.0d;
        while (itB.hasNext()) {
            dDoubleValue += ((Number) lVar.invoke(itB.next())).doubleValue();
        }
        return dDoubleValue;
    }

    public static final float sumOfFloat(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += ((Number) it.next()).floatValue();
        }
        return fFloatValue;
    }

    private static final <T> int sumOfInt(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        int iIntValue = 0;
        while (itB.hasNext()) {
            iIntValue += ((Number) lVar.invoke(itB.next())).intValue();
        }
        return iIntValue;
    }

    private static final <T> long sumOfLong(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        long jLongValue = 0;
        while (itB.hasNext()) {
            jLongValue += ((Number) lVar.invoke(itB.next())).longValue();
        }
        return jLongValue;
    }

    public static final int sumOfShort(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += ((Number) it.next()).shortValue();
        }
        return iShortValue;
    }

    private static final <T> int sumOfUInt(InterfaceC0233q interfaceC0233q, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) selector.invoke(it.next())).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final <T> long sumOfULong(InterfaceC0233q interfaceC0233q, O3.l selector) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) selector.invoke(it.next())).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final <T> InterfaceC0233q take(InterfaceC0233q interfaceC0233q, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested element count ", " is less than zero.").toString());
        }
        if (i5 == 0) {
            return z.emptySequence();
        }
        return interfaceC0233q instanceof InterfaceC0222f ? ((InterfaceC0222f) interfaceC0233q).take(i5) : new N(interfaceC0233q, i5);
    }

    public static final <T> InterfaceC0233q takeWhile(InterfaceC0233q interfaceC0233q, O3.l predicate) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        return new O(interfaceC0233q, predicate);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(InterfaceC0233q interfaceC0233q, C destination) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static final <T> HashSet<T> toHashSet(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return (HashSet) toCollection(interfaceC0233q, new HashSet());
    }

    public static <T> List<T> toList(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return A3.I.emptyList();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return A3.G.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static final <T> List<T> toMutableList(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return (List) toCollection(interfaceC0233q, new ArrayList());
    }

    public static final <T> Set<T> toMutableSet(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Object> it = interfaceC0233q.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static final <T> Set<T> toSet(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return w0.emptySet();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return v0.setOf(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static final <T> InterfaceC0233q windowed(InterfaceC0233q interfaceC0233q, int i5, int i6, boolean z6) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return B0.windowedSequence(interfaceC0233q, i5, i6, z6, false);
    }

    public static final <T> InterfaceC0233q withIndex(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return new C0230n(interfaceC0233q);
    }

    public static final <T, R> InterfaceC0233q zip(InterfaceC0233q interfaceC0233q, InterfaceC0233q other) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        return new C0232p(interfaceC0233q, other, new E3.d(2));
    }

    public static final <T> InterfaceC0233q zipWithNext(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return zipWithNext(interfaceC0233q, new E3.d(3));
    }

    public static final <T, R> InterfaceC0233q chunked(InterfaceC0233q interfaceC0233q, int i5, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return windowed(interfaceC0233q, i5, i5, true, transform);
    }

    public static final <T> InterfaceC0233q minus(InterfaceC0233q interfaceC0233q, T[] elements) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return elements.length == 0 ? interfaceC0233q : new H(interfaceC0233q, elements, 1);
    }

    public static final <T> InterfaceC0233q plus(InterfaceC0233q interfaceC0233q, T[] elements) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return plus(interfaceC0233q, (Iterable) AbstractC0151t.asList(elements));
    }

    public static final <T, R> InterfaceC0233q windowed(InterfaceC0233q interfaceC0233q, int i5, int i6, boolean z6, O3.l transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return map(B0.windowedSequence(interfaceC0233q, i5, i6, z6, true), transform);
    }

    public static final <T, R, V> InterfaceC0233q zip(InterfaceC0233q interfaceC0233q, InterfaceC0233q other, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        return new C0232p(interfaceC0233q, other, transform);
    }

    public static final <T, R> InterfaceC0233q zipWithNext(InterfaceC0233q interfaceC0233q, O3.p transform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return t.sequence(new K(interfaceC0233q, transform, null, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(InterfaceC0233q interfaceC0233q, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (Object obj : interfaceC0233q) {
            destination.put(keySelector.invoke(obj), valueTransform.invoke(obj));
        }
        return destination;
    }

    public static final <T> InterfaceC0233q plus(InterfaceC0233q interfaceC0233q, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return z.flatten(z.sequenceOf(interfaceC0233q, T.asSequence(elements)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associateBy(InterfaceC0233q interfaceC0233q, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : interfaceC0233q) {
            linkedHashMap.put(keySelector.invoke(obj), valueTransform.invoke(obj));
        }
        return linkedHashMap;
    }

    public static final <T> InterfaceC0233q minus(InterfaceC0233q interfaceC0233q, Iterable<? extends T> elements) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return new H(elements, interfaceC0233q);
    }

    public static final <T> InterfaceC0233q plus(InterfaceC0233q interfaceC0233q, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return z.flatten(z.sequenceOf(interfaceC0233q, elements));
    }

    public static final <T> InterfaceC0233q minus(InterfaceC0233q interfaceC0233q, InterfaceC0233q elements) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        return new H(elements, interfaceC0233q, 3);
    }

    public static final <T> boolean any(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return interfaceC0233q.iterator().hasNext();
    }

    public static final <T> int count(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            it.next();
            i5++;
            if (i5 < 0) {
                A3.I.throwCountOverflow();
            }
        }
        return i5;
    }

    public static <T> T firstOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        return null;
    }

    public static final <T> boolean none(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        return !interfaceC0233q.iterator().hasNext();
    }

    public static final <T> T first(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> T lastOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t6 = (T) it.next();
        while (it.hasNext()) {
            t6 = (T) it.next();
        }
        return t6;
    }

    public static final <T> T singleOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t6 = (T) it.next();
        if (it.hasNext()) {
            return null;
        }
        return t6;
    }

    public static final double sumOfDouble(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += ((Number) it.next()).doubleValue();
        }
        return dDoubleValue;
    }

    public static final int sumOfInt(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Number) it.next()).intValue();
        }
        return iIntValue;
    }

    public static final long sumOfLong(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += ((Number) it.next()).longValue();
        }
        return jLongValue;
    }

    public static final <T> T last(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (it.hasNext()) {
            T t6 = (T) it.next();
            while (it.hasNext()) {
                t6 = (T) it.next();
            }
            return t6;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m865maxOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final float m866maxOrThrow(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (it.hasNext()) {
            float fFloatValue = ((Number) it.next()).floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.max(fFloatValue, ((Number) it.next()).floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Float m873minOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final float m874minOrThrow(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (it.hasNext()) {
            float fFloatValue = ((Number) it.next()).floatValue();
            while (it.hasNext()) {
                fFloatValue = Math.min(fFloatValue, ((Number) it.next()).floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final <T> T single(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (it.hasNext()) {
            T t6 = (T) it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Sequence has more than one element.");
            }
            return t6;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(InterfaceC0233q interfaceC0233q, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (Object obj : interfaceC0233q) {
            Object objInvoke = keySelector.invoke(obj);
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(obj));
        }
        return destination;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m862maxOfOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) lVar.invoke(itB.next())).doubleValue();
        while (itB.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) lVar.invoke(itB.next())).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m870minOfOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) lVar.invoke(itB.next())).doubleValue();
        while (itB.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) lVar.invoke(itB.next())).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T, K, V> Map<K, List<V>> groupBy(InterfaceC0233q interfaceC0233q, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : interfaceC0233q) {
            Object objInvoke = keySelector.invoke(obj);
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m860maxOf(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (itB.hasNext()) {
            float fFloatValue = ((Number) lVar.invoke(itB.next())).floatValue();
            while (itB.hasNext()) {
                fFloatValue = Math.max(fFloatValue, ((Number) lVar.invoke(itB.next())).floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m868minOf(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (itB.hasNext()) {
            float fFloatValue = ((Number) lVar.invoke(itB.next())).floatValue();
            while (itB.hasNext()) {
                fFloatValue = Math.min(fFloatValue, ((Number) lVar.invoke(itB.next())).floatValue());
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t6 = (T) it.next();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) it.next();
            if (t6.compareTo(comparable) < 0) {
                t6 = (T) comparable;
            }
        }
        return t6;
    }

    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m867maxOrThrow(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (it.hasNext()) {
            T t6 = (T) it.next();
            while (it.hasNext()) {
                Comparable comparable = (Comparable) it.next();
                if (t6.compareTo(comparable) < 0) {
                    t6 = (T) comparable;
                }
            }
            return t6;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> T minOrNull(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t6 = (T) it.next();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) it.next();
            if (t6.compareTo(comparable) > 0) {
                t6 = (T) comparable;
            }
        }
        return t6;
    }

    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m875minOrThrow(InterfaceC0233q interfaceC0233q) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        Iterator<Object> it = interfaceC0233q.iterator();
        if (it.hasNext()) {
            T t6 = (T) it.next();
            while (it.hasNext()) {
                Comparable comparable = (Comparable) it.next();
                if (t6.compareTo(comparable) > 0) {
                    t6 = (T) comparable;
                }
            }
            return t6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m863maxOfOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) lVar.invoke(itB.next())).floatValue();
        while (itB.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) lVar.invoke(itB.next())).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m871minOfOrNull(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (!itB.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) lVar.invoke(itB.next())).floatValue();
        while (itB.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) lVar.invoke(itB.next())).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m861maxOf(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (itB.hasNext()) {
            R r6 = (R) lVar.invoke(itB.next());
            while (itB.hasNext()) {
                Comparable comparable = (Comparable) lVar.invoke(itB.next());
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m869minOf(InterfaceC0233q interfaceC0233q, O3.l lVar) {
        Iterator itB = AbstractC0157z.B(interfaceC0233q, "<this>", lVar, "selector");
        if (itB.hasNext()) {
            R r6 = (R) lVar.invoke(itB.next());
            while (itB.hasNext()) {
                Comparable comparable = (Comparable) lVar.invoke(itB.next());
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }
}
