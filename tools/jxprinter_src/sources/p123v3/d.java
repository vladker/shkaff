package p123v3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0979l;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p039g3.A;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {
    public final p083o3.d b;
    public final AtomicReference c;
    public final boolean d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f8780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f8781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f8782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f8783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f8784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f8785k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8786l;

    public d(int i5, Runnable runnable, boolean z6) {
        A.c(i5, "capacityHint");
        this.b = new p083o3.d(i5);
        this.c = new AtomicReference(runnable);
        this.d = z6;
        this.f8781g = new AtomicReference();
        this.f8783i = new AtomicBoolean();
        this.f8784j = new c(this);
        this.f8785k = new AtomicLong();
    }

    public static <T> d create() {
        return new d(AbstractC0979l.f5366a);
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(c cVar) {
        if (this.f8783i.get() || !this.f8783i.compareAndSet(false, true)) {
            IllegalStateException illegalStateException = new IllegalStateException("This processor allows only a single Subscriber");
            cVar.onSubscribe(p094q3.d.f7843a);
            cVar.onError(illegalStateException);
        } else {
            cVar.onSubscribe(this.f8784j);
            this.f8781g.set(cVar);
            if (this.f8782h) {
                this.f8781g.lazySet(null);
            } else {
                i();
            }
        }
    }

    public final boolean g(boolean z6, boolean z7, boolean z8, c cVar, p083o3.d dVar) {
        if (this.f8782h) {
            dVar.clear();
            this.f8781g.lazySet(null);
            return true;
        }
        if (!z7) {
            return false;
        }
        if (z6 && this.f8780f != null) {
            dVar.clear();
            this.f8781g.lazySet(null);
            cVar.onError(this.f8780f);
            return true;
        }
        if (!z8) {
            return false;
        }
        Throwable th = this.f8780f;
        this.f8781g.lazySet(null);
        if (th != null) {
            cVar.onError(th);
            return true;
        }
        cVar.onComplete();
        return true;
    }

    @Override // p123v3.a
    public Throwable getThrowable() {
        if (this.e) {
            return this.f8780f;
        }
        return null;
    }

    public final void i() {
        if (this.f8784j.getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        c cVar = (c) this.f8781g.get();
        int iAddAndGet2 = 1;
        while (cVar == null) {
            iAddAndGet2 = this.f8784j.addAndGet(-iAddAndGet2);
            if (iAddAndGet2 == 0) {
                return;
            } else {
                cVar = (c) this.f8781g.get();
            }
        }
        if (this.f8786l) {
            p083o3.d dVar = this.b;
            boolean z6 = this.d;
            while (!this.f8782h) {
                boolean z7 = this.e;
                if (!z6 && z7 && this.f8780f != null) {
                    dVar.clear();
                    this.f8781g.lazySet(null);
                    cVar.onError(this.f8780f);
                    return;
                }
                cVar.onNext(null);
                if (z7) {
                    this.f8781g.lazySet(null);
                    Throwable th = this.f8780f;
                    if (th != null) {
                        cVar.onError(th);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
                iAddAndGet = this.f8784j.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            dVar.clear();
            this.f8781g.lazySet(null);
            return;
        }
        p083o3.d dVar2 = this.b;
        boolean z8 = !this.d;
        int iAddAndGet3 = 1;
        while (true) {
            long j6 = this.f8785k.get();
            long j7 = 0;
            while (j6 != j7) {
                boolean z9 = this.e;
                Object objPoll = dVar2.poll();
                boolean z10 = objPoll == null;
                if (g(z8, z9, z10, cVar, dVar2)) {
                    return;
                }
                if (z10) {
                    break;
                }
                cVar.onNext(objPoll);
                j7++;
            }
            if (j6 == j7 && g(z8, this.e, dVar2.isEmpty(), cVar, dVar2)) {
                return;
            }
            if (j7 != 0 && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f8785k.addAndGet(-j7);
            }
            iAddAndGet3 = this.f8784j.addAndGet(-iAddAndGet3);
            if (iAddAndGet3 == 0) {
                return;
            } else {
                z8 = z8;
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.e || this.f8782h) {
            return;
        }
        this.e = true;
        Runnable runnable = (Runnable) this.c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
        i();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        A.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e || this.f8782h) {
            a.onError(th);
            return;
        }
        this.f8780f = th;
        this.e = true;
        Runnable runnable = (Runnable) this.c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
        i();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        A.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e || this.f8782h) {
            return;
        }
        this.b.offer(obj);
        i();
    }

    @Override // t5.c
    public final void onSubscribe(t5.d dVar) {
        if (this.e || this.f8782h) {
            dVar.cancel();
        } else {
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public static <T> d create(int i5) {
        return new d(i5);
    }

    public static <T> d create(boolean z6) {
        return new d(AbstractC0979l.f5366a, null, z6);
    }

    public static <T> d create(int i5, Runnable runnable) {
        A.b(runnable, "onTerminate");
        return new d(i5, runnable, true);
    }

    public d(int i5) {
        this(i5, null, true);
    }

    public static <T> d create(int i5, Runnable runnable, boolean z6) {
        A.b(runnable, "onTerminate");
        return new d(i5, runnable, z6);
    }
}
