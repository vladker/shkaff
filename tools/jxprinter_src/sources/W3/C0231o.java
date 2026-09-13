package W3;

import java.util.Iterator;

/* JADX INFO: renamed from: W3.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0231o implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f817a;
    public final Iterator b;
    public final /* synthetic */ C0232p c;

    public C0231o(C0232p c0232p) {
        this.c = c0232p;
        this.f817a = c0232p.sequence1.iterator();
        this.b = c0232p.sequence2.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f817a.hasNext() && this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.c.transform.invoke(this.f817a.next(), this.b.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
