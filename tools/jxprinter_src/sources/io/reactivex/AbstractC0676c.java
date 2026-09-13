package io.reactivex;

import io.reactivex.internal.operators.flowable.C0771o3;
import io.reactivex.internal.operators.flowable.C0779q;
import io.reactivex.internal.operators.flowable.C0805u2;
import io.reactivex.internal.operators.flowable.C0817w2;
import io.reactivex.internal.operators.flowable.C0834z1;
import io.reactivex.internal.operators.observable.C0851c2;
import io.reactivex.internal.operators.observable.C0898m;
import io.reactivex.internal.operators.observable.T0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p053j3.C0993d;
import p053j3.C0995f;
import p053j3.C0998i;
import p053j3.C1000k;
import p053j3.C1002m;
import p053j3.C1004o;
import p053j3.C1006q;
import p053j3.C1007s;
import p053j3.C1009u;
import p059k3.C1013b0;

/* JADX INFO: renamed from: io.reactivex.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0676c implements InterfaceC0682i {
    public static AbstractC0676c amb(Iterable<? extends InterfaceC0682i> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.schedulers.B(null, iterable, 1));
    }

    public static AbstractC0676c ambArray(InterfaceC0682i... interfaceC0682iArr) {
        p039g3.A.b(interfaceC0682iArr, "sources is null");
        if (interfaceC0682iArr.length == 0) {
            return complete();
        }
        return interfaceC0682iArr.length == 1 ? wrap(interfaceC0682iArr[0]) : io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.schedulers.B(interfaceC0682iArr, null, 1));
    }

    public static AbstractC0676c complete() {
        return io.reactivex.plugins.a.onAssembly(p053j3.w.b);
    }

    public static AbstractC0676c concat(Iterable<? extends InterfaceC0682i> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C1002m(iterable, 0));
    }

    public static AbstractC0676c concatArray(InterfaceC0682i... interfaceC0682iArr) {
        p039g3.A.b(interfaceC0682iArr, "sources is null");
        if (interfaceC0682iArr.length == 0) {
            return complete();
        }
        return interfaceC0682iArr.length == 1 ? wrap(interfaceC0682iArr[0]) : io.reactivex.plugins.a.onAssembly(new C1000k(interfaceC0682iArr, 0));
    }

    public static AbstractC0676c create(InterfaceC0680g interfaceC0680g) {
        p039g3.A.b(interfaceC0680g, "source is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.w(2));
    }

    public static AbstractC0676c defer(Callable<? extends InterfaceC0682i> callable) {
        p039g3.A.b(callable, "completableSupplier");
        return io.reactivex.plugins.a.onAssembly(new C1004o(callable, 0));
    }

    private AbstractC0676c doOnLifecycle(p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar, p027e3.a aVar2, p027e3.a aVar3, p027e3.a aVar4) {
        p039g3.A.b(gVar, "onSubscribe is null");
        p039g3.A.b(gVar2, "onError is null");
        p039g3.A.b(aVar, "onComplete is null");
        p039g3.A.b(aVar2, "onTerminate is null");
        p039g3.A.b(aVar3, "onAfterTerminate is null");
        p039g3.A.b(aVar4, "onDispose is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.H(this, gVar, gVar2, aVar, aVar2, aVar3, aVar4));
    }

    public static AbstractC0676c error(Callable<? extends Throwable> callable) {
        p039g3.A.b(callable, "errorSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C1004o(callable, 1));
    }

    public static AbstractC0676c fromAction(p027e3.a aVar) {
        p039g3.A.b(aVar, "run is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(aVar, 1));
    }

    public static AbstractC0676c fromCallable(Callable<?> callable) {
        p039g3.A.b(callable, "callable is null");
        return io.reactivex.plugins.a.onAssembly(new C1004o(callable, 2));
    }

    public static AbstractC0676c fromFuture(Future<?> future) {
        p039g3.A.b(future, "future is null");
        return fromAction(new p039g3.k(future));
    }

    public static <T> AbstractC0676c fromMaybe(y yVar) {
        p039g3.A.b(yVar, "maybe is null");
        return io.reactivex.plugins.a.onAssembly(new C1013b0(yVar));
    }

    public static <T> AbstractC0676c fromObservable(G g6) {
        p039g3.A.b(g6, "observable is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(g6, 2));
    }

    public static <T> AbstractC0676c fromPublisher(t5.b bVar) {
        p039g3.A.b(bVar, "publisher is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(bVar, 3));
    }

    public static AbstractC0676c fromRunnable(Runnable runnable) {
        p039g3.A.b(runnable, "run is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(runnable, 4));
    }

    public static <T> AbstractC0676c fromSingle(V v6) {
        p039g3.A.b(v6, "single is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(v6, 5));
    }

    public static AbstractC0676c merge(Iterable<? extends InterfaceC0682i> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C1002m(iterable, 2));
    }

    private static AbstractC0676c merge0(t5.b bVar, int i5, boolean z6) {
        p039g3.A.b(bVar, "sources is null");
        p039g3.A.c(i5, "maxConcurrency");
        return io.reactivex.plugins.a.onAssembly(new p053j3.C(bVar, i5, z6));
    }

    public static AbstractC0676c mergeArray(InterfaceC0682i... interfaceC0682iArr) {
        p039g3.A.b(interfaceC0682iArr, "sources is null");
        if (interfaceC0682iArr.length == 0) {
            return complete();
        }
        return interfaceC0682iArr.length == 1 ? wrap(interfaceC0682iArr[0]) : io.reactivex.plugins.a.onAssembly(new C1000k(interfaceC0682iArr, 1));
    }

    public static AbstractC0676c mergeArrayDelayError(InterfaceC0682i... interfaceC0682iArr) {
        p039g3.A.b(interfaceC0682iArr, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C1000k(interfaceC0682iArr, 2));
    }

    public static AbstractC0676c mergeDelayError(Iterable<? extends InterfaceC0682i> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C1002m(iterable, 1));
    }

    public static AbstractC0676c never() {
        return io.reactivex.plugins.a.onAssembly(p053j3.w.c);
    }

    private AbstractC0676c timeout0(long j6, TimeUnit timeUnit, N n6, InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.O(this, j6, timeUnit, n6, interfaceC0682i));
    }

    public static AbstractC0676c timer(long j6, TimeUnit timeUnit) {
        return timer(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public static AbstractC0676c unsafeCreate(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "source is null");
        if (interfaceC0682i instanceof AbstractC0676c) {
            throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
        }
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(interfaceC0682i, 6));
    }

    public static <R> AbstractC0676c using(Callable<R> callable, p027e3.o oVar, p027e3.g gVar) {
        return using(callable, oVar, gVar, true);
    }

    public static AbstractC0676c wrap(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "source is null");
        return interfaceC0682i instanceof AbstractC0676c ? io.reactivex.plugins.a.onAssembly((AbstractC0676c) interfaceC0682i) : io.reactivex.plugins.a.onAssembly(new p053j3.x(interfaceC0682i, 6));
    }

    public final AbstractC0676c ambWith(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return ambArray(this, interfaceC0682i);
    }

    public final <T> B<T> andThen(G g6) {
        p039g3.A.b(g6, "next is null");
        return io.reactivex.plugins.a.onAssembly(new C0898m(this, g6, 4));
    }

    public final <R> R as(InterfaceC0677d interfaceC0677d) {
        p039g3.A.b(interfaceC0677d, "converter is null");
        throw new ClassCastException();
    }

    public final void blockingAwait() {
        p048i3.g gVar = new p048i3.g(1);
        subscribe(gVar);
        gVar.a();
    }

    public final Throwable blockingGet() {
        p048i3.g gVar = new p048i3.g(1);
        subscribe(gVar);
        if (gVar.getCount() != 0) {
            try {
                gVar.await();
            } catch (InterruptedException e) {
                gVar.b();
                return e;
            }
        }
        return gVar.b;
    }

    public final AbstractC0676c cache() {
        return io.reactivex.plugins.a.onAssembly(new C0995f(this));
    }

    public final AbstractC0676c compose(InterfaceC0977j interfaceC0977j) {
        p039g3.A.b(interfaceC0977j, "transformer is null");
        throw new ClassCastException();
    }

    public final AbstractC0676c concatWith(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C0993d(this, interfaceC0682i, 0));
    }

    public abstract void d(InterfaceC0679f interfaceC0679f);

    public final AbstractC0676c delay(long j6, TimeUnit timeUnit) {
        return delay(j6, timeUnit, io.reactivex.schedulers.j.computation(), false);
    }

    public final AbstractC0676c delaySubscription(long j6, TimeUnit timeUnit) {
        return delaySubscription(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final AbstractC0676c doAfterTerminate(p027e3.a aVar) {
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return doOnLifecycle(bVar, bVar, hVar, hVar, aVar, hVar);
    }

    public final AbstractC0676c doFinally(p027e3.a aVar) {
        p039g3.A.b(aVar, "onFinally is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.schedulers.B(this, aVar, 2));
    }

    public final AbstractC0676c doOnComplete(p027e3.a aVar) {
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return doOnLifecycle(bVar, bVar, aVar, hVar, hVar, hVar);
    }

    public final AbstractC0676c doOnDispose(p027e3.a aVar) {
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return doOnLifecycle(bVar, bVar, hVar, hVar, hVar, aVar);
    }

    public final AbstractC0676c doOnError(p027e3.g gVar) {
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return doOnLifecycle(bVar, gVar, hVar, hVar, hVar, hVar);
    }

    public final AbstractC0676c doOnEvent(p027e3.g gVar) {
        p039g3.A.b(gVar, "onEvent is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.schedulers.B(this, gVar, 3));
    }

    public final AbstractC0676c doOnSubscribe(p027e3.g gVar) {
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return doOnLifecycle(gVar, bVar, hVar, hVar, hVar, hVar);
    }

    public final AbstractC0676c doOnTerminate(p027e3.a aVar) {
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return doOnLifecycle(bVar, bVar, hVar, aVar, hVar, hVar);
    }

    public final AbstractC0676c hide() {
        return io.reactivex.plugins.a.onAssembly(new C1007s(this, 1));
    }

    public final AbstractC0676c lift(InterfaceC0681h interfaceC0681h) {
        p039g3.A.b(interfaceC0681h, "onLift is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.w(this));
    }

    public final <T> O materialize() {
        return io.reactivex.plugins.a.onAssembly(new p053j3.z(this, 0));
    }

    public final AbstractC0676c mergeWith(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return mergeArray(this, interfaceC0682i);
    }

    public final AbstractC0676c observeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1009u(this, n6, 1));
    }

    public final AbstractC0676c onErrorComplete() {
        return onErrorComplete(p039g3.z.f4012g);
    }

    public final AbstractC0676c onErrorResumeNext(p027e3.o oVar) {
        p039g3.A.b(oVar, "errorMapper is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.schedulers.B(this, oVar, 5));
    }

    public final AbstractC0676c onTerminateDetach() {
        return io.reactivex.plugins.a.onAssembly(new C1007s(this, 0));
    }

    public final AbstractC0676c repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    public final AbstractC0676c repeatUntil(p027e3.e eVar) {
        return fromPublisher(toFlowable().repeatUntil(eVar));
    }

    public final AbstractC0676c repeatWhen(p027e3.o oVar) {
        return fromPublisher(toFlowable().repeatWhen(oVar));
    }

    public final AbstractC0676c retry() {
        return fromPublisher(toFlowable().retry());
    }

    public final AbstractC0676c retryWhen(p027e3.o oVar) {
        return fromPublisher(toFlowable().retryWhen(oVar));
    }

    public final AbstractC0676c startWith(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return concatArray(interfaceC0682i, this);
    }

    public final p011b3.c subscribe() {
        p048i3.m mVar = new p048i3.m();
        subscribe(mVar);
        return mVar;
    }

    public final AbstractC0676c subscribeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1009u(this, n6, 2));
    }

    public final <E extends InterfaceC0679f> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final AbstractC0676c takeUntil(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C0993d(this, interfaceC0682i, 1));
    }

    public final p112t3.g test() {
        p112t3.g gVar = new p112t3.g();
        subscribe(gVar);
        return gVar;
    }

    public final AbstractC0676c timeout(long j6, TimeUnit timeUnit) {
        return timeout0(j6, timeUnit, io.reactivex.schedulers.j.computation(), null);
    }

    public final <U> U to(p027e3.o oVar) {
        try {
            p039g3.A.b(oVar, "converter is null");
            return (U) oVar.apply(this);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            throw p100r3.g.d(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> AbstractC0979l toFlowable() {
        return this instanceof p043h3.b ? ((p043h3.b) this).c() : io.reactivex.plugins.a.onAssembly(new C0834z1(this, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> AbstractC0985s toMaybe() {
        return this instanceof p043h3.c ? ((p043h3.c) this).a() : io.reactivex.plugins.a.onAssembly(new C0805u2(this, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> B<T> toObservable() {
        return this instanceof p043h3.d ? ((p043h3.d) this).b() : io.reactivex.plugins.a.onAssembly(new T0(this, 4));
    }

    public final <T> O toSingle(Callable<? extends T> callable) {
        p039g3.A.b(callable, "completionValueSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0771o3(4, this, callable, null, false));
    }

    public final <T> O toSingleDefault(T t6) {
        p039g3.A.b(t6, "completionValue is null");
        return io.reactivex.plugins.a.onAssembly(new C0771o3(4, this, null, t6, false));
    }

    public final AbstractC0676c unsubscribeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1009u(this, n6, 0));
    }

    public static AbstractC0676c timer(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.Q(j6, timeUnit, n6));
    }

    public static <R> AbstractC0676c using(Callable<R> callable, p027e3.o oVar, p027e3.g gVar, boolean z6) {
        p039g3.A.b(callable, "resourceSupplier is null");
        p039g3.A.b(oVar, "completableFunction is null");
        p039g3.A.b(gVar, "disposer is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.U(callable, oVar, gVar, z6));
    }

    public final AbstractC0676c delay(long j6, TimeUnit timeUnit, N n6) {
        return delay(j6, timeUnit, n6, false);
    }

    public final AbstractC0676c delaySubscription(long j6, TimeUnit timeUnit, N n6) {
        return timer(j6, timeUnit, n6).andThen(this);
    }

    public final AbstractC0676c onErrorComplete(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.schedulers.B(this, qVar, 4));
    }

    public final AbstractC0676c repeat(long j6) {
        return fromPublisher(toFlowable().repeat(j6));
    }

    public final AbstractC0676c retry(p027e3.d dVar) {
        return fromPublisher(toFlowable().retry(dVar));
    }

    public final AbstractC0676c timeout(long j6, TimeUnit timeUnit, InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return timeout0(j6, timeUnit, io.reactivex.schedulers.j.computation(), interfaceC0682i);
    }

    public static AbstractC0676c concat(t5.b bVar) {
        return concat(bVar, 2);
    }

    public static AbstractC0676c error(Throwable th) {
        p039g3.A.b(th, "error is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(th, 0));
    }

    public static AbstractC0676c merge(t5.b bVar) {
        return merge0(bVar, Integer.MAX_VALUE, false);
    }

    public static AbstractC0676c mergeDelayError(t5.b bVar) {
        return merge0(bVar, Integer.MAX_VALUE, true);
    }

    public final <T> AbstractC0979l andThen(t5.b bVar) {
        p039g3.A.b(bVar, "next is null");
        return io.reactivex.plugins.a.onAssembly(new C0779q(this, bVar, 5));
    }

    public final AbstractC0676c delay(long j6, TimeUnit timeUnit, N n6, boolean z6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1006q(this, j6, timeUnit, n6, z6));
    }

    public final AbstractC0676c retry(long j6) {
        return fromPublisher(toFlowable().retry(j6));
    }

    public final <T> B<T> startWith(B<T> b) {
        p039g3.A.b(b, "other is null");
        return b.concatWith(toObservable());
    }

    public final p112t3.g test(boolean z6) {
        p112t3.g gVar = new p112t3.g();
        if (z6) {
            gVar.dispose();
        }
        subscribe(gVar);
        return gVar;
    }

    public static AbstractC0676c concat(t5.b bVar, int i5) {
        p039g3.A.b(bVar, "sources is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new C0998i(bVar, i5));
    }

    public static AbstractC0676c merge(t5.b bVar, int i5) {
        return merge0(bVar, i5, false);
    }

    public static AbstractC0676c mergeDelayError(t5.b bVar, int i5) {
        return merge0(bVar, i5, true);
    }

    public final AbstractC0676c retry(long j6, p027e3.q qVar) {
        return fromPublisher(toFlowable().retry(j6, qVar));
    }

    @Override // io.reactivex.InterfaceC0682i
    public final void subscribe(InterfaceC0679f interfaceC0679f) {
        p039g3.A.b(interfaceC0679f, "observer is null");
        try {
            InterfaceC0679f interfaceC0679fOnSubscribe = io.reactivex.plugins.a.onSubscribe(this, interfaceC0679f);
            p039g3.A.b(interfaceC0679fOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            d(interfaceC0679fOnSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final AbstractC0676c timeout(long j6, TimeUnit timeUnit, N n6) {
        return timeout0(j6, timeUnit, n6, null);
    }

    public final <T> O andThen(V v6) {
        p039g3.A.b(v6, "next is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(v6, this, 6));
    }

    public final boolean blockingAwait(long j6, TimeUnit timeUnit) {
        p039g3.A.b(timeUnit, "unit is null");
        p048i3.g gVar = new p048i3.g(1);
        subscribe(gVar);
        if (gVar.getCount() != 0) {
            try {
                if (!gVar.await(j6, timeUnit)) {
                    gVar.b();
                    return false;
                }
            } catch (InterruptedException e) {
                gVar.b();
                throw p100r3.g.d(e);
            }
        }
        Throwable th = gVar.b;
        if (th == null) {
            return true;
        }
        throw p100r3.g.d(th);
    }

    public final AbstractC0676c retry(p027e3.q qVar) {
        return fromPublisher(toFlowable().retry(qVar));
    }

    public final <T> AbstractC0979l startWith(t5.b bVar) {
        p039g3.A.b(bVar, "other is null");
        return toFlowable().startWith(bVar);
    }

    public final AbstractC0676c timeout(long j6, TimeUnit timeUnit, N n6, InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return timeout0(j6, timeUnit, n6, interfaceC0682i);
    }

    public final <T> AbstractC0985s andThen(y yVar) {
        p039g3.A.b(yVar, "next is null");
        return io.reactivex.plugins.a.onAssembly(new C0851c2(yVar, this, 2));
    }

    public final Throwable blockingGet(long j6, TimeUnit timeUnit) {
        p039g3.A.b(timeUnit, "unit is null");
        p048i3.g gVar = new p048i3.g(1);
        subscribe(gVar);
        if (gVar.getCount() != 0) {
            try {
                if (!gVar.await(j6, timeUnit)) {
                    gVar.b();
                    throw p100r3.g.d(new TimeoutException(p100r3.g.c(j6, timeUnit)));
                }
            } catch (InterruptedException e) {
                gVar.b();
                throw p100r3.g.d(e);
            }
        }
        return gVar.b;
    }

    public final AbstractC0676c andThen(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "next is null");
        return io.reactivex.plugins.a.onAssembly(new C0993d(this, interfaceC0682i, 0));
    }

    public final p011b3.c subscribe(p027e3.a aVar, p027e3.g gVar) {
        p039g3.A.b(gVar, "onError is null");
        p039g3.A.b(aVar, "onComplete is null");
        p048i3.i iVar = new p048i3.i(gVar, aVar);
        subscribe(iVar);
        return iVar;
    }

    public final p011b3.c subscribe(p027e3.a aVar) {
        p039g3.A.b(aVar, "onComplete is null");
        p048i3.i iVar = new p048i3.i(aVar);
        subscribe(iVar);
        return iVar;
    }
}
