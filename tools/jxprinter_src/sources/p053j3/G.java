package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import p011b3.c;
import p017c3.d;
import p033f3.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G implements InterfaceC0679f, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5410a;
    public c b;
    public final /* synthetic */ H c;

    public G(H h6, InterfaceC0679f interfaceC0679f) {
        this.c = h6;
        this.f5410a = interfaceC0679f;
    }

    @Override // p011b3.c
    public final void dispose() {
        try {
            this.c.f5413g.run();
        } catch (Throwable th) {
            d.throwIfFatal(th);
            a.onError(th);
        }
        this.b.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.e();
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        InterfaceC0679f interfaceC0679f = this.f5410a;
        H h6 = this.c;
        if (this.b == p033f3.d.f3969a) {
            return;
        }
        try {
            h6.d.run();
            h6.e.run();
            interfaceC0679f.onComplete();
            try {
                h6.f5412f.run();
            } catch (Throwable th) {
                d.throwIfFatal(th);
                a.onError(th);
            }
        } catch (Throwable th2) {
            d.throwIfFatal(th2);
            interfaceC0679f.onError(th2);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        H h6 = this.c;
        if (this.b == p033f3.d.f3969a) {
            a.onError(th);
            return;
        }
        try {
            h6.c.accept(th);
            h6.e.run();
        } catch (Throwable th2) {
            d.throwIfFatal(th2);
            th = new p017c3.c(th, th2);
        }
        this.f5410a.onError(th);
        try {
            h6.f5412f.run();
        } catch (Throwable th3) {
            d.throwIfFatal(th3);
            a.onError(th3);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        InterfaceC0679f interfaceC0679f = this.f5410a;
        try {
            this.c.b.accept(cVar);
            if (p033f3.d.g(this.b, cVar)) {
                this.b = cVar;
                interfaceC0679f.onSubscribe(this);
            }
        } catch (Throwable th) {
            d.throwIfFatal(th);
            cVar.dispose();
            this.b = p033f3.d.f3969a;
            interfaceC0679f.onSubscribe(e.f3970a);
            interfaceC0679f.onError(th);
        }
    }
}
