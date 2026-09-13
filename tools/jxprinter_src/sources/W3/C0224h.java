package W3;

import java.util.Iterator;

/* JADX INFO: renamed from: W3.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0224h implements InterfaceC0233q {
    private final O3.l predicate;
    private final InterfaceC0233q sequence;

    public C0224h(InterfaceC0233q sequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        this.sequence = sequence;
        this.predicate = predicate;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0223g(this);
    }
}
