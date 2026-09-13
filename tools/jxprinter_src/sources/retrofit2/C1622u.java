package retrofit2;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: retrofit2.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1622u implements InterfaceC1613k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f8162a;
    public final InterfaceC1613k b;

    public C1622u(Executor executor, InterfaceC1613k interfaceC1613k) {
        this.f8162a = executor;
        this.b = interfaceC1613k;
    }

    @Override // retrofit2.InterfaceC1613k
    public final void b(InterfaceC1616n interfaceC1616n) {
        this.b.b(new xyz.doikki.videoplayer.player.k(this, interfaceC1616n, 8));
    }

    @Override // retrofit2.InterfaceC1613k
    public final okhttp3.M c() {
        return this.b.c();
    }

    @Override // retrofit2.InterfaceC1613k
    public final void cancel() {
        this.b.cancel();
    }

    @Override // retrofit2.InterfaceC1613k
    public final boolean d() {
        return this.b.d();
    }

    @Override // retrofit2.InterfaceC1613k
    public r0<Object> execute() {
        return this.b.execute();
    }

    @Override // retrofit2.InterfaceC1613k
    public final InterfaceC1613k clone() {
        return new C1622u(this.f8162a, this.b.clone());
    }
}
