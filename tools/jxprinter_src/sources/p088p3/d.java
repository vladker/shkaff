package p088p3;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.g;
import p100r3.l;
import p100r3.m;
import p100r3.n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends AtomicReference implements InterfaceC0984q, t5.d {
    public static final Object b = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f7738a;

    public d(LinkedBlockingQueue linkedBlockingQueue) {
        this.f7738a = linkedBlockingQueue;
    }

    @Override // t5.d
    public final void cancel() {
        if (g.a(this)) {
            this.f7738a.offer(b);
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f7738a.offer(n.f7968a);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7738a.offer(new l(th));
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f7738a.offer(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (g.e(this, dVar)) {
            this.f7738a.offer(new m(this));
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        ((t5.d) get()).request(j6);
    }
}
