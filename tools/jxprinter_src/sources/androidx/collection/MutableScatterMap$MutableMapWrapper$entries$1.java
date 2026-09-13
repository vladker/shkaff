package androidx.collection;

import P3.b;
import P3.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1106u;
import kotlin.jvm.internal.E;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$entries$1<K, V> implements Set<Map.Entry<K, V>>, b {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<K, V>> elements) {
        E.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.this$0.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (!(obj instanceof P3.a) || (obj instanceof c)) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!E.a(mutableScatterMap.get((K) entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.this$0._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(this.this$0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (!(obj instanceof P3.a) || (obj instanceof c)) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        int i5;
        E.f(elements, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i6 = 0;
        boolean z6 = false;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8;
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((255 & j6) >= 128) {
                        i5 = i7;
                        break;
                        break;
                    }
                    int i10 = (i6 << 3) + i9;
                    Iterator<? extends Object> it = elements.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i5 = i7;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        i5 = i7;
                        if (E.a(entry.getKey(), mutableScatterMap.keys[i10]) && E.a(entry.getValue(), mutableScatterMap.values[i10])) {
                            mutableScatterMap.removeValueAt(i10);
                            z6 = true;
                            break;
                        }
                        i7 = i5;
                    }
                    j6 >>= i5;
                    i9++;
                    i7 = i5;
                }
                if (i8 != i7) {
                    return z6;
                }
            }
            if (i6 == length) {
                return z6;
            }
            i6++;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        int i5;
        E.f(elements, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i6 = 0;
        boolean z6 = false;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8;
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((255 & j6) < 128) {
                        int i10 = (i6 << 3) + i9;
                        Iterator<? extends Object> it = elements.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i5 = i7;
                                mutableScatterMap.removeValueAt(i10);
                                z6 = true;
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            i5 = i7;
                            if (E.a(entry.getKey(), mutableScatterMap.keys[i10]) && E.a(entry.getValue(), mutableScatterMap.values[i10])) {
                                break;
                            }
                            i7 = i5;
                        }
                    } else {
                        i5 = i7;
                    }
                    j6 >>= i5;
                    i9++;
                    i7 = i5;
                }
                if (i8 != i7) {
                    return z6;
                }
            }
            if (i6 == length) {
                return z6;
            }
            i6++;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return AbstractC1106u.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Map.Entry<K, V> element) {
        E.f(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        E.f(array, "array");
        return (T[]) AbstractC1106u.toArray(this, array);
    }

    public boolean contains(Map.Entry<K, V> element) {
        E.f(element, "element");
        return E.a(this.this$0.get(element.getKey()), element.getValue());
    }

    public boolean remove(Map.Entry<K, V> element) {
        int iNumberOfTrailingZeros;
        E.f(element, "element");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        K key = element.getKey();
        int iHashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i5 = iHashCode ^ (iHashCode << 16);
        int i6 = i5 & 127;
        int i7 = mutableScatterMap._capacity;
        int i8 = (i5 >>> 7) & i7;
        int i9 = 0;
        loop0: while (true) {
            long[] jArr = mutableScatterMap.metadata;
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            int i12 = i8;
            long j6 = (((-i11) >> 63) & (jArr[i10 + 1] << (64 - i11))) | (jArr[i10] >>> i11);
            long j7 = (((long) i6) * ScatterMapKt.BitmaskLsb) ^ j6;
            long j8 = -9187201950435737472L;
            long j9 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (j9 != 0) {
                iNumberOfTrailingZeros = (i12 + (Long.numberOfTrailingZeros(j9) >> 3)) & i7;
                long j10 = j8;
                if (E.a(mutableScatterMap.keys[iNumberOfTrailingZeros], key)) {
                    break loop0;
                }
                j9 &= j9 - 1;
                j8 = j10;
            }
            if ((j6 & ((~j6) << 6) & j8) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i9 += 8;
            i8 = (i12 + i9) & i7;
        }
        if (iNumberOfTrailingZeros < 0 || !E.a(this.this$0.values[iNumberOfTrailingZeros], element.getValue())) {
            return false;
        }
        this.this$0.removeValueAt(iNumberOfTrailingZeros);
        return true;
    }
}
