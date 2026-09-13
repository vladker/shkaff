package p048i3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import java.util.concurrent.CountDownLatch;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends CountDownLatch implements S, InterfaceC0679f, InterfaceC0988v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4049a;
    public Throwable b;
    public c c;
    public volatile boolean d;

    public final Object a() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                b();
                throw p100r3.g.d(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            return this.f4049a;
        }
        throw p100r3.g.d(th);
    }

    public final void b() {
        this.d = true;
        c cVar = this.c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.b = th;
        countDown();
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        this.c = cVar;
        if (this.d) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f4049a = obj;
        countDown();
    }
}
