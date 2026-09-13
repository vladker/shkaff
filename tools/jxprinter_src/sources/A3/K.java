package A3;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Enumeration f33a;

    public K(Enumeration enumeration) {
        this.f33a = enumeration;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33a.hasMoreElements();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f33a.nextElement();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
