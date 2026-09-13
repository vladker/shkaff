package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0690b0 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -4255299542215038287L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4560a;
    public final p027e3.o b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p100r3.c f4561f = new p100r3.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f4562g = new AtomicLong();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p083o3.d f4563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t5.d f4564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f4565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile p088p3.i f4567l;

    public C0690b0(t5.c cVar, p027e3.o oVar, int i5, int i6, int i7) {
        this.f4560a = cVar;
        this.b = oVar;
        this.c = i5;
        this.d = i6;
        this.e = i7;
        this.f4563h = new p083o3.d(Math.min(i6, i5));
    }

    public final void a() {
        p088p3.i iVar = this.f4567l;
        this.f4567l = null;
        if (iVar != null) {
            p094q3.g.a(iVar);
        }
        while (true) {
            p088p3.i iVar2 = (p088p3.i) this.f4563h.poll();
            if (iVar2 == null) {
                return;
            } else {
                p094q3.g.a(iVar2);
            }
        }
    }

    public final void b() {
        p088p3.i iVar;
        boolean z6;
        long j6;
        p043h3.j jVar;
        if (getAndIncrement() != 0) {
            return;
        }
        p088p3.i iVar2 = this.f4567l;
        t5.c cVar = this.f4560a;
        int i5 = this.e;
        int i6 = 1;
        int iAddAndGet = 1;
        while (true) {
            long j7 = this.f4562g.get();
            if (iVar2 != null) {
                iVar = iVar2;
            } else {
                if (i5 != 3 && ((Throwable) this.f4561f.get()) != null) {
                    a();
                    p100r3.c cVar2 = this.f4561f;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
                    return;
                }
                boolean z7 = this.f4566k;
                iVar = (p088p3.i) this.f4563h.poll();
                if (z7 && iVar == null) {
                    p100r3.c cVar3 = this.f4561f;
                    cVar3.getClass();
                    Throwable thB = p100r3.g.b(cVar3);
                    if (thB != null) {
                        cVar.onError(thB);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
                if (iVar != null) {
                    this.f4567l = iVar;
                }
            }
            if (iVar == null || (jVar = iVar.d) == null) {
                z6 = false;
                j6 = 0;
            } else {
                j6 = 0;
                while (true) {
                    if (j6 != j7) {
                        if (this.f4565j) {
                            a();
                            return;
                        }
                        if (i5 == i6 && ((Throwable) this.f4561f.get()) != null) {
                            this.f4567l = null;
                            p094q3.g.a(iVar);
                            a();
                            p100r3.c cVar4 = this.f4561f;
                            com.google.android.gms.auth.api.accounttransfer.a.q(cVar4, cVar4, cVar);
                            return;
                        }
                        boolean z8 = iVar.e;
                        try {
                            Object objPoll = jVar.poll();
                            boolean z9 = objPoll == null;
                            if (z8 && z9) {
                                this.f4567l = null;
                                this.f4564i.request(1L);
                                iVar = null;
                                z6 = true;
                                break;
                            }
                            if (!z9) {
                                cVar.onNext(objPoll);
                                j6++;
                                if (iVar.f7745g != 1) {
                                    long j8 = iVar.f7744f + 1;
                                    if (j8 == iVar.c) {
                                        iVar.f7744f = 0L;
                                        ((t5.d) iVar.get()).request(j8);
                                    } else {
                                        iVar.f7744f = j8;
                                    }
                                }
                                i6 = 1;
                            }
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.f4567l = null;
                            p094q3.g.a(iVar);
                            a();
                            cVar.onError(th);
                            return;
                        }
                    }
                    z6 = false;
                    break;
                }
                if (j6 != j7) {
                    i6 = 1;
                } else {
                    if (this.f4565j) {
                        a();
                        return;
                    }
                    i6 = 1;
                    if (i5 == 1 && ((Throwable) this.f4561f.get()) != null) {
                        this.f4567l = null;
                        iVar.getClass();
                        p094q3.g.a(iVar);
                        a();
                        p100r3.c cVar5 = this.f4561f;
                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar5, cVar5, cVar);
                        return;
                    }
                    boolean z10 = iVar.e;
                    boolean zIsEmpty = jVar.isEmpty();
                    if (z10 && zIsEmpty) {
                        this.f4567l = null;
                        this.f4564i.request(1L);
                        z6 = true;
                        iVar = null;
                    }
                }
            }
            if (j6 != 0 && j7 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f4562g.addAndGet(-j6);
            }
            if (!z6 && (iAddAndGet = addAndGet(-iAddAndGet)) == 0) {
                return;
            } else {
                iVar2 = iVar;
            }
        }
    }

    public final void c(p088p3.i iVar, Throwable th) {
        p100r3.c cVar = this.f4561f;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        iVar.e = true;
        if (this.e != 3) {
            this.f4564i.cancel();
        }
        b();
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4565j) {
            return;
        }
        this.f4565j = true;
        this.f4564i.cancel();
        if (getAndIncrement() == 0) {
            do {
                a();
            } while (decrementAndGet() != 0);
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4566k = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.f4561f;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4566k = true;
            b();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null Publisher");
            t5.b bVar = (t5.b) objApply;
            p088p3.i iVar = new p088p3.i(this, this.d);
            if (this.f4565j) {
                return;
            }
            this.f4563h.offer(iVar);
            bVar.subscribe(iVar);
            if (this.f4565j) {
                p094q3.g.a(iVar);
                if (getAndIncrement() == 0) {
                    do {
                        a();
                    } while (decrementAndGet() != 0);
                }
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f4564i.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4564i, dVar)) {
            this.f4564i = dVar;
            this.f4560a.onSubscribe(this);
            int i5 = this.c;
            dVar.request(i5 == Integer.MAX_VALUE ? LocationRequestCompat.PASSIVE_INTERVAL : i5);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4562g, j6);
            b();
        }
    }
}
