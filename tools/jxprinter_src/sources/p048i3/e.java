package p048i3;

import io.reactivex.I;
import java.util.concurrent.CountDownLatch;
import p011b3.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends CountDownLatch implements I, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4048a;
    public Throwable b;
    public c c;
    public volatile boolean d;

    public final Object a() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                dispose();
                throw g.d(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            return this.f4048a;
        }
        throw g.d(th);
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d = true;
        c cVar = this.c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        this.c = cVar;
        if (this.d) {
            cVar.dispose();
        }
    }
}
