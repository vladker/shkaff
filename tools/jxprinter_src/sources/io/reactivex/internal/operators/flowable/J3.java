package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J3 extends ArrayList implements C3 {
    private static final long serialVersionUID = 7063189396499112664L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f4299a;

    @Override // io.reactivex.internal.operators.flowable.C3
    public final void a(Object obj) {
        add(obj);
        this.f4299a++;
    }

    @Override // io.reactivex.internal.operators.flowable.C3
    public final void complete() {
        add(p100r3.n.f7968a);
        this.f4299a++;
    }

    @Override // io.reactivex.internal.operators.flowable.C3
    public final void e(C0836z3 c0836z3) {
        boolean z6;
        synchronized (c0836z3) {
            try {
                if (c0836z3.e) {
                    c0836z3.f4852f = true;
                    return;
                }
                c0836z3.e = true;
                t5.c cVar = c0836z3.b;
                while (!c0836z3.e()) {
                    int i5 = this.f4299a;
                    Integer num = (Integer) c0836z3.c;
                    int iIntValue = num != null ? num.intValue() : 0;
                    long j6 = c0836z3.get();
                    long j7 = j6;
                    long j8 = 0;
                    while (j7 != 0 && iIntValue < i5) {
                        Object obj = get(iIntValue);
                        try {
                            if (obj == p100r3.n.f7968a) {
                                cVar.onComplete();
                            } else {
                                if (obj instanceof p100r3.l) {
                                    cVar.onError(((p100r3.l) obj).f7966a);
                                } else {
                                    cVar.onNext(obj);
                                    z6 = false;
                                }
                                if (!z6 || c0836z3.e()) {
                                    return;
                                }
                                iIntValue++;
                                j7--;
                                j8++;
                            }
                            z6 = true;
                            if (!z6) {
                                return;
                            }
                            iIntValue++;
                            j7--;
                            j8++;
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            c0836z3.dispose();
                            if ((obj instanceof p100r3.l) || p100r3.n.c(obj)) {
                                return;
                            }
                            cVar.onError(th);
                            return;
                        }
                    }
                    if (j8 != 0) {
                        c0836z3.c = Integer.valueOf(iIntValue);
                        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                            c0836z3.a(j8);
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
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.C3
    public final void error(Throwable th) {
        add(new p100r3.l(th));
        this.f4299a++;
    }
}
