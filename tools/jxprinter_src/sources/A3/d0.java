package A3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38a;
    private final Iterator<Object> iterator;

    public d0(Iterator<Object> iterator) {
        kotlin.jvm.internal.E.f(iterator, "iterator");
        this.iterator = iterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final C0133b0 next() {
        int i5 = this.f38a;
        this.f38a = i5 + 1;
        if (i5 < 0) {
            I.throwIndexOverflow();
        }
        return new C0133b0(i5, this.iterator.next());
    }
}
