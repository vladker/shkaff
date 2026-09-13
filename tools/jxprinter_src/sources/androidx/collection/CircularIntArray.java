package androidx.collection;

import A3.AbstractC0151t;
import kotlin.jvm.internal.AbstractC1107v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        this(0, 1, null);
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i5 = this.head;
        int i6 = length - i5;
        int i7 = length << 1;
        if (i7 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i7];
        AbstractC0151t.copyInto(iArr, iArr2, 0, i5, length);
        AbstractC0151t.copyInto(this.elements, iArr2, i6, 0, this.head);
        this.elements = iArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i7 - 1;
    }

    public final void addFirst(int i5) {
        int i6 = (this.head - 1) & this.capacityBitmask;
        this.head = i6;
        this.elements[i6] = i5;
        if (i6 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int i5) {
        int[] iArr = this.elements;
        int i6 = this.tail;
        iArr[i6] = i5;
        int i7 = this.capacityBitmask & (i6 + 1);
        this.tail = i7;
        if (i7 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int get(int i5) {
        if (i5 < 0 || i5 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.elements[this.capacityBitmask & (this.head + i5)];
    }

    public final int getFirst() {
        int i5 = this.head;
        if (i5 != this.tail) {
            return this.elements[i5];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i5 = this.head;
        int i6 = this.tail;
        if (i5 != i6) {
            return this.elements[(i6 - 1) & this.capacityBitmask];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final int popFirst() {
        int i5 = this.head;
        if (i5 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i6 = this.elements[i5];
        this.head = (i5 + 1) & this.capacityBitmask;
        return i6;
    }

    public final int popLast() {
        int i5 = this.head;
        int i6 = this.tail;
        if (i5 == i6) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = this.capacityBitmask & (i6 - 1);
        int i8 = this.elements[i7];
        this.tail = i7;
        return i8;
    }

    public final void removeFromEnd(int i5) {
        if (i5 <= 0) {
            return;
        }
        if (i5 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.tail = this.capacityBitmask & (this.tail - i5);
    }

    public final void removeFromStart(int i5) {
        if (i5 <= 0) {
            return;
        }
        if (i5 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.head = this.capacityBitmask & (this.head + i5);
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularIntArray(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i5 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i5 = Integer.bitCount(i5) != 1 ? Integer.highestOneBit(i5 - 1) << 1 : i5;
        this.capacityBitmask = i5 - 1;
        this.elements = new int[i5];
    }

    public /* synthetic */ CircularIntArray(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 8 : i5);
    }
}
