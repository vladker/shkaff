package W3;

import java.util.Iterator;

/* JADX INFO: renamed from: W3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0219c implements InterfaceC0233q {
    private final O3.l keySelector;
    private final InterfaceC0233q source;

    public C0219c(InterfaceC0233q source, O3.l keySelector) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        this.source = source;
        this.keySelector = keySelector;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0218b(this.source.iterator(), this.keySelector);
    }
}
