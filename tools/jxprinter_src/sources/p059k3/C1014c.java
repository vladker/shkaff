package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;

/* JADX INFO: renamed from: k3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1014c extends AtomicReference implements c {
    private static final long serialVersionUID = -5791853038359966195L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5540a;

    public C1014c(InterfaceC0988v interfaceC0988v, C1016d c1016d) {
        super(c1016d);
        this.f5540a = interfaceC0988v;
    }

    @Override // p011b3.c
    public final void dispose() {
        C1016d c1016d = (C1016d) getAndSet(null);
        if (c1016d != null) {
            c1016d.d(this);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == null;
    }
}
