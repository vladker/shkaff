package androidx.collection;

import A3.AbstractC0151t;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CircularArray<E> {
    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;

    public CircularArray() {
        this(0, 1, null);
    }

    private final void doubleCapacity() {
        E[] eArr = this.elements;
        int length = eArr.length;
        int i5 = this.head;
        int i6 = length - i5;
        int i7 = length << 1;
        if (i7 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr2 = (E[]) new Object[i7];
        AbstractC0151t.copyInto(eArr, eArr2, 0, i5, length);
        AbstractC0151t.copyInto(this.elements, eArr2, i6, 0, this.head);
        this.elements = eArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i7 - 1;
    }

    public final void addFirst(E e) {
        int i5 = (this.head - 1) & this.capacityBitmask;
        this.head = i5;
        this.elements[i5] = e;
        if (i5 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e) {
        E[] eArr = this.elements;
        int i5 = this.tail;
        eArr[i5] = e;
        int i6 = this.capacityBitmask & (i5 + 1);
        this.tail = i6;
        if (i6 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int i5) {
        if (i5 < 0 || i5 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[this.capacityBitmask & (this.head + i5)];
        E.c(e);
        return e;
    }

    public final E getFirst() {
        int i5 = this.head;
        if (i5 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[i5];
        E.c(e);
        return e;
    }

    public final E getLast() {
        int i5 = this.head;
        int i6 = this.tail;
        if (i5 == i6) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[(i6 - 1) & this.capacityBitmask];
        E.c(e);
        return e;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final E popFirst() {
        int i5 = this.head;
        if (i5 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.elements;
        E e = eArr[i5];
        eArr[i5] = null;
        this.head = (i5 + 1) & this.capacityBitmask;
        return e;
    }

    public final E popLast() {
        int i5 = this.head;
        int i6 = this.tail;
        if (i5 == i6) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = this.capacityBitmask & (i6 - 1);
        E[] eArr = this.elements;
        E e = eArr[i7];
        eArr[i7] = null;
        this.tail = i7;
        return e;
    }

    public final void removeFromEnd(int i5) {
        if (i5 <= 0) {
            return;
        }
        if (i5 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i6 = this.tail;
        int i7 = i5 < i6 ? i6 - i5 : 0;
        for (int i8 = i7; i8 < i6; i8++) {
            this.elements[i8] = null;
        }
        int i9 = this.tail;
        int i10 = i9 - i7;
        int i11 = i5 - i10;
        this.tail = i9 - i10;
        if (i11 > 0) {
            int length = this.elements.length;
            this.tail = length;
            int i12 = length - i11;
            for (int i13 = i12; i13 < length; i13++) {
                this.elements[i13] = null;
            }
            this.tail = i12;
        }
    }

    public final void removeFromStart(int i5) {
        if (i5 <= 0) {
            return;
        }
        if (i5 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.elements.length;
        int i6 = this.head;
        if (i5 < length - i6) {
            length = i6 + i5;
        }
        while (i6 < length) {
            this.elements[i6] = null;
            i6++;
        }
        int i7 = this.head;
        int i8 = length - i7;
        int i9 = i5 - i8;
        this.head = this.capacityBitmask & (i7 + i8);
        if (i9 > 0) {
            for (int i10 = 0; i10 < i9; i10++) {
                this.elements[i10] = null;
            }
            this.head = i9;
        }
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularArray(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i5 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i5 = Integer.bitCount(i5) != 1 ? Integer.highestOneBit(i5 - 1) << 1 : i5;
        this.capacityBitmask = i5 - 1;
        this.elements = (E[]) new Object[i5];
    }

    public /* synthetic */ CircularArray(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 8 : i5);
    }
}
