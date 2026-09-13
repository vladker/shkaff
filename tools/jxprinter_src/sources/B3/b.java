package B3;

import A3.AbstractC0139g;
import A3.AbstractC0140h;
import A3.AbstractC0151t;
import A3.C0136d;
import A3.G;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends AbstractC0140h implements List, RandomAccess, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f90a;
    public int b;
    private Object[] backing;
    private final b parent;
    private final e root;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a implements ListIterator, P3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f91a;
        public int b;
        public int c;
        private final b list;

        public a(b list, int i5) {
            E.f(list, "list");
            this.list = list;
            this.f91a = i5;
            this.b = -1;
            this.c = ((AbstractList) list).modCount;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            b();
            b bVar = this.list;
            int i5 = this.f91a;
            this.f91a = i5 + 1;
            bVar.add(i5, obj);
            this.b = -1;
            this.c = ((AbstractList) this.list).modCount;
        }

        public final void b() {
            if (((AbstractList) this.list.root).modCount != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this.f91a < this.list.b;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f91a > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            b();
            int i5 = this.f91a;
            b bVar = this.list;
            if (i5 >= bVar.b) {
                throw new NoSuchElementException();
            }
            this.f91a = i5 + 1;
            this.b = i5;
            return bVar.backing[this.list.f90a + this.b];
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f91a;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            b();
            int i5 = this.f91a;
            if (i5 <= 0) {
                throw new NoSuchElementException();
            }
            int i6 = i5 - 1;
            this.f91a = i6;
            this.b = i6;
            return this.list.backing[this.list.f90a + this.b];
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f91a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            b();
            int i5 = this.b;
            if (i5 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.list.c(i5);
            this.f91a = this.b;
            this.b = -1;
            this.c = ((AbstractList) this.list).modCount;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            b();
            int i5 = this.b;
            if (i5 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.list.set(i5, obj);
        }
    }

    public b(Object[] backing, int i5, int i6, b bVar, e root) {
        E.f(backing, "backing");
        E.f(root, "root");
        this.backing = backing;
        this.f90a = i5;
        this.b = i6;
        this.parent = bVar;
        this.root = root;
        ((AbstractList) this).modCount = ((AbstractList) root).modCount;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.root.b) {
            return new r(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        j();
        i();
        h(this.f90a + this.b, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<Object> elements) {
        E.f(elements, "elements");
        j();
        i();
        int size = elements.size();
        g(this.f90a + this.b, elements, size);
        return size > 0;
    }

    @Override // A3.AbstractC0140h
    public final int b() {
        i();
        return this.b;
    }

    @Override // A3.AbstractC0140h
    public final Object c(int i5) {
        j();
        i();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.b(i5, i6);
        return k(this.f90a + i5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        j();
        i();
        l(this.f90a, this.b);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        i();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.backing;
            int i5 = this.b;
            if (i5 == list.size()) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (E.a(objArr[this.f90a + i6], list.get(i6))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void g(int i5, Collection collection, int i6) {
        ((AbstractList) this).modCount++;
        b bVar = this.parent;
        if (bVar != null) {
            bVar.g(i5, collection, i6);
        } else {
            e eVar = this.root;
            int i7 = e.c;
            eVar.f(i5, collection, i6);
        }
        this.backing = this.root.backing;
        this.b += i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        i();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.b(i5, i6);
        return this.backing[this.f90a + i5];
    }

    public final void h(int i5, Object obj) {
        ((AbstractList) this).modCount++;
        b bVar = this.parent;
        if (bVar != null) {
            bVar.h(i5, obj);
        } else {
            e eVar = this.root;
            int i6 = e.c;
            eVar.g(i5, obj);
        }
        this.backing = this.root.backing;
        this.b++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        i();
        Object[] objArr = this.backing;
        int i5 = this.b;
        int iHashCode = 1;
        for (int i6 = 0; i6 < i5; i6++) {
            Object obj = objArr[this.f90a + i6];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i() {
        if (((AbstractList) this.root).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        i();
        for (int i5 = 0; i5 < this.b; i5++) {
            if (E.a(this.backing[this.f90a + i5], obj)) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        i();
        return this.b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<Object> iterator() {
        return listIterator(0);
    }

    public final void j() {
        if (this.root.b) {
            throw new UnsupportedOperationException();
        }
    }

    public final Object k(int i5) {
        Object objJ;
        ((AbstractList) this).modCount++;
        b bVar = this.parent;
        if (bVar != null) {
            objJ = bVar.k(i5);
        } else {
            e eVar = this.root;
            int i6 = e.c;
            objJ = eVar.j(i5);
        }
        this.b--;
        return objJ;
    }

    public final void l(int i5, int i6) {
        if (i6 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.parent;
        if (bVar != null) {
            bVar.l(i5, i6);
        } else {
            e eVar = this.root;
            int i7 = e.c;
            eVar.k(i5, i6);
        }
        this.b -= i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        i();
        for (int i5 = this.b - 1; i5 >= 0; i5--) {
            if (E.a(this.backing[this.f90a + i5], obj)) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<Object> listIterator() {
        return listIterator(0);
    }

    public final int m(int i5, int i6, Collection collection, boolean z6) {
        int iL;
        b bVar = this.parent;
        if (bVar != null) {
            iL = bVar.m(i5, i6, collection, z6);
        } else {
            e eVar = this.root;
            int i7 = e.c;
            iL = eVar.l(i5, i6, collection, z6);
        }
        if (iL > 0) {
            ((AbstractList) this).modCount++;
        }
        this.b -= iL;
        return iL;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        j();
        i();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            c(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        j();
        i();
        return m(this.f90a, this.b, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        j();
        i();
        return m(this.f90a, this.b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        j();
        i();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.b(i5, i6);
        Object[] objArr = this.backing;
        int i7 = this.f90a + i5;
        Object obj2 = objArr[i7];
        objArr[i7] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Object> subList(int i5, int i6) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i7 = this.b;
        c0136d.getClass();
        C0136d.d(i5, i6, i7);
        return new b(this.backing, this.f90a + i5, i6 - i5, this, this.root);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        E.f(array, "array");
        i();
        int length = array.length;
        int i5 = this.b;
        int i6 = this.f90a;
        if (length >= i5) {
            AbstractC0151t.copyInto(this.backing, array, 0, i6, i5 + i6);
            return (T[]) G.terminateCollectionToArray(this.b, array);
        }
        T[] tArr = (T[]) Arrays.copyOfRange(this.backing, i6, i5 + i6, array.getClass());
        E.e(tArr, "copyOfRange(...)");
        return tArr;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        i();
        return f.a(this.backing, this.f90a, this.b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<Object> listIterator(int i5) {
        i();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.c(i5, i6);
        return new a(this, i5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        j();
        i();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.c(i5, i6);
        h(this.f90a + i5, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<Object> elements) {
        E.f(elements, "elements");
        j();
        i();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.c(i5, i6);
        int size = elements.size();
        g(this.f90a + i5, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        i();
        Object[] objArr = this.backing;
        int i5 = this.b;
        int i6 = this.f90a;
        return AbstractC0151t.copyOfRange(objArr, i6, i5 + i6);
    }
}
