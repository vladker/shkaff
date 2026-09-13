package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N2 extends p094q3.a implements InterfaceC0984q {
    private static final long serialVersionUID = -2514538129242366402L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4375a;
    public final p043h3.i b;
    public final boolean c;
    public final p027e3.a d;
    public t5.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Throwable f4378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f4379i = new AtomicLong();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4380j;

    public N2(t5.c cVar, int i5, boolean z6, boolean z7, p027e3.a aVar) {
        this.f4375a = cVar;
        this.d = aVar;
        this.c = z7;
        this.b = z6 ? new p083o3.d(i5) : new p083o3.c(i5);
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f4380j = true;
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4376f) {
            return;
        }
        this.f4376f = true;
        this.e.cancel();
        if (getAndIncrement() == 0) {
            this.b.clear();
        }
    }

    @Override // p043h3.j
    public final void clear() {
        this.b.clear();
    }

    public final boolean e(t5.c cVar, boolean z6, boolean z7) {
        if (this.f4376f) {
            this.b.clear();
            return true;
        }
        if (!z6) {
            return false;
        }
        if (this.c) {
            if (!z7) {
                return false;
            }
            Throwable th = this.f4378h;
            if (th != null) {
                cVar.onError(th);
                return true;
            }
            cVar.onComplete();
            return true;
        }
        Throwable th2 = this.f4378h;
        if (th2 != null) {
            this.b.clear();
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
        if (getAndIncrement() == 0) {
            p043h3.i iVar = this.b;
            t5.c cVar = this.f4375a;
            int iAddAndGet = 1;
            while (!e(cVar, this.f4377g, iVar.isEmpty())) {
                long j6 = this.f4379i.get();
                long j7 = 0;
                while (j7 != j6) {
                    boolean z6 = this.f4377g;
                    Object objPoll = iVar.poll();
                    boolean z7 = objPoll == null;
                    if (e(cVar, z6, z7)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    cVar.onNext(objPoll);
                    j7++;
                }
                if (j7 == j6 && e(cVar, this.f4377g, iVar.isEmpty())) {
                    return;
                }
                if (j7 != 0 && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.f4379i.addAndGet(-j7);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4377g = true;
        if (this.f4380j) {
            this.f4375a.onComplete();
        } else {
            f();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4378h = th;
        this.f4377g = true;
        if (this.f4380j) {
            this.f4375a.onError(th);
        } else {
            f();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.b.offer(obj)) {
            if (this.f4380j) {
                this.f4375a.onNext(null);
                return;
            } else {
                f();
                return;
            }
        }
        this.e.cancel();
        p017c3.e eVar = new p017c3.e("Buffer is full");
        try {
            this.d.run();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            eVar.initCause(th);
        }
        onError(eVar);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.e, dVar)) {
            this.e = dVar;
            this.f4375a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        return this.b.poll();
    }

    @Override // t5.d
    public final void request(long j6) {
        if (this.f4380j || !p094q3.g.f(j6)) {
            return;
        }
        p122v2.a.a(this.f4379i, j6);
        f();
    }
}
