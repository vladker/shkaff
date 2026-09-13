package androidx.collection;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.C;
import A3.I;
import A3.T;
import O3.l;
import P3.b;
import U3.B;
import U3.q;
import W3.InterfaceC0233q;
import W3.L;
import androidx.annotation.IntRange;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.AbstractC1106u;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, P3.a {
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(List<T> list, int i5) {
            E.f(list, "list");
            this.list = list;
            this.prevIndex = i5 - 1;
        }

        @Override // java.util.ListIterator
        public void add(T t6) {
            List<T> list = this.list;
            int i5 = this.prevIndex + 1;
            this.prevIndex = i5;
            list.add(i5, t6);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.prevIndex < this.list.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.prevIndex >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i5 = this.prevIndex + 1;
            this.prevIndex = i5;
            return list.get(i5);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> list = this.list;
            int i5 = this.prevIndex;
            this.prevIndex = i5 - 1;
            return list.get(i5);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public void set(T t6) {
            this.list.set(this.prevIndex, t6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ObjectListMutableList<T> implements List<T>, b {
        private final MutableObjectList<T> objectList;

        public ObjectListMutableList(MutableObjectList<T> objectList) {
            E.f(objectList, "objectList");
            this.objectList = objectList;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t6) {
            return this.objectList.add(t6);
        }

        @Override // java.util.List
        public boolean addAll(int i5, Collection<? extends T> elements) {
            E.f(elements, "elements");
            return this.objectList.addAll(i5, elements);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.objectList.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            E.f(elements, "elements");
            return this.objectList.containsAll(elements);
        }

        @Override // java.util.List
        public T get(int i5) {
            ObjectListKt.checkIndex(this, i5);
            return this.objectList.get(i5);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.objectList.indexOf(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.objectList.lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i5) {
            return removeAt(i5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            E.f(elements, "elements");
            return this.objectList.removeAll(elements);
        }

        public T removeAt(int i5) {
            ObjectListKt.checkIndex(this, i5);
            return this.objectList.removeAt(i5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            E.f(elements, "elements");
            return this.objectList.retainAll((Collection<? extends T>) elements);
        }

        @Override // java.util.List
        public T set(int i5, T t6) {
            ObjectListKt.checkIndex(this, i5);
            return this.objectList.set(i5, t6);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int i5, int i6) {
            ObjectListKt.checkSubIndex(this, i5, i6);
            return new SubList(this, i5, i6);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return AbstractC1106u.toArray(this);
        }

        @Override // java.util.List
        public void add(int i5, T t6) {
            this.objectList.add(i5, t6);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            E.f(elements, "elements");
            return this.objectList.addAll(elements);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i5) {
            return new MutableObjectListIterator(this, i5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.objectList.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            E.f(array, "array");
            return (T[]) AbstractC1106u.toArray(this, array);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SubList<T> implements List<T>, b {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> list, int i5, int i6) {
            E.f(list, "list");
            this.list = list;
            this.start = i5;
            this.end = i6;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t6) {
            List<T> list = this.list;
            int i5 = this.end;
            this.end = i5 + 1;
            list.add(i5, t6);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i5, Collection<? extends T> elements) {
            E.f(elements, "elements");
            this.list.addAll(i5 + this.start, elements);
            this.end = elements.size() + this.end;
            return elements.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i5 = this.end - 1;
            int i6 = this.start;
            if (i6 <= i5) {
                while (true) {
                    this.list.remove(i5);
                    if (i5 == i6) {
                        break;
                    } else {
                        i5--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i5 = this.end;
            for (int i6 = this.start; i6 < i5; i6++) {
                if (E.a(this.list.get(i6), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            E.f(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int i5) {
            ObjectListKt.checkIndex(this, i5);
            return this.list.get(i5 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i5 = this.end;
            for (int i6 = this.start; i6 < i5; i6++) {
                if (E.a(this.list.get(i6), obj)) {
                    return i6 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i5 = this.end - 1;
            int i6 = this.start;
            if (i6 > i5) {
                return -1;
            }
            while (!E.a(this.list.get(i5), obj)) {
                if (i5 == i6) {
                    return -1;
                }
                i5--;
            }
            return i5 - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i5) {
            return removeAt(i5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            E.f(elements, "elements");
            int i5 = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i5 != this.end;
        }

        public T removeAt(int i5) {
            ObjectListKt.checkIndex(this, i5);
            T tRemove = this.list.remove(i5 + this.start);
            this.end--;
            return tRemove;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            E.f(elements, "elements");
            int i5 = this.end;
            int i6 = i5 - 1;
            int i7 = this.start;
            if (i7 <= i6) {
                while (true) {
                    if (!elements.contains(this.list.get(i6))) {
                        this.list.remove(i6);
                        this.end--;
                    }
                    if (i6 == i7) {
                        break;
                    }
                    i6--;
                }
            }
            return i5 != this.end;
        }

        @Override // java.util.List
        public T set(int i5, T t6) {
            ObjectListKt.checkIndex(this, i5);
            return this.list.set(i5 + this.start, t6);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int i5, int i6) {
            ObjectListKt.checkSubIndex(this, i5, i6);
            return new SubList(this, i5, i6);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return AbstractC1106u.toArray(this);
        }

        @Override // java.util.List
        public void add(int i5, T t6) {
            this.list.add(i5 + this.start, t6);
            this.end++;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i5) {
            return new MutableObjectListIterator(this, i5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i5 = this.end;
            for (int i6 = this.start; i6 < i5; i6++) {
                if (E.a(this.list.get(i6), obj)) {
                    this.list.remove(i6);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            E.f(array, "array");
            return (T[]) AbstractC1106u.toArray(this, array);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            E.f(elements, "elements");
            this.list.addAll(this.end, elements);
            this.end = elements.size() + this.end;
            return elements.size() > 0;
        }
    }

    public MutableObjectList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = mutableObjectList._size;
        }
        mutableObjectList.trim(i5);
    }

    public final boolean add(E e) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i5 = this._size;
        objArr[i5] = e;
        this._size = i5 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, E[] elements) {
        int i6;
        E.f(elements, "elements");
        if (i5 < 0 || i5 > (i6 = this._size)) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
            sbT.append(this._size);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i6 + elements.length);
        Object[] objArr = this.content;
        int i7 = this._size;
        if (i5 != i7) {
            AbstractC0151t.copyInto(objArr, objArr, elements.length + i5, i5, i7);
        }
        AbstractC0151t.c(elements, objArr, i5, 0, 0, 12);
        this._size += elements.length;
        return true;
    }

    @Override // androidx.collection.ObjectList
    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        ObjectListMutableList<E> objectListMutableList2 = new ObjectListMutableList<>(this);
        this.list = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void clear() {
        AbstractC0151t.fill(this.content, (Object) null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int i5) {
        Object[] objArr = this.content;
        if (objArr.length < i5) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, Math.max(i5, (objArr.length * 3) / 2));
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.content = objArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(E e) {
        remove(e);
    }

    public final void plusAssign(ObjectList<E> elements) {
        E.f(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + elements._size);
        AbstractC0151t.copyInto(elements.content, this.content, this._size, 0, elements._size);
        this._size += elements._size;
    }

    public final boolean remove(E e) {
        int iIndexOf = indexOf(e);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(E[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        for (E e : elements) {
            remove(e);
        }
        return i5 != this._size;
    }

    public final E removeAt(@IntRange(from = 0) int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this._size)) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "Index ", " must be in 0.."), this._size, 1));
        }
        Object[] objArr = this.content;
        E e = (E) objArr[i5];
        if (i5 != i6 - 1) {
            AbstractC0151t.copyInto(objArr, objArr, i5, i5 + 1, i6);
        }
        int i7 = this._size - 1;
        this._size = i7;
        objArr[i7] = null;
        return e;
    }

    public final void removeIf(l predicate) {
        E.f(predicate, "predicate");
        int i5 = this._size;
        Object[] objArr = this.content;
        int i6 = 0;
        q qVarUntil = B.until(0, i5);
        int i7 = qVarUntil.f732a;
        int i8 = qVarUntil.b;
        if (i7 <= i8) {
            while (true) {
                objArr[i7 - i6] = objArr[i7];
                if (((Boolean) predicate.invoke(objArr[i7])).booleanValue()) {
                    i6++;
                }
                if (i7 == i8) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        AbstractC0151t.fill(objArr, (Object) null, i5 - i6, i5);
        this._size -= i6;
    }

    public final void removeRange(@IntRange(from = 0) int i5, @IntRange(from = 0) int i6) {
        int i7;
        if (i5 < 0 || i5 > (i7 = this._size) || i6 < 0 || i6 > i7) {
            StringBuilder sbS = a.s("Start (", i5, i6, ") and end (", ") must be in 0..");
            sbS.append(this._size);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException("Start (" + i5 + ") is more than end (" + i6 + ')');
        }
        if (i6 != i5) {
            if (i6 < i7) {
                Object[] objArr = this.content;
                AbstractC0151t.copyInto(objArr, objArr, i5, i6, i7);
            }
            int i8 = this._size;
            int i9 = i8 - (i6 - i5);
            AbstractC0151t.fill(this.content, (Object) null, i9, i8);
            this._size = i9;
        }
    }

    public final boolean retainAll(E[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (C.indexOf(elements, objArr[i6]) < 0) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final E set(@IntRange(from = 0) int i5, E e) {
        if (i5 < 0 || i5 >= this._size) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "set index ", " must be between 0 .. "), this._size, 1));
        }
        Object[] objArr = this.content;
        E e6 = (E) objArr[i5];
        objArr[i5] = e;
        return e6;
    }

    public final void trim(int i5) {
        int iMax = Math.max(i5, this._size);
        Object[] objArr = this.content;
        if (objArr.length > iMax) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, iMax);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.content = objArrCopyOf;
        }
    }

    public /* synthetic */ MutableObjectList(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final void minusAssign(List<? extends E> elements) {
        E.f(elements, "elements");
        int size = elements.size();
        for (int i5 = 0; i5 < size; i5++) {
            remove(elements.get(i5));
        }
    }

    public MutableObjectList(int i5) {
        super(i5, null);
    }

    public final void add(@IntRange(from = 0) int i5, E e) {
        int i6;
        if (i5 >= 0 && i5 <= (i6 = this._size)) {
            ensureCapacity(i6 + 1);
            Object[] objArr = this.content;
            int i7 = this._size;
            if (i5 != i7) {
                AbstractC0151t.copyInto(objArr, objArr, i5 + 1, i5, i7);
            }
            objArr[i5] = e;
            this._size++;
            return;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final void minusAssign(E[] elements) {
        E.f(elements, "elements");
        for (E e : elements) {
            remove(e);
        }
    }

    public final boolean removeAll(ObjectList<E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        minusAssign((ObjectList) elements);
        return i5 != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> elements) {
        E.f(elements, "elements");
        Object[] objArr = elements.content;
        int i5 = elements._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(objArr[i6]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ObjectList<E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!elements.contains(objArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean removeAll(ScatterSet<E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        minusAssign((ScatterSet) elements);
        return i5 != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> elements) {
        E.f(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(elements.getSize() + this._size);
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        add(objArr[(i5 << 3) + i7]);
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> elements) {
        E.f(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        remove(objArr[(i5 << 3) + i7]);
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final boolean removeAll(List<? extends E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        minusAssign((List) elements);
        return i5 != this._size;
    }

    public final boolean retainAll(Collection<? extends E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!elements.contains(objArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean removeAll(Iterable<? extends E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        minusAssign((Iterable) elements);
        return i5 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, Collection<? extends E> elements) {
        E.f(elements, "elements");
        if (i5 >= 0 && i5 <= this._size) {
            int i6 = 0;
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(elements.size() + this._size);
            Object[] objArr = this.content;
            if (i5 != this._size) {
                AbstractC0151t.copyInto(objArr, objArr, elements.size() + i5, i5, this._size);
            }
            for (Object obj : elements) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    I.throwIndexOverflow();
                }
                objArr[i6 + i5] = obj;
                i6 = i7;
            }
            this._size = elements.size() + this._size;
            return true;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final void minusAssign(Iterable<? extends E> elements) {
        E.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(E[] elements) {
        E.f(elements, "elements");
        if (elements.length == 0) {
            return;
        }
        ensureCapacity(this._size + elements.length);
        AbstractC0151t.c(elements, this.content, this._size, 0, 0, 12);
        this._size += elements.length;
    }

    public final boolean removeAll(InterfaceC0233q elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        minusAssign(elements);
        return i5 != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(InterfaceC0233q elements) {
        E.f(elements, "elements");
        Iterator<Object> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean retainAll(Iterable<? extends E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!T.contains(elements, objArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final void plusAssign(List<? extends E> elements) {
        E.f(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int i5 = this._size;
        ensureCapacity(elements.size() + i5);
        Object[] objArr = this.content;
        int size = elements.size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i6 + i5] = elements.get(i6);
        }
        this._size = elements.size() + this._size;
    }

    public final boolean retainAll(InterfaceC0233q elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        Object[] objArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!L.contains(elements, objArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final void plusAssign(E e) {
        add(e);
    }

    public final void plusAssign(Iterable<? extends E> elements) {
        E.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(InterfaceC0233q elements) {
        E.f(elements, "elements");
        Iterator<Object> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final boolean addAll(@IntRange(from = 0) int i5, ObjectList<E> elements) {
        E.f(elements, "elements");
        if (i5 >= 0 && i5 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            Object[] objArr = this.content;
            int i6 = this._size;
            if (i5 != i6) {
                AbstractC0151t.copyInto(objArr, objArr, elements._size + i5, i5, i6);
            }
            AbstractC0151t.copyInto(elements.content, objArr, i5, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final boolean addAll(ObjectList<E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        plusAssign((ObjectList) elements);
        return i5 != this._size;
    }

    public final boolean addAll(ScatterSet<E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        plusAssign((ScatterSet) elements);
        return i5 != this._size;
    }

    public final boolean addAll(E[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        plusAssign((Object[]) elements);
        return i5 != this._size;
    }

    public final boolean addAll(List<? extends E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        plusAssign((List) elements);
        return i5 != this._size;
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        plusAssign((Iterable) elements);
        return i5 != this._size;
    }

    public final boolean addAll(InterfaceC0233q elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        plusAssign(elements);
        return i5 != this._size;
    }
}
