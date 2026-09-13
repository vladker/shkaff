package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W extends V {
    private static final long serialVersionUID = -2945777694260521066L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final t5.c f4486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f4487n;

    public W(int i5, p027e3.o oVar, t5.c cVar, boolean z6) {
        super(oVar, i5);
        this.f4486m = cVar;
        this.f4487n = z6;
    }

    @Override // io.reactivex.internal.operators.flowable.Z
    public final void a(Throwable th) {
        p100r3.c cVar = this.f4475j;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (!this.f4487n) {
            this.e.cancel();
            this.f4473h = true;
        }
        this.f4476k = false;
        c();
    }

    @Override // io.reactivex.internal.operators.flowable.Z
    public final void b(Object obj) {
        this.f4486m.onNext(obj);
    }

    @Override // io.reactivex.internal.operators.flowable.V
    public final void c() {
        if (getAndIncrement() == 0) {
            while (!this.f4474i) {
                if (!this.f4476k) {
                    boolean z6 = this.f4473h;
                    if (z6 && !this.f4487n && ((Throwable) this.f4475j.get()) != null) {
                        t5.c cVar = this.f4486m;
                        p100r3.c cVar2 = this.f4475j;
                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
                        return;
                    }
                    try {
                        Object objPoll = this.f4472g.poll();
                        boolean z7 = objPoll == null;
                        if (z6 && z7) {
                            p100r3.c cVar3 = this.f4475j;
                            cVar3.getClass();
                            Throwable thB = p100r3.g.b(cVar3);
                            if (thB != null) {
                                this.f4486m.onError(thB);
                                return;
                            } else {
                                this.f4486m.onComplete();
                                return;
                            }
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
                                        } else if (this.f4470a.f7848h) {
                                            this.f4486m.onNext(objCall);
                                        } else {
                                            this.f4476k = true;
                                            Y y6 = this.f4470a;
                                            y6.e(new C0684a0(objCall, y6));
                                        }
                                    } catch (Throwable th) {
                                        p017c3.d.throwIfFatal(th);
                                        this.e.cancel();
                                        p100r3.c cVar4 = this.f4475j;
                                        cVar4.getClass();
                                        p100r3.g.a(cVar4, th);
                                        t5.c cVar5 = this.f4486m;
                                        p100r3.c cVar6 = this.f4475j;
                                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar6, cVar6, cVar5);
                                        return;
                                    }
                                } else {
                                    this.f4476k = true;
                                    bVar.subscribe(this.f4470a);
                                }
                            } catch (Throwable th2) {
                                p017c3.d.throwIfFatal(th2);
                                this.e.cancel();
                                p100r3.c cVar7 = this.f4475j;
                                cVar7.getClass();
                                p100r3.g.a(cVar7, th2);
                                t5.c cVar8 = this.f4486m;
                                p100r3.c cVar9 = this.f4475j;
                                com.google.android.gms.auth.api.accounttransfer.a.q(cVar9, cVar9, cVar8);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        this.e.cancel();
                        p100r3.c cVar10 = this.f4475j;
                        cVar10.getClass();
                        p100r3.g.a(cVar10, th3);
                        t5.c cVar11 = this.f4486m;
                        p100r3.c cVar12 = this.f4475j;
                        com.google.android.gms.auth.api.accounttransfer.a.q(cVar12, cVar12, cVar11);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
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
        this.f4486m.onSubscribe(this);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.f4475j;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4473h = true;
            c();
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.f4470a.request(j6);
    }
}
