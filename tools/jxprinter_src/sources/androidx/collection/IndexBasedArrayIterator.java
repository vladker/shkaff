package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, P3.a {
    private boolean canRemove;
    private int index;
    private int size;

    public IndexBasedArrayIterator(int i5) {
        this.size = i5;
    }

    public abstract T elementAt(int i5);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.size;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T tElementAt = elementAt(this.index);
        this.index++;
        this.canRemove = true;
        return tElementAt;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i5 = this.index - 1;
        this.index = i5;
        removeAt(i5);
        this.size--;
        this.canRemove = false;
    }

    public abstract void removeAt(int i5);
}
