package p007a4;

import kotlin.jvm.internal.E;
import p028e4.C0663q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class O0 extends C0663q implements InterfaceC0280h0, B0 {
    public X0 d;

    public abstract boolean d();

    @Override // p007a4.InterfaceC0280h0
    public final void dispose() {
        getJob().removeNode$kotlinx_coroutines_core(this);
    }

    public final X0 getJob() {
        X0 x6 = this.d;
        if (x6 != null) {
            return x6;
        }
        E.m("job");
        throw null;
    }

    @Override // p007a4.B0
    public C0268c1 getList() {
        return null;
    }

    public abstract void invoke(Throwable th);

    @Override // p007a4.B0
    public final boolean isActive() {
        return true;
    }

    public final void setJob(X0 x6) {
        this.d = x6;
    }

    @Override // p028e4.C0663q
    public String toString() {
        return S.getClassSimpleName(this) + '@' + S.getHexAddress(this) + "[job@" + S.getHexAddress(getJob()) + ']';
    }
}
