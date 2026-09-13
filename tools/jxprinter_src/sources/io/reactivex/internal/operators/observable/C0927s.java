package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0979l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0927s extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -8466418554264089604L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5269a;
    public final Callable b;
    public final io.reactivex.G c;
    public final p027e3.o d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5272h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f5275k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p083o3.d f5273i = new p083o3.d(AbstractC0979l.f5366a);
    public final p011b3.b e = new p011b3.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f5270f = new AtomicReference();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinkedHashMap f5276l = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p100r3.c f5271g = new p100r3.c();

    public C0927s(io.reactivex.I i5, io.reactivex.G g6, p027e3.o oVar, Callable callable) {
        this.f5269a = i5;
        this.b = callable;
        this.c = g6;
        this.d = oVar;
    }

    public final void a(C0932t c0932t, long j6) {
        boolean z6;
        this.e.delete(c0932t);
        if (this.e.b() == 0) {
            p033f3.d.a(this.f5270f);
            z6 = true;
        } else {
            z6 = false;
        }
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f5276l;
                if (linkedHashMap == null) {
                    return;
                }
                this.f5273i.offer(linkedHashMap.remove(Long.valueOf(j6)));
                if (z6) {
                    this.f5272h = true;
                }
                b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.I i5 = this.f5269a;
        p083o3.d dVar = this.f5273i;
        int iAddAndGet = 1;
        while (!this.f5274j) {
            boolean z6 = this.f5272h;
            if (z6 && this.f5271g.get() != null) {
                dVar.clear();
                p100r3.c cVar = this.f5271g;
                cVar.getClass();
                i5.onError(p100r3.g.b(cVar));
                return;
            }
            Collection collection = (Collection) dVar.poll();
            boolean z7 = collection == null;
            if (z6 && z7) {
                i5.onComplete();
                return;
            } else if (z7) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                i5.onNext(collection);
            }
        }
        dVar.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (p033f3.d.a(this.f5270f)) {
            this.f5274j = true;
            this.e.dispose();
            synchronized (this) {
                this.f5276l = null;
            }
            if (getAndIncrement() != 0) {
                this.f5273i.clear();
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) this.f5270f.get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.e.dispose();
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f5276l;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    this.f5273i.offer((Collection) it.next());
                }
                this.f5276l = null;
                this.f5272h = true;
                b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.f5271g;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.e.dispose();
        synchronized (this) {
            this.f5276l = null;
        }
        this.f5272h = true;
        b();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f5276l;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.f(this.f5270f, cVar)) {
            r rVar = new r(this);
            this.e.add(rVar);
            this.c.subscribe(rVar);
        }
    }
}
