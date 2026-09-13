package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.x3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0824x3 extends AtomicReference implements C3 {
    private static final long serialVersionUID = 2346567790059478686L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public B3 f4823a;
    public int b;
    public long c;

    public AbstractC0824x3() {
        B3 b6 = new B3(null, 0L);
        this.f4823a = b6;
        set(b6);
    }

    @Override // io.reactivex.internal.operators.flowable.C3
    public final void a(Object obj) {
        Object objB = b(obj);
        long j6 = this.c + 1;
        this.c = j6;
        B3 b6 = new B3(objB, j6);
        this.f4823a.set(b6);
        this.f4823a = b6;
        this.b++;
        f();
    }

    public B3 c() {
        return (B3) get();
    }

    @Override // io.reactivex.internal.operators.flowable.C3
    public final void complete() {
        Object objB = b(p100r3.n.f7968a);
        long j6 = this.c + 1;
        this.c = j6;
        B3 b6 = new B3(objB, j6);
        this.f4823a.set(b6);
        this.f4823a = b6;
        this.b++;
        g();
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083 A[LOOP:1: B:24:0x0041->B:46:0x0083, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0080 A[SYNTHETIC] */
    @Override // io.reactivex.internal.operators.flowable.C3
    public final void e(C0836z3 c0836z3) {
        B3 b6;
        boolean z6;
        synchronized (c0836z3) {
            try {
                if (c0836z3.e) {
                    c0836z3.f4852f = true;
                    return;
                }
                c0836z3.e = true;
                while (!c0836z3.e()) {
                    long j6 = c0836z3.get();
                    boolean z7 = j6 == LocationRequestCompat.PASSIVE_INTERVAL;
                    B3 b3C = (B3) c0836z3.c;
                    if (b3C == null) {
                        b3C = c();
                        c0836z3.c = b3C;
                        p122v2.a.a(c0836z3.d, b3C.b);
                    }
                    long j7 = 0;
                    while (j6 != 0 && (b6 = (B3) b3C.get()) != null) {
                        Object objD = d(b6.f4183a);
                        try {
                            t5.c cVar = c0836z3.b;
                            if (objD == p100r3.n.f7968a) {
                                cVar.onComplete();
                            } else {
                                if (objD instanceof p100r3.l) {
                                    cVar.onError(((p100r3.l) objD).f7966a);
                                } else {
                                    cVar.onNext(objD);
                                    z6 = false;
                                }
                                if (z6) {
                                    c0836z3.c = null;
                                    return;
                                }
                                j7++;
                                j6--;
                                if (c0836z3.e()) {
                                    c0836z3.c = null;
                                    return;
                                }
                                b3C = b6;
                            }
                            z6 = true;
                            if (z6) {
                                c0836z3.c = null;
                                return;
                            }
                            j7++;
                            j6--;
                            if (c0836z3.e()) {
                                c0836z3.c = null;
                                return;
                            }
                            b3C = b6;
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            c0836z3.c = null;
                            c0836z3.dispose();
                            if ((objD instanceof p100r3.l) || p100r3.n.c(objD)) {
                                return;
                            }
                            c0836z3.b.onError(th);
                            return;
                        }
                    }
                    if (j7 != 0) {
                        c0836z3.c = b3C;
                        if (!z7) {
                            c0836z3.a(j7);
                        }
                    }
                    synchronized (c0836z3) {
                        try {
                            if (!c0836z3.f4852f) {
                                c0836z3.e = false;
                                return;
                            }
                            c0836z3.f4852f = false;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                c0836z3.c = null;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.C3
    public final void error(Throwable th) {
        Object objB = b(new p100r3.l(th));
        long j6 = this.c + 1;
        this.c = j6;
        B3 b6 = new B3(objB, j6);
        this.f4823a.set(b6);
        this.f4823a = b6;
        this.b++;
        g();
    }

    public abstract void f();

    public void g() {
        B3 b6 = (B3) get();
        if (b6.f4183a != null) {
            B3 b7 = new B3(null, 0L);
            b7.lazySet(b6.get());
            set(b7);
        }
    }

    public Object b(Object obj) {
        return obj;
    }

    public Object d(Object obj) {
        return obj;
    }
}
