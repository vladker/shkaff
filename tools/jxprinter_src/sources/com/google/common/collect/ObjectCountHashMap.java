package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
class ObjectCountHashMap<K> {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @VisibleForTesting
    transient long[] entries;
    transient Object[] keys;
    private transient float loadFactor;
    transient int modCount;
    transient int size;
    private transient int[] table;
    private transient int threshold;
    transient int[] values;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class MapEntry extends Multisets.AbstractEntry<K> {

        @ParametricNullness
        final K key;
        int lastKnownIndex;

        public MapEntry(int i5) {
            this.key = (K) ObjectCountHashMap.this.keys[i5];
            this.lastKnownIndex = i5;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            updateLastKnownIndex();
            int i5 = this.lastKnownIndex;
            if (i5 == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.values[i5];
        }

        @Override // com.google.common.collect.Multiset.Entry
        @ParametricNullness
        public K getElement() {
            return this.key;
        }

        @CanIgnoreReturnValue
        public int setCount(int i5) {
            updateLastKnownIndex();
            int i6 = this.lastKnownIndex;
            if (i6 == -1) {
                ObjectCountHashMap.this.put(this.key, i5);
                return 0;
            }
            int[] iArr = ObjectCountHashMap.this.values;
            int i7 = iArr[i6];
            iArr[i6] = i5;
            return i7;
        }

        public void updateLastKnownIndex() {
            int i5 = this.lastKnownIndex;
            if (i5 == -1 || i5 >= ObjectCountHashMap.this.size() || !Objects.equal(this.key, ObjectCountHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = ObjectCountHashMap.this.indexOf(this.key);
            }
        }
    }

    public ObjectCountHashMap() {
        init(3, 1.0f);
    }

    public static <K> ObjectCountHashMap<K> create() {
        return new ObjectCountHashMap<>();
    }

    public static <K> ObjectCountHashMap<K> createWithExpectedSize(int i5) {
        return new ObjectCountHashMap<>(i5);
    }

    private static int getHash(long j6) {
        return (int) (j6 >>> 32);
    }

    private static int getNext(long j6) {
        return (int) j6;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int i5) {
        long[] jArr = new long[i5];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i5) {
        int[] iArr = new int[i5];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void resizeMeMaybe(int i5) {
        int length = this.entries.length;
        if (i5 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                resizeEntries(iMax);
            }
        }
    }

    private void resizeTable(int i5) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i6 = ((int) (i5 * this.loadFactor)) + 1;
        int[] iArrNewTable = newTable(i5);
        long[] jArr = this.entries;
        int length = iArrNewTable.length - 1;
        for (int i7 = 0; i7 < this.size; i7++) {
            int hash = getHash(jArr[i7]);
            int i8 = hash & length;
            int i9 = iArrNewTable[i8];
            iArrNewTable[i8] = i7;
            jArr[i7] = (((long) hash) << 32) | (((long) i9) & 4294967295L);
        }
        this.threshold = i6;
        this.table = iArrNewTable;
    }

    private static long swapNext(long j6, int i5) {
        return (j6 & HASH_MASK) | (4294967295L & ((long) i5));
    }

    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, 0);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    public boolean containsKey(Object obj) {
        return indexOf(obj) != -1;
    }

    public void ensureCapacity(int i5) {
        if (i5 > this.entries.length) {
            resizeEntries(i5);
        }
        if (i5 >= this.threshold) {
            resizeTable(Math.max(2, Integer.highestOneBit(i5 - 1) << 1));
        }
    }

    public int firstIndex() {
        return this.size == 0 ? -1 : 0;
    }

    public int get(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return 0;
        }
        return this.values[iIndexOf];
    }

    public Multiset.Entry<K> getEntry(int i5) {
        Preconditions.checkElementIndex(i5, this.size);
        return new MapEntry(i5);
    }

    @ParametricNullness
    public K getKey(int i5) {
        Preconditions.checkElementIndex(i5, this.size);
        return (K) this.keys[i5];
    }

    public int getValue(int i5) {
        Preconditions.checkElementIndex(i5, this.size);
        return this.values[i5];
    }

    public int indexOf(Object obj) {
        int iSmearedHash = Hashing.smearedHash(obj);
        int next = this.table[hashTableMask() & iSmearedHash];
        while (next != -1) {
            long j6 = this.entries[next];
            if (getHash(j6) == iSmearedHash && Objects.equal(obj, this.keys[next])) {
                return next;
            }
            next = getNext(j6);
        }
        return -1;
    }

    public void init(int i5, float f6) {
        Preconditions.checkArgument(i5 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f6 > 0.0f, "Illegal load factor");
        int iClosedTableSize = Hashing.closedTableSize(i5, f6);
        this.table = newTable(iClosedTableSize);
        this.loadFactor = f6;
        this.keys = new Object[i5];
        this.values = new int[i5];
        this.entries = newEntries(i5);
        this.threshold = Math.max(1, (int) (iClosedTableSize * f6));
    }

    public void insertEntry(int i5, @ParametricNullness K k6, int i6, int i7) {
        this.entries[i5] = (((long) i7) << 32) | 4294967295L;
        this.keys[i5] = k6;
        this.values[i5] = i6;
    }

    public void moveLastEntry(int i5) {
        int size = size() - 1;
        if (i5 >= size) {
            this.keys[i5] = null;
            this.values[i5] = 0;
            this.entries[i5] = -1;
            return;
        }
        Object[] objArr = this.keys;
        objArr[i5] = objArr[size];
        int[] iArr = this.values;
        iArr[i5] = iArr[size];
        objArr[size] = null;
        iArr[size] = 0;
        long[] jArr = this.entries;
        long j6 = jArr[size];
        jArr[i5] = j6;
        jArr[size] = -1;
        int hash = getHash(j6) & hashTableMask();
        int[] iArr2 = this.table;
        int i6 = iArr2[hash];
        if (i6 == size) {
            iArr2[hash] = i5;
            return;
        }
        while (true) {
            long j7 = this.entries[i6];
            int next = getNext(j7);
            if (next == size) {
                this.entries[i6] = swapNext(j7, i5);
                return;
            }
            i6 = next;
        }
    }

    public int nextIndex(int i5) {
        int i6 = i5 + 1;
        if (i6 < this.size) {
            return i6;
        }
        return -1;
    }

    public int nextIndexAfterRemove(int i5, int i6) {
        return i5 - 1;
    }

    @CanIgnoreReturnValue
    public int put(@ParametricNullness K k6, int i5) {
        CollectPreconditions.checkPositive(i5, "count");
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int iSmearedHash = Hashing.smearedHash(k6);
        int iHashTableMask = hashTableMask() & iSmearedHash;
        int i6 = this.size;
        int[] iArr2 = this.table;
        int i7 = iArr2[iHashTableMask];
        if (i7 == -1) {
            iArr2[iHashTableMask] = i6;
        } else {
            while (true) {
                long j6 = jArr[i7];
                if (getHash(j6) == iSmearedHash && Objects.equal(k6, objArr[i7])) {
                    int i8 = iArr[i7];
                    iArr[i7] = i5;
                    return i8;
                }
                int next = getNext(j6);
                if (next == -1) {
                    jArr[i7] = swapNext(j6, i6);
                    break;
                }
                i7 = next;
            }
        }
        if (i6 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i9 = i6 + 1;
        resizeMeMaybe(i9);
        insertEntry(i6, k6, i5, iSmearedHash);
        this.size = i9;
        if (i6 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return 0;
    }

    @CanIgnoreReturnValue
    public int remove(Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    @CanIgnoreReturnValue
    public int removeEntry(int i5) {
        return remove(this.keys[i5], getHash(this.entries[i5]));
    }

    public void resizeEntries(int i5) {
        this.keys = Arrays.copyOf(this.keys, i5);
        this.values = Arrays.copyOf(this.values, i5);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i5);
        if (i5 > length) {
            Arrays.fill(jArrCopyOf, length, i5, -1L);
        }
        this.entries = jArrCopyOf;
    }

    public void setValue(int i5, int i6) {
        Preconditions.checkElementIndex(i5, this.size);
        this.values[i5] = i6;
    }

    public int size() {
        return this.size;
    }

    private int remove(Object obj, int i5) {
        int iHashTableMask = hashTableMask() & i5;
        int i6 = this.table[iHashTableMask];
        if (i6 == -1) {
            return 0;
        }
        int i7 = -1;
        while (true) {
            if (getHash(this.entries[i6]) == i5 && Objects.equal(obj, this.keys[i6])) {
                int i8 = this.values[i6];
                if (i7 == -1) {
                    this.table[iHashTableMask] = getNext(this.entries[i6]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i7] = swapNext(jArr[i7], getNext(jArr[i6]));
                }
                moveLastEntry(i6);
                this.size--;
                this.modCount++;
                return i8;
            }
            int next = getNext(this.entries[i6]);
            if (next == -1) {
                return 0;
            }
            i7 = i6;
            i6 = next;
        }
    }

    public ObjectCountHashMap(ObjectCountHashMap<? extends K> objectCountHashMap) {
        init(objectCountHashMap.size(), 1.0f);
        int iFirstIndex = objectCountHashMap.firstIndex();
        while (iFirstIndex != -1) {
            put(objectCountHashMap.getKey(iFirstIndex), objectCountHashMap.getValue(iFirstIndex));
            iFirstIndex = objectCountHashMap.nextIndex(iFirstIndex);
        }
    }

    public ObjectCountHashMap(int i5) {
        this(i5, 1.0f);
    }

    public ObjectCountHashMap(int i5, float f6) {
        init(i5, f6);
    }
}
