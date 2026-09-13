package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X extends V {
    private static final long serialVersionUID = 7898995095634264146L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final t5.c f4502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicInteger f4503n;

    public X(t5.c cVar, p027e3.o oVar, int i5) {
        super(oVar, i5);
        this.f4502m = cVar;
        this.f4503n = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.flowable.Z
    public final void a(Throwable th) {
        p100r3.c cVar = this.f4475j;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.e.cancel();
        if (getAndIncrement() == 0) {
            com.google.android.gms.auth.api.accounttransfer.a.q(cVar, cVar, this.f4502m);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.Z
    public final void b(Object obj) {
        if (get() == 0 && compareAndSet(0, 1)) {
            t5.c cVar = this.f4502m;
            cVar.onNext(obj);
            if (compareAndSet(1, 0)) {
                return;
            }
            p100r3.c cVar2 = this.f4475j;
            com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.V
    public final void c() {
        if (this.f4503n.getAndIncrement() == 0) {
            while (!this.f4474i) {
                if (!this.f4476k) {
                    boolean z6 = this.f4473h;
                    try {
                        Object objPoll = this.f4472g.poll();
                        boolean z7 = objPoll == null;
                        if (z6 && z7) {
                            this.f4502m.onComplete();
                            return;
                        }
                        if (!z7) {
                            try {
                                Object objApply = this.b.apply(objPoll);
                                p039g3.A.b(objApply, "The mapper returned a null Publisher");
                                t5.b bVar = (t5.b) objApply;
                                if (this.f4477l != 1) {
                                    int i5 = this.f4471f + 1;
                                    if (i5 == this.d) {
                                        this.f4471f = 0;
                                        this.e.request(i5);
                                    } else {
                                        this.f4471f = i5;
                                    }
                                }
                                if (bVar instanceof Callable) {
                                    try {
                                        Object objCall = ((Callable) bVar).call();
                                        if (objCall == null) {
                                            continue;
                                        } else if (!this.f4470a.f7848h) {
                                            this.f4476k = true;
                                            Y y6 = this.f4470a;
                                            y6.e(new C0684a0(objCall, y6));
                                        } else if (get() == 0 && compareAndSet(0, 1)) {
                                            this.f4502m.onNext(objCall);
                                            if (!compareAndSet(1, 0)) {
                                                t5.c cVar = this.f4502m;
                                                p100r3.c cVar2 = this.f4475j;
                                                com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
                                                return;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        p017c3.d.throwIfFatal(th);
                                        this.e.cancel();
                                        p100r3.c cVar3 = this.f4475j;
                                        cVar3.getClass();
                                        p100r3.g.a(cVar3, th);
                                        t5.c cVar4 = this.f4502m;
                                        p100r3.c cVar5 = this.f4475j;
                                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar5, cVar5, cVar4);
                                        return;
                                    }
                                } else {
                                    this.f4476k = true;
                                    bVar.subscribe(this.f4470a);
                                }
                            } catch (Throwable th2) {
                                p017c3.d.throwIfFatal(th2);
                                this.e.cancel();
                                p100r3.c cVar6 = this.f4475j;
                                cVar6.getClass();
                                p100r3.g.a(cVar6, th2);
                                t5.c cVar7 = this.f4502m;
                                p100r3.c cVar8 = this.f4475j;
                                com.google.android.gms.auth.api.accounttransfer.a.q(cVar8, cVar8, cVar7);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        this.e.cancel();
                        p100r3.c cVar9 = this.f4475j;
                        cVar9.getClass();
                        p100r3.g.a(cVar9, th3);
                        t5.c cVar10 = this.f4502m;
                        p100r3.c cVar11 = this.f4475j;
                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar11, cVar11, cVar10);
                        return;
                    }
                }
                if (this.f4503n.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4474i) {
            return;
        }
        this.f4474i = true;
        this.f4470a.cancel();
        this.e.cancel();
    }

    @Override // io.reactivex.internal.operators.flowable.V
    public final void d() {
        this.f4502m.onSubscribe(this);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.f4475j;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4470a.cancel();
        if (getAndIncrement() == 0) {
            com.google.android.gms.auth.api.accounttransfer.a.q(cVar, cVar, this.f4502m);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.f4470a.request(j6);
    }
}
