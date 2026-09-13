package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.t4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0801t4 extends AtomicInteger implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0795s4 f4779l;
    private static final long serialVersionUID = -3491074160481096299L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4780a;
    public final p027e3.o b;
    public final int c;
    public final boolean d;
    public volatile boolean e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t5.d f4783h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f4786k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f4784i = new AtomicReference();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f4785j = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p100r3.c f4781f = new p100r3.c();

    static {
        C0795s4 c0795s4 = new C0795s4(null, -1L, 1);
        f4779l = c0795s4;
        p094q3.g.a(c0795s4);
    }

    public C0801t4(int i5, p027e3.o oVar, t5.c cVar, boolean z6) {
        this.f4780a = cVar;
        this.b = oVar;
        this.c = i5;
        this.d = z6;
    }

    public final void a() {
        C0795s4 c0795s4;
        AtomicReference atomicReference = this.f4784i;
        C0795s4 c0795s5 = (C0795s4) atomicReference.get();
        C0795s4 c0795s6 = f4779l;
        if (c0795s5 == c0795s6 || (c0795s4 = (C0795s4) atomicReference.getAndSet(c0795s6)) == c0795s6 || c0795s4 == null) {
            return;
        }
        p094q3.g.a(c0795s4);
    }

    public final void b() {
        boolean z6;
        Object objPoll;
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4780a;
        int iAddAndGet = 1;
        while (!this.f4782g) {
            if (this.e) {
                if (this.d) {
                    if (this.f4784i.get() == null) {
                        if (((Throwable) this.f4781f.get()) == null) {
                            cVar.onComplete();
                            return;
                        } else {
                            p100r3.c cVar2 = this.f4781f;
                            com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
                            return;
                        }
                    }
                } else if (((Throwable) this.f4781f.get()) != null) {
                    a();
                    p100r3.c cVar3 = this.f4781f;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar3, cVar3, cVar);
                    return;
                } else if (this.f4784i.get() == null) {
                    cVar.onComplete();
                    return;
                }
            }
            C0795s4 c0795s4 = (C0795s4) this.f4784i.get();
            p043h3.j jVar = c0795s4 != null ? c0795s4.d : null;
            if (jVar != null) {
                if (c0795s4.e) {
                    if (this.d) {
                        if (jVar.isEmpty()) {
                            AtomicReference atomicReference = this.f4784i;
                            while (!atomicReference.compareAndSet(c0795s4, null) && atomicReference.get() == c0795s4) {
                            }
                        }
                    } else if (((Throwable) this.f4781f.get()) != null) {
                        a();
                        p100r3.c cVar4 = this.f4781f;
                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar4, cVar4, cVar);
                        return;
                    } else if (jVar.isEmpty()) {
                        AtomicReference atomicReference2 = this.f4784i;
                        while (!atomicReference2.compareAndSet(c0795s4, null) && atomicReference2.get() == c0795s4) {
                        }
                    }
                }
                long j6 = this.f4785j.get();
                long j7 = 0;
                while (true) {
                    z6 = false;
                    if (j7 != j6) {
                        if (!this.f4782g) {
                            boolean z7 = c0795s4.e;
                            try {
                                objPoll = jVar.poll();
                            } catch (Throwable th) {
                                p017c3.d.throwIfFatal(th);
                                p094q3.g.a(c0795s4);
                                p100r3.c cVar5 = this.f4781f;
                                cVar5.getClass();
                                p100r3.g.a(cVar5, th);
                                objPoll = null;
                                z7 = true;
                            }
                            boolean z8 = objPoll == null;
                            if (c0795s4 == this.f4784i.get()) {
                                if (z7) {
                                    if (this.d) {
                                        if (z8) {
                                            AtomicReference atomicReference3 = this.f4784i;
                                            while (!atomicReference3.compareAndSet(c0795s4, null) && atomicReference3.get() == c0795s4) {
                                            }
                                        }
                                    } else if (((Throwable) this.f4781f.get()) != null) {
                                        p100r3.c cVar6 = this.f4781f;
                                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar6, cVar6, cVar);
                                        return;
                                    } else if (z8) {
                                        AtomicReference atomicReference4 = this.f4784i;
                                        while (!atomicReference4.compareAndSet(c0795s4, null) && atomicReference4.get() == c0795s4) {
                                        }
                                    }
                                }
                                if (z8) {
                                    break;
                                }
                                cVar.onNext(objPoll);
                                j7++;
                            }
                            z6 = true;
                            break;
                        }
                        return;
                    }
                    break;
                }
                if (j7 != 0 && !this.f4782g) {
                    if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                        this.f4785j.addAndGet(-j7);
                    }
                    ((t5.d) c0795s4.get()).request(j7);
                }
                if (z6) {
                    continue;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        this.f4784i.lazySet(null);
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4782g) {
            return;
        }
        this.f4782g = true;
        this.f4783h.cancel();
        a();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (!this.e) {
            p100r3.c cVar = this.f4781f;
            cVar.getClass();
            if (p100r3.g.a(cVar, th)) {
                if (!this.d) {
                    a();
                }
                this.e = true;
                b();
                return;
            }
        }
        io.reactivex.plugins.a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        long j6 = this.f4786k + 1;
        this.f4786k = j6;
        C0795s4 c0795s4 = (C0795s4) this.f4784i.get();
        if (c0795s4 != null) {
            p094q3.g.a(c0795s4);
        }
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The publisher returned is null");
            t5.b bVar = (t5.b) objApply;
            C0795s4 c0795s5 = new C0795s4(this, j6, this.c);
            while (true) {
                C0795s4 c0795s6 = (C0795s4) this.f4784i.get();
                if (c0795s6 == f4779l) {
                    return;
                }
                AtomicReference atomicReference = this.f4784i;
                do {
                    if (atomicReference.compareAndSet(c0795s6, c0795s5)) {
                        bVar.subscribe(c0795s5);
                        return;
                    }
                } while (atomicReference.get() == c0795s6);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f4783h.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4783h, dVar)) {
            this.f4783h = dVar;
            this.f4780a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4785j, j6);
            if (this.f4786k == 0) {
                this.f4783h.request(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                b();
            }
        }
    }
}
