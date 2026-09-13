package io.reactivex.internal.operators.observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends p048i3.s implements Runnable, p011b3.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Callable f4877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TimeUnit f4880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final io.reactivex.M f4881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedList f4882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p011b3.c f4883m;

    public C(p112t3.e eVar, Callable callable, long j6, long j7, TimeUnit timeUnit, io.reactivex.M m6) {
        super(eVar, new p083o3.b());
        this.f4877g = callable;
        this.f4878h = j6;
        this.f4879i = j7;
        this.f4880j = timeUnit;
        this.f4881k = m6;
        this.f4882l = new LinkedList();
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
        synchronized (this) {
            this.f4882l.clear();
        }
        this.f4883m.dispose();
        this.f4881k.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f4882l);
            this.f4882l.clear();
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            this.c.offer((Collection) obj);
        }
        this.e = true;
        if (c()) {
            com.bumptech.glide.f.c(this.c, this.b, this.f4881k, this);
        }
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onError(Throwable th) {
        this.e = true;
        synchronized (this) {
            this.f4882l.clear();
        }
        this.b.onError(th);
        this.f4881k.dispose();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Iterator it = this.f4882l.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        io.reactivex.M m6 = this.f4881k;
        p112t3.e eVar = this.b;
        if (p033f3.d.g(this.f4883m, cVar)) {
            this.f4883m = cVar;
            try {
                Object objCall = this.f4877g.call();
                p039g3.A.b(objCall, "The buffer supplied is null");
                Collection collection = (Collection) objCall;
                this.f4882l.add(collection);
                eVar.onSubscribe(this);
                long j6 = this.f4879i;
                this.f4881k.schedulePeriodically(this, j6, j6, this.f4880j);
                m6.schedule(new B(this, collection, 1), this.f4878h, this.f4880j);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cVar.dispose();
                p033f3.e.a(th, eVar);
                m6.dispose();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d) {
            return;
        }
        try {
            Object objCall = this.f4877g.call();
            p039g3.A.b(objCall, "The bufferSupplier returned a null buffer");
            Collection collection = (Collection) objCall;
            synchronized (this) {
                try {
                    if (this.d) {
                        return;
                    }
                    this.f4882l.add(collection);
                    this.f4881k.schedule(new B(this, collection, 0), this.f4878h, this.f4880j);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            this.b.onError(th2);
            dispose();
        }
    }
}
