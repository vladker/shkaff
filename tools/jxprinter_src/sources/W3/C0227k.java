package W3;

import java.util.Iterator;

/* JADX INFO: renamed from: W3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0227k implements InterfaceC0233q {
    private final O3.l iterator;
    private final InterfaceC0233q sequence;
    private final O3.l transformer;

    public C0227k(InterfaceC0233q sequence, O3.l transformer, O3.l iterator) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        kotlin.jvm.internal.E.f(transformer, "transformer");
        kotlin.jvm.internal.E.f(iterator, "iterator");
        this.sequence = sequence;
        this.transformer = transformer;
        this.iterator = iterator;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0223g(this);
    }
}
