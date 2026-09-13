package androidx.core.util;

import A3.e0;
import A3.f0;
import O3.p;
import android.util.SparseLongArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray sparseLongArray, int i5) {
        return sparseLongArray.indexOfKey(i5) >= 0;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray, int i5) {
        return sparseLongArray.indexOfKey(i5) >= 0;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray, long j6) {
        return sparseLongArray.indexOfValue(j6) >= 0;
    }

    public static final void forEach(SparseLongArray sparseLongArray, p pVar) {
        int size = sparseLongArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseLongArray.keyAt(i5)), Long.valueOf(sparseLongArray.valueAt(i5)));
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray, int i5, long j6) {
        return sparseLongArray.get(i5, j6);
    }

    public static final long getOrElse(SparseLongArray sparseLongArray, int i5, O3.a aVar) {
        int iIndexOfKey = sparseLongArray.indexOfKey(i5);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : ((Number) aVar.invoke()).longValue();
    }

    public static final int getSize(SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        return sparseLongArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        return sparseLongArray.size() != 0;
    }

    public static final e0 keyIterator(final SparseLongArray sparseLongArray) {
        return new e0() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // A3.e0
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseLongArray2.keyAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i5), sparseLongArray2.valueAt(i5));
        }
    }

    public static final boolean remove(SparseLongArray sparseLongArray, int i5, long j6) {
        int iIndexOfKey = sparseLongArray.indexOfKey(i5);
        if (iIndexOfKey < 0 || j6 != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(SparseLongArray sparseLongArray, int i5, long j6) {
        sparseLongArray.put(i5, j6);
    }

    public static final f0 valueIterator(final SparseLongArray sparseLongArray) {
        return new f0() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // A3.f0
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseLongArray2.valueAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }
}
