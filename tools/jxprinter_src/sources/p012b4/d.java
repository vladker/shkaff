package p012b4;

import E3.g;
import E3.q;
import p007a4.AbstractC0265b1;
import p007a4.InterfaceC0280h0;
import p007a4.InterfaceC0285k;
import p007a4.X;
import p007a4.Y;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends AbstractC0265b1 implements Y {
    @Override // p007a4.Y
    public Object delay(long j6, g<? super Q> gVar) {
        return X.delay(this, j6, gVar);
    }

    @Override // p007a4.AbstractC0265b1
    public abstract d getImmediate();

    public InterfaceC0280h0 invokeOnTimeout(long j6, Runnable runnable, q qVar) {
        return X.invokeOnTimeout(this, j6, runnable, qVar);
    }

    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public abstract /* synthetic */ void mo1036scheduleResumeAfterDelay(long j6, InterfaceC0285k interfaceC0285k);
}
