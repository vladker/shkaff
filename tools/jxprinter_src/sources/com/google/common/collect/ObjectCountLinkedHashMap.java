package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import io.flutter.embedding.android.KeyboardMap;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    transient long[] links;

    public ObjectCountLinkedHashMap() {
        this(3);
    }

    public static <K> ObjectCountLinkedHashMap<K> create() {
        return new ObjectCountLinkedHashMap<>();
    }

    public static <K> ObjectCountLinkedHashMap<K> createWithExpectedSize(int i5) {
        return new ObjectCountLinkedHashMap<>(i5);
    }

    private int getPredecessor(int i5) {
        return (int) (this.links[i5] >>> 32);
    }

    private int getSuccessor(int i5) {
        return (int) this.links[i5];
    }

    private void setPredecessor(int i5, int i6) {
        long[] jArr = this.links;
        jArr[i5] = (jArr[i5] & KeyboardMap.kValueMask) | (((long) i6) << 32);
    }

    private void setSucceeds(int i5, int i6) {
        if (i5 == -2) {
            this.firstEntry = i6;
        } else {
            setSuccessor(i5, i6);
        }
        if (i6 == -2) {
            this.lastEntry = i5;
        } else {
            setPredecessor(i6, i5);
        }
    }

    private void setSuccessor(int i5, int i6) {
        long[] jArr = this.links;
        jArr[i5] = (jArr[i5] & (-4294967296L)) | (((long) i6) & KeyboardMap.kValueMask);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int firstIndex() {
        int i5 = this.firstEntry;
        if (i5 == -2) {
            return -1;
        }
        return i5;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void init(int i5, float f6) {
        super.init(i5, f6);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i5];
        this.links = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void insertEntry(int i5, @ParametricNullness K k6, int i6, int i7) {
        super.insertEntry(i5, k6, i6, i7);
        setSucceeds(this.lastEntry, i5);
        setSucceeds(i5, -2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void moveLastEntry(int i5) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i5), getSuccessor(i5));
        if (i5 < size) {
            setSucceeds(getPredecessor(size), i5);
            setSucceeds(i5, getSuccessor(size));
        }
        super.moveLastEntry(i5);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int nextIndex(int i5) {
        int successor = getSuccessor(i5);
        if (successor == -2) {
            return -1;
        }
        return successor;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int nextIndexAfterRemove(int i5, int i6) {
        return i5 == size() ? i6 : i5;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void resizeEntries(int i5) {
        super.resizeEntries(i5);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i5);
        this.links = jArrCopyOf;
        Arrays.fill(jArrCopyOf, length, i5, -1L);
    }

    public ObjectCountLinkedHashMap(int i5) {
        this(i5, 1.0f);
    }

    public ObjectCountLinkedHashMap(int i5, float f6) {
        super(i5, f6);
    }

    public ObjectCountLinkedHashMap(ObjectCountHashMap<K> objectCountHashMap) {
        init(objectCountHashMap.size(), 1.0f);
        int iFirstIndex = objectCountHashMap.firstIndex();
        while (iFirstIndex != -1) {
            put(objectCountHashMap.getKey(iFirstIndex), objectCountHashMap.getValue(iFirstIndex));
            iFirstIndex = objectCountHashMap.nextIndex(iFirstIndex);
        }
    }
}
