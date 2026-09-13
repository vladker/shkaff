package W3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f811a;
    public final /* synthetic */ S b;

    public Q(S s6) {
        this.b = s6;
        this.f811a = s6.sequence.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f811a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.b.transformer.invoke(this.f811a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
