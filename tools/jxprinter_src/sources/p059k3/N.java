package p059k3;

import io.reactivex.I;
import io.reactivex.InterfaceC0988v;
import java.util.Iterator;
import p027e3.o;
import p033f3.d;
import p039g3.A;
import p048i3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N extends c implements InterfaceC0988v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f5524a;
    public final o b;
    public p011b3.c c;
    public volatile Iterator d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5525f;

    public N(I i5, o oVar) {
        this.f5524a = i5;
        this.b = oVar;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f5525f = true;
        return 2;
    }

    @Override // p043h3.j
    public final void clear() {
        this.d = null;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.e = true;
        this.c.dispose();
        this.c = d.f3969a;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.d == null;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5524a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.c = d.f3969a;
        this.f5524a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        if (d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5524a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        I i5 = this.f5524a;
        try {
            Iterator it = ((Iterable) this.b.apply(obj)).iterator();
            if (!it.hasNext()) {
                i5.onComplete();
                return;
            }
            this.d = it;
            if (this.f5525f) {
                i5.onNext(null);
                i5.onComplete();
                return;
            }
            while (!this.e) {
                try {
                    i5.onNext(it.next());
                    if (this.e) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            i5.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        i5.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    i5.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            i5.onError(th3);
        }
    }

    @Override // p048i3.c, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        Iterator it = this.d;
        if (it == null) {
            return null;
        }
        Object next = it.next();
        A.b(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.d = null;
        }
        return next;
    }
}
