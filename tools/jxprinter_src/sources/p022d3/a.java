package p022d3;

import io.reactivex.AbstractC0979l;
import io.reactivex.N;
import io.reactivex.internal.operators.flowable.C0788r3;
import io.reactivex.internal.operators.flowable.C0790s;
import io.reactivex.schedulers.j;
import java.util.concurrent.TimeUnit;
import p027e3.g;
import p039g3.A;
import p039g3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends AbstractC0979l {
    public AbstractC0979l autoConnect() {
        return autoConnect(1);
    }

    public abstract void connect(g gVar);

    public AbstractC0979l refCount() {
        return io.reactivex.plugins.a.onAssembly(new C0788r3(this, 1, 0L, TimeUnit.NANOSECONDS, j.trampoline()));
    }

    public AbstractC0979l autoConnect(int i5) {
        return autoConnect(i5, z.d);
    }

    public AbstractC0979l autoConnect(int i5, g gVar) {
        if (i5 <= 0) {
            connect(gVar);
            return io.reactivex.plugins.a.onAssembly(this);
        }
        return io.reactivex.plugins.a.onAssembly(new C0790s(this, i5, gVar));
    }

    public final AbstractC0979l refCount(int i5) {
        return refCount(i5, 0L, TimeUnit.NANOSECONDS, j.trampoline());
    }

    public final AbstractC0979l refCount(long j6, TimeUnit timeUnit) {
        return refCount(1, j6, timeUnit, j.computation());
    }

    public final AbstractC0979l refCount(long j6, TimeUnit timeUnit, N n6) {
        return refCount(1, j6, timeUnit, n6);
    }

    public final AbstractC0979l refCount(int i5, long j6, TimeUnit timeUnit) {
        return refCount(i5, j6, timeUnit, j.computation());
    }

    public final AbstractC0979l refCount(int i5, long j6, TimeUnit timeUnit, N n6) {
        A.c(i5, "subscriberCount");
        A.b(timeUnit, "unit is null");
        A.b(n6, "scheduler is null");
        return io.reactivex.plugins.a.onAssembly(new C0788r3(this, i5, j6, timeUnit, n6));
    }
}
