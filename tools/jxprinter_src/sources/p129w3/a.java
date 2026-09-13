package p129w3;

import io.reactivex.I;
import java.util.concurrent.atomic.AtomicBoolean;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicBoolean implements c {
    private static final long serialVersionUID = 3562861878281475070L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f8816a;
    public final b b;

    public a(I i5, b bVar) {
        this.f8816a = i5;
        this.b = bVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (compareAndSet(false, true)) {
            this.b.e(this);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get();
    }
}
