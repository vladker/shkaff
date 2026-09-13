package p007a4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: a4.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0313y0 {
    public static final Executor asExecutor(F f6) {
        Executor executor;
        AbstractC0309w0 abstractC0309w0 = f6 instanceof AbstractC0309w0 ? (AbstractC0309w0) f6 : null;
        return (abstractC0309w0 == null || (executor = abstractC0309w0.getExecutor()) == null) ? new ExecutorC0273e0(f6) : executor;
    }

    public static final AbstractC0309w0 from(ExecutorService executorService) {
        return new C0311x0(executorService);
    }

    public static final F from(Executor executor) {
        F f6;
        ExecutorC0273e0 executorC0273e0 = executor instanceof ExecutorC0273e0 ? (ExecutorC0273e0) executor : null;
        return (executorC0273e0 == null || (f6 = executorC0273e0.dispatcher) == null) ? new C0311x0(executor) : f6;
    }

    public static /* synthetic */ void CloseableCoroutineDispatcher$annotations() {
    }
}
