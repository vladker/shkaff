package retrofit2;

import p007a4.C0289m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class H implements InterfaceC1616n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0289m f8098a;

    public H(C0289m c0289m) {
        this.f8098a = c0289m;
    }

    @Override // retrofit2.InterfaceC1616n
    public void onFailure(InterfaceC1613k<Object> call, Throwable t6) {
        kotlin.jvm.internal.E.f(call, "call");
        kotlin.jvm.internal.E.f(t6, "t");
        this.f8098a.resumeWith(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(t6)));
    }

    @Override // retrofit2.InterfaceC1616n
    public void onResponse(InterfaceC1613k<Object> call, r0<Object> response) {
        kotlin.jvm.internal.E.f(call, "call");
        kotlin.jvm.internal.E.f(response, "response");
        this.f8098a.resumeWith(p147z3.u.m1361constructorimpl(response));
    }
}
