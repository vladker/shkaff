package androidx.core.util;

import A3.f0;
import O3.p;
import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03221<T> implements Iterator<T>, P3.a {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C03221(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
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
            LongSparseArray<T> longSparseArray = this.$this_valueIterator;
            int i5 = this.index;
            this.index = i5 + 1;
            return longSparseArray.valueAt(i5);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i5) {
            this.index = i5;
        }
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j6) {
        return longSparseArray.indexOfKey(j6) >= 0;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j6) {
        return longSparseArray.indexOfKey(j6) >= 0;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t6) {
        return longSparseArray.indexOfValue(t6) >= 0;
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p pVar) {
        int size = longSparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i5)), longSparseArray.valueAt(i5));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j6, T t6) {
        T t7 = longSparseArray.get(j6);
        return t7 == null ? t6 : t7;
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j6, O3.a aVar) {
        T t6 = longSparseArray.get(j6);
        return t6 == null ? (T) aVar.invoke() : t6;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size() != 0;
    }

    public static final <T> f0 keyIterator(final LongSparseArray<T> longSparseArray) {
        return new f0() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // A3.f0
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return longSparseArray2.keyAt(i5);
            }

            public final void setIndex(int i5) {
                this.index = i5;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        int size = longSparseArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            longSparseArray.put(longSparseArray2.keyAt(i5), longSparseArray2.valueAt(i5));
        }
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j6, T t6) {
        int iIndexOfKey = longSparseArray.indexOfKey(j6);
        if (iIndexOfKey < 0 || !E.a(t6, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j6, T t6) {
        longSparseArray.put(j6, t6);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        return new C03221(longSparseArray);
    }
}
