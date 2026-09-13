package androidx.collection;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.T;
import P3.b;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1095i;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, b {
    private int _size;
    private Object[] array;
    private int[] hashes;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int i5) {
            return ArraySet.this.valueAt(i5);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int i5) {
            ArraySet.this.removeAt(i5);
        }
    }

    public ArraySet() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i5;
        int iIndexOf;
        int i6 = get_size$collection();
        if (e == null) {
            iIndexOf = ArraySetKt.indexOfNull(this);
            i5 = 0;
        } else {
            int iHashCode = e.hashCode();
            i5 = iHashCode;
            iIndexOf = ArraySetKt.indexOf(this, e, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i7 = ~iIndexOf;
        if (i6 >= getHashes$collection().length) {
            int i8 = 8;
            if (i6 >= 8) {
                i8 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i8 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i8);
            if (i6 != get_size$collection()) {
                throw new ConcurrentModificationException();
            }
            if (getHashes$collection().length != 0) {
                AbstractC0151t.b(hashes$collection, getHashes$collection(), 0, hashes$collection.length, 6);
                AbstractC0151t.c(array$collection, getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i7 < i6) {
            int i9 = i7 + 1;
            AbstractC0151t.copyInto(getHashes$collection(), getHashes$collection(), i9, i7, i6);
            AbstractC0151t.copyInto(getArray$collection(), getArray$collection(), i9, i7, i6);
        }
        if (i6 != get_size$collection() || i7 >= getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        getHashes$collection()[i7] = i5;
        getArray$collection()[i7] = e;
        set_size$collection(get_size$collection() + 1);
        return true;
    }

    public final void addAll(ArraySet<? extends E> array) {
        E.f(array, "array");
        int i5 = array.get_size$collection();
        ensureCapacity(get_size$collection() + i5);
        if (get_size$collection() != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                add(array.valueAt(i6));
            }
        } else if (i5 > 0) {
            AbstractC0151t.b(array.getHashes$collection(), getHashes$collection(), 0, i5, 6);
            AbstractC0151t.c(array.getArray$collection(), getArray$collection(), 0, 0, i5, 6);
            if (get_size$collection() != 0) {
                throw new ConcurrentModificationException();
            }
            set_size$collection(i5);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int i5) {
        int i6 = get_size$collection();
        if (getHashes$collection().length < i5) {
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i5);
            if (get_size$collection() > 0) {
                AbstractC0151t.b(hashes$collection, getHashes$collection(), 0, get_size$collection(), 6);
                AbstractC0151t.c(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6);
            }
        }
        if (get_size$collection() != i6) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i5 = get_size$collection();
            for (int i6 = 0; i6 < i5; i6++) {
                if (!((Set) obj).contains(valueAt(i6))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes$collection = getHashes$collection();
        int i5 = get_size$collection();
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += hashes$collection[i7];
        }
        return i6;
    }

    public final int indexOf(Object obj) {
        return obj == null ? ArraySetKt.indexOfNull(this) : ArraySetKt.indexOf(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return get_size$collection() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(ArraySet<? extends E> array) {
        E.f(array, "array");
        int i5 = array.get_size$collection();
        int i6 = get_size$collection();
        for (int i7 = 0; i7 < i5; i7++) {
            remove(array.valueAt(i7));
        }
        return i6 != get_size$collection();
    }

    public final E removeAt(int i5) {
        int i6;
        int i7 = get_size$collection();
        E e = (E) getArray$collection()[i5];
        if (i7 <= 1) {
            clear();
            return e;
        }
        int i8 = i7 - 1;
        if (getHashes$collection().length <= 8 || get_size$collection() >= getHashes$collection().length / 3) {
            if (i5 < i8) {
                int i9 = i5 + 1;
                AbstractC0151t.copyInto(getHashes$collection(), getHashes$collection(), i5, i9, i7);
                AbstractC0151t.copyInto(getArray$collection(), getArray$collection(), i5, i9, i7);
            }
            getArray$collection()[i8] = null;
        } else {
            int i10 = get_size$collection() > 8 ? get_size$collection() + (get_size$collection() >> 1) : 8;
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i10);
            if (i5 > 0) {
                AbstractC0151t.b(hashes$collection, getHashes$collection(), 0, i5, 6);
                i6 = i5;
                AbstractC0151t.c(array$collection, getArray$collection(), 0, 0, i6, 6);
            } else {
                i6 = i5;
            }
            if (i6 < i8) {
                int i11 = i6 + 1;
                AbstractC0151t.copyInto(hashes$collection, getHashes$collection(), i6, i11, i7);
                AbstractC0151t.copyInto(array$collection, getArray$collection(), i6, i11, i7);
            }
        }
        if (i7 != get_size$collection()) {
            throw new ConcurrentModificationException();
        }
        set_size$collection(i8);
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        boolean z6 = false;
        for (int i5 = get_size$collection() - 1; -1 < i5; i5--) {
            if (!T.contains(elements, getArray$collection()[i5])) {
                removeAt(i5);
                z6 = true;
            }
        }
        return z6;
    }

    public final void setArray$collection(Object[] objArr) {
        E.f(objArr, "<set-?>");
        this.array = objArr;
    }

    public final void setHashes$collection(int[] iArr) {
        E.f(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void set_size$collection(int i5) {
        this._size = i5;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return AbstractC0151t.copyOfRange(this.array, 0, this._size);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i5 = get_size$collection();
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E eValueAt = valueAt(i6);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        return AbstractC0157z.j('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public final E valueAt(int i5) {
        return (E) getArray$collection()[i5];
    }

    public ArraySet(int i5) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i5 > 0) {
            ArraySetKt.allocArrays(this, i5);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] array) {
        E.f(array, "array");
        T[] result = (T[]) ArraySetJvmUtil.resizeForToArray(array, this._size);
        AbstractC0151t.copyInto(this.array, result, 0, 0, this._size);
        E.e(result, "result");
        return result;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    public /* synthetic */ ArraySet(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public ArraySet(ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        E.f(elements, "elements");
        ensureCapacity(elements.size() + get_size$collection());
        Iterator<? extends E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(E[] eArr) {
        this(0);
        if (eArr != null) {
            Iterator it = AbstractC1095i.iterator(eArr);
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }
}
