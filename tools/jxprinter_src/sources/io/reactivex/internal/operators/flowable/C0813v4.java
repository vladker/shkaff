package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.v4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0813v4 extends ArrayDeque implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 7240042530241604978L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4811a;
    public final int b;
    public t5.d c;
    public volatile boolean d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f4812f = new AtomicLong();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f4813g = new AtomicInteger();

    public C0813v4(t5.c cVar, int i5) {
        this.f4811a = cVar;
        this.b = i5;
    }

    public final void a() {
        if (this.f4813g.getAndIncrement() == 0) {
            t5.c cVar = this.f4811a;
            long jAddAndGet = this.f4812f.get();
            while (!this.e) {
                if (this.d) {
                    long j6 = 0;
                    while (j6 != jAddAndGet) {
                        if (this.e) {
                            return;
                        }
                        Object objPoll = poll();
                        if (objPoll == null) {
                            cVar.onComplete();
                            return;
                        } else {
                            cVar.onNext(objPoll);
                            j6++;
                        }
                    }
                    if (j6 != 0 && jAddAndGet != LocationRequestCompat.PASSIVE_INTERVAL) {
                        jAddAndGet = this.f4812f.addAndGet(-j6);
                    }
                }
                if (this.f4813g.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        this.e = true;
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        this.d = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4811a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.b == size()) {
            poll();
        }
        offer(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f4811a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4812f, j6);
            a();
        }
    }
}
