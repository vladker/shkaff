package p088p3;

import androidx.collection.a;
import com.android.billingclient.api.v1;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends AtomicInteger implements InterfaceC0984q, d {
    private static final long serialVersionUID = -4945028590049415624L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7751a;
    public final p100r3.c b = new p100r3.c();
    public final AtomicLong c = new AtomicLong();
    public final AtomicReference d = new AtomicReference();
    public final AtomicBoolean e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f7752f;

    public m(c cVar) {
        this.f7751a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f7752f) {
            return;
        }
        g.a(this.d);
    }

    @Override // t5.c
    public final void onComplete() {
        this.f7752f = true;
        v1.g(this.f7751a, this, this.b);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7752f = true;
        v1.i(this.f7751a, th, this, this.b);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        v1.k(this.f7751a, obj, this, this.b);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (this.e.compareAndSet(false, true)) {
            this.f7751a.onSubscribe(this);
            g.c(this.d, this.c, dVar);
        } else {
            dVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (j6 > 0) {
            g.b(this.d, this.c, j6);
        } else {
            cancel();
            onError(new IllegalArgumentException(a.j(j6, "§3.9 violated: positive request amount required but it was ")));
        }
    }
}
