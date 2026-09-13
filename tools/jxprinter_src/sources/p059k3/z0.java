package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import io.reactivex.y;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z0 extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = 8663801314800248617L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0 f5591a;

    public z0(y0 y0Var) {
        this.f5591a = y0Var;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        y0 y0Var = this.f5591a;
        y0Var.getClass();
        if (d.a(y0Var)) {
            y yVar = y0Var.c;
            if (yVar == null) {
                y0Var.f5590a.onError(new TimeoutException());
            } else {
                ((AbstractC0985s) yVar).subscribe(y0Var.d);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        y0 y0Var = this.f5591a;
        y0Var.getClass();
        if (d.a(y0Var)) {
            y0Var.f5590a.onError(th);
        } else {
            a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        y0 y0Var = this.f5591a;
        y0Var.getClass();
        if (d.a(y0Var)) {
            y yVar = y0Var.c;
            if (yVar == null) {
                y0Var.f5590a.onError(new TimeoutException());
            } else {
                ((AbstractC0985s) yVar).subscribe(y0Var.d);
            }
        }
    }
}
