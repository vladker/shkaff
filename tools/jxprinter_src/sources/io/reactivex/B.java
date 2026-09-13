package io.reactivex;

import A3.AbstractC0157z;
import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.operators.flowable.C0695c;
import io.reactivex.internal.operators.flowable.C0725h;
import io.reactivex.internal.operators.flowable.C0756m0;
import io.reactivex.internal.operators.flowable.C0771o3;
import io.reactivex.internal.operators.flowable.C0817w2;
import io.reactivex.internal.operators.flowable.C0834z1;
import io.reactivex.internal.operators.observable.B0;
import io.reactivex.internal.operators.observable.B1;
import io.reactivex.internal.operators.observable.B3;
import io.reactivex.internal.operators.observable.C0;
import io.reactivex.internal.operators.observable.C0839a0;
import io.reactivex.internal.operators.observable.C0846b2;
import io.reactivex.internal.operators.observable.C0850c1;
import io.reactivex.internal.operators.observable.C0851c2;
import io.reactivex.internal.operators.observable.C0853d;
import io.reactivex.internal.operators.observable.C0864f0;
import io.reactivex.internal.operators.observable.C0867f3;
import io.reactivex.internal.operators.observable.C0873h;
import io.reactivex.internal.operators.observable.C0875h1;
import io.reactivex.internal.operators.observable.C0876h2;
import io.reactivex.internal.operators.observable.C0879i0;
import io.reactivex.internal.operators.observable.C0880i1;
import io.reactivex.internal.operators.observable.C0883j;
import io.reactivex.internal.operators.observable.C0884j0;
import io.reactivex.internal.operators.observable.C0894l0;
import io.reactivex.internal.operators.observable.C0895l1;
import io.reactivex.internal.operators.observable.C0898m;
import io.reactivex.internal.operators.observable.C0905n1;
import io.reactivex.internal.operators.observable.C0910o1;
import io.reactivex.internal.operators.observable.C0915p1;
import io.reactivex.internal.operators.observable.C0918q;
import io.reactivex.internal.operators.observable.C0920q1;
import io.reactivex.internal.operators.observable.C0921q2;
import io.reactivex.internal.operators.observable.C0924r1;
import io.reactivex.internal.operators.observable.C0931s3;
import io.reactivex.internal.operators.observable.C0933t0;
import io.reactivex.internal.operators.observable.C0934t1;
import io.reactivex.internal.operators.observable.C0937u;
import io.reactivex.internal.operators.observable.C0939u1;
import io.reactivex.internal.operators.observable.C0940u2;
import io.reactivex.internal.operators.observable.C0944v1;
import io.reactivex.internal.operators.observable.C0950x;
import io.reactivex.internal.operators.observable.C0952x1;
import io.reactivex.internal.operators.observable.C0959z0;
import io.reactivex.internal.operators.observable.C0960z1;
import io.reactivex.internal.operators.observable.C0961z2;
import io.reactivex.internal.operators.observable.C2;
import io.reactivex.internal.operators.observable.CallableC0885j1;
import io.reactivex.internal.operators.observable.CallableC0890k1;
import io.reactivex.internal.operators.observable.CallableC0929s1;
import io.reactivex.internal.operators.observable.CallableC0948w1;
import io.reactivex.internal.operators.observable.D1;
import io.reactivex.internal.operators.observable.F1;
import io.reactivex.internal.operators.observable.F3;
import io.reactivex.internal.operators.observable.G0;
import io.reactivex.internal.operators.observable.J0;
import io.reactivex.internal.operators.observable.M0;
import io.reactivex.internal.operators.observable.M3;
import io.reactivex.internal.operators.observable.O1;
import io.reactivex.internal.operators.observable.Q1;
import io.reactivex.internal.operators.observable.Q2;
import io.reactivex.internal.operators.observable.R3;
import io.reactivex.internal.operators.observable.S2;
import io.reactivex.internal.operators.observable.T0;
import io.reactivex.internal.operators.observable.U0;
import io.reactivex.internal.operators.observable.U1;
import io.reactivex.internal.operators.observable.U2;
import io.reactivex.internal.operators.observable.V0;
import io.reactivex.internal.operators.observable.V1;
import io.reactivex.internal.operators.observable.X;
import io.reactivex.internal.operators.observable.X2;
import io.reactivex.internal.operators.observable.Y0;
import io.reactivex.internal.operators.observable.Z;
import io.reactivex.internal.operators.observable.Z1;
import io.reactivex.internal.operators.observable.Z2;
import io.reactivex.internal.operators.observable.w3;
import io.reactivex.internal.operators.observable.z3;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p039g3.C0664a;
import p065l3.C1154e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class B<T> implements G {
    public static <T> B<T> amb(Iterable<? extends G> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0898m(null, iterable, 0));
    }

    public static <T> B<T> ambArray(G... gArr) {
        p039g3.A.b(gArr, "sources is null");
        int length = gArr.length;
        if (length == 0) {
            return empty();
        }
        return length == 1 ? wrap(gArr[0]) : io.reactivex.plugins.a.onAssembly(new C0898m(gArr, null, 0));
    }

    public static <T, R> B<R> combineLatest(Iterable<? extends G> iterable, p027e3.o oVar) {
        return combineLatest(iterable, oVar, AbstractC0979l.f5366a);
    }

    public static <T, R> B<R> combineLatestDelayError(Iterable<? extends G> iterable, p027e3.o oVar) {
        return combineLatestDelayError(iterable, oVar, AbstractC0979l.f5366a);
    }

    public static <T> B<T> concat(G g6) {
        return concat(g6, AbstractC0979l.f5366a);
    }

    public static <T> B<T> concatArray(G... gArr) {
        if (gArr.length == 0) {
            return empty();
        }
        if (gArr.length == 1) {
            return wrap(gArr[0]);
        }
        return io.reactivex.plugins.a.onAssembly(new C0918q(fromArray(gArr), p039g3.z.f4010a, AbstractC0979l.f5366a, 2));
    }

    public static <T> B<T> concatArrayDelayError(G... gArr) {
        if (gArr.length == 0) {
            return empty();
        }
        return gArr.length == 1 ? wrap(gArr[0]) : concatDelayError(fromArray(gArr));
    }

    public static <T> B<T> concatArrayEager(G... gArr) {
        int i5 = AbstractC0979l.f5366a;
        return concatArrayEager(i5, i5, gArr);
    }

    public static <T> B<T> concatArrayEagerDelayError(G... gArr) {
        int i5 = AbstractC0979l.f5366a;
        return concatArrayEagerDelayError(i5, i5, gArr);
    }

    public static <T> B<T> concatDelayError(G g6) {
        return concatDelayError(g6, AbstractC0979l.f5366a, true);
    }

    public static <T> B<T> concatEager(G g6) {
        int i5 = AbstractC0979l.f5366a;
        return concatEager(g6, i5, i5);
    }

    public static <T> B<T> create(E e) {
        p039g3.A.b(e, "source is null");
        return io.reactivex.plugins.a.onAssembly(new O1(1));
    }

    public static <T> B<T> defer(Callable<? extends G> callable) {
        p039g3.A.b(callable, "supplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0884j0(callable, 0));
    }

    private B<T> doOnEach(p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar, p027e3.a aVar2) {
        p039g3.A.b(gVar, "onNext is null");
        p039g3.A.b(gVar2, "onError is null");
        p039g3.A.b(aVar, "onComplete is null");
        p039g3.A.b(aVar2, "onAfterTerminate is null");
        return io.reactivex.plugins.a.onAssembly(new C0875h1(this, gVar, gVar2, aVar, aVar2, 2));
    }

    public static <T> B<T> empty() {
        return io.reactivex.plugins.a.onAssembly(C0.f4884a);
    }

    public static <T> B<T> error(Callable<? extends Throwable> callable) {
        p039g3.A.b(callable, "errorSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0884j0(callable, 1));
    }

    public static <T> B<T> fromArray(T... tArr) {
        p039g3.A.b(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        return tArr.length == 1 ? just(tArr[0]) : io.reactivex.plugins.a.onAssembly(new T0(tArr, 0));
    }

    public static <T> B<T> fromCallable(Callable<? extends T> callable) {
        p039g3.A.b(callable, "supplier is null");
        return io.reactivex.plugins.a.onAssembly(new U0(callable));
    }

    public static <T> B<T> fromFuture(Future<? extends T> future) {
        p039g3.A.b(future, "future is null");
        return io.reactivex.plugins.a.onAssembly(new V0(future, 0L, (TimeUnit) null));
    }

    public static <T> B<T> fromIterable(Iterable<? extends T> iterable) {
        p039g3.A.b(iterable, "source is null");
        return io.reactivex.plugins.a.onAssembly(new T0(iterable, 1));
    }

    public static <T> B<T> fromPublisher(t5.b bVar) {
        p039g3.A.b(bVar, "publisher is null");
        return io.reactivex.plugins.a.onAssembly(new T0(bVar, 2));
    }

    public static <T> B<T> generate(p027e3.g gVar) {
        p039g3.A.b(gVar, "generator is null");
        return generate(p039g3.z.f4014i, new C0944v1(gVar), p039g3.z.d);
    }

    public static B<Long> interval(long j6, long j7, TimeUnit timeUnit) {
        return interval(j6, j7, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public static B<Long> intervalRange(long j6, long j7, long j8, long j9, TimeUnit timeUnit) {
        return intervalRange(j6, j7, j8, j9, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public static <T> B<T> just(T t6) {
        p039g3.A.b(t6, "item is null");
        return io.reactivex.plugins.a.onAssembly(new D1(t6));
    }

    public static <T> B<T> merge(Iterable<? extends G> iterable, int i5, int i6) {
        return fromIterable(iterable).flatMap((p027e3.o) p039g3.z.f4010a, false, i5, i6);
    }

    public static <T> B<T> mergeArray(int i5, int i6, G... gArr) {
        return fromArray(gArr).flatMap((p027e3.o) p039g3.z.f4010a, false, i5, i6);
    }

    public static <T> B<T> mergeArrayDelayError(int i5, int i6, G... gArr) {
        return fromArray(gArr).flatMap((p027e3.o) p039g3.z.f4010a, true, i5, i6);
    }

    public static <T> B<T> mergeDelayError(Iterable<? extends G> iterable) {
        return fromIterable(iterable).flatMap((p027e3.o) p039g3.z.f4010a, true);
    }

    public static <T> B<T> never() {
        return io.reactivex.plugins.a.onAssembly(O1.b);
    }

    public static B<Integer> range(int i5, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "count >= 0 required but it was "));
        }
        if (i6 == 0) {
            return empty();
        }
        if (i6 == 1) {
            return just(Integer.valueOf(i5));
        }
        if (((long) i5) + ((long) (i6 - 1)) <= 2147483647L) {
            return io.reactivex.plugins.a.onAssembly(new Z1(i5, i6));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    public static B<Long> rangeLong(long j6, long j7) {
        if (j7 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j7, "count >= 0 required but it was "));
        }
        if (j7 == 0) {
            return empty();
        }
        if (j7 == 1) {
            return just(Long.valueOf(j6));
        }
        long j8 = (j7 - 1) + j6;
        if (j6 <= 0 || j8 >= 0) {
            return io.reactivex.plugins.a.onAssembly(new C0846b2(j6, j7));
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    public static <T> O sequenceEqual(G g6, G g7, p027e3.d dVar) {
        return sequenceEqual(g6, g7, dVar, AbstractC0979l.f5366a);
    }

    public static <T> B<T> switchOnNext(G g6) {
        return switchOnNext(g6, AbstractC0979l.f5366a);
    }

    public static <T> B<T> switchOnNextDelayError(G g6) {
        return switchOnNextDelayError(g6, AbstractC0979l.f5366a);
    }

    public static B<Long> timer(long j6, TimeUnit timeUnit) {
        return timer(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public static <T> B<T> unsafeCreate(G g6) {
        p039g3.A.b(g6, "onSubscribe is null");
        if (g6 instanceof B) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return io.reactivex.plugins.a.onAssembly(new T0(g6, 3));
    }

    public static <T, D> B<T> using(Callable<? extends D> callable, p027e3.o oVar, p027e3.g gVar) {
        return using(callable, oVar, gVar, true);
    }

    public static <T> B<T> wrap(G g6) {
        p039g3.A.b(g6, "source is null");
        return g6 instanceof B ? io.reactivex.plugins.a.onAssembly((B) g6) : io.reactivex.plugins.a.onAssembly(new T0(g6, 3));
    }

    public static <T, R> B<R> zip(Iterable<? extends G> iterable, p027e3.o oVar) {
        p039g3.A.b(oVar, "zipper is null");
        p039g3.A.b(iterable, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.K(null, iterable, oVar, AbstractC0979l.f5366a, false, 1));
    }

    public static <T, R> B<R> zipArray(p027e3.o oVar, boolean z6, int i5, G... gArr) {
        if (gArr.length == 0) {
            return empty();
        }
        p039g3.A.b(oVar, "zipper is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.K(gArr, null, oVar, i5, z6, 1));
    }

    public static <T, R> B<R> zipIterable(Iterable<? extends G> iterable, p027e3.o oVar, boolean z6, int i5) {
        p039g3.A.b(oVar, "zipper is null");
        p039g3.A.b(iterable, "sources is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.K(null, iterable, oVar, i5, z6, 1));
    }

    public final O all(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new C0883j(this, qVar, 0));
    }

    public final B<T> ambWith(G g6) {
        p039g3.A.b(g6, "other is null");
        return ambArray(this, g6);
    }

    public final O any(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new C0883j(this, qVar, 1));
    }

    public final <R> R as(C c) {
        p039g3.A.b(c, "converter is null");
        throw new ClassCastException();
    }

    public abstract void b(I i5);

    public final T blockingFirst() {
        p048i3.f fVar = new p048i3.f(1, 0);
        subscribe(fVar);
        T t6 = (T) fVar.a();
        if (t6 != null) {
            return t6;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(p027e3.g gVar) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                gVar.accept(it.next());
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                ((p011b3.c) it).dispose();
                throw p100r3.g.d(th);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(AbstractC0979l.f5366a);
    }

    public final T blockingLast() {
        p048i3.f fVar = new p048i3.f(1, 1);
        subscribe(fVar);
        T t6 = (T) fVar.a();
        if (t6 != null) {
            return t6;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new C0853d(this, 0);
    }

    public final Iterable<T> blockingMostRecent(T t6) {
        return new C0725h(this, t6, 1);
    }

    public final Iterable<T> blockingNext() {
        return new C0853d(this, 1);
    }

    public final T blockingSingle() {
        T t6 = (T) singleElement().blockingGet();
        if (t6 != null) {
            return t6;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        p100r3.d dVar = new p100r3.d(1);
        V1.b bVar = p039g3.z.d;
        p048i3.r rVar = new p048i3.r(bVar, dVar, dVar, bVar);
        subscribe(rVar);
        p002a.c.a(dVar, rVar);
        Throwable th = dVar.f7959a;
        if (th != null) {
            throw p100r3.g.d(th);
        }
    }

    public final B<List<T>> buffer(int i5) {
        return buffer(i5, i5);
    }

    public final B c(long j6, TimeUnit timeUnit, N n6, G g6) {
        p039g3.A.b(timeUnit, "timeUnit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0931s3(this, j6, timeUnit, n6, g6));
    }

    public final B<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final B<T> cacheWithInitialCapacity(int i5) {
        p039g3.A.c(i5, "initialCapacity");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.F(this, i5));
    }

    public final <U> B<U> cast(Class<U> cls) {
        p039g3.A.b(cls, "clazz is null");
        return (B<U>) map(new p039g3.f(cls));
    }

    public final <U> O collect(Callable<? extends U> callable, p027e3.b bVar) {
        p039g3.A.b(callable, "initialValueSupplier is null");
        p039g3.A.b(bVar, "collector is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.H(this, callable, bVar));
    }

    public final <U> O collectInto(U u6, p027e3.b bVar) {
        p039g3.A.b(u6, "initialValue is null");
        return collect(new p039g3.m(u6), bVar);
    }

    public final <R> B<R> compose(H h6) {
        p039g3.A.b(h6, "composer is null");
        throw new ClassCastException();
    }

    public final <R> B<R> concatMap(p027e3.o oVar) {
        return concatMap(oVar, 2);
    }

    public final AbstractC0676c concatMapCompletable(p027e3.o oVar) {
        return concatMapCompletable(oVar, 2);
    }

    public final AbstractC0676c concatMapCompletableDelayError(p027e3.o oVar) {
        return concatMapCompletableDelayError(oVar, true, 2);
    }

    public final <R> B<R> concatMapDelayError(p027e3.o oVar) {
        return concatMapDelayError(oVar, AbstractC0979l.f5366a, true);
    }

    public final <R> B<R> concatMapEager(p027e3.o oVar) {
        return concatMapEager(oVar, Integer.MAX_VALUE, AbstractC0979l.f5366a);
    }

    public final <R> B<R> concatMapEagerDelayError(p027e3.o oVar, boolean z6) {
        return concatMapEagerDelayError(oVar, Integer.MAX_VALUE, AbstractC0979l.f5366a, z6);
    }

    public final <U> B<U> concatMapIterable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 2));
    }

    public final <R> B<R> concatMapMaybe(p027e3.o oVar) {
        return concatMapMaybe(oVar, 2);
    }

    public final <R> B<R> concatMapMaybeDelayError(p027e3.o oVar) {
        return concatMapMaybeDelayError(oVar, true, 2);
    }

    public final <R> B<R> concatMapSingle(p027e3.o oVar) {
        return concatMapSingle(oVar, 2);
    }

    public final <R> B<R> concatMapSingleDelayError(p027e3.o oVar) {
        return concatMapSingleDelayError(oVar, true, 2);
    }

    public final B<T> concatWith(G g6) {
        p039g3.A.b(g6, "other is null");
        return concat(this, g6);
    }

    public final O contains(Object obj) {
        p039g3.A.b(obj, "element is null");
        return any(new p039g3.j(obj));
    }

    public final O count() {
        return io.reactivex.plugins.a.onAssembly(new C0839a0(this));
    }

    public final B d(G g6, p027e3.o oVar, G g7) {
        p039g3.A.b(oVar, "itemTimeoutIndicator is null");
        return io.reactivex.plugins.a.onAssembly(new C0937u(this, g6, oVar, g7, 2));
    }

    public final <U> B<T> debounce(p027e3.o oVar) {
        p039g3.A.b(oVar, "debounceSelector is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 0));
    }

    public final B<T> defaultIfEmpty(T t6) {
        p039g3.A.b(t6, "defaultItem is null");
        return switchIfEmpty(just(t6));
    }

    public final <U> B<T> delay(p027e3.o oVar) {
        p039g3.A.b(oVar, "itemDelay is null");
        return (B<T>) flatMap(new C0910o1(oVar));
    }

    public final <U> B<T> delaySubscription(G g6) {
        p039g3.A.b(g6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new C0898m(this, g6, 1));
    }

    @Deprecated
    public final <T2> B<T2> dematerialize() {
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, p039g3.z.f4010a, 1));
    }

    public final B<T> distinct() {
        return distinct(p039g3.z.f4010a, p039g3.l.f3998a);
    }

    public final B<T> distinctUntilChanged() {
        return distinctUntilChanged((p027e3.o) p039g3.z.f4010a);
    }

    public final B<T> doAfterNext(p027e3.g gVar) {
        p039g3.A.b(gVar, "onAfterNext is null");
        return io.reactivex.plugins.a.onAssembly(new C0933t0(this, gVar, 0));
    }

    public final B<T> doAfterTerminate(p027e3.a aVar) {
        p039g3.A.b(aVar, "onFinally is null");
        V1.b bVar = p039g3.z.d;
        return doOnEach(bVar, bVar, p039g3.z.c, aVar);
    }

    public final B<T> doFinally(p027e3.a aVar) {
        p039g3.A.b(aVar, "onFinally is null");
        return io.reactivex.plugins.a.onAssembly(new C0933t0(this, aVar, 1));
    }

    public final B<T> doOnComplete(p027e3.a aVar) {
        V1.b bVar = p039g3.z.d;
        return doOnEach(bVar, bVar, aVar, p039g3.z.c);
    }

    public final B<T> doOnDispose(p027e3.a aVar) {
        return doOnLifecycle(p039g3.z.d, aVar);
    }

    public final B<T> doOnError(p027e3.g gVar) {
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return doOnEach(bVar, gVar, hVar, hVar);
    }

    public final B<T> doOnLifecycle(p027e3.g gVar, p027e3.a aVar) {
        p039g3.A.b(gVar, "onSubscribe is null");
        p039g3.A.b(aVar, "onDispose is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, gVar, aVar, 5));
    }

    public final B<T> doOnNext(p027e3.g gVar) {
        V1.b bVar = p039g3.z.d;
        p039g3.h hVar = p039g3.z.c;
        return doOnEach(gVar, bVar, hVar, hVar);
    }

    public final B<T> doOnSubscribe(p027e3.g gVar) {
        return doOnLifecycle(gVar, p039g3.z.c);
    }

    public final B<T> doOnTerminate(p027e3.a aVar) {
        p039g3.A.b(aVar, "onTerminate is null");
        return doOnEach(p039g3.z.d, new C0664a(aVar), aVar, p039g3.z.c);
    }

    public final AbstractC0985s elementAt(long j6) {
        if (j6 >= 0) {
            return io.reactivex.plugins.a.onAssembly(new C0959z0(this, j6));
        }
        throw new IndexOutOfBoundsException(androidx.collection.a.j(j6, "index >= 0 required but it was "));
    }

    public final O elementAtOrError(long j6) {
        if (j6 >= 0) {
            return io.reactivex.plugins.a.onAssembly(new B0(this, j6, null));
        }
        throw new IndexOutOfBoundsException(androidx.collection.a.j(j6, "index >= 0 required but it was "));
    }

    public final B<T> filter(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new C0873h(this, qVar, 2));
    }

    public final O first(T t6) {
        return elementAt(0L, t6);
    }

    public final AbstractC0985s firstElement() {
        return elementAt(0L);
    }

    public final O firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> B<R> flatMap(p027e3.o oVar, int i5) {
        return flatMap(oVar, false, i5, AbstractC0979l.f5366a);
    }

    public final AbstractC0676c flatMapCompletable(p027e3.o oVar) {
        return flatMapCompletable(oVar, false);
    }

    public final <U> B<U> flatMapIterable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 2));
    }

    public final <R> B<R> flatMapMaybe(p027e3.o oVar) {
        return flatMapMaybe(oVar, false);
    }

    public final <R> B<R> flatMapSingle(p027e3.o oVar) {
        return flatMapSingle(oVar, false);
    }

    public final p011b3.c forEach(p027e3.g gVar) {
        return subscribe(gVar);
    }

    public final p011b3.c forEachWhile(p027e3.q qVar) {
        return forEachWhile(qVar, p039g3.z.e, p039g3.z.c);
    }

    public final <K> B<p106s3.b> groupBy(p027e3.o oVar) {
        return groupBy(oVar, p039g3.z.f4010a, false, AbstractC0979l.f5366a);
    }

    public final <TRight, TLeftEnd, TRightEnd, R> B<R> groupJoin(G g6, p027e3.o oVar, p027e3.o oVar2, p027e3.c cVar) {
        p039g3.A.b(g6, "other is null");
        p039g3.A.b(oVar, "leftEnd is null");
        p039g3.A.b(oVar2, "rightEnd is null");
        p039g3.A.b(cVar, "resultSelector is null");
        return io.reactivex.plugins.a.onAssembly(new C0875h1(this, g6, oVar, oVar2, cVar, 0));
    }

    public final B<T> hide() {
        return io.reactivex.plugins.a.onAssembly(new Z(this, 2));
    }

    public final AbstractC0676c ignoreElements() {
        return io.reactivex.plugins.a.onAssembly(new C0880i1(this));
    }

    public final O isEmpty() {
        return all(p039g3.z.f4013h);
    }

    public final <TRight, TLeftEnd, TRightEnd, R> B<R> join(G g6, p027e3.o oVar, p027e3.o oVar2, p027e3.c cVar) {
        p039g3.A.b(g6, "other is null");
        p039g3.A.b(oVar, "leftEnd is null");
        p039g3.A.b(oVar2, "rightEnd is null");
        p039g3.A.b(cVar, "resultSelector is null");
        return io.reactivex.plugins.a.onAssembly(new C0875h1(this, g6, oVar, oVar2, cVar, 1));
    }

    public final O last(T t6) {
        p039g3.A.b(t6, "defaultItem is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, t6, 1));
    }

    public final AbstractC0985s lastElement() {
        return io.reactivex.plugins.a.onAssembly(new F1(this, 0));
    }

    public final O lastOrError() {
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, null, 1));
    }

    public final <R> B<R> lift(F f6) {
        p039g3.A.b(f6, "lifter is null");
        return io.reactivex.plugins.a.onAssembly(new Z(this, 4));
    }

    public final <R> B<R> map(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 3));
    }

    public final B<A> materialize() {
        return io.reactivex.plugins.a.onAssembly(new Z(this, 5));
    }

    public final B<T> mergeWith(G g6) {
        p039g3.A.b(g6, "other is null");
        return merge(this, g6);
    }

    public final B<T> observeOn(N n6) {
        return observeOn(n6, false, AbstractC0979l.f5366a);
    }

    public final <U> B<U> ofType(Class<U> cls) {
        p039g3.A.b(cls, "clazz is null");
        return filter(new p039g3.g(cls)).cast(cls);
    }

    public final B<T> onErrorResumeNext(p027e3.o oVar) {
        p039g3.A.b(oVar, "resumeFunction is null");
        return io.reactivex.plugins.a.onAssembly(new J0(this, oVar, false, 3));
    }

    public final B<T> onErrorReturn(p027e3.o oVar) {
        p039g3.A.b(oVar, "valueSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 4));
    }

    public final B<T> onErrorReturnItem(T t6) {
        p039g3.A.b(t6, "item is null");
        return onErrorReturn(new p039g3.m(t6));
    }

    public final B<T> onExceptionResumeNext(G g6) {
        p039g3.A.b(g6, "next is null");
        return io.reactivex.plugins.a.onAssembly(new J0(this, new p039g3.m(g6), true, 3));
    }

    public final B<T> onTerminateDetach() {
        return io.reactivex.plugins.a.onAssembly(new Z(this, 1));
    }

    public final p106s3.a publish() {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.plugins.a.onAssembly((p106s3.a) new V1(new U1(atomicReference), this, atomicReference));
    }

    public final AbstractC0985s reduce(p027e3.c cVar) {
        p039g3.A.b(cVar, "reducer is null");
        return io.reactivex.plugins.a.onAssembly(new C0851c2(this, cVar, 0));
    }

    public final <R> O reduceWith(Callable<R> callable, p027e3.c cVar) {
        p039g3.A.b(callable, "seedSupplier is null");
        p039g3.A.b(cVar, "reducer is null");
        return io.reactivex.plugins.a.onAssembly(new C0771o3(this, 3, callable, cVar));
    }

    public final B<T> repeat() {
        return repeat(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public final B<T> repeatUntil(p027e3.e eVar) {
        p039g3.A.b(eVar, "stop is null");
        return io.reactivex.plugins.a.onAssembly(new C0933t0(this, eVar, 2));
    }

    public final B<T> repeatWhen(p027e3.o oVar) {
        p039g3.A.b(oVar, "handler is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 6));
    }

    public final p106s3.a replay() {
        return C0961z2.e(this, C0961z2.e);
    }

    public final B<T> retry() {
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, p039g3.z.f4012g);
    }

    public final B<T> retryUntil(p027e3.e eVar) {
        p039g3.A.b(eVar, "stop is null");
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, new p039g3.d(eVar));
    }

    public final B<T> retryWhen(p027e3.o oVar) {
        p039g3.A.b(oVar, "handler is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 7));
    }

    public final void safeSubscribe(I i5) {
        p039g3.A.b(i5, "observer is null");
        if (i5 instanceof p112t3.d) {
            subscribe(i5);
        } else {
            subscribe(new p112t3.d(i5));
        }
    }

    public final B<T> sample(long j6, TimeUnit timeUnit) {
        return sample(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final B<T> scan(p027e3.c cVar) {
        p039g3.A.b(cVar, "accumulator is null");
        return io.reactivex.plugins.a.onAssembly(new C0933t0(this, cVar, 4));
    }

    public final <R> B<R> scanWith(Callable<R> callable, p027e3.c cVar) {
        p039g3.A.b(callable, "seedSupplier is null");
        p039g3.A.b(cVar, "accumulator is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, callable, cVar, 6));
    }

    public final B<T> serialize() {
        return io.reactivex.plugins.a.onAssembly(new Z(this, 6));
    }

    public final B<T> share() {
        return (B<T>) publish().refCount();
    }

    public final O single(T t6) {
        p039g3.A.b(t6, "defaultItem is null");
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, t6, 2));
    }

    public final AbstractC0985s singleElement() {
        return io.reactivex.plugins.a.onAssembly(new F1(this, 1));
    }

    public final O singleOrError() {
        return io.reactivex.plugins.a.onAssembly(new C0817w2(this, null, 2));
    }

    public final B<T> skip(long j6) {
        return j6 <= 0 ? io.reactivex.plugins.a.onAssembly(this) : io.reactivex.plugins.a.onAssembly(new C0876h2(this, j6, 1));
    }

    public final B<T> skipLast(long j6, TimeUnit timeUnit, N n6) {
        return skipLast(j6, timeUnit, n6, false, AbstractC0979l.f5366a);
    }

    public final <U> B<T> skipUntil(G g6) {
        p039g3.A.b(g6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new X2(this, g6, 0));
    }

    public final B<T> skipWhile(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new C0873h(this, qVar, 3));
    }

    public final B<T> sorted() {
        return toList().toObservable().map(new p039g3.n(p039g3.p.f4001a)).flatMapIterable(p039g3.z.f4010a);
    }

    public final B<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final B<T> startWithArray(T... tArr) {
        B bFromArray = fromArray(tArr);
        return bFromArray == empty() ? io.reactivex.plugins.a.onAssembly(this) : concatArray(bFromArray, this);
    }

    public final p011b3.c subscribe() {
        p039g3.u uVar = p039g3.z.e;
        p039g3.h hVar = p039g3.z.c;
        V1.b bVar = p039g3.z.d;
        return subscribe(bVar, uVar, hVar, bVar);
    }

    public final B<T> subscribeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new Z2(this, n6, 0));
    }

    public final <E extends I> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final B<T> switchIfEmpty(G g6) {
        p039g3.A.b(g6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new X2(this, g6, 1));
    }

    public final <R> B<R> switchMap(p027e3.o oVar) {
        return switchMap(oVar, AbstractC0979l.f5366a);
    }

    public final AbstractC0676c switchMapCompletable(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p065l3.m(this, oVar, false, 1));
    }

    public final AbstractC0676c switchMapCompletableDelayError(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p065l3.m(this, oVar, true, 1));
    }

    public final <R> B<R> switchMapDelayError(p027e3.o oVar) {
        return switchMapDelayError(oVar, AbstractC0979l.f5366a);
    }

    public final <R> B<R> switchMapMaybe(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p065l3.G(this, oVar, false, 0));
    }

    public final <R> B<R> switchMapMaybeDelayError(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p065l3.G(this, oVar, true, 0));
    }

    public final <R> B<R> switchMapSingle(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p065l3.G(this, oVar, false, 1));
    }

    public final <R> B<R> switchMapSingleDelayError(p027e3.o oVar) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new p065l3.G(this, oVar, true, 1));
    }

    public final B<T> take(long j6) {
        if (j6 >= 0) {
            return io.reactivex.plugins.a.onAssembly(new C0876h2(this, j6, 2));
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j6, "count >= 0 required but it was "));
    }

    public final B<T> takeLast(long j6, long j7, TimeUnit timeUnit, N n6) {
        return takeLast(j6, j7, timeUnit, n6, false, AbstractC0979l.f5366a);
    }

    public final <U> B<T> takeUntil(G g6) {
        p039g3.A.b(g6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new X2(this, g6, 2));
    }

    public final B<T> takeWhile(p027e3.q qVar) {
        p039g3.A.b(qVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new C0873h(this, qVar, 5));
    }

    public final p112t3.g test() {
        p112t3.g gVar = new p112t3.g();
        subscribe(gVar);
        return gVar;
    }

    public final B<T> throttleFirst(long j6, TimeUnit timeUnit) {
        return throttleFirst(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final B<T> throttleLast(long j6, TimeUnit timeUnit) {
        return sample(j6, timeUnit);
    }

    public final B<T> throttleLatest(long j6, TimeUnit timeUnit) {
        return throttleLatest(j6, timeUnit, io.reactivex.schedulers.j.computation(), false);
    }

    public final B<T> throttleWithTimeout(long j6, TimeUnit timeUnit) {
        return debounce(j6, timeUnit);
    }

    public final B<io.reactivex.schedulers.k> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, io.reactivex.schedulers.j.computation());
    }

    public final <V> B<T> timeout(p027e3.o oVar) {
        return d(null, oVar, null);
    }

    public final B<io.reactivex.schedulers.k> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, io.reactivex.schedulers.j.computation());
    }

    public final <R> R to(p027e3.o oVar) {
        try {
            p039g3.A.b(oVar, "converter is null");
            return (R) oVar.apply(this);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            throw p100r3.g.d(th);
        }
    }

    public final AbstractC0979l toFlowable(EnumC0675b enumC0675b) {
        C0834z1 c0834z1 = new C0834z1(this, 1);
        int iOrdinal = enumC0675b.ordinal();
        if (iOrdinal == 0) {
            return c0834z1;
        }
        if (iOrdinal == 1) {
            return io.reactivex.plugins.a.onAssembly(new C0756m0(c0834z1, 6));
        }
        if (iOrdinal != 3) {
            return iOrdinal != 4 ? c0834z1.onBackpressureBuffer() : c0834z1.onBackpressureLatest();
        }
        return c0834z1.onBackpressureDrop();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new p048i3.o());
    }

    public final O toList() {
        return toList(16);
    }

    public final <K> O toMap(p027e3.o oVar) {
        p039g3.A.b(oVar, "keySelector is null");
        return collect(p100r3.h.f7962a, new p039g3.w(oVar));
    }

    public final <K> O toMultimap(p027e3.o oVar) {
        return toMultimap(oVar, p039g3.z.f4010a, p100r3.h.f7962a, p100r3.b.f7958a);
    }

    public final O toSortedList() {
        return toSortedList(p039g3.z.f4015j);
    }

    public final B<T> unsubscribeOn(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new Z2(this, n6, 1));
    }

    public final B<B<T>> window(long j6) {
        return window(j6, j6, AbstractC0979l.f5366a);
    }

    public final <U, R> B<R> withLatestFrom(G g6, p027e3.c cVar) {
        p039g3.A.b(g6, "other is null");
        p039g3.A.b(cVar, "combiner is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, cVar, g6, 8));
    }

    public final <U, R> B<R> zipWith(Iterable<U> iterable, p027e3.c cVar) {
        p039g3.A.b(iterable, "other is null");
        p039g3.A.b(cVar, "zipper is null");
        return io.reactivex.plugins.a.onAssembly(new Y0(this, iterable, cVar));
    }

    public static B<Long> interval(long j6, long j7, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0960z1(Math.max(0L, j6), Math.max(0L, j7), timeUnit, n6));
    }

    public static B<Long> intervalRange(long j6, long j7, long j8, long j9, TimeUnit timeUnit, N n6) {
        if (j7 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j7, "count >= 0 required but it was "));
        }
        if (j7 == 0) {
            return empty().delay(j8, timeUnit, n6);
        }
        long j10 = (j7 - 1) + j6;
        if (j6 > 0 && j10 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new B1(j6, j10, Math.max(0L, j8), Math.max(0L, j9), timeUnit, n6));
    }

    public static <T> B<T> merge(Iterable<? extends G> iterable) {
        return fromIterable(iterable).flatMap(p039g3.z.f4010a);
    }

    public static <T> B<T> mergeArray(G... gArr) {
        return fromArray(gArr).flatMap(p039g3.z.f4010a, gArr.length);
    }

    public static <T> B<T> mergeArrayDelayError(G... gArr) {
        return fromArray(gArr).flatMap((p027e3.o) p039g3.z.f4010a, true, gArr.length);
    }

    public static <T> B<T> mergeDelayError(Iterable<? extends G> iterable, int i5, int i6) {
        return fromIterable(iterable).flatMap((p027e3.o) p039g3.z.f4010a, true, i5, i6);
    }

    public static B<Long> timer(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new V0(Math.max(j6, 0L), timeUnit, n6));
    }

    public static <T, D> B<T> using(Callable<? extends D> callable, p027e3.o oVar, p027e3.g gVar, boolean z6) {
        p039g3.A.b(callable, "resourceSupplier is null");
        p039g3.A.b(oVar, "sourceSupplier is null");
        p039g3.A.b(gVar, "disposer is null");
        return io.reactivex.plugins.a.onAssembly(new w3(callable, oVar, gVar, z6));
    }

    public final B<List<T>> buffer(int i5, int i6) {
        return (B<List<T>>) buffer(i5, i6, p100r3.b.f7958a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> B<R> concatMap(p027e3.o oVar, int i5) throws Exception {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "prefetch");
        if (!(this instanceof p043h3.h)) {
            return io.reactivex.plugins.a.onAssembly(new C0918q(this, oVar, i5, 1));
        }
        Object objCall = ((p043h3.h) this).call();
        return objCall == null ? empty() : io.reactivex.plugins.a.onAssembly(new C0898m(objCall, oVar, 3));
    }

    public final AbstractC0676c concatMapCompletable(p027e3.o oVar, int i5) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "capacityHint");
        return io.reactivex.plugins.a.onAssembly(new C1154e(this, oVar, 1, i5, 1));
    }

    public final AbstractC0676c concatMapCompletableDelayError(p027e3.o oVar, boolean z6) {
        return concatMapCompletableDelayError(oVar, z6, 2);
    }

    public final <R> B<R> concatMapMaybe(p027e3.o oVar, int i5) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new p065l3.z(this, oVar, 1, i5, 0));
    }

    public final <R> B<R> concatMapMaybeDelayError(p027e3.o oVar, boolean z6) {
        return concatMapMaybeDelayError(oVar, z6, 2);
    }

    public final <R> B<R> concatMapSingle(p027e3.o oVar, int i5) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new p065l3.z(this, oVar, 1, i5, 1));
    }

    public final <R> B<R> concatMapSingleDelayError(p027e3.o oVar, boolean z6) {
        return concatMapSingleDelayError(oVar, z6, 2);
    }

    public final <R> B<R> dematerialize(p027e3.o oVar) {
        p039g3.A.b(oVar, "selector is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 1));
    }

    public final <K> B<T> distinct(p027e3.o oVar) {
        return distinct(oVar, p039g3.l.f3998a);
    }

    public final <K> B<T> distinctUntilChanged(p027e3.o oVar) {
        p039g3.A.b(oVar, "keySelector is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, oVar, p039g3.A.f3987a, 4));
    }

    public final AbstractC0676c flatMapCompletable(p027e3.o oVar, boolean z6) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new M0(this, oVar, z6));
    }

    public final <R> B<R> flatMapMaybe(p027e3.o oVar, boolean z6) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new J0(this, oVar, z6, 1));
    }

    public final <R> B<R> flatMapSingle(p027e3.o oVar, boolean z6) {
        p039g3.A.b(oVar, "mapper is null");
        return io.reactivex.plugins.a.onAssembly(new J0(this, oVar, z6, 2));
    }

    public final p011b3.c forEachWhile(p027e3.q qVar, p027e3.g gVar) {
        return forEachWhile(qVar, gVar, p039g3.z.c);
    }

    public final B<T> repeat(long j6) {
        if (j6 >= 0) {
            return j6 == 0 ? empty() : io.reactivex.plugins.a.onAssembly(new C0876h2(this, j6, 0));
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j6, "times >= 0 required but it was "));
    }

    public final <R> B<R> replay(p027e3.o oVar) {
        p039g3.A.b(oVar, "selector is null");
        return C0961z2.f(oVar, new CallableC0929s1(this));
    }

    public final B<T> retry(p027e3.d dVar) {
        p039g3.A.b(dVar, "predicate is null");
        return io.reactivex.plugins.a.onAssembly(new C0933t0(this, dVar, 3));
    }

    public final B<T> sample(long j6, TimeUnit timeUnit, boolean z6) {
        return sample(j6, timeUnit, io.reactivex.schedulers.j.computation(), z6);
    }

    public final B<T> startWith(G g6) {
        p039g3.A.b(g6, "other is null");
        return concatArray(g6, this);
    }

    public final p011b3.c subscribe(p027e3.g gVar) {
        return subscribe(gVar, p039g3.z.e, p039g3.z.c, p039g3.z.d);
    }

    public final B<T> throttleFirst(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0879i0(1, j6, this, n6, timeUnit));
    }

    public final B<T> throttleLast(long j6, TimeUnit timeUnit, N n6) {
        return sample(j6, timeUnit, n6);
    }

    public final B<T> throttleLatest(long j6, TimeUnit timeUnit, boolean z6) {
        return throttleLatest(j6, timeUnit, io.reactivex.schedulers.j.computation(), z6);
    }

    public final B<T> throttleWithTimeout(long j6, TimeUnit timeUnit, N n6) {
        return debounce(j6, timeUnit, n6);
    }

    public final B<io.reactivex.schedulers.k> timeInterval(N n6) {
        return timeInterval(TimeUnit.MILLISECONDS, n6);
    }

    public final <V> B<T> timeout(p027e3.o oVar, G g6) {
        p039g3.A.b(g6, "other is null");
        return d(null, oVar, g6);
    }

    public final B<io.reactivex.schedulers.k> timestamp(N n6) {
        return timestamp(TimeUnit.MILLISECONDS, n6);
    }

    public final O toList(int i5) {
        p039g3.A.c(i5, "capacityHint");
        return io.reactivex.plugins.a.onAssembly(new C0883j(this, i5));
    }

    public final O toSortedList(Comparator<? super T> comparator) {
        p039g3.A.b(comparator, "comparator is null");
        return toList().map(new p039g3.n(comparator));
    }

    public static <T, R> B<R> combineLatest(G[] gArr, p027e3.o oVar) {
        return combineLatest(gArr, oVar, AbstractC0979l.f5366a);
    }

    public static <T, R> B<R> combineLatestDelayError(G[] gArr, p027e3.o oVar) {
        return combineLatestDelayError(gArr, oVar, AbstractC0979l.f5366a);
    }

    public static <T> B<T> concat(Iterable<? extends G> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(p039g3.z.f4010a, AbstractC0979l.f5366a, false);
    }

    public static <T> B<T> concatArrayEager(int i5, int i6, G... gArr) {
        return fromArray(gArr).concatMapEagerDelayError(p039g3.z.f4010a, i5, i6, false);
    }

    public static <T> B<T> concatArrayEagerDelayError(int i5, int i6, G... gArr) {
        return fromArray(gArr).concatMapEagerDelayError(p039g3.z.f4010a, i5, i6, true);
    }

    public static <T> B<T> concatDelayError(Iterable<? extends G> iterable) {
        p039g3.A.b(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> B<T> concatEager(Iterable<? extends G> iterable) {
        int i5 = AbstractC0979l.f5366a;
        return concatEager(iterable, i5, i5);
    }

    public static <T> B<T> error(Throwable th) {
        p039g3.A.b(th, "exception is null");
        return error(new p039g3.m(th));
    }

    public static <T> B<T> fromFuture(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        p039g3.A.b(future, "future is null");
        p039g3.A.b(timeUnit, "unit is null");
        return io.reactivex.plugins.a.onAssembly(new V0(future, j6, timeUnit));
    }

    public static <T> B<T> just(T t6, T t7) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        return fromArray(t6, t7);
    }

    public static <T> B<T> merge(Iterable<? extends G> iterable, int i5) {
        return fromIterable(iterable).flatMap(p039g3.z.f4010a, i5);
    }

    public static <T> B<T> mergeDelayError(Iterable<? extends G> iterable, int i5) {
        return fromIterable(iterable).flatMap((p027e3.o) p039g3.z.f4010a, true, i5);
    }

    public static <T> O sequenceEqual(G g6, G g7) {
        return sequenceEqual(g6, g7, p039g3.A.f3987a, AbstractC0979l.f5366a);
    }

    public static <T> B<T> switchOnNext(G g6, int i5) {
        p039g3.A.b(g6, "sources is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new Q1(g6, (p027e3.o) p039g3.z.f4010a, i5, false));
    }

    public static <T> B<T> switchOnNextDelayError(G g6, int i5) {
        p039g3.A.b(g6, "sources is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new Q1(g6, (p027e3.o) p039g3.z.f4010a, i5, true));
    }

    public final Iterable<T> blockingIterable(int i5) {
        p039g3.A.c(i5, "bufferSize");
        return new C0695c(this, i5, 1);
    }

    public final T blockingSingle(T t6) {
        return (T) single(t6).blockingGet();
    }

    public final <U extends Collection<? super T>> B<U> buffer(int i5, int i6, Callable<U> callable) {
        p039g3.A.c(i5, "count");
        p039g3.A.c(i6, "skip");
        p039g3.A.b(callable, "bufferSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0918q(this, i5, i6, callable));
    }

    public final AbstractC0676c concatMapCompletableDelayError(p027e3.o oVar, boolean z6, int i5) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new C1154e(this, oVar, z6 ? 3 : 2, i5, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> B<R> concatMapDelayError(p027e3.o oVar, int i5, boolean z6) throws Exception {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "prefetch");
        if (this instanceof p043h3.h) {
            Object objCall = ((p043h3.h) this).call();
            if (objCall == null) {
                return empty();
            }
            return io.reactivex.plugins.a.onAssembly(new C0898m(objCall, oVar, 3));
        }
        return io.reactivex.plugins.a.onAssembly(new C0918q(this, oVar, i5, z6 ? 3 : 2));
    }

    public final <R> B<R> concatMapEager(p027e3.o oVar, int i5, int i6) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "maxConcurrency");
        p039g3.A.c(i6, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.Q(this, oVar, 1, i5, i6));
    }

    public final <R> B<R> concatMapEagerDelayError(p027e3.o oVar, int i5, int i6, boolean z6) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "maxConcurrency");
        p039g3.A.c(i6, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.Q(this, oVar, z6 ? 3 : 2, i5, i6));
    }

    public final <U> B<U> concatMapIterable(p027e3.o oVar, int i5) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "prefetch");
        return (B<U>) concatMap(new C0895l1(oVar), i5);
    }

    public final <R> B<R> concatMapMaybeDelayError(p027e3.o oVar, boolean z6, int i5) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new p065l3.z(this, oVar, z6 ? 3 : 2, i5, 0));
    }

    public final <R> B<R> concatMapSingleDelayError(p027e3.o oVar, boolean z6, int i5) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new p065l3.z(this, oVar, z6 ? 3 : 2, i5, 1));
    }

    public final B<T> concatWith(V v6) {
        p039g3.A.b(v6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new X(this, v6, 0));
    }

    public final B<T> debounce(long j6, TimeUnit timeUnit) {
        return debounce(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final B<T> delaySubscription(long j6, TimeUnit timeUnit) {
        return delaySubscription(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final <K> B<T> distinct(p027e3.o oVar, Callable<? extends Collection<? super K>> callable) {
        p039g3.A.b(oVar, "keySelector is null");
        p039g3.A.b(callable, "collectionSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, oVar, callable, 3, false));
    }

    public final <U, R> B<R> flatMap(p027e3.o oVar, p027e3.c cVar) {
        int i5 = AbstractC0979l.f5366a;
        return flatMap(oVar, cVar, false, i5, i5);
    }

    public final <U, V> B<V> flatMapIterable(p027e3.o oVar, p027e3.c cVar) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.b(cVar, "resultSelector is null");
        C0895l1 c0895l1 = new C0895l1(oVar);
        int i5 = AbstractC0979l.f5366a;
        return (B<V>) flatMap(c0895l1, cVar, false, i5, i5);
    }

    public final p011b3.c forEachWhile(p027e3.q qVar, p027e3.g gVar, p027e3.a aVar) {
        p039g3.A.b(qVar, "onNext is null");
        p039g3.A.b(gVar, "onError is null");
        p039g3.A.b(aVar, "onComplete is null");
        p048i3.n nVar = new p048i3.n(qVar, gVar, aVar);
        subscribe(nVar);
        return nVar;
    }

    public final <K, V> B<p106s3.b> groupBy(p027e3.o oVar, p027e3.o oVar2) {
        return groupBy(oVar, oVar2, false, AbstractC0979l.f5366a);
    }

    public final B<T> mergeWith(V v6) {
        p039g3.A.b(v6, "other is null");
        return io.reactivex.plugins.a.onAssembly(new X(this, v6, 1));
    }

    public final B<T> observeOn(N n6, boolean z6) {
        return observeOn(n6, z6, AbstractC0979l.f5366a);
    }

    public final B<T> onErrorResumeNext(G g6) {
        p039g3.A.b(g6, "next is null");
        return onErrorResumeNext(new p039g3.m(g6));
    }

    public final <R> O reduce(R r6, p027e3.c cVar) {
        p039g3.A.b(r6, "seed is null");
        p039g3.A.b(cVar, "reducer is null");
        return io.reactivex.plugins.a.onAssembly(new C0771o3(this, 2, r6, cVar));
    }

    public final B<T> sample(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0894l0(1, j6, this, n6, timeUnit, false));
    }

    public final <R> B<R> scan(R r6, p027e3.c cVar) {
        p039g3.A.b(r6, "initialValue is null");
        return scanWith(new p039g3.m(r6), cVar);
    }

    public final B<T> skip(long j6, TimeUnit timeUnit) {
        return skipUntil(timer(j6, timeUnit));
    }

    public final B<T> skipLast(long j6, TimeUnit timeUnit, N n6, boolean z6) {
        return skipLast(j6, timeUnit, n6, z6, AbstractC0979l.f5366a);
    }

    public final p011b3.c subscribe(p027e3.g gVar, p027e3.g gVar2) {
        return subscribe(gVar, gVar2, p039g3.z.c, p039g3.z.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> B<R> switchMap(p027e3.o oVar, int i5) throws Exception {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "bufferSize");
        if (this instanceof p043h3.h) {
            Object objCall = ((p043h3.h) this).call();
            if (objCall == null) {
                return empty();
            }
            return io.reactivex.plugins.a.onAssembly(new C0898m(objCall, oVar, 3));
        }
        return io.reactivex.plugins.a.onAssembly(new Q1((G) this, oVar, i5, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> B<R> switchMapDelayError(p027e3.o oVar, int i5) throws Exception {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "bufferSize");
        if (this instanceof p043h3.h) {
            Object objCall = ((p043h3.h) this).call();
            if (objCall == null) {
                return empty();
            }
            return io.reactivex.plugins.a.onAssembly(new C0898m(objCall, oVar, 3));
        }
        return io.reactivex.plugins.a.onAssembly(new Q1((G) this, oVar, i5, true));
    }

    public final B<T> takeLast(long j6, TimeUnit timeUnit, N n6) {
        return takeLast(j6, timeUnit, n6, false, AbstractC0979l.f5366a);
    }

    public final B<T> takeUntil(p027e3.q qVar) {
        p039g3.A.b(qVar, "stopPredicate is null");
        return io.reactivex.plugins.a.onAssembly(new C0873h(this, qVar, 4));
    }

    public final p112t3.g test(boolean z6) {
        p112t3.g gVar = new p112t3.g();
        if (z6) {
            gVar.dispose();
        }
        subscribe(gVar);
        return gVar;
    }

    public final B<T> throttleLatest(long j6, TimeUnit timeUnit, N n6) {
        return throttleLatest(j6, timeUnit, n6, false);
    }

    public final B<io.reactivex.schedulers.k> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final B<io.reactivex.schedulers.k> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final B<B<T>> window(long j6, long j7) {
        return window(j6, j7, AbstractC0979l.f5366a);
    }

    public static <T> B<T> merge(G g6) {
        p039g3.A.b(g6, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new G0(g6, p039g3.z.f4010a, false, Integer.MAX_VALUE, AbstractC0979l.f5366a));
    }

    public static <T> B<T> mergeDelayError(G g6) {
        p039g3.A.b(g6, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new G0(g6, p039g3.z.f4010a, true, Integer.MAX_VALUE, AbstractC0979l.f5366a));
    }

    public final B<T> debounce(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0879i0(0, j6, this, n6, timeUnit));
    }

    public final B<T> delay(long j6, TimeUnit timeUnit) {
        return delay(j6, timeUnit, io.reactivex.schedulers.j.computation(), false);
    }

    public final B<T> delaySubscription(long j6, TimeUnit timeUnit, N n6) {
        return delaySubscription(timer(j6, timeUnit, n6));
    }

    public final B<T> distinctUntilChanged(p027e3.d dVar) {
        p039g3.A.b(dVar, "comparer is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, p039g3.z.f4010a, dVar, 4));
    }

    public final <R> B<R> publish(p027e3.o oVar) {
        p039g3.A.b(oVar, "selector is null");
        return io.reactivex.plugins.a.onAssembly(new C0864f0(this, oVar, 5));
    }

    public final B<T> retry(long j6) {
        return retry(j6, p039g3.z.f4012g);
    }

    public final B<T> skip(long j6, TimeUnit timeUnit, N n6) {
        return skipUntil(timer(j6, timeUnit, n6));
    }

    public final B<T> sorted(Comparator<? super T> comparator) {
        p039g3.A.b(comparator, "sortFunction is null");
        return toList().toObservable().map(new p039g3.n(comparator)).flatMapIterable(p039g3.z.f4010a);
    }

    public final B<T> startWith(T t6) {
        p039g3.A.b(t6, "item is null");
        return concatArray(just(t6), this);
    }

    public final p011b3.c subscribe(p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar) {
        return subscribe(gVar, gVar2, aVar, p039g3.z.d);
    }

    public final B<T> throttleLatest(long j6, TimeUnit timeUnit, N n6, boolean z6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0894l0(2, j6, this, n6, timeUnit, z6));
    }

    public final B<io.reactivex.schedulers.k> timeInterval(TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, timeUnit, n6, 7, false));
    }

    public final B<T> timeout(long j6, TimeUnit timeUnit) {
        return c(j6, timeUnit, io.reactivex.schedulers.j.computation(), null);
    }

    public final B<io.reactivex.schedulers.k> timestamp(TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return map(new p039g3.v(timeUnit, n6));
    }

    public final <U extends Collection<? super T>> O toList(Callable<U> callable) {
        p039g3.A.b(callable, "collectionSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0883j(this, callable, 2));
    }

    public final <K, V> O toMap(p027e3.o oVar, p027e3.o oVar2) {
        p039g3.A.b(oVar, "keySelector is null");
        p039g3.A.b(oVar2, "valueSelector is null");
        return collect(p100r3.h.f7962a, new p039g3.x(oVar2, oVar));
    }

    public final <K, V> O toMultimap(p027e3.o oVar, p027e3.o oVar2) {
        return toMultimap(oVar, oVar2, p100r3.h.f7962a, p100r3.b.f7958a);
    }

    public final <T1, T2, R> B<R> withLatestFrom(G g6, G g7, p027e3.h hVar) {
        p039g3.A.b(g6, "o1 is null");
        p039g3.A.b(g7, "o2 is null");
        p039g3.A.b(hVar, "combiner is null");
        p039g3.z.b();
        throw null;
    }

    public final <U, R> B<R> zipWith(G g6, p027e3.c cVar) {
        p039g3.A.b(g6, "other is null");
        return zip(this, g6, cVar);
    }

    public static <T, R> B<R> combineLatest(p027e3.o oVar, int i5, G... gArr) {
        return combineLatest(gArr, oVar, i5);
    }

    public static <T, R> B<R> combineLatestDelayError(p027e3.o oVar, int i5, G... gArr) {
        return combineLatestDelayError(gArr, oVar, i5);
    }

    public static <T> B<T> concatDelayError(G g6, int i5, boolean z6) {
        p039g3.A.b(g6, "sources is null");
        p039g3.A.c(i5, "prefetch is null");
        return io.reactivex.plugins.a.onAssembly(new C0918q(g6, p039g3.z.f4010a, i5, z6 ? 3 : 2));
    }

    public static <T> B<T> concatEager(G g6, int i5, int i6) {
        return wrap(g6).concatMapEager(p039g3.z.f4010a, i5, i6);
    }

    public static <T, S> B<T> generate(Callable<S> callable, p027e3.b bVar) {
        p039g3.A.b(bVar, "generator is null");
        return generate(callable, new C0939u1(bVar), p039g3.z.d);
    }

    public static B<Long> interval(long j6, TimeUnit timeUnit) {
        return interval(j6, j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final B<T> concatWith(y yVar) {
        p039g3.A.b(yVar, "other is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.V(this, yVar, 0));
    }

    public final B<T> delay(long j6, TimeUnit timeUnit, boolean z6) {
        return delay(j6, timeUnit, io.reactivex.schedulers.j.computation(), z6);
    }

    public final <U, R> B<R> flatMap(p027e3.o oVar, p027e3.c cVar, int i5) {
        return flatMap(oVar, cVar, false, i5, AbstractC0979l.f5366a);
    }

    public final <K, V> B<p106s3.b> groupBy(p027e3.o oVar, p027e3.o oVar2, boolean z6) {
        return groupBy(oVar, oVar2, z6, AbstractC0979l.f5366a);
    }

    public final B<T> mergeWith(y yVar) {
        p039g3.A.b(yVar, "other is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.V(this, yVar, 1));
    }

    public final B<T> observeOn(N n6, boolean z6, int i5) {
        p039g3.A.b(n6, "scheduler is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new Q1(this, n6, z6, i5));
    }

    public final <R> B<R> replay(p027e3.o oVar, int i5) {
        p039g3.A.b(oVar, "selector is null");
        p039g3.A.c(i5, "bufferSize");
        return C0961z2.f(oVar, new CallableC0885j1(this, i5));
    }

    public final B<T> retry(long j6, p027e3.q qVar) {
        if (j6 >= 0) {
            p039g3.A.b(qVar, "predicate is null");
            return io.reactivex.plugins.a.onAssembly(new C2(this, j6, qVar));
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j6, "times >= 0 required but it was "));
    }

    public final B<T> skipLast(int i5) {
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "count >= 0 required but it was "));
        }
        if (i5 == 0) {
            return io.reactivex.plugins.a.onAssembly(this);
        }
        return io.reactivex.plugins.a.onAssembly(new S2(this, i5, 0));
    }

    public final p011b3.c subscribe(p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar, p027e3.g gVar3) {
        p039g3.A.b(gVar, "onNext is null");
        p039g3.A.b(gVar2, "onError is null");
        p039g3.A.b(aVar, "onComplete is null");
        p039g3.A.b(gVar3, "onSubscribe is null");
        p048i3.r rVar = new p048i3.r(gVar, gVar2, aVar, gVar3);
        subscribe(rVar);
        return rVar;
    }

    public final B<T> takeLast(long j6, TimeUnit timeUnit, N n6, boolean z6) {
        return takeLast(j6, timeUnit, n6, z6, AbstractC0979l.f5366a);
    }

    public final B<T> timeout(long j6, TimeUnit timeUnit, G g6) {
        p039g3.A.b(g6, "other is null");
        return c(j6, timeUnit, io.reactivex.schedulers.j.computation(), g6);
    }

    public final B<B<T>> window(long j6, long j7, TimeUnit timeUnit, N n6) {
        return window(j6, j7, timeUnit, n6, AbstractC0979l.f5366a);
    }

    public static <T, R> B<R> combineLatest(Iterable<? extends G> iterable, p027e3.o oVar, int i5) {
        p039g3.A.b(iterable, "sources is null");
        p039g3.A.b(oVar, "combiner is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.K(null, iterable, oVar, i5 << 1, false, 0));
    }

    public static <T, R> B<R> combineLatestDelayError(G[] gArr, p027e3.o oVar, int i5) {
        p039g3.A.c(i5, "bufferSize");
        p039g3.A.b(oVar, "combiner is null");
        if (gArr.length == 0) {
            return empty();
        }
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.K(gArr, null, oVar, i5 << 1, true, 0));
    }

    public static <T> B<T> concatEager(Iterable<? extends G> iterable, int i5, int i6) {
        return fromIterable(iterable).concatMapEagerDelayError(p039g3.z.f4010a, i5, i6, false);
    }

    public static <T> B<T> fromFuture(Future<? extends T> future, long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return fromFuture(future, j6, timeUnit).subscribeOn(n6);
    }

    public static B<Long> interval(long j6, TimeUnit timeUnit, N n6) {
        return interval(j6, j6, timeUnit, n6);
    }

    public static <T> B<T> just(T t6, T t7, T t8) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        p039g3.A.b(t8, "item3 is null");
        return fromArray(t6, t7, t8);
    }

    public static <T> O sequenceEqual(G g6, G g7, p027e3.d dVar, int i5) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(dVar, "isEqual is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new Q2(g6, g7, dVar, i5));
    }

    public static <T, R> B<R> zip(G g6, p027e3.o oVar) {
        p039g3.A.b(oVar, "zipper is null");
        p039g3.A.b(g6, "sources is null");
        return io.reactivex.plugins.a.onAssembly(new C0933t0(g6).flatMap(new C0952x1(oVar)));
    }

    public final T blockingFirst(T t6) {
        p048i3.f fVar = new p048i3.f(1, 0);
        subscribe(fVar);
        T t7 = (T) fVar.a();
        return t7 != null ? t7 : t6;
    }

    public final T blockingLast(T t6) {
        p048i3.f fVar = new p048i3.f(1, 1);
        subscribe(fVar);
        T t7 = (T) fVar.a();
        return t7 != null ? t7 : t6;
    }

    public final B<T> delay(long j6, TimeUnit timeUnit, N n6) {
        return delay(j6, timeUnit, n6, false);
    }

    public final B<T> doOnEach(p027e3.g gVar) {
        p039g3.A.b(gVar, "onNotification is null");
        return doOnEach(new p039g3.s(gVar), new p039g3.r(gVar), new p039g3.q(gVar), p039g3.z.c);
    }

    public final B<T> sample(long j6, TimeUnit timeUnit, N n6, boolean z6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0894l0(1, j6, this, n6, timeUnit, z6));
    }

    public final O toSortedList(Comparator<? super T> comparator, int i5) {
        p039g3.A.b(comparator, "comparator is null");
        return toList(i5).map(new p039g3.n(comparator));
    }

    public final <U, R> B<R> zipWith(G g6, p027e3.c cVar, boolean z6) {
        return zip(this, g6, cVar, z6);
    }

    public static <T> B<T> concat(G g6, int i5) {
        p039g3.A.b(g6, "sources is null");
        p039g3.A.c(i5, "prefetch");
        return io.reactivex.plugins.a.onAssembly(new C0918q(g6, p039g3.z.f4010a, i5, 1));
    }

    public final <U extends Collection<? super T>> B<U> buffer(int i5, Callable<U> callable) {
        return buffer(i5, i5, callable);
    }

    public final B<T> concatWith(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.T(this, interfaceC0682i, 0));
    }

    public final B<T> delay(long j6, TimeUnit timeUnit, N n6, boolean z6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0894l0(0, j6, this, n6, timeUnit, z6));
    }

    public final <U, R> B<R> flatMap(p027e3.o oVar, p027e3.c cVar, boolean z6) {
        int i5 = AbstractC0979l.f5366a;
        return flatMap(oVar, cVar, z6, i5, i5);
    }

    public final <K> B<p106s3.b> groupBy(p027e3.o oVar, boolean z6) {
        return groupBy(oVar, p039g3.z.f4010a, z6, AbstractC0979l.f5366a);
    }

    public final B<T> mergeWith(InterfaceC0682i interfaceC0682i) {
        p039g3.A.b(interfaceC0682i, "other is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.T(this, interfaceC0682i, 1));
    }

    public final B<T> takeLast(int i5) {
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "count >= 0 required but it was "));
        }
        if (i5 == 0) {
            return io.reactivex.plugins.a.onAssembly(new Z(this, 3));
        }
        if (i5 == 1) {
            return io.reactivex.plugins.a.onAssembly(new Z(this, 7));
        }
        return io.reactivex.plugins.a.onAssembly(new S2(this, i5, 1));
    }

    public final B<T> timeout(long j6, TimeUnit timeUnit, N n6, G g6) {
        p039g3.A.b(g6, "other is null");
        return c(j6, timeUnit, n6, g6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> O toMultimap(p027e3.o oVar, p027e3.o oVar2, Callable<? extends Map<K, Collection<V>>> callable, p027e3.o oVar3) {
        p039g3.A.b(oVar, "keySelector is null");
        p039g3.A.b(oVar2, "valueSelector is null");
        p039g3.A.b(callable, "mapSupplier is null");
        p039g3.A.b(oVar3, "collectionFactory is null");
        return collect(callable, new p039g3.y(oVar3, oVar2, oVar));
    }

    public final B<B<T>> window(long j6, TimeUnit timeUnit, N n6, long j7, boolean z6) {
        return window(j6, timeUnit, n6, j7, z6, AbstractC0979l.f5366a);
    }

    public final <U, R> B<R> zipWith(G g6, p027e3.c cVar, boolean z6, int i5) {
        return zip(this, g6, cVar, z6, i5);
    }

    public static <T, S> B<T> generate(Callable<S> callable, p027e3.b bVar, p027e3.g gVar) {
        p039g3.A.b(bVar, "generator is null");
        return generate(callable, new C0939u1(bVar), gVar);
    }

    public static <T> B<T> merge(G g6, int i5) {
        p039g3.A.b(g6, "sources is null");
        p039g3.A.c(i5, "maxConcurrency");
        return io.reactivex.plugins.a.onAssembly(new G0(g6, p039g3.z.f4010a, false, i5, AbstractC0979l.f5366a));
    }

    public static <T> B<T> mergeDelayError(G g6, int i5) {
        p039g3.A.b(g6, "sources is null");
        p039g3.A.c(i5, "maxConcurrency");
        return io.reactivex.plugins.a.onAssembly(new G0(g6, p039g3.z.f4010a, true, i5, AbstractC0979l.f5366a));
    }

    public final B<List<T>> buffer(long j6, long j7, TimeUnit timeUnit) {
        return (B<List<T>>) buffer(j6, j7, timeUnit, io.reactivex.schedulers.j.computation(), p100r3.b.f7958a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> O toMap(p027e3.o oVar, p027e3.o oVar2, Callable<? extends Map<K, V>> callable) {
        p039g3.A.b(oVar, "keySelector is null");
        p039g3.A.b(oVar2, "valueSelector is null");
        p039g3.A.b(callable, "mapSupplier is null");
        return collect(callable, new p039g3.x(oVar2, oVar));
    }

    public final <T1, T2, T3, R> B<R> withLatestFrom(G g6, G g7, G g8, p027e3.i iVar) {
        p039g3.A.b(g6, "o1 is null");
        p039g3.A.b(g7, "o2 is null");
        p039g3.A.b(g8, "o3 is null");
        p039g3.A.b(iVar, "combiner is null");
        p039g3.z.c();
        throw null;
    }

    public static <T> B<T> fromFuture(Future<? extends T> future, N n6) {
        p039g3.A.b(n6, "scheduler is null");
        return fromFuture(future).subscribeOn(n6);
    }

    public final void blockingSubscribe(p027e3.g gVar) {
        p002a.d.c(this, gVar, p039g3.z.e, p039g3.z.c);
    }

    public final B<List<T>> buffer(long j6, long j7, TimeUnit timeUnit, N n6) {
        return (B<List<T>>) buffer(j6, j7, timeUnit, n6, p100r3.b.f7958a);
    }

    public final O elementAt(long j6, T t6) {
        if (j6 >= 0) {
            p039g3.A.b(t6, "defaultItem is null");
            return io.reactivex.plugins.a.onAssembly(new B0(this, j6, t6));
        }
        throw new IndexOutOfBoundsException(androidx.collection.a.j(j6, "index >= 0 required but it was "));
    }

    public final <U, R> B<R> flatMap(p027e3.o oVar, p027e3.c cVar, boolean z6, int i5) {
        return flatMap(oVar, cVar, z6, i5, AbstractC0979l.f5366a);
    }

    public final <R> B<R> replay(p027e3.o oVar, int i5, long j6, TimeUnit timeUnit) {
        return replay(oVar, i5, j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final <U> B<T> sample(G g6) {
        p039g3.A.b(g6, "sampler is null");
        return io.reactivex.plugins.a.onAssembly(new J0(this, g6, false, 4));
    }

    public final B<T> take(long j6, TimeUnit timeUnit) {
        return takeUntil(timer(j6, timeUnit));
    }

    public final B<T> timeout(long j6, TimeUnit timeUnit, N n6) {
        return c(j6, timeUnit, n6, null);
    }

    public final <B> B<B<T>> window(G g6) {
        return window(g6, AbstractC0979l.f5366a);
    }

    public static <T, R> B<R> combineLatest(G[] gArr, p027e3.o oVar, int i5) {
        p039g3.A.b(gArr, "sources is null");
        if (gArr.length == 0) {
            return empty();
        }
        p039g3.A.b(oVar, "combiner is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.K(gArr, null, oVar, i5 << 1, false, 0));
    }

    public static <T> B<T> concat(G g6, G g7) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        return concatArray(g6, g7);
    }

    public static <T> B<T> just(T t6, T t7, T t8, T t9) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        p039g3.A.b(t8, "item3 is null");
        p039g3.A.b(t9, "item4 is null");
        return fromArray(t6, t7, t8, t9);
    }

    public final void blockingSubscribe(p027e3.g gVar, p027e3.g gVar2) {
        p002a.d.c(this, gVar, gVar2, p039g3.z.c);
    }

    public final <U extends Collection<? super T>> B<U> buffer(long j6, long j7, TimeUnit timeUnit, N n6, Callable<U> callable) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        p039g3.A.b(callable, "bufferSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.D(this, j6, j7, timeUnit, n6, callable, Integer.MAX_VALUE, false));
    }

    public final <U, V> B<T> delay(G g6, p027e3.o oVar) {
        return delaySubscription(g6).delay(oVar);
    }

    public final <K, V> B<p106s3.b> groupBy(p027e3.o oVar, p027e3.o oVar2, boolean z6, int i5) {
        p039g3.A.b(oVar, "keySelector is null");
        p039g3.A.b(oVar2, "valueSelector is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new C0850c1(this, oVar, oVar2, i5, z6));
    }

    public final <R> B<R> replay(p027e3.o oVar, int i5, long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(oVar, "selector is null");
        p039g3.A.c(i5, "bufferSize");
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return C0961z2.f(oVar, new CallableC0890k1(i5, j6, this, n6, timeUnit));
    }

    public final B<T> take(long j6, TimeUnit timeUnit, N n6) {
        return takeUntil(timer(j6, timeUnit, n6));
    }

    public final <U, V> B<T> timeout(G g6, p027e3.o oVar) {
        p039g3.A.b(g6, "firstTimeoutIndicator is null");
        return d(g6, oVar, null);
    }

    public final O toSortedList(int i5) {
        return toSortedList(p039g3.z.f4015j, i5);
    }

    public static <T, R> B<R> combineLatestDelayError(Iterable<? extends G> iterable, p027e3.o oVar, int i5) {
        p039g3.A.b(iterable, "sources is null");
        p039g3.A.b(oVar, "combiner is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.K(null, iterable, oVar, i5 << 1, true, 0));
    }

    public static <T, S> B<T> generate(Callable<S> callable, p027e3.c cVar) {
        return generate(callable, cVar, p039g3.z.d);
    }

    public static <T> O sequenceEqual(G g6, G g7, int i5) {
        return sequenceEqual(g6, g7, p039g3.A.f3987a, i5);
    }

    public final void blockingSubscribe(p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar) {
        p002a.d.c(this, gVar, gVar2, aVar);
    }

    public final <R> B<R> flatMap(p027e3.o oVar, boolean z6, int i5) {
        return flatMap(oVar, z6, i5, AbstractC0979l.f5366a);
    }

    public final <U> B<T> sample(G g6, boolean z6) {
        p039g3.A.b(g6, "sampler is null");
        return io.reactivex.plugins.a.onAssembly(new J0(this, g6, z6, 4));
    }

    @Override // io.reactivex.G
    public final void subscribe(I i5) {
        p039g3.A.b(i5, "observer is null");
        try {
            I iOnSubscribe = io.reactivex.plugins.a.onSubscribe(this, i5);
            p039g3.A.b(iOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(iOnSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <U, V> B<B<T>> window(G g6, p027e3.o oVar) {
        return window(g6, oVar, AbstractC0979l.f5366a);
    }

    public static <T, S> B<T> generate(Callable<S> callable, p027e3.c cVar, p027e3.g gVar) {
        p039g3.A.b(callable, "initialState is null");
        p039g3.A.b(cVar, "generator is null");
        p039g3.A.b(gVar, "disposeState is null");
        return io.reactivex.plugins.a.onAssembly(new Y0(callable, cVar, gVar));
    }

    public static <T1, T2, R> B<R> zip(G g6, G g7, p027e3.c cVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        return zipArray(p039g3.z.a(cVar), false, AbstractC0979l.f5366a, g6, g7);
    }

    public final void blockingSubscribe(I i5) {
        p002a.d.d(this, i5);
    }

    public final B<T> doOnEach(I i5) {
        p039g3.A.b(i5, "observer is null");
        return doOnEach(new C0924r1(i5), new C0920q1(i5), new C0915p1(i5), p039g3.z.c);
    }

    public final <U, V> B<T> timeout(G g6, p027e3.o oVar, G g7) {
        p039g3.A.b(g6, "firstTimeoutIndicator is null");
        p039g3.A.b(g7, "other is null");
        return d(g6, oVar, g7);
    }

    public static <T> B<T> concat(G g6, G g7, G g8) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        return concatArray(g6, g7, g8);
    }

    public static <T> B<T> merge(G g6, G g7) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        return fromArray(g6, g7).flatMap((p027e3.o) p039g3.z.f4010a, false, 2);
    }

    public static <T> B<T> mergeDelayError(G g6, G g7) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        return fromArray(g6, g7).flatMap((p027e3.o) p039g3.z.f4010a, true, 2);
    }

    public final <R> B<R> flatMap(p027e3.o oVar) {
        return flatMap(oVar, false);
    }

    public final <K, V> O toMultimap(p027e3.o oVar, p027e3.o oVar2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(oVar, oVar2, callable, p100r3.b.f7958a);
    }

    public final <B> B<B<T>> window(Callable<? extends G> callable) {
        return window(callable, AbstractC0979l.f5366a);
    }

    public final <T1, T2, T3, T4, R> B<R> withLatestFrom(G g6, G g7, G g8, G g9, p027e3.j jVar) {
        p039g3.A.b(g6, "o1 is null");
        p039g3.A.b(g7, "o2 is null");
        p039g3.A.b(g8, "o3 is null");
        p039g3.A.b(g9, "o4 is null");
        p039g3.A.b(jVar, "combiner is null");
        p039g3.z.d();
        throw null;
    }

    public final B<List<T>> buffer(long j6, TimeUnit timeUnit) {
        return buffer(j6, timeUnit, io.reactivex.schedulers.j.computation(), Integer.MAX_VALUE);
    }

    public final <R> B<R> flatMap(p027e3.o oVar, boolean z6) {
        return flatMap(oVar, z6, Integer.MAX_VALUE);
    }

    public final B<T> retry(p027e3.q qVar) {
        return retry(LocationRequestCompat.PASSIVE_INTERVAL, qVar);
    }

    public final B<T> skipLast(long j6, TimeUnit timeUnit) {
        return skipLast(j6, timeUnit, io.reactivex.schedulers.j.trampoline(), false, AbstractC0979l.f5366a);
    }

    public static <T> B<T> just(T t6, T t7, T t8, T t9, T t10) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        p039g3.A.b(t8, "item3 is null");
        p039g3.A.b(t9, "item4 is null");
        p039g3.A.b(t10, "item5 is null");
        return fromArray(t6, t7, t8, t9, t10);
    }

    public final B<List<T>> buffer(long j6, TimeUnit timeUnit, int i5) {
        return buffer(j6, timeUnit, io.reactivex.schedulers.j.computation(), i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> B<R> flatMap(p027e3.o oVar, boolean z6, int i5, int i6) throws Exception {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.c(i5, "maxConcurrency");
        p039g3.A.c(i6, "bufferSize");
        if (this instanceof p043h3.h) {
            Object objCall = ((p043h3.h) this).call();
            if (objCall == null) {
                return empty();
            }
            return io.reactivex.plugins.a.onAssembly(new C0898m(objCall, oVar, 3));
        }
        return io.reactivex.plugins.a.onAssembly(new G0(this, oVar, z6, i5, i6));
    }

    public final B<B<T>> window(long j6, long j7, int i5) {
        p039g3.A.d(j6, "count");
        p039g3.A.d(j7, "skip");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new z3(this, j6, j7, i5));
    }

    public static <T1, T2, R> B<R> combineLatest(G g6, G g7, p027e3.c cVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        return combineLatest(p039g3.z.a(cVar), AbstractC0979l.f5366a, g6, g7);
    }

    public static <T> B<T> merge(G g6, G g7, G g8) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        return fromArray(g6, g7, g8).flatMap((p027e3.o) p039g3.z.f4010a, false, 3);
    }

    public static <T> B<T> mergeDelayError(G g6, G g7, G g8) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        return fromArray(g6, g7, g8).flatMap((p027e3.o) p039g3.z.f4010a, true, 3);
    }

    public final B<List<T>> buffer(long j6, TimeUnit timeUnit, N n6, int i5) {
        return (B<List<T>>) buffer(j6, timeUnit, n6, i5, p100r3.b.f7958a, false);
    }

    public final <R> B<R> replay(p027e3.o oVar, int i5, N n6) {
        p039g3.A.b(oVar, "selector is null");
        p039g3.A.b(n6, "scheduler is null");
        p039g3.A.c(i5, "bufferSize");
        return C0961z2.f(new C0934t1(oVar, n6), new CallableC0885j1(this, i5));
    }

    public static <T> B<T> concat(G g6, G g7, G g8, G g9) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        return concatArray(g6, g7, g8, g9);
    }

    public static <T1, T2, R> B<R> zip(G g6, G g7, p027e3.c cVar, boolean z6) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        return zipArray(p039g3.z.a(cVar), z6, AbstractC0979l.f5366a, g6, g7);
    }

    public final <U extends Collection<? super T>> B<U> buffer(long j6, TimeUnit timeUnit, N n6, int i5, Callable<U> callable, boolean z6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        p039g3.A.b(callable, "bufferSupplier is null");
        p039g3.A.c(i5, "count");
        return io.reactivex.plugins.a.onAssembly(new io.reactivex.internal.operators.observable.D(this, j6, j6, timeUnit, n6, callable, i5, z6));
    }

    public final B<T> skipLast(long j6, TimeUnit timeUnit, boolean z6) {
        return skipLast(j6, timeUnit, io.reactivex.schedulers.j.trampoline(), z6, AbstractC0979l.f5366a);
    }

    public final B<B<T>> window(long j6, long j7, TimeUnit timeUnit) {
        return window(j6, j7, timeUnit, io.reactivex.schedulers.j.computation(), AbstractC0979l.f5366a);
    }

    public final <R> B<R> withLatestFrom(G[] gArr, p027e3.o oVar) {
        p039g3.A.b(gArr, "others is null");
        p039g3.A.b(oVar, "combiner is null");
        return io.reactivex.plugins.a.onAssembly(new R3(this, gArr, oVar));
    }

    public static <T> B<T> merge(G g6, G g7, G g8, G g9) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        return fromArray(g6, g7, g8, g9).flatMap((p027e3.o) p039g3.z.f4010a, false, 4);
    }

    public static <T> B<T> mergeDelayError(G g6, G g7, G g8, G g9) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        return fromArray(g6, g7, g8, g9).flatMap((p027e3.o) p039g3.z.f4010a, true, 4);
    }

    public final B<T> skipLast(long j6, TimeUnit timeUnit, N n6, boolean z6, int i5) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new U2(i5 << 1, j6, this, n6, timeUnit, z6));
    }

    public static <T1, T2, T3, R> B<R> combineLatest(G g6, G g7, G g8, p027e3.h hVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.z.b();
        throw null;
    }

    public static <T> B<T> just(T t6, T t7, T t8, T t9, T t10, T t11) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        p039g3.A.b(t8, "item3 is null");
        p039g3.A.b(t9, "item4 is null");
        p039g3.A.b(t10, "item5 is null");
        p039g3.A.b(t11, "item6 is null");
        return fromArray(t6, t7, t8, t9, t10, t11);
    }

    public final B<T> takeLast(long j6, long j7, TimeUnit timeUnit) {
        return takeLast(j6, j7, timeUnit, io.reactivex.schedulers.j.trampoline(), false, AbstractC0979l.f5366a);
    }

    public static <T1, T2, R> B<R> zip(G g6, G g7, p027e3.c cVar, boolean z6, int i5) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        return zipArray(p039g3.z.a(cVar), z6, i5, g6, g7);
    }

    public final B<List<T>> buffer(long j6, TimeUnit timeUnit, N n6) {
        return (B<List<T>>) buffer(j6, timeUnit, n6, Integer.MAX_VALUE, p100r3.b.f7958a, false);
    }

    public final <R> B<R> replay(p027e3.o oVar, long j6, TimeUnit timeUnit) {
        return replay(oVar, j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final B<B<T>> window(long j6, long j7, TimeUnit timeUnit, N n6, int i5) {
        p039g3.A.d(j6, "timespan");
        p039g3.A.d(j7, "timeskip");
        p039g3.A.c(i5, "bufferSize");
        p039g3.A.b(n6, "scheduler is null");
        p039g3.A.b(timeUnit, "unit is null");
        return io.reactivex.plugins.a.onAssembly(new M3(this, j6, j7, timeUnit, n6, LocationRequestCompat.PASSIVE_INTERVAL, i5, false));
    }

    public final <R> B<R> withLatestFrom(Iterable<? extends G> iterable, p027e3.o oVar) {
        p039g3.A.b(iterable, "others is null");
        p039g3.A.b(oVar, "combiner is null");
        return io.reactivex.plugins.a.onAssembly(new R3(this, iterable, oVar));
    }

    public final <TOpening, TClosing> B<List<T>> buffer(G g6, p027e3.o oVar) {
        return (B<List<T>>) buffer(g6, oVar, p100r3.b.f7958a);
    }

    public final <R> B<R> flatMap(p027e3.o oVar, p027e3.o oVar2, Callable<? extends G> callable) {
        p039g3.A.b(oVar, "onNextMapper is null");
        p039g3.A.b(oVar2, "onErrorMapper is null");
        p039g3.A.b(callable, "onCompleteSupplier is null");
        return merge(new C0937u(this, oVar, oVar2, callable));
    }

    public final <R> B<R> replay(p027e3.o oVar, long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(oVar, "selector is null");
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return C0961z2.f(oVar, new CallableC0948w1(this, j6, timeUnit, n6));
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> B<U> buffer(G g6, p027e3.o oVar, Callable<U> callable) {
        p039g3.A.b(g6, "openingIndicator is null");
        p039g3.A.b(oVar, "closingIndicator is null");
        p039g3.A.b(callable, "bufferSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0937u(this, g6, oVar, callable, 0));
    }

    public final B<T> takeLast(long j6, long j7, TimeUnit timeUnit, N n6, boolean z6, int i5) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        p039g3.A.c(i5, "bufferSize");
        if (j6 >= 0) {
            return io.reactivex.plugins.a.onAssembly(new C0867f3(this, j6, j7, timeUnit, n6, i5, z6));
        }
        throw new IndexOutOfBoundsException(androidx.collection.a.j(j6, "count >= 0 required but it was "));
    }

    public static <T1, T2, T3, T4, R> B<R> combineLatest(G g6, G g7, G g8, G g9, p027e3.i iVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.z.c();
        throw null;
    }

    public static <T1, T2, T3, R> B<R> zip(G g6, G g7, G g8, p027e3.h hVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.z.b();
        throw null;
    }

    public final <R> B<R> flatMap(p027e3.o oVar, p027e3.o oVar2, Callable<? extends G> callable, int i5) {
        p039g3.A.b(oVar, "onNextMapper is null");
        p039g3.A.b(oVar2, "onErrorMapper is null");
        p039g3.A.b(callable, "onCompleteSupplier is null");
        return merge(new C0937u(this, oVar, oVar2, callable), i5);
    }

    public static <T> B<T> just(T t6, T t7, T t8, T t9, T t10, T t11, T t12) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        p039g3.A.b(t8, "item3 is null");
        p039g3.A.b(t9, "item4 is null");
        p039g3.A.b(t10, "item5 is null");
        p039g3.A.b(t11, "item6 is null");
        p039g3.A.b(t12, "item7 is null");
        return fromArray(t6, t7, t8, t9, t10, t11, t12);
    }

    public final <B> B<List<T>> buffer(G g6) {
        return (B<List<T>>) buffer(g6, (Callable) p100r3.b.f7958a);
    }

    public final <R> B<R> replay(p027e3.o oVar, N n6) {
        p039g3.A.b(oVar, "selector is null");
        p039g3.A.b(n6, "scheduler is null");
        return C0961z2.f(new C0934t1(oVar, n6), new CallableC0929s1(this));
    }

    public final B<B<T>> window(long j6, TimeUnit timeUnit) {
        return window(j6, timeUnit, io.reactivex.schedulers.j.computation(), LocationRequestCompat.PASSIVE_INTERVAL, false);
    }

    public static <T1, T2, T3, T4, R> B<R> zip(G g6, G g7, G g8, G g9, p027e3.i iVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.z.c();
        throw null;
    }

    public final <B> B<List<T>> buffer(G g6, int i5) {
        p039g3.A.c(i5, "initialCapacity");
        return (B<List<T>>) buffer(g6, new p039g3.c(i5));
    }

    public final B<B<T>> window(long j6, TimeUnit timeUnit, long j7) {
        return window(j6, timeUnit, io.reactivex.schedulers.j.computation(), j7, false);
    }

    public static <T1, T2, T3, T4, T5, R> B<R> combineLatest(G g6, G g7, G g8, G g9, G g10, p027e3.j jVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.z.d();
        throw null;
    }

    public final B<B<T>> window(long j6, TimeUnit timeUnit, long j7, boolean z6) {
        return window(j6, timeUnit, io.reactivex.schedulers.j.computation(), j7, z6);
    }

    public final <U, R> B<R> flatMap(p027e3.o oVar, p027e3.c cVar, boolean z6, int i5, int i6) {
        p039g3.A.b(oVar, "mapper is null");
        p039g3.A.b(cVar, "combiner is null");
        return flatMap(new C0905n1(oVar, cVar), z6, i5, i6);
    }

    public final B<B<T>> window(long j6, TimeUnit timeUnit, N n6) {
        return window(j6, timeUnit, n6, LocationRequestCompat.PASSIVE_INTERVAL, false);
    }

    public final <B, U extends Collection<? super T>> B<U> buffer(G g6, Callable<U> callable) {
        p039g3.A.b(g6, "boundary is null");
        p039g3.A.b(callable, "bufferSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, g6, callable, 1, false));
    }

    public final B<B<T>> window(long j6, TimeUnit timeUnit, N n6, long j7) {
        return window(j6, timeUnit, n6, j7, false);
    }

    public final p106s3.a replay(int i5) {
        p039g3.A.c(i5, "bufferSize");
        if (i5 == Integer.MAX_VALUE) {
            return C0961z2.e(this, C0961z2.e);
        }
        return C0961z2.e(this, new J0.f(i5));
    }

    public final B<B<T>> window(long j6, TimeUnit timeUnit, N n6, long j7, boolean z6, int i5) {
        p039g3.A.c(i5, "bufferSize");
        p039g3.A.b(n6, "scheduler is null");
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.d(j7, "count");
        return io.reactivex.plugins.a.onAssembly(new M3(this, j6, j6, timeUnit, n6, j7, i5, z6));
    }

    public static <T1, T2, T3, T4, T5, R> B<R> zip(G g6, G g7, G g8, G g9, G g10, p027e3.j jVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.z.d();
        throw null;
    }

    public final <B> B<List<T>> buffer(Callable<? extends G> callable) {
        return (B<List<T>>) buffer(callable, p100r3.b.f7958a);
    }

    public final B<T> takeLast(long j6, TimeUnit timeUnit) {
        return takeLast(j6, timeUnit, io.reactivex.schedulers.j.trampoline(), false, AbstractC0979l.f5366a);
    }

    public static <T1, T2, T3, T4, T5, T6, R> B<R> combineLatest(G g6, G g7, G g8, G g9, G g10, G g11, p027e3.k kVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.A.b(g11, "source6 is null");
        p039g3.z.e();
        throw null;
    }

    public static <T> B<T> just(T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        p039g3.A.b(t8, "item3 is null");
        p039g3.A.b(t9, "item4 is null");
        p039g3.A.b(t10, "item5 is null");
        p039g3.A.b(t11, "item6 is null");
        p039g3.A.b(t12, "item7 is null");
        p039g3.A.b(t13, "item8 is null");
        return fromArray(t6, t7, t8, t9, t10, t11, t12, t13);
    }

    public final <B, U extends Collection<? super T>> B<U> buffer(Callable<? extends G> callable, Callable<U> callable2) {
        p039g3.A.b(callable, "boundarySupplier is null");
        p039g3.A.b(callable2, "bufferSupplier is null");
        return io.reactivex.plugins.a.onAssembly(new C0950x(this, callable, callable2, 0));
    }

    public final p106s3.a replay(int i5, long j6, TimeUnit timeUnit) {
        return replay(i5, j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final p106s3.a replay(int i5, long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.c(i5, "bufferSize");
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return C0961z2.e(this, new C0940u2(i5, j6, timeUnit, n6));
    }

    public final B<T> takeLast(long j6, TimeUnit timeUnit, boolean z6) {
        return takeLast(j6, timeUnit, io.reactivex.schedulers.j.trampoline(), z6, AbstractC0979l.f5366a);
    }

    public final <B> B<B<T>> window(G g6, int i5) {
        p039g3.A.b(g6, "boundary is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new B3(this, g6, i5, 0));
    }

    public static <T1, T2, T3, T4, T5, T6, R> B<R> zip(G g6, G g7, G g8, G g9, G g10, G g11, p027e3.k kVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.A.b(g11, "source6 is null");
        p039g3.z.e();
        throw null;
    }

    public final p106s3.a replay(int i5, N n6) {
        p039g3.A.c(i5, "bufferSize");
        p106s3.a aVarReplay = replay(i5);
        return io.reactivex.plugins.a.onAssembly((p106s3.a) new C0921q2(aVarReplay, aVarReplay.observeOn(n6)));
    }

    public final B<T> takeLast(long j6, TimeUnit timeUnit, N n6, boolean z6, int i5) {
        return takeLast(LocationRequestCompat.PASSIVE_INTERVAL, j6, timeUnit, n6, z6, i5);
    }

    public final <U, V> B<B<T>> window(G g6, p027e3.o oVar, int i5) {
        p039g3.A.b(g6, "openingIndicator is null");
        p039g3.A.b(oVar, "closingIndicator is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new F3(this, g6, oVar, i5));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> B<R> combineLatest(G g6, G g7, G g8, G g9, G g10, G g11, G g12, p027e3.l lVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.A.b(g11, "source6 is null");
        p039g3.A.b(g12, "source7 is null");
        p039g3.z.f();
        throw null;
    }

    public static <T> B<T> just(T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13, T t14) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        p039g3.A.b(t8, "item3 is null");
        p039g3.A.b(t9, "item4 is null");
        p039g3.A.b(t10, "item5 is null");
        p039g3.A.b(t11, "item6 is null");
        p039g3.A.b(t12, "item7 is null");
        p039g3.A.b(t13, "item8 is null");
        p039g3.A.b(t14, "item9 is null");
        return fromArray(t6, t7, t8, t9, t10, t11, t12, t13, t14);
    }

    public final p106s3.a replay(long j6, TimeUnit timeUnit) {
        return replay(j6, timeUnit, io.reactivex.schedulers.j.computation());
    }

    public final <B> B<B<T>> window(Callable<? extends G> callable, int i5) {
        p039g3.A.b(callable, "boundary is null");
        p039g3.A.c(i5, "bufferSize");
        return io.reactivex.plugins.a.onAssembly(new B3(this, callable, i5, 1));
    }

    public final p106s3.a replay(long j6, TimeUnit timeUnit, N n6) {
        p039g3.A.b(timeUnit, "unit is null");
        p039g3.A.b(n6, "scheduler is null");
        return C0961z2.e(this, new C0940u2(Integer.MAX_VALUE, j6, timeUnit, n6));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> B<R> zip(G g6, G g7, G g8, G g9, G g10, G g11, G g12, p027e3.l lVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.A.b(g11, "source6 is null");
        p039g3.A.b(g12, "source7 is null");
        p039g3.z.f();
        throw null;
    }

    public final p106s3.a replay(N n6) {
        p039g3.A.b(n6, "scheduler is null");
        p106s3.a aVarReplay = replay();
        return io.reactivex.plugins.a.onAssembly((p106s3.a) new C0921q2(aVarReplay, aVarReplay.observeOn(n6)));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> B<R> combineLatest(G g6, G g7, G g8, G g9, G g10, G g11, G g12, G g13, p027e3.m mVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.A.b(g11, "source6 is null");
        p039g3.A.b(g12, "source7 is null");
        p039g3.A.b(g13, "source8 is null");
        p039g3.z.g();
        throw null;
    }

    public static <T> B<T> just(T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13, T t14, T t15) {
        p039g3.A.b(t6, "item1 is null");
        p039g3.A.b(t7, "item2 is null");
        p039g3.A.b(t8, "item3 is null");
        p039g3.A.b(t9, "item4 is null");
        p039g3.A.b(t10, "item5 is null");
        p039g3.A.b(t11, "item6 is null");
        p039g3.A.b(t12, "item7 is null");
        p039g3.A.b(t13, "item8 is null");
        p039g3.A.b(t14, "item9 is null");
        p039g3.A.b(t15, "item10 is null");
        return fromArray(t6, t7, t8, t9, t10, t11, t12, t13, t14, t15);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> B<R> zip(G g6, G g7, G g8, G g9, G g10, G g11, G g12, G g13, p027e3.m mVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.A.b(g11, "source6 is null");
        p039g3.A.b(g12, "source7 is null");
        p039g3.A.b(g13, "source8 is null");
        p039g3.z.g();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> B<R> combineLatest(G g6, G g7, G g8, G g9, G g10, G g11, G g12, G g13, G g14, p027e3.n nVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.A.b(g11, "source6 is null");
        p039g3.A.b(g12, "source7 is null");
        p039g3.A.b(g13, "source8 is null");
        p039g3.A.b(g14, "source9 is null");
        p039g3.z.h();
        throw null;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> B<R> zip(G g6, G g7, G g8, G g9, G g10, G g11, G g12, G g13, G g14, p027e3.n nVar) {
        p039g3.A.b(g6, "source1 is null");
        p039g3.A.b(g7, "source2 is null");
        p039g3.A.b(g8, "source3 is null");
        p039g3.A.b(g9, "source4 is null");
        p039g3.A.b(g10, "source5 is null");
        p039g3.A.b(g11, "source6 is null");
        p039g3.A.b(g12, "source7 is null");
        p039g3.A.b(g13, "source8 is null");
        p039g3.A.b(g14, "source9 is null");
        p039g3.z.h();
        throw null;
    }
}
