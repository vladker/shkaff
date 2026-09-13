package g4;

import E3.q;
import java.util.concurrent.Executor;
import p007a4.AbstractC0309w0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class i extends AbstractC0309w0 {
    private d coroutineScheduler;
    private final String schedulerName;

    public i(int i5, int i6, long j6, String str) {
        this.schedulerName = str;
        this.coroutineScheduler = new d(i5, i6, j6, str);
    }

    public void close() throws InterruptedException {
        this.coroutineScheduler.close();
    }

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q qVar, Runnable runnable) {
        d.b(this.coroutineScheduler, runnable, 6);
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable runnable, boolean z6, boolean z7) {
        this.coroutineScheduler.dispatch(runnable, z6, z7);
    }

    @Override // p007a4.F
    public void dispatchYield(q qVar, Runnable runnable) {
        d.b(this.coroutineScheduler, runnable, 2);
    }

    @Override // p007a4.AbstractC0309w0
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }
}
