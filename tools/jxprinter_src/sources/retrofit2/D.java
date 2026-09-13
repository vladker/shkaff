package retrofit2;

import p007a4.C0289m;
import p147z3.C1930j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class D implements InterfaceC1616n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0289m f8094a;

    public D(C0289m c0289m) {
        this.f8094a = c0289m;
    }

    @Override // retrofit2.InterfaceC1616n
    public void onFailure(InterfaceC1613k<Object> call, Throwable t6) {
        kotlin.jvm.internal.E.f(call, "call");
        kotlin.jvm.internal.E.f(t6, "t");
        this.f8094a.resumeWith(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(t6)));
    }

    @Override // retrofit2.InterfaceC1616n
    public void onResponse(InterfaceC1613k<Object> call, r0<Object> response) {
        kotlin.jvm.internal.E.f(call, "call");
        kotlin.jvm.internal.E.f(response, "response");
        boolean zA = response.f8159a.a();
        C0289m c0289m = this.f8094a;
        if (!zA) {
            c0289m.resumeWith(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new C1625x(response))));
            return;
        }
        Object objBody = response.body();
        if (objBody != null) {
            c0289m.resumeWith(p147z3.u.m1361constructorimpl(objBody));
            return;
        }
        Object objTag = call.c().tag(B.class);
        kotlin.jvm.internal.E.c(objTag);
        B b = (B) objTag;
        c0289m.resumeWith(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new C1930j("Response from " + b.f8091a.getName() + '.' + b.b.getName() + " was null but response body type was declared as non-null"))));
    }
}
