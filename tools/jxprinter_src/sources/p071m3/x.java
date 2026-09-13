package p071m3;

import io.reactivex.InterfaceC0984q;
import io.reactivex.M;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p017c3.e;
import p083o3.c;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends AtomicInteger implements InterfaceC0984q, d, Runnable {
    private static final long serialVersionUID = 9222303586456402150L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6163a;
    public final int b;
    public final c c;
    public final M d;
    public d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f6164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f6165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f6166h = new AtomicLong();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f6167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6168j;

    public x(int i5, c cVar, M m6) {
        this.f6163a = i5;
        this.c = cVar;
        this.b = i5 - (i5 >> 2);
        this.d = m6;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f6167i) {
            return;
        }
        this.f6167i = true;
        this.e.cancel();
        this.d.dispose();
        if (getAndIncrement() == 0) {
            this.c.clear();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f6164f) {
            return;
        }
        this.f6164f = true;
        if (getAndIncrement() == 0) {
            this.d.schedule(this);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f6164f) {
            a.onError(th);
            return;
        }
        this.f6165g = th;
        this.f6164f = true;
        if (getAndIncrement() == 0) {
            this.d.schedule(this);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f6164f) {
            return;
        }
        if (!this.c.offer(obj)) {
            this.e.cancel();
            onError(new e("Queue is full?!"));
        } else if (getAndIncrement() == 0) {
            this.d.schedule(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (g.f(j6)) {
            p122v2.a.a(this.f6166h, j6);
            if (getAndIncrement() == 0) {
                this.d.schedule(this);
            }
        }
    }
}
