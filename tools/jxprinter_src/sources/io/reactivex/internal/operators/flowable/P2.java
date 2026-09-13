package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.EnumC0674a;
import io.reactivex.InterfaceC0984q;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P2 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 3240706908776709697L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4407a;
    public final p027e3.a b;
    public final EnumC0674a c;
    public final long d;
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque f4408f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t5.d f4409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f4412j;

    public P2(t5.c cVar, p027e3.a aVar, EnumC0674a enumC0674a, long j6) {
        this.f4407a = cVar;
        this.b = aVar;
        this.c = enumC0674a;
        this.d = j6;
    }

    public static void a(ArrayDeque arrayDeque) {
        synchronized (arrayDeque) {
            arrayDeque.clear();
        }
    }

    public final void b() {
        boolean zIsEmpty;
        Object objPoll;
        if (getAndIncrement() != 0) {
            return;
        }
        ArrayDeque arrayDeque = this.f4408f;
        t5.c cVar = this.f4407a;
        int iAddAndGet = 1;
        do {
            long j6 = this.e.get();
            long j7 = 0;
            while (j7 != j6) {
                if (this.f4410h) {
                    a(arrayDeque);
                    return;
                }
                boolean z6 = this.f4411i;
                synchronized (arrayDeque) {
                    objPoll = arrayDeque.poll();
                }
                boolean z7 = objPoll == null;
                if (z6) {
                    Throwable th = this.f4412j;
                    if (th != null) {
                        a(arrayDeque);
                        cVar.onError(th);
                        return;
                    } else if (z7) {
                        cVar.onComplete();
                        return;
                    }
                }
                if (z7) {
                    break;
                }
                cVar.onNext(objPoll);
                j7++;
            }
            if (j7 == j6) {
                if (this.f4410h) {
                    a(arrayDeque);
                    return;
                }
                boolean z8 = this.f4411i;
                synchronized (arrayDeque) {
                    zIsEmpty = arrayDeque.isEmpty();
                }
                if (z8) {
                    Throwable th2 = this.f4412j;
                    if (th2 != null) {
                        a(arrayDeque);
                        cVar.onError(th2);
                        return;
                    } else if (zIsEmpty) {
                        cVar.onComplete();
                        return;
                    }
                }
            }
            if (j7 != 0) {
                p122v2.a.e(this.e, j7);
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // t5.d
    public final void cancel() {
        this.f4410h = true;
        this.f4409g.cancel();
        if (getAndIncrement() == 0) {
            a(this.f4408f);
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4411i = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4411i) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4412j = th;
        this.f4411i = true;
        b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        boolean z6;
        boolean z7;
        if (this.f4411i) {
            return;
        }
        ArrayDeque arrayDeque = this.f4408f;
        synchronized (arrayDeque) {
            try {
                z6 = false;
                if (arrayDeque.size() == this.d) {
                    int iOrdinal = this.c.ordinal();
                    z7 = true;
                    if (iOrdinal == 1) {
                        arrayDeque.poll();
                        arrayDeque.offer(obj);
                    } else if (iOrdinal == 2) {
                        arrayDeque.pollLast();
                        arrayDeque.offer(obj);
                    }
                    z7 = false;
                    z6 = true;
                } else {
                    arrayDeque.offer(obj);
                    z7 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z6) {
            if (!z7) {
                b();
                return;
            } else {
                this.f4409g.cancel();
                onError(new p017c3.e());
                return;
            }
        }
        p027e3.a aVar = this.b;
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                this.f4409g.cancel();
                onError(th2);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4409g, dVar)) {
            this.f4409g = dVar;
            this.f4407a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.e, j6);
            b();
        }
    }
}
