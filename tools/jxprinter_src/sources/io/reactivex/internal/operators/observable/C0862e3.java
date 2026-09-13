package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.e3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0862e3 extends AtomicBoolean implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -5677354903406201275L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5179a;
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p083o3.d f5180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p011b3.c f5182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f5184j;

    public C0862e3(io.reactivex.I i5, long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6, int i6, boolean z6) {
        this.f5179a = i5;
        this.b = j6;
        this.c = j7;
        this.d = timeUnit;
        this.e = n6;
        this.f5180f = new p083o3.d(i6);
        this.f5181g = z6;
    }

    public final void a() {
        Throwable th;
        if (compareAndSet(false, true)) {
            io.reactivex.I i5 = this.f5179a;
            p083o3.d dVar = this.f5180f;
            boolean z6 = this.f5181g;
            while (!this.f5183i) {
                if (!z6 && (th = this.f5184j) != null) {
                    dVar.clear();
                    i5.onError(th);
                    return;
                }
                Object objPoll = dVar.poll();
                if (objPoll == null) {
                    Throwable th2 = this.f5184j;
                    if (th2 != null) {
                        i5.onError(th2);
                        return;
                    } else {
                        i5.onComplete();
                        return;
                    }
                }
                Object objPoll2 = dVar.poll();
                if (((Long) objPoll).longValue() >= this.e.now(this.d) - this.c) {
                    i5.onNext(objPoll2);
                }
            }
            dVar.clear();
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5183i) {
            return;
        }
        this.f5183i = true;
        this.f5182h.dispose();
        if (compareAndSet(false, true)) {
            this.f5180f.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5183i;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5184j = th;
        a();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        long j6;
        long j7;
        long jNow = this.e.now(this.d);
        long j8 = this.b;
        boolean z6 = j8 == LocationRequestCompat.PASSIVE_INTERVAL;
        Long lValueOf = Long.valueOf(jNow);
        p083o3.d dVar = this.f5180f;
        dVar.offer(lValueOf, obj);
        while (!dVar.isEmpty()) {
            if (((Long) dVar.peek()).longValue() > jNow - this.c) {
                if (z6) {
                    return;
                }
                AtomicLong atomicLong = dVar.f6450h;
                long j9 = atomicLong.get();
                while (true) {
                    j6 = dVar.f6447a.get();
                    j7 = atomicLong.get();
                    if (j9 == j7) {
                        break;
                    } else {
                        j9 = j7;
                    }
                }
                if ((((int) (j6 - j7)) >> 1) <= j8) {
                    return;
                }
            }
            dVar.poll();
            dVar.poll();
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5182h, cVar)) {
            this.f5182h = cVar;
            this.f5179a.onSubscribe(this);
        }
    }
}
