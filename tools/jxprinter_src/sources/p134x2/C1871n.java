package p134x2;

import O3.l;
import kotlin.jvm.internal.F;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p147z3.Q;

/* JADX INFO: renamed from: x2.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1871n extends F implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M0 f8918a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1871n(M0 m6) {
        super(1);
        this.f8918a = m6;
    }

    @Override // O3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Q.INSTANCE;
    }

    public final void invoke(Throwable th) {
        if (th instanceof b1) {
            return;
        }
        O.INSTANCE.e("CurrentPrinter", "send data error", th);
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C1869m(this.f8918a, null));
    }
}
