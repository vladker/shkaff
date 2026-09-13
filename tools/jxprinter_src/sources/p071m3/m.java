package p071m3;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;
import p043h3.i;
import p083o3.c;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = 8410034718427740355L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f6149a;
    public final int b;
    public final int c;
    public long d;
    public volatile c e;

    public m(o oVar, int i5) {
        this.f6149a = oVar;
        this.b = i5;
        this.c = i5 - (i5 >> 2);
    }

    public final i a() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this.b);
        this.e = cVar2;
        return cVar2;
    }

    public final void b() {
        long j6 = this.d + 1;
        if (j6 != this.c) {
            this.d = j6;
        } else {
            this.d = 0L;
            ((d) get()).request(j6);
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f6149a.d();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f6149a.e(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f6149a.f(this, obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        g.d(this, dVar, this.b);
    }
}
