package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.b3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0847b3 extends AtomicInteger implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0842a3 f5153k;
    private static final long serialVersionUID = -3491074160481096299L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5154a;
    public final p027e3.o b;
    public final int c;
    public final boolean d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f5155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p011b3.c f5157h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f5159j;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f5158i = new AtomicReference();
    public final p100r3.c e = new p100r3.c();

    static {
        C0842a3 c0842a3 = new C0842a3(null, -1L, 1);
        f5153k = c0842a3;
        p033f3.d.a(c0842a3);
    }

    public C0847b3(io.reactivex.I i5, p027e3.o oVar, int i6, boolean z6) {
        this.f5154a = i5;
        this.b = oVar;
        this.c = i6;
        this.d = z6;
    }

    public final void a() {
        C0842a3 c0842a3;
        AtomicReference atomicReference = this.f5158i;
        C0842a3 c0842a4 = (C0842a3) atomicReference.get();
        C0842a3 c0842a5 = f5153k;
        if (c0842a4 == c0842a5 || (c0842a3 = (C0842a3) atomicReference.getAndSet(c0842a5)) == c0842a5 || c0842a3 == null) {
            return;
        }
        p033f3.d.a(c0842a3);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x0010 A[SYNTHETIC] */
    public final void b() {
        p043h3.j jVar;
        Object objPoll;
        if (getAndIncrement() != 0) {
            return;
        }
        io.reactivex.I i5 = this.f5154a;
        AtomicReference atomicReference = this.f5158i;
        boolean z6 = this.d;
        int iAddAndGet = 1;
        while (!this.f5156g) {
            if (this.f5155f) {
                boolean z7 = atomicReference.get() == null;
                if (z6) {
                    if (z7) {
                        Throwable th = (Throwable) this.e.get();
                        if (th != null) {
                            i5.onError(th);
                            return;
                        } else {
                            i5.onComplete();
                            return;
                        }
                    }
                } else if (((Throwable) this.e.get()) != null) {
                    p100r3.c cVar = this.e;
                    cVar.getClass();
                    i5.onError(p100r3.g.b(cVar));
                    return;
                } else if (z7) {
                    i5.onComplete();
                    return;
                }
            }
            C0842a3 c0842a3 = (C0842a3) atomicReference.get();
            if (c0842a3 != null && (jVar = c0842a3.d) != null) {
                if (c0842a3.e) {
                    boolean zIsEmpty = jVar.isEmpty();
                    if (z6) {
                        if (zIsEmpty) {
                            while (!atomicReference.compareAndSet(c0842a3, null) && atomicReference.get() == c0842a3) {
                            }
                        }
                    } else if (((Throwable) this.e.get()) != null) {
                        p100r3.c cVar2 = this.e;
                        cVar2.getClass();
                        i5.onError(p100r3.g.b(cVar2));
                        return;
                    } else if (zIsEmpty) {
                        while (!atomicReference.compareAndSet(c0842a3, null) && atomicReference.get() == c0842a3) {
                        }
                    }
                }
                boolean z8 = false;
                while (!this.f5156g) {
                    if (c0842a3 == atomicReference.get()) {
                        if (!z6 && ((Throwable) this.e.get()) != null) {
                            p100r3.c cVar3 = this.e;
                            cVar3.getClass();
                            i5.onError(p100r3.g.b(cVar3));
                            return;
                        }
                        boolean z9 = c0842a3.e;
                        try {
                            objPoll = jVar.poll();
                        } catch (Throwable th2) {
                            p017c3.d.throwIfFatal(th2);
                            p100r3.c cVar4 = this.e;
                            cVar4.getClass();
                            p100r3.g.a(cVar4, th2);
                            while (!atomicReference.compareAndSet(c0842a3, null) && atomicReference.get() == c0842a3) {
                            }
                            if (z6) {
                                p033f3.d.a(c0842a3);
                            } else {
                                a();
                                this.f5157h.dispose();
                                this.f5155f = true;
                            }
                            z8 = true;
                            objPoll = null;
                        }
                        boolean z10 = objPoll == null;
                        if (z9 && z10) {
                            while (!atomicReference.compareAndSet(c0842a3, null) && atomicReference.get() == c0842a3) {
                            }
                        } else if (!z10) {
                            i5.onNext(objPoll);
                        }
                        if (z8) {
                            continue;
                        }
                    }
                    z8 = true;
                    if (z8) {
                        continue;
                    }
                }
                return;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5156g) {
            return;
        }
        this.f5156g = true;
        this.f5157h.dispose();
        a();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5156g;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5155f) {
            return;
        }
        this.f5155f = true;
        b();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (!this.f5155f) {
            p100r3.c cVar = this.e;
            cVar.getClass();
            if (p100r3.g.a(cVar, th)) {
                if (!this.d) {
                    a();
                }
                this.f5155f = true;
                b();
                return;
            }
        }
        io.reactivex.plugins.a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        long j6 = this.f5159j + 1;
        this.f5159j = j6;
        C0842a3 c0842a3 = (C0842a3) this.f5158i.get();
        if (c0842a3 != null) {
            p033f3.d.a(c0842a3);
        }
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The ObservableSource returned is null");
            io.reactivex.G g6 = (io.reactivex.G) objApply;
            C0842a3 c0842a4 = new C0842a3(this, j6, this.c);
            while (true) {
                C0842a3 c0842a5 = (C0842a3) this.f5158i.get();
                if (c0842a5 == f5153k) {
                    return;
                }
                AtomicReference atomicReference = this.f5158i;
                do {
                    if (atomicReference.compareAndSet(c0842a5, c0842a4)) {
                        g6.subscribe(c0842a4);
                        return;
                    }
                } while (atomicReference.get() == c0842a5);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5157h.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5157h, cVar)) {
            this.f5157h = cVar;
            this.f5154a.onSubscribe(this);
        }
    }
}
