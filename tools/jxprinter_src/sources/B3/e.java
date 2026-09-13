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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends AbstractC0140h implements RandomAccess, Serializable {
    private static final c Companion = new c();
    private static final e Empty;
    public static final /* synthetic */ int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f93a;
    public boolean b;
    private Object[] backing;

    static {
        e eVar = new e(0);
        eVar.b = true;
        Empty = eVar;
    }

    public e(int i5) {
        this.backing = f.arrayOfUninitializedElements(i5);
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.b) {
            return new r(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        h();
        g(this.f93a, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<Object> elements) {
        E.f(elements, "elements");
        h();
        int size = elements.size();
        f(this.f93a, elements, size);
        return size > 0;
    }

    @Override // A3.AbstractC0140h
    public final int b() {
        return this.f93a;
    }

    public final List<Object> build() {
        h();
        this.b = true;
        return this.f93a > 0 ? this : Empty;
    }

    @Override // A3.AbstractC0140h
    public final Object c(int i5) {
        h();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.f93a;
        c0136d.getClass();
        C0136d.b(i5, i6);
        return j(i5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        h();
        k(0, this.f93a);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.backing;
            int i5 = this.f93a;
            if (i5 == list.size()) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (E.a(objArr[i6], list.get(i6))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i5, Collection collection, int i6) {
        ((AbstractList) this).modCount++;
        i(i5, i6);
        Iterator it = collection.iterator();
        for (int i7 = 0; i7 < i6; i7++) {
            this.backing[i5 + i7] = it.next();
        }
    }

    public final void g(int i5, Object obj) {
        ((AbstractList) this).modCount++;
        i(i5, 1);
        this.backing[i5] = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.f93a;
        c0136d.getClass();
        C0136d.b(i5, i6);
        return this.backing[i5];
    }

    public final void h() {
        if (this.b) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.backing;
        int i5 = this.f93a;
        int iHashCode = 1;
        for (int i6 = 0; i6 < i5; i6++) {
            Object obj = objArr[i6];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i5, int i6) {
        int i7 = this.f93a + i6;
        if (i7 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.backing;
        if (i7 > objArr.length) {
            C0136d c0136d = AbstractC0139g.Companion;
            int length = objArr.length;
            c0136d.getClass();
            this.backing = f.copyOfUninitializedElements(this.backing, C0136d.e(length, i7));
        }
        Object[] objArr2 = this.backing;
        AbstractC0151t.copyInto(objArr2, objArr2, i5 + i6, i5, this.f93a);
        this.f93a += i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i5 = 0; i5 < this.f93a; i5++) {
            if (E.a(this.backing[i5], obj)) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f93a == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<Object> iterator() {
        return listIterator(0);
    }

    public final Object j(int i5) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.backing;
        Object obj = objArr[i5];
        AbstractC0151t.copyInto(objArr, objArr, i5, i5 + 1, this.f93a);
        f.resetAt(this.backing, this.f93a - 1);
        this.f93a--;
        return obj;
    }

    public final void k(int i5, int i6) {
        if (i6 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.backing;
        AbstractC0151t.copyInto(objArr, objArr, i5, i5 + i6, this.f93a);
        Object[] objArr2 = this.backing;
        int i7 = this.f93a;
        f.resetRange(objArr2, i7 - i6, i7);
        this.f93a -= i6;
    }

    public final int l(int i5, int i6, Collection collection, boolean z6) {
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int i9 = i5 + i7;
            if (collection.contains(this.backing[i9]) == z6) {
                Object[] objArr = this.backing;
                i7++;
                objArr[i8 + i5] = objArr[i9];
                i8++;
            } else {
                i7++;
            }
        }
        int i10 = i6 - i8;
        Object[] objArr2 = this.backing;
        AbstractC0151t.copyInto(objArr2, objArr2, i5 + i8, i6 + i5, this.f93a);
        Object[] objArr3 = this.backing;
        int i11 = this.f93a;
        f.resetRange(objArr3, i11 - i10, i11);
        if (i10 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f93a -= i10;
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i5 = this.f93a - 1; i5 >= 0; i5--) {
            if (E.a(this.backing[i5], obj)) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<Object> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        h();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            c(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        h();
        return l(0, this.f93a, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        h();
        return l(0, this.f93a, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        h();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.f93a;
        c0136d.getClass();
        C0136d.b(i5, i6);
        Object[] objArr = this.backing;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Object> subList(int i5, int i6) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i7 = this.f93a;
        c0136d.getClass();
        C0136d.d(i5, i6, i7);
        return new b(this.backing, i5, i6 - i5, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        E.f(array, "array");
        int length = array.length;
        int i5 = this.f93a;
        if (length >= i5) {
            AbstractC0151t.copyInto(this.backing, array, 0, 0, i5);
            return (T[]) G.terminateCollectionToArray(this.f93a, array);
        }
        T[] tArr = (T[]) Arrays.copyOfRange(this.backing, 0, i5, array.getClass());
        E.e(tArr, "copyOfRange(...)");
        return tArr;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return f.a(this.backing, 0, this.f93a, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<Object> listIterator(int i5) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.f93a;
        c0136d.getClass();
        C0136d.c(i5, i6);
        return new d(this, i5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        h();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.f93a;
        c0136d.getClass();
        C0136d.c(i5, i6);
        g(i5, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<Object> elements) {
        E.f(elements, "elements");
        h();
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.f93a;
        c0136d.getClass();
        C0136d.c(i5, i6);
        int size = elements.size();
        f(i5, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return AbstractC0151t.copyOfRange(this.backing, 0, this.f93a);
    }
}
