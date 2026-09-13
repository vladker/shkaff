package p065l3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.g;
import t5.b;
import t5.c;
import t5.d;

/* JADX INFO: renamed from: l3.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1151b extends AtomicReference implements InterfaceC0984q, InterfaceC0679f, d {
    private static final long serialVersionUID = -8948264376121066672L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5819a;
    public b b;
    public p011b3.c c;
    public final AtomicLong d = new AtomicLong();

    public C1151b(c cVar, b bVar) {
        this.f5819a = cVar;
        this.b = bVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.dispose();
        g.a(this);
    }

    @Override // t5.c
    public final void onComplete() {
        b bVar = this.b;
        if (bVar == null) {
            this.f5819a.onComplete();
        } else {
            this.b = null;
            bVar.subscribe(this);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f5819a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f5819a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5819a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        g.b(this, this.d, j6);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        g.c(this, this.d, dVar);
    }
}
