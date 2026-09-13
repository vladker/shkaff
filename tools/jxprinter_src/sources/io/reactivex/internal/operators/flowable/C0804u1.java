package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.u1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0804u1 extends p094q3.a implements InterfaceC0984q {
    private static final long serialVersionUID = -3096000382929934955L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4794a;
    public final p027e3.o b;
    public final int c;
    public final int d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t5.d f4795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p043h3.j f4796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4798i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Iterator f4800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4802m;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReference f4799j = new AtomicReference();
    public final AtomicLong e = new AtomicLong();

    public C0804u1(t5.c cVar, p027e3.o oVar, int i5) {
        this.f4794a = cVar;
        this.b = oVar;
        this.c = i5;
        this.d = i5 - (i5 >> 2);
    }

    @Override // p043h3.f
    public final int c(int i5) {
        return this.f4802m == 1 ? 1 : 0;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4798i) {
            return;
        }
        this.f4798i = true;
        this.f4795f.cancel();
        if (getAndIncrement() == 0) {
            this.f4796g.clear();
        }
    }

    @Override // p043h3.j
    public final void clear() {
        this.f4800k = null;
        this.f4796g.clear();
    }

    public final boolean e(boolean z6, boolean z7, t5.c cVar, p043h3.j jVar) {
        if (this.f4798i) {
            this.f4800k = null;
            jVar.clear();
            return true;
        }
        if (!z6) {
            return false;
        }
        if (((Throwable) this.f4799j.get()) == null) {
            if (!z7) {
                return false;
            }
            cVar.onComplete();
            return true;
        }
        Throwable thB = p100r3.g.b(this.f4799j);
        this.f4800k = null;
        jVar.clear();
        cVar.onError(thB);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        int i5;
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4794a;
        p043h3.j jVar = this.f4796g;
        boolean z6 = false;
        int i6 = 1;
        Object[] objArr = this.f4802m != 1;
        Iterator it = this.f4800k;
        int iAddAndGet = 1;
        while (true) {
            if (it == null) {
                boolean z7 = this.f4797h;
                try {
                    Object objPoll = jVar.poll();
                    if (e(z7, objPoll == null ? i6 : z6 ? 1 : 0, cVar, jVar)) {
                        return;
                    }
                    if (objPoll != null) {
                        try {
                            it = ((Iterable) this.b.apply(objPoll)).iterator();
                            if (it.hasNext()) {
                                this.f4800k = it;
                            } else {
                                if (objArr != false) {
                                    int i7 = this.f4801l + i6;
                                    if (i7 == this.d) {
                                        this.f4801l = z6 ? 1 : 0;
                                        this.f4795f.request(i7);
                                    } else {
                                        this.f4801l = i7;
                                    }
                                }
                                it = null;
                            }
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.f4795f.cancel();
                            p100r3.g.a(this.f4799j, th);
                            cVar.onError(p100r3.g.b(this.f4799j));
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    this.f4795f.cancel();
                    p100r3.g.a(this.f4799j, th2);
                    Throwable thB = p100r3.g.b(this.f4799j);
                    this.f4800k = null;
                    jVar.clear();
                    cVar.onError(thB);
                    return;
                }
            }
            if (it != null) {
                long j6 = this.e.get();
                long j7 = 0;
                while (true) {
                    if (j7 == j6) {
                        i5 = i6;
                        break;
                    }
                    if (e(this.f4797h, z6, cVar, jVar)) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        i5 = i6;
                        p039g3.A.b(next, "The iterator returned a null value");
                        cVar.onNext(next);
                        if (e(this.f4797h, z6, cVar, jVar)) {
                            return;
                        }
                        j7++;
                        try {
                            if (!it.hasNext()) {
                                if (objArr != false) {
                                    int i8 = this.f4801l + 1;
                                    if (i8 == this.d) {
                                        this.f4801l = z6 ? 1 : 0;
                                        this.f4795f.request(i8);
                                    } else {
                                        this.f4801l = i8;
                                    }
                                }
                                this.f4800k = null;
                                it = null;
                                break;
                            }
                            i6 = i5;
                        } catch (Throwable th3) {
                            p017c3.d.throwIfFatal(th3);
                            this.f4800k = null;
                            this.f4795f.cancel();
                            p100r3.g.a(this.f4799j, th3);
                            cVar.onError(p100r3.g.b(this.f4799j));
                            return;
                        }
                    } catch (Throwable th4) {
                        p017c3.d.throwIfFatal(th4);
                        this.f4800k = null;
                        this.f4795f.cancel();
                        p100r3.g.a(this.f4799j, th4);
                        cVar.onError(p100r3.g.b(this.f4799j));
                        return;
                    }
                }
                if (j7 == j6) {
                    if (e(this.f4797h, (jVar.isEmpty() && it == null) ? i5 : 0, cVar, jVar)) {
                        return;
                    }
                }
                if (j7 != 0 && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.e.addAndGet(-j7);
                }
                if (it != null) {
                }
                i6 = i5;
                z6 = false;
            } else {
                i5 = i6;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            i6 = i5;
            z6 = false;
        }
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.f4800k == null && this.f4796g.isEmpty();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4797h) {
            return;
        }
        this.f4797h = true;
        f();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4797h || !p100r3.g.a(this.f4799j, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4797h = true;
            f();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4797h) {
            return;
        }
        if (this.f4802m != 0 || this.f4796g.offer(obj)) {
            f();
        } else {
            onError(new p017c3.e("Queue is full?!"));
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4795f, dVar)) {
            this.f4795f = dVar;
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(3);
                if (iC == 1) {
                    this.f4802m = iC;
                    this.f4796g = gVar;
                    this.f4797h = true;
                    this.f4794a.onSubscribe(this);
                    return;
                }
                if (iC == 2) {
                    this.f4802m = iC;
                    this.f4796g = gVar;
                    this.f4794a.onSubscribe(this);
                    dVar.request(this.c);
                    return;
                }
            }
            this.f4796g = new p083o3.c(this.c);
            this.f4794a.onSubscribe(this);
            dVar.request(this.c);
        }
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Iterator it = this.f4800k;
        while (it == null) {
            Object objPoll = this.f4796g.poll();
            if (objPoll != null) {
                it = ((Iterable) this.b.apply(objPoll)).iterator();
                if (it.hasNext()) {
                    this.f4800k = it;
                    break;
                }
                it = null;
            } else {
                return null;
            }
        }
        Object next = it.next();
        p039g3.A.b(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.f4800k = null;
        }
        return next;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.e, j6);
            f();
        }
    }
}
