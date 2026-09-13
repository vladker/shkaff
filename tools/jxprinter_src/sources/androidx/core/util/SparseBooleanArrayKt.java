package androidx.core.util;

import A3.D;
import A3.e0;
import O3.p;
import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i5) {
        return sparseBooleanArray.indexOfKey(i5) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i5) {
        return sparseBooleanArray.indexOfKey(i5) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z6) {
        return sparseBooleanArray.indexOfValue(z6) >= 0;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, p pVar) {
        int size = sparseBooleanArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i5)), Boolean.valueOf(sparseBooleanArray.valueAt(i5)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i5, boolean z6) {
        return sparseBooleanArray.get(i5, z6);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i5, O3.a aVar) {
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i5);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : ((Boolean) aVar.invoke()).booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size() != 0;
    }

    public static final e0 keyIterator(final SparseBooleanArray sparseBooleanArray) {
        return new e0() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // A3.e0
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseBooleanArray2.keyAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray2.size() + sparseBooleanArray.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i5), sparseBooleanArray2.valueAt(i5));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i5, boolean z6) {
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i5);
        if (iIndexOfKey < 0 || z6 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i5);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i5, boolean z6) {
        sparseBooleanArray.put(i5, z6);
    }

    public static final D valueIterator(final SparseBooleanArray sparseBooleanArray) {
        return new D() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // A3.D
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseBooleanArray2.valueAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }
}
