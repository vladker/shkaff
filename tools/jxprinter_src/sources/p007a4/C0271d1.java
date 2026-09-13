package p007a4;

/* JADX INFO: renamed from: a4.d1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0271d1 implements InterfaceC0280h0, r {
    public static final C0271d1 INSTANCE = new C0271d1();

    @Override // p007a4.r
    public boolean childCancelled(Throwable th) {
        return false;
    }

    @Override // p007a4.r
    public H0 getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }

    @Override // p007a4.InterfaceC0280h0
    public final void dispose() {
    }
}
