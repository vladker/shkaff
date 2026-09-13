package p123v3;

import p094q3.a;
import p094q3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    private static final long serialVersionUID = -4896760517184205454L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8779a;

    public c(d dVar) {
        this.f8779a = dVar;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f8779a.f8786l = true;
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f8779a.f8782h) {
            return;
        }
        this.f8779a.f8782h = true;
        Runnable runnable = (Runnable) this.f8779a.c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
        d dVar = this.f8779a;
        if (dVar.f8786l || dVar.f8784j.getAndIncrement() != 0) {
            return;
        }
        this.f8779a.b.clear();
        this.f8779a.f8781g.lazySet(null);
    }

    @Override // p043h3.j
    public final void clear() {
        this.f8779a.b.clear();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.f8779a.b.isEmpty();
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        return this.f8779a.b.poll();
    }

    @Override // t5.d
    public final void request(long j6) {
        if (g.f(j6)) {
            d dVar = this.f8779a;
            p122v2.a.a(dVar.f8785k, j6);
            dVar.i();
        }
    }
}
