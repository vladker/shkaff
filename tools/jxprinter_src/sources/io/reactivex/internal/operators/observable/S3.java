package io.reactivex.internal.operators.observable;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S3 extends AtomicInteger implements p011b3.c {
    private static final long serialVersionUID = 2983708048395377667L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5103a;
    public final p027e3.o b;
    public final T3[] c;
    public final Object[] d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f5104f;

    public S3(io.reactivex.I i5, p027e3.o oVar, int i6, boolean z6) {
        this.f5103a = i5;
        this.b = oVar;
        this.c = new T3[i6];
        this.d = new Object[i6];
        this.e = z6;
    }

    public final void a() {
        T3[] t3Arr = this.c;
        for (T3 t6 : t3Arr) {
            t6.b.clear();
        }
        for (T3 t7 : t3Arr) {
            p033f3.d.a(t7.e);
        }
    }

    public final void b() {
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        T3[] t3Arr = this.c;
        io.reactivex.I i5 = this.f5103a;
        Object[] objArr = this.d;
        boolean z6 = this.e;
        int iAddAndGet = 1;
        while (true) {
            int i6 = 0;
            int i7 = 0;
            for (T3 t6 : t3Arr) {
                if (objArr[i7] == null) {
                    boolean z7 = t6.c;
                    Object objPoll = t6.b.poll();
                    boolean z8 = objPoll == null;
                    if (this.f5104f) {
                        a();
                        return;
                    }
                    if (z7) {
                        if (!z6) {
                            Throwable th2 = t6.d;
                            if (th2 != null) {
                                a();
                                i5.onError(th2);
                                return;
                            } else if (z8) {
                                a();
                                i5.onComplete();
                                return;
                            }
                        } else if (z8) {
                            Throwable th3 = t6.d;
                            a();
                            if (th3 != null) {
                                i5.onError(th3);
                                return;
                            } else {
                                i5.onComplete();
                                return;
                            }
                        }
                    }
                    if (z8) {
                        i6++;
                    } else {
                        objArr[i7] = objPoll;
                    }
                } else if (t6.c && !z6 && (th = t6.d) != null) {
                    a();
                    i5.onError(th);
                    return;
                }
                i7++;
            }
            if (i6 != 0) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                try {
                    Object objApply = this.b.apply(objArr.clone());
                    p039g3.A.b(objApply, "The zipper returned a null value");
                    i5.onNext(objApply);
                    Arrays.fill(objArr, (Object) null);
                } catch (Throwable th4) {
                    p017c3.d.throwIfFatal(th4);
                    a();
                    i5.onError(th4);
                    return;
                }
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5104f) {
            return;
        }
        this.f5104f = true;
        for (T3 t6 : this.c) {
            p033f3.d.a(t6.e);
        }
        if (getAndIncrement() == 0) {
            for (T3 t7 : this.c) {
                t7.b.clear();
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5104f;
    }
}
