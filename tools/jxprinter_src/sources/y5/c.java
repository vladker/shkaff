package y5;

import io.reactivex.I;
import retrofit2.InterfaceC1613k;
import retrofit2.InterfaceC1616n;
import retrofit2.r0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class c implements p011b3.c, InterfaceC1616n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1613k f9046a;
    public final I b;
    public volatile boolean c;
    public boolean d = false;

    public c(InterfaceC1613k interfaceC1613k, I i5) {
        this.f9046a = interfaceC1613k;
        this.b = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c = true;
        this.f9046a.cancel();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c;
    }

    @Override // retrofit2.InterfaceC1616n
    public final void onFailure(InterfaceC1613k interfaceC1613k, Throwable th) {
        if (interfaceC1613k.d()) {
            return;
        }
        try {
            this.b.onError(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            io.reactivex.plugins.a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // retrofit2.InterfaceC1616n
    public final void onResponse(InterfaceC1613k interfaceC1613k, r0 r0Var) {
        if (this.c) {
            return;
        }
        try {
            this.b.onNext(r0Var);
            if (this.c) {
                return;
            }
            this.d = true;
            this.b.onComplete();
        } catch (Throwable th) {
            if (this.d) {
                io.reactivex.plugins.a.onError(th);
                return;
            }
            if (this.c) {
                return;
            }
            try {
                this.b.onError(th);
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                io.reactivex.plugins.a.onError(new p017c3.c(th, th2));
            }
        }
    }
}
