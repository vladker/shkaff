package g4;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import p028e4.I;
import p028e4.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m {
    public static final int CORE_POOL_SIZE;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    public static final int MAX_POOL_SIZE;
    public static j schedulerTimeSource;
    public static final String DEFAULT_SCHEDULER_NAME = I.systemProp("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
    public static final long WORK_STEALING_TIME_RESOLUTION_NS = I.systemProp("kotlinx.coroutines.scheduler.resolution.ns", 100000, 1, LocationRequestCompat.PASSIVE_INTERVAL);

    static {
        int i5 = J.f3936a;
        if (i5 < 2) {
            i5 = 2;
        }
        CORE_POOL_SIZE = I.systemProp("kotlinx.coroutines.scheduler.core.pool.size", i5, 1, (8 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
        MAX_POOL_SIZE = I.systemProp("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 1, (8 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
        IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(I.systemProp("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, LocationRequestCompat.PASSIVE_INTERVAL));
        schedulerTimeSource = h.INSTANCE;
    }

    public static final k asTask(Runnable runnable, long j6, boolean z6) {
        return new l(runnable, j6, z6);
    }

    public static final boolean isBlocking(k kVar) {
        return kVar.taskContext;
    }
}
