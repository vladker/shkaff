package p059k3;

import V1.b;
import io.reactivex.S;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p027e3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends AtomicInteger implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f5505a;
    public final D b;
    public final D c;
    public final d d;

    public C(S s6, d dVar) {
        super(2);
        this.f5505a = s6;
        this.d = dVar;
        this.b = new D(this);
        this.c = new D(this);
    }

    public final void a() {
        if (decrementAndGet() == 0) {
            Object obj = this.b.b;
            Object obj2 = this.c.b;
            S s6 = this.f5505a;
            if (obj == null || obj2 == null) {
                s6.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                return;
            }
            try {
                ((b) this.d).getClass();
                s6.onSuccess(Boolean.valueOf(A.a(obj, obj2)));
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                s6.onError(th);
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        D d = this.b;
        d.getClass();
        p033f3.d.a(d);
        D d6 = this.c;
        d6.getClass();
        p033f3.d.a(d6);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((c) this.b.get());
    }
}
