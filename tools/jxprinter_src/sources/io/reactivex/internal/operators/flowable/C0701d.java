package io.reactivex.internal.operators.flowable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0701d extends p135x3.a implements Iterator {
    public final Semaphore b = new Semaphore(0);
    public final AtomicReference c = new AtomicReference();
    public io.reactivex.A d;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        io.reactivex.A a6 = this.d;
        if (a6 != null && (a6.f4169a instanceof p100r3.l)) {
            throw p100r3.g.d(a6.getError());
        }
        if ((a6 == null || a6.a()) && this.d == null) {
            try {
                this.b.acquire();
                io.reactivex.A a7 = (io.reactivex.A) this.c.getAndSet(null);
                this.d = a7;
                if (a7.f4169a instanceof p100r3.l) {
                    throw p100r3.g.d(a7.getError());
                }
            } catch (InterruptedException e) {
                dispose();
                this.d = io.reactivex.A.createOnError(e);
                throw p100r3.g.d(e);
            }
        }
        return this.d.a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext() || !this.d.a()) {
            throw new NoSuchElementException();
        }
        Object value = this.d.getValue();
        this.d = null;
        return value;
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        io.reactivex.plugins.a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.c.getAndSet((io.reactivex.A) obj) == null) {
            this.b.release();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read-only iterator.");
    }

    @Override // t5.c
    public final void onComplete() {
    }
}
