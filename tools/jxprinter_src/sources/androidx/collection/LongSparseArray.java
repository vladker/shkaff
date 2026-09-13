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
public class LongSparseArray<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray() {
        this(0, 1, null);
    }

    public void append(long j6, E e) {
        int i5 = this.size;
        if (i5 != 0 && j6 <= this.keys[i5 - 1]) {
            put(j6, e);
            return;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            if (i5 >= jArr.length) {
                Object[] objArr = this.values;
                int i6 = 0;
                for (int i7 = 0; i7 < i5; i7++) {
                    Object obj = objArr[i7];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i7 != i6) {
                            jArr[i6] = jArr[i7];
                            objArr[i6] = obj;
                            objArr[i7] = null;
                        }
                        i6++;
                    }
                }
                this.garbage = false;
                this.size = i6;
            }
        }
        int i8 = this.size;
        if (i8 >= this.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i8 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.keys, iIdealLongArraySize);
            E.e(jArrCopyOf, "copyOf(this, newSize)");
            this.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealLongArraySize);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        this.keys[i8] = j6;
        this.values[i8] = e;
        this.size = i8 + 1;
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

    public boolean containsKey(long j6) {
        return indexOfKey(j6) >= 0;
    }

    public boolean containsValue(E e) {
        return indexOfValue(e) >= 0;
    }

    public void delete(long j6) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[iBinarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public E get(long j6) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return null;
        }
        return (E) this.values[iBinarySearch];
    }

    public int indexOfKey(long j6) {
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
    }

    public int indexOfValue(E e) {
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        int i8 = this.size;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.values[i9] == e) {
                return i9;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.size)) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        return this.keys[i5];
    }

    public void put(long j6, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = e;
            return;
        }
        int i5 = ~iBinarySearch;
        if (i5 < this.size && this.values[i5] == LongSparseArrayKt.DELETED) {
            this.keys[i5] = j6;
            this.values[i5] = e;
            return;
        }
        if (this.garbage) {
            int i6 = this.size;
            long[] jArr = this.keys;
            if (i6 >= jArr.length) {
                Object[] objArr = this.values;
                int i7 = 0;
                for (int i8 = 0; i8 < i6; i8++) {
                    Object obj = objArr[i8];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i8 != i7) {
                            jArr[i7] = jArr[i8];
                            objArr[i7] = obj;
                            objArr[i8] = null;
                        }
                        i7++;
                    }
                }
                this.garbage = false;
                this.size = i7;
                i5 = ~ContainerHelpersKt.binarySearch(this.keys, i7, j6);
            }
        }
        int i9 = this.size;
        if (i9 >= this.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i9 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.keys, iIdealLongArraySize);
            E.e(jArrCopyOf, "copyOf(this, newSize)");
            this.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealLongArraySize);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        int i10 = this.size;
        if (i10 - i5 != 0) {
            long[] jArr2 = this.keys;
            int i11 = i5 + 1;
            AbstractC0151t.copyInto(jArr2, jArr2, i11, i5, i10);
            Object[] objArr2 = this.values;
            AbstractC0151t.copyInto(objArr2, objArr2, i11, i5, this.size);
        }
        this.keys[i5] = j6;
        this.values[i5] = e;
        this.size++;
    }

    public void putAll(LongSparseArray<? extends E> other) {
        E.f(other, "other");
        int size = other.size();
        for (int i5 = 0; i5 < size; i5++) {
            put(other.keyAt(i5), other.valueAt(i5));
        }
    }

    public E putIfAbsent(long j6, E e) {
        E e6 = get(j6);
        if (e6 == null) {
            put(j6, e);
        }
        return e6;
    }

    public void remove(long j6) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        if (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[iBinarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public void removeAt(int i5) {
        if (this.values[i5] != LongSparseArrayKt.DELETED) {
            this.values[i5] = LongSparseArrayKt.DELETED;
            this.garbage = true;
        }
    }

    public E replace(long j6, E e) {
        int iIndexOfKey = indexOfKey(j6);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e6 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e6;
    }

    public void setValueAt(int i5, E e) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.size)) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        this.values[i5] = e;
    }

    public int size() {
        if (this.garbage) {
            int i5 = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
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
            if (eValueAt != sb) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC0157z.j('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public E valueAt(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.size)) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            this.garbage = false;
            this.size = i7;
        }
        return (E) this.values[i5];
    }

    public LongSparseArray(int i5) {
        if (i5 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i5);
            this.keys = new long[iIdealLongArraySize];
            this.values = new Object[iIdealLongArraySize];
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m964clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        E.d(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray<E> longSparseArray = (LongSparseArray) objClone;
        longSparseArray.keys = (long[]) this.keys.clone();
        longSparseArray.values = (Object[]) this.values.clone();
        return longSparseArray;
    }

    public E get(long j6, E e) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j6);
        return (iBinarySearch < 0 || this.values[iBinarySearch] == LongSparseArrayKt.DELETED) ? e : (E) this.values[iBinarySearch];
    }

    public boolean replace(long j6, E e, E e6) {
        int iIndexOfKey = indexOfKey(j6);
        if (iIndexOfKey < 0 || !E.a(this.values[iIndexOfKey], e)) {
            return false;
        }
        this.values[iIndexOfKey] = e6;
        return true;
    }

    public boolean remove(long j6, E e) {
        int iIndexOfKey = indexOfKey(j6);
        if (iIndexOfKey < 0 || !E.a(e, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public /* synthetic */ LongSparseArray(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
