package p059k3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p094q3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = -1266041316834525931L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w0 f5585a;

    public v0(w0 w0Var) {
        this.f5585a = w0Var;
    }

    @Override // t5.c
    public final void onComplete() {
        w0 w0Var = this.f5585a;
        w0Var.getClass();
        if (d.a(w0Var)) {
            w0Var.f5587a.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        w0 w0Var = this.f5585a;
        w0Var.getClass();
        if (d.a(w0Var)) {
            w0Var.f5587a.onError(th);
        } else {
            a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        g.a(this);
        w0 w0Var = this.f5585a;
        w0Var.getClass();
        if (d.a(w0Var)) {
            w0Var.f5587a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
