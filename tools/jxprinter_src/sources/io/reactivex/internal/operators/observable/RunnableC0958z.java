package io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0958z extends p048i3.s implements Runnable, p011b3.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Callable f5320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f5321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TimeUnit f5322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f5323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f5324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final io.reactivex.M f5325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Collection f5326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p011b3.c f5327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p011b3.c f5328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f5329p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f5330q;

    public RunnableC0958z(p112t3.e eVar, Callable callable, long j6, TimeUnit timeUnit, int i5, boolean z6, io.reactivex.M m6) {
        super(eVar, new p083o3.b());
        this.f5320g = callable;
        this.f5321h = j6;
        this.f5322i = timeUnit;
        this.f5323j = i5;
        this.f5324k = z6;
        this.f5325l = m6;
    }

    @Override // p048i3.s
    public final void b(io.reactivex.I i5, Object obj) {
        i5.onNext((Collection) obj);
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f5328o.dispose();
        this.f5325l.dispose();
        synchronized (this) {
            this.f5326m = null;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        Collection collection;
        this.f5325l.dispose();
        synchronized (this) {
            collection = this.f5326m;
            this.f5326m = null;
        }
        this.c.offer(collection);
        this.e = true;
        if (c()) {
            com.bumptech.glide.f.c(this.c, this.b, this, this);
        }
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onError(Throwable th) {
        synchronized (this) {
            this.f5326m = null;
        }
        this.b.onError(th);
        this.f5325l.dispose();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0060 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:45:0x0076
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // p048i3.s, io.reactivex.I
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onNext(java.lang.Object r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Collection r0 = r7.f5326m     // Catch: java.lang.Throwable -> L71
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
            int r1 = r7.f5323j     // Catch: java.lang.Throwable -> L71
            if (r8 >= r1) goto L19
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L7
            return
        L19:
            r8 = 0
            r7.f5326m = r8     // Catch: java.lang.Throwable -> L71
            long r1 = r7.f5329p     // Catch: java.lang.Throwable -> L71
            r3 = 1
            long r1 = r1 + r3
            r7.f5329p = r1     // Catch: java.lang.Throwable -> L71
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L71
            boolean r8 = r7.f5324k
            if (r8 == 0) goto L2d
            b3.c r8 = r7.f5327n
            r8.dispose()
        L2d:
            r7.g(r0, r7)
            java.util.concurrent.Callable r8 = r7.f5320g     // Catch: java.lang.Throwable -> L62
            java.lang.Object r8 = r8.call()     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = "The buffer supplied is null"
            p039g3.A.b(r8, r0)     // Catch: java.lang.Throwable -> L62
            java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L62
            monitor-enter(r7)
            r7.f5326m = r8     // Catch: java.lang.Throwable -> L5b
            long r0 = r7.f5330q     // Catch: java.lang.Throwable -> L5b
            long r0 = r0 + r3
            r7.f5330q = r0     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L5b
            boolean r8 = r7.f5324k
            if (r8 == 0) goto L59
            io.reactivex.M r0 = r7.f5325l
            long r2 = r7.f5321h
            java.util.concurrent.TimeUnit r6 = r7.f5322i
            r4 = r2
            r1 = r7
            b3.c r8 = r0.schedulePeriodically(r1, r2, r4, r6)
            r1.f5327n = r8
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
            t3.e r0 = r1.b
            r0.onError(r8)
            r7.dispose()
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.RunnableC0958z.onNext(java.lang.Object):void");
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p112t3.e eVar = this.b;
        if (p033f3.d.g(this.f5328o, cVar)) {
            this.f5328o = cVar;
            try {
                Object objCall = this.f5320g.call();
                p039g3.A.b(objCall, "The buffer supplied is null");
                this.f5326m = (Collection) objCall;
                eVar.onSubscribe(this);
                long j6 = this.f5321h;
                this.f5327n = this.f5325l.schedulePeriodically(this, j6, j6, this.f5322i);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cVar.dispose();
                p033f3.e.a(th, eVar);
                this.f5325l.dispose();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object objCall = this.f5320g.call();
            p039g3.A.b(objCall, "The bufferSupplier returned a null buffer");
            Collection collection = (Collection) objCall;
            synchronized (this) {
                Collection collection2 = this.f5326m;
                if (collection2 != null && this.f5329p == this.f5330q) {
                    this.f5326m = collection;
                    g(collection2, this);
                }
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            dispose();
            this.b.onError(th);
        }
    }
}
