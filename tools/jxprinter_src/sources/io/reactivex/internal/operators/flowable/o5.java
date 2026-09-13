package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o5 extends AtomicInteger implements t5.d {
    private static final long serialVersionUID = -2434867452883857743L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4720a;
    public final p5[] b;
    public final p027e3.o c;
    public final AtomicLong d;
    public final p100r3.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object[] f4723h;

    public o5(int i5, int i6, p027e3.o oVar, t5.c cVar, boolean z6) {
        this.f4720a = cVar;
        this.c = oVar;
        this.f4721f = z6;
        p5[] p5VarArr = new p5[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            p5VarArr[i7] = new p5(this, i6);
        }
        this.f4723h = new Object[i5];
        this.b = p5VarArr;
        this.d = new AtomicLong();
        this.e = new p100r3.c();
    }

    public final void a() {
        for (p5 p5Var : this.b) {
            p5Var.getClass();
            p094q3.g.a(p5Var);
        }
    }

    public final void b() {
        long j6;
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4720a;
        p5[] p5VarArr = this.b;
        int length = p5VarArr.length;
        Object[] objArr = this.f4723h;
        int iAddAndGet = 1;
        do {
            long j7 = this.d.get();
            long j8 = 0;
            while (true) {
                if (j7 == j8) {
                    j6 = 0;
                    break;
                }
                if (this.f4722g) {
                    return;
                }
                if (!this.f4721f && this.e.get() != null) {
                    a();
                    p100r3.c cVar2 = this.e;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar2, cVar2, cVar);
                    return;
                }
                boolean z6 = false;
                for (int i5 = 0; i5 < length; i5++) {
                    p5 p5Var = p5VarArr[i5];
                    if (objArr[i5] == null) {
                        try {
                            boolean z7 = p5Var.f4731f;
                            p043h3.j jVar = p5Var.d;
                            Object objPoll = jVar != null ? jVar.poll() : null;
                            boolean z8 = objPoll == null;
                            if (z7 && z8) {
                                a();
                                if (((Throwable) this.e.get()) == null) {
                                    cVar.onComplete();
                                    return;
                                }
                                p100r3.c cVar3 = this.e;
                                cVar3.getClass();
                                cVar.onError(p100r3.g.b(cVar3));
                                return;
                            }
                            if (z8) {
                                z6 = true;
                            } else {
                                objArr[i5] = objPoll;
                            }
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            p100r3.c cVar4 = this.e;
                            cVar4.getClass();
                            p100r3.g.a(cVar4, th);
                            if (!this.f4721f) {
                                a();
                                p100r3.c cVar5 = this.e;
                                com.google.android.gms.auth.api.accounttransfer.a.q(cVar5, cVar5, cVar);
                                return;
                            }
                        }
                    }
                }
                j6 = 0;
                if (z6) {
                    break;
                }
                try {
                    Object objApply = this.c.apply(objArr.clone());
                    p039g3.A.b(objApply, "The zipper returned a null value");
                    cVar.onNext(objApply);
                    j8++;
                    Arrays.fill(objArr, (Object) null);
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    a();
                    p100r3.c cVar6 = this.e;
                    cVar6.getClass();
                    p100r3.g.a(cVar6, th2);
                    p100r3.c cVar7 = this.e;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar7, cVar7, cVar);
                    return;
                }
            }
            if (j7 == j8) {
                if (this.f4722g) {
                    return;
                }
                if (!this.f4721f && this.e.get() != null) {
                    a();
                    p100r3.c cVar8 = this.e;
                    com.google.android.gms.auth.api.accounttransfer.a.q(cVar8, cVar8, cVar);
                    return;
                }
                for (int i6 = 0; i6 < length; i6++) {
                    p5 p5Var2 = p5VarArr[i6];
                    if (objArr[i6] == null) {
                        try {
                            boolean z9 = p5Var2.f4731f;
                            p043h3.j jVar2 = p5Var2.d;
                            Object objPoll2 = jVar2 != null ? jVar2.poll() : null;
                            boolean z10 = objPoll2 == null;
                            if (z9 && z10) {
                                a();
                                if (((Throwable) this.e.get()) == null) {
                                    cVar.onComplete();
                                    return;
                                }
                                p100r3.c cVar9 = this.e;
                                cVar9.getClass();
                                cVar.onError(p100r3.g.b(cVar9));
                                return;
                            }
                            if (!z10) {
                                objArr[i6] = objPoll2;
                            }
                        } catch (Throwable th3) {
                            p017c3.d.throwIfFatal(th3);
                            p100r3.c cVar10 = this.e;
                            cVar10.getClass();
                            p100r3.g.a(cVar10, th3);
                            if (!this.f4721f) {
                                a();
                                p100r3.c cVar11 = this.e;
                                com.google.android.gms.auth.api.accounttransfer.a.q(cVar11, cVar11, cVar);
                                return;
                            }
                        }
                    }
                }
            }
            if (j8 != j6) {
                for (p5 p5Var3 : p5VarArr) {
                    p5Var3.request(j8);
                }
                if (j7 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.d.addAndGet(-j8);
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4722g) {
            return;
        }
        this.f4722g = true;
        a();
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.d, j6);
            b();
        }
    }
}
