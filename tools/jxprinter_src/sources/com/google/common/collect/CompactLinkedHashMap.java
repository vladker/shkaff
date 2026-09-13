package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.flutter.embedding.android.KeyboardMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i5) {
        return new CompactLinkedHashMap<>(i5);
    }

    private int getPredecessor(int i5) {
        return ((int) (link(i5) >>> 32)) - 1;
    }

    private long link(int i5) {
        return requireLinks()[i5];
    }

    private long[] requireLinks() {
        long[] jArr = this.links;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    private void setLink(int i5, long j6) {
        requireLinks()[i5] = j6;
    }

    private void setPredecessor(int i5, int i6) {
        setLink(i5, (link(i5) & KeyboardMap.kValueMask) | (((long) (i6 + 1)) << 32));
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
        setLink(i5, (link(i5) & (-4294967296L)) | (((long) (i6 + 1)) & KeyboardMap.kValueMask));
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i5) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i5), getSuccessor(i5));
            setSucceeds(this.lastEntry, i5);
            setSucceeds(i5, -2);
            incrementModCount();
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i5, int i6) {
        return i5 >= size() ? i6 : i5;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int allocArrays() {
        int iAllocArrays = super.allocArrays();
        this.links = new long[iAllocArrays];
        return iAllocArrays;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = this.links;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    @CanIgnoreReturnValue
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> mapConvertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return mapConvertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> createHashFloodingResistantDelegate(int i5) {
        return new LinkedHashMap(i5, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int i5) {
        return ((int) link(i5)) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int i5) {
        super.init(i5);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i5, @ParametricNullness K k6, @ParametricNullness V v6, int i6, int i7) {
        super.insertEntry(i5, k6, v6, i6, i7);
        setSucceeds(this.lastEntry, i5);
        setSucceeds(i5, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i5, int i6) {
        int size = size() - 1;
        super.moveLastEntry(i5, i6);
        setSucceeds(getPredecessor(i5), getSuccessor(i5));
        if (i5 < size) {
            setSucceeds(getPredecessor(size), i5);
            setSucceeds(i5, getSuccessor(size));
        }
        setLink(size, 0L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i5) {
        super.resizeEntries(i5);
        this.links = Arrays.copyOf(requireLinks(), i5);
    }

    public CompactLinkedHashMap(int i5) {
        this(i5, false);
    }

    public CompactLinkedHashMap(int i5, boolean z6) {
        super(i5);
        this.accessOrder = z6;
    }
}
