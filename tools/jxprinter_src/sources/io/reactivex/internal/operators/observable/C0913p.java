package io.reactivex.internal.operators.observable;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0913p extends AtomicBoolean implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -8223395059921494546L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5248a;
    public final int b;
    public final int c;
    public final Callable d;
    public p011b3.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque f5249f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5250g;

    public C0913p(io.reactivex.I i5, int i6, int i7, Callable callable) {
        this.f5248a = i5;
        this.b = i6;
        this.c = i7;
        this.d = callable;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        while (true) {
            ArrayDeque arrayDeque = this.f5249f;
            boolean zIsEmpty = arrayDeque.isEmpty();
            io.reactivex.I i5 = this.f5248a;
            if (zIsEmpty) {
                i5.onComplete();
                return;
            }
            i5.onNext(arrayDeque.poll());
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5249f.clear();
        this.f5248a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        long j6 = this.f5250g;
        this.f5250g = 1 + j6;
        long j7 = j6 % ((long) this.c);
        io.reactivex.I i5 = this.f5248a;
        ArrayDeque arrayDeque = this.f5249f;
        if (j7 == 0) {
            try {
                Object objCall = this.d.call();
                p039g3.A.b(objCall, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                arrayDeque.offer((Collection) objCall);
            } catch (Throwable th) {
                arrayDeque.clear();
                this.e.dispose();
                i5.onError(th);
                return;
            }
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            Collection collection = (Collection) it.next();
            collection.add(obj);
            if (this.b <= collection.size()) {
                it.remove();
                i5.onNext(collection);
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.e, cVar)) {
            this.e = cVar;
            this.f5248a.onSubscribe(this);
        }
    }
}
