package B3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends a {
    private final m backing;

    public n(m backing) {
        E.f(backing, "backing");
        this.backing = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<Object, Object>> elements) {
        E.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // A3.AbstractC0141i
    public final int b() {
        return this.backing.e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.backing.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        return this.backing.containsAllEntries$kotlin_stdlib(elements);
    }

    @Override // B3.a
    public boolean containsEntry(Map.Entry<Object, Object> element) {
        E.f(element, "element");
        return this.backing.containsEntry$kotlin_stdlib(element);
    }

    public final m getBacking() {
        return this.backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<Object, Object>> iterator() {
        return this.backing.entriesIterator$kotlin_stdlib();
    }

    @Override // B3.a
    public boolean remove(Map.Entry element) {
        E.f(element, "element");
        return this.backing.removeEntry$kotlin_stdlib(element);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        this.backing.h();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        E.f(elements, "elements");
        this.backing.h();
        return super.retainAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Map.Entry<Object, Object> element) {
        E.f(element, "element");
        throw new UnsupportedOperationException();
    }
}
