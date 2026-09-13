package A3;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC1095i;
import kotlin.jvm.internal.AbstractC1106u;

/* JADX INFO: renamed from: A3.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0142j implements Collection, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40a;
    private final Object[] values;

    public C0142j(Object[] values, boolean z6) {
        kotlin.jvm.internal.E.f(values, "values");
        this.values = values;
        this.f40a = z6;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return C.contains(this.values, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!C.contains(this.values, it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.values.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return AbstractC1095i.iterator(this.values);
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
        return this.values.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        return AbstractC1106u.toArray(this, array);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return G.copyToArrayOfAny(this.values, this.f40a);
    }
}
