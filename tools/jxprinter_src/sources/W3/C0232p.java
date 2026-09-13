package W3;

import java.util.Iterator;

/* JADX INFO: renamed from: W3.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0232p implements InterfaceC0233q {
    private final InterfaceC0233q sequence1;
    private final InterfaceC0233q sequence2;
    private final O3.p transform;

    public C0232p(InterfaceC0233q sequence1, InterfaceC0233q sequence2, O3.p transform) {
        kotlin.jvm.internal.E.f(sequence1, "sequence1");
        kotlin.jvm.internal.E.f(sequence2, "sequence2");
        kotlin.jvm.internal.E.f(transform, "transform");
        this.sequence1 = sequence1;
        this.sequence2 = sequence2;
        this.transform = transform;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0231o(this);
    }
}
