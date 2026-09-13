package p059k3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p017c3.c;
import p094q3.g;
import t5.d;

/* JADX INFO: renamed from: k3.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1041s extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = -1215060610805418006L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5579a;
    public Object b;
    public Throwable c;

    public C1041s(InterfaceC0988v interfaceC0988v) {
        this.f5579a = interfaceC0988v;
    }

    @Override // t5.c
    public final void onComplete() {
        Throwable th = this.c;
        InterfaceC0988v interfaceC0988v = this.f5579a;
        if (th != null) {
            interfaceC0988v.onError(th);
            return;
        }
        Object obj = this.b;
        if (obj != null) {
            interfaceC0988v.onSuccess(obj);
        } else {
            interfaceC0988v.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        Throwable th2 = this.c;
        InterfaceC0988v interfaceC0988v = this.f5579a;
        if (th2 == null) {
            interfaceC0988v.onError(th);
        } else {
            interfaceC0988v.onError(new c(th2, th));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        d dVar = (d) get();
        g gVar = g.f7849a;
        if (dVar != gVar) {
            lazySet(gVar);
            dVar.cancel();
            onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
