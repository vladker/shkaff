package p054j4;

import A3.C0130a;
import E3.g;
import F3.h;
import F3.i;
import O3.l;
import Y2.a;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import p007a4.AbstractC0308w;
import p007a4.C0289m;
import p007a4.C0306v;
import p007a4.H0;
import p007a4.InterfaceC0304u;
import p007a4.V;
import p018c4.u0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final c a(Task task, CancellationTokenSource cancellationTokenSource) {
        InterfaceC0304u interfaceC0304uCompletableDeferred = AbstractC0308w.CompletableDeferred((H0) null);
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception != null) {
                interfaceC0304uCompletableDeferred.completeExceptionally(exception);
            } else if (task.isCanceled()) {
                interfaceC0304uCompletableDeferred.cancel((CancellationException) null);
            } else {
                ((C0306v) interfaceC0304uCompletableDeferred).makeCompleting$kotlinx_coroutines_core(task.getResult());
            }
        } else {
            task.addOnCompleteListener(a.INSTANCE, new a(interfaceC0304uCompletableDeferred, 21));
        }
        if (cancellationTokenSource != null) {
            interfaceC0304uCompletableDeferred.invokeOnCompletion(new C0130a(cancellationTokenSource, 13));
        }
        return new c(interfaceC0304uCompletableDeferred);
    }

    public static final <T> V asDeferred(Task<T> task) {
        return a(task, null);
    }

    public static final <T> Task<T> asTask(final V v6) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        v6.invokeOnCompletion(new l() { // from class: j4.b
            @Override // O3.l
            public final Object invoke(Object obj) {
                if (((Throwable) obj) instanceof CancellationException) {
                    cancellationTokenSource.cancel();
                    return Q.INSTANCE;
                }
                V v7 = v6;
                Throwable completionExceptionOrNull = v7.getCompletionExceptionOrNull();
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (completionExceptionOrNull == null) {
                    taskCompletionSource2.setResult(v7.getCompleted());
                } else {
                    Exception runtimeExecutionException = completionExceptionOrNull instanceof Exception ? (Exception) completionExceptionOrNull : null;
                    if (runtimeExecutionException == null) {
                        runtimeExecutionException = new RuntimeExecutionException(completionExceptionOrNull);
                    }
                    taskCompletionSource2.setException(runtimeExecutionException);
                }
                return Q.INSTANCE;
            }
        });
        return taskCompletionSource.getTask();
    }

    public static final <T> Object await(Task<T> task, g<? super T> gVar) {
        return b(task, null, gVar);
    }

    public static final Object b(Task task, CancellationTokenSource cancellationTokenSource, g gVar) throws Exception {
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception != null) {
                throw exception;
            }
            if (!task.isCanceled()) {
                return task.getResult();
            }
            throw new CancellationException("Task " + task + " was cancelled normally.");
        }
        C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
        c0289m.initCancellability();
        task.addOnCompleteListener(a.INSTANCE, new S4.h(c0289m, 12));
        if (cancellationTokenSource != null) {
            c0289m.invokeOnCancellation(new u0(cancellationTokenSource, 1));
        }
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result;
    }

    public static final <T> V asDeferred(Task<T> task, CancellationTokenSource cancellationTokenSource) {
        return a(task, cancellationTokenSource);
    }

    public static final <T> Object await(Task<T> task, CancellationTokenSource cancellationTokenSource, g<? super T> gVar) {
        return b(task, cancellationTokenSource, gVar);
    }
}
