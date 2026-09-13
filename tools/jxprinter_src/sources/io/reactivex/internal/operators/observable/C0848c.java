package io.reactivex.internal.operators.observable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0848c extends p112t3.c implements Iterator {
    public io.reactivex.A b;
    public final Semaphore c = new Semaphore(0);
    public final AtomicReference d = new AtomicReference();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        io.reactivex.A a6 = this.b;
        if (a6 != null && (a6.f4169a instanceof p100r3.l)) {
            throw p100r3.g.d(a6.getError());
        }
        if (a6 == null) {
            try {
                this.c.acquire();
                io.reactivex.A a7 = (io.reactivex.A) this.d.getAndSet(null);
                this.b = a7;
                if (a7.f4169a instanceof p100r3.l) {
                    throw p100r3.g.d(a7.getError());
                }
            } catch (InterruptedException e) {
                dispose();
                this.b = io.reactivex.A.createOnError(e);
                throw p100r3.g.d(e);
            }
        }
        return this.b.a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object value = this.b.getValue();
        this.b = null;
        return value;
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onError(Throwable th) {
        io.reactivex.plugins.a.onError(th);
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onNext(Object obj) {
        if (this.d.getAndSet((io.reactivex.A) obj) == null) {
            this.c.release();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read-only iterator.");
    }

    @Override // io.reactivex.I
    public final void onComplete() {
    }
}
