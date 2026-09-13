package p007a4;

import E3.g;
import E3.q;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p147z3.Q;

/* JADX INFO: renamed from: a4.x0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0311x0 extends AbstractC0309w0 implements Y {
    private final Executor executor;

    public C0311x0(Executor executor) {
        this.executor = executor;
        if (getExecutor() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) getExecutor()).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = getExecutor();
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // p007a4.Y
    public Object delay(long j6, g<? super Q> gVar) {
        return X.delay(this, j6, gVar);
    }

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q qVar, Runnable runnable) {
        try {
            getExecutor().execute(runnable);
        } catch (RejectedExecutionException e) {
            K0.cancel(qVar, AbstractC0305u0.CancellationException("The task was rejected", e));
            C0276f0.getIO().mo1035dispatch(qVar, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0311x0) && ((C0311x0) obj).getExecutor() == getExecutor();
    }

    @Override // p007a4.AbstractC0309w0
    public Executor getExecutor() {
        return this.executor;
    }

    public final int hashCode() {
        return System.identityHashCode(getExecutor());
    }

    @Override // p007a4.Y
    public InterfaceC0280h0 invokeOnTimeout(long j6, Runnable runnable, q qVar) {
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j6, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                K0.cancel(qVar, AbstractC0305u0.CancellationException("The task was rejected", e));
            }
        }
        return scheduledFutureSchedule != null ? new C0278g0(scheduledFutureSchedule) : T.INSTANCE.invokeOnTimeout(j6, runnable, qVar);
    }

    @Override // p007a4.Y
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo1036scheduleResumeAfterDelay(long j6, InterfaceC0285k interfaceC0285k) {
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            j1 j1Var = new j1(this, interfaceC0285k);
            q context = interfaceC0285k.getContext();
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(j1Var, j6, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                K0.cancel(context, AbstractC0305u0.CancellationException("The task was rejected", e));
            }
        }
        if (scheduledFutureSchedule != null) {
            AbstractC0293o.invokeOnCancellation(interfaceC0285k, new C0279h(scheduledFutureSchedule));
        } else {
            T.INSTANCE.mo1036scheduleResumeAfterDelay(j6, interfaceC0285k);
        }
    }

    @Override // p007a4.F
    public String toString() {
        return getExecutor().toString();
    }
}
