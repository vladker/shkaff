package androidx.core.util;

import A3.e0;
import O3.p;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i5) {
        return sparseIntArray.indexOfKey(i5) >= 0;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i5) {
        return sparseIntArray.indexOfKey(i5) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i5) {
        return sparseIntArray.indexOfValue(i5) >= 0;
    }

    public static final void forEach(SparseIntArray sparseIntArray, p pVar) {
        int size = sparseIntArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseIntArray.keyAt(i5)), Integer.valueOf(sparseIntArray.valueAt(i5)));
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i5, int i6) {
        return sparseIntArray.get(i5, i6);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i5, O3.a aVar) {
        int iIndexOfKey = sparseIntArray.indexOfKey(i5);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : ((Number) aVar.invoke()).intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        return sparseIntArray.size() != 0;
    }

    public static final e0 keyIterator(final SparseIntArray sparseIntArray) {
        return new e0() { // from class: androidx.core.util.SparseIntArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // A3.e0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseIntArray2.keyAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray2.size() + sparseIntArray.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i5), sparseIntArray2.valueAt(i5));
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i5, int i6) {
        int iIndexOfKey = sparseIntArray.indexOfKey(i5);
        if (iIndexOfKey < 0 || i6 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i5, int i6) {
        sparseIntArray.put(i5, i6);
    }

    public static final e0 valueIterator(final SparseIntArray sparseIntArray) {
        return new e0() { // from class: androidx.core.util.SparseIntArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseIntArray.size();
            }

            @Override // A3.e0
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseIntArray2.valueAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }
}
