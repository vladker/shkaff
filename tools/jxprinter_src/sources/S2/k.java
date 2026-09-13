package S2;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.T;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f640a;
    public final /* synthetic */ T b;

    public /* synthetic */ k(int i5, T t6) {
        this.f640a = i5;
        this.b = t6;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f640a) {
            case 0:
                U2.f updateRequest = (U2.f) obj;
                E.f(updateRequest, "$this$updateRequest");
                Exception exc = (Exception) this.b.f5689a;
                return U2.f.a(updateRequest, null, exc != null ? exc.toString() : null, 15);
            default:
                p089p4.m it = (p089p4.m) obj;
                E.f(it, "it");
                this.b.f5689a = it;
                return Q.INSTANCE;
        }
    }
}
