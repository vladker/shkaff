package g4;

import E3.q;
import E3.r;
import java.util.concurrent.Executor;
import p007a4.AbstractC0309w0;
import p007a4.F;
import p028e4.I;
import p028e4.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends AbstractC0309w0 implements Executor {
    public static final e INSTANCE = new e();

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final F f2default;

    static {
        n nVar = n.INSTANCE;
        int i5 = J.f3936a;
        if (64 >= i5) {
            i5 = 64;
        }
        f2default = F.limitedParallelism$default(nVar, I.systemProp("kotlinx.coroutines.io.parallelism", i5, 1, (8 & 8) != 0 ? Integer.MAX_VALUE : 2097150), null, 2, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q qVar, Runnable runnable) {
        f2default.mo1035dispatch(qVar, runnable);
    }

    @Override // p007a4.F
    public void dispatchYield(q qVar, Runnable runnable) {
        f2default.dispatchYield(qVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        mo1035dispatch(r.INSTANCE, runnable);
    }

    @Override // p007a4.F
    public F limitedParallelism(int i5, String str) {
        return n.INSTANCE.limitedParallelism(i5, str);
    }

    @Override // p007a4.F
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // p007a4.AbstractC0309w0
    public Executor getExecutor() {
        return this;
    }
}
