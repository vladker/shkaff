package p106s3;

import io.reactivex.B;
import io.reactivex.N;
import io.reactivex.internal.operators.observable.C0866f2;
import io.reactivex.internal.operators.observable.C0903n;
import io.reactivex.schedulers.j;
import java.util.concurrent.TimeUnit;
import p027e3.g;
import p039g3.A;
import p039g3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends B {
    public B<Object> autoConnect() {
        return autoConnect(1);
    }

    public abstract void connect(g gVar);

    public B<Object> refCount() {
        return io.reactivex.plugins.a.onAssembly(new C0866f2(this, 1, 0L, TimeUnit.NANOSECONDS, j.trampoline()));
    }

    public B<Object> autoConnect(int i5) {
        return autoConnect(i5, z.d);
    }

    public B<Object> autoConnect(int i5, g gVar) {
        if (i5 <= 0) {
            connect(gVar);
            return io.reactivex.plugins.a.onAssembly(this);
        }
        return io.reactivex.plugins.a.onAssembly(new C0903n(this, i5, gVar));
    }

    public final B<Object> refCount(int i5) {
        return refCount(i5, 0L, TimeUnit.NANOSECONDS, j.trampoline());
    }

    public final B<Object> refCount(long j6, TimeUnit timeUnit) {
        return refCount(1, j6, timeUnit, j.computation());
    }

    public final B<Object> refCount(long j6, TimeUnit timeUnit, N n6) {
        return refCount(1, j6, timeUnit, n6);
    }

    public final B<Object> refCount(int i5, long j6, TimeUnit timeUnit) {
        return refCount(i5, j6, timeUnit, j.computation());
    }

    public final B<Object> refCount(int i5, long j6, TimeUnit timeUnit, N n6) {
        A.c(i5, "subscriberCount");
        A.b(timeUnit, "unit is null");
        A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0866f2(this, i5, j6, timeUnit, n6));
    }
}
