package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H extends p088p3.k implements t5.d, Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f4265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TimeUnit f4268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final io.reactivex.M f4269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList f4270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t5.d f4271n;

    public H(p135x3.c cVar, Callable callable, long j6, long j7, TimeUnit timeUnit, io.reactivex.M m6) {
        super(cVar, new p083o3.b());
        this.f4265h = callable;
        this.f4266i = j6;
        this.f4267j = j7;
        this.f4268k = timeUnit;
        this.f4269l = m6;
        this.f4270m = new LinkedList();
    }

    @Override // t5.d
    public final void cancel() {
        this.e = true;
        this.f4271n.cancel();
        this.f4269l.dispose();
        synchronized (this) {
            this.f4270m.clear();
        }
    }

    @Override // p088p3.k
    public final boolean o(Object obj, t5.c cVar) {
        cVar.onNext((Collection) obj);
        return true;
    }

    @Override // t5.c
    public final void onComplete() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f4270m);
            this.f4270m.clear();
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            this.d.offer((Collection) obj);
        }
        this.f7748f = true;
        if (p()) {
            com.bumptech.glide.f.d(this.d, this.c, this.f4269l, this);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7748f = true;
        this.f4269l.dispose();
        synchronized (this) {
            this.f4270m.clear();
        }
        this.c.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Iterator it = this.f4270m.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        io.reactivex.M m6 = this.f4269l;
        p135x3.c cVar = this.c;
        if (p094q3.g.g(this.f4271n, dVar)) {
            this.f4271n = dVar;
            try {
                Object objCall = this.f4265h.call();
                p039g3.A.b(objCall, "The supplied buffer is null");
                Collection collection = (Collection) objCall;
                this.f4270m.add(collection);
                cVar.onSubscribe(this);
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                long j6 = this.f4267j;
                this.f4269l.schedulePeriodically(this, j6, j6, this.f4268k);
                m6.schedule(new Q0.b(this, 11, collection, false), this.f4266i, this.f4268k);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                m6.dispose();
                dVar.cancel();
                p094q3.d.e(th, cVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.e) {
            return;
        }
        try {
            Object objCall = this.f4265h.call();
            p039g3.A.b(objCall, "The supplied buffer is null");
            Collection collection = (Collection) objCall;
            synchronized (this) {
                try {
                    if (this.e) {
                        return;
                    }
                    this.f4270m.add(collection);
                    this.f4269l.schedule(new Q0.b(this, 11, collection, false), this.f4266i, this.f4268k);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            cancel();
            this.c.onError(th2);
        }
    }
}
