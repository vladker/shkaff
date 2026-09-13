package W3;

import A3.V;
import java.util.Iterator;

/* JADX INFO: renamed from: W3.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0225i implements InterfaceC0233q, InterfaceC0222f {
    public static final C0225i INSTANCE = new C0225i();

    @Override // W3.InterfaceC0233q
    public Iterator iterator() {
        return V.INSTANCE;
    }

    @Override // W3.InterfaceC0222f
    public C0225i drop(int i5) {
        return INSTANCE;
    }

    @Override // W3.InterfaceC0222f
    public C0225i take(int i5) {
        return INSTANCE;
    }
}
