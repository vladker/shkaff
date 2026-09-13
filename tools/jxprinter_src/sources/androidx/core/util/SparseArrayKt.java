package androidx.core.util;

import A3.e0;
import O3.p;
import android.util.SparseArray;
import java.util.Iterator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03231<T> implements Iterator<T>, P3.a {
        final /* synthetic */ SparseArray<T> $this_valueIterator;
        private int index;

        public C03231(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> sparseArray = this.$this_valueIterator;
            int i5 = this.index;
            this.index = i5 + 1;
            return sparseArray.valueAt(i5);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i5) {
            this.index = i5;
        }
    }

    public static final <T> boolean contains(SparseArray<T> sparseArray, int i5) {
        return sparseArray.indexOfKey(i5) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i5) {
        return sparseArray.indexOfKey(i5) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t6) {
        return sparseArray.indexOfValue(t6) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, p pVar) {
        int size = sparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i5)), sparseArray.valueAt(i5));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i5, T t6) {
        T t7 = sparseArray.get(i5);
        return t7 == null ? t6 : t7;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i5, O3.a aVar) {
        T t6 = sparseArray.get(i5);
        return t6 == null ? (T) aVar.invoke() : t6;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        return sparseArray.size() != 0;
    }

    public static final <T> e0 keyIterator(final SparseArray<T> sparseArray) {
        return new e0() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // A3.e0
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseArray2.keyAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray2.size() + sparseArray.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseArray.put(sparseArray2.keyAt(i5), sparseArray2.valueAt(i5));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i5, T t6) {
        int iIndexOfKey = sparseArray.indexOfKey(i5);
        if (iIndexOfKey < 0 || !E.a(t6, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i5, T t6) {
        sparseArray.put(i5, t6);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        return new C03231(sparseArray);
    }
}
