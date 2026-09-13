package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L2 extends AtomicInteger implements p043h3.e, Runnable {
    private static final long serialVersionUID = 3880992722410194083L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5011a;
    public final Object b;

    public L2(io.reactivex.I i5, Object obj) {
        this.f5011a = i5;
        this.b = obj;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        lazySet(1);
        return 1;
    }

    @Override // p043h3.j
    public final void clear() {
        lazySet(3);
    }

    @Override // p011b3.c
    public final void dispose() {
        set(3);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == 3;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return get() != 1;
    }

    @Override // p043h3.e, p043h3.f, p043h3.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        if (get() != 1) {
            return null;
        }
        lazySet(3);
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            Object obj = this.b;
            io.reactivex.I i5 = this.f5011a;
            i5.onNext(obj);
            if (get() == 2) {
                lazySet(3);
                i5.onComplete();
            }
        }
    }

    @Override // p043h3.e, p043h3.f, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
