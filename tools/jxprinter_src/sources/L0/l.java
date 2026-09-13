package L0;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f405a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j6) {
        return (getLogTime() - j6) * f405a;
    }

    @TargetApi(17)
    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
