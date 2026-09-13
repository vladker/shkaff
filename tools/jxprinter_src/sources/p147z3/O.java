package p147z3;

import A3.C;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1106u;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O implements Collection, P3.a {
    private final short[] storage;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a implements Iterator, P3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9129a;
        private final short[] array;

        public a(short[] array) {
            E.f(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f9129a < this.array.length;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int i5 = this.f9129a;
            short[] sArr = this.array;
            if (i5 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f9129a));
            }
            this.f9129a = i5 + 1;
            return N.a(N.m1306constructorimpl(sArr[i5]));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ O(short[] sArr) {
        this.storage = sArr;
    }

    public static final /* synthetic */ O b(short[] sArr) {
        return new O(sArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short[] m1354constructorimpl(short[] storage) {
        E.f(storage, "storage");
        return storage;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m1355containsAllimpl(short[] sArr, Collection<N> elements) {
        E.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof N) || !C.contains(sArr, ((N) obj).f9128a)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static Iterator<N> m1356iteratorimpl(short[] sArr) {
        return new a(sArr);
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ short[] c() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof N)) {
            return false;
        }
        return C.contains(this.storage, ((N) obj).f9128a);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        return m1355containsAllimpl(this.storage, elements);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof O) && E.a(this.storage, ((O) obj).storage);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.storage);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.storage.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<N> iterator() {
        return m1356iteratorimpl(this.storage);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.storage.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return AbstractC1106u.toArray(this);
    }

    public final String toString() {
        return "UShortArray(storage=" + Arrays.toString(this.storage) + ')';
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short[] m1353constructorimpl(int i5) {
        return m1354constructorimpl(new short[i5]);
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        E.f(array, "array");
        return AbstractC1106u.toArray(this, array);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }
}
