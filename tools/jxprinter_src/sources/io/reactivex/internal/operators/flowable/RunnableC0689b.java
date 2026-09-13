package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0689b extends AtomicReference implements InterfaceC0984q, Iterator, Runnable, p011b3.c {
    private static final long serialVersionUID = 6695226475494099826L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p083o3.c f4556a;
    public final long b;
    public final long c;
    public final ReentrantLock d;
    public final Condition e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Throwable f4559h;

    public RunnableC0689b(int i5) {
        this.f4556a = new p083o3.c(i5);
        this.b = i5;
        this.c = i5 - (i5 >> 2);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.d = reentrantLock;
        this.e = reentrantLock.newCondition();
    }

    public final void a() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            this.e.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p094q3.g.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p094q3.g.f7849a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            boolean z6 = this.f4558g;
            boolean zIsEmpty = this.f4556a.isEmpty();
            if (z6) {
                Throwable th = this.f4559h;
                if (th != null) {
                    throw p100r3.g.d(th);
                }
                if (zIsEmpty) {
                    return false;
                }
            }
            if (!zIsEmpty) {
                return true;
            }
            this.d.lock();
            while (!this.f4558g && this.f4556a.isEmpty()) {
                try {
                    try {
                        this.e.await();
                    } catch (InterruptedException e) {
                        run();
                        throw p100r3.g.d(e);
                    }
                } catch (Throwable th2) {
                    this.d.unlock();
                    throw th2;
                }
            }
            this.d.unlock();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objPoll = this.f4556a.poll();
        long j6 = this.f4557f + 1;
        if (j6 != this.c) {
            this.f4557f = j6;
            return objPoll;
        }
        this.f4557f = 0L;
        ((t5.d) get()).request(j6);
        return objPoll;
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4558g = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4559h = th;
        this.f4558g = true;
        a();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4556a.offer(obj)) {
            a();
        } else {
            p094q3.g.a(this);
            onError(new p017c3.e("Queue full?!"));
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, this.b);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override // java.lang.Runnable
    public final void run() {
        p094q3.g.a(this);
        a();
    }
}
