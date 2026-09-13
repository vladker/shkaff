package io.reactivex;

import io.reactivex.internal.operators.flowable.C0708e0;
import io.reactivex.internal.operators.flowable.C0718f4;
import io.reactivex.internal.operators.flowable.C0771o3;
import io.reactivex.internal.operators.flowable.C0786r1;
import io.reactivex.internal.operators.flowable.C0805u2;
import io.reactivex.internal.operators.flowable.C0814w;
import io.reactivex.internal.operators.flowable.C0817w2;
import io.reactivex.internal.operators.flowable.C0834z1;
import io.reactivex.internal.operators.observable.C0851c2;
import io.reactivex.internal.operators.observable.C0918q;
import io.reactivex.internal.operators.observable.T0;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p077n3.C1249c;
import p077n3.C1251e;
import p077n3.C1253g;
import p077n3.C1257k;
import p077n3.C1259m;
import p077n3.C1261o;
import p077n3.C1262p;
import p077n3.C1263q;
import p077n3.C1270y;
import p077n3.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class O implements V {
    public static <T> O amb(Iterable<? extends V> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(null, iterable, 5));
    }

    public static <T> O ambArray(V... vArr) {
        if (vArr.length == 0) {
            return error(p077n3.D.f6263a);
        }
        return vArr.length == 1 ? wrap(vArr[0]) : io.reactivex.plugins.a.onAssembly(new C0817w2(vArr, null, 5));
    }

    public static <T> AbstractC0979l concat(Iterable<? extends V> iterable) {
        return concat(AbstractC0979l.fromIterable(iterable));
    }

    public static <T> AbstractC0979l concatArray(V... vArr) {
        return io.reactivex.plugins.a.onAssembly(new C0814w(AbstractC0979l.fromArray(vArr), p077n3.E.f6264a, 2, 2));
    }

    public static <T> AbstractC0979l concatArrayEager(V... vArr) {
        return AbstractC0979l.fromArray(vArr).concatMapEager(p077n3.E.f6264a);
    }

    public static <T> AbstractC0979l concatEager(t5.b bVar) {
        return AbstractC0979l.fromPublisher(bVar).concatMapEager(p077n3.E.f6264a);
    }

    public static <T> O create(T t6) {
        p039g3.A.b(t6, "source is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.H(1));
    }

    public static <T> O defer(Callable<? extends V> callable) {
        p039g3.A.b(callable, "singleSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C1251e(callable, 0));
    }

    public static O e(AbstractC0979l abstractC0979l) {
        return io.reactivex.plugins.a.onAssembly(new C0718f4(abstractC0979l, null, 0));
    }

    public static <T> O equals(V v6, V v7) {
        p039g3.A.b(v6, "first is null");
        p039g3.A.b(v7, "second is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(v6, v7, 10));
    }

    public static <T> O error(Callable<? extends Throwable> callable) {
        p039g3.A.b(callable, "errorSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C1251e(callable, 1));
    }

    public static <T> O fromCallable(Callable<? extends T> callable) {
        p039g3.A.b(callable, "callable is null");
        return io.reactivex.plugins.a.onAssembly(new C1251e(callable, 2));
    }

    public static <T> O fromFuture(Future<? extends T> future) {
        return e(AbstractC0979l.fromFuture(future));
    }

    public static <T> O fromObservable(G g6) {
        p039g3.A.b(g6, "observableSource is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(g6, null, 2));
    }

    public static <T> O fromPublisher(t5.b bVar) {
        p039g3.A.b(bVar, "publisher is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.z(bVar, 1));
    }

    public static <T> O just(T t6) {
        p039g3.A.b(t6, "item is null");
        return io.reactivex.plugins.a.onAssembly(new p053j3.z(t6, 3));
    }

    public static <T> AbstractC0979l merge(Iterable<? extends V> iterable) {
        return merge(AbstractC0979l.fromIterable(iterable));
    }

    public static <T> AbstractC0979l mergeDelayError(Iterable<? extends V> iterable) {
        return mergeDelayError(AbstractC0979l.fromIterable(iterable));
    }

    public static <T> O never() {
        return io.reactivex.plugins.a.onAssembly(p077n3.H.b);
    }

    public static O timer(long j6, TimeUnit timeUnit) {
        return timer(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public static <T> O unsafeCreate(V v6) {
        p039g3.A.b(v6, "onSubscribe is null");
        if (v6 instanceof O) {
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return io.reactivex.plugins.a.onAssembly(new p053j3.z(v6, 2));
    }

    public static <T, U> O using(Callable<U> callable, p027e3.o oVar, p027e3.g gVar) {
        return using(callable, oVar, gVar, true);
    }

    public static <T> O wrap(V v6) {
        p039g3.A.b(v6, "source is null");
        return v6 instanceof O ? io.reactivex.plugins.a.onAssembly((O) v6) : io.reactivex.plugins.a.onAssembly(new p053j3.z(v6, 2));
    }

    public static <T, R> O zip(Iterable<? extends V> iterable, p027e3.o oVar) {
        p039g3.A.b(oVar, "zipper is null");
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(iterable, oVar, 13));
    }

    public static <T, R> O zipArray(p027e3.o oVar, V... vArr) {
        p039g3.A.b(oVar, "zipper is null");
        p039g3.A.b(vArr, "sources is null");
        return vArr.length == 0 ? error(new NoSuchElementException()) : io.reactivex.plugins.a.onAssembly(new C0817w2(vArr, oVar, 12));
    }

    public final O ambWith(V v6) {
        p039g3.A.b(v6, "other is null");
        return ambArray(this, v6);
    }

    public final <R> R as(P p6) {
        p039g3.A.b(p6, "converter is null");
        throw new ClassCastException();
    }

    public final Object blockingGet() {
        p048i3.g gVar = new p048i3.g(1);
        subscribe(gVar);
        return gVar.a();
    }

    public final O cache() {
        return io.reactivex.plugins.a.onAssembly(new C1249c(this));
    }

    public final <U> O cast(Class<? extends U> cls) {
        p039g3.A.b(cls, "clazz is null");
        return map(new p039g3.f(cls));
    }

    public final <R> O compose(W w6) {
        p039g3.A.b(w6, "transformer is null");
        throw new ClassCastException();
    }

    public final AbstractC0979l concatWith(V v6) {
        return concat(this, v6);
    }

    public final O contains(Object obj) {
        return contains(obj, p039g3.A.f3987a);
    }

    public final O d(long j6, TimeUnit timeUnit, N n6, V v6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.Q(this, j6, timeUnit, n6, v6));
    }

    public final O delay(long j6, TimeUnit timeUnit) {
        return delay(j6, timeUnit, io.reactivex.schedulers.j.computation(), false);
    }

    public final O delaySubscription(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, interfaceC0682i, 6));
    }

    public final <R> AbstractC0985s dematerialize(p027e3.o oVar) {
        p039g3.A.b(oVar, "selector is null");
        return io.reactivex.plugins.a.onAssembly(new C1259m(this, oVar, 0));
    }

    public final O doAfterSuccess(p027e3.g gVar) {
        p039g3.A.b(gVar, "onAfterSuccess is null");
        return io.reactivex.plugins.a.onAssembly(new C1262p(this, gVar, 0));
    }

    public final O doAfterTerminate(p027e3.a aVar) {
        p039g3.A.b(aVar, "onAfterTerminate is null");
        return io.reactivex.plugins.a.onAssembly(new C1263q(this, aVar, 0));
    }

    public final O doFinally(p027e3.a aVar) {
        p039g3.A.b(aVar, "onFinally is null");
        return io.reactivex.plugins.a.onAssembly(new C1263q(this, aVar, 1));
    }

    public final O doOnDispose(p027e3.a aVar) {
        p039g3.A.b(aVar, "onDispose is null");
        return io.reactivex.plugins.a.onAssembly(new C1263q(this, aVar, 2));
    }

    public final O doOnError(p027e3.g gVar) {
        p039g3.A.b(gVar, "onError is null");
        return io.reactivex.plugins.a.onAssembly(new C1262p(this, gVar, 1));
    }

    public final O doOnEvent(p027e3.b bVar) {
        p039g3.A.b(bVar, "onEvent is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, bVar, 9));
    }

    public final O doOnSubscribe(p027e3.g gVar) {
        p039g3.A.b(gVar, "onSubscribe is null");
        return io.reactivex.plugins.a.onAssembly(new C1262p(this, gVar, 2));
    }

    public final O doOnSuccess(p027e3.g gVar) {
        p039g3.A.b(gVar, "onSuccess is null");
        return io.reactivex.plugins.a.onAssembly(new C1262p(this, gVar, 3));
    }

    public final O doOnTerminate(p027e3.a aVar) {
        p039g3.A.b(aVar, "onTerminate is null");
        return io.reactivex.plugins.a.onAssembly(new C1263q(this, aVar, 3));
    }

    public final AbstractC0985s filter(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new C0851c2(this, qVar, 4));
    }

    public final <R> O flatMap(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, oVar, 11));
    }

    public final AbstractC0676c flatMapCompletable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.schedulers.B(this, oVar, 7));
    }

    public final <R> AbstractC0985s flatMapMaybe(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C1259m(this, oVar, 1));
    }

    public final <R> B<R> flatMapObservable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p065l3.K(this, oVar, 0));
    }

    public final <R> AbstractC0979l flatMapPublisher(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C1270y(this, oVar, 1));
    }

    public final <U> AbstractC0979l flattenAsFlowable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C1270y(this, oVar, 0));
    }

    public final <U> B<U> flattenAsObservable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p065l3.K(this, oVar, 1));
    }

    public final O hide() {
        return io.reactivex.plugins.a.onAssembly(new C1261o(this, 1));
    }

    public final AbstractC0676c ignoreElement() {
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(this, 5));
    }

    public final <R> O lift(U u6) {
        p039g3.A.b(u6, "lift is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.H(this));
    }

    public final <R> O map(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.G(this, oVar, 0));
    }

    public final O materialize() {
        return io.reactivex.plugins.a.onAssembly(new C1261o(this, 2));
    }

    public final AbstractC0979l mergeWith(V v6) {
        return merge(this, v6);
    }

    public final O observeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.J(this, n6, 0));
    }

    public final O onErrorResumeNext(O o6) {
        p039g3.A.b(o6, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(new p039g3.m(o6));
    }

    public final O onErrorReturn(p027e3.o oVar) {
        p039g3.A.b(oVar, "resumeFunction is null");
        return io.reactivex.plugins.a.onAssembly(new C0771o3(7, this, oVar, null, false));
    }

    public final O onErrorReturnItem(Object obj) {
        p039g3.A.b(obj, "value is null");
        return io.reactivex.plugins.a.onAssembly(new C0771o3(7, this, null, obj, false));
    }

    public final O onTerminateDetach() {
        return io.reactivex.plugins.a.onAssembly(new C1261o(this, 0));
    }

    public final AbstractC0979l repeat() {
        return toFlowable().repeat();
    }

    public final AbstractC0979l repeatUntil(p027e3.e eVar) {
        return toFlowable().repeatUntil(eVar);
    }

    public final AbstractC0979l repeatWhen(p027e3.o oVar) {
        return toFlowable().repeatWhen(oVar);
    }

    public final O retry() {
        return e(toFlowable().retry());
    }

    public final O retryWhen(p027e3.o oVar) {
        return e(toFlowable().retryWhen(oVar));
    }

    public final p011b3.c subscribe() {
        return subscribe(p039g3.z.d, p039g3.z.e);
    }

    public abstract void subscribeActual(S s6);

    public final O subscribeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.J(this, n6, 1));
    }

    public final <E extends S> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final O takeUntil(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return takeUntil(new C0834z1(interfaceC0682i, 2));
    }

    public final p112t3.g test() {
        p112t3.g gVar = new p112t3.g();
        subscribe(gVar);
        return gVar;
    }

    public final O timeout(long j6, TimeUnit timeUnit) {
        return d(j6, timeUnit, io.reactivex.schedulers.j.computation(), null);
    }

    public final <R> R to(p027e3.o oVar) {
        try {
            p039g3.A.b(oVar, "convert is null");
            return (R) oVar.apply(this);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            throw p100r3.g.d(th);
        }
    }

    @Deprecated
    public final AbstractC0676c toCompletable() {
        return io.reactivex.plugins.a.onAssembly(new p053j3.x(this, 5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractC0979l toFlowable() {
        return this instanceof p043h3.b ? ((p043h3.b) this).c() : io.reactivex.plugins.a.onAssembly(new C0834z1(this, 4));
    }

    public final Future<Object> toFuture() {
        return (Future) subscribeWith(new p048i3.p());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractC0985s toMaybe() {
        return this instanceof p043h3.c ? ((p043h3.c) this).a() : io.reactivex.plugins.a.onAssembly(new C0805u2(this, 3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final B<Object> toObservable() {
        return this instanceof p043h3.d ? ((p043h3.d) this).b() : io.reactivex.plugins.a.onAssembly(new T0(this, 6));
    }

    public final O unsubscribeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.J(this, n6, 2));
    }

    public final <U, R> O zipWith(V v6, p027e3.c cVar) {
        return zip(this, v6, cVar);
    }

    public static <T> B<T> concat(G g6) {
        p039g3.A.b(g6, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0918q(g6, p077n3.F.f6265a, 2, 1));
    }

    public static <T> AbstractC0979l concatEager(Iterable<? extends V> iterable) {
        return AbstractC0979l.fromIterable(iterable).concatMapEager(p077n3.E.f6264a);
    }

    public static <T> O fromFuture(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        return e(AbstractC0979l.fromFuture(future, j6, timeUnit));
    }

    public static <T> AbstractC0979l merge(t5.b bVar) {
        p039g3.A.b(bVar, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0786r1(bVar, p077n3.E.f6264a, false, Integer.MAX_VALUE, AbstractC0979l.f5366a));
    }

    public static <T> AbstractC0979l mergeDelayError(t5.b bVar) {
        p039g3.A.b(bVar, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0786r1(bVar, p077n3.E.f6264a, true, Integer.MAX_VALUE, AbstractC0979l.f5366a));
    }

    public static O timer(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.T(j6, timeUnit, n6));
    }

    public static <T, U> O using(Callable<U> callable, p027e3.o oVar, p027e3.g gVar, boolean z6) {
        p039g3.A.b(callable, "resourceSupplier is null");
        p039g3.A.b(oVar, "singleFunction is null");
        p039g3.A.b(gVar, "disposer is null");
        return io.reactivex.plugins.a.onAssembly(new Y(callable, oVar, gVar, z6));
    }

    public final O contains(Object obj, p027e3.d dVar) {
        p039g3.A.b(obj, "value is null");
        p039g3.A.b(dVar, "comparer is null");
        return io.reactivex.plugins.a.onAssembly(new C0771o3(this, 6, obj, dVar));
    }

    public final O delay(long j6, TimeUnit timeUnit, boolean z6) {
        return delay(j6, timeUnit, io.reactivex.schedulers.j.computation(), z6);
    }

    public final AbstractC0979l repeat(long j6) {
        return toFlowable().repeat(j6);
    }

    public final O retry(long j6) {
        return e(toFlowable().retry(j6));
    }

    public final p011b3.c subscribe(p027e3.b bVar) {
        p039g3.A.b(bVar, "onCallback is null");
        p048i3.d dVar = new p048i3.d(bVar);
        subscribe(dVar);
        return dVar;
    }

    public final O timeout(long j6, TimeUnit timeUnit, N n6) {
        return d(j6, timeUnit, n6, null);
    }

    public static <T> O error(Throwable th) {
        p039g3.A.b(th, "exception is null");
        return error(new p039g3.m(th));
    }

    public static <T> O fromFuture(Future<? extends T> future, long j6, TimeUnit timeUnit, N n6) {
        return e(AbstractC0979l.fromFuture(future, j6, timeUnit, n6));
    }

    public final O delay(long j6, TimeUnit timeUnit, N n6) {
        return delay(j6, timeUnit, n6, false);
    }

    public final <U> O delaySubscription(V v6) {
        p039g3.A.b(v6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, v6, 8));
    }

    public final O retry(p027e3.d dVar) {
        return e(toFlowable().retry(dVar));
    }

    public final <E> O takeUntil(t5.b bVar) {
        p039g3.A.b(bVar, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C1257k(this, bVar, 1));
    }

    public final p112t3.g test(boolean z6) {
        p112t3.g gVar = new p112t3.g();
        if (z6) {
            gVar.dispose();
        }
        subscribe(gVar);
        return gVar;
    }

    public final O timeout(long j6, TimeUnit timeUnit, N n6, V v6) {
        p039g3.A.b(v6, "other is null");
        return d(j6, timeUnit, n6, v6);
    }

    public static <T> AbstractC0979l concat(t5.b bVar) {
        return concat(bVar, 2);
    }

    public static <T> O fromFuture(Future<? extends T> future, N n6) {
        return e(AbstractC0979l.fromFuture(future, n6));
    }

    public static <T1, T2, R> O zip(V v6, V v7, p027e3.c cVar) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        return zipArray(p039g3.z.a(cVar), v6, v7);
    }

    public final O delay(long j6, TimeUnit timeUnit, N n6, boolean z6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1253g(this, j6, timeUnit, n6, z6));
    }

    public final O onErrorResumeNext(p027e3.o oVar) {
        p039g3.A.b(oVar, "resumeFunctionInCaseOfError is null");
        return io.reactivex.plugins.a.onAssembly(new p077n3.G(this, oVar, 1));
    }

    public final O retry(long j6, p027e3.q qVar) {
        return e(toFlowable().retry(j6, qVar));
    }

    public static <T> AbstractC0979l concat(t5.b bVar, int i5) {
        p039g3.A.b(bVar, "sources is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new C0708e0(bVar, p077n3.E.f6264a, i5));
    }

    public final <U> O delaySubscription(G g6) {
        p039g3.A.b(g6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, g6, 7));
    }

    public final O retry(p027e3.q qVar) {
        return e(toFlowable().retry(qVar));
    }

    public final p011b3.c subscribe(p027e3.g gVar) {
        return subscribe(gVar, p039g3.z.e);
    }

    public final <E> O takeUntil(V v6) {
        p039g3.A.b(v6, "other is null");
        return takeUntil(new C0834z1(v6, 4));
    }

    public final O timeout(long j6, TimeUnit timeUnit, V v6) {
        p039g3.A.b(v6, "other is null");
        return d(j6, timeUnit, io.reactivex.schedulers.j.computation(), v6);
    }

    public static <T> O merge(V v6) {
        p039g3.A.b(v6, "source is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(v6, p039g3.z.f4010a, 11));
    }

    public static <T> AbstractC0979l mergeDelayError(V v6, V v7) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        return mergeDelayError(AbstractC0979l.fromArray(v6, v7));
    }

    public final p011b3.c subscribe(p027e3.g gVar, p027e3.g gVar2) {
        p039g3.A.b(gVar, "onSuccess is null");
        p039g3.A.b(gVar2, "onError is null");
        p048i3.j jVar = new p048i3.j(gVar, gVar2);
        subscribe(jVar);
        return jVar;
    }

    public static <T1, T2, T3, R> O zip(V v6, V v7, V v8, p027e3.h hVar) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.z.b();
        throw null;
    }

    public final <U> O delaySubscription(t5.b bVar) {
        p039g3.A.b(bVar, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C1257k(this, bVar, 0));
    }

    public static <T> AbstractC0979l concat(V v6, V v7) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        return concat(AbstractC0979l.fromArray(v6, v7));
    }

    public static <T> AbstractC0979l merge(V v6, V v7) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        return merge(AbstractC0979l.fromArray(v6, v7));
    }

    public static <T> AbstractC0979l mergeDelayError(V v6, V v7, V v8) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        return mergeDelayError(AbstractC0979l.fromArray(v6, v7, v8));
    }

    public final O delaySubscription(long j6, TimeUnit timeUnit) {
        return delaySubscription(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final O delaySubscription(long j6, TimeUnit timeUnit, N n6) {
        return delaySubscription(B.timer(j6, timeUnit, n6));
    }

    @Override // io.reactivex.V
    public final void subscribe(S s6) {
        p039g3.A.b(s6, "observer is null");
        S sOnSubscribe = io.reactivex.plugins.a.onSubscribe(this, s6);
        p039g3.A.b(sOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(sOnSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T> AbstractC0979l concat(V v6, V v7, V v8) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        return concat(AbstractC0979l.fromArray(v6, v7, v8));
    }

    public static <T> AbstractC0979l merge(V v6, V v7, V v8) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        return merge(AbstractC0979l.fromArray(v6, v7, v8));
    }

    public static <T1, T2, T3, T4, R> O zip(V v6, V v7, V v8, V v9, p027e3.i iVar) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        p039g3.z.c();
        throw null;
    }

    public static <T> AbstractC0979l mergeDelayError(V v6, V v7, V v8, V v9) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        return mergeDelayError(AbstractC0979l.fromArray(v6, v7, v8, v9));
    }

    public static <T> AbstractC0979l concat(V v6, V v7, V v8, V v9) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        return concat(AbstractC0979l.fromArray(v6, v7, v8, v9));
    }

    public static <T> AbstractC0979l merge(V v6, V v7, V v8, V v9) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        return merge(AbstractC0979l.fromArray(v6, v7, v8, v9));
    }

    public static <T1, T2, T3, T4, T5, R> O zip(V v6, V v7, V v8, V v9, V v10, p027e3.j jVar) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        p039g3.A.b(v10, "source5 is null");
        p039g3.z.d();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, R> O zip(V v6, V v7, V v8, V v9, V v10, V v11, p027e3.k kVar) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        p039g3.A.b(v10, "source5 is null");
        p039g3.A.b(v11, "source6 is null");
        p039g3.z.e();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> O zip(V v6, V v7, V v8, V v9, V v10, V v11, V v12, p027e3.l lVar) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        p039g3.A.b(v10, "source5 is null");
        p039g3.A.b(v11, "source6 is null");
        p039g3.A.b(v12, "source7 is null");
        p039g3.z.f();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> O zip(V v6, V v7, V v8, V v9, V v10, V v11, V v12, V v13, p027e3.m mVar) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        p039g3.A.b(v10, "source5 is null");
        p039g3.A.b(v11, "source6 is null");
        p039g3.A.b(v12, "source7 is null");
        p039g3.A.b(v13, "source8 is null");
        p039g3.z.g();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> O zip(V v6, V v7, V v8, V v9, V v10, V v11, V v12, V v13, V v14, p027e3.n nVar) {
        p039g3.A.b(v6, "source1 is null");
        p039g3.A.b(v7, "source2 is null");
        p039g3.A.b(v8, "source3 is null");
        p039g3.A.b(v9, "source4 is null");
        p039g3.A.b(v10, "source5 is null");
        p039g3.A.b(v11, "source6 is null");
        p039g3.A.b(v12, "source7 is null");
        p039g3.A.b(v13, "source8 is null");
        p039g3.A.b(v14, "source9 is null");
        p039g3.z.h();
        throw null;
    }
}
