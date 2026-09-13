package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0826y extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -8466418554264089604L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4832a;
    public final Callable b;
    public final t5.b c;
    public final p027e3.o d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4836i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4838k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4839l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4841n;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p083o3.d f4837j = new p083o3.d(AbstractC0979l.f5366a);
    public final p011b3.b e = new p011b3.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f4833f = new AtomicLong();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f4834g = new AtomicReference();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinkedHashMap f4840m = new LinkedHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p100r3.c f4835h = new p100r3.c();

    public C0826y(t5.c cVar, t5.b bVar, p027e3.o oVar, Callable callable) {
        this.f4832a = cVar;
        this.b = callable;
        this.c = bVar;
        this.d = oVar;
    }

    public final void a(C0832z c0832z, long j6) {
        boolean z6;
        this.e.delete(c0832z);
        if (this.e.b() == 0) {
            p094q3.g.a(this.f4834g);
            z6 = true;
        } else {
            z6 = false;
        }
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f4840m;
                if (linkedHashMap == null) {
                    return;
                }
                this.f4837j.offer(linkedHashMap.remove(Long.valueOf(j6)));
                if (z6) {
                    this.f4836i = true;
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
        long j6 = this.f4841n;
        t5.c cVar = this.f4832a;
        p083o3.d dVar = this.f4837j;
        int iAddAndGet = 1;
        do {
            long j7 = this.f4833f.get();
            while (j6 != j7) {
                if (this.f4838k) {
                    dVar.clear();
                    return;
                }
                boolean z6 = this.f4836i;
                if (z6 && this.f4835h.get() != null) {
                    dVar.clear();
                    p100r3.c cVar2 = this.f4835h;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
                    return;
                }
                Collection collection = (Collection) dVar.poll();
                boolean z7 = collection == null;
                if (z6 && z7) {
                    cVar.onComplete();
                    return;
                } else {
                    if (z7) {
                        break;
                    }
                    cVar.onNext(collection);
                    j6++;
                }
            }
            if (j6 == j7) {
                if (this.f4838k) {
                    dVar.clear();
                    return;
                }
                if (this.f4836i) {
                    if (this.f4835h.get() != null) {
                        dVar.clear();
                        p100r3.c cVar3 = this.f4835h;
                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar3, cVar3, cVar);
                        return;
                    } else if (dVar.isEmpty()) {
                        cVar.onComplete();
                        return;
                    }
                }
            }
            this.f4841n = j6;
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // t5.d
    public final void cancel() {
        if (p094q3.g.a(this.f4834g)) {
            this.f4838k = true;
            this.e.dispose();
            synchronized (this) {
                this.f4840m = null;
            }
            if (getAndIncrement() != 0) {
                this.f4837j.clear();
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.e.dispose();
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f4840m;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    this.f4837j.offer((Collection) it.next());
                }
                this.f4840m = null;
                this.f4836i = true;
                b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.f4835h;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.e.dispose();
        synchronized (this) {
            this.f4840m = null;
        }
        this.f4836i = true;
        b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                LinkedHashMap linkedHashMap = this.f4840m;
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

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this.f4834g, dVar)) {
            C0820x c0820x = new C0820x(this);
            this.e.add(c0820x);
            this.c.subscribe(c0820x);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        p122v2.a.a(this.f4833f, j6);
        b();
    }
}
