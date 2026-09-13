package A3;

import W3.InterfaceC0233q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 extends l0 {
    public static final <K, V> boolean all(Map<? extends K, ? extends V> map, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return !map.isEmpty();
    }

    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.entrySet();
    }

    public static <K, V> InterfaceC0233q asSequence(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return T.asSequence(map.entrySet());
    }

    private static final <K, V> int count(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.size();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    private static final <K, V, R> R firstNotNullOf(Map<? extends K, ? extends V> map, O3.l transform) {
        R r6;
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            r6 = (R) transform.invoke(it.next());
            if (r6 != null) {
                if (r6 != null) {
                    return r6;
                }
                throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
            }
        }
        r6 = null;
        if (r6 != null) {
            return r6;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    private static final <K, V, R> R firstNotNullOfOrNull(Map<? extends K, ? extends V> map, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R r6 = (R) transform.invoke(it.next());
            if (r6 != null) {
                return r6;
            }
        }
        return null;
    }

    public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> map, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            O.addAll(arrayList, (Iterable) transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <K, V, R> List<R> flatMapSequence(Map<? extends K, ? extends V> map, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            O.addAll(arrayList, (InterfaceC0233q) transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(Map<? extends K, ? extends V> map, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            O.addAll(destination, (InterfaceC0233q) transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> map, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            O.addAll(destination, (Iterable) transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <K, V> void forEach(Map<? extends K, ? extends V> map, O3.l action) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> map, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> map, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object objInvoke = transform.invoke(it.next());
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> map, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object objInvoke = transform.invoke(it.next());
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
        }
        return destination;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> map, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> map, O3.l selector) {
        Object obj;
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Comparable comparable = (Comparable) selector.invoke(next);
                do {
                    Object next2 = it.next();
                    Comparable comparable2 = (Comparable) selector.invoke(next2);
                    if (comparable.compareTo(comparable2) < 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrThrow(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            Comparable comparable = (Comparable) selector.invoke(next);
            do {
                Object next2 = it.next();
                Comparable comparable2 = (Comparable) selector.invoke(next2);
                if (comparable.compareTo(comparable2) < 0) {
                    next = next2;
                    comparable = comparable2;
                }
            } while (it.hasNext());
        }
        return (Map.Entry) next;
    }

    private static final <K, V> double maxOf(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(it.next())).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(it.next())).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <K, V> Double m108maxOfOrNull(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(it.next())).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) selector.invoke(it.next())).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
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

    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
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

    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return (Map.Entry) T.maxWithOrNull(map.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrThrow(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return (Map.Entry) T.maxWithOrThrow(map.entrySet(), comparator);
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> map, O3.l selector) {
        Object obj;
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Comparable comparable = (Comparable) selector.invoke(next);
                do {
                    Object next2 = it.next();
                    Comparable comparable2 = (Comparable) selector.invoke(next2);
                    if (comparable.compareTo(comparable2) > 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrThrow(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            Comparable comparable = (Comparable) selector.invoke(next);
            do {
                Object next2 = it.next();
                Comparable comparable2 = (Comparable) selector.invoke(next2);
                if (comparable.compareTo(comparable2) > 0) {
                    next = next2;
                    comparable = comparable2;
                }
            } while (it.hasNext());
        }
        return (Map.Entry) next;
    }

    private static final <K, V> double minOf(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) selector.invoke(it.next())).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(it.next())).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <K, V> Double m112minOfOrNull(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = ((Number) selector.invoke(it.next())).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) selector.invoke(it.next())).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
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

    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
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

    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return (Map.Entry) T.minWithOrNull(map.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> minWithOrThrow(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return (Map.Entry) T.minWithOrThrow(map.entrySet(), comparator);
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M m6, O3.l action) {
        kotlin.jvm.internal.E.f(m6, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        Iterator<Map.Entry<K, V>> it = m6.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        return m6;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(M m6, O3.p action) {
        kotlin.jvm.internal.E.f(m6, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int i5 = 0;
        for (Object obj : m6.entrySet()) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                I.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i5), obj);
            i5 = i6;
        }
        return m6;
    }

    public static final <K, V> List<C1938s> toList(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.E.f(map, "<this>");
        if (map.size() == 0) {
            return I.emptyList();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return I.emptyList();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return G.listOf(new C1938s(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new C1938s(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new C1938s(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> map, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <K, V> int count(Map<? extends K, ? extends V> map, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <K, V> float m106maxOf(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) selector.invoke(it.next())).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(it.next())).floatValue());
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <K, V> Float m109maxOfOrNull(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(it.next())).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) selector.invoke(it.next())).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <K, V> float m110minOf(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) selector.invoke(it.next())).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(it.next())).floatValue());
        }
        return fFloatValue;
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <K, V> Float m113minOfOrNull(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) selector.invoke(it.next())).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) selector.invoke(it.next())).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> map, O3.l predicate) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <K, V, R extends Comparable<? super R>> R m107maxOf(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R r6 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Comparable comparable = (Comparable) selector.invoke(it.next());
            if (r6.compareTo(comparable) < 0) {
                r6 = (R) comparable;
            }
        }
        return r6;
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R r6 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Comparable comparable = (Comparable) selector.invoke(it.next());
            if (r6.compareTo(comparable) < 0) {
                r6 = (R) comparable;
            }
        }
        return r6;
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <K, V, R extends Comparable<? super R>> R m111minOf(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R r6 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Comparable comparable = (Comparable) selector.invoke(it.next());
            if (r6.compareTo(comparable) > 0) {
                r6 = (R) comparable;
            }
        }
        return r6;
    }

    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(Map<? extends K, ? extends V> map, O3.l selector) {
        kotlin.jvm.internal.E.f(map, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R r6 = (R) selector.invoke(it.next());
        while (it.hasNext()) {
            Comparable comparable = (Comparable) selector.invoke(it.next());
            if (r6.compareTo(comparable) > 0) {
                r6 = (R) comparable;
            }
        }
        return r6;
    }
}
