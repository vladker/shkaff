package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @RetainedWith
    @LazyInit
    private transient BiMap<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class EntryForKey extends AbstractMapEntry<K, V> {
        int index;

        @ParametricNullness
        final K key;

        public EntryForKey(int i5) {
            this.key = (K) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.keys[i5]);
            this.index = i5;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getValue() {
            updateIndex();
            int i5 = this.index;
            return i5 == -1 ? (V) NullnessCasts.unsafeNull() : (V) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i5]);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V setValue(@ParametricNullness V v6) {
            updateIndex();
            int i5 = this.index;
            if (i5 == -1) {
                HashBiMap.this.put(this.key, v6);
                return (V) NullnessCasts.unsafeNull();
            }
            V v7 = (V) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i5]);
            if (Objects.equal(v7, v6)) {
                return v6;
            }
            HashBiMap.this.replaceValueInEntry(this.index, v6, false);
            return v7;
        }

        public void updateIndex() {
            int i5 = this.index;
            if (i5 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i5 <= hashBiMap.size && Objects.equal(hashBiMap.keys[i5], this.key)) {
                    return;
                }
            }
            this.index = HashBiMap.this.findEntryByKey(this.key);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        final HashBiMap<K, V> biMap;
        int index;

        @ParametricNullness
        final V value;

        public EntryForValue(HashBiMap<K, V> hashBiMap, int i5) {
            this.biMap = hashBiMap;
            this.value = (V) NullnessCasts.uncheckedCastNullableTToT(hashBiMap.values[i5]);
            this.index = i5;
        }

        private void updateIndex() {
            int i5 = this.index;
            if (i5 != -1) {
                HashBiMap<K, V> hashBiMap = this.biMap;
                if (i5 <= hashBiMap.size && Objects.equal(this.value, hashBiMap.values[i5])) {
                    return;
                }
            }
            this.index = this.biMap.findEntryByValue(this.value);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public V getKey() {
            return this.value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K getValue() {
            updateIndex();
            int i5 = this.index;
            return i5 == -1 ? (K) NullnessCasts.unsafeNull() : (K) NullnessCasts.uncheckedCastNullableTToT(this.biMap.keys[i5]);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @ParametricNullness
        public K setValue(@ParametricNullness K k6) {
            updateIndex();
            int i5 = this.index;
            if (i5 == -1) {
                this.biMap.putInverse(this.value, k6, false);
                return (K) NullnessCasts.unsafeNull();
            }
            K k7 = (K) NullnessCasts.uncheckedCastNullableTToT(this.biMap.keys[i5]);
            if (Objects.equal(k7, k6)) {
                return k6;
            }
            this.biMap.replaceKeyInEntry(this.index, k6, false);
            return k7;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        public EntrySet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int iFindEntryByKey = HashBiMap.this.findEntryByKey(key);
                if (iFindEntryByKey != -1 && Objects.equal(value, HashBiMap.this.values[iFindEntryByKey])) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iSmearedHash = Hashing.smearedHash(key);
            int iFindEntryByKey = HashBiMap.this.findEntryByKey(key, iSmearedHash);
            if (iFindEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[iFindEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(iFindEntryByKey, iSmearedHash);
            return true;
        }

        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<K, V> forEntry(int i5) {
            return new EntryForKey(i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet = new InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet;
            return inverseEntrySet;
        }

        @Override // com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        public K forcePut(@ParametricNullness V v6, @ParametricNullness K k6) {
            return this.forward.putInverse(v6, k6, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        public K put(@ParametricNullness V v6, @ParametricNullness K k6) {
            return this.forward.putInverse(v6, k6, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        public K remove(Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        public InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int iFindEntryByValue = this.biMap.findEntryByValue(key);
                if (iFindEntryByValue != -1 && Objects.equal(this.biMap.keys[iFindEntryByValue], value)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iSmearedHash = Hashing.smearedHash(key);
            int iFindEntryByValue = this.biMap.findEntryByValue(key, iSmearedHash);
            if (iFindEntryByValue == -1 || !Objects.equal(this.biMap.keys[iFindEntryByValue], value)) {
                return false;
            }
            this.biMap.removeEntryValueHashKnown(iFindEntryByValue, iSmearedHash);
            return true;
        }

        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<V, K> forEntry(int i5) {
            return new EntryForValue(this.biMap, i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class KeySet extends View<K, V, K> {
        public KeySet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.HashBiMap.View
        @ParametricNullness
        public K forEntry(int i5) {
            return (K) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.keys[i5]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iSmearedHash = Hashing.smearedHash(obj);
            int iFindEntryByKey = HashBiMap.this.findEntryByKey(obj, iSmearedHash);
            if (iFindEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(iFindEntryByKey, iSmearedHash);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class ValueSet extends View<K, V, V> {
        public ValueSet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // com.google.common.collect.HashBiMap.View
        @ParametricNullness
        public V forEntry(int i5) {
            return (V) NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i5]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iSmearedHash = Hashing.smearedHash(obj);
            int iFindEntryByValue = HashBiMap.this.findEntryByValue(obj, iSmearedHash);
            if (iFindEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(iFindEntryByValue, iSmearedHash);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> biMap;

        public View(HashBiMap<K, V> hashBiMap) {
            this.biMap = hashBiMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.biMap.clear();
        }

        @ParametricNullness
        public abstract T forEntry(int i5);

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: com.google.common.collect.HashBiMap.View.1
                private int expectedModCount;
                private int index;
                private int indexToRemove = -1;
                private int remaining;

                {
                    this.index = ((HashBiMap) View.this.biMap).firstInInsertionOrder;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    this.expectedModCount = hashBiMap.modCount;
                    this.remaining = hashBiMap.size;
                }

                private void checkForComodification() {
                    if (View.this.biMap.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    checkForComodification();
                    return this.index != -2 && this.remaining > 0;
                }

                @Override // java.util.Iterator
                @ParametricNullness
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    T t6 = (T) View.this.forEntry(this.index);
                    this.indexToRemove = this.index;
                    this.index = ((HashBiMap) View.this.biMap).nextInInsertionOrder[this.index];
                    this.remaining--;
                    return t6;
                }

                @Override // java.util.Iterator
                public void remove() {
                    checkForComodification();
                    CollectPreconditions.checkRemove(this.indexToRemove != -1);
                    View.this.biMap.removeEntry(this.indexToRemove);
                    int i5 = this.index;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    if (i5 == hashBiMap.size) {
                        this.index = this.indexToRemove;
                    }
                    this.indexToRemove = -1;
                    this.expectedModCount = hashBiMap.modCount;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.biMap.size;
        }
    }

    private HashBiMap(int i5) {
        init(i5);
    }

    private int bucket(int i5) {
        return i5 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private static int[] createFilledWithAbsent(int i5) {
        int[] iArr = new int[i5];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i5, int i6) {
        Preconditions.checkArgument(i5 != -1);
        int iBucket = bucket(i6);
        int[] iArr = this.hashTableKToV;
        int i7 = iArr[iBucket];
        if (i7 == i5) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[iBucket] = iArr2[i5];
            iArr2[i5] = -1;
            return;
        }
        int i8 = this.nextInBucketKToV[i7];
        while (true) {
            int i9 = i7;
            i7 = i8;
            if (i7 == -1) {
                String strValueOf = String.valueOf(this.keys[i5]);
                throw new AssertionError(com.google.android.gms.auth.api.accounttransfer.a.i(strValueOf.length() + 32, "Expected to find entry with key ", strValueOf));
            }
            if (i7 == i5) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i9] = iArr3[i5];
                iArr3[i5] = -1;
                return;
            }
            i8 = this.nextInBucketKToV[i7];
        }
    }

    private void deleteFromTableVToK(int i5, int i6) {
        Preconditions.checkArgument(i5 != -1);
        int iBucket = bucket(i6);
        int[] iArr = this.hashTableVToK;
        int i7 = iArr[iBucket];
        if (i7 == i5) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[iBucket] = iArr2[i5];
            iArr2[i5] = -1;
            return;
        }
        int i8 = this.nextInBucketVToK[i7];
        while (true) {
            int i9 = i7;
            i7 = i8;
            if (i7 == -1) {
                String strValueOf = String.valueOf(this.values[i5]);
                throw new AssertionError(com.google.android.gms.auth.api.accounttransfer.a.i(strValueOf.length() + 34, "Expected to find entry with value ", strValueOf));
            }
            if (i7 == i5) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i9] = iArr3[i5];
                iArr3[i5] = -1;
                return;
            }
            i8 = this.nextInBucketVToK[i7];
        }
    }

    private void ensureCapacity(int i5) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i5) {
            int iExpandedCapacity = ImmutableCollection.Builder.expandedCapacity(iArr.length, i5);
            this.keys = (K[]) Arrays.copyOf(this.keys, iExpandedCapacity);
            this.values = (V[]) Arrays.copyOf(this.values, iExpandedCapacity);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, iExpandedCapacity);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, iExpandedCapacity);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, iExpandedCapacity);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, iExpandedCapacity);
        }
        if (this.hashTableKToV.length < i5) {
            int iClosedTableSize = Hashing.closedTableSize(i5, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(iClosedTableSize);
            this.hashTableVToK = createFilledWithAbsent(iClosedTableSize);
            for (int i6 = 0; i6 < this.size; i6++) {
                int iBucket = bucket(Hashing.smearedHash(this.keys[i6]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i6] = iArr3[iBucket];
                iArr3[iBucket] = i6;
                int iBucket2 = bucket(Hashing.smearedHash(this.values[i6]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i6] = iArr5[iBucket2];
                iArr5[iBucket2] = i6;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i5) {
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
        Arrays.fill(iArrCopyOf, length, i5, -1);
        return iArrCopyOf;
    }

    private void insertIntoTableKToV(int i5, int i6) {
        Preconditions.checkArgument(i5 != -1);
        int iBucket = bucket(i6);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i5] = iArr2[iBucket];
        iArr2[iBucket] = i5;
    }

    private void insertIntoTableVToK(int i5, int i6) {
        Preconditions.checkArgument(i5 != -1);
        int iBucket = bucket(i6);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i5] = iArr2[iBucket];
        iArr2[iBucket] = i5;
    }

    private void moveEntryToIndex(int i5, int i6) {
        int i7;
        int i8;
        if (i5 == i6) {
            return;
        }
        int i9 = this.prevInInsertionOrder[i5];
        int i10 = this.nextInInsertionOrder[i5];
        setSucceeds(i9, i6);
        setSucceeds(i6, i10);
        K[] kArr = this.keys;
        K k6 = kArr[i5];
        V[] vArr = this.values;
        V v6 = vArr[i5];
        kArr[i6] = k6;
        vArr[i6] = v6;
        int iBucket = bucket(Hashing.smearedHash(k6));
        int[] iArr = this.hashTableKToV;
        int i11 = iArr[iBucket];
        if (i11 == i5) {
            iArr[iBucket] = i6;
        } else {
            int i12 = this.nextInBucketKToV[i11];
            while (true) {
                i7 = i11;
                i11 = i12;
                if (i11 == i5) {
                    break;
                } else {
                    i12 = this.nextInBucketKToV[i11];
                }
            }
            this.nextInBucketKToV[i7] = i6;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i6] = iArr2[i5];
        iArr2[i5] = -1;
        int iBucket2 = bucket(Hashing.smearedHash(v6));
        int[] iArr3 = this.hashTableVToK;
        int i13 = iArr3[iBucket2];
        if (i13 == i5) {
            iArr3[iBucket2] = i6;
        } else {
            int i14 = this.nextInBucketVToK[i13];
            while (true) {
                i8 = i13;
                i13 = i14;
                if (i13 == i5) {
                    break;
                } else {
                    i14 = this.nextInBucketVToK[i13];
                }
            }
            this.nextInBucketVToK[i8] = i6;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i6] = iArr4[i5];
        iArr4[i5] = -1;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int count = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i5, @ParametricNullness K k6, boolean z6) {
        int i6;
        Preconditions.checkArgument(i5 != -1);
        int iSmearedHash = Hashing.smearedHash(k6);
        int iFindEntryByKey = findEntryByKey(k6, iSmearedHash);
        int i7 = this.lastInInsertionOrder;
        if (iFindEntryByKey == -1) {
            i6 = -2;
        } else {
            if (!z6) {
                String strValueOf = String.valueOf(k6);
                throw new IllegalArgumentException(com.google.android.gms.auth.api.accounttransfer.a.i(strValueOf.length() + 28, "Key already present in map: ", strValueOf));
            }
            i7 = this.prevInInsertionOrder[iFindEntryByKey];
            i6 = this.nextInInsertionOrder[iFindEntryByKey];
            removeEntryKeyHashKnown(iFindEntryByKey, iSmearedHash);
            if (i5 == this.size) {
                i5 = iFindEntryByKey;
            }
        }
        if (i7 == i5) {
            i7 = this.prevInInsertionOrder[i5];
        } else if (i7 == this.size) {
            i7 = iFindEntryByKey;
        }
        if (i6 == i5) {
            iFindEntryByKey = this.nextInInsertionOrder[i5];
        } else if (i6 != this.size) {
            iFindEntryByKey = i6;
        }
        setSucceeds(this.prevInInsertionOrder[i5], this.nextInInsertionOrder[i5]);
        deleteFromTableKToV(i5, Hashing.smearedHash(this.keys[i5]));
        this.keys[i5] = k6;
        insertIntoTableKToV(i5, Hashing.smearedHash(k6));
        setSucceeds(i7, i5);
        setSucceeds(i5, iFindEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i5, @ParametricNullness V v6, boolean z6) {
        Preconditions.checkArgument(i5 != -1);
        int iSmearedHash = Hashing.smearedHash(v6);
        int iFindEntryByValue = findEntryByValue(v6, iSmearedHash);
        if (iFindEntryByValue != -1) {
            if (!z6) {
                String strValueOf = String.valueOf(v6);
                throw new IllegalArgumentException(com.google.android.gms.auth.api.accounttransfer.a.i(strValueOf.length() + 30, "Value already present in map: ", strValueOf));
            }
            removeEntryValueHashKnown(iFindEntryByValue, iSmearedHash);
            if (i5 == this.size) {
                i5 = iFindEntryByValue;
            }
        }
        deleteFromTableVToK(i5, Hashing.smearedHash(this.values[i5]));
        this.values[i5] = v6;
        insertIntoTableVToK(i5, iSmearedHash);
    }

    private void setSucceeds(int i5, int i6) {
        if (i5 == -2) {
            this.firstInInsertionOrder = i6;
        } else {
            this.nextInInsertionOrder[i5] = i6;
        }
        if (i6 == -2) {
            this.lastInInsertionOrder = i5;
        } else {
            this.prevInInsertionOrder[i6] = i5;
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    public int findEntry(Object obj, int i5, int[] iArr, int[] iArr2, Object[] objArr) {
        int i6 = iArr[bucket(i5)];
        while (i6 != -1) {
            if (Objects.equal(objArr[i6], obj)) {
                return i6;
            }
            i6 = iArr2[i6];
        }
        return -1;
    }

    public int findEntryByKey(Object obj) {
        return findEntryByKey(obj, Hashing.smearedHash(obj));
    }

    public int findEntryByValue(Object obj) {
        return findEntryByValue(obj, Hashing.smearedHash(obj));
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V forcePut(@ParametricNullness K k6, @ParametricNullness V v6) {
        return put(k6, v6, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int iFindEntryByKey = findEntryByKey(obj);
        if (iFindEntryByKey == -1) {
            return null;
        }
        return this.values[iFindEntryByKey];
    }

    public K getInverse(Object obj) {
        int iFindEntryByValue = findEntryByValue(obj);
        if (iFindEntryByValue == -1) {
            return null;
        }
        return this.keys[iFindEntryByValue];
    }

    public void init(int i5) {
        CollectPreconditions.checkNonnegative(i5, "expectedSize");
        int iClosedTableSize = Hashing.closedTableSize(i5, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i5];
        this.values = (V[]) new Object[i5];
        this.hashTableKToV = createFilledWithAbsent(iClosedTableSize);
        this.hashTableVToK = createFilledWithAbsent(iClosedTableSize);
        this.nextInBucketKToV = createFilledWithAbsent(i5);
        this.nextInBucketVToK = createFilledWithAbsent(i5);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i5);
        this.nextInInsertionOrder = createFilledWithAbsent(i5);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@ParametricNullness K k6, @ParametricNullness V v6) {
        return put(k6, v6, false);
    }

    @CanIgnoreReturnValue
    public K putInverse(@ParametricNullness V v6, @ParametricNullness K k6, boolean z6) {
        int iSmearedHash = Hashing.smearedHash(v6);
        int iFindEntryByValue = findEntryByValue(v6, iSmearedHash);
        if (iFindEntryByValue != -1) {
            K k7 = this.keys[iFindEntryByValue];
            if (Objects.equal(k7, k6)) {
                return k6;
            }
            replaceKeyInEntry(iFindEntryByValue, k6, z6);
            return k7;
        }
        int i5 = this.lastInInsertionOrder;
        int iSmearedHash2 = Hashing.smearedHash(k6);
        int iFindEntryByKey = findEntryByKey(k6, iSmearedHash2);
        if (!z6) {
            Preconditions.checkArgument(iFindEntryByKey == -1, "Key already present: %s", k6);
        } else if (iFindEntryByKey != -1) {
            i5 = this.prevInInsertionOrder[iFindEntryByKey];
            removeEntryKeyHashKnown(iFindEntryByKey, iSmearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i6 = this.size;
        kArr[i6] = k6;
        this.values[i6] = v6;
        insertIntoTableKToV(i6, iSmearedHash2);
        insertIntoTableVToK(this.size, iSmearedHash);
        int i7 = i5 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i5];
        setSucceeds(i5, this.size);
        setSucceeds(this.size, i7);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        int iSmearedHash = Hashing.smearedHash(obj);
        int iFindEntryByKey = findEntryByKey(obj, iSmearedHash);
        if (iFindEntryByKey == -1) {
            return null;
        }
        V v6 = this.values[iFindEntryByKey];
        removeEntryKeyHashKnown(iFindEntryByKey, iSmearedHash);
        return v6;
    }

    public void removeEntry(int i5) {
        removeEntryKeyHashKnown(i5, Hashing.smearedHash(this.keys[i5]));
    }

    public void removeEntryKeyHashKnown(int i5, int i6) {
        removeEntry(i5, i6, Hashing.smearedHash(this.values[i5]));
    }

    public void removeEntryValueHashKnown(int i5, int i6) {
        removeEntry(i5, Hashing.smearedHash(this.keys[i5]), i6);
    }

    public K removeInverse(Object obj) {
        int iSmearedHash = Hashing.smearedHash(obj);
        int iFindEntryByValue = findEntryByValue(obj, iSmearedHash);
        if (iFindEntryByValue == -1) {
            return null;
        }
        K k6 = this.keys[iFindEntryByValue];
        removeEntryValueHashKnown(iFindEntryByValue, iSmearedHash);
        return k6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i5) {
        return new HashBiMap<>(i5);
    }

    private void removeEntry(int i5, int i6, int i7) {
        Preconditions.checkArgument(i5 != -1);
        deleteFromTableKToV(i5, i6);
        deleteFromTableVToK(i5, i7);
        setSucceeds(this.prevInInsertionOrder[i5], this.nextInInsertionOrder[i5]);
        moveEntryToIndex(this.size - 1, i5);
        K[] kArr = this.keys;
        int i8 = this.size;
        kArr[i8 - 1] = null;
        this.values[i8 - 1] = null;
        this.size = i8 - 1;
        this.modCount++;
    }

    public int findEntryByKey(Object obj, int i5) {
        return findEntry(obj, i5, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(Object obj, int i5) {
        return findEntry(obj, i5, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    public V put(@ParametricNullness K k6, @ParametricNullness V v6, boolean z6) {
        int iSmearedHash = Hashing.smearedHash(k6);
        int iFindEntryByKey = findEntryByKey(k6, iSmearedHash);
        if (iFindEntryByKey != -1) {
            V v7 = this.values[iFindEntryByKey];
            if (Objects.equal(v7, v6)) {
                return v6;
            }
            replaceValueInEntry(iFindEntryByKey, v6, z6);
            return v7;
        }
        int iSmearedHash2 = Hashing.smearedHash(v6);
        int iFindEntryByValue = findEntryByValue(v6, iSmearedHash2);
        if (!z6) {
            Preconditions.checkArgument(iFindEntryByValue == -1, "Value already present: %s", v6);
        } else if (iFindEntryByValue != -1) {
            removeEntryValueHashKnown(iFindEntryByValue, iSmearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i5 = this.size;
        kArr[i5] = k6;
        this.values[i5] = v6;
        insertIntoTableKToV(i5, iSmearedHash);
        insertIntoTableVToK(this.size, iSmearedHash2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.valueSet = valueSet;
        return valueSet;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> hashBiMapCreate = create(map.size());
        hashBiMapCreate.putAll(map);
        return hashBiMapCreate;
    }
}
