package org.apache.commons.collections4.iterators;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ListIteratorWrapper<E> implements ResettableListIterator<E> {
    private static final String CANNOT_REMOVE_MESSAGE = "Cannot remove element at index {0}.";
    private static final String UNSUPPORTED_OPERATION_MESSAGE = "ListIteratorWrapper does not support optional operations of ListIterator.";
    private final Iterator<? extends E> iterator;
    private boolean removeState;
    private final List<E> list = new ArrayList();
    private int currentIndex = 0;
    private int wrappedIteratorIndex = 0;

    public ListIteratorWrapper(Iterator<? extends E> it) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.iterator = it;
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        Iterator<? extends E> it = this.iterator;
        if (!(it instanceof ListIterator)) {
            throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
        }
        ((ListIterator) it).add(e);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentIndex == this.wrappedIteratorIndex || (this.iterator instanceof ListIterator)) {
            return this.iterator.hasNext();
        }
        return true;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            return ((ListIterator) it).hasPrevious();
        }
        return this.currentIndex > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            return it.next();
        }
        int i5 = this.currentIndex;
        if (i5 < this.wrappedIteratorIndex) {
            this.currentIndex = i5 + 1;
            return this.list.get(i5);
        }
        E next = it.next();
        this.list.add(next);
        this.currentIndex++;
        this.wrappedIteratorIndex++;
        this.removeState = true;
        return next;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        Iterator<? extends E> it = this.iterator;
        return it instanceof ListIterator ? ((ListIterator) it).nextIndex() : this.currentIndex;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public E previous() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            return (E) ((ListIterator) it).previous();
        }
        int i5 = this.currentIndex;
        if (i5 == 0) {
            throw new NoSuchElementException();
        }
        this.removeState = this.wrappedIteratorIndex == i5;
        List<E> list = this.list;
        int i6 = i5 - 1;
        this.currentIndex = i6;
        return list.get(i6);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        Iterator<? extends E> it = this.iterator;
        return it instanceof ListIterator ? ((ListIterator) it).previousIndex() : this.currentIndex - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            it.remove();
            return;
        }
        int i5 = this.currentIndex;
        int i6 = this.wrappedIteratorIndex;
        int i7 = i5 == i6 ? i5 - 1 : i5;
        if (!this.removeState || i6 - i5 > 1) {
            throw new IllegalStateException(MessageFormat.format(CANNOT_REMOVE_MESSAGE, Integer.valueOf(i7)));
        }
        it.remove();
        this.list.remove(i7);
        this.currentIndex = i7;
        this.wrappedIteratorIndex--;
        this.removeState = false;
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        Iterator<? extends E> it = this.iterator;
        if (!(it instanceof ListIterator)) {
            this.currentIndex = 0;
            return;
        }
        ListIterator listIterator = (ListIterator) it;
        while (listIterator.previousIndex() >= 0) {
            listIterator.previous();
        }
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        Iterator<? extends E> it = this.iterator;
        if (!(it instanceof ListIterator)) {
            throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
        }
        ((ListIterator) it).set(e);
    }
}
