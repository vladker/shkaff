package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0979l;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1 extends AtomicInteger implements p011b3.c, InterfaceC0860e1 {
    private static final long serialVersionUID = -6071216598687999801L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4885a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p027e3.o f4887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p027e3.o f4888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p027e3.c f4889i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f4893m;
    public final p011b3.b c = new p011b3.b();
    public final p083o3.d b = new p083o3.d(AbstractC0979l.f5366a);
    public final LinkedHashMap d = new LinkedHashMap();
    public final LinkedHashMap e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f4886f = new AtomicReference();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f4890j = new AtomicInteger(2);

    public C1(io.reactivex.I i5, p027e3.o oVar, p027e3.o oVar2, p027e3.c cVar) {
        this.f4885a = i5;
        this.f4887g = oVar;
        this.f4888h = oVar2;
        this.f4889i = cVar;
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0860e1
    public final void a(Throwable th) {
        if (!p100r3.g.a(this.f4886f, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4890j.decrementAndGet();
            g();
        }
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0860e1
    public final void b(Throwable th) {
        if (p100r3.g.a(this.f4886f, th)) {
            g();
        } else {
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0860e1
    public final void c(Object obj, boolean z6) {
        synchronized (this) {
            try {
                this.b.offer(z6 ? 1 : 2, obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0860e1
    public final void d(boolean z6, C0865f1 c0865f1) {
        synchronized (this) {
            try {
                this.b.offer(z6 ? 3 : 4, c0865f1);
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f4893m) {
            return;
        }
        this.f4893m = true;
        this.c.dispose();
        if (getAndIncrement() == 0) {
            this.b.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4893m;
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0860e1
    public final void f(C0870g1 c0870g1) {
        this.c.delete(c0870g1);
        this.f4890j.decrementAndGet();
        g();
    }

    public final void g() {
        if (getAndIncrement() != 0) {
            return;
        }
        p083o3.d dVar = this.b;
        io.reactivex.I i5 = this.f4885a;
        int iAddAndGet = 1;
        while (!this.f4893m) {
            if (((Throwable) this.f4886f.get()) != null) {
                dVar.clear();
                this.c.dispose();
                h(i5);
                return;
            }
            boolean z6 = this.f4890j.get() == 0;
            Integer num = (Integer) dVar.poll();
            boolean z7 = num == null;
            if (z6 && z7) {
                this.d.clear();
                this.e.clear();
                this.c.dispose();
                i5.onComplete();
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
                    int i6 = this.f4891k;
                    this.f4891k = i6 + 1;
                    this.d.put(Integer.valueOf(i6), objPoll);
                    try {
                        Object objApply = this.f4887g.apply(objPoll);
                        p039g3.A.b(objApply, "The leftEnd returned a null ObservableSource");
                        io.reactivex.G g6 = (io.reactivex.G) objApply;
                        C0865f1 c0865f1 = new C0865f1(this, true, i6);
                        this.c.add(c0865f1);
                        g6.subscribe(c0865f1);
                        if (((Throwable) this.f4886f.get()) != null) {
                            dVar.clear();
                            this.c.dispose();
                            h(i5);
                            return;
                        }
                        Iterator it = this.e.values().iterator();
                        while (it.hasNext()) {
                            try {
                                Object objApply2 = this.f4889i.apply(objPoll, it.next());
                                p039g3.A.b(objApply2, "The resultSelector returned a null value");
                                i5.onNext(objApply2);
                            } catch (Throwable th) {
                                i(th, i5, dVar);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        i(th2, i5, dVar);
                        return;
                    }
                } else if (num == 2) {
                    int i7 = this.f4892l;
                    this.f4892l = i7 + 1;
                    this.e.put(Integer.valueOf(i7), objPoll);
                    try {
                        Object objApply3 = this.f4888h.apply(objPoll);
                        p039g3.A.b(objApply3, "The rightEnd returned a null ObservableSource");
                        io.reactivex.G g7 = (io.reactivex.G) objApply3;
                        C0865f1 c0865f2 = new C0865f1(this, false, i7);
                        this.c.add(c0865f2);
                        g7.subscribe(c0865f2);
                        if (((Throwable) this.f4886f.get()) != null) {
                            dVar.clear();
                            this.c.dispose();
                            h(i5);
                            return;
                        }
                        Iterator it2 = this.d.values().iterator();
                        while (it2.hasNext()) {
                            try {
                                Object objApply4 = this.f4889i.apply(it2.next(), objPoll);
                                p039g3.A.b(objApply4, "The resultSelector returned a null value");
                                i5.onNext(objApply4);
                            } catch (Throwable th3) {
                                i(th3, i5, dVar);
                                return;
                            }
                        }
                    } catch (Throwable th4) {
                        i(th4, i5, dVar);
                        return;
                    }
                } else if (num == 3) {
                    C0865f1 c0865f3 = (C0865f1) objPoll;
                    this.d.remove(Integer.valueOf(c0865f3.c));
                    this.c.remove(c0865f3);
                } else {
                    C0865f1 c0865f4 = (C0865f1) objPoll;
                    this.e.remove(Integer.valueOf(c0865f4.c));
                    this.c.remove(c0865f4);
                }
            }
        }
        dVar.clear();
    }

    public final void h(io.reactivex.I i5) {
        Throwable thB = p100r3.g.b(this.f4886f);
        this.d.clear();
        this.e.clear();
        i5.onError(thB);
    }

    public final void i(Throwable th, io.reactivex.I i5, p083o3.d dVar) {
        p017c3.d.throwIfFatal(th);
        p100r3.g.a(this.f4886f, th);
        dVar.clear();
        this.c.dispose();
        h(i5);
    }
}
