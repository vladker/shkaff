package A3;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: A3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0144l extends AbstractC0140h {
    public static final C0143k Companion = new C0143k();
    private static final Object[] emptyElementData = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41a;
    public int b;
    private Object[] elementData;

    public C0144l() {
        this.elementData = emptyElementData;
    }

    private final Object internalGet(int i5) {
        return this.elementData[i5];
    }

    private final int internalIndex(int i5) {
        return i(this.f41a + i5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<Object> elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        j();
        e(elements.size() + b());
        d(i(b() + this.f41a), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        j();
        e(this.b + 1);
        int i5 = this.f41a;
        int lastIndex = i5 == 0 ? C.getLastIndex(this.elementData) : i5 - 1;
        this.f41a = lastIndex;
        this.elementData[lastIndex] = obj;
        this.b++;
    }

    public final void addLast(Object obj) {
        j();
        e(b() + 1);
        this.elementData[i(b() + this.f41a)] = obj;
        this.b = b() + 1;
    }

    @Override // A3.AbstractC0140h
    public final int b() {
        return this.b;
    }

    @Override // A3.AbstractC0140h
    public final Object c(int i5) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.b(i5, i6);
        if (i5 == I.getLastIndex(this)) {
            return removeLast();
        }
        if (i5 == 0) {
            return removeFirst();
        }
        j();
        int i7 = i(this.f41a + i5);
        Object[] objArr = this.elementData;
        Object obj = objArr[i7];
        if (i5 < (this.b >> 1)) {
            int i8 = this.f41a;
            if (i7 >= i8) {
                AbstractC0151t.copyInto(objArr, objArr, i8 + 1, i8, i7);
            } else {
                AbstractC0151t.copyInto(objArr, objArr, 1, 0, i7);
                Object[] objArr2 = this.elementData;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i9 = this.f41a;
                AbstractC0151t.copyInto(objArr2, objArr2, i9 + 1, i9, objArr2.length - 1);
            }
            Object[] objArr3 = this.elementData;
            int i10 = this.f41a;
            objArr3[i10] = null;
            this.f41a = f(i10);
        } else {
            int i11 = i(I.getLastIndex(this) + this.f41a);
            if (i7 <= i11) {
                Object[] objArr4 = this.elementData;
                AbstractC0151t.copyInto(objArr4, objArr4, i7, i7 + 1, i11 + 1);
            } else {
                Object[] objArr5 = this.elementData;
                AbstractC0151t.copyInto(objArr5, objArr5, i7, i7 + 1, objArr5.length);
                Object[] objArr6 = this.elementData;
                objArr6[objArr6.length - 1] = objArr6[0];
                AbstractC0151t.copyInto(objArr6, objArr6, 0, 1, i11 + 1);
            }
            this.elementData[i11] = null;
        }
        this.b--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            j();
            h(this.f41a, i(b() + this.f41a));
        }
        this.f41a = 0;
        this.b = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i5, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.elementData.length;
        while (i5 < length && it.hasNext()) {
            this.elementData[i5] = it.next();
            i5++;
        }
        int i6 = this.f41a;
        for (int i7 = 0; i7 < i6 && it.hasNext(); i7++) {
            this.elementData[i7] = it.next();
        }
        this.b = collection.size() + this.b;
    }

    public final void e(int i5) {
        if (i5 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (i5 <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            if (i5 < 10) {
                i5 = 10;
            }
            this.elementData = new Object[i5];
            return;
        }
        C0136d c0136d = AbstractC0139g.Companion;
        int length = objArr.length;
        c0136d.getClass();
        Object[] objArr2 = new Object[C0136d.e(length, i5)];
        Object[] objArr3 = this.elementData;
        AbstractC0151t.copyInto(objArr3, objArr2, 0, this.f41a, objArr3.length);
        Object[] objArr4 = this.elementData;
        int length2 = objArr4.length;
        int i6 = this.f41a;
        AbstractC0151t.copyInto(objArr4, objArr2, length2 - i6, 0, i6);
        this.f41a = 0;
        this.elementData = objArr2;
    }

    public final int f(int i5) {
        if (i5 == C.getLastIndex(this.elementData)) {
            return 0;
        }
        return i5 + 1;
    }

    public final Object firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[this.f41a];
    }

    public final int g(int i5) {
        return i5 < 0 ? i5 + this.elementData.length : i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.b(i5, i6);
        return this.elementData[i(this.f41a + i5)];
    }

    public final void h(int i5, int i6) {
        if (i5 < i6) {
            AbstractC0151t.fill(this.elementData, (Object) null, i5, i6);
            return;
        }
        Object[] objArr = this.elementData;
        AbstractC0151t.fill(objArr, (Object) null, i5, objArr.length);
        AbstractC0151t.fill(this.elementData, (Object) null, 0, i6);
    }

    public final int i(int i5) {
        Object[] objArr = this.elementData;
        return i5 >= objArr.length ? i5 - objArr.length : i5;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i5;
        int i6 = i(b() + this.f41a);
        int length = this.f41a;
        if (length < i6) {
            while (length < i6) {
                if (kotlin.jvm.internal.E.a(obj, this.elementData[length])) {
                    i5 = this.f41a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < i6) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (length < length2) {
            if (kotlin.jvm.internal.E.a(obj, this.elementData[length])) {
                i5 = this.f41a;
            } else {
                length++;
            }
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (kotlin.jvm.internal.E.a(obj, this.elementData[i7])) {
                length = i7 + this.elementData.length;
                i5 = this.f41a;
            }
        }
        return -1;
        return length - i5;
    }

    public final void internalStructure$kotlin_stdlib(O3.p structure) {
        int i5;
        kotlin.jvm.internal.E.f(structure, "structure");
        structure.invoke(Integer.valueOf((isEmpty() || (i5 = this.f41a) < i(b() + this.f41a)) ? this.f41a : i5 - this.elementData.length), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return b() == 0;
    }

    public final void j() {
        ((AbstractList) this).modCount++;
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.elementData[i(I.getLastIndex(this) + this.f41a)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int lastIndex;
        int i5;
        int i6 = i(b() + this.f41a);
        int i7 = this.f41a;
        if (i7 < i6) {
            lastIndex = i6 - 1;
            if (i7 <= lastIndex) {
                while (!kotlin.jvm.internal.E.a(obj, this.elementData[lastIndex])) {
                    if (lastIndex != i7) {
                        lastIndex--;
                    }
                }
                i5 = this.f41a;
                return lastIndex - i5;
            }
            return -1;
        }
        if (i7 > i6) {
            for (int i8 = i6 - 1; -1 < i8; i8--) {
                if (kotlin.jvm.internal.E.a(obj, this.elementData[i8])) {
                    lastIndex = i8 + this.elementData.length;
                    i5 = this.f41a;
                    return lastIndex - i5;
                }
            }
            lastIndex = C.getLastIndex(this.elementData);
            int i9 = this.f41a;
            if (i9 <= lastIndex) {
                while (!kotlin.jvm.internal.E.a(obj, this.elementData[lastIndex])) {
                    if (lastIndex != i9) {
                        lastIndex--;
                    }
                }
                i5 = this.f41a;
                return lastIndex - i5;
            }
        }
        return -1;
    }

    public final Object lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[i(I.getLastIndex(this) + this.f41a)];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        c(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        int i5;
        kotlin.jvm.internal.E.f(elements, "elements");
        boolean z6 = false;
        z6 = false;
        z6 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int i6 = i(b() + this.f41a);
            int i7 = this.f41a;
            if (i7 < i6) {
                i5 = i7;
                while (i7 < i6) {
                    Object obj = this.elementData[i7];
                    if (elements.contains(obj)) {
                        z6 = true;
                    } else {
                        this.elementData[i5] = obj;
                        i5++;
                    }
                    i7++;
                }
                AbstractC0151t.fill(this.elementData, (Object) null, i5, i6);
            } else {
                int length = this.elementData.length;
                boolean z7 = false;
                int i8 = i7;
                while (i7 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i7];
                    objArr[i7] = null;
                    if (elements.contains(obj2)) {
                        z7 = true;
                    } else {
                        this.elementData[i8] = obj2;
                        i8++;
                    }
                    i7++;
                }
                i5 = i(i8);
                for (int i9 = 0; i9 < i6; i9++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i9];
                    objArr2[i9] = null;
                    if (elements.contains(obj3)) {
                        z7 = true;
                    } else {
                        this.elementData[i5] = obj3;
                        i5 = f(i5);
                    }
                }
                z6 = z7;
            }
            if (z6) {
                j();
                this.b = g(i5 - this.f41a);
            }
        }
        return z6;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        j();
        Object[] objArr = this.elementData;
        int i5 = this.f41a;
        Object obj = objArr[i5];
        objArr[i5] = null;
        this.f41a = f(i5);
        this.b = b() - 1;
        return obj;
    }

    public final Object removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        j();
        int i5 = i(I.getLastIndex(this) + this.f41a);
        Object[] objArr = this.elementData;
        Object obj = objArr[i5];
        objArr[i5] = null;
        this.b = b() - 1;
        return obj;
    }

    public final Object removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i5, int i6) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i7 = this.b;
        c0136d.getClass();
        C0136d.d(i5, i6, i7);
        int i8 = i6 - i5;
        if (i8 == 0) {
            return;
        }
        if (i8 == this.b) {
            clear();
            return;
        }
        if (i8 == 1) {
            c(i5);
            return;
        }
        j();
        if (i5 < this.b - i6) {
            int i9 = i((i5 - 1) + this.f41a);
            int i10 = i((i6 - 1) + this.f41a);
            while (i5 > 0) {
                int i11 = i9 + 1;
                int iMin = Math.min(i5, Math.min(i11, i10 + 1));
                Object[] objArr = this.elementData;
                int i12 = i10 - iMin;
                int i13 = i9 - iMin;
                AbstractC0151t.copyInto(objArr, objArr, i12 + 1, i13 + 1, i11);
                i9 = g(i13);
                i10 = g(i12);
                i5 -= iMin;
            }
            int i14 = i(this.f41a + i8);
            h(this.f41a, i14);
            this.f41a = i14;
        } else {
            int i15 = i(this.f41a + i6);
            int i16 = i(this.f41a + i5);
            int i17 = this.b;
            while (true) {
                i17 -= i6;
                if (i17 <= 0) {
                    break;
                }
                Object[] objArr2 = this.elementData;
                i6 = Math.min(i17, Math.min(objArr2.length - i15, objArr2.length - i16));
                Object[] objArr3 = this.elementData;
                int i18 = i15 + i6;
                AbstractC0151t.copyInto(objArr3, objArr3, i16, i15, i18);
                i15 = i(i18);
                i16 = i(i16 + i6);
            }
            int i19 = i(this.b + this.f41a);
            h(g(i19 - i8), i19);
        }
        this.b -= i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        int i5;
        kotlin.jvm.internal.E.f(elements, "elements");
        boolean z6 = false;
        z6 = false;
        z6 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int i6 = i(b() + this.f41a);
            int i7 = this.f41a;
            if (i7 < i6) {
                i5 = i7;
                while (i7 < i6) {
                    Object obj = this.elementData[i7];
                    if (elements.contains(obj)) {
                        this.elementData[i5] = obj;
                        i5++;
                    } else {
                        z6 = true;
                    }
                    i7++;
                }
                AbstractC0151t.fill(this.elementData, (Object) null, i5, i6);
            } else {
                int length = this.elementData.length;
                boolean z7 = false;
                int i8 = i7;
                while (i7 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i7];
                    objArr[i7] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i8] = obj2;
                        i8++;
                    } else {
                        z7 = true;
                    }
                    i7++;
                }
                i5 = i(i8);
                for (int i9 = 0; i9 < i6; i9++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i9];
                    objArr2[i9] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[i5] = obj3;
                        i5 = f(i5);
                    } else {
                        z7 = true;
                    }
                }
                z6 = z7;
            }
            if (z6) {
                j();
                this.b = g(i5 - this.f41a);
            }
        }
        return z6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.b(i5, i6);
        int i7 = i(this.f41a + i5);
        Object[] objArr = this.elementData;
        Object obj2 = objArr[i7];
        objArr[i7] = obj;
        return obj2;
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        return (T[]) toArray(array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[b()]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.c(i5, i6);
        if (i5 == this.b) {
            addLast(obj);
            return;
        }
        if (i5 == 0) {
            addFirst(obj);
            return;
        }
        j();
        e(this.b + 1);
        int i7 = i(this.f41a + i5);
        int i8 = this.b;
        if (i5 < ((i8 + 1) >> 1)) {
            int lastIndex = i7 == 0 ? C.getLastIndex(this.elementData) : i7 - 1;
            int i9 = this.f41a;
            int lastIndex2 = i9 == 0 ? C.getLastIndex(this.elementData) : i9 - 1;
            int i10 = this.f41a;
            if (lastIndex >= i10) {
                Object[] objArr = this.elementData;
                objArr[lastIndex2] = objArr[i10];
                AbstractC0151t.copyInto(objArr, objArr, i10, i10 + 1, lastIndex + 1);
            } else {
                Object[] objArr2 = this.elementData;
                AbstractC0151t.copyInto(objArr2, objArr2, i10 - 1, i10, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC0151t.copyInto(objArr3, objArr3, 0, 1, lastIndex + 1);
            }
            this.elementData[lastIndex] = obj;
            this.f41a = lastIndex2;
        } else {
            int i11 = i(i8 + this.f41a);
            if (i7 < i11) {
                Object[] objArr4 = this.elementData;
                AbstractC0151t.copyInto(objArr4, objArr4, i7 + 1, i7, i11);
            } else {
                Object[] objArr5 = this.elementData;
                AbstractC0151t.copyInto(objArr5, objArr5, 1, 0, i11);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                AbstractC0151t.copyInto(objArr6, objArr6, i7 + 1, i7, objArr6.length - 1);
            }
            this.elementData[i7] = obj;
        }
        this.b++;
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    public C0144l(Collection<Object> elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        this.elementData = array;
        this.b = array.length;
        if (array.length == 0) {
            this.elementData = emptyElementData;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        int length = array.length;
        int i5 = this.b;
        if (length < i5) {
            array = (T[]) AbstractC0145m.arrayOfNulls(array, i5);
        }
        T[] tArr = array;
        int i6 = i(this.b + this.f41a);
        int i7 = this.f41a;
        if (i7 < i6) {
            AbstractC0151t.c(this.elementData, tArr, 0, i7, i6, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            AbstractC0151t.copyInto(objArr, tArr, 0, this.f41a, objArr.length);
            Object[] objArr2 = this.elementData;
            AbstractC0151t.copyInto(objArr2, tArr, objArr2.length - this.f41a, 0, i6);
        }
        return (T[]) G.terminateCollectionToArray(this.b, tArr);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<Object> elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.c(i5, i6);
        if (elements.isEmpty()) {
            return false;
        }
        if (i5 == this.b) {
            return addAll(elements);
        }
        j();
        e(elements.size() + this.b);
        int i7 = i(this.b + this.f41a);
        int i8 = i(this.f41a + i5);
        int size = elements.size();
        if (i5 < ((this.b + 1) >> 1)) {
            int i9 = this.f41a;
            int length = i9 - size;
            if (i8 < i9) {
                Object[] objArr = this.elementData;
                AbstractC0151t.copyInto(objArr, objArr, length, i9, objArr.length);
                if (size >= i8) {
                    Object[] objArr2 = this.elementData;
                    AbstractC0151t.copyInto(objArr2, objArr2, objArr2.length - size, 0, i8);
                } else {
                    Object[] objArr3 = this.elementData;
                    AbstractC0151t.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    AbstractC0151t.copyInto(objArr4, objArr4, 0, size, i8);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.elementData;
                AbstractC0151t.copyInto(objArr5, objArr5, length, i9, i8);
            } else {
                Object[] objArr6 = this.elementData;
                length += objArr6.length;
                int i10 = i8 - i9;
                int length2 = objArr6.length - length;
                if (length2 >= i10) {
                    AbstractC0151t.copyInto(objArr6, objArr6, length, i9, i8);
                } else {
                    AbstractC0151t.copyInto(objArr6, objArr6, length, i9, i9 + length2);
                    Object[] objArr7 = this.elementData;
                    AbstractC0151t.copyInto(objArr7, objArr7, 0, this.f41a + length2, i8);
                }
            }
            this.f41a = length;
            d(g(i8 - size), elements);
            return true;
        }
        int i11 = i8 + size;
        if (i8 < i7) {
            int i12 = size + i7;
            Object[] objArr8 = this.elementData;
            if (i12 <= objArr8.length) {
                AbstractC0151t.copyInto(objArr8, objArr8, i11, i8, i7);
            } else if (i11 >= objArr8.length) {
                AbstractC0151t.copyInto(objArr8, objArr8, i11 - objArr8.length, i8, i7);
            } else {
                int length3 = i7 - (i12 - objArr8.length);
                AbstractC0151t.copyInto(objArr8, objArr8, 0, length3, i7);
                Object[] objArr9 = this.elementData;
                AbstractC0151t.copyInto(objArr9, objArr9, i11, i8, length3);
            }
        } else {
            Object[] objArr10 = this.elementData;
            AbstractC0151t.copyInto(objArr10, objArr10, size, 0, i7);
            Object[] objArr11 = this.elementData;
            if (i11 >= objArr11.length) {
                AbstractC0151t.copyInto(objArr11, objArr11, i11 - objArr11.length, i8, objArr11.length);
            } else {
                AbstractC0151t.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                Object[] objArr12 = this.elementData;
                AbstractC0151t.copyInto(objArr12, objArr12, i11, i8, objArr12.length - size);
            }
        }
        d(i8, elements);
        return true;
    }
}
