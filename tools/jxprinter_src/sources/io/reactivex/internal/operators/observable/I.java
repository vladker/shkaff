package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = -4823716997131257941L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f4959a;
    public final int b;

    public I(J j6, int i5) {
        this.f4959a = j6;
        this.b = i5;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x001f A[Catch: all -> 0x000b, TryCatch #0 {all -> 0x000b, blocks: (B:4:0x0005, B:6:0x0009, B:10:0x000d, B:15:0x0017, B:18:0x0021, B:17:0x001f), top: B:25:0x0005 }] */
    @Override // io.reactivex.I
    public final void onComplete() {
        J j6 = this.f4959a;
        int i5 = this.b;
        synchronized (j6) {
            try {
                Object[] objArr = j6.d;
                if (objArr == null) {
                    return;
                }
                boolean z6 = objArr[i5] == null;
                if (z6) {
                    j6.f4981h = true;
                } else {
                    int i6 = j6.f4984k + 1;
                    j6.f4984k = i6;
                    if (i6 == objArr.length) {
                        j6.f4981h = true;
                    }
                }
                if (z6) {
                    j6.a();
                }
                j6.c();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002e A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:7:0x0015, B:9:0x0019, B:13:0x001d, B:18:0x0026, B:21:0x0030, B:20:0x002e), top: B:31:0x0015 }] */
    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        J j6 = this.f4959a;
        int i5 = this.b;
        p100r3.c cVar = j6.f4982i;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        boolean z6 = true;
        if (j6.f4979f) {
            synchronized (j6) {
                try {
                    Object[] objArr = j6.d;
                    if (objArr == null) {
                        return;
                    }
                    boolean z7 = objArr[i5] == null;
                    if (z7) {
                        j6.f4981h = true;
                    } else {
                        int i6 = j6.f4984k + 1;
                        j6.f4984k = i6;
                        if (i6 == objArr.length) {
                            j6.f4981h = true;
                        }
                    }
                    z6 = z7;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (z6) {
            j6.a();
        }
        j6.c();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        boolean z6;
        J j6 = this.f4959a;
        int i5 = this.b;
        synchronized (j6) {
            try {
                Object[] objArr = j6.d;
                if (objArr == null) {
                    return;
                }
                Object obj2 = objArr[i5];
                int i6 = j6.f4983j;
                if (obj2 == null) {
                    i6++;
                    j6.f4983j = i6;
                }
                objArr[i5] = obj;
                if (i6 == objArr.length) {
                    j6.e.offer(objArr.clone());
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6) {
                    j6.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
