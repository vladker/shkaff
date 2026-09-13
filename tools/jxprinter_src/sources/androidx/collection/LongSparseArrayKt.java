package androidx.collection;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.f0;
import O3.p;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArrayKt {
    private static final Object DELETED = new Object();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class C03171<T> implements Iterator<T>, P3.a {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C03171(LongSparseArray<T> longSparseArray) {
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

    public static final <E> void commonAppend(LongSparseArray<E> longSparseArray, long j6, E e) {
        E.f(longSparseArray, "<this>");
        int i5 = longSparseArray.size;
        if (i5 != 0 && j6 <= longSparseArray.keys[i5 - 1]) {
            longSparseArray.put(j6, e);
            return;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            if (i5 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i6 = 0;
                for (int i7 = 0; i7 < i5; i7++) {
                    Object obj = objArr[i7];
                    if (obj != DELETED) {
                        if (i7 != i6) {
                            jArr[i6] = jArr[i7];
                            objArr[i6] = obj;
                            objArr[i7] = null;
                        }
                        i6++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i6;
            }
        }
        int i8 = longSparseArray.size;
        if (i8 >= longSparseArray.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i8 + 1);
            long[] jArrCopyOf = Arrays.copyOf(longSparseArray.keys, iIdealLongArraySize);
            E.e(jArrCopyOf, "copyOf(this, newSize)");
            longSparseArray.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(longSparseArray.values, iIdealLongArraySize);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            longSparseArray.values = objArrCopyOf;
        }
        longSparseArray.keys[i8] = j6;
        longSparseArray.values[i8] = e;
        longSparseArray.size = i8 + 1;
    }

    public static final <E> void commonClear(LongSparseArray<E> longSparseArray) {
        E.f(longSparseArray, "<this>");
        int i5 = longSparseArray.size;
        Object[] objArr = longSparseArray.values;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        longSparseArray.size = 0;
        longSparseArray.garbage = false;
    }

    public static final <E> boolean commonContainsKey(LongSparseArray<E> longSparseArray, long j6) {
        E.f(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j6) >= 0;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> longSparseArray, E e) {
        E.f(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(e) >= 0;
    }

    public static final <E> void commonGc(LongSparseArray<E> longSparseArray) {
        E.f(longSparseArray, "<this>");
        int i5 = longSparseArray.size;
        long[] jArr = longSparseArray.keys;
        Object[] objArr = longSparseArray.values;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != DELETED) {
                if (i7 != i6) {
                    jArr[i6] = jArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        longSparseArray.garbage = false;
        longSparseArray.size = i6;
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j6) {
        E.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        if (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) {
            return null;
        }
        return (E) longSparseArray.values[iBinarySearch];
    }

    public static final <T extends E, E> T commonGetInternal(LongSparseArray<E> longSparseArray, long j6, T t6) {
        E.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        return (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) ? t6 : (T) longSparseArray.values[iBinarySearch];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> longSparseArray, long j6) {
        E.f(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i5 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        return ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> longSparseArray, E e) {
        E.f(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i5 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        int i8 = longSparseArray.size;
        for (int i9 = 0; i9 < i8; i9++) {
            if (longSparseArray.values[i9] == e) {
                return i9;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> longSparseArray) {
        E.f(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> longSparseArray, int i5) {
        int i6;
        E.f(longSparseArray, "<this>");
        if (i5 < 0 || i5 >= (i6 = longSparseArray.size)) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        return longSparseArray.keys[i5];
    }

    public static final <E> void commonPut(LongSparseArray<E> longSparseArray, long j6, E e) {
        E.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        if (iBinarySearch >= 0) {
            longSparseArray.values[iBinarySearch] = e;
            return;
        }
        int i5 = ~iBinarySearch;
        if (i5 < longSparseArray.size && longSparseArray.values[i5] == DELETED) {
            longSparseArray.keys[i5] = j6;
            longSparseArray.values[i5] = e;
            return;
        }
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            if (i6 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i7 = 0;
                for (int i8 = 0; i8 < i6; i8++) {
                    Object obj = objArr[i8];
                    if (obj != DELETED) {
                        if (i8 != i7) {
                            jArr[i7] = jArr[i8];
                            objArr[i7] = obj;
                            objArr[i8] = null;
                        }
                        i7++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i7;
                i5 = ~ContainerHelpersKt.binarySearch(longSparseArray.keys, i7, j6);
            }
        }
        int i9 = longSparseArray.size;
        if (i9 >= longSparseArray.keys.length) {
            int iIdealLongArraySize = ContainerHelpersKt.idealLongArraySize(i9 + 1);
            long[] jArrCopyOf = Arrays.copyOf(longSparseArray.keys, iIdealLongArraySize);
            E.e(jArrCopyOf, "copyOf(this, newSize)");
            longSparseArray.keys = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(longSparseArray.values, iIdealLongArraySize);
            E.e(objArrCopyOf, "copyOf(this, newSize)");
            longSparseArray.values = objArrCopyOf;
        }
        int i10 = longSparseArray.size;
        if (i10 - i5 != 0) {
            long[] jArr2 = longSparseArray.keys;
            int i11 = i5 + 1;
            AbstractC0151t.copyInto(jArr2, jArr2, i11, i5, i10);
            Object[] objArr2 = longSparseArray.values;
            AbstractC0151t.copyInto(objArr2, objArr2, i11, i5, longSparseArray.size);
        }
        longSparseArray.keys[i5] = j6;
        longSparseArray.values[i5] = e;
        longSparseArray.size++;
    }

    public static final <E> void commonPutAll(LongSparseArray<E> longSparseArray, LongSparseArray<? extends E> other) {
        E.f(longSparseArray, "<this>");
        E.f(other, "other");
        int size = other.size();
        for (int i5 = 0; i5 < size; i5++) {
            longSparseArray.put(other.keyAt(i5), other.valueAt(i5));
        }
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> longSparseArray, long j6, E e) {
        E.f(longSparseArray, "<this>");
        E e6 = longSparseArray.get(j6);
        if (e6 == null) {
            longSparseArray.put(j6, e);
        }
        return e6;
    }

    public static final <E> void commonRemove(LongSparseArray<E> longSparseArray, long j6) {
        E.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        if (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) {
            return;
        }
        longSparseArray.values[iBinarySearch] = DELETED;
        longSparseArray.garbage = true;
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> longSparseArray, int i5) {
        E.f(longSparseArray, "<this>");
        if (longSparseArray.values[i5] != DELETED) {
            longSparseArray.values[i5] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> E commonReplace(LongSparseArray<E> longSparseArray, long j6, E e) {
        E.f(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j6);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = longSparseArray.values;
        E e6 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e;
        return e6;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> longSparseArray, int i5, E e) {
        int i6;
        E.f(longSparseArray, "<this>");
        if (i5 < 0 || i5 >= (i6 = longSparseArray.size)) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        longSparseArray.values[i5] = e;
    }

    public static final <E> int commonSize(LongSparseArray<E> longSparseArray) {
        E.f(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i5 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                Object obj = objArr[i7];
                if (obj != DELETED) {
                    if (i7 != i6) {
                        jArr[i6] = jArr[i7];
                        objArr[i6] = obj;
                        objArr[i7] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        return longSparseArray.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> longSparseArray) {
        E.f(longSparseArray, "<this>");
        if (longSparseArray.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(longSparseArray.size * 28);
        sb.append('{');
        int i5 = longSparseArray.size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(longSparseArray.keyAt(i6));
            sb.append(Chars.EQ);
            E eValueAt = longSparseArray.valueAt(i6);
            if (eValueAt != sb) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC0157z.j('}', "StringBuilder(capacity).…builderAction).toString()", sb);
    }

    public static final <E> E commonValueAt(LongSparseArray<E> longSparseArray, int i5) {
        int i6;
        E.f(longSparseArray, "<this>");
        if (i5 < 0 || i5 >= (i6 = longSparseArray.size)) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Expected index to be within 0..size()-1, but was ").toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj = objArr[i8];
                if (obj != DELETED) {
                    if (i8 != i7) {
                        jArr[i7] = jArr[i8];
                        objArr[i7] = obj;
                        objArr[i8] = null;
                    }
                    i7++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i7;
        }
        return (E) longSparseArray.values[i5];
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j6) {
        E.f(longSparseArray, "<this>");
        return longSparseArray.containsKey(j6);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p action) {
        E.f(longSparseArray, "<this>");
        E.f(action, "action");
        int size = longSparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            action.invoke(Long.valueOf(longSparseArray.keyAt(i5)), longSparseArray.valueAt(i5));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j6, T t6) {
        E.f(longSparseArray, "<this>");
        return longSparseArray.get(j6, t6);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j6, O3.a defaultValue) {
        E.f(longSparseArray, "<this>");
        E.f(defaultValue, "defaultValue");
        T t6 = longSparseArray.get(j6);
        return t6 == null ? (T) defaultValue.invoke() : t6;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        E.f(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        E.f(longSparseArray, "<this>");
        return !longSparseArray.isEmpty();
    }

    public static final <T> f0 keyIterator(final LongSparseArray<T> longSparseArray) {
        E.f(longSparseArray, "<this>");
        return new f0() { // from class: androidx.collection.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
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

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> other) {
        E.f(longSparseArray, "<this>");
        E.f(other, "other");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>(other.size() + longSparseArray.size());
        longSparseArray2.putAll(longSparseArray);
        longSparseArray2.putAll(other);
        return longSparseArray2;
    }

    public static final /* synthetic */ boolean remove(LongSparseArray longSparseArray, long j6, Object obj) {
        E.f(longSparseArray, "<this>");
        return longSparseArray.remove(j6, obj);
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j6, T t6) {
        E.f(longSparseArray, "<this>");
        longSparseArray.put(j6, t6);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        E.f(longSparseArray, "<this>");
        return new C03171(longSparseArray);
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j6, E e) {
        E.f(longSparseArray, "<this>");
        int iBinarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j6);
        return (iBinarySearch < 0 || longSparseArray.values[iBinarySearch] == DELETED) ? e : (E) longSparseArray.values[iBinarySearch];
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> longSparseArray, long j6, E e, E e6) {
        E.f(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j6);
        if (iIndexOfKey < 0 || !E.a(longSparseArray.values[iIndexOfKey], e)) {
            return false;
        }
        longSparseArray.values[iIndexOfKey] = e6;
        return true;
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> longSparseArray, long j6, E e) {
        E.f(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j6);
        if (iIndexOfKey < 0 || !E.a(e, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray longSparseArray) {
    }
}
