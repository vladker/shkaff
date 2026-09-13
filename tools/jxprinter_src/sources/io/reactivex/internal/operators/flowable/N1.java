package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N1 extends p094q3.a implements t5.b {
    private static final long serialVersionUID = -3852313036005250360L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4367a;
    public final p083o3.d b;
    public final L1 c;
    public final boolean d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f4369g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4374l;
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f4370h = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f4371i = new AtomicReference();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f4372j = new AtomicBoolean();

    public N1(int i5, L1 l6, Object obj, boolean z6) {
        this.b = new p083o3.d(i5);
        this.c = l6;
        this.f4367a = obj;
        this.d = z6;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f4373k = true;
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4370h.compareAndSet(false, true)) {
            L1 l6 = this.c;
            l6.getClass();
            Object obj = this.f4367a;
            if (obj == null) {
                obj = L1.f4335q;
            }
            l6.f4337f.remove(obj);
            if (l6.f4343l.decrementAndGet() == 0) {
                l6.f4340i.cancel();
                if (l6.getAndIncrement() == 0) {
                    l6.f4338g.clear();
                }
            }
        }
    }

    @Override // p043h3.j
    public final void clear() {
        this.b.clear();
    }

    public final boolean e(boolean z6, boolean z7, t5.c cVar, boolean z8) {
        boolean z9 = this.f4370h.get();
        p083o3.d dVar = this.b;
        if (z9) {
            dVar.clear();
            return true;
        }
        if (!z6) {
            return false;
        }
        if (z8) {
            if (!z7) {
                return false;
            }
            Throwable th = this.f4369g;
            if (th != null) {
                cVar.onError(th);
                return true;
            }
            cVar.onComplete();
            return true;
        }
        Throwable th2 = this.f4369g;
        if (th2 != null) {
            dVar.clear();
            cVar.onError(th2);
            return true;
        }
        if (!z7) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public final void f() {
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        if (this.f4373k) {
            p083o3.d dVar = this.b;
            t5.c cVar = (t5.c) this.f4371i.get();
            while (true) {
                if (cVar != null) {
                    if (this.f4370h.get()) {
                        dVar.clear();
                        return;
                    }
                    boolean z6 = this.f4368f;
                    if (z6 && !this.d && (th = this.f4369g) != null) {
                        dVar.clear();
                        cVar.onError(th);
                        return;
                    }
                    cVar.onNext(null);
                    if (z6) {
                        Throwable th2 = this.f4369g;
                        if (th2 != null) {
                            cVar.onError(th2);
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (cVar == null) {
                    cVar = (t5.c) this.f4371i.get();
                }
            }
        } else {
            p083o3.d dVar2 = this.b;
            boolean z7 = this.d;
            t5.c cVar2 = (t5.c) this.f4371i.get();
            int iAddAndGet2 = 1;
            while (true) {
                if (cVar2 != null) {
                    long j6 = this.e.get();
                    long j7 = 0;
                    while (j7 != j6) {
                        boolean z8 = this.f4368f;
                        Object objPoll = dVar2.poll();
                        boolean z9 = objPoll == null;
                        if (e(z8, z9, cVar2, z7)) {
                            return;
                        }
                        if (z9) {
                            break;
                        }
                        cVar2.onNext(objPoll);
                        j7++;
                    }
                    if (j7 == j6 && e(this.f4368f, dVar2.isEmpty(), cVar2, z7)) {
                        return;
                    }
                    if (j7 != 0) {
                        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                            this.e.addAndGet(-j7);
                        }
                        this.c.f4340i.request(j7);
                    }
                }
                iAddAndGet2 = addAndGet(-iAddAndGet2);
                if (iAddAndGet2 == 0) {
                    return;
                }
                if (cVar2 == null) {
                    cVar2 = (t5.c) this.f4371i.get();
                }
            }
        }
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.b.poll();
        if (objPoll != null) {
            this.f4374l++;
            return objPoll;
        }
        int i5 = this.f4374l;
        if (i5 == 0) {
            return null;
        }
        this.f4374l = 0;
        this.c.f4340i.request(i5);
        return null;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.e, j6);
            f();
        }
    }

    @Override // t5.b
    public final void subscribe(t5.c cVar) {
        if (!this.f4372j.compareAndSet(false, true)) {
            p094q3.d.e(new IllegalStateException("Only one Subscriber allowed!"), cVar);
            return;
        }
        cVar.onSubscribe(this);
        this.f4371i.lazySet(cVar);
        f();
    }
}
