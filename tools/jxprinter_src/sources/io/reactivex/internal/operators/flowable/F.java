package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F extends p088p3.k implements t5.d, Runnable, p011b3.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f4218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TimeUnit f4220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4221k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4222l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final io.reactivex.M f4223m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Collection f4224n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p011b3.c f4225o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t5.d f4226p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4227q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f4228r;

    public F(p135x3.c cVar, Callable callable, long j6, TimeUnit timeUnit, int i5, boolean z6, io.reactivex.M m6) {
        super(cVar, new p083o3.b());
        this.f4218h = callable;
        this.f4219i = j6;
        this.f4220j = timeUnit;
        this.f4221k = i5;
        this.f4222l = z6;
        this.f4223m = m6;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.e) {
            return;
        }
        this.e = true;
        dispose();
    }

    @Override // p011b3.c
    public final void dispose() {
        synchronized (this) {
            this.f4224n = null;
        }
        this.f4226p.cancel();
        this.f4223m.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4223m.e();
    }

    @Override // p088p3.k
    public final boolean o(Object obj, t5.c cVar) {
        cVar.onNext((Collection) obj);
        return true;
    }

    @Override // t5.c
    public final void onComplete() {
        Collection collection;
        synchronized (this) {
            collection = this.f4224n;
            this.f4224n = null;
        }
        this.d.offer(collection);
        this.f7748f = true;
        if (p()) {
            com.bumptech.glide.f.d(this.d, this.c, this, this);
        }
        this.f4223m.dispose();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        synchronized (this) {
            this.f4224n = null;
        }
        this.c.onError(th);
        this.f4223m.dispose();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0060 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:45:0x0076
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // t5.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onNext(java.lang.Object r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Collection r0 = r7.f4224n     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto Lc
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L7
            return
        L7:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L74
        Lc:
            r0.add(r8)     // Catch: java.lang.Throwable -> L71
            int r8 = r0.size()     // Catch: java.lang.Throwable -> L71
            int r1 = r7.f4221k     // Catch: java.lang.Throwable -> L71
            if (r8 >= r1) goto L19
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L7
            return
        L19:
            r8 = 0
            r7.f4224n = r8     // Catch: java.lang.Throwable -> L71
            long r1 = r7.f4227q     // Catch: java.lang.Throwable -> L71
            r3 = 1
            long r1 = r1 + r3
            r7.f4227q = r1     // Catch: java.lang.Throwable -> L71
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L71
            boolean r8 = r7.f4222l
            if (r8 == 0) goto L2d
            b3.c r8 = r7.f4225o
            r8.dispose()
        L2d:
            r7.s(r0, r7)
            java.util.concurrent.Callable r8 = r7.f4218h     // Catch: java.lang.Throwable -> L62
            java.lang.Object r8 = r8.call()     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = "The supplied buffer is null"
            p039g3.A.b(r8, r0)     // Catch: java.lang.Throwable -> L62
            java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L62
            monitor-enter(r7)
            r7.f4224n = r8     // Catch: java.lang.Throwable -> L5b
            long r0 = r7.f4228r     // Catch: java.lang.Throwable -> L5b
            long r0 = r0 + r3
            r7.f4228r = r0     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L5b
            boolean r8 = r7.f4222l
            if (r8 == 0) goto L59
            io.reactivex.M r0 = r7.f4223m
            long r2 = r7.f4219i
            java.util.concurrent.TimeUnit r6 = r7.f4220j
            r4 = r2
            r1 = r7
            b3.c r8 = r0.schedulePeriodically(r1, r2, r4, r6)
            r1.f4225o = r8
            return
        L59:
            r1 = r7
            return
        L5b:
            r0 = move-exception
            r1 = r7
        L5d:
            r8 = r0
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L60
            throw r8
        L60:
            r0 = move-exception
            goto L5d
        L62:
            r0 = move-exception
            r1 = r7
            r8 = r0
            p017c3.d.throwIfFatal(r8)
            r7.cancel()
            x3.c r0 = r1.c
            r0.onError(r8)
            return
        L71:
            r0 = move-exception
            r1 = r7
        L73:
            r8 = r0
        L74:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            throw r8
        L76:
            r0 = move-exception
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.F.onNext(java.lang.Object):void");
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p135x3.c cVar = this.c;
        if (p094q3.g.g(this.f4226p, dVar)) {
            this.f4226p = dVar;
            try {
                Object objCall = this.f4218h.call();
                p039g3.A.b(objCall, "The supplied buffer is null");
                this.f4224n = (Collection) objCall;
                cVar.onSubscribe(this);
                long j6 = this.f4219i;
                this.f4225o = this.f4223m.schedulePeriodically(this, j6, j6, this.f4220j);
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                this.f4223m.dispose();
                dVar.cancel();
                p094q3.d.e(th, cVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object objCall = this.f4218h.call();
            p039g3.A.b(objCall, "The supplied buffer is null");
            Collection collection = (Collection) objCall;
            synchronized (this) {
                Collection collection2 = this.f4224n;
                if (collection2 != null && this.f4227q == this.f4228r) {
                    this.f4224n = collection;
                    s(collection2, this);
                }
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            cancel();
            this.c.onError(th);
        }
    }
}
