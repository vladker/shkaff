package retrofit2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C extends kotlin.jvm.internal.F implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1613k f8093a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(InterfaceC1613k interfaceC1613k) {
        super(1);
        this.f8093a = interfaceC1613k;
    }

    @Override // O3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return p147z3.Q.INSTANCE;
    }

    public final void invoke(Throwable th) {
        this.f8093a.cancel();
    }
}
