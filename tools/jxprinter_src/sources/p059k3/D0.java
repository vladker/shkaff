package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D0 extends AtomicReference implements c, Runnable {
    private static final long serialVersionUID = 2875964065294031672L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5508a;

    public D0(InterfaceC0988v interfaceC0988v) {
        this.f5508a = interfaceC0988v;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5508a.onSuccess(0L);
    }
}
