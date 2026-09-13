package p007a4;

/* JADX INFO: renamed from: a4.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0284j0 extends O0 {
    private final InterfaceC0280h0 handle;

    public C0284j0(InterfaceC0280h0 interfaceC0280h0) {
        this.handle = interfaceC0280h0;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return false;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        this.handle.dispose();
    }
}
