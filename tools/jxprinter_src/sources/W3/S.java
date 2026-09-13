package W3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S implements InterfaceC0233q {
    private final InterfaceC0233q sequence;
    private final O3.l transformer;

    public S(InterfaceC0233q sequence, O3.l transformer) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        kotlin.jvm.internal.E.f(transformer, "transformer");
        this.sequence = sequence;
        this.transformer = transformer;
    }

    public final <E> InterfaceC0233q flatten$kotlin_stdlib(O3.l iterator) {
        kotlin.jvm.internal.E.f(iterator, "iterator");
        return new C0227k(this.sequence, this.transformer, iterator);
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new Q(this);
    }
}
