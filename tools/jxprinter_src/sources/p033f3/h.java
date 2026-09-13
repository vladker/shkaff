package p033f3;

import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends AtomicReference implements c {
    private static final long serialVersionUID = -754898800686245608L;

    public h(h hVar) {
        lazySet(hVar);
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }
}
