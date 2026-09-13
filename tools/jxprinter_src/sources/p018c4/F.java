package p018c4;

import E3.g;
import E3.q;
import O3.l;
import O3.p;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p147z3.Q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class F {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    public static final void cancelConsumed(B0 b1, Throwable th) {
        K.cancelConsumed(b1, th);
    }

    public static final <E, R> R consume(InterfaceC0366a interfaceC0366a, l lVar) {
        return (R) p0.consume(interfaceC0366a, lVar);
    }

    public static final <E> Object consumeEach(InterfaceC0366a interfaceC0366a, l lVar, g<? super Q> gVar) {
        return p0.consumeEach(interfaceC0366a, lVar, gVar);
    }

    public static final l consumes(B0 b1) {
        return p0.consumes(b1);
    }

    public static final l consumesAll(B0... b0Arr) {
        return p0.consumesAll(b0Arr);
    }

    public static final <E, K> B0 distinctBy(B0 b1, q qVar, p pVar) {
        return p0.distinctBy(b1, qVar, pVar);
    }

    public static final <E> B0 filter(B0 b1, q qVar, p pVar) {
        return p0.filter(b1, qVar, pVar);
    }

    public static final <E> B0 filterNotNull(B0 b1) {
        return p0.filterNotNull(b1);
    }

    public static final <E, R> B0 map(B0 b1, q qVar, p pVar) {
        return p0.map(b1, qVar, pVar);
    }

    public static final <E, R> B0 mapIndexed(B0 b1, q qVar, O3.q qVar2) {
        return p0.mapIndexed(b1, qVar, qVar2);
    }

    public static final <E, C extends D0> Object toChannel(B0 b1, C c, g<? super C> gVar) {
        return p0.toChannel(b1, c, gVar);
    }

    public static final <E, C extends Collection<? super E>> Object toCollection(B0 b1, C c, g<? super C> gVar) {
        return p0.toCollection(b1, c, gVar);
    }

    public static final <E> Object toList(B0 b1, g<? super List<? extends E>> gVar) {
        return K.toList(b1, gVar);
    }

    public static final <E> Object toMutableSet(B0 b1, g<? super Set<E>> gVar) {
        return p0.toMutableSet(b1, gVar);
    }

    public static final <E> Object trySendBlocking(D0 d1, E e) {
        return H.trySendBlocking(d1, e);
    }

    public static final <E, R> R consume(B0 b1, l lVar) {
        return (R) K.consume(b1, lVar);
    }

    public static final <E> Object consumeEach(B0 b1, l lVar, g<? super Q> gVar) {
        return K.consumeEach(b1, lVar, gVar);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(B0 b1, M m6, g<? super M> gVar) {
        return p0.toMap(b1, m6, gVar);
    }

    public static final <E, R, V> B0 zip(B0 b1, B0 b6, q qVar, p pVar) {
        return p0.zip(b1, b6, qVar, pVar);
    }
}
