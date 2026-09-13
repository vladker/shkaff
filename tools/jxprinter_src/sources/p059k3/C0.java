package p059k3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import io.reactivex.y;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p094q3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0 extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = 8663801314800248617L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B0 f5506a;

    public C0(B0 b1) {
        this.f5506a = b1;
    }

    @Override // t5.c
    public final void onComplete() {
        B0 b1 = this.f5506a;
        b1.getClass();
        if (d.a(b1)) {
            y yVar = b1.c;
            if (yVar == null) {
                b1.f5504a.onError(new TimeoutException());
            } else {
                ((AbstractC0985s) yVar).subscribe(b1.d);
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        B0 b1 = this.f5506a;
        b1.getClass();
        if (d.a(b1)) {
            b1.f5504a.onError(th);
        } else {
            a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        ((t5.d) get()).cancel();
        B0 b1 = this.f5506a;
        b1.getClass();
        if (d.a(b1)) {
            y yVar = b1.c;
            if (yVar == null) {
                b1.f5504a.onError(new TimeoutException());
            } else {
                ((AbstractC0985s) yVar).subscribe(b1.d);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
