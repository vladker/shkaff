package org.apache.commons.collections4.iterators;

import A3.AbstractC0157z;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArrayIterator<E> implements ResettableIterator<E> {
    final Object array;
    final int endIndex;
    int index;
    final int startIndex;

    public ArrayIterator(Object obj) {
        this(obj, 0);
    }

    public void checkBound(int i5, int i6, String str) {
        if (i5 > i6) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0157z.o("Attempt to make an ArrayIterator that ", str, "s beyond the end of the array. "));
        }
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0157z.o("Attempt to make an ArrayIterator that ", str, "s before the start of the array. "));
        }
    }

    public Object getArray() {
        return this.array;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.array;
        int i5 = this.index;
        this.index = i5 + 1;
        return (E) Array.get(obj, i5);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }

    public ArrayIterator(Object obj, int i5) {
        this(obj, i5, Array.getLength(obj));
    }

    public ArrayIterator(Object obj, int i5, int i6) {
        this.array = obj;
        this.startIndex = i5;
        this.endIndex = i6;
        this.index = i5;
        int length = Array.getLength(obj);
        checkBound(i5, length, "start");
        checkBound(i6, length, "end");
        if (i6 < i5) {
            throw new IllegalArgumentException("End index must not be less than start index.");
        }
    }
}
