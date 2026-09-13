package W3;

import A3.C0133b0;
import java.util.Iterator;

/* JADX INFO: renamed from: W3.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0230n implements InterfaceC0233q {
    private final InterfaceC0233q sequence;

    public C0230n(InterfaceC0233q sequence) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        this.sequence = sequence;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<C0133b0> iterator() {
        return new C0220d(this);
    }
}
