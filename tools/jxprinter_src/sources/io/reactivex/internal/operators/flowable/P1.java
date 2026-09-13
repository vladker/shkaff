package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P1 extends AtomicInteger implements t5.d, Q1 {
    private static final long serialVersionUID = -6071216598687999801L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4397a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p027e3.o f4400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p027e3.o f4401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p027e3.c f4402j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f4406n;
    public final AtomicLong b = new AtomicLong();
    public final p011b3.b d = new p011b3.b();
    public final p083o3.d c = new p083o3.d(AbstractC0979l.f5366a);
    public final LinkedHashMap e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f4398f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f4399g = new AtomicReference();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f4403k = new AtomicInteger(2);

    public P1(t5.c cVar, p027e3.o oVar, p027e3.o oVar2, p027e3.c cVar2) {
        this.f4397a = cVar;
        this.f4400h = oVar;
        this.f4401i = oVar2;
        this.f4402j = cVar2;
    }

    @Override // io.reactivex.internal.operators.flowable.Q1
    public final void a(Throwable th) {
        if (!p100r3.g.a(this.f4399g, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4403k.decrementAndGet();
            f();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.Q1
    public final void b(Throwable th) {
        if (p100r3.g.a(this.f4399g, th)) {
            f();
        } else {
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.Q1
    public final void c(Object obj, boolean z6) {
        synchronized (this) {
            try {
                this.c.offer(z6 ? 1 : 2, obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4406n) {
            return;
        }
        this.f4406n = true;
        this.d.dispose();
        if (getAndIncrement() == 0) {
            this.c.clear();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.Q1
    public final void d(boolean z6, R1 r6) {
        synchronized (this) {
            try {
                this.c.offer(z6 ? 3 : 4, r6);
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
    }

    @Override // io.reactivex.internal.operators.flowable.Q1
    public final void e(S1 s6) {
        this.d.delete(s6);
        this.f4403k.decrementAndGet();
        f();
    }

    public final void f() {
        if (getAndIncrement() != 0) {
            return;
        }
        p083o3.d dVar = this.c;
        t5.c cVar = this.f4397a;
        int iAddAndGet = 1;
        while (!this.f4406n) {
            if (((Throwable) this.f4399g.get()) != null) {
                dVar.clear();
                this.d.dispose();
                g(cVar);
                return;
            }
            boolean z6 = this.f4403k.get() == 0;
            Integer num = (Integer) dVar.poll();
            boolean z7 = num == null;
            if (z6 && z7) {
                Iterator it = this.e.values().iterator();
                while (it.hasNext()) {
                    ((p123v3.d) it.next()).onComplete();
                }
                this.e.clear();
                this.f4398f.clear();
                this.d.dispose();
                cVar.onComplete();
                return;
            }
            if (z7) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                Object objPoll = dVar.poll();
                if (num == 1) {
                    p123v3.d dVarCreate = p123v3.d.create();
                    int i5 = this.f4404l;
                    this.f4404l = i5 + 1;
                    this.e.put(Integer.valueOf(i5), dVarCreate);
                    try {
                        Object objApply = this.f4400h.apply(objPoll);
                        p039g3.A.b(objApply, "The leftEnd returned a null Publisher");
                        t5.b bVar = (t5.b) objApply;
                        R1 r6 = new R1(this, true, i5);
                        this.d.add(r6);
                        bVar.subscribe(r6);
                        if (((Throwable) this.f4399g.get()) != null) {
                            dVar.clear();
                            this.d.dispose();
                            g(cVar);
                            return;
                        }
                        try {
                            Object objApply2 = this.f4402j.apply(objPoll, dVarCreate);
                            p039g3.A.b(objApply2, "The resultSelector returned a null value");
                            if (this.b.get() == 0) {
                                h(new p017c3.e("Could not emit value due to lack of requests"), cVar, dVar);
                                return;
                            }
                            cVar.onNext(objApply2);
                            p122v2.a.e(this.b, 1L);
                            Iterator it2 = this.f4398f.values().iterator();
                            while (it2.hasNext()) {
                                dVarCreate.onNext(it2.next());
                            }
                        } catch (Throwable th) {
                            h(th, cVar, dVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        h(th2, cVar, dVar);
                        return;
                    }
                } else if (num == 2) {
                    int i6 = this.f4405m;
                    this.f4405m = i6 + 1;
                    this.f4398f.put(Integer.valueOf(i6), objPoll);
                    try {
                        Object objApply3 = this.f4401i.apply(objPoll);
                        p039g3.A.b(objApply3, "The rightEnd returned a null Publisher");
                        t5.b bVar2 = (t5.b) objApply3;
                        R1 r7 = new R1(this, false, i6);
                        this.d.add(r7);
                        bVar2.subscribe(r7);
                        if (((Throwable) this.f4399g.get()) != null) {
                            dVar.clear();
                            this.d.dispose();
                            g(cVar);
                            return;
                        } else {
                            Iterator it3 = this.e.values().iterator();
                            while (it3.hasNext()) {
                                ((p123v3.d) it3.next()).onNext(objPoll);
                            }
                        }
                    } catch (Throwable th3) {
                        h(th3, cVar, dVar);
                        return;
                    }
                } else if (num == 3) {
                    R1 r8 = (R1) objPoll;
                    p123v3.d dVar2 = (p123v3.d) this.e.remove(Integer.valueOf(r8.c));
                    this.d.remove(r8);
                    if (dVar2 != null) {
                        dVar2.onComplete();
                    }
                } else if (num == 4) {
                    R1 r9 = (R1) objPoll;
                    this.f4398f.remove(Integer.valueOf(r9.c));
                    this.d.remove(r9);
                }
            }
        }
        dVar.clear();
    }

    public final void g(t5.c cVar) {
        Throwable thB = p100r3.g.b(this.f4399g);
        LinkedHashMap linkedHashMap = this.e;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((p123v3.d) it.next()).onError(thB);
        }
        linkedHashMap.clear();
        this.f4398f.clear();
        cVar.onError(thB);
    }

    public final void h(Throwable th, t5.c cVar, p043h3.j jVar) {
        p017c3.d.throwIfFatal(th);
        p100r3.g.a(this.f4399g, th);
        jVar.clear();
        this.d.dispose();
        g(cVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.b, j6);
        }
    }
}
