package io.reactivex;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.operators.flowable.C0708e0;
import io.reactivex.internal.operators.flowable.C0771o3;
import io.reactivex.internal.operators.flowable.C0786r1;
import io.reactivex.internal.operators.flowable.C0805u2;
import io.reactivex.internal.operators.flowable.C0817w2;
import io.reactivex.internal.operators.flowable.C0834z1;
import io.reactivex.internal.operators.flowable.F1;
import io.reactivex.internal.operators.observable.C0851c2;
import io.reactivex.internal.operators.observable.T0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p059k3.C1013b0;
import p059k3.C1015c0;
import p059k3.C1016d;
import p059k3.C1017d0;
import p059k3.C1018e;
import p059k3.C1022g;
import p059k3.C1029j0;
import p059k3.C1030k;
import p059k3.C1033l0;
import p059k3.C1034m;
import p059k3.C1037n0;
import p059k3.C1038o;
import p059k3.C1040q;
import p059k3.C1042t;
import p059k3.C1047y;
import p059k3.C1048z;
import p059k3.CallableC1011a0;
import p059k3.G0;
import p059k3.J0;
import p059k3.X;
import p059k3.Y;
import p059k3.Z;
import p059k3.o0;
import p059k3.r0;

/* JADX INFO: renamed from: io.reactivex.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0985s implements y {
    public static <T> AbstractC0985s amb(Iterable<? extends y> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0851c2(null, iterable, 1));
    }

    public static <T> AbstractC0985s ambArray(y... yVarArr) {
        if (yVarArr.length == 0) {
            return empty();
        }
        return yVarArr.length == 1 ? wrap(yVarArr[0]) : io.reactivex.plugins.a.onAssembly(new C0851c2(yVarArr, null, 1));
    }

    public static <T> AbstractC0979l concat(Iterable<? extends y> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new F1(iterable, 1));
    }

    public static <T> AbstractC0979l concatArray(y... yVarArr) {
        p039g3.A.b(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return AbstractC0979l.empty();
        }
        return yVarArr.length == 1 ? io.reactivex.plugins.a.onAssembly(new C0834z1(yVarArr[0], 3)) : io.reactivex.plugins.a.onAssembly(new C1022g(yVarArr, 0));
    }

    public static <T> AbstractC0979l concatArrayDelayError(y... yVarArr) {
        if (yVarArr.length == 0) {
            return AbstractC0979l.empty();
        }
        return yVarArr.length == 1 ? io.reactivex.plugins.a.onAssembly(new C0834z1(yVarArr[0], 3)) : io.reactivex.plugins.a.onAssembly(new C1022g(yVarArr, 1));
    }

    public static <T> AbstractC0979l concatArrayEager(y... yVarArr) {
        return AbstractC0979l.fromArray(yVarArr).concatMapEager(G0.f5511a);
    }

    public static <T> AbstractC0979l concatDelayError(Iterable<? extends y> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return AbstractC0979l.fromIterable(iterable).concatMapDelayError(G0.f5511a);
    }

    public static <T> AbstractC0979l concatEager(Iterable<? extends y> iterable) {
        return AbstractC0979l.fromIterable(iterable).concatMapEager(G0.f5511a);
    }

    public static <T> AbstractC0985s create(InterfaceC0989w interfaceC0989w) {
        p039g3.A.b(interfaceC0989w, "onSubscribe is null");
        return io.reactivex.plugins.a.onAssembly(new C1029j0(1));
    }

    public static <T> AbstractC0985s defer(Callable<? extends y> callable) {
        p039g3.A.b(callable, "maybeSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C1038o(callable, 0));
    }

    public static <T> AbstractC0985s empty() {
        return io.reactivex.plugins.a.onAssembly(p059k3.B.f5503a);
    }

    public static <T> AbstractC0985s error(Throwable th) {
        p039g3.A.b(th, "exception is null");
        return io.reactivex.plugins.a.onAssembly(new C0805u2(th, 1));
    }

    public static <T> AbstractC0985s fromAction(p027e3.a aVar) {
        p039g3.A.b(aVar, "run is null");
        return io.reactivex.plugins.a.onAssembly(new X(aVar));
    }

    public static <T> AbstractC0985s fromCallable(Callable<? extends T> callable) {
        p039g3.A.b(callable, "callable is null");
        return io.reactivex.plugins.a.onAssembly(new Y(callable));
    }

    public static <T> AbstractC0985s fromCompletable(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "completableSource is null");
        return io.reactivex.plugins.a.onAssembly(new C0805u2(interfaceC0682i, 2));
    }

    public static <T> AbstractC0985s fromFuture(Future<? extends T> future) {
        p039g3.A.b(future, "future is null");
        return io.reactivex.plugins.a.onAssembly(new Z(future, 0L, (TimeUnit) null));
    }

    public static <T> AbstractC0985s fromRunnable(Runnable runnable) {
        p039g3.A.b(runnable, "run is null");
        return io.reactivex.plugins.a.onAssembly(new CallableC1011a0(runnable));
    }

    public static <T> AbstractC0985s fromSingle(V v6) {
        p039g3.A.b(v6, "singleSource is null");
        return io.reactivex.plugins.a.onAssembly(new C0805u2(v6, 3));
    }

    public static <T> AbstractC0985s just(T t6) {
        p039g3.A.b(t6, "item is null");
        return io.reactivex.plugins.a.onAssembly(new C1017d0(t6));
    }

    public static <T> AbstractC0979l merge(Iterable<? extends y> iterable) {
        return merge(AbstractC0979l.fromIterable(iterable));
    }

    public static <T> AbstractC0979l mergeArray(y... yVarArr) {
        p039g3.A.b(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return AbstractC0979l.empty();
        }
        return yVarArr.length == 1 ? io.reactivex.plugins.a.onAssembly(new C0834z1(yVarArr[0], 3)) : io.reactivex.plugins.a.onAssembly(new C1022g(yVarArr, 2));
    }

    public static <T> AbstractC0979l mergeArrayDelayError(y... yVarArr) {
        if (yVarArr.length == 0) {
            return AbstractC0979l.empty();
        }
        return AbstractC0979l.fromArray(yVarArr).flatMap((p027e3.o) G0.f5511a, true, yVarArr.length);
    }

    public static <T> AbstractC0979l mergeDelayError(Iterable<? extends y> iterable) {
        return AbstractC0979l.fromIterable(iterable).flatMap((p027e3.o) G0.f5511a, true);
    }

    public static <T> AbstractC0985s never() {
        return io.reactivex.plugins.a.onAssembly(C1029j0.b);
    }

    public static <T> O sequenceEqual(y yVar, y yVar2) {
        return sequenceEqual(yVar, yVar2, p039g3.A.f3987a);
    }

    public static AbstractC0985s timer(long j6, TimeUnit timeUnit) {
        return timer(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public static <T> AbstractC0985s unsafeCreate(y yVar) {
        if (yVar instanceof AbstractC0985s) {
            throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        }
        p039g3.A.b(yVar, "onSubscribe is null");
        return io.reactivex.plugins.a.onAssembly(new C1047y(yVar, 5));
    }

    public static <T, D> AbstractC0985s using(Callable<? extends D> callable, p027e3.o oVar, p027e3.g gVar) {
        return using(callable, oVar, gVar, true);
    }

    public static <T> AbstractC0985s wrap(y yVar) {
        if (yVar instanceof AbstractC0985s) {
            return io.reactivex.plugins.a.onAssembly((AbstractC0985s) yVar);
        }
        p039g3.A.b(yVar, "onSubscribe is null");
        return io.reactivex.plugins.a.onAssembly(new C1047y(yVar, 5));
    }

    public static <T, R> AbstractC0985s zip(Iterable<? extends y> iterable, p027e3.o oVar) {
        p039g3.A.b(oVar, "zipper is null");
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0851c2(iterable, oVar, 7));
    }

    public static <T, R> AbstractC0985s zipArray(p027e3.o oVar, y... yVarArr) {
        p039g3.A.b(yVarArr, "sources is null");
        if (yVarArr.length == 0) {
            return empty();
        }
        p039g3.A.b(oVar, "zipper is null");
        return io.reactivex.plugins.a.onAssembly(new C0851c2(yVarArr, oVar, 6));
    }

    public abstract void a(InterfaceC0988v interfaceC0988v);

    public final AbstractC0985s ambWith(y yVar) {
        p039g3.A.b(yVar, "other is null");
        return ambArray(this, yVar);
    }

    public final <R> R as(InterfaceC0986t interfaceC0986t) {
        p039g3.A.b(interfaceC0986t, "converter is null");
        throw new ClassCastException();
    }

    public final Object blockingGet() {
        p048i3.g gVar = new p048i3.g(1);
        subscribe(gVar);
        return gVar.a();
    }

    public final AbstractC0985s cache() {
        return io.reactivex.plugins.a.onAssembly(new C1016d(this));
    }

    public final <U> AbstractC0985s cast(Class<? extends U> cls) {
        p039g3.A.b(cls, "clazz is null");
        return map(new p039g3.f(cls));
    }

    public final <R> AbstractC0985s compose(z zVar) {
        p039g3.A.b(zVar, "transformer is null");
        throw new ClassCastException();
    }

    public final <R> AbstractC0985s concatMap(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.W(this, oVar, 0));
    }

    public final AbstractC0979l concatWith(y yVar) {
        p039g3.A.b(yVar, "other is null");
        return concat(this, yVar);
    }

    public final O contains(Object obj) {
        p039g3.A.b(obj, "item is null");
        return io.reactivex.plugins.a.onAssembly(new C1030k(this, obj, 0));
    }

    public final O count() {
        return io.reactivex.plugins.a.onAssembly(new C1034m(this, 0));
    }

    public final AbstractC0985s defaultIfEmpty(Object obj) {
        p039g3.A.b(obj, "defaultItem is null");
        return switchIfEmpty(just(obj));
    }

    public final AbstractC0985s delay(long j6, TimeUnit timeUnit) {
        return delay(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final <U> AbstractC0985s delaySubscription(t5.b bVar) {
        p039g3.A.b(bVar, "subscriptionIndicator is null");
        return io.reactivex.plugins.a.onAssembly(new C1042t(this, bVar, 1));
    }

    public final AbstractC0985s doAfterSuccess(p027e3.g gVar) {
        p039g3.A.b(gVar, "onAfterSuccess is null");
        return io.reactivex.plugins.a.onAssembly(new C1048z(this, gVar, 0));
    }

    public final AbstractC0985s doAfterTerminate(p027e3.a aVar) {
        p039g3.A.b(aVar, "onAfterTerminate is null");
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return io.reactivex.plugins.a.onAssembly(new o0(this, bVar, bVar, bVar, hVar, aVar, hVar));
    }

    public final AbstractC0985s doFinally(p027e3.a aVar) {
        p039g3.A.b(aVar, "onFinally is null");
        return io.reactivex.plugins.a.onAssembly(new C1048z(this, aVar, 1));
    }

    public final AbstractC0985s doOnComplete(p027e3.a aVar) {
        p039g3.A.b(aVar, "onComplete is null");
        p039g3.h hVar = p039g3.z.c;
        V1.b bVar = p039g3.z.d;
        return io.reactivex.plugins.a.onAssembly(new o0(this, bVar, bVar, bVar, aVar, hVar, hVar));
    }

    public final AbstractC0985s doOnDispose(p027e3.a aVar) {
        p039g3.A.b(aVar, "onDispose is null");
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return io.reactivex.plugins.a.onAssembly(new o0(this, bVar, bVar, bVar, hVar, hVar, aVar));
    }

    public final AbstractC0985s doOnError(p027e3.g gVar) {
        p039g3.A.b(gVar, "onError is null");
        p039g3.h hVar = p039g3.z.c;
        V1.b bVar = p039g3.z.d;
        return io.reactivex.plugins.a.onAssembly(new o0(this, bVar, bVar, gVar, hVar, hVar, hVar));
    }

    public final AbstractC0985s doOnEvent(p027e3.b bVar) {
        p039g3.A.b(bVar, "onEvent is null");
        return io.reactivex.plugins.a.onAssembly(new C1048z(this, bVar, 2));
    }

    public final AbstractC0985s doOnSubscribe(p027e3.g gVar) {
        p039g3.A.b(gVar, "onSubscribe is null");
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return io.reactivex.plugins.a.onAssembly(new o0(this, gVar, bVar, bVar, hVar, hVar, hVar));
    }

    public final AbstractC0985s doOnSuccess(p027e3.g gVar) {
        p039g3.A.b(gVar, "onSuccess is null");
        p039g3.h hVar = p039g3.z.c;
        V1.b bVar = p039g3.z.d;
        return io.reactivex.plugins.a.onAssembly(new o0(this, bVar, gVar, bVar, hVar, hVar, hVar));
    }

    public final AbstractC0985s doOnTerminate(p027e3.a aVar) {
        p039g3.A.b(aVar, "onTerminate is null");
        return io.reactivex.plugins.a.onAssembly(new C0851c2(this, aVar, 3));
    }

    public final AbstractC0985s filter(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.F(this, qVar, 0));
    }

    public final <R> AbstractC0985s flatMap(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.W(this, oVar, 0));
    }

    public final AbstractC0676c flatMapCompletable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.schedulers.B(this, oVar, 6));
    }

    public final <R> B<R> flatMapObservable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.O(this, oVar, 1));
    }

    public final <R> AbstractC0979l flatMapPublisher(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.M(this, oVar, 1));
    }

    public final <R> O flatMapSingle(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, oVar, 3));
    }

    public final <R> AbstractC0985s flatMapSingleElement(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C0851c2(this, oVar, 5));
    }

    public final <U> AbstractC0979l flattenAsFlowable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.M(this, oVar, 0));
    }

    public final <U> B<U> flattenAsObservable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.O(this, oVar, 0));
    }

    public final AbstractC0985s hide() {
        return io.reactivex.plugins.a.onAssembly(new C1047y(this, 1));
    }

    public final AbstractC0676c ignoreElement() {
        return io.reactivex.plugins.a.onAssembly(new C1013b0(this));
    }

    public final O isEmpty() {
        return io.reactivex.plugins.a.onAssembly(new C1015c0(this));
    }

    public final <R> AbstractC0985s lift(x xVar) {
        p039g3.A.b(xVar, "lift is null");
        return io.reactivex.plugins.a.onAssembly(new C1047y(this, 4));
    }

    public final <R> AbstractC0985s map(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.W(this, oVar, 1));
    }

    public final O materialize() {
        return io.reactivex.plugins.a.onAssembly(new C1034m(this, 1));
    }

    public final AbstractC0979l mergeWith(y yVar) {
        p039g3.A.b(yVar, "other is null");
        return merge(this, yVar);
    }

    public final AbstractC0985s observeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1033l0(this, n6, 0));
    }

    public final <U> AbstractC0985s ofType(Class<U> cls) {
        p039g3.A.b(cls, "clazz is null");
        return filter(new p039g3.g(cls)).cast(cls);
    }

    public final AbstractC0985s onErrorComplete() {
        return onErrorComplete(p039g3.z.f4012g);
    }

    public final AbstractC0985s onErrorResumeNext(y yVar) {
        p039g3.A.b(yVar, "next is null");
        return onErrorResumeNext(new p039g3.m(yVar));
    }

    public final AbstractC0985s onErrorReturn(p027e3.o oVar) {
        p039g3.A.b(oVar, "valueSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.W(this, oVar, 2));
    }

    public final AbstractC0985s onErrorReturnItem(Object obj) {
        p039g3.A.b(obj, "item is null");
        return onErrorReturn(new p039g3.m(obj));
    }

    public final AbstractC0985s onExceptionResumeNext(y yVar) {
        p039g3.A.b(yVar, "next is null");
        return io.reactivex.plugins.a.onAssembly(new C1037n0(this, new p039g3.m(yVar), false));
    }

    public final AbstractC0985s onTerminateDetach() {
        return io.reactivex.plugins.a.onAssembly(new C1047y(this, 0));
    }

    public final AbstractC0979l repeat() {
        return repeat(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public final AbstractC0979l repeatUntil(p027e3.e eVar) {
        return toFlowable().repeatUntil(eVar);
    }

    public final AbstractC0979l repeatWhen(p027e3.o oVar) {
        return toFlowable().repeatWhen(oVar);
    }

    public final AbstractC0985s retry() {
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, p039g3.z.f4012g);
    }

    public final AbstractC0985s retryUntil(p027e3.e eVar) {
        p039g3.A.b(eVar, "stop is null");
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, new p039g3.d(eVar));
    }

    public final AbstractC0985s retryWhen(p027e3.o oVar) {
        return toFlowable().retryWhen(oVar).singleElement();
    }

    public final p011b3.c subscribe() {
        return subscribe(p039g3.z.d, p039g3.z.e, p039g3.z.c);
    }

    public final AbstractC0985s subscribeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1033l0(this, n6, 1));
    }

    public final <E extends InterfaceC0988v> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final AbstractC0985s switchIfEmpty(y yVar) {
        p039g3.A.b(yVar, "other is null");
        return io.reactivex.plugins.a.onAssembly(new r0(this, yVar, 0));
    }

    public final <U> AbstractC0985s takeUntil(y yVar) {
        p039g3.A.b(yVar, "other is null");
        return io.reactivex.plugins.a.onAssembly(new r0(this, yVar, 1));
    }

    public final p112t3.g test() {
        p112t3.g gVar = new p112t3.g();
        subscribe(gVar);
        return gVar;
    }

    public final AbstractC0985s timeout(long j6, TimeUnit timeUnit) {
        return timeout(j6, timeUnit, io.reactivex.schedulers.j.computation());
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

    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractC0979l toFlowable() {
        return this instanceof p043h3.b ? ((p043h3.b) this).c() : io.reactivex.plugins.a.onAssembly(new C0834z1(this, 3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final B<Object> toObservable() {
        return this instanceof p043h3.d ? ((p043h3.d) this).b() : io.reactivex.plugins.a.onAssembly(new T0(this, 5));
    }

    public final O toSingle(Object obj) {
        p039g3.A.b(obj, "defaultValue is null");
        return io.reactivex.plugins.a.onAssembly(new C1030k(this, obj, 1));
    }

    public final AbstractC0985s unsubscribeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1033l0(this, n6, 2));
    }

    public final <U, R> AbstractC0985s zipWith(y yVar, p027e3.c cVar) {
        p039g3.A.b(yVar, "other is null");
        return zip(this, yVar, cVar);
    }

    public static <T> AbstractC0979l concatEager(t5.b bVar) {
        return AbstractC0979l.fromPublisher(bVar).concatMapEager(G0.f5511a);
    }

    public static <T> AbstractC0979l merge(t5.b bVar) {
        return merge(bVar, Integer.MAX_VALUE);
    }

    public static <T> AbstractC0979l mergeDelayError(t5.b bVar) {
        return mergeDelayError(bVar, Integer.MAX_VALUE);
    }

    public static <T> O sequenceEqual(y yVar, y yVar2, p027e3.d dVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(dVar, "isEqual is null");
        return io.reactivex.plugins.a.onAssembly(new C0771o3(yVar, 5, yVar2, dVar));
    }

    public static AbstractC0985s timer(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new Z(Math.max(0L, j6), timeUnit, n6));
    }

    public static <T, D> AbstractC0985s using(Callable<? extends D> callable, p027e3.o oVar, p027e3.g gVar, boolean z6) {
        p039g3.A.b(callable, "resourceSupplier is null");
        p039g3.A.b(oVar, "sourceSupplier is null");
        p039g3.A.b(gVar, "disposer is null");
        return io.reactivex.plugins.a.onAssembly(new J0(callable, oVar, gVar, z6));
    }

    public final AbstractC0985s delay(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C1040q(this, Math.max(0L, j6), timeUnit, n6));
    }

    public final AbstractC0985s onErrorComplete(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.F(this, qVar, 1));
    }

    public final AbstractC0979l repeat(long j6) {
        return toFlowable().repeat(j6);
    }

    public final AbstractC0985s retry(p027e3.d dVar) {
        return toFlowable().retry(dVar).singleElement();
    }

    public final p011b3.c subscribe(p027e3.g gVar) {
        return subscribe(gVar, p039g3.z.e, p039g3.z.c);
    }

    public final AbstractC0985s timeout(long j6, TimeUnit timeUnit, y yVar) {
        p039g3.A.b(yVar, "fallback is null");
        return timeout(j6, timeUnit, io.reactivex.schedulers.j.computation(), yVar);
    }

    public static <T> AbstractC0979l concat(y yVar, y yVar2) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        return concatArray(yVar, yVar2);
    }

    public static <T> AbstractC0979l concatDelayError(t5.b bVar) {
        return AbstractC0979l.fromPublisher(bVar).concatMapDelayError(G0.f5511a);
    }

    public static <T> AbstractC0985s error(Callable<? extends Throwable> callable) {
        p039g3.A.b(callable, "errorSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C1038o(callable, 1));
    }

    public static <T> AbstractC0985s fromFuture(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        p039g3.A.b(future, "future is null");
        p039g3.A.b(timeUnit, "unit is null");
        return io.reactivex.plugins.a.onAssembly(new Z(future, j6, timeUnit));
    }

    public static <T> AbstractC0979l merge(t5.b bVar, int i5) {
        p039g3.A.b(bVar, "source is null");
        p039g3.A.c(i5, "maxConcurrency");
        return io.reactivex.plugins.a.onAssembly(new C0786r1(bVar, G0.f5511a, false, i5, 1));
    }

    public static <T> AbstractC0979l mergeDelayError(t5.b bVar, int i5) {
        p039g3.A.b(bVar, "source is null");
        p039g3.A.c(i5, "maxConcurrency");
        return io.reactivex.plugins.a.onAssembly(new C0786r1(bVar, G0.f5511a, true, i5, 1));
    }

    public final AbstractC0985s delaySubscription(long j6, TimeUnit timeUnit) {
        return delaySubscription(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final <R> AbstractC0985s flatMap(p027e3.o oVar, p027e3.o oVar2, Callable<? extends y> callable) {
        p039g3.A.b(oVar, "onSuccessMapper is null");
        p039g3.A.b(oVar2, "onErrorMapper is null");
        p039g3.A.b(callable, "onCompleteSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.S(this, oVar, oVar2, callable));
    }

    public final AbstractC0985s retry(long j6) {
        return retry(j6, p039g3.z.f4012g);
    }

    public final p011b3.c subscribe(p027e3.g gVar, p027e3.g gVar2) {
        return subscribe(gVar, gVar2, p039g3.z.c);
    }

    public final O switchIfEmpty(V v6) {
        p039g3.A.b(v6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, v6, 4));
    }

    public final <U> AbstractC0985s takeUntil(t5.b bVar) {
        p039g3.A.b(bVar, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C1042t(this, bVar, 2));
    }

    public final p112t3.g test(boolean z6) {
        p112t3.g gVar = new p112t3.g();
        if (z6) {
            gVar.dispose();
        }
        subscribe(gVar);
        return gVar;
    }

    public final O toSingle() {
        return io.reactivex.plugins.a.onAssembly(new C1030k(this, null, 1));
    }

    public static <T1, T2, R> AbstractC0985s zip(y yVar, y yVar2, p027e3.c cVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        return zipArray(p039g3.z.a(cVar), yVar, yVar2);
    }

    public final AbstractC0985s delaySubscription(long j6, TimeUnit timeUnit, N n6) {
        return delaySubscription(AbstractC0979l.timer(j6, timeUnit, n6));
    }

    public final AbstractC0985s onErrorResumeNext(p027e3.o oVar) {
        p039g3.A.b(oVar, "resumeFunction is null");
        return io.reactivex.plugins.a.onAssembly(new C1037n0(this, oVar, true));
    }

    public final AbstractC0985s retry(long j6, p027e3.q qVar) {
        return toFlowable().retry(j6, qVar).singleElement();
    }

    public final p011b3.c subscribe(p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar) {
        p039g3.A.b(gVar, "onSuccess is null");
        p039g3.A.b(gVar2, "onError is null");
        p039g3.A.b(aVar, "onComplete is null");
        return (p011b3.c) subscribeWith(new C1018e(gVar, gVar2, aVar));
    }

    public final AbstractC0985s timeout(long j6, TimeUnit timeUnit, N n6, y yVar) {
        p039g3.A.b(yVar, "fallback is null");
        return timeout(timer(j6, timeUnit, n6), yVar);
    }

    public final Object blockingGet(Object obj) {
        p039g3.A.b(obj, "defaultValue is null");
        p048i3.g gVar = new p048i3.g(1);
        subscribe(gVar);
        if (gVar.getCount() != 0) {
            try {
                gVar.await();
            } catch (InterruptedException e) {
                gVar.b();
                throw p100r3.g.d(e);
            }
        }
        Throwable th = gVar.b;
        if (th == null) {
            Object obj2 = gVar.f4049a;
            return obj2 != null ? obj2 : obj;
        }
        throw p100r3.g.d(th);
    }

    public final <U, V> AbstractC0985s delay(t5.b bVar) {
        p039g3.A.b(bVar, "delayIndicator is null");
        return io.reactivex.plugins.a.onAssembly(new C1042t(this, bVar, 0));
    }

    public final AbstractC0985s retry(p027e3.q qVar) {
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, qVar);
    }

    public static <T> AbstractC0979l concat(y yVar, y yVar2, y yVar3) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        return concatArray(yVar, yVar2, yVar3);
    }

    public static <T> AbstractC0985s merge(y yVar) {
        p039g3.A.b(yVar, "source is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.W(yVar, p039g3.z.f4010a, 0));
    }

    public static <T> AbstractC0979l mergeDelayError(y yVar, y yVar2) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        return mergeArrayDelayError(yVar, yVar2);
    }

    public final AbstractC0985s timeout(long j6, TimeUnit timeUnit, N n6) {
        return timeout(timer(j6, timeUnit, n6));
    }

    public static <T1, T2, T3, R> AbstractC0985s zip(y yVar, y yVar2, y yVar3, p027e3.h hVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.z.b();
        throw null;
    }

    public final <U, R> AbstractC0985s flatMap(p027e3.o oVar, p027e3.c cVar) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.b(cVar, "resultSelector is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.J(this, oVar, cVar, 0));
    }

    public final <U> AbstractC0985s timeout(y yVar) {
        p039g3.A.b(yVar, "timeoutIndicator is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.J(this, yVar, null, 1));
    }

    public static <T> AbstractC0979l merge(y yVar, y yVar2) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        return mergeArray(yVar, yVar2);
    }

    @Override // io.reactivex.y
    public final void subscribe(InterfaceC0988v interfaceC0988v) {
        p039g3.A.b(interfaceC0988v, "observer is null");
        InterfaceC0988v interfaceC0988vOnSubscribe = io.reactivex.plugins.a.onSubscribe(this, interfaceC0988v);
        p039g3.A.b(interfaceC0988vOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            a(interfaceC0988vOnSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T> AbstractC0979l mergeDelayError(y yVar, y yVar2, y yVar3) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        return mergeArrayDelayError(yVar, yVar2, yVar3);
    }

    public final <U> AbstractC0985s timeout(y yVar, y yVar2) {
        p039g3.A.b(yVar, "timeoutIndicator is null");
        p039g3.A.b(yVar2, "fallback is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.J(this, yVar, yVar2, 1));
    }

    public static <T> AbstractC0979l concat(y yVar, y yVar2, y yVar3, y yVar4) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        return concatArray(yVar, yVar2, yVar3, yVar4);
    }

    public static <T> AbstractC0979l merge(y yVar, y yVar2, y yVar3) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        return mergeArray(yVar, yVar2, yVar3);
    }

    public static <T1, T2, T3, T4, R> AbstractC0985s zip(y yVar, y yVar2, y yVar3, y yVar4, p027e3.i iVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        p039g3.z.c();
        throw null;
    }

    public final <U> AbstractC0985s timeout(t5.b bVar) {
        p039g3.A.b(bVar, "timeoutIndicator is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.J(this, bVar, null, 2));
    }

    public static <T> AbstractC0979l mergeDelayError(y yVar, y yVar2, y yVar3, y yVar4) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        return mergeArrayDelayError(yVar, yVar2, yVar3, yVar4);
    }

    public final <U> AbstractC0985s timeout(t5.b bVar, y yVar) {
        p039g3.A.b(bVar, "timeoutIndicator is null");
        p039g3.A.b(yVar, "fallback is null");
        return io.reactivex.plugins.a.onAssembly(new p059k3.J(this, bVar, yVar, 2));
    }

    public static <T> AbstractC0979l concat(t5.b bVar) {
        return concat(bVar, 2);
    }

    public static <T> AbstractC0979l merge(y yVar, y yVar2, y yVar3, y yVar4) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        return mergeArray(yVar, yVar2, yVar3, yVar4);
    }

    public static <T> AbstractC0979l concat(t5.b bVar, int i5) {
        p039g3.A.b(bVar, "sources is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new C0708e0(bVar, G0.f5511a, i5));
    }

    public static <T1, T2, T3, T4, T5, R> AbstractC0985s zip(y yVar, y yVar2, y yVar3, y yVar4, y yVar5, p027e3.j jVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        p039g3.A.b(yVar5, "source5 is null");
        p039g3.z.d();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, R> AbstractC0985s zip(y yVar, y yVar2, y yVar3, y yVar4, y yVar5, y yVar6, p027e3.k kVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        p039g3.A.b(yVar5, "source5 is null");
        p039g3.A.b(yVar6, "source6 is null");
        p039g3.z.e();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC0985s zip(y yVar, y yVar2, y yVar3, y yVar4, y yVar5, y yVar6, y yVar7, p027e3.l lVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        p039g3.A.b(yVar5, "source5 is null");
        p039g3.A.b(yVar6, "source6 is null");
        p039g3.A.b(yVar7, "source7 is null");
        p039g3.z.f();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC0985s zip(y yVar, y yVar2, y yVar3, y yVar4, y yVar5, y yVar6, y yVar7, y yVar8, p027e3.m mVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        p039g3.A.b(yVar5, "source5 is null");
        p039g3.A.b(yVar6, "source6 is null");
        p039g3.A.b(yVar7, "source7 is null");
        p039g3.A.b(yVar8, "source8 is null");
        p039g3.z.g();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC0985s zip(y yVar, y yVar2, y yVar3, y yVar4, y yVar5, y yVar6, y yVar7, y yVar8, y yVar9, p027e3.n nVar) {
        p039g3.A.b(yVar, "source1 is null");
        p039g3.A.b(yVar2, "source2 is null");
        p039g3.A.b(yVar3, "source3 is null");
        p039g3.A.b(yVar4, "source4 is null");
        p039g3.A.b(yVar5, "source5 is null");
        p039g3.A.b(yVar6, "source6 is null");
        p039g3.A.b(yVar7, "source7 is null");
        p039g3.A.b(yVar8, "source8 is null");
        p039g3.A.b(yVar9, "source9 is null");
        p039g3.z.h();
        throw null;
    }
}
