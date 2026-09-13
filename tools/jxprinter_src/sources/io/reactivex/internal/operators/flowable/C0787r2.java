package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.r2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0787r2 extends AtomicInteger implements t5.d, Q1 {
    private static final long serialVersionUID = -6071216598687999801L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4748a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p027e3.o f4751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p027e3.o f4752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p027e3.c f4753j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f4757n;
    public final AtomicLong b = new AtomicLong();
    public final p011b3.b d = new p011b3.b();
    public final p083o3.d c = new p083o3.d(AbstractC0979l.f5366a);
    public final LinkedHashMap e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f4749f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f4750g = new AtomicReference();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f4754k = new AtomicInteger(2);

    public C0787r2(t5.c cVar, p027e3.o oVar, p027e3.o oVar2, p027e3.c cVar2) {
        this.f4748a = cVar;
        this.f4751h = oVar;
        this.f4752i = oVar2;
        this.f4753j = cVar2;
    }

    @Override // io.reactivex.internal.operators.flowable.Q1
    public final void a(Throwable th) {
        if (!p100r3.g.a(this.f4750g, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4754k.decrementAndGet();
            g();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.Q1
    public final void b(Throwable th) {
        if (p100r3.g.a(this.f4750g, th)) {
            g();
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
        g();
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4757n) {
            return;
        }
        this.f4757n = true;
        f();
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
        g();
    }

    @Override // io.reactivex.internal.operators.flowable.Q1
    public final void e(S1 s6) {
        this.d.delete(s6);
        this.f4754k.decrementAndGet();
        g();
    }

    public final void f() {
        this.d.dispose();
    }

    public final void g() {
        if (getAndIncrement() != 0) {
            return;
        }
        p083o3.d dVar = this.c;
        t5.c cVar = this.f4748a;
        boolean z6 = true;
        int iAddAndGet = 1;
        while (!this.f4757n) {
            if (((Throwable) this.f4750g.get()) != null) {
                dVar.clear();
                f();
                h(cVar);
                return;
            }
            Object[] objArr = this.f4754k.get() == 0 ? z6 ? 1 : 0 : null;
            Integer num = (Integer) dVar.poll();
            Object[] objArr2 = num == null ? z6 ? 1 : 0 : null;
            if (objArr != null && objArr2 != null) {
                this.e.clear();
                this.f4749f.clear();
                this.d.dispose();
                cVar.onComplete();
                return;
            }
            if (objArr2 != null) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                Object objPoll = dVar.poll();
                if (num == Integer.valueOf(z6 ? 1 : 0)) {
                    int i5 = this.f4755l;
                    this.f4755l = i5 + 1;
                    this.e.put(Integer.valueOf(i5), objPoll);
                    try {
                        Object objApply = this.f4751h.apply(objPoll);
                        p039g3.A.b(objApply, "The leftEnd returned a null Publisher");
                        t5.b bVar = (t5.b) objApply;
                        R1 r6 = new R1(this, z6, i5);
                        this.d.add(r6);
                        bVar.subscribe(r6);
                        if (((Throwable) this.f4750g.get()) != null) {
                            dVar.clear();
                            f();
                            h(cVar);
                            return;
                        }
                        long j6 = this.b.get();
                        Iterator it = this.f4749f.values().iterator();
                        long j7 = 0;
                        while (it.hasNext()) {
                            try {
                                Object objApply2 = this.f4753j.apply(objPoll, it.next());
                                p039g3.A.b(objApply2, "The resultSelector returned a null value");
                                if (j7 == j6) {
                                    p100r3.g.a(this.f4750g, new p017c3.e("Could not emit value due to lack of requests"));
                                    dVar.clear();
                                    f();
                                    h(cVar);
                                    return;
                                }
                                cVar.onNext(objApply2);
                                j7++;
                            } catch (Throwable th) {
                                i(th, cVar, dVar);
                                return;
                            }
                        }
                        if (j7 != 0) {
                            p122v2.a.e(this.b, j7);
                        }
                    } catch (Throwable th2) {
                        i(th2, cVar, dVar);
                        return;
                    }
                } else if (num == 2) {
                    int i6 = this.f4756m;
                    this.f4756m = i6 + 1;
                    this.f4749f.put(Integer.valueOf(i6), objPoll);
                    try {
                        Object objApply3 = this.f4752i.apply(objPoll);
                        p039g3.A.b(objApply3, "The rightEnd returned a null Publisher");
                        t5.b bVar2 = (t5.b) objApply3;
                        R1 r7 = new R1(this, false, i6);
                        this.d.add(r7);
                        bVar2.subscribe(r7);
                        if (((Throwable) this.f4750g.get()) != null) {
                            dVar.clear();
                            f();
                            h(cVar);
                            return;
                        }
                        long j8 = this.b.get();
                        Iterator it2 = this.e.values().iterator();
                        long j9 = 0;
                        while (it2.hasNext()) {
                            try {
                                Object objApply4 = this.f4753j.apply(it2.next(), objPoll);
                                p039g3.A.b(objApply4, "The resultSelector returned a null value");
                                if (j9 == j8) {
                                    p100r3.g.a(this.f4750g, new p017c3.e("Could not emit value due to lack of requests"));
                                    dVar.clear();
                                    f();
                                    h(cVar);
                                    return;
                                }
                                cVar.onNext(objApply4);
                                j9++;
                            } catch (Throwable th3) {
                                i(th3, cVar, dVar);
                                return;
                            }
                        }
                        if (j9 != 0) {
                            p122v2.a.e(this.b, j9);
                        }
                    } catch (Throwable th4) {
                        i(th4, cVar, dVar);
                        return;
                    }
                } else if (num == 3) {
                    R1 r8 = (R1) objPoll;
                    this.e.remove(Integer.valueOf(r8.c));
                    this.d.remove(r8);
                } else if (num == 4) {
                    R1 r9 = (R1) objPoll;
                    this.f4749f.remove(Integer.valueOf(r9.c));
                    this.d.remove(r9);
                }
                z6 = true;
            }
        }
        dVar.clear();
    }

    public final void h(t5.c cVar) {
        Throwable thB = p100r3.g.b(this.f4750g);
        this.e.clear();
        this.f4749f.clear();
        cVar.onError(thB);
    }

    public final void i(Throwable th, t5.c cVar, p043h3.j jVar) {
        p017c3.d.throwIfFatal(th);
        p100r3.g.a(this.f4750g, th);
        jVar.clear();
        f();
        h(cVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.b, j6);
        }
    }
}
