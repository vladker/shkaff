package p018c4;

import O3.l;
import com.google.android.gms.tasks.CancellationTokenSource;
import kotlinx.coroutines.flow.internal.C1112a;
import p007a4.C0289m;
import p007a4.H0;
import p007a4.InterfaceC0310x;
import p007a4.X0;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1189a;
    public final /* synthetic */ Object b;

    public /* synthetic */ u0(Object obj, int i5) {
        this.f1189a = i5;
        this.b = obj;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f1189a) {
            case 0:
                C0289m c0289m = (C0289m) this.b;
                Q q6 = Q.INSTANCE;
                c0289m.resumeWith(u.m1361constructorimpl(q6));
                return q6;
            case 1:
                ((CancellationTokenSource) this.b).cancel();
                return Q.INSTANCE;
            default:
                H0 h1 = (InterfaceC0310x) this.b;
                if (((X0) h1).isActive()) {
                    h1.cancel(new C1112a(h1));
                }
                return Q.INSTANCE;
        }
    }
}
