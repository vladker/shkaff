package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0802u extends AtomicLong implements InterfaceC0984q, t5.d, p027e3.e {
    private static final long serialVersionUID = -7370244972039324525L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4787a;
    public final Callable b;
    public final int c;
    public final int d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t5.d f4789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4793k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f4788f = new AtomicBoolean();
    public final ArrayDeque e = new ArrayDeque();

    public C0802u(t5.c cVar, int i5, int i6, Callable callable) {
        this.f4787a = cVar;
        this.c = i5;
        this.d = i6;
        this.b = callable;
    }

    @Override // t5.d
    public final void cancel() {
        this.f4792j = true;
        this.f4789g.cancel();
    }

    @Override // p027e3.e
    public final boolean getAsBoolean() {
        return this.f4792j;
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4790h) {
            return;
        }
        this.f4790h = true;
        long j6 = this.f4793k;
        if (j6 != 0) {
            p122v2.a.e(this, j6);
        }
        ArrayDeque arrayDeque = this.e;
        boolean zIsEmpty = arrayDeque.isEmpty();
        t5.c cVar = this.f4787a;
        if (zIsEmpty) {
            cVar.onComplete();
            return;
        }
        C0802u c0802u = this;
        if (com.bumptech.glide.f.f(get(), cVar, arrayDeque, c0802u, this)) {
            return;
        }
        while (true) {
            long j7 = get();
            if ((j7 & Long.MIN_VALUE) != 0) {
                return;
            }
            long j8 = j7 | Long.MIN_VALUE;
            if (compareAndSet(j7, j8)) {
                if (j7 != 0) {
                    com.bumptech.glide.f.f(j8, cVar, arrayDeque, c0802u, this);
                    return;
                }
                return;
            }
            c0802u = this;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4790h) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4790h = true;
        this.e.clear();
        this.f4787a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4790h) {
            return;
        }
        int i5 = this.f4791i;
        int i6 = i5 + 1;
        ArrayDeque arrayDeque = this.e;
        if (i5 == 0) {
            try {
                Object objCall = this.b.call();
                p039g3.A.b(objCall, "The bufferSupplier returned a null buffer");
                arrayDeque.offer((Collection) objCall);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cancel();
                onError(th);
                return;
            }
        }
        Collection collection = (Collection) arrayDeque.peek();
        if (collection != null && collection.size() + 1 == this.c) {
            arrayDeque.poll();
            collection.add(obj);
            this.f4793k++;
            this.f4787a.onNext(collection);
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).add(obj);
        }
        if (i6 == this.d) {
            i6 = 0;
        }
        this.f4791i = i6;
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4789g, dVar)) {
            this.f4789g = dVar;
            this.f4787a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        long j7;
        if (p094q3.g.f(j6)) {
            do {
                j7 = get();
            } while (!compareAndSet(j7, p122v2.a.c(LocationRequestCompat.PASSIVE_INTERVAL & j7, j6) | (j7 & Long.MIN_VALUE)));
            if (j7 == Long.MIN_VALUE) {
                com.bumptech.glide.f.f(j6 | Long.MIN_VALUE, this.f4787a, this.e, this, this);
                return;
            }
            AtomicBoolean atomicBoolean = this.f4788f;
            boolean z6 = atomicBoolean.get();
            int i5 = this.d;
            if (z6 || !atomicBoolean.compareAndSet(false, true)) {
                this.f4789g.request(p122v2.a.d(i5, j6));
            } else {
                this.f4789g.request(p122v2.a.c(this.c, p122v2.a.d(i5, j6 - 1)));
            }
        }
    }
}
