package p088p3;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends AtomicReference implements InterfaceC0984q, c, d {
    private static final long serialVersionUID = -8612022020200669122L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f7753a;
    public final AtomicReference b = new AtomicReference();

    public n(t5.c cVar) {
        this.f7753a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        dispose();
    }

    @Override // p011b3.c
    public final void dispose() {
        g.a(this.b);
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.get() == g.f7849a;
    }

    @Override // t5.c
    public final void onComplete() {
        p033f3.d.a(this);
        this.f7753a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p033f3.d.a(this);
        this.f7753a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f7753a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.e(this.b, dVar)) {
            this.f7753a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (g.f(j6)) {
            ((d) this.b.get()).request(j6);
        }
    }
}
