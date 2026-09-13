package p129w3;

import io.reactivex.AbstractC0979l;
import io.reactivex.I;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.e;
import p039g3.A;
import p083o3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8820a;
    public final AtomicReference b;
    public final AtomicReference c;
    public final boolean d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f8821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f8822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f8823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f8824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8825j;

    public f(int i5, Runnable runnable, boolean z6) {
        A.c(i5, "capacityHint");
        this.f8820a = new d(i5);
        A.b(runnable, "onTerminate");
        this.c = new AtomicReference(runnable);
        this.d = z6;
        this.b = new AtomicReference();
        this.f8823h = new AtomicBoolean();
        this.f8824i = new e(this);
    }

    public static <T> f create() {
        return new f(AbstractC0979l.f5366a, true);
    }

    @Override // io.reactivex.B
    public final void b(I i5) {
        if (this.f8823h.get() || !this.f8823h.compareAndSet(false, true)) {
            IllegalStateException illegalStateException = new IllegalStateException("Only a single observer allowed.");
            i5.onSubscribe(e.f3970a);
            i5.onError(illegalStateException);
        } else {
            i5.onSubscribe(this.f8824i);
            this.b.lazySet(i5);
            if (this.e) {
                this.b.lazySet(null);
            } else {
                f();
            }
        }
    }

    public final void e() {
        AtomicReference atomicReference = this.c;
        Runnable runnable = (Runnable) atomicReference.get();
        if (runnable != null) {
            while (!atomicReference.compareAndSet(runnable, null)) {
                if (atomicReference.get() != runnable) {
                    return;
                }
            }
            runnable.run();
        }
    }

    public final void f() {
        Throwable th;
        if (this.f8824i.getAndIncrement() != 0) {
            return;
        }
        I i5 = (I) this.b.get();
        int iAddAndGet = 1;
        int iAddAndGet2 = 1;
        while (i5 == null) {
            iAddAndGet2 = this.f8824i.addAndGet(-iAddAndGet2);
            if (iAddAndGet2 == 0) {
                return;
            } else {
                i5 = (I) this.b.get();
            }
        }
        if (this.f8825j) {
            d dVar = this.f8820a;
            boolean z6 = this.d;
            while (!this.e) {
                boolean z7 = this.f8821f;
                if (!z6 && z7 && (th = this.f8822g) != null) {
                    this.b.lazySet(null);
                    dVar.clear();
                    i5.onError(th);
                    return;
                }
                i5.onNext(null);
                if (z7) {
                    this.b.lazySet(null);
                    Throwable th2 = this.f8822g;
                    if (th2 != null) {
                        i5.onError(th2);
                        return;
                    } else {
                        i5.onComplete();
                        return;
                    }
                }
                iAddAndGet = this.f8824i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            this.b.lazySet(null);
            dVar.clear();
            return;
        }
        d dVar2 = this.f8820a;
        boolean z8 = this.d;
        boolean z9 = true;
        int iAddAndGet3 = 1;
        while (!this.e) {
            boolean z10 = this.f8821f;
            Object objPoll = this.f8820a.poll();
            boolean z11 = objPoll == null;
            if (z10) {
                if (!z8 && z9) {
                    Throwable th3 = this.f8822g;
                    if (th3 != null) {
                        this.b.lazySet(null);
                        dVar2.clear();
                        i5.onError(th3);
                        return;
                    }
                    z9 = false;
                }
                if (z11) {
                    this.b.lazySet(null);
                    Throwable th4 = this.f8822g;
                    if (th4 != null) {
                        i5.onError(th4);
                        return;
                    } else {
                        i5.onComplete();
                        return;
                    }
                }
            }
            if (z11) {
                iAddAndGet3 = this.f8824i.addAndGet(-iAddAndGet3);
                if (iAddAndGet3 == 0) {
                    return;
                }
            } else {
                i5.onNext(objPoll);
            }
        }
        this.b.lazySet(null);
        dVar2.clear();
    }

    @Override // p129w3.d
    public Throwable getThrowable() {
        if (this.f8821f) {
            return this.f8822g;
        }
        return null;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f8821f || this.e) {
            return;
        }
        this.f8821f = true;
        e();
        f();
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onError(Throwable th) {
        A.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f8821f || this.e) {
            a.onError(th);
            return;
        }
        this.f8822g = th;
        this.f8821f = true;
        e();
        f();
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onNext(Object obj) {
        A.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f8821f || this.e) {
            return;
        }
        this.f8820a.offer(obj);
        f();
    }

    @Override // p129w3.d, io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (this.f8821f || this.e) {
            cVar.dispose();
        }
    }

    public static <T> f create(int i5) {
        return new f(i5, true);
    }

    public static <T> f create(int i5, Runnable runnable) {
        return new f(i5, runnable, true);
    }

    public static <T> f create(int i5, Runnable runnable, boolean z6) {
        return new f(i5, runnable, z6);
    }

    public static <T> f create(boolean z6) {
        return new f(AbstractC0979l.f5366a, z6);
    }

    public f(int i5, boolean z6) {
        A.c(i5, "capacityHint");
        this.f8820a = new d(i5);
        this.c = new AtomicReference();
        this.d = z6;
        this.b = new AtomicReference();
        this.f8823h = new AtomicBoolean();
        this.f8824i = new e(this);
    }
}
