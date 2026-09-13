package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: j3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0992c extends AtomicReference implements InterfaceC0679f, c {
    private static final long serialVersionUID = -4101678820158072998L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5428a;
    public final InterfaceC0682i b;

    public C0992c(InterfaceC0679f interfaceC0679f, InterfaceC0682i interfaceC0682i) {
        this.f5428a = interfaceC0679f;
        this.b = interfaceC0682i;
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
        ((AbstractC0676c) this.b).subscribe(new C0991b(this, this.f5428a, 0));
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5428a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5428a.onSubscribe(this);
        }
    }
}
