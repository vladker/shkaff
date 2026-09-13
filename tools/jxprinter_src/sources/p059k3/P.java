package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P implements InterfaceC0988v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5528a;
    public final /* synthetic */ AtomicReference b;

    public /* synthetic */ P(AtomicReference atomicReference, int i5) {
        this.f5528a = i5;
        this.b = atomicReference;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5528a) {
            case 0:
                ((Q) this.b).f5529a.onComplete();
                break;
            default:
                ((V) this.b).f5532a.onComplete();
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        switch (this.f5528a) {
            case 0:
                ((Q) this.b).f5529a.onError(th);
                break;
            default:
                ((V) this.b).f5532a.onError(th);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        switch (this.f5528a) {
            case 0:
                d.f((Q) this.b, cVar);
                break;
            default:
                d.f((V) this.b, cVar);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        switch (this.f5528a) {
            case 0:
                ((Q) this.b).f5529a.onSuccess(obj);
                break;
            default:
                ((V) this.b).f5532a.onSuccess(obj);
                break;
        }
    }
}
