package W3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P implements InterfaceC0233q {
    private final InterfaceC0233q sequence;
    private final O3.p transformer;

    public P(InterfaceC0233q sequence, O3.p transformer) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        kotlin.jvm.internal.E.f(transformer, "transformer");
        this.sequence = sequence;
        this.transformer = transformer;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0228l(this);
    }
}
