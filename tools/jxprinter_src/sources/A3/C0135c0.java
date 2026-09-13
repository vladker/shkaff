package A3;

import java.util.Iterator;

/* JADX INFO: renamed from: A3.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0135c0 implements Iterable, P3.a {
    private final O3.a iteratorFactory;

    public C0135c0(O3.a iteratorFactory) {
        kotlin.jvm.internal.E.f(iteratorFactory, "iteratorFactory");
        this.iteratorFactory = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator<C0133b0> iterator() {
        return new d0((Iterator) this.iteratorFactory.invoke());
    }
}
