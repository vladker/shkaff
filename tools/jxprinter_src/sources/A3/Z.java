package A3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Z implements Iterator, P3.a {
    public abstract float b();

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Float.valueOf(b());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final Float next() {
        return Float.valueOf(b());
    }
}
