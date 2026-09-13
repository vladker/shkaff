package androidx.collection;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.T;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> array) {
        E.f(arraySet, "<this>");
        E.f(array, "array");
        int i5 = array.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i5);
        if (arraySet.get_size$collection() != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                arraySet.add(array.valueAt(i6));
            }
        } else if (i5 > 0) {
            AbstractC0151t.b(array.getHashes$collection(), arraySet.getHashes$collection(), 0, i5, 6);
            AbstractC0151t.c(array.getArray$collection(), arraySet.getArray$collection(), 0, 0, i5, 6);
            if (arraySet.get_size$collection() != 0) {
                throw new ConcurrentModificationException();
            }
            arraySet.set_size$collection(i5);
        }
    }

    public static final <E> boolean addInternal(ArraySet<E> arraySet, E e) {
        int i5;
        int iIndexOf;
        E.f(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (e == null) {
            iIndexOf = indexOfNull(arraySet);
            i5 = 0;
        } else {
            int iHashCode = e.hashCode();
            i5 = iHashCode;
            iIndexOf = indexOf(arraySet, e, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i7 = ~iIndexOf;
        if (i6 >= arraySet.getHashes$collection().length) {
            int i8 = 8;
            if (i6 >= 8) {
                i8 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i8 = 4;
            }
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i8);
            if (i6 != arraySet.get_size$collection()) {
                throw new ConcurrentModificationException();
            }
            if (arraySet.getHashes$collection().length != 0) {
                AbstractC0151t.b(hashes$collection, arraySet.getHashes$collection(), 0, hashes$collection.length, 6);
                AbstractC0151t.c(array$collection, arraySet.getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i7 < i6) {
            int i9 = i7 + 1;
            AbstractC0151t.copyInto(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i9, i7, i6);
            AbstractC0151t.copyInto(arraySet.getArray$collection(), arraySet.getArray$collection(), i9, i7, i6);
        }
        if (i6 != arraySet.get_size$collection() || i7 >= arraySet.getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        arraySet.getHashes$collection()[i7] = i5;
        arraySet.getArray$collection()[i7] = e;
        arraySet.set_size$collection(arraySet.get_size$collection() + 1);
        return true;
    }

    public static final <E> void allocArrays(ArraySet<E> arraySet, int i5) {
        E.f(arraySet, "<this>");
        arraySet.setHashes$collection(new int[i5]);
        arraySet.setArray$collection(new Object[i5]);
    }

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, null);
    }

    public static final <E> int binarySearchInternal(ArraySet<E> arraySet, int i5) {
        E.f(arraySet, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes$collection(), arraySet.get_size$collection(), i5);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> void clearInternal(ArraySet<E> arraySet) {
        E.f(arraySet, "<this>");
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        E.f(arraySet, "<this>");
        E.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!arraySet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean containsInternal(ArraySet<E> arraySet, E e) {
        E.f(arraySet, "<this>");
        return arraySet.indexOf(e) >= 0;
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> arraySet, int i5) {
        E.f(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (arraySet.getHashes$collection().length < i5) {
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i5);
            if (arraySet.get_size$collection() > 0) {
                AbstractC0151t.b(hashes$collection, arraySet.getHashes$collection(), 0, arraySet.get_size$collection(), 6);
                AbstractC0151t.c(array$collection, arraySet.getArray$collection(), 0, 0, arraySet.get_size$collection(), 6);
            }
        }
        if (arraySet.get_size$collection() != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean equalsInternal(ArraySet<E> arraySet, Object obj) {
        E.f(arraySet, "<this>");
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i5 = arraySet.get_size$collection();
            for (int i6 = 0; i6 < i5; i6++) {
                if (!((Set) obj).contains(arraySet.valueAt(i6))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(ArraySet<E> arraySet) {
        E.f(arraySet, "<this>");
        int[] hashes$collection = arraySet.getHashes$collection();
        int i5 = arraySet.get_size$collection();
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += hashes$collection[i7];
        }
        return i6;
    }

    public static final <E> int indexOf(ArraySet<E> arraySet, Object obj, int i5) {
        E.f(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (i6 == 0) {
            return -1;
        }
        int iBinarySearchInternal = binarySearchInternal(arraySet, i5);
        if (iBinarySearchInternal < 0 || E.a(obj, arraySet.getArray$collection()[iBinarySearchInternal])) {
            return iBinarySearchInternal;
        }
        int i7 = iBinarySearchInternal + 1;
        while (i7 < i6 && arraySet.getHashes$collection()[i7] == i5) {
            if (E.a(obj, arraySet.getArray$collection()[i7])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = iBinarySearchInternal - 1; i8 >= 0 && arraySet.getHashes$collection()[i8] == i5; i8--) {
            if (E.a(obj, arraySet.getArray$collection()[i8])) {
                return i8;
            }
        }
        return ~i7;
    }

    public static final <E> int indexOfInternal(ArraySet<E> arraySet, Object obj) {
        E.f(arraySet, "<this>");
        return obj == null ? indexOfNull(arraySet) : indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> int indexOfNull(ArraySet<E> arraySet) {
        E.f(arraySet, "<this>");
        return indexOf(arraySet, null, 0);
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> arraySet) {
        E.f(arraySet, "<this>");
        return arraySet.get_size$collection() <= 0;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> array) {
        E.f(arraySet, "<this>");
        E.f(array, "array");
        int i5 = array.get_size$collection();
        int i6 = arraySet.get_size$collection();
        for (int i7 = 0; i7 < i5; i7++) {
            arraySet.remove(array.valueAt(i7));
        }
        return i6 != arraySet.get_size$collection();
    }

    public static final <E> E removeAtInternal(ArraySet<E> arraySet, int i5) {
        int i6;
        E.f(arraySet, "<this>");
        int i7 = arraySet.get_size$collection();
        E e = (E) arraySet.getArray$collection()[i5];
        if (i7 <= 1) {
            arraySet.clear();
            return e;
        }
        int i8 = i7 - 1;
        if (arraySet.getHashes$collection().length <= 8 || arraySet.get_size$collection() >= arraySet.getHashes$collection().length / 3) {
            if (i5 < i8) {
                int i9 = i5 + 1;
                AbstractC0151t.copyInto(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i5, i9, i7);
                AbstractC0151t.copyInto(arraySet.getArray$collection(), arraySet.getArray$collection(), i5, i9, i7);
            }
            arraySet.getArray$collection()[i8] = null;
        } else {
            int i10 = arraySet.get_size$collection() > 8 ? arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1) : 8;
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i10);
            if (i5 > 0) {
                AbstractC0151t.b(hashes$collection, arraySet.getHashes$collection(), 0, i5, 6);
                i6 = i5;
                AbstractC0151t.c(array$collection, arraySet.getArray$collection(), 0, 0, i6, 6);
            } else {
                i6 = i5;
            }
            if (i6 < i8) {
                int i11 = i6 + 1;
                AbstractC0151t.copyInto(hashes$collection, arraySet.getHashes$collection(), i6, i11, i7);
                AbstractC0151t.copyInto(array$collection, arraySet.getArray$collection(), i6, i11, i7);
            }
        }
        if (i7 != arraySet.get_size$collection()) {
            throw new ConcurrentModificationException();
        }
        arraySet.set_size$collection(i8);
        return e;
    }

    public static final <E> boolean removeInternal(ArraySet<E> arraySet, E e) {
        E.f(arraySet, "<this>");
        int iIndexOf = arraySet.indexOf(e);
        if (iIndexOf < 0) {
            return false;
        }
        arraySet.removeAt(iIndexOf);
        return true;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        E.f(arraySet, "<this>");
        E.f(elements, "elements");
        boolean z6 = false;
        for (int i5 = arraySet.get_size$collection() - 1; -1 < i5; i5--) {
            if (!T.contains(elements, arraySet.getArray$collection()[i5])) {
                arraySet.removeAt(i5);
                z6 = true;
            }
        }
        return z6;
    }

    public static final <E> String toStringInternal(ArraySet<E> arraySet) {
        E.f(arraySet, "<this>");
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i5 = arraySet.get_size$collection();
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E eValueAt = arraySet.valueAt(i6);
            if (eValueAt != arraySet) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        return AbstractC0157z.j('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public static final <E> E valueAtInternal(ArraySet<E> arraySet, int i5) {
        E.f(arraySet, "<this>");
        return (E) arraySet.getArray$collection()[i5];
    }

    public static final <T> ArraySet<T> arraySetOf(T... values) {
        E.f(values, "values");
        ArraySet<T> arraySet = new ArraySet<>(values.length);
        for (T t6 : values) {
            arraySet.add(t6);
        }
        return arraySet;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        E.f(arraySet, "<this>");
        E.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= arraySet.remove(it.next());
        }
        return zRemove;
    }

    public static final <E> boolean addAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        E.f(arraySet, "<this>");
        E.f(elements, "elements");
        arraySet.ensureCapacity(elements.size() + arraySet.get_size$collection());
        Iterator<? extends E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= arraySet.add(it.next());
        }
        return zAdd;
    }
}
