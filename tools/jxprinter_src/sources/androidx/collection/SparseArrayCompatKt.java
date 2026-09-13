package androidx.collection;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayCompatKt {
    private static final Object DELETED = new Object();

    public static final <E> void commonAppend(SparseArrayCompat<E> sparseArrayCompat, int i5, E e) {
        E.f(sparseArrayCompat, "<this>");
        int i6 = sparseArrayCompat.size;
        if (i6 != 0 && i5 <= sparseArrayCompat.keys[i6 - 1]) {
            sparseArrayCompat.put(i5, e);
            return;
        }
        if (sparseArrayCompat.garbage && i6 >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
        }
        int i7 = sparseArrayCompat.size;
        if (i7 >= sparseArrayCompat.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
            int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            sparseArrayCompat.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            sparseArrayCompat.values = objArrCopyOf;
        }
        sparseArrayCompat.keys[i7] = i5;
        sparseArrayCompat.values[i7] = e;
        sparseArrayCompat.size = i7 + 1;
    }

    public static final <E> void commonClear(SparseArrayCompat<E> sparseArrayCompat) {
        E.f(sparseArrayCompat, "<this>");
        int i5 = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E.f(sparseArrayCompat, "<this>");
        return sparseArrayCompat.indexOfKey(i5) >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0021 A[RETURN] */
    public static final <E> boolean commonContainsValue(SparseArrayCompat<E> sparseArrayCompat, E e) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i5 = sparseArrayCompat.size;
        int i6 = 0;
        while (i6 < i5) {
            if (sparseArrayCompat.values[i6] == e) {
                if (i6 >= 0) {
                    return true;
                }
                return false;
            }
            i6++;
        }
        i6 = -1;
        if (i6 >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E e;
        E.f(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        if (iBinarySearch < 0 || (e = (E) sparseArrayCompat.values[iBinarySearch]) == DELETED) {
            return null;
        }
        return e;
    }

    public static final <E> int commonIndexOfKey(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
    }

    public static final <E> int commonIndexOfValue(SparseArrayCompat<E> sparseArrayCompat, E e) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i5 = sparseArrayCompat.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (sparseArrayCompat.values[i6] == e) {
                return i6;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(SparseArrayCompat<E> sparseArrayCompat) {
        E.f(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size() == 0;
    }

    public static final <E> int commonKeyAt(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i5];
    }

    public static final <E> void commonPut(SparseArrayCompat<E> sparseArrayCompat, int i5, E e) {
        E.f(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        if (iBinarySearch >= 0) {
            sparseArrayCompat.values[iBinarySearch] = e;
            return;
        }
        int i6 = ~iBinarySearch;
        if (i6 < sparseArrayCompat.size && sparseArrayCompat.values[i6] == DELETED) {
            sparseArrayCompat.keys[i6] = i5;
            sparseArrayCompat.values[i6] = e;
            return;
        }
        if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
            i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        }
        int i7 = sparseArrayCompat.size;
        if (i7 >= sparseArrayCompat.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
            int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            sparseArrayCompat.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            sparseArrayCompat.values = objArrCopyOf;
        }
        int i8 = sparseArrayCompat.size;
        if (i8 - i6 != 0) {
            int[] iArr = sparseArrayCompat.keys;
            int i9 = i6 + 1;
            AbstractC0151t.copyInto(iArr, iArr, i9, i6, i8);
            Object[] objArr = sparseArrayCompat.values;
            AbstractC0151t.copyInto(objArr, objArr, i9, i6, sparseArrayCompat.size);
        }
        sparseArrayCompat.keys[i6] = i5;
        sparseArrayCompat.values[i6] = e;
        sparseArrayCompat.size++;
    }

    public static final <E> void commonPutAll(SparseArrayCompat<E> sparseArrayCompat, SparseArrayCompat<? extends E> other) {
        E.f(sparseArrayCompat, "<this>");
        E.f(other, "other");
        int size = other.size();
        for (int i5 = 0; i5 < size; i5++) {
            int iKeyAt = other.keyAt(i5);
            E eValueAt = other.valueAt(i5);
            int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, iKeyAt);
            if (iBinarySearch >= 0) {
                sparseArrayCompat.values[iBinarySearch] = eValueAt;
            } else {
                int i6 = ~iBinarySearch;
                if (i6 >= sparseArrayCompat.size || sparseArrayCompat.values[i6] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, iKeyAt);
                    }
                    int i7 = sparseArrayCompat.size;
                    if (i7 >= sparseArrayCompat.keys.length) {
                        int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                        int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
                        E.e(iArrCopyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.keys = iArrCopyOf;
                        Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
                        E.e(objArrCopyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.values = objArrCopyOf;
                    }
                    int i8 = sparseArrayCompat.size;
                    if (i8 - i6 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i9 = i6 + 1;
                        AbstractC0151t.copyInto(iArr, iArr, i9, i6, i8);
                        Object[] objArr = sparseArrayCompat.values;
                        AbstractC0151t.copyInto(objArr, objArr, i9, i6, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i6] = iKeyAt;
                    sparseArrayCompat.values[i6] = eValueAt;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i6] = iKeyAt;
                    sparseArrayCompat.values[i6] = eValueAt;
                }
            }
        }
    }

    public static final <E> E commonPutIfAbsent(SparseArrayCompat<E> sparseArrayCompat, int i5, E e) {
        E.f(sparseArrayCompat, "<this>");
        E e6 = (E) commonGet(sparseArrayCompat, i5);
        if (e6 == null) {
            int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
            if (iBinarySearch >= 0) {
                sparseArrayCompat.values[iBinarySearch] = e;
                return e6;
            }
            int i6 = ~iBinarySearch;
            if (i6 < sparseArrayCompat.size && sparseArrayCompat.values[i6] == DELETED) {
                sparseArrayCompat.keys[i6] = i5;
                sparseArrayCompat.values[i6] = e;
                return e6;
            }
            if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
                i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
            }
            int i7 = sparseArrayCompat.size;
            if (i7 >= sparseArrayCompat.keys.length) {
                int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                int[] iArrCopyOf = Arrays.copyOf(sparseArrayCompat.keys, iIdealIntArraySize);
                E.e(iArrCopyOf, "copyOf(this, newSize)");
                sparseArrayCompat.keys = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(sparseArrayCompat.values, iIdealIntArraySize);
                E.e(objArrCopyOf, "copyOf(this, newSize)");
                sparseArrayCompat.values = objArrCopyOf;
            }
            int i8 = sparseArrayCompat.size;
            if (i8 - i6 != 0) {
                int[] iArr = sparseArrayCompat.keys;
                int i9 = i6 + 1;
                AbstractC0151t.copyInto(iArr, iArr, i9, i6, i8);
                Object[] objArr = sparseArrayCompat.values;
                AbstractC0151t.copyInto(objArr, objArr, i9, i6, sparseArrayCompat.size);
            }
            sparseArrayCompat.keys[i6] = i5;
            sparseArrayCompat.values[i6] = e;
            sparseArrayCompat.size++;
        }
        return e6;
    }

    public static final <E> void commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E.f(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        if (iBinarySearch >= 0) {
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[iBinarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[iBinarySearch] = obj2;
                sparseArrayCompat.garbage = true;
            }
        }
    }

    public static final <E> void commonRemoveAt(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.values[i5] != DELETED) {
            sparseArrayCompat.values[i5] = DELETED;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(SparseArrayCompat<E> sparseArrayCompat, int i5, int i6) {
        E.f(sparseArrayCompat, "<this>");
        int iMin = Math.min(i6, i5 + i6);
        while (i5 < iMin) {
            sparseArrayCompat.removeAt(i5);
            i5++;
        }
    }

    public static final <E> E commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i5, E e) {
        E.f(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i5);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = sparseArrayCompat.values;
        E e6 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e6;
    }

    public static final <E> void commonSetValueAt(SparseArrayCompat<E> sparseArrayCompat, int i5, E e) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i5] = e;
    }

    public static final <E> int commonSize(SparseArrayCompat<E> sparseArrayCompat) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    public static final <E> String commonToString(SparseArrayCompat<E> sparseArrayCompat) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i5 = sparseArrayCompat.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i6));
            sb.append(Chars.EQ);
            E eValueAt = sparseArrayCompat.valueAt(i6);
            if (eValueAt != sparseArrayCompat) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC0157z.j('}', "buffer.toString()", sb);
    }

    public static final <E> E commonValueAt(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E.f(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return (E) sparseArrayCompat.values[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i5 = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != DELETED) {
                if (i7 != i6) {
                    iArr[i6] = iArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i6;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> sparseArrayCompat, int i5, T t6) {
        T t7;
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        return (iBinarySearch < 0 || (t7 = (T) sparseArrayCompat.values[iBinarySearch]) == DELETED) ? t6 : t7;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i5, E e) {
        E e6;
        E.f(sparseArrayCompat, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        return (iBinarySearch < 0 || (e6 = (E) sparseArrayCompat.values[iBinarySearch]) == DELETED) ? e : e6;
    }

    public static final <E> boolean commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i5, E e, E e6) {
        E.f(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i5);
        if (iIndexOfKey < 0 || !E.a(sparseArrayCompat.values[iIndexOfKey], e)) {
            return false;
        }
        sparseArrayCompat.values[iIndexOfKey] = e6;
        return true;
    }

    public static final <E> boolean commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i5, Object obj) {
        E.f(sparseArrayCompat, "<this>");
        int iIndexOfKey = sparseArrayCompat.indexOfKey(i5);
        if (iIndexOfKey < 0 || !E.a(obj, sparseArrayCompat.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(iIndexOfKey);
        return true;
    }
}
