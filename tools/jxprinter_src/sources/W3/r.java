package W3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends AbstractC0234s implements Iterator, E3.g, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f818a;
    private Iterator<Object> nextIterator;
    private E3.g<? super p147z3.Q> nextStep;
    private Object nextValue;

    public final RuntimeException b() {
        int i5 = this.f818a;
        if (i5 == 4) {
            return new NoSuchElementException();
        }
        if (i5 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f818a);
    }

    @Override // E3.g
    public E3.q getContext() {
        return E3.r.INSTANCE;
    }

    public final E3.g<p147z3.Q> getNextStep() {
        return this.nextStep;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i5 = this.f818a;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2 || i5 == 3) {
                        return true;
                    }
                    if (i5 == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator<Object> it = this.nextIterator;
                kotlin.jvm.internal.E.c(it);
                if (it.hasNext()) {
                    this.f818a = 2;
                    return true;
                }
                this.nextIterator = null;
            }
            this.f818a = 5;
            E3.g<? super p147z3.Q> gVar = this.nextStep;
            kotlin.jvm.internal.E.c(gVar);
            this.nextStep = null;
            gVar.resumeWith(p147z3.u.m1361constructorimpl(p147z3.Q.INSTANCE));
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i5 = this.f818a;
        if (i5 == 0 || i5 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i5 == 2) {
            this.f818a = 1;
            Iterator<Object> it = this.nextIterator;
            kotlin.jvm.internal.E.c(it);
            return it.next();
        }
        if (i5 != 3) {
            throw b();
        }
        this.f818a = 0;
        Object obj = this.nextValue;
        this.nextValue = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // E3.g
    public void resumeWith(Object obj) throws Throwable {
        p147z3.v.throwOnFailure(obj);
        this.f818a = 4;
    }

    public final void setNextStep(E3.g<? super p147z3.Q> gVar) {
        this.nextStep = gVar;
    }

    @Override // W3.AbstractC0234s
    public Object yield(Object obj, E3.g<? super p147z3.Q> gVar) {
        this.nextValue = obj;
        this.f818a = 3;
        this.nextStep = gVar;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == F3.i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return coroutine_suspended == F3.i.getCOROUTINE_SUSPENDED() ? coroutine_suspended : p147z3.Q.INSTANCE;
    }

    @Override // W3.AbstractC0234s
    public Object yieldAll(Iterator<Object> it, E3.g<? super p147z3.Q> gVar) {
        if (!it.hasNext()) {
            return p147z3.Q.INSTANCE;
        }
        this.nextIterator = it;
        this.f818a = 2;
        this.nextStep = gVar;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == F3.i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return coroutine_suspended == F3.i.getCOROUTINE_SUSPENDED() ? coroutine_suspended : p147z3.Q.INSTANCE;
    }
}
