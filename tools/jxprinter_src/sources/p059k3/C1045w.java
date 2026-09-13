package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: k3.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1045w extends AtomicReference implements InterfaceC0679f, c {
    private static final long serialVersionUID = 703409937383992161L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5586a;
    public final y b;

    public C1045w(InterfaceC0988v interfaceC0988v, y yVar) {
        this.f5586a = interfaceC0988v;
        this.b = yVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        ((AbstractC0985s) this.b).subscribe(new C1044v(0, this.f5586a, this));
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5586a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5586a.onSubscribe(this);
        }
    }
}
