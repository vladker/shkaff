package p007a4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p028e4.C0660n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q0 extends O0 {
    private final C0300s child;
    private final X0 parent;
    private final Object proposedUpdate;
    private final R0 state;

    public Q0(X0 x6, R0 r6, C0300s c0300s, Object obj) {
        this.parent = x6;
        this.state = r6;
        this.child = c0300s;
        this.proposedUpdate = obj;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return false;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        X0 x6 = this.parent;
        R0 r6 = this.state;
        C0300s c0300s = this.child;
        Object obj = this.proposedUpdate;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X0.f949a;
        x6.getClass();
        C0300s c0300sM = X0.m(c0300s);
        if (c0300sM == null || !x6.u(r6, c0300sM, obj)) {
            C0268c1 list = r6.getList();
            list.getClass();
            list.addLast(new C0660n(2), 2);
            C0300s c0300sM2 = X0.m(c0300s);
            if (c0300sM2 == null || !x6.u(r6, c0300sM2, obj)) {
                x6.afterCompletion(x6.g(r6, obj));
            }
        }
    }
}
