package p117u3;

import A3.AbstractC0157z;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.AbstractC0979l;
import io.reactivex.N;
import io.reactivex.internal.operators.flowable.C0779q;
import io.reactivex.plugins.a;
import java.util.Comparator;
import java.util.concurrent.Callable;
import p017c3.d;
import p027e3.c;
import p027e3.g;
import p027e3.o;
import p027e3.p;
import p027e3.q;
import p039g3.A;
import p039g3.h;
import p039g3.z;
import p071m3.C1239b;
import p071m3.C1240c;
import p071m3.f;
import p071m3.i;
import p071m3.l;
import p071m3.s;
import p100r3.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static <T> b from(t5.b bVar) {
        return from(bVar, Runtime.getRuntime().availableProcessors(), AbstractC0979l.f5366a);
    }

    public static <T> b fromArray(t5.b... bVarArr) {
        if (bVarArr.length != 0) {
            return a.onAssembly(new i(bVarArr));
        }
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    public abstract int a();

    public final <R> R as(c cVar) {
        A.b(cVar, "converter is null");
        throw new ClassCastException();
    }

    public final <C> b collect(Callable<? extends C> callable, p027e3.b bVar) {
        A.b(callable, "collectionSupplier is null");
        A.b(bVar, "collector is null");
        return a.onAssembly(new C1239b(this, callable, bVar, 0));
    }

    public final <U> b compose(d dVar) {
        A.b(dVar, "composer is null");
        throw new ClassCastException();
    }

    public final <R> b concatMap(o oVar) {
        return concatMap(oVar, 2);
    }

    public final <R> b concatMapDelayError(o oVar, boolean z6) {
        return concatMapDelayError(oVar, 2, z6);
    }

    public final b doAfterNext(g gVar) {
        A.b(gVar, "onAfterNext is null");
        h hVar = z.c;
        V1.b bVar = z.f4011f;
        V1.b bVar2 = z.d;
        return a.onAssembly(new s(this, bVar2, gVar, bVar2, hVar, hVar, bVar2, bVar, hVar));
    }

    public final b doAfterTerminated(p027e3.a aVar) {
        A.b(aVar, "onAfterTerminate is null");
        h hVar = z.c;
        V1.b bVar = z.f4011f;
        V1.b bVar2 = z.d;
        return a.onAssembly(new s(this, bVar2, bVar2, bVar2, hVar, aVar, bVar2, bVar, hVar));
    }

    public final b doOnCancel(p027e3.a aVar) {
        A.b(aVar, "onCancel is null");
        h hVar = z.c;
        V1.b bVar = z.f4011f;
        V1.b bVar2 = z.d;
        return a.onAssembly(new s(this, bVar2, bVar2, bVar2, hVar, hVar, bVar2, bVar, aVar));
    }

    public final b doOnComplete(p027e3.a aVar) {
        A.b(aVar, "onComplete is null");
        h hVar = z.c;
        V1.b bVar = z.f4011f;
        V1.b bVar2 = z.d;
        return a.onAssembly(new s(this, bVar2, bVar2, bVar2, aVar, hVar, bVar2, bVar, hVar));
    }

    public final b doOnError(g gVar) {
        A.b(gVar, "onError is null");
        h hVar = z.c;
        V1.b bVar = z.f4011f;
        V1.b bVar2 = z.d;
        return a.onAssembly(new s(this, bVar2, bVar2, gVar, hVar, hVar, bVar2, bVar, hVar));
    }

    public final b doOnNext(g gVar) {
        A.b(gVar, "onNext is null");
        h hVar = z.c;
        V1.b bVar = z.f4011f;
        V1.b bVar2 = z.d;
        return a.onAssembly(new s(this, gVar, bVar2, bVar2, hVar, hVar, bVar2, bVar, hVar));
    }

    public final b doOnRequest(p pVar) {
        A.b(pVar, "onRequest is null");
        V1.b bVar = z.d;
        h hVar = z.c;
        return a.onAssembly(new s(this, bVar, bVar, bVar, hVar, hVar, bVar, pVar, hVar));
    }

    public final b doOnSubscribe(g gVar) {
        A.b(gVar, "onSubscribe is null");
        h hVar = z.c;
        V1.b bVar = z.f4011f;
        V1.b bVar2 = z.d;
        return a.onAssembly(new s(this, bVar2, bVar2, bVar2, hVar, hVar, gVar, bVar, hVar));
    }

    public final b filter(q qVar) {
        A.b(qVar, "predicate");
        return a.onAssembly(new f(this, qVar, 0));
    }

    public final <R> b flatMap(o oVar) {
        return flatMap(oVar, false, Integer.MAX_VALUE, AbstractC0979l.f5366a);
    }

    public final <R> b map(o oVar) {
        A.b(oVar, "mapper");
        return a.onAssembly(new f(this, oVar, 1));
    }

    public final AbstractC0979l reduce(c cVar) {
        A.b(cVar, "reducer");
        return a.onAssembly(new C0779q(this, cVar, 6));
    }

    public final b runOn(N n6) {
        return runOn(n6, AbstractC0979l.f5366a);
    }

    public final AbstractC0979l sequential() {
        return sequential(AbstractC0979l.f5366a);
    }

    public final AbstractC0979l sequentialDelayError() {
        return sequentialDelayError(AbstractC0979l.f5366a);
    }

    public final AbstractC0979l sorted(Comparator<Object> comparator) {
        return sorted(comparator, 16);
    }

    public abstract void subscribe(t5.c[] cVarArr);

    public final <U> U to(o oVar) {
        try {
            A.b(oVar, "converter is null");
            return (U) oVar.apply(this);
        } catch (Throwable th) {
            d.throwIfFatal(th);
            throw p100r3.g.d(th);
        }
    }

    public final AbstractC0979l toSortedList(Comparator<Object> comparator) {
        return toSortedList(comparator, 16);
    }

    public final boolean validate(t5.c[] cVarArr) {
        int iA = a();
        if (cVarArr.length == iA) {
            return true;
        }
        StringBuilder sbT = AbstractC0157z.t(iA, "parallelism = ", ", subscribers = ");
        sbT.append(cVarArr.length);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sbT.toString());
        for (t5.c cVar : cVarArr) {
            p094q3.d.e(illegalArgumentException, cVar);
        }
        return false;
    }

    public final <R> b concatMap(o oVar, int i5) {
        A.b(oVar, "mapper is null");
        A.c(i5, "prefetch");
        return a.onAssembly(new C1240c(this, oVar, i5, 1));
    }

    public final <R> b concatMapDelayError(o oVar, int i5, boolean z6) {
        A.b(oVar, "mapper is null");
        A.c(i5, "prefetch");
        return a.onAssembly(new C1240c(this, oVar, i5, z6 ? 3 : 2));
    }

    public final AbstractC0979l sorted(Comparator<Object> comparator, int i5) {
        A.b(comparator, "comparator is null");
        A.c(i5, "capacityHint");
        return a.onAssembly(new C0779q(reduce(new p039g3.c((i5 / a()) + 1), p100r3.i.f7963a).map(new p100r3.o(comparator)), comparator, 7));
    }

    public final AbstractC0979l toSortedList(Comparator<Object> comparator, int i5) {
        A.b(comparator, "comparator is null");
        A.c(i5, "capacityHint");
        return a.onAssembly(reduce(new p039g3.c((i5 / a()) + 1), p100r3.i.f7963a).map(new p100r3.o(comparator)).reduce(new j(comparator)));
    }

    public final b filter(q qVar, a aVar) {
        A.b(qVar, "predicate");
        A.b(aVar, "errorHandler is null");
        return a.onAssembly(new C1239b(this, qVar, aVar, 2));
    }

    public final <R> b flatMap(o oVar, boolean z6) {
        return flatMap(oVar, z6, Integer.MAX_VALUE, AbstractC0979l.f5366a);
    }

    public final <R> b map(o oVar, a aVar) {
        A.b(oVar, "mapper");
        A.b(aVar, "errorHandler is null");
        return a.onAssembly(new C1239b(this, oVar, aVar, 3));
    }

    public final <R> b reduce(Callable<R> callable, c cVar) {
        A.b(callable, "initialSupplier");
        A.b(cVar, "reducer");
        return a.onAssembly(new C1239b(this, callable, cVar, 4));
    }

    public final b runOn(N n6, int i5) {
        A.b(n6, "scheduler");
        A.c(i5, "prefetch");
        return a.onAssembly(new p071m3.A(this, n6, i5));
    }

    public final AbstractC0979l sequential(int i5) {
        A.c(i5, "prefetch");
        return a.onAssembly(new p071m3.q(this, i5, false));
    }

    public final AbstractC0979l sequentialDelayError(int i5) {
        A.c(i5, "prefetch");
        return a.onAssembly(new p071m3.q(this, i5, true));
    }

    public static <T> b from(t5.b bVar, int i5, int i6) {
        A.b(bVar, FirebaseAnalytics.Param.SOURCE);
        A.c(i5, "parallelism");
        A.c(i6, "prefetch");
        return a.onAssembly(new l(bVar, i5, i6));
    }

    public final <R> b flatMap(o oVar, boolean z6, int i5) {
        return flatMap(oVar, z6, i5, AbstractC0979l.f5366a);
    }

    public final b doOnNext(g gVar, a aVar) {
        A.b(gVar, "onNext is null");
        A.b(aVar, "errorHandler is null");
        return a.onAssembly(new C1239b(this, gVar, aVar, 1));
    }

    public final b filter(q qVar, c cVar) {
        A.b(qVar, "predicate");
        A.b(cVar, "errorHandler is null");
        return a.onAssembly(new C1239b(this, qVar, cVar, 2));
    }

    public final <R> b map(o oVar, c cVar) {
        A.b(oVar, "mapper");
        A.b(cVar, "errorHandler is null");
        return a.onAssembly(new C1239b(this, oVar, cVar, 3));
    }

    public final <R> b flatMap(o oVar, boolean z6, int i5, int i6) {
        A.b(oVar, "mapper is null");
        A.c(i5, "maxConcurrency");
        A.c(i6, "prefetch");
        return a.onAssembly(new p071m3.h(this, oVar, z6, i5, i6));
    }

    public static <T> b from(t5.b bVar, int i5) {
        return from(bVar, i5, AbstractC0979l.f5366a);
    }

    public final b doOnNext(g gVar, c cVar) {
        A.b(gVar, "onNext is null");
        A.b(cVar, "errorHandler is null");
        return a.onAssembly(new C1239b(this, gVar, cVar, 1));
    }
}
