package retrofit2;

import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: retrofit2.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1619q extends CompletableFuture {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1613k f8153a;

    public C1619q(InterfaceC1613k interfaceC1613k) {
        this.f8153a = interfaceC1613k;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        if (z6) {
            this.f8153a.cancel();
        }
        return super.cancel(z6);
    }
}
