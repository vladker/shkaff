package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CollatingIterator<E> implements Iterator<E> {
    private Comparator<? super E> comparator;
    private List<Iterator<? extends E>> iterators;
    private int lastReturned;
    private BitSet valueSet;
    private List<E> values;

    public CollatingIterator() {
        this((Comparator) null, 2);
    }

    private boolean anyHasNext(List<Iterator<? extends E>> list) {
        Iterator<Iterator<? extends E>> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().hasNext()) {
                return true;
            }
        }
        return false;
    }

    private boolean anyValueSet(BitSet bitSet) {
        for (int i5 = 0; i5 < bitSet.size(); i5++) {
            if (bitSet.get(i5)) {
                return true;
            }
        }
        return false;
    }

    private void checkNotStarted() {
        if (this.values != null) {
            throw new IllegalStateException("Can't do that after next or hasNext has been called.");
        }
    }

    private void clear(int i5) {
        this.values.set(i5, null);
        this.valueSet.clear(i5);
    }

    private int least() {
        Object obj = null;
        int i5 = -1;
        for (int i6 = 0; i6 < this.values.size(); i6++) {
            if (!this.valueSet.get(i6)) {
                set(i6);
            }
            if (this.valueSet.get(i6)) {
                if (i5 == -1) {
                    obj = this.values.get(i6);
                    i5 = i6;
                } else {
                    E e = this.values.get(i6);
                    Comparator<? super E> comparator = this.comparator;
                    if (comparator == null) {
                        throw new NullPointerException("You must invoke setComparator() to set a comparator first.");
                    }
                    if (comparator.compare(e, obj) < 0) {
                        i5 = i6;
                        obj = e;
                    }
                }
            }
        }
        return i5;
    }

    private boolean set(int i5) {
        Iterator<? extends E> it = this.iterators.get(i5);
        if (it.hasNext()) {
            this.values.set(i5, it.next());
            this.valueSet.set(i5);
            return true;
        }
        this.values.set(i5, null);
        this.valueSet.clear(i5);
        return false;
    }

    private void start() {
        if (this.values == null) {
            this.values = new ArrayList(this.iterators.size());
            this.valueSet = new BitSet(this.iterators.size());
            for (int i5 = 0; i5 < this.iterators.size(); i5++) {
                this.values.add(null);
                this.valueSet.clear(i5);
            }
        }
    }

    public void addIterator(Iterator<? extends E> it) {
        checkNotStarted();
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.iterators.add(it);
    }

    public Comparator<? super E> getComparator() {
        return this.comparator;
    }

    public int getIteratorIndex() {
        int i5 = this.lastReturned;
        if (i5 != -1) {
            return i5;
        }
        throw new IllegalStateException("No value has been returned yet");
    }

    public List<Iterator<? extends E>> getIterators() {
        return UnmodifiableList.unmodifiableList(this.iterators);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        start();
        return anyValueSet(this.valueSet) || anyHasNext(this.iterators);
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int iLeast = least();
        if (iLeast == -1) {
            throw new NoSuchElementException();
        }
        E e = this.values.get(iLeast);
        clear(iLeast);
        this.lastReturned = iLeast;
        return e;
    }

    @Override // java.util.Iterator
    public void remove() {
        int i5 = this.lastReturned;
        if (i5 == -1) {
            throw new IllegalStateException("No value can be removed at present");
        }
        this.iterators.get(i5).remove();
    }

    public void setComparator(Comparator<? super E> comparator) {
        checkNotStarted();
        this.comparator = comparator;
    }

    public void setIterator(int i5, Iterator<? extends E> it) {
        checkNotStarted();
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.iterators.set(i5, it);
    }

    public CollatingIterator(Comparator<? super E> comparator) {
        this(comparator, 2);
    }

    public CollatingIterator(Comparator<? super E> comparator, int i5) {
        this.comparator = null;
        this.iterators = null;
        this.values = null;
        this.valueSet = null;
        this.lastReturned = -1;
        this.iterators = new ArrayList(i5);
        setComparator(comparator);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E> it, Iterator<? extends E> it2) {
        this(comparator, 2);
        addIterator(it);
        addIterator(it2);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E>[] itArr) {
        this(comparator, itArr.length);
        for (Iterator<? extends E> it : itArr) {
            addIterator(it);
        }
    }

    public CollatingIterator(Comparator<? super E> comparator, Collection<Iterator<? extends E>> collection) {
        this(comparator, collection.size());
        Iterator<Iterator<? extends E>> it = collection.iterator();
        while (it.hasNext()) {
            addIterator(it.next());
        }
    }
}
