package p007a4;

/* JADX INFO: renamed from: a4.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0300s extends O0 implements r {
    public final InterfaceC0302t childJob;

    public C0300s(InterfaceC0302t interfaceC0302t) {
        this.childJob = interfaceC0302t;
    }

    @Override // p007a4.r
    public boolean childCancelled(Throwable th) {
        return getJob().childCancelled(th);
    }

    @Override // p007a4.O0
    public final boolean d() {
        return true;
    }

    @Override // p007a4.r
    public H0 getParent() {
        return getJob();
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        this.childJob.parentCancelled(getJob());
    }
}
