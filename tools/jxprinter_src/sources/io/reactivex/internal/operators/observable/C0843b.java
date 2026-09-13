package io.reactivex.internal.operators.observable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0843b extends AtomicReference implements io.reactivex.I, Iterator, p011b3.c {
    private static final long serialVersionUID = 6695226475494099826L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p083o3.d f5145a;
    public final ReentrantLock b;
    public final Condition c;
    public volatile boolean d;
    public Throwable e;

    public C0843b(int i5) {
        this.f5145a = new p083o3.d(i5);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.b = reentrantLock;
        this.c = reentrantLock.newCondition();
    }

    public final void a() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            this.c.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            boolean z6 = this.d;
            boolean zIsEmpty = this.f5145a.isEmpty();
            if (z6) {
                Throwable th = this.e;
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
            try {
                this.b.lock();
                while (!this.d && this.f5145a.isEmpty()) {
                    try {
                        this.c.await();
                    } catch (Throwable th2) {
                        this.b.unlock();
                        throw th2;
                    }
                }
                this.b.unlock();
            } catch (InterruptedException e) {
                p033f3.d.a(this);
                a();
                throw p100r3.g.d(e);
            }
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            return this.f5145a.poll();
        }
        throw new NoSuchElementException();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.d = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.e = th;
        this.d = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5145a.offer(obj);
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
