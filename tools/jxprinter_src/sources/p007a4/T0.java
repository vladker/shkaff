package p007a4;

import p044h4.o;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T0 extends O0 {
    public final /* synthetic */ X0 e;
    private final o select;

    public T0(X0 x6, o oVar) {
        this.e = x6;
        this.select = oVar;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return false;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        this.select.trySelect(this.e, Q.INSTANCE);
    }
}
