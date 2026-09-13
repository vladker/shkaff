package p053j3;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P extends AtomicReference implements c, Runnable {
    private static final long serialVersionUID = 3167244060586201109L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5421a;

    public P(InterfaceC0679f interfaceC0679f) {
        this.f5421a = interfaceC0679f;
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
        this.f5421a.onComplete();
    }
}
