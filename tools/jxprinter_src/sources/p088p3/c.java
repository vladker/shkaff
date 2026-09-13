package p088p3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.concurrent.CountDownLatch;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends CountDownLatch implements InterfaceC0984q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f7737a;
    public Throwable b;
    public d c;
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i5, int i6) {
        super(i5);
        this.d = i6;
    }

    public final Object a() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                d dVar = this.c;
                this.c = g.f7849a;
                if (dVar != null) {
                    dVar.cancel();
                }
                throw p100r3.g.d(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            return this.f7737a;
        }
        throw p100r3.g.d(th);
    }

    @Override // t5.c
    public final void onComplete() {
        countDown();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.d) {
            case 0:
                if (this.f7737a == null) {
                    this.b = th;
                } else {
                    a.onError(th);
                }
                countDown();
                break;
            default:
                this.f7737a = null;
                this.b = th;
                countDown();
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.d) {
            case 0:
                if (this.f7737a == null) {
                    this.f7737a = obj;
                    this.c.cancel();
                    countDown();
                }
                break;
            default:
                this.f7737a = obj;
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.c, dVar)) {
            this.c = dVar;
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
