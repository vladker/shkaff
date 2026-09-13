package io.reactivex.plugins;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.B;
import io.reactivex.I;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0988v;
import io.reactivex.N;
import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.internal.schedulers.C0966e;
import io.reactivex.internal.schedulers.K;
import io.reactivex.internal.schedulers.r;
import io.reactivex.internal.schedulers.s;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import p017c3.f;
import p017c3.h;
import p027e3.c;
import p027e3.e;
import p027e3.g;
import p027e3.o;
import p039g3.A;
import p117u3.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    static volatile g errorHandler;
    static volatile e onBeforeBlocking;
    static volatile o onCompletableAssembly;
    static volatile c onCompletableSubscribe;
    static volatile o onComputationHandler;
    static volatile o onConnectableFlowableAssembly;
    static volatile o onConnectableObservableAssembly;
    static volatile o onFlowableAssembly;
    static volatile c onFlowableSubscribe;
    static volatile o onInitComputationHandler;
    static volatile o onInitIoHandler;
    static volatile o onInitNewThreadHandler;
    static volatile o onInitSingleHandler;
    static volatile o onIoHandler;
    static volatile o onMaybeAssembly;
    static volatile c onMaybeSubscribe;
    static volatile o onNewThreadHandler;
    static volatile o onObservableAssembly;
    static volatile c onObservableSubscribe;
    static volatile o onParallelAssembly;
    static volatile o onScheduleHandler;
    static volatile o onSingleAssembly;
    static volatile o onSingleHandler;
    static volatile c onSingleSubscribe;

    public static <T, R> R apply(o oVar, T t6) {
        try {
            return (R) oVar.apply(t6);
        } catch (Throwable th) {
            throw p100r3.g.d(th);
        }
    }

    public static N applyRequireNonNull(o oVar, Callable<N> callable) {
        Object objApply = apply(oVar, callable);
        A.b(objApply, "Scheduler Callable result can't be null");
        return (N) objApply;
    }

    public static N callRequireNonNull(Callable<N> callable) {
        try {
            N nCall = callable.call();
            A.b(nCall, "Scheduler Callable result can't be null");
            return nCall;
        } catch (Throwable th) {
            throw p100r3.g.d(th);
        }
    }

    public static N createComputationScheduler(ThreadFactory threadFactory) {
        A.b(threadFactory, "threadFactory is null");
        return new C0966e(threadFactory);
    }

    public static N createIoScheduler(ThreadFactory threadFactory) {
        A.b(threadFactory, "threadFactory is null");
        return new r(threadFactory);
    }

    public static N createNewThreadScheduler(ThreadFactory threadFactory) {
        A.b(threadFactory, "threadFactory is null");
        return new s(threadFactory);
    }

    public static N createSingleScheduler(ThreadFactory threadFactory) {
        A.b(threadFactory, "threadFactory is null");
        return new K(threadFactory);
    }

    public static o getComputationSchedulerHandler() {
        return onComputationHandler;
    }

    public static g getErrorHandler() {
        return errorHandler;
    }

    public static o getInitComputationSchedulerHandler() {
        return onInitComputationHandler;
    }

    public static o getInitIoSchedulerHandler() {
        return onInitIoHandler;
    }

    public static o getInitNewThreadSchedulerHandler() {
        return onInitNewThreadHandler;
    }

    public static o getInitSingleSchedulerHandler() {
        return onInitSingleHandler;
    }

    public static o getIoSchedulerHandler() {
        return onIoHandler;
    }

    public static o getNewThreadSchedulerHandler() {
        return onNewThreadHandler;
    }

    public static e getOnBeforeBlocking() {
        return onBeforeBlocking;
    }

    public static o getOnCompletableAssembly() {
        return onCompletableAssembly;
    }

    public static c getOnCompletableSubscribe() {
        return onCompletableSubscribe;
    }

    public static o getOnConnectableFlowableAssembly() {
        return onConnectableFlowableAssembly;
    }

    public static o getOnConnectableObservableAssembly() {
        return onConnectableObservableAssembly;
    }

    public static o getOnFlowableAssembly() {
        return onFlowableAssembly;
    }

    public static c getOnFlowableSubscribe() {
        return onFlowableSubscribe;
    }

    public static o getOnMaybeAssembly() {
        return onMaybeAssembly;
    }

    public static c getOnMaybeSubscribe() {
        return onMaybeSubscribe;
    }

    public static o getOnObservableAssembly() {
        return onObservableAssembly;
    }

    public static c getOnObservableSubscribe() {
        return onObservableSubscribe;
    }

    public static o getOnParallelAssembly() {
        return onParallelAssembly;
    }

    public static o getOnSingleAssembly() {
        return onSingleAssembly;
    }

    public static c getOnSingleSubscribe() {
        return onSingleSubscribe;
    }

    public static o getScheduleHandler() {
        return onScheduleHandler;
    }

    public static o getSingleSchedulerHandler() {
        return onSingleHandler;
    }

    public static N initComputationScheduler(Callable<N> callable) {
        A.b(callable, "Scheduler Callable can't be null");
        o oVar = onInitComputationHandler;
        return oVar == null ? callRequireNonNull(callable) : applyRequireNonNull(oVar, callable);
    }

    public static N initIoScheduler(Callable<N> callable) {
        A.b(callable, "Scheduler Callable can't be null");
        o oVar = onInitIoHandler;
        return oVar == null ? callRequireNonNull(callable) : applyRequireNonNull(oVar, callable);
    }

    public static N initNewThreadScheduler(Callable<N> callable) {
        A.b(callable, "Scheduler Callable can't be null");
        o oVar = onInitNewThreadHandler;
        return oVar == null ? callRequireNonNull(callable) : applyRequireNonNull(oVar, callable);
    }

    public static N initSingleScheduler(Callable<N> callable) {
        A.b(callable, "Scheduler Callable can't be null");
        o oVar = onInitSingleHandler;
        return oVar == null ? callRequireNonNull(callable) : applyRequireNonNull(oVar, callable);
    }

    public static <T> AbstractC0985s onAssembly(AbstractC0985s abstractC0985s) {
        o oVar = onMaybeAssembly;
        return oVar != null ? (AbstractC0985s) apply(oVar, abstractC0985s) : abstractC0985s;
    }

    public static N onComputationScheduler(N n6) {
        o oVar = onComputationHandler;
        return oVar == null ? n6 : (N) apply(oVar, n6);
    }

    public static void onError(Throwable th) {
        g gVar = errorHandler;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!(th instanceof f) && !(th instanceof p017c3.e) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof p017c3.c)) {
            th = new h(androidx.exifinterface.media.a.n("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | ", th), th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                uncaught(th2);
            }
        }
        th.printStackTrace();
        uncaught(th);
    }

    public static N onIoScheduler(N n6) {
        o oVar = onIoHandler;
        return oVar == null ? n6 : (N) apply(oVar, n6);
    }

    public static N onNewThreadScheduler(N n6) {
        o oVar = onNewThreadHandler;
        return oVar == null ? n6 : (N) apply(oVar, n6);
    }

    public static Runnable onSchedule(Runnable runnable) {
        A.b(runnable, "run is null");
        o oVar = onScheduleHandler;
        return oVar == null ? runnable : (Runnable) apply(oVar, runnable);
    }

    public static N onSingleScheduler(N n6) {
        o oVar = onSingleHandler;
        return oVar == null ? n6 : (N) apply(oVar, n6);
    }

    public static <T> t5.c onSubscribe(AbstractC0979l abstractC0979l, t5.c cVar) {
        c cVar2 = onFlowableSubscribe;
        return cVar2 != null ? (t5.c) apply(cVar2, abstractC0979l, cVar) : cVar;
    }

    public static void setComputationSchedulerHandler(o oVar) {
        onComputationHandler = oVar;
    }

    public static void setErrorHandler(g gVar) {
        errorHandler = gVar;
    }

    public static void setInitComputationSchedulerHandler(o oVar) {
        onInitComputationHandler = oVar;
    }

    public static void setInitIoSchedulerHandler(o oVar) {
        onInitIoHandler = oVar;
    }

    public static void setInitNewThreadSchedulerHandler(o oVar) {
        onInitNewThreadHandler = oVar;
    }

    public static void setInitSingleSchedulerHandler(o oVar) {
        onInitSingleHandler = oVar;
    }

    public static void setIoSchedulerHandler(o oVar) {
        onIoHandler = oVar;
    }

    public static void setNewThreadSchedulerHandler(o oVar) {
        onNewThreadHandler = oVar;
    }

    public static void setOnBeforeBlocking(e eVar) {
        onBeforeBlocking = eVar;
    }

    public static void setOnCompletableAssembly(o oVar) {
        onCompletableAssembly = oVar;
    }

    public static void setOnCompletableSubscribe(c cVar) {
        onCompletableSubscribe = cVar;
    }

    public static void setOnConnectableFlowableAssembly(o oVar) {
        onConnectableFlowableAssembly = oVar;
    }

    public static void setOnConnectableObservableAssembly(o oVar) {
        onConnectableObservableAssembly = oVar;
    }

    public static void setOnFlowableAssembly(o oVar) {
        onFlowableAssembly = oVar;
    }

    public static void setOnFlowableSubscribe(c cVar) {
        onFlowableSubscribe = cVar;
    }

    public static void setOnMaybeAssembly(o oVar) {
        onMaybeAssembly = oVar;
    }

    public static void setOnMaybeSubscribe(c cVar) {
        onMaybeSubscribe = cVar;
    }

    public static void setOnObservableAssembly(o oVar) {
        onObservableAssembly = oVar;
    }

    public static void setOnObservableSubscribe(c cVar) {
        onObservableSubscribe = cVar;
    }

    public static void setOnParallelAssembly(o oVar) {
        onParallelAssembly = oVar;
    }

    public static void setOnSingleAssembly(o oVar) {
        onSingleAssembly = oVar;
    }

    public static void setOnSingleSubscribe(c cVar) {
        onSingleSubscribe = cVar;
    }

    public static void setScheduleHandler(o oVar) {
        onScheduleHandler = oVar;
    }

    public static void setSingleSchedulerHandler(o oVar) {
        onSingleHandler = oVar;
    }

    public static void uncaught(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static <T, U, R> R apply(c cVar, T t6, U u6) {
        try {
            return (R) cVar.apply(t6, u6);
        } catch (Throwable th) {
            throw p100r3.g.d(th);
        }
    }

    public static <T> AbstractC0979l onAssembly(AbstractC0979l abstractC0979l) {
        o oVar = onFlowableAssembly;
        return oVar != null ? (AbstractC0979l) apply(oVar, abstractC0979l) : abstractC0979l;
    }

    public static <T> I onSubscribe(B<T> b, I i5) {
        c cVar = onObservableSubscribe;
        return cVar != null ? (I) apply(cVar, b, i5) : i5;
    }

    public static <T> p022d3.a onAssembly(p022d3.a aVar) {
        o oVar = onConnectableFlowableAssembly;
        return oVar != null ? (p022d3.a) apply(oVar, aVar) : aVar;
    }

    public static <T> S onSubscribe(O o6, S s6) {
        c cVar = onSingleSubscribe;
        return cVar != null ? (S) apply(cVar, o6, s6) : s6;
    }

    public static <T> B<T> onAssembly(B<T> b) {
        o oVar = onObservableAssembly;
        return oVar != null ? (B) apply(oVar, b) : b;
    }

    public static InterfaceC0679f onSubscribe(AbstractC0676c abstractC0676c, InterfaceC0679f interfaceC0679f) {
        c cVar = onCompletableSubscribe;
        return cVar != null ? (InterfaceC0679f) apply(cVar, abstractC0676c, interfaceC0679f) : interfaceC0679f;
    }

    public static <T> p106s3.a onAssembly(p106s3.a aVar) {
        o oVar = onConnectableObservableAssembly;
        return oVar != null ? (p106s3.a) apply(oVar, aVar) : aVar;
    }

    public static <T> InterfaceC0988v onSubscribe(AbstractC0985s abstractC0985s, InterfaceC0988v interfaceC0988v) {
        c cVar = onMaybeSubscribe;
        return cVar != null ? (InterfaceC0988v) apply(cVar, abstractC0985s, interfaceC0988v) : interfaceC0988v;
    }

    public static <T> O onAssembly(O o6) {
        o oVar = onSingleAssembly;
        return oVar != null ? (O) apply(oVar, o6) : o6;
    }

    public static AbstractC0676c onAssembly(AbstractC0676c abstractC0676c) {
        o oVar = onCompletableAssembly;
        return oVar != null ? (AbstractC0676c) apply(oVar, abstractC0676c) : abstractC0676c;
    }

    public static <T> b onAssembly(b bVar) {
        o oVar = onParallelAssembly;
        return oVar != null ? (b) apply(oVar, bVar) : bVar;
    }
}
