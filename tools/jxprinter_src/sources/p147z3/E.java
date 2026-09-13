package p147z3;

import A3.C;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1106u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E implements Collection, P3.a {
    private final byte[] storage;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a implements Iterator, P3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9123a;
        private final byte[] array;

        public a(byte[] array) {
            kotlin.jvm.internal.E.f(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f9123a < this.array.length;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int i5 = this.f9123a;
            byte[] bArr = this.array;
            if (i5 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f9123a));
            }
            this.f9123a = i5 + 1;
            return D.a(D.m1131constructorimpl(bArr[i5]));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ E(byte[] bArr) {
        this.storage = bArr;
    }

    public static final /* synthetic */ E b(byte[] bArr) {
        return new E(bArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m1179constructorimpl(byte[] storage) {
        kotlin.jvm.internal.E.f(storage, "storage");
        return storage;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m1180containsAllimpl(byte[] bArr, Collection<D> elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof D) || !C.contains(bArr, ((D) obj).f9122a)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static Iterator<D> m1181iteratorimpl(byte[] bArr) {
        return new a(bArr);
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ byte[] c() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof D)) {
            return false;
        }
        return C.contains(this.storage, ((D) obj).f9122a);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return m1180containsAllimpl(this.storage, elements);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof E) && kotlin.jvm.internal.E.a(this.storage, ((E) obj).storage);
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
    public Iterator<D> iterator() {
        return m1181iteratorimpl(this.storage);
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
        return "UByteArray(storage=" + Arrays.toString(this.storage) + ')';
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m1178constructorimpl(int i5) {
        return m1179constructorimpl(new byte[i5]);
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        return AbstractC1106u.toArray(this, array);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }
}
