package p007a4;

import O3.l;

/* JADX INFO: renamed from: a4.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0281i implements InterfaceC0283j {
    private final l handler;

    public C0281i(l lVar) {
        this.handler = lVar;
    }

    @Override // p007a4.InterfaceC0283j
    public void invoke(Throwable th) {
        this.handler.invoke(th);
    }

    public String toString() {
        return "CancelHandler.UserSupplied[" + S.getClassSimpleName(this.handler) + '@' + S.getHexAddress(this) + ']';
    }
}
