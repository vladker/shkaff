package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class K2 extends p094q3.a implements InterfaceC0984q, Runnable {
    private static final long serialVersionUID = -8241002408341274697L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.M f4319a;
    public final boolean b;
    public final int c;
    public final int d;
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t5.d f4320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p043h3.j f4321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f4324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4327m;

    public K2(io.reactivex.M m6, boolean z6, int i5) {
        this.f4319a = m6;
        this.b = z6;
        this.c = i5;
        this.d = i5 - (i5 >> 2);
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f4327m = true;
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4322h) {
            return;
        }
        this.f4322h = true;
        this.f4320f.cancel();
        this.f4319a.dispose();
        if (getAndIncrement() == 0) {
            this.f4321g.clear();
        }
    }

    @Override // p043h3.j
    public final void clear() {
        this.f4321g.clear();
    }

    public final boolean e(t5.c cVar, boolean z6, boolean z7) {
        if (this.f4322h) {
            clear();
            return true;
        }
        if (!z6) {
            return false;
        }
        if (this.b) {
            if (!z7) {
                return false;
            }
            this.f4322h = true;
            Throwable th = this.f4324j;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
            this.f4319a.dispose();
            return true;
        }
        Throwable th2 = this.f4324j;
        if (th2 != null) {
            this.f4322h = true;
            clear();
            cVar.onError(th2);
            this.f4319a.dispose();
            return true;
        }
        if (!z7) {
            return false;
        }
        this.f4322h = true;
        cVar.onComplete();
        this.f4319a.dispose();
        return true;
    }

    public abstract void i();

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.f4321g.isEmpty();
    }

    public abstract void j();

    public abstract void k();

    public final void l() {
        if (getAndIncrement() != 0) {
            return;
        }
        this.f4319a.schedule(this);
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4323i) {
            return;
        }
        this.f4323i = true;
        l();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4323i) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4324j = th;
        this.f4323i = true;
        l();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4323i) {
            return;
        }
        if (this.f4325k == 2) {
            l();
            return;
        }
        if (!this.f4321g.offer(obj)) {
            this.f4320f.cancel();
            this.f4324j = new p017c3.e("Queue is full?!");
            this.f4323i = true;
        }
        l();
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public abstract /* synthetic */ Object poll();

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.e, j6);
            l();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4327m) {
            j();
        } else if (this.f4325k == 1) {
            k();
        } else {
            i();
        }
    }
}
