package p077n3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p017c3.d;
import p027e3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X extends AtomicReference implements S, c {
    private static final long serialVersionUID = -5331524057054083935L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6281a;
    public final g b;
    public final boolean c;
    public c d;

    public X(S s6, Object obj, boolean z6, g gVar) {
        super(obj);
        this.f6281a = s6;
        this.c = z6;
        this.b = gVar;
    }

    public final void a() {
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.b.accept(andSet);
            } catch (Throwable th) {
                d.throwIfFatal(th);
                a.onError(th);
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d.dispose();
        this.d = p033f3.d.f3969a;
        a();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d.e();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.d = p033f3.d.f3969a;
        boolean z6 = this.c;
        if (z6) {
            Object andSet = getAndSet(this);
            if (andSet == this) {
                return;
            }
            try {
                this.b.accept(andSet);
            } catch (Throwable th2) {
                d.throwIfFatal(th2);
                th = new p017c3.c(th, th2);
            }
        }
        this.f6281a.onError(th);
        if (z6) {
            return;
        }
        a();
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.d, cVar)) {
            this.d = cVar;
            this.f6281a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.d = p033f3.d.f3969a;
        S s6 = this.f6281a;
        boolean z6 = this.c;
        if (z6) {
            Object andSet = getAndSet(this);
            if (andSet == this) {
                return;
            }
            try {
                this.b.accept(andSet);
            } catch (Throwable th) {
                d.throwIfFatal(th);
                s6.onError(th);
                return;
            }
        }
        s6.onSuccess(obj);
        if (z6) {
            return;
        }
        a();
    }
}
