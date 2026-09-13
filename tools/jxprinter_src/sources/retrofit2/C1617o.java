package retrofit2;

/* JADX INFO: renamed from: retrofit2.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1617o implements InterfaceC1616n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8132a;
    public final C1619q b;

    public /* synthetic */ C1617o(C1619q c1619q, int i5) {
        this.f8132a = i5;
        this.b = c1619q;
    }

    @Override // retrofit2.InterfaceC1616n
    public final void onFailure(InterfaceC1613k interfaceC1613k, Throwable th) {
        switch (this.f8132a) {
            case 0:
                this.b.completeExceptionally(th);
                break;
            default:
                this.b.completeExceptionally(th);
                break;
        }
    }

    @Override // retrofit2.InterfaceC1616n
    public final void onResponse(InterfaceC1613k interfaceC1613k, r0 r0Var) {
        switch (this.f8132a) {
            case 0:
                boolean zA = r0Var.f8159a.a();
                C1619q c1619q = this.b;
                if (!zA) {
                    c1619q.completeExceptionally(new C1625x(r0Var));
                } else {
                    c1619q.complete(r0Var.body());
                }
                break;
            default:
                this.b.complete(r0Var);
                break;
        }
    }
}
