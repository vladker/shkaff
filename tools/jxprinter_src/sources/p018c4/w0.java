package p018c4;

import E3.q;
import p007a4.J;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends C0392w implements x0 {
    public w0(q qVar, InterfaceC0391v interfaceC0391v) {
        super(qVar, interfaceC0391v, true, true);
    }

    @Override // p007a4.AbstractC0260a
    public void onCancelled(Throwable th, boolean z6) {
        if (get_channel().close(th) || z6) {
            return;
        }
        J.handleCoroutineException(getContext(), th);
    }

    @Override // p007a4.AbstractC0260a
    /* JADX INFO: renamed from: onCompleted, reason: merged with bridge method [inline-methods] */
    public void v(Q q6) {
        get_channel().close(null);
    }
}
