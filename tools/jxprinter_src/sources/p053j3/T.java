package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p017c3.d;
import p027e3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T extends AtomicReference implements InterfaceC0679f, c {
    private static final long serialVersionUID = -674404550052917487L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5424a;
    public final g b;
    public final boolean c;
    public c d;

    public T(InterfaceC0679f interfaceC0679f, Object obj, g gVar, boolean z6) {
        super(obj);
        this.f5424a = interfaceC0679f;
        this.b = gVar;
        this.c = z6;
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

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.d = p033f3.d.f3969a;
        InterfaceC0679f interfaceC0679f = this.f5424a;
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
                interfaceC0679f.onError(th);
                return;
            }
        }
        interfaceC0679f.onComplete();
        if (z6) {
            return;
        }
        a();
    }

    @Override // io.reactivex.InterfaceC0679f
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
        this.f5424a.onError(th);
        if (z6) {
            return;
        }
        a();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.d, cVar)) {
            this.d = cVar;
            this.f5424a.onSubscribe(this);
        }
    }
}
