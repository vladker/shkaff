package io.reactivex.internal.operators.flowable;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E extends p135x3.a {
    public final /* synthetic */ int b;
    public final p088p3.k c;

    public /* synthetic */ E(p088p3.k kVar, int i5) {
        this.b = i5;
        this.c = kVar;
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.b) {
            case 0:
                ((C) this.c).onComplete();
                break;
            default:
                ((Z4) this.c).onComplete();
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.b) {
            case 0:
                ((C) this.c).onError(th);
                break;
            default:
                Z4 z6 = (Z4) this.c;
                z6.f4536l.cancel();
                z6.f4535k.dispose();
                p033f3.d.a(z6.f4537m);
                z6.c.onError(th);
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.b) {
            case 0:
                C c = (C) this.c;
                c.getClass();
                try {
                    Object objCall = c.f4189i.call();
                    p039g3.A.b(objCall, "The buffer supplied is null");
                    Collection collection = (Collection) objCall;
                    synchronized (c) {
                        try {
                            Object obj2 = c.f4191k;
                            if (obj2 != null) {
                                c.f4191k = collection;
                                c.r(obj2, c);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    c.cancel();
                    c.c.onError(th2);
                    return;
                }
            default:
                Z4 z6 = (Z4) this.c;
                z6.d.offer(new a5(null, obj));
                if (z6.p()) {
                    z6.u();
                    return;
                }
                return;
        }
    }
}
