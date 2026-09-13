package A3;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends AbstractC0140h {
    private final List<Object> delegate;

    public r0(List<Object> delegate) {
        kotlin.jvm.internal.E.f(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        this.delegate.add(P.e(i5, this), obj);
    }

    @Override // A3.AbstractC0140h
    public final int b() {
        return this.delegate.size();
    }

    @Override // A3.AbstractC0140h
    public final Object c(int i5) {
        return this.delegate.remove(P.d(i5, this));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.delegate.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        return this.delegate.get(P.d(i5, this));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<Object> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<Object> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        return this.delegate.set(P.d(i5, this), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<Object> listIterator(int i5) {
        return new q0(this, i5);
    }
}
