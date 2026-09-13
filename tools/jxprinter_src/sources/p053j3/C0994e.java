package p053j3;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicBoolean;
import p011b3.c;

/* JADX INFO: renamed from: j3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0994e extends AtomicBoolean implements c {
    private static final long serialVersionUID = 8943152917179642732L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5430a;
    public final /* synthetic */ C0995f b;

    public C0994e(C0995f c0995f, InterfaceC0679f interfaceC0679f) {
        this.b = c0995f;
        this.f5430a = interfaceC0679f;
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
