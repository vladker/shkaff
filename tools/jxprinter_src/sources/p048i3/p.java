package p048i3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends CountDownLatch implements S, Future, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4057a;
    public Throwable b;
    public final AtomicReference c;

    public p() {
        super(1);
        this.c = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        d dVar;
        while (true) {
            AtomicReference atomicReference = this.c;
            c cVar = (c) atomicReference.get();
            if (cVar == this || cVar == (dVar = d.f3969a)) {
                return false;
            }
            do {
                if (atomicReference.compareAndSet(cVar, dVar)) {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    countDown();
                    return true;
                }
            } while (atomicReference.get() == cVar);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.b;
        if (th == null) {
            return this.f4057a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return d.b((c) this.c.get());
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return getCount() == 0;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        while (true) {
            AtomicReference atomicReference = this.c;
            c cVar = (c) atomicReference.get();
            if (cVar == d.f3969a) {
                a.onError(th);
                return;
            }
            this.b = th;
            do {
                if (atomicReference.compareAndSet(cVar, this)) {
                    countDown();
                    return;
                }
            } while (atomicReference.get() == cVar);
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        d.f(this.c, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        AtomicReference atomicReference = this.c;
        c cVar = (c) atomicReference.get();
        if (cVar == d.f3969a) {
            return;
        }
        this.f4057a = obj;
        while (!atomicReference.compareAndSet(cVar, this) && atomicReference.get() == cVar) {
        }
        countDown();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j6, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (getCount() != 0 && !await(j6, timeUnit)) {
            throw new TimeoutException(g.c(j6, timeUnit));
        }
        if (!isCancelled()) {
            Throwable th = this.b;
            if (th == null) {
                return this.f4057a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // p011b3.c
    public final void dispose() {
    }
}
