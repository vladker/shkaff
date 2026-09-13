package p039g3;

import io.reactivex.N;
import io.reactivex.schedulers.k;
import java.util.concurrent.TimeUnit;
import p027e3.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f4006a;
    public final N b;

    public v(TimeUnit timeUnit, N n6) {
        this.f4006a = timeUnit;
        this.b = n6;
    }

    @Override // p027e3.o
    public k apply(Object obj) {
        N n6 = this.b;
        TimeUnit timeUnit = this.f4006a;
        return new k(obj, n6.now(timeUnit), timeUnit);
    }
}
