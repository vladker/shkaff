package org.apache.commons.collections4;

import A3.AbstractC0157z;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CollectionUtils {
    public static final Collection EMPTY_COLLECTION = Collections.EMPTY_LIST;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CardinalityHelper<O> {
        final Map<O, Integer> cardinalityA;
        final Map<O, Integer> cardinalityB;

        public CardinalityHelper(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
            this.cardinalityA = CollectionUtils.getCardinalityMap(iterable);
            this.cardinalityB = CollectionUtils.getCardinalityMap(iterable2);
        }

        private int getFreq(Object obj, Map<?, Integer> map) {
            Integer num = map.get(obj);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        public int freqA(Object obj) {
            return getFreq(obj, this.cardinalityA);
        }

        public int freqB(Object obj) {
            return getFreq(obj, this.cardinalityB);
        }

        public final int max(Object obj) {
            return Math.max(freqA(obj), freqB(obj));
        }

        public final int min(Object obj) {
            return Math.min(freqA(obj), freqB(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class EquatorWrapper<O> {
        private final Equator<? super O> equator;
        private final O object;

        public EquatorWrapper(Equator<? super O> equator, O o6) {
            this.equator = equator;
            this.object = o6;
        }

        public boolean equals(Object obj) {
            if (obj instanceof EquatorWrapper) {
                return this.equator.equate(this.object, (Object) ((EquatorWrapper) obj).getObject());
            }
            return false;
        }

        public O getObject() {
            return this.object;
        }

        public int hashCode() {
            return this.equator.hash(this.object);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SetOperationCardinalityHelper<O> extends CardinalityHelper<O> implements Iterable<O> {
        private final Set<O> elements;
        private final List<O> newList;

        public SetOperationCardinalityHelper(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
            super(iterable, iterable2);
            HashSet hashSet = new HashSet();
            this.elements = hashSet;
            CollectionUtils.addAll(hashSet, iterable);
            CollectionUtils.addAll(hashSet, iterable2);
            this.newList = new ArrayList(hashSet.size());
        }

        @Override // java.lang.Iterable
        public Iterator<O> iterator() {
            return this.elements.iterator();
        }

        public Collection<O> list() {
            return this.newList;
        }

        public void setCardinality(O o6, int i5) {
            for (int i6 = 0; i6 < i5; i6++) {
                this.newList.add(o6);
            }
        }
    }

    private CollectionUtils() {
    }

    public static <C> boolean addAll(Collection<C> collection, Iterable<? extends C> iterable) {
        return iterable instanceof Collection ? collection.addAll((Collection) iterable) : addAll(collection, iterable.iterator());
    }

    public static <T> boolean addIgnoreNull(Collection<T> collection, T t6) {
        if (collection != null) {
            return t6 != null && collection.add(t6);
        }
        throw new NullPointerException("The collection must not be null");
    }

    @Deprecated
    public static <O> int cardinality(O o6, Iterable<? super O> iterable) {
        if (iterable != null) {
            return IterableUtils.frequency(iterable, o6);
        }
        throw new NullPointerException("coll must not be null.");
    }

    public static void checkIndexBounds(int i5) {
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "Index cannot be negative: "));
        }
    }

    public static <O extends Comparable<? super O>> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        return collate(iterable, iterable2, ComparatorUtils.naturalComparator(), true);
    }

    public static <I, O> Collection<O> collect(Iterable<I> iterable, Transformer<? super I, ? extends O> transformer) {
        return collect(iterable, transformer, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static boolean containsAll(Collection<?> collection, Collection<?> collection2) {
        if (collection2.isEmpty()) {
            return true;
        }
        HashSet hashSet = new HashSet();
        for (Object obj : collection2) {
            if (!hashSet.contains(obj)) {
                for (Object obj2 : collection) {
                    hashSet.add(obj2);
                    if (obj == null) {
                        if (obj2 == null) {
                        }
                    } else if (obj.equals(obj2)) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(Collection<?> collection, T... tArr) {
        if (collection.size() < tArr.length) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (ArrayUtils.contains(tArr, it.next())) {
                    return true;
                }
            }
        } else {
            for (T t6 : tArr) {
                if (collection.contains(t6)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Deprecated
    public static <C> int countMatches(Iterable<C> iterable, Predicate<? super C> predicate) {
        if (predicate == null) {
            return 0;
        }
        return (int) IterableUtils.countMatches(iterable, predicate);
    }

    public static <O> Collection<O> disjunction(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        SetOperationCardinalityHelper setOperationCardinalityHelper = new SetOperationCardinalityHelper(iterable, iterable2);
        for (O o6 : setOperationCardinalityHelper) {
            setOperationCardinalityHelper.setCardinality(o6, setOperationCardinalityHelper.max(o6) - setOperationCardinalityHelper.min(o6));
        }
        return setOperationCardinalityHelper.list();
    }

    public static <T> Collection<T> emptyCollection() {
        return EMPTY_COLLECTION;
    }

    public static <T> Collection<T> emptyIfNull(Collection<T> collection) {
        return collection == null ? emptyCollection() : collection;
    }

    @Deprecated
    public static <C> boolean exists(Iterable<C> iterable, Predicate<? super C> predicate) {
        return predicate != null && IterableUtils.matchesAny(iterable, predicate);
    }

    public static <E> E extractSingleton(Collection<E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        if (collection.size() == 1) {
            return collection.iterator().next();
        }
        throw new IllegalArgumentException("Can extract singleton only when collection size == 1");
    }

    public static <T> boolean filter(Iterable<T> iterable, Predicate<? super T> predicate) {
        boolean z6 = false;
        if (iterable != null && predicate != null) {
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                if (!predicate.evaluate(it.next())) {
                    it.remove();
                    z6 = true;
                }
            }
        }
        return z6;
    }

    public static <T> boolean filterInverse(Iterable<T> iterable, Predicate<? super T> predicate) {
        return filter(iterable, predicate == null ? null : PredicateUtils.notPredicate(predicate));
    }

    @Deprecated
    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (predicate != null) {
            return (T) IterableUtils.find(iterable, predicate);
        }
        return null;
    }

    @Deprecated
    public static <T, C extends Closure<? super T>> T forAllButLastDo(Iterable<T> iterable, C c) {
        if (c != null) {
            return (T) IterableUtils.forEachButLast(iterable, c);
        }
        return null;
    }

    @Deprecated
    public static <T, C extends Closure<? super T>> C forAllDo(Iterable<T> iterable, C c) {
        if (c != null) {
            IterableUtils.forEach(iterable, c);
        }
        return c;
    }

    @Deprecated
    public static <T> T get(Iterator<T> it, int i5) {
        return (T) IteratorUtils.get(it, i5);
    }

    public static <O> Map<O, Integer> getCardinalityMap(Iterable<? extends O> iterable) {
        HashMap map = new HashMap();
        for (O o6 : iterable) {
            Integer num = (Integer) map.get(o6);
            if (num == null) {
                map.put(o6, 1);
            } else {
                map.put(o6, Integer.valueOf(num.intValue() + 1));
            }
        }
        return map;
    }

    public static <O> Collection<O> intersection(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        SetOperationCardinalityHelper setOperationCardinalityHelper = new SetOperationCardinalityHelper(iterable, iterable2);
        for (O o6 : setOperationCardinalityHelper) {
            setOperationCardinalityHelper.setCardinality(o6, setOperationCardinalityHelper.min(o6));
        }
        return setOperationCardinalityHelper.list();
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEqualCollection(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() != collection2.size()) {
            return false;
        }
        CardinalityHelper cardinalityHelper = new CardinalityHelper(collection, collection2);
        if (cardinalityHelper.cardinalityA.size() != cardinalityHelper.cardinalityB.size()) {
            return false;
        }
        for (Object obj : cardinalityHelper.cardinalityA.keySet()) {
            if (cardinalityHelper.freqA(obj) != cardinalityHelper.freqB(obj)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFull(Collection<? extends Object> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        if (collection instanceof BoundedCollection) {
            return ((BoundedCollection) collection).isFull();
        }
        try {
            return UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection).isFull();
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isProperSubCollection(Collection<?> collection, Collection<?> collection2) {
        return collection.size() < collection2.size() && isSubCollection(collection, collection2);
    }

    public static boolean isSubCollection(Collection<?> collection, Collection<?> collection2) {
        CardinalityHelper cardinalityHelper = new CardinalityHelper(collection, collection2);
        for (Object obj : collection) {
            if (cardinalityHelper.freqA(obj) > cardinalityHelper.freqB(obj)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static <C> boolean matchesAll(Iterable<C> iterable, Predicate<? super C> predicate) {
        return predicate != null && IterableUtils.matchesAll(iterable, predicate);
    }

    public static int maxSize(Collection<? extends Object> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        if (collection instanceof BoundedCollection) {
            return ((BoundedCollection) collection).maxSize();
        }
        try {
            return UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection).maxSize();
        } catch (IllegalArgumentException unused) {
            return -1;
        }
    }

    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        PermutationIterator permutationIterator = new PermutationIterator(collection);
        ArrayList arrayList = new ArrayList();
        while (permutationIterator.hasNext()) {
            arrayList.add(permutationIterator.next());
        }
        return arrayList;
    }

    public static <C> Collection<C> predicatedCollection(Collection<C> collection, Predicate<? super C> predicate) {
        return PredicatedCollection.predicatedCollection(collection, predicate);
    }

    public static <E> Collection<E> removeAll(Collection<E> collection, Collection<?> collection2) {
        return ListUtils.removeAll(collection, collection2);
    }

    public static <C> Collection<C> retainAll(Collection<C> collection, Collection<?> collection2) {
        return ListUtils.retainAll(collection, collection2);
    }

    public static void reverseArray(Object[] objArr) {
        int length = objArr.length - 1;
        for (int i5 = 0; length > i5; i5++) {
            Object obj = objArr[length];
            objArr[length] = objArr[i5];
            objArr[i5] = obj;
            length--;
        }
    }

    public static <O> Collection<O> select(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        return select(iterable, predicate, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static <O> Collection<O> selectRejected(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        return selectRejected(iterable, predicate, iterable instanceof Collection ? new ArrayList(((Collection) iterable).size()) : new ArrayList());
    }

    public static int size(Object obj) {
        int i5 = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Iterable) {
            return IterableUtils.size((Iterable) obj);
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj instanceof Iterator) {
            return IteratorUtils.size((Iterator) obj);
        }
        if (!(obj instanceof Enumeration)) {
            try {
                return Array.getLength(obj);
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException("Unsupported object type: ".concat(obj.getClass().getName()));
            }
        }
        Enumeration enumeration = (Enumeration) obj;
        while (enumeration.hasMoreElements()) {
            i5++;
            enumeration.nextElement();
        }
        return i5;
    }

    public static boolean sizeIsEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Iterable) {
            return IterableUtils.isEmpty((Iterable) obj);
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        }
        if (obj instanceof Iterator) {
            return !((Iterator) obj).hasNext();
        }
        if (obj instanceof Enumeration) {
            return !((Enumeration) obj).hasMoreElements();
        }
        try {
            return Array.getLength(obj) == 0;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Unsupported object type: ".concat(obj.getClass().getName()));
        }
    }

    public static <O> Collection<O> subtract(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        return subtract(iterable, iterable2, TruePredicate.truePredicate());
    }

    @Deprecated
    public static <C> Collection<C> synchronizedCollection(Collection<C> collection) {
        return SynchronizedCollection.synchronizedCollection(collection);
    }

    public static <C> void transform(Collection<C> collection, Transformer<? super C, ? extends C> transformer) {
        if (collection == null || transformer == null) {
            return;
        }
        if (collection instanceof List) {
            ListIterator listIterator = ((List) collection).listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(transformer.transform((Object) listIterator.next()));
            }
        } else {
            Collection<? extends C> collectionCollect = collect(collection, transformer);
            collection.clear();
            collection.addAll(collectionCollect);
        }
    }

    public static <E> Collection<E> transformingCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        return TransformedCollection.transformingCollection(collection, transformer);
    }

    public static <O> Collection<O> union(Iterable<? extends O> iterable, Iterable<? extends O> iterable2) {
        SetOperationCardinalityHelper setOperationCardinalityHelper = new SetOperationCardinalityHelper(iterable, iterable2);
        for (O o6 : setOperationCardinalityHelper) {
            setOperationCardinalityHelper.setCardinality(o6, setOperationCardinalityHelper.max(o6));
        }
        return setOperationCardinalityHelper.list();
    }

    @Deprecated
    public static <C> Collection<C> unmodifiableCollection(Collection<? extends C> collection) {
        return UnmodifiableCollection.unmodifiableCollection(collection);
    }

    public static <O extends Comparable<? super O>> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, boolean z6) {
        return collate(iterable, iterable2, ComparatorUtils.naturalComparator(), z6);
    }

    @Deprecated
    public static <T, C extends Closure<? super T>> T forAllButLastDo(Iterator<T> it, C c) {
        if (c != null) {
            return (T) IteratorUtils.forEachButLast(it, c);
        }
        return null;
    }

    @Deprecated
    public static <T, C extends Closure<? super T>> C forAllDo(Iterator<T> it, C c) {
        if (c != null) {
            IteratorUtils.forEach(it, c);
        }
        return c;
    }

    @Deprecated
    public static <T> T get(Iterable<T> iterable, int i5) {
        return (T) IterableUtils.get(iterable, i5);
    }

    public static <E> Collection<E> removeAll(Iterable<E> iterable, Iterable<? extends E> iterable2, final Equator<? super E> equator) {
        Set set = (Set) collect(iterable2, new Transformer<E, EquatorWrapper<E>>() { // from class: org.apache.commons.collections4.CollectionUtils.3
            @Override // org.apache.commons.collections4.Transformer
            public EquatorWrapper<E> transform(E e) {
                return new EquatorWrapper<>(equator, e);
            }
        }, new HashSet());
        ArrayList arrayList = new ArrayList();
        for (E e : iterable) {
            if (!set.contains(new EquatorWrapper(equator, e))) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <E> Collection<E> retainAll(Iterable<E> iterable, Iterable<? extends E> iterable2, final Equator<? super E> equator) {
        Set set = (Set) collect(iterable2, new Transformer<E, EquatorWrapper<E>>() { // from class: org.apache.commons.collections4.CollectionUtils.2
            @Override // org.apache.commons.collections4.Transformer
            public EquatorWrapper<E> transform(E e) {
                return new EquatorWrapper<>(equator, e);
            }
        }, new HashSet());
        ArrayList arrayList = new ArrayList();
        for (E e : iterable) {
            if (set.contains(new EquatorWrapper(equator, e))) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <O> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Comparator<? super O> comparator) {
        return collate(iterable, iterable2, comparator, true);
    }

    public static Object get(Object obj, int i5) {
        if (i5 >= 0) {
            if (obj instanceof Map) {
                return IteratorUtils.get(((Map) obj).entrySet().iterator(), i5);
            }
            if (obj instanceof Object[]) {
                return ((Object[]) obj)[i5];
            }
            if (obj instanceof Iterator) {
                return IteratorUtils.get((Iterator) obj, i5);
            }
            if (obj instanceof Iterable) {
                return IterableUtils.get((Iterable) obj, i5);
            }
            if (obj instanceof Enumeration) {
                return EnumerationUtils.get((Enumeration) obj, i5);
            }
            if (obj != null) {
                try {
                    return Array.get(obj, i5);
                } catch (IllegalArgumentException unused) {
                    throw new IllegalArgumentException("Unsupported object type: ".concat(obj.getClass().getName()));
                }
            }
            throw new IllegalArgumentException("Unsupported object type: null");
        }
        throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "Index cannot be negative: "));
    }

    public static <O> Collection<O> subtract(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Predicate<O> predicate) {
        ArrayList arrayList = new ArrayList();
        HashBag hashBag = new HashBag();
        for (O o6 : iterable2) {
            if (predicate.evaluate(o6)) {
                hashBag.add(o6);
            }
        }
        for (O o7 : iterable) {
            if (!hashBag.remove(o7, 1)) {
                arrayList.add(o7);
            }
        }
        return arrayList;
    }

    public static <C> boolean addAll(Collection<C> collection, Iterator<? extends C> it) {
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static <O> List<O> collate(Iterable<? extends O> iterable, Iterable<? extends O> iterable2, Comparator<? super O> comparator, boolean z6) {
        int iMax;
        if (iterable == null || iterable2 == null) {
            throw new NullPointerException("The collections must not be null");
        }
        if (comparator != null) {
            if ((iterable instanceof Collection) && (iterable2 instanceof Collection)) {
                iMax = Math.max(1, ((Collection) iterable2).size() + ((Collection) iterable).size());
            } else {
                iMax = 10;
            }
            CollatingIterator collatingIterator = new CollatingIterator(comparator, iterable.iterator(), iterable2.iterator());
            if (z6) {
                return IteratorUtils.toList(collatingIterator, iMax);
            }
            ArrayList arrayList = new ArrayList(iMax);
            Object obj = null;
            while (collatingIterator.hasNext()) {
                Object next = collatingIterator.next();
                if (obj == null || !obj.equals(next)) {
                    arrayList.add(next);
                }
                obj = next;
            }
            arrayList.trimToSize();
            return arrayList;
        }
        throw new NullPointerException("The comparator must not be null");
    }

    public static <I, O> Collection<O> collect(Iterator<I> it, Transformer<? super I, ? extends O> transformer) {
        return collect(it, transformer, new ArrayList());
    }

    public static <O, R extends Collection<? super O>> R select(Iterable<? extends O> iterable, Predicate<? super O> predicate, R r6) {
        if (iterable != null && predicate != null) {
            for (O o6 : iterable) {
                if (predicate.evaluate(o6)) {
                    r6.add(o6);
                }
            }
        }
        return r6;
    }

    public static <O, R extends Collection<? super O>> R selectRejected(Iterable<? extends O> iterable, Predicate<? super O> predicate, R r6) {
        if (iterable != null && predicate != null) {
            for (O o6 : iterable) {
                if (!predicate.evaluate(o6)) {
                    r6.add(o6);
                }
            }
        }
        return r6;
    }

    public static <I, O, R extends Collection<? super O>> R collect(Iterable<? extends I> iterable, Transformer<? super I, ? extends O> transformer, R r6) {
        return iterable != null ? (R) collect(iterable.iterator(), transformer, r6) : r6;
    }

    public static <C> boolean addAll(Collection<C> collection, Enumeration<? extends C> enumeration) {
        boolean zAdd = false;
        while (enumeration.hasMoreElements()) {
            zAdd |= collection.add(enumeration.nextElement());
        }
        return zAdd;
    }

    public static <I, O, R extends Collection<? super O>> R collect(Iterator<? extends I> it, Transformer<? super I, ? extends O> transformer, R r6) {
        if (it != null && transformer != null) {
            while (it.hasNext()) {
                r6.add(transformer.transform(it.next()));
            }
        }
        return r6;
    }

    public static boolean containsAny(Collection<?> collection, Collection<?> collection2) {
        if (collection.size() < collection2.size()) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (collection2.contains(it.next())) {
                    return true;
                }
            }
            return false;
        }
        Iterator<?> it2 = collection2.iterator();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean isEqualCollection(Collection<? extends E> collection, Collection<? extends E> collection2, final Equator<? super E> equator) {
        if (equator != null) {
            if (collection.size() != collection2.size()) {
                return false;
            }
            Transformer transformer = new Transformer() { // from class: org.apache.commons.collections4.CollectionUtils.1
                @Override // org.apache.commons.collections4.Transformer
                public EquatorWrapper<?> transform(Object obj) {
                    return new EquatorWrapper<>(equator, obj);
                }
            };
            return isEqualCollection(collect(collection, transformer), collect(collection2, transformer));
        }
        throw new NullPointerException("Equator must not be null.");
    }

    public static <O, R extends Collection<? super O>> R select(Iterable<? extends O> iterable, Predicate<? super O> predicate, R r6, R r7) {
        if (iterable != null && predicate != null) {
            for (O o6 : iterable) {
                if (predicate.evaluate(o6)) {
                    r6.add(o6);
                } else {
                    r7.add(o6);
                }
            }
        }
        return r6;
    }

    public static <C> boolean addAll(Collection<C> collection, C... cArr) {
        boolean zAdd = false;
        for (C c : cArr) {
            zAdd |= collection.add(c);
        }
        return zAdd;
    }

    public static <K, V> Map.Entry<K, V> get(Map<K, V> map, int i5) {
        checkIndexBounds(i5);
        return (Map.Entry) get((Iterable) map.entrySet(), i5);
    }
}
