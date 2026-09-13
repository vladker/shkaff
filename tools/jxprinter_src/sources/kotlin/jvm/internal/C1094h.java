package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1094h implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5701a;
    private final Object[] array;

    public C1094h(Object[] array) {
        E.f(array, "array");
        this.array = array;
    }

    public final Object[] getArray() {
        return this.array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5701a < this.array.length;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            Object[] objArr = this.array;
            int i5 = this.f5701a;
            this.f5701a = i5 + 1;
            return objArr[i5];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f5701a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
