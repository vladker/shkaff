package p088p3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends CountDownLatch implements InterfaceC0984q, Future, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f7742a;
    public Throwable b;
    public final AtomicReference c;

    public h() {
        super(1);
        this.c = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        g gVar;
        while (true) {
            AtomicReference atomicReference = this.c;
            d dVar = (d) atomicReference.get();
            if (dVar == this || dVar == (gVar = g.f7849a)) {
                return false;
            }
            do {
                if (atomicReference.compareAndSet(dVar, gVar)) {
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    countDown();
                    return true;
                }
            } while (atomicReference.get() == dVar);
        }
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
            return this.f7742a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.c.get() == g.f7849a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return getCount() == 0;
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f7742a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        while (true) {
            AtomicReference atomicReference = this.c;
            d dVar = (d) atomicReference.get();
            if (dVar == this || dVar == g.f7849a) {
                return;
            }
            do {
                if (atomicReference.compareAndSet(dVar, this)) {
                    countDown();
                    return;
                }
            } while (atomicReference.get() == dVar);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        while (true) {
            AtomicReference atomicReference = this.c;
            d dVar = (d) atomicReference.get();
            if (dVar == this || dVar == g.f7849a) {
                break;
            }
            this.b = th;
            do {
                if (atomicReference.compareAndSet(dVar, this)) {
                    countDown();
                    return;
                }
            } while (atomicReference.get() == dVar);
        }
        a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f7742a == null) {
            this.f7742a = obj;
        } else {
            ((d) this.c.get()).cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        g.d(this.c, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // t5.d
    public final void cancel() {
    }

    @Override // java.util.concurrent.Future
    public Object get(long j6, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (getCount() != 0 && !await(j6, timeUnit)) {
            throw new TimeoutException(p100r3.g.c(j6, timeUnit));
        }
        if (!isCancelled()) {
            Throwable th = this.b;
            if (th == null) {
                return this.f7742a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // t5.d
    public final void request(long j6) {
    }
}
