package io.reactivex.internal.operators.observable;

import java.util.Collection;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0954y extends p112t3.c {
    public final /* synthetic */ int b;
    public final p048i3.s c;

    public /* synthetic */ C0954y(p048i3.s sVar, int i5) {
        this.b = i5;
        this.c = sVar;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.b) {
            case 0:
                ((C0946w) this.c).onComplete();
                break;
            default:
                ((D3) this.c).onComplete();
                break;
        }
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.b) {
            case 0:
                ((C0946w) this.c).onError(th);
                break;
            default:
                D3 d6 = (D3) this.c;
                d6.f4904k.dispose();
                d6.f4903j.dispose();
                d6.onError(th);
                break;
        }
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.b) {
            case 0:
                C0946w c0946w = (C0946w) this.c;
                c0946w.getClass();
                try {
                    Object objCall = c0946w.f5296h.call();
                    p039g3.A.b(objCall, "The buffer supplied is null");
                    Collection collection = (Collection) objCall;
                    synchronized (c0946w) {
                        try {
                            Object obj2 = c0946w.f5298j;
                            if (obj2 != null) {
                                c0946w.f5298j = collection;
                                c0946w.f(obj2, c0946w);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    c0946w.dispose();
                    c0946w.b.onError(th2);
                    return;
                }
            default:
                D3 d6 = (D3) this.c;
                d6.c.offer(new E3(null, obj));
                if (d6.c()) {
                    d6.h();
                    return;
                }
                return;
        }
    }
}
