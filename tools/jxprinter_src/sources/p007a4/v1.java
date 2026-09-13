package p007a4;

import E3.g;
import p028e4.D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v1 extends D implements Runnable {
    public final long time;

    public v1(long j6, g<Object> gVar) {
        super(gVar.getContext(), gVar);
        this.time = j6;
    }

    @Override // p007a4.AbstractC0260a, p007a4.X0
    public String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core() + "(timeMillis=" + this.time + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        cancelCoroutine(x1.TimeoutCancellationException(this.time, AbstractC0261a0.getDelay(getContext()), this));
    }
}
