package androidx.collection;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object obj, T t6) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (T) this.array[(iIndexOfKey << 1) + 1] : t6;
    }

    private final int indexOf(K k6, int i5) {
        int i6 = this.size;
        if (i6 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.hashes, i6, i5);
        if (iBinarySearch < 0 || E.a(k6, this.array[iBinarySearch << 1])) {
            return iBinarySearch;
        }
        int i7 = iBinarySearch + 1;
        while (i7 < i6 && this.hashes[i7] == i5) {
            if (E.a(k6, this.array[i7 << 1])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = iBinarySearch - 1; i8 >= 0 && this.hashes[i8] == i5; i8--) {
            if (E.a(k6, this.array[i8 << 1])) {
                return i8;
            }
        }
        return ~i7;
    }

    private final int indexOfNull() {
        int i5 = this.size;
        if (i5 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.hashes, i5, 0);
        if (iBinarySearch < 0 || this.array[iBinarySearch << 1] == null) {
            return iBinarySearch;
        }
        int i6 = iBinarySearch + 1;
        while (i6 < i5 && this.hashes[i6] == 0) {
            if (this.array[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        for (int i7 = iBinarySearch - 1; i7 >= 0 && this.hashes[i7] == 0; i7--) {
            if (this.array[i7 << 1] == null) {
                return i7;
            }
        }
        return ~i6;
    }

    public final int __restricted$indexOfValue(V v6) {
        int i5 = this.size * 2;
        Object[] objArr = this.array;
        if (v6 == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (v6.equals(objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k6) {
        return indexOfKey(k6) >= 0;
    }

    public boolean containsValue(V v6) {
        return __restricted$indexOfValue(v6) >= 0;
    }

    public void ensureCapacity(int i5) {
        int i6 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i5) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i5 * 2);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
        }
        if (this.size != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i5 = this.size;
                for (int i6 = 0; i6 < i5; i6++) {
                    K kKeyAt = keyAt(i6);
                    V vValueAt = valueAt(i6);
                    Object obj2 = simpleArrayMap.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!vValueAt.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i7 = this.size;
            for (int i8 = 0; i8 < i7; i8++) {
                K kKeyAt2 = keyAt(i8);
                V vValueAt2 = valueAt(i8);
                Object obj3 = ((Map) obj).get(kKeyAt2);
                if (vValueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(kKeyAt2)) {
                        return false;
                    }
                } else if (!vValueAt2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public V get(K k6) {
        int iIndexOfKey = indexOfKey(k6);
        if (iIndexOfKey >= 0) {
            return (V) this.array[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object obj, V v6) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (V) this.array[(iIndexOfKey << 1) + 1] : v6;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i5 = this.size;
        int i6 = 1;
        int i7 = 0;
        int iHashCode = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return iHashCode;
    }

    public int indexOfKey(K k6) {
        return k6 == null ? indexOfNull() : indexOf(k6, k6.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int i5) {
        if (i5 < 0 || i5 >= this.size) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return (K) this.array[i5 << 1];
    }

    public V put(K k6, V v6) {
        int i5 = this.size;
        int iHashCode = k6 != null ? k6.hashCode() : 0;
        int iIndexOf = k6 != null ? indexOf(k6, iHashCode) : indexOfNull();
        if (iIndexOf >= 0) {
            int i6 = (iIndexOf << 1) + 1;
            Object[] objArr = this.array;
            V v7 = (V) objArr[i6];
            objArr[i6] = v6;
            return v7;
        }
        int i7 = ~iIndexOf;
        int[] iArr = this.hashes;
        if (i5 >= iArr.length) {
            int i8 = 8;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i8 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i8);
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i8 << 1);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
            if (i5 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr2 = this.hashes;
            int i9 = i7 + 1;
            AbstractC0151t.copyInto(iArr2, iArr2, i9, i7, i5);
            Object[] objArr2 = this.array;
            AbstractC0151t.copyInto(objArr2, objArr2, i9 << 1, i7 << 1, this.size << 1);
        }
        int i10 = this.size;
        if (i5 == i10) {
            int[] iArr3 = this.hashes;
            if (i7 < iArr3.length) {
                iArr3[i7] = iHashCode;
                Object[] objArr3 = this.array;
                int i11 = i7 << 1;
                objArr3[i11] = k6;
                objArr3[i11 + 1] = v6;
                this.size = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> map) {
        E.f(map, "map");
        int i5 = map.size;
        ensureCapacity(this.size + i5);
        if (this.size != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                put(map.keyAt(i6), map.valueAt(i6));
            }
        } else if (i5 > 0) {
            AbstractC0151t.copyInto(map.hashes, this.hashes, 0, 0, i5);
            AbstractC0151t.copyInto(map.array, this.array, 0, 0, i5 << 1);
            this.size = i5;
        }
    }

    public V putIfAbsent(K k6, V v6) {
        V v7 = get(k6);
        return v7 == null ? put(k6, v6) : v7;
    }

    public V remove(K k6) {
        int iIndexOfKey = indexOfKey(k6);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public V removeAt(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.size)) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        Object[] objArr = this.array;
        int i7 = i5 << 1;
        V v6 = (V) objArr[i7 + 1];
        if (i6 <= 1) {
            clear();
            return v6;
        }
        int i8 = i6 - 1;
        int[] iArr = this.hashes;
        if (iArr.length <= 8 || i6 >= iArr.length / 3) {
            if (i5 < i8) {
                int i9 = i5 + 1;
                AbstractC0151t.copyInto(iArr, iArr, i5, i9, i6);
                Object[] objArr2 = this.array;
                AbstractC0151t.copyInto(objArr2, objArr2, i7, i9 << 1, i6 << 1);
            }
            Object[] objArr3 = this.array;
            int i10 = i8 << 1;
            objArr3[i10] = null;
            objArr3[i10 + 1] = null;
        } else {
            int i11 = i6 > 8 ? i6 + (i6 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i11);
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i11 << 1);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            this.array = objArrCopyOf;
            if (i6 != this.size) {
                throw new ConcurrentModificationException();
            }
            if (i5 > 0) {
                AbstractC0151t.copyInto(iArr, this.hashes, 0, 0, i5);
                AbstractC0151t.copyInto(objArr, this.array, 0, 0, i7);
            }
            if (i5 < i8) {
                int i12 = i5 + 1;
                AbstractC0151t.copyInto(iArr, this.hashes, i5, i12, i6);
                AbstractC0151t.copyInto(objArr, this.array, i7, i12 << 1, i6 << 1);
            }
        }
        if (i6 != this.size) {
            throw new ConcurrentModificationException();
        }
        this.size = i8;
        return v6;
    }

    public V replace(K k6, V v6) {
        int iIndexOfKey = indexOfKey(k6);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v6);
        }
        return null;
    }

    public V setValueAt(int i5, V v6) {
        if (i5 < 0 || i5 >= this.size) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        int i6 = (i5 << 1) + 1;
        Object[] objArr = this.array;
        V v7 = (V) objArr[i6];
        objArr[i6] = v6;
        return v7;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i5 = this.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            K kKeyAt = keyAt(i6);
            if (kKeyAt != sb) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append(Chars.EQ);
            V vValueAt = valueAt(i6);
            if (vValueAt != sb) {
                sb.append(vValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC0157z.j('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public V valueAt(int i5) {
        if (i5 < 0 || i5 >= this.size) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return (V) this.array[(i5 << 1) + 1];
    }

    public SimpleArrayMap(int i5) {
        this.hashes = i5 == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[i5];
        this.array = i5 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[i5 << 1];
    }

    public boolean remove(K k6, V v6) {
        int iIndexOfKey = indexOfKey(k6);
        if (iIndexOfKey < 0 || !E.a(v6, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(K k6, V v6, V v7) {
        int iIndexOfKey = indexOfKey(k6);
        if (iIndexOfKey < 0 || !E.a(v6, valueAt(iIndexOfKey))) {
            return false;
        }
        setValueAt(iIndexOfKey, v7);
        return true;
    }

    public /* synthetic */ SimpleArrayMap(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
