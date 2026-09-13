package androidx.collection;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public void append(int i5, E e) {
        int i6 = this.size;
        if (i6 != 0 && i5 <= this.keys[i6 - 1]) {
            put(i5, e);
            return;
        }
        if (this.garbage && i6 >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
        }
        int i7 = this.size;
        if (i7 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            this.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        this.keys[i7] = i5;
        this.values[i7] = e;
        this.size = i7 + 1;
    }

    public void clear() {
        int i5 = this.size;
        Object[] objArr = this.values;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    public boolean containsKey(int i5) {
        return indexOfKey(i5) >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x001c A[RETURN] */
    public boolean containsValue(E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i5 = this.size;
        int i6 = 0;
        while (i6 < i5) {
            if (this.values[i6] == e) {
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

    public void delete(int i5) {
        remove(i5);
    }

    public E get(int i5) {
        return (E) SparseArrayCompatKt.commonGet(this, i5);
    }

    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public int indexOfKey(int i5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
    }

    public int indexOfValue(E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.values[i6] == e) {
                return i6;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int i5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[i5];
    }

    public void put(int i5, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = e;
            return;
        }
        int i6 = ~iBinarySearch;
        if (i6 < this.size && this.values[i6] == SparseArrayCompatKt.DELETED) {
            this.keys[i6] = i5;
            this.values[i6] = e;
            return;
        }
        if (this.garbage && this.size >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
            i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
        }
        int i7 = this.size;
        if (i7 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            this.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        int i8 = this.size;
        if (i8 - i6 != 0) {
            int[] iArr = this.keys;
            int i9 = i6 + 1;
            AbstractC0151t.copyInto(iArr, iArr, i9, i6, i8);
            Object[] objArr = this.values;
            AbstractC0151t.copyInto(objArr, objArr, i9, i6, this.size);
        }
        this.keys[i6] = i5;
        this.values[i6] = e;
        this.size++;
    }

    public void putAll(SparseArrayCompat<? extends E> other) {
        E.f(other, "other");
        int size = other.size();
        for (int i5 = 0; i5 < size; i5++) {
            int iKeyAt = other.keyAt(i5);
            E eValueAt = other.valueAt(i5);
            int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, iKeyAt);
            if (iBinarySearch >= 0) {
                this.values[iBinarySearch] = eValueAt;
            } else {
                int i6 = ~iBinarySearch;
                if (i6 >= this.size || this.values[i6] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.gc(this);
                        i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, iKeyAt);
                    }
                    int i7 = this.size;
                    if (i7 >= this.keys.length) {
                        int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                        int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
                        E.e(iArrCopyOf, "copyOf(this, newSize)");
                        this.keys = iArrCopyOf;
                        Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
                        E.e(objArrCopyOf, "copyOf(this, newSize)");
                        this.values = objArrCopyOf;
                    }
                    int i8 = this.size;
                    if (i8 - i6 != 0) {
                        int[] iArr = this.keys;
                        int i9 = i6 + 1;
                        AbstractC0151t.copyInto(iArr, iArr, i9, i6, i8);
                        Object[] objArr = this.values;
                        AbstractC0151t.copyInto(objArr, objArr, i9, i6, this.size);
                    }
                    this.keys[i6] = iKeyAt;
                    this.values[i6] = eValueAt;
                    this.size++;
                } else {
                    this.keys[i6] = iKeyAt;
                    this.values[i6] = eValueAt;
                }
            }
        }
    }

    public E putIfAbsent(int i5, E e) {
        E e6 = (E) SparseArrayCompatKt.commonGet(this, i5);
        if (e6 == null) {
            int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
            if (iBinarySearch >= 0) {
                this.values[iBinarySearch] = e;
                return e6;
            }
            int i6 = ~iBinarySearch;
            if (i6 < this.size && this.values[i6] == SparseArrayCompatKt.DELETED) {
                this.keys[i6] = i5;
                this.values[i6] = e;
                return e6;
            }
            if (this.garbage && this.size >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
                i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i5);
            }
            int i7 = this.size;
            if (i7 >= this.keys.length) {
                int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i7 + 1);
                int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
                E.e(iArrCopyOf, "copyOf(this, newSize)");
                this.keys = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
                E.e(objArrCopyOf, "copyOf(this, newSize)");
                this.values = objArrCopyOf;
            }
            int i8 = this.size;
            if (i8 - i6 != 0) {
                int[] iArr = this.keys;
                int i9 = i6 + 1;
                AbstractC0151t.copyInto(iArr, iArr, i9, i6, i8);
                Object[] objArr = this.values;
                AbstractC0151t.copyInto(objArr, objArr, i9, i6, this.size);
            }
            this.keys[i6] = i5;
            this.values[i6] = e;
            this.size++;
        }
        return e6;
    }

    public void remove(int i5) {
        SparseArrayCompatKt.commonRemove(this, i5);
    }

    public void removeAt(int i5) {
        if (this.values[i5] != SparseArrayCompatKt.DELETED) {
            this.values[i5] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAtRange(int i5, int i6) {
        int iMin = Math.min(i6, i5 + i6);
        while (i5 < iMin) {
            removeAt(i5);
            i5++;
        }
    }

    public E replace(int i5, E e) {
        int iIndexOfKey = indexOfKey(i5);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e6 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e6;
    }

    public void setValueAt(int i5, E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        this.values[i5] = e;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.size;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i6));
            sb.append(Chars.EQ);
            E eValueAt = valueAt(i6);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC0157z.j('}', "buffer.toString()", sb);
    }

    public E valueAt(int i5) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return (E) this.values[i5];
    }

    public SparseArrayCompat(int i5) {
        if (i5 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i5);
            this.keys = new int[iIdealIntArraySize];
            this.values = new Object[iIdealIntArraySize];
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m965clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        E.d(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) objClone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public E get(int i5, E e) {
        return (E) SparseArrayCompatKt.commonGet(this, i5, e);
    }

    public boolean remove(int i5, Object obj) {
        int iIndexOfKey = indexOfKey(i5);
        if (iIndexOfKey < 0 || !E.a(obj, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(int i5, E e, E e6) {
        int iIndexOfKey = indexOfKey(i5);
        if (iIndexOfKey < 0 || !E.a(this.values[iIndexOfKey], e)) {
            return false;
        }
        this.values[iIndexOfKey] = e6;
        return true;
    }

    public /* synthetic */ SparseArrayCompat(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
