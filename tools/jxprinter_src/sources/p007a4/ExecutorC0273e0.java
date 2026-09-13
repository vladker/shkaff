package p007a4;

import E3.r;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: a4.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutorC0273e0 implements Executor {
    public final F dispatcher;

    public ExecutorC0273e0(F f6) {
        this.dispatcher = f6;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        F f6 = this.dispatcher;
        r rVar = r.INSTANCE;
        if (f6.isDispatchNeeded(rVar)) {
            this.dispatcher.mo1035dispatch(rVar, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.dispatcher.toString();
    }
}
