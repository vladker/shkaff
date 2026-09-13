package p077n3;

import io.reactivex.S;
import java.util.concurrent.atomic.AtomicBoolean;
import p011b3.c;

/* JADX INFO: renamed from: n3.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1248b extends AtomicBoolean implements c {
    private static final long serialVersionUID = 7514387411091976596L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6286a;
    public final C1249c b;

    public C1248b(S s6, C1249c c1249c) {
        this.f6286a = s6;
        this.b = c1249c;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (compareAndSet(false, true)) {
            this.b.f(this);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get();
    }
}
