package p071m3;

import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.c;
import p094q3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends c {
    private static final long serialVersionUID = -5370107872170712765L;
    public final u[] c;
    public final p027e3.c d;
    public final AtomicReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f6160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f6161g;

    public v(t5.c cVar, int i5, p027e3.c cVar2) {
        super(cVar);
        this.e = new AtomicReference();
        this.f6160f = new AtomicInteger();
        this.f6161g = new AtomicReference();
        u[] uVarArr = new u[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            uVarArr[i6] = new u(this, cVar2);
        }
        this.c = uVarArr;
        this.d = cVar2;
        this.f6160f.lazySet(i5);
    }

    public final void a(Throwable th) {
        AtomicReference atomicReference;
        do {
            atomicReference = this.f6161g;
            if (atomicReference.compareAndSet(null, th)) {
                cancel();
                this.f7842a.onError(th);
                return;
            }
        } while (atomicReference.get() == null);
        if (th != atomicReference.get()) {
            a.onError(th);
        }
    }

    @Override // p094q3.c, t5.d
    public final void cancel() {
        for (u uVar : this.c) {
            uVar.getClass();
            g.a(uVar);
        }
    }
}
