package p048i3;

import io.reactivex.I;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p100r3.l;
import p100r3.n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends AtomicReference implements I, c {
    public static final Object b = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f4050a;

    public h(LinkedBlockingQueue linkedBlockingQueue) {
        this.f4050a = linkedBlockingQueue;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (d.a(this)) {
            this.f4050a.offer(b);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == d.f3969a;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f4050a.offer(n.f7968a);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f4050a.offer(new l(th));
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f4050a.offer(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }
}
