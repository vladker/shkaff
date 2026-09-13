package p077n3;

import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S extends AtomicReference implements c, Runnable {
    private static final long serialVersionUID = 8465401857522493082L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.S f6278a;

    public S(io.reactivex.S s6) {
        this.f6278a = s6;
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
        this.f6278a.onSuccess(0L);
    }
}
