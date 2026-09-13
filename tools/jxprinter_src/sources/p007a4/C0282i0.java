package p007a4;

/* JADX INFO: renamed from: a4.i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0282i0 implements InterfaceC0283j {
    private final InterfaceC0280h0 handle;

    public C0282i0(InterfaceC0280h0 interfaceC0280h0) {
        this.handle = interfaceC0280h0;
    }

    @Override // p007a4.InterfaceC0283j
    public void invoke(Throwable th) {
        this.handle.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.handle + ']';
    }
}
